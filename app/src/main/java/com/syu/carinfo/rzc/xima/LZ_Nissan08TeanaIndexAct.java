package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZ_Nissan08TeanaIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_nissan_08teana_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(0);
                break;
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(0);
                break;
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(8);
                break;
        }
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaIndexAct.this, LZ_Nissan08TeanaCarinfoAct.class);
                    LZ_Nissan08TeanaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaIndexAct.this, LZ_Nissan08TeanaTireAct.class);
                    LZ_Nissan08TeanaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
                            intent.setClass(LZ_Nissan08TeanaIndexAct.this, LZ_Nissan08TeanaScreenAct.class);
                            break;
                        case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
                            DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                            break;
                    }
                    LZ_Nissan08TeanaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaIndexAct.this, LZ_Nissan08TeanaAmpCarSet.class);
                    LZ_Nissan08TeanaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaIndexAct.this, LZ_Nissan08TeanaRadio.class);
                    LZ_Nissan08TeanaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaIndexAct.this, LZ_Nissan08TeanaCd.class);
                    LZ_Nissan08TeanaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
