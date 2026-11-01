package com.syu.carinfo.wc.axela;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityMzdAllMaintainanceCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllMaintainanceCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 165:
                    if (((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 166:
                    if (((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 167:
                    if (((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_open);
                        } else {
                            ((TextView) ActivityMzdAllMaintainanceCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_close);
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_mzd_maintainance_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_AKSL /* 721339 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX5 /* 786875 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX4 /* 917947 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_ATZ /* 983483 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_AKSL_20 /* 15270331 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_MZD2_20 /* 15335867 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            case FinalCanbus.CAR_439_OuDi_MZD_ALL /* 2097591 */:
            case FinalCanbus.CAR_439_BNR_MZD_ALL /* 8061367 */:
            case FinalCanbus.CAR_RZC_MZD_CX5_19 /* 15073719 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityMzdAllReserveSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                dialog(R.string.str_clear_alarm_information, 62);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, ActivityMzdAllTireChangeSet.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, ActivityMzdAllOilSet.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.str_clear_alarm_information)) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllMaintainanceCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllMaintainanceCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(6, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllMaintainanceCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllMaintainanceCarSet.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(6, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
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
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
    }
}
