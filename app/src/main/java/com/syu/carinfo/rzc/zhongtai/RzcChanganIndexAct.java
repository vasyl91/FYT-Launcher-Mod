package com.syu.carinfo.rzc.zhongtai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.carinfo.guochan.Activity_RZC_SettingT60;
import com.syu.carinfo.ztt600.ZTTireAct_Rzc;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcChanganIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_odchangan_indexact);
        if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449 || DataCanbus.DATA[1000] == 5571012 || DataCanbus.DATA[1000] == 6750660) {
            findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        } else {
            findViewById(R.id.odchangan_car_air_view).setVisibility(0);
        }
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
                        intent.setClass(RzcChanganIndexAct.this, Activity_RZC_SettingT60.class);
                    } else if (DataCanbus.DATA[1000] == 6750660) {
                        intent.setClass(RzcChanganIndexAct.this, ODCaptivaCarInfo.class);
                    } else {
                        intent.setClass(RzcChanganIndexAct.this, RzcChanganSetFunc.class);
                    }
                    RzcChanganIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_air)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcChanganIndexAct.this, Air_Activity_All_Toyota_prado_HP.class);
                    RzcChanganIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_tire)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
                        intent.setClass(RzcChanganIndexAct.this, ZTTireAct_Rzc.class);
                    } else if (DataCanbus.DATA[1000] == 6750660) {
                        intent.setClass(RzcChanganIndexAct.this, ODCaptivaTireAct.class);
                    } else {
                        intent.setClass(RzcChanganIndexAct.this, RzcChanganTireAct.class);
                    }
                    RzcChanganIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
