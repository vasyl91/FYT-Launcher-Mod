package com.syu.carinfo.qirui;

import android.app.Activity;
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
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCAiRuiZe extends Activity implements View.OnClickListener {
    int language_set = 255;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.qirui.ActivityWCAiRuiZe.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 101:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    break;
                case 102:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 2:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 103:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 104:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 105:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 106:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 107:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 108:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text3)).setText(R.string.str_395_static_state);
                            break;
                        case 2:
                            ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text3)).setText(R.string.str_395_static_and_dynamic);
                            break;
                    }
                    break;
                case 109:
                    if (value == 0) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                    } else {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append((value * 5) + 25).toString());
                    }
                    break;
                case 110:
                    ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 111:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 112:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 113:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
                case 114:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 115:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
                case 116:
                    if (value == 0) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_light);
                    } else if (value == 1) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_sounds);
                    } else {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_lightsounds);
                    }
                    break;
                case 117:
                    if (value == 0) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text9)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                    } else if (value == 1) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
                    }
                    break;
                case 118:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    break;
                case 119:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 120:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 121:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    break;
                case 122:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
                    break;
                case 123:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
                    break;
                case 124:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    break;
                case 125:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 126:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
                    break;
                case 127:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
                    break;
                case 128:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value != 0);
                    break;
                case 129:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 130:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
                    break;
                case 131:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value != 0);
                    break;
                case 132:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text8)).setText(R.string.str_driving_eco);
                                break;
                            case 1:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text8)).setText(R.string.str_driving_comfort);
                                break;
                            case 2:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text8)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
                case 133:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value != 0);
                    break;
                case 134:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value != 0);
                    break;
                case 135:
                    ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    break;
            }
        }
    };
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_qirui_airuize);
        setListener();
    }

    private void initLauStyle() {
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.qirui.ActivityWCAiRuiZe.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ActivityWCAiRuiZe.this.language_set = position;
                if (ActivityWCAiRuiZe.this.language_set >= 0 && ActivityWCAiRuiZe.this.language_set <= ActivityWCAiRuiZe.this.mLauStylelist.size() && ActivityWCAiRuiZe.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(4, new int[]{1, ActivityWCAiRuiZe.this.send_lang[ActivityWCAiRuiZe.this.language_set]}, null, null);
                }
                ActivityWCAiRuiZe.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    public void setListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = (DataCanbus.DATA[102] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfoCmd(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[102] & 255) + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfoCmd(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = (DataCanbus.DATA[125] & 255) - 1;
                if (value3 < 1) {
                    value3 = 5;
                }
                setCarInfoCmd(35, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = (DataCanbus.DATA[125] & 255) + 1;
                if (value4 > 5) {
                    value4 = 1;
                }
                setCarInfoCmd(35, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = (DataCanbus.DATA[108] & 255) - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfoCmd(11, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = (DataCanbus.DATA[108] & 255) + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfoCmd(11, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = (DataCanbus.DATA[109] & 255) - 1;
                if (value7 < 0) {
                    value7 = 21;
                }
                setCarInfoCmd(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = (DataCanbus.DATA[109] & 255) + 1;
                if (value8 > 21) {
                    value8 = 0;
                }
                setCarInfoCmd(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = (DataCanbus.DATA[110] & 255) - 1;
                if (value9 < 1) {
                    value9 = 1;
                }
                setCarInfoCmd(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = (DataCanbus.DATA[110] & 255) + 1;
                if (value10 > 10) {
                    value10 = 10;
                }
                setCarInfoCmd(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = (DataCanbus.DATA[116] & 255) - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfoCmd(17, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = (DataCanbus.DATA[116] & 255) + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfoCmd(17, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = (DataCanbus.DATA[129] & 255) - 1;
                if (value13 < 0) {
                    value13 = 0;
                }
                setCarInfoCmd(36, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = (DataCanbus.DATA[129] & 255) + 1;
                if (value14 > 255) {
                    value14 = 255;
                }
                setCarInfoCmd(36, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = (DataCanbus.DATA[132] & 255) - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfoCmd(39, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = (DataCanbus.DATA[132] & 255) + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfoCmd(39, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = (DataCanbus.DATA[117] & 255) - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfoCmd(23, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = (DataCanbus.DATA[117] & 255) + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfoCmd(23, value18);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfoCmd(19, (DataCanbus.DATA[119] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfoCmd(31, (DataCanbus.DATA[121] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfoCmd(1, (DataCanbus.DATA[101] & 255) == 0 ? 1 : 0);
                break;
            case R.id.all_func_btn_lauguage_set /* 2131427574 */:
                if (this.mLauStyle == null) {
                    initLauStyle();
                }
                if (this.mLauStyle != null && this.mPopShowView != null) {
                    this.mLauStyle.showAtLocation(this.mPopShowView, 17, 0, 0);
                    updateLauguageSet();
                    break;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfoCmd(20, (DataCanbus.DATA[120] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfoCmd(26, (DataCanbus.DATA[135] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfoCmd(4, (DataCanbus.DATA[103] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfoCmd(5, (DataCanbus.DATA[104] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfoCmd(6, (DataCanbus.DATA[105] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfoCmd(9, (DataCanbus.DATA[106] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfoCmd(10, (DataCanbus.DATA[107] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfoCmd(12, (DataCanbus.DATA[111] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfoCmd(13, (DataCanbus.DATA[112] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfoCmd(14, (DataCanbus.DATA[113] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfoCmd(15, (DataCanbus.DATA[114] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfoCmd(16, (DataCanbus.DATA[115] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfoCmd(30, (DataCanbus.DATA[118] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfoCmd(28, (DataCanbus.DATA[123] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfoCmd(27, (DataCanbus.DATA[124] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCarInfoCmd(18, 0 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                setCarInfoCmd(29, (DataCanbus.DATA[122] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                setCarInfoCmd(32, (DataCanbus.DATA[128] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                setCarInfoCmd(33, (DataCanbus.DATA[127] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                setCarInfoCmd(34, (DataCanbus.DATA[126] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                setCarInfoCmd(41, (DataCanbus.DATA[130] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                setCarInfoCmd(40, (DataCanbus.DATA[131] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                setCarInfoCmd(38, (DataCanbus.DATA[133] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                setCarInfoCmd(37, (DataCanbus.DATA[134] & 255) != 0 ? 0 : 1);
                break;
        }
    }

    private void setCarInfoCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(2, cmd, value);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mCanbusNotify);
    }
}
