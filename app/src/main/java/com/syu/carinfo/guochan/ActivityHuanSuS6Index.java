package com.syu.carinfo.guochan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHuanSuS6Index extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_huansu_s6_index);
        ((CheckedTextView) findViewById(R.id.ctv_air_state_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActivityHuanSuS6Index.1
            @Override // android.view.View.OnClickListener
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
        ((CheckedTextView) findViewById(R.id.ctv_car_state_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActivityHuanSuS6Index.2
            @Override // android.view.View.OnClickListener
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
        ((CheckedTextView) findViewById(R.id.ctv_dashboard_state_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActivityHuanSuS6Index.3
            @Override // android.view.View.OnClickListener
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
