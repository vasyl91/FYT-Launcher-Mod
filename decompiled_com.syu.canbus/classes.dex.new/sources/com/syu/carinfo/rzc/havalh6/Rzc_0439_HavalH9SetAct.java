package com.syu.carinfo.rzc.havalh6;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Rzc_0439_HavalH9SetAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    Rzc_0439_HavalH9SetAct.this.updateDomeDelay();
                    break;
                case 102:
                    Rzc_0439_HavalH9SetAct.this.updateFollowHome();
                    break;
                case 103:
                    Rzc_0439_HavalH9SetAct.this.updatePowerSave();
                    break;
                case 104:
                    Rzc_0439_HavalH9SetAct.this.updateRainFall();
                    break;
                case 105:
                    Rzc_0439_HavalH9SetAct.this.updateRearViewAuto();
                    break;
                case 106:
                    Rzc_0439_HavalH9SetAct.this.updateFrontLight();
                    break;
                case 107:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterSeatmemory();
                    break;
                case 108:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterParkset();
                    break;
                case 109:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterAntisheftset();
                    break;
                case 110:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterDoorlockset();
                    break;
                case 111:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterCetaset();
                    break;
                case 112:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterCartopset();
                    break;
                case 113:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterAllterrainset();
                    break;
                case 115:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterValue8();
                    break;
                case 129:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterCollisionWarn();
                    break;
                case 130:
                    Rzc_0439_HavalH9SetAct.this.mUpdaterAutoBrake();
                    break;
                case 152:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 154:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
                case 155:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 156:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_middle);
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 157:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    break;
                case 158:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    break;
                case 159:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    break;
                case 160:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 161:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    break;
                case 162:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 1);
                    break;
                case 163:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 164:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 165:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
                case 166:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 1);
                    break;
                case 167:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value == 1);
                    break;
                case 168:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value == 1);
                    break;
                case 169:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text12)) != null) {
                        if (value < 10) {
                            ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text12)).setText("-" + (10 - value) + "km");
                        } else if (value > 10) {
                            ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text12)).setText("+" + (value - 10) + "km");
                        } else {
                            ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text12)).setText("0km");
                        }
                    }
                    break;
                case 170:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value == 1);
                    break;
                case 171:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value == 1);
                    break;
                case 172:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value == 1);
                    break;
                case 173:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext28)).setChecked(value == 1);
                    break;
                case 174:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text13)).setText("8km/h");
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text13)).setText("15km/h");
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 175:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text14)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_driving_sport);
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_light_state);
                                break;
                        }
                    }
                    break;
                case 176:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext29)).setChecked(value == 1);
                    break;
                case 177:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext30)).setChecked(value == 1);
                    break;
                case 178:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text15)).setText(R.string.str_long);
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text15)).setText(R.string.str_short);
                                break;
                        }
                    }
                    break;
                case 179:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_whistle);
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_baojun_str0);
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_baojun_str1);
                                break;
                        }
                    }
                    break;
                case 180:
                    if (((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.str_bright_gold);
                                break;
                            case 2:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.str_403_ambient_3);
                                break;
                            default:
                                ((TextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.tv_text17)).setText(R.string.str_background_blue);
                                break;
                        }
                    }
                    break;
                case 181:
                    ((CheckedTextView) Rzc_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_havalh9set);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Rzc_0439_HavalH9SetAct.this.language_set = position;
                if (Rzc_0439_HavalH9SetAct.this.language_set >= 0 && Rzc_0439_HavalH9SetAct.this.language_set <= Rzc_0439_HavalH9SetAct.this.mLauStylelist.size() && Rzc_0439_HavalH9SetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{27, Rzc_0439_HavalH9SetAct.this.send_lang[Rzc_0439_HavalH9SetAct.this.language_set]}, null, null);
                }
                Rzc_0439_HavalH9SetAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_0439_HavalH9SetAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Rzc_0439_HavalH9SetAct.this.mLauStyle == null) {
                    Rzc_0439_HavalH9SetAct.this.initLauStyle();
                }
                if (Rzc_0439_HavalH9SetAct.this.mLauStyle != null && Rzc_0439_HavalH9SetAct.this.mPopShowView != null) {
                    Rzc_0439_HavalH9SetAct.this.mLauStyle.showAtLocation(Rzc_0439_HavalH9SetAct.this.mPopShowView, 17, 0, 0);
                    Rzc_0439_HavalH9SetAct.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427459 */:
                int value2 = DataCanbus.DATA[101] - 1;
                if (value2 < 1) {
                    value2 = 4;
                }
                sendCMD(4, value2);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value3 = DataCanbus.DATA[101] + 1;
                if (value3 > 4) {
                    value3 = 1;
                }
                sendCMD(4, value3);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value4 = DataCanbus.DATA[102] - 1;
                if (value4 < 1) {
                    value4 = 4;
                }
                sendCMD(5, value4);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value5 = DataCanbus.DATA[102] + 1;
                if (value5 > 4) {
                    value5 = 1;
                }
                sendCMD(5, value5);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value6 = DataCanbus.DATA[103] - 1;
                if (value6 < 1) {
                    value6 = 3;
                }
                sendCMD(6, value6);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value7 = DataCanbus.DATA[103] + 1;
                if (value7 > 3) {
                    value7 = 1;
                }
                sendCMD(6, value7);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
            case R.id.btn_plus5 /* 2131427470 */:
                int value8 = DataCanbus.DATA[104];
                if (value8 == 1) {
                    value8 = 1;
                } else if (value8 == 0) {
                    value8 = 2;
                }
                sendCMD(7, value8);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
            case R.id.btn_plus6 /* 2131427473 */:
                if (DataCanbus.DATA[106] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                sendCMD(12, value);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
            case R.id.btn_plus7 /* 2131427476 */:
                int value9 = DataCanbus.DATA[108];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                sendCMD(15, value9);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value10 = DataCanbus.DATA[109] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                sendCMD(14, value10);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value11 = DataCanbus.DATA[109] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                sendCMD(14, value11);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
            case R.id.btn_plus9 /* 2131427482 */:
                int value12 = DataCanbus.DATA[110];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                sendCMD(16, value12);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value13 = DataCanbus.DATA[156] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                sendCMD(50, value13);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value14 = DataCanbus.DATA[156] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                sendCMD(50, value14);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value15 = DataCanbus.DATA[164] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                sendCMD(51, value15);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value16 = DataCanbus.DATA[164] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                sendCMD(51, value16);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value17 = DataCanbus.DATA[169];
                if (value17 > 0) {
                    value17--;
                }
                sendCMD(64, value17);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value18 = DataCanbus.DATA[169];
                if (value18 < 20) {
                    value18++;
                }
                sendCMD(64, value18);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value19 = DataCanbus.DATA[174] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                sendCMD(66, value19);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value20 = DataCanbus.DATA[174] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                sendCMD(66, value20);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value21 = DataCanbus.DATA[175] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                sendCMD(67, value21);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value22 = DataCanbus.DATA[175] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                sendCMD(67, value22);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value23 = DataCanbus.DATA[178] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                sendCMD(73, value23);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value24 = DataCanbus.DATA[178] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                sendCMD(73, value24);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value25 = DataCanbus.DATA[179] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                sendCMD(74, value25);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value26 = DataCanbus.DATA[179] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                sendCMD(74, value26);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value27 = DataCanbus.DATA[180] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                sendCMD(75, value27);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value28 = DataCanbus.DATA[180] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                sendCMD(75, value28);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZC_0439_HavalH9AmpSetAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value29 = DataCanbus.DATA[130] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 24;
                iArr[1] = value29 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value30 = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 23;
                iArr2[1] = value30 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value31 = DataCanbus.DATA[115] & 255;
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[1];
                iArr3[0] = value31 != 0 ? 0 : 1;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value32 = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 60;
                iArr4[1] = value32 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(1, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value33 = DataCanbus.DATA[113] & 255;
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 19;
                iArr5[1] = value33 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(1, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value34 = DataCanbus.DATA[112] & 255;
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 18;
                iArr6[1] = value34 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(1, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value35 = DataCanbus.DATA[111] & 255;
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 17;
                iArr7[1] = value35 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(1, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value36 = DataCanbus.DATA[107] & 255;
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 13;
                iArr8[1] = value36 == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(1, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value37 = DataCanbus.DATA[105] & 255;
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 9;
                iArr9[1] = value37 == 0 ? 1 : 0;
                remoteModuleProxy9.cmd(1, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value38 = DataCanbus.DATA[181];
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 25;
                iArr10[1] = value38 == 0 ? 1 : 0;
                remoteModuleProxy10.cmd(1, iArr10, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value39 = DataCanbus.DATA[152];
                RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                int[] iArr11 = new int[2];
                iArr11[0] = 28;
                iArr11[1] = value39 == 0 ? 1 : 0;
                remoteModuleProxy11.cmd(1, iArr11, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value40 = DataCanbus.DATA[154];
                RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                int[] iArr12 = new int[2];
                iArr12[0] = 48;
                iArr12[1] = value40 == 0 ? 1 : 0;
                remoteModuleProxy12.cmd(1, iArr12, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value41 = DataCanbus.DATA[155];
                RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                int[] iArr13 = new int[2];
                iArr13[0] = 49;
                iArr13[1] = value41 == 0 ? 1 : 0;
                remoteModuleProxy13.cmd(1, iArr13, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value42 = DataCanbus.DATA[165];
                RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                int[] iArr14 = new int[2];
                iArr14[0] = 52;
                iArr14[1] = value42 == 0 ? 1 : 0;
                remoteModuleProxy14.cmd(1, iArr14, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value43 = DataCanbus.DATA[157];
                RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                int[] iArr15 = new int[2];
                iArr15[0] = 53;
                iArr15[1] = value43 == 0 ? 1 : 0;
                remoteModuleProxy15.cmd(1, iArr15, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value44 = DataCanbus.DATA[158];
                RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                int[] iArr16 = new int[2];
                iArr16[0] = 54;
                iArr16[1] = value44 == 0 ? 1 : 0;
                remoteModuleProxy16.cmd(1, iArr16, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value45 = DataCanbus.DATA[159];
                RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                int[] iArr17 = new int[2];
                iArr17[0] = 55;
                iArr17[1] = value45 == 0 ? 1 : 0;
                remoteModuleProxy17.cmd(1, iArr17, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value46 = DataCanbus.DATA[160];
                RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                int[] iArr18 = new int[2];
                iArr18[0] = 57;
                iArr18[1] = value46 == 0 ? 1 : 0;
                remoteModuleProxy18.cmd(1, iArr18, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value47 = DataCanbus.DATA[161];
                RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                int[] iArr19 = new int[2];
                iArr19[0] = 58;
                iArr19[1] = value47 == 0 ? 1 : 0;
                remoteModuleProxy19.cmd(1, iArr19, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value48 = DataCanbus.DATA[162];
                RemoteModuleProxy remoteModuleProxy20 = DataCanbus.PROXY;
                int[] iArr20 = new int[2];
                iArr20[0] = 59;
                iArr20[1] = value48 == 0 ? 1 : 0;
                remoteModuleProxy20.cmd(1, iArr20, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value49 = DataCanbus.DATA[166];
                RemoteModuleProxy remoteModuleProxy21 = DataCanbus.PROXY;
                int[] iArr21 = new int[2];
                iArr21[0] = 62;
                iArr21[1] = value49 == 0 ? 1 : 0;
                remoteModuleProxy21.cmd(1, iArr21, null, null);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value50 = DataCanbus.DATA[167];
                RemoteModuleProxy remoteModuleProxy22 = DataCanbus.PROXY;
                int[] iArr22 = new int[2];
                iArr22[0] = 68;
                iArr22[1] = value50 == 0 ? 1 : 0;
                remoteModuleProxy22.cmd(1, iArr22, null, null);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int value51 = DataCanbus.DATA[168];
                RemoteModuleProxy remoteModuleProxy23 = DataCanbus.PROXY;
                int[] iArr23 = new int[2];
                iArr23[0] = 56;
                iArr23[1] = value51 == 0 ? 1 : 0;
                remoteModuleProxy23.cmd(1, iArr23, null, null);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int value52 = DataCanbus.DATA[170];
                RemoteModuleProxy remoteModuleProxy24 = DataCanbus.PROXY;
                int[] iArr24 = new int[2];
                iArr24[0] = 65;
                iArr24[1] = value52 == 0 ? 1 : 0;
                remoteModuleProxy24.cmd(1, iArr24, null, null);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int value53 = DataCanbus.DATA[171];
                RemoteModuleProxy remoteModuleProxy25 = DataCanbus.PROXY;
                int[] iArr25 = new int[2];
                iArr25[0] = 63;
                iArr25[1] = value53 == 0 ? 1 : 0;
                remoteModuleProxy25.cmd(1, iArr25, null, null);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                int value54 = DataCanbus.DATA[172];
                RemoteModuleProxy remoteModuleProxy26 = DataCanbus.PROXY;
                int[] iArr26 = new int[2];
                iArr26[0] = 69;
                iArr26[1] = value54 == 0 ? 1 : 0;
                remoteModuleProxy26.cmd(1, iArr26, null, null);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                int value55 = DataCanbus.DATA[173];
                RemoteModuleProxy remoteModuleProxy27 = DataCanbus.PROXY;
                int[] iArr27 = new int[2];
                iArr27[0] = 70;
                iArr27[1] = value55 == 0 ? 1 : 0;
                remoteModuleProxy27.cmd(1, iArr27, null, null);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                int value56 = DataCanbus.DATA[176];
                RemoteModuleProxy remoteModuleProxy28 = DataCanbus.PROXY;
                int[] iArr28 = new int[2];
                iArr28[0] = 72;
                iArr28[1] = value56 == 0 ? 1 : 0;
                remoteModuleProxy28.cmd(1, iArr28, null, null);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                int value57 = DataCanbus.DATA[177];
                RemoteModuleProxy remoteModuleProxy29 = DataCanbus.PROXY;
                int[] iArr29 = new int[2];
                iArr29[0] = 71;
                iArr29[1] = value57 == 0 ? 1 : 0;
                remoteModuleProxy29.cmd(1, iArr29, null, null);
                break;
        }
    }

    private void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(5, new int[]{49, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoBrake() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCollisionWarn() {
        int value = DataCanbus.DATA[129];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                        default:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                    }
                    break;
                default:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                        default:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("10min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("20min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText("30min");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[115] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDomeDelay() {
        String str;
        int domedelay = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
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
                default:
                    str = "3s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text2)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowHome() {
        String str;
        int followhome = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
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
                default:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePowerSave() {
        String str;
        int powersave = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
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
                default:
                    str = "10min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text4)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (frontlight == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight2);
            }
        }
    }
}
