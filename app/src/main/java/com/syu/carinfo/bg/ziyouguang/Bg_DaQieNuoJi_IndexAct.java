package com.syu.carinfo.bg.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

public class Bg_DaQieNuoJi_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_IndexAct.this, Bg_DaQieNuoJi_Settings.class);
                    Bg_DaQieNuoJi_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_airset).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_IndexAct.this, Bg_ZiYouGuangAirControlAct.class);
                    Bg_DaQieNuoJi_IndexAct.this.startActivity(intent);
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
                    intent.setClass(Bg_DaQieNuoJi_IndexAct.this, Bg_CdAct.class);
                    Bg_DaQieNuoJi_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (LauncherApplication.isPortrait()) {
            setViewVisible(findViewById(R.id.jeep_car_air), false);
        }
    }
}
