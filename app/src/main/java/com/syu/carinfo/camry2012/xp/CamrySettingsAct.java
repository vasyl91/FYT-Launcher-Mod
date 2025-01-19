package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

public class CamrySettingsAct extends BaseActivity {
    public static CamrySettingsAct mInit;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    CamrySettingsAct.this.mUpdaterDayTimeRuningLights();
                    break;
                case 116:
                    CamrySettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 117:
                    CamrySettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 118:
                    CamrySettingsAct.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 119:
                    CamrySettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 120:
                    CamrySettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 121:
                    CamrySettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 122:
                    CamrySettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 123:
                    CamrySettingsAct.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 124:
                    CamrySettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 125:
                    CamrySettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 126:
                    CamrySettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 127:
                    CamrySettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 128:
                    CamrySettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 129:
                    CamrySettingsAct.this.mUpdaterElectric();
                    break;
                case 130:
                    CamrySettingsAct.this.mUpdaterAirByAutoKey();
                    break;
                case 131:
                    CamrySettingsAct.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 132:
                    CamrySettingsAct.this.mUpdaterLoucs();
                    break;
                case 133:
                    CamrySettingsAct.this.mUpdaterLoucsenable();
                    break;
                case 158:
                    CamrySettingsAct.this.updateECOMode();
                    break;
                case 159:
                    CamrySettingsAct.this.updateEVMode();
                    break;
                case 160:
                    CamrySettingsAct.this.updateStartStop();
                    break;
                case 161:
                    CamrySettingsAct.this.updateAutoRelockTime();
                    break;
                case 174:
                    CamrySettingsAct.this.updateRightCamera();
                    break;
                case 176:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    switch (DataCanbus.DATA[1000]) {
                        case 20:
                        case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
                        case FinalCanbus.CAR_XP1_XFY_SHUPING_KELUZE /* 196628 */:
                        case FinalCanbus.CAR_XP1_XFY_SHUPING_COROLLA /* 262164 */:
                        case FinalCanbus.CAR_XP1_16RAV4_VIEW /* 393236 */:
                        case FinalCanbus.CAR_XP1_16RAV4_VIEW_AMP /* 458772 */:
                        case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                        case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                        case FinalCanbus.CAR_XYF_09Prado /* 2359316 */:
                        case FinalCanbus.CAR_XYF_09Prado_AMP /* 2424852 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_TR1151 /* 2621460 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
                        case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
                            if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                                switch (value) {
                                    case 1:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                                        break;
                                    default:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                                        break;
                                }
                            }
                            break;
                    }
                case 177:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 178:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 179:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 182:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                        case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                        case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                            if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                                switch (value) {
                                    case 0:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_1);
                                        break;
                                    case 1:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_0);
                                        break;
                                    case 2:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_14);
                                        break;
                                    case 3:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_35);
                                        break;
                                }
                            }
                            break;
                    }
                case 184:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)).setText("On");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_214_proda_9);
                                break;
                            default:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 185:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            default:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 186:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)) != null) {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                                switch (value) {
                                    case 1:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG(UK)");
                                        break;
                                    case 2:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("Km/L");
                                        break;
                                    case 3:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                        break;
                                    default:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG(US)");
                                        break;
                                }
                        }
                    }
                    break;
                case 187:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                        break;
                    }
                case 188:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                        break;
                    }
                case 189:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                        break;
                    }
                case 190:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                        break;
                    }
                case 191:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                        break;
                    }
                case 192:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                        break;
                    }
                case 193:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                        break;
                    }
                case 194:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                        break;
                    }
                case 195:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_background_blue);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_3);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_4);
                                break;
                            case 4:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_7);
                                break;
                            case 5:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_1);
                                break;
                            case 6:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_8);
                                break;
                            case 7:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_6);
                                break;
                            case 8:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_403_ambient_2);
                                break;
                            case 9:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.color_blue_green_str);
                                break;
                            case 10:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.color_white_str);
                                break;
                        }
                    }
                    break;
                case 196:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 197:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 198:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 199:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 200:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text21)).setText(R.string.str_mic_type1);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text21)).setText(R.string.str_mic_type2);
                                break;
                        }
                    }
                    break;
                case 201:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)).setText("On");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_214_proda_9);
                                break;
                            default:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text6)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 202:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            default:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text4)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 203:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)).setText("partial");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)).setText("full");
                                break;
                        }
                    }
                    break;
                case 204:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText("Stretch");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_tilt);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText("Stretch and Tilt");
                                break;
                        }
                    }
                    break;
                case 205:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                        case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                        case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                        case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                            if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                                ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                                break;
                            }
                    }
                case 206:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text23)).setText("positive");
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text23)).setText("opposite");
                                break;
                        }
                    }
                    break;
                case 245:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
                    break;
                case 246:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
                    break;
                case 247:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value != 0);
                    break;
                case 248:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
                    break;
                case 249:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
                    break;
                case 250:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
                    break;
                case 251:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value != 0);
                    break;
                case 252:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override
    public void init() {
        mInit = this;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[177];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{22}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[205];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{3, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(42, new int[]{3}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[199];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{48, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{48}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[187];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{1, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{2, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{2}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[189];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{3, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{3}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[190];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{4, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{4}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[191];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{5, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{5}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[192];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{6, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{6}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{7, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{7}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[194];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{8, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{8}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[245];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{52, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[246];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{53, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[247];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{54, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[248];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{55, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[249];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{56, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[250];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[251];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{58, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[252];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{59, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[195];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{9, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[195];
                if (value < 10) {
                    DataCanbus.PROXY.cmd(41, new int[]{9, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[196];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{10, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[196];
                if (value < 31) {
                    DataCanbus.PROXY.cmd(41, new int[]{10, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{11, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value < 31) {
                    DataCanbus.PROXY.cmd(41, new int[]{11, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{12, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value < 31) {
                    DataCanbus.PROXY.cmd(41, new int[]{12, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[200];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{1, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[200];
                if (value < 1) {
                    DataCanbus.PROXY.cmd(42, new int[]{1, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus23)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[206];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{128, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[206];
                if (value < 1) {
                    DataCanbus.PROXY.cmd(42, new int[]{128, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[203] - 1;
                        if (value < 0) {
                            value = 2;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{51, value}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[203] + 1;
                        if (value > 2) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{51, value}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[204] - 1;
                        if (value < 0) {
                            value = 3;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{38, value}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[204] + 1;
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{38, value}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 8;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 16;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 2;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 4;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 32;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 32;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 64;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 64;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[178];
                if (value > 1) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[178];
                if (value < 5) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[176];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[176];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[202] + 1;
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{50, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[185] + 4;
                        if (value2 < 7) {
                            value2++;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{12, value2}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[202] - 1;
                        if (value < 0) {
                            value = 3;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{50, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[185] + 4;
                        if (value2 > 4) {
                            DataCanbus.PROXY.cmd(40, new int[]{12, value2 - 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                switch (DataCanbus.DATA[1000]) {
                    case 20:
                    case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
                    case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                    case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
                    case FinalCanbus.CAR_XP1_14Prado_L /* 3276820 */:
                    case FinalCanbus.CAR_XP1_14Prado_M /* 3342356 */:
                    case FinalCanbus.CAR_XP1_14Prado_H /* 3407892 */:
                        int value2 = value + 1;
                        if (value2 > 9) {
                            value2 = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{36, value2}, null, null);
                        break;
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value3 = value + 1;
                        if (value3 > 3) {
                            value3 = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{36, value3}, null, null);
                        break;
                    default:
                        int value4 = value + 1;
                        if (value4 > 22) {
                            value4 = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{38, value4}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                switch (DataCanbus.DATA[1000]) {
                    case 20:
                    case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
                    case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                    case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
                    case FinalCanbus.CAR_XP1_14Prado_L /* 3276820 */:
                    case FinalCanbus.CAR_XP1_14Prado_M /* 3342356 */:
                    case FinalCanbus.CAR_XP1_14Prado_H /* 3407892 */:
                        int value2 = value - 1;
                        if (value2 < 0) {
                            value2 = 9;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{36, value2}, null, null);
                        break;
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value3 = value - 1;
                        if (value3 < 0) {
                            value3 = 3;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{36, value3}, null, null);
                        break;
                    default:
                        int value4 = value - 1;
                        if (value4 < 0) {
                            value4 = 22;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{38, value4}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[201] + 1;
                        if (value > 2) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{37, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[184] + 1;
                        if (value2 > 2) {
                            value2 = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{37, value2}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        int value = DataCanbus.DATA[201];
                        if (value - 1 < 0) {
                            DataCanbus.PROXY.cmd(40, new int[]{37, 2}, null, null);
                            break;
                        }
                    default:
                        int value2 = DataCanbus.DATA[184];
                        if (value2 - 1 < 0) {
                            DataCanbus.PROXY.cmd(40, new int[]{37, 2}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[186] - 1;
                if ((DataCanbus.DATA[1000] & 65535) == 20) {
                    if (value < 0) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(40, new int[]{25, value}, null, null);
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        if (value < 0) {
                            value = 3;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{49, value}, null, null);
                        break;
                    default:
                        if (value < 0) {
                            value = 2;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{36, value}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[186] + 1;
                if ((DataCanbus.DATA[1000] & 65535) == 20) {
                    if (value > 3) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(40, new int[]{25, value}, null, null);
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{49, value}, null, null);
                        break;
                    default:
                        if (value > 2) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{36, value}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2;
                int value3;
                int value4 = DataCanbus.DATA[179];
                switch (DataCanbus.DATA[1000]) {
                    case 20:
                    case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
                    case FinalCanbus.CAR_XP1_XFY_SHUPING_KELUZE /* 196628 */:
                    case FinalCanbus.CAR_XP1_XFY_SHUPING_COROLLA /* 262164 */:
                    case FinalCanbus.CAR_XP1_16RAV4_VIEW /* 393236 */:
                    case FinalCanbus.CAR_XP1_16RAV4_VIEW_AMP /* 458772 */:
                    case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                    case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                    case FinalCanbus.CAR_XYF_09Prado /* 2359316 */:
                    case FinalCanbus.CAR_XYF_09Prado_AMP /* 2424852 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_TR1151 /* 2621460 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
                    case FinalCanbus.CAR_XP1_14Prado_L /* 3276820 */:
                    case FinalCanbus.CAR_XP1_14Prado_M /* 3342356 */:
                    case FinalCanbus.CAR_XP1_14Prado_H /* 3407892 */:
                        if (DataCanbus.DATA[176] == 1) {
                            value = 0;
                        } else {
                            value = 1;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{27, value}, null, null);
                        break;
                    case 397:
                    case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
                    case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong /* 852365 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
                    case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14Corolla /* 1245581 */:
                    case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
                    case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong_AMP /* 1638797 */:
                    case FinalCanbus.CAR_BNR_10PradoAuto /* 1704333 */:
                    case FinalCanbus.CAR_BNR_10PradoAuto_AMP /* 1769869 */:
                    case FinalCanbus.CAR_BNR_14PradoAuto /* 1835405 */:
                    case FinalCanbus.CAR_BNR_14PradoAuto_AMP /* 1900941 */:
                    case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
                    case FinalCanbus.CAR_BNR_09Rav4 /* 2032013 */:
                    case FinalCanbus.CAR_BNR_18PradoHand /* 2359693 */:
                    case FinalCanbus.CAR_BNR_18PradoHand_AMP /* 2425229 */:
                    case FinalCanbus.CAR_BNR_18PradoAuto /* 2490765 */:
                    case FinalCanbus.CAR_BNR_18PradoAuto_AMP /* 2556301 */:
                    case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
                    case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
                    case FinalCanbus.CAR_BNR_18PradoHand_AirP /* 5112205 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        if (value4 == 1) {
                            value2 = 0;
                        } else {
                            value2 = 1;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{24, value2}, null, null);
                        break;
                    default:
                        if (value4 == 0) {
                            value3 = 3;
                        } else {
                            value3 = 2;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{23, value3}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2;
                int value3;
                int value4 = DataCanbus.DATA[179];
                switch (DataCanbus.DATA[1000]) {
                    case 20:
                    case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
                    case FinalCanbus.CAR_XP1_XFY_SHUPING_KELUZE /* 196628 */:
                    case FinalCanbus.CAR_XP1_XFY_SHUPING_COROLLA /* 262164 */:
                    case FinalCanbus.CAR_XP1_16RAV4_VIEW /* 393236 */:
                    case FinalCanbus.CAR_XP1_16RAV4_VIEW_AMP /* 458772 */:
                    case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                    case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                    case FinalCanbus.CAR_XYF_09Prado /* 2359316 */:
                    case FinalCanbus.CAR_XYF_09Prado_AMP /* 2424852 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_TR1151 /* 2621460 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
                    case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
                    case FinalCanbus.CAR_XP1_14Prado_L /* 3276820 */:
                    case FinalCanbus.CAR_XP1_14Prado_M /* 3342356 */:
                    case FinalCanbus.CAR_XP1_14Prado_H /* 3407892 */:
                        if (DataCanbus.DATA[176] == 1) {
                            value = 0;
                        } else {
                            value = 1;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{27, value}, null, null);
                        break;
                    case 397:
                    case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
                    case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong /* 852365 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
                    case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14Corolla /* 1245581 */:
                    case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
                    case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong_AMP /* 1638797 */:
                    case FinalCanbus.CAR_BNR_10PradoAuto /* 1704333 */:
                    case FinalCanbus.CAR_BNR_10PradoAuto_AMP /* 1769869 */:
                    case FinalCanbus.CAR_BNR_14PradoAuto /* 1835405 */:
                    case FinalCanbus.CAR_BNR_14PradoAuto_AMP /* 1900941 */:
                    case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
                    case FinalCanbus.CAR_BNR_09Rav4 /* 2032013 */:
                    case FinalCanbus.CAR_BNR_18PradoHand /* 2359693 */:
                    case FinalCanbus.CAR_BNR_18PradoHand_AMP /* 2425229 */:
                    case FinalCanbus.CAR_BNR_18PradoAuto /* 2490765 */:
                    case FinalCanbus.CAR_BNR_18PradoAuto_AMP /* 2556301 */:
                    case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
                    case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
                    case FinalCanbus.CAR_BNR_18PradoHand_AirP /* 5112205 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        if (value4 == 1) {
                            value2 = 0;
                        } else {
                            value2 = 1;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{24, value2}, null, null);
                        break;
                    default:
                        if (value4 == 0) {
                            value3 = 3;
                        } else {
                            value3 = 2;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{23, value3}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 17}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 16}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_lock_set_lock_unlock_feedback_tone_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_lock_set_lock_unlock_feedback_tone_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        if (value < 7) {
                            DataCanbus.PROXY.cmd(6, new int[]{value + 1}, null, null);
                            break;
                        }
                    default:
                        if (value < 6) {
                            DataCanbus.PROXY.cmd(6, new int[]{value + 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(12, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(13, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[115];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_headlamps_auto_off_timer_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_headlamps_auto_off_timer_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(7, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_loucs_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_loucs_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value < 2) {
                    DataCanbus.PROXY.cmd(21, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_eco_mode)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_ev_mode)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[159];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_start_stop)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.camry_btn_auto_relock_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[161];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(23, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_auto_relock_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[161];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(23, new int[]{value + 1}, null, null);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{38}, null, null);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(0);
        findViewById(R.id.layout_view3).setVisibility(0);
        findViewById(R.id.layout_view4).setVisibility(0);
        findViewById(R.id.layout_view5).setVisibility(0);
        findViewById(R.id.layout_view6).setVisibility(0);
        findViewById(R.id.layout_view7).setVisibility(0);
        findViewById(R.id.layout_view8).setVisibility(0);
        findViewById(R.id.layout_view9).setVisibility(0);
        findViewById(R.id.layout_view10).setVisibility(0);
        findViewById(R.id.layout_view11).setVisibility(0);
        findViewById(R.id.layout_view12).setVisibility(0);
        findViewById(R.id.layout_view13).setVisibility(0);
        findViewById(R.id.layout_view15).setVisibility(0);
        findViewById(R.id.layout_view16).setVisibility(0);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(0);
        findViewById(R.id.layout_view22).setVisibility(0);
        findViewById(R.id.layout_view23).setVisibility(0);
        findViewById(R.id.layout_view24).setVisibility(0);
        findViewById(R.id.layout_view25).setVisibility(8);
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
        findViewById(R.id.layout_text_view1).setVisibility(0);
        findViewById(R.id.layout_view26).setVisibility(0);
        findViewById(R.id.layout_view27).setVisibility(0);
        findViewById(R.id.layout_view28).setVisibility(0);
        findViewById(R.id.layout_view29).setVisibility(0);
        findViewById(R.id.layout_bnr_camry).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(0);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_view71).setVisibility(8);
        findViewById(R.id.layout_view72).setVisibility(8);
        findViewById(R.id.layout_view73).setVisibility(8);
        findViewById(R.id.layout_view74).setVisibility(8);
        findViewById(R.id.layout_view75).setVisibility(8);
        findViewById(R.id.layout_view76).setVisibility(8);
        findViewById(R.id.layout_view77).setVisibility(8);
        findViewById(R.id.layout_view78).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_view60).setVisibility(0);
                findViewById(R.id.layout_view71).setVisibility(0);
                findViewById(R.id.layout_view72).setVisibility(0);
                findViewById(R.id.layout_view73).setVisibility(0);
                findViewById(R.id.layout_view74).setVisibility(0);
                findViewById(R.id.layout_view75).setVisibility(0);
                findViewById(R.id.layout_view76).setVisibility(0);
                findViewById(R.id.layout_view77).setVisibility(0);
                findViewById(R.id.layout_view78).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                break;
        }
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        if ((DataCanbus.DATA[1000] & 65535) == 397) {
            DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.camry_tv_auto_relock_time)) != null) {
            int value = DataCanbus.DATA[161];
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
            }
        }
    }

    
    public void updateRightCamera() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_turn_rightcamera_onoff)) != null) {
            int value = DataCanbus.DATA[174];
            ((CheckedTextView) findViewById(R.id.camry_btn_turn_rightcamera_onoff)).setChecked(value != 0);
        }
    }

    
    public void updateECOMode() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_eco_mode)) != null) {
            int value = DataCanbus.DATA[158];
            ((CheckedTextView) findViewById(R.id.camry_btn_eco_mode)).setChecked(value != 0);
        }
    }

    
    public void updateEVMode() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_ev_mode)) != null) {
            int value = DataCanbus.DATA[159];
            ((CheckedTextView) findViewById(R.id.camry_btn_ev_mode)).setChecked(value != 0);
        }
    }

    
    public void updateStartStop() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_start_stop)) != null) {
            int value = DataCanbus.DATA[160];
            ((CheckedTextView) findViewById(R.id.camry_btn_start_stop)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[132];
        if (((TextView) findViewById(R.id.xp_loucs_set_show)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model0_string);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model1_string);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model2_string);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model0_string);
                    break;
            }
        }
    }

    
    public void mUpdaterLoucsenable() {
    }

    
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[119];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[120];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[121];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[122];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.camry_tv_lock_set_lock_unlock_feedback_tone)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_lock_unlock_feedback_tone)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[124];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[125];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[126];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[127];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[128];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.camry_tv_sens_cur)) != null) {
            ((TextView) findViewById(R.id.camry_tv_sens_cur)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.camry_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.camry_tv_interior_lighting_off_time)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.camry_tv_headlamps_auto_off_timer)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.camry_tv_headlamps_auto_off_timer)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[129];
        if (((TextView) findViewById(R.id.camry_tv_electric_door)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_4);
                    break;
                default:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_0);
                    break;
            }
        }
    }
}
