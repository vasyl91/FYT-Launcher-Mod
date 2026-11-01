package com.syu.carinfo.wc.crown;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class wc_420_crown_CarfuelInfAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 133:
                    wc_420_crown_CarfuelInfAct.this.updateCarinfo1();
                    break;
                case 134:
                    wc_420_crown_CarfuelInfAct.this.updateCarinfo2();
                    break;
                case 135:
                    wc_420_crown_CarfuelInfAct.this.updateCarinfo3();
                    break;
                case 136:
                    wc_420_crown_CarfuelInfAct.this.updateCarinfo4();
                    break;
                case 137:
                    wc_420_crown_CarfuelInfAct.this.updateCarinfo5();
                    break;
                case 140:
                    wc_420_crown_CarfuelInfAct.this.updateCarinfo6();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0420_wc_fuel_info);
    }

    @Override
    public void onClick(View v) {
        v.getId();
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
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo6() {
        int value = DataCanbus.DATA[140];
        int mileunit = DataCanbus.DATA[139];
        switch (mileunit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km/h");
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[136];
        int hour = value / 60;
        int min = value % 60;
        ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10));
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[135];
        int fuelunit = DataCanbus.DATA[138];
        switch (fuelunit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " MPG");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value * 0.1f) + " L/100km");
                break;
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[134];
        int mileunit = DataCanbus.DATA[139];
        switch (mileunit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[133];
        int fuelunit = DataCanbus.DATA[138];
        switch (fuelunit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " MPG");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + " L/100km");
                break;
        }
    }
}
