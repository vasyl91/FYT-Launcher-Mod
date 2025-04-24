package com.syu.carinfo.bg.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class Bg_ZiYouguang_Settings_BG extends BaseActivity {
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
                    intent.setClass(Bg_ZiYouguang_Settings_BG.this, Bg_ZiYouguang_Safety.class);
                    Bg_ZiYouguang_Settings_BG.this.startActivity(intent);
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
                    intent.setClass(Bg_ZiYouguang_Settings_BG.this, Bg_ZiYouguang_Light.class);
                    Bg_ZiYouguang_Settings_BG.this.startActivity(intent);
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
                    intent.setClass(Bg_ZiYouguang_Settings_BG.this, Bg_ZiYouguang_DoorLock.class);
                    Bg_ZiYouguang_Settings_BG.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.zyg_271_other).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_ZiYouguang_Settings_BG.this, Bg_ZiYouguang_Other.class);
                    Bg_ZiYouguang_Settings_BG.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
