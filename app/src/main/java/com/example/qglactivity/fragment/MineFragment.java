package com.example.qglactivity.fragment;

import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qglactivity.base.BaseFragment;
import com.example.qglactivity.R;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.bean.MinePageBean;
import com.example.qglactivity.cusview.RealNameDialog;
import com.example.qglactivity.presenter.BasePresenter;
import com.example.qglactivity.presenter.HomePresenter;
import com.example.qglactivity.presenter.MinePresenter;
import com.example.qglactivity.util.ImageUtils;
import com.example.qglactivity.view.HomeView;
import com.example.qglactivity.view.MineView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/10/27
 * 描述:我的
 */
public class MineFragment extends BaseFragment<MinePresenter, MineView> implements MineView {
    //入驻状态，1入驻2未入住
    private String Code = "1";
    private SwipeRefreshLayout main_me_refresh;
    private ConstraintLayout main_me_or_code;
    private SimpleDraweeView me_logo;
    private TextView main_me_name;
    private TextView main_me_cooperation_code;
    private TextView intger_tv;
    private TextView wellat_tv;
    private TextView main_me_order;
    private TextView main_me_machine;
    private TextView main_me_wallet;
    private TextView main_me_bank_card;
    private RelativeLayout mine_referees_relative;
    private RelativeLayout mine_authorization_relative;
    private RelativeLayout mine_address_relative;
    private RelativeLayout mine_set_up_relative;
    private RelativeLayout mine_about_relative;

    @Override
    protected void init(View view) {
        main_me_refresh = view.findViewById(R.id.main_me_refresh);
        main_me_or_code = view.findViewById(R.id.main_me_or_code);
        me_logo = view.findViewById(R.id.me_logo);
        main_me_name = view.findViewById(R.id.main_me_name);
        main_me_cooperation_code = view.findViewById(R.id.main_me_cooperation_code);
        intger_tv = view.findViewById(R.id.intger_tv);
        wellat_tv = view.findViewById(R.id.wellat_tv);
        main_me_order = view.findViewById(R.id.main_me_order);
        main_me_machine = view.findViewById(R.id.main_me_machine);
        main_me_wallet = view.findViewById(R.id.main_me_wallet);
        main_me_bank_card = view.findViewById(R.id.main_me_bank_card);
        mine_referees_relative = view.findViewById(R.id.mine_referees_relative);
        mine_authorization_relative = view.findViewById(R.id.mine_authorization_relative);
        mine_address_relative = view.findViewById(R.id.mine_address_relative);
        mine_set_up_relative = view.findViewById(R.id.mine_set_up_relative);
        mine_about_relative = view.findViewById(R.id.mine_about_relative);
        SwipeData(main_me_refresh);
        presenter.posMine(getUserId());
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_mine;
    }


    @Override
    public void onRefresh() {
        main_me_refresh.setRefreshing(true);
        presenter.posMine(getUserId());
    }

    @Override
    public void showMineData(MinePageBean bean) {
        //实名状态赋值
        Code = "1";
        me_logo.setImageURI(ImageUtils.getUri(bean.getData().getPortrait()));
        main_me_name.setText(bean.getData().getNickName());
        main_me_cooperation_code.setText(bean.getData().getMerchCode());
        intger_tv.setText(bean.getData().getIntegral());
        wellat_tv.setText(bean.getData().getWalletAmount());
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
        showDialog();
    }

    @Override
    public void showErrorMessage(String msg) {
        showToast(msg);
    }

    @Override
    public void showProgress() {
        main_me_refresh.setRefreshing(true);
    }

    @Override
    public void downProgress() {
        main_me_refresh.setRefreshing(false);
    }

    private void showDialog() {
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
}