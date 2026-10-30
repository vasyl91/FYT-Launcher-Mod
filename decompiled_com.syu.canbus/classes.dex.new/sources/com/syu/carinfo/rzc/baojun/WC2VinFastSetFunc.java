package com.syu.carinfo.rzc.baojun;

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
public class WC2VinFastSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.WC2VinFastSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "km");
                    break;
                case 100:
                    ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "%");
                    break;
                case 101:
                case 102:
                    int hour = DataCanbus.DATA[101];
                    int min = DataCanbus.DATA[102];
                    ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text11)).setText(String.valueOf(hour) + ":" + (min / 10) + (min % 10));
                    break;
                case 103:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text1)).setText("Sport");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text1)).setText("Eco");
                            break;
                    }
                    break;
                case 104:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text2)).setText("Off");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text2)).setText("Low");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text2)).setText("High");
                            break;
                    }
                    break;
                case 105:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 106:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 107:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("---");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("50%");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("60%");
                            break;
                        case 3:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("70%");
                            break;
                        case 4:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("80%");
                            break;
                        case 5:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("90%");
                            break;
                        case 6:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text3)).setText("100%");
                            break;
                    }
                    break;
                case 108:
                    ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 109:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text5)).setText("Off");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text5)).setText("5");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text5)).setText("10");
                            break;
                        case 3:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text5)).setText("15");
                            break;
                        case 4:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text5)).setText("20");
                            break;
                        case 5:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text5)).setText("25");
                            break;
                    }
                    break;
                case 110:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 111:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 112:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text6)).setText("Off");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text6)).setText("Light");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text6)).setText("Horn");
                            break;
                        case 3:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text6)).setText("Both");
                            break;
                    }
                    break;
                case 113:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 114:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 115:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text7)).setText("Off");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text7)).setText("30s");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text7)).setText("60s");
                            break;
                        case 3:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text7)).setText("90s");
                            break;
                        case 4:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text7)).setText("120s");
                            break;
                    }
                    break;
                case 116:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 117:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("Off");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("40");
                            break;
                        case 2:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("50");
                            break;
                        case 3:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("60");
                            break;
                        case 4:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("70");
                            break;
                        case 5:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("80");
                            break;
                        case 6:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("90");
                            break;
                        case 7:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("100");
                            break;
                        case 8:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("110");
                            break;
                        case 9:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text8)).setText("120");
                            break;
                    }
                    break;
                case 118:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 119:
                    switch (value) {
                        case 0:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text12)).setText("Stop charing");
                            break;
                        case 1:
                            ((TextView) WC2VinFastSetFunc.this.findViewById(R.id.tv_text12)).setText("Charging");
                            break;
                    }
                    break;
                case 120:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 121:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 122:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 123:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 124:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
                case 125:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 126:
                    ((CheckedTextView) WC2VinFastSetFunc.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0444_wc2_winfast_all);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.baojun.WC2VinFastSetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WC2VinFastSetFunc.this.language_set = position;
                if (WC2VinFastSetFunc.this.language_set >= 0 && WC2VinFastSetFunc.this.language_set <= WC2VinFastSetFunc.this.mLauStylelist.size() && WC2VinFastSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{WC2VinFastSetFunc.this.send_lang[WC2VinFastSetFunc.this.language_set]}, null, null);
                }
                WC2VinFastSetFunc.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add("Viet");
        this.send_lang = new int[]{1, 30};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.WC2VinFastSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WC2VinFastSetFunc.this.mLauStyle == null) {
                    WC2VinFastSetFunc.this.initLauStyle();
                }
                if (WC2VinFastSetFunc.this.mLauStyle != null && WC2VinFastSetFunc.this.mPopShowView != null) {
                    WC2VinFastSetFunc.this.mLauStyle.showAtLocation(WC2VinFastSetFunc.this.mPopShowView, 17, 0, 0);
                    WC2VinFastSetFunc.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[103] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(4, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[103] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(4, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[104] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[104] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[107] - 1;
                if (value5 < 0) {
                    value5 = 6;
                }
                setCarInfo(5, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[107] + 1;
                if (value6 > 6) {
                    value6 = 0;
                }
                setCarInfo(5, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[108] - 1;
                if (value7 < 1) {
                    value7 = 15;
                }
                setCarInfo(6, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[108] + 1;
                if (value8 > 15) {
                    value8 = 1;
                }
                setCarInfo(6, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[109] - 1;
                if (value9 < 0) {
                    value9 = 5;
                }
                setCarInfo(10, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[109] + 1;
                if (value10 > 5) {
                    value10 = 0;
                }
                setCarInfo(10, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[112] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(7, value11, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[112] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(7, value12, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[115] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(12, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[115] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(12, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[117] - 1;
                if (value15 < 0) {
                    value15 = 9;
                }
                setCarInfo(16, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[117] + 1;
                if (value16 > 9) {
                    value16 = 0;
                }
                setCarInfo(16, value16, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(2, DataCanbus.DATA[105] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(8, DataCanbus.DATA[111] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(14, DataCanbus.DATA[113] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(1, DataCanbus.DATA[106] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(9, DataCanbus.DATA[110] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(13, DataCanbus.DATA[114] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(11, DataCanbus.DATA[116] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(15, DataCanbus.DATA[118] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(23, DataCanbus.DATA[120] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(22, DataCanbus.DATA[121] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(21, DataCanbus.DATA[122] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(20, DataCanbus.DATA[123] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(19, DataCanbus.DATA[124] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(18, DataCanbus.DATA[125] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(17, DataCanbus.DATA[126] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(24, 1, 255, 255);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setCarInfo(24, 0, 255, 255);
                break;
        }
    }

    void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{97}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }
}
