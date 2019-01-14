package com.kaha.dragon.dragon.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.activity.BaseActivity;

import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.bt})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.bt:
                skipPage(MainActivity.class);
                break;
        }
    }

}
