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

public class ActivityRZCRongWeiRX5 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    ActivityRZCRongWeiRX5.this.updateDisplay1(value);
                    break;
                case 118:
                    ActivityRZCRongWeiRX5.this.updateDisplay2(value);
                    break;
                case 119:
                    ActivityRZCRongWeiRX5.this.updateDisplay3(value);
                    break;
                case 120:
                    ActivityRZCRongWeiRX5.this.updateDisplay4(value);
                    break;
                case 121:
                    ActivityRZCRongWeiRX5.this.updateDisplay5(value);
                    break;
                case 129:
                    ((CheckedTextView) ActivityRZCRongWeiRX5.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    break;
                case 149:
                    ((CheckedTextView) ActivityRZCRongWeiRX5.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    break;
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_273_rzc_rongwei_rx5);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        for (int i = 117; i <= 121; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        for (int i = 117; i <= 121; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value3 = DataCanbus.DATA[129];
                if (value3 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfoCmd(8, 1, value2);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value4 = DataCanbus.DATA[149];
                if (value4 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfoCmd(1, 1, value);
                break;
            case R.id.rzc_ruiteng_speed_lock /* 2131429002 */:
                this.value = DataCanbus.DATA[117];
                setCarInfoCmd(3, 1, this.value == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_auto_unlock /* 2131429003 */:
                this.value = DataCanbus.DATA[118];
                setCarInfoCmd(3, 2, this.value != 0 ? 0 : 1);
                break;
            case R.id.rzc_ruiteng_unlock_mode /* 2131429005 */:
                this.value = DataCanbus.DATA[119];
                setCarInfoCmd(1, 3, this.value == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_unlock_nearcar /* 2131429007 */:
                this.value = DataCanbus.DATA[120];
                setCarInfoCmd(1, 4, this.value == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_home_light_backcar /* 2131429016 */:
                this.value = DataCanbus.DATA[121];
                if (this.value == 0) {
                    creatShowDialog();
                    break;
                }
        }
    }

    
    public void updateDisplay1(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setChecked(value != 0);
        }
    }

    
    public void updateDisplay2(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.rzc_ruiteng_auto_unlock_tv)) != null) {
            ((TextView) findViewById(R.id.rzc_ruiteng_auto_unlock_tv)).setText(value != 0 ? R.string.klc_remote_Remote_control_latch_light_Speaker : R.string.klc_remote_Remote_control_latch_only_light);
        }
    }

    
    public void updateDisplay3(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(value != 0 ? R.string.wc_ruiteng_string_unlock_mode_1 : R.string.wc_ruiteng_string_unlock_mode_0);
        }
    }

    
    public void updateDisplay4(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(value != 0 ? R.string.wc_ruiteng_string_unlock_mode_1 : R.string.wc_ruiteng_string_unlock_mode_0);
        }
    }

    
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        ActivityRZCRongWeiRX5.this.setCarInfoCmd(4, 1, 1);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    
    public void setCarInfoCmd(int cmdCode, int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{cmdCode, value1, value2}, null, null);
    }
}
