package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.kaha.dragon.R;
import com.kaha.dragon.dragon.ui.adapter.MinePagerAdapter;
import com.kaha.dragon.dragon.ui.fragment.home.CartoonFragment;
import com.kaha.dragon.dragon.ui.fragment.home.EchelonFragment;
import com.kaha.dragon.dragon.ui.fragment.home.FollowFragment;
import com.kaha.dragon.dragon.ui.fragment.home.HotPicFragment;
import com.kaha.dragon.dragon.ui.fragment.home.MusicFragment;
import com.kaha.dragon.dragon.ui.fragment.home.RecommendFragment;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * 首页的fragment
 * sound of silence
 * five hundreds miles
 * <p>
 * you must be rich enough,
 * <p>
 * you are single  ,but you are not lonely
 * <p>
 * walk along And you may see the different of yourself
 * <p>
 * some day ,u may strong enough to face more challenge
 * <p>
 * Memories of childhood come to my mind
 *
 * </p>
 *
 * @author Darcy
 * @Date 2019/1/4
 * @package com.kaha.dragon.dragon.ui
 * @Desciption
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.xTablayout)
    XTabLayout tabLayout;

    //tableLayout的标题源数据
    private String[] mTitles = {"关注", "推荐", "热门", "卡通", "优图", "音乐"};
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * 初始化viewPager
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void initViewPager() {
        FollowFragment fragment0 = new FollowFragment();
        RecommendFragment fragment1 = new RecommendFragment();
        HotPicFragment fragment2 = new HotPicFragment();
        CartoonFragment fragment3 = new CartoonFragment();
        EchelonFragment fragment4 = new EchelonFragment();
        MusicFragment fragment5 = new MusicFragment();

        list.add(fragment0);
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);

        MinePagerAdapter pagerAdapter = new MinePagerAdapter(
                Objects.requireNonNull(getActivity()).getSupportFragmentManager(), mTitles, list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
    }
}
