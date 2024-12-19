package com.syu.carinfo.xc.lexus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCLexusIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_lexus_indexact);
        ((Button) findViewById(R.id.lexus_car_radio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusIndexAct.this, XCLexusRadio.class);
                    XCLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lexus_car_air)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusIndexAct.this, XCLexusCarUSB.class);
                    XCLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lexus_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusIndexAct.this, XCLexusCd.class);
                    XCLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
