package com.syu.carinfo.haozheng.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class BmwIndexAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_haozheng_bmw_index);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.bogoo_bmw_car_log_check).setOnClickListener(this);
        findViewById(R.id.bogoo_bmw_system_set_check).setOnClickListener(this);
        findViewById(R.id.bogoo_bmw_time_check).setOnClickListener(this);
        findViewById(R.id.bogoo_bmw_seat_heat_check).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bogoo_bmw_car_log_check /* 2131431657 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) BmwCarLogAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.bogoo_bmw_system_set_check /* 2131431658 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) BmwSystemSetAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.bogoo_bmw_time_check /* 2131431659 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) BmwTimeSetAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.bogoo_bmw_seat_heat_check /* 2131431661 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) BmwSeatHeatAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
        }
    }
}
