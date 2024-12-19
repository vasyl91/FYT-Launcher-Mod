package com.syu.carinfo.rzc.mingjueruiteng;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Act17RuiTengCarSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                case 29:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                case 41:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_driving_sport);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.rzc_klc_nomal);
                            break;
                    }
                case 42:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 43:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 48:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)) != null) {
                        if (value == 1) {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)).setTextColor(-7829368);
                            break;
                        } else {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)).setTextColor(-16777216);
                            break;
                        }
                    }
                    break;
                case 50:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 51:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.lingdu_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.lingdu_air_con_profile_2);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.lingdu_air_con_profile_0);
                            break;
                    }
                case 52:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_273_set_dual1);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_273_set_dual2);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_273_set_dual0);
                            break;
                    }
                case 53:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 54:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 55:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                    break;
                case 59:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext13), value != 0);
                    break;
                case 60:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 61:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 62:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_speed_alarm);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_intelligent_speed_limit);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_manual_speed_limit);
                            break;
                    }
                case 63:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext11), value != 0);
                    break;
                case 64:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_low);
                            break;
                    }
                case 65:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_right_camera_open);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                    }
                case 66:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext12), value != 0);
                    break;
                case 67:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
                            break;
                    }
                case 68:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_low);
                            break;
                    }
                case 69:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 70:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                            break;
                    }
                case 71:
                    if (DataCanbus.DATA[1000] == 1507601 || DataCanbus.DATA[1000] == 1573137) {
                        switch (value) {
                            case 1:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_open);
                                break;
                            case 2:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 3:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 4:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("90S");
                                break;
                            default:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    } else {
                        switch (value) {
                            case 1:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 2:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("90S");
                                break;
                            default:
                                ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                        }
                    }
                case 72:
                    switch (value) {
                        case 0:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                            break;
                        case 10:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_boyue_str12);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                case 75:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext16), value != 0);
                    break;
                case 76:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_395_static_state);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_395_dynamic_state);
                            break;
                        case 3:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_395_static_and_dynamic);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                            break;
                    }
                case 77:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext17), value != 0);
                    break;
                case 78:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.distance_far);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.distance_close);
                            break;
                    }
                case 79:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext19), value != 0);
                    break;
                case 80:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext18), value != 0);
                    break;
                case 81:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext20), value != 0);
                    break;
                case 82:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext21), value != 0);
                    break;
                case 83:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext22), value != 0);
                    break;
                case 84:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext23), value != 0);
                    break;
                case 85:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext24), value != 0);
                    break;
                case 86:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("60S");
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("90S");
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("30S");
                            break;
                    }
                case 87:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext25), value != 0);
                    break;
                case 88:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.str_mode1);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.str_mode2);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.alarm);
                            break;
                    }
                case 89:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_low);
                            break;
                    }
                case 90:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext26), value != 0);
                    break;
                case 91:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
                case 105:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext27), value != 0);
                    break;
                case 106:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text22)).setText(String.valueOf(value) + "Km/H");
                    break;
                case 107:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext28), value != 0);
                    break;
                case 108:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.driver_system_sports);
                            break;
                        case 3:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_252_sound_selection5);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_driving_eco);
                            break;
                    }
                case 109:
                    switch ((value >> 6) & 3) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.driver_system_sports);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.str_driving_eco);
                            break;
                    }
                    switch ((value >> 4) & 3) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.driver_system_sports);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_light_state);
                            break;
                    }
                    switch ((value >> 3) & 1) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text26)).setText(R.string.wc_golf_normal);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text26)).setText(R.string.str_driving_eco);
                            break;
                    }
                case 123:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext30), value != 0);
                    break;
                case 128:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.off);
                            break;
                    }
                case 129:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text28)).setText(new StringBuilder().append(value).toString());
                    break;
                case 130:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext29), value != 0);
                    break;
                case 131:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_sports);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_standard);
                            break;
                    }
                case 140:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext31), value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzc_17ruiteng_car_set);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext29)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext30)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext31)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus23)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus26)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus26)).setOnClickListener(this);
    }

    public void initview() {
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_text_view7).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_MingjueZS /* 65809 */:
            case FinalCanbus.CAR_RZC_XP1_Mingjue_17RuiTeng /* 196881 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX3 /* 327953 */:
            case FinalCanbus.CAR_BNR_Mingjue_GS /* 590097 */:
            case FinalCanbus.CAR_BNR_Mingjue_17GS /* 655633 */:
            case FinalCanbus.CAR_BNR_Mingjue_ZS /* 721169 */:
            case FinalCanbus.CAR_BNR_Mingjue_17ZS /* 786705 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_RongWei_EI5_L /* 393489 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_EI5_M /* 459025 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19MingjueEZS /* 1245457 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        int value12;
        int value13;
        int value14;
        int value15;
        int value16;
        int value17;
        int value18;
        int value19;
        int value20;
        int value21;
        int value22;
        int value23;
        int value24;
        int value25;
        int value26;
        int value27;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value28 = DataCanbus.DATA[76];
                if (value28 == 0) {
                    setCar360Info(15);
                    break;
                } else if (value28 == 1) {
                    setCar360Info(12);
                    break;
                } else if (value28 == 2) {
                    setCar360Info(13);
                    break;
                } else if (value28 == 3) {
                    setCar360Info(14);
                    break;
                }
            case R.id.btn_plus13 /* 2131427470 */:
                int value29 = DataCanbus.DATA[76];
                if (value29 == 0) {
                    setCar360Info(13);
                    break;
                } else if (value29 == 1) {
                    setCar360Info(14);
                    break;
                } else if (value29 == 2) {
                    setCar360Info(15);
                    break;
                } else if (value29 == 3) {
                    setCar360Info(12);
                    break;
                }
            case R.id.btn_minus14 /* 2131427471 */:
                int value30 = DataCanbus.DATA[78] - 1;
                if (value30 < 0) {
                    value30 = 1;
                }
                setCarInfo(6, 10, value30);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value31 = DataCanbus.DATA[78] + 1;
                if (value31 > 1) {
                    value31 = 0;
                }
                setCarInfo(6, 10, value31);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value32 = DataCanbus.DATA[86] - 1;
                if (value32 < 0) {
                    value32 = 2;
                }
                setCarInfo(2, 4, value32);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value33 = DataCanbus.DATA[86] + 1;
                if (value33 > 2) {
                    value33 = 0;
                }
                setCarInfo(2, 4, value33);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[43] == 0) {
                    value27 = 1;
                } else {
                    value27 = 0;
                }
                setCarInfo(3, 1, value27);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                if (DataCanbus.DATA[1000] == 1507601 || DataCanbus.DATA[1000] == 1573137) {
                    int value34 = DataCanbus.DATA[71] - 1;
                    if (value34 < 0) {
                        value34 = 0;
                    }
                    setCarInfo(3, 1, value34);
                    break;
                } else {
                    int value35 = (DataCanbus.DATA[71] + 2) - 1;
                    if (value35 < 2) {
                        value35 = 2;
                    }
                    setCarInfo(3, 1, value35);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int value36 = DataCanbus.DATA[71] + 2;
                if (DataCanbus.DATA[1000] == 1507601 || DataCanbus.DATA[1000] == 1573137) {
                    value36 = DataCanbus.DATA[71];
                }
                int value37 = value36 + 1;
                if (value37 > 4) {
                    value37 = 4;
                }
                setCarInfo(3, 1, value37);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value38 = (DataCanbus.DATA[70] + 2) - 1;
                if (value38 < 2) {
                    value38 = 2;
                }
                setCarInfo(3, 4, value38);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value39 = DataCanbus.DATA[70] + 2 + 1;
                if (value39 > 4) {
                    value39 = 4;
                }
                setCarInfo(3, 4, value39);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value40 = DataCanbus.DATA[51] - 1;
                if (value40 < 0) {
                    value40 = 0;
                }
                setCarInfo(5, 2, value40);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value41 = DataCanbus.DATA[51] + 1;
                if (value41 > 2) {
                    value41 = 2;
                }
                setCarInfo(5, 2, value41);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value42 = DataCanbus.DATA[52] - 1;
                if (value42 < 0) {
                    value42 = 0;
                }
                setCarInfo(5, 3, value42);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value43 = DataCanbus.DATA[52] + 1;
                if (value43 > 2) {
                    value43 = 2;
                }
                setCarInfo(5, 3, value43);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value44 = DataCanbus.DATA[62] - 1;
                if (value44 < 0) {
                    value44 = 0;
                }
                setCarInfo(6, 3, value44);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value45 = DataCanbus.DATA[62] + 1;
                if (value45 > 2) {
                    value45 = 2;
                }
                setCarInfo(6, 3, value45);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value46 = DataCanbus.DATA[64] - 1;
                if (value46 < 0) {
                    value46 = 0;
                }
                setCarInfo(6, 5, value46);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value47 = DataCanbus.DATA[64] + 1;
                if (value47 > 2) {
                    value47 = 2;
                }
                setCarInfo(6, 5, value47);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value48 = DataCanbus.DATA[65] - 1;
                if (value48 < 0) {
                    value48 = 0;
                }
                setCarInfo(6, 6, value48);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value49 = DataCanbus.DATA[65] + 1;
                if (value49 > 1) {
                    value49 = 1;
                }
                setCarInfo(6, 6, value49);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value50 = DataCanbus.DATA[67] - 1;
                if (value50 < 0) {
                    value50 = 0;
                }
                setCarInfo(6, 8, value50);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value51 = DataCanbus.DATA[67] + 1;
                if (value51 > 1) {
                    value51 = 1;
                }
                setCarInfo(6, 8, value51);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value52 = DataCanbus.DATA[68] - 1;
                if (value52 < 0) {
                    value52 = 0;
                }
                setCarInfo(6, 9, value52);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value53 = DataCanbus.DATA[68] + 1;
                if (value53 > 2) {
                    value53 = 2;
                }
                setCarInfo(6, 9, value53);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value54 = DataCanbus.DATA[41] - 1;
                if (value54 < 0) {
                    value54 = 0;
                }
                setCarInfo(3, 3, value54);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value55 = DataCanbus.DATA[41] + 1;
                if (value55 > 2) {
                    value55 = 2;
                }
                setCarInfo(3, 3, value55);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value56 = DataCanbus.DATA[72] - 1;
                if (value56 < 0) {
                    value56 = 0;
                }
                setCarInfo(9, 1, value56);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value57 = DataCanbus.DATA[72] + 1;
                if (value57 > 10) {
                    value57 = 10;
                }
                setCarInfo(9, 1, value57);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value58 = DataCanbus.DATA[55] - 1;
                if (value58 < 1) {
                    value58 = 1;
                }
                setCarInfo(7, 1, value58);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value59 = DataCanbus.DATA[55] + 1;
                if (value59 > 10) {
                    value59 = 10;
                }
                setCarInfo(7, 1, value59);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[69] == 0) {
                    value26 = 1;
                } else {
                    value26 = 0;
                }
                setCarInfo(3, 4, value26);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[42] == 0) {
                    value25 = 1;
                } else {
                    value25 = 0;
                }
                setCarInfo(3, 2, value25);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[28] == 0) {
                    value24 = 1;
                } else {
                    value24 = 0;
                }
                setCarInfo(1, 3, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[29] == 0) {
                    value23 = 1;
                } else {
                    value23 = 0;
                }
                setCarInfo(1, 4, value23);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                if (DataCanbus.DATA[50] == 0) {
                    value22 = 1;
                } else {
                    value22 = 0;
                }
                setCarInfo(5, 1, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                if (DataCanbus.DATA[53] == 0) {
                    value21 = 1;
                } else {
                    value21 = 0;
                }
                setCarInfo(4, 2, value21);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                if (DataCanbus.DATA[60] == 0) {
                    value20 = 1;
                } else {
                    value20 = 0;
                }
                setCarInfo(4, 3, value20);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                if (DataCanbus.DATA[54] == 0) {
                    value19 = 1;
                } else {
                    value19 = 0;
                }
                setCarInfo(6, 1, value19);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                if (DataCanbus.DATA[61] == 0) {
                    value18 = 1;
                } else {
                    value18 = 0;
                }
                setCarInfo(6, 2, value18);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                if (DataCanbus.DATA[63] == 0) {
                    value17 = 1;
                } else {
                    value17 = 0;
                }
                setCarInfo(6, 4, value17);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                if (DataCanbus.DATA[66] == 0) {
                    value16 = 1;
                } else {
                    value16 = 0;
                }
                setCarInfo(6, 7, value16);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                if (DataCanbus.DATA[59] == 0) {
                    value15 = 1;
                } else {
                    value15 = 0;
                }
                setCarInfo(8, 1, value15);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                if (DataCanbus.DATA[48] == 0) {
                    creatShowDialog();
                    break;
                }
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                setCarInfo(4, 1, 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                if (DataCanbus.DATA[75] == 0) {
                    setCar360Info(17);
                    break;
                } else {
                    setCar360Info(16);
                    break;
                }
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                if (DataCanbus.DATA[77] == 0) {
                    value14 = 1;
                } else {
                    value14 = 0;
                }
                setCarInfo(4, 4, value14);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                if (DataCanbus.DATA[80] == 0) {
                    value13 = 1;
                } else {
                    value13 = 0;
                }
                setCarInfo(1, 1, value13);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                if (DataCanbus.DATA[79] == 0) {
                    value12 = 1;
                } else {
                    value12 = 0;
                }
                setCarInfo(6, 11, value12);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                if (DataCanbus.DATA[81] == 0) {
                    value11 = 1;
                } else {
                    value11 = 0;
                }
                setCarInfo(6, 12, value11);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                if (DataCanbus.DATA[82] == 0) {
                    value10 = 1;
                } else {
                    value10 = 0;
                }
                setCarInfo(6, 13, value10);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                if (DataCanbus.DATA[83] == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                setCarInfo(6, 14, value9);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                if (DataCanbus.DATA[84] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                setCarInfo(6, 15, value8);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                if (DataCanbus.DATA[85] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                setCarInfo(6, 16, value7);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                if (DataCanbus.DATA[87] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(6, 17, value6);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                if (DataCanbus.DATA[90] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(6, 20, value5);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                if (DataCanbus.DATA[105] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(6, 21, value4);
                break;
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                if (DataCanbus.DATA[130] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(8, 2, value2);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value60 = DataCanbus.DATA[91];
                if (value60 > 0) {
                    value60--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value60}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value61 = DataCanbus.DATA[91];
                if (value61 < 7) {
                    value61++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value61}, null, null);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value62 = DataCanbus.DATA[106] - 5;
                if (value62 < 30) {
                    value62 = 30;
                }
                setCarInfo(6, 22, value62);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value63 = DataCanbus.DATA[106] + 5;
                if (value63 > 240) {
                    value63 = 240;
                }
                if (value63 < 30) {
                    value63 = 30;
                }
                setCarInfo(6, 22, value63);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value64 = DataCanbus.DATA[108] + 1;
                int value1 = (DataCanbus.DATA[109] >> 6) & 3;
                int data = DataCanbus.DATA[109] & 63;
                if (value64 == 4) {
                    int value110 = value1 - 1;
                    if (value110 < 0) {
                        value110 = 2;
                    }
                    setCarInfo(11, 4, data | ((value110 << 6) & 192));
                    break;
                }
            case R.id.btn_plus21 /* 2131427883 */:
                int value65 = DataCanbus.DATA[108] + 1;
                int value111 = (DataCanbus.DATA[109] >> 6) & 3;
                int data2 = DataCanbus.DATA[109] & 63;
                if (value65 == 4) {
                    int value112 = value111 + 1;
                    if (value112 > 2) {
                        value112 = 0;
                    }
                    setCarInfo(11, 4, data2 | ((value112 << 6) & 192));
                    break;
                }
            case R.id.btn_minus22 /* 2131427884 */:
                int value66 = DataCanbus.DATA[108] + 1;
                int value113 = (DataCanbus.DATA[109] >> 4) & 3;
                int data3 = DataCanbus.DATA[109] & 207;
                if (value66 == 4) {
                    int value114 = value113 - 1;
                    if (value114 < 0) {
                        value114 = 2;
                    }
                    setCarInfo(11, 4, data3 | ((value114 << 4) & 48));
                    break;
                }
            case R.id.btn_plus22 /* 2131427885 */:
                int value67 = DataCanbus.DATA[108] + 1;
                int value115 = (DataCanbus.DATA[109] >> 4) & 3;
                int data4 = DataCanbus.DATA[109] & 207;
                if (value67 == 4) {
                    int value116 = value115 + 1;
                    if (value116 > 2) {
                        value116 = 0;
                    }
                    setCarInfo(11, 4, data4 | ((value116 << 4) & 48));
                    break;
                }
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                setCarAirInfo(28, 1);
                this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Act17RuiTengCarSet.this.setCarAirInfo(28, 0);
                    }
                }, 200L);
                break;
            case R.id.ctv_checkedtext31 /* 2131427887 */:
                if (DataCanbus.DATA[140] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(255, value, 0);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value68 = DataCanbus.DATA[88] - 1;
                if (value68 < 0) {
                    value68 = 2;
                }
                setCarInfo(6, 18, value68);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value69 = DataCanbus.DATA[88] + 1;
                if (value69 > 2) {
                    value69 = 0;
                }
                setCarInfo(6, 18, value69);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value70 = DataCanbus.DATA[89] - 1;
                if (value70 < 0) {
                    value70 = 2;
                }
                setCarInfo(6, 19, value70);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value71 = DataCanbus.DATA[89] + 1;
                if (value71 > 2) {
                    value71 = 0;
                }
                setCarInfo(6, 19, value71);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                if (DataCanbus.DATA[107] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(9, 6, value3);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value72 = DataCanbus.DATA[108] + 1;
                int value117 = DataCanbus.DATA[109];
                int value73 = value72 - 1;
                if (value73 < 1) {
                    value73 = 4;
                }
                if (value73 == 4) {
                    setCarInfo(11, value73, value117);
                    break;
                } else {
                    setCarInfo(11, value73, 0);
                    break;
                }
            case R.id.btn_plus20 /* 2131427894 */:
                int value74 = DataCanbus.DATA[108] + 1;
                int value118 = DataCanbus.DATA[109];
                int value75 = value74 + 1;
                if (value75 > 4) {
                    value75 = 1;
                }
                if (value75 == 4) {
                    setCarInfo(11, value75, value118);
                    break;
                } else {
                    setCarInfo(11, value75, 0);
                    break;
                }
            case R.id.btn_plus25 /* 2131427923 */:
                int value76 = DataCanbus.DATA[129] + 2;
                if (value76 > 152) {
                    value76 = 152;
                }
                setCarInfo(9, 7, value76);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value77 = DataCanbus.DATA[128] + 1;
                if (value77 > 2) {
                    value77 = 0;
                }
                setCarInfo(5, 4, value77);
                break;
            case R.id.btn_plus26 /* 2131427925 */:
                int value78 = DataCanbus.DATA[131] + 1;
                if (value78 > 1) {
                    value78 = 0;
                }
                setCarInfo(4, 5, value78);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value79 = DataCanbus.DATA[108] + 1;
                int value119 = (DataCanbus.DATA[109] >> 3) & 1;
                int data5 = DataCanbus.DATA[109] & 247;
                if (value79 == 4) {
                    int value120 = value119 + 1;
                    if (value120 > 1) {
                        value120 = 0;
                    }
                    setCarInfo(11, 4, data5 | ((value120 << 3) & 8));
                    break;
                }
            case R.id.btn_minus25 /* 2131428315 */:
                int value80 = DataCanbus.DATA[129] - 2;
                if (value80 < 0) {
                    value80 = 0;
                }
                setCarInfo(9, 7, value80);
                break;
            case R.id.btn_minus26 /* 2131428316 */:
                int value81 = DataCanbus.DATA[131] - 1;
                if (value81 < 0) {
                    value81 = 1;
                }
                setCarInfo(4, 5, value81);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value82 = DataCanbus.DATA[108] + 1;
                int value121 = (DataCanbus.DATA[109] >> 3) & 1;
                int data6 = DataCanbus.DATA[109] & 247;
                if (value82 == 4) {
                    int value122 = value121 - 1;
                    if (value122 < 0) {
                        value122 = 1;
                    }
                    setCarInfo(11, 4, data6 | ((value122 << 3) & 8));
                    break;
                }
            case R.id.btn_minus24 /* 2131428319 */:
                int value83 = DataCanbus.DATA[128] - 1;
                if (value83 < 0) {
                    value83 = 2;
                }
                setCarInfo(5, 4, value83);
                break;
        }
    }

    private void creatShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_416_reset_tire));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Act17RuiTengCarSet.this.setCarInfo(4, 1, 1);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCar360Info(int value0) {
        DataCanbus.PROXY.cmd(6, new int[]{value0}, null, null);
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1, value2}, null, null);
    }

    public void setCarAirInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(5, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        initview();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
    }
}
