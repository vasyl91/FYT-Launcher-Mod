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
import com.syu.module.canbus.DataCanbus;

public class ActivityMzdAllReserveSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 163:
                    if (((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 164:
                    if (((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + ActivityMzdAllReserveSet.this.getResources().getString(R.string.str_months));
                        break;
                    }
                case 167:
                    ActivityMzdAllReserveSet.this.setCheck((CheckedTextView) ActivityMzdAllReserveSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 174:
                    if (((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 175:
                    if (((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text4)) != null) {
                        int year = (value >> 16) & 255;
                        int month = (value >> 8) & 255;
                        int day = (value >> 0) & 255;
                        ((TextView) ActivityMzdAllReserveSet.this.findViewById(R.id.tv_text4)).setText("20" + (year / 10) + (year % 10) + "_" + (month / 10) + (month % 10) + "_" + (day / 10) + (day % 10));
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_mzd_reserve_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[164];
                if (value > 0) {
                    value--;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[164];
                if (value2 < 36) {
                    value2++;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[163] - 500;
                if (value3 < 1000) {
                    value3 = 1000;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[163] + 500;
                if (value4 > 99500) {
                    value4 = 99500;
                }
                setCarInfo(3, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[167];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.str_reservation, 255, 1);
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = cmd1;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(8, new int[]{i, i2}, null, null);
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
    }
}
