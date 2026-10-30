package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLCarSettingsAct_BNR extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_car_set);
        init();
    }

    private void init() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 393241) {
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.layout_view4).setVisibility(8);
        } else {
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) YLInfoSetFirstAct_BNR.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) YLTireAct_BNR.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) YLInfoSetSecondAct_BNR.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) YLBasicInfoAct.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
