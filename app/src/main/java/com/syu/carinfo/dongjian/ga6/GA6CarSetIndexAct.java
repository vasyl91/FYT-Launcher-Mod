package com.syu.carinfo.dongjian.ga6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GA6CarSetIndexAct extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_257_dongjian_ga6_index);
        init();
    }

    private void init() {
        if (DataCanbus.DATA[1000] == 257) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 131329 || DataCanbus.DATA[1000] == 65793) {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GA6AirSetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) GA6SeatSetAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) GA6HelpSetAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) GA6CarAccessoryAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) GA6LightSetAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                try {
                    Intent intent6 = new Intent(this, (Class<?>) GA6TimeFormatAct.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                try {
                    Intent intent7 = new Intent(this, (Class<?>) GA6AirSeatControlAct.class);
                    startActivity(intent7);
                    break;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
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
