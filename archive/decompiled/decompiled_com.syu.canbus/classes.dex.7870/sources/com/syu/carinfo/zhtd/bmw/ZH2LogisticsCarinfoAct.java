package com.syu.carinfo.zhtd.bmw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ZH2LogisticsCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZH2LogisticsCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    if (value == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_park_p);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_park);
                    }
                    break;
                case 8:
                    switch (value) {
                        case 0:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text4)).setTextColor(Color.parseColor("#c8c8c8"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text4)).setText("Not Ready");
                            break;
                        case 1:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text4)).setTextColor(Color.parseColor("#34c759"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text4)).setText("Ready");
                            break;
                    }
                    break;
                case 9:
                    switch (value) {
                        case 0:
                            ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view8)).setBackgroundResource(R.drawable.ic_pilotcar_gear_p);
                            break;
                        case 1:
                            ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view8)).setBackgroundResource(R.drawable.ic_pilotcar_gear_r);
                            break;
                        case 2:
                            ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view8)).setBackgroundResource(R.drawable.ic_pilotcar_gear_n);
                            break;
                        case 3:
                            ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view8)).setBackgroundResource(R.drawable.ic_pilotcar_gear_d);
                            break;
                    }
                    break;
                case 10:
                    int left = (value >> 0) & 1;
                    int right = (value >> 1) & 1;
                    int bit4 = (value >> 4) & 1;
                    int far = (value >> 3) & 1;
                    int near = (value >> 5) & 1;
                    int belt = (value >> 7) & 1;
                    if (left == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_pilotcar_leftlight);
                    }
                    if (right == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_pilotcar_rightlight);
                    }
                    if (near == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_pilotcar_short_light);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_pilotcar_short_light_p);
                    }
                    if (far == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.ic_pilotcar_far_light);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.ic_pilotcar_far_light_p);
                    }
                    if (bit4 == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view5)).setBackgroundResource(R.drawable.ic_pilotcar_park_light);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view5)).setBackgroundResource(R.drawable.ic_pilotcar_park_light_p);
                    }
                    if (belt == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view6)).setBackgroundResource(R.drawable.ic_pilotcar_belt);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view6)).setBackgroundResource(R.drawable.ic_pilotcar_belt_p);
                    }
                    break;
                case 13:
                    switch (value) {
                        case 0:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#34c759"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Normal");
                            break;
                        case 1:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#c8c8c8"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Level1");
                            break;
                        case 2:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#3b96d9"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Level2");
                            break;
                        case 3:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#f59e0b"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Level3");
                            break;
                        case 4:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#f26c22"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Level4");
                            break;
                        case 5:
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#e53333"));
                            ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Level5");
                            break;
                    }
                    break;
                case 14:
                    ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 15:
                    if (value >= 500) {
                        int value2 = value - 500;
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "A");
                    } else {
                        int value3 = 500 - value;
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text6)).setText("  -" + (value3 / 10) + "." + (value3 % 10) + "A");
                    }
                    break;
                case 16:
                    ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view14).setVisibility(8);
                    ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view15).setVisibility(8);
                    ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view16).setVisibility(8);
                    if (value < 20) {
                        ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view16).setVisibility(0);
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-65536);
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                        ((ProgressBar) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view16)).setProgress((value * 8) / 10);
                        ((ProgressBar) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view16)).invalidate();
                    } else if (value < 50) {
                        ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view15).setVisibility(0);
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-256);
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                        ((ProgressBar) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view15)).setProgress((value * 8) / 10);
                        ((ProgressBar) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view15)).invalidate();
                    } else {
                        ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view14).setVisibility(0);
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-16711936);
                        ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                        ((ProgressBar) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view14)).setProgress((value * 8) / 10);
                        ((ProgressBar) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view14)).invalidate();
                    }
                    break;
                case 17:
                    ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km");
                    break;
                case 18:
                case 21:
                case 23:
                case 24:
                case 25:
                    ZH2LogisticsCarinfoAct.this.updateWarnInfo();
                    break;
                case 19:
                    ZH2LogisticsCarinfoAct.this.updateWarnInfo();
                    int bit3 = (value >> 3) & 1;
                    if (bit3 == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view7)).setBackgroundResource(R.drawable.ic_ht002_doorlock_n);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view7)).setBackgroundResource(R.drawable.ic_ht002_doorlock_p);
                    }
                    break;
                case 20:
                    ZH2LogisticsCarinfoAct.this.updateWarnInfo();
                    int bit0 = (value >> 0) & 1;
                    if (bit0 == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.ic_ht002_abs_n);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.ic_ht002_abs_p);
                    }
                    int bit1 = (value >> 1) & 1;
                    if (bit1 == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view12)).setBackgroundResource(R.drawable.ic_ht002_ebd_n);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view12)).setBackgroundResource(R.drawable.ic_ht002_ebd_p);
                    }
                    int bit7 = (value >> 7) & 1;
                    if (bit7 == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view13)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view13)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode_p);
                    }
                    break;
                case 22:
                    ZH2LogisticsCarinfoAct.this.updateWarnInfo();
                    int bit6 = (value >> 6) & 1;
                    if (bit6 == 0) {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view9)).setBackgroundResource(R.drawable.ic_ht002_tirewarn_n);
                    } else {
                        ((ImageView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.layout_view9)).setBackgroundResource(R.drawable.ic_ht002_tirewarn_p);
                    }
                    break;
                case 26:
                    ((TextView) ZH2LogisticsCarinfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_0456_zh_logistics_dashboard);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
    }

    public void updateWarnInfo() {
        int data0 = DataCanbus.DATA[18];
        int data1 = DataCanbus.DATA[19];
        int data2 = DataCanbus.DATA[20];
        int data3 = DataCanbus.DATA[21];
        int data4 = DataCanbus.DATA[22];
        int data5 = DataCanbus.DATA[23];
        int data6 = DataCanbus.DATA[24];
        int data7 = DataCanbus.DATA[25];
        if (data0 != 0 || data1 != 0 || data2 != 0 || data3 != 0 || data4 != 0 || data5 != 0 || data6 != 0 || data7 != 0) {
            findViewById(R.id.tv_text9).setVisibility(0);
        } else {
            findViewById(R.id.tv_text9).setVisibility(8);
        }
        if (((data0 >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("智能钥匙电量低");
        }
        if (((data0 >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("ESCL auth failure");
        }
        if (((data0 >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("PEPS 钥匙验证失败");
        }
        if (((data0 >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("启动按钮故障");
        }
        if (((data0 >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("智能钥匙离开车内");
        }
        if (((data0 >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("启动备用IMMO认证");
        }
        if (((data0 >> 6) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("PEPS_智能钥匙搜索失败");
        }
        if (((data0 >> 7) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("PEPS_电源继电器错误");
        }
        if (((data1 >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("PEPS_ECU 故障");
        }
        if (((data1 >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("启动时不在P档");
        }
        if (((data1 >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("请踩刹车启动");
        }
        if (((data1 >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("防盗指示灯报警");
        }
        if (((data2 >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("防抱死系统故障");
        }
        if (((data2 >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("EBD 系统故障");
        }
        if (((data2 >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("EPB 声音报警");
        }
        if (((data2 >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("光感器传感错误");
        }
        if (((data2 >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("雨水传感器错误");
        }
        if (((data2 >> 5) & 3) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("High speed no shift");
        }
        if (((data2 >> 5) & 3) == 2) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Block shift Please brake");
        }
        if (((data2 >> 7) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("跛行模式报警");
        }
        if (((data3 >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("运行模式切换失败");
        }
        if (((data3 >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("控制器过温");
        }
        if (((data3 >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("电机过温");
        }
        if (((data3 >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("车辆限速");
        }
        if (((data3 >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("高压互锁");
        }
        if (((data3 >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("快充枪和慢充枪同时接入");
        }
        if (((data3 >> 6) & 3) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("动力电池热扩散:Failure");
        }
        if (((data4 >> 0) & 7) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("助力故障请停车检修");
        }
        if (((data4 >> 0) & 7) == 2) {
            ((TextView) findViewById(R.id.tv_text9)).setText("助力故障请停车检修");
        }
        if (((data4 >> 0) & 7) == 3) {
            ((TextView) findViewById(R.id.tv_text9)).setText("助力不足请减速慢行");
        }
        if (((data4 >> 0) & 7) == 4) {
            ((TextView) findViewById(R.id.tv_text9)).setText("高原路况请减速慢行");
        }
        if (((data4 >> 3) & 3) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("真空助力器压力：Warning");
        }
        if (((data4 >> 3) & 3) == 2) {
            ((TextView) findViewById(R.id.tv_text9)).setText("真空助力器压力： Serious Warning");
        }
        if (((data4 >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("制动液位低");
        }
        if (((data4 >> 6) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("胎压报警");
        }
        if (((data5 >> 0) & 15) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please charge in time");
        }
        if (((data5 >> 0) & 15) == 2) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please check if the gear is correct");
        }
        if (((data5 >> 0) & 15) == 3) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please check if the key in the car");
        }
        if (((data5 >> 0) & 15) == 4) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please check the Tire Pressure");
        }
        if (((data5 >> 0) & 15) == 5) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please close the door for your safety");
        }
        if (((data5 >> 0) & 15) == 6) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please close the door");
        }
        if (((data5 >> 0) & 15) == 7) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Please fasten your seat belt");
        }
        if (((data5 >> 0) & 15) == 7) {
            ((TextView) findViewById(R.id.tv_text9)).setText("You are speeding");
        }
        if (((data5 >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("ESC 功能故障");
        }
        if (((data5 >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("TCS 功能故障");
        }
        if (((data5 >> 6) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("SAS_CAN 通讯故障");
        }
        if (((data5 >> 7) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("SAS 内部故障");
        }
        if (((data6 >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("电源故障");
        }
        if (((data6 >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("转角传感器角度故障");
        }
        if (((data6 >> 2) & 3) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("压缩机运转");
        }
        if (((data6 >> 2) & 3) == 3) {
            ((TextView) findViewById(R.id.tv_text9)).setText("压缩机故障");
        }
        if (((data6 >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("左前轮速度故障");
        }
        if (((data6 >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("右前轮速度故障");
        }
        if (((data6 >> 6) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("左后轮速度故障");
        }
        if (((data6 >> 7) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("右后轮速度故障");
        }
        if (((data7 >> 0) & 255) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Over Current");
        }
        if (((data7 >> 0) & 255) == 2) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Over Voltage");
        }
        if (((data7 >> 0) & 255) == 4) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Under Voltage");
        }
        if (((data7 >> 0) & 255) == 8) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Standby over voltage");
        }
        if (((data7 >> 0) & 255) == 16) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Standby under voltage");
        }
        if (((data7 >> 0) & 255) == 32) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Communication Error");
        }
        if (((data7 >> 0) & 255) == 64) {
            ((TextView) findViewById(R.id.tv_text9)).setText("Over Current Drop Frequency");
        }
    }
}
