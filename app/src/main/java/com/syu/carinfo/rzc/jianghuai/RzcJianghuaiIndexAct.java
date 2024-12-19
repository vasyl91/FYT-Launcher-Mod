package com.syu.carinfo.rzc.jianghuai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard;
import com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard_HP;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcJianghuaiIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_indexact);
        if (DataCanbus.sCanbusId != 2621879 && DataCanbus.sCanbusId != 11338167 && DataCanbus.sCanbusId != 11403703 && DataCanbus.sCanbusId != 10879428 && DataCanbus.sCanbusId != 10944964) {
            findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(8);
        } else {
            findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(0);
        }
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiSetFunc.class);
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.sCanbusId != 2621879 && DataCanbus.sCanbusId != 11338167 && DataCanbus.sCanbusId != 11403703 && DataCanbus.sCanbusId != 10879428 && DataCanbus.sCanbusId != 10944964) {
                        if (LauncherApplication.getConfiguration() == 1) {
                            intent.setClass(RzcJianghuaiIndexAct.this, RZCAddCanDashBoard.class);
                        } else {
                            intent.setClass(RzcJianghuaiIndexAct.this, RZCAddCanDashBoard_HP.class);
                        }
                    } else {
                        intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiCarinfoAct.class);
                    }
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiTireAct.class);
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
