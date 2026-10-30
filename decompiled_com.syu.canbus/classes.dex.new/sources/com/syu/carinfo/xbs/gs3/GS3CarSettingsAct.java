package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS3CarSettingsAct extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_289_wc_gs4_car_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        View airset = findViewById(R.id.ctv_checkedtext1);
        View seatset = findViewById(R.id.ctv_checkedtext2);
        View helpset = findViewById(R.id.ctv_checkedtext3);
        View accessoryset = findViewById(R.id.ctv_checkedtext4);
        View findViewById2 = findViewById(R.id.ctv_checkedtext5);
        setSelfClick(airset, this);
        setSelfClick(seatset, this);
        setSelfClick(helpset, this);
        setSelfClick(accessoryset, this);
        setSelfClick(findViewById2, this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{10}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3AirSetAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GS3CarAccessoryAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) GS3LightSetAct.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) GS3SeatSetAct.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) GS3HelpSetAct.class);
                    startActivity(intent5);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
