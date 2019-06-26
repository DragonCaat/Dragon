package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.ExpandableListView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.data.HotPicData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.entity.HotPic;
import com.kaha.dragon.dragon.ui.adapter.home.HotPicAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * 首页热门的fragment
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class HotPicFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    public static final int REFRESH_DATA = 0;
    public static final int LOAD_DATA = 1;
    @BindView(R.id.rv_hot_pic)
    RecyclerView rvHotPic;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefreshLayout;

    private HotPicAdapter hotPicAdapter;

    private List<Integer> headList = HotPicData.getHeadList();
    private List<String> nickList = HotPicData.getNickList();
    private List<Integer> imageList = HotPicData.getImagList();
    private List<HotPic> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragmnet_hot_pic;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecycleView();
        setFreshData(REFRESH_DATA);
    }

    private void initRecycleView() {
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
        rvHotPic.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        hotPicAdapter = new HotPicAdapter(activity, null);
        rvHotPic.setAdapter(hotPicAdapter);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        list.clear();
        setFreshData(REFRESH_DATA);
    }


    /**
     * @param type 0:刷新数据 1:加载更多数据
     * @return void
     * @date 2019-04-15
     */
    private void setFreshData(int type) {
        Random random = new Random();
        int size = nickList.size();
        for (int i = 0; i < 8; i++) {
            list.add(new HotPic(imageList.get(random.nextInt(size - 1)),
                    headList.get(random.nextInt(size - 1)), nickList.get(random.nextInt(size - 1)),
                    random.nextInt(2000) + 2000));
        }
        if (type == REFRESH_DATA) {
            hotPicAdapter.updateData(list);
            smartRefreshLayout.finishRefresh();
        } else {
            hotPicAdapter.loadMoreData(list);
            smartRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        setFreshData(LOAD_DATA);
    }
}
