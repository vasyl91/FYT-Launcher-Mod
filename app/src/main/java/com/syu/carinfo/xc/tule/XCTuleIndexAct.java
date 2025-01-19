package com.syu.carinfo.xc.tule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class XCTuleIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_tule_indexact);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 6095300) {
                        intent.setClass(XCTuleIndexAct.this, ODNissanTuleCarInfo.class);
                    } else {
                        intent.setClass(XCTuleIndexAct.this, XCTuleCarInfo.class);
                    }
                    XCTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 6095300) {
                        intent.setClass(XCTuleIndexAct.this, ODNissanTuleCarTire.class);
                    } else {
                        intent.setClass(XCTuleIndexAct.this, XCTuleCarTire.class);
                    }
                    XCTuleIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
