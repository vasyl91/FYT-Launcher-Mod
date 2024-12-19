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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzJaguarXFCarSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuzJaguarXFCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                    LuzJaguarXFCarSet.this.updateText6();
                    break;
                case 26:
                    LuzJaguarXFCarSet.this.updateText7();
                    break;
                case 27:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 28:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 29:
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
                case 30:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 31:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 32:
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
                case 33:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 34:
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
                case 35:
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
                case 37:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 43:
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
                case 44:
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
                case 45:
                    LuzJaguarXFCarSet.this.updateText10();
                    break;
                case 46:
                    LuzJaguarXFCarSet.this.updateText11();
                    break;
                case 47:
                    LuzJaguarXFCarSet.this.updateText12();
                    break;
                case 48:
                    LuzJaguarXFCarSet.this.updateText13();
                    break;
                case 49:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 50:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 51:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 52:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 53:
                    if (((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) LuzJaguarXFCarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 54:
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
                case 55:
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
                case 57:
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
                case 58:
                    LuzJaguarXFCarSet.this.setCheck((CheckedTextView) LuzJaguarXFCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 59:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_luz_jaguar_xf_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzJaguarXFCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
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

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzJaguarXFCarSet.3
            @Override // android.view.View.OnClickListener
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[27];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[29] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(3, value2, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[29] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(3, value3, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[32] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(6, value4, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[32] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(6, value5, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarAirInfo(1, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarAirInfo(2, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value6 = DataCanbus.DATA[34] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarAirInfo(3, value6);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value7 = DataCanbus.DATA[34] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarAirInfo(3, value7);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value8 = DataCanbus.DATA[35] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarAirInfo(4, value8);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value9 = DataCanbus.DATA[35] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarAirInfo(4, value9);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value10 = DataCanbus.DATA[43] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(11, value10, 0);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value11 = DataCanbus.DATA[43] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(11, value11, 0);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value12 = DataCanbus.DATA[44] - 1;
                if (value12 < 0) {
                    value12 = 4;
                }
                setCarInfo(12, value12, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value13 = DataCanbus.DATA[44] + 1;
                if (value13 > 4) {
                    value13 = 0;
                }
                setCarInfo(12, value13, 0);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                setCarAirInfo(1, 0);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                setCarAirInfo(2, 0);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value14 = DataCanbus.DATA[54] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarAirInfo(5, value14);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value15 = DataCanbus.DATA[54] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarAirInfo(5, value15);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value16 = DataCanbus.DATA[57] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo(13, value16, 0);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value17 = DataCanbus.DATA[57] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(13, value17, 0);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value18 = DataCanbus.DATA[59] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(15, value18, 0);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value19 = DataCanbus.DATA[59] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(15, value19, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value20 = DataCanbus.DATA[28];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(2, value20, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value21 = DataCanbus.DATA[30];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(4, value21, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value22 = DataCanbus.DATA[31];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(5, value22, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value23 = DataCanbus.DATA[49];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(7, value23, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value24 = DataCanbus.DATA[50];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(8, value24, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value25 = DataCanbus.DATA[51];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(9, value25, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value26 = DataCanbus.DATA[52];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(10, value26, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setCarAir(31);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value27 = DataCanbus.DATA[58];
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
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.LuzJaguarXFCarSet.4
            @Override // java.lang.Runnable
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
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText13() {
        int value = DataCanbus.DATA[48];
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text13)).setText(String.valueOf(value) + "miles");
            } else {
                ((TextView) findViewById(R.id.tv_text13)).setText(String.valueOf(value) + "km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText12() {
        int value = DataCanbus.DATA[47];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "mpg");
            } else {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "l/100km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText11() {
        int value = DataCanbus.DATA[46];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "mph");
            } else {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "km/h");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText10() {
        int value = DataCanbus.DATA[45];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "miles");
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (this.unit == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " miles");
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
            }
        }
    }
}
