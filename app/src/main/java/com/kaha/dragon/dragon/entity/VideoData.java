package com.kaha.dragon.dragon.entity;

import android.graphics.Bitmap;

/**
 * 视屏播放的实体类
 *
 * @author Darcy
 * @Date 2019/1/10
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class VideoData {
    private String path;

    private Bitmap bitmap;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
