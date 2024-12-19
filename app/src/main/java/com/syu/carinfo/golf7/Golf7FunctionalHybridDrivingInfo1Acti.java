package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalHybridDrivingInfo1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHybridDrivingInfo1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", "noNotify: " + updateCode);
            switch (updateCode) {
                case 298:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeE();
                    break;
                case 299:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeHybrid();
                    break;
                case 300:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeBatteryMaintain();
                    break;
                case 301:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeBatteryCharge();
                    break;
                case 302:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeGte();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_hybrid_driving_info1);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_e_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHybridDrivingInfo1Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{32}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_hybrid_power_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHybridDrivingInfo1Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{33}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_maintain_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHybridDrivingInfo1Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{34}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_charge_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHybridDrivingInfo1Acti.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{35}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_gte_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHybridDrivingInfo1Acti.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{36}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[298].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[298].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverModeE() {
        int value = DataCanbus.DATA[298];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_e_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_e_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_e_mode), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverModeHybrid() {
        int value = DataCanbus.DATA[299];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_hybrid_power_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_hybrid_power_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_hybrid_power_mode), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverModeBatteryMaintain() {
        int value = DataCanbus.DATA[300];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_battery_maintain_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_maintain_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_battery_maintain_mode), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverModeBatteryCharge() {
        int value = DataCanbus.DATA[301];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_battery_charge_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_charge_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_battery_charge_mode), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverModeGte() {
        int value = DataCanbus.DATA[302];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_gte_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_gte_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_gte_mode), false);
    }
}
