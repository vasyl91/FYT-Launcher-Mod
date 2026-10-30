package com.syu.carinfo.rzc.baojun;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCWulingChargeSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.RZCWulingChargeSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                    RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                    RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                    RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view5).setVisibility(8);
                    switch (value) {
                        case 1:
                            RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view2).setVisibility(0);
                            RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                            ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("单次");
                            break;
                        case 2:
                            RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view2).setVisibility(0);
                            RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                            RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view4).setVisibility(0);
                            RZCWulingChargeSetFunc.this.findViewById(R.id.layout_view5).setVisibility(0);
                            ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("每天");
                            break;
                        default:
                            ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                    }
                    break;
                case 152:
                    ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 153:
                    ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 154:
                    ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 155:
                    ((TextView) RZCWulingChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0310_rzc_wuling_charge);
        setupView();
    }

    private void setupView() {
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
            case R.id.btn_minus1 /* 2131427456 */:
                int d0 = DataCanbus.DATA[151];
                int d1 = DataCanbus.DATA[152];
                int d2 = DataCanbus.DATA[153];
                int d3 = DataCanbus.DATA[154];
                int d4 = DataCanbus.DATA[155];
                int d5 = d0 - 1;
                if (d5 < 0) {
                    d5 = 2;
                }
                setCarInfo(d5, d1, d2, d3, d4);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int d6 = DataCanbus.DATA[151];
                int d7 = DataCanbus.DATA[152];
                int d8 = DataCanbus.DATA[153];
                int d9 = DataCanbus.DATA[154];
                int d10 = DataCanbus.DATA[155];
                int d11 = d6 + 1;
                if (d11 > 2) {
                    d11 = 0;
                }
                setCarInfo(d11, d7, d8, d9, d10);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int d12 = DataCanbus.DATA[151];
                int d13 = DataCanbus.DATA[152];
                int d14 = DataCanbus.DATA[153];
                int d15 = DataCanbus.DATA[154];
                int d16 = DataCanbus.DATA[155];
                int d17 = d13 - 1;
                if (d17 < 0) {
                    d17 = 23;
                }
                setCarInfo(d12, d17, d14, d15, d16);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int d18 = DataCanbus.DATA[151];
                int d19 = DataCanbus.DATA[152];
                int d20 = DataCanbus.DATA[153];
                int d21 = DataCanbus.DATA[154];
                int d22 = DataCanbus.DATA[155];
                int d23 = d19 + 1;
                if (d23 > 23) {
                    d23 = 0;
                }
                setCarInfo(d18, d23, d20, d21, d22);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int d24 = DataCanbus.DATA[151];
                int d25 = DataCanbus.DATA[152];
                int d26 = DataCanbus.DATA[153];
                int d27 = DataCanbus.DATA[154];
                int d28 = DataCanbus.DATA[155];
                int d29 = d26 - 5;
                if (d29 < 0) {
                    d29 = 55;
                }
                setCarInfo(d24, d25, d29, d27, d28);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int d30 = DataCanbus.DATA[151];
                int d31 = DataCanbus.DATA[152];
                int d32 = DataCanbus.DATA[153];
                int d33 = DataCanbus.DATA[154];
                int d34 = DataCanbus.DATA[155];
                int d35 = d32 + 5;
                if (d35 > 55) {
                    d35 = 0;
                }
                setCarInfo(d30, d31, d35, d33, d34);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int d36 = DataCanbus.DATA[151];
                int d37 = DataCanbus.DATA[152];
                int d38 = DataCanbus.DATA[153];
                int d39 = DataCanbus.DATA[154];
                int d40 = DataCanbus.DATA[155];
                int d41 = d39 - 1;
                if (d41 < 0) {
                    d41 = 23;
                }
                setCarInfo(d36, d37, d38, d41, d40);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int d42 = DataCanbus.DATA[151];
                int d43 = DataCanbus.DATA[152];
                int d44 = DataCanbus.DATA[153];
                int d45 = DataCanbus.DATA[154];
                int d46 = DataCanbus.DATA[155];
                int d47 = d45 + 1;
                if (d47 > 23) {
                    d47 = 0;
                }
                setCarInfo(d42, d43, d44, d47, d46);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int d48 = DataCanbus.DATA[151];
                int d49 = DataCanbus.DATA[152];
                int d50 = DataCanbus.DATA[153];
                int d51 = DataCanbus.DATA[154];
                int d52 = DataCanbus.DATA[155] - 5;
                if (d52 < 0) {
                    d52 = 55;
                }
                setCarInfo(d48, d49, d50, d51, d52);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int d53 = DataCanbus.DATA[151];
                int d54 = DataCanbus.DATA[152];
                int d55 = DataCanbus.DATA[153];
                int d56 = DataCanbus.DATA[154];
                int d57 = DataCanbus.DATA[155] + 5;
                if (d57 > 55) {
                    d57 = 0;
                }
                setCarInfo(d53, d54, d55, d56, d57);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2, value3, value4, value5}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }
}
