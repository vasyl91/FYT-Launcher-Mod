package com.syu.carinfo.rzc.andra;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LzNissan05CimaTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    LzNissan05CimaTireAct.this.mUpdaterTireFL();
                    break;
                case 107:
                    LzNissan05CimaTireAct.this.mUpdaterTireFR();
                    break;
                case 108:
                    LzNissan05CimaTireAct.this.mUpdaterTireRL();
                    break;
                case 109:
                    LzNissan05CimaTireAct.this.mUpdaterTireRR();
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
        DataCanbus.PROXY.cmd(1, new int[]{54}, null, null);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[106];
        if ((32768 & value) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = value & 32767;
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2) + "Kpa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[107];
        if ((32768 & value) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = value & 32767;
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2) + "Kpa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[108];
        if ((32768 & value) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = value & 32767;
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2) + "Kpa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[109];
        if ((32768 & value) == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = value & 32767;
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2) + "Kpa");
        }
    }
}
