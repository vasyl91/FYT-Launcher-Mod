package com.syu.carinfo.ztt600;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class IndexAct_Bnr extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_bnr_t600_index);
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
                        cls = ZTAirAct_Bnr.class;
                        break;
                    case R.id.id_carset /* 2131428046 */:
                        cls = CarSetAct_Bnr.class;
                        break;
                    case R.id.id_pm25 /* 2131428962 */:
                        cls = PM25Act_Bnr.class;
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
        View v = findViewById(R.id.id_airset);
        setClick(v);
        View v2 = findViewById(R.id.id_pm25);
        setClick(v2);
        View v3 = findViewById(R.id.id_tire);
        setClick(v3);
        View v4 = findViewById(R.id.id_carset);
        setClick(v4);
    }
}
