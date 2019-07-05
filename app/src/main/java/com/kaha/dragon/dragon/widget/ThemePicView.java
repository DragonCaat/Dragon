package com.kaha.dragon.dragon.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 显示主题照骗的view
 *
 * @author Darcy
 * @Date 2019/6/28
 * @package com.kaha.dragon.dragon.widget
 * @Desciption
 */
public class ThemePicView extends RelativeLayout {

    public ThemePicView(Context context) {
        super(context);
    }

    public ThemePicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout
                .layout_theme_picture, this);
        ButterKnife.bind(this, view);
    }

    public ThemePicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindView(R.id.image1)
    ImageView imageView1;
    @BindView(R.id.image2)
    ImageView imageView2;
    @BindView(R.id.image3)
    ImageView imageView3;
    @BindView(R.id.image4)
    ImageView imageView4;
    @BindView(R.id.image5)
    ImageView imageView5;
    @BindView(R.id.image6)
    ImageView imageView6;

    //设置图片数据源
    public void setImageList(List<Integer> imageList, Context context) {
        if (imageList.size() == 1) {
            GlideUtils.show(context, imageList.get(0), imageView1);
            GlideUtils.show(context, imageList.get(0), imageView2);
            GlideUtils.show(context, imageList.get(0), imageView3);
            GlideUtils.show(context, imageList.get(0), imageView4);
            GlideUtils.show(context, imageList.get(0), imageView5);
            GlideUtils.show(context, imageList.get(0), imageView6);
        }
        if (imageList.size() == 2) {
            GlideUtils.show(context, imageList.get(0), imageView1);
            GlideUtils.show(context, imageList.get(1), imageView2);
            GlideUtils.show(context, imageList.get(0), imageView3);
            GlideUtils.show(context, imageList.get(1), imageView4);
            GlideUtils.show(context, imageList.get(0), imageView5);
            GlideUtils.show(context, imageList.get(1), imageView6);
        }
        if (imageList.size() == 3) {
            GlideUtils.show(context, imageList.get(0), imageView1);
            GlideUtils.show(context, imageList.get(1), imageView2);
            GlideUtils.show(context, imageList.get(2), imageView3);
            GlideUtils.show(context, imageList.get(0), imageView4);
            GlideUtils.show(context, imageList.get(1), imageView5);
            GlideUtils.show(context, imageList.get(2), imageView6);
        }
        if (imageList.size() == 4) {
            GlideUtils.show(context, imageList.get(0), imageView1);
            GlideUtils.show(context, imageList.get(1), imageView2);
            GlideUtils.show(context, imageList.get(2), imageView3);
            GlideUtils.show(context, imageList.get(3), imageView4);
            GlideUtils.show(context, imageList.get(0), imageView5);
            GlideUtils.show(context, imageList.get(1), imageView6);
        }
        if (imageList.size() == 5) {
            GlideUtils.show(context, imageList.get(0), imageView1);
            GlideUtils.show(context, imageList.get(1), imageView2);
            GlideUtils.show(context, imageList.get(2), imageView3);
            GlideUtils.show(context, imageList.get(3), imageView4);
            GlideUtils.show(context, imageList.get(4), imageView5);
            GlideUtils.show(context, imageList.get(1), imageView6);
        }
        if (imageList.size() > 6) {
            GlideUtils.show(context, imageList.get(0), imageView1);
            GlideUtils.show(context, imageList.get(1), imageView2);
            GlideUtils.show(context, imageList.get(2), imageView3);
            GlideUtils.show(context, imageList.get(3), imageView4);
            GlideUtils.show(context, imageList.get(4), imageView5);
            GlideUtils.show(context, imageList.get(5), imageView6);
        }

    }
}
