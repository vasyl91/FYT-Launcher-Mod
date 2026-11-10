package com.syu.carinfo.xfy.dx7;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XfyDx7PressureTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    XfyDx7PressureTireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    XfyDx7PressureTireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    XfyDx7PressureTireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    XfyDx7PressureTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xfy_dx7_tire);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.xfydx7_tv_car_tire_0)).setText(String.format("%dKPa", Integer.valueOf((int) num)));
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.xfydx7_tv_car_tire_1)).setText(String.format("%dKPa", Integer.valueOf(num)));
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.xfydx7_tv_car_tire_2)).setText(String.format("%dKPa", Integer.valueOf(num)));
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.xfydx7_tv_car_tire_3)).setText(String.format("%dKPa", Integer.valueOf(num)));
    }
}
