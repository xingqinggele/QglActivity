package com.example.qglactivity.cusview;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.qglactivity.R;

/**
 * 作者: qgl
 * 创建日期：2021/11/2
 * 描述:
 */
public abstract class BaseDialog extends Dialog{
    private int dialogWidth = WindowManager.LayoutParams.WRAP_CONTENT;//弹窗的宽
    private int dialogHeight = WindowManager.LayoutParams.WRAP_CONTENT;//弹窗的高
    private int dialogGravity = Gravity.BOTTOM;//弹窗显示的位置
    private int anim = R.style.MyDialogAnimation;//弹窗显示效果

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public BaseDialog(@NonNull Context context, boolean cancelable) {
        super(context, cancelable?R.style.Custom_Dialog_Theme_Background_DimEnabled_True:R.style.Custom_Dialog_Theme_Background_DimEnabled_False);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        onCreateView(window.getWindowManager());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = dialogWidth;
        attributes.height = dialogHeight;//设置高
        attributes.gravity = dialogGravity;//设置位置
        window.setAttributes(attributes);//设置属性
        window.setWindowAnimations(anim);//设置动画
    }

    protected abstract void onCreateView(WindowManager windowManager);

    /**
     * 设置弹窗的宽度
     * @param dialogWidth （单位px）
     */
    public void setDialogWidth(int dialogWidth) {
        this.dialogWidth = dialogWidth;
    }
    /**
     * 设置弹窗的高度
     * @param dialogHeight （单位px）
     */
    public void setDialogHeight(int dialogHeight) {
        this.dialogHeight = dialogHeight;
    }
    /**
     * 设置弹窗的显示位置
     * @param dialogGravity
     */
    public void setDialogGravity(int dialogGravity) {
        this.dialogGravity = dialogGravity;
    }

    /**
     * 设置弹窗的显示动画效果
     * @param anim
     */
    public void setAnim(int anim) {
        this.anim = anim;
    }
}