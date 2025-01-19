package com.syu.carinfo.xbs.tule;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XBSTuleTireActDZSJ extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 112:
                    XBSTuleTireActDZSJ.this.mUpdaterTireFL();
                    break;
                case 113:
                    XBSTuleTireActDZSJ.this.mUpdaterTireFR();
                    break;
                case 114:
                    XBSTuleTireActDZSJ.this.mUpdaterTireRL();
                    break;
                case 115:
                    XBSTuleTireActDZSJ.this.mUpdaterTireRR();
                    break;
                case 116:
                    XBSTuleTireActDZSJ.this.updaterFLWalm();
                    break;
                case 117:
                    XBSTuleTireActDZSJ.this.updaterFRWalm();
                    break;
                case 118:
                    XBSTuleTireActDZSJ.this.updaterRLWalm();
                    break;
                case 119:
                    XBSTuleTireActDZSJ.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_tule_dzsj_tire);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[112];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[113];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[114];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[115];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[116];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-65536);
                break;
        }
    }

    
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[117];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-65536);
                break;
        }
    }

    
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[118];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-65536);
                break;
        }
    }

    
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[119];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-65536);
                break;
        }
    }
}
