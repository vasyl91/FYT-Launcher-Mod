package com.syu.carinfo.wc.benz;

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

public class WCBenzSprinterCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 111:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_4);
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_7);
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_6);
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 112:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 113:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_keen);
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 114:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 115:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("120km/h");
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("130km/h");
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("140km/h");
                                break;
                            case 4:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("150km/h");
                                break;
                            case 5:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("160km/h");
                                break;
                            case 6:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("170km/h");
                                break;
                            case 7:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("180km/h");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 116:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 117:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 118:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 119:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 120:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("45s");
                                break;
                            case 4:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 121:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 122:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 123:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)).setText("mi");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)).setText("km");
                                break;
                        }
                    }
                    break;
                case 124:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_wc_sprinter_settings);
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
                WCBenzSprinterCarSet.this.language_set = position;
                if (WCBenzSprinterCarSet.this.language_set >= 0 && WCBenzSprinterCarSet.this.language_set <= WCBenzSprinterCarSet.this.mLauStylelist.size() && WCBenzSprinterCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, WCBenzSprinterCarSet.this.send_lang[WCBenzSprinterCarSet.this.language_set]}, null, null);
                }
                WCBenzSprinterCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add("Romana");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15, 16, 17, 18, 20, 22, 23, 24, 25, 26, 27, 28, 31, 32, 34};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (WCBenzSprinterCarSet.this.mLauStyle == null) {
                    WCBenzSprinterCarSet.this.initLauStyle();
                }
                if (WCBenzSprinterCarSet.this.mLauStyle != null && WCBenzSprinterCarSet.this.mPopShowView != null) {
                    WCBenzSprinterCarSet.this.mLauStyle.showAtLocation(WCBenzSprinterCarSet.this.mPopShowView, 17, 0, 0);
                    WCBenzSprinterCarSet.this.updateLauguageSet();
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[111] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[113] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[113] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[115] - 1;
                if (value5 < 0) {
                    value5 = 7;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[115] + 1;
                if (value6 > 7) {
                    value6 = 0;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[120] - 1;
                if (value7 < 0) {
                    value7 = 4;
                }
                setCarInfo(34, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[120] + 1;
                if (value8 > 4) {
                    value8 = 0;
                }
                setCarInfo(34, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[123] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(50, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[123] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(50, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value11 = DataCanbus.DATA[110];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(1, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value12 = DataCanbus.DATA[112];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(3, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value13 = DataCanbus.DATA[114];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(5, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value14 = DataCanbus.DATA[116];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(18, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value15 = DataCanbus.DATA[117];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(19, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(20, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value17 = DataCanbus.DATA[119];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(33, value17);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value18 = DataCanbus.DATA[121];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(35, value18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value19 = DataCanbus.DATA[122];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(49, value19);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value20 = DataCanbus.DATA[124];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(52, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
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
    }
}
