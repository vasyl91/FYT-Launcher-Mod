package com.syu.carinfo.lz.landrover;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LandRoverIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_landrover_indexact);
        ((Button) findViewById(R.id.jeep_car_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.landrover.LandRoverIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LandRoverIndexAct.this, LandRoverCarInfo.class);
                    LandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.landrover.LandRoverIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (TheApp.getConfiguration() == 1) {
                        intent.setClass(LandRoverIndexAct.this, LandRoverNewCarinfoAct_sp.class);
                    } else {
                        intent.setClass(LandRoverIndexAct.this, LandRoverNewCarinfoAct.class);
                    }
                    LandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.landrover.LandRoverIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LandRoverIndexAct.this, LandRoverCarSet.class);
                    LandRoverIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
