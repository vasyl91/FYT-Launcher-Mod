package com.syu.carinfo.od.mazdall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wc2.tata.WC2TataCarSet;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCSuzukiAllIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzuki_indexact);
        if (DataCanbus.DATA[1000] == 12059067) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        ((Button) findViewById(R.id.jeep_car_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 12059067) {
                        intent.setClass(WCSuzukiAllIndexAct.this, WCTataCarInfoIndexAct.class);
                    } else {
                        intent.setClass(WCSuzukiAllIndexAct.this, WCSuzukiCarInfo.class);
                    }
                    WCSuzukiAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 12059067) {
                        intent.setClass(WCSuzukiAllIndexAct.this, WC2TataCarSet.class);
                    } else {
                        intent.setClass(WCSuzukiAllIndexAct.this, WCSuzukiAllCarSet.class);
                    }
                    WCSuzukiAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_tireinfo)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAllIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCSuzukiAllIndexAct.this, WCSuzukiCarTire.class);
                    WCSuzukiAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
