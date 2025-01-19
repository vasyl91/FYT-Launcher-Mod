package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

public class TuRui_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_turui_indexact);
        init();
    }

    @Override
    public void init() {
        Button mBtnFunctionalState = (Button) findViewById(R.id.jeep_car_settings);
        if (mBtnFunctionalState != null) {
            mBtnFunctionalState.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(TuRui_IndexAct.this, TuRui_SettingAct.class);
                        TuRui_IndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (findViewById(R.id.jeep_car_air) != null && LauncherApplication.isPortrait()) {
            findViewById(R.id.jeep_car_air).setVisibility(8);
        }
        Button mBtnAirControl = (Button) findViewById(R.id.jeep_car_airset);
        if (mBtnAirControl != null) {
            mBtnAirControl.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(TuRui_IndexAct.this, TuRui_AirActi.class);
                        TuRui_IndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Button mBtnOil = (Button) findViewById(R.id.jeep_car_oil);
        if (mBtnOil != null) {
            mBtnOil.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(TuRui_IndexAct.this, TuRui_OilActi.class);
                        TuRui_IndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
