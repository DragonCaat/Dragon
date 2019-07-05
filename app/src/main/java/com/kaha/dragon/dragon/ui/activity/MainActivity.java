package com.kaha.dragon.dragon.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.ui.fragment.CommunityFragment;
import com.kaha.dragon.dragon.ui.fragment.HomeFragment;
import com.kaha.dragon.dragon.ui.fragment.MineFragment;
import com.kaha.dragon.dragon.ui.fragment.PictureFragment;
import com.kaha.dragon.framework.base.MyApplication;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.utils.ToastUtil;

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

    @BindView(R.id.iv_publish)
    ImageView ivPublish;

    private CommunityFragment communityFragment;
    private HomeFragment homeFragment;
    private PictureFragment pictureFragment;
    private MineFragment mineFragment;

    private Fragment currentFragment;

    private static Boolean isExit = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //llHome.performClick();
        initFragment();
    }

    WindowManager windowManager;
    View linearLayout;

    @Override
    protected void onResume() {
        super.onResume();
        // showFloating();
    }

    private boolean isOpen = false;

    @OnClick({R.id.ll_publish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_publish:
                if (isOpen) {
                    Animation rotate = AnimationUtils.loadAnimation(context,
                            R.anim.up_img_anim);
                    rotate.setFillAfter(true);
                    ivPublish.startAnimation(rotate);
                    isOpen = false;
                } else {
                    Animation rotate = AnimationUtils.loadAnimation(this,
                            R.anim.down_img_anim);
                    rotate.setFillAfter(true);
                    ivPublish.startAnimation(rotate);
                    isOpen = true;
                }
                break;
        }
    }


    private void showFloating() {
        windowManager = (WindowManager) MyApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        LayoutInflater inflater = LayoutInflater.from(MyApplication.getInstance());
        linearLayout = inflater.inflate(R.layout.layout_floating_item, null);

        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        params.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        //不抢占焦距点
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        windowManager.addView(linearLayout, params);
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
                   // showFragment(homeFragment, HomeFragment.class);
                    switchContent(currentFragment, homeFragment);
                    currentFragment = homeFragment;
                    setSelectedChange(tvHome);
                    ivHome.setImageResource(R.mipmap.home_press);
                    break;

                //美图
                case R.id.ll_picture:
                   // showFragment(pictureFragment, PictureFragment.class);
                    switchContent(currentFragment, pictureFragment);
                    currentFragment = pictureFragment;
                    setSelectedChange(tvPicture);
                    ivPicture.setImageResource(R.mipmap.take_photo_press);
                    break;

                //社区
                case R.id.ll_community:
                    //showFragment(communityFragment, CommunityFragment.class);
                    switchContent(currentFragment, communityFragment);
                    currentFragment = communityFragment;
                    setSelectedChange(tvCommunity);
                    ivCommunity.setImageResource(R.mipmap.community_press);
                    break;
                //我的
                case R.id.ll_my:
                    //showFragment(mineFragment, MineFragment.class);
                    switchContent(currentFragment, mineFragment);
                    currentFragment = mineFragment;
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


    //初始化fragment，并默认显示首页fragment
    private void initFragment(){
        homeFragment = new HomeFragment();
        pictureFragment = new PictureFragment();
        mineFragment = new MineFragment();
        communityFragment = new CommunityFragment();
        currentFragment = homeFragment;
        // 第一次添加Fragments
        FragmentManager fMgr = getSupportFragmentManager();
        FragmentTransaction ft = fMgr.beginTransaction();
        ft.replace(R.id.rl_container, homeFragment);
        ft.commit();
    }

    /**
     * 切换fragment，先将fragment初始化的方式
     *
     * @param from 当前显示的fragment
     * @param to   要显示的fragment
     * @return void
     * @date 2019-06-28
     */
    public void switchContent(Fragment from, Fragment to) {
        if (from == to) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(R.id.rl_container, to)
                    .commitAllowingStateLoss();
        } else {
            transaction.hide(from).show(to).commitAllowingStateLoss();
        }
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
                            add(R.id.rl_container, mineFragment).show(mineFragment);
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
    protected void onDestroy() {
        super.onDestroy();
        homeFragment = null;
        pictureFragment = null;
        communityFragment = null;
        mineFragment = null;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private Handler handler = new Handler();

    //连续按2次退出运用
    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtil.show(context, "再按一次退出");
            handler.sendEmptyMessageDelayed(1, 2000);
        } else {
            finish();
        }
    }
}
