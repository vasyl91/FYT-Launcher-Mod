package com.syu.carinfo.psa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408AlarmRecordActi;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcPsa301IndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_psa301_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.rzc_psa301_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.RzcPsa301IndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcPsa301IndexActi.this, BZ408OilMileIndexActi.class);
                    RzcPsa301IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_psa301_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.RzcPsa301IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        ((Button) findViewById(R.id.rzc_psa301_btn_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.RzcPsa301IndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcPsa301IndexActi.this, RZC_BZ408AlarmRecordActi.class);
                    RzcPsa301IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
