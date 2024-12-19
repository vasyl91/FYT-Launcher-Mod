package com.syu.carinfo.hc.tianlai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class IndexAct_Hc_03TianLai extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_327_hc_03tianlai_index);
        if (DataCanbus.DATA[1000] != 131399 && DataCanbus.DATA[1000] != 262471) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        if (((Button) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((Button) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.IndexAct_Hc_03TianLai.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_03TianLai.this, ActivityTianLaiCarCD.class);
                        IndexAct_Hc_03TianLai.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (((Button) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.IndexAct_Hc_03TianLai.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_03TianLai.this, ActivityFx35CarSettings.class);
                        IndexAct_Hc_03TianLai.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (((Button) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.tianlai.IndexAct_Hc_03TianLai.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_03TianLai.this, ActivityTianLaiCarInfo.class);
                        IndexAct_Hc_03TianLai.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
