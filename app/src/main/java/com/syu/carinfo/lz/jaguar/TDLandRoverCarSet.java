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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 121:
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
                case 122:
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
                case 123:
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
                case 124:
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
                case 125:
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
                case 126:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        if (TDLandRoverCarSet.this.mileunit == 1) {
                            ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "MPH");
                            break;
                        } else {
                            ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "km/h");
                            break;
                        }
                    }
                    break;
                case 127:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 128:
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
                case 129:
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
                case 130:
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
                case 133:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 134:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 135:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 136:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 137:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 138:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 139:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 140:
                    TDLandRoverCarSet.this.updateLauguageSet();
                    break;
                case 148:
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
                case 149:
                    if (((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 153:
                    TDLandRoverCarSet.this.setCheck((CheckedTextView) TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 154:
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
                case 296:
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
                case 297:
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
        int value = DataCanbus.DATA[140];
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                dialog("fuel Consumption1", 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[128] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[128] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[129] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[129] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[130] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(254, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[130] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(254, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[148];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[148];
                if (value8 < 4) {
                    value8++;
                }
                setCarInfo(14, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = DataCanbus.DATA[149] - 1;
                if (value9 < 0) {
                    value9 = 10;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = DataCanbus.DATA[149] + 1;
                if (value10 > 10) {
                    value10 = 0;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value11 = DataCanbus.DATA[126];
                if (this.mileunit == 1) {
                    if (value11 > 10) {
                        value11--;
                    }
                } else if (value11 > 16) {
                    value11--;
                }
                setCarInfo(0, value11);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value12 = DataCanbus.DATA[126];
                if (this.mileunit == 1) {
                    if (value12 < 156) {
                        value12++;
                    }
                } else if (value12 < 259) {
                    value12++;
                }
                setCarInfo(0, value12);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value13 = DataCanbus.DATA[154] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(16, value13);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value14 = DataCanbus.DATA[154] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(16, value14);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value15 = DataCanbus.DATA[296] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo2(0, value15, 0, 0, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value16 = DataCanbus.DATA[296] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo2(0, value16, 0, 0, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value17 = DataCanbus.DATA[297] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo2(2, value17, 0, 0, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value18 = DataCanbus.DATA[297] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo2(2, value18, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog("fuel Consumption2", 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                dialog("average speed", 2);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int bit7 = DataCanbus.DATA[133];
                int bit6 = DataCanbus.DATA[134];
                int bit5 = DataCanbus.DATA[135];
                int bit4 = DataCanbus.DATA[136];
                int bit3 = DataCanbus.DATA[137];
                int bit2 = DataCanbus.DATA[138];
                int bit1 = DataCanbus.DATA[139];
                if (bit7 == 0) {
                    bit7 = 1;
                } else if (bit7 == 1) {
                    bit7 = 0;
                }
                setCarInfo(10, ((bit7 << 7) & 128) | ((bit6 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 4) | ((bit1 << 1) & 2));
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int bit72 = DataCanbus.DATA[133];
                int bit62 = DataCanbus.DATA[134];
                int bit52 = DataCanbus.DATA[135];
                int bit42 = DataCanbus.DATA[136];
                int bit32 = DataCanbus.DATA[137];
                int bit22 = DataCanbus.DATA[138];
                int bit12 = DataCanbus.DATA[139];
                if (bit62 == 0) {
                    bit62 = 1;
                } else if (bit62 == 1) {
                    bit62 = 0;
                }
                setCarInfo(10, ((bit72 << 7) & 128) | ((bit62 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit32 << 3) & 8) | ((bit22 << 2) & 4) | ((bit12 << 1) & 2));
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int bit73 = DataCanbus.DATA[133];
                int bit63 = DataCanbus.DATA[134];
                int bit53 = DataCanbus.DATA[135];
                int bit43 = DataCanbus.DATA[136];
                int bit33 = DataCanbus.DATA[137];
                int bit23 = DataCanbus.DATA[138];
                int bit13 = DataCanbus.DATA[139];
                if (bit53 == 0) {
                    bit53 = 1;
                } else if (bit53 == 1) {
                    bit53 = 0;
                }
                setCarInfo(10, ((bit73 << 7) & 128) | ((bit63 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit33 << 3) & 8) | ((bit23 << 2) & 4) | ((bit13 << 1) & 2));
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int bit74 = DataCanbus.DATA[133];
                int bit64 = DataCanbus.DATA[134];
                int bit54 = DataCanbus.DATA[135];
                int bit44 = DataCanbus.DATA[136];
                int bit34 = DataCanbus.DATA[137];
                int bit24 = DataCanbus.DATA[138];
                int bit14 = DataCanbus.DATA[139];
                if (bit44 == 0) {
                    bit44 = 1;
                } else if (bit44 == 1) {
                    bit44 = 0;
                }
                setCarInfo(10, ((bit74 << 7) & 128) | ((bit64 << 6) & 64) | ((bit54 << 5) & 32) | ((bit44 << 4) & 16) | ((bit34 << 3) & 8) | ((bit24 << 2) & 4) | ((bit14 << 1) & 2));
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int bit75 = DataCanbus.DATA[133];
                int bit65 = DataCanbus.DATA[134];
                int bit55 = DataCanbus.DATA[135];
                int bit45 = DataCanbus.DATA[136];
                int bit35 = DataCanbus.DATA[137];
                int bit25 = DataCanbus.DATA[138];
                int bit15 = DataCanbus.DATA[139];
                if (bit35 == 0) {
                    bit35 = 1;
                } else if (bit35 == 1) {
                    bit35 = 0;
                }
                setCarInfo(10, ((bit75 << 7) & 128) | ((bit65 << 6) & 64) | ((bit55 << 5) & 32) | ((bit45 << 4) & 16) | ((bit35 << 3) & 8) | ((bit25 << 2) & 4) | ((bit15 << 1) & 2));
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int bit76 = DataCanbus.DATA[133];
                int bit66 = DataCanbus.DATA[134];
                int bit56 = DataCanbus.DATA[135];
                int bit46 = DataCanbus.DATA[136];
                int bit36 = DataCanbus.DATA[137];
                int bit26 = DataCanbus.DATA[138];
                int bit16 = DataCanbus.DATA[139];
                if (bit26 == 0) {
                    bit26 = 1;
                } else if (bit26 == 1) {
                    bit26 = 0;
                }
                setCarInfo(10, ((bit76 << 7) & 128) | ((bit66 << 6) & 64) | ((bit56 << 5) & 32) | ((bit46 << 4) & 16) | ((bit36 << 3) & 8) | ((bit26 << 2) & 4) | ((bit16 << 1) & 2));
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int bit77 = DataCanbus.DATA[133];
                int bit67 = DataCanbus.DATA[134];
                int bit57 = DataCanbus.DATA[135];
                int bit47 = DataCanbus.DATA[136];
                int bit37 = DataCanbus.DATA[137];
                int bit27 = DataCanbus.DATA[138];
                int bit17 = DataCanbus.DATA[139];
                if (bit17 == 0) {
                    bit17 = 1;
                } else if (bit17 == 1) {
                    bit17 = 0;
                }
                setCarInfo(10, ((bit77 << 7) & 128) | ((bit67 << 6) & 64) | ((bit57 << 5) & 32) | ((bit47 << 4) & 16) | ((bit37 << 3) & 8) | ((bit27 << 2) & 4) | ((bit17 << 1) & 2));
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value19 = DataCanbus.DATA[127];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(1, value19);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value20 = DataCanbus.DATA[153];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(17, value20);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
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
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
