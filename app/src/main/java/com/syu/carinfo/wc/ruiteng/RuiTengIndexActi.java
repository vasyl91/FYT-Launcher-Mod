package com.syu.carinfo.wc.ruiteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RuiTengIndexActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 75:
                    RuiTengIndexActi.this.mUpdaterValue3();
                    RuiTengIndexActi.this.mUpdaterValue4();
                    break;
                case 76:
                    RuiTengIndexActi.this.mUpdaterValue3();
                    RuiTengIndexActi.this.mUpdaterValue4();
                    break;
                case 79:
                    RuiTengIndexActi.this.mUpdaterValue2();
                    break;
                case 86:
                    RuiTengIndexActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_ruiteng_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_btn_show_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengLight.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_btn_meter_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengMeterAct.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_air_conditioning_control)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengAirControlActi.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_btn_functional_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengFuncSettings.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengOilAct.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_alarm_record)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengWarningInfo.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 131354) {
            findViewById(R.id.wc_ruiteng_main_btn_airsystem_set_view).setVisibility(0);
        } else {
            findViewById(R.id.wc_ruiteng_main_btn_airsystem_set_view).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_airsystem_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengIndexActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTeng17YearAirSystemSet.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[86];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)) != null) {
            if (value != 0) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[79];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value1 = DataCanbus.DATA[76];
        int value2 = DataCanbus.DATA[75];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)) != null) {
            if (value1 == 1 || value2 == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value1 = DataCanbus.DATA[76];
        int value2 = DataCanbus.DATA[75];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)) != null) {
            if (value1 == 1 || value2 == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(8);
            }
        }
    }
}
