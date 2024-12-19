package com.syu.carinfo.rzc.ruifengs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JhRuiFengR3IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ruifengr3_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(JhRuiFengR3IndexAct.this, JhRuiFengEV7ChargeSetFunc.class);
                    JhRuiFengR3IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ruifengr3_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_452_Oudi_Jianghuai_Ruifeng_S7 /* 655812 */:
                        case FinalCanbus.CAR_452_Oudi_Jianghuai_Ruifeng_S7_H /* 721348 */:
                            intent.setClass(JhRuiFengR3IndexAct.this, JhRuiFengS7SetFunc.class);
                            break;
                        case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                        case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                        case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                        case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                            intent.setClass(JhRuiFengR3IndexAct.this, JhJiayueA5SetFunc.class);
                            break;
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
                            intent.setClass(JhRuiFengR3IndexAct.this, KYCSanlinSetFunc.class);
                            break;
                        default:
                            intent.setClass(JhRuiFengR3IndexAct.this, JhRuiFengR3SetFunc.class);
                            break;
                    }
                    JhRuiFengR3IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ruifengr3_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3IndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_452_Oudi_Jianghuai_Ruifeng_S7 /* 655812 */:
                        case FinalCanbus.CAR_452_Oudi_Jianghuai_Ruifeng_S7_H /* 721348 */:
                            intent.setClass(JhRuiFengR3IndexAct.this, JhRuiFengS7TireAct.class);
                            break;
                        case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                        case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                        case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                        case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                            intent.setClass(JhRuiFengR3IndexAct.this, JhJiayueA5TireAct.class);
                            break;
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
                        case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
                            intent.setClass(JhRuiFengR3IndexAct.this, KYCSanlinTireAct.class);
                            break;
                        default:
                            intent.setClass(JhRuiFengR3IndexAct.this, JhRuiFengS3TireAct.class);
                            break;
                    }
                    JhRuiFengR3IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
