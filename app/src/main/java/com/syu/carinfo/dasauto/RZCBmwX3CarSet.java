package com.syu.carinfo.dasauto;

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
public class RZCBmwX3CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.RZCBmwX3CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 57:
                    if (((CheckedTextView) RZCBmwX3CarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCBmwX3CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 58:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text2)).setText("Not Supported");
                            break;
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text2)).setText("Supported");
                            break;
                    }
                case 59:
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
                case 60:
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
                case 76:
                    switch (value) {
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text4)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text4)).setText("Draw");
                            break;
                    }
                case 77:
                    switch (value) {
                        case 6:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1280x720@25Hz");
                            break;
                    }
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[57];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[59];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[59];
                if (value3 < 3) {
                    value3++;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[58];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[58];
                if (value5 < 1) {
                    value5++;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[60];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[60];
                if (value7 < 2) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[76] - 1;
                if (value8 < 1) {
                    value8 = 2;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[76] + 1;
                if (value9 > 2) {
                    value9 = 1;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[77] - 1;
                if (value10 < 6) {
                    value10 = 7;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[77] + 1;
                if (value11 > 7) {
                    value11 = 6;
                }
                setCarInfo(6, value11);
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
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
    }
}
