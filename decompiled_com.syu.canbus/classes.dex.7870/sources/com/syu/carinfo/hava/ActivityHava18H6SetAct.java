package com.syu.carinfo.hava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ActivityHava18H6SetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.ActivityHava18H6SetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    ActivityHava18H6SetAct.this.updateDomeDelay();
                    break;
                case 103:
                    ActivityHava18H6SetAct.this.updateFollowHome();
                    break;
                case 104:
                    ActivityHava18H6SetAct.this.updatePowerSave();
                    break;
                case 105:
                    ActivityHava18H6SetAct.this.updateRainFall();
                    break;
                case 106:
                    ActivityHava18H6SetAct.this.updateAls();
                    break;
                case 107:
                    ActivityHava18H6SetAct.this.updateScreenBright();
                    break;
                case 108:
                    ActivityHava18H6SetAct.this.updateRearViewAuto();
                    break;
                case 110:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext21)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 1);
                    }
                    break;
                case 113:
                    if (((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text18)).setText(R.string.str_unlockall_set);
                                break;
                            case 1:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text18)).setText(R.string.str_unlockdriver_set);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    }
                    break;
                case 118:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    }
                    break;
                case 119:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    }
                    break;
                case 123:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    }
                    break;
                case 124:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    }
                    break;
                case 125:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    }
                    break;
                case 126:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                            break;
                    }
                    break;
                case 127:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    }
                    break;
                case 128:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    }
                    break;
                case 129:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    }
                    break;
                case 130:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    }
                    break;
                case 131:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    }
                    break;
                case 132:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    }
                    break;
                case 133:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    }
                    break;
                case 134:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    }
                    break;
                case 135:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    }
                    break;
                case 158:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_bright_gold);
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                            break;
                    }
                    break;
                case 160:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    }
                    break;
                case 161:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    }
                    break;
                case 162:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext18)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    }
                    break;
                case 163:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext19)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    }
                    break;
                case 164:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext20)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    }
                    break;
                case 165:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text3)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                            break;
                    }
                    break;
                case 166:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext22)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 1);
                    }
                    break;
                case 167:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text4)).setText("15km/h");
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text4)).setText("8km/h");
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                    }
                    break;
                case 168:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext23)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value == 1);
                    }
                    break;
                case 169:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_long);
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_short);
                            break;
                    }
                    break;
                case 170:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                    }
                    break;
                case 171:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text7)).setText(R.string.mateng_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text7)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        default:
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text7)).setText(R.string.mateng_air_con_profile_2);
                            break;
                    }
                    break;
                case 172:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext24)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value == 1);
                    }
                    break;
                case 173:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext25)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value == 1);
                    }
                    break;
                case 174:
                    ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value == 1);
                    break;
                case 175:
                    ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext28)).setChecked(value == 1);
                    break;
                case 176:
                    if (((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text13)) != null) {
                        if (value > 10) {
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text13)).setText("+" + (value - 10) + "km");
                        } else if (value < 10) {
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text13)).setText("-" + (10 - value) + "km");
                        } else {
                            ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text13)).setText("0km");
                        }
                    }
                    break;
                case 178:
                    if (((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_light_state);
                                break;
                            case 1:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text14)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 179:
                    ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext30)).setChecked(value == 1);
                    break;
                case 180:
                    ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext31)).setChecked(value == 1);
                    break;
                case 181:
                    if (((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text15)).setText("预警");
                                break;
                            case 1:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text15)).setText("居中");
                                break;
                            case 2:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text15)).setText("保持");
                                break;
                        }
                    }
                    break;
                case 182:
                    ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext32)).setChecked(value == 1);
                    break;
                case 183:
                    ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext33)).setChecked(value == 1);
                    break;
                case 184:
                    if (((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_steering_flashing_lighting);
                                break;
                            case 2:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_steering_flashing);
                                break;
                        }
                    }
                    break;
                case 185:
                    if (((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.driver_system_standard);
                                break;
                            case 1:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.str_17_snow);
                                break;
                            case 3:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.driver_system_economics);
                                break;
                            case 4:
                                ((TextView) ActivityHava18H6SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0244_rzc_havalh6set);
        initview();
        init();
    }

    private void initview() {
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_HongBiao /* 524532 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_LanBiao /* 590068 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_18 /* 655604 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16 /* 786676 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                if (DataCanbus.DATA[1000] == 1573108) {
                    findViewById(R.id.layout_view28).setVisibility(0);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_HavalLow_H2_LanBiao_H /* 1048820 */:
            case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_HavalH6_Sport_19 /* 1179892 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
            case FinalCanbus.CAR_RZC_HavalM6_PLUS_21 /* 2490612 */:
            case FinalCanbus.CAR_RZC_HavalM6_PLUS_21_H /* 2556148 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Haval_Fengjun7_21 /* 2621684 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Haval_Changchengpao_26 /* 2687220 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Haval_ChangCheng_JOLION_21 /* 2752756 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                break;
        }
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int iAls;
        int iRainFall;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[126] - 1;
                if (value < 0) {
                    value = 2;
                }
                sendCMD(50, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[126] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                sendCMD(50, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[158] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                sendCMD(75, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[158] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                sendCMD(75, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[165] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                sendCMD(51, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[165] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                sendCMD(51, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[167] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                sendCMD(66, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[169] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                sendCMD(73, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[170] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                sendCMD(74, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[171] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                sendCMD(80, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int iDomeDelayValue = DataCanbus.DATA[102] + 1;
                if (iDomeDelayValue > 4) {
                    iDomeDelayValue = 1;
                }
                sendCMD(4, iDomeDelayValue);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int iFollowHomeValue = DataCanbus.DATA[103] + 1;
                if (iFollowHomeValue > 6) {
                    iFollowHomeValue = 1;
                }
                sendCMD(5, iFollowHomeValue);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int iPowerSave = DataCanbus.DATA[104] + 1;
                if (DataCanbus.DATA[1000] == 1114356 || DataCanbus.DATA[1000] == 2294004 || DataCanbus.DATA[1000] == 2687220) {
                    if (iPowerSave > 6) {
                        iPowerSave = 1;
                    }
                } else if (iPowerSave > 3) {
                    iPowerSave = 1;
                }
                sendCMD(6, iPowerSave);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
            case R.id.btn_minus11 /* 2131427486 */:
                int iRainFall2 = DataCanbus.DATA[105];
                if (iRainFall2 == 0) {
                    iRainFall = 2;
                } else {
                    iRainFall = 1;
                }
                sendCMD(7, iRainFall);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
            case R.id.btn_minus12 /* 2131427488 */:
                int iAls2 = DataCanbus.DATA[106];
                if (iAls2 == 0) {
                    iAls = 2;
                } else {
                    iAls = 1;
                }
                sendCMD(8, iAls);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value11 = DataCanbus.DATA[176] + 1;
                if (value11 > 20) {
                    value11 = 0;
                }
                sendCMD(64, value11);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value12 = DataCanbus.DATA[178] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                sendCMD(67, value12);
                break;
            case R.id.btn_plus15 /* 2131427439 */:
                int value13 = DataCanbus.DATA[181] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                sendCMD(86, value13);
                break;
            case R.id.btn_plus16 /* 2131427440 */:
                int value14 = DataCanbus.DATA[184] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                sendCMD(88, value14);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value15 = DataCanbus.DATA[167] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                sendCMD(66, value15);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value16 = DataCanbus.DATA[169] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                sendCMD(73, value16);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value17 = DataCanbus.DATA[170] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                sendCMD(74, value17);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value18 = DataCanbus.DATA[171] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                sendCMD(80, value18);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int iDomeDelayValue2 = DataCanbus.DATA[102] - 1;
                if (iDomeDelayValue2 < 1) {
                    iDomeDelayValue2 = 4;
                }
                sendCMD(4, iDomeDelayValue2);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int iFollowHomeValue2 = DataCanbus.DATA[103] - 1;
                if (iFollowHomeValue2 < 1) {
                    iFollowHomeValue2 = 6;
                }
                sendCMD(5, iFollowHomeValue2);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int iPowerSave2 = DataCanbus.DATA[104] - 1;
                if (DataCanbus.DATA[1000] == 1114356 || DataCanbus.DATA[1000] == 2294004 || DataCanbus.DATA[1000] == 2687220) {
                    if (iPowerSave2 < 1) {
                        iPowerSave2 = 6;
                    }
                } else if (iPowerSave2 < 1) {
                    iPowerSave2 = 3;
                }
                sendCMD(6, iPowerSave2);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value19 = DataCanbus.DATA[176] - 1;
                if (value19 < 0) {
                    value19 = 20;
                }
                sendCMD(64, value19);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value20 = DataCanbus.DATA[178] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                sendCMD(67, value20);
                break;
            case R.id.btn_minus15 /* 2131427494 */:
                int value21 = DataCanbus.DATA[181] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                sendCMD(86, value21);
                break;
            case R.id.btn_minus16 /* 2131427496 */:
                int value22 = DataCanbus.DATA[184] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                sendCMD(88, value22);
                break;
            case R.id.btn_minus17 /* 2131427498 */:
                int value23 = DataCanbus.DATA[185] - 1;
                if (value23 < 0) {
                    value23 = 4;
                }
                if (value23 == 2) {
                    value23 = 1;
                }
                sendCMD(89, value23);
                break;
            case R.id.btn_plus17 /* 2131427500 */:
                int value24 = DataCanbus.DATA[185] + 1;
                if (value24 > 4) {
                    value24 = 0;
                }
                if (value24 == 2) {
                    value24 = 3;
                }
                sendCMD(89, value24);
                break;
            case R.id.btn_minus18 /* 2131427501 */:
                int value25 = DataCanbus.DATA[113] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                sendCMD(16, value25);
                break;
            case R.id.btn_plus18 /* 2131427503 */:
                int value26 = DataCanbus.DATA[113] + 1;
                if (value26 > 1) {
                    value26 = 0;
                }
                sendCMD(16, value26);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value27 = DataCanbus.DATA[119] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 11;
                iArr[1] = value27 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value28 = DataCanbus.DATA[123] & 255;
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 28;
                iArr2[1] = value28 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value29 = DataCanbus.DATA[124] & 255;
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 48;
                iArr3[1] = value29 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value30 = DataCanbus.DATA[117] & 255;
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 23;
                iArr4[1] = value30 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value31 = DataCanbus.DATA[118] & 255;
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 24;
                iArr5[1] = value31 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(2, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value32 = DataCanbus.DATA[125] & 255;
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 49;
                iArr6[1] = value32 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(2, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value33 = DataCanbus.DATA[127] & 255;
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 52;
                iArr7[1] = value33 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(2, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value34 = DataCanbus.DATA[128] & 255;
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 53;
                iArr8[1] = value34 == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(2, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value35 = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 54;
                iArr9[1] = value35 == 0 ? 1 : 0;
                remoteModuleProxy9.cmd(2, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value36 = DataCanbus.DATA[130] & 255;
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 55;
                iArr10[1] = value36 == 0 ? 1 : 0;
                remoteModuleProxy10.cmd(2, iArr10, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value37 = DataCanbus.DATA[131] & 255;
                RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                int[] iArr11 = new int[2];
                iArr11[0] = 57;
                iArr11[1] = value37 == 0 ? 1 : 0;
                remoteModuleProxy11.cmd(2, iArr11, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value38 = DataCanbus.DATA[132] & 255;
                RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                int[] iArr12 = new int[2];
                iArr12[0] = 58;
                iArr12[1] = value38 == 0 ? 1 : 0;
                remoteModuleProxy12.cmd(2, iArr12, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                int value39 = DataCanbus.DATA[133] & 255;
                RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                int[] iArr13 = new int[2];
                iArr13[0] = 59;
                iArr13[1] = value39 == 0 ? 1 : 0;
                remoteModuleProxy13.cmd(2, iArr13, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                int value40 = DataCanbus.DATA[134] & 255;
                RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                int[] iArr14 = new int[2];
                iArr14[0] = 60;
                iArr14[1] = value40 == 0 ? 1 : 0;
                remoteModuleProxy14.cmd(2, iArr14, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                int value41 = DataCanbus.DATA[135] & 255;
                RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                int[] iArr15 = new int[2];
                iArr15[0] = 61;
                iArr15[1] = value41 == 0 ? 1 : 0;
                remoteModuleProxy15.cmd(2, iArr15, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                int value42 = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                int[] iArr16 = new int[2];
                iArr16[0] = 76;
                iArr16[1] = value42 == 0 ? 1 : 0;
                remoteModuleProxy16.cmd(2, iArr16, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                int value43 = DataCanbus.DATA[161] & 255;
                RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                int[] iArr17 = new int[2];
                iArr17[0] = 77;
                iArr17[1] = value43 == 0 ? 1 : 0;
                remoteModuleProxy17.cmd(2, iArr17, null, null);
                break;
            case R.id.ctv_checkedtext26 /* 2131427715 */:
                int value44 = DataCanbus.DATA[108] & 255;
                RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                int[] iArr18 = new int[2];
                iArr18[0] = 9;
                iArr18[1] = value44 == 0 ? 1 : 0;
                remoteModuleProxy18.cmd(2, iArr18, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                int value45 = DataCanbus.DATA[162] & 255;
                RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                int[] iArr19 = new int[2];
                iArr19[0] = 78;
                iArr19[1] = value45 == 0 ? 1 : 0;
                remoteModuleProxy19.cmd(2, iArr19, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427730 */:
                int value46 = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy20 = DataCanbus.PROXY;
                int[] iArr20 = new int[2];
                iArr20[0] = 79;
                iArr20[1] = value46 == 0 ? 1 : 0;
                remoteModuleProxy20.cmd(2, iArr20, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427732 */:
                int value47 = DataCanbus.DATA[164] & 255;
                RemoteModuleProxy remoteModuleProxy21 = DataCanbus.PROXY;
                int[] iArr21 = new int[2];
                iArr21[0] = 255;
                iArr21[1] = value47 == 0 ? 1 : 0;
                remoteModuleProxy21.cmd(2, iArr21, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427734 */:
                int value48 = DataCanbus.DATA[110] & 255;
                RemoteModuleProxy remoteModuleProxy22 = DataCanbus.PROXY;
                int[] iArr22 = new int[2];
                iArr22[0] = 13;
                iArr22[1] = value48 == 0 ? 1 : 0;
                remoteModuleProxy22.cmd(2, iArr22, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427736 */:
                int value49 = DataCanbus.DATA[166] & 255;
                RemoteModuleProxy remoteModuleProxy23 = DataCanbus.PROXY;
                int[] iArr23 = new int[2];
                iArr23[0] = 65;
                iArr23[1] = value49 == 0 ? 1 : 0;
                remoteModuleProxy23.cmd(2, iArr23, null, null);
                break;
            case R.id.ctv_checkedtext23 /* 2131427739 */:
                int value50 = DataCanbus.DATA[168] & 255;
                RemoteModuleProxy remoteModuleProxy24 = DataCanbus.PROXY;
                int[] iArr24 = new int[2];
                iArr24[0] = 72;
                iArr24[1] = value50 == 0 ? 1 : 0;
                remoteModuleProxy24.cmd(2, iArr24, null, null);
                break;
            case R.id.ctv_checkedtext24 /* 2131427744 */:
                int value51 = DataCanbus.DATA[172] & 255;
                RemoteModuleProxy remoteModuleProxy25 = DataCanbus.PROXY;
                int[] iArr25 = new int[2];
                iArr25[0] = 81;
                iArr25[1] = value51 == 0 ? 1 : 0;
                remoteModuleProxy25.cmd(2, iArr25, null, null);
                break;
            case R.id.ctv_checkedtext25 /* 2131427746 */:
                int value52 = DataCanbus.DATA[172] & 255;
                RemoteModuleProxy remoteModuleProxy26 = DataCanbus.PROXY;
                int[] iArr26 = new int[2];
                iArr26[0] = 82;
                iArr26[1] = value52 == 0 ? 1 : 0;
                remoteModuleProxy26.cmd(2, iArr26, null, null);
                break;
            case R.id.ctv_checkedtext27 /* 2131427748 */:
                int value53 = DataCanbus.DATA[174] & 255;
                RemoteModuleProxy remoteModuleProxy27 = DataCanbus.PROXY;
                int[] iArr27 = new int[2];
                iArr27[0] = 68;
                iArr27[1] = value53 == 0 ? 1 : 0;
                remoteModuleProxy27.cmd(2, iArr27, null, null);
                break;
            case R.id.ctv_checkedtext28 /* 2131427750 */:
                int value54 = DataCanbus.DATA[175] & 255;
                RemoteModuleProxy remoteModuleProxy28 = DataCanbus.PROXY;
                int[] iArr28 = new int[2];
                iArr28[0] = 56;
                iArr28[1] = value54 == 0 ? 1 : 0;
                remoteModuleProxy28.cmd(2, iArr28, null, null);
                break;
            case R.id.ctv_checkedtext30 /* 2131427756 */:
                int value55 = DataCanbus.DATA[179] & 255;
                RemoteModuleProxy remoteModuleProxy29 = DataCanbus.PROXY;
                int[] iArr29 = new int[2];
                iArr29[0] = 83;
                iArr29[1] = value55 == 0 ? 1 : 0;
                remoteModuleProxy29.cmd(2, iArr29, null, null);
                break;
            case R.id.ctv_checkedtext31 /* 2131427758 */:
                int value56 = DataCanbus.DATA[180] & 255;
                RemoteModuleProxy remoteModuleProxy30 = DataCanbus.PROXY;
                int[] iArr30 = new int[2];
                iArr30[0] = 84;
                iArr30[1] = value56 == 0 ? 1 : 0;
                remoteModuleProxy30.cmd(2, iArr30, null, null);
                break;
            case R.id.ctv_checkedtext32 /* 2131427761 */:
                int value57 = DataCanbus.DATA[182] & 255;
                RemoteModuleProxy remoteModuleProxy31 = DataCanbus.PROXY;
                int[] iArr31 = new int[2];
                iArr31[0] = 85;
                iArr31[1] = value57 == 0 ? 1 : 0;
                remoteModuleProxy31.cmd(2, iArr31, null, null);
                break;
            case R.id.ctv_checkedtext33 /* 2131427763 */:
                int value58 = DataCanbus.DATA[183] & 255;
                RemoteModuleProxy remoteModuleProxy32 = DataCanbus.PROXY;
                int[] iArr32 = new int[2];
                iArr32[0] = 87;
                iArr32[1] = value58 == 0 ? 1 : 0;
                remoteModuleProxy32.cmd(2, iArr32, null, null);
                break;
        }
    }

    private void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(2, new int[]{cmd, val}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{49, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDomeDelay() {
        int domedelay = DataCanbus.DATA[102];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (domedelay) {
                case 1:
                    str = "3s";
                    break;
                case 2:
                    str = "10s";
                    break;
                case 3:
                    str = "20s";
                    break;
                case 4:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text8)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowHome() {
        int followhome = DataCanbus.DATA[103];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (followhome) {
                case 1:
                    str = "30s";
                    break;
                case 2:
                    str = "1min";
                    break;
                case 3:
                    str = "2min";
                    break;
                case 4:
                    str = "3min";
                    break;
                case 5:
                    str = "60s";
                    break;
                case 6:
                    str = "90s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text9)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePowerSave() {
        int powersave = DataCanbus.DATA[104];
        String str = "";
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (powersave) {
                case 1:
                    str = "10min";
                    break;
                case 2:
                    str = "20min";
                    break;
                case 3:
                    str = "30min";
                    break;
                case 4:
                    str = "2min";
                    break;
                case 5:
                    str = "5min";
                    break;
                case 6:
                    str = "8min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text10)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAls() {
        int als = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (als == 1) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.str_244_als2);
            } else {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.str_244_als1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.tv_text30)) != null) {
            if (DataCanbus.DATA[1000] == 458996 || DataCanbus.DATA[1000] == 1573108 || DataCanbus.DATA[1000] == 655604 || DataCanbus.DATA[1000] == 1179892 || DataCanbus.DATA[1000] == 852212) {
                if (bright <= 15) {
                    ((TextView) findViewById(R.id.tv_text30)).setText(R.string.str_244_screenbright);
                    return;
                } else if (bright >= 95) {
                    ((TextView) findViewById(R.id.tv_text30)).setText(R.string.str_screen_bright_brightest);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text30)).setText(String.format("%d", Integer.valueOf(bright - 15)));
                    return;
                }
            }
            if (bright <= 26) {
                ((TextView) findViewById(R.id.tv_text30)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.tv_text30)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.tv_text30)).setText(String.format("%d", Integer.valueOf(bright - 26)));
            }
        }
    }
}
