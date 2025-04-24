package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class MazdAllCarTire extends BaseActivity {
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 55:
                    MazdAllCarTire.this.mUpdaterTireFL();
                    break;
                case 56:
                    MazdAllCarTire.this.mUpdaterTireFR();
                    break;
                case 57:
                    MazdAllCarTire.this.mUpdaterTireRL();
                    break;
                case 58:
                    MazdAllCarTire.this.mUpdaterTireRR();
                    break;
                case 59:
                case 62:
                    MazdAllCarTire.this.mUpdaterTireAdd();
                    break;
                case 60:
                case 61:
                    MazdAllCarTire.this.mUpdaterTireTitle();
                    break;
                case 64:
                    MazdAllCarTire.this.mUpdaterTireFL();
                    MazdAllCarTire.this.mUpdaterTireFR();
                    MazdAllCarTire.this.mUpdaterTireRL();
                    MazdAllCarTire.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_oudi_zt_t600_tire);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireAdd() {
        int value = DataCanbus.DATA[59];
        int state = DataCanbus.DATA[62];
        int unit = DataCanbus.DATA[64];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText(value / 10 + "." + (value % 10) + "bar");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText(value + "psi");
                break;
            case 2:
                int value2 = value * 25;
                ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText(value2 / 10 + "." + (value2 % 10) + "kPa");
                break;
        }
    }

    
    public void mUpdaterTireTitle() {
        int value = DataCanbus.DATA[60];
        int warn = DataCanbus.DATA[61];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tire_pressure_miss);
        } else if (warn == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.tireflnormal);
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[55];
        int unit = DataCanbus.DATA[64];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (findViewById(R.id.oudi_changan_tire1) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value + "psi");
                    break;
                case 2:
                    int value2 = value * 25;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value2 / 10 + "." + (value2 % 10) + "kPa");
                    break;
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[56];
        int unit = DataCanbus.DATA[64];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (findViewById(R.id.oudi_changan_tire2) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value + "psi");
                    break;
                case 2:
                    int value2 = value * 25;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value2 / 10 + "." + (value2 % 10) + "kPa");
                    break;
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[57];
        int unit = DataCanbus.DATA[64];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (findViewById(R.id.oudi_changan_tire3) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value + "psi");
                    break;
                case 2:
                    int value2 = value * 25;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value2 / 10 + "." + (value2 % 10) + "kPa");
                    break;
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[58];
        int unit = DataCanbus.DATA[64];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (findViewById(R.id.oudi_changan_tire4) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value + "psi");
                    break;
                case 2:
                    int value2 = value * 25;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value2 / 10 + "." + (value2 % 10) + "kPa");
                    break;
            }
        }
    }
}
