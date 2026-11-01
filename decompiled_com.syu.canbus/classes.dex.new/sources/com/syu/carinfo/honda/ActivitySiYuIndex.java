package com.syu.carinfo.honda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.carinfo.crv.WcCrvActiAll;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivitySiYuIndex extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_index_siyu);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_Honda_12Siyu_CRV /* 1638721 */:
            case FinalCanbus.CAR_WC2_Honda_14Siyu_L /* 1704257 */:
            case FinalCanbus.CAR_WC2_Honda_15CRV_L /* 1769793 */:
            case FinalCanbus.CAR_WC2_Honda_12Siyu /* 1966401 */:
            case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_L /* 3146049 */:
            case FinalCanbus.CAR_WC2_Honda_15CIVIC_OverSea_L /* 3277121 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                break;
            case FinalCanbus.CAR_443_WC_14Aodesai_CD /* 7078331 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.ActivitySiYuIndex.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) WcCrvActiAll.class));
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.ActivitySiYuIndex.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) Act_WC_CarCD_AoDeSai.class));
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.ActivitySiYuIndex.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
                    case FinalCanbus.CAR_WC2_Honda_17CRV_H /* 524609 */:
                    case FinalCanbus.CAR_WC2_Honda_17CRV_M /* 590145 */:
                    case FinalCanbus.CAR_WC2_Honda_AllCom_Top /* 983361 */:
                    case FinalCanbus.CAR_WC2_Honda_15Aodesai_Tai /* 1048897 */:
                    case FinalCanbus.CAR_WC2_Honda_18Aodesai_Tai /* 1114433 */:
                    case FinalCanbus.CAR_WC2_Honda_19CRV /* 1179969 */:
                    case FinalCanbus.CAR_WC2_Honda_19Lingpai /* 1245505 */:
                    case FinalCanbus.CAR_WC2_Honda_19Xiangyu /* 1311041 */:
                    case FinalCanbus.CAR_WC2_Honda_17Elysion /* 1376577 */:
                    case FinalCanbus.CAR_WC2_Honda_15Aodesai_H /* 1507649 */:
                    case FinalCanbus.CAR_WC2_Honda_18Aodesai_H /* 1573185 */:
                    case FinalCanbus.CAR_WC2_Honda_19INSPIRE /* 2031937 */:
                    case FinalCanbus.CAR_WC2_Honda_20EVERUS /* 2097473 */:
                    case FinalCanbus.CAR_WC2_Honda_21CRV /* 2163009 */:
                    case FinalCanbus.CAR_WC2_Honda_21BREEZE /* 2228545 */:
                    case FinalCanbus.CAR_WC2_Honda_22CIVIC /* 2294081 */:
                    case FinalCanbus.CAR_WC2_Honda_22Accord /* 2359617 */:
                    case FinalCanbus.CAR_WC2_Honda_22CRIDER /* 2425153 */:
                    case FinalCanbus.CAR_WC2_Honda_21Fit /* 2490689 */:
                    case FinalCanbus.CAR_WC2_Honda_19Elysion /* 2556225 */:
                    case FinalCanbus.CAR_WC2_Honda_15Aodesai_MH /* 2621761 */:
                    case FinalCanbus.CAR_WC2_Honda_16Acura_CDX /* 2687297 */:
                    case FinalCanbus.CAR_WC2_Honda_20Aodesai_H /* 2752833 */:
                    case FinalCanbus.CAR_WC2_Honda_22STEP_WGN /* 2818369 */:
                    case FinalCanbus.CAR_WC2_Honda_23XRV /* 2883905 */:
                    case FinalCanbus.CAR_WC2_Honda_15Aodesai_T /* 2949441 */:
                    case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_H /* 3080513 */:
                    case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_L /* 3146049 */:
                    case FinalCanbus.CAR_WC2_Honda_15_18Aodesai_H /* 3342657 */:
                    case FinalCanbus.CAR_WC2_Honda_19Aodesai /* 3408193 */:
                    case FinalCanbus.CAR_WC2_Honda_14Freed /* 3473729 */:
                    case FinalCanbus.CAR_WC2_Honda_23Freed /* 3539265 */:
                    case FinalCanbus.CAR_WC2_Honda_19CRV_H /* 4915521 */:
                    case FinalCanbus.CAR_WC2_Honda_21CRV_H /* 5046593 */:
                    case FinalCanbus.CAR_WC2_Honda_17Elysion_H /* 5112129 */:
                    case FinalCanbus.CAR_WC2_Honda_19Elysion_H /* 5177665 */:
                    case FinalCanbus.CAR_WC2_Honda_19Aodesai_H /* 5243201 */:
                    case FinalCanbus.CAR_WC2_Honda_21BREEZE_H /* 5308737 */:
                    case FinalCanbus.CAR_WC2_Honda_19INSPIRE_H /* 5374273 */:
                    case FinalCanbus.CAR_WC2_Honda_22Accord_H /* 5439809 */:
                    case FinalCanbus.CAR_WC2_Honda_22CIVIC_L /* 6029633 */:
                    case FinalCanbus.CAR_WC2_Honda_19Xiangyu_L /* 6160705 */:
                    case FinalCanbus.CAR_WC2_Honda_20EVERUS_L /* 6226241 */:
                    case FinalCanbus.CAR_WC2_Honda_21Fit_L /* 6291777 */:
                    case FinalCanbus.CAR_WC2_Honda_23XRV_L /* 6357313 */:
                    case FinalCanbus.CAR_WC2_Honda_14Freed_L /* 6422849 */:
                    case FinalCanbus.CAR_WC2_Honda_23Freed_L /* 6488385 */:
                    case FinalCanbus.CAR_WC2_Honda_22STEP_WGN_H /* 7405889 */:
                    case FinalCanbus.CAR_WC2_Honda_17STEP_WGN /* 7471425 */:
                    case FinalCanbus.CAR_WC2_Honda_17STEP_WGN_H /* 7536961 */:
                    case FinalCanbus.CAR_WC2_Honda_16CRV_Oceania_H /* 7602497 */:
                    case FinalCanbus.CAR_WC2_Honda_15CIVIC_Oceania_H /* 7668033 */:
                    case FinalCanbus.CAR_WC2_Honda_11AodesaiLX_NA /* 7733569 */:
                    case FinalCanbus.CAR_WC2_Honda_11AodesaiEX_NA /* 7799105 */:
                    case FinalCanbus.CAR_WC2_Honda_11AodesaiEXL_NA /* 7864641 */:
                    case FinalCanbus.CAR_WC2_Honda_11AodesaiEXL_WRES_NA /* 7930177 */:
                    case FinalCanbus.CAR_WC2_Honda_11AodesaiEXL_WNAVI_NA /* 7995713 */:
                    case FinalCanbus.CAR_WC2_Honda_11AodesaiEXL_WRES_NAVI_NA /* 8061249 */:
                    case FinalCanbus.CAR_WC2_Honda_11Aodesai_Touring_NA /* 8126785 */:
                    case FinalCanbus.CAR_WC2_Honda_11Aodesai_TouringElite_NA /* 8192321 */:
                    case FinalCanbus.CAR_WC2_Honda_13Accod /* 8257857 */:
                    case FinalCanbus.CAR_WC2_Honda_23BREEZE_L /* 8323393 */:
                    case FinalCanbus.CAR_WC2_Honda_23BREEZE_H /* 8388929 */:
                    case FinalCanbus.CAR_WC2_Honda_18HRV_Oceania /* 8454465 */:
                        ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) ActivityAirControl.class));
                        break;
                    default:
                        ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) ActivityAirControl.class));
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.ActivitySiYuIndex.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) HondaIndexActi.class));
            }
        });
    }
}
