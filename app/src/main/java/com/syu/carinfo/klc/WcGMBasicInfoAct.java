package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcGMBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.WcGMBasicInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 9:
                    WcGMBasicInfoAct.this.mUpdaterTrip();
                    break;
                case 13:
                    WcGMBasicInfoAct.this.mUpdaterCurrentSpeech();
                    break;
                case 107:
                    WcGMBasicInfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 144:
                    WcGMBasicInfoAct.this.mUpdaterTrunk();
                    break;
                case 145:
                    WcGMBasicInfoAct.this.mUpdaterBatteryVol();
                    break;
                case 146:
                    WcGMBasicInfoAct.this.mUpdaterDrivingMileage();
                    break;
                case 147:
                    WcGMBasicInfoAct.this.updaterOutTemp();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_basic_info);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[107];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_engine_speed_wc)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_engine_speed_wc)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentSpeech() {
        int value = DataCanbus.DATA[13];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_current_speed)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_current_speed)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[146];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_mileage_wc)).setText(String.valueOf(value) + " KM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_mileage_wc)).setText("--.-- KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[145];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_battery_voltage_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " V");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_battery_voltage_wc)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrip() {
        int value = DataCanbus.DATA[9];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_trip_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_trip_wc)).setText("--.--L/100KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[147];
        if (value >= 0 && value <= 80) {
            int value2 = 400 - (value * 5);
            ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText("-" + (value2 / 10) + "." + (value2 % 10) + "℃");
        } else {
            int value3 = (value * 5) - 400;
            ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[144];
        ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(String.valueOf(value) + " ");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
