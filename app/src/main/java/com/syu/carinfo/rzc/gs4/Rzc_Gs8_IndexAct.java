package com.syu.carinfo.rzc.gs4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wc.gs4.GS4SetAct_Bnr;
import com.syu.module.canbus.DataCanbus;

public class Rzc_Gs8_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_416_rongwei_indexact);
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_Gs8_IndexAct.this, GS4SetAct_Bnr.class);
                    Rzc_Gs8_IndexAct.this.startActivity(intent);
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
                    if (DataCanbus.DATA[1000] == 459032) {
                        intent.setClass(Rzc_Gs8_IndexAct.this, Rzc_Gs3_AirControlAct.class);
                    } else {
                        intent.setClass(Rzc_Gs8_IndexAct.this, Rzc_Gs8_AirControlAct.class);
                    }
                    Rzc_Gs8_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
