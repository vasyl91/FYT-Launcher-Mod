package com.syu.carinfo.oudi.changan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class OdChanganIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_odchangan_indexact);
        switch (DataCanbus.sCanbusId) {
            case FinalCanbus.CAR_439_OuDi_ZTT500 /* 721335 */:
            case FinalCanbus.CAR_439_OuDi_DMX7 /* 917943 */:
                setViewVisible(findViewById(R.id.odchangan_car_air_view), true);
                setViewVisible(findViewById(R.id.odchangan_car_setting_view), true);
                setViewVisible(findViewById(R.id.odchangan_car_tire_view), true);
                break;
            case FinalCanbus.CAR_439_OuDi_ZTT600 /* 786871 */:
                setViewVisible(findViewById(R.id.odchangan_car_air_view), false);
                setViewVisible(findViewById(R.id.odchangan_car_setting_view), true);
                setViewVisible(findViewById(R.id.odchangan_car_tire_view), true);
                break;
            case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                setViewVisible(findViewById(R.id.odchangan_car_air_view), false);
                break;
        }
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(OdChanganIndexAct.this, OdChanganSetFunc.class);
                    OdChanganIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_air)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(OdChanganIndexAct.this, OdChanganAirControlAct.class);
                    OdChanganIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.changan.OdChanganIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(OdChanganIndexAct.this, OdChanganTireAct.class);
                    OdChanganIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
