package com.example.qglactivity.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.qglactivity.R;
import com.example.qglactivity.adapter.BusinessNewsAdapter;
import com.example.qglactivity.base.BaseFragment;
import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.presenter.BusinessMessagePresenter;
import com.example.qglactivity.view.BusinessMessageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:
 */
public class BusinessMessageFragment extends BaseFragment<BusinessMessagePresenter, BusinessMessageView> implements BusinessMessageView, BaseQuickAdapter.RequestLoadMoreListener {
    private BusinessNewsAdapter systemMeAdapter;
    private SwipeRefreshLayout business_message_swipe;
    private RecyclerView business_message_list_view;
    private List<BusinessMessageBean> mData = new ArrayList<>();
    //请求页数
    private int mCount = 1;
    // 请求数据数量
    private int pageSize = 20;
    //用于判断数据是否更新
    private boolean isUpdate = false;


    @Override
    protected int getLayoutId() {
        return R.layout.business_message_fragment;
    }

    @Override
    protected void init(View view) {
        business_message_swipe = view.findViewById(R.id.business_message_swipe);
        business_message_list_view = view.findViewById(R.id.business_message_list_view);
        initView();
        presenter.isMessageData(getUserId(), mCount, pageSize);
    }

    //初始化列表
    private void initView() {
        //下拉样式
        business_message_swipe.setColorSchemeResources(R.color.new_theme_color, R.color.green, R.color.colorAccent);
        //上拉刷新初始化
        business_message_swipe.setOnRefreshListener(this);
        //adapter配置data
        systemMeAdapter = new BusinessNewsAdapter(R.layout.item_business_message, mData);
        //打开加载动画
        systemMeAdapter.openLoadAnimation();
        //设置启用加载更多
        systemMeAdapter.setEnableLoadMore(true);
        //设置为加载更多监听器
        systemMeAdapter.setOnLoadMoreListener(this, business_message_list_view);
        //数据为空显示xml
        systemMeAdapter.setEmptyView(LayoutInflater.from(getActivity()).inflate(R.layout.list_messge_empty, null));
        //RecyclerView设置布局管理器
        business_message_list_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        //RecyclerView配置adapter
        business_message_list_view.setAdapter(systemMeAdapter);
    }


    @Override
    protected BusinessMessagePresenter createPresenter() {
        return new BusinessMessagePresenter();
    }


    @Override
    public void showListData(List<BusinessMessageBean> bean) {
        if (!isUpdate) {
            mData.clear();
        }
        mData.addAll(bean);
        systemMeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        isUpdate = false;
        mCount = 1;
        business_message_swipe.setRefreshing(true);
        presenter.isMessageData(getUserId(), mCount, pageSize);
    }

    @Override
    public void onLoadMoreRequested() {
        isUpdate = true;
        mCount = mCount + 1;
        presenter.isMessageData(getUserId(), mCount, pageSize);
    }


    @Override
    public void showErrorToken(String msg) {
        showToast(msg);
        exitApp(mContext, true);
    }

    @Override
    public void loadMoreEnd() {
        //数据长度小于定义的长度,adapter 加载更多的结束
        systemMeAdapter.loadMoreEnd();
    }

    @Override
    public void loadMoreComplete() {
        //数据长度小于定义的长度,adapter 继续加载
        systemMeAdapter.loadMoreComplete();
    }

    @Override
    public void showErrorMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void showProgress() {
        business_message_swipe.setRefreshing(true);
    }

    @Override
    public void downProgress() {
        business_message_swipe.setRefreshing(false);

    }


}