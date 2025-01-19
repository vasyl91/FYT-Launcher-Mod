package com.syu.carinfo.ztt600;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class IndexAct_Luz extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_luz_t600_index);
        init();
    }

    @Override
    public void init() {
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.id_airset /* 2131427689 */:
                        cls = ZTAirAct_Luz.class;
                        break;
                    case R.id.id_tire /* 2131427691 */:
                        cls = ZTTireAct_Luz.class;
                        break;
                    case R.id.id_pm25 /* 2131428962 */:
                        cls = PM25Act_Luz.class;
                        break;
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(IndexAct_Luz.this, cls);
                        IndexAct_Luz.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.id_airset);
        setClick(v);
        View v2 = findViewById(R.id.id_pm25);
        setClick(v2);
        View v3 = findViewById(R.id.id_tire);
        setClick(v3);
    }
}
