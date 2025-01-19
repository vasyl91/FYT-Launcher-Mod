package com.syu.carinfo.rzc.hantengx5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;

public class RZC_0255_HanTengX5_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0255_oudi_hantengx5_index);
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
                        cls = Air_Activity_All_NewAdd_HP.class;
                        break;
                    case R.id.id_carsettings /* 2131427690 */:
                        cls = RZC_0255_HanTengX5_CarSet.class;
                        break;
                    case R.id.id_tire /* 2131427691 */:
                        cls = RZC_0255_HanTengX5_TireAct.class;
                        break;
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(RZC_0255_HanTengX5_IndexAct.this, cls);
                        RZC_0255_HanTengX5_IndexAct.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.id_airset);
        setClick(v);
        View v2 = findViewById(R.id.id_carsettings);
        setClick(v2);
        View v3 = findViewById(R.id.id_tire);
        setClick(v3);
    }
}
