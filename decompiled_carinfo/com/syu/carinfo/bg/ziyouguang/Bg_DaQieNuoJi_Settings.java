package com.syu.carinfo.bg.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class Bg_DaQieNuoJi_Settings extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_settings_bg);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.zyg_271_Safety).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        findViewById(R.id.zyg_271_LightEngine).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        findViewById(R.id.zyg_271_DoorLock).setOnClickListener(new View.OnClickListener() { 
            @Override
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
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
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
        findViewById(R.id.zyg_271_other).setOnClickListener(new View.OnClickListener() { 
            @Override
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
