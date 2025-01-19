package com.syu.carinfo.xc.feiyatefeiyue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class XCFeiyateFeiyueIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_416_rongwei_indexact);
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCFeiyateFeiyueIndexAct.this, XCFeiyateFeiyueSetFunc.class);
                    XCFeiyateFeiyueIndexAct.this.startActivity(intent);
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
                    intent.setClass(XCFeiyateFeiyueIndexAct.this, XCFeiyateFeiyueFrontAirControlAct.class);
                    XCFeiyateFeiyueIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
