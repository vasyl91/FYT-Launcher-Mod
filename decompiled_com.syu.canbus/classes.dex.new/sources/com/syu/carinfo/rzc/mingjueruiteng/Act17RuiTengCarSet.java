package com.syu.carinfo.rzc.mingjueruiteng;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Act17RuiTengCarSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 44:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
                case 100:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext32), value != 0);
                    break;
                case 101:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                    break;
                case 102:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                    break;
                case 114:
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
                    break;
                case 115:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext3), value != 15);
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        case 15:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                    break;
                case 116:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 121:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)) != null) {
                        if (value == 1) {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)).setTextColor(-7829368);
                        } else {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.rzc_ruiteng_home_light_backcar_tv)).setTextColor(-16777216);
                        }
                    }
                    break;
                case 122:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 123:
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
                    break;
                case 124:
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
                    break;
                case 125:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 126:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 127:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                    break;
                case 129:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext13), value != 0);
                    break;
                case 130:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 131:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 132:
                    switch (value) {
                        case 0:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_manual_speed_limit);
                            break;
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_speed_alarm);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_intelligent_speed_limit);
                            break;
                        case 255:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                    }
                    break;
                case 133:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext11), value != 0);
                    break;
                case 134:
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
                    break;
                case 135:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_right_camera_open);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                    }
                    break;
                case 136:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext12), value != 0);
                    break;
                case 137:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
                            break;
                    }
                    break;
                case 138:
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
                    break;
                case 139:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 140:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                        case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                        case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                            switch (value) {
                                case 0:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                    break;
                                case 1:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                    break;
                                case 2:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                    break;
                            }
                            break;
                        default:
                            switch (value) {
                                case 1:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.rzc_c4l_open);
                                    break;
                                case 2:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                    break;
                                case 3:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                    break;
                                case 4:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                    break;
                                default:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                    break;
                            }
                            break;
                    }
                    break;
                case 141:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                        case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                        case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                        case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                        case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                            switch (value) {
                                case 0:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                    break;
                                case 1:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                    break;
                                case 2:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText("90S");
                                    break;
                            }
                            break;
                        case FinalCanbus.CAR_RZC_19MingjueEZS /* 1245457 */:
                        case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                        case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
                        case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                            switch (value) {
                                case 0:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                    break;
                                case 1:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_open);
                                    break;
                            }
                            break;
                        default:
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
                            break;
                    }
                    break;
                case 142:
                    switch (value) {
                        case 0:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                            break;
                        case 10:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_boyue_str12);
                            break;
                        case 11:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText("通风");
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                    break;
                case 144:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext16), value != 0);
                    break;
                case 145:
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
                    break;
                case 146:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext17), value != 0);
                    break;
                case 147:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.distance_far);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.distance_close);
                            break;
                    }
                    break;
                case 148:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext19), value != 0);
                    break;
                case 149:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext18), value != 0);
                    break;
                case 150:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext20), value != 0);
                    break;
                case 151:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext21), value != 0);
                    break;
                case 152:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext22), value != 0);
                    break;
                case 153:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext23), value != 0);
                    break;
                case 154:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext24), value != 0);
                    break;
                case 155:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
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
                            break;
                        default:
                            switch (value) {
                                case 1:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("60S");
                                    break;
                                case 2:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("90S");
                                    break;
                                case 3:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("120S");
                                    break;
                                case 4:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("150S");
                                    break;
                                case 5:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("180S");
                                    break;
                                case 6:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("210S");
                                    break;
                                case 7:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("240S");
                                    break;
                                case 8:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("270S");
                                    break;
                                case 9:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("300S");
                                    break;
                                default:
                                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text18)).setText("30S");
                                    break;
                            }
                            break;
                    }
                    break;
                case 156:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext25), value != 0);
                    break;
                case 157:
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
                    break;
                case 158:
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
                    break;
                case 159:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext26), value != 0);
                    break;
                case 173:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext27), value != 0);
                    break;
                case 174:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text22)).setText(String.valueOf(value) + "Km/H");
                    break;
                case 175:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext28), value != 0);
                    break;
                case 176:
                    switch (value) {
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.wc_golf_normal);
                            break;
                        case 3:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.driver_system_sports);
                            break;
                        case 4:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_252_sound_selection5);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text23)).setText(R.string.str_driving_eco);
                            break;
                    }
                    break;
                case 177:
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
                    switch ((value >> 1) & 3) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text35)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text35)).setText(R.string.str_driving_sport);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text35)).setText(R.string.str_driving_eco);
                            break;
                    }
                    break;
                case 190:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext30), value != 0);
                    break;
                case 195:
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
                    break;
                case 196:
                    ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text28)).setText(new StringBuilder().append(value).toString());
                    break;
                case 197:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext29), value != 0);
                    break;
                case 198:
                    switch (value) {
                        case 1:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_sports);
                            break;
                        default:
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_standard);
                            break;
                    }
                    break;
                case 199:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext31), value != 0);
                    break;
                case 200:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text36)) != null) {
                        ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text36)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + "%");
                    }
                    break;
                case 201:
                    Act17RuiTengCarSet.this.updateLauguageSet();
                    break;
                case 202:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext33), value != 0);
                    break;
                case 203:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext34), value != 0);
                    break;
                case 204:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext35), value != 0);
                    break;
                case 205:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext36), value != 0);
                    break;
                case 206:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext37), value != 0);
                    break;
                case 207:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text30)) != null) {
                        if (value == 1) {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text30)).setText("自动开启");
                        } else {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text30)).setText("常亮");
                        }
                    }
                    break;
                case 208:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text31)) != null) {
                        if (value == 1) {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text31)).setText("自定义");
                        } else {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text31)).setText("关联驾驶模式");
                        }
                    }
                    break;
                case 209:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text32)) != null) {
                        ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text32)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 210:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text33)) != null) {
                        ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text33)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 211:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext38), value != 0);
                    break;
                case 212:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext39), value != 0);
                    break;
                case 213:
                    if (((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text34)) != null) {
                        if (value == 1) {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text34)).setText("标准");
                        } else if (value == 2) {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text34)).setText("热烈");
                        } else {
                            ((TextView) Act17RuiTengCarSet.this.findViewById(R.id.tv_text34)).setText("优雅 ");
                        }
                    }
                    break;
                case 214:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext40), value != 0);
                    break;
                case 215:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext41), value != 0);
                    break;
                case 216:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext42), value != 0);
                    break;
                case 217:
                    Act17RuiTengCarSet.this.setCheck((CheckedTextView) Act17RuiTengCarSet.this.findViewById(R.id.ctv_checkedtext43), value != 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Act17RuiTengCarSet.this.language_set = position;
                if (Act17RuiTengCarSet.this.language_set >= 0 && Act17RuiTengCarSet.this.language_set <= Act17RuiTengCarSet.this.mLauStylelist.size() && Act17RuiTengCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(4, new int[]{10, 1, Act17RuiTengCarSet.this.send_lang[Act17RuiTengCarSet.this.language_set]}, null, null);
                }
                Act17RuiTengCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[201];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{1, 2, 36};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Act17RuiTengCarSet.this.mLauStyle == null) {
                    Act17RuiTengCarSet.this.initLauStyle();
                }
                if (Act17RuiTengCarSet.this.mLauStyle != null && Act17RuiTengCarSet.this.mPopShowView != null) {
                    Act17RuiTengCarSet.this.mLauStyle.showAtLocation(Act17RuiTengCarSet.this.mPopShowView, 17, 0, 0);
                    Act17RuiTengCarSet.this.updateLauguageSet();
                }
            }
        });
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext32)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext33)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext34)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext35)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext36)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext37)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext38)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext39)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext40)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext41)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext42)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext43)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext44)).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus27)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus27)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus28)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus28)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus29)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus29)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus30)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus30)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus31)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus31)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus32)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus32)).setOnClickListener(this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                ((TextView) findViewById(R.id.layout_text_view11)).setText(R.string.str_accoff_autolock);
                return;
            default:
                ((TextView) findViewById(R.id.layout_text_view11)).setText(R.string.str_unlock);
                return;
        }
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
        findViewById(R.id.layout_view58).setVisibility(8);
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
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
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
        findViewById(R.id.layout_view61).setVisibility(8);
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
        findViewById(R.id.layout_view74).setVisibility(8);
        findViewById(R.id.layout_text_view8).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view63).setVisibility(8);
        findViewById(R.id.layout_view64).setVisibility(8);
        findViewById(R.id.layout_view65).setVisibility(8);
        findViewById(R.id.layout_view66).setVisibility(8);
        findViewById(R.id.layout_view67).setVisibility(8);
        findViewById(R.id.layout_view68).setVisibility(8);
        findViewById(R.id.layout_view69).setVisibility(8);
        findViewById(R.id.layout_view70).setVisibility(8);
        findViewById(R.id.layout_view71).setVisibility(8);
        findViewById(R.id.layout_view72).setVisibility(8);
        findViewById(R.id.layout_view73).setVisibility(8);
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
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
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
                findViewById(R.id.layout_view61).setVisibility(0);
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
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view74).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                findViewById(R.id.layout_view66).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                findViewById(R.id.layout_view68).setVisibility(0);
                findViewById(R.id.layout_view69).setVisibility(0);
                findViewById(R.id.layout_view70).setVisibility(0);
                findViewById(R.id.layout_view71).setVisibility(0);
                findViewById(R.id.layout_view72).setVisibility(0);
                findViewById(R.id.layout_view73).setVisibility(0);
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
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
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
                findViewById(R.id.layout_view61).setVisibility(0);
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
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view74).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                findViewById(R.id.layout_view66).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                findViewById(R.id.layout_view68).setVisibility(0);
                findViewById(R.id.layout_view69).setVisibility(0);
                findViewById(R.id.layout_view70).setVisibility(0);
                findViewById(R.id.layout_view71).setVisibility(0);
                findViewById(R.id.layout_view72).setVisibility(0);
                findViewById(R.id.layout_view73).setVisibility(0);
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
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
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
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
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
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
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
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
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
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                findViewById(R.id.layout_view66).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                findViewById(R.id.layout_view68).setVisibility(0);
                findViewById(R.id.layout_view69).setVisibility(0);
                findViewById(R.id.layout_view70).setVisibility(0);
                findViewById(R.id.layout_view71).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
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
        int value28;
        int value29;
        int value30;
        int value31;
        int value32;
        int value33;
        int value34;
        int value35;
        int value36;
        int value37;
        int value38;
        int value39;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value40 = DataCanbus.DATA[141] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                    case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                    case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                        if (value40 < 0) {
                            value40 = 2;
                        }
                        break;
                    case FinalCanbus.CAR_RZC_19MingjueEZS /* 1245457 */:
                    case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                    case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
                    case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                        if (value40 < 0) {
                            value40 = 1;
                        }
                        break;
                    default:
                        if (value40 < 0) {
                            value40 = 4;
                        }
                        break;
                }
                setCarInfo(3, 1, value40);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value41 = DataCanbus.DATA[141] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                    case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                    case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                        if (value41 > 2) {
                            value41 = 0;
                        }
                        break;
                    case FinalCanbus.CAR_RZC_19MingjueEZS /* 1245457 */:
                    case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                    case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
                    case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                        if (value41 > 1) {
                            value41 = 0;
                        }
                        break;
                    default:
                        if (value41 > 4) {
                            value41 = 0;
                        }
                        break;
                }
                setCarInfo(3, 1, value41);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value42 = DataCanbus.DATA[140] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                        if (value42 < 0) {
                            value42 = 2;
                        }
                        break;
                    default:
                        if (value42 < 0) {
                            value42 = 4;
                        }
                        break;
                }
                setCarInfo(3, 4, value42);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value43 = DataCanbus.DATA[140] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                    case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                        if (value43 > 2) {
                            value43 = 0;
                        }
                        break;
                    default:
                        if (value43 > 4) {
                            value43 = 0;
                        }
                        break;
                }
                setCarInfo(3, 4, value43);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value44 = DataCanbus.DATA[123] - 1;
                if (value44 < 0) {
                    value44 = 0;
                }
                setCarInfo(5, 2, value44);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value45 = DataCanbus.DATA[123] + 1;
                if (value45 > 2) {
                    value45 = 2;
                }
                setCarInfo(5, 2, value45);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value46 = DataCanbus.DATA[124] - 1;
                if (value46 < 0) {
                    value46 = 0;
                }
                setCarInfo(5, 3, value46);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value47 = DataCanbus.DATA[124] + 1;
                if (value47 > 2) {
                    value47 = 2;
                }
                setCarInfo(5, 3, value47);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value48 = DataCanbus.DATA[132] - 1;
                if (value48 < 0) {
                    value48 = 2;
                }
                setCarInfo(6, 3, value48);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value49 = DataCanbus.DATA[132] + 1;
                if (value49 > 2) {
                    value49 = 0;
                }
                setCarInfo(6, 3, value49);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value50 = DataCanbus.DATA[134] - 1;
                if (value50 < 0) {
                    value50 = 0;
                }
                setCarInfo(6, 5, value50);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value51 = DataCanbus.DATA[134] + 1;
                if (value51 > 2) {
                    value51 = 2;
                }
                setCarInfo(6, 5, value51);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value52 = DataCanbus.DATA[135] - 1;
                if (value52 < 0) {
                    value52 = 0;
                }
                setCarInfo(6, 6, value52);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value53 = DataCanbus.DATA[135] + 1;
                if (value53 > 1) {
                    value53 = 1;
                }
                setCarInfo(6, 6, value53);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value54 = DataCanbus.DATA[137] - 1;
                if (value54 < 0) {
                    value54 = 0;
                }
                setCarInfo(6, 8, value54);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value55 = DataCanbus.DATA[137] + 1;
                if (value55 > 1) {
                    value55 = 1;
                }
                setCarInfo(6, 8, value55);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value56 = DataCanbus.DATA[138] - 1;
                if (value56 < 0) {
                    value56 = 0;
                }
                setCarInfo(6, 9, value56);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value57 = DataCanbus.DATA[138] + 1;
                if (value57 > 2) {
                    value57 = 2;
                }
                setCarInfo(6, 9, value57);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value58 = DataCanbus.DATA[114] - 1;
                if (value58 < 0) {
                    value58 = 0;
                }
                setCarInfo(3, 3, value58);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value59 = DataCanbus.DATA[114] + 1;
                if (value59 > 2) {
                    value59 = 2;
                }
                setCarInfo(3, 3, value59);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value60 = DataCanbus.DATA[142] - 1;
                if (value60 < 0) {
                    value60 = 0;
                }
                setCarInfo(9, 1, value60);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value61 = DataCanbus.DATA[142] + 1;
                if (value61 > 11) {
                    value61 = 11;
                }
                setCarInfo(9, 1, value61);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value62 = DataCanbus.DATA[127] - 1;
                if (value62 < 1) {
                    value62 = 1;
                }
                setCarInfo(7, 1, value62);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value63 = DataCanbus.DATA[127] + 1;
                if (value63 > 10) {
                    value63 = 10;
                }
                setCarInfo(7, 1, value63);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value64 = DataCanbus.DATA[145];
                if (value64 == 0) {
                    setCar360Info(15);
                } else if (value64 == 1) {
                    setCar360Info(12);
                } else if (value64 == 2) {
                    setCar360Info(13);
                } else if (value64 == 3) {
                    setCar360Info(14);
                }
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value65 = DataCanbus.DATA[145];
                if (value65 == 0) {
                    setCar360Info(13);
                } else if (value65 == 1) {
                    setCar360Info(14);
                } else if (value65 == 2) {
                    setCar360Info(15);
                } else if (value65 == 3) {
                    setCar360Info(12);
                }
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value66 = DataCanbus.DATA[147] - 1;
                if (value66 < 0) {
                    value66 = 1;
                }
                setCarInfo(6, 10, value66);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value67 = DataCanbus.DATA[147] + 1;
                if (value67 > 1) {
                    value67 = 0;
                }
                setCarInfo(6, 10, value67);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value68 = DataCanbus.DATA[155] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                        if (value68 < 0) {
                            value68 = 2;
                        }
                        break;
                    default:
                        if (value68 < 0) {
                            value68 = 9;
                        }
                        break;
                }
                setCarInfo(2, 4, value68);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value69 = DataCanbus.DATA[155] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                        if (value69 > 2) {
                            value69 = 0;
                        }
                        break;
                    default:
                        if (value69 > 9) {
                            value69 = 0;
                        }
                        break;
                }
                setCarInfo(2, 4, value69);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value70 = DataCanbus.DATA[157] - 1;
                if (value70 < 0) {
                    value70 = 2;
                }
                setCarInfo(6, 18, value70);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value71 = DataCanbus.DATA[157] + 1;
                if (value71 > 2) {
                    value71 = 0;
                }
                setCarInfo(6, 18, value71);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value72 = DataCanbus.DATA[158] - 1;
                if (value72 < 0) {
                    value72 = 2;
                }
                setCarInfo(6, 19, value72);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value73 = DataCanbus.DATA[158] + 1;
                if (value73 > 2) {
                    value73 = 0;
                }
                setCarInfo(6, 19, value73);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value74 = DataCanbus.DATA[44];
                if (value74 > 0) {
                    value74--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value74}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value75 = DataCanbus.DATA[44];
                if (value75 < 7) {
                    value75++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value75}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[116] == 0) {
                    value39 = 1;
                } else {
                    value39 = 0;
                }
                setCarInfo(3, 1, value39);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[101] == 0) {
                    value36 = 1;
                } else {
                    value36 = 0;
                }
                setCarInfo(1, 3, value36);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[102] == 0) {
                    value35 = 1;
                } else {
                    value35 = 0;
                }
                setCarInfo(1, 4, value35);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (DataCanbus.DATA[139] == 0) {
                    value38 = 1;
                } else {
                    value38 = 0;
                }
                setCarInfo(3, 4, value38);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value76 = DataCanbus.DATA[115];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                        if (value76 == 0) {
                            value37 = 1;
                        } else if (value76 == 1) {
                            value37 = 15;
                        } else {
                            value37 = 0;
                        }
                        break;
                    default:
                        if (value76 == 0) {
                            value37 = 1;
                        } else {
                            value37 = 0;
                        }
                        break;
                }
                setCarInfo(3, 2, value37);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (DataCanbus.DATA[122] == 0) {
                    value34 = 1;
                } else {
                    value34 = 0;
                }
                setCarInfo(5, 1, value34);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (DataCanbus.DATA[125] == 0) {
                    value33 = 1;
                } else {
                    value33 = 0;
                }
                setCarInfo(4, 2, value33);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value77 = DataCanbus.DATA[174] - 5;
                if (value77 < 30) {
                    value77 = 30;
                }
                setCarInfo(6, 22, value77);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value78 = DataCanbus.DATA[174] + 5;
                if (value78 > 240) {
                    value78 = 240;
                }
                if (value78 < 30) {
                    value78 = 30;
                }
                setCarInfo(6, 22, value78);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value79 = DataCanbus.DATA[176];
                int value1 = DataCanbus.DATA[177];
                int value80 = value79 - 1;
                if (value80 < 1) {
                    value80 = 4;
                }
                if (value80 == 4) {
                    setCarInfo(11, value80, value1);
                } else {
                    setCarInfo(11, value80, 0);
                }
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value81 = DataCanbus.DATA[176];
                int value82 = DataCanbus.DATA[177];
                int value83 = value81 + 1;
                if (value83 > 4) {
                    value83 = 1;
                }
                if (value83 == 4) {
                    setCarInfo(11, value83, value82);
                } else {
                    setCarInfo(11, value83, 0);
                }
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int i = DataCanbus.DATA[176];
                int value84 = (DataCanbus.DATA[177] >> 6) & 3;
                int data = DataCanbus.DATA[177] & 63;
                int value85 = value84 - 1;
                if (value85 < 0) {
                    value85 = 2;
                }
                setCarInfo(11, 4, data | ((value85 << 6) & 192));
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int i2 = DataCanbus.DATA[176];
                int value86 = (DataCanbus.DATA[177] >> 6) & 3;
                int data2 = DataCanbus.DATA[177] & 63;
                int value87 = value86 + 1;
                if (value87 > 2) {
                    value87 = 0;
                }
                setCarInfo(11, 4, data2 | ((value87 << 6) & 192));
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int i3 = DataCanbus.DATA[176];
                int value88 = (DataCanbus.DATA[177] >> 4) & 3;
                int data3 = DataCanbus.DATA[177] & 207;
                int value89 = value88 - 1;
                if (value89 < 0) {
                    value89 = 2;
                }
                setCarInfo(11, 4, data3 | ((value89 << 4) & 48));
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int i4 = DataCanbus.DATA[176];
                int value90 = (DataCanbus.DATA[177] >> 4) & 3;
                int data4 = DataCanbus.DATA[177] & 207;
                int value91 = value90 + 1;
                if (value91 > 2) {
                    value91 = 0;
                }
                setCarInfo(11, 4, data4 | ((value91 << 4) & 48));
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int i5 = DataCanbus.DATA[176];
                int value92 = (DataCanbus.DATA[177] >> 3) & 1;
                int data5 = DataCanbus.DATA[177] & 247;
                int value93 = value92 - 1;
                if (value93 < 0) {
                    value93 = 1;
                }
                setCarInfo(11, 4, data5 | ((value93 << 3) & 8));
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int value94 = DataCanbus.DATA[176];
                int value95 = (DataCanbus.DATA[177] >> 3) & 1;
                int data6 = DataCanbus.DATA[177] & 247;
                if (value94 == 4) {
                    int value96 = value95 + 1;
                    if (value96 > 1) {
                        value96 = 0;
                    }
                    setCarInfo(11, 4, data6 | ((value96 << 3) & 8));
                }
                break;
            case R.id.btn_minus24 /* 2131427610 */:
                int value97 = DataCanbus.DATA[195] - 1;
                if (value97 < 0) {
                    value97 = 2;
                }
                setCarInfo(5, 4, value97);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                int value98 = DataCanbus.DATA[195] + 1;
                if (value98 > 2) {
                    value98 = 0;
                }
                setCarInfo(5, 4, value98);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
                int value99 = DataCanbus.DATA[196] - 2;
                if (value99 < 0) {
                    value99 = 0;
                }
                setCarInfo(9, 7, value99);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int value100 = DataCanbus.DATA[196] + 2;
                if (value100 > 152) {
                    value100 = 152;
                }
                setCarInfo(9, 7, value100);
                break;
            case R.id.btn_minus26 /* 2131427617 */:
                int value101 = DataCanbus.DATA[198] - 1;
                if (value101 < 0) {
                    value101 = 1;
                }
                setCarInfo(4, 5, value101);
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                int value102 = DataCanbus.DATA[198] + 1;
                if (value102 > 1) {
                    value102 = 0;
                }
                setCarInfo(4, 5, value102);
                break;
            case R.id.btn_minus27 /* 2131427620 */:
                int value103 = DataCanbus.DATA[207] - 1;
                if (value103 < 0) {
                    value103 = 1;
                }
                setCarInfo(13, 3, value103);
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                int value104 = DataCanbus.DATA[207] + 1;
                if (value104 > 1) {
                    value104 = 0;
                }
                setCarInfo(13, 3, value104);
                break;
            case R.id.btn_minus28 /* 2131427623 */:
                int value105 = DataCanbus.DATA[208] - 1;
                if (value105 < 0) {
                    value105 = 1;
                }
                setCarInfo(13, 4, value105);
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                int value106 = DataCanbus.DATA[208] + 1;
                if (value106 > 1) {
                    value106 = 0;
                }
                setCarInfo(13, 4, value106);
                break;
            case R.id.btn_minus29 /* 2131427627 */:
                int value107 = DataCanbus.DATA[209];
                if (value107 > 0) {
                    value107--;
                }
                setCarInfo(13, 5, value107);
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                int value108 = DataCanbus.DATA[209];
                if (value108 < 255) {
                    value108++;
                }
                setCarInfo(13, 5, value108);
                break;
            case R.id.btn_minus30 /* 2131427630 */:
                int value109 = DataCanbus.DATA[210];
                if (value109 > 0) {
                    value109--;
                }
                setCarInfo(13, 6, value109);
                break;
            case R.id.btn_plus30 /* 2131427632 */:
                int value110 = DataCanbus.DATA[210];
                if (value110 < 10) {
                    value110++;
                }
                setCarInfo(13, 6, value110);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                if (DataCanbus.DATA[130] == 0) {
                    value32 = 1;
                } else {
                    value32 = 0;
                }
                setCarInfo(4, 3, value32);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                if (DataCanbus.DATA[126] == 0) {
                    value31 = 1;
                } else {
                    value31 = 0;
                }
                setCarInfo(6, 1, value31);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                if (DataCanbus.DATA[131] == 0) {
                    value30 = 1;
                } else {
                    value30 = 0;
                }
                setCarInfo(6, 2, value30);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                if (DataCanbus.DATA[133] == 0) {
                    value29 = 1;
                } else {
                    value29 = 0;
                }
                setCarInfo(6, 4, value29);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                if (DataCanbus.DATA[136] == 0) {
                    value28 = 1;
                } else {
                    value28 = 0;
                }
                setCarInfo(6, 7, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                if (DataCanbus.DATA[129] == 0) {
                    value27 = 1;
                } else {
                    value27 = 0;
                }
                setCarInfo(8, 1, value27);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                if (DataCanbus.DATA[121] == 0) {
                    creatShowDialog();
                }
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(4, 1, 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                if (DataCanbus.DATA[144] == 0) {
                    setCar360Info(17);
                } else {
                    setCar360Info(16);
                }
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                if (DataCanbus.DATA[146] == 0) {
                    value26 = 1;
                } else {
                    value26 = 0;
                }
                setCarInfo(4, 4, value26);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                if (DataCanbus.DATA[149] == 0) {
                    value25 = 1;
                } else {
                    value25 = 0;
                }
                setCarInfo(1, 1, value25);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                if (DataCanbus.DATA[148] == 0) {
                    value24 = 1;
                } else {
                    value24 = 0;
                }
                setCarInfo(6, 11, value24);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                if (DataCanbus.DATA[150] == 0) {
                    value23 = 1;
                } else {
                    value23 = 0;
                }
                setCarInfo(6, 12, value23);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                if (DataCanbus.DATA[151] == 0) {
                    value22 = 1;
                } else {
                    value22 = 0;
                }
                setCarInfo(6, 13, value22);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                if (DataCanbus.DATA[152] == 0) {
                    value21 = 1;
                } else {
                    value21 = 0;
                }
                setCarInfo(6, 14, value21);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                if (DataCanbus.DATA[153] == 0) {
                    value20 = 1;
                } else {
                    value20 = 0;
                }
                setCarInfo(6, 15, value20);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                if (DataCanbus.DATA[154] == 0) {
                    value19 = 1;
                } else {
                    value19 = 0;
                }
                setCarInfo(6, 16, value19);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                if (DataCanbus.DATA[156] == 0) {
                    value18 = 1;
                } else {
                    value18 = 0;
                }
                setCarInfo(6, 17, value18);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                if (DataCanbus.DATA[159] == 0) {
                    value17 = 1;
                } else {
                    value17 = 0;
                }
                setCarInfo(6, 20, value17);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                if (DataCanbus.DATA[173] == 0) {
                    value16 = 1;
                } else {
                    value16 = 0;
                }
                setCarInfo(6, 21, value16);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                if (DataCanbus.DATA[175] == 0) {
                    value15 = 1;
                } else {
                    value15 = 0;
                }
                setCarInfo(9, 6, value15);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                if (DataCanbus.DATA[197] == 0) {
                    value14 = 1;
                } else {
                    value14 = 0;
                }
                setCarInfo(8, 2, value14);
                break;
            case R.id.btn_minus31 /* 2131427828 */:
                int value111 = DataCanbus.DATA[213] - 1;
                if (value111 < 0) {
                    value111 = 2;
                }
                setCarInfo(13, 9, value111);
                break;
            case R.id.btn_plus31 /* 2131427829 */:
                int value112 = DataCanbus.DATA[213] + 1;
                if (value112 > 2) {
                    value112 = 0;
                }
                setCarInfo(13, 9, value112);
                break;
            case R.id.btn_minus32 /* 2131427830 */:
                int i6 = DataCanbus.DATA[176];
                int value113 = (DataCanbus.DATA[177] >> 1) & 3;
                int data7 = DataCanbus.DATA[177] & 249;
                int value114 = value113 - 1;
                if (value114 < 0) {
                    value114 = 2;
                }
                setCarInfo(11, 4, data7 | ((value114 << 1) & 6));
                break;
            case R.id.btn_plus32 /* 2131427831 */:
                int i7 = DataCanbus.DATA[176];
                int value115 = (DataCanbus.DATA[177] >> 1) & 3;
                int data8 = DataCanbus.DATA[177] & 249;
                int value116 = value115 + 1;
                if (value116 > 2) {
                    value116 = 0;
                }
                setCarInfo(11, 4, data8 | ((value116 << 1) & 6));
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                setCarAirInfo(28, 1);
                this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Act17RuiTengCarSet.this.setCarAirInfo(28, 0);
                    }
                }, 200L);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                if (DataCanbus.DATA[199] == 0) {
                    value13 = 1;
                } else {
                    value13 = 0;
                }
                setCarInfo(255, value13, 0);
                break;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                if (DataCanbus.DATA[100] == 0) {
                    value11 = 1;
                } else {
                    value11 = 0;
                }
                setCarInfo(1, 2, value11);
                break;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                if (DataCanbus.DATA[202] == 0) {
                    value10 = 1;
                } else {
                    value10 = 0;
                }
                setCarInfo(5, 5, value10);
                break;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                if (DataCanbus.DATA[203] == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                setCarInfo(5, 6, value9);
                break;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                if (DataCanbus.DATA[204] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                setCarInfo(6, 23, value8);
                break;
            case R.id.ctv_checkedtext36 /* 2131427844 */:
                if (DataCanbus.DATA[205] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                setCarInfo(13, 1, value7);
                break;
            case R.id.ctv_checkedtext37 /* 2131427855 */:
                if (DataCanbus.DATA[206] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(13, 2, value6);
                break;
            case R.id.ctv_checkedtext38 /* 2131427856 */:
                if (DataCanbus.DATA[211] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(13, 7, value5);
                break;
            case R.id.ctv_checkedtext39 /* 2131427857 */:
                if (DataCanbus.DATA[212] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(13, 8, value4);
                break;
            case R.id.ctv_checkedtext40 /* 2131427858 */:
                if (DataCanbus.DATA[214] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(13, 10, value3);
                break;
            case R.id.ctv_checkedtext41 /* 2131427859 */:
                if (DataCanbus.DATA[215] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(13, 11, value2);
                break;
            case R.id.ctv_checkedtext42 /* 2131427860 */:
                if (DataCanbus.DATA[216] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(13, 12, value);
                break;
            case R.id.ctv_checkedtext43 /* 2131427861 */:
                if (DataCanbus.DATA[217] == 0) {
                    value12 = 1;
                } else {
                    value12 = 0;
                }
                setCarInfo(254, value12, 0);
                break;
            case R.id.ctv_checkedtext44 /* 2131427875 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Act17RuiTengAHDActi.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    private void creatShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_416_reset_tire));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Act17RuiTengCarSet.this.setCarInfo(4, 1, 1);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet.6
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
        DataCanbus.PROXY.cmd(7, new int[]{65, 0, 0}, null, null);
        DataCanbus.PROXY.cmd(7, new int[]{64, 0, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
    }
}
