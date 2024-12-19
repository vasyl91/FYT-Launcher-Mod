package com.syu.carinfo.havah6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC_0320_HavalH9_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_oudi_havalh9_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427478 */:
                        cls = WC_0320_HavalH9SetAct.class;
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427531 */:
                        cls = WC_0320_HavalH9AmpCarSet.class;
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427532 */:
                        cls = WC_0320_HavalH9CarinfoAct.class;
                        break;
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(WC_0320_HavalH9_IndexAct.this, cls);
                        WC_0320_HavalH9_IndexAct.this.startActivity(ii);
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
        View v3 = findViewById(R.id.ctv_checkedtext3);
        setClick(v3);
    }
}
