package com.syu.carinfo.qirui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DaojunQiruiCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qirui.DaojunQiruiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
                    DaojunQiruiCarSet.this.updateText1(val);
                    break;
                case 24:
                    DaojunQiruiCarSet.this.updateText2(val);
                    break;
                case 25:
                    DaojunQiruiCarSet.this.setCheck((CheckedTextView) DaojunQiruiCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 26:
                    DaojunQiruiCarSet.this.setCheck((CheckedTextView) DaojunQiruiCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 27:
                    DaojunQiruiCarSet.this.setCheck((CheckedTextView) DaojunQiruiCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 28:
                    DaojunQiruiCarSet.this.setCheck((CheckedTextView) DaojunQiruiCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 29:
                    DaojunQiruiCarSet.this.updateText3(val);
                    break;
                case 30:
                    DaojunQiruiCarSet.this.updateText4(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_daojun_qirui_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[25];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[23] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[23] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[24] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[24] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[29];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[29];
                if (value7 < 23) {
                    value7++;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[30];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[30];
                if (value9 < 60) {
                    value9++;
                }
                setCarInfo(7, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value10 = DataCanbus.DATA[26];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(3, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value11 = DataCanbus.DATA[27];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(4, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value12 = DataCanbus.DATA[28];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(5, value12);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_sounds);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_light);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_lightsounds);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_close);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_language_set1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_language_set0);
                    break;
            }
        }
    }
}