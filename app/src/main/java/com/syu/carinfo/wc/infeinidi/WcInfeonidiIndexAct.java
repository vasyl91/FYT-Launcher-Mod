package com.syu.carinfo.wc.infeinidi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcInfeonidiIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_infinit_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        if (DataCanbus.DATA[1000] == 5308859 || DataCanbus.DATA[1000] == 8651195) {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 7209403) {
            findViewById(R.id.layout_view2).setVisibility(8);
        } else {
            findViewById(R.id.layout_view2).setVisibility(0);
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.infeinidi.WcInfeonidiIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 5308859 || DataCanbus.DATA[1000] == 8651195 || DataCanbus.DATA[1000] == 1507771 || DataCanbus.DATA[1000] == 7209403) {
                        intent.setClass(WcInfeonidiIndexAct.this, WcInfeinidiEQSet.class);
                    } else {
                        intent.setClass(WcInfeonidiIndexAct.this, WcInfinitCarInfo.class);
                    }
                    WcInfeonidiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.infeinidi.WcInfeonidiIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WcInfeonidiIndexAct.this, WcInfeinidiCarSet.class);
                    WcInfeonidiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.infeinidi.WcInfeonidiIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WcInfeonidiIndexAct.this, WcInfinitCarTire.class);
                    WcInfeonidiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_air).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.infeinidi.WcInfeonidiIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[104] == 2) {
                        intent.setClass(WcInfeonidiIndexAct.this, WcInfinitCarCD.class);
                    } else {
                        intent.setClass(WcInfeonidiIndexAct.this, WcInfinitCarRadio.class);
                    }
                    WcInfeonidiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
