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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODBeiqiBJX55CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODBeiqiBJX55CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text1)).setText("5km/h");
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text1)).setText("10km/h");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text1)).setText("15km/h");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text1)).setText("20km/h");
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 128:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 129:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 130:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_unlockall_set);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_unlockdriver_set);
                                break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)).setText("10s");
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)).setText("20s");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)).setText("120s");
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 132:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 133:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_five_times);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_seven_times);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_three_times);
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 135:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 136:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_sports);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_standard);
                                break;
                        }
                    }
                    break;
                case 137:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 138:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 139:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 140:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_keen);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 141:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 142:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_unit_imperial);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_unit_metric);
                                break;
                        }
                    }
                    break;
                case 143:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 144:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 145:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 146:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 147:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append((val * 5) + 30).toString());
                    }
                    break;
                case 148:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text12)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_driving_eco);
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_driving_sport);
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text12)).setText(R.string.str_intelligent);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text12)).setText(R.string.wc_golf_comfort);
                                break;
                        }
                    }
                    break;
                case 149:
                    ODBeiqiBJX55CarSet.this.updateLauguageSet();
                    break;
                case 150:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_new_mode3);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_new_mode1);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_new_mode2);
                                break;
                        }
                    }
                    break;
                case 151:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 152:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 153:
                    ODBeiqiBJX55CarSet.this.setCheck((CheckedTextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 154:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.mateng_air_con_profile_1);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.mateng_air_con_profile_2);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text14)).setText(R.string.mateng_air_con_profile_0);
                                break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text15)).setText(R.string.str_day1);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text15)).setText(R.string.str_night);
                                break;
                            default:
                                ((TextView) ODBeiqiBJX55CarSet.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_auto);
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
        setContentView(R.layout.layout_0455_od_beiqi_x55_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODBeiqiBJX55CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ODBeiqiBJX55CarSet.this.language_set = position;
                if (ODBeiqiBJX55CarSet.this.language_set >= 0 && ODBeiqiBJX55CarSet.this.language_set <= ODBeiqiBJX55CarSet.this.mLauStylelist.size() && ODBeiqiBJX55CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(5, new int[]{20, ODBeiqiBJX55CarSet.this.send_lang[ODBeiqiBJX55CarSet.this.language_set]}, null, null);
                }
                ODBeiqiBJX55CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[149];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODBeiqiBJX55CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ODBeiqiBJX55CarSet.this.mLauStyle == null) {
                    ODBeiqiBJX55CarSet.this.initLauStyle();
                }
                if (ODBeiqiBJX55CarSet.this.mLauStyle != null && ODBeiqiBJX55CarSet.this.mPopShowView != null) {
                    ODBeiqiBJX55CarSet.this.mLauStyle.showAtLocation(ODBeiqiBJX55CarSet.this.mPopShowView, 17, 0, 0);
                    ODBeiqiBJX55CarSet.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[127] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[127] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[130] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[130] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[131] - 1;
                if (value5 < 0) {
                    value5 = 5;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[131] + 1;
                if (value6 > 5) {
                    value6 = 0;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[133] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[133] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[134] - 1;
                if (value9 < 1) {
                    value9 = 10;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[134] + 1;
                if (value10 > 10) {
                    value10 = 1;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[136] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(11, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[136] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(11, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[140] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(15, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[140] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(15, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[141] - 1;
                if (value15 < 1) {
                    value15 = 10;
                }
                setCarInfo(17, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[141] + 1;
                if (value16 > 10) {
                    value16 = 1;
                }
                setCarInfo(17, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[142] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(16, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[142] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(16, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[143] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(9, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[143] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(9, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[147] - 1;
                if (value21 < 0) {
                    value21 = 26;
                }
                setCarInfo(19, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[147] + 1;
                if (value22 > 26) {
                    value22 = 0;
                }
                setCarInfo(19, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[148] - 1;
                if (value23 < 1) {
                    value23 = 4;
                }
                setCarInfo(22, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[148] + 1;
                if (value24 > 4) {
                    value24 = 1;
                }
                setCarInfo(22, value24);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[150] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(21, value25);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[150] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(21, value26);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value27 = DataCanbus.DATA[154] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(29, value27);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value28 = DataCanbus.DATA[154] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(29, value28);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value29 = DataCanbus.DATA[155] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(30, value29);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value30 = DataCanbus.DATA[155] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(30, value30);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(4, DataCanbus.DATA[128] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(10, DataCanbus.DATA[135] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(12, DataCanbus.DATA[137] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(3, DataCanbus.DATA[129] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(8, DataCanbus.DATA[132] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(13, DataCanbus.DATA[138] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(14, DataCanbus.DATA[139] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(23, DataCanbus.DATA[144] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(24, DataCanbus.DATA[145] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(18, DataCanbus.DATA[146] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(26, DataCanbus.DATA[151] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(27, DataCanbus.DATA[152] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(28, DataCanbus.DATA[153] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(25, 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(25, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{67, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }
}
