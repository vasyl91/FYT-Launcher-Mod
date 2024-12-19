package com.syu.carinfo.rzc.mingjueruiteng;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityRZCRongWeiRX5 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityRZCRongWeiRX5.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 44:
                    ActivityRZCRongWeiRX5.this.updateDisplay1(value);
                    break;
                case 45:
                    ActivityRZCRongWeiRX5.this.updateDisplay2(value);
                    break;
                case 46:
                    ActivityRZCRongWeiRX5.this.updateDisplay3(value);
                    break;
                case 47:
                    ActivityRZCRongWeiRX5.this.updateDisplay4(value);
                    break;
                case 48:
                    ActivityRZCRongWeiRX5.this.updateDisplay5(value);
                    break;
                case 59:
                    ((CheckedTextView) ActivityRZCRongWeiRX5.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    break;
                case 80:
                    ((CheckedTextView) ActivityRZCRongWeiRX5.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_273_rzc_rongwei_rx5);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        for (int i = 44; i <= 48; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        for (int i = 44; i <= 48; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value3 = DataCanbus.DATA[59];
                if (value3 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfoCmd(8, 1, value2);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value4 = DataCanbus.DATA[80];
                if (value4 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfoCmd(1, 1, value);
                break;
            case R.id.rzc_ruiteng_speed_lock /* 2131429037 */:
                this.value = DataCanbus.DATA[44];
                setCarInfoCmd(3, 1, this.value == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_auto_unlock /* 2131429038 */:
                this.value = DataCanbus.DATA[45];
                setCarInfoCmd(3, 2, this.value != 0 ? 0 : 1);
                break;
            case R.id.rzc_ruiteng_unlock_mode /* 2131429040 */:
                this.value = DataCanbus.DATA[46];
                setCarInfoCmd(1, 3, this.value == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_unlock_nearcar /* 2131429042 */:
                this.value = DataCanbus.DATA[47];
                setCarInfoCmd(1, 4, this.value == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_home_light_backcar /* 2131429051 */:
                this.value = DataCanbus.DATA[48];
                if (this.value == 0) {
                    creatShowDialog();
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay1(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay2(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.rzc_ruiteng_auto_unlock_tv)) != null) {
            ((TextView) findViewById(R.id.rzc_ruiteng_auto_unlock_tv)).setText(value != 0 ? R.string.klc_remote_Remote_control_latch_light_Speaker : R.string.klc_remote_Remote_control_latch_only_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay3(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(value != 0 ? R.string.wc_ruiteng_string_unlock_mode_1 : R.string.wc_ruiteng_string_unlock_mode_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay4(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(value != 0 ? R.string.wc_ruiteng_string_unlock_mode_1 : R.string.wc_ruiteng_string_unlock_mode_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay5(int value) {
        if (((TextView) findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)).setTextColor(-7829368);
            } else {
                ((TextView) findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)).setTextColor(-16777216);
            }
        }
    }

    private void creatShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityRZCRongWeiRX5.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityRZCRongWeiRX5.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityRZCRongWeiRX5.this.setCarInfoCmd(4, 1, 1);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityRZCRongWeiRX5.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarInfoCmd(int cmdCode, int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{cmdCode, value1, value2}, null, null);
    }
}
