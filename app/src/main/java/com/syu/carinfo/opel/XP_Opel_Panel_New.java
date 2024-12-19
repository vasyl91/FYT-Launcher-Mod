package com.syu.carinfo.opel;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XP_Opel_Panel_New extends Activity implements View.OnTouchListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_xp_opelnew_keys);
        init();
    }

    private void init() {
        findViewById(R.id.ctv_checkedtext1).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int cmd = 0;
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                cmd = 2;
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                cmd = 6;
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                cmd = 3;
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                cmd = 4;
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                cmd = 1;
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                cmd = 5;
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                cmd = 8;
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                cmd = 7;
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                cmd = 9;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
        }
        return false;
    }
}
