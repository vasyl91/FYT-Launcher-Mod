package com.syu.carinfo.geshitu.wc;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCRenaultCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 185:
                    WCRenaultCarTire.this.mUpdaterTireFL();
                    break;
                case 186:
                    WCRenaultCarTire.this.mUpdaterTireFR();
                    break;
                case 187:
                    WCRenaultCarTire.this.mUpdaterTireRL();
                    break;
                case 188:
                    WCRenaultCarTire.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[185];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[186];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[187];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[188];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kPa");
        }
    }
}
