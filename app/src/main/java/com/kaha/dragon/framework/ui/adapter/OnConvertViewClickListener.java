package com.kaha.dragon.framework.ui.adapter;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/**
 * 用于解决getView()方法生成很多不必要的OnClickListener对象的问题.
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.framework.ui.adapter
 * @Desciption
 */
public abstract class OnConvertViewClickListener implements View.OnClickListener {
    private View convertView;
    private int[] positionIds;

    public OnConvertViewClickListener(View convertView, int... positionIds) {
        this.convertView = convertView;
        this.positionIds = positionIds;
    }

    @TargetApi(Build.VERSION_CODES.DONUT)
    @Override
    public void onClick(View v) {
        int len = positionIds.length;
        int[] positions = new int[len];
        for (int i = 0; i < len; i++) {
            positions[i] = (int) convertView.getTag(positionIds[i]);
        }
        onClickCallBack(v, positions);
    }

    /**
     * 点击回调
     *
     * @return void
     * @time 2018-9-18 17:32
     **/
    public abstract void onClickCallBack(View clickView, int... positionIds);

}
