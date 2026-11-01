package com.syu.carinfo.lz.jaguar;

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
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class JaguarCarSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 100:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 101:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 102:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 103:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 104:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 105:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 106:
                    JaguarCarSet.this.updateText1(val);
                    JaguarCarSet.this.unit = val;
                    break;
                case 109:
                    JaguarCarSet.this.updateText2(val);
                    break;
                case 146:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 154:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 155:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 156:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_always_open);
                                break;
                        }
                    }
                    break;
                case 157:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 158:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 159:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 161:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 162:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 163:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 164:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 165:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        if (val > 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)).setText("R" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)).setText("L" + (9 - val));
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)).setText("0");
                        }
                    }
                    break;
                case 166:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        if (val > 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)).setText("R" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)).setText("F" + (9 - val));
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)).setText("0");
                        }
                    }
                    break;
                case 167:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        if (val > 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)).setText("+" + (val - 5));
                        } else if (val < 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)).setText("-" + (5 - val));
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)).setText("0");
                        }
                    }
                    break;
                case 168:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        if (val > 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)).setText("+" + (val - 5));
                        } else if (val < 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)).setText("-" + (5 - val));
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)).setText("0");
                        }
                    }
                    break;
                case 169:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        if (val > 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)).setText("+" + (val - 5));
                        } else if (val < 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)).setText("-" + (5 - val));
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                        }
                    }
                    break;
                case 170:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 178:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text15)).setText("ECO");
                                break;
                            case 2:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text15)).setText("LOCK");
                                break;
                            case 3:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text15)).setText("UNLOCK");
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                            default:
                                ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                        }
                    }
                    break;
                case 183:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 184:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
            }
        }
    };
    int unit = 0;
    int language_set = 255;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_jaguar_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 25, 33};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (JaguarCarSet.this.mLauStyle == null) {
                    JaguarCarSet.this.initLauStyle();
                }
                if (JaguarCarSet.this.mLauStyle != null && JaguarCarSet.this.mPopShowView != null) {
                    JaguarCarSet.this.mLauStyle.showAtLocation(JaguarCarSet.this.mPopShowView, 17, 0, 0);
                    JaguarCarSet.this.updateLauguageSet();
                }
            }
        });
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(0);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_LZ_Jaguar_XK /* 3670468 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
            case FinalCanbus.CAR_455_LZ_Jaguar_S_TYPE_Low /* 16122311 */:
            case FinalCanbus.CAR_455_LZ_Jaguar_X_TYPE_Low /* 16187847 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                break;
        }
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[106] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(12, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[106] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(12, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[157] - 1;
                if (value3 < 0) {
                    value3 = 5;
                }
                setCarInfo(15, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[157] + 1;
                if (value4 > 5) {
                    value4 = 0;
                }
                setCarInfo(15, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[154] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[154] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[158] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(19, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[158] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(19, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[159] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(20, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[159] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(20, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[156] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(21, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[156] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(21, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value0 = DataCanbus.DATA[164];
                int value1 = DataCanbus.DATA[165];
                int value13 = DataCanbus.DATA[166];
                int value14 = DataCanbus.DATA[167];
                int value15 = DataCanbus.DATA[168];
                int value16 = DataCanbus.DATA[169];
                int value17 = DataCanbus.DATA[170];
                if (value0 > 0) {
                    value0--;
                }
                setCarAmp(value0, value1, value13, value14, value15, value16, value17);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value18 = DataCanbus.DATA[164];
                int value19 = DataCanbus.DATA[165];
                int value20 = DataCanbus.DATA[166];
                int value21 = DataCanbus.DATA[167];
                int value22 = DataCanbus.DATA[168];
                int value23 = DataCanbus.DATA[169];
                int value24 = DataCanbus.DATA[170];
                if (value18 < 38) {
                    value18++;
                }
                setCarAmp(value18, value19, value20, value21, value22, value23, value24);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value25 = DataCanbus.DATA[164];
                int value26 = DataCanbus.DATA[165];
                int value27 = DataCanbus.DATA[166];
                int value28 = DataCanbus.DATA[167];
                int value29 = DataCanbus.DATA[168];
                int value30 = DataCanbus.DATA[169];
                int value31 = DataCanbus.DATA[170];
                if (value26 > 0) {
                    value26--;
                }
                setCarAmp(value25, value26, value27, value28, value29, value30, value31);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value32 = DataCanbus.DATA[164];
                int value33 = DataCanbus.DATA[165];
                int value34 = DataCanbus.DATA[166];
                int value35 = DataCanbus.DATA[167];
                int value36 = DataCanbus.DATA[168];
                int value37 = DataCanbus.DATA[169];
                int value38 = DataCanbus.DATA[170];
                if (value33 < 19) {
                    value33++;
                }
                setCarAmp(value32, value33, value34, value35, value36, value37, value38);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value39 = DataCanbus.DATA[164];
                int value40 = DataCanbus.DATA[165];
                int value41 = DataCanbus.DATA[166];
                int value42 = DataCanbus.DATA[167];
                int value43 = DataCanbus.DATA[168];
                int value44 = DataCanbus.DATA[169];
                int value45 = DataCanbus.DATA[170];
                if (value41 > 0) {
                    value41--;
                }
                setCarAmp(value39, value40, value41, value42, value43, value44, value45);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value46 = DataCanbus.DATA[164];
                int value47 = DataCanbus.DATA[165];
                int value48 = DataCanbus.DATA[166];
                int value49 = DataCanbus.DATA[167];
                int value50 = DataCanbus.DATA[168];
                int value51 = DataCanbus.DATA[169];
                int value52 = DataCanbus.DATA[170];
                if (value48 < 19) {
                    value48++;
                }
                setCarAmp(value46, value47, value48, value49, value50, value51, value52);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value53 = DataCanbus.DATA[164];
                int value54 = DataCanbus.DATA[165];
                int value55 = DataCanbus.DATA[166];
                int value56 = DataCanbus.DATA[167];
                int value57 = DataCanbus.DATA[168];
                int value58 = DataCanbus.DATA[169];
                int value59 = DataCanbus.DATA[170];
                if (value56 > 0) {
                    value56--;
                }
                setCarAmp(value53, value54, value55, value56, value57, value58, value59);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value60 = DataCanbus.DATA[164];
                int value61 = DataCanbus.DATA[165];
                int value62 = DataCanbus.DATA[166];
                int value63 = DataCanbus.DATA[167];
                int value64 = DataCanbus.DATA[168];
                int value65 = DataCanbus.DATA[169];
                int value66 = DataCanbus.DATA[170];
                if (value63 < 15) {
                    value63++;
                }
                setCarAmp(value60, value61, value62, value63, value64, value65, value66);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value67 = DataCanbus.DATA[164];
                int value68 = DataCanbus.DATA[165];
                int value69 = DataCanbus.DATA[166];
                int value70 = DataCanbus.DATA[167];
                int value71 = DataCanbus.DATA[168];
                int value72 = DataCanbus.DATA[169];
                int value73 = DataCanbus.DATA[170];
                if (value71 > 0) {
                    value71--;
                }
                setCarAmp(value67, value68, value69, value70, value71, value72, value73);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value74 = DataCanbus.DATA[164];
                int value75 = DataCanbus.DATA[165];
                int value76 = DataCanbus.DATA[166];
                int value77 = DataCanbus.DATA[167];
                int value78 = DataCanbus.DATA[168];
                int value79 = DataCanbus.DATA[169];
                int value80 = DataCanbus.DATA[170];
                if (value78 < 15) {
                    value78++;
                }
                setCarAmp(value74, value75, value76, value77, value78, value79, value80);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value81 = DataCanbus.DATA[164];
                int value82 = DataCanbus.DATA[165];
                int value83 = DataCanbus.DATA[166];
                int value84 = DataCanbus.DATA[167];
                int value85 = DataCanbus.DATA[168];
                int value86 = DataCanbus.DATA[169];
                int value87 = DataCanbus.DATA[170];
                if (value86 > 0) {
                    value86--;
                }
                setCarAmp(value81, value82, value83, value84, value85, value86, value87);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value88 = DataCanbus.DATA[164];
                int value89 = DataCanbus.DATA[165];
                int value90 = DataCanbus.DATA[166];
                int value91 = DataCanbus.DATA[167];
                int value92 = DataCanbus.DATA[168];
                int value93 = DataCanbus.DATA[169];
                int value94 = DataCanbus.DATA[170];
                if (value93 < 15) {
                    value93++;
                }
                setCarAmp(value88, value89, value90, value91, value92, value93, value94);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value95 = DataCanbus.DATA[164];
                int value96 = DataCanbus.DATA[165];
                int value97 = DataCanbus.DATA[166];
                int value98 = DataCanbus.DATA[167];
                int value99 = DataCanbus.DATA[168];
                int value100 = DataCanbus.DATA[169];
                int value101 = DataCanbus.DATA[170];
                if (value101 > 0) {
                    value101--;
                }
                setCarAmp(value95, value96, value97, value98, value99, value100, value101);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value102 = DataCanbus.DATA[164];
                int value103 = DataCanbus.DATA[165];
                int value104 = DataCanbus.DATA[166];
                int value105 = DataCanbus.DATA[167];
                int value106 = DataCanbus.DATA[168];
                int value107 = DataCanbus.DATA[169];
                int value108 = DataCanbus.DATA[170];
                if (value108 < 3) {
                    value108++;
                }
                setCarAmp(value102, value103, value104, value105, value106, value107, value108);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value109 = DataCanbus.DATA[99];
                if (value109 == 0) {
                    value109 = 1;
                } else if (value109 == 1) {
                    value109 = 0;
                }
                setCarInfo(0, value109);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value110 = DataCanbus.DATA[102];
                if (value110 == 0) {
                    value110 = 1;
                } else if (value110 == 1) {
                    value110 = 0;
                }
                setCarInfo(3, value110);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value111 = DataCanbus.DATA[103];
                if (value111 == 0) {
                    value111 = 1;
                } else if (value111 == 1) {
                    value111 = 0;
                }
                setCarInfo(4, value111);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value112 = DataCanbus.DATA[100];
                if (value112 == 0) {
                    value112 = 1;
                } else if (value112 == 1) {
                    value112 = 0;
                }
                setCarInfo(1, value112);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value113 = DataCanbus.DATA[101];
                if (value113 == 0) {
                    value113 = 1;
                } else if (value113 == 1) {
                    value113 = 0;
                }
                setCarInfo(2, value113);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value114 = DataCanbus.DATA[104];
                if (value114 == 0) {
                    value114 = 1;
                } else if (value114 == 1) {
                    value114 = 0;
                }
                setCarInfo(5, value114);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value115 = DataCanbus.DATA[105];
                if (value115 == 0) {
                    value115 = 1;
                } else if (value115 == 1) {
                    value115 = 0;
                }
                setCarInfo(6, value115);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value116 = DataCanbus.DATA[155];
                if (value116 == 0) {
                    value116 = 1;
                } else if (value116 == 1) {
                    value116 = 0;
                }
                setCarInfo(16, value116);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value117 = DataCanbus.DATA[161];
                if (value117 == 0) {
                    value117 = 1;
                } else if (value117 == 1) {
                    value117 = 0;
                }
                setCarInfo(23, value117);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value118 = DataCanbus.DATA[162];
                if (value118 == 0) {
                    value118 = 1;
                } else if (value118 == 1) {
                    value118 = 0;
                }
                setCarInfo(24, value118);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value119 = DataCanbus.DATA[163];
                if (value119 == 0) {
                    value119 = 1;
                } else if (value119 == 1) {
                    value119 = 0;
                }
                setCarInfo(25, value119);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(22, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value120 = DataCanbus.DATA[178] + 1;
                if (value120 > 3) {
                    value120 = 1;
                }
                sendCmd(value120);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                sendCmd2(27);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value121 = DataCanbus.DATA[184];
                if (value121 == 0) {
                    value121 = 1;
                } else if (value121 == 1) {
                    value121 = 0;
                }
                setCarInfo(35, value121);
                break;
        }
    }

    public void setCarAmp(int value0, int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3, value4, value5, value6}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    private void sendCmd(int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{14, cmd}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSet.3
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{14, 0}, null, null);
            }
        }, 200L);
    }

    private void sendCmd2(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSet.4
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd, 0}, null, null);
            }
        }, 200L);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{53, 0}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{56, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (this.unit) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("miles");
                    break;
            }
        }
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSet.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                JaguarCarSet.this.language_set = position;
                if (JaguarCarSet.this.language_set >= 0 && JaguarCarSet.this.language_set <= JaguarCarSet.this.mLauStylelist.size() && JaguarCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{11, JaguarCarSet.this.send_lang[JaguarCarSet.this.language_set]}, null, null);
                }
                JaguarCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }
}
