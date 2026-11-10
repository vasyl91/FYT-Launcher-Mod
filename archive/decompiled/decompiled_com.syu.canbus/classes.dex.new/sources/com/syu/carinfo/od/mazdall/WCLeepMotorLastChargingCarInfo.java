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
public class WCLeepMotorLastChargingCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorLastChargingCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
                case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                    switch (updateCode) {
                        case 134:
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                            }
                            break;
                        case 135:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 136:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 137:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 138:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 139:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                            }
                            break;
                    }
                    break;
                default:
                    switch (updateCode) {
                        case 108:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 109:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 110:
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                            }
                            break;
                        case 111:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 112:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                            }
                            break;
                        case 113:
                            if (value == 255) {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
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
        setContentView(R.layout.layout_0443_wc_leepmotor_lastcharge_carinfo);
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
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                DataCanbus.PROXY.cmd(0, new int[]{67, 0}, null, null);
                DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
                break;
        }
    }
}
