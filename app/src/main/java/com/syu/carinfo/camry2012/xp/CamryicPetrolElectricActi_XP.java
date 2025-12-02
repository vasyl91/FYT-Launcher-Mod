package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryicPetrolElectricActi_XP extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                    switch (updateCode) {
                        case 148:
                            CamryicPetrolElectricActi_XP.this.mUpdaterBatteryVol(value);
                            break;
                        case 150:
                            CamryicPetrolElectricActi_XP.this.mUpdaterPEStates(value);
                            break;
                    }
                default:
                    switch (updateCode) {
                        case 100:
                            CamryicPetrolElectricActi_XP.this.mUpdaterPEStates(value);
                            break;
                        case 197:
                            CamryicPetrolElectricActi_XP.this.mUpdaterBatteryVol(value);
                            break;
                    }
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    @Override
    public void removeNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
                break;
        }
    }

    
    public void mUpdaterBatteryVol(int value) {
        if (value > -1 && value < 9) {
            ((TextView) findViewById(R.id.camry_tv_pe_battery)).setBackgroundResource(CamryData.mPEDrawableId[value]);
        }
    }

    
    public void mUpdaterPEStates(int data) {
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
