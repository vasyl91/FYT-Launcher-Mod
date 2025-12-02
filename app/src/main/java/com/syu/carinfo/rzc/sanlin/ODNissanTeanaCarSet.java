package com.syu.carinfo.rzc.sanlin;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class ODNissanTeanaCarSet extends BaseActivity implements View.OnClickListener {
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
                case 127:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 0) {
                            ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                        } else {
                            ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 129:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)).setText("波浪");
                                break;
                            case 2:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)).setText("猫步");
                                break;
                            case 3:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)).setText("敲击");
                                break;
                            case 4:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)).setText("舒腰");
                                break;
                            case 5:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text3)).setText("舒肩");
                                break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 0) {
                            ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                        } else {
                            ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 132:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)).setText("波浪");
                                break;
                            case 2:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)).setText("猫步");
                                break;
                            case 3:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)).setText("敲击");
                                break;
                            case 4:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)).setText("舒腰");
                                break;
                            case 5:
                                ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text6)).setText("舒肩");
                                break;
                        }
                    }
                    break;
                case 133:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 134:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 135:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 136:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 1) {
                            ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text7)).setText("灯光+喇叭");
                            break;
                        } else {
                            ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text7)).setText("仅灯光");
                            break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 138:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 139:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 140:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 141:
                    if (((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) ODNissanTeanaCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 142:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 143:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 144:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 145:
                    ODNissanTeanaCarSet.this.setCheck((CheckedTextView) ODNissanTeanaCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0080_od_nissan_teana_settings);
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
                ODNissanTeanaCarSet.this.language_set = position;
                if (ODNissanTeanaCarSet.this.language_set >= 0 && ODNissanTeanaCarSet.this.language_set <= ODNissanTeanaCarSet.this.mLauStylelist.size() && ODNissanTeanaCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{49, ODNissanTeanaCarSet.this.send_lang[ODNissanTeanaCarSet.this.language_set]}, null, null);
                }
                ODNissanTeanaCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_42));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.send_lang = new int[]{0, 1, 129, 130, 131, 132, 133, 134, 135, 137, 138, 141, 145, 147, 148, 149, 150, 151, 152, 153, 154, 155};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ODNissanTeanaCarSet.this.mLauStyle == null) {
                    ODNissanTeanaCarSet.this.initLauStyle();
                }
                if (ODNissanTeanaCarSet.this.mLauStyle != null && ODNissanTeanaCarSet.this.mPopShowView != null) {
                    ODNissanTeanaCarSet.this.mLauStyle.showAtLocation(ODNissanTeanaCarSet.this.mPopShowView, 17, 0, 0);
                    ODNissanTeanaCarSet.this.updateLauguageSet();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[127] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarAirInfo(176, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[127] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarAirInfo(176, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[128] - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                setCarAirInfo(177, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[128] + 1;
                if (value4 > 4) {
                    value4 = 1;
                }
                setCarAirInfo(177, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[129] - 1;
                if (value5 < 0) {
                    value5 = 5;
                }
                setCarAirInfo(178, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[129] + 1;
                if (value6 > 5) {
                    value6 = 0;
                }
                setCarAirInfo(178, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[130] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarAirInfo(179, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[130] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarAirInfo(179, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[131] - 1;
                if (value9 < 1) {
                    value9 = 4;
                }
                setCarAirInfo(180, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[131] + 1;
                if (value10 > 4) {
                    value10 = 1;
                }
                setCarAirInfo(180, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[132] - 1;
                if (value11 < 0) {
                    value11 = 5;
                }
                setCarAirInfo(181, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[132] + 1;
                if (value12 > 5) {
                    value12 = 0;
                }
                setCarAirInfo(181, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[136] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(3, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[136] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(3, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[137] - 1;
                if (value15 < 0) {
                    value15 = 100;
                }
                setCarInfo(4, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[137] + 1;
                if (value16 > 100) {
                    value16 = 0;
                }
                setCarInfo(4, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[139] - 1;
                if (value17 < 0) {
                    value17 = 128;
                }
                setCarInfo(6, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[139] + 1;
                if (value18 > 128) {
                    value18 = 0;
                }
                setCarInfo(6, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[141] - 1;
                if (value19 < 0) {
                    value19 = 4;
                }
                setCarInfo(8, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[141] + 1;
                if (value20 > 4) {
                    value20 = 0;
                }
                setCarInfo(8, value20);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(0, DataCanbus.DATA[133] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(1, DataCanbus.DATA[134] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(2, DataCanbus.DATA[135] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(5, DataCanbus.DATA[138] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(7, DataCanbus.DATA[140] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(9, DataCanbus.DATA[142] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(10, DataCanbus.DATA[143] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(11, DataCanbus.DATA[144] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(12, DataCanbus.DATA[145] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    public void setCarAirInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(5, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }
}
