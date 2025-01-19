package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class LingDuActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_lingdu_index);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.lingdu_btn_trip)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 270) {
                        intent.setClass(LingDuActi.this, Golf7OilMileagePage1LowActi.class);
                    } else if (DataCanbus.DATA[1000] == 279) {
                        intent.setClass(LingDuActi.this, Golf7OilMileageIndexActi.class);
                    }
                    LingDuActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lingdu_btn_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LingDuActi.this, Golf7FunctionalEscSystemActi.class);
                    LingDuActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
