package com.syu.carinfo.rzc.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Rzc_ZiYouguang_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_indexact);
        if (LauncherApplication.getConfiguration() == 1 || DataCanbus.DATA[1000] == 1048949) {
            findViewById(R.id.jeep_car_air).setVisibility(8);
        } else {
            findViewById(R.id.jeep_car_air).setVisibility(0);
        }
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 1048949) {
                        intent.setClass(Rzc_ZiYouguang_IndexAct.this, RZC_JeepCarEQSet.class);
                    } else {
                        intent.setClass(Rzc_ZiYouguang_IndexAct.this, Rzc_ZiYouguang_Settings.class);
                    }
                    Rzc_ZiYouguang_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_airset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_IndexAct.this, Air_Activity_All_NewAdd_HP.class);
                    Rzc_ZiYouguang_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (findViewById(R.id.jeep_car_cd_view) != null) {
            if (DataCanbus.DATA[1000] == 262517 || DataCanbus.DATA[1000] == 328053 || DataCanbus.DATA[1000] == 852341 || DataCanbus.DATA[1000] == 917877) {
                findViewById(R.id.jeep_car_cd_view).setVisibility(8);
            } else {
                findViewById(R.id.jeep_car_cd_view).setVisibility(0);
            }
        }
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_ZiYouguang_IndexAct.this, Rzc_CdAct.class);
                    Rzc_ZiYouguang_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
