package com.syu.carinfo.psa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408AlarmRecordActi;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcPsa301IndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_psa301_index);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.rzc_psa301_btn_trip)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcPsa301IndexActi.this, BZ408OilMileIndexActi.class);
                    RzcPsa301IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_psa301_btn_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
            }
        });
        ((Button) findViewById(R.id.rzc_psa301_btn_info)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcPsa301IndexActi.this, RZC_BZ408AlarmRecordActi.class);
                    RzcPsa301IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
