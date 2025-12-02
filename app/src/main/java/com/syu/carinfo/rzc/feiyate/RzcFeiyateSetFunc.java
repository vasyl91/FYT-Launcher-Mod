package com.syu.carinfo.rzc.feiyate;

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
public class RzcFeiyateSetFunc extends BaseActivity implements View.OnClickListener {
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
                case 99:
                    RzcFeiyateSetFunc.this.updateText1(val);
                    break;
                case 100:
                    RzcFeiyateSetFunc.this.updateText2(val);
                    break;
                case 101:
                    RzcFeiyateSetFunc.this.updateText3(val);
                    break;
                case 102:
                    RzcFeiyateSetFunc.this.updateText4(val);
                    break;
                case 103:
                    RzcFeiyateSetFunc.this.updateText5(val);
                    break;
                case 104:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 105:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 106:
                    RzcFeiyateSetFunc.this.updateText9(val);
                    break;
                case 107:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 108:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 109:
                    RzcFeiyateSetFunc.this.updateText6(val);
                    break;
                case 110:
                    RzcFeiyateSetFunc.this.updateText7(val);
                    break;
                case 111:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 112:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 113:
                    RzcFeiyateSetFunc.this.updateText8(val);
                    break;
                case 126:
                    RzcFeiyateSetFunc.this.updateText10(val);
                    break;
                case 127:
                    RzcFeiyateSetFunc.this.updateText11(val);
                    break;
                case 128:
                    RzcFeiyateSetFunc.this.updateText12(val);
                    break;
                case 129:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 130:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 131:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 132:
                    if (((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("0s");
                                break;
                            case 1:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("60s");
                                break;
                            case 3:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text14)).setText("Driver door");
                                break;
                            case 1:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text14)).setText("All doors");
                                break;
                        }
                    }
                    break;
                case 134:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 135:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 136:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 137:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 138:
                    if (((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text15)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text15)).setText("1");
                                break;
                            case 1:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text15)).setText("2");
                                break;
                            case 2:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text15)).setText("3");
                                break;
                            case 3:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text15)).setText("4");
                                break;
                        }
                    }
                    break;
                case 139:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 140:
                    if (((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text16)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text16)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text16)).setText("Lights");
                                break;
                            case 2:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text16)).setText("Lights + Chime");
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
        //setContentView(R.layout.layout_rzc_feiyate_setfunc);
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
                RzcFeiyateSetFunc.this.language_set = position;
                if (RzcFeiyateSetFunc.this.language_set >= 0 && RzcFeiyateSetFunc.this.language_set <= RzcFeiyateSetFunc.this.mLauStylelist.size() && RzcFeiyateSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{0, RzcFeiyateSetFunc.this.send_lang[RzcFeiyateSetFunc.this.language_set]}, null, null);
                }
                RzcFeiyateSetFunc.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RzcFeiyateSetFunc.this.mLauStyle == null) {
                    RzcFeiyateSetFunc.this.initLauStyle();
                }
                if (RzcFeiyateSetFunc.this.mLauStyle != null && RzcFeiyateSetFunc.this.mPopShowView != null) {
                    RzcFeiyateSetFunc.this.mLauStyle.showAtLocation(RzcFeiyateSetFunc.this.mPopShowView, 17, 0, 0);
                    RzcFeiyateSetFunc.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                if (DataCanbus.DATA[101] == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (DataCanbus.DATA[101] == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[102] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[102] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[103] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[103] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[109] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(48, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[109] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(48, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[110] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(49, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[110] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(49, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[113] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(244, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[113] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(244, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[106];
                if (DataCanbus.DATA[1000] == 393255) {
                    if (value17 == 2) {
                        value2 = 0;
                    } else {
                        value2 = value17 - 1;
                        if (value2 < 0) {
                            value2 = 4;
                        }
                    }
                } else {
                    value2 = value17 - 1;
                    if (value2 < 0) {
                        value2 = 1;
                    }
                }
                setCarInfo(18, value2);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[106];
                if (DataCanbus.DATA[1000] == 393255) {
                    if (value18 == 0) {
                        value = 2;
                    } else {
                        value = value18 + 1;
                        if (value > 4) {
                            value = 0;
                        }
                    }
                } else {
                    value = value18 + 1;
                    if (value > 1) {
                        value = 0;
                    }
                }
                setCarInfo(18, value);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[126] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(20, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[126] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(20, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[127] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(50, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[127] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(50, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[128] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(51, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[128] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(51, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[132] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(21, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[132] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(21, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[133] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(33, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[133] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(33, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[138] - 1;
                if (value29 < 0) {
                    value29 = 3;
                }
                setCarInfo(57, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[138] + 1;
                if (value30 > 3) {
                    value30 = 0;
                }
                setCarInfo(57, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[140] - 1;
                if (value31 < 0) {
                    value31 = 2;
                }
                setCarInfo(59, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[140] + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarInfo(59, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[104];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(16, value33);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[105];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(17, value34);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value35 = DataCanbus.DATA[107];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(19, value35);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value36 = DataCanbus.DATA[108];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(32, value36);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value37 = DataCanbus.DATA[111];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(240, value37);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value38 = DataCanbus.DATA[112];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(243, value38);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value39 = DataCanbus.DATA[129];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(52, value39);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value40 = DataCanbus.DATA[130];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(53, value40);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value41 = DataCanbus.DATA[131];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(54, value41);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value42 = DataCanbus.DATA[134];
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(55, value42);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value43 = DataCanbus.DATA[135];
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(56, value43);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value44 = DataCanbus.DATA[136];
                if (value44 == 0) {
                    value44 = 1;
                } else if (value44 == 1) {
                    value44 = 0;
                }
                setCarInfo(34, value44);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value45 = DataCanbus.DATA[137];
                if (value45 == 0) {
                    value45 = 1;
                } else if (value45 == 1) {
                    value45 = 0;
                }
                setCarInfo(35, value45);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value46 = DataCanbus.DATA[139];
                if (value46 == 0) {
                    value46 = 1;
                } else if (value46 == 1) {
                    value46 = 0;
                }
                setCarInfo(58, value46);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64, 255}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Near");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Med");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Far");
                    break;
            }
        }
    }

    
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text11)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Only Act.Braking");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Warn+Act.Brk");
                    break;
            }
        }
    }

    
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText("1");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText("2");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText("3");
                    break;
            }
        }
    }

    
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText("On");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text9)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text9)).setText("90s");
                    break;
            }
        }
    }

    
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type1");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type2");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type3");
                    break;
            }
        }
    }

    
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Low");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Med");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText("High");
                    break;
            }
        }
    }

    
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Sound");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Sound Display");
                    break;
            }
        }
    }

    
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Imperial");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Custom");
                    break;
            }
        }
    }

    
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("℉");
                    break;
            }
        }
    }

    
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Mil");
                    break;
            }
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Km/L");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("L/100Km");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("MPG(UK)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("MPG(US)");
                    break;
            }
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_21);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_15);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_10);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_35);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_14);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_29);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_27);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_9);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_28);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_39);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_31);
                    break;
            }
        }
    }
}
