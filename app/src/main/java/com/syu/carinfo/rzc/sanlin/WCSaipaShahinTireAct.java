package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WCSaipaShahinTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    WCSaipaShahinTireAct.this.updaterTireWarn();
                    break;
                case 115:
                    WCSaipaShahinTireAct.this.mUpdaterTireFL();
                    break;
                case 116:
                    WCSaipaShahinTireAct.this.mUpdaterTireFR();
                    break;
                case 117:
                    WCSaipaShahinTireAct.this.mUpdaterTireRL();
                    break;
                case 118:
                    WCSaipaShahinTireAct.this.mUpdaterTireRR();
                    break;
                case 119:
                    WCSaipaShahinTireAct.this.mUpdaterTempFL();
                    break;
                case 120:
                    WCSaipaShahinTireAct.this.mUpdaterTempFR();
                    break;
                case 121:
                    WCSaipaShahinTireAct.this.mUpdaterTempRL();
                    break;
                case 122:
                    WCSaipaShahinTireAct.this.mUpdaterTempRR();
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
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTireWarn() {
        int value = DataCanbus.DATA[114];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tireflalarm);
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setTextColor(-65536);
                break;
        }
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[119];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[120];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[121];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[122];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[115];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[116];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[117];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[118];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }
}
