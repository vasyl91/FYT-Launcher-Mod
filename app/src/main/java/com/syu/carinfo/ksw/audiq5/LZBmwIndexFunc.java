package com.syu.carinfo.ksw.audiq5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZBmwIndexFunc extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_indexact);
        if (DataCanbus.DATA[1000] == 65984 || DataCanbus.DATA[1000] == 197056 || DataCanbus.DATA[1000] == 262592 || DataCanbus.DATA[1000] == 131520) {
            findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        }
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.LZBmwIndexFunc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 65984 || DataCanbus.DATA[1000] == 197056 || DataCanbus.DATA[1000] == 262592 || DataCanbus.DATA[1000] == 131520) {
                        intent.setClass(LZBmwIndexFunc.this, ZXMZDSetFunc.class);
                    } else {
                        intent.setClass(LZBmwIndexFunc.this, KswAudiQ5SetFunc.class);
                    }
                    LZBmwIndexFunc.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.LZBmwIndexFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZBmwIndexFunc.this, LZBmwCarinfoAct.class);
                    LZBmwIndexFunc.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ksw.audiq5.LZBmwIndexFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZBmwIndexFunc.this, LzBmwTireAct.class);
                    LZBmwIndexFunc.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}