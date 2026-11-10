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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 28:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 29:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 30:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 31:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 32:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 33:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 34:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 35:
                    JaguarCarSet.this.updateText1(val);
                    JaguarCarSet.this.unit = val;
                    break;
                case 38:
                    JaguarCarSet.this.updateText2(val);
                    break;
                case 83:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 91:
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
                case 92:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 93:
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
                case 94:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 95:
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
                case 96:
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
                case 98:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 99:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 100:
                    JaguarCarSet.this.setCheck((CheckedTextView) JaguarCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 101:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 102:
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
                case 103:
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
                case 104:
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
                case 105:
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
                case 106:
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
                case 107:
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
                case 119:
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
                case 123:
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
                case 124:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 125:
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
        this.send_lang = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12};
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
        findViewById(R.id.layout_view9).setVisibility(8);
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
            case R.id.btn_minus13 /* 2131427468 */:
                int value0 = DataCanbus.DATA[101];
                int value1 = DataCanbus.DATA[102];
                int value2 = DataCanbus.DATA[103];
                int value3 = DataCanbus.DATA[104];
                int value4 = DataCanbus.DATA[105];
                int value5 = DataCanbus.DATA[106];
                int value6 = DataCanbus.DATA[107];
                if (value6 > 0) {
                    value6--;
                }
                setCarAmp(value0, value1, value2, value3, value4, value5, value6);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value7 = DataCanbus.DATA[101];
                int value8 = DataCanbus.DATA[102];
                int value9 = DataCanbus.DATA[103];
                int value10 = DataCanbus.DATA[104];
                int value11 = DataCanbus.DATA[105];
                int value12 = DataCanbus.DATA[106];
                int value13 = DataCanbus.DATA[107];
                if (value13 < 3) {
                    value13++;
                }
                setCarAmp(value7, value8, value9, value10, value11, value12, value13);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[28];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value14 = DataCanbus.DATA[35] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(12, value14);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value15 = DataCanbus.DATA[35] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(12, value15);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value16 = DataCanbus.DATA[94] - 1;
                if (value16 < 0) {
                    value16 = 5;
                }
                setCarInfo(15, value16);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value17 = DataCanbus.DATA[94] + 1;
                if (value17 > 5) {
                    value17 = 0;
                }
                setCarInfo(15, value17);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value18 = DataCanbus.DATA[91] - 1;
                if (value18 < 0) {
                    value18 = 3;
                }
                setCarInfo(17, value18);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value19 = DataCanbus.DATA[91] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(17, value19);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value20 = DataCanbus.DATA[95] - 1;
                if (value20 < 0) {
                    value20 = 3;
                }
                setCarInfo(19, value20);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value21 = DataCanbus.DATA[95] + 1;
                if (value21 > 3) {
                    value21 = 0;
                }
                setCarInfo(19, value21);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value22 = DataCanbus.DATA[96] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(20, value22);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value23 = DataCanbus.DATA[96] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(20, value23);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value24 = DataCanbus.DATA[93] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                setCarInfo(21, value24);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value25 = DataCanbus.DATA[93] + 1;
                if (value25 > 1) {
                    value25 = 0;
                }
                setCarInfo(21, value25);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value26 = DataCanbus.DATA[101];
                int value27 = DataCanbus.DATA[102];
                int value28 = DataCanbus.DATA[103];
                int value29 = DataCanbus.DATA[104];
                int value30 = DataCanbus.DATA[105];
                int value31 = DataCanbus.DATA[106];
                int value32 = DataCanbus.DATA[107];
                if (value26 > 0) {
                    value26--;
                }
                setCarAmp(value26, value27, value28, value29, value30, value31, value32);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value33 = DataCanbus.DATA[101];
                int value34 = DataCanbus.DATA[102];
                int value35 = DataCanbus.DATA[103];
                int value36 = DataCanbus.DATA[104];
                int value37 = DataCanbus.DATA[105];
                int value38 = DataCanbus.DATA[106];
                int value39 = DataCanbus.DATA[107];
                if (value33 < 38) {
                    value33++;
                }
                setCarAmp(value33, value34, value35, value36, value37, value38, value39);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value40 = DataCanbus.DATA[101];
                int value41 = DataCanbus.DATA[102];
                int value42 = DataCanbus.DATA[103];
                int value43 = DataCanbus.DATA[104];
                int value44 = DataCanbus.DATA[105];
                int value45 = DataCanbus.DATA[106];
                int value46 = DataCanbus.DATA[107];
                if (value41 > 0) {
                    value41--;
                }
                setCarAmp(value40, value41, value42, value43, value44, value45, value46);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value47 = DataCanbus.DATA[101];
                int value48 = DataCanbus.DATA[102];
                int value49 = DataCanbus.DATA[103];
                int value50 = DataCanbus.DATA[104];
                int value51 = DataCanbus.DATA[105];
                int value52 = DataCanbus.DATA[106];
                int value53 = DataCanbus.DATA[107];
                if (value48 < 19) {
                    value48++;
                }
                setCarAmp(value47, value48, value49, value50, value51, value52, value53);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value54 = DataCanbus.DATA[101];
                int value55 = DataCanbus.DATA[102];
                int value56 = DataCanbus.DATA[103];
                int value57 = DataCanbus.DATA[104];
                int value58 = DataCanbus.DATA[105];
                int value59 = DataCanbus.DATA[106];
                int value60 = DataCanbus.DATA[107];
                if (value56 > 0) {
                    value56--;
                }
                setCarAmp(value54, value55, value56, value57, value58, value59, value60);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value61 = DataCanbus.DATA[101];
                int value62 = DataCanbus.DATA[102];
                int value63 = DataCanbus.DATA[103];
                int value64 = DataCanbus.DATA[104];
                int value65 = DataCanbus.DATA[105];
                int value66 = DataCanbus.DATA[106];
                int value67 = DataCanbus.DATA[107];
                if (value63 < 19) {
                    value63++;
                }
                setCarAmp(value61, value62, value63, value64, value65, value66, value67);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value68 = DataCanbus.DATA[101];
                int value69 = DataCanbus.DATA[102];
                int value70 = DataCanbus.DATA[103];
                int value71 = DataCanbus.DATA[104];
                int value72 = DataCanbus.DATA[105];
                int value73 = DataCanbus.DATA[106];
                int value74 = DataCanbus.DATA[107];
                if (value71 > 0) {
                    value71--;
                }
                setCarAmp(value68, value69, value70, value71, value72, value73, value74);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value75 = DataCanbus.DATA[101];
                int value76 = DataCanbus.DATA[102];
                int value77 = DataCanbus.DATA[103];
                int value78 = DataCanbus.DATA[104];
                int value79 = DataCanbus.DATA[105];
                int value80 = DataCanbus.DATA[106];
                int value81 = DataCanbus.DATA[107];
                if (value78 < 15) {
                    value78++;
                }
                setCarAmp(value75, value76, value77, value78, value79, value80, value81);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value82 = DataCanbus.DATA[101];
                int value83 = DataCanbus.DATA[102];
                int value84 = DataCanbus.DATA[103];
                int value85 = DataCanbus.DATA[104];
                int value86 = DataCanbus.DATA[105];
                int value87 = DataCanbus.DATA[106];
                int value88 = DataCanbus.DATA[107];
                if (value86 > 0) {
                    value86--;
                }
                setCarAmp(value82, value83, value84, value85, value86, value87, value88);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value89 = DataCanbus.DATA[101];
                int value90 = DataCanbus.DATA[102];
                int value91 = DataCanbus.DATA[103];
                int value92 = DataCanbus.DATA[104];
                int value93 = DataCanbus.DATA[105];
                int value94 = DataCanbus.DATA[106];
                int value95 = DataCanbus.DATA[107];
                if (value93 < 15) {
                    value93++;
                }
                setCarAmp(value89, value90, value91, value92, value93, value94, value95);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value96 = DataCanbus.DATA[101];
                int value97 = DataCanbus.DATA[102];
                int value98 = DataCanbus.DATA[103];
                int value99 = DataCanbus.DATA[104];
                int value100 = DataCanbus.DATA[105];
                int value101 = DataCanbus.DATA[106];
                int value102 = DataCanbus.DATA[107];
                if (value101 > 0) {
                    value101--;
                }
                setCarAmp(value96, value97, value98, value99, value100, value101, value102);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value103 = DataCanbus.DATA[101];
                int value104 = DataCanbus.DATA[102];
                int value105 = DataCanbus.DATA[103];
                int value106 = DataCanbus.DATA[104];
                int value107 = DataCanbus.DATA[105];
                int value108 = DataCanbus.DATA[106];
                int value109 = DataCanbus.DATA[107];
                if (value108 < 15) {
                    value108++;
                }
                setCarAmp(value103, value104, value105, value106, value107, value108, value109);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value110 = DataCanbus.DATA[29];
                if (value110 == 0) {
                    value110 = 1;
                } else if (value110 == 1) {
                    value110 = 0;
                }
                setCarInfo(1, value110);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value111 = DataCanbus.DATA[30];
                if (value111 == 0) {
                    value111 = 1;
                } else if (value111 == 1) {
                    value111 = 0;
                }
                setCarInfo(2, value111);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value112 = DataCanbus.DATA[31];
                if (value112 == 0) {
                    value112 = 1;
                } else if (value112 == 1) {
                    value112 = 0;
                }
                setCarInfo(3, value112);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value113 = DataCanbus.DATA[32];
                if (value113 == 0) {
                    value113 = 1;
                } else if (value113 == 1) {
                    value113 = 0;
                }
                setCarInfo(4, value113);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value114 = DataCanbus.DATA[33];
                if (value114 == 0) {
                    value114 = 1;
                } else if (value114 == 1) {
                    value114 = 0;
                }
                setCarInfo(5, value114);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value115 = DataCanbus.DATA[34];
                if (value115 == 0) {
                    value115 = 1;
                } else if (value115 == 1) {
                    value115 = 0;
                }
                setCarInfo(6, value115);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value116 = DataCanbus.DATA[92];
                if (value116 == 0) {
                    value116 = 1;
                } else if (value116 == 1) {
                    value116 = 0;
                }
                setCarInfo(16, value116);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value117 = DataCanbus.DATA[98];
                if (value117 == 0) {
                    value117 = 1;
                } else if (value117 == 1) {
                    value117 = 0;
                }
                setCarInfo(23, value117);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value118 = DataCanbus.DATA[99];
                if (value118 == 0) {
                    value118 = 1;
                } else if (value118 == 1) {
                    value118 = 0;
                }
                setCarInfo(24, value118);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value119 = DataCanbus.DATA[100];
                if (value119 == 0) {
                    value119 = 1;
                } else if (value119 == 1) {
                    value119 = 0;
                }
                setCarInfo(25, value119);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfo(22, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value120 = DataCanbus.DATA[119] + 1;
                if (value120 > 3) {
                    value120 = 1;
                }
                sendCmd(value120);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                sendCmd2(27);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value121 = DataCanbus.DATA[125];
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
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
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
