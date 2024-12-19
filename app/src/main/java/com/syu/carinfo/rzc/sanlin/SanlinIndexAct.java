package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.jili.RZCNisaanGuishiCarSettingsAct;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class SanlinIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_huiteng_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        if (DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_orinal_car_fuc);
        } else if (DataCanbus.DATA[1000] == 1376446) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_guandao_amp);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.SanlinIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 12255684) {
                        intent.setClass(SanlinIndexAct.this, LZMaseratiCarInfo.class);
                    } else if (DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
                        intent.setClass(SanlinIndexAct.this, LuZVolvoCarInfo.class);
                    } else if (DataCanbus.DATA[1000] == 1507781) {
                        intent.setClass(SanlinIndexAct.this, LuZBMW15MiniCarInfo.class);
                    } else if (DataCanbus.DATA[1000] == 1376446) {
                        intent.setClass(SanlinIndexAct.this, RZCNissanAmpCarSet.class);
                    } else {
                        intent.setClass(SanlinIndexAct.this, SanlinCarInfo.class);
                    }
                    SanlinIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.SanlinIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 12255684) {
                        intent.setClass(SanlinIndexAct.this, LZMaseratiCarSet.class);
                    } else if (DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
                        intent.setClass(SanlinIndexAct.this, LuzVolvoCarSet.class);
                    } else if (DataCanbus.DATA[1000] == 1507781) {
                        intent.setClass(SanlinIndexAct.this, LuzBMW15MiniCarSet.class);
                    } else if (DataCanbus.DATA[1000] == 1376446) {
                        intent.setClass(SanlinIndexAct.this, RZCNisaanGuishiCarSettingsAct.class);
                    } else {
                        intent.setClass(SanlinIndexAct.this, SanlinCarSet.class);
                    }
                    SanlinIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
