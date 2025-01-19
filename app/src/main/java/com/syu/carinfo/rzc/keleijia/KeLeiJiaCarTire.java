package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KeLeiJiaCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 139:
                    KeLeiJiaCarTire.this.mUpdaterTireFL();
                    break;
                case 140:
                    KeLeiJiaCarTire.this.mUpdaterTireFR();
                    break;
                case 141:
                    KeLeiJiaCarTire.this.mUpdaterTireRL();
                    break;
                case 142:
                    KeLeiJiaCarTire.this.mUpdaterTireRR();
                    break;
                case 143:
                    KeLeiJiaCarTire.this.updaterTireWarn();
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
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[139];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + CamryData.PRESSURE_UNIT_BAR);
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[140];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + CamryData.PRESSURE_UNIT_BAR);
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[141];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + CamryData.PRESSURE_UNIT_BAR);
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[142];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + CamryData.PRESSURE_UNIT_BAR);
        }
    }

    
    public void updaterTireWarn() {
        int value = DataCanbus.DATA[143];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state0);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state3);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state4);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state5);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state6);
                break;
        }
    }
}
