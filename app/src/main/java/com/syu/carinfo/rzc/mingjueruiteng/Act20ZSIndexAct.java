package com.syu.carinfo.rzc.mingjueruiteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rongwei.Wc_416_RongWei_CarSetAct;
import com.syu.carinfo.rongwei.Wc_416_RongweiEi6CarInfo;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Act20ZSIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_jianghuai_iev6e_indexact);
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 262560) {
                        intent.setClass(Act20ZSIndexAct.this, Wc_416_RongWei_CarSetAct.class);
                    } else {
                        intent.setClass(Act20ZSIndexAct.this, Act17RuiTengCarSet.class);
                    }
                    Act20ZSIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 1573137 || DataCanbus.DATA[1000] == 262560) {
            findViewById(R.id.wc_jianghuai_car_tire_view).setVisibility(8);
        } else {
            findViewById(R.id.wc_jianghuai_carinfo_view).setVisibility(8);
        }
        findViewById(R.id.wc_jianghuai_carinfo).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 262560) {
                        intent.setClass(Act20ZSIndexAct.this, Wc_416_RongweiEi6CarInfo.class);
                    } else {
                        intent.setClass(Act20ZSIndexAct.this, ActRongweiEi6CarInfo.class);
                    }
                    Act20ZSIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_jianghuai_car_tire).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Act20ZSIndexAct.this, Act20ZSCarTire.class);
                    Act20ZSIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
