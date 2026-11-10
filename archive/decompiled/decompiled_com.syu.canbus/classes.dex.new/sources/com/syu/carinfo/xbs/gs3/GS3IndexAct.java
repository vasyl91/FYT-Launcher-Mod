package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS3IndexAct extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_gs3_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        View set = findViewById(R.id.ctv_checkedtext1);
        View energy = findViewById(R.id.ctv_checkedtext2);
        setSelfClick(set, this);
        setSelfClick(energy, this);
        if (DataCanbus.DATA[1000] == 196773) {
            setViewVisible(findViewById(R.id.layout_view2), true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        Class<?> cls = null;
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                cls = GS3CarSettingsAct.class;
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
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
