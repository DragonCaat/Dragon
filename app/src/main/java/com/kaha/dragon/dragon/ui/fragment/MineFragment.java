package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.CommunityData;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.entity.Mine;
import com.kaha.dragon.dragon.ui.adapter.CommunityAdapter;
import com.kaha.dragon.dragon.ui.adapter.MineAdapter;
import com.kaha.dragon.dragon.ui.adapter.MinePagerAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.kaha.dragon.framework.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * 我的fragment
 *
 * @author Darcy
 * @Date 2019/1/4
 * @package com.kaha.dragon.dragon.ui
 * @Desciption
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout barLayout;
    @BindView(R.id.iv_mine_bg)
    ImageView ivMineBg;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @BindView(R.id.recycleView)
    RecyclerView rvMine;

    private int mOffset = 0;
    private int mScrollY = 0;

    private MineAdapter adapter;
    private List<Mine> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //状态栏透明和间距处理
        StatusBarUtil.immersive(activity);
        StatusBarUtil.setPaddingSmart(activity, toolbar);
        initRefreshLayout();
        initData();
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new Mine());
        }
        rvMine.setLayoutManager(new GridLayoutManager(context, 1));
        adapter = new MineAdapter(context, null);
        rvMine.setAdapter(adapter);
        adapter.updateData(list);
    }

    /**
     * 初始化监听
     *
     * @param ,
     * @return void
     * @date 2019-01-08
     */
    private void initRefreshLayout() {
        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(3000);
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }

            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                mOffset = offset / 2;
                ivMineBg.setTranslationY(mOffset - mScrollY);
                toolbar.setAlpha(1 - Math.min(percent, 1));
            }
        });
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            private int lastScrollY = 0;
            private int h = DensityUtil.dp2px(170);
            private int color = ContextCompat.getColor(activity, R.color.gray_f3f3f3) & 0x00ffffff;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
                    barLayout.setAlpha(1f * mScrollY / h);
                    toolbar.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                    ivMineBg.setTranslationY(mOffset - mScrollY);
                }
                lastScrollY = scrollY;
            }
        });
        barLayout.setAlpha(0);
        toolbar.setBackgroundColor(0);
    }
}
