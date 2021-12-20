package com.example.qglactivity.fragment;

import android.app.Dialog;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qglactivity.base.BaseFragment;
import com.example.qglactivity.R;
import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.cusview.RealNameDialog;
import com.example.qglactivity.presenter.BasePresenter;
import com.example.qglactivity.presenter.DataPresenter;
import com.example.qglactivity.presenter.HomePresenter;
import com.example.qglactivity.view.DataView;
import com.example.qglactivity.view.HomeView;

import java.math.BigDecimal;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/10/27
 * 描述:数据
 */
public class DataFragment extends BaseFragment<DataPresenter, DataView> implements DataView, View.OnClickListener {
    //我的收益
    private LinearLayout data_earnings_tv;
    //我的账单
    private LinearLayout data_bill_tv;
    //个人业绩
    private ConstraintLayout data_personal_results_relative;
    //伙伴业绩
    private ConstraintLayout data_partner_results_relative;
    //本月直营商户交易额
    private TextView data_price_tv1;
    //本月直营商户交易额
    private TextView data_price_tv2;
    //个人 累计伙伴
    private TextView data_new_merchants_tv;
    //个人 累计商户
    private TextView data_total_merchants_tv;
    //累计伙伴
    private TextView data_cumulative_partner_tv;
    //累计商户
    private TextView data_cumulative_merchants_tv;
    //刷新控件
    private SwipeRefreshLayout data_fragment_swipe;
    //入驻状态，1入驻2未入住
    private String Code = "1";
    //个人业绩
    private LinearLayout data_personal_tv;
    //伙伴业绩
    private LinearLayout data_partner_tv;
    //总业绩 本月直营商户交易额
    private TextView data_total_price_tv;
    //总业绩累计伙伴
    private TextView data_total_new_merchants_tv;
    //总业绩累计商户
    private TextView data_total_total_merchants_tv;
     //总业绩
    private LinearLayout data_total_tv;


    @Override
    protected void init(View rootView) {
        data_earnings_tv = rootView.findViewById(R.id.data_earnings_tv);
        data_bill_tv = rootView.findViewById(R.id.data_bill_tv);
        data_personal_results_relative = rootView.findViewById(R.id.data_personal_results_relative);
        data_partner_results_relative = rootView.findViewById(R.id.data_partner_results_relative);
        data_price_tv1 = rootView.findViewById(R.id.data_price_tv1);
        data_price_tv2 = rootView.findViewById(R.id.data_price_tv2);
        data_new_merchants_tv = rootView.findViewById(R.id.data_new_merchants_tv);
        data_total_merchants_tv = rootView.findViewById(R.id.data_total_merchants_tv);
        data_cumulative_partner_tv = rootView.findViewById(R.id.data_cumulative_partner_tv);
        data_cumulative_merchants_tv = rootView.findViewById(R.id.data_cumulative_merchants_tv);
        data_fragment_swipe = rootView.findViewById(R.id.data_fragment_swipe);
        data_personal_tv = rootView.findViewById(R.id.data_personal_tv);
        data_partner_tv = rootView.findViewById(R.id.data_partner_tv);
        data_total_price_tv = rootView.findViewById(R.id.data_total_price_tv);
        data_total_new_merchants_tv = rootView.findViewById(R.id.data_total_new_merchants_tv);
        data_total_total_merchants_tv = rootView.findViewById(R.id.data_total_total_merchants_tv);
        data_total_tv = rootView.findViewById(R.id.data_total_tv);
        data_earnings_tv.setOnClickListener(this);
        data_bill_tv.setOnClickListener(this);
        data_personal_tv.setOnClickListener(this);
        data_partner_tv.setOnClickListener(this);
        data_personal_results_relative.setOnClickListener(this);
        data_partner_results_relative.setOnClickListener(this);
        data_total_tv.setOnClickListener(this);
        SwipeData(data_fragment_swipe);
        presenter.posData();
    }

    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_data;
    }


    @Override
    public void showHomeData(DataPageBean bean) {
        Code = "1";
        data_total_price_tv.setText(bean.getData().getMonthlyTransAmount().toPlainString());
        data_price_tv1.setText(bean.getData().getMerchantTransAmount().toPlainString());
        data_price_tv2.setText(bean.getData().getPartnerTransAmount().toPlainString());
        data_total_new_merchants_tv.setText(bean.getData().getAllParentsCounts()+"");
        data_total_total_merchants_tv.setText(bean.getData().getAllMerchantCounts()+"");
        data_new_merchants_tv.setText(bean.getData().getOwnTotalParentCounts()+"");
        data_total_merchants_tv.setText(bean.getData().getOwnTotalMerchantCounts()+"");
        data_cumulative_partner_tv.setText(bean.getData().getOwnTotalParentCounts()+"");
        data_cumulative_merchants_tv.setText(bean.getData().getParentTotalMerchantCounts()+"");
    }

    @Override
    public void showErrorToken(String msg) {
        showToast(msg);
        exitApp(mContext, true);
    }

    @Override
    public void NoRealName() {
        //实名状态赋值
        Code = "2";
        //弹出实名认证dialog
        showDialog();
    }

    @Override
    public void showErrorMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void showProgress() {
        data_fragment_swipe.setRefreshing(true);

    }

    @Override
    public void downProgress() {
        data_fragment_swipe.setRefreshing(false);

    }

    private void showDialog(){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.real_name_dialog, null);
        RealNameDialog realDialog = new RealNameDialog(getActivity(), true, (float) 0.7).setNewView(view);
        realDialog.setDialogGravity(Gravity.CENTER);
        realDialog.setDialogCancelable(false);
        realDialog.show();
        ImageView perfect_out = view.findViewById(R.id.perfect_out);
        Button perfect_into = view.findViewById(R.id.perfect_into);
        perfect_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realDialog.dismiss();
            }
        });

        perfect_into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {
        data_fragment_swipe.setRefreshing(true);
        presenter.posData();
    }



}