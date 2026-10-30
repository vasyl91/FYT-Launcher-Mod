package com.syu.carinfo.rzc.changan_cx70;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcChanganCX70IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzcchangan_indexact);
        if (DataCanbus.DATA[1000] != 7471543 && DataCanbus.DATA[1000] != 4719044 && DataCanbus.DATA[1000] != 11010500 && DataCanbus.DATA[1000] != 3473861) {
            findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        }
        if (TheApp.getConfiguration() == 1) {
            findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 3473861) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_charging_state);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.tire_pressure);
        }
        if (DataCanbus.DATA[1000] == 10158534) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_orinal_car_fuc);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_main_settings_title);
        }
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 10158534) {
                        intent.setClass(RzcChanganCX70IndexAct.this, RZCBenBenOrinalCarActivity.class);
                    } else {
                        intent.setClass(RzcChanganCX70IndexAct.this, RzcChanganCX70SetFunc.class);
                    }
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
                    intent.setClass(RzcChanganCX70IndexAct.this, Air_Activity_All_Toyota_prado_HP.class);
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
