package com.syu.carinfo.rzc.changan_cx70;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcChanganCX70IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_odchangan_indexact);
        if (DataCanbus.DATA[1000] != 7471543 && DataCanbus.DATA[1000] != 4719044 && DataCanbus.DATA[1000] != 11010500 && DataCanbus.DATA[1000] != 3473861) {
            findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        }
        if (LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 3473861) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_charging_state);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.tire_pressure);
        }
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcChanganCX70IndexAct.this, RzcChanganCX70SetFunc.class);
                    RzcChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_air)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcChanganCX70IndexAct.this, RzcChanganCOSAirControlAct.class);
                    RzcChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70IndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 3473861) {
                        intent.setClass(RzcChanganCX70IndexAct.this, RzcChanganChargeSetFunc.class);
                    } else {
                        intent.setClass(RzcChanganCX70IndexAct.this, RzcChanganCX70TireAct.class);
                    }
                    RzcChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}