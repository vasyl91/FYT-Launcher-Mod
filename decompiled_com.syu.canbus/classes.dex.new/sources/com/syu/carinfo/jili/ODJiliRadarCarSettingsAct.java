package com.syu.carinfo.jili;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODJiliRadarCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliRadarCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 286:
                    ODJiliRadarCarSettingsAct.this.setCheck((CheckedTextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 287:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 288:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_sport);
                            break;
                        case 2:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_comfort);
                            break;
                        case 3:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_17_snow);
                            break;
                        case 4:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_mud_ruts);
                            break;
                        case 5:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_17_off_road);
                            break;
                    }
                    break;
                case 289:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_c4l_open);
                            break;
                        case 2:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_always_open);
                            break;
                    }
                    break;
                case 290:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("30s");
                            break;
                        case 1:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("60s");
                            break;
                        case 2:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("90s");
                            break;
                    }
                    break;
                case 291:
                    ODJiliRadarCarSettingsAct.this.setCheck((CheckedTextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 292:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        case 1:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                    break;
                case 293:
                    ODJiliRadarCarSettingsAct.this.setCheck((CheckedTextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 294:
                    ODJiliRadarCarSettingsAct.this.setCheck((CheckedTextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 295:
                    ODJiliRadarCarSettingsAct.this.setCheck((CheckedTextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 296:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("CLTC");
                            break;
                        case 1:
                            ((TextView) ODJiliRadarCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("WLTP");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_jili_radar_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[287] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(7, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[287] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(7, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[288] - 1;
                if (value3 < 0) {
                    value3 = 5;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[288] + 1;
                if (value4 > 5) {
                    value4 = 0;
                }
                setCarInfo(0, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[289] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[289] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[290] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(11, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[290] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(11, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[292] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[292] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[296] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(12, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[296] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(12, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(10, DataCanbus.DATA[286] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(1, DataCanbus.DATA[294] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(2, DataCanbus.DATA[294] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(6, DataCanbus.DATA[291] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(3, DataCanbus.DATA[293] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ODJiliRadarCarEVInfAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(40, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[290].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[290].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
    }
}
