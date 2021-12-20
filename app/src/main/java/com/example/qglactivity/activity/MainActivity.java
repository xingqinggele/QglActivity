package com.example.qglactivity.activity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.example.qglactivity.R;
import com.example.qglactivity.base.BaseNoActivity;
import com.example.qglactivity.fragment.DataFragment;
import com.example.qglactivity.fragment.HomeFragment;
import com.example.qglactivity.fragment.MineFragment;
import com.example.qglactivity.util.StatusBarUtil;
import com.example.qglactivity.util.Utils;
import com.gyf.barlibrary.ImmersionBar;

public class MainActivity extends BaseNoActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private BottomNavigationView bottom_nav;
    private Fragment[] fragments; //fragment数组
    private int lastFragmentIndex = 0;//初始显示的页码
    //权限标识值
    private static final int REQUEST_CODE = 1;
    //权限池
    private static final String[] BASIC_PERMISSIONS = new String[]{
            //相机权限
            android.Manifest.permission.CAMERA,
            //读取手机状态和身份
            android.Manifest.permission.READ_PHONE_STATE,
            // 拨打电话
            Manifest.permission.CALL_PHONE,
            // 修改、删除SD卡中内容
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            //通知权限
            Manifest.permission.ACCESS_NOTIFICATION_POLICY,
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //选中效果
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.home_btn:
                //设置状态栏颜色,修改状态栏字体颜色
                statusBarConfig(R.color.white, true).init();
                switchFragment(0);
                break;
            case R.id.data_btn:
                //设置状态栏颜色
                statusBarConfig(R.color.new_theme_color, false).init();
                switchFragment(1);
                break;
            case R.id.me_btn:
                //设置状态栏颜色
                statusBarConfig(R.color.new_theme_color, false).init();
                switchFragment(2);
                break;
        }
        return false;
    }

    private void switchFragment(int to) {
        if (lastFragmentIndex == to) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragments[to].isAdded()) {
            transaction.add(R.id.main_frame, fragments[to]);
        } else {
            transaction.show(fragments[to]);
        }
        transaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();
        lastFragmentIndex = to;
    }

    @Override
    public void onBackPressed() {
        Utils.onFinish(this, getResources().getString(R.string.app_name));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setItemIconTintList(null);
        fragments = new Fragment[]{
                new HomeFragment(),
                new DataFragment(),
                new MineFragment()};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame, fragments[0])
                .commit();
        //设置状态栏颜色,修改状态栏字体颜色
        statusBarConfig(R.color.white, true).init();
        //权限获取
        initPermission();
    }

    @Override
    protected void initListener() {
        bottom_nav.setOnNavigationItemSelectedListener(this);
    }


    /**
     * 获取权限
     */
    private void initPermission() {
        // 版本判断。当手机系统大于 23 时，才有必要去判断权限是否获取
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 检查该权限是否已经获取
            for (int i = 0; i < BASIC_PERMISSIONS.length; i++) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), BASIC_PERMISSIONS[i]) != PackageManager.PERMISSION_GRANTED) {
                    // 如果没有授予该权限，就去提示用户请求
                    ActivityCompat.requestPermissions(this, BASIC_PERMISSIONS, REQUEST_CODE);
                }
            }

        }
    }
}