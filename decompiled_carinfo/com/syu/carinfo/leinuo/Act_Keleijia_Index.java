package com.syu.carinfo.leinuo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Act_Keleijia_Index extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_keleiao_index);
        View viewAir = findViewById(R.id.id_airset);
        View viewCarSet = findViewById(R.id.id_carset);
        setSelfClick(findViewById(R.id.btn_air_control), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    Class<?> cls = Act_Keleijia_Airset_high.class;
                    if (DataCanbus.DATA[1000] == 328054) {
                        cls = Act_Keleijia_Airset.class;
                    }
                    intent.setClass(Act_Keleijia_Index.this, cls);
                    Act_Keleijia_Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick(findViewById(R.id.btn_base_info), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Act_Keleijia_Index.this, Act_Keleijia_set.class);
                    Act_Keleijia_Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 328054) {
            setViewVisible(viewCarSet, false);
        }
        if (LauncherApplication.isPortrait()) {
            setViewVisible(viewAir, false);
        }
    }
}
