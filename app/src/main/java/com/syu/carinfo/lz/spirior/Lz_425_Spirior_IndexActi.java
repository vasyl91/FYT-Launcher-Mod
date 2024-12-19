package com.syu.carinfo.lz.spirior;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Lz_425_Spirior_IndexActi extends BaseActivity {
    private CheckedTextView chkLightInfo;
    private CheckedTextView chkMeterInfo;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0425_lz_spirior_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.chkMeterInfo = (CheckedTextView) findViewById(R.id.lz_spirior_meter_info);
        this.chkMeterInfo.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.spirior.Lz_425_Spirior_IndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Lz_425_Spirior_IndexActi.this, Lz_425_Spirior_MeterAct.class);
                    Lz_425_Spirior_IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.chkLightInfo = (CheckedTextView) findViewById(R.id.lz_spirior_light_info);
        this.chkLightInfo.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.spirior.Lz_425_Spirior_IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Lz_425_Spirior_IndexActi.this, Lz_425_Spirior_LightAct.class);
                    Lz_425_Spirior_IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
