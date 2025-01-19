package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DJ_Guanzhi_TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    DJ_Guanzhi_TireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    DJ_Guanzhi_TireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    DJ_Guanzhi_TireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    DJ_Guanzhi_TireAct.this.mUpdaterTireRR();
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
        DataCanbus.PROXY.cmd(1, new int[]{37}, null, null);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
        }
    }
}
