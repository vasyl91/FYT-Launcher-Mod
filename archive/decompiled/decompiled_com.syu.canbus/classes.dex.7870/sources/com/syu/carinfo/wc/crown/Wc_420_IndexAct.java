package com.syu.carinfo.wc.crown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.carinfo.rzc.sanlin.WC2SanlinAHDActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Wc_420_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_420_crown_indexact);
        findViewById(R.id.jeep_car_air).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case 420:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_09IS_Low /* 721316 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.jeep_car_air).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX300 /* 524708 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX350 /* 590244 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.jeep_car_air).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_ToYoTa_98_00LC100 /* 917924 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.jeep_car_air).setVisibility(0);
                break;
            default:
                findViewById(R.id.jeep_car_air).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                break;
        }
        if (TheApp.getConfiguration() == 1) {
            findViewById(R.id.jeep_car_air).setVisibility(8);
        }
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.crown.Wc_420_IndexAct.1
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.crown.Wc_420_IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_420_IndexAct.this, WC2SanlinAHDActi.class);
                    Wc_420_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_airset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.crown.Wc_420_IndexAct.3
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.crown.Wc_420_IndexAct.4
            @Override // android.view.View.OnClickListener
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
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.crown.Wc_420_IndexAct.5
            @Override // android.view.View.OnClickListener
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
