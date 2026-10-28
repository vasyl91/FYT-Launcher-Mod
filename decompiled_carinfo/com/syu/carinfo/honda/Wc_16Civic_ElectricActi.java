package com.syu.carinfo.honda;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_16Civic_ElectricActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 207:
                    Wc_16Civic_ElectricActi.this.mUpdaterBatteryVol();
                    break;
                case 208:
                    Wc_16Civic_ElectricActi.this.mUpdaterPEStates();
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
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[207];
        if (value == 0) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[0]);
            return;
        }
        if (value <= 12) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[1]);
            return;
        }
        if (value <= 25) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[2]);
            return;
        }
        if (value <= 37) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[3]);
            return;
        }
        if (value <= 50) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[4]);
            return;
        }
        if (value <= 62) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[5]);
            return;
        }
        if (value <= 75) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[6]);
        } else if (value <= 87) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[7]);
        } else if (value <= 100) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[8]);
        }
    }

    
    public void mUpdaterPEStates() {
        int data = DataCanbus.DATA[208];
        int value1 = data & 1;
        int value2 = data & 2;
        int value3 = data & 4;
        int value4 = data & 8;
        int value5 = data & 16;
        int value6 = data & 32;
        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_camry_petrol_electric_wc);
        ((TextView) findViewById(R.id.camry_tv_pe_6)).setBackgroundResource(R.drawable.ic_camry_tv_6_n);
        ((TextView) findViewById(R.id.camry_tv_pe_3)).setBackgroundResource(value3 == 0 ? R.drawable.ic_camry_tv_3_n : R.drawable.ic_camry_tv_3_p);
        ((TextView) findViewById(R.id.camry_tv_pe_1)).setBackgroundResource(value4 == 0 ? R.drawable.ic_camry_tv_1_n : R.drawable.ic_camry_tv_1_p);
        if (value1 == 1) {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_r);
        } else if (value5 == 16) {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_p_l);
        } else {
            ((TextView) findViewById(R.id.camry_tv_pe_5)).setBackgroundResource(R.drawable.ic_camry_tv_5_n);
        }
        if (value2 != 0) {
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_p);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_p);
        } else if (value6 != 0) {
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_p_n);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_p_r);
        } else {
            ((TextView) findViewById(R.id.camry_tv_pe_2)).setBackgroundResource(R.drawable.ic_camry_tv_2_n);
            ((TextView) findViewById(R.id.camry_tv_pe_4)).setBackgroundResource(R.drawable.ic_camry_tv_4_n);
        }
    }
}
