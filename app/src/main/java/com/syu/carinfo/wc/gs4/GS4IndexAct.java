package com.syu.carinfo.wc.gs4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.canbus.DataCanbus;

public class GS4IndexAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_gs4_index);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.gs4_btn_air /* 2131432971 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.gs4_btn_setting /* 2131432972 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GS4CarSettingsAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.gs3_engine_speed /* 2131432973 */:
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
