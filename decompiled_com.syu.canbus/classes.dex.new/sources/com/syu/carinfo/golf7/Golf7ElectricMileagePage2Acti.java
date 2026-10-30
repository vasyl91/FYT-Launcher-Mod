package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7ElectricMileagePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7ElectricMileagePage2Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 231:
                case 308:
                    Golf7ElectricMileagePage2Acti.this.mUpdaterDrivingMileage();
                    break;
                case 304:
                case 307:
                    Golf7ElectricMileagePage2Acti.this.mUpdaterAverageElectric();
                    break;
            }
        }
    };
    private TextView mTvAverageElectric;
    private TextView mTvDrivingMileage;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_electric_mileage_page2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvAverageElectric = (TextView) findViewById(R.id.golf7_tv_electric_long_term_electric);
        this.mTvDrivingMileage = (TextView) findViewById(R.id.golf7_tv_electric_long_term_driving_mileage);
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
        DataCanbus.NOTIFY_EVENTS[307].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[307].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageElectric() {
        int value = DataCanbus.DATA[307];
        int unit_wc = DataCanbus.DATA[304] & 255;
        if (this.mTvAverageElectric != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        this.mTvAverageElectric.setText(String.valueOf(String.format("-%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + Golf7Data.mElectricUnit[unit_wc]);
                        return;
                    } else {
                        this.mTvAverageElectric.setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + Golf7Data.mElectricUnit[unit_wc]);
                        return;
                    }
                }
                this.mTvAverageElectric.setText("--.--");
                return;
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && mValue != 6553 && unit > -1 && unit < 4) {
                this.mTvAverageElectric.setText(String.valueOf(mValue) + Golf7Data.mElectricUnit[unit]);
            } else if (unit > -1 && unit < 4) {
                this.mTvAverageElectric.setText("--.--" + Golf7Data.mElectricUnit[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[308];
        int unit_wc = DataCanbus.DATA[231] & 255;
        if (this.mTvDrivingMileage != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    this.mTvDrivingMileage.setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    this.mTvDrivingMileage.setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                this.mTvDrivingMileage.setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }
}
