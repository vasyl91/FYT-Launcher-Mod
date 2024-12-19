package com.syu.carinfo.oudi.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityEnergyLevel extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.beiqi.ActivityEnergyLevel.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 22:
                    ActivityEnergyLevel.this.updateCarState(DataCanbus.DATA[updateCode]);
                    break;
                case 23:
                    ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_227_energy_level);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergyLevel(int value) {
        int resId;
        if (((ImageView) findViewById(R.id.iv_energy_level)) != null) {
            if (value < 13) {
                resId = R.drawable.ic_227_battery_level_0;
            } else if (value < 38) {
                resId = R.drawable.ic_227_battery_level_1;
            } else if (value < 63) {
                resId = R.drawable.ic_227_battery_level_2;
            } else if (value < 88) {
                resId = R.drawable.ic_227_battery_level_3;
            } else if (value < 113) {
                resId = R.drawable.ic_227_battery_level_4;
            } else if (value < 138) {
                resId = R.drawable.ic_227_battery_level_5;
            } else if (value < 163) {
                resId = R.drawable.ic_227_battery_level_6;
            } else if (value < 188) {
                resId = R.drawable.ic_227_battery_level_7;
            } else if (value < 213) {
                resId = R.drawable.ic_227_battery_level_8;
            } else if (value < 238) {
                resId = R.drawable.ic_227_battery_level_9;
            } else {
                resId = R.drawable.ic_227_battery_level_10;
            }
            ((ImageView) findViewById(R.id.iv_energy_level)).setBackgroundResource(resId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarState(int value) {
        if (((TextView) findViewById(R.id.tv_227_car_state)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_0);
                    break;
            }
        }
    }
}
