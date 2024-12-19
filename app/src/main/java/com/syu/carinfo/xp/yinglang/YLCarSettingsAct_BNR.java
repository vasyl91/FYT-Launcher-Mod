package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLCarSettingsAct_BNR extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_car_set);
        init();
    }

    private void init() {
        findViewById(R.id.xp_yl_car_set_first_check).setOnClickListener(this);
        findViewById(R.id.xp_yl_car_set_Second_check).setOnClickListener(this);
        findViewById(R.id.xp_yl_car_set_basic_info_check).setOnClickListener(this);
        findViewById(R.id.xp_yl_car_set_tire_check).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 393241) {
            findViewById(R.id.glf7_view_baseinfo).setVisibility(8);
            findViewById(R.id.glf7_view_tire).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.glf7_view_tire).setVisibility(8);
        } else {
            findViewById(R.id.glf7_view_baseinfo).setVisibility(0);
            findViewById(R.id.glf7_view_tire).setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_car_set_basic_info_check /* 2131431925 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) YLBasicInfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_first_check /* 2131433491 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) YLInfoSetFirstAct_BNR.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_Second_check /* 2131433492 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) YLInfoSetSecondAct_BNR.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.xp_yl_car_set_tire_check /* 2131433494 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) YLTireAct_BNR.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
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
