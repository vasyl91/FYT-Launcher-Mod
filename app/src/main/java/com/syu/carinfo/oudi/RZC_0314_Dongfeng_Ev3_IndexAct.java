package com.syu.carinfo.oudi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_0314_Dongfeng_Ev3_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_indexact);
        findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_Dongfeng_Ev3_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_0314_Dongfeng_Ev3_IndexAct.this, RZC_0314_DongfengEv3_CarSettingAct.class);
                    RZC_0314_Dongfeng_Ev3_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_Dongfeng_Ev3_IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 1769786 || DataCanbus.DATA[1000] == 1835322 || DataCanbus.DATA[1000] == 1900858) {
                        intent.setClass(RZC_0314_Dongfeng_Ev3_IndexAct.this, RZC_0314_DongfengE3_CarInfoAct.class);
                    } else {
                        intent.setClass(RZC_0314_Dongfeng_Ev3_IndexAct.this, RZC_0314_DongfengEv3_CarInfoAct.class);
                    }
                    RZC_0314_Dongfeng_Ev3_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
