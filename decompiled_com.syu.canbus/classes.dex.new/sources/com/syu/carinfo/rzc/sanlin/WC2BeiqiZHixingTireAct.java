package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2BeiqiZHixingTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2BeiqiZHixingTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTempFL();
                    break;
                case 104:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTempFR();
                    break;
                case 105:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTempRL();
                    break;
                case 106:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTempRR();
                    break;
                case 107:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTireFL();
                    break;
                case 108:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTireFR();
                    break;
                case 109:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTireRL();
                    break;
                case 110:
                    WC2BeiqiZHixingTireAct.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[106];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[107];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[108];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[109];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[110];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }
}
