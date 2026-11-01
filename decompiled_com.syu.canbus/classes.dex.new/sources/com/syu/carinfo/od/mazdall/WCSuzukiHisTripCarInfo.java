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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCSuzukiHisTripCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiHisTripCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 106:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 107:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 108:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 109:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 110:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
                case 111:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
                case 112:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
                case 113:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
                case 114:
                    if (value == 65535) {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                    } else {
                        ((TextView) WCSuzukiHisTripCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzuki_histrip_carinfo);
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
                dialog(R.string.str_historical_mileage_trip, 82);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.clear)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiHisTripCarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiHisTripCarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WCSuzukiHisTripCarInfo.this.setCarInfo(i, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiHisTripCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiHisTripCarInfo.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WCSuzukiHisTripCarInfo.this.setCarInfo(i, 0, 0, 0);
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }
}
