package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.adapter.home.RecommendAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页推荐的fragment
 *
 * @author Darcy
 * @Date 2019/1/17
 * @package com.kaha.dragon.dragon.ui.fragment
 * @Desciption
 */
public class RecommendFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    //推荐的适配器
    private RecommendAdapter adapter;

    private List<Community> list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initRecycleView();
    }

    private void initData() {
        List<String> desList = CommunityData.getDesList();
        List<String> longDesList = CommunityData.getLongDesList();
        List<String> nickList = CommunityData.getNickList();
        List<Integer> headList = CommunityData.getHeadList();
        List<List<Integer>> lists = CommunityData.getLists();

        list = new ArrayList<>();
        list.clear();
        for (int i = 0; i < desList.size(); i++) {
            list.add(new Community(nickList.get(i), desList.get(i), headList.get(i), lists.get(i), longDesList.get(i)));
        }
    }

    /**
     * 初始化recycleView
     *
     * @param ,
     * @return void
     * @date 2019-01-18
     */
    private void initRecycleView() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new RecommendAdapter(context, null);
        recyclerView.setAdapter(adapter);

        adapter.updateData(list);
    }


}
