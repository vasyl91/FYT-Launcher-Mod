package com.syu.carinfo.rzc.andra;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LzNissan03TeanaCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " L/100km");
                    break;
                case 87:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value * 0.1f) + " L/100km");
                    break;
                case 88:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " km");
                    break;
                case 89:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " km/h");
                    break;
                case 90:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km/h");
                    break;
                case 91:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                    break;
                case 92:
                    ((TextView) LzNissan03TeanaCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_nissan_03teana_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                dialog(R.string.average_oil, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog(R.string.mileage, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{13, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{55}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
    }
}