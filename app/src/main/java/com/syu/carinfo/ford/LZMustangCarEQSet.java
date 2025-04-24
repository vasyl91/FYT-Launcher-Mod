package com.syu.carinfo.ford;

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
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZMustangCarEQSet extends BaseActivity implements View.OnClickListener {
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
                case 113:
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
                case 114:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 115:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 118:
                    LZMustangCarEQSet.this.updateLauguageSet();
                    break;
                case 139:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 140:
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
                case 141:
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
                case 142:
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
                case 143:
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
                case 144:
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
                case 145:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 146:
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
                case 152:
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
                case 153:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 154:
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
                case 155:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 156:
                    LZMustangCarEQSet.this.setCheck((CheckedTextView) LZMustangCarEQSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 157:
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
                case 158:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 159:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 160:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 161:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text20)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 162:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 163:
                    if (((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) LZMustangCarEQSet.this.findViewById(R.id.tv_text22)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 164:
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
                case 165:
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
                case 166:
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
                case 167:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_mustang_eqsettings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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
        int value = DataCanbus.DATA[118];
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
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[142];
                if (value > 0) {
                    value--;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[142];
                if (value2 < 14) {
                    value2++;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[141];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[141];
                if (value4 < 14) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[140];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[140];
                if (value6 < 14) {
                    value6++;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[143];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[143];
                if (value8 < 14) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[144];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[144];
                if (value10 < 14) {
                    value10++;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[145];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(11, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[145];
                if (value12 < 7) {
                    value12++;
                }
                setCarInfo(11, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[157];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(15, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[157];
                if (value14 < 1) {
                    value14++;
                }
                setCarInfo(15, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
            case R.id.btn_plus8 /* 2131427478 */:
                int value15 = DataCanbus.DATA[146];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(6, value15);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                setCarInfo(0, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                setCarInfo(0, 1);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value16 = DataCanbus.DATA[37];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo1(160, value16);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value17 = DataCanbus.DATA[37];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo1(160, value17);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value18 = DataCanbus.DATA[113];
                if (value18 == 0) {
                    value18 = 15;
                } else if (value18 == 1) {
                    value18 = 14;
                }
                setCarInfo1(163, value18);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value19 = DataCanbus.DATA[113];
                if (value19 == 0) {
                    value19 = 15;
                } else if (value19 == 1) {
                    value19 = 14;
                }
                setCarInfo1(163, value19);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value20 = DataCanbus.DATA[152];
                if (value20 == 0) {
                    value20 = 17;
                } else if (value20 == 1) {
                    value20 = 16;
                }
                setCarInfo1(163, value20);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value21 = DataCanbus.DATA[152];
                if (value21 == 0) {
                    value21 = 17;
                } else if (value21 == 1) {
                    value21 = 16;
                }
                setCarInfo1(163, value21);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value22 = DataCanbus.DATA[153] - 5;
                if (value22 < 0) {
                    value22 = 0;
                }
                setCarInfo1(177, value22);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value23 = DataCanbus.DATA[153] + 5;
                if (value23 > 100) {
                    value23 = 100;
                }
                setCarInfo1(177, value23);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value24 = DataCanbus.DATA[154] - 1;
                if (value24 < 1) {
                    value24 = 7;
                }
                setCarInfo1(178, value24);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value25 = DataCanbus.DATA[154] + 1;
                if (value25 > 7) {
                    value25 = 1;
                }
                setCarInfo1(178, value25);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                setCarSeatInfo(0, 0);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                setCarSeatInfo(0, 1);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                setCarSeatInfo(1, 0);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                setCarSeatInfo(1, 1);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                setCarSeatInfo(2, 0);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                setCarSeatInfo(2, 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value26 = DataCanbus.DATA[114];
                if (value26 == 0) {
                    value26 = 16;
                } else if (value26 == 1) {
                    value26 = 17;
                }
                setCarInfo1(171, value26);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value27 = DataCanbus.DATA[115];
                if (value27 == 0) {
                    value27 = 19;
                } else if (value27 == 1) {
                    value27 = 18;
                }
                setCarInfo1(171, value27);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZFordDoornumSetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, LuzMustangBaseCarInfo.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, LuzMustangCarTire.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.btn_minus18 /* 2131427894 */:
                int value28 = DataCanbus.DATA[164] - 1;
                if (value28 < 0) {
                    value28 = 2;
                }
                setCarSeatInfo(6, value28);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value29 = DataCanbus.DATA[164] + 1;
                if (value29 > 2) {
                    value29 = 0;
                }
                setCarSeatInfo(6, value29);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value30 = DataCanbus.DATA[165] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarSeatInfo(7, value30);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value31 = DataCanbus.DATA[165] + 1;
                if (value31 > 2) {
                    value31 = 0;
                }
                setCarSeatInfo(7, value31);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                setCarSeatInfo(4, 0);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                setCarSeatInfo(4, 1);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                setCarSeatInfo(5, 0);
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                setCarSeatInfo(5, 1);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                setCarSeatInfo(3, 0);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                setCarSeatInfo(3, 1);
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                int value32 = DataCanbus.DATA[167] + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarSeatInfo(9, value32);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value33 = DataCanbus.DATA[166] + 1;
                if (value33 > 2) {
                    value33 = 0;
                }
                setCarSeatInfo(8, value33);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value34 = DataCanbus.DATA[166] - 1;
                if (value34 < 0) {
                    value34 = 2;
                }
                setCarSeatInfo(8, value34);
                break;
            case R.id.btn_minus24 /* 2131428307 */:
                int value35 = DataCanbus.DATA[167] - 1;
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{99}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
    }
}
