package com.syu.carinfo.lz.lexusis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class LuzLexusISIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lzlexus_indexact);
        if (LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.layout_text_view2).setVisibility(0);
            findViewById(R.id.layout_text_view6).setVisibility(0);
            findViewById(R.id.layout_text_view3).setVisibility(8);
            findViewById(R.id.layout_text_view4).setVisibility(8);
            findViewById(R.id.layout_text_view5).setVisibility(8);
        } else {
            findViewById(R.id.layout_text_view2).setVisibility(0);
            findViewById(R.id.layout_text_view6).setVisibility(8);
            findViewById(R.id.layout_text_view3).setVisibility(0);
            findViewById(R.id.layout_text_view4).setVisibility(0);
            findViewById(R.id.layout_text_view5).setVisibility(0);
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(R.string.mzd_clock_set);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
            case FinalCanbus.CAR_454_LZ_Lexus_RX330_L /* 3801542 */:
            case FinalCanbus.CAR_454_LZ_Lexus_RX330_H /* 3867078 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                break;
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                break;
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_text_view6).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_car_settings);
                findViewById(R.id.layout_text_view7).setVisibility(8);
                break;
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                findViewById(R.id.layout_text_view3).setVisibility(8);
                break;
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                break;
            case FinalCanbus.CAR_454_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 16581062 */:
            case FinalCanbus.CAR_454_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 16646598 */:
                findViewById(R.id.layout_text_view3).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                break;
        }
        findViewById(R.id.lexus_car_radio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                            intent.setClass(LuzLexusISIndexAct.this, TangduLexusRadio.class);
                            break;
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                            intent.setClass(LuzLexusISIndexAct.this, KYCLexusRadio.class);
                            break;
                        default:
                            intent.setClass(LuzLexusISIndexAct.this, LuzLexusISRadio.class);
                            break;
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_car_cd).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                            intent.setClass(LuzLexusISIndexAct.this, TangduLexusCd.class);
                            break;
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                            intent.setClass(LuzLexusISIndexAct.this, KYCLexusCd.class);
                            break;
                        default:
                            intent.setClass(LuzLexusISIndexAct.this, LuzLexusISCd.class);
                            break;
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_car_air).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (LauncherApplication.getConfiguration() != 1) {
                        intent.setClass(LuzLexusISIndexAct.this, Air_Activity_All_NewAdd_HP.class);
                    } else {
                        intent.setClass(LuzLexusISIndexAct.this, LuzLexusLSFrontAirControlAct.class);
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
                        case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
                        case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                            intent.setClass(LuzLexusISIndexAct.this, KYCToyotaAllCarSet.class);
                            break;
                        default:
                            intent.setClass(LuzLexusISIndexAct.this, LuzLexusLSClockSetAct.class);
                            break;
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                            intent.setClass(LuzLexusISIndexAct.this, TangduLexusCarInfo.class);
                            break;
                        default:
                            intent.setClass(LuzLexusISIndexAct.this, LuzToyotaReizCarInfo.class);
                            break;
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                            intent.setClass(LuzLexusISIndexAct.this, TangduLexusCarUSB.class);
                            break;
                        default:
                            intent.setClass(LuzLexusISIndexAct.this, LuzLexusISCarUSB.class);
                            break;
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                        case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                            intent.setClass(LuzLexusISIndexAct.this, TangduLexusCarSet.class);
                            break;
                        default:
                            intent.setClass(LuzLexusISIndexAct.this, LZLexusISCarSet.class);
                            break;
                    }
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
