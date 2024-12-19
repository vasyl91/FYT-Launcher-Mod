package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7ElectricMileagePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7ElectricMileagePage3Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 177:
                case 292:
                    Golf7ElectricMileagePage3Acti.this.mUpdaterDrivingMileage();
                    break;
                case 276:
                case 291:
                    Golf7ElectricMileagePage3Acti.this.mUpdaterAverageElectric();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_electric_mileage_page3);
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageElectric() {
        int value = DataCanbus.DATA[291];
        int unit_wc = DataCanbus.DATA[276] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_average_electric)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_average_electric)).setText(String.valueOf(String.format("-%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + Golf7Data.mElectricUnit[unit_wc]);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_average_electric)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + Golf7Data.mElectricUnit[unit_wc]);
                        return;
                    }
                }
                ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_average_electric)).setText("--.--");
                return;
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && mValue != 6553 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_average_electric)).setText(String.valueOf(mValue) + Golf7Data.mElectricUnit[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_average_electric)).setText("--.--" + Golf7Data.mElectricUnit[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[292];
        int unit_wc = DataCanbus.DATA[177] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_driving_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_driving_mileage)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_driving_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_electric_since_refuelling_driving_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }
}
