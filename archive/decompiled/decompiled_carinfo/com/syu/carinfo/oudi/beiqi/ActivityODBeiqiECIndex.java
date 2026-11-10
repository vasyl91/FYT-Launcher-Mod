package com.syu.carinfo.oudi.beiqi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityODBeiqiECIndex extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_huiteng_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ActivityODBeiqiECIndex.this, ActivityCarInfoIndex.class);
                    ActivityODBeiqiECIndex.this.startActivity(intent);
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
                        case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
                        case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
                        case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                        case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
                        case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
                        case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
                        case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                            intent.setClass(ActivityODBeiqiECIndex.this, ActivityOudi18EU5CarSet.class);
                            break;
                        default:
                            intent.setClass(ActivityODBeiqiECIndex.this, ActivityOudiBeiqiEcCarSet.class);
                            break;
                    }
                    ActivityODBeiqiECIndex.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
