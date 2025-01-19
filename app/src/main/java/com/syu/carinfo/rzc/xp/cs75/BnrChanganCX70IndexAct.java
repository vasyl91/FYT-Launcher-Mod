package com.syu.carinfo.rzc.xp.cs75;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class BnrChanganCX70IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_odchangan_indexact);
        findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(BnrChanganCX70IndexAct.this, ChangAnCS75Act.class);
                    BnrChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_tire)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(BnrChanganCX70IndexAct.this, BnrChanganCX70TireAct.class);
                    BnrChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
