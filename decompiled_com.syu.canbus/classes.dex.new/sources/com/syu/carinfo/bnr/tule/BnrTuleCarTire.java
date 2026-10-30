package com.syu.carinfo.bnr.tule;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BnrTuleCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.tule.BnrTuleCarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    BnrTuleCarTire.this.mUpdaterTireFL();
                    break;
                case 100:
                    BnrTuleCarTire.this.mUpdaterTireFR();
                    break;
                case 101:
                    BnrTuleCarTire.this.mUpdaterTireRL();
                    break;
                case 102:
                    BnrTuleCarTire.this.mUpdaterTireRR();
                    break;
                case 103:
                    BnrTuleCarTire.this.mUpdaterTireFL();
                    BnrTuleCarTire.this.mUpdaterTireFR();
                    BnrTuleCarTire.this.mUpdaterTireRL();
                    BnrTuleCarTire.this.mUpdaterTireRR();
                    break;
                case 104:
                    BnrTuleCarTire.this.updaterFRWalm();
                    BnrTuleCarTire.this.updaterFLWalm();
                    BnrTuleCarTire.this.updaterRLWalm();
                    BnrTuleCarTire.this.updaterRRWalm();
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[99];
        int value1 = (DataCanbus.DATA[103] >> 6) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int value2 = value * 10;
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
        int value = DataCanbus.DATA[100];
        int value1 = (DataCanbus.DATA[103] >> 7) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int value2 = value * 10;
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
        int value = DataCanbus.DATA[101];
        int value1 = (DataCanbus.DATA[103] >> 4) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int value2 = value * 10;
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
        int value = DataCanbus.DATA[102];
        int value1 = (DataCanbus.DATA[103] >> 5) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int value2 = value * 10;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = (DataCanbus.DATA[104] >> 6) & 1;
        int value1 = (DataCanbus.DATA[104] >> 2) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = (DataCanbus.DATA[104] >> 7) & 1;
        int value1 = (DataCanbus.DATA[104] >> 3) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = (DataCanbus.DATA[104] >> 4) & 1;
        int value1 = (DataCanbus.DATA[104] >> 0) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = (DataCanbus.DATA[104] >> 5) & 1;
        int value1 = (DataCanbus.DATA[104] >> 1) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }
}
