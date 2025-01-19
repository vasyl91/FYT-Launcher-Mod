package com.syu.carinfo.daojun.ats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.xp.yinglang.YLOnStarAct;
import com.syu.module.canbus.DataCanbus;

public class AtsIndexAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_daojun_ats_index);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 852316 || DataCanbus.DATA[1000] == 917852) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AtsFunc.C_REQUEST_CAR_INFO(49);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) AtsCarSettingsAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) AtsAirMessageAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) YLOnStarAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }
}
