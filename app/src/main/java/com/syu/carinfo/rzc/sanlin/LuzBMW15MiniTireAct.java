package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzBMW15MiniTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 131:
                    LuzBMW15MiniTireAct.this.updaterFLWalm();
                    break;
                case 132:
                    LuzBMW15MiniTireAct.this.updaterFRWalm();
                    break;
                case 133:
                    LuzBMW15MiniTireAct.this.updaterRLWalm();
                    break;
                case 134:
                    LuzBMW15MiniTireAct.this.updaterRRWalm();
                    break;
                case 138:
                    LuzBMW15MiniTireAct.this.mUpdaterTireFL();
                    LuzBMW15MiniTireAct.this.mUpdaterTireFR();
                    LuzBMW15MiniTireAct.this.mUpdaterTireRL();
                    LuzBMW15MiniTireAct.this.mUpdaterTireRR();
                    break;
                case 139:
                    LuzBMW15MiniTireAct.this.mUpdaterTireFL();
                    break;
                case 140:
                    LuzBMW15MiniTireAct.this.mUpdaterTireFR();
                    break;
                case 141:
                    LuzBMW15MiniTireAct.this.mUpdaterTireRL();
                    break;
                case 142:
                    LuzBMW15MiniTireAct.this.mUpdaterTireRR();
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
        DataCanbus.PROXY.cmd(2, new int[]{73}, null, null);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText("");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_pack_break_down);
                break;
        }
    }

    
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[132];
        ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText("");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_pack_break_down);
                break;
        }
    }

    
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[133];
        ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText("");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_pack_break_down);
                break;
        }
    }

    
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[134];
        ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        switch (system) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText("");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_pack_break_down);
                break;
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[139];
        int unit = DataCanbus.DATA[138];
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            if (value >= 65280) {
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("----");
            }
            switch (unit) {
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_KPA);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                default:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[140];
        int unit = DataCanbus.DATA[138];
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            if (value >= 65280) {
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("----");
            }
            switch (unit) {
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_KPA);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                default:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[141];
        int unit = DataCanbus.DATA[138];
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            if (value >= 65280) {
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("----");
            }
            switch (unit) {
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_KPA);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                default:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[142];
        int unit = DataCanbus.DATA[138];
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            if (value >= 65280) {
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("----");
            }
            switch (unit) {
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_KPA);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + CamryData.PRESSURE_UNIT_PSI);
                    break;
                default:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                    break;
            }
        }
    }
}
