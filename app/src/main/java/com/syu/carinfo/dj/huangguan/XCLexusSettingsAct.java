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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCLexusSettingsAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.XCLexusSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 93:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 94:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 95:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text2)) != null) {
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
                case 96:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text3)) != null) {
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
                case 97:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 98:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 99:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 100:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 101:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 102:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 103:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 104:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 105:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 106:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 107:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 108:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 109:
                    XCLexusSettingsAct.this.setCheck((CheckedTextView) XCLexusSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 110:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text8)) != null) {
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
                case 111:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text7)) != null) {
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
                case 112:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text9)) != null) {
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
                case 113:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text10)) != null) {
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
                case 114:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
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
                case 115:
                    XCLexusSettingsAct.this.updateLauguageSet();
                    break;
                case 116:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text11)) != null) {
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
                case 117:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text12)).setText("L/100km");
                                break;
                            case 1:
                                ((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text12)).setText("KM/L");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) XCLexusSettingsAct.this.findViewById(R.id.tv_text13)) != null) {
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0429_xc_lexus_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.dj.huangguan.XCLexusSettingsAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
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
        int value = DataCanbus.DATA[115];
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
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.XCLexusSettingsAct.3
            @Override // android.view.View.OnClickListener
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(64, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[118] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(64, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value3 = DataCanbus.DATA[93];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value4 = DataCanbus.DATA[94] - 1;
                if (value4 < 0) {
                    value4 = 4;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value5 = DataCanbus.DATA[94] + 1;
                if (value5 > 4) {
                    value5 = 0;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value6 = DataCanbus.DATA[95] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(12, value6);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value7 = DataCanbus.DATA[95] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(12, value7);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value8 = DataCanbus.DATA[96] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value9 = DataCanbus.DATA[96] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value10 = DataCanbus.DATA[114] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(12, value10 + 4);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value11 = DataCanbus.DATA[114] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(12, value11 + 4);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value12 = DataCanbus.DATA[101] - 1;
                if (value12 < 0) {
                    value12 = 6;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value13 = DataCanbus.DATA[101] + 1;
                if (value13 > 6) {
                    value13 = 0;
                }
                setCarInfo(5, value13);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value14 = DataCanbus.DATA[107] - 1;
                if (value14 < 0) {
                    value14 = 6;
                }
                setCarInfo(35, value14);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value15 = DataCanbus.DATA[107] + 1;
                if (value15 > 6) {
                    value15 = 0;
                }
                setCarInfo(35, value15);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value16 = DataCanbus.DATA[111] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(20, value16);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value17 = DataCanbus.DATA[111] + 1;
                if (value17 > 3) {
                    value17 = 0;
                }
                setCarInfo(20, value17);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value18 = DataCanbus.DATA[110] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(34, value18);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value19 = DataCanbus.DATA[110] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(34, value19);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value20 = DataCanbus.DATA[112] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                setCarInfo(24, value20);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value21 = DataCanbus.DATA[112] + 1;
                if (value21 > 2) {
                    value21 = 0;
                }
                setCarInfo(24, value21);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value22 = DataCanbus.DATA[113] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(37, value22);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value23 = DataCanbus.DATA[113] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(37, value23);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value24 = DataCanbus.DATA[116] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                setCarInfo(23, value24 + 2);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value25 = DataCanbus.DATA[116] + 1;
                if (value25 > 1) {
                    value25 = 0;
                }
                setCarInfo(23, value25 + 2);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value26 = DataCanbus.DATA[117] - 1;
                if (value26 < 0) {
                    value26 = 1;
                }
                setCarInfo(36, value26);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value27 = DataCanbus.DATA[117] + 1;
                if (value27 > 1) {
                    value27 = 0;
                }
                setCarInfo(36, value27);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value28 = DataCanbus.DATA[97];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(0, value28);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value29 = DataCanbus.DATA[98];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(1, value29);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value30 = DataCanbus.DATA[99];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(2, value30);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value31 = DataCanbus.DATA[100];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(3, value31);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value32 = DataCanbus.DATA[102];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(13, value32);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value33 = DataCanbus.DATA[103];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(14, value33);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value34 = DataCanbus.DATA[104];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(15, value34);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value35 = DataCanbus.DATA[105];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(16, value35);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value36 = DataCanbus.DATA[106];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(17, value36);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value37 = DataCanbus.DATA[108];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(18, value37);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value38 = DataCanbus.DATA[109];
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }
}
