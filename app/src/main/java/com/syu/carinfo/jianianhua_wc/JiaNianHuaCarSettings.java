package com.syu.carinfo.jianianhua_wc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JiaNianHuaCarSettings extends BaseActivity {
    public static final int FRESH_TEXTVIEW_STATUS = 100;
    SharedPreferences.Editor editor;
    private SharedPreferences sp;
    public int mLight = 0;
    public int mUnit = 0;
    public int mInfoState = 0;
    public int mWainingState = 0;
    public int mTurnLightState = 0;
    public int mDVDState = 0;
    public int mNaviState = 0;
    Handler mHandler = new Handler() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    if (JiaNianHuaCarSettings.this.mLight == 0) {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_environment_light_switch)).setChecked(false);
                    } else {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_environment_light_switch)).setChecked(true);
                    }
                    if (JiaNianHuaCarSettings.this.mUnit == 0) {
                        ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_unit_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show__metric_unit_0));
                    } else {
                        ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_unit_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show__metric_unit_1));
                    }
                    if (JiaNianHuaCarSettings.this.mInfoState == 0) {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_information_point_state)).setChecked(false);
                    } else {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_information_point_state)).setChecked(true);
                    }
                    if (JiaNianHuaCarSettings.this.mWainingState == 0) {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_warning_point_state)).setChecked(false);
                    } else {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_warning_point_state)).setChecked(true);
                    }
                    if (JiaNianHuaCarSettings.this.mTurnLightState == 0) {
                        ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_turnlight_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show_turnlights_point_0));
                    } else {
                        ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_turnlight_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show_turnlights_point_1));
                    }
                    if (JiaNianHuaCarSettings.this.mDVDState == 0) {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_dvd_state)).setChecked(false);
                    } else {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_dvd_state)).setChecked(true);
                    }
                    if (JiaNianHuaCarSettings.this.mNaviState == 0) {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_navi_root_state)).setChecked(false);
                        break;
                    } else {
                        ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_navi_root_state)).setChecked(true);
                        break;
                    }
            }
        }
    };

    public void getShareData() {
        this.mLight = this.sp.getInt("light", 0);
        this.mUnit = this.sp.getInt("unit", 0);
        this.mInfoState = this.sp.getInt("info", 0);
        this.mWainingState = this.sp.getInt("waining", 0);
        this.mTurnLightState = this.sp.getInt("turnlight", 0);
        this.mDVDState = this.sp.getInt("dvd", 0);
        this.mNaviState = this.sp.getInt("navi", 0);
        this.mHandler.sendEmptyMessage(100);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jianianhua_settings);
        this.sp = getSharedPreferences("jianianhua", 0);
        this.editor = this.sp.edit();
        ((CheckedTextView) findViewById(R.id.jia_btn_environment_light_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                JiaNianHuaCarSettings.this.mLight = JiaNianHuaCarSettings.this.sp.getInt("light", 0);
                ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_environment_light_switch)).toggle();
                if (JiaNianHuaCarSettings.this.mLight == 0) {
                    JiaNianHuaCarSettings.this.editor.putInt("light", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    JiaNianHuaCarSettings.this.editor.putInt("light", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.jnh_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JiaNianHuaCarSettings.this.mUnit = JiaNianHuaCarSettings.this.sp.getInt("unit", 0);
                if (JiaNianHuaCarSettings.this.mUnit == 0) {
                    ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_unit_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show__metric_unit_1));
                    JiaNianHuaCarSettings.this.editor.putInt("unit", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.jnh_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JiaNianHuaCarSettings.this.mUnit = JiaNianHuaCarSettings.this.sp.getInt("unit", 0);
                if (JiaNianHuaCarSettings.this.mUnit == 1) {
                    ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_unit_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show__metric_unit_0));
                    JiaNianHuaCarSettings.this.editor.putInt("unit", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.jia_btn_information_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                JiaNianHuaCarSettings.this.mInfoState = JiaNianHuaCarSettings.this.sp.getInt("info", 0);
                ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_information_point_state)).toggle();
                if (JiaNianHuaCarSettings.this.mInfoState == 0) {
                    JiaNianHuaCarSettings.this.editor.putInt("info", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    JiaNianHuaCarSettings.this.editor.putInt("info", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.jia_btn_warning_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                JiaNianHuaCarSettings.this.mWainingState = JiaNianHuaCarSettings.this.sp.getInt("waining", 0);
                ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_warning_point_state)).toggle();
                if (JiaNianHuaCarSettings.this.mWainingState == 0) {
                    JiaNianHuaCarSettings.this.editor.putInt("waining", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    JiaNianHuaCarSettings.this.editor.putInt("waining", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.jnh_turnlight_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JiaNianHuaCarSettings.this.mTurnLightState = JiaNianHuaCarSettings.this.sp.getInt("turnlight", 0);
                if (JiaNianHuaCarSettings.this.mTurnLightState == 0) {
                    ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_turnlight_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show_turnlights_point_1));
                    JiaNianHuaCarSettings.this.editor.putInt("turnlight", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.jnh_turnlight_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JiaNianHuaCarSettings.this.mTurnLightState = JiaNianHuaCarSettings.this.sp.getInt("turnlight", 0);
                if (JiaNianHuaCarSettings.this.mTurnLightState == 1) {
                    ((TextView) JiaNianHuaCarSettings.this.findViewById(R.id.jnh_turnlight_set_show)).setText(JiaNianHuaCarSettings.this.getResources().getString(R.string.wc_jianianhua_show_turnlights_point_0));
                    JiaNianHuaCarSettings.this.editor.putInt("turnlight", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.jia_btn_dvd_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.9
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_dvd_state)).toggle();
                JiaNianHuaCarSettings.this.mDVDState = JiaNianHuaCarSettings.this.sp.getInt("dvd", 0);
                if (JiaNianHuaCarSettings.this.mDVDState == 0) {
                    JiaNianHuaCarSettings.this.editor.putInt("dvd", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    JiaNianHuaCarSettings.this.editor.putInt("dvd", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.jia_btn_navi_root_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.jianianhua_wc.JiaNianHuaCarSettings.10
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                JiaNianHuaCarSettings.this.mNaviState = JiaNianHuaCarSettings.this.sp.getInt("navi", 0);
                ((CheckedTextView) JiaNianHuaCarSettings.this.findViewById(R.id.jia_btn_navi_root_state)).toggle();
                if (JiaNianHuaCarSettings.this.mNaviState == 0) {
                    JiaNianHuaCarSettings.this.editor.putInt("navi", 1);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    JiaNianHuaCarSettings.this.editor.putInt("navi", 0);
                    JiaNianHuaCarSettings.this.editor.commit();
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        getShareData();
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }
}
