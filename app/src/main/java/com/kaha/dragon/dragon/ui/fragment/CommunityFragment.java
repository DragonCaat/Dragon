package com.kaha.dragon.dragon.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kaha.dragon.R;
import com.kaha.dragon.data.HotPicData;
import com.kaha.dragon.data.KingHeroData;
import com.kaha.dragon.dragon.entity.KingHero;
import com.kaha.dragon.dragon.ui.activity.CircleZoneActivity;
import com.kaha.dragon.dragon.ui.activity.KingHeroActivity;
import com.kaha.dragon.dragon.ui.adapter.KingHeroAdapter;
import com.kaha.dragon.dragon.widget.CustomGridLayoutManager;
import com.kaha.dragon.dragon.widget.jdview.AdverNotice;
import com.kaha.dragon.dragon.widget.jdview.JDAdverView;
import com.kaha.dragon.dragon.widget.jdview.JDViewAdapter;
import com.kaha.dragon.framework.ui.fragment.BaseFragment;
import com.kaha.dragon.framework.utils.glide.GlideUtils;
import com.kaha.dragon.framework.widget.TopView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 社区的fragment
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.ui.fragment
 * @Desciption
 */
public class CommunityFragment extends BaseFragment {

    @BindView(R.id.topView)
    TopView topView;

    @BindView(R.id.banner)
    Banner banner;
//    @BindView(R.id.jdView)
//    JDAdverView jdAdverView;

    private List<Integer> images = new ArrayList<>(5);
    private List<String> titles = new ArrayList<>(5);
    private List<AdverNotice> datas = new ArrayList<>(4);

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_community;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topView.setLeftVisb(false);
        topView.setTitle("社区");
        initBanner();
        //initData();
    }
/*
    private void initData() {
        datas.add(new AdverNotice("人生若只如初见,何事秋风悲画扇 等闲变却故人心,却道故人心易变", "最新"));
        datas.add(new AdverNotice("时光的剪影里,暖了多少相遇，又惆怅了多少离别", "最火爆"));
        datas.add(new AdverNotice("日光倾城而下,时光的摆上印记在身后层层腐朽", "HOT"));
        datas.add(new AdverNotice("千山万水,一帘烟雨，迷离了眼眸", "new"));
        final JDViewAdapter adapter = new JDViewAdapter(datas);
        jdAdverView.setAdapter(adapter);
        //开启线程滚东
        jdAdverView.start();
    }
*/
    //初始化banner
    private void initBanner() {
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);
        images.add(R.mipmap.banner5);
        titles.add("人生若只如初见，何事秋风悲画扇 等闲变却故人心，却道故人心易变");
        titles.add("滚滚红尘，陌上寒烟。前世的缘，今生相见");
        titles.add("千山万水，一帘烟雨，迷离了眼眸");
        titles.add("时光的剪影里，暖了多少相遇，又惆怅了多少离别");
        titles.add("日光倾城而下，时光的摆上印记在身后层层腐朽");
        //设置banner动画效果
        // banner.setBannerAnimation(Transformer.Accordion);
        //banner的样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置指示器位置（当banner模式中有指示器时）
        // banner.setIndicatorGravity(BannerConfig.CENTER);
        //轮询间隔
        banner.setDelayTime(4000);
        //设置banner的图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                //实用你自己的图片加载框架加载图片
                //Picasso.with(context).load((Integer) path).into(imageView);
                GlideUtils.show(context, path, imageView);
            }
        });
        //设置图片集合
        banner.setImages(images);
        banner.start();
        //设置自动轮播，默认为true
        //banner.isAutoPlay(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        //banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        // banner.stopAutoPlay();
    }

    @OnClick({R.id.ll_circle_friends, R.id.ll_king_hero})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_circle_friends:
                skipPage(CircleZoneActivity.class);
                break;
            case R.id.ll_king_hero:
                skipPage(KingHeroActivity.class);
                break;
        }
    }
}
