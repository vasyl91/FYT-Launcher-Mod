package com.syu.carinfo.ztt600;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class IndexAct_Bnr extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_265_bnr_t600_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.ztt600.IndexAct_Bnr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427554 */:
                        cls = ZTAirAct_Bnr.class;
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427576 */:
                        cls = PM25Act_Bnr.class;
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427577 */:
                        cls = CarSetAct_Bnr.class;
                        break;
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(IndexAct_Bnr.this, cls);
                        IndexAct_Bnr.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.ctv_checkedtext1);
        setClick(v);
        View v2 = findViewById(R.id.ctv_checkedtext2);
        setClick(v2);
        View v3 = findViewById(R.id.ctv_checkedtext4);
        setClick(v3);
        View v4 = findViewById(R.id.ctv_checkedtext3);
        setClick(v4);
    }
}
