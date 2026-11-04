package com.syu.carinfo.wc.ruijie15;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class WCYiboCarSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.WCYiboCarSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 121:
                    WCYiboCarSetAct.this.updaterTrationCtrl();
                    break;
                case 122:
                    WCYiboCarSetAct.this.updaterTurnLight();
                    break;
                case 123:
                    WCYiboCarSetAct.this.updaterMilieoLight();
                    break;
                case 124:
                    WCYiboCarSetAct.this.updaterMeasurUnit();
                    break;
                case 125:
                    WCYiboCarSetAct.this.updaterMessagePrompt();
                    break;
                case 126:
                    WCYiboCarSetAct.this.updaterWarnPrompt();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc2_yibo_car_set);
        setUI();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value = DataCanbus.DATA[122];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 3, value}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value2 = DataCanbus.DATA[125];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 6, value2}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value3 = DataCanbus.DATA[126];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 7, value3}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value4 = DataCanbus.DATA[124];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 5, value4}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value5 = DataCanbus.DATA[123];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 4, value5}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value6 = DataCanbus.DATA[121];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{138, 3, value6}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                dialog(R.string.str_suzuki_alerts7, 31);
                break;
        }
    }

    protected void dialog(int stringId, int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.ruijie15.WCYiboCarSetAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.ruijie15.WCYiboCarSetAct.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{138, 5, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.ruijie15.WCYiboCarSetAct.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.ruijie15.WCYiboCarSetAct.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{138, 5, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void setUI() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnPrompt() {
        int value = DataCanbus.DATA[126];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMessagePrompt() {
        int value = DataCanbus.DATA[125];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMeasurUnit() {
        int value = DataCanbus.DATA[124];
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMilieoLight() {
        int value = DataCanbus.DATA[123];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrationCtrl() {
        int value = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTurnLight() {
        int value = DataCanbus.DATA[122];
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
