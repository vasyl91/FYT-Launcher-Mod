package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DasAutoXpTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    DasAutoXpTire.this.updaterFLWalm();
                    break;
                case 115:
                    DasAutoXpTire.this.updaterFRWalm();
                    break;
                case 116:
                    DasAutoXpTire.this.updaterRLWalm();
                    break;
                case 117:
                    DasAutoXpTire.this.updaterRRWalm();
                    break;
                case 118:
                case 119:
                    DasAutoXpTire.this.updaterTitleState();
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, 0);
    }

    @Override
    public void init() {
    }

    
    public void updaterTitleState() {
        int value = DataCanbus.DATA[118];
        int value1 = DataCanbus.DATA[119];
        if (value == 2) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.xp_ylford_set_tyre_monitor_init);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state4);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.xp_ylford_set_tyre_monitor_ok);
        }
    }

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[114];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_408_carinfo_95);
                break;
        }
    }

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[115];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_408_carinfo_95);
                break;
        }
    }

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[116];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_408_carinfo_95);
                break;
        }
    }

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[117];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_408_carinfo_95);
                break;
        }
    }
}
