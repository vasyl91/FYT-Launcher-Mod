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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODDongnanSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.ODDongnanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " μg/m³");
                    break;
                case 17:
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
                case 18:
                    switch (value) {
                        case 1:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_one_minute_interval);
                            break;
                        default:
                            ((TextView) ODDongnanSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_always_open);
                            break;
                    }
                case 19:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0452_od_dongnan_a5);
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.ODDongnanSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.baojun.ODDongnanSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.ODDongnanSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                dialog(R.string.str_pm25_purification, 4);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[18] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[18] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[19] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[19] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog(R.string.rzc_qicheng_t70_default, 3);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
    }
}
