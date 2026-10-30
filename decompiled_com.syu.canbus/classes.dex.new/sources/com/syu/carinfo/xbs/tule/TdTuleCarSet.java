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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TdTuleCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tule.TdTuleCarSet.1
        @Override // com.syu.module.IUiNotify
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
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text4)).setText("+" + value);
                    }
                    break;
                case 102:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (256 - value));
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text5)).setText("+" + value);
                    }
                    break;
                case 103:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text6)).setText("-" + (256 - value));
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text6)).setText("0");
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text6)).setText("+" + value);
                    }
                    break;
                case 104:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text7)).setText("-" + (256 - value));
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text7)).setText("0");
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text7)).setText("+" + value);
                    }
                    break;
                case 105:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 106:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 107:
                    if ((value & 128) != 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text9)).setText("-" + (256 - value));
                    } else if (value == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text9)).setText("0");
                    } else if ((value & 128) == 0) {
                        ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text9)).setText("+" + value);
                    }
                    break;
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
                    break;
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
                    break;
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
                    break;
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
                    break;
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
                    break;
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
                    break;
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
                case 150:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 151:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 152:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 153:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 154:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 155:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 156:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 157:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 158:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 159:
                    TdTuleCarSet.this.setCheck((CheckedTextView) TdTuleCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 160:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(value).toString());
                    break;
                case 161:
                    ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
                case 162:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text18)).setText("DVD");
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text18)).setText("HDMI");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text18)).setText("USB");
                            break;
                    }
                    break;
                case 163:
                    switch (value) {
                        case 0:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text19)).setText("DVD");
                            break;
                        case 1:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text19)).setText("HDMI");
                            break;
                        case 2:
                            ((TextView) TdTuleCarSet.this.findViewById(R.id.tv_text19)).setText("USB");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_td_tule_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xbs.tule.TdTuleCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.xbs.tule.TdTuleCarSet.3
            @Override // android.view.View.OnClickListener
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                setCarAmpInfo(33, 49);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                setCarAmpInfo(33, 33);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                setCarAmpInfo(34, 49);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                setCarAmpInfo(34, 33);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                setCarAmpInfo(35, 49);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                setCarAmpInfo(35, 33);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                setCarAmpInfo(36, 49);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                setCarAmpInfo(36, 33);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                setCarAmpInfo(37, 49);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                setCarAmpInfo(37, 33);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                setCarAmpInfo(38, 49);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                setCarAmpInfo(38, 33);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                setCarAmpInfo(40, 49);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                setCarAmpInfo(40, 33);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value5 = DataCanbus.DATA[138] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value6 = DataCanbus.DATA[138] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(13, value6);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value7 = DataCanbus.DATA[139] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value8 = DataCanbus.DATA[139] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(14, value8);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value9 = DataCanbus.DATA[140] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value10 = DataCanbus.DATA[140] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                setCarInfo(18, 1);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                setCarInfo(17, 1);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                setCarInfo(24, 1);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                setCarInfo(23, 1);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                setCarInfo(22, 1);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                setCarInfo(21, 1);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value11 = DataCanbus.DATA[162];
                if (value11 == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{5}, null, null);
                } else if (value11 == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{3}, null, null);
                } else if (value11 == 2) {
                    DataCanbus.PROXY.cmd(4, new int[]{4}, null, null);
                }
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value12 = DataCanbus.DATA[162];
                if (value12 == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{4}, null, null);
                } else if (value12 == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{5}, null, null);
                } else if (value12 == 2) {
                    DataCanbus.PROXY.cmd(4, new int[]{3}, null, null);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(33, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(4, new int[]{2}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(34, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(35, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value13 = DataCanbus.DATA[106];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarAmpInfo(39, value13);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value14 = DataCanbus.DATA[108];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarAmpInfo(41, value14);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value15 = DataCanbus.DATA[163];
                if (value15 == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{8}, null, null);
                } else if (value15 == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{6}, null, null);
                } else if (value15 == 2) {
                    DataCanbus.PROXY.cmd(4, new int[]{7}, null, null);
                }
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value16 = DataCanbus.DATA[163];
                if (value16 == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{7}, null, null);
                } else if (value16 == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{8}, null, null);
                } else if (value16 == 2) {
                    DataCanbus.PROXY.cmd(4, new int[]{6}, null, null);
                }
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value17 = DataCanbus.DATA[160];
                if (value17 == 1) {
                    setCarInfo(65, 0);
                } else if (value17 == 2) {
                    setCarInfo(63, 0);
                } else if (value17 == 3) {
                    setCarInfo(64, 0);
                } else {
                    setCarInfo(63, 0);
                }
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value18 = DataCanbus.DATA[160];
                if (value18 == 1) {
                    setCarInfo(64, 0);
                } else if (value18 == 2) {
                    setCarInfo(65, 0);
                } else if (value18 == 3) {
                    setCarInfo(63, 0);
                } else {
                    setCarInfo(63, 0);
                }
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value19 = DataCanbus.DATA[161];
                if (value19 == 1) {
                    setCarInfo(68, 0);
                } else if (value19 == 2) {
                    setCarInfo(66, 0);
                } else if (value19 == 3) {
                    setCarInfo(67, 0);
                } else {
                    setCarInfo(66, 0);
                }
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value20 = DataCanbus.DATA[161];
                if (value20 == 1) {
                    setCarInfo(67, 0);
                } else if (value20 == 2) {
                    setCarInfo(68, 0);
                } else if (value20 == 3) {
                    setCarInfo(66, 0);
                } else {
                    setCarInfo(66, 0);
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value21 = DataCanbus.DATA[130];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(11, value21);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value22 = DataCanbus.DATA[131];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(10, value22);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value23 = DataCanbus.DATA[132];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(2, value23);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value24 = DataCanbus.DATA[133];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(7, value24);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value25 = DataCanbus.DATA[134];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(8, value25);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value26 = DataCanbus.DATA[141];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(16, value26);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value27 = DataCanbus.DATA[143];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(19, value27);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value28 = DataCanbus.DATA[144];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(20, value28);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                dialog(R.string.all_settings, 9);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value29 = DataCanbus.DATA[150];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(55, value29);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value30 = DataCanbus.DATA[151];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(53, value30);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value31 = DataCanbus.DATA[152];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(54, value31);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value32 = DataCanbus.DATA[153];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(50, value32);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value33 = DataCanbus.DATA[154];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(49, value33);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value34 = DataCanbus.DATA[155];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(52, value34);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value35 = DataCanbus.DATA[156];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(51, value35);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int value36 = DataCanbus.DATA[157];
                if (value36 == 0) {
                    setCarInfo(62, 0);
                } else if (value36 == 1) {
                    setCarInfo(61, 0);
                }
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int value37 = DataCanbus.DATA[158];
                if (value37 == 0) {
                    setCarInfo(58, 0);
                } else if (value37 == 1) {
                    setCarInfo(57, 0);
                }
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int value38 = DataCanbus.DATA[159];
                if (value38 == 0) {
                    setCarInfo(60, 0);
                } else if (value38 == 1) {
                    setCarInfo(59, 0);
                }
                break;
        }
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{116}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{147}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xbs.tule.TdTuleCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.xbs.tule.TdTuleCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xbs.tule.TdTuleCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
