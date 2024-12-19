package com.syu.carinfo.oudi.hantengx5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Oudi_0255_HanTengX5_IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0255_oudi_hantengx5_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.id_airset /* 2131427677 */:
                        if (DataCanbus.DATA[1000] == 12124612) {
                            cls = Oudi_0452_Hongqi_AirControlAct.class;
                            break;
                        } else {
                            cls = Oudi_0255_HanTengX5_AirControlAct.class;
                            break;
                        }
                    case R.id.id_carsettings /* 2131427678 */:
                        if (DataCanbus.DATA[1000] == 459007) {
                            cls = Oudi_0255_XiaoYao_CarSettingAct.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 12124612) {
                            cls = Oudi_0452_Hongqi_CarSettingAct.class;
                            break;
                        } else {
                            cls = Oudi_0255_HanTengX5_CarSettingAct.class;
                            break;
                        }
                    case R.id.id_tire /* 2131427679 */:
                        if (DataCanbus.DATA[1000] == 12124612) {
                            cls = Oudi_0452_Hongqi_TireAct.class;
                            break;
                        } else {
                            cls = Oudi_0255_HanTengX5_TireAct.class;
                            break;
                        }
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(Oudi_0255_HanTengX5_IndexAct.this, cls);
                        Oudi_0255_HanTengX5_IndexAct.this.startActivity(ii);
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
