package com.syu.carinfo.wc.ruijie15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.carinfo.ford.FordCarSet;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RJIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc3_15ruijie_index);
        setUI();
        if (DataCanbus.DATA[1000] == 300) {
            if (LauncherApplication.getConfiguration() == 1) {
                findViewById(R.id.wc_15ruijie_air).setVisibility(8);
                return;
            } else {
                findViewById(R.id.wc_15ruijie_air).setVisibility(0);
                return;
            }
        }
        findViewById(R.id.wc_15ruijie_air).setVisibility(8);
    }

    private void setUI() {
        findViewById(R.id.wc_15ruijie_car_settings_check).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    if (DataCanbus.DATA[1000] == 22 || DataCanbus.DATA[1000] == 131094 || DataCanbus.DATA[1000] == 300) {
                        RJIndexAct.this.startActivity(new Intent(RJIndexAct.this, (Class<?>) FordCarSet.class));
                    } else if (DataCanbus.DATA[1000] == 115) {
                        RJIndexAct.this.startActivity(new Intent(RJIndexAct.this, (Class<?>) WCYiboCarSetAct.class));
                    } else {
                        RJIndexAct.this.startActivity(new Intent(RJIndexAct.this, (Class<?>) RJCarSetAct.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_15ruijie_sync_set_check).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    RJIndexAct.this.startActivity(new Intent(RJIndexAct.this, (Class<?>) FocusSyncBtActi.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_15ruijie_air_set_check).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    RJIndexAct.this.startActivity(new Intent(RJIndexAct.this, (Class<?>) RJ_GC_AirControlAct.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
