package com.syu.carinfo.rzc.baojun;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2WulingXingguangSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.WC2WulingXingguangSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 99:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 100:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 101:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 102:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text4)).setText("15s");
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text4)).setText("30s");
                            break;
                        case 3:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text4)).setText("60s");
                            break;
                    }
                    break;
                case 103:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 104:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.dj_airuize7_prompt_light);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.dj_airuize7_prompt_lightsounds);
                            break;
                    }
                    break;
                case 105:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_comfort);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_sport);
                            break;
                    }
                    break;
                case 106:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.wc_golf_comfort);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.mateng_air_con_profile_2);
                            break;
                    }
                    break;
                case 107:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text7)).setText("ECO+");
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text7)).setText("ECO");
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.wc_golf_normal);
                            break;
                        case 3:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_driving_sport);
                            break;
                    }
                    break;
                case 108:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 109:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.str_baojun_str0);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.str_baojun_str1);
                            break;
                    }
                    break;
                case 110:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 111:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.xp_psa_all_string_door_open_1);
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.xp_psa_all_string_door_open_0);
                            break;
                    }
                    break;
                case 112:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.xp_psa_all_string_door_open_1);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.xp_psa_all_string_door_open_0);
                            break;
                    }
                    break;
                case 113:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 114:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 115:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 116:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 117:
                    ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 118:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text11)).setText("10min");
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text11)).setText("20min");
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text11)).setText("30min");
                            break;
                    }
                    break;
                case 119:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 120:
                    ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 121:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    break;
                case 122:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text10)).setText("3");
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text10)).setText("5");
                            break;
                        case 3:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text10)).setText("8");
                            break;
                    }
                    break;
                case 123:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    break;
                case 124:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    break;
                case 125:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.xp_accord9_auto_light_0lowest);
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 126:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text14)).setText("经济+");
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text14)).setText(R.string.driver_system_economics);
                            break;
                        case 2:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text14)).setText(R.string.driver_system_standard);
                            break;
                        case 3:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text14)).setText(R.string.driver_system_sports);
                            break;
                        case 15:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text14)).setText(R.string.wc_golf_custom);
                            break;
                    }
                    break;
                case 127:
                    if (value > 10) {
                        ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text15)).setText("--");
                    } else {
                        ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value * 10) + "%");
                    }
                    break;
                case 128:
                    if (value > 10) {
                        ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text16)).setText("--");
                    } else {
                        ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value * 10) + "%");
                    }
                    break;
                case 129:
                    ((CheckedTextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text17)).setText("单次");
                            break;
                        case 1:
                            ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text17)).setText("循环");
                            break;
                    }
                    break;
                case 131:
                    ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(value).toString());
                    break;
                case 132:
                    ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text19)).setText(new StringBuilder().append(value).toString());
                    break;
                case 133:
                    ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(value).toString());
                    break;
                case 134:
                    ((TextView) WC2WulingXingguangSetFunc.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0444_wc2_wuling_xingguang);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Wuling_Xingguang70_24 /* 459196 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                break;
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_L /* 5505468 */:
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_H /* 5571004 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                break;
            case FinalCanbus.CAR_444_WC2_Wuling_HongguangMini_25 /* 5636540 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                break;
        }
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int mode;
        int mode2;
        int onoff;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[112] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(15, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[112] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(15, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[111] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(16, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[111] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(16, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[104] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[104] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(2, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[102] - 1;
                if (value7 < 1) {
                    value7 = 3;
                }
                setCarInfo(6, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[102] + 1;
                if (value8 > 3) {
                    value8 = 1;
                }
                setCarInfo(6, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[109] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(7, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[109] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(7, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[105] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(11, value11, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[105] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(11, value12, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[107] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(9, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[107] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(9, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[106] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(10, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[106] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(10, value16, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[117];
                if (value17 > 35) {
                    value17--;
                }
                setCarInfo(19, value17, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[117];
                if (value18 < 70) {
                    value18++;
                }
                setCarInfo(19, value18, 255, 255);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[122] - 1;
                if (value19 < 1) {
                    value19 = 3;
                }
                setCarInfo(26, value19, 255, 255);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[122] + 1;
                if (value20 > 3) {
                    value20 = 1;
                }
                setCarInfo(26, value20, 255, 255);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[118] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(27, value21, 255, 255);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[118] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(27, value22, 255, 255);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[120] - 1;
                if (value23 < 1) {
                    value23 = 10;
                }
                setCarInfo(22, value23, 255, 255);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[120] + 1;
                if (value24 > 10) {
                    value24 = 1;
                }
                setCarInfo(22, value24, 255, 255);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[125] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCarInfo(31, value25, 255, 255);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[125] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCarInfo(31, value26, 255, 255);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value27 = DataCanbus.DATA[126] - 1;
                if (value27 < 0) {
                    value27 = 15;
                } else if (value27 > 3) {
                    value27 = 3;
                }
                setCarInfo(28, value27, 255, 255);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value28 = DataCanbus.DATA[126] + 1;
                if (value28 > 15) {
                    value28 = 0;
                } else if (value28 > 3) {
                    value28 = 15;
                }
                setCarInfo(28, value28, 255, 255);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value29 = DataCanbus.DATA[127] - 1;
                if (value29 < 1) {
                    value29 = 10;
                }
                setCarInfo(29, value29, 255, 255);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value30 = DataCanbus.DATA[127] + 1;
                if (value30 > 10) {
                    value30 = 1;
                }
                setCarInfo(29, value30, 255, 255);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value31 = DataCanbus.DATA[128] - 1;
                if (value31 < 0) {
                    value31 = 10;
                }
                setCarInfo(30, value31, 255, 255);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value32 = DataCanbus.DATA[128] + 1;
                if (value32 > 10) {
                    value32 = 0;
                }
                setCarInfo(30, value32, 255, 255);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int onoff2 = DataCanbus.DATA[129];
                int mode3 = DataCanbus.DATA[130];
                int d1 = DataCanbus.DATA[131];
                int d2 = DataCanbus.DATA[132];
                int d3 = DataCanbus.DATA[133];
                int d4 = DataCanbus.DATA[134];
                if (mode3 == 1) {
                    mode2 = 0;
                } else {
                    mode2 = 1;
                }
                setCarCahrgeInfo(((mode2 << 6) & 64) | ((onoff2 << 7) & 128), d1, d2, d3, d4);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int onoff3 = DataCanbus.DATA[129];
                int mode4 = DataCanbus.DATA[130];
                int d5 = DataCanbus.DATA[131];
                int d6 = DataCanbus.DATA[132];
                int d7 = DataCanbus.DATA[133];
                int d8 = DataCanbus.DATA[134];
                if (mode4 == 1) {
                    mode = 0;
                } else {
                    mode = 1;
                }
                setCarCahrgeInfo(((mode << 6) & 64) | ((onoff3 << 7) & 128), d5, d6, d7, d8);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int onoff4 = DataCanbus.DATA[129];
                int mode5 = DataCanbus.DATA[130];
                int d9 = DataCanbus.DATA[131];
                int d10 = DataCanbus.DATA[132];
                int d11 = DataCanbus.DATA[133];
                int d12 = DataCanbus.DATA[134];
                int d13 = d9 - 1;
                if (d13 < 0) {
                    d13 = 23;
                }
                setCarCahrgeInfo(((mode5 << 6) & 64) | ((onoff4 << 7) & 128), d13, d10, d11, d12);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int onoff5 = DataCanbus.DATA[129];
                int mode6 = DataCanbus.DATA[130];
                int d14 = DataCanbus.DATA[131];
                int d15 = DataCanbus.DATA[132];
                int d16 = DataCanbus.DATA[133];
                int d17 = DataCanbus.DATA[134];
                int d18 = d14 + 1;
                if (d18 > 23) {
                    d18 = 0;
                }
                setCarCahrgeInfo(((mode6 << 6) & 64) | ((onoff5 << 7) & 128), d18, d15, d16, d17);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(14, DataCanbus.DATA[113] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarAirInfo(74);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarAirInfo(75);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarAirInfo(72);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarAirInfo(73);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(3, DataCanbus.DATA[103] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(8, DataCanbus.DATA[108] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int onoff6 = DataCanbus.DATA[129];
                int mode7 = DataCanbus.DATA[130];
                int d19 = DataCanbus.DATA[131];
                int d20 = DataCanbus.DATA[132];
                int d21 = DataCanbus.DATA[133];
                int d22 = DataCanbus.DATA[134];
                int d23 = d20 - 1;
                if (d23 < 0) {
                    d23 = 59;
                }
                setCarCahrgeInfo(((mode7 << 6) & 64) | ((onoff6 << 7) & 128), d19, d23, d21, d22);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int onoff7 = DataCanbus.DATA[129];
                int mode8 = DataCanbus.DATA[130];
                int d24 = DataCanbus.DATA[131];
                int d25 = DataCanbus.DATA[132];
                int d26 = DataCanbus.DATA[133];
                int d27 = DataCanbus.DATA[134];
                int d28 = d25 + 1;
                if (d28 > 59) {
                    d28 = 0;
                }
                setCarCahrgeInfo(((mode8 << 6) & 64) | ((onoff7 << 7) & 128), d24, d28, d26, d27);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int onoff8 = DataCanbus.DATA[129];
                int mode9 = DataCanbus.DATA[130];
                int d29 = DataCanbus.DATA[131];
                int d30 = DataCanbus.DATA[132];
                int d31 = DataCanbus.DATA[133];
                int d32 = DataCanbus.DATA[134];
                int d33 = d31 - 1;
                if (d33 < 0) {
                    d33 = 23;
                }
                setCarCahrgeInfo(((mode9 << 6) & 64) | ((onoff8 << 7) & 128), d29, d30, d33, d32);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int onoff9 = DataCanbus.DATA[129];
                int mode10 = DataCanbus.DATA[130];
                int d34 = DataCanbus.DATA[131];
                int d35 = DataCanbus.DATA[132];
                int d36 = DataCanbus.DATA[133];
                int d37 = DataCanbus.DATA[134];
                int d38 = d36 + 1;
                if (d38 > 23) {
                    d38 = 0;
                }
                setCarCahrgeInfo(((mode10 << 6) & 64) | ((onoff9 << 7) & 128), d34, d35, d38, d37);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int onoff10 = DataCanbus.DATA[129];
                int mode11 = DataCanbus.DATA[130];
                int d39 = DataCanbus.DATA[131];
                int d40 = DataCanbus.DATA[132];
                int d41 = DataCanbus.DATA[133];
                int d42 = DataCanbus.DATA[134] - 1;
                if (d42 < 0) {
                    d42 = 59;
                }
                setCarCahrgeInfo(((mode11 << 6) & 64) | ((onoff10 << 7) & 128), d39, d40, d41, d42);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int onoff11 = DataCanbus.DATA[129];
                int mode12 = DataCanbus.DATA[130];
                int d43 = DataCanbus.DATA[131];
                int d44 = DataCanbus.DATA[132];
                int d45 = DataCanbus.DATA[133];
                int d46 = DataCanbus.DATA[134] + 1;
                if (d46 > 59) {
                    d46 = 0;
                }
                setCarCahrgeInfo(((mode12 << 6) & 64) | ((onoff11 << 7) & 128), d43, d44, d45, d46);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(12, DataCanbus.DATA[115] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(13, DataCanbus.DATA[114] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(17, DataCanbus.DATA[110] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(18, DataCanbus.DATA[116] != 1 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(20, 1, 255, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(5, DataCanbus.DATA[102] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(24, DataCanbus.DATA[119] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(25, DataCanbus.DATA[122] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(23, DataCanbus.DATA[121] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(32, DataCanbus.DATA[123] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfo(21, DataCanbus.DATA[124] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int onoff12 = DataCanbus.DATA[129];
                int mode13 = DataCanbus.DATA[130];
                int d47 = DataCanbus.DATA[131];
                int d48 = DataCanbus.DATA[132];
                int d49 = DataCanbus.DATA[133];
                int d50 = DataCanbus.DATA[134];
                if (onoff12 == 1) {
                    onoff = 0;
                } else {
                    onoff = 1;
                }
                setCarCahrgeInfo(((mode13 << 6) & 64) | ((onoff << 7) & 128), d47, d48, d49, d50);
                break;
        }
    }

    void setCarCahrgeInfo(int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2, value3, value4, value5}, null, null);
    }

    void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2, value3, value4}, null, null);
    }

    void setCarAirInfo(int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, 1}, null, null);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DataCanbus.PROXY.cmd(0, new int[]{value1, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.WC2WulingXingguangSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.baojun.WC2WulingXingguangSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.baojun.WC2WulingXingguangSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
