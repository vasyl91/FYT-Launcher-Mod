package com.syu.carinfo.wc.axela;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityMzdAllHUDCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllHUDCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode] & 255;
            int show = (DataCanbus.DATA[updateCode] >> 8) & 255;
            switch (updateCode) {
                case 39:
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
                case 40:
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
                case 41:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view8).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 42:
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
                case 43:
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
                case 44:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view11).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text9)).setText("Once driver,Twice all");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text9)).setText("Once all");
                            break;
                    }
                case 45:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view12).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 46:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view13).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                            break;
                    }
                case 47:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view14).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 48:
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
                case 49:
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
                case 50:
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
                case 51:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view18).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 52:
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 53:
                    ActivityMzdAllHUDCarSet.this.updateText1(val);
                    break;
                case 54:
                    ActivityMzdAllHUDCarSet.this.updateText2(val);
                    break;
                case 55:
                    ActivityMzdAllHUDCarSet.this.updateText3(val);
                    break;
                case 56:
                    ActivityMzdAllHUDCarSet.this.updateText4(val);
                    break;
                case 57:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view19).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 58:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view20).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 59:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view21).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 60:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view22).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 61:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view23).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 62:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view24).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 63:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view25).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 64:
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
                case 65:
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
                case 66:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view28).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 67:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view29).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                    }
                case 68:
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
                case 69:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view31).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 70:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view32).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 71:
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
                case 72:
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
                case 73:
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
                case 74:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view34).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 75:
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
                case 76:
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
                case 77:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view39).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text23)).setText("rumble");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text23)).setText("BiBi");
                            break;
                    }
                case 78:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view40).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text24)).setText(R.string.klc_air_low);
                            break;
                    }
                case 79:
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
                case 80:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view42).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 81:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view43).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 84:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view44).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 85:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view45).setVisibility(show != 1 ? 8 : 0);
                    switch (val) {
                        case 1:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text26)).setText("continuous");
                            break;
                        default:
                            ((TextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.tv_text26)).setText("Automatic shutdown");
                            break;
                    }
                case 86:
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
                case 87:
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
                case 88:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view48).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 89:
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
                case 90:
                    ActivityMzdAllHUDCarSet.this.findViewById(R.id.layout_view50).setVisibility(show == 1 ? 0 : 8);
                    ActivityMzdAllHUDCarSet.this.setCheck((CheckedTextView) ActivityMzdAllHUDCarSet.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 91:
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
                case 92:
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
                case 93:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_mzd_hud_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[50] & 255;
                if (value > 0) {
                    value--;
                }
                setCarInfo(12, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[50] & 255;
                if (value2 < 2) {
                    value2++;
                }
                setCarInfo(12, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[64] & 255;
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(19, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[64] & 255;
                if (value4 < 2) {
                    value4++;
                }
                setCarInfo(19, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[65] & 255;
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(20, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[65] & 255;
                if (value6 < 4) {
                    value6++;
                }
                setCarInfo(20, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[52] & 255;
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(52, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[53] & 255;
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(53, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[53] & 255;
                if (value9 < 30) {
                    value9++;
                }
                setCarInfo(53, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = (DataCanbus.DATA[54] & 255) - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(56, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = (DataCanbus.DATA[54] & 255) + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(56, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[55] & 255;
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(54, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[55] & 255;
                if (value13 < 10) {
                    value13++;
                }
                setCarInfo(54, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[56] & 255;
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(55, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[56] & 255;
                if (value15 < 10) {
                    value15++;
                }
                setCarInfo(55, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[39] & 255;
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(1, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[39] & 255;
                if (value17 < 4) {
                    value17++;
                }
                setCarInfo(1, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[40] & 255;
                if (value18 > 0) {
                    value18--;
                }
                setCarInfo(2, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[40] & 255;
                if (value19 < 2) {
                    value19++;
                }
                setCarInfo(2, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[42] & 255;
                if (value20 > 0) {
                    value20--;
                }
                setCarInfo(4, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[42] & 255;
                if (value21 < 3) {
                    value21++;
                }
                setCarInfo(4, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[43] & 255;
                if (value22 > 0) {
                    value22--;
                }
                setCarInfo(5, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[43] & 255;
                if (value23 < 2) {
                    value23++;
                }
                setCarInfo(5, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[44] & 255;
                if (value24 > 0) {
                    value24--;
                }
                setCarInfo(6, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[44] & 255;
                if (value25 < 1) {
                    value25++;
                }
                setCarInfo(6, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[46] & 255;
                if (value26 > 0) {
                    value26--;
                }
                setCarInfo(8, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[46] & 255;
                if (value27 < 1) {
                    value27++;
                }
                setCarInfo(8, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[48] & 255;
                if (value28 > 0) {
                    value28--;
                }
                setCarInfo(10, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[48] & 255;
                if (value29 < 3) {
                    value29++;
                }
                setCarInfo(10, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[49] & 255;
                if (value30 > 0) {
                    value30--;
                }
                setCarInfo(11, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[49] & 255;
                if (value31 < 4) {
                    value31++;
                }
                setCarInfo(11, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[41] & 255;
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(3, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[45] & 255;
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(7, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[47] & 255;
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(9, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[51] & 255;
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(13, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[57] & 255;
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(45, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[58] & 255;
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(27, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[59] & 255;
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(14, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[60] & 255;
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(15, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[61] & 255;
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(16, value40);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[62] & 255;
                if (value41 == 0) {
                    value41 = 1;
                } else if (value41 == 1) {
                    value41 = 0;
                }
                setCarInfo(17, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[63] & 255;
                if (value42 == 0) {
                    value42 = 1;
                } else if (value42 == 1) {
                    value42 = 0;
                }
                setCarInfo(18, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[66] & 255;
                if (value43 == 0) {
                    value43 = 1;
                } else if (value43 == 1) {
                    value43 = 0;
                }
                setCarInfo(21, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[69] & 255;
                if (value44 == 0) {
                    value44 = 1;
                } else if (value44 == 1) {
                    value44 = 0;
                }
                setCarInfo(46, value44);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value45 = DataCanbus.DATA[70] & 255;
                if (value45 == 0) {
                    value45 = 1;
                } else if (value45 == 1) {
                    value45 = 0;
                }
                setCarInfo(24, value45);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value46 = DataCanbus.DATA[74] & 255;
                if (value46 == 0) {
                    value46 = 1;
                } else if (value46 == 1) {
                    value46 = 0;
                }
                setCarInfo(28, value46);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value47 = DataCanbus.DATA[80] & 255;
                if (value47 == 0) {
                    value47 = 1;
                } else if (value47 == 1) {
                    value47 = 0;
                }
                setCarInfo(36, value47);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value48 = DataCanbus.DATA[81] & 255;
                if (value48 == 0) {
                    value48 = 1;
                } else if (value48 == 1) {
                    value48 = 0;
                }
                setCarInfo(37, value48);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value49 = DataCanbus.DATA[84] & 255;
                if (value49 == 0) {
                    value49 = 1;
                } else if (value49 == 1) {
                    value49 = 0;
                }
                setCarInfo(47, value49);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value50 = DataCanbus.DATA[88] & 255;
                if (value50 == 0) {
                    value50 = 1;
                } else if (value50 == 1) {
                    value50 = 0;
                }
                setCarInfo(41, value50);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value51 = DataCanbus.DATA[90] & 255;
                if (value51 == 0) {
                    value51 = 1;
                } else if (value51 == 1) {
                    value51 = 0;
                }
                setCarInfo(43, value51);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value52 = DataCanbus.DATA[71] & 255;
                if (value52 > 0) {
                    value52--;
                }
                setCarInfo(25, value52);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value53 = DataCanbus.DATA[71] & 255;
                if (value53 < 2) {
                    value53++;
                }
                setCarInfo(25, value53);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value54 = DataCanbus.DATA[73] & 255;
                if (value54 > 0) {
                    value54--;
                }
                setCarInfo(29, value54);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value55 = DataCanbus.DATA[73] & 255;
                if (value55 < 2) {
                    value55++;
                }
                setCarInfo(29, value55);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value56 = DataCanbus.DATA[75] & 255;
                if (value56 > 0) {
                    value56--;
                }
                setCarInfo(31, value56);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value57 = DataCanbus.DATA[75] & 255;
                if (value57 < 2) {
                    value57++;
                }
                setCarInfo(31, value57);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value58 = DataCanbus.DATA[76] & 255;
                if (value58 > 0) {
                    value58--;
                }
                setCarInfo(32, value58);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value59 = DataCanbus.DATA[76] & 255;
                if (value59 < 3) {
                    value59++;
                }
                setCarInfo(32, value59);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value60 = DataCanbus.DATA[67] & 255;
                if (value60 > 0) {
                    value60--;
                }
                setCarInfo(22, value60);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value61 = DataCanbus.DATA[67] & 255;
                if (value61 < 1) {
                    value61++;
                }
                setCarInfo(22, value61);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value62 = DataCanbus.DATA[68] & 255;
                if (value62 > 0) {
                    value62--;
                }
                setCarInfo(23, value62);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value63 = DataCanbus.DATA[68] & 255;
                if (value63 < 2) {
                    value63++;
                }
                setCarInfo(23, value63);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value64 = DataCanbus.DATA[72] & 255;
                if (value64 > 0) {
                    value64--;
                }
                setCarInfo(30, value64);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value65 = DataCanbus.DATA[72] & 255;
                if (value65 < 2) {
                    value65++;
                }
                setCarInfo(30, value65);
                break;
            case R.id.btn_plus25 /* 2131427923 */:
                int value66 = DataCanbus.DATA[79] & 255;
                if (value66 < 2) {
                    value66++;
                }
                setCarInfo(35, value66);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value67 = DataCanbus.DATA[78] & 255;
                if (value67 < 1) {
                    value67++;
                }
                setCarInfo(34, value67);
                break;
            case R.id.btn_plus26 /* 2131427925 */:
                int value68 = DataCanbus.DATA[85] & 255;
                if (value68 < 1) {
                    value68++;
                }
                setCarInfo(48, value68);
                break;
            case R.id.btn_plus27 /* 2131427926 */:
                int value69 = DataCanbus.DATA[86] & 255;
                if (value69 < 2) {
                    value69++;
                }
                setCarInfo(50, value69);
                break;
            case R.id.btn_plus28 /* 2131427927 */:
                int value70 = DataCanbus.DATA[87] & 255;
                if (value70 < 2) {
                    value70++;
                }
                setCarInfo(40, value70);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value71 = DataCanbus.DATA[77] & 255;
                if (value71 < 1) {
                    value71++;
                }
                setCarInfo(33, value71);
                break;
            case R.id.btn_minus28 /* 2131428312 */:
                int value72 = DataCanbus.DATA[87] & 255;
                if (value72 > 0) {
                    value72--;
                }
                setCarInfo(40, value72);
                break;
            case R.id.btn_minus29 /* 2131428313 */:
                int value73 = DataCanbus.DATA[89] & 255;
                if (value73 > 0) {
                    value73--;
                }
                setCarInfo(42, value73);
                break;
            case R.id.btn_plus29 /* 2131428314 */:
                int value74 = DataCanbus.DATA[89] & 255;
                if (value74 < 2) {
                    value74++;
                }
                setCarInfo(42, value74);
                break;
            case R.id.btn_minus25 /* 2131428315 */:
                int value75 = DataCanbus.DATA[79] & 255;
                if (value75 > 0) {
                    value75--;
                }
                setCarInfo(35, value75);
                break;
            case R.id.btn_minus26 /* 2131428316 */:
                int value76 = DataCanbus.DATA[85] & 255;
                if (value76 > 0) {
                    value76--;
                }
                setCarInfo(48, value76);
                break;
            case R.id.btn_minus27 /* 2131428317 */:
                int value77 = DataCanbus.DATA[86] & 255;
                if (value77 > 0) {
                    value77--;
                }
                setCarInfo(50, value77);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value78 = DataCanbus.DATA[77] & 255;
                if (value78 > 0) {
                    value78--;
                }
                setCarInfo(33, value78);
                break;
            case R.id.btn_minus24 /* 2131428319 */:
                int value79 = DataCanbus.DATA[78] & 255;
                if (value79 > 0) {
                    value79--;
                }
                setCarInfo(34, value79);
                break;
            case R.id.btn_minus30 /* 2131428377 */:
                int value80 = DataCanbus.DATA[91] & 255;
                if (value80 > 0) {
                    value80--;
                }
                setCarInfo(44, value80);
                break;
            case R.id.btn_plus30 /* 2131428378 */:
                int value81 = DataCanbus.DATA[91] & 255;
                if (value81 < 3) {
                    value81++;
                }
                setCarInfo(44, value81);
                break;
            case R.id.btn_minus31 /* 2131428546 */:
                int value82 = DataCanbus.DATA[92] & 255;
                if (value82 > 0) {
                    value82--;
                }
                setCarInfo(49, value82);
                break;
            case R.id.btn_plus31 /* 2131428547 */:
                int value83 = DataCanbus.DATA[92] & 255;
                if (value83 < 4) {
                    value83++;
                }
                setCarInfo(49, value83);
                break;
            case R.id.btn_minus32 /* 2131428548 */:
                int value84 = DataCanbus.DATA[93] & 255;
                if (value84 > 0) {
                    value84--;
                }
                setCarInfo(51, value84);
                break;
            case R.id.btn_plus32 /* 2131428549 */:
                int value85 = DataCanbus.DATA[93] & 255;
                if (value85 < 2) {
                    value85++;
                }
                setCarInfo(51, value85);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2}, null, null);
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
        for (int i = 39; i <= 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 39; i <= 93; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 5).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText("-" + (5 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 5).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText("-" + (5 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_Manual);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
