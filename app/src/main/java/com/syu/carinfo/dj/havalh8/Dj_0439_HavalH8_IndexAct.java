package com.syu.carinfo.dj.havalh8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dj_0439_HavalH8_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_huiteng_indexact);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.jeep_car_cd /* 2131427806 */:
                        cls = Dj_0439_HavalH8CarCDAct.class;
                        break;
                    case R.id.jeep_car_info /* 2131427807 */:
                        cls = Dj_0439_HavalH8CarinfoAct.class;
                        break;
                    case R.id.jeep_car_settings /* 2131427808 */:
                        cls = Dj_0439_HavalH8SetAct.class;
                        break;
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(Dj_0439_HavalH8_IndexAct.this, cls);
                        Dj_0439_HavalH8_IndexAct.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.jeep_car_settings);
        setClick(v);
        View v2 = findViewById(R.id.jeep_car_info);
        setClick(v2);
        View v3 = findViewById(R.id.jeep_car_cd);
        setClick(v3);
    }
}
