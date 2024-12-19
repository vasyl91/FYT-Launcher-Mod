package com.syu.carinfo.rzc.havalh6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.hava.BNRActivityHavaH6SetAct;
import com.syu.carinfo.hava.BNRActivityHavaH8EQSetAct;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_Oudi_0439_HavalH9_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_oudi_havalh9_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] != 16318903 && DataCanbus.DATA[1000] != 16384439) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.RZC_Oudi_0439_HavalH9_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427478 */:
                        if (DataCanbus.DATA[1000] == 7078327 || DataCanbus.DATA[1000] == 7143863 || DataCanbus.DATA[1000] == 11272631 || DataCanbus.DATA[1000] == 7602615) {
                            cls = Activity439Hava18H6SetAct.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 16318903 || DataCanbus.DATA[1000] == 16384439) {
                            cls = BNRActivityHavaH6SetAct.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 2556343) {
                            cls = Rzc_0439_HavalH9SetAct.class;
                            break;
                        } else {
                            cls = Oudi_0439_HavalH9SetAct.class;
                            break;
                        }
                    case R.id.ctv_checkedtext2 /* 2131427531 */:
                        cls = BNRActivityHavaH8EQSetAct.class;
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427532 */:
                        if (DataCanbus.DATA[1000] == 7078327 || DataCanbus.DATA[1000] == 7143863 || DataCanbus.DATA[1000] == 7143863) {
                            cls = ActivityHavaRZCH2SCarInfo2.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 16318903 || DataCanbus.DATA[1000] == 16384439) {
                            cls = BNR_Oudi_0439_HavalH9CarinfoAct.class;
                            break;
                        } else {
                            cls = Rzc_Oudi_0439_HavalH9CarinfoAct.class;
                            break;
                        }
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(RZC_Oudi_0439_HavalH9_IndexAct.this, cls);
                        RZC_Oudi_0439_HavalH9_IndexAct.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.ctv_checkedtext1);
        setClick(v);
        View v2 = findViewById(R.id.ctv_checkedtext3);
        setClick(v2);
        View v3 = findViewById(R.id.ctv_checkedtext2);
        setClick(v3);
    }
}
