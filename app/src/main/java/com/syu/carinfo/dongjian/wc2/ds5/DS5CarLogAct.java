package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5CarLogAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    DS5CarLogAct.this.updaterSpeed();
                    break;
                case 99:
                    DS5CarLogAct.this.updaterOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterSpeed() {
        int xingshiSpeedValue = DataCanbus.DATA[98];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_xingshi_speed_tv)).setText(xingshiSpeedValue + "Km/h");
    }

    
    public void updaterOil() {
        int xunshiOilValue = DataCanbus.DATA[99];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_xunshi_oil_tv)).setText(String.valueOf(String.format("%.1f", Float.valueOf(xunshiOilValue / 10.0f))) + "L/100Km");
    }
}
