package com.example.qglactivity.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qglactivity.R;
import com.example.qglactivity.adapter.BusinessNewsAdapter;
import com.example.qglactivity.adapter.MerchantsAdapter;
import com.example.qglactivity.base.BaseActivity;
import com.example.qglactivity.bean.MerchantsBean;
import com.example.qglactivity.presenter.BasePresenter;
import com.example.qglactivity.presenter.MerchantsPresenter;
import com.example.qglactivity.util.Utils;
import com.example.qglactivity.view.MerchantsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.qglactivity.util.ConvenientUtils.UndTv;

/**
 * 作者: qgl
 * 创建日期：2021/11/16
 * 描述:我的商户
 */
public class MerchantsActivity extends BaseActivity<MerchantsPresenter, MerchantsView> implements MerchantsView, View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    //请求页数
    private int mCount = 1;
    // 请求数据数量
    private int pageSize = 20;
    //用于判断数据是否更新
    private boolean isUpdate = false;
    private String nikeName = "";
    private LinearLayout iv_back;
    private EditText merchants_person_ed_search;
    private TextView merchants_list_size;
    private TextView merchants_turnover;
    private SwipeRefreshLayout merchants_swipe;
    private RecyclerView merchants_list_view;
    private List<MerchantsBean.DataBean> mData = new ArrayList<>();
    private MerchantsAdapter mAdapter;
    //交易额默认值 1.升序 2.降序
    private String turnover = "2";

    @Override
    protected MerchantsPresenter createPresenter() {
        return new MerchantsPresenter();
    }

    @Override
    protected int getLayoutId() {
        //设置状态栏颜色
        statusBarConfig(R.color.new_theme_color, false).init();
        return R.layout.merchats_activity;
    }

    @Override
    protected void init() {
        iv_back = findViewById(R.id.iv_back);
        merchants_person_ed_search = findViewById(R.id.merchants_person_ed_search);
        merchants_list_size = findViewById(R.id.merchants_list_size);
        merchants_turnover = findViewById(R.id.merchants_turnover);
        UndTv(this, turnover, merchants_turnover);
        merchants_swipe = findViewById(R.id.merchants_swipe);
        merchants_list_view = findViewById(R.id.merchants_list_view);
        initView();
        presenter.isMerchantsData(getUserId(), mCount, pageSize, nikeName, turnover);
        search();
    }

    //初始化列表
    private void initView() {
        //下拉样式
        merchants_swipe.setColorSchemeResources(R.color.new_theme_color, R.color.green, R.color.colorAccent);
        //上拉刷新初始化
        merchants_swipe.setOnRefreshListener(this);
        //adapter配置data
        mAdapter = new MerchantsAdapter(R.layout.item_merchants, mData);
        //打开加载动画
        mAdapter.openLoadAnimation();
        //设置启用加载更多
        mAdapter.setEnableLoadMore(true);
        //设置为加载更多监听器
        mAdapter.setOnLoadMoreListener(this, merchants_list_view);
        //数据为空显示xml
        mAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.list_messge_empty, null));
        //RecyclerView设置布局管理器
        merchants_list_view.setLayoutManager(new LinearLayoutManager(this));
        //RecyclerView配置adapter
        merchants_list_view.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        iv_back.setOnClickListener(this);
        merchants_turnover.setOnClickListener(this);
    }

    @Override
    public void showListData(MerchantsBean bean) {
        merchants_list_size.setText("共" + bean.getNum() + "户");
        if (!isUpdate) {
            mData.clear();
        }
        mData.addAll(bean.getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorToken(String msg) {
        showToast(msg);
        exitApp(mContext, true);
    }

    @Override
    public void loadMoreEnd() {
        //数据长度小于定义的长度,adapter 加载更多的结束
        mAdapter.loadMoreEnd();
    }

    @Override
    public void loadMoreComplete() {
        //数据长度小于定义的长度,adapter 继续加载
        mAdapter.loadMoreComplete();
    }

    @Override
    public void showErrorMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void showProgress() {
        merchants_swipe.setRefreshing(true);

    }

    @Override
    public void downProgress() {
        merchants_swipe.setRefreshing(false);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.merchants_turnover:
                if (turnover.equals("1")) {
                    turnover = "2";
                } else {
                    turnover = "1";
                }
                UndTv(this, turnover, merchants_turnover);
                onRefresh();
                break;
        }
    }

    @Override
    public void onRefresh() {
        isUpdate = false;
        mCount = 1;
        merchants_swipe.setRefreshing(true);
        presenter.isMerchantsData(getUserId(), mCount, pageSize, nikeName, turnover);
    }

    @Override
    public void onLoadMoreRequested() {
        isUpdate = true;
        mCount = mCount + 1;
        presenter.isMerchantsData(getUserId(), mCount, pageSize, nikeName, turnover);
    }

    //搜索框
    private void search() {
        merchants_person_ed_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 当按了搜索之后关闭软键盘
                    Utils.hideKeyboard(merchants_person_ed_search);
                    //输入内容赋给搜索内容
                    nikeName = v.getText().toString().trim();
                    //访问接口
                    onRefresh();
                    return true;
                }
                return false;
            }
        });
    }
}