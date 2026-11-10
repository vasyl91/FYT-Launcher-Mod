package com.syu.carinfo.wc.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_indexact);
        if (TheApp.getConfiguration() == 1) {
            findViewById(R.id.jeep_car_air).setVisibility(8);
        } else {
            findViewById(R.id.jeep_car_air).setVisibility(0);
        }
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_372_IndexAct.this, Wc_372_FunctionalActi.class);
                    Wc_372_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_airset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_372_IndexAct.this, Air_Activity_All_NewAdd_HP.class);
                    Wc_372_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case 372:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia /* 393588 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia_H /* 459124 */:
            case FinalCanbus.CAR_WC1_Jeep_19ZiYouXia_W /* 524660 */:
            case FinalCanbus.CAR_WC1_Fiat_19_500X /* 590196 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM /* 917876 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_H /* 1048948 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZhiNanZhe_EU /* 1311092 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11CD /* 1442164 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_M /* 1638772 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_M /* 1704308 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM /* 1900916 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_M /* 1966452 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_H /* 2031988 */:
                findViewById(R.id.jeep_car_cd_view).setVisibility(0);
                break;
            default:
                findViewById(R.id.jeep_car_cd_view).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_IndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_372_IndexAct.this, Wc_372_CdAct.class);
                    Wc_372_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_IndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_372_IndexAct.this, Wc_372_TireAct.class);
                    Wc_372_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
