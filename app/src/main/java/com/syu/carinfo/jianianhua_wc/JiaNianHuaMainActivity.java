package com.syu.carinfo.jianianhua_wc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JiaNianHuaMainActivity extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jianianhua_main);
        ((Button) findViewById(R.id.jia_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaMainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(JiaNianHuaMainActivity.this, JiaNianHuaCarSettings.class);
                    JiaNianHuaMainActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jia_car_warning_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaMainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(JiaNianHuaMainActivity.this, JiaNianHuaWarningInfo.class);
                    JiaNianHuaMainActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
