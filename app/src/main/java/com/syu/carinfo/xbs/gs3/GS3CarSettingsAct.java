package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS3CarSettingsAct extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_289_wc_gs4_car_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        View airset = findViewById(R.id.wc_gs4_air_car_set_check);
        View seatset = findViewById(R.id.wc_gs4_seat_car_set_check);
        View helpset = findViewById(R.id.wc_gs4_help_set_check);
        View accessoryset = findViewById(R.id.wc_gs4_car_accessory_set_check);
        View findViewById2 = findViewById(R.id.wc_gs4_light_set_check);
        setSelfClick(airset, this);
        setSelfClick(seatset, this);
        setSelfClick(helpset, this);
        setSelfClick(accessoryset, this);
        setSelfClick(findViewById2, this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{10}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_air_car_set_check /* 2131429146 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3AirSetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_seat_car_set_check /* 2131429148 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GS3SeatSetAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_help_set_check /* 2131429150 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) GS3HelpSetAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_car_accessory_set_check /* 2131429152 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) GS3CarAccessoryAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.wc_gs4_light_set_check /* 2131429153 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) GS3LightSetAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
