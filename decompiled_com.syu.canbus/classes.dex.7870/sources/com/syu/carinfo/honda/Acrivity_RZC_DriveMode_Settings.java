package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Acrivity_RZC_DriveMode_Settings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_RZC_DriveMode_Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 414:
                    if (((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.str_oil_signal_normal);
                                break;
                            case 3:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_economics);
                                break;
                            default:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 415:
                    if (((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text2)).setText(R.string.str_oil_signal_normal);
                                break;
                            default:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 416:
                    if (((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text3)).setText(R.string.str_oil_signal_normal);
                                break;
                            default:
                                ((TextView) Acrivity_RZC_DriveMode_Settings.this.findViewById(R.id.tv_text3)).setText(R.string.driver_system_sports);
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
        setContentView(R.layout.layout_0298_rzc_drivemode_settings);
        setListener();
    }

    private void setListener() {
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[414] - 1;
                if (value < 1) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{94, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[414] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{94, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[415] - 1;
                if (value3 < 1) {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(105, new int[]{95, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[415] + 1;
                if (value4 > 2) {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{95, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[416] - 1;
                if (value5 < 1) {
                    value5 = 2;
                }
                DataCanbus.PROXY.cmd(105, new int[]{102, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[416] + 1;
                if (value6 > 2) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{102, value6}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[414].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[415].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[416].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[417].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[414].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[415].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[416].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[417].removeNotify(this.mNotifyCanbus);
    }
}
