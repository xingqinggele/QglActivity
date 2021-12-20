package com.example.qglactivity.activity;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qglactivity.R;
import com.example.qglactivity.base.BaseActivity;
import com.example.qglactivity.bean.LoginBean;
import com.example.qglactivity.presenter.LoginPresenter;
import com.example.qglactivity.util.SPUtils;
import com.example.qglactivity.view.LoginView;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:登录
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    //是否记住密码
    private boolean RememberPass = false;
    //手机号输入框
    private EditText login_et_userName;
    //密码输入框
    private EditText login_et_passWord;
    //登录按钮
    private Button login_bt_login;
    //是否记住密码选项
    private CheckBox login_remember_password;
    //忘记密码按钮
    private TextView login_tv_forgot_password;
    //隐私政策
    private TextView privacy_btn_tv;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        // 设置状态栏颜色
        statusBarConfig(R.color.login_title,false).init();
        return R.layout.login_activity;
    }

    @Override
    protected void init() {
        //判断本地是否存在数据,如果存在就直接去登录
        if (SPUtils.contains(LoginActivity.this, "passWord")) {
            presenter.login(this,
                    RememberPass,
                    SPUtils.get(LoginActivity.this, "userName", "-1").toString(),
                    SPUtils.get(LoginActivity.this, "passWord", "-1").toString());
        }
        login_et_userName = findViewById(R.id.login_et_userName);
        login_et_passWord = findViewById(R.id.login_et_passWord);
        login_bt_login = findViewById(R.id.login_bt_login);
        login_remember_password = findViewById(R.id.login_remember_password);
        login_tv_forgot_password = findViewById(R.id.login_tv_forgot_password);
        privacy_btn_tv = findViewById(R.id.privacy_btn_tv);

    }

    @Override
    protected void initListener() {
        login_remember_password.setOnCheckedChangeListener(this);
        login_bt_login.setOnClickListener(this);
        login_tv_forgot_password.setOnClickListener(this);
        privacy_btn_tv.setOnClickListener(this);
    }

    @Override
    public void showGoodList(LoginBean bean) {
        //跳转到主页
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void showErrorMessage(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        //显示加载框
        loadingDialog.loading("登录中...");
    }

    @Override
    public void downProgress() {
        if (loadingDialog != null) {
            //显示加载失败后取消加载框
            loadingDialog.cancel();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //登录按钮
            case R.id.login_bt_login:
                //判断用户是否输入手机号
                if (TextUtils.isEmpty(login_et_userName.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "请输入手机号", Toast.LENGTH_LONG).show();
                    return;
                }
                //判断用户是否输入密码
                if (TextUtils.isEmpty(login_et_passWord.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_LONG).show();
                    return;
                }
                //满足条件进行登录
                presenter.login(this, RememberPass, login_et_userName.getText().toString().trim(), login_et_passWord.getText().toString().trim());
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        RememberPass = b;
    }

}