package com.syu.carinfo.daojun.tianlai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class djTianlaiIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djtianlai_indexact);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djTianlaiIndexAct.this, djTianlaiCd.class);
                    djTianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djTianlaiIndexAct.this, djTianlaiRadio.class);
                    djTianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djTianlaiIndexAct.this, djTianlaiAudio.class);
                    djTianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djTianlaiIndexAct.this, djTianlaiCarKeyActivity.class);
                    djTianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_CZH_NISSAN_08Tianlai /* 6619591 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
        }
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djTianlaiIndexAct.this, CZH_NissanCarinfoAct.class);
                    djTianlaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
