package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class BaguVinFastCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.BaguVinFastCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) BaguVinFastCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) BaguVinFastCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_ba_vinfast4);
                                break;
                            case 1:
                                ((TextView) BaguVinFastCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_ba_vinfast5);
                                break;
                        }
                    }
                    break;
                case 100:
                    BaguVinFastCarSet.this.setCheck((CheckedTextView) BaguVinFastCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 101:
                    if (((TextView) BaguVinFastCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) BaguVinFastCarSet.this.findViewById(R.id.tv_text2)).setText("110km");
                                break;
                            case 1:
                                ((TextView) BaguVinFastCarSet.this.findViewById(R.id.tv_text2)).setText("220km");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_bagu_vinfast_carset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_ZH2_VinFast_VF2_Screen /* 12452296 */:
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value0 = DataCanbus.DATA[99];
                int value1 = DataCanbus.DATA[100];
                int value2 = DataCanbus.DATA[101];
                int value3 = value0 - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value3, value1, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value4 = DataCanbus.DATA[99];
                int value5 = DataCanbus.DATA[100];
                int value6 = DataCanbus.DATA[101];
                int value7 = value4 + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value7, value5, value6}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value8 = DataCanbus.DATA[99];
                int value9 = DataCanbus.DATA[100];
                int value10 = DataCanbus.DATA[101] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value8, value9, value10}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value11 = DataCanbus.DATA[99];
                int value12 = DataCanbus.DATA[100];
                int value13 = DataCanbus.DATA[101] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value11, value12, value13}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value14 = DataCanbus.DATA[99];
                int value15 = DataCanbus.DATA[100];
                int value16 = DataCanbus.DATA[101];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value14, value15, value16}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
