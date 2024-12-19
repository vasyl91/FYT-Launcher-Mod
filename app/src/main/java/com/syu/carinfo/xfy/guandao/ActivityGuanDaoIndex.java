package com.syu.carinfo.xfy.guandao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityGuanDaoIndex extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_425_guandao_index);
        ((CheckedTextView) findViewById(R.id.ctv_car_state_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.ActivityGuanDaoIndex.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ActivityGuanDaoIndex.this, GuandaoSettingsAct.class);
                    ActivityGuanDaoIndex.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_dashboard_state_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.ActivityGuanDaoIndex.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ActivityGuanDaoIndex.this, GuandaoSetting2Act.class);
                    ActivityGuanDaoIndex.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
