package com.kaha.dragon.framework.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;


/**
 * 实现圆角bitmap的transformation
 *
 * @author Darcy
 * @date 2019-01-10
 * @package com.darcy.pet.trunk.framework.utils
 * @Desciption
 */
public class RoundTransformation extends BitmapTransformation {

    private float radius = 0f;

    public final static float CIRCLE = -10;

    public RoundTransformation(Context context) {
        this(context, 4);
    }

    public RoundTransformation(Context context, float radius) {
        super(context);
        this.radius = radius;

    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap source, int outWidth, int outHeight) {
        return roundCrop(pool, source);
    }


    private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) {
            return null;
        }
        int left = 1;
        int top = 1;
        int width = source.getWidth();
        int height = source.getHeight();


        if (radius == CIRCLE) {
            if (width > height) {
                width = source.getHeight();
            } else {
                height = source.getWidth();
            }
            radius = width / 2 - 1;
        }
        Bitmap result = pool.get(width, height, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(width, height, Bitmap.Config
                    .ARGB_8888);
        }


        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader
                .TileMode.CLAMP));
        paint.setAntiAlias(true);

        RectF rectF = new RectF(left, top, width, height);

        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }

}
