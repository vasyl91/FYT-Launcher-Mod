package com.syu.carinfo.rzc.nissa_tuda;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcNissanTudaInTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.nissa_tuda.RzcNissanTudaInTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                case 101:
                    RzcNissanTudaInTireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                case 100:
                    RzcNissanTudaInTireAct.this.updaterFLWalm();
                    break;
                case 102:
                case 105:
                    RzcNissanTudaInTireAct.this.mUpdaterTireFR();
                    break;
                case 103:
                case 104:
                    RzcNissanTudaInTireAct.this.updaterFRWalm();
                    break;
                case 106:
                case 109:
                    RzcNissanTudaInTireAct.this.mUpdaterTireRL();
                    break;
                case 107:
                case 108:
                    RzcNissanTudaInTireAct.this.updaterRLWalm();
                    break;
                case 110:
                case 113:
                    RzcNissanTudaInTireAct.this.mUpdaterTireRR();
                    break;
                case 111:
                case 112:
                    RzcNissanTudaInTireAct.this.updaterRRWalm();
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        int value1 = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            if (value1 == 1) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
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
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[102];
        int value1 = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            if (value1 == 1) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
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
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[106];
        int value1 = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            if (value1 == 1) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
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
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[110];
        int value1 = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            if (value1 == 1) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                switch (TireUnit) {
                    case 0:
                        ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
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
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[99];
        int system1 = DataCanbus.DATA[100];
        if (system1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[103];
        int system1 = DataCanbus.DATA[104];
        if (system1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[107];
        int system1 = DataCanbus.DATA[108];
        if (system1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[111];
        int system1 = DataCanbus.DATA[112];
        if (system1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText("");
        }
    }
}
