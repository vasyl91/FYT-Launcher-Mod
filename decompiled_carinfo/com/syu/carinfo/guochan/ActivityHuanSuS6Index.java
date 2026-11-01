package com.syu.carinfo.guochan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityHuanSuS6Index extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_419_huansu_s6_index);
        ((CheckedTextView) findViewById(R.id.ctv_air_state_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ActivityHuanSuS6Index.this, ActivityHuanSuAirSet.class);
                    ActivityHuanSuS6Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_car_state_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ActivityHuanSuS6Index.this, ActivityHuanSuCarSet.class);
                    ActivityHuanSuS6Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_dashboard_state_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ActivityHuanSuS6Index.this, ActivityHuanSuDashboardSet.class);
                    ActivityHuanSuS6Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
