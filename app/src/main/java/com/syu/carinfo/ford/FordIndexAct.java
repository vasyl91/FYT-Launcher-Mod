package com.syu.carinfo.ford;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_tule_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Lingjie2019 /* 459086 */:
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_Lingjie2019_M /* 1179982 */:
            case FinalCanbus.CAR_RZC_Lingjie2019_H /* 1245518 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_seat_set);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
                break;
        }
        ((Button) findViewById(R.id.jeep_car_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                            intent.setClass(FordIndexAct.this, FordCarSeatInfo.class);
                            break;
                        case FinalCanbus.CAR_RZC_Ford_Transit /* 1114446 */:
                            intent.setClass(FordIndexAct.this, FordCarInfo2.class);
                            break;
                        case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
                        case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
                        case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
                        case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
                        case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
                        case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                            intent.setClass(FordIndexAct.this, MustangCarEQSet.class);
                            break;
                        default:
                            intent.setClass(FordIndexAct.this, FordCarInfo.class);
                            break;
                    }
                    FordIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Escape_20 /* 917838 */:
                        case FinalCanbus.CAR_RZC_Ford_Transit /* 1114446 */:
                            intent.setClass(FordIndexAct.this, FordCarSet_RZC2.class);
                            break;
                        default:
                            intent.setClass(FordIndexAct.this, FordCarSet_RZC.class);
                            break;
                    }
                    FordIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(FordIndexAct.this, FordTireAct.class);
                    FordIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}