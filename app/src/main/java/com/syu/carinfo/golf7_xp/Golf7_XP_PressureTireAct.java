package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_PressureTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_PressureTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 69:
                    Golf7_XP_PressureTireAct.this.uTireUnit(DataCanbus.DATA[updateCode]);
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFL();
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFR();
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRL();
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRR();
                    break;
                case 158:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFL();
                    break;
                case 159:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireFR();
                    break;
                case 160:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRL();
                    break;
                case 161:
                    Golf7_XP_PressureTireAct.this.mUpdaterTireRR();
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
        DataCanbus.PROXY.cmd(98, new int[]{102, 255}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.notifyCanbus);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        String str = "";
        int value = DataCanbus.DATA[158];
        if (this.tireUnitID == 0) {
            str = String.valueOf(value / 10.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 1) {
            str = String.valueOf(value / 2.0f) + getTireUnit(this.tireUnitID);
        } else if (this.tireUnitID == 2) {
            str = String.valueOf(value * 10) + getTireUnit(this.tireUnitID);
        }
        ((TextView) findViewById(R.id.rzc_golf_tv_car_tire_0)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        String str = "";
        int value = DataCanbus.DATA[159];
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
        int value = DataCanbus.DATA[160];
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
        int value = DataCanbus.DATA[161];
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
