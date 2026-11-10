package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJiaHistroyAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaHistroyAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    KeLeiJiaHistroyAct.this.mUpdateCurOilExpend();
                    break;
                case 133:
                    KeLeiJiaHistroyAct.this.mUpdateCurOptimalOilExpend();
                    break;
                case 134:
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        int value = DataCanbus.DATA[132];
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
        int value = DataCanbus.DATA[133];
        if (((TextView) findViewById(R.id.xfydx7_current_consumption)) != null) {
            if (value < 0 || value == 65535) {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText(String.valueOf(value / 10) + "." + (value % 10) + " " + CamryData.SPEED_UNIT_KM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[134];
        if (((TextView) findViewById(R.id.xfydx7_trip_oil_value)) != null) {
            if (value < 0 || value >= 131071) {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + " " + CamryData.MILEAGE_UNIT_KM);
            }
        }
    }
}
