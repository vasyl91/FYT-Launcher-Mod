package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODChangChengOulaCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODChangChengOulaCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("3s");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("10s");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("20s");
                            break;
                        case 4:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("30s");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text1)).setText("3s");
                            break;
                    }
                case 88:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("60s");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("120s");
                            break;
                        case 4:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("180s");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                    }
                case 89:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("10min");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("20min");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("30min");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text3)).setText("10min");
                            break;
                    }
                case 90:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf((value * 100) / 250) + "%");
                    break;
                case 91:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text6)).setText("电量正常");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text6)).setText("电量充足");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text6)).setText("电量低");
                            break;
                    }
                case 92:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 64) + "km");
                    break;
                case 93:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_normal);
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_0);
                            break;
                    }
                case 94:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + "km/kWh");
                    break;
                case 95:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + "km/kWh");
                    break;
                case 96:
                    ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "kW");
                    break;
                case 97:
                    switch (value) {
                        case 1:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("车辆预充电加热");
                            break;
                        case 2:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("车辆边充电边加热");
                            break;
                        case 3:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("车辆正常充电");
                            break;
                        case 4:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("能量回收");
                            break;
                        case 5:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("就绪");
                            break;
                        default:
                            ((TextView) ODChangChengOulaCarInfo.this.findViewById(R.id.tv_text11)).setText("正常行驶");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_changcheng_oula_carinfo);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[87] - 1;
                if (value < 1) {
                    value = 4;
                }
                setCarInfo(4, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[87] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                setCarInfo(4, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[88] - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                setCarInfo(5, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[88] + 1;
                if (value4 > 4) {
                    value4 = 1;
                }
                setCarInfo(5, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[89] - 1;
                if (value5 < 1) {
                    value5 = 3;
                }
                setCarInfo(6, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[89] + 1;
                if (value6 > 3) {
                    value6 = 1;
                }
                setCarInfo(6, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[93] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(48, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[93] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(48, value8, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }
}
