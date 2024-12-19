package com.syu.carinfo.xp.psa_all;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpPsaAllOrinalCarActivity extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_psa_all_orinal_car);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.xp_pas_all_btn_down)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{8}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_up)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{7}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{6}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{5}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_ok)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{9}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_mode)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_esc)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_park)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_pas_all_btn_menu)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(54, new int[]{4}, null, null);
            }
        });
    }
}
