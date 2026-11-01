package com.syu.carinfo.geshitu.wc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wc.leinuo.DusterOilMileIndexActi;
import com.syu.carinfo.wc.leinuo.Megane4SetIndexActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCRenaultIndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_renault_index);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_RENAULT_Megane4 /* 459104 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_M /* 983392 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_H /* 1442144 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4 /* 1704288 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_M /* 1769824 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_H /* 1835360 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman /* 1900896 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_M /* 1966432 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_H /* 2031968 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_L /* 2621792 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_M /* 2687328 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_H /* 2752864 */:
            case FinalCanbus.CAR_WC2_RENAULT_16SamsungSM6 /* 2949472 */:
            case FinalCanbus.CAR_WC2_RENAULT_16SamsungSM6_M /* 3015008 */:
            case FinalCanbus.CAR_WC2_RENAULT_16SamsungSM6_H /* 3080544 */:
            case FinalCanbus.CAR_WC2_RENAULT_24Arkana /* 3473760 */:
            case FinalCanbus.CAR_WC2_RENAULT_24Arkana_M /* 3539296 */:
            case FinalCanbus.CAR_WC2_RENAULT_24Arkana_H /* 3604832 */:
            case FinalCanbus.CAR_WC2_RENAULT_16Talisman_L /* 3998048 */:
            case FinalCanbus.CAR_WC2_RENAULT_16Talisman_M /* 4063584 */:
            case FinalCanbus.CAR_WC2_RENAULT_16Talisman_H /* 4129120 */:
            case FinalCanbus.CAR_WC2_Samsung_16SingleSM6 /* 5898592 */:
            case FinalCanbus.CAR_WC2_Samsung_16SingleSM6_M /* 5964128 */:
            case FinalCanbus.CAR_WC2_Samsung_16SingleSM6_H /* 6029664 */:
            case FinalCanbus.CAR_WC2_Samsung_16QM6 /* 6095200 */:
            case FinalCanbus.CAR_WC2_Samsung_16QM6_M /* 6160736 */:
            case FinalCanbus.CAR_WC2_Samsung_16QM6_H /* 6226272 */:
            case FinalCanbus.CAR_WC2_Samsung_16SingleQM6 /* 6291808 */:
            case FinalCanbus.CAR_WC2_Samsung_16SingleQM6_M /* 6357344 */:
            case FinalCanbus.CAR_WC2_Samsung_16SingleQM6_H /* 6422880 */:
            case FinalCanbus.CAR_WC2_RENAULT_16Talisman_DualL /* 6750560 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_DualL /* 6816096 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.geshitu.wc.WCRenaultIndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCRenaultIndexActi.this, DusterOilMileIndexActi.class);
                    WCRenaultIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.geshitu.wc.WCRenaultIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCRenaultIndexActi.this, Megane4SetIndexActi.class);
                    WCRenaultIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.geshitu.wc.WCRenaultIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCRenaultIndexActi.this, WCRenaultCarTire.class);
                    WCRenaultIndexActi.this.startActivity(intent);
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
