package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCLeepMotorCarTire extends BaseActivity {
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 117:
                    WCLeepMotorCarTire.this.mUpdaterTireFL();
                    break;
                case 118:
                    WCLeepMotorCarTire.this.mUpdaterTireFR();
                    break;
                case 119:
                    WCLeepMotorCarTire.this.mUpdaterTireRL();
                    break;
                case 120:
                    WCLeepMotorCarTire.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[117];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire1) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[118];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire2) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[119];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire3) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[120];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire4) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }
}
