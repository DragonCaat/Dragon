package com.kaha.dragon.dragon.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.github.chrisbanes.photoview.PhotoView;
import com.kaha.dragon.dragon.widget.ninelayout.Utils;

import java.util.List;

/**
 * 图片查看器viewpager的适配器
 *
 * @author Darcy
 * @date 2019-01-07
 * @des
 */
public class ImagePreviewAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> imageList;
    private int itemPosition;
    private PhotoView photoView;

    public ImagePreviewAdapter(Context context, List<Integer> imageList, int itemPosition) {
        this.context = context;
        this.imageList = imageList;
        this.itemPosition = itemPosition;
    }

    @Override
    public int getCount() {
        return imageList == null ? 0 : imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final PhotoView image = new PhotoView(context);

//        final ProgressBar progressBar = new ProgressBar(context);
//
//        container.addView(progressBar);

        image.setEnabled(true);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image.setMaximumScale(2.0F);
        image.setMinimumScale(0.8F);
        //progressBar.setVisibility(View.VISIBLE);

        Glide.with(context).load(imageList.get(position)).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                //progressBar.setVisibility(View.INVISIBLE);
                image.setImageDrawable(resource);
            }
        });

        //Glide.with(context).load(Const.PIC_URL+imageList.get(position)).into(image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setEnabled(false);
                ((Activity) context).onBackPressed();
            }
        });
        container.addView(image);
        return image;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        photoView = (PhotoView) object;
        photoView.setTag(Utils.getNameByPosition(itemPosition, position));
        photoView.setTransitionName(Utils.getNameByPosition(itemPosition, position));
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    public PhotoView getPhotoView() {
        return photoView;
    }

}
