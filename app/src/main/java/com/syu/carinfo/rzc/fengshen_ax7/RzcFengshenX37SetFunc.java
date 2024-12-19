package com.syu.carinfo.rzc.fengshen_ax7;

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
public class RzcFengshenX37SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenX37SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                    if (((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_technology_blue);
                                break;
                            case 1:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_bright_gold);
                                break;
                            case 2:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 61:
                    if (((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 2:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            case 3:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_31);
                                break;
                            case 4:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_3);
                                break;
                            default:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_1);
                                break;
                        }
                    }
                    break;
                case 62:
                    if (((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text2)).setText("Purple gold");
                                break;
                            default:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text2)).setText("Disk");
                                break;
                        }
                    }
                    break;
                case 66:
                    RzcFengshenX37SetFunc.this.setCheck((CheckedTextView) RzcFengshenX37SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_fengshen_x37_setfunc);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[66];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(36, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = (DataCanbus.DATA[60] + 1) - 1;
                if (value2 < 1) {
                    value2 = 3;
                }
                setCarInfo(35, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[60] + 1 + 1;
                if (value3 > 3) {
                    value3 = 1;
                }
                setCarInfo(35, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[62] - 1;
                if (value4 < 1) {
                    value4 = 2;
                }
                setCarInfo(38, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[62] + 1;
                if (value5 > 2) {
                    value5 = 1;
                }
                setCarInfo(38, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[61] - 1;
                if (value6 < 1) {
                    value6 = 4;
                }
                setCarInfo(37, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[61] + 1;
                if (value7 > 4) {
                    value7 = 1;
                }
                setCarInfo(37, value7);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
    }
}
