package com.example.qglactivity.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.example.qglactivity.R;
import com.example.qglactivity.adapter.MyViewPageAdapter;
import com.example.qglactivity.base.BaseNoActivity;
import com.example.qglactivity.fragment.BusinessMessageFragment;

import java.util.ArrayList;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:消息
 */
public class HomeMessageActivity extends BaseNoActivity implements View.OnClickListener {
    //选项卡控件
    private TabLayout message_table_layout;
    //ViewPager
    private ViewPager message_viewpager;
    //返回键
    private LinearLayout iv_back;
    //存储标题容器
    ArrayList<String> title_dates = new ArrayList<>();
    //存储界面容器
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected int getLayoutId() {
        // 设置状态栏颜色
        statusBarConfig(R.color.new_theme_color, false).init();
        return R.layout.message_activity;
    }

    @Override
    protected void init() {
        message_table_layout = findViewById(R.id.message_table_layout);
        message_viewpager = findViewById(R.id.message_viewpager);
        iv_back = findViewById(R.id.iv_back);
        initData();
    }

    @Override
    protected void initListener() {
        iv_back.setOnClickListener(this);

    }

    //数据处理

    private void initData() {
        //tab标题存入容器里
        title_dates.add("业务消息");
        title_dates.add("系统消息");
        //fragment存入容器里
        fragmentList.add(new BusinessMessageFragment());
        fragmentList.add(new BusinessMessageFragment());
        //配置adapter
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回键
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void initView() {
        //初始化Adapter
        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getSupportFragmentManager(), title_dates, fragmentList);
        //设置选中的标签指示器、默认选中第一个
        message_table_layout.setSelectedTabIndicator(0);
        //viewPager设置适配器
        message_viewpager.setAdapter(myViewPageAdapter);
        //设置ViewPager
        message_table_layout.setupWithViewPager(message_viewpager);
        //设置选项卡
        message_table_layout.setTabsFromPagerAdapter(myViewPageAdapter);
    }
}