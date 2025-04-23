package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KYCToyotaTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 172:
                    KYCToyotaTireAct.this.mUpdaterTireFL();
                    break;
                case 173:
                    KYCToyotaTireAct.this.mUpdaterTireFR();
                    break;
                case 174:
                    KYCToyotaTireAct.this.mUpdaterTireRL();
                    break;
                case 175:
                    KYCToyotaTireAct.this.mUpdaterTireRR();
                    break;
                case 176:
                    KYCToyotaTireAct.this.mUpdaterTireAdd();
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
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[172];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[173];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[174];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[175];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "bar");
        }
    }

    
    public void mUpdaterTireAdd() {
        int value = DataCanbus.DATA[176];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire_add)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire_add)).setText(String.valueOf(value) + "bar");
        }
    }
}
