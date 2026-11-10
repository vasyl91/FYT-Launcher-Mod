package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCLeepMotorCurrentCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorCurrentCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
                case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                    switch (updateCode) {
                        case 128:
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                            }
                            break;
                        case 129:
                            int hour = (value >> 8) & 255;
                            int min = value & 255;
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(hour / 10) + "H" + min + "M");
                            }
                            break;
                        case 130:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 131:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 132:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 133:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                            }
                            break;
                    }
                    break;
                default:
                    switch (updateCode) {
                        case 99:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 100:
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                            }
                            break;
                        case 101:
                            int hour2 = (value >> 8) & 65535;
                            int min2 = value & 255;
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(hour2 / 10) + "H" + min2 + "M");
                            }
                            break;
                        case 102:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 103:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 104:
                            if (value == 255) {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                            }
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_leepmotor_cur_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                DataCanbus.PROXY.cmd(0, new int[]{67, 0}, null, null);
                DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
                break;
        }
    }
}
