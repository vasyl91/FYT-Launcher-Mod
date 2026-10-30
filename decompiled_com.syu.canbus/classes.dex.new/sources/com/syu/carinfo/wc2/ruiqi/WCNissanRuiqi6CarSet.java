package com.syu.carinfo.wc2.ruiqi;

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
public class WCNissanRuiqi6CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ruiqi.WCNissanRuiqi6CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 117:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 118:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 119:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 125:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 126:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_out_sync);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_sync_open);
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_sync_close);
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_sync_all);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_sport);
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_playstate11);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("1min");
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("2min");
                                break;
                            case 4:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("5min");
                                break;
                        }
                    }
                    break;
                case 131:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    break;
                case 132:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    break;
                case 133:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    break;
                case 134:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 143:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text10)).setText("LDW");
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text10)).setText("LKA&LDW");
                                break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text11)).setText("Normal");
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text11)).setText("Late");
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text11)).setText("Early");
                                break;
                        }
                    }
                    break;
                case 145:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
                case 146:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text12)).setText("Normal");
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text12)).setText("Late");
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text12)).setText("Early");
                                break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text4)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text4)).setText("Type2");
                                break;
                        }
                    }
                    break;
                case 148:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text6)).setText("15s");
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text6)).setText("45s");
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 149:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 150:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 151:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_3);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_8);
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_bright_gold);
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_1);
                                break;
                            case 4:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_5);
                                break;
                            case 5:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.color_white_str);
                                break;
                            case 6:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_4);
                                break;
                            case 7:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_multi_color_respiration);
                                break;
                        }
                    }
                    break;
                case 152:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 154:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 156:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 157:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 158:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 159:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
                case 160:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.driver_system_standard);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_17_snow);
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_Manual);
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_mud_ruts);
                                break;
                            case 4:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.driver_system_sports);
                                break;
                            case 5:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_driving_eco);
                                break;
                            case 6:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_sand);
                                break;
                        }
                    }
                    break;
                case 161:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_nissan_ruiqi_settings);
        setListener();
    }

    private void setListener() {
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
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_WC2_Dongfeng_23YiXuan_H /* 262590 */:
            case FinalCanbus.CAR_446_WC2_Dongfeng_23YiXuan_L /* 655806 */:
                findViewById(R.id.layout_view1).setVisibility(0);
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
                break;
            case FinalCanbus.CAR_446_WC2_Nissan_Ruiqi6_H /* 1376702 */:
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                break;
            case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            case FinalCanbus.CAR_446_WC2_Nissan_Ruiqi6EV_A17K /* 1835454 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            case FinalCanbus.CAR_446_WC2_Nissan_S15 /* 2752958 */:
            case FinalCanbus.CAR_446_WC2_Nissan_S15_AUTO /* 2818494 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[126] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(0, new int[]{26, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[126] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{26, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[127] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[127] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[128] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{27, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[128] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{27, value6}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[147] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{38, value7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[147] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{38, value8}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[149] - 1;
                if (value9 < 1) {
                    value9 = 6;
                }
                DataCanbus.PROXY.cmd(0, new int[]{40, value9}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[149] + 1;
                if (value10 > 6) {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{40, value10}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[148] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                DataCanbus.PROXY.cmd(0, new int[]{39, value11}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[148] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{39, value12}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[151] - 1;
                if (value13 < 0) {
                    value13 = 7;
                }
                DataCanbus.PROXY.cmd(0, new int[]{42, value13}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[151] + 1;
                if (value14 > 7) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{42, value14}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[152] - 1;
                if (value15 < 1) {
                    value15 = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{43, value15}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[152] + 1;
                if (value16 > 10) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{43, value16}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[160] - 1;
                if (value17 < 0) {
                    value17 = 6;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value17}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[160] + 1;
                if (value18 > 6) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value18}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[143] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{22, value19}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[143] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{22, value20}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[144] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{23, value21}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[144] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{23, value22}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[146] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, value23}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[146] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{25, value24}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value25 = DataCanbus.DATA[116];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value25}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value26 = DataCanbus.DATA[119];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value26}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value27 = DataCanbus.DATA[125];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value27}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value28 = DataCanbus.DATA[117];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value28}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value29 = DataCanbus.DATA[118];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value29}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value30 = DataCanbus.DATA[150];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{41, value30}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                DataCanbus.PROXY.cmd(0, new int[]{44, 1}, null, null);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DataCanbus.PROXY.cmd(0, new int[]{44, 0}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value31 = DataCanbus.DATA[154];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{45, value31}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                DataCanbus.PROXY.cmd(0, new int[]{46, 1}, null, null);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                DataCanbus.PROXY.cmd(0, new int[]{46, 0}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value32 = DataCanbus.DATA[156];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{47, value32}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value33 = DataCanbus.DATA[157];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{48, value33}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value34 = DataCanbus.DATA[158];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{49, value34}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value35 = DataCanbus.DATA[159];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value35}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value36 = DataCanbus.DATA[161];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value36}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value37 = DataCanbus.DATA[145];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{24, value37}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value38 = DataCanbus.DATA[131];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{34, value38}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value39 = DataCanbus.DATA[132];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{35, value39}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value40 = DataCanbus.DATA[133];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{36, value40}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value41 = DataCanbus.DATA[134];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{37, value41}, null, null);
                break;
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }
}
