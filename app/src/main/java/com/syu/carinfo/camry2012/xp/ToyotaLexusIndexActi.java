package com.syu.carinfo.camry2012.xp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ToyotaLexusIndexActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0112_rzc_lexus_index);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
            case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
            case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
            case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
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
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
        }
        ((Button) findViewById(R.id.wc_geshitu_btn_trip)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.wc_geshitu_btn_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.btn_429_carradio)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.btn_429_carusb)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.btn_429_ampset)).setOnClickListener(new View.OnClickListener() { 
            @Override
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
    }
}
