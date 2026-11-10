package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_lz_mustang_autopark, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UILZFordMustang.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{2, 0}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UILZFordMustang.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{3, 0}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UILZFordMustang.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{4, 0}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UILZFordMustang.4
                @Override // android.view.View.OnClickListener
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
                break;
            case 172:
                Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
                String language = locale.getCountry();
                if (!language.endsWith("CN")) {
                    switch (value) {
                        case 1:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_1);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Select direction by the turn signal");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Select direction by the turn signal");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 2:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Parking function not available");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Parking function not available");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 3:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Release the steering wheel");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Release the steering wheel");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Shift to reverse gear");
                            break;
                        case 4:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Reverse");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Reverse,Prepare to park");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Prepare to park");
                            break;
                        case 5:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Control the steering wheel properly");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Control the steering wheel properly");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 6:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_8);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Searching for parking spaces on the left, move forward");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Searching for parking spaces on the left side, move forward and use turn signals to search for parking spaces on the right side");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Search for the right side using turn signals");
                            break;
                        case 7:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Please disengage from reverse gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Please disengage from reverse gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 8:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_6);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Searching for parking spaces on the right, move forward");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Searching for parking spaces on the right, move forward and use turn signals to search for parking spaces on the right side");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Search for the right side using turn signals");
                            break;
                        case 9:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Have found a suitable parking spot");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Have found a suitable parking spot");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 10:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Keep moving forward");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Keep moving forward");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 11:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Automatic parking successful");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Automatic parking successful");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 12:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_c);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Right side");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Right side");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 13:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_d);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Left side");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Left side");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 14:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Please slow down your search speed");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Please slow down your search speed");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 15:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Please slow down");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Please slow down");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 16:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Fault");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Fault");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 17:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Active parking assist has been cancelled by the driver");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Active parking assist has been cancelled by the driver");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 18:
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Press the parking assist button and release the steering wheel ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Press the parking assist button, release the steering wheel, and continue parking");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Continue parking");
                            break;
                        case 19:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Active parking is prohibited");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Active parking is prohibited");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 20:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Park");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Park, please shift to forward gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Please shift to forward gear");
                            break;
                        case 21:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Slow forward");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Slow down and prepare to stop");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Prepare to stop");
                            break;
                        case 22:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Park ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Park and shift to reverse gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Shift to reverse gear");
                            break;
                        case 23:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Slow reverse");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Slow reverse and prepare to stop");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Prepare to stop车");
                            break;
                        case 24:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Release the steering wheel");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Release the steering wheel and shift to forward gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Shift to forward gear");
                            break;
                        case 25:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Forward travel");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Drive forward and prepare to park");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Prepare to park");
                            break;
                        case 26:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Park ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Park and shift to reverse gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Shift to reverse gear");
                            break;
                        case 27:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Find a parking space");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Find a parking space and move forward");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Move forward");
                            break;
                        case 28:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Find a parking space ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Find a parking space and park");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Park");
                            break;
                        case 29:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Find the parking space and release the steering wheel ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Find the parking space, release the steering wheel and shift to reverse gear");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Shift to reverse gear");
                            break;
                        case 30:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Park");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("Park");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                    }
                } else {
                    switch (value) {
                        case 1:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_1);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("请使用转向信号选择泊车方位");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("请使用转向信号选择泊车方位");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 2:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
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
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_8);
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
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_6);
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
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("自动泊车成功");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("自动泊车成功");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 12:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_c);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("右侧");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("右侧");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 13:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_ford_autopark_state_d);
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
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("故障");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("故障");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 17:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
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
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("主动泊车已禁止");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("主动泊车已禁止");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 20:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车，请换前进档");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("请换前进档");
                            break;
                        case 21:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("缓速前进 ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("缓速前进 准备停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                            break;
                        case 22:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车 ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车 换倒档");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换倒档");
                            break;
                        case 23:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("缓速倒车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("缓速倒车 准备停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                            break;
                        case 24:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("松开方向盘");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("松开方向盘换前进档");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换前进档");
                            break;
                        case 25:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("向前行驶");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("向前行驶 准备停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("准备停车");
                            break;
                        case 26:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车 ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车 换至倒档");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换至倒档");
                            break;
                        case 27:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("找到泊车位");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("找到泊车位前进");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("前进");
                            break;
                        case 28:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("找到泊车位 ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("找到泊车位 停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("停车");
                            break;
                        case 29:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("找到泊车位 松开方向盘 ");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("找到泊车位 松开方向盘 换倒档");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("换倒档");
                            break;
                        case 30:
                            ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.icon_car_null);
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("停车");
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                            break;
                    }
                }
                break;
            case 173:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(0);
                } else {
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(0);
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
