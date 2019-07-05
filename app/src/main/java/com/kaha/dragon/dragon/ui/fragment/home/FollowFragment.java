package com.kaha.dragon.dragon.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kaha.dragon.R;
import com.kaha.dragon.dragon.widget.dialog.SharedDialog;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 首页关注的fragment
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.ui.fragment.home
 * @Desciption
 */
public class FollowFragment extends BaseFragment {
    @BindView(R.id.iv_bg)
    ImageView ivBg;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(context)
                .load(R.mipmap.xiaowanzi)
                .placeholder(R.mipmap.loading_pic)
                .bitmapTransform(new BlurTransformation(context, 10))
                .into(ivBg);
    }

    @OnClick({R.id.tv_follow})
    public void onClick() {
        new SharedDialog(activity) {
            @Override
            public void wxShared() {

            }

            @Override
            public void wxZoneShared() {

            }
        }.show();
    }
}
