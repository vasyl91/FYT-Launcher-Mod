package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408EVMilePage3Acti extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408EVMilePage3Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 296:
                    ((TextView) RZC_BZ408EVMilePage3Acti.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value / 60)).toString());
                    ((TextView) RZC_BZ408EVMilePage3Acti.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value % 60)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_psa_ev3_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int hour = DataCanbus.DATA[296] / 60;
                int min = DataCanbus.DATA[296] % 60;
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                int value = (hour2 * 60) + min;
                DataCanbus.PROXY.cmd(100, new int[]{1, (value >> 8) & 255, value & 255}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int hour3 = DataCanbus.DATA[296] / 60;
                int min2 = DataCanbus.DATA[296] % 60;
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                int value2 = (hour4 * 60) + min2;
                DataCanbus.PROXY.cmd(100, new int[]{1, (value2 >> 8) & 255, value2 & 255}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int hour5 = DataCanbus.DATA[296] / 60;
                int min3 = (DataCanbus.DATA[296] % 60) - 1;
                if (min3 < 0) {
                    min3 = 59;
                }
                int value3 = (hour5 * 60) + min3;
                DataCanbus.PROXY.cmd(100, new int[]{1, (value3 >> 8) & 255, value3 & 255}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int hour6 = DataCanbus.DATA[296] / 60;
                int min4 = (DataCanbus.DATA[296] % 60) + 1;
                if (min4 > 59) {
                    min4 = 0;
                }
                int value4 = (hour6 * 60) + min4;
                DataCanbus.PROXY.cmd(100, new int[]{1, (value4 >> 8) & 255, value4 & 255}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(70, new int[]{82}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
    }
}
