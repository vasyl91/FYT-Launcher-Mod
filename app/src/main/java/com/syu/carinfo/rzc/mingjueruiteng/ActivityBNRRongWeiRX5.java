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

public class ActivityBNRRongWeiRX5 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_bnr_rongwei_rx5);
        ((Button) findViewById(R.id.accord9_low_btn_yibiao_color_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_yibiao_color_sub)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_eco_drive_mode)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_system_vol)).setOnClickListener(this);
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
        for (int i = 98; i <= 105; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeNotify() {
        for (int i = 98; i <= 105; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rzc_ruiteng_speed_lock /* 2131429002 */:
                setCarInfoCmd(0, DataCanbus.DATA[98] != 0 ? 0 : 1);
                break;
            case R.id.rzc_ruiteng_auto_unlock /* 2131429003 */:
                setCarInfoCmd(1, DataCanbus.DATA[99] == 0 ? 1 : 0);
                break;
            case R.id.rzc_ruiteng_unlock_mode /* 2131429005 */:
                setCarInfoCmd(2, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.rzc_ruiteng_unlock_nearcar /* 2131429007 */:
                setCarInfoCmd(3, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.rzc_ruiteng_home_light_backcar /* 2131429016 */:
                if (DataCanbus.DATA[103] == 0) {
                    creatShowDialog();
                    break;
                }
            case R.id.rzc_ruiteng_eco_drive_mode /* 2131430056 */:
                setCarInfoCmd(4, DataCanbus.DATA[102] != 0 ? 0 : 1);
                break;
            case R.id.rzc_ruiteng_system_vol /* 2131430057 */:
                setCarInfoCmd(6, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
            case R.id.accord9_low_btn_yibiao_color_sub /* 2131430059 */:
                int value = DataCanbus.DATA[105];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value}, null, null);
                break;
            case R.id.accord9_low_btn_yibiao_color_add /* 2131430061 */:
                int value2 = DataCanbus.DATA[105];
                if (value2 < 3) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value2}, null, null);
                break;
        }
    }

    
    public void updateDisplay8(int value) {
        if (((TextView) findViewById(R.id.accord9_low_tv_yibiao_color)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.accord9_low_tv_yibiao_color)).setText(R.string.wc_psa_all_factory_settings_select_models_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.accord9_low_tv_yibiao_color)).setText("梦幻蓝");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.accord9_low_tv_yibiao_color)).setText("激情红");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.accord9_low_tv_yibiao_color)).setText("炫光金");
                    break;
            }
        }
    }

    
    public void updateDisplay6(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_eco_drive_mode)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_eco_drive_mode)).setChecked(value != 0);
        }
    }

    
    public void updateDisplay1(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setChecked(value != 0);
        }
    }

    
    public void updateDisplay7(int value) {
        if (((CheckedTextView) findViewById(R.id.rzc_ruiteng_system_vol)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_ruiteng_system_vol)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_system_vol_tv)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_system_vol_tv)).setText(value != 0 ? R.string.distance_far : R.string.distance_close);
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
                        ActivityBNRRongWeiRX5.this.setCarInfoCmd(5, 1);
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

    
    public void setCarInfoCmd(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }
}
