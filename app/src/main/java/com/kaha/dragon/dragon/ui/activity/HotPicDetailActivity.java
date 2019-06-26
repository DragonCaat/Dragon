package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.entity.HotPic;
import com.kaha.dragon.dragon.ui.adapter.home.HotPicAdapter;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import butterknife.BindView;

/**
 * 热门图片的详情activity
 *
 * @author Darcy
 * @Date 2019/4/25
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class HotPicDetailActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView imageView;

    private HotPic hotPic;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_pic_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotPic = (HotPic) getIntent().getSerializableExtra(HotPicAdapter.HOT_PIC);

        initView();
    }

    private void initView() {
        GlideUtils.show(context, hotPic.getImage(), imageView, R.mipmap.loading_pic, R.mipmap.loading_pic);
    }
}
