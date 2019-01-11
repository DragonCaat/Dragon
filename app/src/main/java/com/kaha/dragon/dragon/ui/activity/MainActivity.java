package com.kaha.dragon.dragon.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.ui.fragment.CommunityFragment;
import com.kaha.dragon.dragon.ui.fragment.HomeFragment;
import com.kaha.dragon.dragon.ui.fragment.MineFragment;
import com.kaha.dragon.dragon.ui.fragment.PictureFragment;
import com.kaha.dragon.framework.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主界面
 *
 * @author Darcy
 * @package com.kaha.dragon.dragon.ui
 * @date 2019-01-04
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_main)
    ViewPager viewPager;

    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;

    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_picture)
    TextView tvPicture;

    @BindView(R.id.iv_community)
    ImageView ivCommunity;
    @BindView(R.id.tv_community)
    TextView tvCommunity;

    @BindView(R.id.iv_my)
    ImageView ivMy;
    @BindView(R.id.tv_my)
    TextView tvMy;
    //viewPager的适配器
    private FragmentPagerAdapter mAdapter;
    //用于装fragment的集合
    private List<Fragment> mFragments;

    private CommunityFragment communityFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvents();
    }

    /**
     * 初始化对应的fragment和viewpager
     *
     * @param ,
     * @return void
     * @date 2018-01-05
     */
    private void initView() {
        Fragment homeFragment = new HomeFragment();
        Fragment pictureFragment = new PictureFragment();
        communityFragment = new CommunityFragment();
        Fragment mineFragment = new MineFragment();

        mFragments = new ArrayList<>();
        mFragments.add(homeFragment);
        mFragments.add(pictureFragment);
        mFragments.add(communityFragment);
        mFragments.add(mineFragment);

        //设置viewpager的最大缓存量为2
        viewPager.setOffscreenPageLimit(2);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        viewPager.setAdapter(mAdapter);
    }

    /**
     * 初始化ViewPager的选中的点击事件
     *
     * @param ,
     * @return void
     * @date 2019-01-05
     */
    private void initEvents() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
                switch (position) {
                    case 0:
                        setSelect(0);
                        break;
                    case 1:
                        setSelect(1);
                        break;
                    case 2:
                        setSelect(2);
                        break;
                    case 3:
                        setSelect(3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @OnClick({R.id.ll_home, R.id.ll_picture, R.id.ll_community, R.id.ll_my})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                setSelect(0);
                break;
            case R.id.ll_picture:
                setSelect(1);
                break;
            case R.id.ll_community:
                setSelect(2);
                break;
            case R.id.ll_my:
                setSelect(3);
                break;
        }
    }

    //重置底部的按钮和文字的状态
    private void resetAll() {
        tvHome.setTextColor(getResources().getColor(R.color.gray_888888));
        tvPicture.setTextColor(getResources().getColor(R.color.gray_888888));
        tvCommunity.setTextColor(getResources().getColor(R.color.gray_888888));
        tvMy.setTextColor(getResources().getColor(R.color.gray_888888));

        ivHome.setImageResource(R.mipmap.home_normal);
        ivPicture.setImageResource(R.mipmap.take_photo_normal);
        ivCommunity.setImageResource(R.mipmap.community_normal);
        ivMy.setImageResource(R.mipmap.my_normal);
    }

    //选中不同的fragment
    private void setSelect(int id) {
        resetAll();
        switch (id) {
            case 0:
                setSelectedChange(tvHome);
                ivHome.setImageResource(R.mipmap.home_press);
                break;
            case 1:
                setSelectedChange(tvPicture);
                ivPicture.setImageResource(R.mipmap.take_photo_press);
                break;
            case 2:
                setSelectedChange(tvCommunity);
                ivCommunity.setImageResource(R.mipmap.community_press);
                break;
            case 3:
                setSelectedChange(tvMy);
                ivMy.setImageResource(R.mipmap.my_press);
                break;
        }
        viewPager.setCurrentItem(id, false);
    }

    /**
     * 更改TextView字体颜色
     *
     * @param tv 要改变颜色的textView
     * @return void
     * @date 2019-01-05
     */
    private void setSelectedChange(TextView tv) {
        tv.setTextColor(getResources().getColor(R.color.black_333333));
    }

    @Override
    public void onActivityReenter(int requestCode, Intent data) {
        super.onActivityReenter(requestCode, data);
        communityFragment.getActivityData(data);
        communityFragment.initShareElement();
    }
}
