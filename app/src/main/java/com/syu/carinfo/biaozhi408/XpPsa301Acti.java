package com.syu.carinfo.biaozhi408;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408AlarmRecordActi;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XpPsa301Acti extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa301_index_xp);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.psa301_btn_trip_xp).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsa301Acti.this, BZ408OilMileIndexActi.class);
                    XpPsa301Acti.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.psa301_btn_setting_xp).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XpPsa301Acti.this, XpPsa301settingActi.class);
                    XpPsa301Acti.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.psa301_btn_info_xp).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 123) {
                        intent.setClass(XpPsa301Acti.this, RZC_BZ408AlarmRecordActi.class);
                    } else {
                        intent.setClass(XpPsa301Acti.this, BZ408AlarmRecordActi.class);
                    }
                    XpPsa301Acti.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
