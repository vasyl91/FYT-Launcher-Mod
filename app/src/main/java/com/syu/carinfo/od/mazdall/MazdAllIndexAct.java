package com.syu.carinfo.od.mazdall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class MazdAllIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_od_mazdall_indexact);
        if (DataCanbus.DATA[1000] == 2097591) {
            findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(0);
        } else {
            findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MazdAllIndexAct.this, MazdAllCarInfo.class);
                    MazdAllIndexAct.this.startActivity(intent);
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
                    intent.setClass(MazdAllIndexAct.this, MazdAllCarCD.class);
                    MazdAllIndexAct.this.startActivity(intent);
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
                    intent.setClass(MazdAllIndexAct.this, MazdAllCarSet.class);
                    MazdAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_tireinfo).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(MazdAllIndexAct.this, MazdAllCarTire.class);
                    MazdAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
