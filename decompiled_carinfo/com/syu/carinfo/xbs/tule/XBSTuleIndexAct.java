package com.syu.carinfo.xbs.tule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBSTuleIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_tule_indexact);
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                        case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                        case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                            intent.setClass(XBSTuleIndexAct.this, TdTuleCarInfo.class);
                            break;
                        default:
                            intent.setClass(XBSTuleIndexAct.this, XBSTuleCarInfo.class);
                            break;
                    }
                    XBSTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                        case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                        case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                            intent.setClass(XBSTuleIndexAct.this, TdTuleCarSet.class);
                            break;
                        default:
                            intent.setClass(XBSTuleIndexAct.this, XBSTuleCarSet.class);
                            break;
                    }
                    XBSTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                        case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                        case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                        case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                            intent.setClass(XBSTuleIndexAct.this, TDTuleCarTire.class);
                            break;
                        default:
                            intent.setClass(XBSTuleIndexAct.this, XBSTuleCarTire.class);
                            break;
                    }
                    XBSTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
