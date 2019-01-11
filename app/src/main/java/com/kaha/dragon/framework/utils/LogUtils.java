package com.kaha.dragon.framework.utils;

import android.util.Log;

/**
 * 日志打印类
 *
 * @author Darcy
 * @Date 2018/12/10
 * @package com.darcy.pet.trunk.framework.utils
 * @Desciption
 */
public class LogUtils {

    public static boolean isDebug = true;//是否要打印bug，可以再application的onCreate方法里面初始化

    private static final String TAG = LogUtils.class.getSimpleName();

    // 下面四个是默认tag的方法
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug) {
            int index = 0;
            int maxLength = 3800;
            String sub;
            while (index < msg.length()) {
                // java的字符不允许指定超过总的长度end
                if (msg.length() <= index + maxLength) {
                    sub = msg.substring(index);
                } else {
                    sub = msg.substring(index, index + maxLength);
                }

                index += maxLength;
                Log.e(TAG, sub.trim());
            }
        }
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的方法
    public static void i(String tag, String msg) {
        if (isDebug) {
            int index = 0;
            int maxLength = 3800;
            String sub;
            while (index < msg.length()) {
                // java的字符不允许指定超过总的长度end
                if (msg.length() <= index + maxLength) {
                    sub = msg.substring(index);
                } else {
                    sub = msg.substring(index, index + maxLength);
                }

                index += maxLength;
                Log.i(tag, sub.trim());
            }
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }
    public static void w(String tag, String msg) {
        if (isDebug)
            Log.w(tag, msg);
    }
    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }

    public static void outTaskCurrentTime(boolean start) {
        if (isDebug)
            Log.e(start ? "start" : "end" + " CurrentTime", "********************" + System.currentTimeMillis() + "********************");
    }


    /**
     * 截断输出日志
     *
     * @param msg
     */
    public static void test(String tag, String msg) {
        if (isDebug) {
            if (tag == null || tag.length() == 0
                    || msg == null || msg.length() == 0) {
                return;
            }

            int segmentSize = 500 * 1024;
            long length = msg.length();
            if (length <= segmentSize) {// 长度小于等于限制直接打印
                Log.i(tag, msg);
            } else {
                while (msg.length() > segmentSize) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize);
                    msg = msg.replace(logContent, "");
                    Log.i(tag, logContent);
                }
                Log.i(tag, msg);// 打印剩余日志
            }
        }
    }


    private LogUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
}
