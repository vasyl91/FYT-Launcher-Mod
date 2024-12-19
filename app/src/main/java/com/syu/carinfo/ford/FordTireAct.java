package com.syu.carinfo.ford;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordTireAct extends BaseActivity {
    int unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 78:
                    FordTireAct.this.mUpdaterTireFL();
                    break;
                case 79:
                    FordTireAct.this.mUpdaterTireFR();
                    break;
                case 80:
                    FordTireAct.this.mUpdaterTireRL();
                    break;
                case 81:
                    FordTireAct.this.mUpdaterTireRR();
                    break;
                case 82:
                    FordTireAct.this.updaterFLWalm();
                    break;
                case 83:
                    FordTireAct.this.updaterFRWalm();
                    break;
                case 84:
                    FordTireAct.this.updaterRLWalm();
                    break;
                case 85:
                    FordTireAct.this.updaterRRWalm();
                    break;
                case 86:
                    FordTireAct.this.mUpdaterTempFL();
                    break;
                case 87:
                    FordTireAct.this.mUpdaterTempFR();
                    break;
                case 88:
                    FordTireAct.this.mUpdaterTempRL();
                    break;
                case 89:
                    FordTireAct.this.mUpdaterTempRR();
                    break;
                case 180:
                    FordTireAct.this.unit = DataCanbus.DATA[180];
                    FordTireAct.this.mUpdaterTireFL();
                    FordTireAct.this.mUpdaterTireFR();
                    FordTireAct.this.mUpdaterTireRL();
                    FordTireAct.this.mUpdaterTireRR();
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[1], null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[86];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                break;
            default:
                if (value == 255) {
                    ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
                    break;
                } else if (value == 0) {
                    ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("");
                    break;
                } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
                    ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 60) + "℃");
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[87];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                break;
            default:
                if (value == 255) {
                    ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
                    break;
                } else if (value == 0) {
                    ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("");
                    break;
                } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
                    ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 60) + "℃");
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[88];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                break;
            default:
                if (value == 255) {
                    ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
                    break;
                } else if (value == 0) {
                    ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("");
                    break;
                } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
                    ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 60) + "℃");
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[89];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                break;
            default:
                if (value == 255) {
                    ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
                    break;
                } else if (value == 0) {
                    ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("");
                    break;
                } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
                    ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 60) + "℃");
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[78];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            if (this.unit == 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((int) ((value * 2.75f) * 100.0f)) / 100) + "kPa");
            } else if (this.unit == 1) {
                int value2 = (int) (value * 39.9f);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "psi");
            } else if (this.unit == 2) {
                int value3 = (int) (value * 2.75f);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value3 / 100) + "." + ((value3 % 100) / 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[79];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            if (this.unit == 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((int) ((value * 2.75f) * 100.0f)) / 100) + "kPa");
            } else if (this.unit == 1) {
                int value2 = (int) (value * 39.9f);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "psi");
            } else if (this.unit == 2) {
                int value3 = (int) (value * 2.75f);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value3 / 100) + "." + ((value3 % 100) / 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[80];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            if (this.unit == 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((int) ((value * 2.75f) * 100.0f)) / 100) + "kPa");
            } else if (this.unit == 1) {
                int value2 = (int) (value * 39.9f);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "psi");
            } else if (this.unit == 2) {
                int value3 = (int) (value * 2.75f);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value3 / 100) + "." + ((value3 % 100) / 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[81];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            if (this.unit == 0) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((int) ((value * 2.75f) * 100.0f)) / 100) + "kPa");
            } else if (this.unit == 1) {
                int value2 = (int) (value * 39.9f);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "psi");
            } else if (this.unit == 2) {
                int value3 = (int) (value * 2.75f);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value3 / 100) + "." + ((value3 % 100) / 10) + "bar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[82];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirerllow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_quik_leakage);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[83];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirerllow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_quik_leakage);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[84];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirerllow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_quik_leakage);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[85];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirerllow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_quik_leakage);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }
}
