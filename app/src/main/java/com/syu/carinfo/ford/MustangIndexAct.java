package com.syu.carinfo.ford;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class MustangIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_ford_mustang_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                if (DataCanbus.DATA[1000] != 11403716) {
                    findViewById(R.id.layout_view1).setVisibility(8);
                }
                ((TextView) findViewById(R.id.tv_text1)).setText("Sync");
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
                break;
            case FinalCanbus.CAR_RZC_Ford_Lincoln_Continental /* 2031950 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_settings_title);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.sound_settings);
                break;
            case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.oil_mileage);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText("Sync");
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
                break;
        }
        if (1900878 == DataCanbus.DATA[1000]) {
            if (LauncherApplication.getConfiguration() != 1) {
                findViewById(R.id.layout_view2).setVisibility(8);
            } else {
                findViewById(R.id.layout_view3).setVisibility(0);
            }
            findViewById(R.id.layout_view3).setVisibility(8);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_settings_title);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.sound_settings);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_psa_all_orinal_car_fuc);
        } else {
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.radio_car);
        }
        ((Button) findViewById(R.id.jeep_car_radio)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                        case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
                        case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                        case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                        case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                            intent.setClass(MustangIndexAct.this, LZMustangCarRadioAct.class);
                            break;
                        case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                            intent.setClass(MustangIndexAct.this, RZCFordNavigatorPanelAct.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                            intent.setClass(MustangIndexAct.this, LZSubaruCarRadioAct.class);
                            break;
                        default:
                            intent.setClass(MustangIndexAct.this, MustangCarRadioAct.class);
                            break;
                    }
                    MustangIndexAct.this.startActivity(intent);
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
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                        case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
                        case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                        case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                        case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                            intent.setClass(MustangIndexAct.this, LZMustangCarCDAct.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                            intent.setClass(MustangIndexAct.this, LZSubaruCarCd.class);
                            break;
                        default:
                            intent.setClass(MustangIndexAct.this, MustangCarCDAct.class);
                            break;
                    }
                    MustangIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_info)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                        case FinalCanbus.CAR_RZC_Ford_Lincoln_Continental /* 2031950 */:
                            intent.setClass(MustangIndexAct.this, FordCarSet_RZC.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                            intent.setClass(MustangIndexAct.this, LZSubaruCarInfo.class);
                            break;
                        default:
                            intent.setClass(MustangIndexAct.this, FocusSyncBtActi.class);
                            break;
                    }
                    MustangIndexAct.this.startActivity(intent);
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
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                        case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                        case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                        case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
                        case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                        case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                        case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                            intent.setClass(MustangIndexAct.this, LZMustangCarEQSet.class);
                            break;
                        case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                            intent.setClass(MustangIndexAct.this, LZSubaruCarSet.class);
                            break;
                        default:
                            intent.setClass(MustangIndexAct.this, MustangCarEQSet.class);
                            break;
                    }
                    MustangIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
