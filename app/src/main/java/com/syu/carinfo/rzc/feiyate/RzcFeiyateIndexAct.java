package com.syu.carinfo.rzc.feiyate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class RzcFeiyateIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_indexact);
        findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcFeiyateIndexAct.this, RzcFeiyateSetFunc.class);
                    RzcFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcFeiyateIndexAct.this, RzcFYTOilMileIndexActi.class);
                    RzcFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
