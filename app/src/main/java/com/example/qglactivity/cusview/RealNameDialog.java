package com.example.qglactivity.cusview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.qglactivity.R;

/**
 * 作者: qgl
 * 创建日期：2021/11/2
 * 描述:实名认证Dialog
 */
public class RealNameDialog extends BaseDialog {
    private float width;
    private View addView;
    private boolean isCanceled = true; //点击其他区域是否关闭
    private boolean isCancelable = true; //点击物理返回键是否关闭
    public RealNameDialog(@NonNull Context context, boolean dimEnabled, float width) {
        super(context, dimEnabled);
        this.width = width;
    }

    @Override
    protected void onCreateView(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        setDialogWidth((int) (displayMetrics.widthPixels * width));
        setDialogHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setContentView(addView);
        //dialog弹出后会点击屏幕，dialog不消失；点击物理返回键dialog消失
        setCanceledOnTouchOutside(isCanceled);
        //dialog弹出后会点击屏幕或物理返回键，dialog不消失
        setCancelable(isCancelable);
    }

    public RealNameDialog setNewView(View addView){
        this.addView = addView;
        return this;
    }

    public void setDialogCanceled(boolean isCanceled){
        this.isCanceled = isCanceled;
    }

    public void setDialogCancelable(boolean Cancelable){
        this.isCancelable = Cancelable;
    }
}