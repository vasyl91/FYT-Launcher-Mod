package com.syu.carinfo.rzc.mazda;

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
public class Rzc_Mazda_CarAmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarAmpSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 92:
                    if (((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 6) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text1)).setText("+" + (12 - value));
                            break;
                        } else if (value < 6) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text1)).setText("-" + (value - 6));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 93:
                    if (((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 6) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text2)).setText("+" + (12 - value));
                            break;
                        } else if (value < 6) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text2)).setText("-" + (value - 6));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 94:
                    if (((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 8) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text3)).setText("+" + (16 - value));
                            break;
                        } else if (value < 8) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text3)).setText("-" + (value - 8));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 95:
                    if (((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 8) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text4)).setText("+" + (16 - value));
                            break;
                        } else if (value < 8) {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text4)).setText("-" + (value - 8));
                            break;
                        } else {
                            ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 96:
                    if (((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 97:
                    if (((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 98:
                    Rzc_Mazda_CarAmpSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    Rzc_Mazda_CarAmpSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarAmpSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_mazda_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[98];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarAmpInfo(7, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarAmpInfo(1, 129);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarAmpInfo(1, 1);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarAmpInfo(2, 129);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarAmpInfo(2, 1);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarAmpInfo(3, 129);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarAmpInfo(3, 1);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarAmpInfo(4, 129);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarAmpInfo(4, 1);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarAmpInfo(5, 129);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarAmpInfo(5, 1);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarAmpInfo(6, 129);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarAmpInfo(6, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value2 = DataCanbus.DATA[99];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarAmpInfo(8, value2);
                break;
        }
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{112}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
