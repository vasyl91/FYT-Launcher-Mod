package com.syu.carinfo.xfy.dx7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XfyDx7HistroyAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.dx7.XfyDx7HistroyAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 5:
                    XfyDx7HistroyAct.this.mUpdateCurOilExpend();
                    break;
                case 6:
                    XfyDx7HistroyAct.this.mUpdaterDrivingMileage();
                    break;
                case 7:
                    XfyDx7HistroyAct.this.mUpdateCurOptimalOilExpend();
                    break;
                case 8:
                    XfyDx7HistroyAct.this.mUpdaterLastOil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xfydx7_oil_trip_info);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        int value = DataCanbus.DATA[5];
        if (((TextView) findViewById(R.id.xfydx7_average_oil)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_average_oil)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_average_oil)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOptimalOilExpend() {
        int value = DataCanbus.DATA[7];
        if (((TextView) findViewById(R.id.xfydx7_current_consumption)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText(String.valueOf(value) + " Km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastOil() {
        int value = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.xfydx7_trip_oil_value)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText("--.--");
            } else if (value < 5) {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText("0%");
            } else {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.xfydx7_driving_mileage)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_driving_mileage)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_driving_mileage)).setText(String.valueOf(value) + " km");
            }
        }
    }
}
