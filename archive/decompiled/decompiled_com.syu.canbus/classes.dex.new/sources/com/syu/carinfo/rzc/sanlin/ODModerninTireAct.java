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
public class ODModerninTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODModerninTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 140:
                    ODModerninTireAct.this.mUpdaterTireFL();
                    break;
                case 141:
                    ODModerninTireAct.this.mUpdaterTireFR();
                    break;
                case 142:
                    ODModerninTireAct.this.mUpdaterTireRL();
                    break;
                case 143:
                    ODModerninTireAct.this.mUpdaterTireRR();
                    break;
                case 144:
                    ODModerninTireAct.this.mUpdaterTempFL();
                    break;
                case 145:
                    ODModerninTireAct.this.mUpdaterTempFR();
                    break;
                case 146:
                    ODModerninTireAct.this.mUpdaterTempRL();
                    break;
                case 147:
                    ODModerninTireAct.this.mUpdaterTempRR();
                    break;
                case 148:
                    ODModerninTireAct.this.updaterFLWalm();
                    break;
                case 149:
                    ODModerninTireAct.this.updaterFRWalm();
                    break;
                case 150:
                    ODModerninTireAct.this.updaterRRWalm();
                    break;
                case 151:
                    ODModerninTireAct.this.updaterRLWalm();
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
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[148];
        ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[149];
        ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[151];
        ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[150];
        ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        if (((system >> 8) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_focus_warm_8_7);
            return;
        }
        if (((system >> 7) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
            return;
        }
        if (((system >> 6) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str8);
            return;
        }
        if (((system >> 4) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
            return;
        }
        if (((system >> 3) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_4);
            return;
        }
        if (((system >> 1) & 1) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefllow);
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
        } else {
            if (((system >> 0) & 1) != 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[144];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[145];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[146];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[147];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[140];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int value2 = value * 275;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 100) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((value2 / 100) * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 1000;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[141];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int value2 = value * 275;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 100) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((value2 / 100) * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 1000;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[142];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int value2 = value * 275;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 100) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((value2 / 100) * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 1000;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[143];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int value2 = value * 275;
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 100) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((value2 / 100) * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value3 = value2 / 1000;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "bar");
                    break;
            }
        }
    }
}
