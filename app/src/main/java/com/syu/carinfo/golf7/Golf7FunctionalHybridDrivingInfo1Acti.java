package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalHybridDrivingInfo1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", "noNotify: " + updateCode);
            switch (updateCode) {
                case 316:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeE();
                    break;
                case 317:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeHybrid();
                    break;
                case 318:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeBatteryMaintain();
                    break;
                case 319:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeBatteryCharge();
                    break;
                case 320:
                    Golf7FunctionalHybridDrivingInfo1Acti.this.mUpdaterDriverModeGte();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_hybrid_driving_info1);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_e_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{32}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_hybrid_power_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{33}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_maintain_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{34}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_charge_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{35}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_driver_gte_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{36}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[316].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[317].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[318].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[319].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[316].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[317].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[318].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[319].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDriverModeE() {
        int value = DataCanbus.DATA[316];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_e_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_e_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_e_mode), false);
    }

    
    public void mUpdaterDriverModeHybrid() {
        int value = DataCanbus.DATA[317];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_hybrid_power_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_hybrid_power_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_hybrid_power_mode), false);
    }

    
    public void mUpdaterDriverModeBatteryMaintain() {
        int value = DataCanbus.DATA[318];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_battery_maintain_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_maintain_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_battery_maintain_mode), false);
    }

    
    public void mUpdaterDriverModeBatteryCharge() {
        int value = DataCanbus.DATA[319];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_driver_set_battery_charge_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_driver_battery_charge_mode), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_driver_set_battery_charge_mode), false);
    }

    
    public void mUpdaterDriverModeGte() {
        int value = DataCanbus.DATA[320];
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
