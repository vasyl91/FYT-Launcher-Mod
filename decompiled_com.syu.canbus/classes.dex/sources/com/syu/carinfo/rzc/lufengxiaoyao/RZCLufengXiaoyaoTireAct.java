package com.syu.carinfo.rzc.lufengxiaoyao;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 86:
                case 98:
                case 99:
                    RZCLufengXiaoyaoTireAct.this.updaterTempFL();
                    break;
                case 87:
                case 106:
                case 107:
                    RZCLufengXiaoyaoTireAct.this.updaterTempFR();
                    break;
                case 88:
                case 122:
                case 123:
                    RZCLufengXiaoyaoTireAct.this.updaterTempRL();
                    break;
                case 89:
                case 114:
                case 115:
                    RZCLufengXiaoyaoTireAct.this.updaterTempRR();
                    break;
                case 90:
                case 94:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireFL();
                    break;
                case 91:
                case 102:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireFR();
                    break;
                case 92:
                case 118:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireRL();
                    break;
                case 93:
                case 110:
                    RZCLufengXiaoyaoTireAct.this.mUpdaterTireRR();
                    break;
                case 95:
                case 96:
                case 97:
                    RZCLufengXiaoyaoTireAct.this.updaterFLWalm();
                    break;
                case 100:
                case 101:
                    if (DataCanbus.DATA[101] != 1 && DataCanbus.DATA[100] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText("----");
                    }
                    if (DataCanbus.DATA[109] == 1 && DataCanbus.DATA[108] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[125] == 1 && DataCanbus.DATA[124] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[117] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[116] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    break;
                case 103:
                case 104:
                case 105:
                    RZCLufengXiaoyaoTireAct.this.updaterFRWalm();
                    break;
                case 108:
                case 109:
                    if (DataCanbus.DATA[109] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    }
                    if (DataCanbus.DATA[125] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    }
                    if (DataCanbus.DATA[117] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[116] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    break;
                case 111:
                case 112:
                case 113:
                    RZCLufengXiaoyaoTireAct.this.updaterRRWalm();
                    break;
                case 116:
                case 117:
                    if (DataCanbus.DATA[117] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[116] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    break;
                case 119:
                case 120:
                case 121:
                    RZCLufengXiaoyaoTireAct.this.updaterRLWalm();
                    break;
                case 124:
                case 125:
                    if (DataCanbus.DATA[125] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    } else {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    }
                    if (DataCanbus.DATA[117] == 1) {
                        ((TextView) RZCLufengXiaoyaoTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    } else if (DataCanbus.DATA[116] == 1) {
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[86];
        int value1 = DataCanbus.DATA[98];
        int value2 = DataCanbus.DATA[99];
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
        int value = DataCanbus.DATA[87];
        int value1 = DataCanbus.DATA[106];
        int value2 = DataCanbus.DATA[107];
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
        int value = DataCanbus.DATA[88];
        int value1 = DataCanbus.DATA[122];
        int value2 = DataCanbus.DATA[123];
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
        int value = DataCanbus.DATA[89];
        int value1 = DataCanbus.DATA[114];
        int value2 = DataCanbus.DATA[115];
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
        int value = DataCanbus.DATA[90];
        int value1 = DataCanbus.DATA[94];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[91];
        int value1 = DataCanbus.DATA[102];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[92];
        int value1 = DataCanbus.DATA[118];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[93];
        int value1 = DataCanbus.DATA[110];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[95];
        int value1 = DataCanbus.DATA[96];
        int value2 = DataCanbus.DATA[97];
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
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[104];
        int value2 = DataCanbus.DATA[105];
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
        int value = DataCanbus.DATA[119];
        int value1 = DataCanbus.DATA[120];
        int value2 = DataCanbus.DATA[121];
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
        int value = DataCanbus.DATA[111];
        int value1 = DataCanbus.DATA[112];
        int value2 = DataCanbus.DATA[113];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
        }
    }
}
