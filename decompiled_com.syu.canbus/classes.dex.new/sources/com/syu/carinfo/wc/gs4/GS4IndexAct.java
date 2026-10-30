package com.syu.carinfo.wc.gs4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        int id = v.getId();
        switch (id) {
            case R.id.gs4_btn_air /* 2131432032 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.gs4_btn_setting /* 2131432033 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GS4CarSettingsAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.gs3_engine_speed /* 2131432034 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) GS3SpeedAct.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
        }
    }
}
