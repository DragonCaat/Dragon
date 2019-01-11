package com.kaha.dragon.dragon.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.kaha.dragon.framework.utils.glide.GlideUtils;

import java.util.List;

/**
 * Created by Dragon on 2017-10-26.
 * banner图的view
 */
public class ViewPagerBinner extends RelativeLayout implements
        ViewPager.OnPageChangeListener {
    private final int MAX_COUNT = Integer.MAX_VALUE;
    private final int TIME_INTERVAL = 3000;
    public final int MSG_CODE = 0x986;
    private List<Integer> images;
    private ImageView[] imageViews;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private List<View> dots;
    private boolean autoPlayFlag;
    private int currentNumber;

    private Context mContext;

    public void setImages(List<Integer> images, final Context mContext) {
        this.images = images;
        this.mContext = mContext;

        if (images != null) {
            imageViews = new ImageView[images.size()];
            for (int i = 0; i < images.size(); i++) {
                imageViews[i] = new ImageView(getContext());

                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                imageViews[i].setLayoutParams(layoutParams);
                GlideUtils.show(mContext, images.get(i), imageViews[i]);
                imageViews[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            // 设置适配器
            viewPager.setAdapter(new MyAdapter());
            // 设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
            currentNumber = (imageViews.length) * 100;
            viewPager.setCurrentItem(currentNumber);
            // 设置监听器
            viewPager.setOnPageChangeListener(this);
            // 开始自动播放
            final Message message = handler.obtainMessage(MSG_CODE);
            handler.sendMessageDelayed(message, TIME_INTERVAL);
        }
    }

    // 构造
    public ViewPagerBinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewPager = new ViewPager(getContext());
        viewPager.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        addView(viewPager);
        autoPlayFlag = true;

    }

    // 设置ViewPager的适配器
    public class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return MAX_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews[position % imageViews.length]);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ViewGroup parent = (ViewGroup) imageViews[position
                    % imageViews.length].getParent();
            if (parent != null) {
                parent.removeAllViews();

            }
            container.addView(imageViews[position % imageViews.length], 0);
            return imageViews[position % imageViews.length];
        }
    }

    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_CODE) {
                if (autoPlayFlag) {
                    showNext();
                }
                Message message = handler.obtainMessage(MSG_CODE);
                handler.sendMessageDelayed(message, TIME_INTERVAL);
            }

        }
    };

    public void showNext() {
        currentNumber++;
        viewPager.setCurrentItem(currentNumber);
    }

    public void showPrevious() {
        currentNumber--;
        viewPager.setCurrentItem(currentNumber);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentNumber = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case ViewPager.SCROLL_STATE_IDLE:
                // 无动作、初始状态
                break;
            case ViewPager.SCROLL_STATE_DRAGGING:
                // 点击、滑屏
                autoPlayFlag = false;
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                // 释放
                autoPlayFlag = true;
                break;
        }
    }
}