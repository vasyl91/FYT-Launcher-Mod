package com.syu.carinfo.ford;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class FordCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_mileage)).setText(String.valueOf(value) + " km");
                    break;
                case 143:
                    if (value > 999) {
                        ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText("-- km");
                        break;
                    } else {
                        ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 144:
                    int value2 = (value * 2) + 1;
                    if (value2 > 300) {
                        ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " L/100km");
                        break;
                    }
                case 145:
                    int temp = value / 2;
                    if (temp > 100) {
                        ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText("-- L");
                        break;
                    } else {
                        ((TextView) FordCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText(String.format("%d L", Integer.valueOf(temp)));
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzcford_carinfo);
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }
}
