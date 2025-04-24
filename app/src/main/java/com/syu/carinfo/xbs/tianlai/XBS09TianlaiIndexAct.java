package com.syu.carinfo.xbs.tianlai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.RZCNissanAmpCarSet;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBS09TianlaiIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_09tianlai_indexact);
        ((Button) findViewById(R.id.jeep_car_info)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBS09TianlaiIndexAct.this, XBS09TianlaiCarCDAct.class);
                    XBS09TianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBS09TianlaiIndexAct.this, XBS09TianlaiCarRadioAct.class);
                    XBS09TianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 458942) {
                        intent.setClass(XBS09TianlaiIndexAct.this, RZCNissanAmpCarSet.class);
                    } else {
                        intent.setClass(XBS09TianlaiIndexAct.this, XBS09TianlaiCarEQAct.class);
                    }
                    XBS09TianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
