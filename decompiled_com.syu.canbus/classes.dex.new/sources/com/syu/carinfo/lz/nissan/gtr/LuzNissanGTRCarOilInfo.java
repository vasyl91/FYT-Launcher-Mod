package com.syu.carinfo.lz.nissan.gtr;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzNissanGTRCarOilInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarOilInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 139:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 140:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 141:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    break;
                case 142:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
                    break;
                case 143:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 144:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 145:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 146:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 147:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 148:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 149:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 150:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 151:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 152:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 153:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 154:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 155:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 156:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " L/100km");
                    break;
                case 157:
                    ((TextView) LuzNissanGTRCarOilInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " L/100km");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_nissan_gtr_oilinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog(R.string.average_consumption, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                dialog(R.string.distance_travelled, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarOilInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarOilInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{13, i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarOilInfo.3
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
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{55, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{64, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }
}
