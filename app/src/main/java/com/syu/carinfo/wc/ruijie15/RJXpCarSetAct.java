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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RJXpCarSetAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.RJXpCarSetAct.1
        @Override // com.syu.module.IUiNotify
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
                case 86:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 108:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 109:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 110:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 111:
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
                case 112:
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
                case 113:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 114:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 115:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 116:
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
                case 117:
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
                case 118:
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
                case 119:
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
                case 120:
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
                case 121:
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
                case 122:
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
                case 123:
                    if (((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RJXpCarSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 124:
                    RJXpCarSetAct.this.updateLauguageSet();
                    break;
                case 125:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xp_ford_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.ruijie15.RJXpCarSetAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
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
        int value = DataCanbus.DATA[124];
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruijie15.RJXpCarSetAct.3
            @Override // android.view.View.OnClickListener
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                setCarInfo(186, 1);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                setCarInfo(186, 2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                setCarInfo(187, 1);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                setCarInfo(187, 2);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value = DataCanbus.DATA[116];
                if (value > 0) {
                    value--;
                }
                setCarInfo(192, value);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value2 = DataCanbus.DATA[116];
                if (value2 < 14) {
                    value2++;
                }
                setCarInfo(192, value2);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 6;
                }
                setCarInfo(177, value3);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 6) {
                    value4 = 0;
                }
                setCarInfo(177, value4);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value5 = DataCanbus.DATA[123];
                if (value5 > 0) {
                    value5 -= 5;
                }
                setCarInfo(189, value5);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value6 = DataCanbus.DATA[123];
                if (value6 < 100) {
                    value6 += 5;
                }
                setCarInfo(189, value6);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value7 = DataCanbus.DATA[125] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(188, value7);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value8 = DataCanbus.DATA[125] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(188, value8);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value9 = DataCanbus.DATA[106] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(178, value9);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value10 = DataCanbus.DATA[106] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(178, value10);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value11 = DataCanbus.DATA[107] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(179, value11);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value12 = DataCanbus.DATA[107] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(179, value12);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(180, 1);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(180, 2);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(181, 1);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(181, 2);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                setCarInfo(182, 1);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                setCarInfo(182, 2);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value13 = DataCanbus.DATA[111] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(183, value13);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value14 = DataCanbus.DATA[111] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(183, value14);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value15 = DataCanbus.DATA[112] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(184, value15);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value16 = DataCanbus.DATA[112] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(184, value16);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                setCarInfo(185, 1);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                setCarInfo(185, 2);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value17 = DataCanbus.DATA[119];
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo(195, value17);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value18 = DataCanbus.DATA[119];
                if (value18 < 14) {
                    value18++;
                }
                setCarInfo(195, value18);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value19 = DataCanbus.DATA[120];
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo(196, value19);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value20 = DataCanbus.DATA[120];
                if (value20 < 14) {
                    value20++;
                }
                setCarInfo(196, value20);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value21 = DataCanbus.DATA[122] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(198, value21 + 1);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value22 = DataCanbus.DATA[122] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(198, value22 + 1);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value23 = DataCanbus.DATA[37] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(160, value23);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value24 = DataCanbus.DATA[37] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(160, value24);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value25 = DataCanbus.DATA[117];
                if (value25 > 0) {
                    value25--;
                }
                setCarInfo(193, value25);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value26 = DataCanbus.DATA[117];
                if (value26 < 14) {
                    value26++;
                }
                setCarInfo(193, value26);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value27 = DataCanbus.DATA[118];
                if (value27 > 0) {
                    value27--;
                }
                setCarInfo(194, value27);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value28 = DataCanbus.DATA[118];
                if (value28 < 14) {
                    value28++;
                }
                setCarInfo(194, value28);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value29 = DataCanbus.DATA[121] - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo(197, value29 + 1);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value30 = DataCanbus.DATA[121] + 1;
                if (value30 > 3) {
                    value30 = 0;
                }
                setCarInfo(197, value30 + 1);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value31 = DataCanbus.DATA[86] + 1;
                if (value31 > 1) {
                    value31 = 0;
                }
                setCarInfo(163, value31 + 14);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value32 = DataCanbus.DATA[86] - 1;
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{72}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{39}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }
}
