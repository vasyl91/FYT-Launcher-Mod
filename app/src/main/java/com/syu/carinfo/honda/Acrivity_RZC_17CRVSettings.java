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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 58:
                    Acrivity_RZC_17CRVSettings.this.updateTripA();
                    break;
                case 59:
                    Acrivity_RZC_17CRVSettings.this.updateTripB();
                    break;
                case 60:
                    Acrivity_RZC_17CRVSettings.this.updateOutTemp();
                    break;
                case 61:
                    Acrivity_RZC_17CRVSettings.this.updateAutoLightSens();
                    break;
                case 62:
                    Acrivity_RZC_17CRVSettings.this.updateHeadLessAutoOff();
                    break;
                case 63:
                    Acrivity_RZC_17CRVSettings.this.updateInteriorLightDimmingTime();
                    break;
                case 64:
                    Acrivity_RZC_17CRVSettings.this.updateKeyLockAnswer();
                    break;
                case 65:
                    Acrivity_RZC_17CRVSettings.this.updateKeyAndRemoteUnlockMode();
                    break;
                case 66:
                    Acrivity_RZC_17CRVSettings.this.updateSecurityRelockTime();
                    break;
                case 67:
                    Acrivity_RZC_17CRVSettings.this.updateAutoDoorUnLock();
                    break;
                case 68:
                    Acrivity_RZC_17CRVSettings.this.updateAutoDoorLock();
                    break;
                case 69:
                    Acrivity_RZC_17CRVSettings.this.updateKeylessAccessBeep();
                    break;
                case 70:
                    Acrivity_RZC_17CRVSettings.this.updateRemoteStartSys();
                    break;
                case 71:
                    Acrivity_RZC_17CRVSettings.this.updateDoorUnlockMode();
                    break;
                case 72:
                    Acrivity_RZC_17CRVSettings.this.updateKeylessAccessLightFlash();
                    break;
                case 73:
                    Acrivity_RZC_17CRVSettings.this.updateAutoInterIllumination();
                    break;
                case 74:
                    Acrivity_RZC_17CRVSettings.this.updateAdjustAlarmVolume();
                    break;
                case 75:
                    Acrivity_RZC_17CRVSettings.this.updateFuelEfficBacklight();
                    break;
                case 76:
                    Acrivity_RZC_17CRVSettings.this.updateNewMsgNoti();
                    break;
                case 77:
                    Acrivity_RZC_17CRVSettings.this.updateSpeedDistanceUnit();
                    break;
                case 78:
                    Acrivity_RZC_17CRVSettings.this.updateTachometer();
                    break;
                case 79:
                    Acrivity_RZC_17CRVSettings.this.updateWalkAwayAutoLock();
                    break;
                case 80:
                    Acrivity_RZC_17CRVSettings.this.updateAutoHeadlightWiper();
                    break;
                case 81:
                    Acrivity_RZC_17CRVSettings.this.updateVolumeAlarmSys();
                    break;
                case 82:
                    Acrivity_RZC_17CRVSettings.this.updateEnergySaveAutoEnghine();
                    break;
                case 83:
                    Acrivity_RZC_17CRVSettings.this.updateAccDiscoveryVehicle();
                    break;
                case 84:
                    Acrivity_RZC_17CRVSettings.this.updatePauseLKADTone();
                    break;
                case 85:
                    Acrivity_RZC_17CRVSettings.this.updateSetFrontHazardDistance();
                    break;
                case 86:
                    Acrivity_RZC_17CRVSettings.this.updateMinorLane();
                    break;
                case 87:
                    Acrivity_RZC_17CRVSettings.this.updateTachometerSet();
                    break;
                case 109:
                    Acrivity_RZC_17CRVSettings.this.updateBackCarBeepTone();
                    break;
                case 110:
                    Acrivity_RZC_17CRVSettings.this.updateEleDoorRemoteOpenCondition();
                    break;
                case 111:
                    Acrivity_RZC_17CRVSettings.this.updateEleDoorOpenAutoOrManule();
                    break;
                case 114:
                    Acrivity_RZC_17CRVSettings.this.uAttentionMonitor(val);
                    break;
                case 151:
                    Acrivity_RZC_17CRVSettings.this.updateTrafficSign(val);
                    break;
                case 152:
                    Acrivity_RZC_17CRVSettings.this.updateRiseWarning(val);
                    break;
                case 153:
                    Acrivity_RZC_17CRVSettings.this.updateMemorySeat(val);
                    break;
                case 154:
                    Acrivity_RZC_17CRVSettings.this.updateSeatBelt(val);
                    break;
                case 155:
                    Acrivity_RZC_17CRVSettings.this.updateStaticLine(val);
                    break;
                case 156:
                    Acrivity_RZC_17CRVSettings.this.updateDynamicLine(val);
                    break;
                case 157:
                    Acrivity_RZC_17CRVSettings.this.updateShowCamera(val);
                    break;
                case 158:
                    Acrivity_RZC_17CRVSettings.this.updateParkSpace(val);
                    break;
                case 159:
                    Acrivity_RZC_17CRVSettings.this.updateReminderSystem(val);
                    break;
                case 161:
                    Acrivity_RZC_17CRVSettings.this.updateMultiFunction(val);
                    break;
                case 166:
                    Acrivity_RZC_17CRVSettings.this.updateAutoOpenTunk(val);
                    break;
                case 173:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 175:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext29), val != 0);
                    break;
                case 176:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext31), val != 0);
                    break;
                case 177:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text24)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text24)).setText(R.string.str_automatic_folding);
                            break;
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_Manual);
                            break;
                        }
                    }
                    break;
                case 178:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext32), val != 0);
                    break;
                case 179:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text21)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text21)).setText("在特定速度范围内激活");
                            break;
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text21)).setText("巡航控制时激活");
                            break;
                        }
                    }
                    break;
                case 190:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext30), val != 0);
                    break;
                case 191:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext33), val != 0);
                    break;
                case 192:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext34), val != 0);
                    break;
                case 193:
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
                case 194:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext35), val != 0);
                    break;
                case 195:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext36), val != 0);
                    break;
                case 196:
                    Acrivity_RZC_17CRVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.ctv_checkedtext37), val != 0);
                    break;
                case 197:
                    if (((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)) != null) {
                        if (val == 1) {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)).setText("视觉+声音报警");
                            break;
                        } else {
                            ((TextView) Acrivity_RZC_17CRVSettings.this.findViewById(R.id.tv_text23)).setText("视觉报警");
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
        if (DataCanbus.DATA[1000] == 3277098 || DataCanbus.DATA[1000] == 2097450 || DataCanbus.DATA[1000] == 2556202 || DataCanbus.DATA[1000] == 2490666) {
            setViewState(findViewById(R.id.layout_view1), 0);
        } else {
            setViewState(findViewById(R.id.layout_view1), 8);
        }
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
                        DataCanbus.PROXY.cmd(105, new int[]{i}, null, null);
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
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[74];
                int value2 = (value - 1) % 3;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(18, value2);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value3 = DataCanbus.DATA[74];
                setCarInfo(18, (value3 + 1) % 3);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value4 = DataCanbus.DATA[77];
                setCarInfo(21, value4 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value5 = DataCanbus.DATA[77];
                setCarInfo(21, value5 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value6 = DataCanbus.DATA[81];
                setCarInfo(30, value6 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value7 = DataCanbus.DATA[81];
                setCarInfo(30, value7 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value8 = DataCanbus.DATA[173] == 0 ? 1 : 0;
                setCarInfo(52, value8);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value9 = DataCanbus.DATA[60];
                int value10 = (value9 - 1) % 11;
                if (value10 < 0) {
                    value10 = 10;
                }
                setCarInfo(0, value10);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value11 = DataCanbus.DATA[60];
                setCarInfo(0, (value11 + 1) % 11);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value12 = DataCanbus.DATA[58];
                int value13 = (value12 - 1) % 3;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(2, value13);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value14 = DataCanbus.DATA[58];
                setCarInfo(2, (value14 + 1) % 3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value15 = DataCanbus.DATA[59];
                int value16 = (value15 - 1) % 3;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(3, value16);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value17 = DataCanbus.DATA[59];
                setCarInfo(3, (value17 + 1) % 3);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value18 = DataCanbus.DATA[63];
                int value19 = (value18 - 1) % 3;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(4, value19);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value20 = DataCanbus.DATA[63];
                setCarInfo(4, (value20 + 1) % 3);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value21 = DataCanbus.DATA[62];
                int value22 = (value21 - 1) % 4;
                if (value22 < 0) {
                    value22 = 3;
                }
                setCarInfo(5, value22);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value23 = DataCanbus.DATA[62];
                setCarInfo(5, (value23 + 1) % 4);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value24 = DataCanbus.DATA[61];
                int value25 = (value24 - 1) % 5;
                if (value25 < 0) {
                    value25 = 4;
                }
                setCarInfo(6, value25);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value26 = DataCanbus.DATA[61];
                setCarInfo(6, (value26 + 1) % 5);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value27 = DataCanbus.DATA[65];
                setCarInfo(9, value27 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value28 = DataCanbus.DATA[65];
                setCarInfo(9, value28 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value29 = DataCanbus.DATA[66];
                int value30 = (value29 - 1) % 3;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo(11, value30);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value31 = DataCanbus.DATA[66];
                setCarInfo(11, (value31 + 1) % 3);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value32 = DataCanbus.DATA[67];
                int value33 = (value32 - 1) % 4;
                if (value33 < 0) {
                    value33 = 3;
                }
                setCarInfo(8, value33);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value34 = DataCanbus.DATA[67];
                setCarInfo(8, (value34 + 1) % 4);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value35 = DataCanbus.DATA[68];
                int value36 = (value35 - 1) % 3;
                if (value36 < 0) {
                    value36 = 2;
                }
                setCarInfo(7, value36);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value37 = DataCanbus.DATA[68];
                setCarInfo(7, (value37 + 1) % 3);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value38 = DataCanbus.DATA[71];
                setCarInfo(25, value38 != 0 ? 0 : 1);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value39 = DataCanbus.DATA[71];
                setCarInfo(25, value39 != 0 ? 0 : 1);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value40 = DataCanbus.DATA[73];
                int value41 = (value40 - 1) % 5;
                if (value41 < 0) {
                    value41 = 4;
                }
                setCarInfo(27, value41);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value42 = DataCanbus.DATA[73];
                setCarInfo(27, (value42 + 1) % 5);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value43 = DataCanbus.DATA[64];
                setCarInfo(10, value43 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value44 = DataCanbus.DATA[69];
                setCarInfo(13, value44 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value45 = DataCanbus.DATA[70];
                setCarInfo(24, value45 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value46 = DataCanbus.DATA[72];
                setCarInfo(26, value46 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value47 = DataCanbus.DATA[75];
                setCarInfo(19, value47 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value48 = DataCanbus.DATA[76];
                setCarInfo(20, value48 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value49 = DataCanbus.DATA[78];
                setCarInfo(22, value49 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value50 = DataCanbus.DATA[79];
                setCarInfo(23, value50 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value51 = DataCanbus.DATA[80];
                setCarInfo(28, value51 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value52 = DataCanbus.DATA[82];
                setCarInfo(29, value52 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value53 = DataCanbus.DATA[83];
                setCarInfo(32, value53 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value54 = DataCanbus.DATA[84];
                setCarInfo(33, value54 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value55 = DataCanbus.DATA[87];
                setCarInfo(35, value55 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value56 = DataCanbus.DATA[111] == 0 ? 1 : 0;
                setCarInfo(38, value56);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value57 = DataCanbus.DATA[151] == 0 ? 1 : 0;
                setCarInfo(39, value57);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value58 = DataCanbus.DATA[152] == 0 ? 1 : 0;
                setCarInfo(40, value58);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value59 = DataCanbus.DATA[153] == 0 ? 1 : 0;
                setCarInfo(41, value59);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value60 = DataCanbus.DATA[154] == 0 ? 1 : 0;
                setCarInfo(42, value60);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value61 = DataCanbus.DATA[155] == 0 ? 1 : 0;
                setCarInfo(43, value61);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value62 = DataCanbus.DATA[156] == 0 ? 1 : 0;
                setCarInfo(44, value62);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value63 = DataCanbus.DATA[157] == 0 ? 1 : 0;
                setCarInfo(45, value63);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                int value64 = DataCanbus.DATA[159] == 0 ? 1 : 0;
                setCarInfo(47, value64);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                int value65 = DataCanbus.DATA[161] == 0 ? 1 : 0;
                setCarInfo(49, value65);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                int value66 = DataCanbus.DATA[109] == 0 ? 1 : 0;
                setCarInfo(50, value66);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                setCarInfo(48, 0);
                break;
            case R.id.ctv_checkedtext32 /* 2131427876 */:
                int value67 = DataCanbus.DATA[178] == 0 ? 1 : 0;
                setCarInfo(72, value67);
                break;
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                int value68 = DataCanbus.DATA[175] == 0 ? 1 : 0;
                setCarInfo(74, value68);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value69 = DataCanbus.DATA[114];
                int value70 = value69 - 1;
                if (value70 < 0) {
                    value70 = 2;
                }
                setCarInfo(36, value70);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value71 = DataCanbus.DATA[114];
                setCarInfo(36, (value71 + 1) % 3);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value72 = DataCanbus.DATA[110] == 0 ? 1 : 0;
                setCarInfo(37, value72);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value73 = DataCanbus.DATA[110] == 0 ? 1 : 0;
                setCarInfo(37, value73);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value74 = DataCanbus.DATA[179] == 0 ? 1 : 0;
                setCarInfo(73, value74);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value75 = DataCanbus.DATA[179] == 0 ? 1 : 0;
                setCarInfo(73, value75);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value76 = DataCanbus.DATA[193];
                int value77 = value76 - 1;
                if (value77 < 0) {
                    value77 = 3;
                }
                setCarInfo(79, value77);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value78 = DataCanbus.DATA[193];
                int value79 = value78 + 1;
                if (value79 > 3) {
                    value79 = 0;
                }
                setCarInfo(79, value79);
                break;
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                int value80 = DataCanbus.DATA[190] == 0 ? 1 : 0;
                setCarInfo(81, value80);
                break;
            case R.id.ctv_checkedtext31 /* 2131427887 */:
                int value81 = DataCanbus.DATA[176] == 0 ? 1 : 0;
                setCarInfo(70, value81);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value82 = DataCanbus.DATA[85];
                int value83 = (value82 - 1) % 3;
                if (value83 < 0) {
                    value83 = 2;
                }
                setCarInfo(31, value83);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value84 = DataCanbus.DATA[85];
                setCarInfo(31, (value84 + 1) % 3);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value85 = DataCanbus.DATA[86];
                int value86 = (value85 - 1) % 3;
                if (value86 < 0) {
                    value86 = 2;
                }
                setCarInfo(34, value86);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value87 = DataCanbus.DATA[86];
                setCarInfo(34, (value87 + 1) % 3);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                int value88 = DataCanbus.DATA[166] == 0 ? 1 : 0;
                setCarInfo(51, value88);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value89 = DataCanbus.DATA[158] == 0 ? 1 : 0;
                setCarInfo(46, value89);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value90 = DataCanbus.DATA[158] == 0 ? 1 : 0;
                setCarInfo(46, value90);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
            case R.id.btn_minus24 /* 2131428319 */:
                int value91 = DataCanbus.DATA[177] == 0 ? 1 : 0;
                setCarInfo(71, value91);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value92 = DataCanbus.DATA[197];
                int value93 = value92 + 1;
                if (value93 > 1) {
                    value93 = 0;
                }
                setCarInfo(82, value93);
                break;
            case R.id.ctv_checkedtext33 /* 2131428103 */:
                int value94 = DataCanbus.DATA[191] == 0 ? 1 : 0;
                setCarInfo(75, value94);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value95 = DataCanbus.DATA[197];
                int value96 = value95 - 1;
                if (value96 < 0) {
                    value96 = 1;
                }
                setCarInfo(82, value96);
                break;
            case R.id.ctv_checkedtext42 /* 2131428355 */:
                dialog(R.string.str_298_reset_maintenance, 14);
                break;
            case R.id.ctv_checkedtext43 /* 2131428356 */:
                dialog(R.string.str_298_default_all, 15);
                break;
            case R.id.ctv_checkedtext44 /* 2131428361 */:
                dialog(R.string.str_298_tpms_cal, 17);
                break;
            case R.id.ctv_checkedtext45 /* 2131428362 */:
                try {
                    Intent ii = new Intent();
                    ii.setClass(this, ActiAMP_Bnr.class);
                    startActivity(ii);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext34 /* 2131428383 */:
                int value97 = DataCanbus.DATA[192] == 0 ? 1 : 0;
                setCarInfo(76, value97);
                break;
            case R.id.ctv_checkedtext35 /* 2131428385 */:
                int value98 = DataCanbus.DATA[194] == 0 ? 1 : 0;
                setCarInfo(77, value98);
                break;
            case R.id.ctv_checkedtext36 /* 2131428387 */:
                int value99 = DataCanbus.DATA[195] == 0 ? 1 : 0;
                setCarInfo(78, value99);
                break;
            case R.id.ctv_checkedtext37 /* 2131428390 */:
                int value100 = DataCanbus.DATA[196] == 0 ? 1 : 0;
                setCarInfo(97, value100);
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
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
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
        int value = DataCanbus.DATA[58];
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
                        ((TextView) findViewById(R.id.tv_text2)).setText("与充电中联动");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_refuel);
                        break;
                    }
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
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
        }
    }

    protected void updateEleDoorRemoteOpenCondition() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.tv_text19)) != null) {
            ((TextView) findViewById(R.id.tv_text19)).setText(value == 0 ? R.string.str_guandao_remote_open1 : R.string.str_guandao_remote_open2);
        }
    }

    protected void updateBackCarBeepTone() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripB() {
        int value = DataCanbus.DATA[59];
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
                        ((TextView) findViewById(R.id.tv_text3)).setText("与充电中联动");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_298_refuel);
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutTemp() {
        int value = DataCanbus.DATA[60];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLightSens() {
        int value = DataCanbus.DATA[61];
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
        int value = DataCanbus.DATA[62];
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
        int value = DataCanbus.DATA[63];
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
        int value = DataCanbus.DATA[64];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyAndRemoteUnlockMode() {
        int value = DataCanbus.DATA[65];
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
        int value = DataCanbus.DATA[66];
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
        int value = DataCanbus.DATA[67];
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
        int value = DataCanbus.DATA[68];
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
        int value = DataCanbus.DATA[69];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteStartSys() {
        int value = DataCanbus.DATA[70];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlockMode() {
        int value = DataCanbus.DATA[71];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeylessAccessLightFlash() {
        int value = DataCanbus.DATA[72];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoInterIllumination() {
        int value = DataCanbus.DATA[73];
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
        int value = DataCanbus.DATA[74];
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
        int value = DataCanbus.DATA[75];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewMsgNoti() {
        int value = DataCanbus.DATA[76];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedDistanceUnit() {
        int value = DataCanbus.DATA[77];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text14)).setText("km/h  km");
        } else {
            ((TextView) findViewById(R.id.tv_text14)).setText("mph  miles");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTachometer() {
        int value = DataCanbus.DATA[78];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWalkAwayAutoLock() {
        int value = DataCanbus.DATA[79];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoHeadlightWiper() {
        int value = DataCanbus.DATA[80];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolumeAlarmSys() {
        int value = DataCanbus.DATA[81];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text15)).setText("low");
        } else {
            ((TextView) findViewById(R.id.tv_text15)).setText("high");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergySaveAutoEnghine() {
        int value = DataCanbus.DATA[82];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccDiscoveryVehicle() {
        int value = DataCanbus.DATA[83];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePauseLKADTone() {
        int value = DataCanbus.DATA[84];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
    }

    protected void updateSetFrontHazardDistance() {
        int value = DataCanbus.DATA[85];
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
        int value = DataCanbus.DATA[86];
        if (((TextView) findViewById(R.id.tv_text17)) != null) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTachometerSet() {
        int value = DataCanbus.DATA[87];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
    }
}
