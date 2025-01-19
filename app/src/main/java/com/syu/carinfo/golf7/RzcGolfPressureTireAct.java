package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RzcGolfPressureTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 184:
                    RzcGolfPressureTireAct.this.mUpdaterTireFL();
                    break;
                case 185:
                    RzcGolfPressureTireAct.this.mUpdaterTireFR();
                    break;
                case 186:
                    RzcGolfPressureTireAct.this.mUpdaterTireRL();
                    break;
                case 187:
                    RzcGolfPressureTireAct.this.mUpdaterTireRR();
                    break;
                case 251:
                    RzcGolfPressureTireAct.this.uTireDisplay(DataCanbus.DATA[updateCode]);
                    break;
                case 252:
                    RzcGolfPressureTireAct.this.uTireUnit(DataCanbus.DATA[updateCode]);
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
        DataCanbus.PROXY.cmd(98, new int[]{4}, null, null);
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

    
    public void mUpdaterTireFL() {
        String str = "";
        int value = DataCanbus.DATA[184];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)).setText(str);
    }

    protected void uTireUnit(int i) {
        this.tireUnitID = i;
    }

    protected void uTireDisplay(int i) {
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

    
    public void mUpdaterTireFR() {
        String str = "";
        int value = DataCanbus.DATA[185];
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
        int value = DataCanbus.DATA[186];
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
        int value = DataCanbus.DATA[187];
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
