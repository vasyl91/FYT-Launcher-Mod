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
public class ODJiliICONCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliICONCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 327:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("运动");
                            break;
                        case 2:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("舒适");
                            break;
                        case 3:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("智能");
                            break;
                    }
                    break;
                case 328:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 329:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("流星效果");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("普通效果");
                            break;
                    }
                    break;
                case 330:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("30s");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("60s");
                            break;
                        case 2:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("90s");
                            break;
                    }
                    break;
                case 331:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 332:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 333:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("主驾车门");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("所有车门");
                            break;
                    }
                    break;
                case 334:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("锁车自动关窗");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("长按钥匙自动升窗");
                            break;
                    }
                    break;
                case 335:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("灯光和声音");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("灯光");
                            break;
                    }
                    break;
                case 336:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 337:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 338:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 339:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("随驾驶模式联动");
                            break;
                        case 1:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("随车律动");
                            break;
                        case 2:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("呼吸模式");
                            break;
                        case 3:
                            ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("自定义");
                            break;
                    }
                    break;
                case 340:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 341:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 342:
                    ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 343:
                    ((TextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 344:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 345:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 346:
                    ODJiliICONCarSettingsAct.this.setCheck((CheckedTextView) ODJiliICONCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_od_jili_icon_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
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
                int value = DataCanbus.DATA[327] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[327] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[329] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[329] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[330] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(11, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[330] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(11, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[333] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[334] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[335] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(17, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[339] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(32, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[342] + 1;
                if (value11 > 10) {
                    value11 = 1;
                }
                setCarInfo(30, value11);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[343] + 1;
                if (value12 > 72) {
                    value12 = 1;
                }
                setCarInfo(31, value12);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value13 = DataCanbus.DATA[333] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(16, value13);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value14 = DataCanbus.DATA[334] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(6, value14);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value15 = DataCanbus.DATA[335] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(17, value15);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value16 = DataCanbus.DATA[339] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(32, value16);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value17 = DataCanbus.DATA[342] - 1;
                if (value17 < 1) {
                    value17 = 10;
                }
                setCarInfo(30, value17);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[343] - 1;
                if (value18 < 1) {
                    value18 = 72;
                }
                setCarInfo(31, value18);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfo(2, DataCanbus.DATA[328] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfo(14, DataCanbus.DATA[336] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setCarInfo(10, DataCanbus.DATA[337] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfo(19, DataCanbus.DATA[331] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfo(15, DataCanbus.DATA[332] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                setCarInfo(7, DataCanbus.DATA[338] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                setCarInfo(33, DataCanbus.DATA[340] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                setCarInfo(40, DataCanbus.DATA[341] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                setCarInfo(41, DataCanbus.DATA[344] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                setCarInfo(42, DataCanbus.DATA[345] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                setCarInfo(43, DataCanbus.DATA[346] != 1 ? 1 : 0);
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
        DataCanbus.NOTIFY_EVENTS[327].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[328].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[329].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[330].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[331].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[332].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[333].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[334].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[335].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[336].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[337].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[338].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[339].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[341].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[342].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[343].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[344].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[345].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[346].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[327].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[328].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[329].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[330].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[331].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[332].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[333].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[334].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[335].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[336].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[337].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[338].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[339].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[341].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[342].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[343].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[344].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[345].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[346].removeNotify(this.mNotifyCanbus);
    }
}
