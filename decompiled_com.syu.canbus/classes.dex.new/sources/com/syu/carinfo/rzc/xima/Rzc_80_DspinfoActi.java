package com.syu.carinfo.rzc.xima;

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
import com.syu.carinfo.rzc.sanlin.RZCNissanAHDActi;
import com.syu.carinfo.rzc.sanlin.RZCNissanRearYuleActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Rzc_80_DspinfoActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.Rzc_80_DspinfoActi.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427456 */:
                    Rzc_80_DspinfoActi.this.sendCMD(33, 49);
                    break;
                case R.id.btn_plus1 /* 2131427458 */:
                    Rzc_80_DspinfoActi.this.sendCMD(33, 33);
                    break;
                case R.id.btn_minus2 /* 2131427459 */:
                    Rzc_80_DspinfoActi.this.sendCMD(35, 49);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    Rzc_80_DspinfoActi.this.sendCMD(35, 33);
                    break;
                case R.id.btn_minus3 /* 2131427462 */:
                    Rzc_80_DspinfoActi.this.sendCMD(34, 49);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    Rzc_80_DspinfoActi.this.sendCMD(34, 33);
                    break;
                case R.id.btn_minus4 /* 2131427465 */:
                    Rzc_80_DspinfoActi.this.sendCMD(36, 49);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    Rzc_80_DspinfoActi.this.sendCMD(36, 33);
                    break;
                case R.id.btn_minus5 /* 2131427468 */:
                    Rzc_80_DspinfoActi.this.sendCMD(37, 49);
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    Rzc_80_DspinfoActi.this.sendCMD(37, 33);
                    break;
                case R.id.btn_minus6 /* 2131427471 */:
                    Rzc_80_DspinfoActi.this.sendCMD(38, 49);
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    Rzc_80_DspinfoActi.this.sendCMD(38, 33);
                    break;
                case R.id.btn_minus7 /* 2131427474 */:
                    Rzc_80_DspinfoActi.this.sendCMD(40, 49);
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    Rzc_80_DspinfoActi.this.sendCMD(40, 33);
                    break;
                case R.id.btn_minus8 /* 2131427477 */:
                    int value = DataCanbus.DATA[150] - 1;
                    if (value < 0) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{48, value}, null, null);
                    break;
                case R.id.btn_plus8 /* 2131427479 */:
                    int value2 = DataCanbus.DATA[150] + 1;
                    if (value2 > 1) {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{48, value2}, null, null);
                    break;
                case R.id.btn_minus9 /* 2131427480 */:
                    int value3 = DataCanbus.DATA[188] - 1;
                    if (value3 < 0) {
                        value3 = 2;
                    }
                    DataCanbus.PROXY.cmd(6, new int[]{value3}, null, null);
                    break;
                case R.id.btn_plus9 /* 2131427482 */:
                    int value4 = DataCanbus.DATA[188] + 1;
                    if (value4 > 2) {
                        value4 = 0;
                    }
                    DataCanbus.PROXY.cmd(6, new int[]{value4}, null, null);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    Rzc_80_DspinfoActi.this.sendCMD(41, DataCanbus.DATA[106] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427561 */:
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Rzc_80_DspinfoActi.this, RZCNissanRearYuleActi.class);
                        Rzc_80_DspinfoActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                    break;
                case R.id.ctv_checkedtext2 /* 2131427576 */:
                    Rzc_80_DspinfoActi.this.sendCMD(39, DataCanbus.DATA[104] != 0 ? 0 : 1);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427577 */:
                    try {
                        Intent intent2 = new Intent();
                        intent2.setClass(Rzc_80_DspinfoActi.this, RZCNissanAHDActi.class);
                        Rzc_80_DspinfoActi.this.startActivity(intent2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.Rzc_80_DspinfoActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    Rzc_80_DspinfoActi.this.uCarSpeedLink(val);
                    break;
                case 104:
                    Rzc_80_DspinfoActi.this.uCarBose(val);
                    break;
                case 105:
                    Rzc_80_DspinfoActi.this.uCarRoundVol(val);
                    break;
                case 106:
                    Rzc_80_DspinfoActi.this.uCarFieldDriver(val);
                    break;
                case 108:
                    Rzc_80_DspinfoActi.this.uCarSoundL(val);
                    break;
                case 109:
                    Rzc_80_DspinfoActi.this.uCarSoundH(val);
                    break;
                case 110:
                    Rzc_80_DspinfoActi.this.uCarFieldLR(val);
                    break;
                case 111:
                    Rzc_80_DspinfoActi.this.uCarFieldFB(val);
                    break;
                case 113:
                    Rzc_80_DspinfoActi.this.uCarSound(val);
                    break;
                case 146:
                case 149:
                    int unit = DataCanbus.DATA[146];
                    int data = DataCanbus.DATA[149];
                    if (((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text10)) != null) {
                        if (unit == 1) {
                            ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text10)).setText(String.valueOf(data) + "miles");
                        } else {
                            ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text10)).setText(String.valueOf(data) + "km");
                        }
                    }
                    break;
                case 147:
                case 148:
                    int unit2 = DataCanbus.DATA[147];
                    int data2 = DataCanbus.DATA[148];
                    if (((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text9)) != null) {
                        if (unit2 == 1) {
                            ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text9)).setText(String.valueOf(data2) + "miles");
                        } else {
                            ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text9)).setText(String.valueOf(data2) + "km");
                        }
                    }
                    break;
                case 150:
                    if (((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text8)).setText("Metric");
                                break;
                            case 1:
                                ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text8)).setText("US");
                                break;
                        }
                    }
                    break;
                case 188:
                    if (((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text11)).setText("Type0");
                                break;
                            case 1:
                                ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text11)).setText("Type1");
                                break;
                            case 2:
                                ((TextView) Rzc_80_DspinfoActi.this.findViewById(R.id.tv_text11)).setText("Type2");
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
        setContentView(R.layout.layout_080_rzc_nissan_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.xima.Rzc_80_DspinfoActi.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Rzc_80_DspinfoActi.this.language_set = position;
                if (Rzc_80_DspinfoActi.this.language_set >= 0 && Rzc_80_DspinfoActi.this.language_set <= Rzc_80_DspinfoActi.this.mLauStylelist.size() && Rzc_80_DspinfoActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{49, Rzc_80_DspinfoActi.this.send_lang[Rzc_80_DspinfoActi.this.language_set]}, null, null);
                }
                Rzc_80_DspinfoActi.this.mLauStyle.dismiss();
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_OD_NISSAN_Xima_L /* 1048656 */:
            case FinalCanbus.CAR_OD_NISSAN_Xima_H /* 1114192 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_L /* 1179728 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_H /* 1245264 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_L /* 1310800 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_H /* 1376336 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
                this.send_lang = new int[]{0, 1};
                break;
            default:
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
                break;
        }
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.Rzc_80_DspinfoActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Rzc_80_DspinfoActi.this.mLauStyle == null) {
                    Rzc_80_DspinfoActi.this.initLauStyle();
                }
                if (Rzc_80_DspinfoActi.this.mLauStyle != null && Rzc_80_DspinfoActi.this.mPopShowView != null) {
                    Rzc_80_DspinfoActi.this.mLauStyle.showAtLocation(Rzc_80_DspinfoActi.this.mPopShowView, 17, 0, 0);
                    Rzc_80_DspinfoActi.this.updateLauguageSet();
                }
            }
        });
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus8));
        setonClick((Button) findViewById(R.id.btn_plus8));
        setonClick((Button) findViewById(R.id.btn_minus9));
        setonClick((Button) findViewById(R.id.btn_plus9));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4));
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
            case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
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
                return;
            case FinalCanbus.CAR_OD_NISSAN_Xima_L /* 1048656 */:
            case FinalCanbus.CAR_OD_NISSAN_Xima_H /* 1114192 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_L /* 1179728 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_H /* 1245264 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_L /* 1310800 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_H /* 1376336 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                return;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    protected void uCarSoundL(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSound(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSoundH(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarRoundVol(int val) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSpeedLink(int val) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldLR(int val) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldFB(int val) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarBose(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
        }
    }

    protected void uCarFieldDriver(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
        }
    }
}
