package com.syu.carinfo.lz.nissan.gtr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class LuzNissanGTRIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_lz_nissan_gtr_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_RZC_Mahindra_Thar_21 /* 1114566 */:
            case FinalCanbus.CAR_454_RZC_Mahindra_XUV_16_Hand /* 1180102 */:
            case FinalCanbus.CAR_454_RZC_TATA_NEXON_21_Hand /* 1245638 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_meter_info);
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_RZC_Mahindra_Thar_21 /* 1114566 */:
                        case FinalCanbus.CAR_454_RZC_Mahindra_XUV_16_Hand /* 1180102 */:
                        case FinalCanbus.CAR_454_RZC_TATA_NEXON_21_Hand /* 1245638 */:
                            intent.setClass(LuzNissanGTRIndexAct.this, RZCMahindraCarInfo.class);
                            break;
                        default:
                            intent.setClass(LuzNissanGTRIndexAct.this, LuzNissanGTRCarInfo.class);
                            break;
                    }
                    LuzNissanGTRIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LuzNissanGTRIndexAct.this, LuzNissanGTRCarOilInfo.class);
                    LuzNissanGTRIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_RZC_Mahindra_Thar_21 /* 1114566 */:
                        case FinalCanbus.CAR_454_RZC_Mahindra_XUV_16_Hand /* 1180102 */:
                        case FinalCanbus.CAR_454_RZC_TATA_NEXON_21_Hand /* 1245638 */:
                            intent.setClass(LuzNissanGTRIndexAct.this, RZCMahindraCarSet.class);
                            break;
                        default:
                            intent.setClass(LuzNissanGTRIndexAct.this, LuzNissanGTRCarSet.class);
                            break;
                    }
                    LuzNissanGTRIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_RZC_Mahindra_Thar_21 /* 1114566 */:
                        case FinalCanbus.CAR_454_RZC_Mahindra_XUV_16_Hand /* 1180102 */:
                        case FinalCanbus.CAR_454_RZC_TATA_NEXON_21_Hand /* 1245638 */:
                            intent.setClass(LuzNissanGTRIndexAct.this, RZCMaheidraCarTire.class);
                            break;
                        default:
                            intent.setClass(LuzNissanGTRIndexAct.this, LuzNissanGTRCarTire.class);
                            break;
                    }
                    LuzNissanGTRIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
