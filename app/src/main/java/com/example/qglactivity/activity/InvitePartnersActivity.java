package com.example.qglactivity.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qglactivity.R;
import com.example.qglactivity.base.BaseActivity;
import com.example.qglactivity.bean.InvitePartnersBean;
import com.example.qglactivity.presenter.InvitePartnersPresenter;
import com.example.qglactivity.util.CodeCreator;
import com.example.qglactivity.util.SPUtils;
import com.example.qglactivity.view.InvitePartnersView;

import static com.example.qglactivity.util.ImageUtils.saveImageToGallery;

/**
 * 作者: qgl
 * 创建日期：2021/11/19
 * 描述:邀请伙伴
 */
public class InvitePartnersActivity extends BaseActivity<InvitePartnersPresenter, InvitePartnersView> implements InvitePartnersView, View.OnClickListener {
    private LinearLayout iv_back;
    private TextView home_invitepar_tv_save;
    private TextView home_inviterpar_mercode;
    private ImageView home_invitepar_img;
    private SoundPool soundPool;
    private int soundID;
    //注册地址
    private String url;
    //邀请码
    private String merchCode;
    //用户名
    private TextView user_name_tv;
    //用户手机号
    private TextView user_phone_tv;
    @Override
    protected InvitePartnersPresenter createPresenter() {
        return new InvitePartnersPresenter();
    }

    @Override
    protected int getLayoutId() {
        //设置状态栏颜色
        statusBarConfig(R.color.new_theme_color, false).init();
        return R.layout.invite_partners_activity;
    }

    @Override
    protected void init() {
        iv_back = findViewById(R.id.iv_back);
        home_invitepar_tv_save = findViewById(R.id.home_invitepar_tv_save);
        home_inviterpar_mercode = findViewById(R.id.home_inviterpar_mercode);
        home_invitepar_img = findViewById(R.id.home_invitepar_img);
        user_name_tv = findViewById(R.id.user_name_tv);
        user_phone_tv = findViewById(R.id.user_phone_tv);

        user_name_tv.setText(getNikeName());
        user_phone_tv.setText(getUserName());
        initSound();
        presenter.inviteParData();

    }

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.screen, 1);
    }

    @Override
    protected void initListener() {
        iv_back.setOnClickListener(this);
        home_invitepar_tv_save.setOnClickListener(this);
    }

    @Override
    public void showInvite(InvitePartnersBean bean) {
        merchCode = bean.getData().getMerchCode();
        url = bean.getData().getUrl();
        home_inviterpar_mercode.setText("邀请码" + merchCode);
        getOrCode();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.home_invitepar_tv_save: // 截屏
                //隐藏不截屏的控件
                home_invitepar_tv_save.setVisibility(View.GONE);
                iv_back.setVisibility(View.GONE);
                //音效
                playSound();
                View dView = this.getWindow().getDecorView();
                dView.destroyDrawingCache();
                dView.setDrawingCacheEnabled(false);
                dView.buildDrawingCache();
                //截屏完显示不截屏的控件
                home_invitepar_tv_save.setVisibility(View.VISIBLE);
                iv_back.setVisibility(View.VISIBLE);
                Bitmap bitmap = Bitmap.createBitmap(dView.getDrawingCache());
                if (bitmap != null) {
                    if (saveImageToGallery(this, bitmap)) {
                        showToast("截图保存成功");
                    }
                }
        }
    }

    private void playSound() {
        soundPool.play(
                soundID,
                0.1f,      //左耳道音量【0~1】
                0.5f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }


    /**
     * 生成二维码
     */
    public void getOrCode() {
        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.app_iso);
        home_invitepar_img.setImageBitmap(CodeCreator.createQRCode(url + "?id=" + merchCode, 400, 400, logo));

    }
}