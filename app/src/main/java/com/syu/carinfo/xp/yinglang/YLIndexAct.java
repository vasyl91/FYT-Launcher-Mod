package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.klc.RzcKlcOnstatWifiAct;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLIndexAct extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_index);
        init();
        switch (DataCanbus.DATA[1000]) {
            case 263:
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
                for (int i = 57; i <= 86; i++) {
                    DataCanbus.DATA[i] = 1;
                }
                DataCanbus.DATA[123] = 1;
                break;
            case 309:
                for (int i2 = 57; i2 <= 86; i2++) {
                    DataCanbus.DATA[i2] = 1;
                }
                DataCanbus.DATA[123] = 1;
                break;
            case 364:
            case FinalCanbus.CAR_RZC_XP1_16_18MaiRuiBaoXL /* 65900 */:
            case FinalCanbus.CAR_RZC_XP1_19MaiRuiBaoXL /* 131436 */:
                for (int i3 = 57; i3 <= 86; i3++) {
                    DataCanbus.DATA[i3] = 1;
                }
                DataCanbus.DATA[123] = 1;
                break;
            case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
            case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
            case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
            case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
            case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
                for (int i4 = 57; i4 <= 86; i4++) {
                    DataCanbus.DATA[i4] = 1;
                }
                DataCanbus.DATA[123] = 1;
                break;
        }
    }

    private void init() {
        ((CheckedTextView) findViewById(R.id.xp_yl_car_settings_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_air_message_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_onstar_set_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_air_control_set_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_klc_onstar_wifi_check)).setOnClickListener(this);
        if (findViewById(R.id.rzc_klc_carinfo_check) != null) {
            findViewById(R.id.rzc_klc_carinfo_check).setOnClickListener(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (LauncherApplication.getConfiguration() == 1 || DataCanbus.DATA[1000] == 393241 || DataCanbus.DATA[1000] == 2424857 || DataCanbus.DATA[1000] == 2359321) {
            findViewById(R.id.xp_yl_air_control_view).setVisibility(8);
        } else {
            findViewById(R.id.xp_yl_air_control_view).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            findViewById(R.id.klc_onstarwifi_view).setVisibility(0);
        } else {
            findViewById(R.id.klc_onstarwifi_view).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 2359321 && findViewById(R.id.xp_yl_onstar_view) != null) {
            findViewById(R.id.xp_yl_onstar_view).setVisibility(8);
        }
        if (findViewById(R.id.klc_carinfo_view) != null) {
            if (DataCanbus.DATA[1000] == 359 || DataCanbus.DATA[1000] == 196967 || DataCanbus.DATA[1000] == 262503 || DataCanbus.DATA[1000] == 65895 || DataCanbus.DATA[1000] == 131431) {
                findViewById(R.id.klc_carinfo_view).setVisibility(0);
            } else {
                findViewById(R.id.klc_carinfo_view).setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intent intent;
        Intent intent2;
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_car_settings_check /* 2131433495 */:
                try {
                    if (DataCanbus.DATA[1000] == 379 || DataCanbus.DATA[1000] == 2294139 || DataCanbus.DATA[1000] == 2424857) {
                        intent2 = new Intent(this, (Class<?>) YLCarSettingsAct_BNR.class);
                    } else {
                        intent2 = new Intent(this, (Class<?>) YLCarSettingsAct.class);
                    }
                    startActivity(intent2);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.xp_yl_air_message_check /* 2131433496 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) YLAirMessageAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.xp_yl_onstar_set_check /* 2131433498 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) YLOnStarAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.xp_yl_air_control_set_check /* 2131433500 */:
                try {
                    if (DataCanbus.DATA[1000] == 359 || DataCanbus.DATA[1000] == 65895 || DataCanbus.DATA[1000] == 262503 || DataCanbus.DATA[1000] == 196967 || DataCanbus.DATA[1000] == 131431 || DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
                        intent = new Intent(this, (Class<?>) XpMrbAirControlAct.class);
                    } else if (DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 393479 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 524551) {
                        intent = new Intent(this, (Class<?>) KlcGl8_263_AirControlAct.class);
                    } else if (DataCanbus.DATA[1000] == 379) {
                        intent = new Intent(this, (Class<?>) YLAirControlAct_BNR.class);
                    } else {
                        intent = new Intent(this, (Class<?>) YLAirControlAct.class);
                    }
                    startActivity(intent);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.rzc_klc_onstar_wifi_check /* 2131433502 */:
                try {
                    Intent intent5 = new Intent();
                    intent5.setClass(this, RzcKlcOnstatWifiAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.rzc_klc_carinfo_check /* 2131433504 */:
                try {
                    Intent intent6 = new Intent();
                    intent6.setClass(this, XpMrb_CarInfo.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
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
