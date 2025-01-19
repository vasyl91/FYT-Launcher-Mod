package com.syu.carinfo.ford;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class FordTireAct extends BaseActivity {
    int unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 146:
                    FordTireAct.this.mUpdaterTireFL();
                    break;
                case 147:
                    FordTireAct.this.mUpdaterTireFR();
                    break;
                case 148:
                    FordTireAct.this.mUpdaterTireRL();
                    break;
                case 149:
                    FordTireAct.this.mUpdaterTireRR();
                    break;
                case 150:
                    FordTireAct.this.updaterFLWalm();
                    break;
                case 151:
                    FordTireAct.this.updaterFRWalm();
                    break;
                case 152:
                    FordTireAct.this.updaterRLWalm();
                    break;
                case 153:
                    FordTireAct.this.updaterRRWalm();
                    break;
                case 154:
                    FordTireAct.this.mUpdaterTempFL();
                    break;
                case 155:
                    FordTireAct.this.mUpdaterTempFR();
                    break;
                case 156:
                    FordTireAct.this.mUpdaterTempRL();
                    break;
                case 157:
                    FordTireAct.this.mUpdaterTempRR();
                    break;
                case 247:
                    FordTireAct.this.unit = DataCanbus.DATA[247];
                    FordTireAct.this.mUpdaterTireFL();
                    FordTireAct.this.mUpdaterTireFR();
                    FordTireAct.this.mUpdaterTireRL();
                    FordTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            //setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            //setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[1], null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[154];
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

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[155];
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

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[156];
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

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[157];
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

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[146];
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

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[147];
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

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[148];
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

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[149];
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

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[150];
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

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[151];
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

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[152];
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

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[153];
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
