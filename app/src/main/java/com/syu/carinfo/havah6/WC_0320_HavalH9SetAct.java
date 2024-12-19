package com.syu.carinfo.havah6;

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
public class WC_0320_HavalH9SetAct extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 65:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 66:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 92:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 93:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 94:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 95:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 96:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 97:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 98:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("0S");
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("10S");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("20S");
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("1Min");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("2Min");
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("3Min");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)).setText("10Min");
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)).setText("20Min");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)).setText("30Min");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall2);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall1);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_frontlight1);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_frontlight2);
                                break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText("10Min");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText("20Min");
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText("30Min");
                                break;
                        }
                    }
                    break;
                case 105:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_WeiChi2_ChangChengH9 /* 328000 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH9_M /* 393536 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH9_H /* 459072 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH8 /* 1573184 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH8_M /* 1638720 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH8_H /* 1704256 */:
                            WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext1), value == 0);
                            break;
                        default:
                            WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                            break;
                    }
                case 106:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_unlockall_set);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_unlockdriver_set);
                                break;
                        }
                    }
                    break;
                case 107:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 108:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 109:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 110:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0320_wc_haval_h9_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WC_0320_HavalH9SetAct.this.language_set = position;
                if (WC_0320_HavalH9SetAct.this.language_set >= 0 && WC_0320_HavalH9SetAct.this.language_set <= WC_0320_HavalH9SetAct.this.mLauStylelist.size() && WC_0320_HavalH9SetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(6, new int[]{1, WC_0320_HavalH9SetAct.this.send_lang[WC_0320_HavalH9SetAct.this.language_set]}, null, null);
                }
                WC_0320_HavalH9SetAct.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WC_0320_HavalH9SetAct.this.mLauStyle == null) {
                    WC_0320_HavalH9SetAct.this.initLauStyle();
                }
                if (WC_0320_HavalH9SetAct.this.mLauStyle != null && WC_0320_HavalH9SetAct.this.mPopShowView != null) {
                    WC_0320_HavalH9SetAct.this.mLauStyle.showAtLocation(WC_0320_HavalH9SetAct.this.mPopShowView, 17, 0, 0);
                    WC_0320_HavalH9SetAct.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[94] - 1;
                if (value < 0) {
                    value = 5;
                }
                setCarInfo(31, value, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[94] + 1;
                if (value2 > 5) {
                    value2 = 0;
                }
                setCarInfo(31, value2, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[97] - 1;
                if (value3 < 0) {
                    value3 = 5;
                }
                setCarInfo(34, value3, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[97] + 1;
                if (value4 > 5) {
                    value4 = 0;
                }
                setCarInfo(34, value4, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value5 = DataCanbus.DATA[105];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(23, value5, 0, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value6 = DataCanbus.DATA[98] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(16, value6, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value7 = DataCanbus.DATA[98] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(16, value7, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value8 = DataCanbus.DATA[99] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(17, value8, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value9 = DataCanbus.DATA[99] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(17, value9, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value10 = DataCanbus.DATA[100] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(18, value10, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value11 = DataCanbus.DATA[100] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(18, value11, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value12 = DataCanbus.DATA[101] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(19, value12, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value13 = DataCanbus.DATA[101] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(19, value13, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value14 = DataCanbus.DATA[102] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(20, value14, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value15 = DataCanbus.DATA[102] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(20, value15, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value16 = DataCanbus.DATA[103] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo(21, value16, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value17 = DataCanbus.DATA[103] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(21, value17, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value18 = DataCanbus.DATA[104] - 1;
                if (value18 < 0) {
                    value18 = 3;
                }
                setCarInfo(22, value18, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value19 = DataCanbus.DATA[104] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(22, value19, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value20 = DataCanbus.DATA[106] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                setCarInfo(24, value20, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value21 = DataCanbus.DATA[106] + 1;
                if (value21 > 1) {
                    value21 = 0;
                }
                setCarInfo(24, value21, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value22 = DataCanbus.DATA[92] - 1;
                if (value22 < 0) {
                    value22 = 3;
                }
                setCarInfo(29, value22, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value23 = DataCanbus.DATA[92] + 1;
                if (value23 > 3) {
                    value23 = 0;
                }
                setCarInfo(29, value23, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value24 = DataCanbus.DATA[95] - 1;
                if (value24 < 0) {
                    value24 = 3;
                }
                setCarInfo(32, value24, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value25 = DataCanbus.DATA[95] + 1;
                if (value25 > 3) {
                    value25 = 0;
                }
                setCarInfo(32, value25, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value26 = DataCanbus.DATA[93] - 1;
                if (value26 < 0) {
                    value26 = 2;
                }
                setCarInfo(30, value26, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value27 = DataCanbus.DATA[93] + 1;
                if (value27 > 2) {
                    value27 = 0;
                }
                setCarInfo(30, value27, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value28 = DataCanbus.DATA[96] - 1;
                if (value28 < 0) {
                    value28 = 2;
                }
                setCarInfo(33, value28, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value29 = DataCanbus.DATA[96] + 1;
                if (value29 > 2) {
                    value29 = 0;
                }
                setCarInfo(33, value29, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value30 = DataCanbus.DATA[107];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(25, value30, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value31 = DataCanbus.DATA[108];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(26, value31, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value32 = DataCanbus.DATA[109];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(27, value32, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value33 = DataCanbus.DATA[110];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(28, value33, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setAir(17);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                setAir(18);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(7, new int[]{value0, value1, value2, value3}, null, null);
    }

    private void setAir(final int cmd) {
        DataCanbus.PROXY.cmd(4, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.4
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(4, new int[]{cmd}, null, null);
            }
        }, 200L);
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
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
    }
}
