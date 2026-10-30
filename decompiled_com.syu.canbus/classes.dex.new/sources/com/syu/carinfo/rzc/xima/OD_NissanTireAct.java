package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class OD_NissanTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.OD_NissanTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 123:
                    OD_NissanTireAct.this.mUpdaterTireFL();
                    break;
                case 124:
                    OD_NissanTireAct.this.mUpdaterTireFR();
                    break;
                case 125:
                    OD_NissanTireAct.this.mUpdaterTireRL();
                    break;
                case 126:
                    OD_NissanTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[123];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int value2 = value * 17;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                    break;
                case 1:
                    int value3 = (value2 * 1000) / 6895;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                    break;
                case 2:
                    int value4 = value2 / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[124] & 255;
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int value2 = value * 17;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                    break;
                case 1:
                    int value3 = (value2 * 1000) / 6895;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                    break;
                case 2:
                    int value4 = value2 / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[125] & 255;
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int value2 = value * 17;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                    break;
                case 1:
                    int value3 = (value2 * 1000) / 6895;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                    break;
                case 2:
                    int value4 = value2 / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[126] & 255;
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int value2 = value * 17;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kPa");
                    break;
                case 1:
                    int value3 = (value2 * 1000) / 6895;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "Psi");
                    break;
                case 2:
                    int value4 = value2 / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + "bar");
                    break;
            }
        }
    }
}
