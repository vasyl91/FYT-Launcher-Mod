package com.syu.carinfo.xp.yinglang;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class YLCarSettingsAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_car_set);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.xp_yl_car_set_first_check).setOnClickListener(this);
        findViewById(R.id.xp_yl_car_set_Second_check).setOnClickListener(this);
        findViewById(R.id.xp_yl_car_set_basic_info_check).setOnClickListener(this);
        findViewById(R.id.xp_yl_car_set_tire_check).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 393241 || DataCanbus.DATA[1000] == 309 || DataCanbus.DATA[1000] == 2359321) {
            setViewVisible(findViewById(R.id.glf7_view_baseinfo), 0);
            setViewVisible(findViewById(R.id.glf7_view_tire), 0);
        } else if (DataCanbus.DATA[1000] == 263 || DataCanbus.DATA[1000] == 65799 || DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 393479 || DataCanbus.DATA[1000] == 459015) {
            setViewVisible(findViewById(R.id.glf7_view_baseinfo), 0);
            setViewVisible(findViewById(R.id.glf7_view_tire), 1);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_baseinfo), 1);
            setViewVisible(findViewById(R.id.glf7_view_tire), 1);
        }
        if (DataCanbus.DATA[1000] == 2359321) {
            setViewVisible(findViewById(R.id.glf7_view_functional_mirrors_and_wipers_lower_while_reversing), 0);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_car_set_basic_info_check /* 2131431875 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) YLBasicInfoAct.class);
                    if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                        intent = new Intent(this, (Class<?>) GL8_652TCarInfo.class);
                    }
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_first_check /* 2131433405 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) YLInfoSetFirstAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_Second_check /* 2131433406 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) YLInfoSetSecondAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_tire_check /* 2131433408 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) YLTireAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
