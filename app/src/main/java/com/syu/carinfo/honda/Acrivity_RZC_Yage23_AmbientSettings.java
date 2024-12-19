package com.syu.carinfo.honda;

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
public class Acrivity_RZC_Yage23_AmbientSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_RZC_Yage23_AmbientSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 233:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text1)).setText(R.string.str_theme_colors);
                                break;
                            default:
                                ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text1)).setText(R.string.str_recommended_colors);
                                break;
                        }
                    }
                    break;
                case 234:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 235:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 236:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 237:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 238:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 239:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 240:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 241:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 242:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 243:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0298_rzc_yage23_lightsettings);
        setListener();
    }

    private void setListener() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[236] == 0) {
                    value7 = 2;
                } else {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{16, value7}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[233] - 1;
                if (value8 < 1) {
                    value8 = 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, value8}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[233] + 1;
                if (value9 > 2) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, value9}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[234] - 1;
                if (value10 < 1) {
                    value10 = 10;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, value10}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[234] + 1;
                if (value11 > 10) {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, value11}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[235] - 1;
                if (value12 < 1) {
                    value12 = 10;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, value12}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[235] + 1;
                if (value13 > 10) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, value13}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[243] - 1;
                if (value14 < 10) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{48, value14}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[243] + 1;
                if (value15 > 10) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{48, value15}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[237] == 0) {
                    value6 = 2;
                } else {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{17, value6}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[238] == 0) {
                    value5 = 2;
                } else {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{18, value5}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[239] == 0) {
                    value4 = 2;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{19, value4}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[240] == 0) {
                    value3 = 2;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{20, value3}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                if (DataCanbus.DATA[241] == 0) {
                    value2 = 2;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{21, value2}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                if (DataCanbus.DATA[242] == 0) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{22, value}, null, null);
                break;
        }
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
    }
}
