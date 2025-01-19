package com.syu.carinfo.geshitu.wc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wc.leinuo.DusterOilMileIndexActi;
import com.syu.carinfo.wc.leinuo.Megane4SetActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class WCRenaultIndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0352_wc_renault_index);
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
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCRenaultIndexActi.this, Megane4SetActi.class);
                    WCRenaultIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
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

    @Override
    protected void onResume() {
        super.onResume();
    }
}
