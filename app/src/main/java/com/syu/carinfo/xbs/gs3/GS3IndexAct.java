package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS3IndexAct extends BaseActivity implements View.OnClickListener {
    View Energy_View;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_gs3_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        View air = findViewById(R.id.gs4_btn_air);
        View set = findViewById(R.id.gs4_btn_setting);
        View energy = findViewById(R.id.gs3_btn_energy_flow);
        setSelfClick(air, this);
        setSelfClick(set, this);
        setSelfClick(energy, this);
        this.Energy_View = findViewById(R.id.gs3_btn_energy_view);
        if (DataCanbus.DATA[1000] == 196773) {
            setViewVisible(this.Energy_View, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        Class<?> cls = null;
        switch (id) {
            case R.id.gs4_btn_air /* 2131433072 */:
                cls = GS3AirControlAct.class;
                break;
            case R.id.gs4_btn_setting /* 2131433073 */:
                cls = GS3CarSettingsAct.class;
                break;
            case R.id.gs3_btn_energy_flow /* 2131433220 */:
                cls = GS3EnergyFlowAct.class;
                break;
        }
        if (cls != null) {
            try {
                Intent intent = new Intent(this, cls);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
