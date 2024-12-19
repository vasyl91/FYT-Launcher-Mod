package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcGolfPressureTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.RzcGolfPressureTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    RzcGolfPressureTireAct.this.mUpdaterTireFL();
                    break;
                case 117:
                    RzcGolfPressureTireAct.this.mUpdaterTireFR();
                    break;
                case 118:
                    RzcGolfPressureTireAct.this.mUpdaterTireRL();
                    break;
                case 119:
                    RzcGolfPressureTireAct.this.mUpdaterTireRR();
                    break;
                case 201:
                    RzcGolfPressureTireAct.this.uTireDisplay(DataCanbus.DATA[updateCode]);
                    break;
                case 202:
                    RzcGolfPressureTireAct.this.uTireUnit(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private int tireUnitID = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_golf_tire);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        String str = "";
        int value = DataCanbus.DATA[116];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        String str = "";
        int value = DataCanbus.DATA[117];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_1)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        String str = "";
        int value = DataCanbus.DATA[118];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_2)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        String str = "";
        int value = DataCanbus.DATA[119];
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
