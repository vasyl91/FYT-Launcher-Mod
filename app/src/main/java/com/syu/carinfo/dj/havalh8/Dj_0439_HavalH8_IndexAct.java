package com.syu.carinfo.dj.havalh8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class Dj_0439_HavalH8_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_huiteng_indexact);
        init();
    }

    @Override
    public void init() {
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.jeep_car_cd /* 2131427825 */:
                        cls = Dj_0439_HavalH8CarCDAct.class;
                        break;
                    case R.id.jeep_car_info /* 2131427826 */:
                        cls = Dj_0439_HavalH8CarinfoAct.class;
                        break;
                    case R.id.jeep_car_settings /* 2131427827 */:
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
