package com.syu.carinfo.oudi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_0314_Dongfeng_Ev3_IndexAct extends BaseActivity {
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
                    intent.setClass(RZC_0314_Dongfeng_Ev3_IndexAct.this, RZC_0314_DongfengEv3_CarSettingAct.class);
                    RZC_0314_Dongfeng_Ev3_IndexAct.this.startActivity(intent);
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
                    if (DataCanbus.DATA[1000] == 1769786 || DataCanbus.DATA[1000] == 1835322 || DataCanbus.DATA[1000] == 1900858) {
                        intent.setClass(RZC_0314_Dongfeng_Ev3_IndexAct.this, RZC_0314_DongfengE3_CarInfoAct.class);
                    } else {
                        intent.setClass(RZC_0314_Dongfeng_Ev3_IndexAct.this, RZC_0314_DongfengEv3_CarInfoAct.class);
                    }
                    RZC_0314_Dongfeng_Ev3_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
