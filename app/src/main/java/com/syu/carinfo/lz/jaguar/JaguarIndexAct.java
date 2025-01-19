package com.syu.carinfo.lz.jaguar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class JaguarIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jaguar_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 15729092) {
                        intent.setClass(JaguarIndexAct.this, JaguarLandRoverCarInfo.class);
                    } else {
                        intent.setClass(JaguarIndexAct.this, JaguarOilMileIndexActi.class);
                    }
                    JaguarIndexAct.this.startActivity(intent);
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
                    intent.setClass(JaguarIndexAct.this, JaguarCarSet.class);
                    JaguarIndexAct.this.startActivity(intent);
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
                    intent.setClass(JaguarIndexAct.this, JaguarCarSeatSet.class);
                    JaguarIndexAct.this.startActivity(intent);
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
                    intent.setClass(JaguarIndexAct.this, JaguarAmbientLightSet.class);
                    JaguarIndexAct.this.startActivity(intent);
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
                    if (LauncherApplication.getConfiguration() == 1) {
                        intent.setClass(JaguarIndexAct.this, JaguarNewCarinfoAct_SP.class);
                    } else {
                        intent.setClass(JaguarIndexAct.this, JaguarNewCarinfoAct.class);
                    }
                    JaguarIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
