package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GolfTireAct_TuAng_Wc extends BaseActivity {
    int curVal;
    int defVal;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 184:
                    GolfTireAct_TuAng_Wc.this.uTireFL(val);
                    break;
                case 185:
                    GolfTireAct_TuAng_Wc.this.uTireFR(val);
                    break;
                case 186:
                    GolfTireAct_TuAng_Wc.this.uTireRL(val);
                    break;
                case 187:
                    GolfTireAct_TuAng_Wc.this.uTireRR(val);
                    break;
                case 251:
                    GolfTireAct_TuAng_Wc.this.uTireDisplay(val);
                    break;
                case 252:
                    GolfTireAct_TuAng_Wc.this.uTireUnit(val);
                    break;
            }
        }
    };
    private int tireUnitID = 0;
    private int uFL = 0;
    private int uFR = 0;
    private int uRR = 0;
    private int uRL = 0;
    String strTireUnit = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf_tire_wc);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.notifyCanbus);
    }

    protected void uTireDisplay(int i) {
        int color = (i & 128) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)).setTextColor(getResources().getColor(color));
        }
        int color1 = (i & 64) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_1)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_1)).setTextColor(getResources().getColor(color1));
        }
        int color2 = (i & 32) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_2)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_2)).setTextColor(getResources().getColor(color2));
        }
        int color3 = (i & 16) == 0 ? 2131099649 : 2131099658;
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_3)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_3)).setTextColor(getResources().getColor(color3));
        }
    }

    protected void uTireUnit(int i) {
        this.tireUnitID = i;
        this.strTireUnit = getTireUnit(this.tireUnitID);
        uTireFL(this.uFL);
        uTireFR(this.uFR);
        uTireRR(this.uRR);
        uTireRL(this.uRL);
    }

    private String getTireUnit(int i) {
        if (i == 0) {
            this.strTireUnit = "kpa";
        } else if (i == 1) {
            this.strTireUnit = "bar";
        } else if (i == 2) {
            this.strTireUnit = "psi";
        }
        return this.strTireUnit;
    }

    
    public void uTireFL(int val) {
        String str;
        this.uFL = val;
        this.defVal = (val >> 16) & 65535;
        this.curVal = val & 65535;
        if (this.tireUnitID == 1) {
            str = String.valueOf(this.curVal / 10.0f) + "/" + (this.defVal / 10.0f);
        } else {
            str = String.valueOf(this.curVal / 10) + "/" + (this.defVal / 10);
        }
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)).setText("(" + str + ")" + this.strTireUnit);
        }
    }

    
    public void uTireFR(int val) {
        String str;
        this.uFR = val;
        this.defVal = (val >> 16) & 65535;
        this.curVal = val & 65535;
        if (this.tireUnitID == 1) {
            str = String.valueOf(this.curVal / 10.0f) + "/" + (this.defVal / 10.0f);
        } else {
            str = String.valueOf(this.curVal / 10) + "/" + (this.defVal / 10);
        }
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_1)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_1)).setText("(" + str + ")" + this.strTireUnit);
        }
    }

    
    public void uTireRL(int val) {
        String str;
        this.uRL = val;
        this.defVal = (val >> 16) & 65535;
        this.curVal = val & 65535;
        if (this.tireUnitID == 1) {
            str = String.valueOf(this.curVal / 10.0f) + "/" + (this.defVal / 10.0f);
        } else {
            str = String.valueOf(this.curVal / 10) + "/" + (this.defVal / 10);
        }
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_2)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_2)).setText("(" + str + ")" + this.strTireUnit);
        }
    }

    
    public void uTireRR(int val) {
        String str;
        this.uRR = val;
        this.defVal = (val >> 16) & 65535;
        this.curVal = val & 65535;
        if (this.tireUnitID == 1) {
            str = String.valueOf(this.curVal / 10.0f) + "/" + (this.defVal / 10.0f);
        } else {
            str = String.valueOf(this.curVal / 10) + "/" + (this.defVal / 10);
        }
        if (((TextView) findViewById(R.id.rzc_golf_tv_car_tire_3)) != null) {
            ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_3)).setText("(" + str + ")" + this.strTireUnit);
        }
    }
}
