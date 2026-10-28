package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCSuzukiCarTire extends BaseActivity {
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 133:
                    WCSuzukiCarTire.this.mUpdaterTireFL();
                    break;
                case 134:
                    WCSuzukiCarTire.this.mUpdaterTireFR();
                    break;
                case 135:
                    WCSuzukiCarTire.this.mUpdaterTireRL();
                    break;
                case 136:
                    WCSuzukiCarTire.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[133];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire1) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[134];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire2) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[135];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire3) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[136];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (findViewById(R.id.oudi_changan_tire4) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value / 10 + "." + (value % 10) + "kPa");
        }
    }
}
