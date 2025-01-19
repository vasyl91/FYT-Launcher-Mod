package com.syu.carinfo.rzc.changan_cx70;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

public class RzcChanganCX70TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    RzcChanganCX70TireAct.this.mUpdaterTireFL();
                    break;
                case 103:
                    RzcChanganCX70TireAct.this.mUpdaterTireFR();
                    break;
                case 104:
                    RzcChanganCX70TireAct.this.mUpdaterTireRL();
                    break;
                case 105:
                    RzcChanganCX70TireAct.this.mUpdaterTireRR();
                    break;
                case 106:
                    RzcChanganCX70TireAct.this.updaterTempFL();
                    break;
                case 107:
                    RzcChanganCX70TireAct.this.updaterTempFR();
                    break;
                case 108:
                    RzcChanganCX70TireAct.this.updaterTempRL();
                    break;
                case 109:
                    RzcChanganCX70TireAct.this.updaterTempRR();
                    break;
                case 110:
                    RzcChanganCX70TireAct.this.updaterFLWalm();
                    break;
                case 111:
                    RzcChanganCX70TireAct.this.updaterFRWalm();
                    break;
                case 112:
                    RzcChanganCX70TireAct.this.updaterRLWalm();
                    break;
                case 113:
                    RzcChanganCX70TireAct.this.updaterRRWalm();
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTempFL() {
        int value = DataCanbus.DATA[106];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempFR() {
        int value = DataCanbus.DATA[107];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRL() {
        int value = DataCanbus.DATA[108];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRR() {
        int value = DataCanbus.DATA[109];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[102];
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

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[103];
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

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[104];
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

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[105];
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

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[110];
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

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[111];
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

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[112];
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

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[113];
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
