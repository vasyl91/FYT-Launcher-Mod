package com.syu.carinfo.ford;

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
public class LZMustangCarEQSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZMustangCarEQSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text10)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text10)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text11)).setText("km");
                                break;
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text11)).setText("mile");
                                break;
                        }
                    }
                    break;
                case 102:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 103:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 106:
                    LZMustangCarEQSet.this.updateLauguageSet();
                    break;
                case 127:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 128:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 7) {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 7) {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 7) {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text1)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 7) {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 132:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 7) {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 134:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_distribution1);
                                break;
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_distribution0);
                                break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_Manual);
                                break;
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 141:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 142:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_0);
                                break;
                            case 2:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_1);
                                break;
                            case 3:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_2);
                                break;
                            case 4:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_3);
                                break;
                            case 5:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_4);
                                break;
                            case 6:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_5);
                                break;
                            case 7:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_6);
                                break;
                            default:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_403_ambient_0);
                                break;
                        }
                    }
                    break;
                case 143:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 144:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 145:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text7)).setText(R.string.haval_volspeed1);
                                break;
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_surroundsound);
                                break;
                        }
                    }
                    break;
                case 146:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 147:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 148:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 149:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text20)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 150:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 151:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text22)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 152:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text18)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 153:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text19)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text19)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text19)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 154:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text23)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text23)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text23)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text24)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text24)).setText(R.string.off);
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
        setContentView(R.layout.layout_0452_lz_mustang_eqsettings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.ford.LZMustangCarEQSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZMustangCarEQSet.this.language_set = position;
                if (LZMustangCarEQSet.this.language_set >= 0 && LZMustangCarEQSet.this.language_set <= LZMustangCarEQSet.this.mLauStylelist.size() && LZMustangCarEQSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{164, LZMustangCarEQSet.this.send_lang[LZMustangCarEQSet.this.language_set]}, null, null);
                }
                LZMustangCarEQSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[106];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 18, 22, 23, 27, 28};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.LZMustangCarEQSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZMustangCarEQSet.this.mLauStyle == null) {
                    LZMustangCarEQSet.this.initLauStyle();
                }
                if (LZMustangCarEQSet.this.mLauStyle != null && LZMustangCarEQSet.this.mPopShowView != null) {
                    LZMustangCarEQSet.this.mLauStyle.showAtLocation(LZMustangCarEQSet.this.mPopShowView, 17, 0, 0);
                    LZMustangCarEQSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[141] - 5;
                if (value < 0) {
                    value = 0;
                }
                setCarInfo1(177, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[141] + 5;
                if (value2 > 100) {
                    value2 = 100;
                }
                setCarInfo1(177, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[142] - 1;
                if (value3 < 1) {
                    value3 = 7;
                }
                setCarInfo1(178, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[142] + 1;
                if (value4 > 7) {
                    value4 = 1;
                }
                setCarInfo1(178, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                setCarSeatInfo(0, 0);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                setCarSeatInfo(0, 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value5 = DataCanbus.DATA[130];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value6 = DataCanbus.DATA[130];
                if (value6 < 14) {
                    value6++;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value7 = DataCanbus.DATA[129];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value8 = DataCanbus.DATA[129];
                if (value8 < 14) {
                    value8++;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value9 = DataCanbus.DATA[128];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(1, value9);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value10 = DataCanbus.DATA[128];
                if (value10 < 14) {
                    value10++;
                }
                setCarInfo(1, value10);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value11 = DataCanbus.DATA[131];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 < 14) {
                    value12++;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value13 = DataCanbus.DATA[132];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(5, value13);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value14 = DataCanbus.DATA[132];
                if (value14 < 14) {
                    value14++;
                }
                setCarInfo(5, value14);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value15 = DataCanbus.DATA[133];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(11, value15);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value16 = DataCanbus.DATA[133];
                if (value16 < 7) {
                    value16++;
                }
                setCarInfo(11, value16);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value17 = DataCanbus.DATA[145];
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo(15, value17);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value18 = DataCanbus.DATA[145];
                if (value18 < 1) {
                    value18++;
                }
                setCarInfo(15, value18);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
            case R.id.btn_plus8 /* 2131427511 */:
                int value19 = DataCanbus.DATA[134];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(6, value19);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                setCarInfo(0, 0);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                setCarInfo(0, 1);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value20 = DataCanbus.DATA[37];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo1(160, value20);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value21 = DataCanbus.DATA[37];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo1(160, value21);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value22 = DataCanbus.DATA[101];
                if (value22 == 0) {
                    value22 = 15;
                } else if (value22 == 1) {
                    value22 = 14;
                }
                setCarInfo1(163, value22);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value23 = DataCanbus.DATA[101];
                if (value23 == 0) {
                    value23 = 15;
                } else if (value23 == 1) {
                    value23 = 14;
                }
                setCarInfo1(163, value23);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value24 = DataCanbus.DATA[140];
                if (value24 == 0) {
                    value24 = 17;
                } else if (value24 == 1) {
                    value24 = 16;
                }
                setCarInfo1(163, value24);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value25 = DataCanbus.DATA[140];
                if (value25 == 0) {
                    value25 = 17;
                } else if (value25 == 1) {
                    value25 = 16;
                }
                setCarInfo1(163, value25);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value26 = DataCanbus.DATA[102];
                if (value26 == 0) {
                    value26 = 16;
                } else if (value26 == 1) {
                    value26 = 17;
                }
                setCarInfo1(171, value26);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value27 = DataCanbus.DATA[103];
                if (value27 == 0) {
                    value27 = 19;
                } else if (value27 == 1) {
                    value27 = 18;
                }
                setCarInfo1(171, value27);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value28 = DataCanbus.DATA[152] - 1;
                if (value28 < 0) {
                    value28 = 2;
                }
                setCarSeatInfo(6, value28);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value29 = DataCanbus.DATA[152] + 1;
                if (value29 > 2) {
                    value29 = 0;
                }
                setCarSeatInfo(6, value29);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value30 = DataCanbus.DATA[153] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarSeatInfo(7, value30);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value31 = DataCanbus.DATA[153] + 1;
                if (value31 > 2) {
                    value31 = 0;
                }
                setCarSeatInfo(7, value31);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                setCarSeatInfo(4, 0);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                setCarSeatInfo(4, 1);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                setCarSeatInfo(5, 0);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                setCarSeatInfo(5, 1);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                setCarSeatInfo(1, 0);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                setCarSeatInfo(1, 1);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                setCarSeatInfo(2, 0);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                setCarSeatInfo(2, 1);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                setCarSeatInfo(3, 0);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                setCarSeatInfo(3, 1);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value32 = DataCanbus.DATA[155] + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarSeatInfo(9, value32);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value33 = DataCanbus.DATA[154] + 1;
                if (value33 > 2) {
                    value33 = 0;
                }
                setCarSeatInfo(8, value33);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value34 = DataCanbus.DATA[154] - 1;
                if (value34 < 0) {
                    value34 = 2;
                }
                setCarSeatInfo(8, value34);
                break;
            case R.id.btn_minus24 /* 2131428319 */:
                int value35 = DataCanbus.DATA[155] - 1;
                if (value35 < 0) {
                    value35 = 2;
                }
                setCarSeatInfo(9, value35);
                break;
        }
    }

    public void setCarInfo1(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    public void setCarSeatInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{99}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
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
