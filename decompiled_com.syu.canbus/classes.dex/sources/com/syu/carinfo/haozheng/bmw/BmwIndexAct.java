package com.syu.carinfo.haozheng.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BmwIndexAct extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_haozheng_bmw_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.bogoo_bmw_car_log_check).setOnClickListener(this);
        findViewById(R.id.bogoo_bmw_system_set_check).setOnClickListener(this);
        findViewById(R.id.bogoo_bmw_time_check).setOnClickListener(this);
        findViewById(R.id.bogoo_bmw_seat_heat_check).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bogoo_bmw_car_log_check /* 2131431680 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) BmwCarLogAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.bogoo_bmw_system_set_check /* 2131431681 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) BmwSystemSetAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.bogoo_bmw_time_check /* 2131431682 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) BmwTimeSetAct.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.bogoo_bmw_seat_heat_check /* 2131431684 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) BmwSeatHeatAct.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }
}
