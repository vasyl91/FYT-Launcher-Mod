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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class DJFordFiestaCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.DJFordFiestaCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                        } else {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                        }
                    }
                    break;
                case 99:
                    if (((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                        } else {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                        }
                    }
                    break;
                case 100:
                    DJFordFiestaCarSet.this.setCheck((CheckedTextView) DJFordFiestaCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 101:
                    DJFordFiestaCarSet.this.setCheck((CheckedTextView) DJFordFiestaCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 102:
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
            case R.id.btn_minus1 /* 2131427456 */:
            case R.id.btn_plus1 /* 2131427458 */:
                int B7 = DataCanbus.DATA[98];
                int B6 = DataCanbus.DATA[99];
                int B5 = DataCanbus.DATA[100];
                int B4 = DataCanbus.DATA[101];
                int B3 = DataCanbus.DATA[102];
                if (B7 == 1) {
                    B7 = 0;
                } else if (B7 == 0) {
                    B7 = 1;
                }
                int value = ((B7 << 7) & 128) | ((B6 << 6) & 64) | ((B5 << 5) & 32) | ((B4 << 4) & 16) | ((B3 << 3) & 8);
                setCarInfo(value);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
            case R.id.btn_plus2 /* 2131427461 */:
                int B8 = DataCanbus.DATA[98];
                int B9 = DataCanbus.DATA[99];
                int B10 = DataCanbus.DATA[100];
                int B11 = DataCanbus.DATA[101];
                int B12 = DataCanbus.DATA[102];
                if (B9 == 1) {
                    B9 = 0;
                } else if (B9 == 0) {
                    B9 = 1;
                }
                int value2 = ((B8 << 7) & 128) | ((B9 << 6) & 64) | ((B10 << 5) & 32) | ((B11 << 4) & 16) | ((B12 << 3) & 8);
                setCarInfo(value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int B13 = DataCanbus.DATA[98];
                int B14 = DataCanbus.DATA[99];
                int B15 = DataCanbus.DATA[100];
                int B16 = DataCanbus.DATA[101];
                int B17 = DataCanbus.DATA[102];
                if (B15 == 1) {
                    B15 = 0;
                } else if (B15 == 0) {
                    B15 = 1;
                }
                int value3 = ((B13 << 7) & 128) | ((B14 << 6) & 64) | ((B15 << 5) & 32) | ((B16 << 4) & 16) | ((B17 << 3) & 8);
                setCarInfo(value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int B18 = DataCanbus.DATA[98];
                int B19 = DataCanbus.DATA[99];
                int B20 = DataCanbus.DATA[100];
                int B21 = DataCanbus.DATA[101];
                int B22 = DataCanbus.DATA[102];
                if (B21 == 1) {
                    B21 = 0;
                } else if (B21 == 0) {
                    B21 = 1;
                }
                int value4 = ((B18 << 7) & 128) | ((B19 << 6) & 64) | ((B20 << 5) & 32) | ((B21 << 4) & 16) | ((B22 << 3) & 8);
                setCarInfo(value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int B23 = DataCanbus.DATA[98];
                int B24 = DataCanbus.DATA[99];
                int B25 = DataCanbus.DATA[100];
                int B26 = DataCanbus.DATA[101];
                int B27 = DataCanbus.DATA[102];
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }
}
