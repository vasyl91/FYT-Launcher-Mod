package com.syu.carinfo.rzc.sanlin;

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
import com.syu.carinfo.ford.LZRam1500CarCDAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZDodgeRam1500CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZDodgeRam1500CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 99:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 100:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 101:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 102:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 103:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            case 3:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text3)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 105:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 106:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 107:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 108:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 109:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 110:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 111:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 112:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_presskeyunlock_1);
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_presskeyunlock_0);
                                break;
                        }
                    }
                    break;
                case 113:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 114:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text5)).setText("km");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text5)).setText("mil");
                                break;
                        }
                    }
                    break;
                case 115:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 116:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text6)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text6)).setText("45s");
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text6)).setText("5min");
                                break;
                            case 3:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text6)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 117:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 118:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 119:
                    LZDodgeRam1500CarSet.this.updateLauguageSet();
                    break;
                case 120:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 121:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 122:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_all);
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_warning);
                                break;
                        }
                    }
                    break;
                case 125:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 126:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 127:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 128:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text10)).setText("km/h");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text10)).setText("mph");
                                break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text11)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text11)).setText("l/100km");
                                break;
                            case 2:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text11)).setText("mpg(uk)");
                                break;
                            case 3:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text11)).setText("mpg(us)");
                                break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text12)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text12)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 131:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 132:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext22), val == 1);
                    break;
                case 133:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext23), val == 1);
                    break;
                case 134:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text21)).setText(R.string.str_pack_complete);
                                break;
                            case 1:
                                ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text21)).setText(R.string.str_compass_checking);
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 137:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 138:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text15)) != null) {
                        if (val > 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text15)).setText("R" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text15)).setText("L" + (9 - val));
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text15)).setText("0");
                        }
                    }
                    break;
                case 139:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text16)) != null) {
                        if (val > 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text16)).setText("R" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text16)).setText("F" + (9 - val));
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text16)).setText("0");
                        }
                    }
                    break;
                case 140:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text17)) != null) {
                        if (val > 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text17)).setText("+" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text17)).setText("-" + (9 - val));
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text17)).setText("0");
                        }
                    }
                    break;
                case 141:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text18)) != null) {
                        if (val > 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text18)).setText("+" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text18)).setText("-" + (9 - val));
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text18)).setText("0");
                        }
                    }
                    break;
                case 142:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text19)) != null) {
                        if (val > 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text19)).setText("+" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text19)).setText("-" + (9 - val));
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text19)).setText("0");
                        }
                    }
                    break;
                case 143:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext25), val == 1);
                    break;
                case 144:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text20)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text20)).setText(R.string.off);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text20)).setText(new StringBuilder().append(val).toString());
                        }
                    }
                    break;
                case 145:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext34), val == 1);
                    break;
                case 146:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext27), val == 1);
                    break;
                case 147:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text22)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text22)).setText(R.string.jeep_forwardcollisionwarn_0);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text22)).setText(R.string.jeep_forwardcollisionwarn_1);
                        }
                    }
                    break;
                case 148:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text23)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text23)).setText(R.string.jeep_lanesensewarn_2);
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text23)).setText(R.string.jeep_lanesensewarn_1);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text23)).setText(R.string.jeep_lanesensewarn_0);
                        }
                    }
                    break;
                case 149:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text24)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text24)).setText(R.string.wc_372_low);
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text24)).setText(R.string.wc_372_mid);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text24)).setText(R.string.wc_372_high);
                        }
                    }
                    break;
                case 150:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text25)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_driving_normal);
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_driving_sport);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text25)).setText(R.string.str_driving_comfort);
                        }
                    }
                    break;
                case 151:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text26)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text26)).setText(R.string.off);
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text26)).setText(R.string.jeep_blindwarn_1);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text26)).setText(R.string.jeep_blindwarn_2);
                        }
                    }
                    break;
                case 152:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext28), val == 1);
                    break;
                case 153:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext29), val == 1);
                    break;
                case 154:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext30), val == 1);
                    break;
                case 155:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text27)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text27)).setText("L");
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text27)).setText("gal(uk)");
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text27)).setText("gal(us)");
                        }
                    }
                    break;
                case 156:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text28)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text28)).setText("kpa");
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text28)).setText("bar");
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text28)).setText("psi");
                        }
                    }
                    break;
                case 157:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text29)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text29)).setText("kw");
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text29)).setText("hp(uk)");
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text29)).setText("hp(us)");
                        }
                    }
                    break;
                case 158:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text30)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text30)).setText(R.string.klc_air_auto);
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text30)).setText("max 12m");
                        }
                    }
                    break;
                case 159:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext31), val == 1);
                    break;
                case 160:
                    if (((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text31)) != null) {
                        if (val == 0) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text31)).setText(R.string.off);
                        } else if (val == 1) {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text31)).setText(R.string.str_373_first_touch);
                        } else {
                            ((TextView) LZDodgeRam1500CarSet.this.findViewById(R.id.tv_text31)).setText(R.string.str_373_double_touch);
                        }
                    }
                    break;
                case 170:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext26), val == 1);
                    break;
                case 171:
                    LZDodgeRam1500CarSet.this.setCheck((CheckedTextView) LZDodgeRam1500CarSet.this.findViewById(R.id.ctv_checkedtext35), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_dodge_ram1500_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZDodgeRam1500CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZDodgeRam1500CarSet.this.language_set = position;
                if (LZDodgeRam1500CarSet.this.language_set >= 0 && LZDodgeRam1500CarSet.this.language_set <= LZDodgeRam1500CarSet.this.mLauStylelist.size() && LZDodgeRam1500CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, LZDodgeRam1500CarSet.this.send_lang[LZDodgeRam1500CarSet.this.language_set]}, null, null);
                }
                LZDodgeRam1500CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[119];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 6, 7, 9, 10, 13, 16, 17};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZDodgeRam1500CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZDodgeRam1500CarSet.this.mLauStyle == null) {
                    LZDodgeRam1500CarSet.this.initLauStyle();
                }
                if (LZDodgeRam1500CarSet.this.mLauStyle != null && LZDodgeRam1500CarSet.this.mPopShowView != null) {
                    LZDodgeRam1500CarSet.this.mLauStyle.showAtLocation(LZDodgeRam1500CarSet.this.mPopShowView, 17, 0, 0);
                    LZDodgeRam1500CarSet.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[103] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[103] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[104] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[104] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[112] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[112] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[114] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[114] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[116] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(21, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[116] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(21, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[122] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(29, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[122] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(29, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[123] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(30, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[123] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(30, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[124] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(48, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[124] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(48, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[128] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(53, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[128] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(53, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[129] - 1;
                if (value21 < 0) {
                    value21 = 3;
                }
                setCarInfo(54, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[129] + 1;
                if (value22 > 3) {
                    value22 = 0;
                }
                setCarInfo(54, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[130] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(57, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[130] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(57, value24);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[135] - 1;
                if (value25 < 0) {
                    value25 = 14;
                }
                setCarInfo(64, value25);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[135] + 1;
                if (value26 > 14) {
                    value26 = 0;
                }
                setCarInfo(64, value26);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int vol = DataCanbus.DATA[137];
                int bal = DataCanbus.DATA[138];
                int fad = DataCanbus.DATA[139];
                int bass = DataCanbus.DATA[140];
                int mid = DataCanbus.DATA[141];
                int treb = DataCanbus.DATA[142];
                int suround = DataCanbus.DATA[143];
                int speedvol = DataCanbus.DATA[144];
                if (vol > 0) {
                    vol--;
                }
                setCarAmpInfo(vol, bal, fad, bass, mid, treb, (speedvol & 15) | ((suround << 7) & 128));
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int vol2 = DataCanbus.DATA[137];
                int bal2 = DataCanbus.DATA[138];
                int fad2 = DataCanbus.DATA[139];
                int bass2 = DataCanbus.DATA[140];
                int mid2 = DataCanbus.DATA[141];
                int treb2 = DataCanbus.DATA[142];
                int suround2 = DataCanbus.DATA[143];
                int speedvol2 = DataCanbus.DATA[144];
                if (vol2 < 38) {
                    vol2++;
                }
                setCarAmpInfo(vol2, bal2, fad2, bass2, mid2, treb2, (speedvol2 & 15) | ((suround2 << 7) & 128));
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int vol3 = DataCanbus.DATA[137];
                int bal3 = DataCanbus.DATA[138];
                int fad3 = DataCanbus.DATA[139];
                int bass3 = DataCanbus.DATA[140];
                int mid3 = DataCanbus.DATA[141];
                int treb3 = DataCanbus.DATA[142];
                int suround3 = DataCanbus.DATA[143];
                int speedvol3 = DataCanbus.DATA[144];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarAmpInfo(vol3, bal3, fad3, bass3, mid3, treb3, (speedvol3 & 15) | ((suround3 << 7) & 128));
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int vol4 = DataCanbus.DATA[137];
                int bal4 = DataCanbus.DATA[138];
                int fad4 = DataCanbus.DATA[139];
                int bass4 = DataCanbus.DATA[140];
                int mid4 = DataCanbus.DATA[141];
                int treb4 = DataCanbus.DATA[142];
                int suround4 = DataCanbus.DATA[143];
                int speedvol4 = DataCanbus.DATA[144];
                if (bal4 < 19) {
                    bal4++;
                }
                setCarAmpInfo(vol4, bal4, fad4, bass4, mid4, treb4, (speedvol4 & 15) | ((suround4 << 7) & 128));
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int vol5 = DataCanbus.DATA[137];
                int bal5 = DataCanbus.DATA[138];
                int fad5 = DataCanbus.DATA[139];
                int bass5 = DataCanbus.DATA[140];
                int mid5 = DataCanbus.DATA[141];
                int treb5 = DataCanbus.DATA[142];
                int suround5 = DataCanbus.DATA[143];
                int speedvol5 = DataCanbus.DATA[144];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarAmpInfo(vol5, bal5, fad5, bass5, mid5, treb5, (speedvol5 & 15) | ((suround5 << 7) & 128));
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int vol6 = DataCanbus.DATA[137];
                int bal6 = DataCanbus.DATA[138];
                int fad6 = DataCanbus.DATA[139];
                int bass6 = DataCanbus.DATA[140];
                int mid6 = DataCanbus.DATA[141];
                int treb6 = DataCanbus.DATA[142];
                int suround6 = DataCanbus.DATA[143];
                int speedvol6 = DataCanbus.DATA[144];
                if (fad6 < 19) {
                    fad6++;
                }
                setCarAmpInfo(vol6, bal6, fad6, bass6, mid6, treb6, (speedvol6 & 15) | ((suround6 << 7) & 128));
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int vol7 = DataCanbus.DATA[137];
                int bal7 = DataCanbus.DATA[138];
                int fad7 = DataCanbus.DATA[139];
                int bass7 = DataCanbus.DATA[140];
                int mid7 = DataCanbus.DATA[141];
                int treb7 = DataCanbus.DATA[142];
                int suround7 = DataCanbus.DATA[143];
                int speedvol7 = DataCanbus.DATA[144];
                if (bass7 > 0) {
                    bass7--;
                }
                setCarAmpInfo(vol7, bal7, fad7, bass7, mid7, treb7, (speedvol7 & 15) | ((suround7 << 7) & 128));
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int vol8 = DataCanbus.DATA[137];
                int bal8 = DataCanbus.DATA[138];
                int fad8 = DataCanbus.DATA[139];
                int bass8 = DataCanbus.DATA[140];
                int mid8 = DataCanbus.DATA[141];
                int treb8 = DataCanbus.DATA[142];
                int suround8 = DataCanbus.DATA[143];
                int speedvol8 = DataCanbus.DATA[144];
                if (bass8 < 19) {
                    bass8++;
                }
                setCarAmpInfo(vol8, bal8, fad8, bass8, mid8, treb8, (speedvol8 & 15) | ((suround8 << 7) & 128));
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int vol9 = DataCanbus.DATA[137];
                int bal9 = DataCanbus.DATA[138];
                int fad9 = DataCanbus.DATA[139];
                int bass9 = DataCanbus.DATA[140];
                int mid9 = DataCanbus.DATA[141];
                int treb9 = DataCanbus.DATA[142];
                int suround9 = DataCanbus.DATA[143];
                int speedvol9 = DataCanbus.DATA[144];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarAmpInfo(vol9, bal9, fad9, bass9, mid9, treb9, (speedvol9 & 15) | ((suround9 << 7) & 128));
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int vol10 = DataCanbus.DATA[137];
                int bal10 = DataCanbus.DATA[138];
                int fad10 = DataCanbus.DATA[139];
                int bass10 = DataCanbus.DATA[140];
                int mid10 = DataCanbus.DATA[141];
                int treb10 = DataCanbus.DATA[142];
                int suround10 = DataCanbus.DATA[143];
                int speedvol10 = DataCanbus.DATA[144];
                if (mid10 < 19) {
                    mid10++;
                }
                setCarAmpInfo(vol10, bal10, fad10, bass10, mid10, treb10, (speedvol10 & 15) | ((suround10 << 7) & 128));
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(0, DataCanbus.DATA[98] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(5, DataCanbus.DATA[102] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(8, DataCanbus.DATA[105] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(2, DataCanbus.DATA[100] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(4, DataCanbus.DATA[101] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(9, DataCanbus.DATA[106] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(13, DataCanbus.DATA[107] == 1 ? 0 : 1);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int vol11 = DataCanbus.DATA[137];
                int bal11 = DataCanbus.DATA[138];
                int fad11 = DataCanbus.DATA[139];
                int bass11 = DataCanbus.DATA[140];
                int mid11 = DataCanbus.DATA[141];
                int treb11 = DataCanbus.DATA[142];
                int suround11 = DataCanbus.DATA[143];
                int speedvol11 = DataCanbus.DATA[144];
                if (treb11 > 0) {
                    treb11--;
                }
                setCarAmpInfo(vol11, bal11, fad11, bass11, mid11, treb11, (speedvol11 & 15) | ((suround11 << 7) & 128));
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int vol12 = DataCanbus.DATA[137];
                int bal12 = DataCanbus.DATA[138];
                int fad12 = DataCanbus.DATA[139];
                int bass12 = DataCanbus.DATA[140];
                int mid12 = DataCanbus.DATA[141];
                int treb12 = DataCanbus.DATA[142];
                int suround12 = DataCanbus.DATA[143];
                int speedvol12 = DataCanbus.DATA[144];
                if (treb12 < 19) {
                    treb12++;
                }
                setCarAmpInfo(vol12, bal12, fad12, bass12, mid12, treb12, (speedvol12 & 15) | ((suround12 << 7) & 128));
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int vol13 = DataCanbus.DATA[137];
                int bal13 = DataCanbus.DATA[138];
                int fad13 = DataCanbus.DATA[139];
                int bass13 = DataCanbus.DATA[140];
                int mid13 = DataCanbus.DATA[141];
                int treb13 = DataCanbus.DATA[142];
                int suround13 = DataCanbus.DATA[143];
                int speedvol13 = DataCanbus.DATA[144];
                if (speedvol13 > 0) {
                    speedvol13--;
                }
                setCarAmpInfo(vol13, bal13, fad13, bass13, mid13, treb13, (speedvol13 & 15) | ((suround13 << 7) & 128));
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int vol14 = DataCanbus.DATA[137];
                int bal14 = DataCanbus.DATA[138];
                int fad14 = DataCanbus.DATA[139];
                int bass14 = DataCanbus.DATA[140];
                int mid14 = DataCanbus.DATA[141];
                int treb14 = DataCanbus.DATA[142];
                int suround14 = DataCanbus.DATA[143];
                int speedvol14 = DataCanbus.DATA[144];
                if (speedvol14 < 3) {
                    speedvol14++;
                }
                setCarAmpInfo(vol14, bal14, fad14, bass14, mid14, treb14, (speedvol14 & 15) | ((suround14 << 7) & 128));
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value27 = DataCanbus.DATA[147] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(34, value27);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value28 = DataCanbus.DATA[147] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(34, value28);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int value29 = DataCanbus.DATA[148] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(31, value29);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int value30 = DataCanbus.DATA[148] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(31, value30);
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int value31 = DataCanbus.DATA[149] - 1;
                if (value31 < 0) {
                    value31 = 2;
                }
                setCarInfo(32, value31);
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int value32 = DataCanbus.DATA[149] + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarInfo(32, value32);
                break;
            case R.id.btn_minus24 /* 2131427610 */:
                int value33 = DataCanbus.DATA[150] - 1;
                if (value33 < 0) {
                    value33 = 2;
                }
                setCarInfo(35, value33);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                int value34 = DataCanbus.DATA[150] + 1;
                if (value34 > 2) {
                    value34 = 0;
                }
                setCarInfo(35, value34);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
                int value35 = DataCanbus.DATA[151] - 1;
                if (value35 < 0) {
                    value35 = 2;
                }
                setCarInfo(36, value35);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int value36 = DataCanbus.DATA[151] + 1;
                if (value36 > 2) {
                    value36 = 0;
                }
                setCarInfo(36, value36);
                break;
            case R.id.btn_minus26 /* 2131427617 */:
                int value37 = DataCanbus.DATA[155] - 1;
                if (value37 < 0) {
                    value37 = 2;
                }
                setCarInfo(55, value37);
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                int value38 = DataCanbus.DATA[155] + 1;
                if (value38 > 2) {
                    value38 = 0;
                }
                setCarInfo(55, value38);
                break;
            case R.id.btn_minus27 /* 2131427620 */:
                int value39 = DataCanbus.DATA[156] - 1;
                if (value39 < 0) {
                    value39 = 2;
                }
                setCarInfo(56, value39);
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                int value40 = DataCanbus.DATA[156] + 1;
                if (value40 > 2) {
                    value40 = 0;
                }
                setCarInfo(56, value40);
                break;
            case R.id.btn_minus28 /* 2131427623 */:
                int value41 = DataCanbus.DATA[157] - 1;
                if (value41 < 0) {
                    value41 = 2;
                }
                setCarInfo(58, value41);
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                int value42 = DataCanbus.DATA[157] + 1;
                if (value42 > 2) {
                    value42 = 0;
                }
                setCarInfo(58, value42);
                break;
            case R.id.btn_minus29 /* 2131427627 */:
                int value43 = DataCanbus.DATA[158] - 1;
                if (value43 < 0) {
                    value43 = 1;
                }
                setCarInfo(66, value43);
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                int value44 = DataCanbus.DATA[158] + 1;
                if (value44 > 1) {
                    value44 = 0;
                }
                setCarInfo(66, value44);
                break;
            case R.id.btn_minus30 /* 2131427630 */:
                int value45 = DataCanbus.DATA[160] - 1;
                if (value45 < 0) {
                    value45 = 2;
                }
                setCarInfo(68, value45);
                break;
            case R.id.btn_plus30 /* 2131427632 */:
                int value46 = DataCanbus.DATA[160] + 1;
                if (value46 > 2) {
                    value46 = 0;
                }
                setCarInfo(68, value46);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(14, DataCanbus.DATA[108] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(15, DataCanbus.DATA[109] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(17, DataCanbus.DATA[110] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(18, DataCanbus.DATA[111] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(19, DataCanbus.DATA[113] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(20, DataCanbus.DATA[115] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(26, DataCanbus.DATA[117] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(27, DataCanbus.DATA[118] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(28, DataCanbus.DATA[120] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(37, DataCanbus.DATA[121] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfo(49, DataCanbus.DATA[125] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCarInfo(50, DataCanbus.DATA[126] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                setCarInfo(51, DataCanbus.DATA[127] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                setCarInfo(61, DataCanbus.DATA[131] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                setCarInfo(62, DataCanbus.DATA[132] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                setCarInfo(63, DataCanbus.DATA[133] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                setCarInfo(65, 1);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int vol15 = DataCanbus.DATA[137];
                int bal15 = DataCanbus.DATA[138];
                int fad15 = DataCanbus.DATA[139];
                int bass15 = DataCanbus.DATA[140];
                int mid15 = DataCanbus.DATA[141];
                int treb15 = DataCanbus.DATA[142];
                int suround15 = DataCanbus.DATA[143];
                int speedvol15 = DataCanbus.DATA[144];
                if (suround15 == 1) {
                    suround15 = 0;
                } else if (suround15 == 0) {
                    suround15 = 1;
                }
                setCarAmpInfo(vol15, bal15, fad15, bass15, mid15, treb15, (speedvol15 & 15) | ((suround15 << 7) & 128));
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                setCarInfo(52, DataCanbus.DATA[170] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                setCarInfo(33, DataCanbus.DATA[146] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                setCarInfo(44, DataCanbus.DATA[152] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                setCarInfo(45, DataCanbus.DATA[153] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                setCarInfo(47, DataCanbus.DATA[154] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                setCarInfo(67, DataCanbus.DATA[159] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                setCarInfo(69, 1);
                break;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZRam1500CarCDAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                setCarInfo(59, DataCanbus.DATA[145] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                setCarInfo(60, DataCanbus.DATA[171] == 1 ? 0 : 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    public void setCarAmpInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3, value4, value5, value6}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
    }
}
