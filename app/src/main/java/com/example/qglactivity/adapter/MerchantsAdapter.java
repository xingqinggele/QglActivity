package com.example.qglactivity.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.qglactivity.R;
import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.MerchantsBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:
 */
public class MerchantsAdapter extends BaseQuickAdapter<MerchantsBean.DataBean, BaseViewHolder> {

    public MerchantsAdapter(int layoutResId, @Nullable List<MerchantsBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantsBean.DataBean item) {
        helper.setText(R.id.merchants_name,item.getMerchantName());
        helper.setText(R.id.merchants_price,new BigDecimal(item.getTransAmount()).toString());
    }


}