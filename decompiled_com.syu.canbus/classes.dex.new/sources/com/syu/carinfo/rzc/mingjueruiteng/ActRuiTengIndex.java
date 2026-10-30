package com.syu.carinfo.rzc.mingjueruiteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActRuiTengIndex extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_ruiteng_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_carset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengIndex.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent;
                if (196881 == DataCanbus.DATA[1000]) {
                    intent = new Intent(ActRuiTengIndex.this, (Class<?>) Act17RuiTengCarSet.class);
                } else {
                    intent = new Intent(ActRuiTengIndex.this, (Class<?>) ActRuiTengCarSet.class);
                }
                ActRuiTengIndex.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_air_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengIndex.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent(ActRuiTengIndex.this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                ActRuiTengIndex.this.startActivity(intent);
            }
        });
    }
}
