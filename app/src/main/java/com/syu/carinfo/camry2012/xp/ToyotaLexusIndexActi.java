package com.syu.carinfo.camry2012.xp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ToyotaLexusIndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0112_rzc_lexus_index);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
                if (LauncherApplication.getConfiguration() != 1) {
                    findViewById(R.id.layout_view2).setVisibility(0);
                    findViewById(R.id.layout_view5).setVisibility(0);
                }
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
        }
        ((Button) findViewById(R.id.wc_geshitu_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusIndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ToyotaLexusIndexActi.this, ToyotaLexusActivityCarCD.class);
                    ToyotaLexusIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.wc_geshitu_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ToyotaLexusIndexActi.this, CamryIndexAct.class);
                    ToyotaLexusIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_429_carradio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ToyotaLexusIndexActi.this, ToyotaLexusActivityCarRadio.class);
                    ToyotaLexusIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_429_carusb)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusIndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ToyotaLexusIndexActi.this, ToyotaLexusActivityCarUSB.class);
                    ToyotaLexusIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_429_ampset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusIndexActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ToyotaLexusIndexActi.this, ToyotaLexusEQActi.class);
                    ToyotaLexusIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
