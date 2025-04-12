package com.syu.carinfo.lz.jaguar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class TDLandRoverCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int mileunit = 0;
    int oilunit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text1) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text1)).setText(value + " km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text1)).setText(value + " miles");
                                break;
                        }
                    }
                    break;
                case 134:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text2) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(value + " km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(value + " miles");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text3) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " l/100km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " mpg");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " km/l");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text4) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10) + " l/100km");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10) + " mpg");
                                break;
                            case 2:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10) + " km/l");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text5) != null) {
                        switch (TDLandRoverCarSet.this.mileunit) {
                            case 0:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text5)).setText(value + " km/h");
                                break;
                            case 1:
                                ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text5)).setText(value + " MPH");
                                break;
                        }
                    }
                    break;
                case 138:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text11) != null) {
                        if (TDLandRoverCarSet.this.mileunit == 1) {
                            ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)).setText(value + CamryData.SPEED_UNIT_MILE);
                            break;
                        } else {
                            ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text11)).setText(value + "km/h");
                            break;
                        }
                    }
                    break;
                case 139:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 140:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text6) != null) {
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
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text7) != null) {
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
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text8) != null) {
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
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 146:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 147:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 148:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 149:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 150:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 151:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 152:
                    TDLandRoverCarSet.this.updateLauguageSet();
                    break;
                case 160:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text9) != null) {
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
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text10) != null) {
                        ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value));
                        break;
                    }
                case 165:
                    TDLandRoverCarSet.this.setCheck(TDLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 166:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text12) != null) {
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
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text14) != null) {
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
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text15) != null) {
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
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text16) != null) {
                        ((TextView) TDLandRoverCarSet.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value));
                        break;
                    }
                case 311:
                    if (TDLandRoverCarSet.this.findViewById(R.id.tv_text17) != null) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_settings);
        init();
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter(new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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
            if (findViewById(R.id.lauguage_set_curr) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override
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
        setSelfClick(findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_minus8), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
        setSelfClick(findViewById(R.id.btn_minus9), this);
        setSelfClick(findViewById(R.id.btn_plus9), this);
        setSelfClick(findViewById(R.id.btn_minus10), this);
        setSelfClick(findViewById(R.id.btn_plus10), this);
        setSelfClick(findViewById(R.id.btn_minus11), this);
        setSelfClick(findViewById(R.id.btn_plus11), this);
        setSelfClick(findViewById(R.id.btn_minus12), this);
        setSelfClick(findViewById(R.id.btn_plus13), this);
    }

    protected void dialog(String stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + stringId + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{13, i}, null, null);
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

    protected void dialog2(final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm) + " " + getResources().getString(R.string.str_cartime_sync) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{i, 1}, null, null);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[140];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[140];
                int value4 = value3 + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[141];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[141];
                int value8 = value7 + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value9 = DataCanbus.DATA[142];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(254, value10);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value11 = DataCanbus.DATA[142];
                int value12 = value11 + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(254, value12);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value13 = DataCanbus.DATA[160];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(14, value13);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value14 = DataCanbus.DATA[160];
                if (value14 < 4) {
                    value14++;
                }
                setCarInfo(14, value14);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value15 = DataCanbus.DATA[161];
                int value16 = value15 - 1;
                if (value16 < 0) {
                    value16 = 10;
                }
                setCarInfo(15, value16);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value17 = DataCanbus.DATA[161];
                int value18 = value17 + 1;
                if (value18 > 10) {
                    value18 = 0;
                }
                setCarInfo(15, value18);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
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
            case R.id.btn_plus6 /* 2131427472 */:
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
            case R.id.btn_minus7 /* 2131427473 */:
                int value21 = DataCanbus.DATA[166];
                int value22 = value21 - 1;
                if (value22 < 0) {
                    value22 = 1;
                }
                setCarInfo(16, value22);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value23 = DataCanbus.DATA[166];
                int value24 = value23 + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(16, value24);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value25 = DataCanbus.DATA[308];
                int value26 = value25 - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                setCarInfo2(0, value26, 0, 0, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value27 = DataCanbus.DATA[308];
                int value28 = value27 + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo2(0, value28, 0, 0, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value29 = DataCanbus.DATA[309];
                int value30 = value29 - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo2(2, value30, 0, 0, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value31 = DataCanbus.DATA[309];
                int value32 = value31 + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarInfo2(2, value32, 0, 0, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int b74 = DataCanbus.DATA[310];
                int b30 = DataCanbus.DATA[311];
                if (b74 > 0) {
                    b74--;
                }
                int value33 = ((b74 << 4) & 240) | (b30 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value33}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int b742 = DataCanbus.DATA[310];
                int b302 = DataCanbus.DATA[311];
                if (b742 < 10) {
                    b742++;
                }
                int value34 = ((b742 << 4) & 240) | (b302 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value34}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int b743 = DataCanbus.DATA[310];
                int b303 = DataCanbus.DATA[311] - 1;
                if (b303 < 0) {
                    b303 = 3;
                }
                int value35 = ((b743 << 4) & 240) | (b303 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value35}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int b744 = DataCanbus.DATA[310];
                int b304 = DataCanbus.DATA[311] + 1;
                if (b304 > 3) {
                    b304 = 0;
                }
                int value36 = ((b744 << 4) & 240) | (b304 & 15);
                DataCanbus.PROXY.cmd(9, new int[]{value36}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog("fuel Consumption1", 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog("fuel Consumption2", 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                dialog("average speed", 2);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
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
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int bit72 = DataCanbus.DATA[145];
                int bit62 = DataCanbus.DATA[146];
                int bit52 = DataCanbus.DATA[147];
                int bit42 = DataCanbus.DATA[148];
                int bit32 = DataCanbus.DATA[149];
                int bit22 = DataCanbus.DATA[150];
                int bit12 = DataCanbus.DATA[151];
                if (bit62 == 0) {
                    bit62 = 1;
                } else if (bit62 == 1) {
                    bit62 = 0;
                }
                setCarInfo(10, ((bit72 << 7) & 128) | ((bit62 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit32 << 3) & 8) | ((bit22 << 2) & 4) | ((bit12 << 1) & 2));
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int bit73 = DataCanbus.DATA[145];
                int bit63 = DataCanbus.DATA[146];
                int bit53 = DataCanbus.DATA[147];
                int bit43 = DataCanbus.DATA[148];
                int bit33 = DataCanbus.DATA[149];
                int bit23 = DataCanbus.DATA[150];
                int bit13 = DataCanbus.DATA[151];
                if (bit53 == 0) {
                    bit53 = 1;
                } else if (bit53 == 1) {
                    bit53 = 0;
                }
                setCarInfo(10, ((bit73 << 7) & 128) | ((bit63 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit33 << 3) & 8) | ((bit23 << 2) & 4) | ((bit13 << 1) & 2));
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int bit74 = DataCanbus.DATA[145];
                int bit64 = DataCanbus.DATA[146];
                int bit54 = DataCanbus.DATA[147];
                int bit44 = DataCanbus.DATA[148];
                int bit34 = DataCanbus.DATA[149];
                int bit24 = DataCanbus.DATA[150];
                int bit14 = DataCanbus.DATA[151];
                if (bit44 == 0) {
                    bit44 = 1;
                } else if (bit44 == 1) {
                    bit44 = 0;
                }
                setCarInfo(10, ((bit74 << 7) & 128) | ((bit64 << 6) & 64) | ((bit54 << 5) & 32) | ((bit44 << 4) & 16) | ((bit34 << 3) & 8) | ((bit24 << 2) & 4) | ((bit14 << 1) & 2));
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int bit75 = DataCanbus.DATA[145];
                int bit65 = DataCanbus.DATA[146];
                int bit55 = DataCanbus.DATA[147];
                int bit45 = DataCanbus.DATA[148];
                int bit35 = DataCanbus.DATA[149];
                int bit25 = DataCanbus.DATA[150];
                int bit15 = DataCanbus.DATA[151];
                if (bit35 == 0) {
                    bit35 = 1;
                } else if (bit35 == 1) {
                    bit35 = 0;
                }
                setCarInfo(10, ((bit75 << 7) & 128) | ((bit65 << 6) & 64) | ((bit55 << 5) & 32) | ((bit45 << 4) & 16) | ((bit35 << 3) & 8) | ((bit25 << 2) & 4) | ((bit15 << 1) & 2));
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int bit76 = DataCanbus.DATA[145];
                int bit66 = DataCanbus.DATA[146];
                int bit56 = DataCanbus.DATA[147];
                int bit46 = DataCanbus.DATA[148];
                int bit36 = DataCanbus.DATA[149];
                int bit26 = DataCanbus.DATA[150];
                int bit16 = DataCanbus.DATA[151];
                if (bit26 == 0) {
                    bit26 = 1;
                } else if (bit26 == 1) {
                    bit26 = 0;
                }
                setCarInfo(10, ((bit76 << 7) & 128) | ((bit66 << 6) & 64) | ((bit56 << 5) & 32) | ((bit46 << 4) & 16) | ((bit36 << 3) & 8) | ((bit26 << 2) & 4) | ((bit16 << 1) & 2));
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int bit77 = DataCanbus.DATA[145];
                int bit67 = DataCanbus.DATA[146];
                int bit57 = DataCanbus.DATA[147];
                int bit47 = DataCanbus.DATA[148];
                int bit37 = DataCanbus.DATA[149];
                int bit27 = DataCanbus.DATA[150];
                int bit17 = DataCanbus.DATA[151];
                if (bit17 == 0) {
                    bit17 = 1;
                } else if (bit17 == 1) {
                    bit17 = 0;
                }
                setCarInfo(10, ((bit77 << 7) & 128) | ((bit67 << 6) & 64) | ((bit57 << 5) & 32) | ((bit47 << 4) & 16) | ((bit37 << 3) & 8) | ((bit27 << 2) & 4) | ((bit17 << 1) & 2));
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value37 = DataCanbus.DATA[139];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(1, value37);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value38 = DataCanbus.DATA[165];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(17, value38);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{55}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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

    @Override
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
