package com.syu.carinfo.rzc.andra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.opel.OPELCarKeyActivity;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GmAndraIndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_andra_index);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.wc_geshitu_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraIndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan03TeanaCd.class);
                            break;
                        default:
                            intent.setClass(GmAndraIndexActi.this, GmAndraActivityCarCD.class);
                            break;
                    }
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.wc_geshitu_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan03TeanaCarSet.class);
                            break;
                        default:
                            intent.setClass(GmAndraIndexActi.this, GmAndraCarinfoIndexAct.class);
                            break;
                    }
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(GmAndraIndexActi.this, OPELCarKeyActivity.class);
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraIndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(GmAndraIndexActi.this, LzNissan03TeanaTireAct.class);
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
