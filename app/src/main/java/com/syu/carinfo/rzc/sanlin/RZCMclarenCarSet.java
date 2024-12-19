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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 26:
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
                case 27:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 28:
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
                case 29:
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
                case 30:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 31:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 32:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 33:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 34:
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
                case 35:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 36:
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
                case 37:
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
                case 38:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 39:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 40:
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
                case 41:
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
                case 42:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 43:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 44:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 45:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 46:
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
                case 48:
                    RZCMclarenCarSet.this.setCheck((CheckedTextView) RZCMclarenCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 49:
                    RZCMclarenCarSet.this.updateLauguageSet();
                    break;
                case 50:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)).setText("L/100km");
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text14)).setText("km/L");
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
                case 51:
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
                case 52:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)).setText("kPa");
                                break;
                            case 1:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)).setText("PSI");
                                break;
                            case 2:
                                ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text16)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 53:
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
                case 54:
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
                case 55:
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
                case 56:
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
                case 57:
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
                case 58:
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
                case 59:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text23)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 60:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text24)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 61:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 62:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 63:
                    if (((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RZCMclarenCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
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
                    DataCanbus.PROXY.cmd(2, new int[]{48, RZCMclarenCarSet.this.send_lang[RZCMclarenCarSet.this.language_set]}, null, null);
                }
                RZCMclarenCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[49];
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
                        DataCanbus.PROXY.cmd(2, new int[]{i}, null, null);
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
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[46];
                int value1 = DataCanbus.DATA[62];
                int value2 = DataCanbus.DATA[63];
                int value22 = value2 - 1;
                if (value22 < 0) {
                    value22 = 7;
                }
                setCarInfo(38, value, ((value1 << 4) & 240) | (value22 & 15));
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value3 = DataCanbus.DATA[46];
                int value12 = DataCanbus.DATA[62];
                int value23 = DataCanbus.DATA[63];
                int value24 = value23 + 1;
                if (value24 > 7) {
                    value24 = 0;
                }
                setCarInfo(38, value3, ((value12 << 4) & 240) | (value24 & 15));
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value4 = DataCanbus.DATA[50] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(49, value4, 0);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value5 = DataCanbus.DATA[50] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(49, value5, 0);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value6 = DataCanbus.DATA[51] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(50, value6, 0);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value7 = DataCanbus.DATA[51] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(50, value7, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfo(2, DataCanbus.DATA[27] == 1 ? 0 : 1, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[26] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(1, value8, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[26] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(1, value9, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[28] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(3, value10, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[28] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(3, value11, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value13 = DataCanbus.DATA[29] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(4, value13, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value14 = DataCanbus.DATA[29] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(4, value14, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value15 = DataCanbus.DATA[34] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(10, value15, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value16 = DataCanbus.DATA[34] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(10, value16, 0);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value17 = DataCanbus.DATA[36] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(12, value17, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value18 = DataCanbus.DATA[36] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(12, value18, 0);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value19 = DataCanbus.DATA[37] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(14, value19, 0);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value20 = DataCanbus.DATA[37] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(14, value20, 0);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value21 = DataCanbus.DATA[38] - 1;
                if (value21 < 0) {
                    value21 = 4;
                }
                setCarInfo(15, value21, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value25 = DataCanbus.DATA[38] + 1;
                if (value25 > 4) {
                    value25 = 0;
                }
                setCarInfo(15, value25, 0);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value26 = DataCanbus.DATA[40] - 1;
                if (value26 < 0) {
                    value26 = 4;
                }
                setCarInfo(32, value26, 0);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value27 = DataCanbus.DATA[40] + 1;
                if (value27 > 4) {
                    value27 = 0;
                }
                setCarInfo(32, value27, 0);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value28 = DataCanbus.DATA[41] - 1;
                if (value28 < 0) {
                    value28 = 4;
                }
                setCarInfo(33, value28, 0);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value29 = DataCanbus.DATA[41] + 1;
                if (value29 > 4) {
                    value29 = 0;
                }
                setCarInfo(33, value29, 0);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value30 = DataCanbus.DATA[43] - 1;
                if (value30 < 1) {
                    value30 = 7;
                }
                setCarInfo(35, value30, 0);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value31 = DataCanbus.DATA[43] + 1;
                if (value31 > 7) {
                    value31 = 1;
                }
                setCarInfo(35, value31, 0);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value32 = DataCanbus.DATA[46];
                int value110 = DataCanbus.DATA[62];
                int value210 = DataCanbus.DATA[63];
                int value33 = value32 - 1;
                if (value33 < 0) {
                    value33 = 2;
                }
                setCarInfo(38, value33, ((value110 << 4) & 240) | (value210 & 15));
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value34 = DataCanbus.DATA[46];
                int value111 = DataCanbus.DATA[62];
                int value211 = DataCanbus.DATA[63];
                int value35 = value34 + 1;
                if (value35 > 2) {
                    value35 = 0;
                }
                setCarInfo(38, value35, ((value111 << 4) & 240) | (value211 & 15));
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value36 = DataCanbus.DATA[46];
                int value112 = DataCanbus.DATA[62];
                int value212 = DataCanbus.DATA[63];
                int value113 = value112 - 1;
                if (value113 < 0) {
                    value113 = 11;
                }
                setCarInfo(38, value36, ((value113 << 4) & 240) | (value212 & 15));
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value37 = DataCanbus.DATA[46];
                int value114 = DataCanbus.DATA[62];
                int value213 = DataCanbus.DATA[63];
                int value115 = value114 + 1;
                if (value115 > 11) {
                    value115 = 0;
                }
                setCarInfo(38, value37, ((value115 << 4) & 240) | (value213 & 15));
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfo(6, DataCanbus.DATA[30] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfo(7, DataCanbus.DATA[31] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(8, DataCanbus.DATA[32] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfo(9, DataCanbus.DATA[33] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfo(11, DataCanbus.DATA[35] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                setCarInfo(16, DataCanbus.DATA[39] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                setCarInfo(34, DataCanbus.DATA[42] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setCarInfo(36, DataCanbus.DATA[44] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                setCarInfo(37, DataCanbus.DATA[45] == 1 ? 0 : 1, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                dialog(R.string.bsd_klj_str17, 39);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfo(40, DataCanbus.DATA[48] == 1 ? 0 : 1, 0);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value0 = DataCanbus.DATA[54];
                int value116 = DataCanbus.DATA[55];
                int value214 = DataCanbus.DATA[56];
                int value38 = DataCanbus.DATA[57];
                int value42 = DataCanbus.DATA[58];
                int value5_4 = DataCanbus.DATA[59];
                int value5_0 = DataCanbus.DATA[60];
                int value62 = DataCanbus.DATA[61];
                if (value0 > 0) {
                    value0--;
                }
                setAmpInfo(value0, value116, value214, value38, value42, (value5_0 & 15) | ((value5_4 << 4) & 240), value62);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value02 = DataCanbus.DATA[54];
                int value117 = DataCanbus.DATA[55];
                int value215 = DataCanbus.DATA[56];
                int value39 = DataCanbus.DATA[57];
                int value43 = DataCanbus.DATA[58];
                int value5_42 = DataCanbus.DATA[59];
                int value5_02 = DataCanbus.DATA[60];
                int value63 = DataCanbus.DATA[61];
                if (value02 < 19) {
                    value02++;
                }
                setAmpInfo(value02, value117, value215, value39, value43, (value5_02 & 15) | ((value5_42 << 4) & 240), value63);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value03 = DataCanbus.DATA[54];
                int value118 = DataCanbus.DATA[55];
                int value216 = DataCanbus.DATA[56];
                int value310 = DataCanbus.DATA[57];
                int value44 = DataCanbus.DATA[58];
                int value5_43 = DataCanbus.DATA[59];
                int value5_03 = DataCanbus.DATA[60];
                int value64 = DataCanbus.DATA[61];
                if (value118 > 0) {
                    value118--;
                }
                setAmpInfo(value03, value118, value216, value310, value44, (value5_03 & 15) | ((value5_43 << 4) & 240), value64);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value04 = DataCanbus.DATA[54];
                int value119 = DataCanbus.DATA[55];
                int value217 = DataCanbus.DATA[56];
                int value311 = DataCanbus.DATA[57];
                int value45 = DataCanbus.DATA[58];
                int value5_44 = DataCanbus.DATA[59];
                int value5_04 = DataCanbus.DATA[60];
                int value65 = DataCanbus.DATA[61];
                if (value119 < 19) {
                    value119++;
                }
                setAmpInfo(value04, value119, value217, value311, value45, (value5_04 & 15) | ((value5_44 << 4) & 240), value65);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value05 = DataCanbus.DATA[54];
                int value120 = DataCanbus.DATA[55];
                int value218 = DataCanbus.DATA[56];
                int value312 = DataCanbus.DATA[57];
                int value46 = DataCanbus.DATA[58];
                int value5_45 = DataCanbus.DATA[59];
                int value5_05 = DataCanbus.DATA[60];
                int value66 = DataCanbus.DATA[61];
                if (value312 > 0) {
                    value312--;
                }
                setAmpInfo(value05, value120, value218, value312, value46, (value5_05 & 15) | ((value5_45 << 4) & 240), value66);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value06 = DataCanbus.DATA[54];
                int value121 = DataCanbus.DATA[55];
                int value219 = DataCanbus.DATA[56];
                int value313 = DataCanbus.DATA[57];
                int value47 = DataCanbus.DATA[58];
                int value5_46 = DataCanbus.DATA[59];
                int value5_06 = DataCanbus.DATA[60];
                int value67 = DataCanbus.DATA[61];
                if (value313 < 19) {
                    value313++;
                }
                setAmpInfo(value06, value121, value219, value313, value47, (value5_06 & 15) | ((value5_46 << 4) & 240), value67);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value07 = DataCanbus.DATA[54];
                int value122 = DataCanbus.DATA[55];
                int value220 = DataCanbus.DATA[56];
                int value314 = DataCanbus.DATA[57];
                int value48 = DataCanbus.DATA[58];
                int value5_47 = DataCanbus.DATA[59];
                int value5_07 = DataCanbus.DATA[60];
                int value68 = DataCanbus.DATA[61];
                if (value48 > 0) {
                    value48--;
                }
                setAmpInfo(value07, value122, value220, value314, value48, (value5_07 & 15) | ((value5_47 << 4) & 240), value68);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value08 = DataCanbus.DATA[54];
                int value123 = DataCanbus.DATA[55];
                int value221 = DataCanbus.DATA[56];
                int value315 = DataCanbus.DATA[57];
                int value49 = DataCanbus.DATA[58];
                int value5_48 = DataCanbus.DATA[59];
                int value5_08 = DataCanbus.DATA[60];
                int value69 = DataCanbus.DATA[61];
                if (value49 < 19) {
                    value49++;
                }
                setAmpInfo(value08, value123, value221, value315, value49, (value5_08 & 15) | ((value5_48 << 4) & 240), value69);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value40 = DataCanbus.DATA[52] - 1;
                if (value40 < 0) {
                    value40 = 2;
                }
                setCarInfo(51, value40, 0);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value41 = DataCanbus.DATA[52] + 1;
                if (value41 > 2) {
                    value41 = 0;
                }
                setCarInfo(51, value41, 0);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value50 = DataCanbus.DATA[53] - 1;
                if (value50 < 0) {
                    value50 = 1;
                }
                setCarInfo(52, value50, 0);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value51 = DataCanbus.DATA[53] + 1;
                if (value51 > 1) {
                    value51 = 0;
                }
                setCarInfo(52, value51, 0);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value09 = DataCanbus.DATA[54];
                int value124 = DataCanbus.DATA[55];
                int value222 = DataCanbus.DATA[56];
                int value316 = DataCanbus.DATA[57];
                int value410 = DataCanbus.DATA[58];
                int value5_49 = DataCanbus.DATA[59];
                int value5_09 = DataCanbus.DATA[60];
                int value610 = DataCanbus.DATA[61];
                if (value222 > 0) {
                    value222--;
                }
                setAmpInfo(value09, value124, value222, value316, value410, (value5_09 & 15) | ((value5_49 << 4) & 240), value610);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value010 = DataCanbus.DATA[54];
                int value125 = DataCanbus.DATA[55];
                int value223 = DataCanbus.DATA[56];
                int value317 = DataCanbus.DATA[57];
                int value411 = DataCanbus.DATA[58];
                int value5_410 = DataCanbus.DATA[59];
                int value5_010 = DataCanbus.DATA[60];
                int value611 = DataCanbus.DATA[61];
                if (value223 < 19) {
                    value223++;
                }
                setAmpInfo(value010, value125, value223, value317, value411, (value5_010 & 15) | ((value5_410 << 4) & 240), value611);
                break;
            case R.id.btn_plus25 /* 2131427923 */:
                int value011 = DataCanbus.DATA[54];
                int value126 = DataCanbus.DATA[55];
                int value224 = DataCanbus.DATA[56];
                int value318 = DataCanbus.DATA[57];
                int value412 = DataCanbus.DATA[58];
                int value5_411 = DataCanbus.DATA[59];
                int value5_011 = DataCanbus.DATA[60];
                int value612 = DataCanbus.DATA[61];
                if (value612 < 40) {
                    value612++;
                }
                setAmpInfo(value011, value126, value224, value318, value412, (value5_011 & 15) | ((value5_411 << 4) & 240), value612);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value012 = DataCanbus.DATA[54];
                int value127 = DataCanbus.DATA[55];
                int value225 = DataCanbus.DATA[56];
                int value319 = DataCanbus.DATA[57];
                int value413 = DataCanbus.DATA[58];
                int value5_412 = DataCanbus.DATA[59];
                int value5_012 = DataCanbus.DATA[60];
                int value613 = DataCanbus.DATA[61];
                int value5_013 = value5_012 + 1;
                if (value5_013 > 3) {
                    value5_013 = 0;
                }
                setAmpInfo(value012, value127, value225, value319, value413, (value5_013 & 15) | ((value5_412 << 4) & 240), value613);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value013 = DataCanbus.DATA[54];
                int value128 = DataCanbus.DATA[55];
                int value226 = DataCanbus.DATA[56];
                int value320 = DataCanbus.DATA[57];
                int value414 = DataCanbus.DATA[58];
                int value5_413 = DataCanbus.DATA[59];
                int value5_014 = DataCanbus.DATA[60];
                int value614 = DataCanbus.DATA[61];
                int value5_414 = value5_413 + 1;
                if (value5_414 > 2) {
                    value414 = 0;
                }
                setAmpInfo(value013, value128, value226, value320, value414, (value5_014 & 15) | ((value5_414 << 4) & 240), value614);
                break;
            case R.id.btn_minus25 /* 2131428315 */:
                int value014 = DataCanbus.DATA[54];
                int value129 = DataCanbus.DATA[55];
                int value227 = DataCanbus.DATA[56];
                int value321 = DataCanbus.DATA[57];
                int value415 = DataCanbus.DATA[58];
                int value5_415 = DataCanbus.DATA[59];
                int value5_015 = DataCanbus.DATA[60];
                int value615 = DataCanbus.DATA[61];
                if (value615 > 0) {
                    value615--;
                }
                setAmpInfo(value014, value129, value227, value321, value415, (value5_015 & 15) | ((value5_415 << 4) & 240), value615);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value015 = DataCanbus.DATA[54];
                int value130 = DataCanbus.DATA[55];
                int value228 = DataCanbus.DATA[56];
                int value322 = DataCanbus.DATA[57];
                int value416 = DataCanbus.DATA[58];
                int value5_416 = DataCanbus.DATA[59];
                int value5_016 = DataCanbus.DATA[60];
                int value616 = DataCanbus.DATA[61];
                int value5_417 = value5_416 - 1;
                if (value5_417 < 0) {
                    value5_417 = 2;
                }
                setAmpInfo(value015, value130, value228, value322, value416, (value5_016 & 15) | ((value5_417 << 4) & 240), value616);
                break;
            case R.id.btn_minus24 /* 2131428319 */:
                int value016 = DataCanbus.DATA[54];
                int value131 = DataCanbus.DATA[55];
                int value229 = DataCanbus.DATA[56];
                int value323 = DataCanbus.DATA[57];
                int value417 = DataCanbus.DATA[58];
                int value5_418 = DataCanbus.DATA[59];
                int value5_017 = DataCanbus.DATA[60];
                int value617 = DataCanbus.DATA[61];
                int value5_018 = value5_017 - 1;
                if (value5_018 < 0) {
                    value5_018 = 3;
                }
                setAmpInfo(value016, value131, value229, value323, value417, (value5_018 & 15) | ((value5_418 << 4) & 240), value617);
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
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
    }
}
