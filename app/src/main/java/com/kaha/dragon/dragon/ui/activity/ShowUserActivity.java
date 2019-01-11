package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.dragon.entity.Community;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.utils.StatusBarUtil;
import com.kaha.dragon.framework.widget.TopView;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

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

    /**
     * 初始化toolbar
     *
     * @param ,
     * @return void
     * @date 2019-01-09
     */
    private void initToolBar() {
        //setSupportActionBar(toolbar);
    }

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
            rlRoot.setImageResource(community.getImageList().get(0));
        }
    }

}
