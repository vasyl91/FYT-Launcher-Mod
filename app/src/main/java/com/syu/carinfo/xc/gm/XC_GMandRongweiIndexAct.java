package com.syu.carinfo.xc.gm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.klc.RzcKlcOnStarAct;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XC_GMandRongweiIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_gm_rongwei_indexact);
        if (DataCanbus.DATA[1000] == 7471556) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.gm.XC_GMandRongweiIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XC_GMandRongweiIndexAct.this, XC_GMadRongweiCarInfo.class);
                    XC_GMandRongweiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.gm.XC_GMandRongweiIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XC_GMandRongweiIndexAct.this, XC_GMandRongweiCarSet.class);
                    XC_GMandRongweiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.gm.XC_GMandRongweiIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XC_GMandRongweiIndexAct.this, RzcKlcOnStarAct.class);
                    XC_GMandRongweiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}