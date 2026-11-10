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

@SuppressWarnings({"deprecation", "unchecked"})
public class Acrivity_RZC_Yage23_AmbientSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 270:
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
                case 271:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 272:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 273:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 274:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 275:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 276:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 277:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 278:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 279:
                    Acrivity_RZC_Yage23_AmbientSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 280:
                    if (((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Acrivity_RZC_Yage23_AmbientSettings.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0298_rzc_yage23_lightsettings);
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

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value8 = DataCanbus.DATA[270] - 1;
                if (value8 < 1) {
                    value8 = 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, value8}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value9 = DataCanbus.DATA[270] + 1;
                if (value9 > 2) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, value9}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value10 = DataCanbus.DATA[271] - 1;
                if (value10 < 1) {
                    value10 = 10;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, value10}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value11 = DataCanbus.DATA[271] + 1;
                if (value11 > 10) {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, value11}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value12 = DataCanbus.DATA[272] - 1;
                if (value12 < 1) {
                    value12 = 10;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, value12}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value13 = DataCanbus.DATA[272] + 1;
                if (value13 > 10) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, value13}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value14 = DataCanbus.DATA[280] - 1;
                if (value14 < 10) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{48, value14}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value15 = DataCanbus.DATA[280] + 1;
                if (value15 > 10) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{48, value15}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[273] == 0) {
                    value7 = 2;
                } else {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{16, value7}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[274] == 0) {
                    value6 = 2;
                } else {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{17, value6}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[275] == 0) {
                    value5 = 2;
                } else {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{18, value5}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[276] == 0) {
                    value4 = 2;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{19, value4}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[277] == 0) {
                    value3 = 2;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{20, value3}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[278] == 0) {
                    value2 = 2;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{21, value2}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[279] == 0) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{22, value}, null, null);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
    }
}
