package com.syu.carinfo.rzc.beiqi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class Activity19EC5Index extends BaseActivity {
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
                    intent.setClass(Activity19EC5Index.this, ActivityEC180Index.class);
                    Activity19EC5Index.this.startActivity(intent);
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
                    if (DataCanbus.DATA[1000] == 786659 || DataCanbus.DATA[1000] == 1376483 || DataCanbus.DATA[1000] == 852195) {
                        intent.setClass(Activity19EC5Index.this, Activity18EU5CarSet.class);
                    } else {
                        intent.setClass(Activity19EC5Index.this, Activity19EC5CarSet.class);
                    }
                    Activity19EC5Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
