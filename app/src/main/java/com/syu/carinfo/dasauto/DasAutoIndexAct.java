package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DasAutoIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_jianghuai_iev6e_indexact);
        if (DataCanbus.DATA[1000] != 3538995 && DataCanbus.DATA[1000] != 3670067 && DataCanbus.DATA[1000] != 3735603 && DataCanbus.DATA[1000] != 3801139 && DataCanbus.DATA[1000] != 3866675 && DataCanbus.DATA[1000] != 4128819 && DataCanbus.DATA[1000] != 4390963 && DataCanbus.DATA[1000] != 2424883 && DataCanbus.DATA[1000] != 2490419 && DataCanbus.DATA[1000] != 2883635 && DataCanbus.DATA[1000] != 2555955 && DataCanbus.DATA[1000] != 2949171 && DataCanbus.DATA[1000] != 4194355) {
            findViewById(R.id.wc_jianghuai_carset_view).setVisibility(8);
        } else {
            findViewById(R.id.wc_jianghuai_car_tire_view).setVisibility(8);
        }
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Audi_TT_08_13 /* 2424883 */:
                        case FinalCanbus.CAR_RZC_Audi_A3_04_12 /* 2490419 */:
                        case FinalCanbus.CAR_RZC_Audi_A4_03_07 /* 2555955 */:
                        case FinalCanbus.CAR_RZC_Audi_Q3_13_18 /* 2883635 */:
                        case FinalCanbus.CAR_RZC_Audi_Q5_10_18 /* 2949171 */:
                        case FinalCanbus.CAR_RZC_Audi_R8_12 /* 4194355 */:
                            intent.setClass(DasAutoIndexAct.this, RZCAudiCarSet.class);
                            break;
                        case FinalCanbus.CAR_RZC_BMW_X1_12_14 /* 3538995 */:
                            intent.setClass(DasAutoIndexAct.this, RZCBmwX1CarSet.class);
                            break;
                        case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
                        case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
                        case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
                        case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
                        case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
                        case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
                            intent.setClass(DasAutoIndexAct.this, RZCBmwX3CarSet.class);
                            break;
                    }
                    DasAutoIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_jianghuai_carinfo).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(DasAutoIndexAct.this, DasAutoXpAct.class);
                    DasAutoIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_jianghuai_car_tire).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(DasAutoIndexAct.this, DasAutoXpTire.class);
                    DasAutoIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
