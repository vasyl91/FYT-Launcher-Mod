package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.rzc.klc.RzcKlcOnstatWifiAct;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class YLIndexAct extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_index);
        init();
        switch (DataCanbus.DATA[1000]) {
            case 263:
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
                for (int i = 154; i <= 183; i++) {
                    DataCanbus.DATA[i] = 1;
                }
                DataCanbus.DATA[186] = 1;
                break;
            case 309:
                for (int i2 = 154; i2 <= 183; i2++) {
                    DataCanbus.DATA[i2] = 1;
                }
                DataCanbus.DATA[186] = 1;
                break;
            case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
            case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
            case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
            case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
            case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
                for (int i3 = 154; i3 <= 183; i3++) {
                    DataCanbus.DATA[i3] = 1;
                }
                DataCanbus.DATA[186] = 1;
                break;
            case FinalCanbus.CAR_RZC_XP1_MaiRuiBao16 /* 6422589 */:
            case FinalCanbus.CAR_RZC_XP1_16_18MaiRuiBaoXL /* 6488125 */:
            case FinalCanbus.CAR_RZC_XP1_19MaiRuiBaoXL /* 6553661 */:
                for (int i4 = 154; i4 <= 183; i4++) {
                    DataCanbus.DATA[i4] = 1;
                }
                DataCanbus.DATA[186] = 1;
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

    @Override
    protected void onResume() {
        super.onResume();
        if (LauncherApplication.getConfiguration() == 1 || DataCanbus.DATA[1000] == 393241 || DataCanbus.DATA[1000] == 2424857 || DataCanbus.DATA[1000] == 2687001 || DataCanbus.DATA[1000] == 2359321) {
            findViewById(R.id.xp_yl_air_control_view).setVisibility(8);
        } else {
            findViewById(R.id.xp_yl_air_control_view).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
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

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Intent intent2;
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_car_settings_check /* 2131433409 */:
                try {
                    if (DataCanbus.DATA[1000] == 379 || DataCanbus.DATA[1000] == 2294139 || DataCanbus.DATA[1000] == 2424857 || DataCanbus.DATA[1000] == 2687001) {
                        intent = new Intent(this, (Class<?>) YLCarSettingsAct_BNR.class);
                    } else {
                        intent = new Intent(this, (Class<?>) YLCarSettingsAct.class);
                    }
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.xp_yl_air_message_check /* 2131433410 */:
                try {
                    startActivity(new Intent(this, (Class<?>) YLAirMessageAct.class));
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.xp_yl_onstar_set_check /* 2131433412 */:
                try {
                    startActivity(new Intent(this, (Class<?>) YLOnStarAct.class));
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.xp_yl_air_control_set_check /* 2131433414 */:
                try {
                    if (DataCanbus.DATA[1000] == 359 || DataCanbus.DATA[1000] == 65895 || DataCanbus.DATA[1000] == 262503 || DataCanbus.DATA[1000] == 196967 || DataCanbus.DATA[1000] == 131431 || DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
                        intent2 = new Intent(this, (Class<?>) XpMrbAirControlAct.class);
                    } else if (DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 393479 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 524551) {
                        intent2 = new Intent(this, (Class<?>) KlcGl8_263_AirControlAct.class);
                    } else if (DataCanbus.DATA[1000] == 379) {
                        intent2 = new Intent(this, (Class<?>) YLAirControlAct_BNR.class);
                    } else {
                        intent2 = new Intent(this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                    }
                    startActivity(intent2);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.rzc_klc_onstar_wifi_check /* 2131433416 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, RzcKlcOnstatWifiAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.rzc_klc_carinfo_check /* 2131433418 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, XpMrb_CarInfo.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
