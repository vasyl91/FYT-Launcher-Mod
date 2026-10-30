package com.syu.carinfo.lz.jaguar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TDLandRoverIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
            case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
            case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
            case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
        }
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                        case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                        case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
                        case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                            intent.setClass(TDLandRoverIndexAct.this, RZCLandRoverDataIndexActi.class);
                            break;
                        default:
                            intent.setClass(TDLandRoverIndexAct.this, TDLandRoverEcoDataIndexActi.class);
                            break;
                    }
                    TDLandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                        case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                        case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
                        case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                            intent.setClass(TDLandRoverIndexAct.this, RZCLandRoverNewCarinfoAct.class);
                            break;
                        default:
                            intent.setClass(TDLandRoverIndexAct.this, TDLandRoverNewCarinfoAct.class);
                            break;
                    }
                    TDLandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(TDLandRoverIndexAct.this, TDLandRoverCarSet.class);
                    TDLandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                        case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                        case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
                        case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                            intent.setClass(TDLandRoverIndexAct.this, RZCLandRoverAirSet.class);
                            break;
                        default:
                            intent.setClass(TDLandRoverIndexAct.this, TDLandRoverAirSet.class);
                            break;
                    }
                    TDLandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(TDLandRoverIndexAct.this, TDLandRoverCarSeatSet.class);
                    TDLandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
