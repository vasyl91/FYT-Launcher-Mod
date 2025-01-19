package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UIXPPsaAutoPark {
    private static UIXPPsaAutoPark mInstance;
    Context context;
    private View sWarnContent;

    public static UIXPPsaAutoPark getInstance() {
        if (mInstance == null) {
            mInstance = new UIXPPsaAutoPark();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[216] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0281_xp_psa_autopark, null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(68, new int[]{1}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(68, new int[]{2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(68, new int[]{3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(68, new int[1], null, null);
                }
            });
        }
        switch (updateCode) {
            case 217:
                this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(8);
                this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(0);
                switch (value) {
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(8);
                        this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(0);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num02);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("请用转向灯指定停车方位");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("");
                        break;
                    case 3:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：进行中");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("限速8公里/小时");
                        break;
                    case 4:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：进行中");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请前进");
                        break;
                    case 5:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：进行中");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请倒车");
                        break;
                    case 6:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num06);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：已完成");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("恢复方向盘控制");
                        break;
                    case 7:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num07);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：已取消");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("恢复方向盘控制");
                        break;
                    case 8:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num08);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动驶出：进行中");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("限速5公里/小时");
                        break;
                    case 9:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num07);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动驶出：已取消");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("恢复方向盘控制");
                        break;
                    case 10:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num0a);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("测量中...");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("限速20公里/小时");
                        break;
                    case 11:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num0b);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请前进");
                        break;
                    case 12:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num0c);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请倒车");
                        break;
                    case 13:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num0d);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("测量中...");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("限速20公里/小时");
                        break;
                    case 14:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num0e);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请前进");
                        break;
                    case 15:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num0f);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请倒车");
                        break;
                    case 16:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num10);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("测量中...");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("限速20公里/小时");
                        break;
                    case 17:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num11);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请前进");
                        break;
                    case 18:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num12);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请倒车");
                        break;
                    case 19:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num13);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("测量中...");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("限速20公里/小时");
                        break;
                    case 20:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num14);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请前进");
                        break;
                    case 21:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num15);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动泊车：条件满足");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请倒车");
                        break;
                    case 22:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num16);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动驶出：已完成");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("恢复方向盘控制");
                        break;
                    case 23:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_psa_autopark_num17);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("自动驶出：已完成");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("恢复方向盘控制");
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
