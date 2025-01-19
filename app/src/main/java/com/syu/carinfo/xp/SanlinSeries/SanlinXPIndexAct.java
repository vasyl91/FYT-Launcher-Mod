package com.syu.carinfo.xp.SanlinSeries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class SanlinXPIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_354_xp_sanlin_indexact);
        ((Button) findViewById(R.id.xbs_418_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(SanlinXPIndexAct.this, SanlinXPCarSet.class);
                    SanlinXPIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.xbs_418_car_oil_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(SanlinXPIndexAct.this, SanlinXPEQCarSet.class);
                    SanlinXPIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
