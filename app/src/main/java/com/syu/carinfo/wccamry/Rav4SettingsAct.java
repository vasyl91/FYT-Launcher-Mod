package com.syu.carinfo.wccamry;

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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class Rav4SettingsAct extends BaseActivity {
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
                case 37:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text15)).setText("℃");
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text15)).setText("℉");
                            break;
                    }
                case 102:
                    Rav4SettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 103:
                    Rav4SettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 104:
                    Rav4SettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 105:
                    Rav4SettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 106:
                    Rav4SettingsAct.this.mUpdaterAutoAc();
                    break;
                case 107:
                    Rav4SettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 108:
                    Rav4SettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 109:
                    Rav4SettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 110:
                    Rav4SettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 111:
                    Rav4SettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 112:
                    Rav4SettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 113:
                    Rav4SettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 114:
                    Rav4SettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 119:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
                        break;
                    }
                case 120:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(value).toString());
                    break;
                case 122:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
                case 123:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text22)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    Rav4SettingsAct.this.mUpdaterOuteriorLightOffTime();
                    break;
                case 170:
                    if (value > 3) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("+" + (value - 3));
                        break;
                    } else if (value < 3) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("-" + (3 - value));
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("0");
                        break;
                    }
                case 171:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                        break;
                    }
                case 172:
                    if (value > 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("+" + (value - 2));
                        break;
                    } else if (value < 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("-" + (2 - value));
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("0");
                        break;
                    }
                case 173:
                    if (value > 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("+" + (value - 2));
                        break;
                    } else if (value < 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("-" + (2 - value));
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    }
                case 174:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_only_incline);
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_only_telescoping);
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_incline_telescoping);
                            break;
                    }
                case 175:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 182:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText("Half");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText("All");
                            break;
                    }
                case 183:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText("Stop");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText("Start");
                            break;
                    }
                case 184:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                        break;
                    }
                case 185:
                    if (value == 0) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
                        break;
                    }
                case 187:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text13)).setText("30s");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text13)).setText("60s");
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text13)).setText("120s");
                            break;
                    }
                case 188:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text14)).setText("30s");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text14)).setText("60s");
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text14)).setText("90s");
                            break;
                    }
                case 189:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text16)).setText("MPG(US)");
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text16)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text16)).setText("L/100knm");
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text16)).setText("MPG(UK)");
                            break;
                    }
                case 190:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text17)).setText("km");
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text17)).setText("mile");
                            break;
                    }
                case 191:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
                        break;
                    }
                case 192:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text18)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_high);
                            break;
                    }
                case 193:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text19)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rav4_settings);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
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
                Rav4SettingsAct.this.language_set = position;
                if (Rav4SettingsAct.this.language_set >= 0 && Rav4SettingsAct.this.language_set <= Rav4SettingsAct.this.mLauStylelist.size() && Rav4SettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(32, new int[]{1, Rav4SettingsAct.this.send_lang[Rav4SettingsAct.this.language_set]}, null, null);
                }
                Rav4SettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_23));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add("Viet");
        this.mLauStylelist.add("Indonesia");
        this.mLauStylelist.add("Malaysia");
        this.send_lang = new int[]{1, 2, 3, 5, 7, 9, 15, 16, 17, 18, 19, 30, 42, 43};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Rav4SettingsAct.this.mLauStyle == null) {
                    Rav4SettingsAct.this.initLauStyle();
                }
                if (Rav4SettingsAct.this.mLauStyle != null && Rav4SettingsAct.this.mPopShowView != null) {
                    Rav4SettingsAct.this.mLauStyle.showAtLocation(Rav4SettingsAct.this.mPopShowView, 17, 0, 0);
                    Rav4SettingsAct.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios /* 2359590 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios_H /* 2425126 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios /* 2490662 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios_H /* 2556198 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova /* 3408166 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova_H /* 3473702 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR /* 4587814 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR_H /* 4653350 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Altis /* 8192294 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Altis_H /* 8257830 */:
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
                findViewById(R.id.layout_view28).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view4).setVisibility(8);
                break;
            default:
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
                findViewById(R.id.layout_view28).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                break;
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[103] == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[113] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[111] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[105] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[104] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[112] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[108] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[114] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[110] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[171] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 11, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 11}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[184] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 17, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 17}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rav4SettingsAct.this, Wc09LexusESEQActi.class);
                    Rav4SettingsAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[191] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{2, 7, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{2, 7}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[119] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 8, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 8}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                //
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[185] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[185] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[172];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[172];
                if (value < 4) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[173];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[173];
                if (value < 4) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[174];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[174];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[175];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[175];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value < 2) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[183];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[183];
                if (value < 2) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[170];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[170];
                if (value < 6) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[187];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[187];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[37];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[37];
                if (value < 1) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[189];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[189];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[192];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[192];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                if (value < 13) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120];
                if (value < 5) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(29, new int[]{1, 10, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(29, new int[]{1, 10, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(29, new int[]{1, 10, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(29, new int[]{1, 10, 2}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOuteriorLightOffTime() {
        int value = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.tv_text4)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text4)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text3)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text3)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[103];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[104];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[114];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text2)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }
}
