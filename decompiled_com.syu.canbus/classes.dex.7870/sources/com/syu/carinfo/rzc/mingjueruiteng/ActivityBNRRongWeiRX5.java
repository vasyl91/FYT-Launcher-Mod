package com.syu.carinfo.rzc.mingjueruiteng;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ActivityBNRRongWeiRX5 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityBNRRongWeiRX5.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ActivityBNRRongWeiRX5.this.updateDisplay1(value);
                    break;
                case 99:
                    ActivityBNRRongWeiRX5.this.updateDisplay2(value);
                    break;
                case 100:
                    ActivityBNRRongWeiRX5.this.updateDisplay3(value);
                    break;
                case 101:
                    ActivityBNRRongWeiRX5.this.updateDisplay4(value);
                    break;
                case 102:
                    ActivityBNRRongWeiRX5.this.updateDisplay6(value);
                    break;
                case 103:
                    ActivityBNRRongWeiRX5.this.updateDisplay5(value);
                    break;
                case 104:
                    ActivityBNRRongWeiRX5.this.updateDisplay7(value);
                    break;
                case 105:
                    ActivityBNRRongWeiRX5.this.updateDisplay8(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_439_bnr_rongwei_rx5);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
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
        for (int i = 98; i <= 105; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeNotify() {
        for (int i = 98; i <= 105; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[105];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[105];
                if (value2 < 3) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value2}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                setCarInfoCmd(0, DataCanbus.DATA[98] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                setCarInfoCmd(3, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setCarInfoCmd(4, DataCanbus.DATA[102] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                setCarInfoCmd(1, DataCanbus.DATA[99] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                setCarInfoCmd(2, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                if (DataCanbus.DATA[103] == 0) {
                    creatShowDialog();
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                setCarInfoCmd(6, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay8(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_factory_settings_select_models_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("梦幻蓝");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("激情红");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("炫光金");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay6(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay1(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay7(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(value != 0 ? R.string.distance_far : R.string.distance_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay2(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(value != 0 ? R.string.klc_remote_Remote_control_latch_light_Speaker : R.string.klc_remote_Remote_control_latch_only_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay3(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(value != 0 ? R.string.wc_ruiteng_string_unlock_mode_1 : R.string.wc_ruiteng_string_unlock_mode_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplay4(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(value != 0 ? R.string.wc_ruiteng_string_unlock_mode_1 : R.string.wc_ruiteng_string_unlock_mode_0);
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityBNRRongWeiRX5.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityBNRRongWeiRX5.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityBNRRongWeiRX5.this.setCarInfoCmd(5, 1);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityBNRRongWeiRX5.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarInfoCmd(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }
}
