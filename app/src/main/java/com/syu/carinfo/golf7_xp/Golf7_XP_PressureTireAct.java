package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_PressureTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 166:
                    Golf7_XP_PressureTireAct.this.uTireUnit(DataCanbus.DATA[updateCode]);
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFL();
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFR();
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRL();
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRR();
                    break;
                case 212:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFL();
                    break;
                case 213:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFR();
                    break;
                case 214:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRL();
                    break;
                case 215:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };
    private int tireUnitID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_golf_tire);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{102, 255}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.notifyCanbus);
    }

    protected void uTireUnit(int i) {
        this.tireUnitID = i;
    }

    private String getTireUnit(int i) {
        if (i == 0) {
            return "bar";
        }
        if (i == 1) {
            return "psi";
        }
        if (i != 2) {
            return "";
        }
        return "kpa";
    }

    
    public void mUpdaterTireFL() {
        String str = "";
        int value = DataCanbus.DATA[212];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)).setText(str);
    }

    
    public void mUpdaterTireFR() {
        String str = "";
        int value = DataCanbus.DATA[213];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_1)).setText(str);
    }

    
    public void mUpdaterTireRL() {
        String str = "";
        int value = DataCanbus.DATA[214];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_2)).setText(str);
    }

    
    public void mUpdaterTireRR() {
        String str = "";
        int value = DataCanbus.DATA[215];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_3)).setText(str);
    }
}
