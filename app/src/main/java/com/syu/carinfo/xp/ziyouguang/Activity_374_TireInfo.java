package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Activity_374_TireInfo extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 405:
                    Activity_374_TireInfo.this.mUpdaterTireFL();
                    Activity_374_TireInfo.this.mUpdaterTireFR();
                    Activity_374_TireInfo.this.mUpdaterTireRL();
                    Activity_374_TireInfo.this.mUpdaterTireRR();
                    break;
                case 406:
                    Activity_374_TireInfo.this.mUpdaterTireFL();
                    break;
                case 407:
                    Activity_374_TireInfo.this.mUpdaterTireFR();
                    break;
                case 408:
                    Activity_374_TireInfo.this.mUpdaterTireRL();
                    break;
                case 409:
                    Activity_374_TireInfo.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_tule_tire);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[405].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[406].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[407].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[408].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[409].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[405].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[406].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[407].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[408].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[409].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[406];
        int unit = DataCanbus.DATA[405];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_BAR);
                    break;
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[407];
        int unit = DataCanbus.DATA[405];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_BAR);
                    break;
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[408];
        int unit = DataCanbus.DATA[405];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_BAR);
                    break;
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[409];
        int unit = DataCanbus.DATA[405];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 0.1f) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 0.1f) + CamryData.PRESSURE_UNIT_BAR);
                    break;
            }
        }
    }
}
