package com.syu.carinfo.lz.jaguar;

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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TDLandRoverCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int mileunit = 0;
    int oilunit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km/h");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " MPH");
                                break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        if (TDLandRoverCarSet.this.mileunit == 1) {
                            ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + CamryData.SPEED_UNIT_MILE);
                        } else {
                            ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "km/h");
                        }
                    }
                    break;
                case 139:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 140:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text6)).setText("℃");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text6)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 141:
                    TDLandRoverCarSet.this.oilunit = value;
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text7)).setText("l/100km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text7)).setText("mpg");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text7)).setText("km/l");
                                break;
                        }
                    }
                    break;
                case 142:
                    TDLandRoverCarSet.this.mileunit = value;
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text8)).setText("km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text8)).setText("mile");
                                break;
                        }
                    }
                    break;
                case 145:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 146:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 147:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 148:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 149:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 150:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 151:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 152:
                    TDLandRoverCarSet.this.updateLauguageSet();
                    break;
                case 160:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text9)).setText("25%");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text9)).setText("50%");
                                break;
                            case 3:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text9)).setText("75%");
                                break;
                            case 4:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text9)).setText("100%");
                                break;
                        }
                    }
                    break;
                case 161:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 165:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 166:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text12)).setText("1");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text12)).setText("2");
                                break;
                        }
                    }
                    break;
                case 308:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                        }
                    }
                    break;
                case 309:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text15)).setText("DD.MM.YYYY");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text15)).setText("YYYY-MM-DD");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text15)).setText("MM-DD-YYYY");
                                break;
                        }
                    }
                    break;
                case 310:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text16)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 311:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.str_e000_ats_local_camera);
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.str_car360_type1);
                                break;
                            case 3:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.str_car_360device);
                                break;
                            default:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.str_e000_ats_car_camera);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                TDLandRoverCarSet.this.language_set = position;
                if (TDLandRoverCarSet.this.language_set >= 0 && TDLandRoverCarSet.this.language_set <= TDLandRoverCarSet.this.mLauStylelist.size() && TDLandRoverCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{12, TDLandRoverCarSet.this.send_lang[TDLandRoverCarSet.this.language_set]}, null, null);
                }
                TDLandRoverCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[152];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_25));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add("Cestina");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TDLandRoverCarSet.this.mLauStyle == null) {
                    TDLandRoverCarSet.this.initLauStyle();
                }
                if (TDLandRoverCarSet.this.mLauStyle != null && TDLandRoverCarSet.this.mPopShowView != null) {
                    TDLandRoverCarSet.this.mLauStyle.showAtLocation(TDLandRoverCarSet.this.mPopShowView, 17, 0, 0);
                    TDLandRoverCarSet.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_13_SCREEN /* 12124614 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_16_SCREEN /* 12190150 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_17_SCREEN /* 12255686 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_SCREEN /* 12321222 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_10_SCREEN /* 12386758 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_14_SCREEN /* 12452294 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_17_SCREEN /* 12517830 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_SCREEN /* 12583366 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_12_SCREEN /* 12648902 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_13_SCREEN /* 12714438 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_16_SCREEN /* 12779974 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_17_SCREEN /* 12845510 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_SCREEN /* 12911046 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Velar_SCREEN /* 12976582 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
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
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
    }

    protected void dialog(String stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + stringId + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{13, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    protected void dialog2(final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm)) + " " + getResources().getString(R.string.str_cartime_sync) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverCarSet.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[140];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[140];
                int value4 = value3 + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value5 = DataCanbus.DATA[141];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value7 = DataCanbus.DATA[141];
                int value8 = value7 + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value9 = DataCanbus.DATA[142];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(254, value10);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value11 = DataCanbus.DATA[142];
                int value12 = value11 + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(254, value12);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value13 = DataCanbus.DATA[160];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(14, value13);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value14 = DataCanbus.DATA[160];
                if (value14 < 4) {
                    value14++;
                }
                setCarInfo(14, value14);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value15 = DataCanbus.DATA[161];
                int value16 = value15 - 1;
                if (value16 < 0) {
                    value16 = 10;
                }
                setCarInfo(15, value16);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value17 = DataCanbus.DATA[161];
                int value18 = value17 + 1;
                if (value18 > 10) {
                    value18 = 0;
                }
                setCarInfo(15, value18);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value19 = DataCanbus.DATA[138];
                if (this.mileunit == 1) {
                    if (value19 > 10) {
                        value19--;
                    }
                } else if (value19 > 16) {
                    value19--;
                }
                setCarInfo(0, value19);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value20 = DataCanbus.DATA[138];
                if (this.mileunit == 1) {
                    if (value20 < 156) {
                        value20++;
                    }
                } else if (value20 < 259) {
                    value20++;
                }
                setCarInfo(0, value20);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value21 = DataCanbus.DATA[166];
                int value22 = value21 - 1;
                if (value22 < 0) {
                    value22 = 1;
                }
                setCarInfo(16, value22);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value23 = DataCanbus.DATA[166];
                int value24 = value23 + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(16, value24);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value25 = DataCanbus.DATA[308];
                int value26 = value25 - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                setCarInfo2(0, value26, 0, 0, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value27 = DataCanbus.DATA[308];
                int value28 = value27 + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo2(0, value28, 0, 0, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value29 = DataCanbus.DATA[309];
                int value30 = value29 - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo2(2, value30, 0, 0, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value31 = DataCanbus.DATA[309];
                int value32 = value31 + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarInfo2(2, value32, 0, 0, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int b74 = DataCanbus.DATA[310];
                int b30 = DataCanbus.DATA[311];
                if (b74 > 0) {
                    b74--;
                }
                int value33 = ((b74 << 4) & 240) | (b30 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value33, 0}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int b75 = DataCanbus.DATA[310];
                int b31 = DataCanbus.DATA[311];
                if (b75 < 10) {
                    b75++;
                }
                int value34 = ((b75 << 4) & 240) | (b31 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value34, 0}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int b76 = DataCanbus.DATA[310];
                int b32 = DataCanbus.DATA[311] - 1;
                if (b32 < 0) {
                    b32 = 3;
                }
                int value35 = ((b76 << 4) & 240) | (b32 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value35, 0}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int b77 = DataCanbus.DATA[310];
                int b33 = DataCanbus.DATA[311] + 1;
                if (b33 > 3) {
                    b33 = 0;
                }
                int value36 = ((b77 << 4) & 240) | (b33 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value36, 0}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog("fuel Consumption1", 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int bit7 = DataCanbus.DATA[145];
                int bit6 = DataCanbus.DATA[146];
                int bit5 = DataCanbus.DATA[147];
                int bit4 = DataCanbus.DATA[148];
                int bit3 = DataCanbus.DATA[149];
                int bit2 = DataCanbus.DATA[150];
                int bit1 = DataCanbus.DATA[151];
                if (bit7 == 0) {
                    bit7 = 1;
                } else if (bit7 == 1) {
                    bit7 = 0;
                }
                setCarInfo(10, ((bit7 << 7) & 128) | ((bit6 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 4) | ((bit1 << 1) & 2));
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int bit8 = DataCanbus.DATA[145];
                int bit9 = DataCanbus.DATA[146];
                int bit10 = DataCanbus.DATA[147];
                int bit11 = DataCanbus.DATA[148];
                int bit12 = DataCanbus.DATA[149];
                int bit13 = DataCanbus.DATA[150];
                int bit14 = DataCanbus.DATA[151];
                if (bit9 == 0) {
                    bit9 = 1;
                } else if (bit9 == 1) {
                    bit9 = 0;
                }
                setCarInfo(10, ((bit8 << 7) & 128) | ((bit9 << 6) & 64) | ((bit10 << 5) & 32) | ((bit11 << 4) & 16) | ((bit12 << 3) & 8) | ((bit13 << 2) & 4) | ((bit14 << 1) & 2));
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                dialog("fuel Consumption2", 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                dialog("average speed", 2);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int bit15 = DataCanbus.DATA[145];
                int bit16 = DataCanbus.DATA[146];
                int bit17 = DataCanbus.DATA[147];
                int bit18 = DataCanbus.DATA[148];
                int bit19 = DataCanbus.DATA[149];
                int bit20 = DataCanbus.DATA[150];
                int bit21 = DataCanbus.DATA[151];
                if (bit17 == 0) {
                    bit17 = 1;
                } else if (bit17 == 1) {
                    bit17 = 0;
                }
                setCarInfo(10, ((bit15 << 7) & 128) | ((bit16 << 6) & 64) | ((bit17 << 5) & 32) | ((bit18 << 4) & 16) | ((bit19 << 3) & 8) | ((bit20 << 2) & 4) | ((bit21 << 1) & 2));
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int bit22 = DataCanbus.DATA[145];
                int bit23 = DataCanbus.DATA[146];
                int bit24 = DataCanbus.DATA[147];
                int bit25 = DataCanbus.DATA[148];
                int bit26 = DataCanbus.DATA[149];
                int bit27 = DataCanbus.DATA[150];
                int bit28 = DataCanbus.DATA[151];
                if (bit25 == 0) {
                    bit25 = 1;
                } else if (bit25 == 1) {
                    bit25 = 0;
                }
                setCarInfo(10, ((bit22 << 7) & 128) | ((bit23 << 6) & 64) | ((bit24 << 5) & 32) | ((bit25 << 4) & 16) | ((bit26 << 3) & 8) | ((bit27 << 2) & 4) | ((bit28 << 1) & 2));
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int bit29 = DataCanbus.DATA[145];
                int bit30 = DataCanbus.DATA[146];
                int bit31 = DataCanbus.DATA[147];
                int bit32 = DataCanbus.DATA[148];
                int bit33 = DataCanbus.DATA[149];
                int bit34 = DataCanbus.DATA[150];
                int bit35 = DataCanbus.DATA[151];
                if (bit33 == 0) {
                    bit33 = 1;
                } else if (bit33 == 1) {
                    bit33 = 0;
                }
                setCarInfo(10, ((bit29 << 7) & 128) | ((bit30 << 6) & 64) | ((bit31 << 5) & 32) | ((bit32 << 4) & 16) | ((bit33 << 3) & 8) | ((bit34 << 2) & 4) | ((bit35 << 1) & 2));
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int bit36 = DataCanbus.DATA[145];
                int bit37 = DataCanbus.DATA[146];
                int bit38 = DataCanbus.DATA[147];
                int bit39 = DataCanbus.DATA[148];
                int bit40 = DataCanbus.DATA[149];
                int bit41 = DataCanbus.DATA[150];
                int bit42 = DataCanbus.DATA[151];
                if (bit41 == 0) {
                    bit41 = 1;
                } else if (bit41 == 1) {
                    bit41 = 0;
                }
                setCarInfo(10, ((bit36 << 7) & 128) | ((bit37 << 6) & 64) | ((bit38 << 5) & 32) | ((bit39 << 4) & 16) | ((bit40 << 3) & 8) | ((bit41 << 2) & 4) | ((bit42 << 1) & 2));
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int bit43 = DataCanbus.DATA[145];
                int bit44 = DataCanbus.DATA[146];
                int bit45 = DataCanbus.DATA[147];
                int bit46 = DataCanbus.DATA[148];
                int bit47 = DataCanbus.DATA[149];
                int bit48 = DataCanbus.DATA[150];
                int bit49 = DataCanbus.DATA[151];
                if (bit49 == 0) {
                    bit49 = 1;
                } else if (bit49 == 1) {
                    bit49 = 0;
                }
                setCarInfo(10, ((bit43 << 7) & 128) | ((bit44 << 6) & 64) | ((bit45 << 5) & 32) | ((bit46 << 4) & 16) | ((bit47 << 3) & 8) | ((bit48 << 2) & 4) | ((bit49 << 1) & 2));
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value37 = DataCanbus.DATA[139];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(1, value37);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value38 = DataCanbus.DATA[165];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(17, value38);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                dialog2(255);
                break;
        }
    }

    public void setCarInfo2(int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{55}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[309].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[310].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[311].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[309].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[310].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[311].removeNotify(this.mNotifyCanbus);
    }
}
