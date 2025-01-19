package com.syu.carinfo.dasauto;

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

public class RZCBmwX1CarSet extends BaseActivity implements View.OnClickListener {
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
                case 113:
                    if (((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("l/100km");
                                break;
                            case 1:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("mpg(US)");
                                break;
                            case 2:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("mpg(UK)");
                                break;
                            case 3:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text1)).setText("km/l");
                                break;
                        }
                    }
                    break;
                case 114:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text2)).setText("℃");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text2)).setText("℉");
                            break;
                    }
                case 115:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text3)).setText("km");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text3)).setText("mls");
                            break;
                    }
                case 116:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_1);
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_0);
                            break;
                    }
                case 140:
                    if (((CheckedTextView) RZCBmwX1CarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCBmwX1CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 141:
                    if (((CheckedTextView) RZCBmwX1CarSet.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) RZCBmwX1CarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                        break;
                    }
                case 142:
                    if (((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text5)).setText("Temp");
                                break;
                            case 1:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text5)).setText("Arrival");
                                break;
                        }
                    }
                    break;
                case 143:
                    if (((CheckedTextView) RZCBmwX1CarSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) RZCBmwX1CarSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                        break;
                    }
                case 144:
                    if (((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 145:
                    if (((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 146:
                    int unit = DataCanbus.DATA[113];
                    switch (unit) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "l/100km");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "mpg(US)");
                            break;
                        case 2:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "mpg(UK)");
                            break;
                        case 3:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/l");
                            break;
                    }
                case 147:
                    int unit2 = DataCanbus.DATA[113];
                    switch (unit2) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + "l/100km");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + "mpg(US)");
                            break;
                        case 2:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + "mpg(UK)");
                            break;
                        case 3:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/l");
                            break;
                    }
                case 148:
                    int unit3 = DataCanbus.DATA[115];
                    switch (unit3) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/h");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + "mph");
                            break;
                    }
                case 149:
                    int unit4 = DataCanbus.DATA[115];
                    switch (unit4) {
                        case 0:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "km");
                            break;
                        case 1:
                            ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "miles");
                            break;
                    }
                case 150:
                    int unit5 = DataCanbus.DATA[114];
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        switch (unit5) {
                            case 0:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text12)).setText("-" + value2 + "℃");
                                break;
                            case 1:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text12)).setText("-" + value2 + "℉");
                                break;
                        }
                    } else {
                        switch (unit5) {
                            case 0:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "℃");
                                break;
                            case 1:
                                ((TextView) RZCBmwX1CarSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "℉");
                                break;
                        }
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0051_rzc_bmw_x1_settings);
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
                RZCBmwX1CarSet.this.language_set = position;
                if (RZCBmwX1CarSet.this.language_set >= 0 && RZCBmwX1CarSet.this.language_set <= RZCBmwX1CarSet.this.mLauStylelist.size() && RZCBmwX1CarSet.this.send_lang != null) {
                    int fuelunit = DataCanbus.DATA[113];
                    int tempunit = DataCanbus.DATA[114];
                    int distanceunit = DataCanbus.DATA[115];
                    int timeformat = DataCanbus.DATA[116];
                    int d2_b7 = DataCanbus.DATA[140];
                    int d2_b6 = DataCanbus.DATA[141];
                    int d2_b5 = DataCanbus.DATA[142];
                    int language = RZCBmwX1CarSet.this.send_lang[RZCBmwX1CarSet.this.language_set];
                    int value = ((fuelunit << 6) & 192) | ((tempunit << 5) & 32) | ((distanceunit << 4) & 16) | ((timeformat << 3) & 8) | (language & 7);
                    int value2 = ((d2_b7 << 7) & 128) | ((d2_b6 << 6) & 64) | ((d2_b5 << 5) & 32);
                    RZCBmwX1CarSet.this.setCarInfo(17, value, value2);
                }
                RZCBmwX1CarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_35));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCBmwX1CarSet.this.mLauStyle == null) {
                    RZCBmwX1CarSet.this.initLauStyle();
                }
                if (RZCBmwX1CarSet.this.mLauStyle != null && RZCBmwX1CarSet.this.mPopShowView != null) {
                    RZCBmwX1CarSet.this.mLauStyle.showAtLocation(RZCBmwX1CarSet.this.mPopShowView, 17, 0, 0);
                    RZCBmwX1CarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int fuelunit = DataCanbus.DATA[113];
                int tempunit = DataCanbus.DATA[114];
                int distanceunit = DataCanbus.DATA[115];
                int timeformat = DataCanbus.DATA[116];
                int language = DataCanbus.DATA[117];
                int d2_b7 = DataCanbus.DATA[140];
                int d2_b6 = DataCanbus.DATA[141];
                int d2_b5 = DataCanbus.DATA[142];
                int fuelunit2 = fuelunit - 1;
                if (fuelunit2 < 0) {
                    fuelunit2 = 3;
                }
                int value = ((fuelunit2 << 6) & 192) | ((tempunit << 5) & 32) | ((distanceunit << 4) & 16) | ((timeformat << 3) & 8) | (language & 7);
                int value2 = ((d2_b7 << 7) & 128) | ((d2_b6 << 6) & 64) | ((d2_b5 << 5) & 32);
                setCarInfo(17, value, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int fuelunit3 = DataCanbus.DATA[113];
                int tempunit2 = DataCanbus.DATA[114];
                int distanceunit2 = DataCanbus.DATA[115];
                int timeformat2 = DataCanbus.DATA[116];
                int language2 = DataCanbus.DATA[117];
                int d2_b72 = DataCanbus.DATA[140];
                int d2_b62 = DataCanbus.DATA[141];
                int d2_b52 = DataCanbus.DATA[142];
                int fuelunit4 = fuelunit3 + 1;
                if (fuelunit4 > 3) {
                    fuelunit4 = 0;
                }
                int value3 = ((fuelunit4 << 6) & 192) | ((tempunit2 << 5) & 32) | ((distanceunit2 << 4) & 16) | ((timeformat2 << 3) & 8) | (language2 & 7);
                int value22 = ((d2_b72 << 7) & 128) | ((d2_b62 << 6) & 64) | ((d2_b52 << 5) & 32);
                setCarInfo(17, value3, value22);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int fuelunit5 = DataCanbus.DATA[113];
                int tempunit3 = DataCanbus.DATA[114];
                int distanceunit3 = DataCanbus.DATA[115];
                int timeformat3 = DataCanbus.DATA[116];
                int language3 = DataCanbus.DATA[117];
                int d2_b73 = DataCanbus.DATA[140];
                int d2_b63 = DataCanbus.DATA[141];
                int d2_b53 = DataCanbus.DATA[142];
                int tempunit4 = tempunit3 - 1;
                if (tempunit4 < 0) {
                    tempunit4 = 1;
                }
                int value4 = ((fuelunit5 << 6) & 192) | ((tempunit4 << 5) & 32) | ((distanceunit3 << 4) & 16) | ((timeformat3 << 3) & 8) | (language3 & 7);
                int value23 = ((d2_b73 << 7) & 128) | ((d2_b63 << 6) & 64) | ((d2_b53 << 5) & 32);
                setCarInfo(17, value4, value23);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int fuelunit6 = DataCanbus.DATA[113];
                int tempunit5 = DataCanbus.DATA[114];
                int distanceunit4 = DataCanbus.DATA[115];
                int timeformat4 = DataCanbus.DATA[116];
                int language4 = DataCanbus.DATA[117];
                int d2_b74 = DataCanbus.DATA[140];
                int d2_b64 = DataCanbus.DATA[141];
                int d2_b54 = DataCanbus.DATA[142];
                int tempunit6 = tempunit5 + 1;
                if (tempunit6 > 1) {
                    tempunit6 = 0;
                }
                int value5 = ((fuelunit6 << 6) & 192) | ((tempunit6 << 5) & 32) | ((distanceunit4 << 4) & 16) | ((timeformat4 << 3) & 8) | (language4 & 7);
                int value24 = ((d2_b74 << 7) & 128) | ((d2_b64 << 6) & 64) | ((d2_b54 << 5) & 32);
                setCarInfo(17, value5, value24);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int fuelunit7 = DataCanbus.DATA[113];
                int tempunit7 = DataCanbus.DATA[114];
                int distanceunit5 = DataCanbus.DATA[115];
                int timeformat5 = DataCanbus.DATA[116];
                int language5 = DataCanbus.DATA[117];
                int d2_b75 = DataCanbus.DATA[140];
                int d2_b65 = DataCanbus.DATA[141];
                int d2_b55 = DataCanbus.DATA[142];
                int distanceunit6 = distanceunit5 - 1;
                if (distanceunit6 < 0) {
                    distanceunit6 = 1;
                }
                int value6 = ((fuelunit7 << 6) & 192) | ((tempunit7 << 5) & 32) | ((distanceunit6 << 4) & 16) | ((timeformat5 << 3) & 8) | (language5 & 7);
                int value25 = ((d2_b75 << 7) & 128) | ((d2_b65 << 6) & 64) | ((d2_b55 << 5) & 32);
                setCarInfo(17, value6, value25);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int fuelunit8 = DataCanbus.DATA[113];
                int tempunit8 = DataCanbus.DATA[114];
                int distanceunit7 = DataCanbus.DATA[115];
                int timeformat6 = DataCanbus.DATA[116];
                int language6 = DataCanbus.DATA[117];
                int d2_b76 = DataCanbus.DATA[140];
                int d2_b66 = DataCanbus.DATA[141];
                int d2_b56 = DataCanbus.DATA[142];
                int distanceunit8 = distanceunit7 + 1;
                if (distanceunit8 > 1) {
                    distanceunit8 = 0;
                }
                int value7 = ((fuelunit8 << 6) & 192) | ((tempunit8 << 5) & 32) | ((distanceunit8 << 4) & 16) | ((timeformat6 << 3) & 8) | (language6 & 7);
                int value26 = ((d2_b76 << 7) & 128) | ((d2_b66 << 6) & 64) | ((d2_b56 << 5) & 32);
                setCarInfo(17, value7, value26);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int fuelunit9 = DataCanbus.DATA[113];
                int tempunit9 = DataCanbus.DATA[114];
                int distanceunit9 = DataCanbus.DATA[115];
                int timeformat7 = DataCanbus.DATA[116];
                int language7 = DataCanbus.DATA[117];
                int d2_b77 = DataCanbus.DATA[140];
                int d2_b67 = DataCanbus.DATA[141];
                int d2_b57 = DataCanbus.DATA[142];
                int timeformat8 = timeformat7 - 1;
                if (timeformat8 < 0) {
                    timeformat8 = 1;
                }
                int value8 = ((fuelunit9 << 6) & 192) | ((tempunit9 << 5) & 32) | ((distanceunit9 << 4) & 16) | ((timeformat8 << 3) & 8) | (language7 & 7);
                int value27 = ((d2_b77 << 7) & 128) | ((d2_b67 << 6) & 64) | ((d2_b57 << 5) & 32);
                setCarInfo(17, value8, value27);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int fuelunit10 = DataCanbus.DATA[113];
                int tempunit10 = DataCanbus.DATA[114];
                int distanceunit10 = DataCanbus.DATA[115];
                int timeformat9 = DataCanbus.DATA[116];
                int language8 = DataCanbus.DATA[117];
                int d2_b78 = DataCanbus.DATA[140];
                int d2_b68 = DataCanbus.DATA[141];
                int d2_b58 = DataCanbus.DATA[142];
                int timeformat10 = timeformat9 + 1;
                if (timeformat10 > 1) {
                    timeformat10 = 0;
                }
                int value9 = ((fuelunit10 << 6) & 192) | ((tempunit10 << 5) & 32) | ((distanceunit10 << 4) & 16) | ((timeformat10 << 3) & 8) | (language8 & 7);
                int value28 = ((d2_b78 << 7) & 128) | ((d2_b68 << 6) & 64) | ((d2_b58 << 5) & 32);
                setCarInfo(17, value9, value28);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int fuelunit11 = DataCanbus.DATA[113];
                int tempunit11 = DataCanbus.DATA[114];
                int distanceunit11 = DataCanbus.DATA[115];
                int timeformat11 = DataCanbus.DATA[116];
                int language9 = DataCanbus.DATA[117];
                int d2_b79 = DataCanbus.DATA[140];
                int d2_b69 = DataCanbus.DATA[141];
                int d2_b59 = DataCanbus.DATA[142] - 1;
                if (d2_b59 < 0) {
                    d2_b59 = 1;
                }
                int value10 = ((fuelunit11 << 6) & 192) | ((tempunit11 << 5) & 32) | ((distanceunit11 << 4) & 16) | ((timeformat11 << 3) & 8) | (language9 & 7);
                int value29 = ((d2_b79 << 7) & 128) | ((d2_b69 << 6) & 64) | ((d2_b59 << 5) & 32);
                setCarInfo(17, value10, value29);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int fuelunit12 = DataCanbus.DATA[113];
                int tempunit12 = DataCanbus.DATA[114];
                int distanceunit12 = DataCanbus.DATA[115];
                int timeformat12 = DataCanbus.DATA[116];
                int language10 = DataCanbus.DATA[117];
                int d2_b710 = DataCanbus.DATA[140];
                int d2_b610 = DataCanbus.DATA[141];
                int d2_b510 = DataCanbus.DATA[142] + 1;
                if (d2_b510 > 1) {
                    d2_b510 = 0;
                }
                int value11 = ((fuelunit12 << 6) & 192) | ((tempunit12 << 5) & 32) | ((distanceunit12 << 4) & 16) | ((timeformat12 << 3) & 8) | (language10 & 7);
                int value210 = ((d2_b710 << 7) & 128) | ((d2_b610 << 6) & 64) | ((d2_b510 << 5) & 32);
                setCarInfo(17, value11, value210);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int onoff = DataCanbus.DATA[143];
                int d1_d2 = DataCanbus.DATA[144];
                if (d1_d2 > 6) {
                    d1_d2 -= 5;
                }
                if (d1_d2 < 6) {
                    d1_d2 = 6;
                }
                int value12 = ((onoff << 7) & 128) | ((d1_d2 >> 8) & 15);
                int value211 = d1_d2 & 255;
                setCarInfo(18, value12, value211);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int onoff2 = DataCanbus.DATA[143];
                int d1_d22 = DataCanbus.DATA[144];
                if (d1_d22 < 299) {
                    d1_d22 += 5;
                }
                if (d1_d22 > 299) {
                    d1_d22 = 299;
                }
                int value13 = ((onoff2 << 7) & 128) | ((d1_d22 >> 8) & 15);
                int value212 = d1_d22 & 255;
                setCarInfo(18, value13, value212);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int d1_d23 = DataCanbus.DATA[145];
                if (d1_d23 > 0) {
                    d1_d23 -= 10;
                }
                if (d1_d23 < 0) {
                    d1_d23 = 0;
                }
                int value14 = (d1_d23 >> 8) & 63;
                int value213 = d1_d23 & 255;
                setCarInfo(19, value14, value213);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int d1_d24 = DataCanbus.DATA[145];
                if (d1_d24 < 9999) {
                    d1_d24 += 10;
                }
                if (d1_d24 > 9999) {
                    d1_d24 = 9999;
                }
                int value15 = (d1_d24 >> 8) & 63;
                int value214 = d1_d24 & 255;
                setCarInfo(19, value15, value214);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int fuelunit13 = DataCanbus.DATA[113];
                int tempunit13 = DataCanbus.DATA[114];
                int distanceunit13 = DataCanbus.DATA[115];
                int timeformat13 = DataCanbus.DATA[116];
                int language11 = DataCanbus.DATA[117];
                int d2_b711 = DataCanbus.DATA[140];
                int d2_b611 = DataCanbus.DATA[141];
                int d2_b511 = DataCanbus.DATA[142];
                if (d2_b711 == 0) {
                    d2_b711 = 1;
                } else if (d2_b711 == 1) {
                    d2_b711 = 0;
                }
                int value16 = ((fuelunit13 << 6) & 192) | ((tempunit13 << 5) & 32) | ((distanceunit13 << 4) & 16) | ((timeformat13 << 3) & 8) | (language11 & 7);
                int value215 = ((d2_b711 << 7) & 128) | ((d2_b611 << 6) & 64) | ((d2_b511 << 5) & 32);
                setCarInfo(17, value16, value215);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int fuelunit14 = DataCanbus.DATA[113];
                int tempunit14 = DataCanbus.DATA[114];
                int distanceunit14 = DataCanbus.DATA[115];
                int timeformat14 = DataCanbus.DATA[116];
                int language12 = DataCanbus.DATA[117];
                int d2_b712 = DataCanbus.DATA[140];
                int d2_b612 = DataCanbus.DATA[141];
                int d2_b512 = DataCanbus.DATA[142];
                if (d2_b612 == 0) {
                    d2_b612 = 1;
                } else if (d2_b612 == 1) {
                    d2_b612 = 0;
                }
                int value17 = ((fuelunit14 << 6) & 192) | ((tempunit14 << 5) & 32) | ((distanceunit14 << 4) & 16) | ((timeformat14 << 3) & 8) | (language12 & 7);
                int value216 = ((d2_b712 << 7) & 128) | ((d2_b612 << 6) & 64) | ((d2_b512 << 5) & 32);
                setCarInfo(17, value17, value216);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int onoff3 = DataCanbus.DATA[143];
                int d1_d25 = DataCanbus.DATA[144];
                if (onoff3 == 0) {
                    onoff3 = 1;
                } else if (onoff3 == 1) {
                    onoff3 = 0;
                }
                int value18 = ((onoff3 << 7) & 128) | ((d1_d25 >> 8) & 15);
                int value217 = d1_d25 & 255;
                setCarInfo(18, value18, value217);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2, value3}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }
}
