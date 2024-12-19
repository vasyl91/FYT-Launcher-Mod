package com.syu.carinfo.bg.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bg_DaQieNuoJi_Settings extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_settings_bg);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.zyg_271_Safety).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Settings.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_Settings.this, Bg_DaQieNuoJi_Safety.class);
                    Bg_DaQieNuoJi_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.zyg_271_LightEngine).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Settings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_Settings.this, Bg_DaQieNuoJi_Light.class);
                    Bg_DaQieNuoJi_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.zyg_271_DoorLock).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Settings.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_Settings.this, Bg_DaQieNuoJi_DoorLock.class);
                    Bg_DaQieNuoJi_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        View v = findViewById(R.id.zyg_271_suspension_view);
        if (v != null) {
            v.setVisibility(0);
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Settings.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Bg_DaQieNuoJi_Settings.this, Bg_DaQieNuoJi_Suspension.class);
                        Bg_DaQieNuoJi_Settings.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        findViewById(R.id.zyg_271_other).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Settings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_Settings.this, Bg_DaQieNuoJi_Other.class);
                    Bg_DaQieNuoJi_Settings.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
