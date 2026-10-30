package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.RZCBMWPanelButtonSet;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCBmwX3CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.RZCBmwX3CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (((CheckedTextView) RZCBmwX3CarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCBmwX3CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    }
                    break;
                case 119:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text2)).setText("Not Supported");
                            break;
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text2)).setText("Supported");
                            break;
                    }
                    break;
                case 120:
                    switch (value) {
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("Screen 6.5");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("Screen 8.8");
                            break;
                        case 3:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("Screen 10.25");
                            break;
                        default:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                    }
                    break;
                case 122:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text3)).setText("Default");
                            break;
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text3)).setText("Interactive");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text3)).setText("Independence");
                            break;
                    }
                    break;
                case 138:
                    switch (value) {
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text4)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text4)).setText("Draw");
                            break;
                    }
                    break;
                case 139:
                    switch (value) {
                        case 4:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1920x1080@30Hz");
                            break;
                        case 5:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1920x1080@25Hz");
                            break;
                        case 6:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1280x720@25Hz");
                            break;
                    }
                    break;
                case 151:
                    if ((value & 128) != 0) {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text6)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 152:
                    if ((value & 128) != 0) {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text7)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0051_rzc_bmw_x3_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_BMW_320i_05_12 /* 3145779 */:
            case FinalCanbus.CAR_RZC_BMW_320i_05_12_H /* 3211315 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[120];
                if (value > 0) {
                    value--;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[120];
                if (value2 < 3) {
                    value2++;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[119];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[119];
                if (value4 < 1) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[122];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[122];
                if (value6 < 2) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[138] - 1;
                if (value7 < 1) {
                    value7 = 2;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[138] + 1;
                if (value8 > 2) {
                    value8 = 1;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[139] - 1;
                if (value9 < 4) {
                    value9 = 7;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[139] + 1;
                if (value10 > 7) {
                    value10 = 4;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                setCarInfo(7, 1);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                setCarInfo(7, 2);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                setCarInfo(8, 1);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                setCarInfo(8, 2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value11 = DataCanbus.DATA[118];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(0, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(5, new int[]{161}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(5, new int[]{177}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCBMWPanelButtonSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }
}
