package com.syu.carinfo.havah6;

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
public class Wc_320_CarSetlAct_newH6 extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.Wc_320_CarSetlAct_newH6.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    if (value == 0) {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_Manual);
                    } else {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_auto);
                    }
                    break;
                case 108:
                    if (value == 0) {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_c4l_close);
                    } else {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_c4l_open);
                    }
                    break;
                case 130:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 131:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 132:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 133:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 134:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 135:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text1)).setText(R.string.wc_372_low);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 136:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 137:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 138:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 139:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text2)).setText(R.string.str_bright_gold);
                            break;
                    }
                    break;
                case 140:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text3)).setText(R.string.str_244_rainfall2);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text3)).setText(R.string.str_244_rainfall1);
                            break;
                    }
                    break;
                case 141:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 150:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext12), value != 0);
                    break;
                case 151:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext11), value != 0);
                    break;
                case 152:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 153:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext13), value != 0);
                    break;
                case 154:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext14), value != 0);
                    break;
                case 155:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 178:
                    switch (value) {
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text8)).setText(R.string.str_long);
                            break;
                        default:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text8)).setText(R.string.str_short);
                            break;
                    }
                    break;
                case 179:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext15), value != 0);
                    break;
                case 180:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text7)).setText("8km/h");
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text7)).setText("15km/h");
                            break;
                    }
                    break;
                case 182:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext16), value != 0);
                    break;
                case 183:
                    switch (value) {
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                        default:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                    }
                    break;
                case 184:
                    switch (value) {
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text10)).setText(R.string.driver_system_economics);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text10)).setText(R.string.driver_system_sports);
                            break;
                        case 3:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text10)).setText(R.string.str_17_snow);
                            break;
                        default:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text10)).setText(R.string.driver_system_standard);
                            break;
                    }
                    break;
                case 185:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext17), value != 0);
                    break;
                case 186:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext18), value != 0);
                    break;
                case 187:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext19), value != 0);
                    break;
                case 188:
                    switch (value) {
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text11)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text11)).setText(R.string.str_driving_sport);
                            break;
                        default:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text11)).setText(R.string.str_light_state);
                            break;
                    }
                    break;
                case 189:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext20), value != 0);
                    break;
                case 190:
                    ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 191:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext21), value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_newh6_carset);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.havah6.Wc_320_CarSetlAct_newH6.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Wc_320_CarSetlAct_newH6.this.language_set = position;
                if (Wc_320_CarSetlAct_newH6.this.language_set >= 0 && Wc_320_CarSetlAct_newH6.this.language_set <= Wc_320_CarSetlAct_newH6.this.mLauStylelist.size() && Wc_320_CarSetlAct_newH6.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(6, new int[]{1, Wc_320_CarSetlAct_newH6.this.send_lang[Wc_320_CarSetlAct_newH6.this.language_set]}, null, null);
                }
                Wc_320_CarSetlAct_newH6.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.havah6.Wc_320_CarSetlAct_newH6.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Wc_320_CarSetlAct_newH6.this.mLauStyle == null) {
                    Wc_320_CarSetlAct_newH6.this.initLauStyle();
                }
                if (Wc_320_CarSetlAct_newH6.this.mLauStyle != null && Wc_320_CarSetlAct_newH6.this.mPopShowView != null) {
                    Wc_320_CarSetlAct_newH6.this.mLauStyle.showAtLocation(Wc_320_CarSetlAct_newH6.this.mPopShowView, 17, 0, 0);
                    Wc_320_CarSetlAct_newH6.this.updateLauguageSet();
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
        if (DataCanbus.DATA[1000] == 1900864 || DataCanbus.DATA[1000] == 1966400) {
            findViewById(R.id.all_func_btn_lauguage_set_view).setVisibility(8);
        } else {
            findViewById(R.id.all_func_btn_lauguage_set_view).setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        int value12;
        int value13;
        int value14;
        int value15;
        int value16;
        int value17;
        int value18;
        int value19;
        int value20;
        int value21;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value22 = DataCanbus.DATA[135];
                int value23 = value22 - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                CarSetControl(11, value23);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value24 = DataCanbus.DATA[135];
                int value25 = value24 + 1;
                if (value25 > 2) {
                    value25 = 0;
                }
                CarSetControl(11, value25);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value26 = DataCanbus.DATA[139];
                int value27 = value26 - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                CarSetControl(17, value27);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value28 = DataCanbus.DATA[139];
                int value29 = value28 + 1;
                if (value29 > 2) {
                    value29 = 0;
                }
                CarSetControl(17, value29);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value30 = DataCanbus.DATA[140];
                int value31 = value30 - 1;
                if (value31 < 0) {
                    value31 = 1;
                }
                CarSetControl(18, value31);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value32 = DataCanbus.DATA[140];
                int value33 = value32 + 1;
                if (value33 > 1) {
                    value33 = 0;
                }
                CarSetControl(18, value33);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                if (DataCanbus.DATA[107] == 0) {
                    CarSetControl(0, 1);
                } else {
                    CarSetControl(0, 0);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                if (DataCanbus.DATA[107] == 0) {
                    CarSetControl(0, 1);
                } else {
                    CarSetControl(0, 0);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                if (DataCanbus.DATA[108] == 0) {
                    CarSetControl(1, 1);
                } else {
                    CarSetControl(1, 0);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                if (DataCanbus.DATA[108] == 0) {
                    CarSetControl(1, 1);
                } else {
                    CarSetControl(1, 0);
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value34 = DataCanbus.DATA[155];
                int value35 = value34 - 1;
                if (value35 < 0) {
                    value35 = 2;
                }
                CarSetControl(25, value35);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value36 = DataCanbus.DATA[155];
                int value37 = value36 + 1;
                if (value37 > 2) {
                    value37 = 0;
                }
                CarSetControl(25, value37);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value38 = DataCanbus.DATA[180];
                int value39 = value38 - 1;
                if (value39 < 0) {
                    value39 = 2;
                }
                CarSetControl(28, value39);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value40 = DataCanbus.DATA[180];
                int value41 = value40 + 1;
                if (value41 > 2) {
                    value41 = 0;
                }
                CarSetControl(28, value41);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value42 = DataCanbus.DATA[178];
                int value43 = value42 - 1;
                if (value43 < 1) {
                    value43 = 3;
                }
                CarSetControl(30, value43);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value44 = DataCanbus.DATA[178];
                int value45 = value44 + 1;
                if (value45 > 3) {
                    value45 = 1;
                }
                CarSetControl(30, value45);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value46 = DataCanbus.DATA[183];
                int value47 = value46 - 1;
                if (value47 < 0) {
                    value47 = 1;
                }
                CarSetControl(32, value47);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value48 = DataCanbus.DATA[183];
                int value49 = value48 + 1;
                if (value49 > 1) {
                    value49 = 0;
                }
                CarSetControl(32, value49);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value50 = DataCanbus.DATA[184];
                int value51 = value50 - 1;
                if (value51 < 0) {
                    value51 = 3;
                }
                CarSetControl(33, value51);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value52 = DataCanbus.DATA[184];
                int value53 = value52 + 1;
                if (value53 > 3) {
                    value53 = 0;
                }
                CarSetControl(33, value53);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value54 = DataCanbus.DATA[188];
                int value55 = value54 - 1;
                if (value55 < 0) {
                    value55 = 2;
                }
                CarSetControl(34, value55);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value56 = DataCanbus.DATA[188];
                int value57 = value56 + 1;
                if (value57 > 2) {
                    value57 = 0;
                }
                CarSetControl(34, value57);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value58 = DataCanbus.DATA[190];
                int value59 = value58 - 1;
                if (value59 < 1) {
                    value59 = 10;
                }
                CarSetControl(39, value59);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value60 = DataCanbus.DATA[190];
                int value61 = value60 + 1;
                if (value61 > 10) {
                    value61 = 1;
                }
                CarSetControl(39, value61);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value62 = DataCanbus.DATA[130];
                if (value62 == 0) {
                    value21 = 1;
                } else {
                    value21 = 0;
                }
                CarSetControl(12, value21);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value63 = DataCanbus.DATA[133];
                if (value63 == 0) {
                    value18 = 1;
                } else {
                    value18 = 0;
                }
                CarSetControl(9, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value64 = DataCanbus.DATA[134];
                if (value64 == 0) {
                    value17 = 1;
                } else {
                    value17 = 0;
                }
                CarSetControl(10, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value65 = DataCanbus.DATA[131];
                if (value65 == 0) {
                    value20 = 1;
                } else {
                    value20 = 0;
                }
                CarSetControl(13, value20);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value66 = DataCanbus.DATA[132];
                if (value66 == 0) {
                    value19 = 1;
                } else {
                    value19 = 0;
                }
                CarSetControl(8, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value67 = DataCanbus.DATA[136];
                if (value67 == 0) {
                    value16 = 1;
                } else {
                    value16 = 0;
                }
                CarSetControl(14, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value68 = DataCanbus.DATA[137];
                if (value68 == 0) {
                    value15 = 1;
                } else {
                    value15 = 0;
                }
                CarSetControl(15, value15);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value69 = DataCanbus.DATA[138];
                if (value69 == 0) {
                    value14 = 1;
                } else {
                    value14 = 0;
                }
                CarSetControl(16, value14);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value70 = DataCanbus.DATA[141];
                if (value70 == 0) {
                    value13 = 1;
                } else {
                    value13 = 0;
                }
                CarSetControl(19, value13);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value71 = DataCanbus.DATA[152];
                if (value71 == 0) {
                    value12 = 1;
                } else {
                    value12 = 0;
                }
                CarSetControl(24, value12);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value72 = DataCanbus.DATA[151];
                if (value72 == 0) {
                    value11 = 1;
                } else {
                    value11 = 0;
                }
                CarSetControl(23, value11);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value73 = DataCanbus.DATA[150];
                if (value73 == 0) {
                    value10 = 1;
                } else {
                    value10 = 0;
                }
                CarSetControl(22, value10);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value74 = DataCanbus.DATA[153];
                if (value74 == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                CarSetControl(26, value9);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value75 = DataCanbus.DATA[154];
                if (value75 == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                CarSetControl(27, value8);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value76 = DataCanbus.DATA[179];
                if (value76 == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                CarSetControl(29, value5);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value77 = DataCanbus.DATA[182];
                if (value77 == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                CarSetControl(31, value4);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value78 = DataCanbus.DATA[185];
                if (value78 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                CarSetControl(35, value3);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value79 = DataCanbus.DATA[186];
                if (value79 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                CarSetControl(36, value2);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value80 = DataCanbus.DATA[187];
                if (value80 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                CarSetControl(37, value);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value81 = DataCanbus.DATA[189];
                if (value81 == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                CarSetControl(38, value7);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value82 = DataCanbus.DATA[191];
                if (value82 == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                CarSetControl(40, value6);
                break;
        }
    }

    private void CarSetControl(int cmd1, int cmd2) {
        DataCanbus.PROXY.cmd(5, new int[]{cmd1, cmd2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
    }
}
