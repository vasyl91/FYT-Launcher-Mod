package com.syu.carinfo.rzc.baojun;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 7:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 9:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 2);
                    break;
                case 10:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 2);
                    break;
                case 11:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 2);
                    break;
                case 12:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 2);
                    break;
                case 13:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 2);
                    break;
                case 14:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                    }
                case 15:
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
                case 16:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                    }
                case 17:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 2);
                    break;
                case 18:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 2);
                    break;
                case 19:
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
                case 20:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 2);
                    break;
                case 21:
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
                case 22:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.str_baojun_str0);
                            break;
                        case 2:
                            ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.str_baojun_str1);
                            break;
                    }
                case 23:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 2);
                    break;
                case 24:
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
                case 25:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 2);
                    break;
                case 26:
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
                case 27:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 2);
                    break;
                case 29:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 2);
                    break;
                case 30:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 2);
                    break;
                case 31:
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
                case 32:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 2);
                    break;
                case 33:
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
                case 34:
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
                case 35:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 36:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                    break;
                case 37:
                    ((CheckedTextView) RzcBaojunSetFunc.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 2);
                    break;
                case 38:
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
                case 39:
                    ((TextView) RzcBaojunSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + "s");
                    break;
                case 40:
                    RzcBaojunSetFunc.this.updateLauguageSet();
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
        int value = DataCanbus.DATA[40];
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
                    int value = DataCanbus.DATA[7] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 1;
                    iArr[1] = value != 1 ? 1 : 2;
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
                    int value = DataCanbus.DATA[9] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 3;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[10] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 4;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[11] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 5;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[12] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 6;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[13] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 7;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[17] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 11;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.12
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[18] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 12;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.13
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[20] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 14;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[23] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 17;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[25] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 19;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[27] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 21;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.17
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[29] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 22;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.18
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[30] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 23;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[30] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 25;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[37] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 30;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[14] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 8;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[14] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 8;
                    iArr[1] = value != 1 ? 1 : 2;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[15] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.24
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[15] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.25
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[16] & 255) - 1;
                    if (value < 1) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.26
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[16] & 255) + 1;
                    if (value > 2) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.27
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[19] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.28
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[19] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.29
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[21] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.30
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[21] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.31
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[22] & 255) - 1;
                    if (value < 1) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.32
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[22] & 255) + 1;
                    if (value > 2) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.33
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[24] & 255) - 1;
                    if (value < 1) {
                        value = 11;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.34
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[24] & 255) + 1;
                    if (value > 11) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.35
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[26] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{20, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.36
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[26] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{20, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.37
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[31] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{24, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.38
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[31] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{24, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.39
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[33] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{26, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.40
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[33] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{26, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.41
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[34] & 255) - 1;
                    if (value < 1) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{27, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.42
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[34] & 255) + 1;
                    if (value > 3) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{27, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus12)) != null) {
            ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.43
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[35] & 255;
                    if (value > 1) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{28, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus12)) != null) {
            ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.44
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[35] & 255;
                    if (value < 253) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{28, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus13)) != null) {
            ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.45
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[36] & 255;
                    if (value > 1) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{29, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus13)) != null) {
            ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.46
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[36] & 255;
                    if (value < 100) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{29, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus14)) != null) {
            ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.47
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[38] & 255) - 1;
                    if (value < 1) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{31, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus14)) != null) {
            ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.48
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[38] & 255) + 1;
                    if (value > 4) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{31, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus15)) != null) {
            ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.49
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[39] & 255;
                    if (value > 5) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{32, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus15)) != null) {
            ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.50
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[39] & 255;
                    if (value < 20) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{32, value}, null, null);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.51
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.51.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc.52
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
