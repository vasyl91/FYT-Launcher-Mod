package com.syu.carinfo.od.tusheng;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XP_19ShengDafei_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.XP_19ShengDafei_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    XP_19ShengDafei_CarSettingAct.this.updateLauguageSet();
                    break;
                case 100:
                    XP_19ShengDafei_CarSettingAct.this.updateGuijiOn();
                    break;
                case 101:
                    XP_19ShengDafei_CarSettingAct.this.updateRadarOn();
                    break;
                case 102:
                    XP_19ShengDafei_CarSettingAct.this.updateFrontViewMode();
                    break;
                case 103:
                    XP_19ShengDafei_CarSettingAct.this.updateRearViewMode();
                    break;
                case 120:
                    ((CheckedTextView) XP_19ShengDafei_CarSettingAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0355_xp_shengdafei_carsetting);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.od.tusheng.XP_19ShengDafei_CarSettingAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                XP_19ShengDafei_CarSettingAct.this.language_set = position;
                if (XP_19ShengDafei_CarSettingAct.this.language_set >= 0 && XP_19ShengDafei_CarSettingAct.this.language_set <= XP_19ShengDafei_CarSettingAct.this.mLauStylelist.size() && XP_19ShengDafei_CarSettingAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{XP_19ShengDafei_CarSettingAct.this.send_lang[XP_19ShengDafei_CarSettingAct.this.language_set]}, null, null);
                }
                XP_19ShengDafei_CarSettingAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[98];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_8));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_18));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.od.tusheng.XP_19ShengDafei_CarSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (XP_19ShengDafei_CarSettingAct.this.mLauStyle == null) {
                    XP_19ShengDafei_CarSettingAct.this.initLauStyle();
                }
                if (XP_19ShengDafei_CarSettingAct.this.mLauStyle != null && XP_19ShengDafei_CarSettingAct.this.mPopShowView != null) {
                    XP_19ShengDafei_CarSettingAct.this.mLauStyle.showAtLocation(XP_19ShengDafei_CarSettingAct.this.mPopShowView, 17, 0, 0);
                    XP_19ShengDafei_CarSettingAct.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.id_reset)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        switch (DataCanbus.DATA[1000]) {
            case 31:
            case 355:
            case FinalCanbus.CAR_XP_QiYaK5_M /* 65891 */:
            case FinalCanbus.CAR_XP_QiYaK5_H /* 131427 */:
            case FinalCanbus.CAR_355_XP_XIANDAI_19SDF /* 721251 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl /* 917859 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_IX45_H /* 1114467 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_BORREGO /* 1180003 */:
            case FinalCanbus.CAR_XP_XIANDAI_19ALl /* 1245539 */:
            case FinalCanbus.CAR_XP_18QiYaK5 /* 1507683 */:
            case FinalCanbus.CAR_XP_18QiYaK5_M /* 1573219 */:
            case FinalCanbus.CAR_XP_18QiYaK5_H /* 1638755 */:
            case FinalCanbus.CAR_XP_16QiYaKX5 /* 1704291 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_M /* 1769827 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_H /* 1835363 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_M /* 1900899 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_H /* 1966435 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_L /* 2097507 */:
            case FinalCanbus.CAR_XP_18KIA_carnival /* 2163043 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_H_Noamp /* 2228579 */:
            case FinalCanbus.CAR_XP_SsangYong_Rexton /* 2294115 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
            case FinalCanbus.CAR_XP1_XiandaiIX45_M /* 65567 */:
            case FinalCanbus.CAR_XP1_XiandaiIX45_H /* 131103 */:
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_XP_QiYaK5_H /* 131427 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP /* 459107 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP_KEEPAIRPANEL /* 524643 */:
            case FinalCanbus.CAR_355_HC_XIANDAI_AMP /* 655715 */:
            case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_TOP /* 852323 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_TOP /* 1048931 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_IX45_H /* 1114467 */:
            case FinalCanbus.CAR_XP_XIANDAI_19ALl_TOP /* 1376611 */:
            case FinalCanbus.CAR_XP_18QiYaK5_H /* 1638755 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_H /* 1835363 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_H /* 1966435 */:
            case FinalCanbus.CAR_DJ_XIANDAI_Sorento_H /* 2031971 */:
                findViewById(R.id.layout_view6).setVisibility(0);
                return;
            default:
                findViewById(R.id.layout_view6).setVisibility(8);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[102] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[102] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[103] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[103] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value4}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[100];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value5 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value6 = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value6 != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(5, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value7 = DataCanbus.DATA[101];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 3;
                iArr3[1] = value7 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Xp_XiandaiAmpCarSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.id_reset /* 2131427693 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Activity_XP_355_FactorySetActivity.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }

    protected void updateRearViewMode() {
        int value = DataCanbus.DATA[103];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_all_view);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_3);
                break;
        }
    }

    protected void updateFrontViewMode() {
        int value = DataCanbus.DATA[102];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_all_view);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadarOn() {
        int value = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGuijiOn() {
        int value = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
