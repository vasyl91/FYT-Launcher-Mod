package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityHuangGuanIndex extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_429_dj_huangguan);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
        }
        if (DataCanbus.DATA[1000] == 1049005) {
            findViewById(R.id.layout_view4).setVisibility(0);
        } else {
            findViewById(R.id.layout_view4).setVisibility(8);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
            case FinalCanbus.CAR_DJ_XC_Infiniti_FX35_03_09 /* 1245613 */:
                findViewById(R.id.layout_view4).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_car_settings);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_yinglang_car_set_Second_str10);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_guandao_amp);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.app_name);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) ActivityCarRadio.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) XCLexusIndexAct.class);
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                        case FinalCanbus.CAR_DJ_XC_Infiniti_FX35_03_09 /* 1245613 */:
                            intent2 = new Intent(this, (Class<?>) ActivityOldFx35TireAct.class);
                            break;
                    }
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) XC_429_ToyotaCarInfo.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) XC_429_crown_AmpSetAct.class);
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                        case FinalCanbus.CAR_DJ_XC_Infiniti_FX35_03_09 /* 1245613 */:
                            intent4 = new Intent(this, (Class<?>) ActivityOldFx35CarSettings.class);
                            break;
                    }
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) ActivityCarCD.class);
                    startActivity(intent5);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
        }
    }
}
