package com.kaha.dragon.framework.base;

import android.support.multidex.MultiDexApplication;

/**
 * @author Darcy
 * @Date 2018/12/11
 * @package com.darcy.pet.trunk.framework.base
 * @Desciption
 */
public class MyApplication extends MultiDexApplication {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 获取全局的上下文
     *
     * @return MyApplication
     * @date 2018-12-11
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
