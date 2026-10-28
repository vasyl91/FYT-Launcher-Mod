package com.syu.carinfo.rzc.sanlin;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCBeiqiBJ90CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    RZCBeiqiBJ90CarSet.this.updateLauguageSet();
                    break;
                case 102:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 115:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 116:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 117:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 118:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text6)).setText("+" + value);
                        break;
                    }
                case 119:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text7)).setText("+" + value);
                        break;
                    }
                case 120:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 121:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 122:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text9)).setText("+" + value);
                        break;
                    }
                case 124:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 125:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 126:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 127:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.switch_on_time_late);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.switch_on_time_medium);
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.switch_on_time_early);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_keen);
                                break;
                        }
                    }
                    break;
                case 129:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 130:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 131:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text12)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value * 10) + "km/h");
                                break;
                        }
                    }
                    break;
                case 132:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.normal);
                                break;
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.wc_gs4_air_set_comfort_nomol);
                                break;
                            case 3:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.wc_gs4_air_set_comfort_fast);
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.wc_gs4_air_set_comfort_slow);
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text15)).setText("mile");
                                break;
                            default:
                                ((TextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.tv_text15)).setText("km");
                                break;
                        }
                    }
                    break;
                case 135:
                    RZCBeiqiBJ90CarSet.this.setCheck((CheckedTextView) RZCBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_rzc_beiqi_bj90_settings);
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
                RZCBeiqiBJ90CarSet.this.language_set = position;
                if (RZCBeiqiBJ90CarSet.this.language_set >= 0 && RZCBeiqiBJ90CarSet.this.language_set <= RZCBeiqiBJ90CarSet.this.mLauStylelist.size() && RZCBeiqiBJ90CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{1, 1, RZCBeiqiBJ90CarSet.this.send_lang[RZCBeiqiBJ90CarSet.this.language_set]}, null, null);
                }
                RZCBeiqiBJ90CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[101];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_42));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_43));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCBeiqiBJ90CarSet.this.mLauStyle == null) {
                    RZCBeiqiBJ90CarSet.this.initLauStyle();
                }
                if (RZCBeiqiBJ90CarSet.this.mLauStyle != null && RZCBeiqiBJ90CarSet.this.mPopShowView != null) {
                    RZCBeiqiBJ90CarSet.this.mLauStyle.showAtLocation(RZCBeiqiBJ90CarSet.this.mPopShowView, 17, 0, 0);
                    RZCBeiqiBJ90CarSet.this.updateLauguageSet();
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
    }

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427458 */:
                int value2 = DataCanbus.DATA[103] - 1;
                if (value2 < 0) {
                    value2 = 4;
                }
                setCarInfo(2, 2, value2);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value3 = DataCanbus.DATA[103] + 1;
                if (value3 > 4) {
                    value3 = 0;
                }
                setCarInfo(2, 2, value3);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value4 = DataCanbus.DATA[104] - 1;
                if (value4 < 0) {
                    value4 = 4;
                }
                setCarInfo(2, 3, value4);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value5 = DataCanbus.DATA[104] + 1;
                if (value5 > 4) {
                    value5 = 0;
                }
                setCarInfo(2, 3, value5);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value6 = DataCanbus.DATA[105] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(3, 1, value6);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value7 = DataCanbus.DATA[105] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(3, 1, value7);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value8 = DataCanbus.DATA[106] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(3, 2, value8);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value9 = DataCanbus.DATA[106] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(3, 2, value9);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value10 = DataCanbus.DATA[118] - 1;
                if (value10 < 1) {
                    value10 = 5;
                }
                setCarInfo(4, 2, value10);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value11 = DataCanbus.DATA[118] + 1;
                if (value11 > 5) {
                    value11 = 1;
                }
                setCarInfo(4, 2, value11);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value12 = DataCanbus.DATA[119] - 1;
                if (value12 < 1) {
                    value12 = 5;
                }
                setCarInfo(4, 3, value12);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[119] + 1;
                if (value13 > 5) {
                    value13 = 1;
                }
                setCarInfo(4, 3, value13);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value14 = DataCanbus.DATA[122] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(5, 1, value14);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value15 = DataCanbus.DATA[122] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(5, 1, value15);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value16 = DataCanbus.DATA[123] - 1;
                if (value16 < 0) {
                    value16 = 10;
                }
                setCarInfo(5, 2, value16);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value17 = DataCanbus.DATA[123] + 1;
                if (value17 > 10) {
                    value17 = 0;
                }
                setCarInfo(5, 2, value17);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value18 = DataCanbus.DATA[127] - 1;
                if (value18 < 0) {
                    value18 = 3;
                }
                setCarInfo(7, 1, value18);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value19 = DataCanbus.DATA[127] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(7, 1, value19);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value20 = DataCanbus.DATA[128] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                setCarInfo(8, 1, value20);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value21 = DataCanbus.DATA[128] + 1;
                if (value21 > 2) {
                    value21 = 0;
                }
                setCarInfo(8, 1, value21);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value22 = DataCanbus.DATA[131];
                if (value22 > 12) {
                    value = value22 - 1;
                } else {
                    value = 0;
                }
                setCarInfo(9, 3, value);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value23 = DataCanbus.DATA[131];
                if (value23 < 12) {
                    value23 = 12;
                } else if (value23 < 18) {
                    value23++;
                }
                setCarInfo(9, 3, value23);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value24 = DataCanbus.DATA[132] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(10, 1, value24);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value25 = DataCanbus.DATA[132] + 1;
                if (value25 > 2) {
                    value25 = 0;
                }
                setCarInfo(10, 1, value25);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value26 = DataCanbus.DATA[133] - 1;
                if (value26 < 1) {
                    value26 = 3;
                }
                setCarInfo(10, 2, value26);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value27 = DataCanbus.DATA[133] + 1;
                if (value27 > 3) {
                    value27 = 1;
                }
                setCarInfo(10, 2, value27);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value28 = DataCanbus.DATA[134] - 1;
                if (value28 < 1) {
                    value28 = 2;
                }
                setCarInfo(10, 3, value28);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value29 = DataCanbus.DATA[134] + 1;
                if (value29 > 2) {
                    value29 = 1;
                }
                setCarInfo(10, 3, value29);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(2, 1, DataCanbus.DATA[102] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(2, 4, DataCanbus.DATA[115] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(2, 5, DataCanbus.DATA[116] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(4, 1, DataCanbus.DATA[117] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(4, 4, DataCanbus.DATA[120] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(4, 5, DataCanbus.DATA[121] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(5, 3, DataCanbus.DATA[124] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(6, 1, DataCanbus.DATA[125] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(6, 2, DataCanbus.DATA[126] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(9, 1, DataCanbus.DATA[129] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(9, 2, DataCanbus.DATA[130] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(10, 4, DataCanbus.DATA[135] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2}, null, null);
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
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
    }
}
