package com.syu.carinfo.camry2012.xp;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class CamrySettingsAct_XP extends BaseActivity implements View.OnClickListener {
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
                case 116:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 117:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 118:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text9)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text9)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text9)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text10)).setText("30s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text10)).setText("60s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text10)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 120:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 121:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 122:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 123:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 124:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 125:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 126:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 127:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                        }
                    }
                    break;
                case 128:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 129:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 130:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 131:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 132:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 133:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text13)).setText(R.string.xp_loucs_model0_string);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text13)).setText(R.string.xp_loucs_model1_string);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text13)).setText(R.string.xp_loucs_model2_string);
                                break;
                        }
                    }
                    break;
                case 191:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 192:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text15)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text15)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 194:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 195:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 198:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text11)).setText("Km/L");
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text11)).setText("L/100Km");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text11)).setText("MPG US");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text11)).setText("MPG UK");
                                break;
                        }
                    }
                    break;
                case 199:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text12)).setText("Clear blue");
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text12)).setText("Clear turquoise");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text12)).setText("Deep orange");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text12)).setText("Radiant orange");
                                break;
                        }
                    }
                    break;
                case 200:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text4)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 201:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text5)).setText("ON while stopped");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text5)).setText("On");
                                break;
                        }
                    }
                    break;
                case 202:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 203:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text6)).setText("By Driver Door");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text6)).setText("By Shift to P");
                                break;
                        }
                    }
                    break;
                case 204:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text7)).setText("By Shift from P");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text7)).setText("By Speed");
                                break;
                        }
                    }
                    break;
                case 205:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text14)).setText("Partial");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text14)).setText("Full");
                                break;
                        }
                    }
                    break;
                case 206:
                    CamrySettingsAct_XP.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_settings_xp);
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
                CamrySettingsAct_XP.this.language_set = position;
                if (CamrySettingsAct_XP.this.language_set >= 0 && CamrySettingsAct_XP.this.language_set <= CamrySettingsAct_XP.this.mLauStylelist.size() && CamrySettingsAct_XP.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(40, new int[]{36, CamrySettingsAct_XP.this.send_lang[CamrySettingsAct_XP.this.language_set]}, null, null);
                }
                CamrySettingsAct_XP.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[206];
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (CamrySettingsAct_XP.this.mLauStyle == null) {
                    CamrySettingsAct_XP.this.initLauStyle();
                }
                if (CamrySettingsAct_XP.this.mLauStyle != null && CamrySettingsAct_XP.this.mPopShowView != null) {
                    CamrySettingsAct_XP.this.mLauStyle.showAtLocation(CamrySettingsAct_XP.this.mPopShowView, 17, 0, 0);
                    CamrySettingsAct_XP.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[124] - 1;
                if (value < 0) {
                    value = 7;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[124] + 1;
                if (value2 > 7) {
                    value2 = 0;
                }
                setCarInfo(5, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[127] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(15, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[127] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(15, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[130] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(35, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[130] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(35, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[200] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(20, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[200] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(20, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[201] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(40, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[201] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(40, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[203] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(39, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[203] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(39, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[204] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(38, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[204] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(38, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[117] - 1;
                if (value15 < 0) {
                    value15 = 4;
                }
                setCarInfo(6, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[117] + 1;
                if (value16 > 4) {
                    value16 = 0;
                }
                setCarInfo(6, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[118] - 1;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(12, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[118] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(12, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[119] - 1;
                if (value19 < 0) {
                    value19 = 3;
                }
                setCarInfo(7, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[119] + 1;
                if (value20 > 3) {
                    value20 = 0;
                }
                setCarInfo(7, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[198] - 1;
                if (value21 < 0) {
                    value21 = 3;
                }
                setCarInfo(25, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[198] + 1;
                if (value22 > 3) {
                    value22 = 0;
                }
                setCarInfo(25, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[199] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(24, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[199] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCarInfo(24, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[133] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(34, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[133] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(34, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[205] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(43, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[205] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(43, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[192] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(23, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[192] + 1;
                if (value30 > 1) {
                    value30 = 0;
                }
                setCarInfo(23, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[195] - 1;
                if (value31 < 1) {
                    value31 = 5;
                }
                setCarInfo(21, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[195] + 1;
                if (value32 > 5) {
                    value32 = 1;
                }
                setCarInfo(21, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[202];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(37, value33);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[120];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(0, value34);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value35 = DataCanbus.DATA[121];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(1, value35);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value36 = DataCanbus.DATA[122];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(2, value36);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value37 = DataCanbus.DATA[123];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(3, value37);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value38 = DataCanbus.DATA[126];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(14, value38);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value39 = DataCanbus.DATA[128];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(16, value39);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value40 = DataCanbus.DATA[129];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(17, value40);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value41 = DataCanbus.DATA[116];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(4, value41);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value42 = DataCanbus.DATA[131];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(18, value42);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value43 = DataCanbus.DATA[132];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(19, value43);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value44 = DataCanbus.DATA[125];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(13, value44);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value45 = DataCanbus.DATA[191];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(22, value45);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value46 = DataCanbus.DATA[194];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(26, value46);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(40, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(43, new int[]{38}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
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
}
