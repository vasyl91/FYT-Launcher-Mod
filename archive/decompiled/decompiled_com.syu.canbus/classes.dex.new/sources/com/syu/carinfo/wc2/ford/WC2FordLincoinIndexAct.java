package com.syu.carinfo.wc2.ford;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2FordLincoinIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_ford_lincoin_index_act);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarSettingsAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinAmpInfoAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCdAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarRadioAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarSeatSet.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinFactoryPwdAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        if (DataCanbus.DATA[1000] == 4981179 || DataCanbus.DATA[1000] == 5571003) {
            findViewById(R.id.layout_view3).setVisibility(8);
            return;
        }
        if (DataCanbus.DATA[1000] == 5177787 || DataCanbus.DATA[1000] == 6685115 || DataCanbus.DATA[1000] == 15401403 || DataCanbus.DATA[1000] == 15729083 || DataCanbus.DATA[1000] == 15794619 || DataCanbus.DATA[1000] == 15860155 || DataCanbus.DATA[1000] == 15991227 || DataCanbus.DATA[1000] == 15925691 || DataCanbus.DATA[1000] == 16056763 || DataCanbus.DATA[1000] == 16122299 || DataCanbus.DATA[1000] == 16187835 || DataCanbus.DATA[1000] == 16253371 || DataCanbus.DATA[1000] == 16318907 || DataCanbus.DATA[1000] == 16384443 || DataCanbus.DATA[1000] == 7274940 || DataCanbus.DATA[1000] == 7340476 || DataCanbus.DATA[1000] == 7406012 || DataCanbus.DATA[1000] == 7733692 || DataCanbus.DATA[1000] == 7799228 || DataCanbus.DATA[1000] == 7864764 || DataCanbus.DATA[1000] == 7930300 || DataCanbus.DATA[1000] == 7995836 || DataCanbus.DATA[1000] == 8061372 || DataCanbus.DATA[1000] == 8126908 || DataCanbus.DATA[1000] == 8192444 || DataCanbus.DATA[1000] == 8257980 || DataCanbus.DATA[1000] == 8323516 || DataCanbus.DATA[1000] == 8389052 || DataCanbus.DATA[1000] == 8454588 || DataCanbus.DATA[1000] == 8520124 || DataCanbus.DATA[1000] == 8585660 || DataCanbus.DATA[1000] == 8651196 || DataCanbus.DATA[1000] == 8716732 || DataCanbus.DATA[1000] == 8782268 || DataCanbus.DATA[1000] == 8913340 || DataCanbus.DATA[1000] == 8978876 || DataCanbus.DATA[1000] == 9044412 || DataCanbus.DATA[1000] == 9109948 || DataCanbus.DATA[1000] == 9175484 || DataCanbus.DATA[1000] == 9241020 || DataCanbus.DATA[1000] == 9306556 || DataCanbus.DATA[1000] == 9372092 || DataCanbus.DATA[1000] == 9437628 || DataCanbus.DATA[1000] == 9503164 || DataCanbus.DATA[1000] == 9568700 || DataCanbus.DATA[1000] == 9634236 || DataCanbus.DATA[1000] == 9699772 || DataCanbus.DATA[1000] == 9765308 || DataCanbus.DATA[1000] == 9896380 || DataCanbus.DATA[1000] == 9961916 || DataCanbus.DATA[1000] == 10027452) {
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
        }
    }
}
