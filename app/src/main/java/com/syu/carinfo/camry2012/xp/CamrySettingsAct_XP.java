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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CamrySettingsAct_XP extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct_XP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 105:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 106:
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
                case 107:
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
                case 108:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 109:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 110:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 111:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 112:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 113:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 114:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 115:
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
                case 116:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 117:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 118:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 120:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 121:
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
                case 179:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 180:
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
                case 182:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 183:
                    if (((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) CamrySettingsAct_XP.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 186:
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
                case 187:
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
                case 188:
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
                case 189:
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
                case 190:
                    CamrySettingsAct_XP.this.setCheck((CheckedTextView) CamrySettingsAct_XP.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 191:
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
                case 192:
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
                case 193:
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
                case 194:
                    CamrySettingsAct_XP.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_settings_xp);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct_XP.2
            @Override // android.widget.AdapterView.OnItemClickListener
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
        int value = DataCanbus.DATA[194];
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct_XP.3
            @Override // android.view.View.OnClickListener
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(34, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[121] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(34, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[193] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(43, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[193] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(43, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[180] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(23, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[180] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(23, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[190];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(37, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[112] - 1;
                if (value8 < 0) {
                    value8 = 7;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[112] + 1;
                if (value9 > 7) {
                    value9 = 0;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[115] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[115] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(15, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[118] - 1;
                if (value12 < 0) {
                    value12 = 4;
                }
                setCarInfo(35, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[118] + 1;
                if (value13 > 4) {
                    value13 = 0;
                }
                setCarInfo(35, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[188] - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarInfo(20, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[188] + 1;
                if (value15 > 3) {
                    value15 = 0;
                }
                setCarInfo(20, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[189] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(40, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[189] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(40, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[191] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(39, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[191] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(39, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[192] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                setCarInfo(38, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[192] + 1;
                if (value21 > 2) {
                    value21 = 0;
                }
                setCarInfo(38, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[105] - 1;
                if (value22 < 0) {
                    value22 = 4;
                }
                setCarInfo(6, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[105] + 1;
                if (value23 > 4) {
                    value23 = 0;
                }
                setCarInfo(6, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[106] - 1;
                if (value24 < 0) {
                    value24 = 3;
                }
                setCarInfo(12, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[106] + 1;
                if (value25 > 3) {
                    value25 = 0;
                }
                setCarInfo(12, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[107] - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                setCarInfo(7, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[107] + 1;
                if (value27 > 3) {
                    value27 = 0;
                }
                setCarInfo(7, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[186] - 1;
                if (value28 < 0) {
                    value28 = 3;
                }
                setCarInfo(25, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[186] + 1;
                if (value29 > 3) {
                    value29 = 0;
                }
                setCarInfo(25, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[187] - 1;
                if (value30 < 0) {
                    value30 = 3;
                }
                setCarInfo(24, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[187] + 1;
                if (value31 > 3) {
                    value31 = 0;
                }
                setCarInfo(24, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[108];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(0, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[109];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(1, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[110];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(2, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[111];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(3, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[114];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(14, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[116];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(16, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[117];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(17, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[104];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(4, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[119];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(18, value40);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[120];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(19, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[113];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(13, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[179];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(22, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[182];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(26, value44);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value45 = DataCanbus.DATA[183] - 1;
                if (value45 < 1) {
                    value45 = 5;
                }
                setCarInfo(21, value45);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value46 = DataCanbus.DATA[183] + 1;
                if (value46 > 5) {
                    value46 = 1;
                }
                setCarInfo(21, value46);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(40, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(43, new int[]{38}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct_XP.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct_XP.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamrySettingsAct_XP.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
