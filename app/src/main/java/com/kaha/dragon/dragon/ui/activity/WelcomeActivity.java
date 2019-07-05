package com.kaha.dragon.dragon.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.activity.BaseActivity;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 欢迎界面
 *
 * @author Darcy
 * @Date 2019/6/26
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.iv_welcome)
    ImageView ivWelcome;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(context)
                .load(R.mipmap.welcome)
                .placeholder(R.mipmap.loading_pic)
                .bitmapTransform(new BlurTransformation(context, 10))
                .into(ivWelcome);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                skipPage(MainActivity.class);
                finish();
            }
        }, 2000);
    }

    private Handler handler = new Handler();

}
