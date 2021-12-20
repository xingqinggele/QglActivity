package com.example.qglactivity.adapter;

import android.content.Context;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.qglactivity.R;
import com.example.qglactivity.bean.TeamBean;
import com.example.qglactivity.util.ImageUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qgl on 2020/3/11.
 * Describe:
 */
public class TeamAdapter extends BaseQuickAdapter<TeamBean.DataBean, BaseViewHolder> {

    private Context mContext;

    public TeamAdapter(Context context, int layoutResId, @Nullable List<TeamBean.DataBean> data) {
        super(layoutResId, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, TeamBean.DataBean report) {
        SimpleDraweeView home_team_logo = holder.itemView.findViewById(R.id.team_logo);
        home_team_logo.setImageURI(ImageUtils.getUri(report.getPortrait()));
        if (TextUtils.isEmpty(report.getPartnerName())) {
            holder.setText(R.id.team_name, "未实名认证");
            holder.setText(R.id.team_tv_price, "0");
            holder.setText(R.id.team_tv_team_trans_amount, "0");
            holder.setImageDrawable(R.id.real_name_static, mContext.getResources().getDrawable(R.mipmap.no_real_name));
            holder.setVisible(R.id.team_tv_details, false);
        } else {
            holder.setText(R.id.team_name, report.getPartnerName());
            holder.setText(R.id.team_tv_price, new BigDecimal(report.getTeamTransAmount()).toString());
            holder.setText(R.id.team_tv_team_trans_amount, report.getTeamActiveCounts() + "");
            holder.setImageDrawable(R.id.real_name_static, mContext.getResources().getDrawable(R.mipmap.have_real_name));
            holder.setVisible(R.id.team_tv_details, true);
        }

    }

}
