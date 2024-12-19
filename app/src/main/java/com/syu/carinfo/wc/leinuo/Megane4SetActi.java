package com.syu.carinfo.wc.leinuo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
public class Megane4SetActi extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 97:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_0);
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_6);
                                break;
                            case 4:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_brown);
                                break;
                            case 5:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_2);
                                break;
                            case 6:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                                break;
                            case 7:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 98:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value * 5).toString());
                        break;
                    }
                case 99:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 103:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text3)).setText("Sport");
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text3)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text3)).setText("Neutral");
                                break;
                            case 3:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text3)).setText("Eco");
                                break;
                            case 4:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text3)).setText("Perso");
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text4)).setText("Style1");
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text4)).setText("Style2");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text4)).setText("Style3");
                                break;
                            case 3:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text4)).setText("Style4");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text5)).setText("Sport");
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text5)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text5)).setText("Neutral");
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text6)).setText("Sport");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text6)).setText("Neutral");
                                break;
                            case 3:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text6)).setText("Eco");
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text7)).setText("Neutral");
                                break;
                            case 3:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text7)).setText("Eco");
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text8)).setText("Relaxing");
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text8)).setText("Lumbar");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text8)).setText("Tonic");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 110:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 111:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 112:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 113:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 114:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 115:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 116:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 117:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 118:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 119:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 120:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value * 5).toString());
                        break;
                    }
                case 121:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 122:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text13)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text13)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text13)).setText("Type3");
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 124:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 125:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 126:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                        }
                    }
                    break;
                case 128:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 129:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 130:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 131:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 132:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 133:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 134:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 135:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 136:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 137:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 138:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 139:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 140:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 154:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text21)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text21)).setText("Neutral");
                                break;
                            default:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text21)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text22)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text22)).setText("Neutral");
                                break;
                            default:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text22)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 172:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 177:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 178:
                    Megane4SetActi.this.setCheck((CheckedTextView) Megane4SetActi.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 179:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text20)).setText(R.string.rzc_zhenglizi_str);
                                break;
                            case 2:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text20)).setText(R.string.rzc_fulizi_str);
                                break;
                            default:
                                ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text20)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 180:
                    if (((TextView) Megane4SetActi.this.findViewById(R.id.tv_text19)) != null) {
                        ((TextView) Megane4SetActi.this.findViewById(R.id.tv_text19)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Megane4SetActi.this.language_set = position;
                if (Megane4SetActi.this.language_set >= 0 && Megane4SetActi.this.language_set <= Megane4SetActi.this.mLauStylelist.size() && Megane4SetActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{1, Megane4SetActi.this.send_lang[Megane4SetActi.this.language_set]}, null, null);
                }
                Megane4SetActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Megane4SetActi.this.mLauStyle == null) {
                    Megane4SetActi.this.initLauStyle();
                }
                if (Megane4SetActi.this.mLauStyle != null && Megane4SetActi.this.mPopShowView != null) {
                    Megane4SetActi.this.mLauStyle.showAtLocation(Megane4SetActi.this.mPopShowView, 17, 0, 0);
                    Megane4SetActi.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value3 = DataCanbus.DATA[122] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(27, value3, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value4 = DataCanbus.DATA[122] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(27, value4, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value5 = DataCanbus.DATA[123];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(28, value5, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value6 = DataCanbus.DATA[123];
                if (value6 < 31) {
                    value6++;
                }
                setCarInfo(28, value6, 0, 0);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value7 = DataCanbus.DATA[126] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(32, value7, 0, 0);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value8 = DataCanbus.DATA[126] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(32, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value9 = DataCanbus.DATA[99];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(3, value9, 0, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value10 = DataCanbus.DATA[97] - 1;
                if (value10 < 0) {
                    value10 = 7;
                }
                setCarInfo(1, value10, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value11 = DataCanbus.DATA[97] + 1;
                if (value11 > 7) {
                    value11 = 0;
                }
                setCarInfo(1, value11, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value12 = DataCanbus.DATA[98];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(2, value12, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value13 = DataCanbus.DATA[98];
                if (value13 < 20) {
                    value13++;
                }
                setCarInfo(2, value13, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value14 = DataCanbus.DATA[103] - 1;
                if (value14 < 0) {
                    value14 = 4;
                }
                setCarInfo(7, value14, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value15 = DataCanbus.DATA[103] + 1;
                if (value15 > 4) {
                    value15 = 0;
                }
                setCarInfo(7, value15, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value16 = DataCanbus.DATA[104] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(8, value16, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value17 = DataCanbus.DATA[104] + 1;
                if (value17 > 3) {
                    value17 = 0;
                }
                setCarInfo(8, value17, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value18 = DataCanbus.DATA[105] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(9, value18, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value19 = DataCanbus.DATA[105] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(9, value19, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value20 = DataCanbus.DATA[106];
                if (value20 == 0) {
                    value20 = 3;
                } else if (value20 == 3) {
                    value20 = 2;
                } else if (value20 == 2) {
                    value20 = 0;
                }
                setCarInfo(10, value20, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value21 = DataCanbus.DATA[106];
                if (value21 == 0) {
                    value21 = 2;
                } else if (value21 == 2) {
                    value21 = 3;
                } else if (value21 == 3) {
                    value21 = 0;
                }
                setCarInfo(10, value21, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                if (DataCanbus.DATA[107] == 3) {
                    value2 = 2;
                } else {
                    value2 = 3;
                }
                setCarInfo(11, value2, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                if (DataCanbus.DATA[107] == 2) {
                    value = 3;
                } else {
                    value = 2;
                }
                setCarInfo(11, value, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[108] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(13, value22, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[108] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarInfo(13, value23, 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[109] - 1;
                if (value24 < 1) {
                    value24 = 5;
                }
                setCarInfo(14, value24, 0, 0);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[109] + 1;
                if (value25 > 5) {
                    value25 = 1;
                }
                setCarInfo(14, value25, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[110] - 1;
                if (value26 < 1) {
                    value26 = 5;
                }
                setCarInfo(15, value26, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[110] + 1;
                if (value27 > 5) {
                    value27 = 1;
                }
                setCarInfo(15, value27, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[116];
                if (value28 > 0) {
                    value28--;
                }
                setCarInfo(20, value28, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[116];
                if (value29 < 2) {
                    value29++;
                }
                setCarInfo(20, value29, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[120];
                if (value30 > 0) {
                    value30--;
                }
                setCarInfo(24, value30, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[120];
                if (value31 < 20) {
                    value31++;
                }
                setCarInfo(24, value31, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[100];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(4, value32, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[101];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(5, value33, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[102];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(6, value34, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[111];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(12, value35, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[112];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(16, value36, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[113];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(17, value37, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[114];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(18, value38, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[115];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(19, value39, 0, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[117];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(21, value40, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[118];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(22, value41, 0, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[119];
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(23, value42, 0, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[121];
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(26, value43, 0, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[124];
                if (value44 == 0) {
                    value44 = 1;
                } else if (value44 == 1) {
                    value44 = 0;
                }
                setCarInfo(29, value44, 0, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value45 = DataCanbus.DATA[125];
                if (value45 == 0) {
                    value45 = 1;
                } else if (value45 == 1) {
                    value45 = 0;
                }
                setCarInfo(30, value45, 0, 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                creatShowDialog();
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value46 = DataCanbus.DATA[128];
                if (value46 == 0) {
                    value46 = 1;
                } else if (value46 == 1) {
                    value46 = 0;
                }
                setCarInfo(34, value46, 0, 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value47 = DataCanbus.DATA[129];
                if (value47 == 0) {
                    value47 = 1;
                } else if (value47 == 1) {
                    value47 = 0;
                }
                setCarInfo(35, value47, 0, 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value48 = DataCanbus.DATA[131];
                if (value48 == 0) {
                    value48 = 1;
                } else if (value48 == 1) {
                    value48 = 0;
                }
                setCarInfo(37, value48, 0, 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value49 = DataCanbus.DATA[132];
                if (value49 == 0) {
                    value49 = 1;
                } else if (value49 == 1) {
                    value49 = 0;
                }
                setCarInfo(38, value49, 0, 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value50 = DataCanbus.DATA[133];
                if (value50 == 0) {
                    value50 = 1;
                } else if (value50 == 1) {
                    value50 = 0;
                }
                setCarInfo(39, value50, 0, 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value51 = DataCanbus.DATA[134];
                if (value51 == 0) {
                    value51 = 1;
                } else if (value51 == 1) {
                    value51 = 0;
                }
                setCarInfo(40, value51, 0, 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value52 = DataCanbus.DATA[135];
                if (value52 == 0) {
                    value52 = 1;
                } else if (value52 == 1) {
                    value52 = 0;
                }
                setCarInfo(41, value52, 0, 0);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                int value53 = DataCanbus.DATA[136];
                if (value53 == 0) {
                    value53 = 1;
                } else if (value53 == 1) {
                    value53 = 0;
                }
                setCarInfo(42, value53, 0, 0);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                int value54 = DataCanbus.DATA[137];
                if (value54 == 0) {
                    value54 = 1;
                } else if (value54 == 1) {
                    value54 = 0;
                }
                setCarInfo(43, value54, 0, 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                int value55 = DataCanbus.DATA[138];
                if (value55 == 0) {
                    value55 = 1;
                } else if (value55 == 1) {
                    value55 = 0;
                }
                setCarInfo(44, value55, 0, 0);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                int value56 = DataCanbus.DATA[139];
                if (value56 == 0) {
                    value56 = 1;
                } else if (value56 == 1) {
                    value56 = 0;
                }
                setCarInfo(45, value56, 0, 0);
                break;
            case R.id.ctv_checkedtext32 /* 2131427876 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Megane4SetActi2.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                CreatDialog();
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value57 = DataCanbus.DATA[172] - 1;
                if (value57 < 0) {
                    value57 = 2;
                }
                setCarInfo(91, value57, 0, 0);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value58 = DataCanbus.DATA[172] + 1;
                if (value58 > 2) {
                    value58 = 0;
                }
                setCarInfo(91, value58, 0, 0);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value59 = DataCanbus.DATA[180] - 1;
                if (value59 < 1) {
                    value59 = 3;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value59}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value60 = DataCanbus.DATA[180] + 1;
                if (value60 > 3) {
                    value60 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value60}, null, null);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value61 = DataCanbus.DATA[154] - 1;
                if (value61 < 0) {
                    value61 = 2;
                }
                setCarInfo(74, value61, 0, 0);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value62 = DataCanbus.DATA[154] + 1;
                if (value62 > 2) {
                    value62 = 0;
                }
                setCarInfo(74, value62, 0, 0);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value63 = DataCanbus.DATA[155] - 1;
                if (value63 < 0) {
                    value63 = 2;
                }
                setCarInfo(75, value63, 0, 0);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value64 = DataCanbus.DATA[155] + 1;
                if (value64 > 2) {
                    value64 = 0;
                }
                setCarInfo(75, value64, 0, 0);
                break;
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                int value65 = DataCanbus.DATA[177];
                if (value65 == 0) {
                    value65 = 1;
                } else if (value65 == 1) {
                    value65 = 0;
                }
                setCarInfo(87, value65, 0, 0);
                break;
            case R.id.ctv_checkedtext31 /* 2131427887 */:
                int value66 = DataCanbus.DATA[178];
                if (value66 == 0) {
                    value66 = 1;
                } else if (value66 == 1) {
                    value66 = 0;
                }
                setCarInfo(88, value66, 0, 0);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value67 = DataCanbus.DATA[127] - 1;
                if (value67 < 0) {
                    value67 = 2;
                }
                setCarInfo(33, value67, 0, 0);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value68 = DataCanbus.DATA[127] + 1;
                if (value68 > 2) {
                    value68 = 0;
                }
                setCarInfo(33, value68, 0, 0);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value69 = DataCanbus.DATA[130] - 1;
                if (value69 < 0) {
                    value69 = 2;
                }
                setCarInfo(36, value69, 0, 0);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value70 = DataCanbus.DATA[130] + 1;
                if (value70 > 2) {
                    value70 = 0;
                }
                setCarInfo(36, value70, 0, 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                int value71 = DataCanbus.DATA[140];
                if (value71 == 0) {
                    value71 = 1;
                } else if (value71 == 1) {
                    value71 = 0;
                }
                setCarInfo(46, value71, 0, 0);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value72 = DataCanbus.DATA[179] - 1;
                if (value72 < 0) {
                    value72 = 2;
                }
                setCarInfo(89, value72, 0, 0);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value73 = DataCanbus.DATA[179] + 1;
                if (value73 > 2) {
                    value73 = 0;
                }
                setCarInfo(89, value73, 0, 0);
                break;
        }
    }

    private void creatShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_416_reset_tire));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Megane4SetActi.this.setCarInfo(25, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Megane4SetActi.this.setCarInfo(25, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void CreatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Megane4SetActi.this.setCarInfo(31, 1, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.Megane4SetActi.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Megane4SetActi.this.setCarInfo(31, 0, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }
}
