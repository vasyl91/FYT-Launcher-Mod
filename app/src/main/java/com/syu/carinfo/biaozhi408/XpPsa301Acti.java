package com.syu.carinfo.biaozhi408;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408AlarmRecordActi;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpPsa301Acti extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa301_index_xp);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.psa301_btn_trip_xp).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.XpPsa301Acti.1
            @Override // android.view.View.OnClickListener
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
        findViewById(R.id.psa301_btn_setting_xp).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.XpPsa301Acti.2
            @Override // android.view.View.OnClickListener
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
        findViewById(R.id.psa301_btn_info_xp).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.XpPsa301Acti.3
            @Override // android.view.View.OnClickListener
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
