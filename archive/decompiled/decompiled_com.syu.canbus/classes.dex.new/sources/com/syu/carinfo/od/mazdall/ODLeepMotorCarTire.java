package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODLeepMotorCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.ODLeepMotorCarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 143:
                    ODLeepMotorCarTire.this.updaterFLWalm();
                    break;
                case 144:
                    ODLeepMotorCarTire.this.updaterFRWalm();
                    break;
                case 145:
                    ODLeepMotorCarTire.this.updaterRLWalm();
                    break;
                case 146:
                    ODLeepMotorCarTire.this.updaterRRWalm();
                    break;
                case 147:
                    ODLeepMotorCarTire.this.mUpdaterTireFL();
                    break;
                case 148:
                    ODLeepMotorCarTire.this.mUpdaterTireFR();
                    break;
                case 149:
                    ODLeepMotorCarTire.this.mUpdaterTireRL();
                    break;
                case 150:
                    ODLeepMotorCarTire.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[143];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefllow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str6);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[144];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefllow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str6);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[145];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefllow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str6);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[146];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefllow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str6);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[147];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            int value2 = value * 1373;
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 1000) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((value2 * 1000) / 6895) / 1000) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 10000;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[148];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            int value2 = value * 1373;
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 1000) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((value2 * 1000) / 6895) / 1000) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 10000;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[149];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            int value2 = value * 1373;
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 1000) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((value2 * 1000) / 6895) / 1000) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 10000;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[150];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            int value2 = value * 1373;
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 1000) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((value2 * 1000) / 6895) / 1000) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 10000;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }
}
