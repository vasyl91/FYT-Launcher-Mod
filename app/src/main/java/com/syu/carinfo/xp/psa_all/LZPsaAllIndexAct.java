package com.syu.carinfo.xp.psa_all;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ407CarCD;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ407CarRadio;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZPsaAllIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_mustang_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        ((Button) findViewById(R.id.jeep_car_radio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.LZPsaAllIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 1704275) {
                        intent.setClass(LZPsaAllIndexAct.this, RZC_BZ407CarRadio.class);
                    } else {
                        intent.setClass(LZPsaAllIndexAct.this, LZPsaAllCarRadio.class);
                    }
                    LZPsaAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.LZPsaAllIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 1704275) {
                        intent.setClass(LZPsaAllIndexAct.this, RZC_BZ407CarCD.class);
                    } else {
                        intent.setClass(LZPsaAllIndexAct.this, LZPsaAllCarCD.class);
                    }
                    LZPsaAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.LZPsaAllIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 1704275) {
                        intent.setClass(LZPsaAllIndexAct.this, RZC_BZ408IndexActi.class);
                    } else {
                        intent.setClass(LZPsaAllIndexAct.this, XpPsaAllIndexActi.class);
                    }
                    LZPsaAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
