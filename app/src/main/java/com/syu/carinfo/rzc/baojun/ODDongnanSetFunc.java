package com.syu.carinfo.rzc.baojun;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class ODDongnanSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " μg/m³");
                    break;
                case 99:
                    switch (value) {
                        case 1:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_light_alarm);
                            break;
                        case 2:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_moderate_alarm);
                            break;
                        case 3:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_severe_alarm);
                            break;
                        case 4:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_serious_alarm);
                            break;
                        default:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_no_alarm);
                            break;
                    }
                case 100:
                    switch (value) {
                        case 1:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_one_minute_interval);
                            break;
                        default:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_always_open);
                            break;
                    }
                case 101:
                    switch (value) {
                        case 1:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_moderate_alarm);
                            break;
                        case 2:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_severe_alarm);
                            break;
                        case 3:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_serious_alarm);
                            break;
                        default:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_light_alarm);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_0452_od_dongnan_a5);
        setupView();
    }

    private void setupView() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.str_pm25_purification, 4);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.rzc_qicheng_t70_default, 3);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
