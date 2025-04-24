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

@SuppressWarnings({"deprecation", "unchecked"})
public class WC_0320_HavalH9SetAct extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 30:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 157:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 158:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 159:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 160:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 161:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 162:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 163:
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
                case 164:
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
                case 165:
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
                case 166:
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
                case 167:
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
                case 168:
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
                case 169:
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
                case 170:
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
                case 171:
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
                case 172:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 173:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 174:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 175:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0320_wc_haval_h9_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[163] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(16, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[163] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(16, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[164] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(17, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[164] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(17, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[165] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(18, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[165] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(18, value6, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[166] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(19, value7, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[166] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(19, value8, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[167] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(20, value9, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[167] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(20, value10, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[168] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(21, value11, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[168] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(21, value12, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[169] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(22, value13, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[169] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(22, value14, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[171] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(24, value15, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[171] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(24, value16, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[157] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(29, value17, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[157] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(29, value18, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[160] - 1;
                if (value19 < 0) {
                    value19 = 3;
                }
                setCarInfo(32, value19, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[160] + 1;
                if (value20 > 3) {
                    value20 = 0;
                }
                setCarInfo(32, value20, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[158] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(30, value21, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[158] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(30, value22, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[161] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(33, value23, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[161] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(33, value24, 0, 0);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[159] - 1;
                if (value25 < 0) {
                    value25 = 5;
                }
                setCarInfo(31, value25, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[159] + 1;
                if (value26 > 5) {
                    value26 = 0;
                }
                setCarInfo(31, value26, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[162] - 1;
                if (value27 < 0) {
                    value27 = 5;
                }
                setCarInfo(34, value27, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[162] + 1;
                if (value28 > 5) {
                    value28 = 0;
                }
                setCarInfo(34, value28, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value29 = DataCanbus.DATA[170];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(23, value29, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value30 = DataCanbus.DATA[172];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(25, value30, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value31 = DataCanbus.DATA[173];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(26, value31, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value32 = DataCanbus.DATA[174];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(27, value32, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value33 = DataCanbus.DATA[175];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(28, value33, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setAir(17);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setAir(18);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(7, new int[]{value0, value1, value2, value3}, null, null);
    }

    private void setAir(final int cmd) {
        DataCanbus.PROXY.cmd(4, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(4, new int[]{cmd}, null, null);
            }
        }, 200L);
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
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }
}
