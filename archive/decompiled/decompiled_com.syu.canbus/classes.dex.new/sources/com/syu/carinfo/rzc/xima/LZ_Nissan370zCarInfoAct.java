package com.syu.carinfo.rzc.xima;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZ_Nissan370zCarInfoAct extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan370zCarInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    }
                    break;
                case 99:
                    if (((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    }
                    break;
                case 100:
                    if (((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (LZ_Nissan370zCarInfoAct.this.unit == 1) {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "miles");
                        } else {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                        }
                    }
                    break;
                case 101:
                    if (((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (LZ_Nissan370zCarInfoAct.this.unit == 1) {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "mph");
                        } else {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/h");
                        }
                    }
                    break;
                case 102:
                    if (((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (LZ_Nissan370zCarInfoAct.this.unit == 1) {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "miles");
                        } else {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "km");
                        }
                    }
                    break;
                case 103:
                    if (((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (LZ_Nissan370zCarInfoAct.this.unit == 1) {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "miles");
                        } else {
                            ((TextView) LZ_Nissan370zCarInfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                        }
                    }
                    break;
                case 104:
                    LZ_Nissan370zCarInfoAct.this.unit = value;
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_lz_nissan_370z_oilinf);
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
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog(R.string.average_oil, 13, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                dialog(R.string.mileage, 13, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan370zCarInfoAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan370zCarInfoAct.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, i2, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan370zCarInfoAct.3
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
        DataCanbus.PROXY.cmd(0, new int[]{51, 0}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{55, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }
}
