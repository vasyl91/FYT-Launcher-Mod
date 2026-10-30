package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZFordQuanshunT8RS485CarInfo extends BaseActivity implements View.OnClickListener {
    int pagenum = 0;
    int frontstate = 0;
    int rearstate = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZFordQuanshunT8RS485CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 128:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 129:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value / 10) + "℃");
                    break;
                case 130:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value) + "%");
                    break;
                case 131:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Mpa");
                    if (value != 0) {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view12).setVisibility(0);
                    } else {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view12).setVisibility(8);
                    }
                    switch (value / 10) {
                        case 0:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_0);
                            break;
                        case 1:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_1);
                            break;
                        case 2:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_2);
                            break;
                        case 3:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_3);
                            break;
                        case 4:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_4);
                            break;
                        case 5:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_5);
                            break;
                        case 6:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_6);
                            break;
                        case 7:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_7);
                            break;
                        case 8:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_8);
                            break;
                        case 9:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_9);
                            break;
                        case 10:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_10);
                            break;
                        case 11:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_11);
                            break;
                        case 12:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_12);
                            break;
                        case 13:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_13);
                            break;
                        case 14:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_14);
                            break;
                        case 15:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_15);
                            break;
                    }
                    break;
                case 132:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "Mpa");
                    if (value != 0) {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view13).setVisibility(0);
                    } else {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view13).setVisibility(8);
                    }
                    switch (value / 10) {
                        case 0:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_0);
                            break;
                        case 1:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_1);
                            break;
                        case 2:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_2);
                            break;
                        case 3:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_3);
                            break;
                        case 4:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_4);
                            break;
                        case 5:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_5);
                            break;
                        case 6:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_6);
                            break;
                        case 7:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_7);
                            break;
                        case 8:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_8);
                            break;
                        case 9:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_9);
                            break;
                        case 10:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_10);
                            break;
                        case 11:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_11);
                            break;
                        case 12:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_12);
                            break;
                        case 13:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_13);
                            break;
                        case 14:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_14);
                            break;
                        case 15:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_quanshunt8_yangqiping_15);
                            break;
                    }
                    break;
                case 133:
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text3)).setText("-" + value2);
                        ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text16)).setText("-" + value2 + "Pa");
                    } else {
                        ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + "Pa");
                    }
                    break;
                case 134:
                    int h1 = ((value >> 8) & 255) / 10;
                    int h2 = ((value >> 8) & 255) % 10;
                    int m1 = (value & 255) / 10;
                    int m2 = (value & 255) % 10;
                    LZFordQuanshunT8RS485CarInfo.this.updateNum(R.id.layout_view3, h1);
                    LZFordQuanshunT8RS485CarInfo.this.updateNum(R.id.layout_view4, h2);
                    LZFordQuanshunT8RS485CarInfo.this.updateNum(R.id.layout_view5, m1);
                    LZFordQuanshunT8RS485CarInfo.this.updateNum(R.id.layout_view6, m2);
                    break;
                case 135:
                    int coldstate = (value >> 7) & 1;
                    int hotstate = (value >> 6) & 1;
                    if (coldstate == 1 || hotstate == 1) {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_quanshunt8_air_p);
                    } else {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_quanshunt8_air_n);
                    }
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus28).setBackgroundResource(coldstate == 1 ? R.drawable.ic_quanshunt8_cold_p : R.drawable.ic_quanshunt8_cold_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus29).setBackgroundResource(hotstate == 1 ? R.drawable.ic_quanshunt8_hot_p : R.drawable.ic_quanshunt8_hot_n);
                    break;
                case 136:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text9)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text10)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text11)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text12)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text13)).setTextColor(-1);
                    switch (value) {
                        case 1:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text9)).setTextColor(-16776961);
                            break;
                        case 2:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text10)).setTextColor(-16776961);
                            break;
                        case 3:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text11)).setTextColor(-16776961);
                            break;
                        case 4:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text12)).setTextColor(-16776961);
                            break;
                        case 5:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text13)).setTextColor(-16776961);
                            break;
                    }
                    break;
                case 137:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text19)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text20)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text21)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text22)).setTextColor(-1);
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text23)).setTextColor(-1);
                    switch (value) {
                        case 1:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text19)).setTextColor(-65536);
                            break;
                        case 2:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text20)).setTextColor(-65536);
                            break;
                        case 3:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text21)).setTextColor(-65536);
                            break;
                        case 4:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text22)).setTextColor(-65536);
                            break;
                        case 5:
                            ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text23)).setTextColor(-65536);
                            break;
                    }
                    break;
                case 138:
                    if (value < 1) {
                        value = 1;
                    }
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view8).layout((value - 1) * 44, 3, ((value - 1) * 44) + 36, 39);
                    break;
                case 140:
                    int bit7 = (value >> 7) & 1;
                    int bit6 = (value >> 6) & 1;
                    int bit5 = (value >> 5) & 1;
                    int bit4 = (value >> 4) & 1;
                    int bit3 = (value >> 3) & 1;
                    int bit2 = (value >> 2) & 1;
                    int bit1 = (value >> 1) & 1;
                    int bit0 = (value >> 0) & 1;
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus5).setBackgroundResource(bit7 == 1 ? R.drawable.ic_quanshunt8_jinqi_p : R.drawable.ic_quanshunt8_jinqi_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus6).setBackgroundResource(bit6 == 1 ? R.drawable.ic_quanshunt8_paiqi_p : R.drawable.ic_quanshunt8_paiqi_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus7).setBackgroundResource(bit5 == 1 ? R.drawable.ic_quanshunt8_duijiang_p : R.drawable.ic_quanshunt8_duijiang_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus13).setBackgroundResource(bit2 == 1 ? R.drawable.ic_quanshunt8_zhuanyun_p : R.drawable.ic_quanshunt8_zhuanyun_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(bit1 == 1 ? R.drawable.ic_quanshunt8_shotlight_p : R.drawable.ic_quanshunt8_shotlight_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(bit0 == 1 ? R.drawable.ic_quanshunt8_outlight_p : R.drawable.ic_quanshunt8_outlight_n);
                    if (bit4 == 1) {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_quanshunt8_warn2);
                    } else if (bit3 == 1) {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_quanshunt8_warn1);
                    } else {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_jaguar_null);
                    }
                    break;
                case 141:
                    int bit8 = (value >> 7) & 1;
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus8).setBackgroundResource(bit8 == 1 ? R.drawable.ic_quanshunt8_nibianqi_p : R.drawable.ic_quanshunt8_nibianqi_n);
                    break;
                case 142:
                case 143:
                    if (DataCanbus.DATA[142] != 0) {
                        ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text15)).setText(String.valueOf(DataCanbus.DATA[142]) + "V");
                    } else {
                        ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text15)).setText(String.valueOf(DataCanbus.DATA[143]) + "V");
                    }
                    break;
                case 144:
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus12).setBackgroundResource(value == 1 ? R.drawable.ic_quanshunt8_fuya_p : R.drawable.ic_quanshunt8_fuya_n);
                    break;
                case 145:
                    switch (value) {
                        case 0:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji0);
                            break;
                        case 1:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji1);
                            break;
                        case 2:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji2);
                            break;
                        case 3:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji3);
                            break;
                        case 4:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji4);
                            break;
                        case 5:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji5);
                            break;
                        case 6:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji6);
                            break;
                        case 7:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji7);
                            break;
                        case 8:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji8);
                            break;
                        case 9:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji9);
                            break;
                        case 10:
                            LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.layout_view11).setBackgroundResource(R.drawable.ic_quanshunt8_fuyadengji10);
                            break;
                    }
                    break;
                case 146:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 147:
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 148:
                    int bit9 = (value >> 7) & 1;
                    int bit10 = (value >> 6) & 1;
                    int bit11 = (value >> 5) & 1;
                    int bit12 = (value >> 4) & 1;
                    if (bit9 == 1 || bit10 == 1) {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_quanshunt8_xiaodu_p);
                    } else {
                        LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_quanshunt8_xiaodu_n);
                    }
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus20).setBackgroundResource(bit9 == 1 ? R.drawable.ic_quanshunt8_xiaodudeng1_p : R.drawable.ic_quanshunt8_xiaodudeng1_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus24).setBackgroundResource(bit10 == 1 ? R.drawable.ic_quanshunt8_xiaodudeng2_p : R.drawable.ic_quanshunt8_xiaodudeng2_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus23).setBackgroundResource(bit11 == 0 ? R.drawable.ic_btn_quanshunt8_enter_n : R.drawable.ic_btn_quanshunt8_stop_n);
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus27).setBackgroundResource(bit12 == 0 ? R.drawable.ic_btn_quanshunt8_enter_n : R.drawable.ic_btn_quanshunt8_stop_n);
                    break;
                case 149:
                    int m3 = ((value >> 8) & 255) / 10;
                    int m4 = ((value >> 8) & 255) % 10;
                    int s1 = (value & 255) / 10;
                    int s2 = (value & 255) % 10;
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(m3) + m4 + ":" + s1 + s2);
                    break;
                case 150:
                    int m5 = ((value >> 8) & 255) / 10;
                    int m6 = ((value >> 8) & 255) % 10;
                    int s3 = (value & 255) / 10;
                    int s4 = (value & 255) % 10;
                    ((TextView) LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(m5) + m6 + ":" + s3 + s4);
                    break;
                case 151:
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus1).setBackgroundResource(value == 1 ? R.drawable.ic_quanshunt8_frontlight_p : R.drawable.ic_quanshunt8_frontlight_n);
                    break;
                case 152:
                    if (LZFordQuanshunT8RS485CarInfo.this.pagenum == 2) {
                        LZFordQuanshunT8RS485CarInfo.this.updateLightLev(value);
                    }
                    break;
                case 153:
                    LZFordQuanshunT8RS485CarInfo.this.findViewById(R.id.btn_plus2).setBackgroundResource(value == 1 ? R.drawable.ic_quanshunt8_rearlight_p : R.drawable.ic_quanshunt8_rearlight_n);
                    break;
                case 154:
                    if (LZFordQuanshunT8RS485CarInfo.this.pagenum == 3) {
                        LZFordQuanshunT8RS485CarInfo.this.updateLightLev(value);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_quanshunt8_rs485_carinfo);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
        setSelfClick(findViewById(R.id.btn_plus9), this);
        setSelfClick(findViewById(R.id.btn_plus10), this);
        setSelfClick(findViewById(R.id.btn_plus11), this);
        setSelfClick(findViewById(R.id.btn_plus12), this);
        setSelfClick(findViewById(R.id.btn_plus13), this);
        setSelfClick(findViewById(R.id.btn_plus14), this);
        setSelfClick(findViewById(R.id.btn_plus15), this);
        setSelfClick(findViewById(R.id.btn_plus16), this);
        setSelfClick(findViewById(R.id.btn_plus17), this);
        setSelfClick(findViewById(R.id.btn_plus18), this);
        setSelfClick(findViewById(R.id.btn_plus19), this);
        setSelfClick(findViewById(R.id.btn_plus20), this);
        setSelfClick(findViewById(R.id.btn_plus21), this);
        setSelfClick(findViewById(R.id.btn_plus22), this);
        setSelfClick(findViewById(R.id.btn_plus23), this);
        setSelfClick(findViewById(R.id.btn_plus24), this);
        setSelfClick(findViewById(R.id.btn_plus25), this);
        setSelfClick(findViewById(R.id.btn_plus26), this);
        setSelfClick(findViewById(R.id.btn_plus27), this);
        setSelfClick(findViewById(R.id.btn_plus28), this);
        setSelfClick(findViewById(R.id.btn_plus29), this);
        setSelfClick(findViewById(R.id.btn_plus30), this);
        setSelfClick(findViewById(R.id.btn_plus31), this);
        setSelfClick(findViewById(R.id.btn_plus32), this);
        setSelfClick(findViewById(R.id.tv_text9), this);
        setSelfClick(findViewById(R.id.tv_text10), this);
        setSelfClick(findViewById(R.id.tv_text11), this);
        setSelfClick(findViewById(R.id.tv_text12), this);
        setSelfClick(findViewById(R.id.tv_text13), this);
        setSelfClick(findViewById(R.id.tv_text19), this);
        setSelfClick(findViewById(R.id.tv_text20), this);
        setSelfClick(findViewById(R.id.tv_text21), this);
        setSelfClick(findViewById(R.id.tv_text22), this);
        setSelfClick(findViewById(R.id.tv_text23), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        this.pagenum = 0;
        updatePage(this.pagenum);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427458 */:
                this.pagenum = 2;
                updatePage(this.pagenum);
                updateLightLev(DataCanbus.DATA[152]);
                DataCanbus.PROXY.cmd(3, new int[]{1, 11}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                this.pagenum = 3;
                updatePage(this.pagenum);
                updateLightLev(DataCanbus.DATA[154]);
                DataCanbus.PROXY.cmd(3, new int[]{1, 12}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 10}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 9}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 17}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 18}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 26}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 15}, null, null);
                break;
            case R.id.tv_text9 /* 2131427481 */:
                DataCanbus.PROXY.cmd(3, new int[]{2, 1}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                this.pagenum = 6;
                updatePage(this.pagenum);
                break;
            case R.id.tv_text10 /* 2131427484 */:
                DataCanbus.PROXY.cmd(3, new int[]{2, 2}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                this.pagenum = 5;
                updatePage(this.pagenum);
                break;
            case R.id.tv_text11 /* 2131427487 */:
                DataCanbus.PROXY.cmd(3, new int[]{2, 3}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 34}, null, null);
                break;
            case R.id.tv_text12 /* 2131427490 */:
                DataCanbus.PROXY.cmd(3, new int[]{2, 4}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                this.pagenum = 4;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 19}, null, null);
                break;
            case R.id.tv_text13 /* 2131427493 */:
                DataCanbus.PROXY.cmd(3, new int[]{2, 5}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                this.pagenum = 1;
                updatePage(this.pagenum);
                DataCanbus.PROXY.cmd(3, new int[]{1, 8}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                if (this.pagenum == 2) {
                    int value = DataCanbus.DATA[152];
                    if (value > 0) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{5, value}, null, null);
                } else if (this.pagenum == 3) {
                    int value2 = DataCanbus.DATA[154];
                    if (value2 > 0) {
                        value2--;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{6, value2}, null, null);
                }
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                if (this.pagenum == 2) {
                    int value3 = DataCanbus.DATA[152];
                    if (value3 < 8) {
                        value3++;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{5, value3}, null, null);
                } else if (this.pagenum == 3) {
                    int value4 = DataCanbus.DATA[154];
                    if (value4 < 8) {
                        value4++;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{6, value4}, null, null);
                }
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 19}, null, null);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 21}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 20}, null, null);
                break;
            case R.id.tv_text19 /* 2131427583 */:
                DataCanbus.PROXY.cmd(3, new int[]{3, 1}, null, null);
                break;
            case R.id.tv_text20 /* 2131427584 */:
                DataCanbus.PROXY.cmd(3, new int[]{3, 2}, null, null);
                break;
            case R.id.tv_text21 /* 2131427585 */:
                DataCanbus.PROXY.cmd(3, new int[]{3, 3}, null, null);
                break;
            case R.id.tv_text22 /* 2131427586 */:
                DataCanbus.PROXY.cmd(3, new int[]{3, 4}, null, null);
                break;
            case R.id.tv_text23 /* 2131427587 */:
                DataCanbus.PROXY.cmd(3, new int[]{3, 5}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 27}, null, null);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 22}, null, null);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int bit5 = (DataCanbus.DATA[148] >> 5) & 1;
                if (bit5 == 0) {
                    int min = (DataCanbus.DATA[149] >> 8) & 255;
                    if (min > 0) {
                        min--;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{4, min}, null, null);
                }
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int bit6 = (DataCanbus.DATA[148] >> 5) & 1;
                if (bit6 == 0) {
                    int min2 = (DataCanbus.DATA[149] >> 8) & 255;
                    if (min2 < 255) {
                        min2++;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{4, min2}, null, null);
                }
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 23}, null, null);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 24}, null, null);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int bit4 = (DataCanbus.DATA[148] >> 4) & 1;
                if (bit4 == 0) {
                    int min3 = (DataCanbus.DATA[150] >> 8) & 255;
                    if (min3 > 0) {
                        min3--;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{7, min3}, null, null);
                }
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                int bit7 = (DataCanbus.DATA[148] >> 4) & 1;
                if (bit7 == 0) {
                    int min4 = (DataCanbus.DATA[150] >> 8) & 255;
                    if (min4 < 255) {
                        min4++;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{7, min4}, null, null);
                }
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 25}, null, null);
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 1}, null, null);
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 4}, null, null);
                break;
            case R.id.btn_plus30 /* 2131427632 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 36}, null, null);
                break;
            case R.id.btn_plus31 /* 2131427829 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 35}, null, null);
                break;
            case R.id.btn_plus32 /* 2131427831 */:
                this.pagenum = 0;
                updatePage(this.pagenum);
                break;
        }
    }

    void updatePage(int num) {
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.btn_plus32).setVisibility(num != 0 ? 0 : 8);
        switch (num) {
            case 0:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                break;
            case 1:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                break;
            case 2:
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setBackgroundResource(R.drawable.ic_quanshunt8_liangdutiaojie);
                break;
            case 3:
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setBackgroundResource(R.drawable.ic_quanshunt8_liangdutiaojie_r);
                break;
            case 4:
                findViewById(R.id.layout_text_view4).setVisibility(0);
                break;
            case 5:
                findViewById(R.id.layout_text_view5).setVisibility(0);
                break;
            case 6:
                findViewById(R.id.layout_text_view6).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                break;
        }
    }

    void updateLightLev(int num) {
        switch (num) {
            case 0:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_0);
                break;
            case 1:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_1);
                break;
            case 2:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_2);
                break;
            case 3:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_3);
                break;
            case 4:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_4);
                break;
            case 5:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_5);
                break;
            case 6:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_6);
                break;
            case 7:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_7);
                break;
            case 8:
                findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_quanshunt8_liangdu_8);
                break;
        }
    }

    void updateNum(int id, int value) {
        switch (value) {
            case 0:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n0);
                break;
            case 1:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n1);
                break;
            case 2:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n2);
                break;
            case 3:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n3);
                break;
            case 4:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n4);
                break;
            case 5:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n5);
                break;
            case 6:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n6);
                break;
            case 7:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n7);
                break;
            case 8:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n8);
                break;
            case 9:
                findViewById(id).setBackgroundResource(R.drawable.ic_quanshunt8_n9);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
    }
}
