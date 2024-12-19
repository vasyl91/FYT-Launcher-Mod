package com.syu.carinfo.lz.lexusis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzLexusISIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lzlexus_indexact);
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
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                break;
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
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.lexus_car_radio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
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
        ((Button) findViewById(R.id.lexus_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
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
        ((Button) findViewById(R.id.lexus_car_air)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LuzLexusISIndexAct.this, LuzLexusLSFrontAirControlAct.class);
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
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
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LuzLexusISIndexAct.this, LuzToyotaReizCarInfo.class);
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LuzLexusISIndexAct.this, LuzLexusISCarUSB.class);
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LuzLexusISIndexAct.this, LZLexusISCarSet.class);
                    LuzLexusISIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
