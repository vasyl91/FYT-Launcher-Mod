package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

public class ODCaptivaTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    ODCaptivaTireAct.this.mUpdaterTireFL();
                    break;
                case 104:
                    ODCaptivaTireAct.this.mUpdaterTireFR();
                    break;
                case 105:
                    ODCaptivaTireAct.this.mUpdaterTireRL();
                    break;
                case 106:
                    ODCaptivaTireAct.this.mUpdaterTireRR();
                    break;
                case 107:
                    ODCaptivaTireAct.this.updaterTempFL();
                    break;
                case 108:
                    ODCaptivaTireAct.this.updaterTempFR();
                    break;
                case 109:
                    ODCaptivaTireAct.this.updaterTempRL();
                    break;
                case 110:
                    ODCaptivaTireAct.this.updaterTempRR();
                    break;
                case 111:
                    ODCaptivaTireAct.this.updaterFLWalm();
                    break;
                case 112:
                    ODCaptivaTireAct.this.updaterFRWalm();
                    break;
                case 113:
                    ODCaptivaTireAct.this.updaterRLWalm();
                    break;
                case 114:
                    ODCaptivaTireAct.this.updaterRRWalm();
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
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTempFL() {
        int value = DataCanbus.DATA[107];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempFR() {
        int value = DataCanbus.DATA[108];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRL() {
        int value = DataCanbus.DATA[109];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void updaterTempRR() {
        int value = DataCanbus.DATA[110];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 27.45d);
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 1000.0f)) + "bar");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 27.45d);
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 1000.0f)) + "bar");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 27.45d);
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 1000.0f)) + "bar");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[106];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 27.45d);
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 1000.0f)) + "bar");
        }
    }

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[111];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn3);
        }
    }

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[112];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn3);
        }
    }

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[113];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn3);
        }
    }

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[114];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn3);
        }
    }
}
