package com.syu.carinfo.rzc.changan_cx70;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcChanganCX70TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 25:
                    RzcChanganCX70TireAct.this.mUpdaterTireFL();
                    break;
                case 26:
                    RzcChanganCX70TireAct.this.mUpdaterTireFR();
                    break;
                case 27:
                    RzcChanganCX70TireAct.this.mUpdaterTireRL();
                    break;
                case 28:
                    RzcChanganCX70TireAct.this.mUpdaterTireRR();
                    break;
                case 29:
                    RzcChanganCX70TireAct.this.updaterTempFL();
                    break;
                case 30:
                    RzcChanganCX70TireAct.this.updaterTempFR();
                    break;
                case 31:
                    RzcChanganCX70TireAct.this.updaterTempRL();
                    break;
                case 32:
                    RzcChanganCX70TireAct.this.updaterTempRR();
                    break;
                case 33:
                    RzcChanganCX70TireAct.this.updaterFLWalm();
                    break;
                case 34:
                    RzcChanganCX70TireAct.this.updaterFRWalm();
                    break;
                case 35:
                    RzcChanganCX70TireAct.this.updaterRLWalm();
                    break;
                case 36:
                    RzcChanganCX70TireAct.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[29];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[30];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[31];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[32];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[25];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = (int) ((value * 1.428d) - 10.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[26];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = (int) ((value * 1.428d) - 10.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[27];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = (int) ((value * 1.428d) - 10.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[28];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = (int) ((value * 1.428d) - 10.0d);
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[33];
        if ((system & 8) == 8) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
        }
        if ((system & 128) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_390_sensor_failure);
        } else if ((system & 64) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_390_sensor_battery_low);
        } else if ((system & 32) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_390_lost_sensor);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_top)).setText("");
        }
        if ((system & 16) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.str_390_quik_leakage);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_top1)).setText("");
        }
        if ((system & 7) == 4) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
        } else if ((system & 2) == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if ((system & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[34];
        if ((system & 8) == 8) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
        }
        if ((system & 128) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_390_sensor_failure);
        } else if ((system & 64) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_390_sensor_battery_low);
        } else if ((system & 32) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_390_lost_sensor);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_top)).setText("");
        }
        if ((system & 16) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.str_390_quik_leakage);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_top1)).setText("");
        }
        if ((system & 7) == 4) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
        } else if ((system & 2) == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if ((system & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[35];
        if ((system & 8) == 8) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
        }
        if ((system & 128) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_390_sensor_failure);
        } else if ((system & 64) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_390_sensor_battery_low);
        } else if ((system & 32) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_390_lost_sensor);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_top)).setText("");
        }
        if ((system & 16) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.str_390_quik_leakage);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_top1)).setText("");
        }
        if ((system & 7) == 4) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
        } else if ((system & 2) == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if ((system & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[36];
        if ((system & 8) == 8) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
        }
        if ((system & 128) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_390_sensor_failure);
        } else if ((system & 64) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_390_sensor_battery_low);
        } else if ((system & 32) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_390_lost_sensor);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_top)).setText("");
        }
        if ((system & 16) != 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.str_390_quik_leakage);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_top1)).setText("");
        }
        if ((system & 7) == 4) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
        } else if ((system & 2) == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if ((system & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }
}
