package com.syu.carinfo.xbs.angkesaila;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS_AngKeSaiLa_Cx4_IndexAct extends BaseActivity {
    private Button xbs_418_CarCD;
    private Button xbs_418_CarOilInfo;
    private Button xbs_418_CarSettings;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_418_xbs_aksl_cx4_indexact);
        this.xbs_418_CarSettings = (Button) findViewById(R.id.xbs_418_car_settings);
        this.xbs_418_CarOilInfo = (Button) findViewById(R.id.xbs_418_car_oil_set);
        this.xbs_418_CarCD = (Button) findViewById(R.id.xbs_418_car_cd);
        this.xbs_418_CarSettings.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.XBS_AngKeSaiLa_Cx4_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBS_AngKeSaiLa_Cx4_IndexAct.this, Xbs_AngKeSaiLa_Setting.class);
                    XBS_AngKeSaiLa_Cx4_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.xbs_418_CarOilInfo.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.XBS_AngKeSaiLa_Cx4_IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBS_AngKeSaiLa_Cx4_IndexAct.this, Xbs_AngKeSaiLa_TripAct.class);
                    XBS_AngKeSaiLa_Cx4_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.xbs_418_CarCD.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.XBS_AngKeSaiLa_Cx4_IndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBS_AngKeSaiLa_Cx4_IndexAct.this, Xbs_AngKeSaiLa_CarCD.class);
                    XBS_AngKeSaiLa_Cx4_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
