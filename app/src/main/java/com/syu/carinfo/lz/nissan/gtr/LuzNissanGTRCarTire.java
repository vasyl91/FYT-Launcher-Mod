package com.syu.carinfo.lz.nissan.gtr;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzNissanGTRCarTire extends BaseActivity {
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 115:
                case 119:
                    LuzNissanGTRCarTire.this.mUpdaterTireFR();
                    break;
                case 116:
                case 120:
                    LuzNissanGTRCarTire.this.mUpdaterTireFL();
                    break;
                case 117:
                case 121:
                    LuzNissanGTRCarTire.this.mUpdaterTireRR();
                    break;
                case 118:
                case 122:
                    LuzNissanGTRCarTire.this.mUpdaterTireRL();
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
        DataCanbus.PROXY.cmd(2, new int[]{54}, null, null);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[116];
        int state = DataCanbus.DATA[120];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            int value2 = (value * 145) / 100;
            if (findViewById(R.id.oudi_changan_tire1) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                return;
            }
            return;
        }
        if (findViewById(R.id.oudi_changan_tire1) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[115];
        int state = DataCanbus.DATA[119];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            int value2 = (value * 145) / 100;
            if (findViewById(R.id.oudi_changan_tire2) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                return;
            }
            return;
        }
        if (findViewById(R.id.oudi_changan_tire2) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[118];
        int state = DataCanbus.DATA[122];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            int value2 = (value * 145) / 100;
            if (findViewById(R.id.oudi_changan_tire3) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                return;
            }
            return;
        }
        if (findViewById(R.id.oudi_changan_tire3) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[117];
        int state = DataCanbus.DATA[121];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            int value2 = (value * 145) / 100;
            if (findViewById(R.id.oudi_changan_tire4) != null) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                return;
            }
            return;
        }
        if (findViewById(R.id.oudi_changan_tire4) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value + "kPa");
        }
    }
}
