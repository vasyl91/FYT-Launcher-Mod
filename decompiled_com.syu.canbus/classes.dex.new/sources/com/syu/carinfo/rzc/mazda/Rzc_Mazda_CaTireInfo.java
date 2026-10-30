package com.syu.carinfo.rzc.mazda;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Rzc_Mazda_CaTireInfo extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CaTireInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 142:
                    Rzc_Mazda_CaTireInfo.this.mUpdaterTireFL();
                    break;
                case 143:
                    Rzc_Mazda_CaTireInfo.this.mUpdaterTireFR();
                    break;
                case 144:
                    Rzc_Mazda_CaTireInfo.this.mUpdaterTireRL();
                    break;
                case 145:
                    Rzc_Mazda_CaTireInfo.this.mUpdaterTireRR();
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{38}, null, null);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[142];
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("----");
            }
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 2) + "kPa");
                    break;
                case 1:
                    int value2 = (value * 290) / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((value * 2) / 10) / 10) + "." + (((value * 2) / 10) % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[143];
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("----");
            }
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 2) + "kPa");
                    break;
                case 1:
                    int value2 = (value * 290) / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((value * 2) / 10) / 10) + "." + (((value * 2) / 10) % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[144];
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("----");
            }
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 2) + "kPa");
                    break;
                case 1:
                    int value2 = (value * 290) / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((value * 2) / 10) / 10) + "." + (((value * 2) / 10) % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[145];
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("----");
            }
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 2) + "kPa");
                    break;
                case 1:
                    int value2 = (value * 290) / 100;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((value * 2) / 10) / 10) + "." + (((value * 2) / 10) % 10) + "bar");
                    break;
            }
        }
    }
}
