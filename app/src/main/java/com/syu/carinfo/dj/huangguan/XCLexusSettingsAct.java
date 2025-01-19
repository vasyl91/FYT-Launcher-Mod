package com.syu.carinfo.dj.huangguan;

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

import java.util.ArrayList;

public class XCLexusSettingsAct extends BaseActivity implements View.OnClickListener {
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
                case 134:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 135:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text1) != null) {
                        ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value));
                        break;
                    }
                case 136:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text2) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text2)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text2)).setText("15s");
                                break;
                            case 3:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text3) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            case 3:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text3)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 138:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 139:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 140:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 141:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 142:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text5) != null) {
                        ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value + 1));
                        break;
                    }
                case 143:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 144:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 145:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 146:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 147:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 148:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text6) != null) {
                        ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value + 1));
                        break;
                    }
                case 149:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 150:
                    XCLexusSettingsAct.this.setCheck(XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 151:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text8) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.xp_loucs_model0_string);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.xp_loucs_model1_string);
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.xp_loucs_model2_string);
                                break;
                        }
                    }
                    break;
                case 152:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text7) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text7)).setText("60s");
                                break;
                            case 3:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text7)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 153:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text9) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_playstate11);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text9)).setText("少量");
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.wc_golf_normal);
                                break;
                        }
                    }
                    break;
                case 154:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text10) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_right_camera_open);
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text10)).setText("停车后启动");
                                break;
                        }
                    }
                    break;
                case 155:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text4) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 3:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 156:
                    XCLexusSettingsAct.this.updateLauguageSet();
                    break;
                case 157:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text11) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 158:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text12) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text12)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text12)).setText("KM/L");
                                break;
                        }
                    }
                    break;
                case 159:
                    if (XCLexusSettingsAct.this.findViewById(R.id.tv_text13) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.color_navyblue_str);
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.color_blue_green_str);
                                break;
                            case 2:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.str_403_ambient_1);
                                break;
                            case 3:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.str_bright_orange);
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
        //setContentView(R.layout.layout_0429_xc_lexus_settings);
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
                XCLexusSettingsAct.this.language_set = position;
                if (XCLexusSettingsAct.this.language_set >= 0 && XCLexusSettingsAct.this.language_set <= XCLexusSettingsAct.this.mLauStylelist.size() && XCLexusSettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(107, new int[]{0, XCLexusSettingsAct.this.send_lang[XCLexusSettingsAct.this.language_set]}, null, null);
                }
                XCLexusSettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[156];
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
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick(findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (XCLexusSettingsAct.this.mLauStyle == null) {
                    XCLexusSettingsAct.this.initLauStyle();
                }
                if (XCLexusSettingsAct.this.mLauStyle != null && XCLexusSettingsAct.this.mPopShowView != null) {
                    XCLexusSettingsAct.this.mLauStyle.showAtLocation(XCLexusSettingsAct.this.mPopShowView, 17, 0, 0);
                    XCLexusSettingsAct.this.updateLauguageSet();
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
        setSelfClick(findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext12), this);
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
        setSelfClick(findViewById(R.id.btn_plus12), this);
        setSelfClick(findViewById(R.id.btn_minus13), this);
        setSelfClick(findViewById(R.id.btn_plus13), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[135] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[135] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[136] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[136] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[137] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[137] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[155] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(12, value7 + 4);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[155] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(12, value8 + 4);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[142] - 1;
                if (value9 < 0) {
                    value9 = 6;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[142] + 1;
                if (value10 > 6) {
                    value10 = 0;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[148] - 1;
                if (value11 < 0) {
                    value11 = 6;
                }
                setCarInfo(35, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[148] + 1;
                if (value12 > 6) {
                    value12 = 0;
                }
                setCarInfo(35, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[152] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(20, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[152] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(20, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[151] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(34, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[151] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(34, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[153] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(24, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[153] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(24, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[154] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(37, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[154] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(37, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[157] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(23, value21 + 2);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[157] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(23, value22 + 2);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[158] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(36, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[158] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(36, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[159] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(64, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[159] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(64, value26);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value27 = DataCanbus.DATA[134];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(4, value27);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value28 = DataCanbus.DATA[138];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(0, value28);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value29 = DataCanbus.DATA[139];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(1, value29);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value30 = DataCanbus.DATA[140];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(2, value30);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value31 = DataCanbus.DATA[141];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(3, value31);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value32 = DataCanbus.DATA[143];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(13, value32);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value33 = DataCanbus.DATA[144];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(14, value33);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value34 = DataCanbus.DATA[145];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(15, value34);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value35 = DataCanbus.DATA[146];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(16, value35);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value36 = DataCanbus.DATA[147];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(17, value36);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value37 = DataCanbus.DATA[149];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(18, value37);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value38 = DataCanbus.DATA[150];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(19, value38);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
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
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
    }
}
