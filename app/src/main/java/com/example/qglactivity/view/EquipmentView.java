package com.example.qglactivity.view;

import com.example.qglactivity.bean.EquipmentBean;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/11/1
 * 描述:终端管理
 */
public interface EquipmentView extends IBaseView {

    //显示数据
    void showEquipmentData(EquipmentBean bean);

    //token错误
    void showErrorToken(String msg);

} 