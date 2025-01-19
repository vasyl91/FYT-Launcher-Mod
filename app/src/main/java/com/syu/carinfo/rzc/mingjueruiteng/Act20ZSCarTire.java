package com.syu.carinfo.rzc.mingjueruiteng;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Act20ZSCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 160:
                    Act20ZSCarTire.this.mUpdaterTireFL();
                    break;
                case 161:
                    Act20ZSCarTire.this.mUpdaterTireFR();
                    break;
                case 162:
                    Act20ZSCarTire.this.mUpdaterTireRL();
                    break;
                case 163:
                    Act20ZSCarTire.this.mUpdaterTireRR();
                    break;
                case 164:
                    Act20ZSCarTire.this.mUpdaterTempFL();
                    break;
                case 165:
                    Act20ZSCarTire.this.mUpdaterTempFR();
                    break;
                case 166:
                    Act20ZSCarTire.this.mUpdaterTempRL();
                    break;
                case 167:
                    Act20ZSCarTire.this.mUpdaterTempRR();
                    break;
                case 168:
                    Act20ZSCarTire.this.updaterFLWalm();
                    break;
                case 169:
                    Act20ZSCarTire.this.updaterFRWalm();
                    break;
                case 170:
                    Act20ZSCarTire.this.updaterRLWalm();
                    break;
                case 171:
                    Act20ZSCarTire.this.updaterRRWalm();
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
        DataCanbus.PROXY.cmd(0, new int[1], null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[164];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[165];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[166];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[167];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 60) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[160];
        int unit = DataCanbus.DATA[172];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 10) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Psi");
                    break;
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[161];
        int unit = DataCanbus.DATA[172];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Psi");
                break;
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[162];
        int unit = DataCanbus.DATA[172];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Psi");
                break;
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[163];
        int unit = DataCanbus.DATA[172];
        if (value == 65535) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Bar");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Psi");
                break;
        }
    }

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[168];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn1);
                break;
        }
    }

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[169];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn1);
                break;
        }
    }

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[170];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn1);
                break;
        }
    }

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[171];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn1);
                break;
        }
    }
}
