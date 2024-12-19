package com.syu.carinfo.ford;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MustangIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_mustang_indexact);
        if (7078340 == DataCanbus.DATA[1000]) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.oil_mileage);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
        } else if (11403716 == DataCanbus.DATA[1000] || 14090692 == DataCanbus.DATA[1000]) {
            ((TextView) findViewById(R.id.tv_text1)).setText("Sync");
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
        } else if (2031950 == DataCanbus.DATA[1000]) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_settings_title);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.sound_settings);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("Sync");
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
        }
        if (1900878 == DataCanbus.DATA[1000]) {
            if (LauncherApplication.getConfiguration() != 1) {
                findViewById(R.id.layout_view2).setVisibility(8);
            } else {
                findViewById(R.id.layout_view3).setVisibility(0);
            }
            findViewById(R.id.layout_view3).setVisibility(8);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_settings_title);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.sound_settings);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_psa_all_orinal_car_fuc);
        } else {
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.radio_car);
        }
        ((Button) findViewById(R.id.jeep_car_radio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.MustangIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (7078340 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZSubaruCarRadioAct.class);
                    } else if (11403716 == DataCanbus.DATA[1000] || 14090692 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZMustangCarRadioAct.class);
                    } else if (1900878 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, RZCFordNavigatorPanelAct.class);
                    } else {
                        intent.setClass(MustangIndexAct.this, MustangCarRadioAct.class);
                    }
                    MustangIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.MustangIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (7078340 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZSubaruCarCd.class);
                    } else if (11403716 == DataCanbus.DATA[1000] || 14090692 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZMustangCarCDAct.class);
                    } else {
                        intent.setClass(MustangIndexAct.this, MustangCarCDAct.class);
                    }
                    MustangIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.MustangIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (7078340 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZSubaruCarInfo.class);
                    } else if (1900878 == DataCanbus.DATA[1000] || 2031950 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, FordCarSet_RZC.class);
                    } else {
                        intent.setClass(MustangIndexAct.this, FocusSyncBtActi.class);
                    }
                    MustangIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.MustangIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (7078340 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZSubaruCarSet.class);
                    } else if (11403716 == DataCanbus.DATA[1000] || 14090692 == DataCanbus.DATA[1000]) {
                        intent.setClass(MustangIndexAct.this, LZMustangCarEQSet.class);
                    } else {
                        intent.setClass(MustangIndexAct.this, MustangCarEQSet.class);
                    }
                    MustangIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
