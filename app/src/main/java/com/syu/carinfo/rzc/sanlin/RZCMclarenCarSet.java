package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import java.util.ArrayList;

public class RZCMclarenCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 100:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 101:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_put_it_away_forever);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_sports_and_track_mode_folded_up);
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_track_mode_folded_up);
                                break;
                            case 3:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_folded_out_forever);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_both_sides);
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_passenger);
                                break;
                        }
                    }
                    break;
                case 103:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 104:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 105:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 106:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 107:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_distribution0);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_both_sides);
                                break;
                        }
                    }
                    break;
                case 108:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 109:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text5)).setText("PZERO");
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text5)).setText("CORSA");
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text5)).setText("WINTER");
                                break;
                            case 3:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text5)).setText("TROFEO");
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_reckon_by_time);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 112:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 113:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text8)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text8)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text8)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text8)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text9)).setText("15S");
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text9)).setText("30S");
                                break;
                            case 3:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text9)).setText("45S");
                                break;
                            case 4:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text9)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 115:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 116:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 117:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 118:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 119:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.str_on_and_light);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 121:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 122:
                    RZCMclarenCarSet.this.updateLauguageSet();
                    break;
                case 123:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)).setText("mpg(UK)");
                                break;
                            case 3:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)).setText("mpg(US)");
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text15)).setText("km/h & km");
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text15)).setText("mph & miles");
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)).setText("kPa");
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)).setText(CamryData.PRESSURE_UNIT_PSI);
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text17)).setText("℉");
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text17)).setText("℃");
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text18)).setText("+" + (val - 10));
                            break;
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text18)).setText("-" + (10 - val));
                            break;
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text18)).setText("0");
                            break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)).setText("+" + (val - 10));
                            break;
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)).setText("-" + (10 - val));
                            break;
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)).setText("0");
                            break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)).setText("+" + (val - 10));
                            break;
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)).setText("-" + (10 - val));
                            break;
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)).setText("0");
                            break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)).setText("R" + (val - 10));
                            break;
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)).setText("L" + (10 - val));
                            break;
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)).setText("0");
                            break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)).setText("R" + (val - 10));
                            break;
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)).setText("F" + (10 - val));
                            break;
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)).setText("0");
                            break;
                        }
                    }
                    break;
                case 132:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text23)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 133:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text24)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 134:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 135:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 136:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_rzc_mclaren_settings);
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
                RZCMclarenCarSet.this.language_set = position;
                if (RZCMclarenCarSet.this.language_set >= 0 && RZCMclarenCarSet.this.language_set <= RZCMclarenCarSet.this.mLauStylelist.size() && RZCMclarenCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{48, RZCMclarenCarSet.this.send_lang[RZCMclarenCarSet.this.language_set]}, null, null);
                }
                RZCMclarenCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[122];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCMclarenCarSet.this.mLauStyle == null) {
                    RZCMclarenCarSet.this.initLauStyle();
                }
                if (RZCMclarenCarSet.this.mLauStyle != null && RZCMclarenCarSet.this.mPopShowView != null) {
                    RZCMclarenCarSet.this.mLauStyle.showAtLocation(RZCMclarenCarSet.this.mPopShowView, 17, 0, 0);
                    RZCMclarenCarSet.this.updateLauguageSet();
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
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i}, null, null);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(3, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(3, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[102] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(4, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[102] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(4, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[107] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(10, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[107] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(10, value8, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[109] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(12, value9, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[109] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(12, value10, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[110] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(14, value11, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[110] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(14, value12, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[111] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(15, value13, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[111] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(15, value14, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[113] - 1;
                if (value15 < 0) {
                    value15 = 4;
                }
                setCarInfo(32, value15, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[113] + 1;
                if (value16 > 4) {
                    value16 = 0;
                }
                setCarInfo(32, value16, 0);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[114] - 1;
                if (value17 < 0) {
                    value17 = 4;
                }
                setCarInfo(33, value17, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[114] + 1;
                if (value18 > 4) {
                    value18 = 0;
                }
                setCarInfo(33, value18, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[116] - 1;
                if (value19 < 1) {
                    value19 = 7;
                }
                setCarInfo(35, value19, 0);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[116] + 1;
                if (value20 > 7) {
                    value20 = 1;
                }
                setCarInfo(35, value20, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[119];
                int value1 = DataCanbus.DATA[135];
                int value22 = DataCanbus.DATA[136];
                int value23 = value21 - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(38, value23, ((value1 << 4) & 240) | (value22 & 15));
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value24 = DataCanbus.DATA[119];
                int value110 = DataCanbus.DATA[135];
                int value25 = DataCanbus.DATA[136];
                int value26 = value24 + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(38, value26, ((value110 << 4) & 240) | (value25 & 15));
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value27 = DataCanbus.DATA[119];
                int value111 = DataCanbus.DATA[135];
                int value28 = DataCanbus.DATA[136];
                int value112 = value111 - 1;
                if (value112 < 0) {
                    value112 = 11;
                }
                setCarInfo(38, value27, ((value112 << 4) & 240) | (value28 & 15));
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value29 = DataCanbus.DATA[119];
                int value113 = DataCanbus.DATA[135];
                int value210 = DataCanbus.DATA[136];
                int value114 = value113 + 1;
                if (value114 > 11) {
                    value114 = 0;
                }
                setCarInfo(38, value29, ((value114 << 4) & 240) | (value210 & 15));
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value30 = DataCanbus.DATA[119];
                int value115 = DataCanbus.DATA[135];
                int value211 = DataCanbus.DATA[136];
                int value212 = value211 - 1;
                if (value212 < 0) {
                    value212 = 7;
                }
                setCarInfo(38, value30, ((value115 << 4) & 240) | (value212 & 15));
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value31 = DataCanbus.DATA[119];
                int value116 = DataCanbus.DATA[135];
                int value213 = DataCanbus.DATA[136];
                int value214 = value213 + 1;
                if (value214 > 7) {
                    value214 = 0;
                }
                setCarInfo(38, value31, ((value116 << 4) & 240) | (value214 & 15));
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value32 = DataCanbus.DATA[123] - 1;
                if (value32 < 0) {
                    value32 = 3;
                }
                setCarInfo(49, value32, 0);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value33 = DataCanbus.DATA[123] + 1;
                if (value33 > 3) {
                    value33 = 0;
                }
                setCarInfo(49, value33, 0);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value34 = DataCanbus.DATA[124] - 1;
                if (value34 < 0) {
                    value34 = 1;
                }
                setCarInfo(50, value34, 0);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value35 = DataCanbus.DATA[124] + 1;
                if (value35 > 1) {
                    value35 = 0;
                }
                setCarInfo(50, value35, 0);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value36 = DataCanbus.DATA[125] - 1;
                if (value36 < 0) {
                    value36 = 2;
                }
                setCarInfo(51, value36, 0);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value37 = DataCanbus.DATA[125] + 1;
                if (value37 > 2) {
                    value37 = 0;
                }
                setCarInfo(51, value37, 0);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value38 = DataCanbus.DATA[126] - 1;
                if (value38 < 0) {
                    value38 = 1;
                }
                setCarInfo(52, value38, 0);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value39 = DataCanbus.DATA[126] + 1;
                if (value39 > 1) {
                    value39 = 0;
                }
                setCarInfo(52, value39, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(2, DataCanbus.DATA[100] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(6, DataCanbus.DATA[103] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(7, DataCanbus.DATA[104] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(8, DataCanbus.DATA[105] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(9, DataCanbus.DATA[106] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(11, DataCanbus.DATA[108] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(16, DataCanbus.DATA[112] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(34, DataCanbus.DATA[115] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(36, DataCanbus.DATA[117] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(37, DataCanbus.DATA[118] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                dialog(R.string.bsd_klj_str17, 39);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(40, DataCanbus.DATA[121] == 1 ? 0 : 1, 0);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value0 = DataCanbus.DATA[127];
                int value117 = DataCanbus.DATA[128];
                int value215 = DataCanbus.DATA[129];
                int value310 = DataCanbus.DATA[130];
                int value42 = DataCanbus.DATA[131];
                int value5_4 = DataCanbus.DATA[132];
                int value5_0 = DataCanbus.DATA[133];
                int value62 = DataCanbus.DATA[134];
                if (value0 > 0) {
                    value0--;
                }
                setAmpInfo(value0, value117, value215, value310, value42, (value5_0 & 15) | ((value5_4 << 4) & 240), value62);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value02 = DataCanbus.DATA[127];
                int value118 = DataCanbus.DATA[128];
                int value216 = DataCanbus.DATA[129];
                int value311 = DataCanbus.DATA[130];
                int value43 = DataCanbus.DATA[131];
                int value5_42 = DataCanbus.DATA[132];
                int value5_02 = DataCanbus.DATA[133];
                int value63 = DataCanbus.DATA[134];
                if (value02 < 19) {
                    value02++;
                }
                setAmpInfo(value02, value118, value216, value311, value43, (value5_02 & 15) | ((value5_42 << 4) & 240), value63);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value03 = DataCanbus.DATA[127];
                int value119 = DataCanbus.DATA[128];
                int value217 = DataCanbus.DATA[129];
                int value312 = DataCanbus.DATA[130];
                int value44 = DataCanbus.DATA[131];
                int value5_43 = DataCanbus.DATA[132];
                int value5_03 = DataCanbus.DATA[133];
                int value64 = DataCanbus.DATA[134];
                if (value119 > 0) {
                    value119--;
                }
                setAmpInfo(value03, value119, value217, value312, value44, (value5_03 & 15) | ((value5_43 << 4) & 240), value64);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value04 = DataCanbus.DATA[127];
                int value120 = DataCanbus.DATA[128];
                int value218 = DataCanbus.DATA[129];
                int value313 = DataCanbus.DATA[130];
                int value45 = DataCanbus.DATA[131];
                int value5_44 = DataCanbus.DATA[132];
                int value5_04 = DataCanbus.DATA[133];
                int value65 = DataCanbus.DATA[134];
                if (value120 < 19) {
                    value120++;
                }
                setAmpInfo(value04, value120, value218, value313, value45, (value5_04 & 15) | ((value5_44 << 4) & 240), value65);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value05 = DataCanbus.DATA[127];
                int value121 = DataCanbus.DATA[128];
                int value219 = DataCanbus.DATA[129];
                int value314 = DataCanbus.DATA[130];
                int value46 = DataCanbus.DATA[131];
                int value5_45 = DataCanbus.DATA[132];
                int value5_05 = DataCanbus.DATA[133];
                int value66 = DataCanbus.DATA[134];
                if (value314 > 0) {
                    value314--;
                }
                setAmpInfo(value05, value121, value219, value314, value46, (value5_05 & 15) | ((value5_45 << 4) & 240), value66);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value06 = DataCanbus.DATA[127];
                int value122 = DataCanbus.DATA[128];
                int value220 = DataCanbus.DATA[129];
                int value315 = DataCanbus.DATA[130];
                int value47 = DataCanbus.DATA[131];
                int value5_46 = DataCanbus.DATA[132];
                int value5_06 = DataCanbus.DATA[133];
                int value67 = DataCanbus.DATA[134];
                if (value315 < 19) {
                    value315++;
                }
                setAmpInfo(value06, value122, value220, value315, value47, (value5_06 & 15) | ((value5_46 << 4) & 240), value67);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                int value07 = DataCanbus.DATA[127];
                int value123 = DataCanbus.DATA[128];
                int value221 = DataCanbus.DATA[129];
                int value316 = DataCanbus.DATA[130];
                int value48 = DataCanbus.DATA[131];
                int value5_47 = DataCanbus.DATA[132];
                int value5_07 = DataCanbus.DATA[133];
                int value68 = DataCanbus.DATA[134];
                if (value48 > 0) {
                    value48--;
                }
                setAmpInfo(value07, value123, value221, value316, value48, (value5_07 & 15) | ((value5_47 << 4) & 240), value68);
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                int value08 = DataCanbus.DATA[127];
                int value124 = DataCanbus.DATA[128];
                int value222 = DataCanbus.DATA[129];
                int value317 = DataCanbus.DATA[130];
                int value49 = DataCanbus.DATA[131];
                int value5_48 = DataCanbus.DATA[132];
                int value5_08 = DataCanbus.DATA[133];
                int value69 = DataCanbus.DATA[134];
                if (value49 < 19) {
                    value49++;
                }
                setAmpInfo(value08, value124, value222, value317, value49, (value5_08 & 15) | ((value5_48 << 4) & 240), value69);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value09 = DataCanbus.DATA[127];
                int value125 = DataCanbus.DATA[128];
                int value223 = DataCanbus.DATA[129];
                int value318 = DataCanbus.DATA[130];
                int value410 = DataCanbus.DATA[131];
                int value5_49 = DataCanbus.DATA[132];
                int value5_09 = DataCanbus.DATA[133];
                int value610 = DataCanbus.DATA[134];
                if (value223 > 0) {
                    value223--;
                }
                setAmpInfo(value09, value125, value223, value318, value410, (value5_09 & 15) | ((value5_49 << 4) & 240), value610);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value010 = DataCanbus.DATA[127];
                int value126 = DataCanbus.DATA[128];
                int value224 = DataCanbus.DATA[129];
                int value319 = DataCanbus.DATA[130];
                int value411 = DataCanbus.DATA[131];
                int value5_410 = DataCanbus.DATA[132];
                int value5_010 = DataCanbus.DATA[133];
                int value611 = DataCanbus.DATA[134];
                if (value224 < 19) {
                    value224++;
                }
                setAmpInfo(value010, value126, value224, value319, value411, (value5_010 & 15) | ((value5_410 << 4) & 240), value611);
                break;
            case R.id.btn_plus25 /* 2131427926 */:
                int value011 = DataCanbus.DATA[127];
                int value127 = DataCanbus.DATA[128];
                int value225 = DataCanbus.DATA[129];
                int value320 = DataCanbus.DATA[130];
                int value412 = DataCanbus.DATA[131];
                int value5_411 = DataCanbus.DATA[132];
                int value5_011 = DataCanbus.DATA[133];
                int value612 = DataCanbus.DATA[134];
                if (value612 < 40) {
                    value612++;
                }
                setAmpInfo(value011, value127, value225, value320, value412, (value5_011 & 15) | ((value5_411 << 4) & 240), value612);
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                int value012 = DataCanbus.DATA[127];
                int value128 = DataCanbus.DATA[128];
                int value226 = DataCanbus.DATA[129];
                int value321 = DataCanbus.DATA[130];
                int value413 = DataCanbus.DATA[131];
                int value5_412 = DataCanbus.DATA[132];
                int value5_012 = DataCanbus.DATA[133];
                int value613 = DataCanbus.DATA[134];
                int value5_013 = value5_012 + 1;
                if (value5_013 > 3) {
                    value5_013 = 0;
                }
                setAmpInfo(value012, value128, value226, value321, value413, (value5_013 & 15) | ((value5_412 << 4) & 240), value613);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value013 = DataCanbus.DATA[127];
                int value129 = DataCanbus.DATA[128];
                int value227 = DataCanbus.DATA[129];
                int value322 = DataCanbus.DATA[130];
                int value414 = DataCanbus.DATA[131];
                int value5_413 = DataCanbus.DATA[132];
                int value5_014 = DataCanbus.DATA[133];
                int value614 = DataCanbus.DATA[134];
                int value5_414 = value5_413 + 1;
                if (value5_414 > 2) {
                    value414 = 0;
                }
                setAmpInfo(value013, value129, value227, value322, value414, (value5_014 & 15) | ((value5_414 << 4) & 240), value614);
                break;
            case R.id.btn_minus25 /* 2131428303 */:
                int value014 = DataCanbus.DATA[127];
                int value130 = DataCanbus.DATA[128];
                int value228 = DataCanbus.DATA[129];
                int value323 = DataCanbus.DATA[130];
                int value415 = DataCanbus.DATA[131];
                int value5_415 = DataCanbus.DATA[132];
                int value5_015 = DataCanbus.DATA[133];
                int value615 = DataCanbus.DATA[134];
                if (value615 > 0) {
                    value615--;
                }
                setAmpInfo(value014, value130, value228, value323, value415, (value5_015 & 15) | ((value5_415 << 4) & 240), value615);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value015 = DataCanbus.DATA[127];
                int value131 = DataCanbus.DATA[128];
                int value229 = DataCanbus.DATA[129];
                int value324 = DataCanbus.DATA[130];
                int value416 = DataCanbus.DATA[131];
                int value5_416 = DataCanbus.DATA[132];
                int value5_016 = DataCanbus.DATA[133];
                int value616 = DataCanbus.DATA[134];
                int value5_417 = value5_416 - 1;
                if (value5_417 < 0) {
                    value5_417 = 2;
                }
                setAmpInfo(value015, value131, value229, value324, value416, (value5_016 & 15) | ((value5_417 << 4) & 240), value616);
                break;
            case R.id.btn_minus24 /* 2131428307 */:
                int value016 = DataCanbus.DATA[127];
                int value132 = DataCanbus.DATA[128];
                int value230 = DataCanbus.DATA[129];
                int value325 = DataCanbus.DATA[130];
                int value417 = DataCanbus.DATA[131];
                int value5_418 = DataCanbus.DATA[132];
                int value5_017 = DataCanbus.DATA[133];
                int value617 = DataCanbus.DATA[134];
                int value5_018 = value5_017 - 1;
                if (value5_018 < 0) {
                    value5_018 = 3;
                }
                setAmpInfo(value016, value132, value230, value325, value417, (value5_018 & 15) | ((value5_418 << 4) & 240), value617);
                break;
        }
    }

    public void setAmpInfo(int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2, value3, value4, value5, value6, value7}, null, null);
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
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
    }
}
