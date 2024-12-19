package com.syu.carinfo.crv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.carinfo.dasauto.DasAutoXpAct;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KangshengXpCrvActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_047_xp_crv_index);
        findViewById(R.id.car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.KangshengXpCrvActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KangshengXpCrvActi.this, DasAutoXpAct.class);
                    KangshengXpCrvActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.CarInfo).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.KangshengXpCrvActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KangshengXpCrvActi.this, XpCrvActi.class);
                    if (DataCanbus.DATA[1] == 0) {
                        FuncMain.tips(KangshengXpCrvActi.this.getString(R.string.vehicle_not_exist));
                    } else {
                        KangshengXpCrvActi.this.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
