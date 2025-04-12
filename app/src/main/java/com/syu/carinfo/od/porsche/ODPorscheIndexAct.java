package com.syu.carinfo.od.porsche;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class ODPorscheIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_indexact);
        findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        findViewById(R.id.rzc_jianghuai_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ODPorscheIndexAct.this, ODPorscheCarSettingAct.class);
                    ODPorscheIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.rzc_jianghuai_carinfo).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ODPorscheIndexAct.this, ODPorscheCarTire.class);
                    ODPorscheIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
