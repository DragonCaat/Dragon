package com.kaha.dragon.dragon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.ui.adapter.MinePagerAdapter;
import com.kaha.dragon.dragon.ui.fragment.home.CartoonFragment;
import com.kaha.dragon.dragon.ui.fragment.home.EchelonFragment;
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
 *
 * you are single  ,but you are not lonely
 *
 * walk along And you may see the different of yourself
 *
 * some day ,u may strong enough to face more challenge
 *
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
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    //tableLayout的标题源数据
    private String[] mTitles = {"推荐", "卡通", "优图","音乐"};
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
        RecommendFragment fragment1 = new RecommendFragment();
        CartoonFragment fragment2 = new CartoonFragment();
        EchelonFragment fragment3 = new EchelonFragment();
        MusicFragment fragment4 = new MusicFragment();

        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);

        MinePagerAdapter pagerAdapter = new MinePagerAdapter(
                Objects.requireNonNull(getActivity()).getSupportFragmentManager(), mTitles, list);
        viewPager.setAdapter(pagerAdapter);
    }
}
