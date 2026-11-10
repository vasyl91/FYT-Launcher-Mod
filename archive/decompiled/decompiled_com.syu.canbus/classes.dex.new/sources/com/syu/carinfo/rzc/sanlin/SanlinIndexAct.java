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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class SanlinIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 14811591) {
            setContentView(R.layout.layout_0455_lz_ford_quanshunt8_indexact);
        } else {
            setContentView(R.layout.layout_huiteng_indexact);
        }
        if (findViewById(R.id.layout_view1) != null) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_orinal_car_fuc);
        } else if (DataCanbus.DATA[1000] == 1376446 || DataCanbus.DATA[1000] == 4325566) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_guandao_amp);
        } else if (DataCanbus.DATA[1000] == 15860165) {
            ((TextView) findViewById(R.id.tv_text1)).setText("EV");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.SanlinIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Nissan_Tianlai_Amp /* 1376446 */:
                        case FinalCanbus.CAR_RZC_Nissan_Elgrand_12 /* 4325566 */:
                            intent.setClass(SanlinIndexAct.this, RZCNissanAmpCarSet.class);
                            break;
                        case FinalCanbus.CAR_453_LZ_BMW_Mini_15 /* 1507781 */:
                            intent.setClass(SanlinIndexAct.this, LuZBMW15MiniCarInfo.class);
                            break;
                        case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
                        case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
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
                        case FinalCanbus.CAR_455_LZ_Ford_QuanShun_T8 /* 14811591 */:
                            intent.setClass(SanlinIndexAct.this, LZFordQuanshunT8CarInfo.class);
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
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.SanlinIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Nissan_Tianlai_Amp /* 1376446 */:
                        case FinalCanbus.CAR_RZC_Nissan_Elgrand_12 /* 4325566 */:
                            intent.setClass(SanlinIndexAct.this, RZCNisaanGuishiCarSettingsAct.class);
                            break;
                        case FinalCanbus.CAR_453_LZ_BMW_Mini_15 /* 1507781 */:
                            intent.setClass(SanlinIndexAct.this, LuzBMW15MiniCarSet.class);
                            break;
                        case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
                        case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
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
                        case FinalCanbus.CAR_455_LZ_Ford_QuanShun_T8 /* 14811591 */:
                            intent.setClass(SanlinIndexAct.this, LZFordQuanshunT8RS485CarInfo.class);
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
