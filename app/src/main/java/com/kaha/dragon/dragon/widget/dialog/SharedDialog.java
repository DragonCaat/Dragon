package com.kaha.dragon.dragon.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.kaha.dragon.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 分享的dialog
 *
 * @author Darcy
 * @Date 2019/4/17
 * @package com.kaha.dragon.dragon.widget.dialog
 * @Desciption
 */
public abstract class SharedDialog extends Dialog implements
        android.view.View.OnClickListener {

    private Activity activity;


    public SharedDialog(Activity activity) {
        super(activity, R.style.BottomDialog);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialo_shared_layout);

        setViewLocation();
        setCanceledOnTouchOutside(true);// 外部点击取消

        ButterKnife.bind(this);

    }

    /**
     * 设置dialog位于屏幕底部
     *
     * @return void
     * @Date 2018-11-19
     */
    private void setViewLocation() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }

    @OnClick({R.id.ll_wx_shared, R.id.ll_wx_zone_shared, R.id.tv_cancel})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_wx_shared:
                wxShared();
                this.cancel();
                break;
            case R.id.ll_wx_zone_shared:
                wxZoneShared();
                this.cancel();
                break;
            //取消分享
            case R.id.tv_cancel:
                this.cancel();
                break;
        }
    }

    public abstract void wxShared();

    public abstract void wxZoneShared();

}
