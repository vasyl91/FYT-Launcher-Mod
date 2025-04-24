package com.syu.carinfo.xbs.tule;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class TdTuleCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 100:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 101:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (256 - value));
                        break;
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text4)).setText("+" + value);
                        break;
                    }
                case 102:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (256 - value));
                        break;
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text5)).setText("+" + value);
                        break;
                    }
                case 103:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text6)).setText("-" + (256 - value));
                        break;
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                        break;
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text6)).setText("+" + value);
                        break;
                    }
                case 104:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text7)).setText("-" + (256 - value));
                        break;
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text7)).setText("+" + value);
                        break;
                    }
                case 105:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 106:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 107:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text9)).setText("-" + (256 - value));
                        break;
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text9)).setText("0");
                        break;
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text9)).setText("+" + value);
                        break;
                    }
                case 108:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 130:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 131:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 132:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 133:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 134:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 135:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 136:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("0s");
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("30s");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("45s");
                            break;
                        case 3:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("60s");
                            break;
                        case 4:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("90s");
                            break;
                        case 5:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("120s");
                            break;
                        case 6:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("150s");
                            break;
                        case 7:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text11)).setText("180s");
                            break;
                    }
                case 137:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext1), false);
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext2), false);
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext3), false);
                    switch (value) {
                        case 1:
                            TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext1), true);
                            break;
                        case 2:
                            TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext2), true);
                            break;
                        case 3:
                            TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext3), true);
                            break;
                    }
                case 138:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text12)).setText("lock");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text12)).setText("unlock");
                            break;
                        case 3:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text12)).setText("lock and unlock");
                            break;
                    }
                case 139:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text13)).setText("lock");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text13)).setText("unlock");
                            break;
                        case 3:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text13)).setText("lock and unlock");
                            break;
                    }
                case 140:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text14)).setText("beeper");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text14)).setText("horn chirp");
                            break;
                    }
                case 141:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 142:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text15)).setText("30s");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text15)).setText("1min");
                            break;
                        case 3:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text15)).setText("2min");
                            break;
                        case 4:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text15)).setText("5min");
                            break;
                    }
                case 143:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 144:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 145:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                    break;
                case 146:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                    break;
                case 148:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 149:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_td_tule_settings);
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
                TdTuleCarSet.this.language_set = position;
                if (TdTuleCarSet.this.language_set >= 0 && TdTuleCarSet.this.language_set <= TdTuleCarSet.this.mLauStylelist.size() && TdTuleCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{49, TdTuleCarSet.this.send_lang[TdTuleCarSet.this.language_set]}, null, null);
                }
                TdTuleCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (TdTuleCarSet.this.mLauStyle == null) {
                    TdTuleCarSet.this.initLauStyle();
                }
                if (TdTuleCarSet.this.mLauStyle != null && TdTuleCarSet.this.mPopShowView != null) {
                    TdTuleCarSet.this.mLauStyle.showAtLocation(TdTuleCarSet.this.mPopShowView, 17, 0, 0);
                    TdTuleCarSet.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarAmpInfo(33, 49);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarAmpInfo(33, 33);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarAmpInfo(34, 49);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarAmpInfo(34, 33);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarAmpInfo(35, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarAmpInfo(35, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarAmpInfo(36, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarAmpInfo(36, 33);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarAmpInfo(37, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarAmpInfo(37, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarAmpInfo(38, 49);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarAmpInfo(38, 33);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                setCarAmpInfo(40, 49);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                setCarAmpInfo(40, 33);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value5 = DataCanbus.DATA[138] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value6 = DataCanbus.DATA[138] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(13, value6);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value7 = DataCanbus.DATA[139] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value8 = DataCanbus.DATA[139] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(14, value8);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value9 = DataCanbus.DATA[140] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value10 = DataCanbus.DATA[140] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                setCarInfo(18, 1);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                setCarInfo(17, 1);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                setCarInfo(24, 1);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                setCarInfo(23, 1);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                setCarInfo(22, 1);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                setCarInfo(21, 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(33, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(34, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(35, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                DataCanbus.PROXY.cmd(4, new int[]{2}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value11 = DataCanbus.DATA[106];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarAmpInfo(39, value11);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value12 = DataCanbus.DATA[108];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarAmpInfo(41, value12);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value13 = DataCanbus.DATA[130];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(11, value13);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value14 = DataCanbus.DATA[131];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(10, value14);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value15 = DataCanbus.DATA[132];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(2, value15);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value16 = DataCanbus.DATA[133];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(7, value16);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value17 = DataCanbus.DATA[134];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(8, value17);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value18 = DataCanbus.DATA[141];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(16, value18);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value19 = DataCanbus.DATA[143];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(19, value19);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value20 = DataCanbus.DATA[144];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(20, value20);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                dialog(R.string.all_settings, 9);
                break;
        }
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{116}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{147}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
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
                        DataCanbus.PROXY.cmd(2, new int[]{i, 1}, null, null);
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
}
