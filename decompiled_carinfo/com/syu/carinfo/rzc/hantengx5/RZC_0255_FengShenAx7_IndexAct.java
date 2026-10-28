package com.syu.carinfo.rzc.hantengx5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.hava.ActivityHava18H6SetAct;
import com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct;
import com.syu.carinfo.od.tusheng.RZC_NaZHijieU6_CarSettingAct;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_0255_FengShenAx7_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_indexact);
        findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(8);
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case 339:
                        case FinalCanbus.CAR_RZC4_PSA_19_C4L /* 131411 */:
                        case FinalCanbus.CAR_RZC4_PSA_19_508 /* 196947 */:
                        case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_L /* 262483 */:
                        case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_M /* 328019 */:
                        case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_H /* 393555 */:
                        case FinalCanbus.CAR_RZC4_PSA_ALL_M /* 459091 */:
                        case FinalCanbus.CAR_RZC4_PSA_ALL_H /* 524627 */:
                        case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
                        case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
                        case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
                        case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
                        case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
                        case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
                        case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
                        case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
                        case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                            intent.setClass(RZC_0255_FengShenAx7_IndexAct.this, RZC_BZ408IndexActi.class);
                            break;
                        case FinalCanbus.CAR_447_RZC_19IX45 /* 262591 */:
                        case FinalCanbus.CAR_447_RZC_19IX45_H /* 328127 */:
                        case FinalCanbus.CAR_447_RZC_19IX45_Top /* 393663 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19Tusheng /* 459199 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19Tusheng_H /* 524735 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5 /* 590271 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5_H /* 655807 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K3 /* 721343 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_KX3 /* 1114559 */:
                            intent.setClass(RZC_0255_FengShenAx7_IndexAct.this, OD_19Tusheng_CarSettingAct.class);
                            break;
                        case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
                        case FinalCanbus.CAR_RZC_XP1_M6_17 /* 917748 */:
                        case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
                            intent.setClass(RZC_0255_FengShenAx7_IndexAct.this, ActivityHava18H6SetAct.class);
                            break;
                        case FinalCanbus.CAR_439_RZC_CanAdd1 /* 4850103 */:
                            intent.setClass(RZC_0255_FengShenAx7_IndexAct.this, RZC_NaZHijieU6_CarSettingAct.class);
                            break;
                        default:
                            intent.setClass(RZC_0255_FengShenAx7_IndexAct.this, RZC_0255_FengShenAx7_CarSettingAct.class);
                            break;
                    }
                    RZC_0255_FengShenAx7_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
