package com.syu.carinfo.od.mazdall;

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
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCLeepMotorTripACarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorTripACarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
                case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                    switch (updateCode) {
                        case 140:
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                            }
                            break;
                        case 141:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 142:
                            if (value == 255) {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                    }
                    break;
                default:
                    switch (updateCode) {
                        case 105:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 106:
                            if (value == 65535) {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                            }
                            break;
                        case 107:
                            if (value == 16777215) {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                            } else {
                                ((TextView) WCLeepMotorTripACarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                            }
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_leepmotor_tripa_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog(R.string.jiede_trip_a, 82);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.clear)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorTripACarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorTripACarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
                            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                                DataCanbus.PROXY.cmd(1, new int[]{27, 1, 0}, null, null);
                                break;
                            default:
                                WCLeepMotorTripACarInfo.this.setCarInfo(i, 1, 0, 0);
                                break;
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorTripACarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorTripACarInfo.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
                            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                                break;
                            default:
                                WCLeepMotorTripACarInfo.this.setCarInfo(i, 0, 0, 0);
                                break;
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                DataCanbus.PROXY.cmd(0, new int[]{67, 0}, null, null);
                DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
                break;
        }
    }
}
