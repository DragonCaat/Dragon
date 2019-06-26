package com.kaha.dragon.dragon.ui.fragment;

import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.activity.ImagePreviewActivity;
import com.kaha.dragon.dragon.ui.adapter.CommunityAdapter;
import com.kaha.dragon.dragon.widget.ninelayout.OnItemPictureClickListener;
import com.kaha.dragon.dragon.widget.ninelayout.P;
import com.kaha.dragon.dragon.widget.ninelayout.Utils;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.kaha.dragon.framework.widget.TopView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 社区的fragment
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.ui.fragment
 * @Desciption
 */
public class CommunityFragment extends BaseFragment {
    @BindView(R.id.topView)
    TopView topView;
    @BindView(R.id.rv_community)
    RecyclerView rvCommunity;

    private CommunityAdapter adapter;
    private List<Community> list = new ArrayList<>();

    private int itemPosition;//用户点击放大的那个图片的角标
    private Bundle mReenterState;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_community;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topView.setLeftVisb(false);
        topView.setTitle("社区");

        initData();
    }

    //初始化数据
    private void initData() {
        List<String> desList = CommunityData.getDesList();
        List<String> longDesList = CommunityData.getLongDesList();
        List<String> nickList = CommunityData.getNickList();
        List<Integer> headList = CommunityData.getHeadList();
        List<List<Integer>> lists = CommunityData.getLists();

        list.clear();
        for (int i = 0; i < desList.size(); i++) {
            list.add(new Community(nickList.get(i), desList.get(i),
                    headList.get(i), lists.get(i), longDesList.get(i)));
        }
        rvCommunity.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new CommunityAdapter(context, null);
        rvCommunity.setAdapter(adapter);
        adapter.updateData(list);
        adapter.setListener(listener);
    }

    //图片点击回调
    private OnItemPictureClickListener listener = new OnItemPictureClickListener() {
        @Override
        public void onItemPictureClick(int position, int i, int url, List<Integer> urlList, ImageView imageView) {
            itemPosition = position;
            Intent intent = new Intent(context, ImagePreviewActivity.class);
            intent.putIntegerArrayListExtra("imageList", (ArrayList<Integer>) urlList);
            intent.putExtra(P.START_ITEM_POSITION, itemPosition);
            intent.putExtra(P.START_IAMGE_POSITION, i);
            ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                    imageView, imageView.getTransitionName());
            startActivity(intent, compat.toBundle());
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        CommunityData.clear();
    }

    public void initShareElement() {
        getActivity().setExitSharedElementCallback(mCallback);
    }

    //调用activity返回数据的时候调用
    public void getActivityData(Intent data) {
        mReenterState = new Bundle(data.getExtras());
        int startingPosition = mReenterState.getInt(P.CURRENT_ITEM_POSITION);
        if (startingPosition != itemPosition) {//如果不是同一个item就滚动到指定的item
            rvCommunity.scrollToPosition(itemPosition);
        }
        postponeEnterTransition();
        rvCommunity.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                rvCommunity.getViewTreeObserver().removeOnPreDrawListener(this);
                rvCommunity.requestLayout();
                startPostponedEnterTransition();
                return true;
            }
        });

    }

    private final SharedElementCallback mCallback = new SharedElementCallback() {

        @Override
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            if (mReenterState != null) {
                //从别的界面返回当前界面
                int startingPosition = mReenterState.getInt(P.START_IAMGE_POSITION);
                int currentPosition = mReenterState.getInt(P.CURRENT_IAMGE_POSITION);
                if (startingPosition != currentPosition) {//如果不是之前的那张图片就切换到指定的图片
                    String newTransitionName = Utils.getNameByPosition(itemPosition, currentPosition);
                    View newSharedElement = rvCommunity.findViewWithTag(newTransitionName);
                    if (newSharedElement != null) {
                        names.clear();
                        names.add(newTransitionName);
                        sharedElements.clear();
                        sharedElements.put(newTransitionName, newSharedElement);
                    }
                }
                mReenterState = null;
            }
        }
    };

    /**
     * <b>
     *
     * </b>
     *
     * */
}
