package com.kaha.dragon.dragon.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
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

    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;

    @BindView(R.id.ll_picture)
    LinearLayout llPicture;
    @BindView(R.id.iv_picture)
    ImageView ivPicture;
    @BindView(R.id.tv_picture)
    TextView tvPicture;

    @BindView(R.id.ll_community)
    LinearLayout llCommmunity;
    @BindView(R.id.iv_community)
    ImageView ivCommunity;
    @BindView(R.id.tv_community)
    TextView tvCommunity;

    @BindView(R.id.ll_my)
    LinearLayout llMy;
    @BindView(R.id.iv_my)
    ImageView ivMy;
    @BindView(R.id.tv_my)
    TextView tvMy;

    private CommunityFragment communityFragment;
    private HomeFragment homeFragment;
    private PictureFragment pictureFragment;
    private MineFragment mineFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        llHome.performClick();
    }

    /**
     * 初始化对应的fragment和viewpager
     *
     * @param ,
     * @return void
     * @date 2018-01-05
     */
    private void initView() {
        llHome.setOnClickListener(listener);
        llPicture.setOnClickListener(listener);
        llCommmunity.setOnClickListener(listener);
        llMy.setOnClickListener(listener);
    }

    /**
     * 底部点击事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetAll();
            switch (v.getId()) {
                //底部选中
                case R.id.ll_home:
                    showFragment(homeFragment, HomeFragment.class);
                    setSelectedChange(tvHome);
                    ivHome.setImageResource(R.mipmap.home_press);
                    break;

                //美图
                case R.id.ll_picture:
                    showFragment(pictureFragment, PictureFragment.class);
                    setSelectedChange(tvPicture);
                    ivPicture.setImageResource(R.mipmap.take_photo_press);
                    break;

                //社区
                case R.id.ll_community:
                    showFragment(communityFragment, CommunityFragment.class);
                    setSelectedChange(tvCommunity);
                    ivCommunity.setImageResource(R.mipmap.community_press);
                    break;
                //我的
                case R.id.ll_my:
                    showFragment(mineFragment, MineFragment.class);
                    setSelectedChange(tvMy);
                    ivMy.setImageResource(R.mipmap.my_press);
                    break;
            }
        }
    };

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

    /**
     * @param fragment 要展示的fragment
     * @param cl       对应的fragment类
     * @return void
     * @date 2019-01-17
     */
    private void showFragment(Fragment fragment, Class<?> cl) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        if (fragment == null) {
            if (cl == HomeFragment.class) {
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.remove(homeFragment).
                            add(R.id.rl_container, homeFragment).show(homeFragment);
                }
            } else if (cl == PictureFragment.class) {
                if (pictureFragment == null) {
                    pictureFragment = new PictureFragment();
                    transaction.remove(pictureFragment).
                            add(R.id.rl_container, pictureFragment).show(pictureFragment);
                }
            } else if (cl == CommunityFragment.class) {
                if (communityFragment == null) {
                    communityFragment = new CommunityFragment();
                    transaction.remove(communityFragment).
                            add(R.id.rl_container, communityFragment).show(communityFragment);
                }
            } else if (cl == MineFragment.class) {
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.remove(mineFragment).
                            add(R.id.rl_container, mineFragment).show(communityFragment);
                }
            }
        } else {
            if (cl == HomeFragment.class) {
                transaction.show(homeFragment);
            }
            if (cl == PictureFragment.class) {
                transaction.show(pictureFragment);
            }
            if (cl == CommunityFragment.class) {
                transaction.show(communityFragment);
            }
            if (cl == MineFragment.class) {
                transaction.show(mineFragment);
            }
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param transaction .操作fragment的事务
     * @return void
     * @date 2019-01-17
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (pictureFragment != null) {
            transaction.hide(pictureFragment);
        }
        if (communityFragment != null) {
            transaction.hide(communityFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }


    @Override
    public void onActivityReenter(int requestCode, Intent data) {
        super.onActivityReenter(requestCode, data);
        communityFragment.getActivityData(data);
        communityFragment.initShareElement();
    }
}
