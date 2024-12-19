package com.syu.carinfo.havah6;

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
public class Wc_320_CarSetlAct_newH6 extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.Wc_320_CarSetlAct_newH6.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                    if (value == 0) {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_Manual);
                        break;
                    } else {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_auto);
                        break;
                    }
                case 32:
                    if (value == 0) {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_c4l_close);
                        break;
                    } else {
                        ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_c4l_open);
                        break;
                    }
                case 55:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 56:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 57:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 58:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 59:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 60:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text1)).setText(R.string.wc_372_low);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                    }
                case 61:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 62:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 63:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 64:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text2)).setText(R.string.str_bright_gold);
                            break;
                    }
                case 69:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text3)).setText(R.string.str_244_rainfall2);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text3)).setText(R.string.str_244_rainfall1);
                            break;
                    }
                case 70:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 79:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext12), value != 0);
                    break;
                case 80:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext11), value != 0);
                    break;
                case 81:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 82:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext13), value != 0);
                    break;
                case 83:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext14), value != 0);
                    break;
                case 84:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                            break;
                    }
                case 113:
                    switch (value) {
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text8)).setText(R.string.str_long);
                            break;
                        default:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text8)).setText(R.string.str_short);
                            break;
                    }
                case 114:
                    Wc_320_CarSetlAct_newH6.this.setCheck((CheckedTextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.ctv_checkedtext15), value != 0);
                    break;
                case 115:
                    switch (value) {
                        case 0:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text7)).setText("8km/h");
                            break;
                        case 2:
                            ((TextView) Wc_320_CarSetlAct_newH6.this.findViewById(R.id.tv_text7)).setText("15km/h");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_newh6_carset);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.havah6.Wc_320_CarSetlAct_newH6.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Wc_320_CarSetlAct_newH6.this.language_set = position;
                if (Wc_320_CarSetlAct_newH6.this.language_set >= 0 && Wc_320_CarSetlAct_newH6.this.language_set <= Wc_320_CarSetlAct_newH6.this.mLauStylelist.size() && Wc_320_CarSetlAct_newH6.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(6, new int[]{1, Wc_320_CarSetlAct_newH6.this.send_lang[Wc_320_CarSetlAct_newH6.this.language_set]}, null, null);
                }
                Wc_320_CarSetlAct_newH6.this.mLauStyle.dismiss();
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.havah6.Wc_320_CarSetlAct_newH6.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Wc_320_CarSetlAct_newH6.this.mLauStyle == null) {
                    Wc_320_CarSetlAct_newH6.this.initLauStyle();
                }
                if (Wc_320_CarSetlAct_newH6.this.mLauStyle != null && Wc_320_CarSetlAct_newH6.this.mPopShowView != null) {
                    Wc_320_CarSetlAct_newH6.this.mLauStyle.showAtLocation(Wc_320_CarSetlAct_newH6.this.mPopShowView, 17, 0, 0);
                    Wc_320_CarSetlAct_newH6.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        int value12;
        int value13;
        int value14;
        int value15;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value16 = DataCanbus.DATA[55];
                if (value16 == 0) {
                    value15 = 1;
                } else {
                    value15 = 0;
                }
                CarSetControl(12, value15);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value17 = DataCanbus.DATA[60];
                int value18 = value17 - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                CarSetControl(11, value18);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value19 = DataCanbus.DATA[60];
                int value20 = value19 + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                CarSetControl(11, value20);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value21 = DataCanbus.DATA[64];
                int value22 = value21 - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                CarSetControl(17, value22);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value23 = DataCanbus.DATA[64];
                int value24 = value23 + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                CarSetControl(17, value24);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value25 = DataCanbus.DATA[69];
                int value26 = value25 - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                CarSetControl(18, value26);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value27 = DataCanbus.DATA[69];
                int value28 = value27 + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                CarSetControl(18, value28);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                if (DataCanbus.DATA[31] == 0) {
                    CarSetControl(0, 1);
                    break;
                } else {
                    CarSetControl(0, 0);
                    break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                if (DataCanbus.DATA[31] == 0) {
                    CarSetControl(0, 1);
                    break;
                } else {
                    CarSetControl(0, 0);
                    break;
                }
            case R.id.btn_minus5 /* 2131427496 */:
                if (DataCanbus.DATA[32] == 0) {
                    CarSetControl(1, 1);
                    break;
                } else {
                    CarSetControl(1, 0);
                    break;
                }
            case R.id.btn_plus5 /* 2131427498 */:
                if (DataCanbus.DATA[32] == 0) {
                    CarSetControl(1, 1);
                    break;
                } else {
                    CarSetControl(1, 0);
                    break;
                }
            case R.id.btn_minus6 /* 2131427501 */:
                int value29 = DataCanbus.DATA[84];
                int value30 = value29 - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                CarSetControl(25, value30);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value31 = DataCanbus.DATA[84];
                int value32 = value31 + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                CarSetControl(25, value32);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value33 = DataCanbus.DATA[115];
                int value34 = value33 - 1;
                if (value34 < 0) {
                    value34 = 2;
                }
                CarSetControl(28, value34);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value35 = DataCanbus.DATA[115];
                int value36 = value35 + 1;
                if (value36 > 2) {
                    value36 = 0;
                }
                CarSetControl(28, value36);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value37 = DataCanbus.DATA[113];
                int value38 = value37 - 1;
                if (value38 < 1) {
                    value38 = 3;
                }
                CarSetControl(30, value38);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value39 = DataCanbus.DATA[113];
                int value40 = value39 + 1;
                if (value40 > 3) {
                    value40 = 1;
                }
                CarSetControl(30, value40);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value41 = DataCanbus.DATA[56];
                if (value41 == 0) {
                    value14 = 1;
                } else {
                    value14 = 0;
                }
                CarSetControl(13, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value42 = DataCanbus.DATA[57];
                if (value42 == 0) {
                    value13 = 1;
                } else {
                    value13 = 0;
                }
                CarSetControl(8, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value43 = DataCanbus.DATA[58];
                if (value43 == 0) {
                    value12 = 1;
                } else {
                    value12 = 0;
                }
                CarSetControl(9, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value44 = DataCanbus.DATA[59];
                if (value44 == 0) {
                    value11 = 1;
                } else {
                    value11 = 0;
                }
                CarSetControl(10, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value45 = DataCanbus.DATA[61];
                if (value45 == 0) {
                    value10 = 1;
                } else {
                    value10 = 0;
                }
                CarSetControl(14, value10);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value46 = DataCanbus.DATA[62];
                if (value46 == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                CarSetControl(15, value9);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value47 = DataCanbus.DATA[63];
                if (value47 == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                CarSetControl(16, value8);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value48 = DataCanbus.DATA[70];
                if (value48 == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                CarSetControl(19, value7);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value49 = DataCanbus.DATA[81];
                if (value49 == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                CarSetControl(24, value6);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value50 = DataCanbus.DATA[80];
                if (value50 == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                CarSetControl(23, value5);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value51 = DataCanbus.DATA[79];
                if (value51 == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                CarSetControl(22, value4);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value52 = DataCanbus.DATA[82];
                if (value52 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                CarSetControl(26, value3);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value53 = DataCanbus.DATA[83];
                if (value53 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                CarSetControl(27, value2);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value54 = DataCanbus.DATA[114];
                if (value54 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                CarSetControl(29, value);
                break;
        }
    }

    private void CarSetControl(int cmd1, int cmd2) {
        DataCanbus.PROXY.cmd(5, new int[]{cmd1, cmd2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }
}
