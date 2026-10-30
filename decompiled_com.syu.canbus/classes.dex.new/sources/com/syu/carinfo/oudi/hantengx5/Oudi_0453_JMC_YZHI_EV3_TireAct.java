package com.syu.carinfo.oudi.hantengx5;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Oudi_0453_JMC_YZHI_EV3_TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0453_JMC_YZHI_EV3_TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTempFL();
                    break;
                case 103:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTempFR();
                    break;
                case 104:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTempRL();
                    break;
                case 105:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.mUpdaterTempRR();
                    break;
                case 106:
                case 107:
                case 108:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.updaterFLWalm();
                    break;
                case 109:
                case 110:
                case 111:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.updaterFRWalm();
                    break;
                case 112:
                case 113:
                case 114:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.updaterRRWalm();
                    break;
                case 115:
                case 116:
                case 117:
                    Oudi_0453_JMC_YZHI_EV3_TireAct.this.updaterRLWalm();
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
        DataCanbus.PROXY.cmd(2, new int[]{56, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[106];
        int lowalarm = DataCanbus.DATA[107];
        int highalarm = DataCanbus.DATA[108];
        ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        if (highalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
        } else if (lowalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrlow);
        } else {
            if (system == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[109];
        int lowalarm = DataCanbus.DATA[110];
        int highalarm = DataCanbus.DATA[111];
        ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        if (highalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
        } else if (lowalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrlow);
        } else {
            if (system == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[115];
        int lowalarm = DataCanbus.DATA[116];
        int highalarm = DataCanbus.DATA[117];
        ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        if (highalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
        } else if (lowalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrlow);
        } else {
            if (system == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[112];
        int lowalarm = DataCanbus.DATA[113];
        int highalarm = DataCanbus.DATA[114];
        ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        if (highalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
        } else if (lowalarm == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrlow);
        } else {
            if (system == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
                return;
            }
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int value2 = (int) (value * 1.373f * 100.0f);
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int value2 = (int) (value * 1.373f * 100.0f);
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int value2 = (int) (value * 1.373f * 100.0f);
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int value2 = (int) (value * 1.373f * 100.0f);
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }
}
