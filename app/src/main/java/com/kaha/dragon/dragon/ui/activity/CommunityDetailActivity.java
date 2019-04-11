package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.adapter.MinePagerAdapter;
import com.kaha.dragon.dragon.ui.fragment.CommunityFragment;
import com.kaha.dragon.dragon.ui.fragment.HomeFragment;
import com.kaha.dragon.dragon.ui.fragment.PublicCommentFragment;
import com.kaha.dragon.dragon.widget.ninelayout.NineGridTestLayout;
import com.kaha.dragon.framework.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 社区详情界面
 *
 * @author Darcy
 * @package com.kaha.dragon.dragon.ui.activity
 * @date 2019-01-09
 */
public class CommunityDetailActivity extends BaseActivity {

    @BindView(R.id.cv_head)
    CircleImageView cvHead;
    @BindView(R.id.tv_nickName)
    TextView tvNickName;
    @BindView(R.id.tv_long_des)
    TextView tvLongDes;
    @BindView(R.id.nine_images)
    NineGridTestLayout nineGridTestLayout;

    @BindView(R.id.scrollView)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBarLayout;

    //传递过来的数据实体
    private Community community;

    private String[] mTitles = {"普通", "会员"};
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_community_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        community = (Community) getIntent().getSerializableExtra(AppConst.KEY_2);
        //设置 NestedScrollView 的内容是否拉伸填充整个视图，
        //这个设置是必须的，否者我们在里面设置的ViewPager会不可见
        mNestedScrollView.setFillViewport(true);

        initData();
        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * 设置UI数据
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void initData() {
        if (community != null) {
            cvHead.setImageResource(community.getHead());
            tvNickName.setText(community.getNick());
            nineGridTestLayout.setUrlList(community.getImageList());
            tvLongDes.setText(community.getLongDes());
        }
    }

    /**
     * 初始化viewPager
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void initViewPager() {
        PublicCommentFragment fragment1 = new PublicCommentFragment();
        PublicCommentFragment fragment3 = new PublicCommentFragment();
        list.add(fragment1);
        list.add(fragment3);
        MinePagerAdapter pagerAdapter = new MinePagerAdapter(
                getSupportFragmentManager(), mTitles, list);
        viewPager.setAdapter(pagerAdapter);

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int scrollRangle = appBarLayout.getTotalScrollRange();
                //初始verticalOffset为0，不能参与计算。
                if (verticalOffset == 0) {
                    // mTvTitle.setAlpha(0.0f);
                } else {
                    //保留一位小数
                    float alpha = Math.abs(Math.round(1.0f * verticalOffset / scrollRangle) * 10) / 10;
                    // mTvTitle.setAlpha(alpha);
                }
            }
        });
    }
}
