package com.syu.carinfo.wc.ruijie15;

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

public class RJXpCarSetAct extends BaseActivity implements View.OnClickListener {
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
                case 37:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text22)).setText("℃");
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text22)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 98:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text23)).setText("km");
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text23)).setText("mile");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_ice_blue);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_orange_str);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_2);
                                break;
                            case 3:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                                break;
                            case 4:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_4);
                                break;
                            case 5:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                            case 6:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_6);
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 121:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 122:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 123:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 126:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 127:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 128:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text15)) != null) {
                        if (value > 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text15)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text15)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text15)).setText("0");
                            break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text16)) != null) {
                        if (value > 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text16)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text16)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text16)).setText("0");
                            break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text17)) != null) {
                        if (value > 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text17)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text17)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text17)).setText("0");
                            break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text18)) != null) {
                        if (value > 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text18)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text18)).setText("F" + (7 - value));
                            break;
                        } else {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text18)).setText("0");
                            break;
                        }
                    }
                    break;
                case 132:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text19)) != null) {
                        if (value > 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text19)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text19)).setText("L" + (7 - value));
                            break;
                        } else {
                            ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text19)).setText("0");
                            break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text20)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text21)).setText("stereo");
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text21)).setText("surround");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 136:
                    RJXpCarSetAct.this.updateLauguageSet();
                    break;
                case 137:
                    RJXpCarSetAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view6).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view7).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view8).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view9).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view11).setVisibility(8);
                    RJXpCarSetAct.this.findViewById(R.id.layout_view12).setVisibility(8);
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text3)).setText("Driver Adjust");
                                RJXpCarSetAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                                RJXpCarSetAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                                RJXpCarSetAct.this.findViewById(R.id.layout_view6).setVisibility(0);
                                break;
                            case 1:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text3)).setText("Driver Massage");
                                RJXpCarSetAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                                RJXpCarSetAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                                break;
                            case 2:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text3)).setText("Passenger Adjust");
                                RJXpCarSetAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                                RJXpCarSetAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                                RJXpCarSetAct.this.findViewById(R.id.layout_view12).setVisibility(0);
                                break;
                            case 3:
                                ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text3)).setText("Passenger Massage");
                                RJXpCarSetAct.this.findViewById(R.id.layout_view8).setVisibility(0);
                                RJXpCarSetAct.this.findViewById(R.id.layout_view9).setVisibility(0);
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
        //setContentView(R.layout.layout_0452_xp_ford_settings);
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
                RJXpCarSetAct.this.language_set = position;
                if (RJXpCarSetAct.this.language_set >= 0 && RJXpCarSetAct.this.language_set <= RJXpCarSetAct.this.mLauStylelist.size() && RJXpCarSetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{164, RJXpCarSetAct.this.send_lang[RJXpCarSetAct.this.language_set]}, null, null);
                }
                RJXpCarSetAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[136];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 18, 22, 27};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RJXpCarSetAct.this.mLauStyle == null) {
                    RJXpCarSetAct.this.initLauStyle();
                }
                if (RJXpCarSetAct.this.mLauStyle != null && RJXpCarSetAct.this.mPopShowView != null) {
                    RJXpCarSetAct.this.mLauStyle.showAtLocation(RJXpCarSetAct.this.mPopShowView, 17, 0, 0);
                    RJXpCarSetAct.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[117] - 1;
                if (value < 0) {
                    value = 6;
                }
                setCarInfo(177, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[117] + 1;
                if (value2 > 6) {
                    value2 = 0;
                }
                setCarInfo(177, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[135];
                if (value3 > 0) {
                    value3 -= 5;
                }
                setCarInfo(189, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[135];
                if (value4 < 100) {
                    value4 += 5;
                }
                setCarInfo(189, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[137] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(188, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[137] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(188, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[118] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(178, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[118] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(178, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[119] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(179, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[119] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(179, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(180, 1);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(180, 2);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(181, 1);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(181, 2);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(182, 1);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(182, 2);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value11 = DataCanbus.DATA[123] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(183, value11);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value12 = DataCanbus.DATA[123] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(183, value12);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value13 = DataCanbus.DATA[124] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(184, value13);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value14 = DataCanbus.DATA[124] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(184, value14);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                setCarInfo(185, 1);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                setCarInfo(185, 2);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                setCarInfo(186, 1);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                setCarInfo(186, 2);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                setCarInfo(187, 1);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                setCarInfo(187, 2);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value15 = DataCanbus.DATA[128];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(192, value15);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value16 = DataCanbus.DATA[128];
                if (value16 < 14) {
                    value16++;
                }
                setCarInfo(192, value16);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value17 = DataCanbus.DATA[129];
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo(193, value17);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value18 = DataCanbus.DATA[129];
                if (value18 < 14) {
                    value18++;
                }
                setCarInfo(193, value18);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value19 = DataCanbus.DATA[130];
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo(194, value19);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value20 = DataCanbus.DATA[130];
                if (value20 < 14) {
                    value20++;
                }
                setCarInfo(194, value20);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value21 = DataCanbus.DATA[131];
                if (value21 > 0) {
                    value21--;
                }
                setCarInfo(195, value21);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value22 = DataCanbus.DATA[131];
                if (value22 < 14) {
                    value22++;
                }
                setCarInfo(195, value22);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value23 = DataCanbus.DATA[132];
                if (value23 > 0) {
                    value23--;
                }
                setCarInfo(196, value23);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value24 = DataCanbus.DATA[132];
                if (value24 < 14) {
                    value24++;
                }
                setCarInfo(196, value24);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value25 = DataCanbus.DATA[134] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo(198, value25 + 1);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value26 = DataCanbus.DATA[134] + 1;
                if (value26 > 1) {
                    value26 = 0;
                }
                setCarInfo(198, value26 + 1);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                int value27 = DataCanbus.DATA[37] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(160, value27);
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                int value28 = DataCanbus.DATA[37] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(160, value28);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value29 = DataCanbus.DATA[133] - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo(197, value29 + 1);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value30 = DataCanbus.DATA[133] + 1;
                if (value30 > 3) {
                    value30 = 0;
                }
                setCarInfo(197, value30 + 1);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value31 = DataCanbus.DATA[98] + 1;
                if (value31 > 1) {
                    value31 = 0;
                }
                setCarInfo(163, value31 + 14);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value32 = DataCanbus.DATA[98] - 1;
                if (value32 < 0) {
                    value32 = 1;
                }
                setCarInfo(163, value32 + 14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{72}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{39}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }
}
