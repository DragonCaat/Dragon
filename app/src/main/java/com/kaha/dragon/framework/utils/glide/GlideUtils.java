package com.kaha.dragon.framework.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.kaha.dragon.framework.utils.LogUtils;

import java.io.File;


/**
 * 图片加载框架
 *
 * @author Darcy
 * @date 2019-01-10
 * @package com.darcy.pet.trunk.framework.utils
 * @Desciption
 */
public class GlideUtils {

    private static final String TAG = GlideUtils.class.getSimpleName();

    /**
     * 显示图片
     *
     * @param context   context
     * @param url       url
     * @param imageView imageview
     * @return void
     * @time 2018-9-27 11:26
     **/
    public static void show(Context context, Object url, ImageView imageView) {
        show(context, url, imageView, -1, -1, 1.0f, false, DiskCacheStrategy.ALL);
    }

    /**
     * 显示图片
     *
     * @param context    context
     * @param url        url
     * @param imageView  imageview
     * @param placeResId 图片加载出来前，显示的图片
     * @param errorResId 图片加载失败后，显示的图片
     * @return void
     * @time 2018-9-27 11:26
     **/
    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId) {
        show(context, url, imageView, placeResId, errorResId, 1.0f, false, DiskCacheStrategy.ALL);
    }

    /**
     * 显示图片
     *
     * @param context        context
     * @param url            url
     * @param imageView      imageview
     * @param placeResId     图片加载出来前，显示的图片
     * @param errorResId     图片加载失败后，显示的图片
     * @param sizeMultiplier 其显示的倍数大小。例如，你传入 0.2f 作为参数，Glide 将会显示原始图片的20%的大小
     * @return void
     * @time 2018-9-27 11:26
     **/
    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId, float sizeMultiplier) {
        show(context, url, imageView, placeResId, errorResId, sizeMultiplier, false, DiskCacheStrategy.ALL);
    }

    /**
     * 显示图片
     *
     * @param context         context
     * @param url             url
     * @param imageView       imageview
     * @param placeResId      图片加载出来前，显示的图片
     * @param errorResId      图片加载失败后，显示的图片
     * @param sizeMultiplier  其显示的倍数大小。例如，你传入 0.2f 作为参数，Glide 将会显示原始图片的20%的大小
     * @param skipMemoryCache 是否使用内存缓存，true:不使用
     * @return void
     * @time 2018-9-27 11:26
     **/
    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId, float sizeMultiplier, boolean skipMemoryCache) {
        show(context, url, imageView, placeResId, errorResId, sizeMultiplier, skipMemoryCache, DiskCacheStrategy.ALL);
    }

    /**
     * 显示图片
     *
     * @param context           context
     * @param url               url
     * @param imageView         imageview
     * @param placeResId        图片加载出来前，显示的图片
     * @param errorResId        图片加载失败后，显示的图片
     * @param sizeMultiplier    其显示的倍数大小。例如，你传入 0.2f 作为参数，Glide 将会显示原始图片的20%的大小
     * @param skipMemoryCache   是否使用内存缓存，true:不使用
     * @param diskCacheStrategy 磁盘缓存策略，什么都不缓存{@link DiskCacheStrategy#NONE}、
     *                          只缓存全尺寸图{@link DiskCacheStrategy#SOURCE}、 只缓存最终的加载图{@link DiskCacheStrategy#RESULT}、
     *                          缓存所有版本图（默认行为）{@link DiskCacheStrategy#ALL}
     * @return void
     * @time 2018-9-27 11:26
     **/
    public static void show(Context context, Object url, ImageView imageView, int placeResId,
                            int errorResId, float sizeMultiplier, boolean skipMemoryCache,
                            DiskCacheStrategy diskCacheStrategy) {
        Glide.with(context)
                .load(url)
                .placeholder(placeResId)//
                .error(errorResId)//
                .thumbnail(sizeMultiplier)
                .skipMemoryCache(skipMemoryCache)//是否跳过内存缓存
                .diskCacheStrategy(diskCacheStrategy)//是否使用磁盘缓存
                .into(imageView);
    }


    /**
     * 显示裁减后的图片
     *
     * @param context   context
     * @param url       url
     * @param imageView imageview
     * @param width     显示的宽度,单位是px
     * @param height    显示的高度,单位是px
     * @return void
     * @time 2018-9-27 11:39
     **/
    public static void showCutedImage(Context context, String url, ImageView imageView, int width, int height) {
        showCutedImage(context, url, imageView, width, height, -1, -1);
    }

    /**
     * 显示裁减后的图片
     *
     * @param context    context
     * @param url        url
     * @param imageView  imageview
     * @param width      显示的宽度,单位是px
     * @param height     显示的高度,单位是px
     * @param placeResId 图片加载出来前，显示的图片
     * @param errorResId 图片加载失败后，显示的图片
     * @return void
     * @time 2018-9-27 11:39
     **/
    public static void showCutedImage(Context context, String url, ImageView imageView, int width, int height,
                                      int placeResId, int errorResId) {
        Glide.with(context)
                .load(url)
                .override(width, height)//这里的单位是px
                .placeholder(placeResId)
                .error(errorResId)
                .into(imageView);
    }


    /**
     * 加载图片bitmap
     *
     * @param context context
     * @param url     url
     * @param target  获取bitmap的回调
     * @return void
     * @time 2018-9-27 11:49
     **/
    public static void loadBitmap(Context context, String url, SimpleTarget<Bitmap> target) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .into(target);
    }

    /**
     * 显示圆角图片
     *
     * @param context   context
     * @param url       url
     * @param imageView imageview
     * @param radius    圆角半径，单位：px
     **/
    public static void showRoundImage(Context context, Object url, ImageView imageView, float radius) {
        showRoundImage(context, url, imageView, radius, -1, -1);

    }


    /**
     * 显示圆角图片
     *
     * @param context    context
     * @param url        url
     * @param imageView  imageview
     * @param radius     圆角半径，单位：px
     * @param placeResId 图片加载出来前，显示的图片
     * @param errorResId 图片加载失败后，显示的图片
     **/
    public static void showRoundImage(Context context, Object url, ImageView imageView, float radius, int placeResId, int errorResId) {

        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(placeResId)
                .error(errorResId)
                .skipMemoryCache(true)//是否跳过内存缓存
                .transform(new RoundTransformation(context, radius))
                .diskCacheStrategy(DiskCacheStrategy.ALL)//是否使用磁盘缓存
                .into(imageView);

    }

    /**
     * 显示本地图片
     *
     * @return void
     * @time 2018-11-7 15:00
     **/
    public static void loadLocal(Context context, String strFile, ImageView imageView) {
        loadLocal(context, strFile, imageView, 0);
    }

    /**
     * 显示本地图片
     *
     * @return void
     * @time 2018-11-7 15:00
     **/
    public static void loadLocal(Context context, String filePath, ImageView imageView, float radius) {
        File file = new File(filePath);
        if (!file.exists()) {
            LogUtils.w(TAG, "loadLocal() ," + filePath + " 文件不存在！");
            return;
        }
        if (!file.isFile()) {
            LogUtils.w(TAG, "loadLocal() ," + filePath + " 不是文件！");
            return;
        }
        loadLocal(context, file, imageView, radius);
    }

    /**
     * 显示本地图片
     *
     * @return void
     * @time 2018-11-7 15:00
     **/
    public static void loadLocal(Context context, File file, ImageView imageView) {
        loadLocal(context, file, imageView, 0, -1, -1);
    }

    /**
     * 显示本地图片
     *
     * @return void
     * @time 2018-11-7 15:00
     **/
    public static void loadLocal(Context context, File file, ImageView imageView, float radius) {
        loadLocal(context, file, imageView, radius, -1, -1);
    }

    /**
     * 显示本地图片
     *
     * @return void
     * @time 2018-11-7 15:00
     **/
    public static void loadLocal(Context context, File file, ImageView imageView, float radius, int placeResId, int errorResId) {
        Glide.with(context)
                .load(file)
                .placeholder(placeResId)
                .error(errorResId)
                .transform(new RoundTransformation(context, radius))
                .into(imageView);
    }


}
