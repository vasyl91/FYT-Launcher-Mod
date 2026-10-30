package com.syu.carinfo.bg.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Bg_DaQieNuoJi_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_IndexAct.this, Bg_DaQieNuoJi_Settings.class);
                    Bg_DaQieNuoJi_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_airset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_IndexAct.this, Bg_ZiYouGuangAirControlAct.class);
                    Bg_DaQieNuoJi_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_IndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Bg_DaQieNuoJi_IndexAct.this, Bg_CdAct.class);
                    Bg_DaQieNuoJi_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TheApp.isPortrait()) {
            setViewVisible(findViewById(R.id.jeep_car_air), false);
        }
    }
}
