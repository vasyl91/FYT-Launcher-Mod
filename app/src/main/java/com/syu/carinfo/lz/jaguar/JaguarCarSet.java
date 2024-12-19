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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                        break;
                    }
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
                        break;
                    }
                case 102:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        if (val > 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)).setText("R" + (val - 9));
                            break;
                        } else if (val < 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)).setText("L" + (9 - val));
                            break;
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text9)).setText("0");
                            break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        if (val > 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)).setText("R" + (val - 9));
                            break;
                        } else if (val < 9) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)).setText("F" + (9 - val));
                            break;
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text10)).setText("0");
                            break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        if (val > 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)).setText("+" + (val - 5));
                            break;
                        } else if (val < 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)).setText("-" + (5 - val));
                            break;
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text11)).setText("0");
                            break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        if (val > 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)).setText("+" + (val - 5));
                            break;
                        } else if (val < 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)).setText("-" + (5 - val));
                            break;
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text12)).setText("0");
                            break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        if (val > 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)).setText("+" + (val - 5));
                            break;
                        } else if (val < 5) {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)).setText("-" + (5 - val));
                            break;
                        } else {
                            ((TextView) JaguarCarSet.this.findViewById(R.id.tv_text13)).setText("0");
                            break;
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
                        break;
                    }
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
                int value02 = DataCanbus.DATA[101];
                int value12 = DataCanbus.DATA[102];
                int value22 = DataCanbus.DATA[103];
                int value32 = DataCanbus.DATA[104];
                int value42 = DataCanbus.DATA[105];
                int value52 = DataCanbus.DATA[106];
                int value62 = DataCanbus.DATA[107];
                if (value62 < 3) {
                    value62++;
                }
                setCarAmp(value02, value12, value22, value32, value42, value52, value62);
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
                int value7 = DataCanbus.DATA[35] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(12, value7);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value8 = DataCanbus.DATA[35] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(12, value8);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value9 = DataCanbus.DATA[94] - 1;
                if (value9 < 0) {
                    value9 = 5;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value10 = DataCanbus.DATA[94] + 1;
                if (value10 > 5) {
                    value10 = 0;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value11 = DataCanbus.DATA[91] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(17, value11);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[91] + 1;
                if (value13 > 3) {
                    value13 = 0;
                }
                setCarInfo(17, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[95] - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarInfo(19, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[95] + 1;
                if (value15 > 3) {
                    value15 = 0;
                }
                setCarInfo(19, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[96] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(20, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[96] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(20, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[93] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(21, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[93] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(21, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value03 = DataCanbus.DATA[101];
                int value110 = DataCanbus.DATA[102];
                int value23 = DataCanbus.DATA[103];
                int value33 = DataCanbus.DATA[104];
                int value43 = DataCanbus.DATA[105];
                int value53 = DataCanbus.DATA[106];
                int value63 = DataCanbus.DATA[107];
                if (value03 > 0) {
                    value03--;
                }
                setCarAmp(value03, value110, value23, value33, value43, value53, value63);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value04 = DataCanbus.DATA[101];
                int value111 = DataCanbus.DATA[102];
                int value24 = DataCanbus.DATA[103];
                int value34 = DataCanbus.DATA[104];
                int value44 = DataCanbus.DATA[105];
                int value54 = DataCanbus.DATA[106];
                int value64 = DataCanbus.DATA[107];
                if (value04 < 38) {
                    value04++;
                }
                setCarAmp(value04, value111, value24, value34, value44, value54, value64);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value05 = DataCanbus.DATA[101];
                int value112 = DataCanbus.DATA[102];
                int value25 = DataCanbus.DATA[103];
                int value35 = DataCanbus.DATA[104];
                int value45 = DataCanbus.DATA[105];
                int value55 = DataCanbus.DATA[106];
                int value65 = DataCanbus.DATA[107];
                if (value112 > 0) {
                    value112--;
                }
                setCarAmp(value05, value112, value25, value35, value45, value55, value65);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value06 = DataCanbus.DATA[101];
                int value113 = DataCanbus.DATA[102];
                int value26 = DataCanbus.DATA[103];
                int value36 = DataCanbus.DATA[104];
                int value46 = DataCanbus.DATA[105];
                int value56 = DataCanbus.DATA[106];
                int value66 = DataCanbus.DATA[107];
                if (value113 < 19) {
                    value113++;
                }
                setCarAmp(value06, value113, value26, value36, value46, value56, value66);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value07 = DataCanbus.DATA[101];
                int value114 = DataCanbus.DATA[102];
                int value27 = DataCanbus.DATA[103];
                int value37 = DataCanbus.DATA[104];
                int value47 = DataCanbus.DATA[105];
                int value57 = DataCanbus.DATA[106];
                int value67 = DataCanbus.DATA[107];
                if (value27 > 0) {
                    value27--;
                }
                setCarAmp(value07, value114, value27, value37, value47, value57, value67);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value08 = DataCanbus.DATA[101];
                int value115 = DataCanbus.DATA[102];
                int value28 = DataCanbus.DATA[103];
                int value38 = DataCanbus.DATA[104];
                int value48 = DataCanbus.DATA[105];
                int value58 = DataCanbus.DATA[106];
                int value68 = DataCanbus.DATA[107];
                if (value28 < 19) {
                    value28++;
                }
                setCarAmp(value08, value115, value28, value38, value48, value58, value68);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value09 = DataCanbus.DATA[101];
                int value116 = DataCanbus.DATA[102];
                int value29 = DataCanbus.DATA[103];
                int value39 = DataCanbus.DATA[104];
                int value49 = DataCanbus.DATA[105];
                int value59 = DataCanbus.DATA[106];
                int value69 = DataCanbus.DATA[107];
                if (value39 > 0) {
                    value39--;
                }
                setCarAmp(value09, value116, value29, value39, value49, value59, value69);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value010 = DataCanbus.DATA[101];
                int value117 = DataCanbus.DATA[102];
                int value210 = DataCanbus.DATA[103];
                int value310 = DataCanbus.DATA[104];
                int value410 = DataCanbus.DATA[105];
                int value510 = DataCanbus.DATA[106];
                int value610 = DataCanbus.DATA[107];
                if (value310 < 15) {
                    value310++;
                }
                setCarAmp(value010, value117, value210, value310, value410, value510, value610);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value011 = DataCanbus.DATA[101];
                int value118 = DataCanbus.DATA[102];
                int value211 = DataCanbus.DATA[103];
                int value311 = DataCanbus.DATA[104];
                int value411 = DataCanbus.DATA[105];
                int value511 = DataCanbus.DATA[106];
                int value611 = DataCanbus.DATA[107];
                if (value411 > 0) {
                    value411--;
                }
                setCarAmp(value011, value118, value211, value311, value411, value511, value611);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value012 = DataCanbus.DATA[101];
                int value119 = DataCanbus.DATA[102];
                int value212 = DataCanbus.DATA[103];
                int value312 = DataCanbus.DATA[104];
                int value412 = DataCanbus.DATA[105];
                int value512 = DataCanbus.DATA[106];
                int value612 = DataCanbus.DATA[107];
                if (value412 < 15) {
                    value412++;
                }
                setCarAmp(value012, value119, value212, value312, value412, value512, value612);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value013 = DataCanbus.DATA[101];
                int value120 = DataCanbus.DATA[102];
                int value213 = DataCanbus.DATA[103];
                int value313 = DataCanbus.DATA[104];
                int value413 = DataCanbus.DATA[105];
                int value513 = DataCanbus.DATA[106];
                int value613 = DataCanbus.DATA[107];
                if (value513 > 0) {
                    value513--;
                }
                setCarAmp(value013, value120, value213, value313, value413, value513, value613);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value014 = DataCanbus.DATA[101];
                int value121 = DataCanbus.DATA[102];
                int value214 = DataCanbus.DATA[103];
                int value314 = DataCanbus.DATA[104];
                int value414 = DataCanbus.DATA[105];
                int value514 = DataCanbus.DATA[106];
                int value614 = DataCanbus.DATA[107];
                if (value514 < 15) {
                    value514++;
                }
                setCarAmp(value014, value121, value214, value314, value414, value514, value614);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value20 = DataCanbus.DATA[29];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(1, value20);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value21 = DataCanbus.DATA[30];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(2, value21);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value30 = DataCanbus.DATA[31];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(3, value30);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value31 = DataCanbus.DATA[32];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(4, value31);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value40 = DataCanbus.DATA[33];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(5, value40);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value41 = DataCanbus.DATA[34];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(6, value41);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value50 = DataCanbus.DATA[92];
                if (value50 == 0) {
                    value50 = 1;
                } else if (value50 == 1) {
                    value50 = 0;
                }
                setCarInfo(16, value50);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value51 = DataCanbus.DATA[98];
                if (value51 == 0) {
                    value51 = 1;
                } else if (value51 == 1) {
                    value51 = 0;
                }
                setCarInfo(23, value51);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value60 = DataCanbus.DATA[99];
                if (value60 == 0) {
                    value60 = 1;
                } else if (value60 == 1) {
                    value60 = 0;
                }
                setCarInfo(24, value60);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value61 = DataCanbus.DATA[100];
                if (value61 == 0) {
                    value61 = 1;
                } else if (value61 == 1) {
                    value61 = 0;
                }
                setCarInfo(25, value61);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfo(22, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value70 = DataCanbus.DATA[119] + 1;
                if (value70 > 3) {
                    value70 = 1;
                }
                sendCmd(value70);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                sendCmd2(27);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value71 = DataCanbus.DATA[125];
                if (value71 == 0) {
                    value71 = 1;
                } else if (value71 == 1) {
                    value71 = 0;
                }
                setCarInfo(35, value71);
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
                DataCanbus.PROXY.cmd(0, new int[]{14}, null, null);
            }
        }, 200L);
    }

    private void sendCmd2(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarCarSet.4
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
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
