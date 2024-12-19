package com.syu.carinfo.wc.gs4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS4IndexAct extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_gs4_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 262433) {
            findViewById(R.id.gs3_engine_speed).setVisibility(0);
            findViewById(R.id.gs3_engine_speed).setOnClickListener(this);
        } else {
            findViewById(R.id.gs3_engine_speed).setVisibility(8);
        }
        findViewById(R.id.gs4_btn_air).setOnClickListener(this);
        findViewById(R.id.gs4_btn_setting).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        switch (id) {
            case R.id.gs4_btn_air /* 2131433072 */:
                try {
                    if (DataCanbus.DATA[1000] == 262433) {
                        intent = new Intent(this, (Class<?>) GS3AirControlAct.class);
                    } else {
                        intent = new Intent(this, (Class<?>) GS4AirControlAct.class);
                    }
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.gs4_btn_setting /* 2131433073 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GS4CarSettingsAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.gs3_engine_speed /* 2131433074 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) GS3SpeedAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }
}
