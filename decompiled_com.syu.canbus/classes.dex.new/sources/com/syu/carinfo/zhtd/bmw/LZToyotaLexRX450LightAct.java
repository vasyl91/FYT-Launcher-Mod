package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZToyotaLexRX450LightAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZToyotaLexRX450LightAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    LZToyotaLexRX450LightAct.this.setCheck((CheckedTextView) LZToyotaLexRX450LightAct.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 154:
                    ((TextView) LZToyotaLexRX450LightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 155:
                    ((TextView) LZToyotaLexRX450LightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 156:
                    ((TextView) LZToyotaLexRX450LightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 157:
                    ((TextView) LZToyotaLexRX450LightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_bba_fwlight_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int d0_b7 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b70 = DataCanbus.DATA[154];
                int d2_b70 = DataCanbus.DATA[155];
                int d3_b70 = DataCanbus.DATA[156];
                int d4_b70 = DataCanbus.DATA[157];
                int d1_b71 = d1_b70 - 5;
                if (d1_b71 < 0) {
                    d1_b71 = 0;
                }
                setCarInfo((d0_b7 << 7) & 128, d1_b71, d2_b70, d3_b70, d4_b70);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int d0_b8 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b72 = DataCanbus.DATA[154];
                int d2_b71 = DataCanbus.DATA[155];
                int d3_b71 = DataCanbus.DATA[156];
                int d4_b71 = DataCanbus.DATA[157];
                int d1_b73 = d1_b72 + 5;
                if (d1_b73 > 100) {
                    d1_b73 = 100;
                }
                setCarInfo((d0_b8 << 7) & 128, d1_b73, d2_b71, d3_b71, d4_b71);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int d0_b9 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b74 = DataCanbus.DATA[154];
                int d2_b72 = DataCanbus.DATA[155];
                int d3_b72 = DataCanbus.DATA[156];
                int d4_b72 = DataCanbus.DATA[157];
                int d2_b73 = d2_b72 - 10;
                if (d2_b73 < 0) {
                    d2_b73 = 0;
                }
                setCarInfo((d0_b9 << 7) & 128, d1_b74, d2_b73, d3_b72, d4_b72);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int d0_b10 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b75 = DataCanbus.DATA[154];
                int d2_b74 = DataCanbus.DATA[155];
                int d3_b73 = DataCanbus.DATA[156];
                int d4_b73 = DataCanbus.DATA[157];
                int d2_b75 = d2_b74 + 10;
                if (d2_b75 > 255) {
                    d2_b75 = 255;
                }
                setCarInfo((d0_b10 << 7) & 128, d1_b75, d2_b75, d3_b73, d4_b73);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int d0_b11 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b76 = DataCanbus.DATA[154];
                int d2_b76 = DataCanbus.DATA[155];
                int d3_b74 = DataCanbus.DATA[156];
                int d4_b74 = DataCanbus.DATA[157];
                int d3_b75 = d3_b74 - 10;
                if (d3_b75 < 0) {
                    d3_b75 = 0;
                }
                setCarInfo((d0_b11 << 7) & 128, d1_b76, d2_b76, d3_b75, d4_b74);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int d0_b12 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b77 = DataCanbus.DATA[154];
                int d2_b77 = DataCanbus.DATA[155];
                int d3_b76 = DataCanbus.DATA[156];
                int d4_b75 = DataCanbus.DATA[157];
                int d3_b77 = d3_b76 + 10;
                if (d3_b77 > 255) {
                    d3_b77 = 255;
                }
                setCarInfo((d0_b12 << 7) & 128, d1_b77, d2_b77, d3_b77, d4_b75);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int d0_b13 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b78 = DataCanbus.DATA[154];
                int d2_b78 = DataCanbus.DATA[155];
                int d3_b78 = DataCanbus.DATA[156];
                int d4_b76 = DataCanbus.DATA[157] - 10;
                if (d4_b76 < 0) {
                    d4_b76 = 0;
                }
                setCarInfo((d0_b13 << 7) & 128, d1_b78, d2_b78, d3_b78, d4_b76);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int d0_b14 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b79 = DataCanbus.DATA[154];
                int d2_b79 = DataCanbus.DATA[155];
                int d3_b79 = DataCanbus.DATA[156];
                int d4_b77 = DataCanbus.DATA[157] + 10;
                if (d4_b77 > 255) {
                    d4_b77 = 255;
                }
                setCarInfo((d0_b14 << 7) & 128, d1_b79, d2_b79, d3_b79, d4_b77);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int d0_b15 = (DataCanbus.DATA[153] >> 7) & 1;
                int d1_b710 = DataCanbus.DATA[154];
                int d2_b710 = DataCanbus.DATA[155];
                int d3_b710 = DataCanbus.DATA[156];
                int d4_b78 = DataCanbus.DATA[157];
                if (d0_b15 == 1) {
                    d0_b15 = 0;
                } else if (d0_b15 == 0) {
                    d0_b15 = 1;
                }
                setCarInfo((d0_b15 << 7) & 128, d1_b710, d2_b710, d3_b710, d4_b78);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(57, new int[]{value1, value2, value3, value4, value5}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }
}
