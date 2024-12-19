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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_424_ClioFuncSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 97:
                    Activity_424_ClioFuncSet.this.updateLauguageSet();
                    break;
                case 98:
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
                case 99:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 103:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 104:
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
                case 105:
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
                case 106:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 107:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 108:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 109:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 110:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 111:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 112:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 113:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 114:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 115:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 116:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 117:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 118:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 119:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 120:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 121:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 123:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 124:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 125:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 126:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 127:
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
                case 128:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 129:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 130:
                    Activity_424_ClioFuncSet.this.setCheck((CheckedTextView) Activity_424_ClioFuncSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 131:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0424_xp_clio_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
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
        int value = DataCanbus.DATA[97];
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet.3
            @Override // android.view.View.OnClickListener
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[99];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(33, value);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value2 = DataCanbus.DATA[98] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(32, value2);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value3 = DataCanbus.DATA[98] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(32, value3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value4 = DataCanbus.DATA[104] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(22, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value5 = DataCanbus.DATA[104] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(22, value5);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value6 = DataCanbus.DATA[105] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(23, value6);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value7 = DataCanbus.DATA[105] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(23, value7);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value8 = DataCanbus.DATA[127] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(85, value8);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value9 = DataCanbus.DATA[127] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(85, value9);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value10 = DataCanbus.DATA[131] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(80, value10);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value11 = DataCanbus.DATA[131] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(80, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value12 = DataCanbus.DATA[100];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(34, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value13 = DataCanbus.DATA[101];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(35, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value14 = DataCanbus.DATA[102];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(36, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value15 = DataCanbus.DATA[103];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(37, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value16 = DataCanbus.DATA[106];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(16, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value17 = DataCanbus.DATA[107];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(17, value17);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value18 = DataCanbus.DATA[108];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(18, value18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value19 = DataCanbus.DATA[109];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(19, value19);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value20 = DataCanbus.DATA[110];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(20, value20);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value21 = DataCanbus.DATA[111];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(21, value21);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value22 = DataCanbus.DATA[112];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(38, value22);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value23 = DataCanbus.DATA[113];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(39, value23);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value24 = DataCanbus.DATA[114];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(40, value24);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value25 = DataCanbus.DATA[115];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(41, value25);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value26 = DataCanbus.DATA[116];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(42, value26);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value27 = DataCanbus.DATA[117];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(43, value27);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value28 = DataCanbus.DATA[118];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(44, value28);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value29 = DataCanbus.DATA[119];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(48, value29);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value30 = DataCanbus.DATA[120];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(49, value30);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value31 = DataCanbus.DATA[121];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(50, value31);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value32 = DataCanbus.DATA[123];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(81, value32);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value33 = DataCanbus.DATA[124];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(24, value33);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                int value34 = DataCanbus.DATA[125];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(25, value34);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                int value35 = DataCanbus.DATA[126];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(84, value35);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                int value36 = DataCanbus.DATA[128];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(83, value36);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                int value37 = DataCanbus.DATA[129];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(82, value37);
                break;
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                dialog(R.string.tpms_calibration, 64);
                break;
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Activity_424_MultiSenseFuncSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                int value38 = DataCanbus.DATA[130];
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
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
    }
}
