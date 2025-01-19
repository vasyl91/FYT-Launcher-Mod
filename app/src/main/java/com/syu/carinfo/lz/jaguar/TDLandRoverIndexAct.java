package com.syu.carinfo.lz.jaguar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class TDLandRoverIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
            case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
        }
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                        case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
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
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                        case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
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
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                        case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
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
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
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
