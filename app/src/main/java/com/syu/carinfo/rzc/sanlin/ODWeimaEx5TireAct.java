package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODWeimaEx5TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    ODWeimaEx5TireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    ODWeimaEx5TireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    ODWeimaEx5TireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    ODWeimaEx5TireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    ODWeimaEx5TireAct.this.mUpdaterTempFL();
                    break;
                case 103:
                    ODWeimaEx5TireAct.this.mUpdaterTempFR();
                    break;
                case 104:
                    ODWeimaEx5TireAct.this.mUpdaterTempRL();
                    break;
                case 105:
                    ODWeimaEx5TireAct.this.mUpdaterTempRR();
                    break;
                case 126:
                    ODWeimaEx5TireAct.this.mUpdaterTireFL();
                    ODWeimaEx5TireAct.this.mUpdaterTireFR();
                    ODWeimaEx5TireAct.this.mUpdaterTireRL();
                    ODWeimaEx5TireAct.this.mUpdaterTireRR();
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
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{57}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    private void updaterFLWalm() {
        int system = DataCanbus.DATA[106];
        ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrlow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    private void updaterFRWalm() {
        int system = DataCanbus.DATA[107];
        ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrlow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    private void updaterRLWalm() {
        int system = DataCanbus.DATA[109];
        ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrlow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    private void updaterRRWalm() {
        int system = DataCanbus.DATA[108];
        ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrlow);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_battery_low);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_failure);
                break;
            case 7:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_quik_leakage);
                break;
        }
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value;
        int value2 = DataCanbus.DATA[98];
        int unit = DataCanbus.DATA[126];
        if (value2 == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int value3 = value2 * 275;
            if ((value3 % 100) / 10 >= 5) {
                value = (value3 / 100) + 1;
            } else {
                value = value3 / 100;
            }
            if (unit == 1) {
                int value4 = value * 145;
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value4 / 1000) + "." + ((value4 % 1000) / 100) + CamryData.PRESSURE_UNIT_PSI);
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + "bar");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "kPa");
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value;
        int value2 = DataCanbus.DATA[99];
        int unit = DataCanbus.DATA[126];
        if (value2 == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            int value3 = value2 * 275;
            if ((value3 % 100) / 10 >= 5) {
                value = (value3 / 100) + 1;
            } else {
                value = value3 / 100;
            }
            if (unit == 1) {
                int value4 = value * 145;
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value4 / 1000) + "." + ((value4 % 1000) / 100) + CamryData.PRESSURE_UNIT_PSI);
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + "bar");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "kPa");
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value;
        int value2 = DataCanbus.DATA[100];
        int unit = DataCanbus.DATA[126];
        if (value2 == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            int value3 = value2 * 275;
            if ((value3 % 100) / 10 >= 5) {
                value = (value3 / 100) + 1;
            } else {
                value = value3 / 100;
            }
            if (unit == 1) {
                int value4 = value * 145;
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value4 / 1000) + "." + ((value4 % 1000) / 100) + CamryData.PRESSURE_UNIT_PSI);
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + "bar");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "kPa");
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value;
        int value2 = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[126];
        if (value2 == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            int value3 = value2 * 275;
            if ((value3 % 100) / 10 >= 5) {
                value = (value3 / 100) + 1;
            } else {
                value = value3 / 100;
            }
            if (unit == 1) {
                int value4 = value * 145;
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value4 / 1000) + "." + ((value4 % 1000) / 100) + CamryData.PRESSURE_UNIT_PSI);
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + "bar");
            } else {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "kPa");
            }
        }
    }
}
