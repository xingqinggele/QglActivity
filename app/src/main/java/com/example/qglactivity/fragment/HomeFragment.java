package com.example.qglactivity.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qglactivity.activity.EquipmentActivity;
import com.example.qglactivity.activity.HomeMessageActivity;
import com.example.qglactivity.activity.InvitePartnersActivity;
import com.example.qglactivity.activity.MerchantsActivity;
import com.example.qglactivity.activity.TeamActivity;
import com.example.qglactivity.base.BaseFragment;
import com.example.qglactivity.R;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.cusview.MeSwipeRefreshLayout;
import com.example.qglactivity.cusview.RealNameDialog;
import com.example.qglactivity.presenter.HomePresenter;
import com.example.qglactivity.util.GlideImageLoader;
import com.example.qglactivity.view.HomeView;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者: qgl
 * 创建日期：2021/10/27
 * 描述:首页
 */
public class HomeFragment extends BaseFragment<HomePresenter, HomeView> implements HomeView, View.OnClickListener {
    //入驻状态，1实名2未实名
    private String Code = "1";
    private Banner home_top_banner;
    private Banner center_banner;
    private Banner bot_banner;
    private TextView home_name_tv;
    private ImageView home_message;
    private TextView home_me_merchants;
    private TextView home_invite_partners;
    private TextView home_my_partner;
    private TextView home_terminal_management;
    private TextView home_list;
    private TextView home_real_name;
    private TextView home_gift_bag;
    private TextView home_integral;
    private TextView home_price;
    private TextView home_new_partner;
    private TextView home_new_merchants;
    private MeSwipeRefreshLayout home_swipe;
    private List<HomeAdvBean.Data0Bean> beanList0 = new ArrayList<>();
    private List<HomeAdvBean.Data1Bean> beanList1 = new ArrayList<>();
    private List<HomeAdvBean.Data2Bean> beanList2 = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_home;
    }

    @Override
    protected void init(View view) {
        home_top_banner = view.findViewById(R.id.home_top_banner);
        center_banner = view.findViewById(R.id.center_banner);
        bot_banner = view.findViewById(R.id.bot_banner);
        home_name_tv = view.findViewById(R.id.home_name_tv);
        home_message = view.findViewById(R.id.home_message);
        home_me_merchants = view.findViewById(R.id.home_me_merchants);
        home_invite_partners = view.findViewById(R.id.home_invite_partners);
        home_my_partner = view.findViewById(R.id.home_my_partner);
        home_terminal_management = view.findViewById(R.id.home_terminal_management);
        home_list = view.findViewById(R.id.home_list);
        home_real_name = view.findViewById(R.id.home_real_name);
        home_gift_bag = view.findViewById(R.id.home_gift_bag);
        home_integral = view.findViewById(R.id.home_integral);
        home_price = view.findViewById(R.id.home_price);
        home_new_partner = view.findViewById(R.id.home_new_partner);
        home_new_merchants = view.findViewById(R.id.home_new_merchants);
        home_swipe = view.findViewById(R.id.home_swipe);
        home_top_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (!beanList0.get(position).getNewsUrl().equals("")) {
//                    Intent intent = new Intent(getActivity(), HomeAdvPictureActivity.class);
//                    intent.putExtra("title", beanList0.get(position).getNewsTitle());
//                    intent.putExtra("iv", beanList0.get(position).getNewsUrl());
//                    startActivity(intent);
                }
            }
        });
        center_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
//                Intent intent = new Intent(getActivity(), HomeAdvPictureActivity.class);
//                intent.putExtra("title", "信用卡申请");
//                intent.putExtra("iv", "https://cykj-1303987307.cos.ap-beijing.myqcloud.com/advertising/bankadetail2.png");
//                startActivity(intent);
            }
        });
        bot_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (!beanList2.get(position).getNewsUrl().equals("")) {
//                    Intent intent = new Intent(getActivity(), HomeAdvPictureActivity.class);
//                    intent.putExtra("title", beanList2.get(position).getNewsTitle());
//                    intent.putExtra("iv", beanList2.get(position).getNewsUrl());
//                    startActivity(intent);
                }
            }
        });

        home_message.setOnClickListener(this);
        //设置下拉框的样式
        SwipeData(home_swipe);
        presenter.HomePage(getUserId());
        presenter.HomeBanner();

        home_me_merchants.setOnClickListener(this);
        home_invite_partners.setOnClickListener(this);
        home_my_partner.setOnClickListener(this);
        home_terminal_management.setOnClickListener(this);

    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showHomeData(HomePageBean bean) {
        Code = "1";
        home_name_tv.setText("Hi，" + bean.getData().getNickName());
        home_price.setText(bean.getData().getMonthlyTransAmount().toPlainString());
        home_new_partner.setText(bean.getData().getMonthlyNewPartnerCounts() + "");
        home_new_merchants.setText(bean.getData().getMonthlyNewMerchantCounts() + "");
    }

    @Override
    public void showErrorMessage(String msg) {
        showToast(msg);
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
    public void BannerSuccess(HomeAdvBean bean) {
        beanList0 = new ArrayList<>();
        beanList1 = new ArrayList<>();
        beanList2 = new ArrayList<>();

        beanList0 = bean.getData0();
        beanList1 = bean.getData1();
        beanList2 = bean.getData2();

        List<String> top_list = new ArrayList<>();
        List<String> center_list = new ArrayList<>();
        List<String> bot_list = new ArrayList<>();
        for (int i = 0; i < beanList0.size(); i++) {
            top_list.add(beanList0.get(i).getAdvPicture());
        }
        setBanner(home_top_banner, top_list);

        for (int i = 0; i < beanList1.size(); i++) {
            center_list.add(beanList1.get(i).getAdvPicture());
        }
        setBanner(center_banner, center_list);

        for (int i = 0; i < beanList2.size(); i++) {
            bot_list.add(beanList2.get(i).getAdvPicture());
        }
        setBanner(bot_banner, bot_list);

    }

    @Override
    public void BannerFail(String message) {
        showToast(message);
    }

    @Override
    public void showProgress() {
        //显示加载框
        home_swipe.setRefreshing(true);
    }

    @Override
    public void downProgress() {
        //关闭加载框
        home_swipe.setRefreshing(false);
    }

    /**
     * 配置Banner数据
     *
     * @param banner
     * @param list
     */
    private void setBanner(Banner banner, List<String> list) {
        banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .setBannerAnimation(Transformer.Default)
                //设置轮播间隔时间
                .setDelayTime(5000)
                //设置是否为自动轮播，默认是“是”。
                .isAutoPlay(true)
                .start();
    }

    @Override
    public void onRefresh() {
        //进行刷新操作
        home_swipe.setRefreshing(true);
        //获取首页数据
        presenter.HomePage(getUserId());
        //请求广告图
        presenter.HomeBanner();
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

    @Override
    public void onClick(View view) {
        if (Code.equals("2")) {
            showDialog();
            return;
        }
        switch (view.getId()) {
            case R.id.home_message:
                startActivity(new Intent(getActivity(), HomeMessageActivity.class));
                break;
            case R.id.home_me_merchants:
                startActivity(new Intent(getActivity(), MerchantsActivity.class));
                break;
            case R.id.home_invite_partners:
                startActivity(new Intent(getActivity(), InvitePartnersActivity.class));
                break;
            case R.id.home_my_partner:
                startActivity(new Intent(getActivity(), TeamActivity.class));
                break;
            case R.id.home_terminal_management:
                startActivity(new Intent(getActivity(), EquipmentActivity.class));

                break;
            default:
                break;
        }
    }




}