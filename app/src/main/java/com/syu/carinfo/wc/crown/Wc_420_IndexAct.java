package com.syu.carinfo.wc.crown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class Wc_420_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_420_crown_indexact);
        if (LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.jeep_car_air).setVisibility(8);
        } else {
            findViewById(R.id.jeep_car_air).setVisibility(0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX300 /* 524708 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX350 /* 590244 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case 420:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_09IS_Low /* 721316 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_420_IndexAct.this, wc_420_crown_CarfuelInfAct.class);
                    Wc_420_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_airset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_420_IndexAct.this, wc_420_crown_AirControlAct.class);
                    Wc_420_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_420_IndexAct.this, wc_420_crown_AmpSetAct.class);
                    Wc_420_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_420_IndexAct.this, Wc_420_crown_CarCD.class);
                    Wc_420_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
