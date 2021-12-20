package com.example.qglactivity.activity;

import com.example.qglactivity.R;
import com.example.qglactivity.base.BaseActivity;
import com.example.qglactivity.bean.EquipmentBean;
import com.example.qglactivity.presenter.EquipmentPresenter;
import com.example.qglactivity.view.EquipmentView;

/**
 * 作者: qgl
 * 创建日期：2021/11/19
 * 描述:终端管理
 */
public class EquipmentActivity extends BaseActivity<EquipmentPresenter, EquipmentView> implements EquipmentView {
    @Override
    protected EquipmentPresenter createPresenter() {
        return new EquipmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.equipment_activity;
    }

    @Override
    protected void init() {
        presenter.EquipmentData(getUserId());
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showEquipmentData(EquipmentBean bean) {

    }

    @Override
    public void showErrorToken(String msg) {

    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void downProgress() {

    }
}