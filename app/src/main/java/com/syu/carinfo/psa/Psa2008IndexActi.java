package com.syu.carinfo.psa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Psa2008IndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa2008_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.psa2008_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008IndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Psa2008IndexActi.this, PsaOilMileIndexActi.class);
                    Psa2008IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Psa2008IndexActi.this, Psa2008settingActi.class);
                    Psa2008IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008IndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Psa2008IndexActi.this, PsaAlarmRecordActi.class);
                    Psa2008IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.psa2008_btn_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008IndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Psa2008IndexActi.this, Psa2008SpeedLimitSetActi.class);
                    Psa2008IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
