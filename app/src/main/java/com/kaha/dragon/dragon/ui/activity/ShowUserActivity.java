package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.dragon.ui.adapter.ShowUserThemPicAdapter;
import com.kaha.dragon.dragon.utils.StaggeredDividerItemDecoration;
import com.kaha.dragon.dragon.widget.TagCloudView;
import com.kaha.dragon.dragon.widget.ThemePicView;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.utils.StatusBarUtil;
import com.kaha.dragon.framework.utils.ToastUtil;
import com.kaha.dragon.framework.widget.TopView;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 展示用户资料的界面
 *
 * @author Darcy
 * @Date 2019/1/9
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class ShowUserActivity extends BaseActivity {
    @BindView(R.id.iv_bg)
    ImageView rlRoot;
    @BindView(R.id.cv_show_user)
    CircleImageView cvUserHead;
    @BindView(R.id.tv_show_nickName)
    TextView tvShowNickname;
    @BindView(R.id.tv_show_sign)
    TextView tvShowSign;

    @BindView(R.id.nestedScrollView)
    NestedScrollView scrollView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout barLayout;
    //仿照QQ个性签名
    @BindView(R.id.tagCloudView)
    TagCloudView tagCloudView;
    //主题图片
    @BindView(R.id.themePic)
    ThemePicView themePicView;

    //用户信息的实体类信息
    private Community community;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        community = (Community) getIntent().getSerializableExtra(AppConst.KEY_1);
        initToolBar();
        setUserData();
    }

    @OnClick({R.id.rl_back, R.id.ll_add_statues})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            //添加状态
            case R.id.ll_add_statues:
                ToastUtil.show(context, "功能暂未开放");
                break;
        }
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
                    rlRoot.setTranslationY(mOffset - mScrollY);
                }
                lastScrollY = scrollY;
            }
        });
        barLayout.setAlpha(0);
        toolbar.setBackgroundColor(0);
    }

//
//    ShowUserThemPicAdapter userThemPicAdapter;

    /**
     * 设置用户数据信息
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void setUserData() {
        if (community != null) {
            cvUserHead.setImageResource(community.getHead());
            tvShowNickname.setText(community.getNick());
            tvShowSign.setText(community.getDes());
            //高斯模糊图片
            Glide.with(context)
                    .load(community.getImageList().get(0))
                    // .placeholder(R.mipmap.loading_pic)
                    .dontAnimate()
                    .bitmapTransform(new BlurTransformation(context, 1, 4))
                    .into(rlRoot);
            themePicView.setImageList(community.getImageList(), context);
            ArrayList<String> tags = new ArrayList<>();
            tags.add("两个黄鹂鸣翠柳");
            tags.add("一行白鹭上青天");
            tags.add("窗含西岭千秋雪");
            tags.add("门泊东吴万里船");
            tagCloudView.setData(tags);
        }
    }

}
