package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLBasicInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 33:
                    YLBasicInfoAct.this.mUpdaterCurrentSpeech();
                    break;
                case 35:
                    YLBasicInfoAct.this.mUpdaterBatteryVol();
                    break;
                case 36:
                    YLBasicInfoAct.this.updaterOutTemp();
                    break;
                case 37:
                    YLBasicInfoAct.this.mUpdaterDrivingMileage();
                    break;
                case 38:
                    YLBasicInfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 39:
                    YLBasicInfoAct.this.mUpdaterTrip();
                    break;
                case 40:
                    YLBasicInfoAct.this.mUpdaterTrunk();
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
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[38];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_engine_speed_wc)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_engine_speed_wc)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentSpeech() {
        int value = DataCanbus.DATA[33];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_current_speed)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_current_speed)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[37];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_mileage_wc)).setText(String.valueOf(value) + " KM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_mileage_wc)).setText("--.-- KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[35];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_battery_voltage_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " V");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_battery_voltage_wc)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrip() {
        int value = DataCanbus.DATA[39];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_trip_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_trip_wc)).setText("--.--L/100KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[36];
        int flag = 0;
        if ((value & 128) != 0) {
            value = 256 - value;
            flag = 1;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (flag == 0) {
                ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText(String.valueOf(((value * 9) / 5) + 32) + "℉");
                return;
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText(String.valueOf((320 - (value * 18)) / 10) + "℉");
                return;
            }
        }
        if (flag == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText(String.valueOf(value) + "℃");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText("-" + value + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[40];
        ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(String.valueOf(value) + "%");
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
