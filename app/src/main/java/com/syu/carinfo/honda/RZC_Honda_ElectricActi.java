package com.syu.carinfo.honda;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_Honda_ElectricActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 308:
                    RZC_Honda_ElectricActi.this.mUpdaterPEStates();
                    break;
                case 309:
                    RZC_Honda_ElectricActi.this.mUpdaterBatteryVol();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_petrol_electric);
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[309].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[309].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[309];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_7);
                break;
            case 8:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_8);
                break;
            case 9:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_9);
                break;
            case 10:
                ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(R.drawable.ic_honda_battery_level_10);
                break;
        }
    }

    
    public void mUpdaterPEStates() {
        int data = DataCanbus.DATA[308];
        int bit7 = (data >> 7) & 1;
        int bit6 = (data >> 6) & 1;
        int bit5 = (data >> 5) & 1;
        int bit4 = (data >> 4) & 1;
        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_camry_petrol_electric_wc);
        ((TextView) findViewById(R.id.camry_tv_pe_6)).setBackgroundResource(R.drawable.ic_camry_tv_6_n);
        ((TextView) findViewById(R.id.camry_tv_pe_3)).setBackgroundResource(R.drawable.ic_camry_tv_3_n);
        ((TextView) findViewById(R.id.camry_tv_pe_1)).setBackgroundResource(R.drawable.ic_camry_tv_1_n);
        ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_n);
        ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_n);
        ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_n);
        if (bit7 == 1) {
            ((TextView) findViewById(R.id.camry_tv_pe_3)).setBackgroundResource(R.drawable.ic_camry_tv_3_p);
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_r);
        }
        if (bit6 == 1) {
            ((TextView) findViewById(R.id.camry_tv_pe_1)).setBackgroundResource(R.drawable.ic_camry_tv_1_p);
        }
        if (bit5 == 1) {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_l);
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_p);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_p);
        }
        if (bit4 == 1) {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_r);
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_p_n);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_p_r);
        }
    }
}
