package com.kaha.dragon.dragon.ui.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.activity.BaseActivity;


/**
 * Splash界面
 *
 * @author Jack
 * @package com.kaha.dragon.dragon.ui.activity
 * @date 2019-1-14
 */

public class SplashActivity extends BaseActivity {

    @SuppressLint("HandlerLeak")
    private  Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    getHome();
                    break;
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler.sendEmptyMessageDelayed(1,1000);
    }


    /**
     * 判断跳转的界面
     */
    public void getHome(){
        skipPage(LoginActivity.class);
        finishActivity(SplashActivity.class);

    }

}
