package com.syu.carinfo.camry2012.xp;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CamrySettingsAct extends BaseActivity {
    public static CamrySettingsAct mInit;
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 18:
                    CamrySettingsAct.this.mUpdaterDayTimeRuningLights();
                    break;
                case 19:
                    CamrySettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 20:
                    CamrySettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 21:
                    CamrySettingsAct.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 22:
                    CamrySettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 23:
                    CamrySettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 24:
                    CamrySettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 25:
                    CamrySettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 26:
                    CamrySettingsAct.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 27:
                    CamrySettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 28:
                    CamrySettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 29:
                    CamrySettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 30:
                    CamrySettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 31:
                    CamrySettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 32:
                    CamrySettingsAct.this.mUpdaterElectric();
                    break;
                case 33:
                    CamrySettingsAct.this.mUpdaterAirByAutoKey();
                    break;
                case 34:
                    CamrySettingsAct.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 35:
                    CamrySettingsAct.this.mUpdaterLoucs();
                    break;
                case 36:
                    CamrySettingsAct.this.mUpdaterLoucsenable();
                    break;
                case 80:
                    CamrySettingsAct.this.updateAuotAC();
                    break;
                case 81:
                    CamrySettingsAct.this.updateBlowEffective();
                    break;
                case 103:
                    CamrySettingsAct.this.updateECOMode();
                    break;
                case 104:
                    CamrySettingsAct.this.updateEVMode();
                    break;
                case 105:
                    CamrySettingsAct.this.updateStartStop();
                    break;
                case 107:
                    CamrySettingsAct.this.updateAutoRelockTime();
                    break;
                case 123:
                    CamrySettingsAct.this.mUpdaterGasSensor();
                    break;
                case 124:
                    CamrySettingsAct.this.mUpdaterSeatMoveMent();
                    break;
                case 133:
                    CamrySettingsAct.this.updateRightCamera();
                    break;
                case 142:
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
                case 143:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 144:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 145:
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
                case 148:
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
                            if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                                switch (value) {
                                    case 0:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_1);
                                        break;
                                    case 1:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_0);
                                        break;
                                    case 2:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_1_US);
                                        break;
                                    case 3:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_35);
                                        break;
                                    case 4:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_5);
                                        break;
                                    case 5:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_2);
                                        break;
                                    case 6:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_3);
                                        break;
                                    case 7:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_16);
                                        break;
                                    case 8:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_1_UK);
                                        break;
                                    case 9:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_31);
                                        break;
                                }
                            }
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
                        default:
                            if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                                switch (value) {
                                    case 0:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_1);
                                        break;
                                    case 1:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                                        break;
                                    case 2:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_0);
                                        break;
                                    case 3:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_15);
                                        break;
                                    case 4:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_14);
                                        break;
                                    case 5:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_35);
                                        break;
                                    case 6:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_21);
                                        break;
                                    case 7:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_29);
                                        break;
                                    case 8:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_9);
                                        break;
                                    case 9:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_37);
                                        break;
                                    case 10:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_26);
                                        break;
                                    case 11:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_8);
                                        break;
                                    case 12:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_31);
                                        break;
                                    case 13:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_12);
                                        break;
                                    case 14:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_16);
                                        break;
                                    case 15:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_27);
                                        break;
                                    case 16:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_40);
                                        break;
                                    case 17:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_39);
                                        break;
                                    case 18:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_18);
                                        break;
                                    case 19:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_7);
                                        break;
                                    case 20:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_33);
                                        break;
                                    case 21:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_30);
                                        break;
                                    case 22:
                                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_language_set0);
                                        break;
                                }
                            }
                            break;
                    }
                case 150:
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
                case 151:
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
                case 159:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)) != null) {
                        if ((DataCanbus.DATA[1000] & 65535) == 20) {
                            switch (value) {
                                case 1:
                                    ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("L/100km");
                                    break;
                                case 2:
                                    ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG(Us)");
                                    break;
                                case 3:
                                    ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG(UK)");
                                    break;
                                default:
                                    ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("Km/L");
                                    break;
                            }
                        } else {
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
                                    switch (value) {
                                        case 1:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG(UK)");
                                            break;
                                        case 2:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("Km/L");
                                            break;
                                        case 3:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("L/100km");
                                            break;
                                        default:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG(US)");
                                            break;
                                    }
                                default:
                                    switch (value) {
                                        case 1:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("Km/L");
                                            break;
                                        case 2:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("L/100km");
                                            break;
                                        default:
                                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text7)).setText("MPG");
                                            break;
                                    }
                            }
                        }
                    }
                    break;
                case 163:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                        break;
                    }
                case 164:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                        break;
                    }
                case 165:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                        break;
                    }
                case 166:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                        break;
                    }
                case 167:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                        break;
                    }
                case 168:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                        break;
                    }
                case 169:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                        break;
                    }
                case 170:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                        break;
                    }
                case 171:
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
                case 172:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 173:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 174:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 175:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 176:
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
                case 178:
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
                case 179:
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
                case 180:
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
                case 181:
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
                            if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                                ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                                break;
                            }
                        default:
                            if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text8)) != null) {
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                                break;
                            }
                    }
                case 183:
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
                case 188:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 8);
                        break;
                    }
                case 196:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText("倾斜和伸缩");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_tilt);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text16)).setText("伸缩");
                                break;
                        }
                    }
                    break;
                case 197:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 198:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value - 5).toString());
                        break;
                    }
                case 199:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value - 5).toString());
                        break;
                    }
                case 200:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 201:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 202:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text24)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 203:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 209:
                    if (((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
                case 210:
                    CamrySettingsAct.this.updateAutoRelockTime();
                    break;
                case 211:
                    if (((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)).setText("部分");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text22)).setText("全部");
                                break;
                        }
                    }
                    break;
                case 223:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
                    break;
                case 224:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
                    break;
                case 225:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value != 0);
                    break;
                case 226:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
                    break;
                case 227:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
                    break;
                case 228:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
                    break;
                case 229:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value != 0);
                    break;
                case 230:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
                    break;
                case 236:
                    switch (value) {
                        case 0:
                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text26)).setText(R.string.str_no_delay);
                            break;
                        case 1:
                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text26)).setText(R.string.str_delay1);
                            break;
                        case 2:
                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text26)).setText(R.string.str_delay2);
                            break;
                        case 3:
                            ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text26)).setText(R.string.str_delay3);
                            break;
                    }
                case 238:
                    CamrySettingsAct.this.updateLauguageSet();
                    break;
                case 239:
                    ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text27)).setText(new StringBuilder().append(value).toString());
                    break;
                case 240:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
                    break;
                case 241:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
                    break;
                case 242:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
                    break;
                case 243:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
                    break;
                case 244:
                    ((CheckedTextView) CamrySettingsAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    break;
                case 254:
                    if (value == 1) {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text28)).setText(R.string.str_244_als2);
                        break;
                    } else {
                        ((TextView) CamrySettingsAct.this.findViewById(R.id.tv_text28)).setText(R.string.str_244_als1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                CamrySettingsAct.this.language_set = position;
                if (CamrySettingsAct.this.language_set >= 0 && CamrySettingsAct.this.language_set <= CamrySettingsAct.this.mLauStylelist.size() && CamrySettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(151, new int[]{4, CamrySettingsAct.this.send_lang[CamrySettingsAct.this.language_set]}, null, null);
                }
                CamrySettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[238];
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
        this.mLauStylelist.add("0");
        this.mLauStylelist.add("3");
        this.mLauStylelist.add("4");
        this.mLauStylelist.add("5");
        this.mLauStylelist.add("6");
        this.mLauStylelist.add("7");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CamrySettingsAct.this.mLauStyle == null) {
                    CamrySettingsAct.this.initLauStyle();
                }
                if (CamrySettingsAct.this.mLauStyle != null && CamrySettingsAct.this.mPopShowView != null) {
                    CamrySettingsAct.this.mLauStyle.showAtLocation(CamrySettingsAct.this.mPopShowView, 17, 0, 0);
                    CamrySettingsAct.this.updateLauguageSet();
                }
            }
        });
        mInit = this;
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy /* 3211376 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy_M /* 3276912 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy_H /* 3342448 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy_21 /* 3670128 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Sienna /* 3801200 */:
                findViewById(R.id.layout_view63).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                findViewById(R.id.layout_view66).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                findViewById(R.id.layout_view68).setVisibility(0);
                findViewById(R.id.layout_view69).setVisibility(0);
                findViewById(R.id.layout_view70).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view63).setVisibility(8);
                findViewById(R.id.layout_view64).setVisibility(8);
                findViewById(R.id.layout_view65).setVisibility(8);
                findViewById(R.id.layout_view66).setVisibility(8);
                findViewById(R.id.layout_view67).setVisibility(8);
                findViewById(R.id.layout_view68).setVisibility(8);
                findViewById(R.id.layout_view69).setVisibility(8);
                findViewById(R.id.layout_view70).setVisibility(8);
                break;
        }
        if ((DataCanbus.DATA[1000] & 65535) == 112) {
            findViewById(R.id.layout_view79).setVisibility(0);
        } else {
            findViewById(R.id.layout_view79).setVisibility(8);
        }
        ((Button) findViewById(R.id.btn_minus28)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[254] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus28)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[254] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[239] - 1;
                if (value < 0) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(151, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[239] + 1;
                if (value > 9) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(151, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[236] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[236] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[143];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{22}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[188];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(24, new int[]{3, 8}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(24, new int[]{3, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 17}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 16}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[209];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{65, 32}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{65, 33}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[175];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{48, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{48}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[163];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{1, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[164];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{2, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{2}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[165];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{3, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{3}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[166];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{4, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{4}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[167];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{5, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{5}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[168];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{6, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{6}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{7, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{7}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{8, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(41, new int[]{8}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[240] & 255;
                int value1 = DataCanbus.DATA[241] & 255;
                int value2 = DataCanbus.DATA[242] & 255;
                int value3 = DataCanbus.DATA[243] & 255;
                int value4 = DataCanbus.DATA[244] & 255;
                if (value0 == 0) {
                    value0 = 1;
                } else if (value0 == 1) {
                    value0 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[240] & 255;
                int value1 = DataCanbus.DATA[241] & 255;
                int value2 = DataCanbus.DATA[242] & 255;
                int value3 = DataCanbus.DATA[243] & 255;
                int value4 = DataCanbus.DATA[244] & 255;
                if (value1 == 0) {
                    value1 = 1;
                } else if (value1 == 1) {
                    value1 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.28
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[240] & 255;
                int value1 = DataCanbus.DATA[241] & 255;
                int value2 = DataCanbus.DATA[242] & 255;
                int value3 = DataCanbus.DATA[243] & 255;
                int value4 = DataCanbus.DATA[244] & 255;
                if (value2 == 0) {
                    value2 = 1;
                } else if (value2 == 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.29
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[240] & 255;
                int value1 = DataCanbus.DATA[241] & 255;
                int value2 = DataCanbus.DATA[242] & 255;
                int value3 = DataCanbus.DATA[243] & 255;
                int value4 = DataCanbus.DATA[244] & 255;
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.30
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[240] & 255;
                int value1 = DataCanbus.DATA[241] & 255;
                int value2 = DataCanbus.DATA[242] & 255;
                int value3 = DataCanbus.DATA[243] & 255;
                int value4 = DataCanbus.DATA[244] & 255;
                if (value4 == 0) {
                    value4 = 1;
                } else if (value4 == 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.31
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[223];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{52, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.32
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[224];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{53, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.33
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[225];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{54, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.34
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[226];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{55, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.35
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[227];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{56, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.36
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[228];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.37
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[229];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{58, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.38
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[230];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{59, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[171];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{9, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[171];
                if (value < 10) {
                    DataCanbus.PROXY.cmd(41, new int[]{9, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[172];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{10, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[172];
                if (value < 31) {
                    DataCanbus.PROXY.cmd(41, new int[]{10, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[173];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{11, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[173];
                if (value < 31) {
                    DataCanbus.PROXY.cmd(41, new int[]{11, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[174];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{12, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[174];
                if (value < 31) {
                    DataCanbus.PROXY.cmd(41, new int[]{12, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[176];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{1, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.48
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[176];
                if (value < 1) {
                    DataCanbus.PROXY.cmd(42, new int[]{1, value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.49
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{3, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(42, new int[]{3}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.50
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[183];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{128, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.51
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[183];
                if (value < 1) {
                    DataCanbus.PROXY.cmd(42, new int[]{128, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.52
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[180] - 1;
                        if (value < 0) {
                            value = 2;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{51, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[211];
                        if (value2 > 0) {
                            DataCanbus.PROXY.cmd(40, new int[]{29, value2 - 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.53
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[180] + 1;
                        if (value > 2) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{51, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[211];
                        if (value2 < 2) {
                            DataCanbus.PROXY.cmd(40, new int[]{29, value2 + 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.54
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{25, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.55
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{25, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.56
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value > 3) {
                    value--;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{26, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.57
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value < 7) {
                    value++;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{26, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.58
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[199];
                if (value > 3) {
                    value--;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{27, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.59
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[199];
                if (value < 7) {
                    value++;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{27, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.60
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[181] - 1;
                        if (value < 0) {
                            value = 3;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{38, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[196];
                        if (value2 > 0) {
                            DataCanbus.PROXY.cmd(40, new int[]{28, value2 - 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.61
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[181] + 1;
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{38, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[196];
                        if (value2 < 3) {
                            DataCanbus.PROXY.cmd(40, new int[]{28, value2 + 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.62
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 8;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.62.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.63
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 16;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.63.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.64
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 2;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.64.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.65
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 4;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.65.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.66
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 32;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.66.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.67
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 32;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.67.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.68
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 64;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.68.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.69
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 64;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct.this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.69.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.70
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[144];
                if (value > 1) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.71
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[144];
                if (value < 5) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.72
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.73
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.74
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[179] + 1;
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{50, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[151] + 4;
                        if (value2 < 7) {
                            value2++;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{12, value2}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.75
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[179] - 1;
                        if (value < 0) {
                            value = 3;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{50, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[151] + 4;
                        if (value2 > 4) {
                            DataCanbus.PROXY.cmd(40, new int[]{12, value2 - 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.76
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148];
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
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.77
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148];
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
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.78
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[178] + 1;
                        if (value > 2) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{37, value}, null, null);
                        break;
                    default:
                        int value2 = DataCanbus.DATA[150] + 1;
                        if (value2 > 2) {
                            value2 = 0;
                        }
                        DataCanbus.PROXY.cmd(40, new int[]{37, value2}, null, null);
                        break;
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.79
            @Override // android.view.View.OnClickListener
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
                        int value = DataCanbus.DATA[178];
                        if (value - 1 < 0) {
                            DataCanbus.PROXY.cmd(40, new int[]{37, 2}, null, null);
                            break;
                        }
                        break;
                    default:
                        int value2 = DataCanbus.DATA[150];
                        if (value2 - 1 < 0) {
                            DataCanbus.PROXY.cmd(40, new int[]{37, 2}, null, null);
                            break;
                        }
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.80
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] - 1;
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
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.81
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] + 1;
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
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.82
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(40, new int[]{24, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.83
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(40, new int[]{24, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.84
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2;
                int value3;
                int value4 = DataCanbus.DATA[145];
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
                        if (DataCanbus.DATA[142] == 1) {
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
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.85
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2;
                int value3;
                int value4 = DataCanbus.DATA[145];
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
                        if (DataCanbus.DATA[142] == 1) {
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
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.86
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_auto_ac)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.87
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[80];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(37, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(37, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_blow_effective)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.88
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[81];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(38, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(38, new int[1], null, null);
                }
            }
        });
        findViewById(R.id.layout_view21).setVisibility(8);
        ((CheckedTextView) findViewById(R.id.camry_btn_turn_rightcamera_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.89
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[133];
                DataCanbus.PROXY.cmd(26, value == 1 ? 0 : 1);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.90
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.91
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.92
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[25];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_lock_set_lock_unlock_feedback_tone_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.93
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_lock_set_lock_unlock_feedback_tone_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.94
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26];
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
                        if (value < 7) {
                            DataCanbus.PROXY.cmd(6, new int[]{value + 1}, null, null);
                            break;
                        }
                        break;
                    default:
                        if (value < 6) {
                            DataCanbus.PROXY.cmd(6, new int[]{value + 1}, null, null);
                            break;
                        }
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.95
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(12, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.96
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(13, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.97
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[29];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.98
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[30];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.99
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[31];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.100
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.101
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.102
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[18];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.103
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.104
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.105
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[20];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.106
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[20];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_headlamps_auto_off_timer_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.107
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[21];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_headlamps_auto_off_timer_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.108
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[21];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(7, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.109
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.110
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_loucs_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.111
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[35];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_loucs_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.112
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[35];
                if (value < 2) {
                    DataCanbus.PROXY.cmd(21, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_eco_mode)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.113
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_ev_mode)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.114
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[104];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_start_stop)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.115
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[105];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(21, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.camry_btn_auto_relock_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.116
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if ((DataCanbus.DATA[1000] & 65535) == 112 || (DataCanbus.DATA[1000] & 65535) == 63) {
                    int value = DataCanbus.DATA[210];
                    if (value > 0) {
                        DataCanbus.PROXY.cmd(40, new int[]{20, value - 1}, null, null);
                        return;
                    }
                    return;
                }
                int value2 = DataCanbus.DATA[107];
                if (value2 > 0) {
                    DataCanbus.PROXY.cmd(23, new int[]{value2 - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_auto_relock_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.117
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if ((DataCanbus.DATA[1000] & 65535) == 112 || (DataCanbus.DATA[1000] & 65535) == 63) {
                    int value = DataCanbus.DATA[210];
                    if (value < 3) {
                        DataCanbus.PROXY.cmd(40, new int[]{20, value + 1}, null, null);
                        return;
                    }
                    return;
                }
                int value2 = DataCanbus.DATA[107];
                if (value2 < 3) {
                    DataCanbus.PROXY.cmd(23, new int[]{value2 + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_seat_movement_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.118
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(28, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_seat_movement_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.119
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value < 2) {
                    DataCanbus.PROXY.cmd(28, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_inout_sensor_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.120
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(27, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_inout_sensor_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct.121
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value < 6) {
                    DataCanbus.PROXY.cmd(27, new int[]{value + 1}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
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
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(0);
        findViewById(R.id.layout_view16).setVisibility(0);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(0);
        findViewById(R.id.layout_view21).setVisibility(8);
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
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
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
            case FinalCanbus.CAR_RZC_OD_14HuangGuan /* 589936 */:
            case FinalCanbus.CAR_RZC_OD_14HuangGuan_H /* 655472 */:
            case FinalCanbus.CAR_RZC_HST_14HuangGuan_H /* 721008 */:
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                break;
            case FinalCanbus.CAR_XP1_TOYOTA_TR1151 /* 2621460 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_view14).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(8);
                findViewById(R.id.layout_view18).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(8);
                findViewById(R.id.layout_view20).setVisibility(8);
                findViewById(R.id.layout_view21).setVisibility(8);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(8);
                findViewById(R.id.layout_view25).setVisibility(8);
                findViewById(R.id.layout_view26).setVisibility(8);
                findViewById(R.id.layout_view27).setVisibility(8);
                findViewById(R.id.layout_view28).setVisibility(8);
                findViewById(R.id.layout_view29).setVisibility(8);
                findViewById(R.id.layout_view30).setVisibility(8);
                findViewById(R.id.layout_view31).setVisibility(8);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(8);
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
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
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
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
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
        if (DataCanbus.DATA[1000] == 852080 || DataCanbus.DATA[1000] == 3735664) {
            findViewById(R.id.layout_view24).setVisibility(8);
        }
        if ((DataCanbus.DATA[1000] & 65535) == 63 || (DataCanbus.DATA[1000] & 65535) == 20) {
            findViewById(R.id.layout_view25).setVisibility(8);
            findViewById(R.id.layout_view31).setVisibility(8);
            findViewById(R.id.layout_view58).setVisibility(8);
        }
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        if ((DataCanbus.DATA[1000] & 65535) == 397) {
            DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
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
            DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        }
        if ((DataCanbus.DATA[1000] & 65535) == 112) {
            DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.camry_tv_auto_relock_time)) != null) {
            int value = DataCanbus.DATA[107];
            if ((DataCanbus.DATA[1000] & 65535) == 112 || (DataCanbus.DATA[1000] & 65535) == 63) {
                value = DataCanbus.DATA[210];
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuotAC() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_auto_ac)) != null) {
            int value = DataCanbus.DATA[80];
            ((CheckedTextView) findViewById(R.id.camry_btn_auto_ac)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowEffective() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_blow_effective)) != null) {
            int value = DataCanbus.DATA[81];
            ((CheckedTextView) findViewById(R.id.camry_btn_blow_effective)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRightCamera() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_turn_rightcamera_onoff)) != null) {
            int value = DataCanbus.DATA[133];
            ((CheckedTextView) findViewById(R.id.camry_btn_turn_rightcamera_onoff)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateECOMode() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_eco_mode)) != null) {
            int value = DataCanbus.DATA[103];
            ((CheckedTextView) findViewById(R.id.camry_btn_eco_mode)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEVMode() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_ev_mode)) != null) {
            int value = DataCanbus.DATA[104];
            ((CheckedTextView) findViewById(R.id.camry_btn_ev_mode)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStartStop() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_start_stop)) != null) {
            int value = DataCanbus.DATA[105];
            ((CheckedTextView) findViewById(R.id.camry_btn_start_stop)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[35];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoucsenable() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[22];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[23];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[24];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[25];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.camry_tv_lock_set_lock_unlock_feedback_tone)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_lock_unlock_feedback_tone)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[27];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[28];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[29];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[30];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[31];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[33];
        if (((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[34];
        if (((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[18];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.camry_tv_sens_cur)) != null) {
            ((TextView) findViewById(R.id.camry_tv_sens_cur)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.camry_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.camry_tv_interior_lighting_off_time)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterGasSensor() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.camry_tv_inout_sensor)) != null) {
            ((TextView) findViewById(R.id.camry_tv_inout_sensor)).setText(new StringBuilder().append(value + 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatMoveMent() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.camry_tv_seat_movement)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.camry_tv_seat_movement)).setText(R.string.str_sbd_x80_shengchang_0);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.camry_tv_seat_movement)).setText(R.string.distance_very_close);
                    break;
                default:
                    ((TextView) findViewById(R.id.camry_tv_seat_movement)).setText(R.string.jeep_comfortsystems_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.camry_tv_headlamps_auto_off_timer)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.camry_tv_headlamps_auto_off_timer)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[32];
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
