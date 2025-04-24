package com.syu.carinfo.toyota.tangdu;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0452_Tangdu_Toyota_All;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ToyotaTangduIcPetrolElectricActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    ToyotaTangduIcPetrolElectricActi.this.mUpdaterBatteryVol();
                    break;
                case 101:
                    ToyotaTangduIcPetrolElectricActi.this.mUpdaterPEStates();
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
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[99];
        if (value > -1 && value < 9) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(Callback_0452_Tangdu_Toyota_All.mPEDrawableId[value]);
        }
    }

    
    public void mUpdaterPEStates() {
        int data = DataCanbus.DATA[101];
        int value1 = data & 1;
        int value2 = data & 2;
        int value3 = data & 4;
        int value4 = data & 8;
        int value5 = data & 16;
        int value6 = data & 32;
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
