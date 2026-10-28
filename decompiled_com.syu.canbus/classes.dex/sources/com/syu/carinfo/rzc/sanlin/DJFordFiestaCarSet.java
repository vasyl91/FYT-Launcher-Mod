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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DJFordFiestaCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.DJFordFiestaCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 22:
                    if (((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                        } else {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                        }
                    }
                    break;
                case 23:
                    if (((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                        } else {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                        }
                    }
                    break;
                case 24:
                    DJFordFiestaCarSet.this.setCheck((CheckedTextView) DJFordFiestaCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 25:
                    DJFordFiestaCarSet.this.setCheck((CheckedTextView) DJFordFiestaCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 26:
                    DJFordFiestaCarSet.this.setCheck((CheckedTextView) DJFordFiestaCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_dj_ford_fiesta_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int B7 = DataCanbus.DATA[22];
                int B6 = DataCanbus.DATA[23];
                int B5 = DataCanbus.DATA[24];
                int B4 = DataCanbus.DATA[25];
                int B3 = DataCanbus.DATA[26];
                if (B5 == 1) {
                    B5 = 0;
                } else if (B5 == 0) {
                    B5 = 1;
                }
                int value = ((B7 << 7) & 128) | ((B6 << 6) & 64) | ((B5 << 5) & 32) | ((B4 << 4) & 16) | ((B3 << 3) & 8);
                setCarInfo(value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
            case R.id.btn_plus1 /* 2131427482 */:
                int B8 = DataCanbus.DATA[22];
                int B9 = DataCanbus.DATA[23];
                int B10 = DataCanbus.DATA[24];
                int B11 = DataCanbus.DATA[25];
                int B12 = DataCanbus.DATA[26];
                if (B8 == 1) {
                    B8 = 0;
                } else if (B8 == 0) {
                    B8 = 1;
                }
                int value2 = ((B8 << 7) & 128) | ((B9 << 6) & 64) | ((B10 << 5) & 32) | ((B11 << 4) & 16) | ((B12 << 3) & 8);
                setCarInfo(value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
            case R.id.btn_plus2 /* 2131427486 */:
                int B13 = DataCanbus.DATA[22];
                int B14 = DataCanbus.DATA[23];
                int B15 = DataCanbus.DATA[24];
                int B16 = DataCanbus.DATA[25];
                int B17 = DataCanbus.DATA[26];
                if (B14 == 1) {
                    B14 = 0;
                } else if (B14 == 0) {
                    B14 = 1;
                }
                int value3 = ((B13 << 7) & 128) | ((B14 << 6) & 64) | ((B15 << 5) & 32) | ((B16 << 4) & 16) | ((B17 << 3) & 8);
                setCarInfo(value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int B18 = DataCanbus.DATA[22];
                int B19 = DataCanbus.DATA[23];
                int B20 = DataCanbus.DATA[24];
                int B21 = DataCanbus.DATA[25];
                int B22 = DataCanbus.DATA[26];
                if (B21 == 1) {
                    B21 = 0;
                } else if (B21 == 0) {
                    B21 = 1;
                }
                int value4 = ((B18 << 7) & 128) | ((B19 << 6) & 64) | ((B20 << 5) & 32) | ((B21 << 4) & 16) | ((B22 << 3) & 8);
                setCarInfo(value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int B23 = DataCanbus.DATA[22];
                int B24 = DataCanbus.DATA[23];
                int B25 = DataCanbus.DATA[24];
                int B26 = DataCanbus.DATA[25];
                int B27 = DataCanbus.DATA[26];
                if (B27 == 1) {
                    B27 = 0;
                } else if (B27 == 0) {
                    B27 = 1;
                }
                int value5 = ((B23 << 7) & 128) | ((B24 << 6) & 64) | ((B25 << 5) & 32) | ((B26 << 4) & 16) | ((B27 << 3) & 8);
                setCarInfo(value5);
                break;
        }
    }

    public void setCarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
    }
}
