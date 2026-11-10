package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODJiliVANCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliVANCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 347:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("舒适");
                            break;
                        case 1:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("运动");
                            break;
                    }
                    break;
                case 348:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("关闭");
                            break;
                        case 1:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                        case 2:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("60s");
                            break;
                        case 3:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("90s");
                            break;
                    }
                    break;
                case 349:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("所有车门");
                            break;
                        case 1:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("主驾车门");
                            break;
                    }
                    break;
                case 350:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("灯光+喇叭");
                            break;
                        case 1:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("灯光");
                            break;
                    }
                    break;
                case 351:
                    ODJiliVANCarSettingsAct.this.setCheck((CheckedTextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 352:
                    ODJiliVANCarSettingsAct.this.setCheck((CheckedTextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 353:
                    ODJiliVANCarSettingsAct.this.setCheck((CheckedTextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 354:
                    ODJiliVANCarSettingsAct.this.setCheck((CheckedTextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 355:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("低");
                            break;
                        case 1:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("中");
                            break;
                        case 2:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("高");
                            break;
                    }
                    break;
                case 356:
                    ODJiliVANCarSettingsAct.this.setCheck((CheckedTextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 357:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("日间");
                            break;
                        case 1:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("夜间");
                            break;
                        case 2:
                            ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("自定义");
                            break;
                    }
                    break;
                case 358:
                    ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 359:
                    ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 360:
                    ((TextView) ODJiliVANCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_od_jili_van_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[347] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[347] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[348] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[348] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[349] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[349] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[350] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[355] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(8, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[357] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(10, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[358] + 1;
                if (value10 > 10) {
                    value10 = 1;
                }
                setCarInfo(11, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[359] + 1;
                if (value11 > 12) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{12, 1, value11}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[360] + 1;
                if (value12 > 23) {
                    value12 = 13;
                }
                DataCanbus.PROXY.cmd(7, new int[]{12, 2, value12}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value13 = DataCanbus.DATA[350] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value14 = DataCanbus.DATA[355] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value15 = DataCanbus.DATA[357] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(10, value15);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value16 = DataCanbus.DATA[358] - 1;
                if (value16 < 1) {
                    value16 = 10;
                }
                setCarInfo(11, value16);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value17 = DataCanbus.DATA[359] - 1;
                if (value17 < 0) {
                    value17 = 12;
                }
                DataCanbus.PROXY.cmd(7, new int[]{12, 1, value17}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[360] - 1;
                if (value18 < 13) {
                    value18 = 23;
                }
                DataCanbus.PROXY.cmd(7, new int[]{12, 2, value18}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo(2, DataCanbus.DATA[351] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfo(7, DataCanbus.DATA[354] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setCarInfo(9, DataCanbus.DATA[356] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo(3, DataCanbus.DATA[352] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo(6, DataCanbus.DATA[353] != 1 ? 1 : 0);
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
        DataCanbus.NOTIFY_EVENTS[347].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[348].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[349].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[350].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[351].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[353].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[354].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[355].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[356].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[357].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[358].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[359].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[347].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[348].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[349].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[350].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[351].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[353].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[354].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[355].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[356].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[357].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[358].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[359].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
    }
}
