package com.syu.carinfo.rzc.qirui;

import android.app.Activity;
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
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityQiRuiAiRuiZe extends Activity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ActivityQiRuiAiRuiZe.this.updateLauguageSet();
                    break;
                case 99:
                    if (DataCanbus.DATA[1000] == 2687380 || DataCanbus.DATA[1000] == 3080596 || DataCanbus.DATA[1000] == 3146132) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text14)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            case 1:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text14)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    } else {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text14)).setText(R.string.dj_airuize7_prompt_sounds);
                                break;
                            case 1:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text14)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            case 2:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text14)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext15)).setChecked((value & 255) == 1);
                    }
                    break;
                case 101:
                    ActivityQiRuiAiRuiZe.this.updateAutoLock(value);
                    break;
                case 102:
                    ActivityQiRuiAiRuiZe.this.updateBiglightSleep(value);
                    break;
                case 103:
                    ActivityQiRuiAiRuiZe.this.updateDayLight(value);
                    break;
                case 104:
                    ActivityQiRuiAiRuiZe.this.updateSteeringAvm(value);
                    break;
                case 105:
                    ActivityQiRuiAiRuiZe.this.updateSteeringAnim(value);
                    break;
                case 106:
                    ActivityQiRuiAiRuiZe.this.updateVehicleGuides(value);
                    break;
                case 107:
                    ActivityQiRuiAiRuiZe.this.updateSpeedAlarm(value);
                    break;
                case 108:
                    ActivityQiRuiAiRuiZe.this.updateDashBoardBacklight(value);
                    break;
                case 109:
                    ActivityQiRuiAiRuiZe.this.updateSteeringAuxiliaryLighting(value);
                    break;
                case 110:
                    ActivityQiRuiAiRuiZe.this.updateAutoUnLock(value);
                    break;
                case 111:
                    ActivityQiRuiAiRuiZe.this.updateOnlyRemoteOpenBackDoor(value);
                    break;
                case 113:
                    ActivityQiRuiAiRuiZe.this.updateBlindSide(value);
                    break;
                case 114:
                    ActivityQiRuiAiRuiZe.this.updateAwayRoad(value);
                    break;
                case 115:
                    ActivityQiRuiAiRuiZe.this.updateRearviewAuto(value);
                    break;
                case 116:
                    ActivityQiRuiAiRuiZe.this.updateGestureKnow(value);
                    break;
                case 117:
                    ActivityQiRuiAiRuiZe.this.updateGestureSkyLight(value);
                    break;
                case 118:
                    ActivityQiRuiAiRuiZe.this.updateHomeLight(value);
                    break;
                case 119:
                    ActivityQiRuiAiRuiZe.this.updateChangeWayLight(value);
                    break;
                case 120:
                    ActivityQiRuiAiRuiZe.this.updateWelcomeLight(value);
                    break;
                case 121:
                    ActivityQiRuiAiRuiZe.this.updateEPSsyeterm(value);
                    break;
                case 122:
                    ActivityQiRuiAiRuiZe.this.updateAmbientLight(value);
                    break;
                case 123:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 124:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 125:
                    if (value == 0) {
                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                    } else {
                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 126:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)).setChecked((value & 255) == 1);
                    }
                    break;
                case 127:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext6)).setChecked((value & 255) == 1);
                    }
                    break;
                case 128:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) == 1);
                    }
                    break;
                case 129:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) == 1);
                    }
                    break;
                case 130:
                    ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                            break;
                        case 2:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_1);
                            break;
                        case 3:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_7);
                            break;
                        case 4:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_4);
                            break;
                        case 5:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_0);
                            break;
                        case 6:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                            break;
                        case 7:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_6);
                            break;
                    }
                    break;
                case 132:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext7)).setChecked((value & 255) == 1);
                    }
                    break;
                case 133:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_sports);
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                            break;
                    }
                    break;
                case 134:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext8)).setChecked((value & 255) == 1);
                    }
                    break;
                case 135:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext9)).setChecked((value & 255) == 1);
                    }
                    break;
                case 136:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text5)).setText(R.string.carema_type_1);
                            break;
                        case 3:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                        case 4:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                    }
                    break;
                case 137:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text6)).setText(R.string.MAX);
                            break;
                        case 2:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text6)).setText(R.string.carema_type_1);
                            break;
                        case 3:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text6)).setText(R.string.MIN);
                            break;
                    }
                    break;
                case 138:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext10)).setChecked((value & 255) == 1);
                    }
                    break;
                case 139:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext11)).setChecked((value & 255) == 1);
                    }
                    break;
                case 140:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext12)).setChecked((value & 255) == 1);
                    }
                    break;
                case 141:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                            break;
                        default:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                            break;
                    }
                    break;
                case 142:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext13)).setChecked((value & 255) == 1);
                    }
                    break;
                case 151:
                    if (((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)) != null) {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_RZC_XP1_23Ruihu_KaiyiX3 /* 3539348 */:
                                switch (value) {
                                    case 1:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText(R.string.off);
                                        break;
                                    case 2:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("1小时");
                                        break;
                                    case 3:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("1.5小时");
                                        break;
                                    case 4:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("2小时");
                                        break;
                                    case 5:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("2.5小时");
                                        break;
                                    case 6:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("3小时");
                                        break;
                                    case 7:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("3.5小时");
                                        break;
                                    case 8:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("4小时");
                                        break;
                                }
                                break;
                            default:
                                switch (value) {
                                    case 0:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText(R.string.off);
                                        break;
                                    case 1:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("1小时");
                                        break;
                                    case 2:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("1.5小时");
                                        break;
                                    case 3:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("2小时");
                                        break;
                                    case 4:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("2.5小时");
                                        break;
                                    case 5:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("3小时");
                                        break;
                                    case 6:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("3.5小时");
                                        break;
                                    case 7:
                                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("4小时");
                                        break;
                                }
                                break;
                        }
                    }
                    break;
                case 154:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext33)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext33)).setChecked((value & 255) == 1);
                    }
                    break;
                case 155:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext32)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext32)).setChecked((value & 255) == 1);
                    }
                    break;
                case 156:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text15)).setText(R.string.wc_372_high);
                            break;
                        default:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text15)).setText(R.string.wc_372_low);
                            break;
                    }
                    break;
                case 157:
                    if (((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext34)) != null) {
                        ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext34)).setChecked((value & 255) == 1);
                    }
                    break;
                case 158:
                    if (DataCanbus.DATA[1000] == 2687380 || DataCanbus.DATA[1000] == 3080596 || DataCanbus.DATA[1000] == 3146132) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("1小时");
                                break;
                            case 2:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("1.5小时");
                                break;
                            case 3:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("2小时");
                                break;
                            case 4:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("2.5小时");
                                break;
                            case 5:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("3小时");
                                break;
                            case 6:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("3.5小时");
                                break;
                            case 7:
                                ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text21)).setText("4小时");
                                break;
                        }
                    } else {
                        ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                    break;
                case 159:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext35)).setChecked((value & 255) == 1);
                    break;
                case 160:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext36)).setChecked((value & 255) == 1);
                    break;
                case 161:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext37)).setChecked((value & 255) == 1);
                    break;
                case 162:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext38)).setChecked((value & 255) == 1);
                    break;
                case 163:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext40)).setChecked((value & 255) == 1);
                    break;
                case 164:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext41)).setChecked((value & 255) == 1);
                    break;
                case 166:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext39)).setChecked((value & 255) == 1);
                    break;
                case 167:
                    ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value) + "s");
                    break;
                case 168:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext42)).setChecked((value & 255) == 1);
                    break;
                case 169:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext43)).setChecked((value & 255) == 1);
                    break;
                case 170:
                    ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text18)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 171:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext44)).setChecked((value & 255) == 1);
                    break;
                case 172:
                    ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text19)).setText(String.valueOf((value * 5) + 25) + "km/h");
                    break;
                case 173:
                    ((CheckedTextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.ctv_checkedtext45)).setChecked((value & 255) == 1);
                    break;
                case 174:
                    ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text20)).setText(String.valueOf((value * 5) + 30) + "cm");
                    break;
                case 196:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text22)).setText("Reset triggered");
                            break;
                        case 2:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text22)).setText("Resetting");
                            break;
                        case 3:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text22)).setText("Reset Fail");
                            break;
                        case 4:
                            ((TextView) ActivityQiRuiAiRuiZe.this.findViewById(R.id.tv_text22)).setText("Reset Complete");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_404_qiruiairuize);
        setListener();
    }

    private void initLauStyle() {
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ActivityQiRuiAiRuiZe.this.language_set = position;
                if (ActivityQiRuiAiRuiZe.this.language_set >= 0 && ActivityQiRuiAiRuiZe.this.language_set <= ActivityQiRuiAiRuiZe.this.mLauStylelist.size() && ActivityQiRuiAiRuiZe.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{0, ActivityQiRuiAiRuiZe.this.send_lang[ActivityQiRuiAiRuiZe.this.language_set]}, null, null);
                }
                ActivityQiRuiAiRuiZe.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[98];
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

    private void setListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.send_lang = new int[]{0, 1, 3};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext45)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext46)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext47)).setOnClickListener(this);
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
    }

    @Override // android.app.Activity
    protected void onResume() {
        InitVisible();
        super.onResume();
        for (int i = 1; i < 56; i++) {
            if (i % 5 == 0) {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DataCanbus.PROXY.cmd(3, new int[]{64, i}, null, null);
        }
        DataCanbus.PROXY.cmd(3, 65, 0);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void InitVisible() {
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view66).setVisibility(8);
        findViewById(R.id.layout_view68).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
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
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view67).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_text_view7).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view63).setVisibility(8);
        findViewById(R.id.layout_view64).setVisibility(8);
        findViewById(R.id.layout_view65).setVisibility(8);
        findViewById(R.id.layout_text_view8).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_text_view9).setVisibility(0);
        findViewById(R.id.layout_view49).setVisibility(0);
        findViewById(R.id.layout_view44).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case 404:
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_QiRuiAiRuiZe7 /* 197012 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX /* 262548 */:
            case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5 /* 590228 */:
            case FinalCanbus.CAR_OD_RZC_23QiRuiAiRuiZeE /* 2359700 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX_H /* 328084 */:
            case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5_H /* 655764 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X /* 393620 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X_H /* 459156 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18JieTU_X70 /* 524692 */:
            case FinalCanbus.CAR_RZC_XP1_18JieTU_X70_H /* 1311124 */:
            case FinalCanbus.CAR_RZC_OD_18JieTU_X70 /* 1900948 */:
            case FinalCanbus.CAR_RZC_OD_18JieTU_X70_H /* 2752916 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7 /* 721300 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8 /* 852372 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                if (DataCanbus.DATA[1000] == 852372) {
                    findViewById(R.id.layout_view3).setVisibility(0);
                    findViewById(R.id.layout_view31).setVisibility(0);
                }
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                if (DataCanbus.DATA[1000] == 852372) {
                    findViewById(R.id.layout_view1).setVisibility(0);
                    findViewById(R.id.layout_view2).setVisibility(0);
                }
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7_H /* 786836 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8_H /* 917908 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                if (DataCanbus.DATA[1000] == 917908) {
                    findViewById(R.id.layout_view3).setVisibility(0);
                    findViewById(R.id.layout_view31).setVisibility(0);
                }
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                if (DataCanbus.DATA[1000] == 917908) {
                    findViewById(R.id.layout_text_view8).setVisibility(0);
                    findViewById(R.id.layout_view1).setVisibility(0);
                    findViewById(R.id.layout_view2).setVisibility(0);
                }
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu7 /* 1048980 */:
            case FinalCanbus.CAR_RZC_XP1_21DR_F35 /* 2556308 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu3x /* 1114516 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_15QiRuiRuiHu5 /* 1245588 */:
                findViewById(R.id.layout_view20).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
            case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
            case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_5X /* 2294164 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X_Inter /* 3408276 */:
            case FinalCanbus.CAR_RZC_XP1_24Ruihu_5X /* 3473812 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
            case FinalCanbus.CAR_RZC_LUZ_QiRuiRuiHu5 /* 3604884 */:
                if (DataCanbus.DATA[1000] == 3604884) {
                    findViewById(R.id.layout_view66).setVisibility(0);
                } else {
                    findViewById(R.id.layout_view66).setVisibility(8);
                }
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(8);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_19X90 /* 1835412 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
                findViewById(R.id.layout_view68).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
            case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5 /* 2425236 */:
            case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5_EV /* 2490772 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_view60).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                break;
            case FinalCanbus.CAR_OD_RZC_20Showjet /* 2687380 */:
            case FinalCanbus.CAR_OD_RZC_24Showjet_Pro /* 3080596 */:
            case FinalCanbus.CAR_OD_RZC_25Kaiyi_X3Pro /* 3146132 */:
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_OD_19JieTU_X90 /* 2818452 */:
            case FinalCanbus.CAR_RZC_OD_19JieTU_X90_H /* 2883988 */:
            case FinalCanbus.CAR_RZC_OD_21AiRuiZe5_Plus /* 3277204 */:
            case FinalCanbus.CAR_RZC_OD_21AiRuiZe5_Plus_H /* 3342740 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_KaiyiX3 /* 3539348 */:
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view67).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_text_view9).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = (DataCanbus.DATA[125] & 255) - 1;
                if (value < 50) {
                    value = 50;
                }
                setCarInfoState(27, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[125] & 255) + 1;
                if (value2 > 100) {
                    value2 = 100;
                }
                setCarInfoState(27, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = (DataCanbus.DATA[131] & 255) - 1;
                if (value3 < 1) {
                    value3 = 7;
                }
                setCarInfoState(33, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = (DataCanbus.DATA[131] & 255) + 1;
                if (value4 > 7) {
                    value4 = 1;
                }
                setCarInfoState(33, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = (DataCanbus.DATA[130] & 255) - 1;
                if (value5 < 1) {
                    value5 = 1;
                }
                setCarInfoState(32, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = (DataCanbus.DATA[130] & 255) + 1;
                if (value6 > 5) {
                    value6 = 5;
                }
                setCarInfoState(32, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = (DataCanbus.DATA[133] & 255) - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfoState(35, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = (DataCanbus.DATA[133] & 255) + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfoState(35, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = (DataCanbus.DATA[136] & 255) - 1;
                if (value9 < 1) {
                    value9 = 4;
                }
                setCarInfoState(38, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = (DataCanbus.DATA[136] & 255) + 1;
                if (value10 > 4) {
                    value10 = 1;
                }
                setCarInfoState(38, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = (DataCanbus.DATA[137] & 255) - 1;
                if (value11 < 1) {
                    value11 = 3;
                }
                setCarInfoState(39, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = (DataCanbus.DATA[137] & 255) + 1;
                if (value12 > 3) {
                    value12 = 1;
                }
                setCarInfoState(39, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = (DataCanbus.DATA[141] & 255) - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfoState(253, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = (DataCanbus.DATA[141] & 255) + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfoState(253, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = (DataCanbus.DATA[118] & 255) - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfoState(20, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = (DataCanbus.DATA[118] & 255) + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfoState(20, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = (DataCanbus.DATA[119] & 255) - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfoState(21, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = (DataCanbus.DATA[119] & 255) + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfoState(21, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = (DataCanbus.DATA[121] & 255) - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfoState(23, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = (DataCanbus.DATA[121] & 255) + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfoState(23, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = (DataCanbus.DATA[106] & 255) - 1;
                if (value21 < 0) {
                    value21 = 0;
                }
                setCarInfoState(8, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = (DataCanbus.DATA[106] & 255) + 1;
                if (value22 > 2) {
                    value22 = 2;
                }
                setCarInfoState(8, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = (DataCanbus.DATA[107] & 255) - 1;
                if (value23 < 0) {
                    value23 = 0;
                }
                setCarInfoState(9, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = (DataCanbus.DATA[107] & 255) + 1;
                if (value24 > 21) {
                    value24 = 21;
                }
                setCarInfoState(9, value24);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = (DataCanbus.DATA[108] & 255) - 1;
                if (value25 < 1) {
                    value25 = 1;
                }
                setCarInfoState(10, value25);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = (DataCanbus.DATA[108] & 255) + 1;
                if (value26 > 10) {
                    value26 = 10;
                }
                setCarInfoState(10, value26);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value27 = DataCanbus.DATA[99] - 1;
                if (DataCanbus.DATA[1000] == 2687380 || DataCanbus.DATA[1000] == 3080596 || DataCanbus.DATA[1000] == 3146132) {
                    if (value27 < 0) {
                        value27 = 1;
                    }
                } else if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfoState(1, value27);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value28 = DataCanbus.DATA[99] + 1;
                if (DataCanbus.DATA[1000] == 2687380 || DataCanbus.DATA[1000] == 3080596 || DataCanbus.DATA[1000] == 3146132) {
                    if (value28 > 1) {
                        value28 = 0;
                    }
                } else if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfoState(1, value28);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value29 = DataCanbus.DATA[156] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfoState(50, value29);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value30 = DataCanbus.DATA[156] + 1;
                if (value30 > 1) {
                    value30 = 0;
                }
                setCarInfoState(50, value30);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value31 = DataCanbus.DATA[158] - 1;
                if (DataCanbus.DATA[1000] == 2687380 || DataCanbus.DATA[1000] == 3080596 || DataCanbus.DATA[1000] == 3146132) {
                    if (value31 < 0) {
                        value31 = 7;
                    }
                } else if (value31 < 0) {
                    value31 = 3;
                }
                setCarInfoState(43, value31);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value32 = DataCanbus.DATA[158] + 1;
                if (DataCanbus.DATA[1000] == 2687380 || DataCanbus.DATA[1000] == 3080596 || DataCanbus.DATA[1000] == 3146132) {
                    if (value32 > 7) {
                        value32 = 0;
                    }
                } else if (value32 > 3) {
                    value32 = 0;
                }
                setCarInfoState(43, value32);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value33 = DataCanbus.DATA[167] - 1;
                if (value33 < 1) {
                    value33 = 1;
                }
                setCarInfoState(49, value33);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value34 = DataCanbus.DATA[167] + 1;
                if (value34 > 10) {
                    value34 = 10;
                }
                setCarInfoState(49, value34);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value35 = DataCanbus.DATA[170] - 1;
                if (value35 < 1) {
                    value35 = 1;
                }
                setCarInfoState(52, value35);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value36 = DataCanbus.DATA[170] + 1;
                if (value36 > 5) {
                    value36 = 5;
                }
                setCarInfoState(52, value36);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfoState(25, DataCanbus.DATA[123] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfoState(31, DataCanbus.DATA[129] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfoState(28, DataCanbus.DATA[126] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfoState(26, DataCanbus.DATA[124] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfoState(30, DataCanbus.DATA[128] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfoState(29, DataCanbus.DATA[127] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfoState(34, DataCanbus.DATA[132] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value37 = DataCanbus.DATA[172] - 1;
                if (value37 < 1) {
                    value37 = 1;
                }
                setCarInfoState(54, value37);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value38 = DataCanbus.DATA[172] + 1;
                if (value38 > 19) {
                    value38 = 19;
                }
                setCarInfoState(54, value38);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value39 = DataCanbus.DATA[174] - 1;
                if (value39 < 1) {
                    value39 = 1;
                }
                setCarInfoState(56, value39);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value40 = DataCanbus.DATA[174] + 1;
                if (value40 > 6) {
                    value40 = 6;
                }
                setCarInfoState(56, value40);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_23Ruihu_KaiyiX3 /* 3539348 */:
                        int value41 = DataCanbus.DATA[151] - 1;
                        if (value41 < 1) {
                            value41 = 8;
                        }
                        setCarInfoState(58, value41);
                        break;
                }
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_23Ruihu_KaiyiX3 /* 3539348 */:
                        int value42 = DataCanbus.DATA[151] + 1;
                        if (value42 > 8) {
                            value42 = 1;
                        }
                        setCarInfoState(58, value42);
                        break;
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfoState(36, DataCanbus.DATA[134] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfoState(37, DataCanbus.DATA[135] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfoState(40, DataCanbus.DATA[138] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfoState(41, DataCanbus.DATA[139] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfoState(42, DataCanbus.DATA[140] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfoState(255, DataCanbus.DATA[142] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                if (this.mLauStyle == null) {
                    initLauStyle();
                }
                if (this.mLauStyle != null && this.mPopShowView != null) {
                    this.mLauStyle.showAtLocation(this.mPopShowView, 17, 0, 0);
                    updateLauguageSet();
                    break;
                }
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfoState(2, (DataCanbus.DATA[100] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfoState(3, (DataCanbus.DATA[101] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfoState(4, (DataCanbus.DATA[102] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfoState(5, (DataCanbus.DATA[103] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCarInfoState(6, (DataCanbus.DATA[104] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                setCarInfoState(7, (DataCanbus.DATA[105] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                setCarInfoState(11, DataCanbus.DATA[109] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                setCarInfoState(12, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                setCarInfoState(13, DataCanbus.DATA[111] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                setCarInfoState(15, DataCanbus.DATA[113] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                setCarInfoState(16, DataCanbus.DATA[114] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                setCarInfoState(17, DataCanbus.DATA[115] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                setCarInfoState(18, DataCanbus.DATA[116] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                setCarInfoState(19, DataCanbus.DATA[117] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                dialog(R.string.all_settings, 254);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                setCarInfoState(22, DataCanbus.DATA[120] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                setCarInfoState(24, DataCanbus.DATA[122] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                setCarInfoState(49, DataCanbus.DATA[155] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                setCarInfoState(48, DataCanbus.DATA[154] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                setCarInfoState(51, DataCanbus.DATA[157] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                setCarInfoState(44, DataCanbus.DATA[159] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext36 /* 2131427844 */:
                setCarInfoState(45, DataCanbus.DATA[160] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext37 /* 2131427855 */:
                setCarInfoState(44, DataCanbus.DATA[161] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext38 /* 2131427856 */:
                setCarInfoState(44, DataCanbus.DATA[162] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext39 /* 2131427857 */:
                setCarInfoState(48, DataCanbus.DATA[166] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext40 /* 2131427858 */:
                setCarInfoState(52, DataCanbus.DATA[163] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext41 /* 2131427859 */:
                setCarInfoState(53, DataCanbus.DATA[164] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext42 /* 2131427860 */:
                setCarInfoState(50, DataCanbus.DATA[168] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext43 /* 2131427861 */:
                setCarInfoState(51, DataCanbus.DATA[169] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext44 /* 2131427875 */:
                setCarInfoState(53, DataCanbus.DATA[171] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext45 /* 2131427876 */:
                setCarInfoState(55, DataCanbus.DATA[173] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext46 /* 2131427877 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZQiruiDiandongweimenSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext47 /* 2131427878 */:
                dialog(R.string.xp_yinglang_car_set_Second_str10, 57);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, value1, value2);
    }

    private void setCarInfoState(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, value1, value2);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }

    protected void updateAmbientLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext31)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext31)).setChecked(value != 0);
        }
    }

    protected void updateEPSsyeterm(int value2) {
        switch (value2) {
            case 0:
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.driver_system_sports);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                break;
        }
    }

    protected void updateWelcomeLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext30)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext30)).setChecked(value != 0);
        }
    }

    protected void updateChangeWayLight(int value2) {
        switch (value2) {
            case 0:
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_three_times);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_five_times);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_seven_times);
                break;
        }
    }

    protected void updateHomeLight(int value2) {
        switch (value2) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
        }
    }

    protected void updateGestureSkyLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext28)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setChecked(value != 0);
        }
    }

    protected void updateGestureKnow(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext27)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setChecked(value != 0);
        }
    }

    protected void updateRearviewAuto(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
        }
    }

    protected void updateAwayRoad(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext25)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setChecked(value != 0);
        }
    }

    protected void updateBlindSide(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext24)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
        }
    }

    protected void updateSteeringAuxiliaryLighting(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext21)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setChecked(value != 0);
        }
    }

    protected void updateAutoUnLock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
        }
    }

    protected void updateOnlyRemoteOpenBackDoor(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
        }
    }

    protected void updateAutoLock(int value2) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateBiglightSleep(int value2) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateDayLight(int value2) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateSteeringAvm(int value2) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext19)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateSteeringAnim(int value2) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateVehicleGuides(int value2) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value2 & 255) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_395_static_state);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_395_static_and_dynamic);
                    break;
            }
        }
    }

    protected void updateSpeedAlarm(int value2) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            int value = value2 & 255;
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.tv_text12)).setText(new StringBuilder().append((value * 5) + 25).toString());
            }
        }
    }

    protected void updateDashBoardBacklight(int value2) {
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            int value = value2 & 255;
            if (value > 10) {
                value = 10;
            } else if (value <= 0) {
                value = 0;
            }
            ((TextView) findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
        }
    }
}
