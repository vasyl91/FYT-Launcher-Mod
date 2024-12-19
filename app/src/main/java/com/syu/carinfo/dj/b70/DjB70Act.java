package com.syu.carinfo.dj.b70;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DjB70Act extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dj_14b70);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.dj_14b70_air).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70Act.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(DjB70Act.this, DjB70AirControlAct.class);
                    DjB70Act.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.dj_14b70_bt).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70Act.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(DjB70Act.this, DjB70Carbt.class);
                    DjB70Act.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.dj_14b70_time_setting).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70Act.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(DjB70Act.this, DjB70TimeSettingAct.class);
                    DjB70Act.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
