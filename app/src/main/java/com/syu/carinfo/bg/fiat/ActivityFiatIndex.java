package com.syu.carinfo.bg.fiat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.R;
import com.syu.carinfo.xp.ziyouguang.Activity_374_FactorySetActivity;

public class ActivityFiatIndex extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_index_xp_fiat);
        findViewById(R.id.btn_usb_control).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ActivityFiatIndex.this.startActivity(new Intent(ActivityFiatIndex.this, ActivityFiatCarUSB.class));
            }
        });
        findViewById(R.id.btn_base_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ActivityFiatIndex.this.startActivity(new Intent(ActivityFiatIndex.this, Activity_374_FactorySetActivity.class));
            }
        });
    }
}
