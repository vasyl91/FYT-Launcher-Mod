package com.syu.carinfo.od.mazdall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wc2.tata.WC2TataCarSet;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class WCSuzukiAllIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_suzuki_indexact);
        if (DataCanbus.DATA[1000] == 12059067) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_443_WC2_TATA_harrier /* 12059067 */:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCTataCarInfoIndexAct.class);
                            break;
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCLeepMotorCarInfo.class);
                            break;
                        default:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCSuzukiCarInfo.class);
                            break;
                    }
                    WCSuzukiAllIndexAct.this.startActivity(intent);
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
                        case FinalCanbus.CAR_443_WC2_TATA_harrier /* 12059067 */:
                            intent.setClass(WCSuzukiAllIndexAct.this, WC2TataCarSet.class);
                            break;
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCLeepMotorCarSet.class);
                            break;
                        default:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCSuzukiAllCarSet.class);
                            break;
                    }
                    WCSuzukiAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_tireinfo).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
                        case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCLeepMotorCarTire.class);
                            break;
                        default:
                            intent.setClass(WCSuzukiAllIndexAct.this, WCSuzukiCarTire.class);
                            break;
                    }
                    WCSuzukiAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
