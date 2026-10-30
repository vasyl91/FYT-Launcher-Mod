package com.syu.carinfo.rzc.hantengx5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_0255_HanTengX5_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0255_oudi_hantengx5_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.hantengx5.RZC_0255_HanTengX5_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.id_airset /* 2131427797 */:
                        cls = Air_Activity_All_NewAdd_HP.class;
                        break;
                    case R.id.id_carsettings /* 2131427798 */:
                        cls = RZC_0255_HanTengX5_CarSet.class;
                        break;
                    case R.id.id_tire /* 2131427799 */:
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
