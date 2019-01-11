package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.adapter.CommunityAdapter;
import com.kaha.dragon.dragon.ui.adapter.PicAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.kaha.dragon.framework.widget.TopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 美图的fragment
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.ui.fragment
 * @Desciption
 */
public class PictureFragment extends BaseFragment {

    @BindView(R.id.topView)
    TopView topView;
    @BindView(R.id.rvPic)
    RecyclerView rvPic;

    private PicAdapter picAdapter;
    private List<Community> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_picture;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topView.setTitle("美图");
        topView.setLeftVisb(false);

        initRecycleView();
    }

    /**
     * 初始化RecycleView
     *
     * @param ,
     * @return void
     * @date 2019-01-10
     */
    private void initRecycleView() {
        List<String> desList = CommunityData.getDesList();
        List<String> longDesList = CommunityData.getLongDesList();
        List<String> nickList = CommunityData.getNickList();
        List<Integer> headList = CommunityData.getHeadList();
        List<List<Integer>> lists = CommunityData.getLists();

        list.clear();
        for (int i = 0; i < desList.size(); i++) {
            list.add(new Community(nickList.get(i), desList.get(i), headList.get(i), lists.get(i), longDesList.get(i)));
        }
        rvPic.setLayoutManager(new GridLayoutManager(context, 1));
        picAdapter = new PicAdapter(context, null);
        rvPic.setAdapter(picAdapter);
        picAdapter.updateData(list);
    }
}
