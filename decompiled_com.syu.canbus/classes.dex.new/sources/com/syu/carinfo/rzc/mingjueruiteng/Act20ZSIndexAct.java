package com.syu.carinfo.rzc.mingjueruiteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rongwei.Wc_416_RongWei_CarSetAct;
import com.syu.carinfo.rongwei.Wc_416_RongWei_IndexAct;
import com.syu.carinfo.rongwei.Wc_416_RongweiAllCarInfo;
import com.syu.carinfo.rongwei.Wc_416_RongweiEi6CarInfo;
import com.syu.carinfo.rongwei.Wc_416_Rongwei_CarTireInfo;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Act20ZSIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_jianghuai_iev6e_indexact);
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case 416:
                        case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                        case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                        case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                        case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                        case FinalCanbus.CAR_WC2_20MingJue6 /* 590240 */:
                        case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
                        case FinalCanbus.CAR_WC2_Rongwei360_15 /* 852384 */:
                        case FinalCanbus.CAR_WC2_RongWeiRX5_20 /* 917920 */:
                        case FinalCanbus.CAR_WC2_RongWei_I6_17 /* 983456 */:
                        case FinalCanbus.CAR_WC2_MingJueZS_17SAF1 /* 1180064 */:
                        case FinalCanbus.CAR_WC2_MingJue_MG4_22 /* 1245600 */:
                        case FinalCanbus.CAR_WC2_MingJue_MG5_21 /* 1376672 */:
                        case FinalCanbus.CAR_WC2_RongWei_RX5Plus_20 /* 1507744 */:
                        case FinalCanbus.CAR_WC2_RongWei_RX5Plus_20Auto /* 1638816 */:
                        case FinalCanbus.CAR_WC2_Datong_D90_19 /* 1704352 */:
                        case FinalCanbus.CAR_WC2_Datong_D90_19_H /* 1769888 */:
                            intent.setClass(Act20ZSIndexAct.this, Wc_416_RongWei_CarSetAct.class);
                            break;
                        case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                        case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                        case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                        case FinalCanbus.CAR_WC2_MingJue_ZS /* 524704 */:
                        case FinalCanbus.CAR_WC2_MingJue_MULAN /* 721312 */:
                        case FinalCanbus.CAR_WC2_MingJue_20ZS /* 786848 */:
                        case FinalCanbus.CAR_WC2_MingJueRuiTeng_15SAF1 /* 1048992 */:
                        case FinalCanbus.CAR_WC2_MingJueRuiTeng_17SAF1 /* 1114528 */:
                            intent.setClass(Act20ZSIndexAct.this, Wc_416_RongWei_IndexAct.class);
                            break;
                        default:
                            intent.setClass(Act20ZSIndexAct.this, Act17RuiTengCarSet.class);
                            break;
                    }
                    Act20ZSIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case 416:
            case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
            case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
            case FinalCanbus.CAR_WC2_RongWeiRX5_20 /* 917920 */:
            case FinalCanbus.CAR_WC2_RongWei_I6_17 /* 983456 */:
            case FinalCanbus.CAR_WC2_MingJueRuiTeng_15SAF1 /* 1048992 */:
            case FinalCanbus.CAR_WC2_MingJueRuiTeng_17SAF1 /* 1114528 */:
            case FinalCanbus.CAR_WC2_MingJueZS_17SAF1 /* 1180064 */:
            case FinalCanbus.CAR_WC2_MingJue_MG4_22 /* 1245600 */:
            case FinalCanbus.CAR_WC2_MingJue_MG5_21 /* 1376672 */:
            case FinalCanbus.CAR_WC2_RongWei_RX5Plus_20 /* 1507744 */:
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
            case FinalCanbus.CAR_WC2_RongWei_RX5Plus_20Auto /* 1638816 */:
                findViewById(R.id.wc_jianghuai_car_tire_view).setVisibility(8);
                break;
            case FinalCanbus.CAR_WC2_MingJue_ZS /* 524704 */:
            case FinalCanbus.CAR_WC2_20MingJue6 /* 590240 */:
            case FinalCanbus.CAR_WC2_MingJue_MULAN /* 721312 */:
            case FinalCanbus.CAR_WC2_MingJue_20ZS /* 786848 */:
                break;
            default:
                findViewById(R.id.wc_jianghuai_carinfo_view).setVisibility(8);
                break;
        }
        findViewById(R.id.wc_jianghuai_carinfo).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case 416:
                        case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                        case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                        case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                        case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                        case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                        case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                        case FinalCanbus.CAR_WC2_MingJue_ZS /* 524704 */:
                        case FinalCanbus.CAR_WC2_20MingJue6 /* 590240 */:
                        case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
                        case FinalCanbus.CAR_WC2_MingJue_MULAN /* 721312 */:
                        case FinalCanbus.CAR_WC2_MingJue_20ZS /* 786848 */:
                        case FinalCanbus.CAR_WC2_RongWeiRX5_20 /* 917920 */:
                        case FinalCanbus.CAR_WC2_RongWei_I6_17 /* 983456 */:
                        case FinalCanbus.CAR_WC2_MingJueRuiTeng_15SAF1 /* 1048992 */:
                        case FinalCanbus.CAR_WC2_MingJueRuiTeng_17SAF1 /* 1114528 */:
                        case FinalCanbus.CAR_WC2_MingJueZS_17SAF1 /* 1180064 */:
                        case FinalCanbus.CAR_WC2_MingJue_MG4_22 /* 1245600 */:
                        case FinalCanbus.CAR_WC2_MingJue_MG5_21 /* 1376672 */:
                        case FinalCanbus.CAR_WC2_RongWei_RX5Plus_20 /* 1507744 */:
                        case FinalCanbus.CAR_WC2_RongWei_RX5Plus_20Auto /* 1638816 */:
                            intent.setClass(Act20ZSIndexAct.this, Wc_416_RongweiAllCarInfo.class);
                            break;
                        case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                            intent.setClass(Act20ZSIndexAct.this, Wc_416_RongweiEi6CarInfo.class);
                            break;
                        default:
                            intent.setClass(Act20ZSIndexAct.this, ActRongweiEi6CarInfo.class);
                            break;
                    }
                    Act20ZSIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_jianghuai_car_tire).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_WC2_MingJue_ZS /* 524704 */:
                        case FinalCanbus.CAR_WC2_20MingJue6 /* 590240 */:
                        case FinalCanbus.CAR_WC2_MingJue_MULAN /* 721312 */:
                        case FinalCanbus.CAR_WC2_MingJue_20ZS /* 786848 */:
                        case FinalCanbus.CAR_WC2_Datong_D90_19 /* 1704352 */:
                        case FinalCanbus.CAR_WC2_Datong_D90_19_H /* 1769888 */:
                            intent.setClass(Act20ZSIndexAct.this, Wc_416_Rongwei_CarTireInfo.class);
                            break;
                        default:
                            intent.setClass(Act20ZSIndexAct.this, Act20ZSCarTire.class);
                            break;
                    }
                    Act20ZSIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
