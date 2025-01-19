package com.syu.carinfo.bnr.guanzhi;

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

public class LZRomeoCarSet extends BaseActivity implements View.OnClickListener {
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
                case 104:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 105:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 106:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 107:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 108:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 111:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 112:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 113:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 114:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 115:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_metric);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_us_imperial);
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text6)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text6)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)).setText("l/100km");
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)).setText("mpg");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_selection5);
                                break;
                            default:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)).setText("kpa");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)).setText("psi");
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 122:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("60s");
                                break;
                            case 3:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 123:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 124:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 125:
                    LZRomeoCarSet.this.updateLauguageSet();
                    break;
                case 132:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 133:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 134:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 135:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 136:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text13)).setText("G_METER");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text13)).setText("Target");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text14)).setText("History");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text14)).setText("Current");
                                break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text15)).setText("eco index");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text15)).setText("Current");
                                break;
                        }
                    }
                    break;
                case 139:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 140:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 141:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 142:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_parksense_2);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_parksense_1);
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
        //setContentView(R.layout.layout_0453_lz_romeo_settings);
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
                LZRomeoCarSet.this.language_set = position;
                if (LZRomeoCarSet.this.language_set >= 0 && LZRomeoCarSet.this.language_set <= LZRomeoCarSet.this.mLauStylelist.size() && LZRomeoCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{17, LZRomeoCarSet.this.send_lang[LZRomeoCarSet.this.language_set]}, null, null);
                }
                LZRomeoCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[125];
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
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LZRomeoCarSet.this.mLauStyle == null) {
                    LZRomeoCarSet.this.initLauStyle();
                }
                if (LZRomeoCarSet.this.mLauStyle != null && LZRomeoCarSet.this.mPopShowView != null) {
                    LZRomeoCarSet.this.mLauStyle.showAtLocation(LZRomeoCarSet.this.mPopShowView, 17, 0, 0);
                    LZRomeoCarSet.this.updateLauguageSet();
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[105] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[105] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[108] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[108] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[109] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(9, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[109] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(9, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[110] - 5;
                if (value7 < 30) {
                    value7 = 30;
                }
                setCarInfo(1, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[110] + 5;
                if (value8 > 180) {
                    value8 = 180;
                }
                setCarInfo(1, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[115] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(13, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[115] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(13, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[116] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(14, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[116] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(14, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[117] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(15, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[117] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(15, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[118] - 1;
                if (value15 < 0) {
                    value15 = 0;
                }
                setCarInfo(8, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[118] + 1;
                if (value16 > 4) {
                    value16 = 4;
                }
                setCarInfo(8, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[119] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(16, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[119] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(16, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[120] - 1;
                if (value19 < 0) {
                    value19 = 5;
                }
                setCarInfo(22, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[120] + 1;
                if (value20 > 5) {
                    value20 = 0;
                }
                setCarInfo(22, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[121] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(18, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[121] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(18, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[122] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(19, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[122] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(19, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[136] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo(27, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[136] + 1;
                if (value26 > 1) {
                    value26 = 0;
                }
                setCarInfo(27, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[137] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(28, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[137] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(28, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[138] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(29, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[138] + 1;
                if (value30 > 1) {
                    value30 = 0;
                }
                setCarInfo(29, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[142] - 1;
                if (value31 < 0) {
                    value31 = 1;
                }
                setCarInfo(33, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[142] + 1;
                if (value32 > 1) {
                    value32 = 0;
                }
                setCarInfo(33, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[104];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(0, value33);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[106];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(4, value34);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value35 = DataCanbus.DATA[107];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(5, value35);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value36 = DataCanbus.DATA[111];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(7, value36);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value37 = DataCanbus.DATA[112];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(10, value37);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value38 = DataCanbus.DATA[113];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(11, value38);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value39 = DataCanbus.DATA[114];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(12, value39);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value40 = DataCanbus.DATA[123];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(20, value40);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value41 = DataCanbus.DATA[124];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(21, value41);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                dialog(6);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value42 = DataCanbus.DATA[132];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(23, value42);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value43 = DataCanbus.DATA[133];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(24, value43);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value44 = DataCanbus.DATA[134];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(25, value44);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value45 = DataCanbus.DATA[135];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(26, value45);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value46 = DataCanbus.DATA[139];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(30, value46);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value47 = DataCanbus.DATA[140];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(31, value47);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value48 = DataCanbus.DATA[141];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(32, value48);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZRomeoAmpCarSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
    }

    @Override
    public void removeNotify() {
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
    }

    protected void dialog(int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.jeep_brakemode)) + "   " + getResources().getString(R.string.str_romeo_tip));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{6}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
