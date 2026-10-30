package com.syu.carinfo.rzc.changan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcChanganAllIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_changan_indexact);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcChanganAllIndexAct.this, RzcChanganAllSetAct.class);
                    RzcChanganAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcChanganAllIndexAct.this, RzcChanganAllTireAct.class);
                    RzcChanganAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
