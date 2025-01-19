package com.syu.carinfo.xp.ziyouguang;

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
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class Activity_424_ClioFuncSet extends BaseActivity implements View.OnClickListener {
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
                case 109:
                    Activity_424_ClioFuncSet.this.updateLauguageSet();
                    break;
                case 110:
                    if (((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 111:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 112:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 113:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 114:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 115:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 116:
                    if (((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text4)).setText("Early");
                                break;
                            case 1:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text4)).setText("Standard");
                                break;
                            case 2:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text4)).setText("Late");
                                break;
                        }
                    }
                    break;
                case 118:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 119:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 120:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 121:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 122:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 123:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 124:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 125:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 126:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 127:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 128:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 129:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 130:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 131:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 132:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 133:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 135:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 136:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 137:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 138:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 139:
                    if (((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text5)).setText("Off");
                                break;
                            case 1:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 2:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text5)).setText("60s");
                                break;
                            case 3:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text5)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 140:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 141:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 142:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 143:
                    if (((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text6)).setText("1x");
                                break;
                            case 1:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text6)).setText("3x");
                                break;
                            case 2:
                                ((TextView) Activity_424_ClioFuncSet.this.findViewById(R.id.tv_text6)).setText("5x");
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
        //setContentView(R.layout.layout_0424_xp_clio_settings);
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
                Activity_424_ClioFuncSet.this.language_set = position;
                if (Activity_424_ClioFuncSet.this.language_set >= 0 && Activity_424_ClioFuncSet.this.language_set <= Activity_424_ClioFuncSet.this.mLauStylelist.size() && Activity_424_ClioFuncSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{3, Activity_424_ClioFuncSet.this.send_lang[Activity_424_ClioFuncSet.this.language_set]}, null, null);
                }
                Activity_424_ClioFuncSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[109];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Activity_424_ClioFuncSet.this.mLauStyle == null) {
                    Activity_424_ClioFuncSet.this.initLauStyle();
                }
                if (Activity_424_ClioFuncSet.this.mLauStyle != null && Activity_424_ClioFuncSet.this.mPopShowView != null) {
                    Activity_424_ClioFuncSet.this.mLauStyle.showAtLocation(Activity_424_ClioFuncSet.this.mPopShowView, 17, 0, 0);
                    Activity_424_ClioFuncSet.this.updateLauguageSet();
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                findViewById(R.id.layout_view37).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view37).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP_Renault_20Clio_Low /* 786856 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_view14).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(8);
                findViewById(R.id.layout_view16).setVisibility(8);
                findViewById(R.id.layout_view17).setVisibility(8);
                findViewById(R.id.layout_view18).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(8);
                findViewById(R.id.layout_view20).setVisibility(8);
                findViewById(R.id.layout_view21).setVisibility(8);
                findViewById(R.id.layout_view22).setVisibility(8);
                findViewById(R.id.layout_view23).setVisibility(8);
                findViewById(R.id.layout_view24).setVisibility(8);
                findViewById(R.id.layout_view26).setVisibility(8);
                findViewById(R.id.layout_view27).setVisibility(8);
                findViewById(R.id.layout_view28).setVisibility(8);
                findViewById(R.id.layout_view29).setVisibility(8);
                findViewById(R.id.layout_view30).setVisibility(8);
                findViewById(R.id.layout_view31).setVisibility(8);
                findViewById(R.id.layout_view32).setVisibility(8);
                findViewById(R.id.layout_view33).setVisibility(8);
                findViewById(R.id.layout_view34).setVisibility(8);
                findViewById(R.id.layout_view35).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view4).setVisibility(8);
                return;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427458 */:
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(32, value);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value2 = DataCanbus.DATA[110] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(32, value2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value3 = DataCanbus.DATA[116] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(22, value3);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value4 = DataCanbus.DATA[116] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(22, value4);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[117] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(23, value5);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[117] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(23, value6);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[139] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                setCarInfo(85, value7);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[139] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(85, value8);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[143] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(80, value9);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[143] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(80, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value11 = DataCanbus.DATA[111];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(33, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value12 = DataCanbus.DATA[112];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(34, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value13 = DataCanbus.DATA[113];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(35, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value14 = DataCanbus.DATA[114];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(36, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value15 = DataCanbus.DATA[115];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(37, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(16, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value17 = DataCanbus.DATA[119];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(17, value17);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value18 = DataCanbus.DATA[120];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(18, value18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value19 = DataCanbus.DATA[121];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(19, value19);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value20 = DataCanbus.DATA[122];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(20, value20);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value21 = DataCanbus.DATA[123];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(21, value21);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value22 = DataCanbus.DATA[124];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(38, value22);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value23 = DataCanbus.DATA[125];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(39, value23);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value24 = DataCanbus.DATA[126];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(40, value24);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value25 = DataCanbus.DATA[127];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(41, value25);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value26 = DataCanbus.DATA[128];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(42, value26);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value27 = DataCanbus.DATA[129];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(43, value27);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value28 = DataCanbus.DATA[130];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(44, value28);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value29 = DataCanbus.DATA[131];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(48, value29);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value30 = DataCanbus.DATA[132];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(49, value30);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value31 = DataCanbus.DATA[133];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(50, value31);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value32 = DataCanbus.DATA[135];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(81, value32);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value33 = DataCanbus.DATA[136];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(24, value33);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value34 = DataCanbus.DATA[137];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(25, value34);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value35 = DataCanbus.DATA[138];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(84, value35);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value36 = DataCanbus.DATA[140];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(83, value36);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value37 = DataCanbus.DATA[141];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(82, value37);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                dialog(R.string.tpms_calibration, 64);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Activity_424_MultiSenseFuncSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Activity_424_BoadFuncSet.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                int value38 = DataCanbus.DATA[142];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(51, value38);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
    }
}
