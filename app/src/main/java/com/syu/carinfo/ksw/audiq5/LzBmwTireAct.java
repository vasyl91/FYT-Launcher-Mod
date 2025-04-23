package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LzBmwTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 112:
                    LzBmwTireAct.this.mUpdaterTireFL();
                    break;
                case 113:
                    LzBmwTireAct.this.mUpdaterTireFR();
                    break;
                case 114:
                    LzBmwTireAct.this.mUpdaterTireRL();
                    break;
                case 115:
                    LzBmwTireAct.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[112];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(R.string.tireflalarm);
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[113];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(R.string.tireflalarm);
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[114];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(R.string.tireflalarm);
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[115];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(R.string.tireflalarm);
        }
    }
}
