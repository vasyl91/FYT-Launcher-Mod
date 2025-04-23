package com.syu.carinfo.xc.gm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class XC_GMandRongweiCarSet extends BaseActivity implements View.OnClickListener {
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
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_last_Set);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.rzc_c4l_open);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_last_Set);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 102:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 3:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text1)).setText("120S");
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 104:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 106:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 107:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 108:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 109:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 3:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                        }
                    }
                    break;
                case 111:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 112:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 113:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 114:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 115:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 116:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                        }
                    }
                    break;
                case 117:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 118:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 119:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 120:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 121:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 144:
                    if (((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_sb_saiou3_str3);
                                break;
                            case 2:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_sb_saiou3_str4);
                                break;
                            default:
                                ((TextView) XC_GMandRongweiCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 145:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 146:
                    XC_GMandRongweiCarSet.this.setCheck((CheckedTextView) XC_GMandRongweiCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_rongwei_gm_settings);
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
                XC_GMandRongweiCarSet.this.language_set = position;
                if (XC_GMandRongweiCarSet.this.language_set >= 0 && XC_GMandRongweiCarSet.this.language_set <= XC_GMandRongweiCarSet.this.mLauStylelist.size() && XC_GMandRongweiCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{32, XC_GMandRongweiCarSet.this.send_lang[XC_GMandRongweiCarSet.this.language_set]}, null, null);
                }
                XC_GMandRongweiCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16, 19, 23};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (XC_GMandRongweiCarSet.this.mLauStyle == null) {
                    XC_GMandRongweiCarSet.this.initLauStyle();
                }
                if (XC_GMandRongweiCarSet.this.mLauStyle != null && XC_GMandRongweiCarSet.this.mPopShowView != null) {
                    XC_GMandRongweiCarSet.this.mLauStyle.showAtLocation(XC_GMandRongweiCarSet.this.mPopShowView, 17, 0, 0);
                    XC_GMandRongweiCarSet.this.updateLauguageSet();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext11).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext12).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext13).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext14).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext15).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext16).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext17).setOnClickListener(this);
        findViewById(R.id.btn_minus1).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_minus2).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_minus3).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.btn_minus4).setOnClickListener(this);
        findViewById(R.id.btn_plus4).setOnClickListener(this);
        findViewById(R.id.btn_minus5).setOnClickListener(this);
        findViewById(R.id.btn_plus5).setOnClickListener(this);
        findViewById(R.id.btn_minus6).setOnClickListener(this);
        findViewById(R.id.btn_plus6).setOnClickListener(this);
        findViewById(R.id.btn_minus7).setOnClickListener(this);
        findViewById(R.id.btn_plus7).setOnClickListener(this);
        findViewById(R.id.btn_minus8).setOnClickListener(this);
        findViewById(R.id.btn_plus8).setOnClickListener(this);
        findViewById(R.id.btn_minus9).setOnClickListener(this);
        findViewById(R.id.btn_plus9).setOnClickListener(this);
        findViewById(R.id.btn_minus10).setOnClickListener(this);
        findViewById(R.id.btn_plus10).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                XC_GMandRongweiCarSet.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        XC_GMandRongweiCarSet.this.setCarInfo(128, 1);
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
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[103] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[103] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[106] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[106] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[109] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[109] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[110] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(8, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[110] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(8, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[116] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(14, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[116] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(14, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[98] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setAirInfo(0, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[98] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setAirInfo(0, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[99] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setAirInfo(1, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[99] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setAirInfo(1, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[100] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setAirInfo(2, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[100] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setAirInfo(2, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[101] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setAirInfo(3, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[101] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setAirInfo(3, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[144] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setAirInfo(4, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[144] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setAirInfo(4, value20);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value21 = DataCanbus.DATA[102];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(0, value21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value22 = DataCanbus.DATA[104];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(2, value22);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value23 = DataCanbus.DATA[105];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(3, value23);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value24 = DataCanbus.DATA[107];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(5, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value25 = DataCanbus.DATA[108];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(6, value25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value26 = DataCanbus.DATA[111];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(9, value26);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value27 = DataCanbus.DATA[112];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(10, value27);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value28 = DataCanbus.DATA[113];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(11, value28);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value29 = DataCanbus.DATA[114];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(12, value29);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value30 = DataCanbus.DATA[115];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(13, value30);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value31 = DataCanbus.DATA[117];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(15, value31);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value32 = DataCanbus.DATA[118];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(16, value32);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value33 = DataCanbus.DATA[119];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(17, value33);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value34 = DataCanbus.DATA[120];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(18, value34);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value35 = DataCanbus.DATA[145];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setAirInfo(5, value35);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value36 = DataCanbus.DATA[146];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setAirInfo(6, value36);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value37 = DataCanbus.DATA[121];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setRadarInfo(value37);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setAirInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    public void setRadarInfo(int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }
}
