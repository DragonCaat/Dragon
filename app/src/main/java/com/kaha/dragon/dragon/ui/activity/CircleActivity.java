package com.kaha.dragon.dragon.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Interpolator;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.ui.adapter.MinePagerAdapter;
import com.kaha.dragon.dragon.ui.fragment.circle.FollowPeopleFragment;
import com.kaha.dragon.dragon.ui.fragment.circle.RecPeopleFragment;
import com.kaha.dragon.dragon.ui.fragment.home.CartoonFragment;
import com.kaha.dragon.dragon.ui.fragment.home.EchelonFragment;
import com.kaha.dragon.dragon.ui.fragment.home.FollowFragment;
import com.kaha.dragon.dragon.ui.fragment.home.HotPicFragment;
import com.kaha.dragon.dragon.ui.fragment.home.MusicFragment;
import com.kaha.dragon.dragon.ui.fragment.home.RecommendFragment;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.widget.TopView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * 圈子界面
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class CircleActivity extends BaseActivity {

    @BindView(R.id.topView)
    TopView topView;

    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private String[] mTitles = {"推荐", "关注"};
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_circle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topView.setTitle("圈子");
        initViewPager();
        initTabLayout();
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    //初始化指示器
    private void initTabLayout() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
//        commonNavigator.setEnablePivotScroll(true);
//        commonNavigator.setFollowTouch(true);
//        commonNavigator.setSmoothScroll(true);
//        commonNavigator.setReselectWhenLayout(true);
//        commonNavigator.setSkimOver(true);
//        commonNavigator.setScrollPivotX(50);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mTitles == null ? 0 : mTitles.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#888888"));
                colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#000000"));

                colorTransitionPagerTitleView.setText(mTitles[index]);
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setColors(getResources().getColor(R.color.yellow_fed943));
                indicator.setLineWidth(50);
                indicator.setLineHeight(10);
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
    }

    /**
     * 初始化viewPager
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void initViewPager() {
        RecPeopleFragment fragment1 = new RecPeopleFragment();
        FollowPeopleFragment fragment2 = new FollowPeopleFragment();

        list.add(fragment1);
        list.add(fragment2);

        MinePagerAdapter pagerAdapter = new MinePagerAdapter(
                getSupportFragmentManager(), mTitles, list);
        mViewPager.setAdapter(pagerAdapter);
    }
}
