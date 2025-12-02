package com.syu.carinfo.saiou3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class SaiOu3Index extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_sb_saiou3_index);
        setUI();
    }

    private void setUI() {
        findViewById(R.id.xfl_ck_air_message_check).setOnClickListener(this);
        findViewById(R.id.xfl_ck_car_body_check).setOnClickListener(this);
        findViewById(R.id.xfl_ck_onstar_set_check).setOnClickListener(this);
        findViewById(R.id.xfl_ck_car_body2_check).setOnClickListener(this);
        findViewById(R.id.xfl_air_control_set_check).setOnClickListener(this);
        if (findViewById(R.id.id_tire) != null) {
            findViewById(R.id.id_tire).setOnClickListener(this);
        }
        if (findViewById(R.id.id_fuel) != null) {
            findViewById(R.id.id_fuel).setOnClickListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (findViewById(R.id.id_tire) != null) {
            findViewById(R.id.id_tire).setVisibility(DataCanbus.DATA[1000] == 65868 ? 0 : 8);
        }
        if (findViewById(R.id.id_fuel) != null) {
            findViewById(R.id.id_fuel).setVisibility(DataCanbus.DATA[1000] != 65868 ? 8 : 0);
        }
        if (LauncherApplication.isPortrait() && findViewById(R.id.id_airset) != null) {
            findViewById(R.id.id_airset).setVisibility(8);
        }
    }

    @Override
    public void onClick(View v) {
        Class<?> cls = null;
        switch (v.getId()) {
            case R.id.id_tire /* 2131427691 */:
                cls = ActTire_GM_SiBo.class;
                break;
            case R.id.xfl_ck_air_message_check /* 2131432799 */:
                if (DataCanbus.DATA[1000] == 65868) {
                    cls = ActAirSet_GM_SiBo.class;
                    break;
                } else {
                    cls = SO3AirAct.class;
                    break;
                }
            case R.id.xfl_ck_car_body_check /* 2131432800 */:
                if (DataCanbus.DATA[1000] == 65868) {
                    cls = ActCarSet1_GM_SiBo.class;
                    break;
                } else {
                    cls = SO3Carbody1Act.class;
                    break;
                }
            case R.id.xfl_ck_car_body2_check /* 2131432801 */:
                if (DataCanbus.DATA[1000] == 65868) {
                    cls = ActCarSet2_GM_SiBo.class;
                    break;
                } else {
                    cls = SO3CarBody2Act.class;
                    break;
                }
            case R.id.xfl_air_control_set_check /* 2131432803 */:
                cls = SO3AirControlAct.class;
                break;
            case R.id.id_fuel /* 2131432805 */:
                cls = ActFuel_GM_SiBo.class;
                break;
        }
        if (cls != null) {
            try {
                Intent intent = new Intent();
                intent.setClass(this, cls);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
