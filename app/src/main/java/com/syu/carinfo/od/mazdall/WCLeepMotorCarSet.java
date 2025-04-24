package com.syu.carinfo.od.mazdall;

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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCLeepMotorCarSet extends BaseActivity implements View.OnClickListener {
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
                case 121:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value));
                        break;
                    }
                case 122:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text3) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text3)).setText("15s");
                                break;
                            case 2:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 3:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            default:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 123:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text1) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_width_light);
                                break;
                            case 2:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_near_light);
                                break;
                            case 3:
                            default:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 4:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text1)).setText("AUTO");
                                break;
                        }
                    }
                    break;
                case 124:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 125:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 126:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text4) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_one_click_window_lowering);
                                break;
                            case 2:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_one_click_air_open);
                                break;
                            default:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_one_click_car_search);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text5) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value));
                                break;
                        }
                    }
                    break;
                case 128:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 129:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 130:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text6) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_standard);
                                break;
                            case 3:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_economics);
                                break;
                            default:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 131:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text7) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                                break;
                            case 2:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_standard);
                                break;
                            default:
                                ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 132:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 133:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 134:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 135:
                    if (WCLeepMotorCarSet.this.findViewById(R.id.tv_text8) != null) {
                        ((TextView) WCLeepMotorCarSet.this.findViewById(R.id.tv_text8)).setText(value + "%");
                        break;
                    }
                case 136:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 138:
                    WCLeepMotorCarSet.this.setCheck(WCLeepMotorCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_leepmotor_settings);
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
                WCLeepMotorCarSet.this.language_set = position;
                if (WCLeepMotorCarSet.this.language_set >= 0 && WCLeepMotorCarSet.this.language_set <= WCLeepMotorCarSet.this.mLauStylelist.size() && WCLeepMotorCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, WCLeepMotorCarSet.this.send_lang[WCLeepMotorCarSet.this.language_set]}, null, null);
                }
                WCLeepMotorCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add("Rome");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add("Slovakia");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
        this.mLauStylelist.add("Flemish");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_19));
        this.mLauStylelist.add("Persia");
        this.mLauStylelist.add("Latvia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_25));
        this.mLauStylelist.add("Slovenia");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 20, 22, 23, 24, 25, 26, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick(findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (WCLeepMotorCarSet.this.mLauStyle == null) {
                    WCLeepMotorCarSet.this.initLauStyle();
                }
                if (WCLeepMotorCarSet.this.mLauStyle != null && WCLeepMotorCarSet.this.mPopShowView != null) {
                    WCLeepMotorCarSet.this.mLauStyle.showAtLocation(WCLeepMotorCarSet.this.mPopShowView, 17, 0, 0);
                    WCLeepMotorCarSet.this.updateLauguageSet();
                }
            }
        });
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[123] - 1;
                if (value < 0) {
                    value = 4;
                } else if (value == 3) {
                    value = 2;
                }
                setCarInfo(1, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[123] + 1;
                if (value2 > 4) {
                    value2 = 0;
                } else if (value2 == 3) {
                    value2 = 3;
                }
                setCarInfo(1, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[121] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(3, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[121] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(3, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[122] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(4, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[122] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(4, value6, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[126] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(17, value7, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[126] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(17, value8, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[127];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(33, value9, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[127];
                if (value10 < 10) {
                    value10++;
                }
                setCarInfo(33, value10, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[130];
                if (value11 == 0) {
                    value11 = 3;
                } else if (value11 == 2) {
                    value11 = 0;
                } else if (value11 == 3) {
                    value11 = 2;
                }
                setCarInfo(49, value11, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[130];
                if (value12 == 0) {
                    value12 = 2;
                } else if (value12 == 2) {
                    value12 = 3;
                } else if (value12 == 3) {
                    value12 = 0;
                }
                setCarInfo(49, value12, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[131] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(50, value13, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[131] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(50, value14, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[131];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(65, value15, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[131];
                if (value16 < 100) {
                    value16++;
                }
                setCarInfo(65, value16, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[124];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(2, value17, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[125];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(5, value18, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[128];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(34, value19, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value20 = DataCanbus.DATA[129];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(35, value20, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value21 = DataCanbus.DATA[132];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(51, value21, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value22 = DataCanbus.DATA[133];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(52, value22, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value23 = DataCanbus.DATA[134];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(53, value23, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value24 = DataCanbus.DATA[136];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(66, value24, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                dialog(R.string.str_restart_the_vehicle, 81);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value25 = DataCanbus.DATA[138];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(84, value25, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm) + "     " + getResources().getString(stringId) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        WCLeepMotorCarSet.this.setCarInfo(i, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        WCLeepMotorCarSet.this.setCarInfo(i, 0, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
