package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LingDuActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_lingdu_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.lingdu_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.LingDuActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 270) {
                        intent.setClass(LingDuActi.this, Golf7OilMileagePage1LowActi.class);
                    } else if (DataCanbus.DATA[1000] == 279) {
                        intent.setClass(LingDuActi.this, Golf7OilMileageIndexActi.class);
                    }
                    LingDuActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lingdu_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.LingDuActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LingDuActi.this, Golf7FunctionalEscSystemActi.class);
                    LingDuActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
