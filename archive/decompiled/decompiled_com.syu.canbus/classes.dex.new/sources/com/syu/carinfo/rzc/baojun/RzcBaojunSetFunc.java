package com.syu.carinfo.rzc.baojun;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcBaojunSetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 100:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 2);
                    break;
                case 101:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 2);
                    break;
                case 102:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 2);
                    break;
                case 103:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 2);
                    break;
                case 104:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 2);
                    break;
                case 105:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                    break;
                case 106:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                    break;
                case 107:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                    }
                    break;
                case 108:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 2);
                    break;
                case 109:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 2);
                    break;
                case 110:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text4)).setText("10min");
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text4)).setText("20min");
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text4)).setText("30min");
                            break;
                    }
                    break;
                case 111:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 2);
                    break;
                case 112:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                        case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
                        case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                            switch (value) {
                                case 1:
                                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text5)).setText("15S");
                                    break;
                                case 2:
                                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text5)).setText("30S");
                                    break;
                                case 3:
                                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text5)).setText("60S");
                                    break;
                            }
                            break;
                        default:
                            switch (value) {
                                case 1:
                                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text5)).setText("30S");
                                    break;
                                case 2:
                                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text5)).setText("50S");
                                    break;
                                case 3:
                                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text5)).setText("75S");
                                    break;
                            }
                            break;
                    }
                    break;
                case 113:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.str_baojun_str0);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.str_baojun_str1);
                            break;
                    }
                    break;
                case 114:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 2);
                    break;
                case 115:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("30km/h");
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("35km/h");
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("40km/h");
                            break;
                        case 4:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("45km/h");
                            break;
                        case 5:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("50km/h");
                            break;
                        case 6:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("55km/h");
                            break;
                        case 7:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("60km/h");
                            break;
                        case 8:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("65km/h");
                            break;
                        case 9:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("70km/h");
                            break;
                        case 10:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("75km/h");
                            break;
                        case 11:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text7)).setText("80km/h");
                            break;
                    }
                    break;
                case 116:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 2);
                    break;
                case 117:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                            break;
                    }
                    break;
                case 118:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 2);
                    break;
                case 119:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 2);
                    break;
                case 120:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 2);
                    break;
                case 121:
                    switch (value) {
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text9)).setText(R.string.wc_golf_normal);
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
                            break;
                        default:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_comfort);
                            break;
                    }
                    break;
                case 122:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 2);
                    break;
                case 123:
                    switch (value) {
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.klc_Parking_with_trailer_ON);
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_auto);
                            break;
                        default:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                    }
                    break;
                case 124:
                    if (DataCanbus.DATA[1000] == 721206 || DataCanbus.DATA[1000] == 983350) {
                        switch (value) {
                            case 2:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text11)).setText("随机模式");
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view28).setVisibility(8);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view30).setVisibility(8);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view31).setVisibility(0);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view32).setVisibility(0);
                                break;
                            case 3:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text11)).setText("驾驶模式");
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view28).setVisibility(8);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view30).setVisibility(8);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view31).setVisibility(8);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view32).setVisibility(8);
                                break;
                            default:
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view28).setVisibility(0);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view30).setVisibility(0);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view31).setVisibility(8);
                                RzcBaojunSetFunc.this.findViewById(R.id.layout_view32).setVisibility(8);
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text11)).setText("固定模式");
                                break;
                        }
                    }
                    break;
                case 125:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 126:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                    break;
                case 127:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 2);
                    break;
                case 128:
                    switch (value) {
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text14)).setText("动感缤纷");
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text14)).setText("所有随机");
                            break;
                        case 4:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text14)).setText("偏好随机");
                            break;
                        default:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text14)).setText("柔和微光");
                            break;
                    }
                    break;
                case 129:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + "s");
                    break;
                case 130:
                    RzcBaojunSetFunc.this.updateLauguageSet();
                    break;
                case 132:
                    if (DataCanbus.DATA[1000] == 1311030) {
                        switch (value) {
                            case 2:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.driver_system_standard);
                                break;
                            case 3:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.driver_system_sports);
                                break;
                            case 4:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText("经济+");
                                break;
                            default:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.driver_system_economics);
                                break;
                        }
                    }
                    break;
                case 133:
                    if (DataCanbus.DATA[1000] == 1311030) {
                        switch (value) {
                            case 2:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text17)).setText(R.string.wc_golf_comfort);
                                break;
                            case 3:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text17)).setText(R.string.mateng_air_con_profile_2);
                                break;
                            default:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text17)).setText(R.string.driver_system_standard);
                                break;
                        }
                    }
                    break;
                case 134:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 2);
                    break;
                case 135:
                    if (DataCanbus.DATA[1000] == 1311030) {
                        ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 2);
                    }
                    break;
                case 136:
                    if (DataCanbus.DATA[1000] == 1311030) {
                        ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 2);
                    }
                    break;
                case 138:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 2);
                    break;
                case 139:
                    if (DataCanbus.DATA[1000] == 1311030) {
                        ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 141:
                    if (DataCanbus.DATA[1000] == 524598) {
                        switch (value) {
                            case 2:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.driver_system_economics);
                                break;
                            case 3:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.driver_system_sports);
                                break;
                            case 4:
                            default:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.driver_system_standard);
                                break;
                            case 5:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text16)).setText(R.string.wc_golf_custom);
                                break;
                        }
                    }
                    break;
                case 142:
                    if (DataCanbus.DATA[1000] == 524598) {
                        switch (value) {
                            case 2:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text17)).setText(R.string.wc_golf_comfort);
                                break;
                            case 3:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text17)).setText(R.string.mateng_air_con_profile_2);
                                break;
                            default:
                                ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text17)).setText(R.string.driver_system_standard);
                                break;
                        }
                    }
                    break;
                case 143:
                    if (DataCanbus.DATA[1000] == 524598) {
                        ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 2);
                    }
                    break;
                case 144:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value) + "%");
                    break;
                case 145:
                    if (DataCanbus.DATA[1000] == 524598) {
                        ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 146:
                    switch (value) {
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text20)).setText(R.string.wc_372_low);
                            break;
                        case 3:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text20)).setText(R.string.wc_372_mid);
                            break;
                        case 4:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text20)).setText(R.string.wc_372_high);
                            break;
                        default:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text20)).setText(R.string.xp_accord9_auto_light_0lowest);
                            break;
                    }
                    break;
                case 147:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value == 2);
                    break;
                case 148:
                    if (DataCanbus.DATA[1000] == 524598) {
                        ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 2);
                    }
                    break;
                case 156:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
                case 157:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value == 2);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0310_rzc_baojun);
        setupView();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RzcBaojunSetFunc.this.language_set = position;
                if (RzcBaojunSetFunc.this.language_set >= 0 && RzcBaojunSetFunc.this.language_set <= RzcBaojunSetFunc.this.mLauStylelist.size() && RzcBaojunSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{33, RzcBaojunSetFunc.this.send_lang[RzcBaojunSetFunc.this.language_set]}, null, null);
                }
                RzcBaojunSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[130];
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

    private void setupView() {
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_18BaoJun530 /* 196918 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_19BaoJun730 /* 393526 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
            case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
            case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_25WulinHongguang_MINI /* 524598 */:
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                break;
            case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                break;
        }
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.off));
        this.mLauStylelist.add("翘起");
        this.mLauStylelist.add("打开");
        this.send_lang = new int[]{0, 100, 200};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcBaojunSetFunc.this.mLauStyle == null) {
                    RzcBaojunSetFunc.this.initLauStyle();
                }
                if (RzcBaojunSetFunc.this.mLauStyle != null && RzcBaojunSetFunc.this.mPopShowView != null) {
                    RzcBaojunSetFunc.this.mLauStyle.showAtLocation(RzcBaojunSetFunc.this.mPopShowView, 17, 0, 0);
                    RzcBaojunSetFunc.this.updateLauguageSet();
                }
            }
        });
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[98] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 1;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RzcBaojunSetFunc.this.dialog(R.string.xp_accord9_deflation_warning_system, 0, 2);
            }
        });
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.6
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[100] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 3;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[101] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 4;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[102] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 5;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[103] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 6;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[104] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 7;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[108] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.12
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[109] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 12;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.13
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[111] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 14;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[114] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 17;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[116] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 19;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[118] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 21;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.17
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[119] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 22;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.18
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[120] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 23;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[120] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 25;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[127] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 30;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext19)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[134] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 50;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = DataCanbus.DATA[143] & 255;
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int[] iArr = new int[2];
                        iArr[0] = 37;
                        iArr[1] = value == 2 ? 1 : 2;
                        remoteModuleProxy.cmd(0, iArr, null, null);
                        return;
                    }
                    int value2 = DataCanbus.DATA[135] & 255;
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[2];
                    iArr2[0] = 51;
                    iArr2[1] = value2 == 2 ? 1 : 2;
                    remoteModuleProxy2.cmd(0, iArr2, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext21)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = DataCanbus.DATA[148] & 255;
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int[] iArr = new int[2];
                        iArr[0] = 42;
                        iArr[1] = value == 2 ? 1 : 2;
                        remoteModuleProxy.cmd(0, iArr, null, null);
                        return;
                    }
                    int value2 = DataCanbus.DATA[136] & 255;
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[2];
                    iArr2[0] = 52;
                    iArr2[1] = value2 == 2 ? 1 : 2;
                    remoteModuleProxy2.cmd(0, iArr2, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.24
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[138] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 53;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.25
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        DataCanbus.PROXY.cmd(0, new int[]{43, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{55, 1}, null, null);
                    }
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext24)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.26
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[147] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 41;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext25)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.27
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(0, new int[]{44, 1}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext26)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.28
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(RzcBaojunSetFunc.this, RZCWulingChargeSetFunc.class);
                        RzcBaojunSetFunc.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext27)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.29
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[157] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 57;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.30
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[105] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 8;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.31
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[105] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 8;
                    iArr[1] = value == 2 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.32
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[106] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.33
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[106] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.34
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[107] & 255) - 1;
                    if (value < 1) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.35
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[107] & 255) + 1;
                    if (value > 2) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.36
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[110] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.37
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[110] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.38
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[112] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.39
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[112] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.40
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[113] & 255) - 1;
                    if (value < 1) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.41
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[113] & 255) + 1;
                    if (value > 2) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.42
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[115] & 255) - 1;
                    if (value < 1) {
                        value = 11;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.43
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[115] & 255) + 1;
                    if (value > 11) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.44
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[117] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{20, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.45
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[117] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{20, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.46
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[121] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{24, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.47
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[121] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{24, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.48
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[123] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{26, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.49
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[123] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{26, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.50
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[124] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{27, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.51
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[124] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{27, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus12)) != null) {
            ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.52
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[125] & 255;
                    if (value > 1) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{28, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus12)) != null) {
            ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.53
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[125] & 255;
                    if (value < 253) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{28, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus13)) != null) {
            ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.54
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[126] & 255;
                    if (value > 1) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{29, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus13)) != null) {
            ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.55
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[126] & 255;
                    if (value < 100) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{29, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus14)) != null) {
            ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.56
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[128] & 255) - 1;
                    if (value < 1) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{31, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus14)) != null) {
            ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.57
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[128] & 255) + 1;
                    if (value > 4) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{31, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus15)) != null) {
            ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.58
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[129] & 255;
                    if (value > 5) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{32, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus15)) != null) {
            ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.59
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[129] & 255;
                    if (value < 20) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{32, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus16)) != null) {
            ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.60
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = (DataCanbus.DATA[141] & 255) - 1;
                        if (value == 4) {
                            value = 3;
                        }
                        if (value < 1) {
                            value = 5;
                        }
                        DataCanbus.PROXY.cmd(0, new int[]{35, value}, null, null);
                        return;
                    }
                    int value2 = (DataCanbus.DATA[132] & 255) - 1;
                    if (value2 < 1) {
                        value2 = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{48, value2}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus16)) != null) {
            ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.61
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = (DataCanbus.DATA[141] & 255) + 1;
                        if (value == 4) {
                            value = 5;
                        }
                        if (value > 5) {
                            value = 1;
                        }
                        DataCanbus.PROXY.cmd(0, new int[]{35, value}, null, null);
                        return;
                    }
                    int value2 = (DataCanbus.DATA[132] & 255) + 1;
                    if (value2 > 4) {
                        value2 = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{48, value2}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus17)) != null) {
            ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.62
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = (DataCanbus.DATA[142] & 255) - 1;
                        if (value < 1) {
                            value = 3;
                        }
                        DataCanbus.PROXY.cmd(0, new int[]{36, value}, null, null);
                        return;
                    }
                    int value2 = (DataCanbus.DATA[133] & 255) - 1;
                    if (value2 < 1) {
                        value2 = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{49, value2}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus17)) != null) {
            ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.63
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = (DataCanbus.DATA[142] & 255) + 1;
                        if (value > 3) {
                            value = 1;
                        }
                        DataCanbus.PROXY.cmd(0, new int[]{36, value}, null, null);
                        return;
                    }
                    int value2 = (DataCanbus.DATA[133] & 255) + 1;
                    if (value2 > 3) {
                        value2 = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{49, value2}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus18)) != null) {
            ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.64
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = (DataCanbus.DATA[145] & 255) - 10;
                        if (value < 0) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(0, new int[]{39, value}, null, null);
                        return;
                    }
                    int value2 = (DataCanbus.DATA[139] & 255) - 1;
                    if (value2 < 35) {
                        value2 = 35;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{54, value2}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus18)) != null) {
            ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.65
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (DataCanbus.DATA[1000] == 524598) {
                        int value = (DataCanbus.DATA[145] & 255) + 10;
                        if (value > 100) {
                            value = 100;
                        }
                        DataCanbus.PROXY.cmd(0, new int[]{39, value}, null, null);
                        return;
                    }
                    int value2 = (DataCanbus.DATA[139] & 255) + 1;
                    if (value2 > 100) {
                        value2 = 100;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{54, value2}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus19)) != null) {
            ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.66
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[144] & 255) - 10;
                    if (value < 10) {
                        value = 10;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{38, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus19)) != null) {
            ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.67
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[144] & 255) + 10;
                    if (value > 100) {
                        value = 100;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{38, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus20)) != null) {
            ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.68
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[146] & 255) - 1;
                    if (value < 1) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{40, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus20)) != null) {
            ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.69
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[146] & 255) + 1;
                    if (value > 4) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{40, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus21)) != null) {
            ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.70
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[156] & 255) - 1;
                    if (value < 1) {
                        value = 10;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{56, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus21)) != null) {
            ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.71
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[156] & 255) + 1;
                    if (value > 10) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{56, value}, null, null);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.72
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.72.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.73
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
