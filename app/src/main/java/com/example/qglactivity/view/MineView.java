package com.example.qglactivity.view;

import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.bean.MinePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/11/2
 * 描述:wode
 */
public interface MineView extends IBaseView{

    //显示数据
    void showMineData(MinePageBean bean);

    //token错误
    void showErrorToken(String msg);

    //未实名
    void NoRealName();

} 