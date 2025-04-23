package com.syu.carinfo.rzc.sanlin;

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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

public class LuzJaguarXFCarSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 66:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 100:
                    LuzJaguarXFCarSet.this.updateText6();
                    break;
                case 102:
                    LuzJaguarXFCarSet.this.updateText7();
                    break;
                case 103:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text1)).setText("8km/h");
                                break;
                            case 2:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text1)).setText("16km/h");
                                break;
                            case 3:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text1)).setText("32km/h");
                                break;
                        }
                    }
                    break;
                case 106:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 107:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 108:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text2)).setText("D");
                                break;
                            case 1:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text2)).setText("D+S");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 110:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text4)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text4)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text5)).setText("Auto");
                                break;
                            case 1:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text5)).setText("Always on");
                                break;
                        }
                    }
                    break;
                case 113:
                    LuzJaguarXFCarSet.this.unit = value;
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text8)).setText("km");
                                break;
                            case 1:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text8)).setText("miles");
                                break;
                        }
                    }
                    LuzJaguarXFCarSet.this.updateText6();
                    LuzJaguarXFCarSet.this.updateText7();
                    LuzJaguarXFCarSet.this.updateText10();
                    LuzJaguarXFCarSet.this.updateText11();
                    LuzJaguarXFCarSet.this.updateText12();
                    LuzJaguarXFCarSet.this.updateText13();
                    break;
                case 114:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text9)).setText("Trip A");
                                break;
                            case 1:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text9)).setText("Trip B");
                                break;
                            case 2:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text9)).setText("Trip auto");
                                break;
                            case 3:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text9)).setText("Add trip");
                                break;
                            case 4:
                                ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text9)).setText("Del trip");
                                break;
                        }
                    }
                    break;
                case 115:
                    LuzJaguarXFCarSet.this.updateText10();
                    break;
                case 116:
                    LuzJaguarXFCarSet.this.updateText11();
                    break;
                case 117:
                    LuzJaguarXFCarSet.this.updateText12();
                    break;
                case 118:
                    LuzJaguarXFCarSet.this.updateText13();
                    break;
                case 119:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 120:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 121:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 122:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 123:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 124:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        if (value == 1) {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.str_backrest_only);
                            break;
                        } else {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.str_full_seat);
                            break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        if (value == 1) {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_backrest_only);
                            break;
                        } else {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.str_full_seat);
                            break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        if (value == 1) {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.wc_372_high);
                            break;
                        } else {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.normal);
                            break;
                        }
                    }
                    break;
                case 128:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 129:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        if (value == 1) {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.str_244_als2);
                            break;
                        } else {
                            ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.str_244_als1);
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_luz_jaguar_xf_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
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
                LuzJaguarXFCarSet.this.language_set = position;
                if (LuzJaguarXFCarSet.this.language_set >= 0 && LuzJaguarXFCarSet.this.language_set <= LuzJaguarXFCarSet.this.mLauStylelist.size() && LuzJaguarXFCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{16, LuzJaguarXFCarSet.this.send_lang[LuzJaguarXFCarSet.this.language_set]}, null, null);
                }
                LuzJaguarXFCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add("Vlaams");
        this.mLauStylelist.add("Cestina");
        this.mLauStylelist.add("Eyygvika");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LuzJaguarXFCarSet.this.mLauStyle == null) {
                    LuzJaguarXFCarSet.this.initLauStyle();
                }
                if (LuzJaguarXFCarSet.this.mLauStyle != null && LuzJaguarXFCarSet.this.mPopShowView != null) {
                    LuzJaguarXFCarSet.this.mLauStyle.showAtLocation(LuzJaguarXFCarSet.this.mPopShowView, 17, 0, 0);
                    LuzJaguarXFCarSet.this.updateLauguageSet();
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[105] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(3, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[105] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(3, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[108] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(6, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[108] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(6, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarAirInfo(1, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarAirInfo(2, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[110] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarAirInfo(3, value5);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[110] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarAirInfo(3, value6);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[111] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarAirInfo(4, value7);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[111] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarAirInfo(4, value8);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[113] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(11, value9, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[113] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(11, value10, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[114] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(12, value11, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value12 = DataCanbus.DATA[114] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(12, value12, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarAirInfo(1, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarAirInfo(2, 0);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value13 = DataCanbus.DATA[124] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarAirInfo(5, value13);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value14 = DataCanbus.DATA[124] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarAirInfo(5, value14);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value15 = DataCanbus.DATA[127] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(13, value15, 0);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value16 = DataCanbus.DATA[127] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(13, value16, 0);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value17 = DataCanbus.DATA[129] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(15, value17, 0);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value18 = DataCanbus.DATA[129] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(15, value18, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value19 = DataCanbus.DATA[103];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(1, value19, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value20 = DataCanbus.DATA[104];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(2, value20, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value21 = DataCanbus.DATA[106];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(4, value21, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value22 = DataCanbus.DATA[107];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(5, value22, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value23 = DataCanbus.DATA[119];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(7, value23, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value24 = DataCanbus.DATA[120];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(8, value24, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value25 = DataCanbus.DATA[121];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(9, value25, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value26 = DataCanbus.DATA[122];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(10, value26, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarAir(31);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value27 = DataCanbus.DATA[128];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(14, value27, 0);
                break;
        }
    }

    public void setCarAir(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2}, null, null);
    }

    public void setCarAirInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText13() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text13)).setText(String.valueOf(value) + "miles");
            } else {
                ((TextView) findViewById(R.id.tv_text13)).setText(String.valueOf(value) + "km");
            }
        }
    }

    
    public void updateText12() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "mpg");
            } else {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "l/100km");
            }
        }
    }

    
    public void updateText11() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "mph");
            } else {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "km/h");
            }
        }
    }

    
    public void updateText10() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "miles");
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "km");
            }
        }
    }

    
    public void updateText6() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
            }
        }
    }

    
    public void updateText7() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " miles");
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
            }
        }
    }
}
