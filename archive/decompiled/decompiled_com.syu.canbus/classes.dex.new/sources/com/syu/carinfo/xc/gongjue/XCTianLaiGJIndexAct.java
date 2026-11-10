package com.syu.carinfo.xc.gongjue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XCTianLaiGJIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_tianlai_gj_index);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.gongjue.XCTianLaiGJIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(XCTianLaiGJIndexAct.this, XCTianLaiGjAmpInfoAct.class);
                XCTianLaiGJIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.gongjue.XCTianLaiGJIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(XCTianLaiGJIndexAct.this, XCTianLaiGJCenterControlAct.class);
                XCTianLaiGJIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.gongjue.XCTianLaiGJIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(XCTianLaiGJIndexAct.this, XCTianLaiGjCdAct.class);
                XCTianLaiGJIndexAct.this.startActivity(intent);
            }
        });
    }
}
