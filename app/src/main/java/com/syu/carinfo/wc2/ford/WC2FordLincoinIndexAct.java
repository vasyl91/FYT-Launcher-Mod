package com.syu.carinfo.wc2.ford;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2FordLincoinIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_ford_lincoin_index_act);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarSettingsAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinAmpInfoAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCdAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarRadioAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarSeatSet.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        if (DataCanbus.DATA[1000] == 5177787 || DataCanbus.DATA[1000] == 6685115 || DataCanbus.DATA[1000] == 15401403 || DataCanbus.DATA[1000] == 15729083 || DataCanbus.DATA[1000] == 15794619 || DataCanbus.DATA[1000] == 15860155 || DataCanbus.DATA[1000] == 15991227 || DataCanbus.DATA[1000] == 15925691 || DataCanbus.DATA[1000] == 16056763 || DataCanbus.DATA[1000] == 16122299 || DataCanbus.DATA[1000] == 16187835 || DataCanbus.DATA[1000] == 16253371 || DataCanbus.DATA[1000] == 16318907 || DataCanbus.DATA[1000] == 16384443) {
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
        }
    }
}
