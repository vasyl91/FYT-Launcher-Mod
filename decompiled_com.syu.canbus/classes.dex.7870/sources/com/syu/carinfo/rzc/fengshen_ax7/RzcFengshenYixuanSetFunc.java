package com.syu.carinfo.rzc.fengshen_ax7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RzcFengshenYixuanSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("15s");
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 108:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 109:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 110:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 111:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 112:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 113:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 114:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 115:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext22), val == 1);
                    break;
                case 116:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 117:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext23), val == 1);
                    break;
                case 119:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 120:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 121:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 122:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 123:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 124:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 125:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 126:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.engine_speed);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.wc_4008_pannel_str5);
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.outside_temperature);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.engine_speed);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_4008_pannel_str5);
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.outside_temperature);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 130:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_8);
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_bright_gold);
                                break;
                            case 4:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_1);
                                break;
                            case 5:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_5);
                                break;
                            case 6:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.color_white_str);
                                break;
                            case 7:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_4);
                                break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 132:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext24), val == 1);
                    break;
                case 133:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext25), val == 1);
                    break;
                case 134:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext26), val == 1);
                    break;
                case 135:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text9)).setText("10s");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text9)).setText("15s");
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text9)).setText("20s");
                                break;
                            case 4:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text9)).setText("30s");
                                break;
                            default:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text9)).setText("10s");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 137:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 138:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 139:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 143:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 144:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_OD_RZC_FengShen_YiXuan /* 2162943 */:
                            case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX /* 2228479 */:
                            case FinalCanbus.CAR_OD_CZH_FengShen_YiXuan /* 2294015 */:
                            case FinalCanbus.CAR_OD_CZH_FengShen_22YiXuanMAX /* 2359551 */:
                            case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX_H /* 2425087 */:
                                switch (val) {
                                    case 0:
                                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_lanewar);
                                        break;
                                    case 1:
                                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_wc_174008_str1);
                                        break;
                                    case 2:
                                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_keep_lane_centered);
                                        break;
                                }
                                break;
                            default:
                                switch (val) {
                                    case 0:
                                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_lanewar);
                                        break;
                                    case 1:
                                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_wc_174008_str1);
                                        break;
                                }
                                break;
                        }
                    }
                    break;
                case 145:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 155:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext27), val == 1);
                    break;
                case 156:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.str_warning);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.str_assist);
                                break;
                            default:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 157:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext28), val == 1);
                    break;
                case 158:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext29), val == 1);
                    break;
                case 159:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext30), val == 1);
                    break;
                case 160:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext31), val == 1);
                    break;
                case 161:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext32), val == 1);
                    break;
                case 162:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text11)).setText("仅方向盘振动");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text11)).setText("声音+振动");
                                break;
                            default:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text11)).setText("仅声音报警");
                                break;
                        }
                    }
                    break;
                case 163:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext33), val == 1);
                    break;
                case 164:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext34), val == 1);
                    break;
                case 165:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext35), val == 1);
                    break;
                case 166:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext36), val == 1);
                    break;
                case 167:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext37), val == 1);
                    break;
                case 168:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext38), val == 1);
                    break;
                case 169:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext39), val == 1);
                    break;
                case 170:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext40), val == 1);
                    break;
                case 171:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext41), val == 1);
                    break;
                case 172:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext42), val == 1);
                    break;
                case 173:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text12)).setText("关闭");
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text12)).setText("不灵敏");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text12)).setText("标准");
                                break;
                        }
                    }
                    break;
                case 174:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("伸展形按摩");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("肩部按摩");
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("单排按摩");
                                break;
                            case 4:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("波浪形按摩");
                                break;
                            case 5:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("腰部按摩");
                                break;
                            case 6:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("蛇形按摩");
                                break;
                            case 7:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("蝶形按摩");
                                break;
                            default:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text13)).setText("猫步按摩");
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
        setContentView(R.layout.layout_rzc_fengshen_yixuan_setfunc);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_OD_RZC_FengShen_YiXuan /* 2162943 */:
            case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX /* 2228479 */:
            case FinalCanbus.CAR_OD_CZH_FengShen_YiXuan /* 2294015 */:
            case FinalCanbus.CAR_OD_CZH_FengShen_22YiXuanMAX /* 2359551 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
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
                break;
            case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX_H /* 2425087 */:
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
                break;
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext38), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext39), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext40), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext41), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext42), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext43), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[136] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(31, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[136] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(31, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[107] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[107] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[128];
                if (value5 > 1) {
                    value5--;
                }
                setCarInfo(23, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[128];
                if (value6 < 6) {
                    value6++;
                }
                setCarInfo(23, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[144] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_OD_RZC_FengShen_YiXuan /* 2162943 */:
                    case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX /* 2228479 */:
                    case FinalCanbus.CAR_OD_CZH_FengShen_YiXuan /* 2294015 */:
                    case FinalCanbus.CAR_OD_CZH_FengShen_22YiXuanMAX /* 2359551 */:
                    case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX_H /* 2425087 */:
                        if (value7 > 2) {
                            value7 = 0;
                        }
                        break;
                    default:
                        if (value7 > 1) {
                            value7 = 0;
                        }
                        break;
                }
                setCarInfo(40, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[126] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(14, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[127] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[130] + 1;
                if (value10 > 7) {
                    value10 = 1;
                }
                setCarInfo(25, value10);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[131] + 1;
                if (value11 > 10) {
                    value11 = 1;
                }
                setCarInfo(26, value11);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[135] + 1;
                if (value12 > 4) {
                    value12 = 1;
                }
                setCarInfo(30, value12);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value13 = DataCanbus.DATA[156] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(44, value13);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value14 = DataCanbus.DATA[162] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(48, value14);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value15 = DataCanbus.DATA[173] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(64, value15);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value16 = DataCanbus.DATA[174] + 1;
                if (value16 > 7) {
                    value16 = 0;
                }
                setCarInfo(65, value16);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value17 = DataCanbus.DATA[144] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_OD_RZC_FengShen_YiXuan /* 2162943 */:
                    case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX /* 2228479 */:
                    case FinalCanbus.CAR_OD_CZH_FengShen_YiXuan /* 2294015 */:
                    case FinalCanbus.CAR_OD_CZH_FengShen_22YiXuanMAX /* 2359551 */:
                    case FinalCanbus.CAR_OD_RZC_FengShen_22YiXuanMAX_H /* 2425087 */:
                        if (value17 < 0) {
                            value17 = 2;
                        }
                        break;
                    default:
                        if (value17 < 0) {
                            value17 = 1;
                        }
                        break;
                }
                setCarInfo(40, value17);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value18 = DataCanbus.DATA[126] - 1;
                if (value18 < 0) {
                    value18 = 3;
                }
                setCarInfo(14, value18);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value19 = DataCanbus.DATA[127] - 1;
                if (value19 < 0) {
                    value19 = 3;
                }
                setCarInfo(15, value19);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value20 = DataCanbus.DATA[130] - 1;
                if (value20 < 1) {
                    value20 = 7;
                }
                setCarInfo(25, value20);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value21 = DataCanbus.DATA[131] - 1;
                if (value21 < 1) {
                    value21 = 10;
                }
                setCarInfo(26, value21);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value22 = DataCanbus.DATA[135] - 1;
                if (value22 < 1) {
                    value22 = 4;
                }
                setCarInfo(30, value22);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value23 = DataCanbus.DATA[156] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(44, value23);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value24 = DataCanbus.DATA[162] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                setCarInfo(48, value24);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value25 = DataCanbus.DATA[173] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(64, value25);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value26 = DataCanbus.DATA[174] - 1;
                if (value26 < 0) {
                    value26 = 7;
                }
                setCarInfo(65, value26);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value27 = DataCanbus.DATA[137];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(32, value27);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value28 = DataCanbus.DATA[108];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(2, value28);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value29 = DataCanbus.DATA[109];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(3, value29);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value30 = DataCanbus.DATA[138];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(33, value30);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value31 = DataCanbus.DATA[139];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(34, value31);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value32 = DataCanbus.DATA[110];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(4, value32);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value33 = DataCanbus.DATA[113];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(7, value33);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value34 = DataCanbus.DATA[114];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(8, value34);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value35 = DataCanbus.DATA[116];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(11, value35);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value36 = DataCanbus.DATA[119];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(16, value36);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value37 = DataCanbus.DATA[120];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(17, value37);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value38 = DataCanbus.DATA[121];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(18, value38);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                int value39 = DataCanbus.DATA[122];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(19, value39);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                int value40 = DataCanbus.DATA[123];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(20, value40);
                break;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                int value41 = DataCanbus.DATA[124];
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(21, value41);
                break;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                int value42 = DataCanbus.DATA[125];
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(22, value42);
                break;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                int value43 = DataCanbus.DATA[143];
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(39, value43);
                break;
            case R.id.ctv_checkedtext26 /* 2131427715 */:
                int value44 = DataCanbus.DATA[134];
                if (value44 == 0) {
                    value44 = 1;
                } else if (value44 == 1) {
                    value44 = 0;
                }
                setCarInfo(29, value44);
                break;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                int value45 = DataCanbus.DATA[145];
                if (value45 == 0) {
                    value45 = 1;
                } else if (value45 == 1) {
                    value45 = 0;
                }
                setCarInfo(41, value45);
                break;
            case R.id.ctv_checkedtext19 /* 2131427730 */:
                dialog(R.string.xp_accord9_deflation_warning_system, 12, 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427732 */:
                int value46 = DataCanbus.DATA[111];
                if (value46 == 0) {
                    value46 = 1;
                } else if (value46 == 1) {
                    value46 = 0;
                }
                setCarInfo(5, value46);
                break;
            case R.id.ctv_checkedtext21 /* 2131427734 */:
                int value47 = DataCanbus.DATA[112];
                if (value47 == 0) {
                    value47 = 1;
                } else if (value47 == 1) {
                    value47 = 0;
                }
                setCarInfo(6, value47);
                break;
            case R.id.ctv_checkedtext22 /* 2131427736 */:
                int value48 = DataCanbus.DATA[115];
                if (value48 == 0) {
                    value48 = 1;
                } else if (value48 == 1) {
                    value48 = 0;
                }
                setCarInfo(9, value48);
                break;
            case R.id.ctv_checkedtext23 /* 2131427739 */:
                int value49 = DataCanbus.DATA[117];
                if (value49 == 0) {
                    value49 = 1;
                } else if (value49 == 1) {
                    value49 = 0;
                }
                setCarInfo(11, value49);
                break;
            case R.id.ctv_checkedtext24 /* 2131427744 */:
                int value50 = DataCanbus.DATA[132];
                if (value50 == 0) {
                    value50 = 1;
                } else if (value50 == 1) {
                    value50 = 0;
                }
                setCarInfo(27, value50);
                break;
            case R.id.ctv_checkedtext25 /* 2131427746 */:
                int value51 = DataCanbus.DATA[133];
                if (value51 == 0) {
                    value51 = 1;
                } else if (value51 == 1) {
                    value51 = 0;
                }
                setCarInfo(28, value51);
                break;
            case R.id.ctv_checkedtext27 /* 2131427748 */:
                int value52 = DataCanbus.DATA[155];
                if (value52 == 0) {
                    value52 = 1;
                } else if (value52 == 1) {
                    value52 = 0;
                }
                setCarInfo(43, value52);
                break;
            case R.id.ctv_checkedtext28 /* 2131427750 */:
                int value53 = DataCanbus.DATA[157];
                if (value53 == 0) {
                    value53 = 1;
                } else if (value53 == 1) {
                    value53 = 0;
                }
                setCarInfo(49, value53);
                break;
            case R.id.ctv_checkedtext29 /* 2131427753 */:
                int value54 = DataCanbus.DATA[158];
                if (value54 == 0) {
                    value54 = 1;
                } else if (value54 == 1) {
                    value54 = 0;
                }
                setCarInfo(45, value54);
                break;
            case R.id.ctv_checkedtext30 /* 2131427756 */:
                int value55 = DataCanbus.DATA[159];
                if (value55 == 0) {
                    value55 = 1;
                } else if (value55 == 1) {
                    value55 = 0;
                }
                setCarInfo(46, value55);
                break;
            case R.id.ctv_checkedtext31 /* 2131427758 */:
                int value56 = DataCanbus.DATA[160];
                if (value56 == 0) {
                    value56 = 1;
                } else if (value56 == 1) {
                    value56 = 0;
                }
                setCarInfo(47, value56);
                break;
            case R.id.ctv_checkedtext32 /* 2131427761 */:
                int value57 = DataCanbus.DATA[161];
                if (value57 == 0) {
                    value57 = 1;
                } else if (value57 == 1) {
                    value57 = 0;
                }
                setCarInfo(50, value57);
                break;
            case R.id.ctv_checkedtext33 /* 2131427763 */:
                int value58 = DataCanbus.DATA[163];
                if (value58 == 0) {
                    value58 = 1;
                } else if (value58 == 1) {
                    value58 = 0;
                }
                setCarInfo(58, value58);
                break;
            case R.id.ctv_checkedtext34 /* 2131427817 */:
                int value59 = DataCanbus.DATA[164];
                if (value59 == 0) {
                    value59 = 1;
                } else if (value59 == 1) {
                    value59 = 0;
                }
                setCarInfo(54, value59);
                break;
            case R.id.ctv_checkedtext35 /* 2131427818 */:
                int value60 = DataCanbus.DATA[165];
                if (value60 == 0) {
                    value60 = 1;
                } else if (value60 == 1) {
                    value60 = 0;
                }
                setCarInfo(55, value60);
                break;
            case R.id.ctv_checkedtext36 /* 2131427819 */:
                int value61 = DataCanbus.DATA[166];
                if (value61 == 0) {
                    value61 = 1;
                } else if (value61 == 1) {
                    value61 = 0;
                }
                setCarInfo(56, value61);
                break;
            case R.id.ctv_checkedtext37 /* 2131427830 */:
                int value62 = DataCanbus.DATA[167];
                if (value62 == 0) {
                    value62 = 1;
                } else if (value62 == 1) {
                    value62 = 0;
                }
                setCarInfo(57, value62);
                break;
            case R.id.ctv_checkedtext38 /* 2131427831 */:
                int value63 = DataCanbus.DATA[168];
                if (value63 == 0) {
                    value63 = 1;
                } else if (value63 == 1) {
                    value63 = 0;
                }
                setCarInfo(59, value63);
                break;
            case R.id.ctv_checkedtext39 /* 2131427832 */:
                int value64 = DataCanbus.DATA[169];
                if (value64 == 0) {
                    value64 = 1;
                } else if (value64 == 1) {
                    value64 = 0;
                }
                setCarInfo(60, value64);
                break;
            case R.id.ctv_checkedtext40 /* 2131427833 */:
                int value65 = DataCanbus.DATA[170];
                if (value65 == 0) {
                    value65 = 1;
                } else if (value65 == 1) {
                    value65 = 0;
                }
                setCarInfo(61, value65);
                break;
            case R.id.ctv_checkedtext41 /* 2131427834 */:
                int value66 = DataCanbus.DATA[171];
                if (value66 == 0) {
                    value66 = 1;
                } else if (value66 == 1) {
                    value66 = 0;
                }
                setCarInfo(62, value66);
                break;
            case R.id.ctv_checkedtext42 /* 2131427835 */:
                int value67 = DataCanbus.DATA[172];
                if (value67 == 0) {
                    value67 = 1;
                } else if (value67 == 1) {
                    value67 = 0;
                }
                setCarInfo(63, value67);
                break;
            case R.id.ctv_checkedtext43 /* 2131427836 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RzcFengshenX37SetFunc.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd, final int cmdid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmdid;
                final int i2 = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
