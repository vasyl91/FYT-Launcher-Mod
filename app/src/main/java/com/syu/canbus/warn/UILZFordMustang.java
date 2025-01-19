package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UILZFordMustang {
    private static UILZFordMustang mInstance;
    Context context;
    private View sWarnContent;

    public static UILZFordMustang getInstance() {
        if (mInstance == null) {
            mInstance = new UILZFordMustang();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[171] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_lz_mustang_autopark, null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{4}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[2], null, null);
                }
            });
        }
        switch (updateCode) {
            case 170:
                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_ford_autopark_1_n);
                this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_ford_autopark_2_n);
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_ford_autopark_3_n);
                this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_ford_autopark_4_n);
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("");
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_ford_autopark_4_p);
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_parallel_parking);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText(R.string.str_parallel_parking);
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_ford_autopark_1_p);
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_vertical_parking);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText(R.string.str_vertical_parking);
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_ford_autopark_2_p);
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_parallel_mooring);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText(R.string.str_parallel_mooring);
                        this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_ford_autopark_3_p);
                        break;
                }
            case 172:
                switch (value) {
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ford_autopark_state_1);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请使用转向信号选择泊车方位");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("请使用转向信号选择泊车方位");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("泊车功能不可用");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("泊车功能不可用");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("松开方向盘");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("松开方向盘换倒档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换倒档");
                        break;
                    case 4:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("倒车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("倒车，准备停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                        break;
                    case 5:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("控制好方向盘");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("控制好方向盘");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 6:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ford_autopark_state_8);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("正在搜索左侧的泊车位,前进");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("正在搜索左侧的泊车位,前进,使用转向信号搜索右侧");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("使用转向信号搜索右侧");
                        break;
                    case 7:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请脱离倒档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("请脱离倒档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 8:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ford_autopark_state_6);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("正在搜索右侧的泊车位,前进");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("正在搜索右侧的泊车位,前进,使用转向信号搜索左侧");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("使用转向信号搜索左侧");
                        break;
                    case 9:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("已经找到合适的泊车位置");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("已经找到合适的泊车位置");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 10:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("继续向前开");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("继续向前开");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 11:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("自动泊车成功");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("自动泊车成功");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 12:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ford_autopark_state_c);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("右侧");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("右侧");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 13:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_ford_autopark_state_d);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("左侧");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("左侧");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 14:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请降低速度进行搜索");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("请降低速度进行搜索");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 15:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请减速");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("请减速");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 16:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("故障");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("故障");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 17:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("主动泊车辅助已被驾驶员取消");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("主动泊车辅助已被驾驶员取消");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 18:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("按下泊车辅助按钮 松开方向盘 ");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("按下泊车辅助按钮 松开方向盘 继续泊车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("继续泊车");
                        break;
                    case 19:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("主动泊车已禁止");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("主动泊车已禁止");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 20:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车，请换前进档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("请换前进档");
                        break;
                    case 21:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("缓速前进 ");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("缓速前进 准备停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                        break;
                    case 22:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车 ");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车 换倒档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换倒档");
                        break;
                    case 23:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("缓速倒车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("缓速倒车 准备停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                        break;
                    case 24:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("松开方向盘");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("松开方向盘换前进档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换前进档");
                        break;
                    case 25:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("向前行驶");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("向前行驶 准备停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                        break;
                    case 26:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车 ");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车 换至倒档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换至倒档");
                        break;
                    case 27:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("找到泊车位");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("找到泊车位前进");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("前进");
                        break;
                    case 28:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("找到泊车位 ");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("找到泊车位 停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("停车");
                        break;
                    case 29:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("找到泊车位 松开方向盘 ");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("找到泊车位 松开方向盘 换倒档");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换倒档");
                        break;
                    case 30:
                        this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.icon_car_null);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                }
            case 173:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(0);
                    break;
                } else {
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(0);
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
