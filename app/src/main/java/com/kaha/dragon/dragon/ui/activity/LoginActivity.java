package com.kaha.dragon.dragon.ui.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.kaha.dragon.R;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 *
 * @author Jack
 * @package com.kaha.dragon.dragon.ui.activity
 * @date 2019-1-14
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_userName)
    EditText mEtUserName;
    @BindView(R.id.et_passWord)
    EditText mEtPassWord;

    private String userName = "";
    private String passWord = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDate();

    }

    private void initDate(){
        getDate();
        if (userName != null || passWord != null){
            mEtUserName.setText(userName);
            mEtPassWord.setText(passWord);
        }else{
            mEtUserName.setText("");
            mEtPassWord.setText("");
        }

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_login:
                checkDate();
                break;
            case R.id.tv_register:
                break;
            case R.id.tv_forget_pass:
                break;
        }
    }


    private void checkDate(){
        userName = getUserName();
        passWord = getPassword();
        if (TextUtils.isEmpty(userName)||(TextUtils.isEmpty(passWord))){
            ToastUtil.show(this,"用户名和密码不能为空");
        }else {
            login();
        }
    }

    private void login(){
        getDate();
        saveDate();
        skipPage(MainActivity.class);
    }

    //保存用户输入的信息到本地
    public void saveDate() {
        SharedPreferences.Editor editor = getSharedPreferences("date", MODE_PRIVATE).edit();
        editor.putString("userName", getUserName());
        editor.putString("passWord", getPassword());
    }

    //从SharedPreferences获取保存的信息
    public void getDate(){
        SharedPreferences pref = getSharedPreferences("date",MODE_PRIVATE);
        String userName = pref.getString("userName","");
        String password = pref.getString("password","");
    }

    //获取用户输入的信息
    public String getUserName(){
        return mEtUserName.getText().toString().trim();
    }
    public String getPassword(){
        return mEtPassWord.getText().toString().trim();
    }

}
