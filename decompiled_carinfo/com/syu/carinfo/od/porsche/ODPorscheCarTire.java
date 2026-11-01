package com.syu.carinfo.od.porsche;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODPorscheCarTire extends BaseActivity {
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    ODPorscheCarTire.this.mUpdaterTireFL();
                    break;
                case 99:
                    ODPorscheCarTire.this.mUpdaterTireFR();
                    break;
                case 100:
                    ODPorscheCarTire.this.mUpdaterTireRL();
                    break;
                case 101:
                    ODPorscheCarTire.this.mUpdaterTireRR();
                    break;
                case 102:
                    ODPorscheCarTire.this.mUpdaterTireFL();
                    ODPorscheCarTire.this.mUpdaterTireFR();
                    ODPorscheCarTire.this.mUpdaterTireRL();
                    ODPorscheCarTire.this.mUpdaterTireRR();
                    break;
                case 103:
                case 104:
                    ODPorscheCarTire.this.updaterWalm();
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
        DataCanbus.PROXY.cmd(1, new int[]{102}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{104}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        int unit = DataCanbus.DATA[102];
        if (findViewById(R.id.oudi_changan_tire1) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    int value2 = value * 5;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(value * 10 + "kPa");
                    break;
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        int unit = DataCanbus.DATA[102];
        if (findViewById(R.id.oudi_changan_tire2) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    int value2 = value * 5;
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(value * 10 + "kPa");
                    break;
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        int unit = DataCanbus.DATA[102];
        if (findViewById(R.id.oudi_changan_tire3) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    int value2 = value * 5;
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(value * 10 + "kPa");
                    break;
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[102];
        if (findViewById(R.id.oudi_changan_tire4) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value / 10 + "." + (value % 10) + "bar");
                    break;
                case 1:
                    int value2 = value * 5;
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value2 / 10 + "." + (value2 % 10) + "psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(value * 10 + "kPa");
                    break;
            }
        }
    }

    
    public void updaterWalm() {
        int value = DataCanbus.DATA[103];
        if (((value >> 0) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn1);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
        if (((value >> 1) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn1);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
        if (((value >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn1);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
        if (((value >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn1);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }
}
