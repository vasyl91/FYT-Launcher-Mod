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

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityHava18H6SetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int iAls;
            int iRainFall;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[126] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(50, value);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[126] + 1;
                    if (value2 > 2) {
                        value2 = 0;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(50, value2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value3 = DataCanbus.DATA[158] - 1;
                    if (value3 < 0) {
                        value3 = 2;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(75, value3);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value4 = DataCanbus.DATA[158] + 1;
                    if (value4 > 2) {
                        value4 = 0;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(75, value4);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value5 = DataCanbus.DATA[165] - 1;
                    if (value5 < 0) {
                        value5 = 2;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(51, value5);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value6 = DataCanbus.DATA[165] + 1;
                    if (value6 > 2) {
                        value6 = 0;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(51, value6);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value7 = DataCanbus.DATA[167] - 1;
                    if (value7 < 0) {
                        value7 = 2;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(66, value7);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value8 = DataCanbus.DATA[167] + 1;
                    if (value8 > 2) {
                        value8 = 0;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(66, value8);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    int value9 = DataCanbus.DATA[169] - 1;
                    if (value9 < 0) {
                        value9 = 2;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(73, value9);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[169] + 1;
                    if (value10 > 2) {
                        value10 = 0;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(73, value10);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                    int value11 = DataCanbus.DATA[170] - 1;
                    if (value11 < 0) {
                        value11 = 2;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(74, value11);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    int value12 = DataCanbus.DATA[170] + 1;
                    if (value12 > 2) {
                        value12 = 0;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(74, value12);
                    break;
                case R.id.rzc_havalh6_domedelay_m /* 2131427633 */:
                    int iDomeDelayValue = DataCanbus.DATA[102] - 1;
                    if (iDomeDelayValue < 1) {
                        iDomeDelayValue = 4;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(4, iDomeDelayValue);
                    break;
                case R.id.rzc_havalh6_domedelay_p /* 2131427635 */:
                    int iDomeDelayValue2 = DataCanbus.DATA[102] + 1;
                    if (iDomeDelayValue2 > 4) {
                        iDomeDelayValue2 = 1;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(4, iDomeDelayValue2);
                    break;
                case R.id.rzc_havalh6_followhome_m /* 2131427636 */:
                    int iFollowHomeValue = DataCanbus.DATA[103] - 1;
                    if (iFollowHomeValue < 1) {
                        iFollowHomeValue = 4;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(5, iFollowHomeValue);
                    break;
                case R.id.rzc_havalh6_followhome_p /* 2131427638 */:
                    int iFollowHomeValue2 = DataCanbus.DATA[103] + 1;
                    if (iFollowHomeValue2 > 4) {
                        iFollowHomeValue2 = 1;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(5, iFollowHomeValue2);
                    break;
                case R.id.rzc_havalh6_powersave_m /* 2131427639 */:
                    int iPowerSave = DataCanbus.DATA[104] - 1;
                    if (DataCanbus.DATA[1000] == 1114356 || DataCanbus.DATA[1000] == 2294004) {
                        if (iPowerSave < 1) {
                            iPowerSave = 6;
                        }
                    } else if (iPowerSave < 1) {
                        iPowerSave = 3;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(6, iPowerSave);
                    break;
                case R.id.rzc_havalh6_powersave_p /* 2131427641 */:
                    int iPowerSave2 = DataCanbus.DATA[104] + 1;
                    if (DataCanbus.DATA[1000] == 1114356 || DataCanbus.DATA[1000] == 2294004) {
                        if (iPowerSave2 > 6) {
                            iPowerSave2 = 1;
                        }
                    } else if (iPowerSave2 > 3) {
                        iPowerSave2 = 1;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(6, iPowerSave2);
                    break;
                case R.id.rzc_havalh6_rainfall_m /* 2131427642 */:
                case R.id.rzc_havalh6_rainfall_p /* 2131427644 */:
                    int iRainFall2 = DataCanbus.DATA[105];
                    if (iRainFall2 == 0) {
                        iRainFall = 2;
                    } else {
                        iRainFall = 1;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(7, iRainFall);
                    break;
                case R.id.rzc_havalh6_als_m /* 2131427645 */:
                case R.id.rzc_havalh6_als_p /* 2131427647 */:
                    int iAls2 = DataCanbus.DATA[106];
                    if (iAls2 == 0) {
                        iAls = 2;
                    } else {
                        iAls = 1;
                    }
                    ActivityHava18H6SetAct.this.sendCMD(8, iAls);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                        break;
                    }
                case 117:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                        break;
                    }
                case 118:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
                case 119:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
                case 123:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
                case 124:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                        break;
                    }
                case 125:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                        break;
                    }
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
                case 127:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                        break;
                    }
                case 128:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                        break;
                    }
                case 129:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                        break;
                    }
                case 130:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                        break;
                    }
                case 131:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                        break;
                    }
                case 132:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                        break;
                    }
                case 133:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                        break;
                    }
                case 134:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                        break;
                    }
                case 135:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                        break;
                    }
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
                case 160:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                        break;
                    }
                case 161:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                        break;
                    }
                case 162:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext18)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                        break;
                    }
                case 163:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext19)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                        break;
                    }
                case 164:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext20)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                        break;
                    }
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
                case 166:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext22)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 1);
                        break;
                    }
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
                case 168:
                    if (((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext23)) != null) {
                        ((CheckedTextView) ActivityHava18H6SetAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value == 1);
                        break;
                    }
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
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0244_rzc_havalh6set);
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
                    break;
                }
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
        }
    }

    @Override
    public void init() {
        setonClick((Button) findViewById(R.id.rzc_havalh6_domedelay_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_domedelay_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_followhome_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_followhome_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_powersave_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_powersave_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_rainfall_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_rainfall_p));
        setonClick((Button) findViewById(R.id.rzc_havalh6_als_m));
        setonClick((Button) findViewById(R.id.rzc_havalh6_als_p));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        if (((CheckedTextView) findViewById(R.id.rzc_havalH6_rearview_auto)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_havalH6_rearview_auto)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[108] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[119] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[117] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 23;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[118] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 24;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[123] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 28;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[124] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 48;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[125] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 49;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[127] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 52;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[128] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 53;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[129] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 54;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[130] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 55;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[131] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 57;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[132] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 58;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[133] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 59;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[134] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 60;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[135] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 61;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[160] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 76;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[161] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 77;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[162] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 78;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext19)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[163] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 79;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[164] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 255;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext21)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[110] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 13;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[166] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 65;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[168] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 72;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(2, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{49}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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
    }

    @Override
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
    }

    
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.rzc_havalH6_rearview_auto)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_havalH6_rearview_auto)).setChecked(value == 1);
        }
    }

    
    public void updateDomeDelay() {
        int domedelay = DataCanbus.DATA[102];
        String str = "";
        if (((TextView) findViewById(R.id.rzc_havalh6_domedelay_text)) != null) {
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
            ((TextView) findViewById(R.id.rzc_havalh6_domedelay_text)).setText(str);
        }
    }

    
    public void updateFollowHome() {
        int followhome = DataCanbus.DATA[103];
        String str = "";
        if (((TextView) findViewById(R.id.rzc_havalh6_followhome_text)) != null) {
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
            }
            ((TextView) findViewById(R.id.rzc_havalh6_followhome_text)).setText(str);
        }
    }

    
    public void updatePowerSave() {
        int powersave = DataCanbus.DATA[104];
        String str = "";
        if (((TextView) findViewById(R.id.rzc_havalh6_powersave_text)) != null) {
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
            ((TextView) findViewById(R.id.rzc_havalh6_powersave_text)).setText(str);
        }
    }

    
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.rzc_havalh6_rainfall_text)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.rzc_havalh6_rainfall_text)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_rainfall_text)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    
    public void updateAls() {
        int als = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.rzc_havalh6_als_text)) != null) {
            if (als == 1) {
                ((TextView) findViewById(R.id.rzc_havalh6_als_text)).setText(R.string.str_244_als2);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_als_text)).setText(R.string.str_244_als1);
            }
        }
    }

    
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)) != null) {
            if (DataCanbus.DATA[1000] == 458996 || DataCanbus.DATA[1000] == 1573108 || DataCanbus.DATA[1000] == 655604 || DataCanbus.DATA[1000] == 1179892 || DataCanbus.DATA[1000] == 852212) {
                if (bright <= 15) {
                    ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_244_screenbright);
                    return;
                } else if (bright >= 95) {
                    ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_screen_bright_brightest);
                    return;
                } else {
                    ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(String.format("%d", Integer.valueOf(bright - 15)));
                    return;
                }
            }
            if (bright <= 26) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(String.format("%d", Integer.valueOf(bright - 26)));
            }
        }
    }
}
