package com.syu.carinfo.klc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcCarSettingsAct extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_car_set);
        init();
    }

    private void init() {
        findViewById(R.id.klc_btn_Crash_check).setOnClickListener(this);
        findViewById(R.id.klc_btn_lock_check).setOnClickListener(this);
        findViewById(R.id.klc_btn_Remote_setting_check).setOnClickListener(this);
        findViewById(R.id.klc_btn_light_set_check).setOnClickListener(this);
        findViewById(R.id.klc_btn_Instrument_set_check).setOnClickListener(this);
        findViewById(R.id.klc_btn_sport_mode_check).setOnClickListener(this);
        findViewById(R.id.klc_btn_default_set_check).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 254) {
            findViewById(R.id.wc_yl_yibiao).setVisibility(8);
            findViewById(R.id.wc_yl_sport_mode).setVisibility(8);
        } else {
            findViewById(R.id.wc_yl_yibiao).setVisibility(0);
            findViewById(R.id.wc_yl_sport_mode).setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_Crash_check /* 2131431858 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) KlcCrashSetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.klc_btn_lock_check /* 2131431859 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) KlcLockAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.klc_btn_Remote_setting_check /* 2131431860 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) KlcRemoteControlAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.klc_btn_light_set_check /* 2131431861 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) KlcLightAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.klc_btn_Instrument_set_check /* 2131431863 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) KlcMeterAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.klc_btn_sport_mode_check /* 2131431865 */:
                try {
                    Intent intent6 = new Intent(this, (Class<?>) KlcSportModeAct.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.klc_btn_default_set_check /* 2131431867 */:
                dialog();
                break;
        }
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.klc.KlcCarSettingsAct.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.klc.KlcCarSettingsAct.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(15);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.klc.KlcCarSettingsAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
