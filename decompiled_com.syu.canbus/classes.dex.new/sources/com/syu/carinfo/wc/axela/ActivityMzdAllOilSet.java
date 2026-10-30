package com.syu.carinfo.wc.axela;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityMzdAllOilSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllOilSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 166:
                    if (((TextView) ActivityMzdAllOilSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ActivityMzdAllOilSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 169:
                    ActivityMzdAllOilSet.this.setCheck((CheckedTextView) ActivityMzdAllOilSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 177:
                    if (((TextView) ActivityMzdAllOilSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityMzdAllOilSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_mzd_oil_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[166] - 500;
                if (value < 1000) {
                    value = 1000;
                }
                setCarInfo(7, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[166] + Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B54;
                if (value2 > 99500) {
                    value2 = 99500;
                }
                setCarInfo(7, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value3 = DataCanbus.DATA[169];
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                setCarInfo(6, value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                dialog(R.string.str_motoroil_change, 255, 3);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(8, new int[]{value1, value2}, null, null);
    }

    protected void dialog(int stringId, final int cmd, final int cmd1) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllOilSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = cmd1;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllOilSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(8, new int[]{i, i2}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllOilSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
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
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }
}
