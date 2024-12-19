package com.syu.carinfo.luz.oubao;

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
public class Luz_Oubao_CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.luz.oubao.Luz_Oubao_CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 25:
                    if (value > 715) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Km");
                        break;
                    }
                case 26:
                    if (value > 398) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 27:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text11)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 28:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text12)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 29:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text13)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 30:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text14)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 31:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + " Km");
                        break;
                    }
                case 32:
                    if (value > 250) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Km/h");
                        break;
                    }
                case 33:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " L");
                        break;
                    }
                case 34:
                    if (value > 398) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 35:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " Km");
                        break;
                    }
                case 36:
                    if (value > 250) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " Km/h");
                        break;
                    }
                case 37:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + " L");
                        break;
                    }
                case 38:
                    if (value > 398) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_luz_oubao_andela_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{18}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{19}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{20}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                dialog("BC1", 3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog("BC2", 4);
                break;
        }
    }

    protected void dialog(String str, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + str + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.luz.oubao.Luz_Oubao_CarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.luz.oubao.Luz_Oubao_CarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.luz.oubao.Luz_Oubao_CarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
    }
}
