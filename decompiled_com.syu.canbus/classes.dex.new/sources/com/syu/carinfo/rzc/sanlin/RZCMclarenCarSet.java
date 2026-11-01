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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCMclarenCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet.1
        @Override // com.syu.module.IUiNotify
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
                    }
                    break;
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
                    }
                    break;
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
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text18)).setText("-" + (10 - val));
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text18)).setText("0");
                        }
                    }
                    break;
                case 128:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)).setText("+" + (val - 10));
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)).setText("-" + (10 - val));
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text19)).setText("0");
                        }
                    }
                    break;
                case 129:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)).setText("+" + (val - 10));
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)).setText("-" + (10 - val));
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text20)).setText("0");
                        }
                    }
                    break;
                case 130:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)).setText("R" + (val - 10));
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)).setText("L" + (10 - val));
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text21)).setText("0");
                        }
                    }
                    break;
                case 131:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)) != null) {
                        if (val > 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)).setText("R" + (val - 10));
                        } else if (val < 10) {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)).setText("F" + (10 - val));
                        } else {
                            ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text22)).setText("0");
                        }
                    }
                    break;
                case 132:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text23)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 133:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text24)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 134:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 135:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 136:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_mclaren_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RZCMclarenCarSet.this.language_set = position;
                if (RZCMclarenCarSet.this.language_set >= 0 && RZCMclarenCarSet.this.language_set <= RZCMclarenCarSet.this.mLauStylelist.size() && RZCMclarenCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{48, RZCMclarenCarSet.this.send_lang[RZCMclarenCarSet.this.language_set], 0}, null, null);
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

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet.3
            @Override // android.view.View.OnClickListener
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i, 0, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(3, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(3, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[102] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(4, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[102] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(4, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[107] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(10, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[107] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(10, value8, 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[109] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(12, value9, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[109] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(12, value10, 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[110] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(14, value11, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[110] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(14, value12, 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[111] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(15, value13, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[111] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(15, value14, 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[113] - 1;
                if (value15 < 0) {
                    value15 = 4;
                }
                setCarInfo(32, value15, 0);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[113] + 1;
                if (value16 > 4) {
                    value16 = 0;
                }
                setCarInfo(32, value16, 0);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[114] - 1;
                if (value17 < 0) {
                    value17 = 4;
                }
                setCarInfo(33, value17, 0);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[114] + 1;
                if (value18 > 4) {
                    value18 = 0;
                }
                setCarInfo(33, value18, 0);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[116] - 1;
                if (value19 < 1) {
                    value19 = 7;
                }
                setCarInfo(35, value19, 0);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[116] + 1;
                if (value20 > 7) {
                    value20 = 1;
                }
                setCarInfo(35, value20, 0);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[119];
                int value1 = DataCanbus.DATA[135];
                int value22 = DataCanbus.DATA[136];
                int value23 = value21 - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(38, value23, ((value1 << 4) & 240) | (value22 & 15));
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value24 = DataCanbus.DATA[119];
                int value25 = DataCanbus.DATA[135];
                int value26 = DataCanbus.DATA[136];
                int value27 = value24 + 1;
                if (value27 > 2) {
                    value27 = 0;
                }
                setCarInfo(38, value27, ((value25 << 4) & 240) | (value26 & 15));
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value28 = DataCanbus.DATA[119];
                int value29 = DataCanbus.DATA[135];
                int value30 = DataCanbus.DATA[136];
                int value31 = value29 - 1;
                if (value31 < 0) {
                    value31 = 11;
                }
                setCarInfo(38, value28, ((value31 << 4) & 240) | (value30 & 15));
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value32 = DataCanbus.DATA[119];
                int value33 = DataCanbus.DATA[135];
                int value34 = DataCanbus.DATA[136];
                int value35 = value33 + 1;
                if (value35 > 11) {
                    value35 = 0;
                }
                setCarInfo(38, value32, ((value35 << 4) & 240) | (value34 & 15));
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value36 = DataCanbus.DATA[119];
                int value37 = DataCanbus.DATA[135];
                int value38 = DataCanbus.DATA[136];
                int value39 = value38 - 1;
                if (value39 < 0) {
                    value39 = 7;
                }
                setCarInfo(38, value36, ((value37 << 4) & 240) | (value39 & 15));
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value40 = DataCanbus.DATA[119];
                int value41 = DataCanbus.DATA[135];
                int value42 = DataCanbus.DATA[136];
                int value43 = value42 + 1;
                if (value43 > 7) {
                    value43 = 0;
                }
                setCarInfo(38, value40, ((value41 << 4) & 240) | (value43 & 15));
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value44 = DataCanbus.DATA[123] - 1;
                if (value44 < 0) {
                    value44 = 3;
                }
                setCarInfo(49, value44, 0);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value45 = DataCanbus.DATA[123] + 1;
                if (value45 > 3) {
                    value45 = 0;
                }
                setCarInfo(49, value45, 0);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value46 = DataCanbus.DATA[124] - 1;
                if (value46 < 0) {
                    value46 = 1;
                }
                setCarInfo(50, value46, 0);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value47 = DataCanbus.DATA[124] + 1;
                if (value47 > 1) {
                    value47 = 0;
                }
                setCarInfo(50, value47, 0);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value48 = DataCanbus.DATA[125] - 1;
                if (value48 < 0) {
                    value48 = 2;
                }
                setCarInfo(51, value48, 0);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value49 = DataCanbus.DATA[125] + 1;
                if (value49 > 2) {
                    value49 = 0;
                }
                setCarInfo(51, value49, 0);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value50 = DataCanbus.DATA[126] - 1;
                if (value50 < 0) {
                    value50 = 1;
                }
                setCarInfo(52, value50, 0);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value51 = DataCanbus.DATA[126] + 1;
                if (value51 > 1) {
                    value51 = 0;
                }
                setCarInfo(52, value51, 0);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value0 = DataCanbus.DATA[127];
                int value52 = DataCanbus.DATA[128];
                int value53 = DataCanbus.DATA[129];
                int value54 = DataCanbus.DATA[130];
                int value55 = DataCanbus.DATA[131];
                int value5_4 = DataCanbus.DATA[132];
                int value5_0 = DataCanbus.DATA[133];
                int value56 = DataCanbus.DATA[134];
                if (value0 > 0) {
                    value0--;
                }
                setAmpInfo(value0, value52, value53, value54, value55, (value5_0 & 15) | ((value5_4 << 4) & 240), value56);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value57 = DataCanbus.DATA[127];
                int value58 = DataCanbus.DATA[128];
                int value59 = DataCanbus.DATA[129];
                int value60 = DataCanbus.DATA[130];
                int value61 = DataCanbus.DATA[131];
                int value5_5 = DataCanbus.DATA[132];
                int value5_1 = DataCanbus.DATA[133];
                int value62 = DataCanbus.DATA[134];
                if (value57 < 19) {
                    value57++;
                }
                setAmpInfo(value57, value58, value59, value60, value61, (value5_1 & 15) | ((value5_5 << 4) & 240), value62);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(2, DataCanbus.DATA[100] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(8, DataCanbus.DATA[105] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(9, DataCanbus.DATA[106] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(6, DataCanbus.DATA[103] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(7, DataCanbus.DATA[104] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(11, DataCanbus.DATA[108] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(16, DataCanbus.DATA[112] == 1 ? 0 : 1, 0);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value63 = DataCanbus.DATA[127];
                int value64 = DataCanbus.DATA[128];
                int value65 = DataCanbus.DATA[129];
                int value66 = DataCanbus.DATA[130];
                int value67 = DataCanbus.DATA[131];
                int value5_6 = DataCanbus.DATA[132];
                int value5_2 = DataCanbus.DATA[133];
                int value68 = DataCanbus.DATA[134];
                if (value64 > 0) {
                    value64--;
                }
                setAmpInfo(value63, value64, value65, value66, value67, (value5_2 & 15) | ((value5_6 << 4) & 240), value68);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value69 = DataCanbus.DATA[127];
                int value70 = DataCanbus.DATA[128];
                int value71 = DataCanbus.DATA[129];
                int value72 = DataCanbus.DATA[130];
                int value73 = DataCanbus.DATA[131];
                int value5_7 = DataCanbus.DATA[132];
                int value5_3 = DataCanbus.DATA[133];
                int value74 = DataCanbus.DATA[134];
                if (value70 < 19) {
                    value70++;
                }
                setAmpInfo(value69, value70, value71, value72, value73, (value5_3 & 15) | ((value5_7 << 4) & 240), value74);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value75 = DataCanbus.DATA[127];
                int value76 = DataCanbus.DATA[128];
                int value77 = DataCanbus.DATA[129];
                int value78 = DataCanbus.DATA[130];
                int value79 = DataCanbus.DATA[131];
                int value5_8 = DataCanbus.DATA[132];
                int value5_9 = DataCanbus.DATA[133];
                int value80 = DataCanbus.DATA[134];
                if (value77 > 0) {
                    value77--;
                }
                setAmpInfo(value75, value76, value77, value78, value79, (value5_9 & 15) | ((value5_8 << 4) & 240), value80);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value81 = DataCanbus.DATA[127];
                int value82 = DataCanbus.DATA[128];
                int value83 = DataCanbus.DATA[129];
                int value84 = DataCanbus.DATA[130];
                int value85 = DataCanbus.DATA[131];
                int value5_10 = DataCanbus.DATA[132];
                int value5_11 = DataCanbus.DATA[133];
                int value86 = DataCanbus.DATA[134];
                if (value83 < 19) {
                    value83++;
                }
                setAmpInfo(value81, value82, value83, value84, value85, (value5_11 & 15) | ((value5_10 << 4) & 240), value86);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value87 = DataCanbus.DATA[127];
                int value88 = DataCanbus.DATA[128];
                int value89 = DataCanbus.DATA[129];
                int value90 = DataCanbus.DATA[130];
                int value91 = DataCanbus.DATA[131];
                int value5_12 = DataCanbus.DATA[132];
                int value5_13 = DataCanbus.DATA[133];
                int value92 = DataCanbus.DATA[134];
                if (value90 > 0) {
                    value90--;
                }
                setAmpInfo(value87, value88, value89, value90, value91, (value5_13 & 15) | ((value5_12 << 4) & 240), value92);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value93 = DataCanbus.DATA[127];
                int value94 = DataCanbus.DATA[128];
                int value95 = DataCanbus.DATA[129];
                int value96 = DataCanbus.DATA[130];
                int value97 = DataCanbus.DATA[131];
                int value5_14 = DataCanbus.DATA[132];
                int value5_15 = DataCanbus.DATA[133];
                int value98 = DataCanbus.DATA[134];
                if (value96 < 19) {
                    value96++;
                }
                setAmpInfo(value93, value94, value95, value96, value97, (value5_15 & 15) | ((value5_14 << 4) & 240), value98);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int value99 = DataCanbus.DATA[127];
                int value100 = DataCanbus.DATA[128];
                int value101 = DataCanbus.DATA[129];
                int value102 = DataCanbus.DATA[130];
                int value103 = DataCanbus.DATA[131];
                int value5_16 = DataCanbus.DATA[132];
                int value5_17 = DataCanbus.DATA[133];
                int value104 = DataCanbus.DATA[134];
                if (value103 > 0) {
                    value103--;
                }
                setAmpInfo(value99, value100, value101, value102, value103, (value5_17 & 15) | ((value5_16 << 4) & 240), value104);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int value105 = DataCanbus.DATA[127];
                int value106 = DataCanbus.DATA[128];
                int value107 = DataCanbus.DATA[129];
                int value108 = DataCanbus.DATA[130];
                int value109 = DataCanbus.DATA[131];
                int value5_18 = DataCanbus.DATA[132];
                int value5_19 = DataCanbus.DATA[133];
                int value110 = DataCanbus.DATA[134];
                if (value109 < 19) {
                    value109++;
                }
                setAmpInfo(value105, value106, value107, value108, value109, (value5_19 & 15) | ((value5_18 << 4) & 240), value110);
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int value111 = DataCanbus.DATA[127];
                int value112 = DataCanbus.DATA[128];
                int value113 = DataCanbus.DATA[129];
                int value114 = DataCanbus.DATA[130];
                int value115 = DataCanbus.DATA[131];
                int value5_20 = DataCanbus.DATA[132];
                int value5_21 = DataCanbus.DATA[133];
                int value116 = DataCanbus.DATA[134];
                int value5_22 = value5_20 - 1;
                if (value5_22 < 0) {
                    value5_22 = 2;
                }
                setAmpInfo(value111, value112, value113, value114, value115, (value5_21 & 15) | ((value5_22 << 4) & 240), value116);
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int value117 = DataCanbus.DATA[127];
                int value118 = DataCanbus.DATA[128];
                int value119 = DataCanbus.DATA[129];
                int value120 = DataCanbus.DATA[130];
                int value121 = DataCanbus.DATA[131];
                int value5_23 = DataCanbus.DATA[132];
                int value5_24 = DataCanbus.DATA[133];
                int value122 = DataCanbus.DATA[134];
                int value5_25 = value5_23 + 1;
                if (value5_25 > 2) {
                    value121 = 0;
                }
                setAmpInfo(value117, value118, value119, value120, value121, (value5_24 & 15) | ((value5_25 << 4) & 240), value122);
                break;
            case R.id.btn_minus24 /* 2131427610 */:
                int value123 = DataCanbus.DATA[127];
                int value124 = DataCanbus.DATA[128];
                int value125 = DataCanbus.DATA[129];
                int value126 = DataCanbus.DATA[130];
                int value127 = DataCanbus.DATA[131];
                int value5_26 = DataCanbus.DATA[132];
                int value5_27 = DataCanbus.DATA[133];
                int value128 = DataCanbus.DATA[134];
                int value5_28 = value5_27 - 1;
                if (value5_28 < 0) {
                    value5_28 = 3;
                }
                setAmpInfo(value123, value124, value125, value126, value127, (value5_28 & 15) | ((value5_26 << 4) & 240), value128);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                int value129 = DataCanbus.DATA[127];
                int value130 = DataCanbus.DATA[128];
                int value131 = DataCanbus.DATA[129];
                int value132 = DataCanbus.DATA[130];
                int value133 = DataCanbus.DATA[131];
                int value5_29 = DataCanbus.DATA[132];
                int value5_30 = DataCanbus.DATA[133];
                int value134 = DataCanbus.DATA[134];
                int value5_31 = value5_30 + 1;
                if (value5_31 > 3) {
                    value5_31 = 0;
                }
                setAmpInfo(value129, value130, value131, value132, value133, (value5_31 & 15) | ((value5_29 << 4) & 240), value134);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
                int value135 = DataCanbus.DATA[127];
                int value136 = DataCanbus.DATA[128];
                int value137 = DataCanbus.DATA[129];
                int value138 = DataCanbus.DATA[130];
                int value139 = DataCanbus.DATA[131];
                int value5_32 = DataCanbus.DATA[132];
                int value5_33 = DataCanbus.DATA[133];
                int value140 = DataCanbus.DATA[134];
                if (value140 > 0) {
                    value140--;
                }
                setAmpInfo(value135, value136, value137, value138, value139, (value5_33 & 15) | ((value5_32 << 4) & 240), value140);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int value141 = DataCanbus.DATA[127];
                int value142 = DataCanbus.DATA[128];
                int value143 = DataCanbus.DATA[129];
                int value144 = DataCanbus.DATA[130];
                int value145 = DataCanbus.DATA[131];
                int value5_34 = DataCanbus.DATA[132];
                int value5_35 = DataCanbus.DATA[133];
                int value146 = DataCanbus.DATA[134];
                if (value146 < 40) {
                    value146++;
                }
                setAmpInfo(value141, value142, value143, value144, value145, (value5_35 & 15) | ((value5_34 << 4) & 240), value146);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(34, DataCanbus.DATA[115] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(36, DataCanbus.DATA[117] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(37, DataCanbus.DATA[118] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                dialog(R.string.bsd_klj_str17, 39);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(40, DataCanbus.DATA[121] == 1 ? 0 : 1, 0);
                break;
        }
    }

    public void setAmpInfo(int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2, value3, value4, value5, value6, value7}, null, null);
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // com.syu.canbus.BaseActivity
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
