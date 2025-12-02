package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class GS3IndexAct extends BaseActivity implements View.OnClickListener {
    View Energy_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_gs3_index);
        init();
    }

    @Override
    public void init() {
        View set = findViewById(R.id.gs4_btn_setting);
        View energy = findViewById(R.id.gs3_btn_energy_flow);
        setSelfClick(set, this);
        setSelfClick(energy, this);
        this.Energy_View = findViewById(R.id.gs3_btn_energy_view);
        if (DataCanbus.DATA[1000] == 196773) {
            setViewVisible(this.Energy_View, true);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Class<?> cls = null;
        switch (id) {
            case R.id.gs4_btn_setting /* 2131432972 */:
                cls = GS3CarSettingsAct.class;
                break;
            case R.id.gs3_btn_energy_flow /* 2131433142 */:
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
