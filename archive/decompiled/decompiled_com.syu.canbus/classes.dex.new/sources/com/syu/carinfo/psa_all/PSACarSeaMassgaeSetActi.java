package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class PSACarSeaMassgaeSetActi extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {247, 248, 249, 250};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSACarSeaMassgaeSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 247:
                    if (((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(DataCanbus.DATA[updateCode]).toString());
                    }
                    break;
                case 248:
                    if (((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(DataCanbus.DATA[updateCode]).toString());
                    }
                    break;
                case 249:
                    if (((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text11)) != null) {
                        switch (DataCanbus.DATA[updateCode]) {
                            case 0:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 250:
                    if (((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text13)) != null) {
                        switch (DataCanbus.DATA[updateCode]) {
                            case 0:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSACarSeaMassgaeSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_high);
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
        setContentView(R.layout.layout_psa_all_carseat_massage_set);
        registerListener();
    }

    public void registerListener() {
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus4 /* 2131427465 */:
                int value = DataCanbus.DATA[247] - 1;
                if (value < 1) {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(101, new int[]{29, value}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value2 = DataCanbus.DATA[247] + 1;
                if (value2 > 5) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{29, value2}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value3 = DataCanbus.DATA[249] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{31, value3}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value4 = DataCanbus.DATA[249] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{31, value4}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value5 = DataCanbus.DATA[248] - 1;
                if (value5 < 1) {
                    value5 = 5;
                }
                DataCanbus.PROXY.cmd(101, new int[]{30, value5}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value6 = DataCanbus.DATA[248] + 1;
                if (value6 > 5) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{30, value6}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value7 = DataCanbus.DATA[250] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{32, value7}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value8 = DataCanbus.DATA[250] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{32, value8}, null, null);
                break;
        }
    }
}
