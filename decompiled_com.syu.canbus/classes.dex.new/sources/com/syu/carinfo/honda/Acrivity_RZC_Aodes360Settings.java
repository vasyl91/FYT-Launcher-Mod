package com.syu.carinfo.honda;

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
public class Acrivity_RZC_Aodes360Settings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_RZC_Aodes360Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 211:
                    Acrivity_RZC_Aodes360Settings.this.updateCamaMode(val);
                    break;
                case 212:
                    Acrivity_RZC_Aodes360Settings.this.updateCamaRearview(val);
                    break;
                case 213:
                    Acrivity_RZC_Aodes360Settings.this.updateLowSpeed(val);
                    break;
                case 214:
                    Acrivity_RZC_Aodes360Settings.this.updatePremode(val);
                    break;
                case 215:
                    Acrivity_RZC_Aodes360Settings.this.updateBackParkmode(val);
                    break;
                case 216:
                    Acrivity_RZC_Aodes360Settings.this.setCheck((CheckedTextView) Acrivity_RZC_Aodes360Settings.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 411:
                    if (((TextView) Acrivity_RZC_Aodes360Settings.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Acrivity_RZC_Aodes360Settings.this.findViewById(R.id.tv_text6)).setText("800*480");
                                break;
                            case 1:
                                ((TextView) Acrivity_RZC_Aodes360Settings.this.findViewById(R.id.tv_text6)).setText("2560*720");
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
        setContentView(R.layout.layout_0298_rzc_aodes_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value2 = DataCanbus.DATA[211] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{53, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[211] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{53, value3}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value4 = DataCanbus.DATA[105] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{54, value4}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value5 = DataCanbus.DATA[105] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{54, value5}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value6 = DataCanbus.DATA[213] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{55, value6}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value7 = DataCanbus.DATA[213] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{55, value7}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value8 = DataCanbus.DATA[214] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{56, value8}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value9 = DataCanbus.DATA[214] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{56, value9}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value10 = DataCanbus.DATA[215] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{57, value10}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value11 = DataCanbus.DATA[215] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{57, value11}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value12 = DataCanbus.DATA[411] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{99, value12}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value13 = DataCanbus.DATA[411] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{99, value13}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[216] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{58, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[411].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[411].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBackParkmode(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_narrow_zone_mode);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_wide_area_mode);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePremode(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_return_parking);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_parallel_parking);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLowSpeed(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_298_17crv_notdisplay);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_298_17crv_display);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCamaRearview(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_back_screen_and_panorama);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_previous_screen);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_back_camera_wide_angle);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_back_camera_standard);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCamaMode(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_forward_screen_and_panorama);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_previous_screen);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_forward_screen_only);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_left_and_right_screen);
                    break;
            }
        }
    }
}
