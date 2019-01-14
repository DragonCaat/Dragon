package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.dragon.entity.BannerData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.adapter.HomeAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.kaha.dragon.framework.widget.TopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页的fragment
 *
 * @author Darcy
 * @Date 2019/1/4
 * @package com.kaha.dragon.dragon.ui
 * @Desciption
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_recycleView)
    RecyclerView homeRecycleView;
    @BindView(R.id.topView)
    TopView topView;

    //首页适配器
    private HomeAdapter adapter;

    private List<Community> list = new ArrayList<>();

    private BannerData bannerData;//滚动数据资源

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topView.setTitle("首页");
        topView.setLeftVisb(false);
        initImage();
        initData();

    }

    //初始化图片资源
    private void initImage() {

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.mipmap.pic1);
        imageList.add(R.mipmap.pic2);
        imageList.add(R.mipmap.pic3);
        imageList.add(R.mipmap.pic4);

        List<String> titleList = new ArrayList<>();
        titleList.add("只想优雅转身");
        titleList.add("不料华丽撞墙");
        titleList.add("如果没有如果");
        titleList.add("我该如何选择");

        bannerData = new BannerData(imageList, titleList);

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
            list.add(new Community(nickList.get(i), desList.get(i), headList.get(i), lists.get(i), longDesList.get(i)));
        }
        homeRecycleView.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new HomeAdapter(list, context);
        homeRecycleView.setAdapter(adapter);
        adapter.setBannerData(bannerData);
    }
}
