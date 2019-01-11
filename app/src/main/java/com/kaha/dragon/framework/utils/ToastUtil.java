package com.kaha.dragon.framework.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kaha.dragon.R;


/**
 * 吐司工具类
 *
 * 多次点击只显示一次。
 * <p>
 * 使用：<br>
 * 显示系统样式的toast：<code>ToastUtil.show(getApplicationContext(), msg);</code><br>
 * 取消显示系统显示的toast：<code>ToastUtil.cancelToast();</code><br>
 * 显示自定义toast：<code>ToastUtil.customToast(getApplicationContext(),msg);</code><br>
 * 取消自定义toast：<code>ToastUtil.cancelCustomToast();</code>
 * </p>
 *
 * @author Darcy
 * @Date 2018/12/10
 * @package com.darcy.pet.trunk.framework.utils
 * @Desciption
 */
public class ToastUtil {
    //上一次显示的信息
    private static String oldMsg;

    private static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    /**
     * 取消toast.
     * @return void
     **/
    public static void cancelToast(){
        if (toast!=null){
            toast.cancel();
            toast=null;
            oldMsg=null;
            oneTime = 0;
            twoTime = 0;
        }
    }

    /**
     * Toast显示信息
     * @param context activity的context或applicationContent
     * @param text 显示的内容
     * @return void
     **/
    public static void show(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (text.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = text;
                toast.setText(text);
                toast.show();
            }
        }
        oneTime = twoTime;
    }


    /**
     * Toast显示信息
     * @param context activity的context或applicationContent
     * @param resId text的resId
     * @return void
     **/
    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }



    //////////////////////////////////////////////////////////////////
    //自定义样式
    /////////////////////////////////////////////////////////////////

    private static Toast customToast = null;
    /**
     * 无图标
     **/
    private static final int IMAGE_RESID_NONE=-1;//

    /**
     * 自定义toast
     * @param context  context
     * @param msg 显示的消息
     * @return void
     **/
    public static void customToast(Context context, String msg){
        customToast(context,msg,IMAGE_RESID_NONE);
    }

    /**
     * 自定义toast
     * @param context  context
     * @param msg 文字
     * @param imageResId 图标icon ， {@link #IMAGE_RESID_NONE}为无图标
     * @return void
     **/
    public static void customToast(Context context, String msg, int imageResId){
        Context applicationContext=context.getApplicationContext();

        View vContent= LayoutInflater.from(applicationContext).inflate(R.layout.framework_layout_custom_toast,null);

        TextView tvMsg=vContent.findViewById(R.id.tv_message);
        tvMsg.setText(msg);
        if (IMAGE_RESID_NONE!=imageResId){
            ImageView ivIcon=vContent.findViewById(R.id.iv_icon);
            ivIcon.setImageResource(imageResId);
        }

        customToast(context,vContent);
    }

    /**
     * 显示自定义toast
     * @param applicationContext applicationContext
     * @param view 自定义样式
     * @return void
     **/
    public static void customToast(Context applicationContext, View view){
        applicationContext=applicationContext.getApplicationContext();
        if (customToast == null) {
            customToast = new Toast(applicationContext);
        }
        //设置toast居中显示
        customToast.setGravity(Gravity.CENTER, 0, 0);
        customToast.setDuration(Toast.LENGTH_SHORT);
        customToast.setView(view);
        customToast.show();
    }

    /**
     * 取消自定义toast
     * @return void
     **/
    public static void cancelCustomToast(){
        if (null!=customToast){
            customToast.cancel();
            customToast=null;
        }
    }
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //自定义样式
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
}
