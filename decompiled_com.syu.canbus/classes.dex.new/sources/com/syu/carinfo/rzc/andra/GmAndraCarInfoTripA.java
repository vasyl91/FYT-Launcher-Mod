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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GmAndraCarInfoTripA extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.GmAndraCarInfoTripA.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 180:
                case 185:
                    GmAndraCarInfoTripA.this.updateCarinfo1();
                    break;
                case 181:
                case 186:
                    GmAndraCarInfoTripA.this.updateCarinfo2();
                    break;
                case 182:
                case 187:
                    GmAndraCarInfoTripA.this.updateCarinfo3();
                    break;
                case 183:
                case 188:
                    GmAndraCarInfoTripA.this.updateCarinfo4();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_tripa_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{74, 3}, null, null);
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
                dialog(R.string.str_trip_A);
                break;
        }
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraCarInfoTripA.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.andra.GmAndraCarInfoTripA.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{96, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraCarInfoTripA.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[188];
        int unit = DataCanbus.DATA[183];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " miles/gal");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[187];
        int unit = DataCanbus.DATA[182];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " gal");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " L");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[186];
        int unit = DataCanbus.DATA[181];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mph");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[185];
        int unit = DataCanbus.DATA[180];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " mile");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " km");
        }
    }
}
