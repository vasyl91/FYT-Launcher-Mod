package com.syu.carinfo.dj.b70;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DjB70TimeSettingAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dj_14b70_time_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.dj_14b70_hour_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70TimeSettingAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{97, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{97}, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_14b70_hour_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70TimeSettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{96, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{96}, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_14b70_minte_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70TimeSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{99, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{99}, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_14b70_minte_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70TimeSettingAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{98, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{98}, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_14b70_format_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70TimeSettingAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{101, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{101}, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_14b70_format_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70TimeSettingAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{100, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{100}, null, null);
            }
        });
    }
}
