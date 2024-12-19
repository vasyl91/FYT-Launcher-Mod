package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JaguarOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarOilMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 40:
                    JaguarOilMilePage1Acti.this.mUpdaterOilExpend();
                case 41:
                    JaguarOilMilePage1Acti.this.mUpdaterMileage();
                case 42:
                    JaguarOilMilePage1Acti.this.mUpdaterSpeed();
                case 50:
                    JaguarOilMilePage1Acti.this.mUpdaterOilExpend();
                    JaguarOilMilePage1Acti.this.mUpdaterMileage();
                    JaguarOilMilePage1Acti.this.mUpdaterSpeed();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_jaguar_page1);
        ((Button) findViewById(R.id.psa_all_btn_oil_page1_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.JaguarOilMilePage1Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[40];
        int unit = DataCanbus.DATA[50] & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
            }
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterMileage() {
        int value = DataCanbus.DATA[41];
        int unit = DataCanbus.DATA[50] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + " km");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + " miles");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeed() {
        int value = DataCanbus.DATA[42];
        int unit = DataCanbus.DATA[50];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text3)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/h");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mph");
            }
        }
    }
}
