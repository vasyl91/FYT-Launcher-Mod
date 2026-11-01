package com.syu.carinfo.honda;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Acrivity_RZC_17CRVSettings extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_RZC_17CRVSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text25)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text25)).setText("℉");
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text25)).setText("℃");
                        }
                    }
                    break;
                case 119:
                    Acrivity_RZC_17CRVSettings.this.updateTripA();
                    break;
                case 120:
                    Acrivity_RZC_17CRVSettings.this.updateTripB();
                    break;
                case 121:
                    Acrivity_RZC_17CRVSettings.this.updateOutTemp();
                    break;
                case 122:
                    Acrivity_RZC_17CRVSettings.this.updateAutoLightSens();
                    break;
                case 123:
                    Acrivity_RZC_17CRVSettings.this.updateHeadLessAutoOff();
                    break;
                case 124:
                    Acrivity_RZC_17CRVSettings.this.updateInteriorLightDimmingTime();
                    break;
                case 125:
                    Acrivity_RZC_17CRVSettings.this.updateKeyLockAnswer();
                    break;
                case 126:
                    Acrivity_RZC_17CRVSettings.this.updateKeyAndRemoteUnlockMode();
                    break;
                case 127:
                    Acrivity_RZC_17CRVSettings.this.updateSecurityRelockTime();
                    break;
                case 128:
                    Acrivity_RZC_17CRVSettings.this.updateAutoDoorUnLock();
                    break;
                case 129:
                    Acrivity_RZC_17CRVSettings.this.updateAutoDoorLock();
                    break;
                case 130:
                    Acrivity_RZC_17CRVSettings.this.updateKeylessAccessBeep();
                    break;
                case 131:
                    Acrivity_RZC_17CRVSettings.this.updateRemoteStartSys();
                    break;
                case 132:
                    Acrivity_RZC_17CRVSettings.this.updateDoorUnlockMode();
                    break;
                case 133:
                    Acrivity_RZC_17CRVSettings.this.updateKeylessAccessLightFlash();
                    break;
                case 134:
                    Acrivity_RZC_17CRVSettings.this.updateAutoInterIllumination();
                    break;
                case 135:
                    Acrivity_RZC_17CRVSettings.this.updateAdjustAlarmVolume();
                    break;
                case 136:
                    Acrivity_RZC_17CRVSettings.this.updateFuelEfficBacklight();
                    break;
                case 137:
                    Acrivity_RZC_17CRVSettings.this.updateNewMsgNoti();
                    break;
                case 138:
                    Acrivity_RZC_17CRVSettings.this.updateSpeedDistanceUnit();
                    break;
                case 139:
                    Acrivity_RZC_17CRVSettings.this.updateTachometer();
                    break;
                case 140:
                    Acrivity_RZC_17CRVSettings.this.updateWalkAwayAutoLock();
                    break;
                case 141:
                    Acrivity_RZC_17CRVSettings.this.updateAutoHeadlightWiper();
                    break;
                case 142:
                    Acrivity_RZC_17CRVSettings.this.updateVolumeAlarmSys();
                    break;
                case 143:
                    Acrivity_RZC_17CRVSettings.this.updateEnergySaveAutoEnghine();
                    break;
                case 144:
                    Acrivity_RZC_17CRVSettings.this.updateAccDiscoveryVehicle();
                    break;
                case 145:
                    Acrivity_RZC_17CRVSettings.this.updatePauseLKADTone();
                    break;
                case 146:
                    Acrivity_RZC_17CRVSettings.this.updateSetFrontHazardDistance();
                    break;
                case 147:
                    Acrivity_RZC_17CRVSettings.this.updateMinorLane();
                    break;
                case 148:
                    Acrivity_RZC_17CRVSettings.this.updateTachometerSet();
                    break;
                case 153:
                    Acrivity_RZC_17CRVSettings.this.updateBackCarBeepTone();
                    break;
                case 154:
                    Acrivity_RZC_17CRVSettings.this.updateEleDoorRemoteOpenCondition();
                    break;
                case 155:
                    Acrivity_RZC_17CRVSettings.this.updateEleDoorOpenAutoOrManule();
                    break;
                case 158:
                    Acrivity_RZC_17CRVSettings.this.uAttentionMonitor(val);
                    break;
                case 195:
                    Acrivity_RZC_17CRVSettings.this.updateTrafficSign(val);
                    break;
                case 196:
                    Acrivity_RZC_17CRVSettings.this.updateRiseWarning(val);
                    break;
                case 197:
                    Acrivity_RZC_17CRVSettings.this.updateMemorySeat(val);
                    break;
                case 198:
                    Acrivity_RZC_17CRVSettings.this.updateSeatBelt(val);
                    break;
                case 199:
                    Acrivity_RZC_17CRVSettings.this.updateStaticLine(val);
                    break;
                case 200:
                    Acrivity_RZC_17CRVSettings.this.updateDynamicLine(val);
                    break;
                case 201:
                    Acrivity_RZC_17CRVSettings.this.updateShowCamera(val);
                    break;
                case 202:
                    Acrivity_RZC_17CRVSettings.this.updateParkSpace(val);
                    break;
                case 203:
                    Acrivity_RZC_17CRVSettings.this.updateReminderSystem(val);
                    break;
                case 205:
                    Acrivity_RZC_17CRVSettings.this.updateMultiFunction(val);
                    break;
                case 210:
                    Acrivity_RZC_17CRVSettings.this.updateAutoOpenTunk(val);
                    break;
                case 217:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 219:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext29), val != 0);
                    break;
                case 220:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext31), val != 0);
                    break;
                case 221:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text24)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text24)).setText(R.string.str_automatic_folding);
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_Manual);
                        }
                    }
                    break;
                case 222:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext32), val != 0);
                    break;
                case 223:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text21)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text21)).setText(R.string.str_specific_speed_activation);
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text21)).setText(R.string.str_activate_during_cruise_control);
                        }
                    }
                    break;
                case 234:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext30), val != 0);
                    break;
                case 235:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext33), val != 0);
                    break;
                case 236:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext34), val != 0);
                    break;
                case 300:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text22)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text22)).setText("+0km/h");
                                break;
                            case 1:
                                ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text22)).setText("+5km/h");
                                break;
                            case 2:
                                ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text22)).setText("+10km/h");
                                break;
                            case 3:
                                ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text22)).setText("+15km/h");
                                break;
                        }
                    }
                    break;
                case 301:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext35), val != 0);
                    break;
                case 302:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext36), val != 0);
                    break;
                case 303:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext37), val != 0);
                    break;
                case 304:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)).setText(R.string.str_298_tactile_and_visual_warnings);
                        } else if (val == 2) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)).setText(R.string.off);
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)).setText(R.string.str_298_visual_warning_);
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_298_rzc_17crv_settings);
        setListener();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.honda.Acrivity_RZC_17CRVSettings.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Acrivity_RZC_17CRVSettings.this.language_set = position;
                if (Acrivity_RZC_17CRVSettings.this.language_set >= 0 && Acrivity_RZC_17CRVSettings.this.language_set <= Acrivity_RZC_17CRVSettings.this.mLauStylelist.size() && Acrivity_RZC_17CRVSettings.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(105, new int[]{85, Acrivity_RZC_17CRVSettings.this.send_lang[Acrivity_RZC_17CRVSettings.this.language_set]}, null, null);
                }
                Acrivity_RZC_17CRVSettings.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    private void setListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add("Malaysia");
        this.mLauStylelist.add("Indonesia");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.mLauStylelist.add("Latvia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_25));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.honda.Acrivity_RZC_17CRVSettings.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Acrivity_RZC_17CRVSettings.this.mLauStyle == null) {
                    Acrivity_RZC_17CRVSettings.this.initLauStyle();
                }
                if (Acrivity_RZC_17CRVSettings.this.mLauStyle != null && Acrivity_RZC_17CRVSettings.this.mPopShowView != null) {
                    Acrivity_RZC_17CRVSettings.this.mLauStyle.showAtLocation(Acrivity_RZC_17CRVSettings.this.mPopShowView, 17, 0, 0);
                    Acrivity_RZC_17CRVSettings.this.updateLauguageSet();
                }
            }
        });
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext42), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext43), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext44), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext45), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext46), this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Acrivity_RZC_17CRVSettings.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.honda.Acrivity_RZC_17CRVSettings.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(105, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Acrivity_RZC_17CRVSettings.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[121];
                int value2 = (value - 1) % 11;
                if (value2 < 0) {
                    value2 = 10;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[121];
                setCarInfo(0, (value3 + 1) % 11);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value4 = DataCanbus.DATA[119];
                int value5 = (value4 - 1) % 3;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value6 = DataCanbus.DATA[119];
                setCarInfo(2, (value6 + 1) % 3);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value7 = DataCanbus.DATA[120];
                int value8 = (value7 - 1) % 3;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value9 = DataCanbus.DATA[120];
                setCarInfo(3, (value9 + 1) % 3);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value10 = DataCanbus.DATA[124];
                int value11 = (value10 - 1) % 3;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value12 = DataCanbus.DATA[124];
                setCarInfo(4, (value12 + 1) % 3);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value13 = DataCanbus.DATA[123];
                int value14 = (value13 - 1) % 4;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarInfo(5, value14);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value15 = DataCanbus.DATA[123];
                setCarInfo(5, (value15 + 1) % 4);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value16 = DataCanbus.DATA[122];
                int value17 = (value16 - 1) % 5;
                if (value17 < 0) {
                    value17 = 4;
                }
                setCarInfo(6, value17);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value18 = DataCanbus.DATA[122];
                setCarInfo(6, (value18 + 1) % 5);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value19 = DataCanbus.DATA[126];
                setCarInfo(9, value19 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value20 = DataCanbus.DATA[126];
                setCarInfo(9, value20 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value21 = DataCanbus.DATA[127];
                int value22 = (value21 - 1) % 3;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(11, value22);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value23 = DataCanbus.DATA[127];
                setCarInfo(11, (value23 + 1) % 3);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value24 = DataCanbus.DATA[128];
                int value25 = (value24 - 1) % 4;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(8, value25);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value26 = DataCanbus.DATA[128];
                setCarInfo(8, (value26 + 1) % 4);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value27 = DataCanbus.DATA[129];
                int value28 = (value27 - 1) % 3;
                if (value28 < 0) {
                    value28 = 2;
                }
                setCarInfo(7, value28);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value29 = DataCanbus.DATA[129];
                setCarInfo(7, (value29 + 1) % 3);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value30 = DataCanbus.DATA[132];
                setCarInfo(25, value30 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value31 = DataCanbus.DATA[132];
                setCarInfo(25, value31 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value32 = DataCanbus.DATA[134];
                int value33 = (value32 - 1) % 5;
                if (value33 < 0) {
                    value33 = 4;
                }
                setCarInfo(27, value33);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value34 = DataCanbus.DATA[134];
                setCarInfo(27, (value34 + 1) % 5);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value35 = DataCanbus.DATA[135];
                int value36 = (value35 - 1) % 3;
                if (value36 < 0) {
                    value36 = 2;
                }
                setCarInfo(18, value36);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value37 = DataCanbus.DATA[135];
                setCarInfo(18, (value37 + 1) % 3);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value38 = DataCanbus.DATA[138];
                setCarInfo(21, value38 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value39 = DataCanbus.DATA[138];
                setCarInfo(21, value39 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value40 = DataCanbus.DATA[142];
                setCarInfo(30, value40 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value41 = DataCanbus.DATA[142];
                setCarInfo(30, value41 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value42 = DataCanbus.DATA[146];
                int value43 = (value42 - 1) % 3;
                if (value43 < 0) {
                    value43 = 2;
                }
                setCarInfo(31, value43);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value44 = DataCanbus.DATA[146];
                setCarInfo(31, (value44 + 1) % 3);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value45 = DataCanbus.DATA[147];
                int value46 = value45 - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_17CRV /* 786730 */:
                    case FinalCanbus.CAR_RZC_XP1_17CRV_H /* 917802 */:
                    case FinalCanbus.CAR_RZC_HONDA_19Linpai /* 1245482 */:
                    case FinalCanbus.CAR_RZC_HONDA_9Yage /* 1507626 */:
                    case FinalCanbus.CAR_RZC_HONDA_9Yage_H /* 1573162 */:
                    case FinalCanbus.CAR_RZC_HONDA_Crown /* 2031914 */:
                    case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
                    case FinalCanbus.CAR_RZC_XP1_2016SIYU /* 2818346 */:
                    case FinalCanbus.CAR_RZC_XP1_2016SIYU_H /* 2883882 */:
                        if (value46 < 0) {
                            value46 = 2;
                        }
                        break;
                    default:
                        if (value46 < 0) {
                            value46 = 3;
                        }
                        break;
                }
                setCarInfo(34, value46);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value47 = DataCanbus.DATA[147];
                int value48 = value47 + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_17CRV /* 786730 */:
                    case FinalCanbus.CAR_RZC_XP1_17CRV_H /* 917802 */:
                    case FinalCanbus.CAR_RZC_HONDA_19Linpai /* 1245482 */:
                    case FinalCanbus.CAR_RZC_HONDA_9Yage /* 1507626 */:
                    case FinalCanbus.CAR_RZC_HONDA_9Yage_H /* 1573162 */:
                    case FinalCanbus.CAR_RZC_HONDA_Crown /* 2031914 */:
                    case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
                    case FinalCanbus.CAR_RZC_XP1_2016SIYU /* 2818346 */:
                    case FinalCanbus.CAR_RZC_XP1_2016SIYU_H /* 2883882 */:
                        if (value48 > 2) {
                            value48 = 0;
                        }
                        break;
                    default:
                        if (value48 > 3) {
                            value48 = 0;
                        }
                        break;
                }
                setCarInfo(34, value48);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value49 = DataCanbus.DATA[158];
                int value50 = value49 - 1;
                if (value50 < 0) {
                    value50 = 2;
                }
                setCarInfo(36, value50);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value51 = DataCanbus.DATA[158];
                setCarInfo(36, (value51 + 1) % 3);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value52 = DataCanbus.DATA[217] == 0 ? 1 : 0;
                setCarInfo(52, value52);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value53 = DataCanbus.DATA[130];
                setCarInfo(13, value53 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value54 = DataCanbus.DATA[131];
                setCarInfo(24, value54 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value55 = DataCanbus.DATA[125];
                setCarInfo(10, value55 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value56 = DataCanbus.DATA[133];
                setCarInfo(26, value56 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value57 = DataCanbus.DATA[136];
                setCarInfo(19, value57 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value58 = DataCanbus.DATA[154] == 0 ? 1 : 0;
                setCarInfo(37, value58);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value59 = DataCanbus.DATA[154] == 0 ? 1 : 0;
                setCarInfo(37, value59);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value60 = DataCanbus.DATA[202] == 0 ? 1 : 0;
                setCarInfo(46, value60);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value61 = DataCanbus.DATA[202] == 0 ? 1 : 0;
                setCarInfo(46, value61);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value62 = DataCanbus.DATA[223] == 0 ? 1 : 0;
                setCarInfo(73, value62);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value63 = DataCanbus.DATA[223] == 0 ? 1 : 0;
                setCarInfo(73, value63);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int value64 = DataCanbus.DATA[300];
                int value65 = value64 - 1;
                if (value65 < 0) {
                    value65 = 3;
                }
                setCarInfo(79, value65);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int value66 = DataCanbus.DATA[300];
                int value67 = value66 + 1;
                if (value67 > 3) {
                    value67 = 0;
                }
                setCarInfo(79, value67);
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int value68 = DataCanbus.DATA[304];
                int value69 = value68 - 1;
                if (value69 < 0) {
                    value69 = 2;
                }
                setCarInfo(82, value69);
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int value70 = DataCanbus.DATA[304];
                int value71 = value70 + 1;
                if (value71 > 2) {
                    value71 = 0;
                }
                setCarInfo(82, value71);
                break;
            case R.id.btn_minus24 /* 2131427610 */:
            case R.id.btn_plus24 /* 2131427612 */:
                int value72 = DataCanbus.DATA[221] == 0 ? 1 : 0;
                setCarInfo(71, value72);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
            case R.id.btn_plus25 /* 2131427615 */:
                int value73 = DataCanbus.DATA[37] == 0 ? 2 : 1;
                setCarInfo(84, value73);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value74 = DataCanbus.DATA[137];
                setCarInfo(20, value74 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value75 = DataCanbus.DATA[139];
                setCarInfo(22, value75 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value76 = DataCanbus.DATA[140];
                setCarInfo(23, value76 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value77 = DataCanbus.DATA[141];
                setCarInfo(28, value77 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value78 = DataCanbus.DATA[143];
                setCarInfo(29, value78 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value79 = DataCanbus.DATA[144];
                setCarInfo(32, value79 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value80 = DataCanbus.DATA[145];
                setCarInfo(33, value80 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value81 = DataCanbus.DATA[148];
                setCarInfo(35, value81 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value82 = DataCanbus.DATA[155] == 0 ? 1 : 0;
                setCarInfo(38, value82);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value83 = DataCanbus.DATA[195] == 0 ? 1 : 0;
                setCarInfo(39, value83);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value84 = DataCanbus.DATA[196] == 0 ? 1 : 0;
                setCarInfo(40, value84);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value85 = DataCanbus.DATA[197] == 0 ? 1 : 0;
                setCarInfo(41, value85);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value86 = DataCanbus.DATA[198] == 0 ? 1 : 0;
                setCarInfo(42, value86);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value87 = DataCanbus.DATA[199] == 0 ? 1 : 0;
                setCarInfo(43, value87);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value88 = DataCanbus.DATA[200] == 0 ? 1 : 0;
                setCarInfo(44, value88);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value89 = DataCanbus.DATA[201] == 0 ? 1 : 0;
                setCarInfo(45, value89);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int value90 = DataCanbus.DATA[203] == 0 ? 1 : 0;
                setCarInfo(47, value90);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int value91 = DataCanbus.DATA[205] == 0 ? 1 : 0;
                setCarInfo(49, value91);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int value92 = DataCanbus.DATA[153] == 0 ? 1 : 0;
                setCarInfo(50, value92);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                setCarInfo(48, 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                int value93 = DataCanbus.DATA[210] == 0 ? 1 : 0;
                setCarInfo(51, value93);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                int value94 = DataCanbus.DATA[219] == 0 ? 1 : 0;
                setCarInfo(74, value94);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                int value95 = DataCanbus.DATA[234] == 0 ? 1 : 0;
                setCarInfo(81, value95);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                int value96 = DataCanbus.DATA[220] == 0 ? 1 : 0;
                setCarInfo(70, value96);
                break;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                int value97 = DataCanbus.DATA[222] == 0 ? 1 : 0;
                setCarInfo(72, value97);
                break;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                int value98 = DataCanbus.DATA[235] == 0 ? 1 : 0;
                setCarInfo(75, value98);
                break;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                int value99 = DataCanbus.DATA[236] == 0 ? 1 : 0;
                setCarInfo(76, value99);
                break;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                int value100 = DataCanbus.DATA[301] == 0 ? 1 : 0;
                setCarInfo(77, value100);
                break;
            case R.id.ctv_checkedtext36 /* 2131427844 */:
                int value101 = DataCanbus.DATA[302] == 0 ? 1 : 0;
                setCarInfo(78, value101);
                break;
            case R.id.ctv_checkedtext37 /* 2131427855 */:
                int value102 = DataCanbus.DATA[303] == 0 ? 1 : 0;
                setCarInfo(97, value102);
                break;
            case R.id.ctv_checkedtext42 /* 2131427860 */:
                dialog(R.string.str_298_reset_maintenance, 14);
                break;
            case R.id.ctv_checkedtext43 /* 2131427861 */:
                dialog(R.string.str_298_default_all, 15);
                break;
            case R.id.ctv_checkedtext44 /* 2131427875 */:
                dialog(R.string.str_298_tpms_cal, 17);
                break;
            case R.id.ctv_checkedtext45 /* 2131427876 */:
                try {
                    Intent ii = new Intent();
                    ii.setClass(this, ActiAMP_Bnr.class);
                    startActivity(ii);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext46 /* 2131427877 */:
                try {
                    Intent ii2 = new Intent();
                    ii2.setClass(this, RZCHondaAHDActi.class);
                    startActivity(ii2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(105, value1, value2);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    private void setViewState(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    protected void updateSeatBelt(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext20), val != 0);
    }

    protected void updateAutoOpenTunk(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext28), val != 0);
    }

    protected void updateMultiFunction(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext25), val != 0);
    }

    protected void updateReminderSystem(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext24), val != 0);
    }

    protected void updateParkSpace(int val) {
        if (((TextView) findViewById(R.id.tv_text20)) != null) {
            if (val == 1) {
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.str_17crv_parking_spaces1);
            } else {
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.str_17crv_parking_spaces0);
            }
        }
    }

    protected void updateShowCamera(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext23), val != 0);
    }

    protected void updateDynamicLine(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext22), val != 0);
    }

    protected void updateStaticLine(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext21), val != 0);
    }

    protected void updateMemorySeat(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext19), val != 0);
    }

    protected void updateRiseWarning(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext18), val != 0);
    }

    protected void updateTrafficSign(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext17), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripA() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_ignite_off);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_manually);
                    break;
                default:
                    if (DataCanbus.DATA[1000] == 1966378) {
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_charging_linkage);
                    } else {
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_refuel);
                    }
                    break;
            }
        }
    }

    protected void uAttentionMonitor(int val) {
        switch (val) {
            case 1:
                ((TextView) findViewById(R.id.tv_text18)).setText(R.string.str_298_visual_warning_);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text18)).setText(R.string.str_298_tactile_and_visual_warnings);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text18)).setText(R.string.off);
                break;
        }
    }

    protected void updateEleDoorOpenAutoOrManule() {
        int value = DataCanbus.DATA[155];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(value != 1);
        }
    }

    protected void updateEleDoorRemoteOpenCondition() {
        int value = DataCanbus.DATA[154];
        if (((TextView) findViewById(R.id.tv_text19)) != null) {
            ((TextView) findViewById(R.id.tv_text19)).setText(value == 0 ? R.string.str_guandao_remote_open1 : R.string.str_guandao_remote_open2);
        }
    }

    protected void updateBackCarBeepTone() {
        int value = DataCanbus.DATA[153];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripB() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_298_ignite_off);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_298_manually);
                    break;
                default:
                    if (DataCanbus.DATA[1000] == 1966378) {
                        ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_charging_linkage);
                    } else {
                        ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_298_refuel);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutTemp() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            Locale locale = TheApp.getInstance().getResources().getConfiguration().locale;
            String language = locale.getCountry();
            if (!language.endsWith("CN")) {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 5).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 3).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLightSens() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText("min");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText("middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text6)).setText("high");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text6)).setText("max");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeadLessAutoOff() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("15s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText("60s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInteriorLightDimmingTime() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("15s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("60s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyLockAnswer() {
        int value = DataCanbus.DATA[125];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyAndRemoteUnlockMode() {
        int value = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.xp_psa_all_string_door_open_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.xp_psa_all_string_door_open_1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSecurityRelockTime() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText("30s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("60s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("90s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoDoorUnLock() {
        int value = DataCanbus.DATA[128];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_298_all_when_driver_door_open);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_298_all_door_when_shifted_to_park);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_298_all_when_ignition_switched_off);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoDoorLock() {
        int value = DataCanbus.DATA[129];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_298_vehicle_speed);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_298_shift_from_p);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeylessAccessBeep() {
        int value = DataCanbus.DATA[130];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteStartSys() {
        int value = DataCanbus.DATA[131];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlockMode() {
        int value = DataCanbus.DATA[132];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeylessAccessLightFlash() {
        int value = DataCanbus.DATA[133];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoInterIllumination() {
        int value = DataCanbus.DATA[134];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("min");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text12)).setText("low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text12)).setText("middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text12)).setText("high");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text12)).setText("max");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdjustAlarmVolume() {
        int value = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text13)).setText("hight");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text13)).setText("middle");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text13)).setText("low");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFuelEfficBacklight() {
        int value = DataCanbus.DATA[136];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewMsgNoti() {
        int value = DataCanbus.DATA[137];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedDistanceUnit() {
        int value = DataCanbus.DATA[138];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text14)).setText("km/h  km");
        } else {
            ((TextView) findViewById(R.id.tv_text14)).setText("mph  miles");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTachometer() {
        int value = DataCanbus.DATA[139];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWalkAwayAutoLock() {
        int value = DataCanbus.DATA[140];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoHeadlightWiper() {
        int value = DataCanbus.DATA[141];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolumeAlarmSys() {
        int value = DataCanbus.DATA[142];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text15)).setText("low");
        } else {
            ((TextView) findViewById(R.id.tv_text15)).setText("high");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergySaveAutoEnghine() {
        int value = DataCanbus.DATA[143];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccDiscoveryVehicle() {
        int value = DataCanbus.DATA[144];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePauseLKADTone() {
        int value = DataCanbus.DATA[145];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
    }

    protected void updateSetFrontHazardDistance() {
        int value = DataCanbus.DATA[146];
        if (((TextView) findViewById(R.id.tv_text16)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_0);
                    break;
            }
        }
    }

    protected void updateMinorLane() {
        int value = DataCanbus.DATA[147];
        if (((TextView) findViewById(R.id.tv_text17)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_RZC_XP1_17CRV /* 786730 */:
                case FinalCanbus.CAR_RZC_XP1_17CRV_H /* 917802 */:
                case FinalCanbus.CAR_RZC_HONDA_19Linpai /* 1245482 */:
                case FinalCanbus.CAR_RZC_HONDA_9Yage /* 1507626 */:
                case FinalCanbus.CAR_RZC_HONDA_9Yage_H /* 1573162 */:
                case FinalCanbus.CAR_RZC_HONDA_Crown /* 2031914 */:
                case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
                case FinalCanbus.CAR_RZC_XP1_2016SIYU /* 2818346 */:
                case FinalCanbus.CAR_RZC_XP1_2016SIYU_H /* 2883882 */:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.jeep_lanesensewarn_1);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_298_wide);
                            break;
                        case 2:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_298_only_warn);
                            break;
                    }
                    break;
                case FinalCanbus.CAR_RZC_HONDA_19YingSipai /* 1179946 */:
                case FinalCanbus.CAR_RZC_HONDA_19Xiangyu /* 1311018 */:
                case FinalCanbus.CAR_RZC_HONDA_10Yage /* 1769770 */:
                case FinalCanbus.CAR_RZC_HONDA_19YingSipai_H /* 2359594 */:
                case FinalCanbus.CAR_RZC_HONDA_10Yage_H /* 2556202 */:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.carema_type_1);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.carema_type_4);
                            break;
                        case 2:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.carema_type_5);
                            break;
                        case 3:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.carema_type_6);
                            break;
                    }
                    break;
                default:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.carema_type_1);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_298_wide);
                            break;
                        case 2:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_298_only_warn);
                            break;
                        case 3:
                            ((TextView) findViewById(R.id.tv_text17)).setText(R.string.distance_very_close);
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTachometerSet() {
        int value = DataCanbus.DATA[148];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
    }
}
