package com.syu.carinfo.bnr.guanzhi;

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
public class LZRomeoCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 34:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 35:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 36:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 37:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 38:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 39:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 40:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 41:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 42:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 43:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 44:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 45:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_metric);
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_us_imperial);
                                break;
                        }
                    }
                    break;
                case 46:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text6)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text6)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 47:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)).setText("l/100km");
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text7)).setText("mpg");
                                break;
                        }
                    }
                    break;
                case 48:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_selection5);
                                break;
                            default:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 49:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)).setText("kpa");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)).setText("psi");
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text9)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 50:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 51:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 52:
                    if (((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("60s");
                                break;
                            case 3:
                                ((TextView) LZRomeoCarSet.this.findViewById(R.id.tv_text12)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 53:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 54:
                    LZRomeoCarSet.this.setCheck((CheckedTextView) LZRomeoCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 55:
                    LZRomeoCarSet.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_romeo_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZRomeoCarSet.this.language_set = position;
                if (LZRomeoCarSet.this.language_set >= 0 && LZRomeoCarSet.this.language_set <= LZRomeoCarSet.this.mLauStylelist.size() && LZRomeoCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{17, LZRomeoCarSet.this.send_lang[LZRomeoCarSet.this.language_set]}, null, null);
                }
                LZRomeoCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[55];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZRomeoCarSet.this.mLauStyle == null) {
                    LZRomeoCarSet.this.initLauStyle();
                }
                if (LZRomeoCarSet.this.mLauStyle != null && LZRomeoCarSet.this.mPopShowView != null) {
                    LZRomeoCarSet.this.mLauStyle.showAtLocation(LZRomeoCarSet.this.mPopShowView, 17, 0, 0);
                    LZRomeoCarSet.this.updateLauguageSet();
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
                int value = DataCanbus.DATA[34];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[35] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[35] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[38] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[38] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[39] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(9, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[39] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(9, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[40] - 5;
                if (value8 < 30) {
                    value8 = 30;
                }
                setCarInfo(1, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[40] + 5;
                if (value9 > 180) {
                    value9 = 180;
                }
                setCarInfo(1, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[45] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(13, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[45] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(13, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[46] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(14, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[46] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(14, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[47] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(15, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[47] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(15, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[48] - 1;
                if (value16 < 0) {
                    value16 = 0;
                }
                setCarInfo(8, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[48] + 1;
                if (value17 > 4) {
                    value17 = 4;
                }
                setCarInfo(8, value17);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value18 = DataCanbus.DATA[49] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(16, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value19 = DataCanbus.DATA[49] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(16, value19);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value20 = DataCanbus.DATA[50] - 1;
                if (value20 < 0) {
                    value20 = 5;
                }
                setCarInfo(22, value20);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value21 = DataCanbus.DATA[50] + 1;
                if (value21 > 5) {
                    value21 = 0;
                }
                setCarInfo(22, value21);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value22 = DataCanbus.DATA[51] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(18, value22);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value23 = DataCanbus.DATA[51] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(18, value23);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value24 = DataCanbus.DATA[52] - 1;
                if (value24 < 0) {
                    value24 = 3;
                }
                setCarInfo(19, value24);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value25 = DataCanbus.DATA[52] + 1;
                if (value25 > 3) {
                    value25 = 0;
                }
                setCarInfo(19, value25);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value26 = DataCanbus.DATA[36];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(4, value26);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value27 = DataCanbus.DATA[37];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(5, value27);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value28 = DataCanbus.DATA[41];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(7, value28);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value29 = DataCanbus.DATA[42];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(10, value29);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value30 = DataCanbus.DATA[43];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(11, value30);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value31 = DataCanbus.DATA[44];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(12, value31);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value32 = DataCanbus.DATA[53];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(20, value32);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value33 = DataCanbus.DATA[54];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(21, value33);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                dialog(6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.jeep_brakemode)) + "   " + getResources().getString(R.string.str_romeo_tip));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{6}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
