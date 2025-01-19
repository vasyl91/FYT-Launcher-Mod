package com.syu.carinfo.wc.gs4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class GS4CarSettingsAct extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_289_wc_gs4_car_set);
        init();
    }

    private void init() {
        findViewById(R.id.wc_gs4_air_car_set_check).setOnClickListener(this);
        findViewById(R.id.wc_gs4_seat_car_set_check).setOnClickListener(this);
        findViewById(R.id.wc_gs4_help_set_check).setOnClickListener(this);
        findViewById(R.id.wc_gs4_car_accessory_set_check).setOnClickListener(this);
        findViewById(R.id.wc_gs4_light_set_check).setOnClickListener(this);
        findViewById(R.id.wc_gs4_charging_set_check).setOnClickListener(this);
        if (DataCanbus.DATA[1000] != 459041 && DataCanbus.DATA[1000] != 655649 && DataCanbus.DATA[1000] != 786721) {
            findViewById(R.id.view_functional_charging_set).setVisibility(8);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_air_car_set_check /* 2131429106 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS4AirSetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_seat_car_set_check /* 2131429108 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GS4SeatSetAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_help_set_check /* 2131429110 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) GS4HelpSetAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_car_accessory_set_check /* 2131429112 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) GS4CarAccessoryAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_light_set_check /* 2131429113 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) GS4LightSetAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_charging_set_check /* 2131429115 */:
                try {
                    Intent intent6 = new Intent(this, (Class<?>) GE3ChargingSetAct.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
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
