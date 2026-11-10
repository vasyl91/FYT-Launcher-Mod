package com.syu.carinfo.dj.huangguan;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityOldFx35TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.ActivityOldFx35TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 181:
                    ActivityOldFx35TireAct.this.mUpdaterTireFL();
                    break;
                case 182:
                    ActivityOldFx35TireAct.this.mUpdaterTireFR();
                    break;
                case 183:
                    ActivityOldFx35TireAct.this.mUpdaterTireRL();
                    break;
                case 184:
                    ActivityOldFx35TireAct.this.mUpdaterTireRR();
                    break;
                case 185:
                    ActivityOldFx35TireAct.this.updaterFRWalm();
                    break;
                case 186:
                    ActivityOldFx35TireAct.this.updaterFLWalm();
                    break;
                case 187:
                    ActivityOldFx35TireAct.this.updaterRRWalm();
                    break;
                case 188:
                    ActivityOldFx35TireAct.this.updaterRLWalm();
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
        DataCanbus.PROXY.cmd(1, new int[]{110}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[186];
        ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrlow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[185];
        ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrlow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[188];
        ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrlow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[187];
        ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrlow);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[181];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[182];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[183];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[184];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
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
    }
}
