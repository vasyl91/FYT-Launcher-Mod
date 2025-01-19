package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

public class RzcJianghuaiTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    RzcJianghuaiTireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    RzcJianghuaiTireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    RzcJianghuaiTireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    RzcJianghuaiTireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    RzcJianghuaiTireAct.this.updaterTempFL();
                    break;
                case 103:
                    RzcJianghuaiTireAct.this.updaterTempFR();
                    break;
                case 104:
                    RzcJianghuaiTireAct.this.updaterTempRL();
                    break;
                case 105:
                    RzcJianghuaiTireAct.this.updaterTempRR();
                    break;
                case 106:
                    RzcJianghuaiTireAct.this.updaterFLWalm();
                    break;
                case 107:
                    RzcJianghuaiTireAct.this.updaterFRWalm();
                    break;
                case 108:
                    RzcJianghuaiTireAct.this.updaterRLWalm();
                    break;
                case 109:
                    RzcJianghuaiTireAct.this.updaterRRWalm();
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTempFL() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempFR() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRL() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRR() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[106];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[107];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[108];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[109];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }
}
