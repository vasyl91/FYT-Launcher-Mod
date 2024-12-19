package com.syu.carinfo.xp.SanlinSeries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class SanlinXPIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_354_xp_sanlin_indexact);
        ((Button) findViewById(R.id.xbs_418_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.SanlinSeries.SanlinXPIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(SanlinXPIndexAct.this, SanlinXPCarSet.class);
                    SanlinXPIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.xbs_418_car_oil_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.SanlinSeries.SanlinXPIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(SanlinXPIndexAct.this, SanlinXPEQCarSet.class);
                    SanlinXPIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
