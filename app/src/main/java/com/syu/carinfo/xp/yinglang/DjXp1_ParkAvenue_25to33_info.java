package com.syu.carinfo.xp.yinglang;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DjXp1_ParkAvenue_25to33_info extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 130:
                    DjXp1_ParkAvenue_25to33_info.this.mUpdateCarSpeed();
                    break;
                case 135:
                    DjXp1_ParkAvenue_25to33_info.this.mUpdateMachineSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0025_dj_parkavenue);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateCarSpeed() {
        int value = DataCanbus.DATA[130];
        if (((TextView) findViewById(R.id.cs75_tv_current_speed)) != null) {
            ((TextView) findViewById(R.id.cs75_tv_current_speed)).setText(String.valueOf(value) + "km/h");
        }
    }

    protected void mUpdateMachineSpeed() {
        int value = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.cs75_tv_engine_speed)) != null) {
            ((TextView) findViewById(R.id.cs75_tv_engine_speed)).setText(String.valueOf(value) + "rpm");
        }
    }
}
