package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.androidkun.xtablayout.XTabLayout;
import com.kaha.dragon.R;
import com.kaha.dragon.dragon.ui.adapter.MinePagerAdapter;
import com.kaha.dragon.dragon.ui.fragment.home.FollowFragment;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

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

    @BindView(R.id.nestedScrollView)
    NestedScrollView scrollView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout barLayout;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initToolBar();
    }

    private int mOffset = 0;
    private int mScrollY = 0;

    /**
     * 初始化toolbar
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void initToolBar() {
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
                }
                lastScrollY = scrollY;
            }
        });
        barLayout.setAlpha(0);
        toolbar.setBackgroundColor(0);
    }
}
