package com.syu.carinfo.daojun.lexus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djLexusIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djlexus_indexact);
        findViewById(R.id.lexus_car_radio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djLexusIndexAct.this, djLexusRadio.class);
                    djLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_car_air).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djLexusIndexAct.this, djLexusAirControlAct.class);
                    djLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_car_cd).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djLexusIndexAct.this, djLexusCd.class);
                    djLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
