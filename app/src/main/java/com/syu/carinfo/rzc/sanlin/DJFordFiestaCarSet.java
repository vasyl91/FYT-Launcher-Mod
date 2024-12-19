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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                            break;
                        } else {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                            break;
                        }
                    }
                    break;
                case 23:
                    if (((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                            break;
                        } else {
                            ((TextView) DJFordFiestaCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                            break;
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
                int B72 = DataCanbus.DATA[22];
                int B62 = DataCanbus.DATA[23];
                int B52 = DataCanbus.DATA[24];
                int B42 = DataCanbus.DATA[25];
                int B32 = DataCanbus.DATA[26];
                if (B72 == 1) {
                    B72 = 0;
                } else if (B72 == 0) {
                    B72 = 1;
                }
                int value2 = ((B72 << 7) & 128) | ((B62 << 6) & 64) | ((B52 << 5) & 32) | ((B42 << 4) & 16) | ((B32 << 3) & 8);
                setCarInfo(value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
            case R.id.btn_plus2 /* 2131427486 */:
                int B73 = DataCanbus.DATA[22];
                int B63 = DataCanbus.DATA[23];
                int B53 = DataCanbus.DATA[24];
                int B43 = DataCanbus.DATA[25];
                int B33 = DataCanbus.DATA[26];
                if (B63 == 1) {
                    B63 = 0;
                } else if (B63 == 0) {
                    B63 = 1;
                }
                int value3 = ((B73 << 7) & 128) | ((B63 << 6) & 64) | ((B53 << 5) & 32) | ((B43 << 4) & 16) | ((B33 << 3) & 8);
                setCarInfo(value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int B74 = DataCanbus.DATA[22];
                int B64 = DataCanbus.DATA[23];
                int B54 = DataCanbus.DATA[24];
                int B44 = DataCanbus.DATA[25];
                int B34 = DataCanbus.DATA[26];
                if (B44 == 1) {
                    B44 = 0;
                } else if (B44 == 0) {
                    B44 = 1;
                }
                int value4 = ((B74 << 7) & 128) | ((B64 << 6) & 64) | ((B54 << 5) & 32) | ((B44 << 4) & 16) | ((B34 << 3) & 8);
                setCarInfo(value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int B75 = DataCanbus.DATA[22];
                int B65 = DataCanbus.DATA[23];
                int B55 = DataCanbus.DATA[24];
                int B45 = DataCanbus.DATA[25];
                int B35 = DataCanbus.DATA[26];
                if (B35 == 1) {
                    B35 = 0;
                } else if (B35 == 0) {
                    B35 = 1;
                }
                int value5 = ((B75 << 7) & 128) | ((B65 << 6) & 64) | ((B55 << 5) & 32) | ((B45 << 4) & 16) | ((B35 << 3) & 8);
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
