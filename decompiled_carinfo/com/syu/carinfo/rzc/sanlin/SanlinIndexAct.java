package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.jili.RZCNisaanGuishiCarSettingsAct;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class SanlinIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_huiteng_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        if (DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_orinal_car_fuc);
        } else if (DataCanbus.DATA[1000] == 1376446) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_guandao_amp);
        } else if (DataCanbus.DATA[1000] == 15860165) {
            ((TextView) findViewById(R.id.tv_text1)).setText("EV");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Nissan_Tianlai_Amp /* 1376446 */:
                            intent.setClass(SanlinIndexAct.this, RZCNissanAmpCarSet.class);
                            break;
                        case FinalCanbus.CAR_453_LZ_BMW_Mini_15 /* 1507781 */:
                            intent.setClass(SanlinIndexAct.this, LuZBMW15MiniCarInfo.class);
                            break;
                        case FinalCanbus.CAR_454_RZC_Sprinter_22 /* 6881734 */:
                            intent.setClass(SanlinIndexAct.this, RzcBenzCCarSet.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                            intent.setClass(SanlinIndexAct.this, LZMaseratiCarInfo.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                        case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                            intent.setClass(SanlinIndexAct.this, LuZVolvoCarInfo.class);
                            break;
                        case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                            intent.setClass(SanlinIndexAct.this, RZCVinFastPlusCarInfo.class);
                            break;
                        default:
                            intent.setClass(SanlinIndexAct.this, SanlinCarInfo.class);
                            break;
                    }
                    SanlinIndexAct.this.startActivity(intent);
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
                        case FinalCanbus.CAR_RZC_Nissan_Tianlai_Amp /* 1376446 */:
                            intent.setClass(SanlinIndexAct.this, RZCNisaanGuishiCarSettingsAct.class);
                            break;
                        case FinalCanbus.CAR_453_LZ_BMW_Mini_15 /* 1507781 */:
                            intent.setClass(SanlinIndexAct.this, LuzBMW15MiniCarSet.class);
                            break;
                        case FinalCanbus.CAR_454_RZC_Sprinter_22 /* 6881734 */:
                            intent.setClass(SanlinIndexAct.this, RZCBeiqiBJ90CarSet.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                            intent.setClass(SanlinIndexAct.this, LZMaseratiCarSet.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                        case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                            intent.setClass(SanlinIndexAct.this, LuzVolvoCarSet.class);
                            break;
                        case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                            intent.setClass(SanlinIndexAct.this, RZCVinFastPlusCarSet.class);
                            break;
                        default:
                            intent.setClass(SanlinIndexAct.this, SanlinCarSet.class);
                            break;
                    }
                    SanlinIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
