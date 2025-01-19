package com.syu.carinfo.camry2012.xp;

import android.content.Intent;
import android.os.Bundle;
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
import com.syu.carinfo.jili.RZCCamryChangjingSetActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class CamrySettingsAct_RZC extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    CamrySettingsAct_RZC.this.mUpdaterDayTimeRuningLights();
                    break;
                case 116:
                    CamrySettingsAct_RZC.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 117:
                    CamrySettingsAct_RZC.this.mUpdaterInteriorLightOffTime();
                    break;
                case 118:
                    CamrySettingsAct_RZC.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 119:
                    CamrySettingsAct_RZC.this.mUpdaterAutolockBySpeed();
                    break;
                case 120:
                    CamrySettingsAct_RZC.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 121:
                    CamrySettingsAct_RZC.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 122:
                    CamrySettingsAct_RZC.this.mUpdaterRemote2PressUnlock();
                    break;
                case 123:
                    CamrySettingsAct_RZC.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 124:
                    CamrySettingsAct_RZC.this.m2TimesKeyUnLock();
                    break;
                case 125:
                    CamrySettingsAct_RZC.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 126:
                    CamrySettingsAct_RZC.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 127:
                    CamrySettingsAct_RZC.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 128:
                    CamrySettingsAct_RZC.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 129:
                    CamrySettingsAct_RZC.this.mUpdaterElectric();
                    break;
                case 130:
                    CamrySettingsAct_RZC.this.mUpdaterAirByAutoKey();
                    break;
                case 131:
                    CamrySettingsAct_RZC.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 132:
                    CamrySettingsAct_RZC.this.mUpdaterLoucs();
                    break;
                case 133:
                    CamrySettingsAct_RZC.this.mUpdaterLoucsenable();
                    break;
                case 159:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 160:
                    if (((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 161:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 162:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 165:
                    CamrySettingsAct_RZC.this.updateLauguageSet();
                    break;
                case 167:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text6)).setText("On");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text6)).setText(R.string.str_214_proda_9);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text6)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 168:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text4)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text4)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 169:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text7)).setText("Km/L");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text7)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text7)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 196:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text16)).setText(R.string.str_incline_telescoping);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text16)).setText(R.string.str_only_incline);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text16)).setText(R.string.str_only_telescoping);
                                break;
                        }
                    }
                    break;
                case 197:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 198:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value - 5).toString());
                        break;
                    }
                case 199:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value - 5).toString());
                        break;
                    }
                case 205:
                    if (((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
                case 206:
                    CamrySettingsAct_RZC.this.updateAutoRelockTime();
                    break;
                case 207:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text22)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text22)).setText(R.string.klc_meter_Speed_Range_Tips_little);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text22)).setText(R.string.klc_meter_Speed_Range_Tips_all);
                                break;
                        }
                    }
                    break;
                case 230:
                    if (value == 1) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text21)).setText(R.string.str_244_als2);
                        break;
                    } else {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text21)).setText(R.string.str_244_als1);
                        break;
                    }
                case 239:
                    if (((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                        break;
                    }
                case 245:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text23)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 246:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text24)) != null) {
                        if (value == 0) {
                            ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text24)).setText(R.string.off);
                            break;
                        } else {
                            ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text24)).setText(new StringBuilder().append(value).toString());
                            break;
                        }
                    }
                    break;
                case 247:
                    ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 248:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text26)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text26)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text26)).setText("By Driver Door");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text26)).setText("By Shift to P");
                                break;
                        }
                    }
                    break;
                case 249:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text27)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text27)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text27)).setText("By Shift from P");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text27)).setText("By Speed");
                                break;
                        }
                    }
                    break;
                case 250:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text28)) != null) {
                        CamrySettingsAct_RZC.this.findViewById(R.id.layout_view1).setVisibility(8);
                        CamrySettingsAct_RZC.this.findViewById(R.id.layout_view2).setVisibility(8);
                        CamrySettingsAct_RZC.this.findViewById(R.id.layout_view3).setVisibility(8);
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text28)).setText("---");
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text28)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text28)).setText(R.string.driver_system_economics);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text28)).setText(R.string.driver_system_sports);
                                break;
                            case 4:
                                CamrySettingsAct_RZC.this.findViewById(R.id.layout_view1).setVisibility(0);
                                CamrySettingsAct_RZC.this.findViewById(R.id.layout_view2).setVisibility(0);
                                CamrySettingsAct_RZC.this.findViewById(R.id.layout_view3).setVisibility(0);
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text28)).setText(R.string.wc_17zhinanzhe_str1);
                                break;
                        }
                    }
                    break;
                case 251:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text29)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_economics);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_sports);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text29)).setText("---");
                                break;
                        }
                    }
                    break;
                case 252:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text30)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text30)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text30)).setText(R.string.driver_system_sports);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text30)).setText("---");
                                break;
                        }
                    }
                    break;
                case 253:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text31)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text31)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text31)).setText(R.string.driver_system_economics);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text31)).setText("---");
                                break;
                        }
                    }
                    break;
                case 261:
                    ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 262:
                    ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    break;
                case 271:
                    if (((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text32)) != null) {
                        ((TextView) CamrySettingsAct_RZC.this.findViewById(R.id.tv_text32)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 272:
                    ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 1);
                    break;
                case 273:
                    ((CheckedTextView) CamrySettingsAct_RZC.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_settings_rzc);
        init();
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                CamrySettingsAct_RZC.this.language_set = position;
                if (CamrySettingsAct_RZC.this.language_set >= 0 && CamrySettingsAct_RZC.this.language_set <= CamrySettingsAct_RZC.this.mLauStylelist.size() && CamrySettingsAct_RZC.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(40, new int[]{38, CamrySettingsAct_RZC.this.send_lang[CamrySettingsAct_RZC.this.language_set]}, null, null);
                }
                CamrySettingsAct_RZC.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[165];
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add("Vietnam");
        this.mLauStylelist.add("Indonesia");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25, 26, 27};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (CamrySettingsAct_RZC.this.mLauStyle == null) {
                    CamrySettingsAct_RZC.this.initLauStyle();
                }
                if (CamrySettingsAct_RZC.this.mLauStyle != null && CamrySettingsAct_RZC.this.mPopShowView != null) {
                    CamrySettingsAct_RZC.this.mLauStyle.showAtLocation(CamrySettingsAct_RZC.this.mPopShowView, 17, 0, 0);
                    CamrySettingsAct_RZC.this.updateLauguageSet();
                }
            }
        });
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
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_minus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
        setSelfClick((Button) findViewById(R.id.btn_minus30), this);
        setSelfClick((Button) findViewById(R.id.btn_plus30), this);
        setSelfClick((Button) findViewById(R.id.btn_minus31), this);
        setSelfClick((Button) findViewById(R.id.btn_plus31), this);
        setSelfClick((Button) findViewById(R.id.btn_minus32), this);
        setSelfClick((Button) findViewById(R.id.btn_plus32), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_TOYOTA_Alpha_17 /* 7471216 */:
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view4).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                return;
            default:
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
        }
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value5 = DataCanbus.DATA[161];
                if (value5 > 1) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value5 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int value6 = DataCanbus.DATA[161];
                if (value6 < 5) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value6 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                if (DataCanbus.DATA[162] == 0) {
                    value4 = 3;
                } else {
                    value4 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value4}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                if (DataCanbus.DATA[162] == 0) {
                    value3 = 3;
                } else {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value3}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                if (DataCanbus.DATA[159] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value2}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (DataCanbus.DATA[159] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[168] + 4;
                if (value7 > 4) {
                    DataCanbus.PROXY.cmd(40, new int[]{12, value7 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[168] + 4;
                if (value8 < 7) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(40, new int[]{12, value8}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[123];
                if (value9 > 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{value9 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[123];
                if (value10 < 6) {
                    DataCanbus.PROXY.cmd(6, new int[]{value10 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                if (DataCanbus.DATA[167] - 1 < 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{37, 2}, null, null);
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                int value11 = DataCanbus.DATA[167] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{37, value11}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value12 = DataCanbus.DATA[169] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{36, value12}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[169] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{36, value13}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value14 = DataCanbus.DATA[182];
                if (value14 > 1) {
                    value14--;
                }
                DataCanbus.PROXY.cmd(40, new int[]{24, value14}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value15 = DataCanbus.DATA[182];
                if (value15 < 7) {
                    value15++;
                }
                DataCanbus.PROXY.cmd(40, new int[]{24, value15}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value16 = DataCanbus.DATA[116];
                if (value16 > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value16 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus9 /* 2131427481 */:
                int value17 = DataCanbus.DATA[116];
                if (value17 < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value17 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus10 /* 2131427482 */:
                int value18 = DataCanbus.DATA[117];
                if (value18 > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value18 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus10 /* 2131427484 */:
                int value19 = DataCanbus.DATA[117];
                if (value19 < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value19 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus11 /* 2131427485 */:
                int value20 = DataCanbus.DATA[118];
                if (value20 > 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{value20 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus11 /* 2131427487 */:
                int value21 = DataCanbus.DATA[118];
                if (value21 < 3) {
                    DataCanbus.PROXY.cmd(7, new int[]{value21 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus12 /* 2131427488 */:
                int value22 = DataCanbus.DATA[129];
                if (value22 > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value22 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus12 /* 2131427490 */:
                int value23 = DataCanbus.DATA[129];
                if (value23 < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value23 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus13 /* 2131427491 */:
                int value24 = DataCanbus.DATA[197];
                if (value24 > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{25, value24 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus13 /* 2131427493 */:
                int value25 = DataCanbus.DATA[197];
                if (value25 < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{25, value25 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus14 /* 2131427494 */:
                int value26 = DataCanbus.DATA[198];
                if (value26 > 3) {
                    value26--;
                }
                if (value26 < 3) {
                    value26 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{26, value26}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value27 = DataCanbus.DATA[198];
                if (value27 < 7) {
                    value27++;
                }
                if (value27 < 3) {
                    value27 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{26, value27}, null, null);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value28 = DataCanbus.DATA[199];
                if (value28 > 3) {
                    value28--;
                }
                if (value28 < 3) {
                    value28 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{27, value28}, null, null);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value29 = DataCanbus.DATA[199];
                if (value29 < 7) {
                    value29++;
                }
                if (value29 < 3) {
                    value29 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{27, value29}, null, null);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value30 = DataCanbus.DATA[196];
                if (value30 > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{28, value30 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus16 /* 2131427520 */:
                int value31 = DataCanbus.DATA[196];
                if (value31 < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{28, value31 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus17 /* 2131427521 */:
                int value32 = DataCanbus.DATA[132];
                if (value32 > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value32 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus17 /* 2131427523 */:
                int value33 = DataCanbus.DATA[132];
                if (value33 < 2) {
                    DataCanbus.PROXY.cmd(21, new int[]{value33 + 1}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[160] == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{22}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[119] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[205] == 32) {
                    DataCanbus.PROXY.cmd(40, new int[]{65, 33}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{65, 32}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[247] == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{39, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{39}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCCamryChangjingSetActi.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[120] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[121] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if (DataCanbus.DATA[122] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                if (DataCanbus.DATA[124] == 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(12, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                if (DataCanbus.DATA[125] == 0) {
                    DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(13, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                if (DataCanbus.DATA[126] == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                if (DataCanbus.DATA[127] == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                if (DataCanbus.DATA[128] == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                if (DataCanbus.DATA[130] == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                if (DataCanbus.DATA[131] == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                if (DataCanbus.DATA[115] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                if (DataCanbus.DATA[239] == 0) {
                    DataCanbus.PROXY.cmd(50, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(50, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, RZCToyotaAHDActi.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                if (DataCanbus.DATA[261] == 0) {
                    DataCanbus.PROXY.cmd(44, new int[]{96, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(44, new int[]{96}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                if (DataCanbus.DATA[262] == 0) {
                    DataCanbus.PROXY.cmd(44, new int[]{97, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(44, new int[]{97}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                if (DataCanbus.DATA[273] == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{112, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{112}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                if (DataCanbus.DATA[272] == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{51, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{51}, null, null);
                    break;
                }
            case R.id.btn_minus18 /* 2131427894 */:
                int value34 = DataCanbus.DATA[206];
                if (value34 > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{20, value34 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus18 /* 2131427895 */:
                int value35 = DataCanbus.DATA[206];
                if (value35 < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{20, value35 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus19 /* 2131427896 */:
                DataCanbus.PROXY.cmd(40, new int[]{65, 2}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                DataCanbus.PROXY.cmd(40, new int[]{65, 1}, null, null);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value36 = DataCanbus.DATA[230] - 1;
                if (value36 < 0) {
                    value36 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value36}, null, null);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value37 = DataCanbus.DATA[230] + 1;
                if (value37 > 1) {
                    value37 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value37}, null, null);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                int value38 = DataCanbus.DATA[207];
                if (value38 > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{29, value38 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus22 /* 2131427901 */:
                int value39 = DataCanbus.DATA[207];
                if (value39 < 2) {
                    DataCanbus.PROXY.cmd(40, new int[]{29, value39 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus20 /* 2131427905 */:
                DataCanbus.PROXY.cmd(40, new int[]{65, 17}, null, null);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                DataCanbus.PROXY.cmd(40, new int[]{65, 16}, null, null);
                break;
            case R.id.btn_plus25 /* 2131427926 */:
                int value40 = DataCanbus.DATA[163] + 1;
                if (value40 > 3) {
                    value40 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{56, value40}, null, null);
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                int value41 = DataCanbus.DATA[246] + 1;
                if (value41 > 3) {
                    value41 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{59, value41}, null, null);
                break;
            case R.id.btn_plus26 /* 2131427928 */:
                int value42 = DataCanbus.DATA[248] + 1;
                if (value42 > 2) {
                    value42 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{41, value42}, null, null);
                break;
            case R.id.btn_plus27 /* 2131427929 */:
                int value43 = DataCanbus.DATA[249] + 1;
                if (value43 > 2) {
                    value43 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{40, value43}, null, null);
                break;
            case R.id.btn_plus28 /* 2131427930 */:
                int value44 = DataCanbus.DATA[250] + 1;
                if (value44 > 4) {
                    value44 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{52, value44}, null, null);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value45 = DataCanbus.DATA[245] + 1;
                if (value45 > 13) {
                    value45 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{58, value45}, null, null);
                break;
            case R.id.btn_minus28 /* 2131428300 */:
                int value46 = DataCanbus.DATA[250] - 1;
                if (value46 < 1) {
                    value46 = 4;
                }
                DataCanbus.PROXY.cmd(40, new int[]{52, value46}, null, null);
                break;
            case R.id.btn_minus29 /* 2131428301 */:
                int value47 = DataCanbus.DATA[251] - 1;
                if (value47 < 1) {
                    value47 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{53, value47}, null, null);
                break;
            case R.id.btn_plus29 /* 2131428302 */:
                int value48 = DataCanbus.DATA[251] + 1;
                if (value48 > 3) {
                    value48 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{53, value48}, null, null);
                break;
            case R.id.btn_minus25 /* 2131428303 */:
                int value49 = DataCanbus.DATA[163] - 1;
                if (value49 < 0) {
                    value49 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{56, value49}, null, null);
                break;
            case R.id.btn_minus26 /* 2131428304 */:
                int value50 = DataCanbus.DATA[248] - 1;
                if (value50 < 0) {
                    value50 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{41, value50}, null, null);
                break;
            case R.id.btn_minus27 /* 2131428305 */:
                int value51 = DataCanbus.DATA[249] - 1;
                if (value51 < 0) {
                    value51 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{40, value51}, null, null);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value52 = DataCanbus.DATA[245] - 1;
                if (value52 < 0) {
                    value52 = 13;
                }
                DataCanbus.PROXY.cmd(40, new int[]{58, value52}, null, null);
                break;
            case R.id.btn_minus24 /* 2131428307 */:
                int value53 = DataCanbus.DATA[246] - 1;
                if (value53 < 0) {
                    value53 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{59, value53}, null, null);
                break;
            case R.id.btn_minus30 /* 2131428365 */:
                int value54 = DataCanbus.DATA[252] - 1;
                if (value54 < 1) {
                    value54 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{54, value54}, null, null);
                break;
            case R.id.btn_plus30 /* 2131428366 */:
                int value55 = DataCanbus.DATA[252] + 1;
                if (value55 > 2) {
                    value55 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{54, value55}, null, null);
                break;
            case R.id.btn_minus31 /* 2131428447 */:
                int value56 = DataCanbus.DATA[253] - 1;
                if (value56 < 1) {
                    value56 = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{55, value56}, null, null);
                break;
            case R.id.btn_plus31 /* 2131428448 */:
                int value57 = DataCanbus.DATA[253] + 1;
                if (value57 > 2) {
                    value57 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{55, value57}, null, null);
                break;
            case R.id.btn_minus32 /* 2131428449 */:
                int value58 = DataCanbus.DATA[271];
                if (value58 > 0) {
                    value58--;
                }
                DataCanbus.PROXY.cmd(40, new int[]{60, value58}, null, null);
                break;
            case R.id.btn_plus32 /* 2131428450 */:
                int value59 = DataCanbus.DATA[271];
                if (value59 < 9) {
                    value59++;
                }
                DataCanbus.PROXY.cmd(40, new int[]{60, value59}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{38}, null, null);
        DataCanbus.PROXY.cmd(43, new int[]{80}, null, null);
        DataCanbus.PROXY.cmd(43, new int[]{82}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.tv_text18)) != null) {
            int value = DataCanbus.DATA[206];
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text18)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text18)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text18)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text18)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
            }
        }
    }

    
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[132];
        if (((TextView) findViewById(R.id.tv_text17)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.xp_loucs_model0_string);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.xp_loucs_model1_string);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.xp_loucs_model2_string);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.xp_loucs_model0_string);
                    break;
            }
        }
    }

    
    public void mUpdaterLoucsenable() {
    }

    
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[119];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[120];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[121];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[122];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[124];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[125];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[126];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[127];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[128];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            ((TextView) findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.tv_text10)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text10)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.tv_text11)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.tv_text11)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[129];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_camry_electric_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_camry_electric_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_camry_electric_level_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_camry_electric_level_4);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_camry_electric_level_0);
                    break;
            }
        }
    }
}
