package com.syu.carinfo.psa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Psa301IndexActi extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa301_index);
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.psa301_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa301IndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Psa301IndexActi.this, PsaOilMileIndexActi.class);
                    Psa301IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.psa301_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa301IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 12) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Psa301IndexActi.this, PsaC4LsettingActi.class);
                        Psa301IndexActi.this.startActivity(intent);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (DataCanbus.DATA[1000] == 129) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setClass(Psa301IndexActi.this, PsaC5settingActi.class);
                        Psa301IndexActi.this.startActivity(intent2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        ((Button) findViewById(R.id.psa301_btn_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa301IndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Psa301IndexActi.this, PsaAlarmRecordActi.class);
                    Psa301IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}