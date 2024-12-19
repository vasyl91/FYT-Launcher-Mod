package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KeLeiJiaHistroyAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaHistroyAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 42:
                    KeLeiJiaHistroyAct.this.mUpdateCurOilExpend();
                    break;
                case 43:
                    KeLeiJiaHistroyAct.this.mUpdateCurOptimalOilExpend();
                    break;
                case 44:
                    KeLeiJiaHistroyAct.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_keleijiahistroy);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        int value = DataCanbus.DATA[42];
        if (((TextView) findViewById(R.id.xfydx7_average_oil)) != null) {
            if (value < 0 || value == 65535) {
                ((TextView) findViewById(R.id.xfydx7_average_oil)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_average_oil)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOptimalOilExpend() {
        int value = DataCanbus.DATA[43];
        if (((TextView) findViewById(R.id.xfydx7_current_consumption)) != null) {
            if (value < 0 || value == 65535) {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText(String.valueOf(value / 10) + "." + (value % 10) + " KM/H");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[44];
        if (((TextView) findViewById(R.id.xfydx7_trip_oil_value)) != null) {
            if (value < 0 || value == 65535) {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + " KM");
            }
        }
    }
}
