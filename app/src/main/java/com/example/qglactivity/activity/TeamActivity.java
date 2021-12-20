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
import com.example.qglactivity.adapter.TeamAdapter;
import com.example.qglactivity.base.BaseActivity;
import com.example.qglactivity.bean.TeamBean;
import com.example.qglactivity.presenter.TeamPresenter;
import com.example.qglactivity.util.Utils;
import com.example.qglactivity.view.TeamView;

import java.util.ArrayList;
import java.util.List;

import static com.example.qglactivity.util.ConvenientUtils.UndTv;

/**
 * 作者: qgl
 * 创建日期：2021/11/19
 * 描述:我的伙伴
 */
public class TeamActivity extends BaseActivity<TeamPresenter, TeamView> implements TeamView, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    //下拉刷新控件
    private SwipeRefreshLayout team_swipe_refresh;
    //列表ListView
    private RecyclerView team_recycler;
    //累计团队
    private TextView team_person_number;
    //返回键
    private LinearLayout iv_back;
    //搜索框
    private EditText team_ed_search;
    //页码
    private int mCount = 1;
    //请求数据数量
    private int pageSize = 20;
    //排序按钮
    private TextView team_sorting;
    //实体类集合
    private List<TeamBean.DataBean> mData = new ArrayList<>();
    //搜索内容
    private String search_value = "";
    //排序标识 1升序2降序
    private String sortTime = "2";

    private TeamAdapter mAdapter;

    //用于判断数据是否更新
    private boolean isUpdate = false;

    @Override
    protected TeamPresenter createPresenter() {
        return new TeamPresenter();
    }

    @Override
    protected int getLayoutId() {
        // 设置状态栏颜色
        statusBarConfig(R.color.new_theme_color, false).init();
        return R.layout.team_activity;
    }

    @Override
    protected void init() {
        iv_back = findViewById(R.id.iv_back);
        team_swipe_refresh = findViewById(R.id.team_swipe_refresh);
        team_recycler = findViewById(R.id.team_recycler);
        team_person_number = findViewById(R.id.team_person_number);
        team_ed_search = findViewById(R.id.team_ed_search);
        team_sorting = findViewById(R.id.team_sorting);
        UndTv(TeamActivity.this, sortTime, team_sorting);
        SearchMethods();
        initView();
        presenter.isTeamList(getUserId(), mCount, pageSize, search_value, sortTime);
    }

    private void SearchMethods() {
        team_ed_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 当按了搜索之后关闭软键盘
                    Utils.hideKeyboard(team_ed_search);
                    search_value = v.getText().toString().trim();
                    presenter.isTeamList(getUserId(), mCount, pageSize, search_value, sortTime);
                    return true;
                }
                return false;
            }
        });
    }

    private void initView() {
        //下拉样式
        team_swipe_refresh.setColorSchemeResources(R.color.new_theme_color, R.color.green, R.color.colorAccent);
        //上拉刷新初始化
        team_swipe_refresh.setOnRefreshListener(this);
        //adapter配置data
        mAdapter = new TeamAdapter(this, R.layout.item_team, mData);
        //打开加载动画
        mAdapter.openLoadAnimation();
        //设置启用加载更多
        mAdapter.setEnableLoadMore(true);
        //设置为加载更多监听器
        mAdapter.setOnLoadMoreListener(this, team_recycler);
        //数据为空显示xml
        mAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.list_empty, null));
        //RecyclerView设置布局管理器
        team_recycler.setLayoutManager(new LinearLayoutManager(this));
        //RecyclerView配置adapter
        team_recycler.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        iv_back.setOnClickListener(this);
        team_sorting.setOnClickListener(this);
    }

    @Override
    public void onRefresh() {
        isUpdate = false;
        mCount = 1;
        team_swipe_refresh.setRefreshing(true);
        presenter.isTeamList(getUserId(), mCount, pageSize, search_value, sortTime);
    }

    @Override
    public void onLoadMoreRequested() {
        isUpdate = true;
        mCount = mCount + 1;
        presenter.isTeamList(getUserId(), mCount, pageSize, search_value, sortTime);
    }


    @Override
    public void showListData(TeamBean bean) {
        team_person_number.setText("共计:" + bean.getPartnerCounts() + "人");
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
        mAdapter.loadMoreEnd();
    }

    @Override
    public void loadMoreComplete() {
        mAdapter.loadMoreComplete();
    }

    @Override
    public void showErrorMessage(String msg) {
        showToast(msg);

    }

    @Override
    public void showProgress() {
        team_swipe_refresh.setRefreshing(true);

    }

    @Override
    public void downProgress() {
        team_swipe_refresh.setRefreshing(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.team_sorting:
                if (sortTime.equals("1")) {
                    sortTime = "2";
                } else {
                    sortTime = "1";
                }
                UndTv(TeamActivity.this, sortTime, team_sorting);
                presenter.isTeamList(getUserId(), mCount, pageSize, search_value, sortTime);
                break;
        }
    }

}