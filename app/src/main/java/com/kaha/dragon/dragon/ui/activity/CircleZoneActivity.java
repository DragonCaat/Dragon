package com.kaha.dragon.dragon.ui.activity;

import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.adapter.CommunityAdapter;
import com.kaha.dragon.dragon.widget.ninelayout.OnItemPictureClickListener;
import com.kaha.dragon.dragon.widget.ninelayout.P;
import com.kaha.dragon.dragon.widget.ninelayout.Utils;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.we.widget.WeRecycleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 仿微信朋友圈
 *
 * @author Darcy
 * @Date 2019/7/2
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class CircleZoneActivity extends BaseActivity {
    @BindView(R.id.rv_community)
    WeRecycleView rvCommunity;

    @BindView(R.id.title)
    TextView mTitleView;
    @BindView(R.id.ll_head)
    LinearLayout llHead;

    private CommunityAdapter adapter;
    private List<Community> list = new ArrayList<>();

    private int itemPosition;//用户点击放大的那个图片的角标
    private Bundle mReenterState;
    private int mDensity;
    private final int title_bg_color = Color.parseColor("#ffffff");
    private final int RED = Color.red(title_bg_color);
    private final int GREEN = Color.green(title_bg_color);
    private final int BLUE = Color.blue(title_bg_color);

    private final int text_color = Color.parseColor("#333333");
    private final int RED1 = Color.red(text_color);
    private final int GREEN1 = Color.green(text_color);
    private final int BLUE1 = Color.blue(text_color);

    @Override
    protected int getLayoutId() {
        return R.layout.activity_circle_zone;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDensity = (int) getResources().getDisplayMetrics().density;

        llHead.setBackgroundColor(Color.argb(0, RED, GREEN, BLUE));
        mTitleView.setTextColor(Color.argb(0, RED1, GREEN1, BLUE1));
        initData();
    }

    @OnClick({R.id.rl_back_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back_black:
                finish();
                break;
        }
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
        adapter = new CommunityAdapter(context, list);
        rvCommunity.setAdapter(adapter);

        rvCommunity.setScrollMode(WeRecycleView.SCROLL_SCALE_HEAD);
        rvCommunity.setMaxScale(4f);
        //如果有titleBar，这就设titlebar的高度，没有就不需要设置
        rvCommunity.setCloseOffset(50 * mDensity);
        rvCommunity.setOnHeadExpandListener(new WeRecycleView.OnHeadExpandListener() {
            @Override
            public void onExpand(float percent) {
                llHead.setBackgroundColor(Color.argb((int) (255 * (1 - percent)), RED, GREEN, BLUE));
                mTitleView.setTextColor(Color.argb((int) (255 * (1 - percent)), RED1, GREEN1, BLUE1));
            }

            @Override
            public void onEnterSafeArea(boolean isEnter) {

            }
        });
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
            ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(activity,
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
        setExitSharedElementCallback(mCallback);
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

    @Override
    public void onActivityReenter(int requestCode, Intent data) {
        super.onActivityReenter(requestCode, data);
        getActivityData(data);
        initShareElement();
    }
}
