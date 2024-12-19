package com.syu.carinfo.bnr.tule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wc.ecosport18.Wc_21FordMDOCarInfo;
import com.syu.carinfo.wc.ecosport18.Wc_21_EcosportSetAct;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BnrTuleIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bnr_tule_indexact);
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.tule.BnrTuleIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 524309) {
                        intent.setClass(BnrTuleIndexAct.this, Wc_21_EcosportSetAct.class);
                    } else {
                        intent.setClass(BnrTuleIndexAct.this, BnrTuleCarInfo.class);
                    }
                    BnrTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.tule.BnrTuleIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 524309) {
                        intent.setClass(BnrTuleIndexAct.this, Wc_21FordMDOCarInfo.class);
                    } else {
                        intent.setClass(BnrTuleIndexAct.this, BnrTuleCarTire.class);
                    }
                    BnrTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
