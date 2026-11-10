package com.syu.carinfo.rzc.lufengxiaoyao;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCLufengXiaoyaoTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoTireAct.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:25:0x008b A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:37:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:41:0x0118  */
        /* JADX WARN: Code duplicated, block: B:43:0x0120  */
        /* JADX WARN: Code duplicated, block: B:44:0x0130  */
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                case 110:
                case 111:
                    RZCLufengXiaoyaoTireAct.this.updaterTempFL();
                    break;
                case 99:
                case 118:
                case 119:
                    RZCLufengXiaoyaoTireAct.this.updaterTempFR();
                    break;
                case 100:
                case 134:
                case 135:
                    RZCLufengXiaoyaoTireAct.this.updaterTempRL();
                    break;
                case 101:
                case 126:
                case 127:
                    RZCLufengXiaoyaoTireAct.this.updaterTempRR();
                    break;
                case 102:
                case 106:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireFL();
                    break;
                case 103:
                case 114:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireFR();
                    break;
                case 104:
                case 130:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireRL();
                    break;
                case 105:
                case 122:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireRR();
                    break;
                case 107:
                case 108:
                case 109:
                    RZCLufengXiaoyaoTireAct.this.updaterFLWalm();
                    break;
                case 112:
                case 113:
                    if (DataCanbus.DATA[113] != 1 && DataCanbus.DATA[112] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText("----");
                    }
                    if (DataCanbus.DATA[121] == 1 && DataCanbus.DATA[120] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[137] == 1 && DataCanbus.DATA[136] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[129] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    break;
                case 115:
                case 116:
                case 117:
                    RZCLufengXiaoyaoTireAct.this.updaterFRWalm();
                    break;
                case 120:
                case 121:
                    if (DataCanbus.DATA[121] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    }
                    if (DataCanbus.DATA[137] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    }
                    if (DataCanbus.DATA[129] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    break;
                case 123:
                case 124:
                case 125:
                    RZCLufengXiaoyaoTireAct.this.updaterRRWalm();
                    break;
                case 128:
                case 129:
                    if (DataCanbus.DATA[129] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    break;
                case 131:
                case 132:
                case 133:
                    RZCLufengXiaoyaoTireAct.this.updaterRLWalm();
                    break;
                case 136:
                case 137:
                    if (DataCanbus.DATA[137] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    }
                    if (DataCanbus.DATA[129] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[128] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[98];
        int value1 = DataCanbus.DATA[110];
        int value2 = DataCanbus.DATA[111];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[99];
        int value1 = DataCanbus.DATA[118];
        int value2 = DataCanbus.DATA[119];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[100];
        int value1 = DataCanbus.DATA[134];
        int value2 = DataCanbus.DATA[135];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[101];
        int value1 = DataCanbus.DATA[126];
        int value2 = DataCanbus.DATA[127];
        if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            if (value1 == 1) {
                ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
            }
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[102];
        int value1 = DataCanbus.DATA[106];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[114];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[104];
        int value1 = DataCanbus.DATA[130];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[105];
        int value1 = DataCanbus.DATA[122];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[107];
        int value1 = DataCanbus.DATA[108];
        int value2 = DataCanbus.DATA[109];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[115];
        int value1 = DataCanbus.DATA[116];
        int value2 = DataCanbus.DATA[117];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[131];
        int value1 = DataCanbus.DATA[132];
        int value2 = DataCanbus.DATA[133];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[123];
        int value1 = DataCanbus.DATA[124];
        int value2 = DataCanbus.DATA[125];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
        }
    }
}
