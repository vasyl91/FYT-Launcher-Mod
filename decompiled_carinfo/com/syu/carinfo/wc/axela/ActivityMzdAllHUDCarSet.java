package com.syu.carinfo.wc.axela;

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
import com.syu.carinfo.mzd.MzdAllM3ClockSetActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityMzdAllHUDCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode] & 255;
            int show = (DataCanbus.DATA[updateCode] >> 8) & 255;
            switch (updateCode) {
                case 107:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view6).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text5)).setText("Driving lock");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text5)).setText("Driving lock,Flameout unlock");
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text5)).setText("Quit P lock");
                            break;
                        case 4:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text5)).setText("Quit P lock, enter P unlock");
                            break;
                        case 5:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text5)).setText("Driving lock, stop unlock");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                    }
                case 108:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view7).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text6)).setText("30min");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text6)).setText("60min");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text6)).setText("10min");
                            break;
                    }
                case 109:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view8).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 110:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view9).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                    }
                case 111:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view10).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text8)).setText("90S");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text8)).setText("60S");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text8)).setText("30S");
                            break;
                    }
                case 112:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view11).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text9)).setText("Once driver,Twice all");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text9)).setText("Once all");
                            break;
                    }
                case 113:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view12).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 114:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view13).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                            break;
                    }
                case 115:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view14).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 116:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view15).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text11)).setText("15S");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text11)).setText("30S");
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text11)).setText("60S");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text11)).setText("7.5S");
                            break;
                    }
                case 117:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view16).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text12)).setText("Bright");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text12)).setText("Slightly bright");
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text12)).setText("Normal");
                            break;
                        case 4:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text12)).setText("Dim");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text12)).setText("dark");
                            break;
                    }
                case 118:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view17).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                            break;
                    }
                case 119:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view18).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 120:
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 121:
                    ActivityMzdAllHUDCarSet.this.updateText1(val);
                    break;
                case 122:
                    ActivityMzdAllHUDCarSet.this.updateText2(val);
                    break;
                case 123:
                    ActivityMzdAllHUDCarSet.this.updateText3(val);
                    break;
                case 124:
                    ActivityMzdAllHUDCarSet.this.updateText4(val);
                    break;
                case 125:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view19).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 126:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view20).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 127:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view21).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 128:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view22).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 129:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view23).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 130:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view24).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 131:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view25).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 132:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view26).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                            break;
                    }
                case 133:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view27).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text15)).setText("30S");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text15)).setText("60S");
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text15)).setText("90S");
                            break;
                        case 4:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text15)).setText("120S");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                            break;
                    }
                case 134:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view28).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 135:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view29).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                    }
                case 136:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view30).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text17)).setText(R.string.off);
                            break;
                    }
                case 137:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view31).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 138:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view32).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 139:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view33).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text18)).setText(R.string.off);
                            break;
                    }
                case 140:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view36).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text20)).setText("5Km");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text20)).setText("10Km");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text20)).setText("0Km");
                            break;
                    }
                case 141:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view35).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text19)).setText("Vision");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text19)).setText("Sound+Vision");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.off);
                            break;
                    }
                case 142:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view34).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 143:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view37).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text21)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text21)).setText("Rarely");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text21)).setText("often");
                            break;
                    }
                case 144:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view38).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text22)).setText("Beforehand");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text22)).setText(R.string.driver_system_standard);
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text22)).setText("Delay");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text22)).setText("Auto");
                            break;
                    }
                case 145:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view39).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text23)).setText("rumble");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text23)).setText("BiBi");
                            break;
                    }
                case 146:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view40).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_low);
                            break;
                    }
                case 147:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view41).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text25)).setText(R.string.klc_air_low);
                            break;
                    }
                case 148:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view42).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 149:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view43).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 150:
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text33)).setText(R.string.jeep_format_set0);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text33)).setText(R.string.jeep_format_set1);
                            break;
                    }
                case 151:
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text34)).setText("℉");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text34)).setText("℃");
                            break;
                    }
                case 152:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view44).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 153:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view45).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text26)).setText("continuous");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text26)).setText("Automatic shutdown");
                            break;
                    }
                case 154:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view46).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text27)).setText("Type1");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text27)).setText("Type2");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.off);
                            break;
                    }
                case 155:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view47).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text28)).setText("Vision");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text28)).setText("Sound+Vision");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text28)).setText(R.string.off);
                            break;
                    }
                case 156:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view48).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 157:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view49).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text29)).setText(R.string.driver_system_standard);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text29)).setText("Delay");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text29)).setText("Beforehand");
                            break;
                    }
                case 158:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view50).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 159:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view51).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text30)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text30)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text30)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text30)).setText(R.string.off);
                            break;
                    }
                case 160:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view52).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text31)).setText("30S");
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text31)).setText("60S");
                            break;
                        case 3:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text31)).setText("90S");
                            break;
                        case 4:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text31)).setText("120S");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text31)).setText(R.string.off);
                            break;
                    }
                case 161:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view53).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text32)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text32)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text32)).setText(R.string.klc_air_low);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_mzd_hud_settings);
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
                ActivityMzdAllHUDCarSet.this.language_set = position;
                if (ActivityMzdAllHUDCarSet.this.language_set >= 0 && ActivityMzdAllHUDCarSet.this.language_set <= ActivityMzdAllHUDCarSet.this.mLauStylelist.size() && ActivityMzdAllHUDCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(9, new int[]{1, ActivityMzdAllHUDCarSet.this.send_lang[ActivityMzdAllHUDCarSet.this.language_set]}, null, null);
                }
                ActivityMzdAllHUDCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add("Viet");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.mLauStylelist.add("Indonesia");
        this.mLauStylelist.add("Malaysia");
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15, 16, 18, 19, 23, 24, 25, 26, 27, 30, 35, 42, 43};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ActivityMzdAllHUDCarSet.this.mLauStyle == null) {
                    ActivityMzdAllHUDCarSet.this.initLauStyle();
                }
                if (ActivityMzdAllHUDCarSet.this.mLauStyle != null && ActivityMzdAllHUDCarSet.this.mPopShowView != null) {
                    ActivityMzdAllHUDCarSet.this.mLauStyle.showAtLocation(ActivityMzdAllHUDCarSet.this.mPopShowView, 17, 0, 0);
                    ActivityMzdAllHUDCarSet.this.updateLauguageSet();
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
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_minus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
        setSelfClick((Button) findViewById(R.id.btn_minus30), this);
        setSelfClick((Button) findViewById(R.id.btn_plus30), this);
        setSelfClick((Button) findViewById(R.id.btn_minus31), this);
        setSelfClick((Button) findViewById(R.id.btn_plus31), this);
        setSelfClick((Button) findViewById(R.id.btn_minus32), this);
        setSelfClick((Button) findViewById(R.id.btn_plus32), this);
        setSelfClick((Button) findViewById(R.id.btn_minus33), this);
        setSelfClick((Button) findViewById(R.id.btn_plus33), this);
        setSelfClick((Button) findViewById(R.id.btn_minus34), this);
        setSelfClick((Button) findViewById(R.id.btn_plus34), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M6 /* 393659 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M3 /* 459195 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M5 /* 524731 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M8 /* 590267 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX7_H /* 655803 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M7 /* 852411 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX7_L /* 1049019 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M6_Ruiyi /* 15663547 */:
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
            default:
                findViewById(R.id.layout_view54).setVisibility(8);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[121] & 255;
                if (value > 0) {
                    value--;
                }
                setCarInfo(53, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 < 30) {
                    value2++;
                }
                setCarInfo(53, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = (DataCanbus.DATA[122] & 255) - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(56, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = (DataCanbus.DATA[122] & 255) + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(56, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[123] & 255;
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(54, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[123] & 255;
                if (value6 < 10) {
                    value6++;
                }
                setCarInfo(54, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[124] & 255;
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(55, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[124] & 255;
                if (value8 < 10) {
                    value8++;
                }
                setCarInfo(55, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[107] & 255;
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(1, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[107] & 255;
                if (value10 < 4) {
                    value10++;
                }
                setCarInfo(1, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[108] & 255;
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(2, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[108] & 255;
                if (value12 < 2) {
                    value12++;
                }
                setCarInfo(2, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[110] & 255;
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[110] & 255;
                if (value14 < 3) {
                    value14++;
                }
                setCarInfo(4, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[111] & 255;
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(5, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[111] & 255;
                if (value16 < 2) {
                    value16++;
                }
                setCarInfo(5, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[112] & 255;
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo(6, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[112] & 255;
                if (value18 < 1) {
                    value18++;
                }
                setCarInfo(6, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[114] & 255;
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo(8, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[114] & 255;
                if (value20 < 1) {
                    value20++;
                }
                setCarInfo(8, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[116] & 255;
                if (value21 > 0) {
                    value21--;
                }
                setCarInfo(10, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[116] & 255;
                if (value22 < 3) {
                    value22++;
                }
                setCarInfo(10, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[117] & 255;
                if (value23 > 0) {
                    value23--;
                }
                setCarInfo(11, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[117] & 255;
                if (value24 < 4) {
                    value24++;
                }
                setCarInfo(11, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[118] & 255;
                if (value25 > 0) {
                    value25--;
                }
                setCarInfo(12, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[118] & 255;
                if (value26 < 2) {
                    value26++;
                }
                setCarInfo(12, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[132] & 255;
                if (value27 > 0) {
                    value27--;
                }
                setCarInfo(19, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[132] & 255;
                if (value28 < 2) {
                    value28++;
                }
                setCarInfo(19, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[133] & 255;
                if (value29 > 0) {
                    value29--;
                }
                setCarInfo(20, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[133] & 255;
                if (value30 < 4) {
                    value30++;
                }
                setCarInfo(20, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[135] & 255;
                if (value31 > 0) {
                    value31--;
                }
                setCarInfo(22, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[135] & 255;
                if (value32 < 1) {
                    value32++;
                }
                setCarInfo(22, value32);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = DataCanbus.DATA[136] & 255;
                if (value33 > 0) {
                    value33--;
                }
                setCarInfo(23, value33);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = DataCanbus.DATA[136] & 255;
                if (value34 < 2) {
                    value34++;
                }
                setCarInfo(23, value34);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value35 = DataCanbus.DATA[120] & 255;
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(52, value35);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value36 = DataCanbus.DATA[109] & 255;
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(3, value36);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value37 = DataCanbus.DATA[113] & 255;
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(7, value37);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value38 = DataCanbus.DATA[115] & 255;
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(9, value38);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value39 = DataCanbus.DATA[119] & 255;
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(13, value39);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value40 = DataCanbus.DATA[125] & 255;
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(45, value40);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value41 = DataCanbus.DATA[126] & 255;
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(27, value41);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value42 = DataCanbus.DATA[127] & 255;
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(14, value42);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value43 = DataCanbus.DATA[128] & 255;
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(15, value43);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value44 = DataCanbus.DATA[129] & 255;
                if (value44 == 0) {
                    value44 = 1;
                } else if (value44 == 1) {
                    value44 = 0;
                }
                setCarInfo(16, value44);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value45 = DataCanbus.DATA[130] & 255;
                if (value45 == 0) {
                    value45 = 1;
                } else if (value45 == 1) {
                    value45 = 0;
                }
                setCarInfo(17, value45);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value46 = DataCanbus.DATA[131] & 255;
                if (value46 == 0) {
                    value46 = 1;
                } else if (value46 == 1) {
                    value46 = 0;
                }
                setCarInfo(18, value46);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value47 = DataCanbus.DATA[134] & 255;
                if (value47 == 0) {
                    value47 = 1;
                } else if (value47 == 1) {
                    value47 = 0;
                }
                setCarInfo(21, value47);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value48 = DataCanbus.DATA[137] & 255;
                if (value48 == 0) {
                    value48 = 1;
                } else if (value48 == 1) {
                    value48 = 0;
                }
                setCarInfo(46, value48);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value49 = DataCanbus.DATA[138] & 255;
                if (value49 == 0) {
                    value49 = 1;
                } else if (value49 == 1) {
                    value49 = 0;
                }
                setCarInfo(24, value49);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value50 = DataCanbus.DATA[142] & 255;
                if (value50 == 0) {
                    value50 = 1;
                } else if (value50 == 1) {
                    value50 = 0;
                }
                setCarInfo(28, value50);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value51 = DataCanbus.DATA[148] & 255;
                if (value51 == 0) {
                    value51 = 1;
                } else if (value51 == 1) {
                    value51 = 0;
                }
                setCarInfo(36, value51);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value52 = DataCanbus.DATA[149] & 255;
                if (value52 == 0) {
                    value52 = 1;
                } else if (value52 == 1) {
                    value52 = 0;
                }
                setCarInfo(37, value52);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value53 = DataCanbus.DATA[152] & 255;
                if (value53 == 0) {
                    value53 = 1;
                } else if (value53 == 1) {
                    value53 = 0;
                }
                setCarInfo(47, value53);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value54 = DataCanbus.DATA[156] & 255;
                if (value54 == 0) {
                    value54 = 1;
                } else if (value54 == 1) {
                    value54 = 0;
                }
                setCarInfo(41, value54);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value55 = DataCanbus.DATA[158] & 255;
                if (value55 == 0) {
                    value55 = 1;
                } else if (value55 == 1) {
                    value55 = 0;
                }
                setCarInfo(43, value55);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, MzdAllM3ClockSetActi.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_minus18 /* 2131427894 */:
                int value56 = DataCanbus.DATA[139] & 255;
                if (value56 > 0) {
                    value56--;
                }
                setCarInfo(25, value56);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value57 = DataCanbus.DATA[139] & 255;
                if (value57 < 2) {
                    value57++;
                }
                setCarInfo(25, value57);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value58 = DataCanbus.DATA[141] & 255;
                if (value58 > 0) {
                    value58--;
                }
                setCarInfo(29, value58);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value59 = DataCanbus.DATA[141] & 255;
                if (value59 < 2) {
                    value59++;
                }
                setCarInfo(29, value59);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value60 = DataCanbus.DATA[143] & 255;
                if (value60 > 0) {
                    value60--;
                }
                setCarInfo(31, value60);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value61 = DataCanbus.DATA[143] & 255;
                if (value61 < 2) {
                    value61++;
                }
                setCarInfo(31, value61);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                int value62 = DataCanbus.DATA[144] & 255;
                if (value62 > 0) {
                    value62--;
                }
                setCarInfo(32, value62);
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                int value63 = DataCanbus.DATA[144] & 255;
                if (value63 < 3) {
                    value63++;
                }
                setCarInfo(32, value63);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value64 = DataCanbus.DATA[140] & 255;
                if (value64 > 0) {
                    value64--;
                }
                setCarInfo(30, value64);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value65 = DataCanbus.DATA[140] & 255;
                if (value65 < 2) {
                    value65++;
                }
                setCarInfo(30, value65);
                break;
            case R.id.btn_plus25 /* 2131427926 */:
                int value66 = DataCanbus.DATA[147] & 255;
                if (value66 < 2) {
                    value66++;
                }
                setCarInfo(35, value66);
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                int value67 = DataCanbus.DATA[146] & 255;
                if (value67 < 1) {
                    value67++;
                }
                setCarInfo(34, value67);
                break;
            case R.id.btn_plus26 /* 2131427928 */:
                int value68 = DataCanbus.DATA[153] & 255;
                if (value68 < 1) {
                    value68++;
                }
                setCarInfo(48, value68);
                break;
            case R.id.btn_plus27 /* 2131427929 */:
                int value69 = DataCanbus.DATA[154] & 255;
                if (value69 < 2) {
                    value69++;
                }
                setCarInfo(50, value69);
                break;
            case R.id.btn_plus28 /* 2131427930 */:
                int value70 = DataCanbus.DATA[155] & 255;
                if (value70 < 2) {
                    value70++;
                }
                setCarInfo(40, value70);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value71 = DataCanbus.DATA[145] & 255;
                if (value71 < 1) {
                    value71++;
                }
                setCarInfo(33, value71);
                break;
            case R.id.btn_minus28 /* 2131428300 */:
                int value72 = DataCanbus.DATA[155] & 255;
                if (value72 > 0) {
                    value72--;
                }
                setCarInfo(40, value72);
                break;
            case R.id.btn_minus29 /* 2131428301 */:
                int value73 = DataCanbus.DATA[157] & 255;
                if (value73 > 0) {
                    value73--;
                }
                setCarInfo(42, value73);
                break;
            case R.id.btn_plus29 /* 2131428302 */:
                int value74 = DataCanbus.DATA[157] & 255;
                if (value74 < 2) {
                    value74++;
                }
                setCarInfo(42, value74);
                break;
            case R.id.btn_minus25 /* 2131428303 */:
                int value75 = DataCanbus.DATA[147] & 255;
                if (value75 > 0) {
                    value75--;
                }
                setCarInfo(35, value75);
                break;
            case R.id.btn_minus26 /* 2131428304 */:
                int value76 = DataCanbus.DATA[153] & 255;
                if (value76 > 0) {
                    value76--;
                }
                setCarInfo(48, value76);
                break;
            case R.id.btn_minus27 /* 2131428305 */:
                int value77 = DataCanbus.DATA[154] & 255;
                if (value77 > 0) {
                    value77--;
                }
                setCarInfo(50, value77);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value78 = DataCanbus.DATA[145] & 255;
                if (value78 > 0) {
                    value78--;
                }
                setCarInfo(33, value78);
                break;
            case R.id.btn_minus24 /* 2131428307 */:
                int value79 = DataCanbus.DATA[146] & 255;
                if (value79 > 0) {
                    value79--;
                }
                setCarInfo(34, value79);
                break;
            case R.id.btn_minus30 /* 2131428365 */:
                int value80 = DataCanbus.DATA[159] & 255;
                if (value80 > 0) {
                    value80--;
                }
                setCarInfo(44, value80);
                break;
            case R.id.btn_plus30 /* 2131428366 */:
                int value81 = DataCanbus.DATA[159] & 255;
                if (value81 < 3) {
                    value81++;
                }
                setCarInfo(44, value81);
                break;
            case R.id.btn_minus31 /* 2131428447 */:
                int value82 = DataCanbus.DATA[160] & 255;
                if (value82 > 0) {
                    value82--;
                }
                setCarInfo(49, value82);
                break;
            case R.id.btn_plus31 /* 2131428448 */:
                int value83 = DataCanbus.DATA[160] & 255;
                if (value83 < 4) {
                    value83++;
                }
                setCarInfo(49, value83);
                break;
            case R.id.btn_minus32 /* 2131428449 */:
                int value84 = DataCanbus.DATA[161] & 255;
                if (value84 > 0) {
                    value84--;
                }
                setCarInfo(51, value84);
                break;
            case R.id.btn_plus32 /* 2131428450 */:
                int value85 = DataCanbus.DATA[161] & 255;
                if (value85 < 2) {
                    value85++;
                }
                setCarInfo(51, value85);
                break;
            case R.id.btn_minus33 /* 2131428451 */:
                int value86 = (DataCanbus.DATA[150] & 255) - 1;
                if (value86 < 0) {
                    value86 = 1;
                }
                setCarInfo(38, value86);
                break;
            case R.id.btn_plus33 /* 2131428452 */:
                int value87 = (DataCanbus.DATA[150] & 255) + 1;
                if (value87 > 1) {
                    value87 = 0;
                }
                setCarInfo(38, value87);
                break;
            case R.id.btn_minus34 /* 2131428453 */:
                int value88 = (DataCanbus.DATA[151] & 255) - 1;
                if (value88 < 0) {
                    value88 = 1;
                }
                setCarInfo(39, value88);
                break;
            case R.id.btn_plus34 /* 2131428454 */:
                int value89 = (DataCanbus.DATA[151] & 255) + 1;
                if (value89 > 1) {
                    value89 = 0;
                }
                setCarInfo(39, value89);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        for (int i = 107; i <= 161; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 107; i <= 161; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 5).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText("-" + (5 - value));
            }
        }
    }

    
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 5).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText("-" + (5 - value));
            }
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_Manual);
            }
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value >= 15) {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 15).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("-" + (15 - value));
            }
        }
    }
}
