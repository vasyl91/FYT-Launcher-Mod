package com.syu.carinfo.wc2.tata;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2MHDTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.tata.WC2MHDTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 105:
                case 106:
                    WC2MHDTireAct.this.mUpdaterTireTitle();
                    break;
                case 107:
                    WC2MHDTireAct.this.mUpdaterTireFL();
                    break;
                case 108:
                    WC2MHDTireAct.this.mUpdaterTireFR();
                    break;
                case 109:
                    WC2MHDTireAct.this.mUpdaterTireRL();
                    break;
                case 110:
                    WC2MHDTireAct.this.mUpdaterTireRR();
                    break;
                case 111:
                case 116:
                case 121:
                    WC2MHDTireAct.this.mUpdaterTireAdd();
                    break;
                case 112:
                    WC2MHDTireAct.this.updaterTempFL();
                    break;
                case 113:
                    WC2MHDTireAct.this.updaterTempFR();
                    break;
                case 114:
                    WC2MHDTireAct.this.updaterTempRL();
                    break;
                case 115:
                    WC2MHDTireAct.this.updaterTempRR();
                    break;
                case 117:
                    WC2MHDTireAct.this.updaterFLWalm();
                    break;
                case 118:
                    WC2MHDTireAct.this.updaterFRWalm();
                    break;
                case 119:
                    WC2MHDTireAct.this.updaterRLWalm();
                    break;
                case 120:
                    WC2MHDTireAct.this.updaterRRWalm();
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
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireAdd() {
        int value = DataCanbus.DATA[111];
        int state = DataCanbus.DATA[121];
        int temp = DataCanbus.DATA[116];
        if (state == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText(R.string.tireflalarm);
        } else if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText("--.--");
        } else {
            int temp2 = (temp * 5) - 400;
            ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText(String.valueOf(value) + "kPa / " + (temp2 / 10) + "." + (temp2 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireTitle() {
        int value = DataCanbus.DATA[105];
        int warn = DataCanbus.DATA[106];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tire_pressure_miss);
        } else if (warn == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[112];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            int value2 = (value * 5) - 400;
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[113];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            int value2 = (value * 5) - 400;
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[114];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            int value2 = (value * 5) - 400;
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[115];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            int value2 = (value * 5) - 400;
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[107];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[108];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[109];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[110];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[117];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[118];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[119];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[120];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
                break;
        }
    }
}
