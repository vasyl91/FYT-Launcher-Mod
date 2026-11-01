package com.syu.carinfo.od.tusheng;

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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class OD_19Tusheng_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 10) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text7)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text7)).setText("-" + (10 - value));
                        } else {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 99:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 10) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text8)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text8)).setText("-" + (10 - value));
                        } else {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text8)).setText("0");
                        }
                    }
                    break;
                case 100:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text9)) != null) {
                        if (value > 10) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text9)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text9)).setText("-" + (10 - value));
                        } else {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text9)).setText("0");
                        }
                    }
                    break;
                case 101:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text11)) != null) {
                        if (value > 7) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("F" + (7 - value));
                        } else {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("0");
                        }
                    }
                    break;
                case 102:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text10)) != null) {
                        if (value > 7) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text10)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text10)).setText("L" + (7 - value));
                        } else {
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text10)).setText("0");
                        }
                    }
                    break;
                case 104:
                    OD_19Tusheng_CarSettingAct.this.updateGuijiOn();
                    break;
                case 105:
                    OD_19Tusheng_CarSettingAct.this.updateRadarOn();
                    break;
                case 106:
                    OD_19Tusheng_CarSettingAct.this.updateFrontViewMode();
                    break;
                case 107:
                    OD_19Tusheng_CarSettingAct.this.updateRearViewMode();
                    break;
                case 108:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 109:
                    OD_19Tusheng_CarSettingAct.this.updateTempCtrl();
                    break;
                case 110:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 111:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 112:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 113:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 114:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 1);
                    break;
                case 117:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 118:
                    switch (value) {
                        case 1:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_theme_color);
                            break;
                        default:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_monochrome_lamp);
                            break;
                    }
                    break;
                case 119:
                    switch (value) {
                        case 3:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("派对主题");
                            break;
                        case 6:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("嘿！哟！");
                            break;
                        case 9:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("旅行");
                            break;
                        case 12:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("浪漫");
                            break;
                        case 15:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("午夜城市");
                            break;
                        case 18:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("咖啡");
                            break;
                    }
                    break;
                case 120:
                    switch (value) {
                        case 1:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("波罗的海蓝");
                            break;
                        case 2:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("挪威森林绿");
                            break;
                        case 3:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("普罗旺斯紫");
                            break;
                        case 4:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("彩色的云");
                            break;
                        case 5:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("活力橙");
                            break;
                        case 6:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("大漠金");
                            break;
                        case 7:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("清爽的海");
                            break;
                        case 8:
                            ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("巴塞罗那红");
                            break;
                    }
                    break;
                case 121:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 122:
                    ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 1).toString());
                    break;
                case 155:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 156:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text13)).setText("Warning Only");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text13)).setText("Active assist");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 157:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 2);
                    break;
                case 158:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 2);
                    break;
                case 159:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text14)).setText("ThemeB");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text14)).setText("ThemeC");
                                break;
                            case 4:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text14)).setText("ThemeD");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text14)).setText("ThemeA");
                                break;
                        }
                    }
                    break;
                case 160:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 2);
                    break;
                case 161:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 2);
                    break;
                case 162:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 2);
                    break;
                case 163:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 2);
                    break;
                case 164:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 2);
                    break;
                case 165:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 2);
                    break;
                case 166:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 167:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text16)) != null) {
                        ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text16)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 168:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    break;
                case 169:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text17)).setText(R.string.str_oil_signal_normal);
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text17)).setText("Extended");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text17)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 170:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 2);
                    break;
                case 171:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text18)).setText("3 flashs");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text18)).setText("5 flashs");
                                break;
                            case 4:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text18)).setText("7 flashs");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text18)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 172:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value == 2);
                    break;
                case 173:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text19)).setText("Speed");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text19)).setText("Gearshift");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text19)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 174:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text20)).setText("Key out");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text20)).setText("Gearshift");
                                break;
                            case 4:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text20)).setText("Door open");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text20)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 175:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value == 2);
                    break;
                case 176:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value == 2);
                    break;
                case 177:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text21)).setText("Low");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text21)).setText("Fast");
                                break;
                        }
                    }
                    break;
                case 178:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text22)).setText("Lev 1");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text22)).setText("Lev 2");
                                break;
                            case 4:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text22)).setText("Lev 3");
                                break;
                            case 129:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text22)).setText("User");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text22)).setText("Fully open");
                                break;
                        }
                    }
                    break;
                case 179:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext26)).setChecked(value == 2);
                    break;
                case 180:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value == 2);
                    break;
                case 181:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext28)).setChecked(value == 2);
                    break;
                case 182:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext29)).setChecked(value == 2);
                    break;
                case 183:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext30)).setChecked(value == 2);
                    break;
                case 184:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext31)).setChecked(value == 2);
                    break;
                case 185:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext32)).setChecked(value == 2);
                    break;
                case 186:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext33)).setChecked(value == 2);
                    break;
                case 187:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text23)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text23)).setText("km");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text23)).setText("mi");
                                break;
                        }
                    }
                    break;
                case 188:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text24)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text24)).setText("mpg(UK)");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text24)).setText("mpg(US)");
                                break;
                        }
                    }
                    break;
                case 189:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text25)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text25)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text25)).setText("km/l");
                                break;
                        }
                    }
                    break;
                case 190:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text26)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text26)).setText("℉");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text26)).setText("℃");
                                break;
                        }
                    }
                    break;
                case 191:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text27)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text27)).setText("kPa");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text27)).setText("bar");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text27)).setText("psi");
                                break;
                        }
                    }
                    break;
                case 194:
                    OD_19Tusheng_CarSettingAct.this.updateLauguageSet();
                    break;
                case 196:
                    ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text28)).setText(new StringBuilder().append(value).toString());
                    break;
                case 197:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext35)).setChecked(value == 2);
                    break;
                case 198:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext36)).setChecked(value == 2);
                    break;
                case 199:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text29)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text29)).setText("Late");
                                break;
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text29)).setText("Standard");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text29)).setText("---");
                                break;
                        }
                    }
                    break;
                case 200:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext37)).setChecked(value == 2);
                    break;
                case 201:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext38)).setChecked(value == 2);
                    break;
                case 202:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext39)).setChecked(value == 2);
                    break;
                case 203:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext40)).setChecked(value == 2);
                    break;
                case 204:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text30)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text30)).setText("off");
                                break;
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text30)).setText("Warning only");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text30)).setText("Active Assist");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text30)).setText("---");
                                break;
                        }
                    }
                    break;
                case 205:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text31)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text31)).setText("off");
                                break;
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text31)).setText("Warning only");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text31)).setText("Active Assist");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text31)).setText("---");
                                break;
                        }
                    }
                    break;
                case 206:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext41)).setChecked(value == 2);
                    break;
                case 207:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text32)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text32)).setText("off");
                                break;
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text32)).setText("Warning only");
                                break;
                            case 3:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text32)).setText("Active Assist");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text32)).setText("---");
                                break;
                        }
                    }
                    break;
                case 209:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text33)) != null) {
                        ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text33)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 210:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext43)).setChecked(value == 1);
                    break;
                case 211:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext44)).setChecked(value == 1);
                    break;
                case 212:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext45)).setChecked(value == 1);
                    break;
                case 213:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext46)).setChecked(value == 1);
                    break;
                case 214:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext47)).setChecked(value == 1);
                    break;
                case 215:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext48)).setChecked(value == 2);
                    break;
                case 216:
                    if (((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text34)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text34)).setText("off");
                                break;
                            case 2:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text34)).setText("Open Sliding doors");
                                break;
                            default:
                                ((TextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.tv_text34)).setText("---");
                                break;
                        }
                    }
                    break;
                case 217:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext49)).setChecked(value == 2);
                    break;
                case 218:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext50)).setChecked(value == 2);
                    break;
                case 219:
                    ((CheckedTextView) OD_19Tusheng_CarSettingAct.this.findViewById(R.id.ctv_checkedtext51)).setChecked(value == 2);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0447_od_rzc_tusheng_carsetting);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                OD_19Tusheng_CarSettingAct.this.language_set = position;
                if (OD_19Tusheng_CarSettingAct.this.language_set >= 0 && OD_19Tusheng_CarSettingAct.this.language_set <= OD_19Tusheng_CarSettingAct.this.mLauStylelist.size() && OD_19Tusheng_CarSettingAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(8, new int[]{OD_19Tusheng_CarSettingAct.this.send_lang[OD_19Tusheng_CarSettingAct.this.language_set]}, null, null);
                }
                OD_19Tusheng_CarSettingAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[194];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_34));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add("Francais(US)");
        this.mLauStylelist.add("Espanol(US)");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add("Indonesia");
        this.mLauStylelist.add("Magyar");
        this.mLauStylelist.add("HINDU");
        this.mLauStylelist.add("Greek");
        this.mLauStylelist.add("Ukrainian");
        this.mLauStylelist.add("Slovenscine");
        this.mLauStylelist.add("Bulgarian");
        this.mLauStylelist.add("Hrvatski");
        this.mLauStylelist.add("Romana");
        this.mLauStylelist.add("BANGLADES");
        this.mLauStylelist.add("TELUGU");
        this.mLauStylelist.add("TAMIL");
        this.mLauStylelist.add("GUJURATI");
        this.mLauStylelist.add("KANNADA");
        this.mLauStylelist.add("ODIA");
        this.mLauStylelist.add("MAYALAM");
        this.mLauStylelist.add("PUNJABI");
        this.mLauStylelist.add("PUNCHABI");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.send_lang = new int[]{0, 1, 2, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 24, 25, 28, 31, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 129};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (OD_19Tusheng_CarSettingAct.this.mLauStyle == null) {
                    OD_19Tusheng_CarSettingAct.this.initLauStyle();
                }
                if (OD_19Tusheng_CarSettingAct.this.mLauStyle != null && OD_19Tusheng_CarSettingAct.this.mPopShowView != null) {
                    OD_19Tusheng_CarSettingAct.this.mLauStyle.showAtLocation(OD_19Tusheng_CarSettingAct.this.mPopShowView, 17, 0, 0);
                    OD_19Tusheng_CarSettingAct.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus21)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus21)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus23)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus23)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus26)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus26)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus27)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus27)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus28)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus28)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus29)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus29)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus30)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus30)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus31)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus31)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus32)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus32)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus33)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus33)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus34)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus34)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext25)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext26)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext29)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext30)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext31)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext32)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext33)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext34)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext35)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext36)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext37)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext38)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext39)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext40)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext41)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext42)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext43)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext44)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext45)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext46)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext47)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext48)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext49)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext50)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext51)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int value;
        int value2;
        int value3;
        int value4;
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value5 = DataCanbus.DATA[118] - 1;
                if (value5 < 1) {
                    value5 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value5}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value6 = DataCanbus.DATA[118] + 1;
                if (value6 > 2) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value6}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value7 = DataCanbus.DATA[119];
                if (value7 == 3) {
                    value4 = 18;
                } else if (value7 == 6) {
                    value4 = 3;
                } else if (value7 == 9) {
                    value4 = 6;
                } else if (value7 == 12) {
                    value4 = 9;
                } else if (value7 == 15) {
                    value4 = 12;
                } else if (value7 == 18) {
                    value4 = 15;
                } else {
                    value4 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value4}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value8 = DataCanbus.DATA[119];
                if (value8 == 3) {
                    value3 = 6;
                } else if (value8 == 6) {
                    value3 = 9;
                } else if (value8 == 9) {
                    value3 = 12;
                } else if (value8 == 12) {
                    value3 = 15;
                } else if (value8 == 15) {
                    value3 = 18;
                } else if (value8 == 18) {
                    value3 = 3;
                } else {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value3}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value9 = DataCanbus.DATA[120] - 1;
                if (value9 < 1) {
                    value9 = 8;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value9}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value10 = DataCanbus.DATA[120] + 1;
                if (value10 > 8) {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value10}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value11 = DataCanbus.DATA[122] - 1;
                if (value11 < 2) {
                    value11 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value11}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value12 = DataCanbus.DATA[122] + 1;
                if (value12 > 5) {
                    value12 = 5;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value12}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value13 = DataCanbus.DATA[106] - 1;
                if (value13 < 1) {
                    value13 = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value13}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value14 = DataCanbus.DATA[106] + 1;
                if (value14 > 4) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value14}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value15 = DataCanbus.DATA[107] - 1;
                if (value15 < 1) {
                    value15 = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value15}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value16 = DataCanbus.DATA[107] + 1;
                if (value16 > 4) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value16}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int bass = DataCanbus.DATA[98];
                int mid = DataCanbus.DATA[99];
                int treb = DataCanbus.DATA[100];
                if (bass > 0) {
                    bass--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{bass, mid, treb}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int bass2 = DataCanbus.DATA[98];
                int mid2 = DataCanbus.DATA[99];
                int treb2 = DataCanbus.DATA[100];
                if (bass2 < 20) {
                    bass2++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{bass2, mid2, treb2}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int bass3 = DataCanbus.DATA[98];
                int mid3 = DataCanbus.DATA[99];
                int treb3 = DataCanbus.DATA[100];
                if (mid3 > 0) {
                    mid3--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{bass3, mid3, treb3}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int bass4 = DataCanbus.DATA[98];
                int mid4 = DataCanbus.DATA[99];
                int treb4 = DataCanbus.DATA[100];
                if (mid4 < 20) {
                    mid4++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{bass4, mid4, treb4}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int bass5 = DataCanbus.DATA[98];
                int mid5 = DataCanbus.DATA[99];
                int treb5 = DataCanbus.DATA[100];
                if (treb5 > 0) {
                    treb5--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{bass5, mid5, treb5}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int bass6 = DataCanbus.DATA[98];
                int mid6 = DataCanbus.DATA[99];
                int treb6 = DataCanbus.DATA[100];
                if (treb6 < 20) {
                    treb6++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{bass6, mid6, treb6}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int bal = DataCanbus.DATA[102];
                int fad = DataCanbus.DATA[101];
                if (bal > 0) {
                    bal--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{fad, bal}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int bal2 = DataCanbus.DATA[102];
                int fad2 = DataCanbus.DATA[101];
                if (bal2 < 14) {
                    bal2++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{fad2, bal2}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int bal3 = DataCanbus.DATA[102];
                int fad3 = DataCanbus.DATA[101];
                if (fad3 > 0) {
                    fad3--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{fad3, bal3}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int bal4 = DataCanbus.DATA[102];
                int fad4 = DataCanbus.DATA[101];
                if (fad4 < 14) {
                    fad4++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{fad4, bal4}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value17 = DataCanbus.DATA[155] - 1;
                if (value17 < 1) {
                    value17 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{32, value17}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value18 = DataCanbus.DATA[155] + 1;
                if (value18 > 3) {
                    value18 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{32, value18}, null, null);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value19 = DataCanbus.DATA[156] - 1;
                if (value19 < 1) {
                    value19 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{33, value19}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value20 = DataCanbus.DATA[156] + 1;
                if (value20 > 3) {
                    value20 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{33, value20}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value21 = DataCanbus.DATA[159] - 1;
                if (value21 < 1) {
                    value21 = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{48, value21}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value22 = DataCanbus.DATA[159] + 1;
                if (value22 > 4) {
                    value22 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{48, value22}, null, null);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value23 = DataCanbus.DATA[166];
                if (value23 > 0) {
                    value23--;
                }
                DataCanbus.PROXY.cmd(7, new int[]{55, (value23 >> 8) & 255, value23 & 255}, null, null);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value24 = DataCanbus.DATA[166] + 1;
                DataCanbus.PROXY.cmd(7, new int[]{55, (value24 >> 8) & 255, value24 & 255}, null, null);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value25 = DataCanbus.DATA[167];
                if (value25 > 0) {
                    value25--;
                }
                DataCanbus.PROXY.cmd(7, new int[]{56, (value25 >> 8) & 255, value25 & 255}, null, null);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value26 = DataCanbus.DATA[167] + 1;
                DataCanbus.PROXY.cmd(7, new int[]{56, (value26 >> 8) & 255, value26 & 255}, null, null);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value27 = DataCanbus.DATA[169] - 1;
                if (value27 < 1) {
                    value27 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{80, value27}, null, null);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value28 = DataCanbus.DATA[169] + 1;
                if (value28 > 3) {
                    value28 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{80, value28}, null, null);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value29 = DataCanbus.DATA[171] - 1;
                if (value29 < 1) {
                    value29 = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{97, value29}, null, null);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value30 = DataCanbus.DATA[171] + 1;
                if (value30 > 4) {
                    value30 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{97, value30}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value31 = DataCanbus.DATA[121];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 14;
                iArr[1] = value31 == 1 ? 2 : 1;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value32 = DataCanbus.DATA[105];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = value32 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(0, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value33 = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 1;
                iArr3[1] = value33 == 1 ? 2 : 1;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value34 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 10;
                iArr4[1] = value34 == 1 ? 2 : 1;
                remoteModuleProxy4.cmd(1, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value35 = DataCanbus.DATA[104];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 1;
                iArr5[1] = value35 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(0, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value36 = DataCanbus.DATA[109];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 2;
                iArr6[1] = value36 == 1 ? 2 : 1;
                remoteModuleProxy6.cmd(1, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value37 = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 5;
                iArr7[1] = value37 == 1 ? 2 : 1;
                remoteModuleProxy7.cmd(1, iArr7, null, null);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value38 = DataCanbus.DATA[173] - 1;
                if (value38 < 1) {
                    value38 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value38}, null, null);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value39 = DataCanbus.DATA[173] + 1;
                if (value39 > 3) {
                    value39 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value39}, null, null);
                break;
            case R.id.btn_minus20 /* 2131427597 */:
                int value40 = DataCanbus.DATA[174] - 1;
                if (value40 < 1) {
                    value40 = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value40}, null, null);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value41 = DataCanbus.DATA[174] + 1;
                if (value41 > 4) {
                    value41 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value41}, null, null);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value42 = DataCanbus.DATA[177] - 1;
                if (value42 < 1) {
                    value42 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{113, value42}, null, null);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value43 = DataCanbus.DATA[177] + 1;
                if (value43 > 2) {
                    value43 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{113, value43}, null, null);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int value44 = DataCanbus.DATA[178];
                if (value44 == 129) {
                    value2 = 4;
                } else {
                    value2 = value44 - 1;
                }
                if (value2 < 1) {
                    value2 = 129;
                }
                DataCanbus.PROXY.cmd(1, new int[]{114, value2}, null, null);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int value45 = DataCanbus.DATA[178];
                if (value45 == 4) {
                    value = 129;
                } else {
                    value = value45 + 1;
                }
                if (value > 129) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{114, value}, null, null);
                break;
            case R.id.btn_minus23 /* 2131427607 */:
                int value46 = DataCanbus.DATA[187] - 1;
                if (value46 < 1) {
                    value46 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{160, value46}, null, null);
                break;
            case R.id.btn_plus23 /* 2131427609 */:
                int value47 = DataCanbus.DATA[187] + 1;
                if (value47 > 2) {
                    value47 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{160, value47}, null, null);
                break;
            case R.id.btn_minus24 /* 2131427610 */:
                int value48 = DataCanbus.DATA[188] - 1;
                if (value48 < 1) {
                    value48 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{161, value48}, null, null);
                break;
            case R.id.btn_plus24 /* 2131427612 */:
                int value49 = DataCanbus.DATA[188] + 1;
                if (value49 > 2) {
                    value49 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{161, value49}, null, null);
                break;
            case R.id.btn_minus25 /* 2131427613 */:
                int value50 = DataCanbus.DATA[189] - 1;
                if (value50 < 1) {
                    value50 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{162, value50}, null, null);
                break;
            case R.id.btn_plus25 /* 2131427615 */:
                int value51 = DataCanbus.DATA[189] + 1;
                if (value51 > 2) {
                    value51 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{162, value51}, null, null);
                break;
            case R.id.btn_minus26 /* 2131427617 */:
                int value52 = DataCanbus.DATA[190] - 1;
                if (value52 < 1) {
                    value52 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value52}, null, null);
                break;
            case R.id.btn_plus26 /* 2131427619 */:
                int value53 = DataCanbus.DATA[190] + 1;
                if (value53 > 2) {
                    value53 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value53}, null, null);
                break;
            case R.id.btn_minus27 /* 2131427620 */:
                int value54 = DataCanbus.DATA[191] - 1;
                if (value54 < 1) {
                    value54 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{164, value54}, null, null);
                break;
            case R.id.btn_plus27 /* 2131427622 */:
                int value55 = DataCanbus.DATA[191] + 1;
                if (value55 > 3) {
                    value55 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{164, value55}, null, null);
                break;
            case R.id.btn_minus28 /* 2131427623 */:
                int value56 = DataCanbus.DATA[196];
                if (value56 > 0) {
                    value56--;
                }
                DataCanbus.PROXY.cmd(9, new int[]{value56}, null, null);
                break;
            case R.id.btn_plus28 /* 2131427625 */:
                int value57 = DataCanbus.DATA[196];
                if (value57 < 75) {
                    value57++;
                }
                DataCanbus.PROXY.cmd(9, new int[]{value57}, null, null);
                break;
            case R.id.btn_minus29 /* 2131427627 */:
                int value58 = DataCanbus.DATA[199] - 1;
                if (value58 < 1) {
                    value58 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{38, value58}, null, null);
                break;
            case R.id.btn_plus29 /* 2131427629 */:
                int value59 = DataCanbus.DATA[199] + 1;
                if (value59 > 2) {
                    value59 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{38, value59}, null, null);
                break;
            case R.id.btn_minus30 /* 2131427630 */:
                int value60 = DataCanbus.DATA[204] - 1;
                if (value60 < 1) {
                    value60 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{43, value60}, null, null);
                break;
            case R.id.btn_plus30 /* 2131427632 */:
                int value61 = DataCanbus.DATA[204] + 1;
                if (value61 > 3) {
                    value61 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{43, value61}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value62 = DataCanbus.DATA[110];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 3;
                iArr8[1] = value62 == 1 ? 2 : 1;
                remoteModuleProxy8.cmd(1, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value63 = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 4;
                iArr9[1] = value63 == 1 ? 2 : 1;
                remoteModuleProxy9.cmd(1, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value64 = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 6;
                iArr10[1] = value64 == 1 ? 2 : 1;
                remoteModuleProxy10.cmd(1, iArr10, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value65 = DataCanbus.DATA[157];
                RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                int[] iArr11 = new int[2];
                iArr11[0] = 34;
                iArr11[1] = value65 == 1 ? 2 : 1;
                remoteModuleProxy11.cmd(1, iArr11, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value66 = DataCanbus.DATA[158];
                RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                int[] iArr12 = new int[2];
                iArr12[0] = 35;
                iArr12[1] = value66 == 1 ? 2 : 1;
                remoteModuleProxy12.cmd(1, iArr12, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value67 = DataCanbus.DATA[160];
                RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                int[] iArr13 = new int[2];
                iArr13[0] = 49;
                iArr13[1] = value67 == 1 ? 2 : 1;
                remoteModuleProxy13.cmd(1, iArr13, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value68 = DataCanbus.DATA[161];
                RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                int[] iArr14 = new int[2];
                iArr14[0] = 50;
                iArr14[1] = value68 == 1 ? 2 : 1;
                remoteModuleProxy14.cmd(1, iArr14, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int value69 = DataCanbus.DATA[162];
                RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                int[] iArr15 = new int[2];
                iArr15[0] = 51;
                iArr15[1] = value69 == 1 ? 2 : 1;
                remoteModuleProxy15.cmd(1, iArr15, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value70 = DataCanbus.DATA[163];
                RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                int[] iArr16 = new int[2];
                iArr16[0] = 52;
                iArr16[1] = value70 == 1 ? 2 : 1;
                remoteModuleProxy16.cmd(1, iArr16, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value71 = DataCanbus.DATA[164];
                RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                int[] iArr17 = new int[2];
                iArr17[0] = 53;
                iArr17[1] = value71 == 1 ? 2 : 1;
                remoteModuleProxy17.cmd(1, iArr17, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value72 = DataCanbus.DATA[165];
                RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                int[] iArr18 = new int[2];
                iArr18[0] = 54;
                iArr18[1] = value72 == 1 ? 2 : 1;
                remoteModuleProxy18.cmd(1, iArr18, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value73 = DataCanbus.DATA[168];
                RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                int[] iArr19 = new int[2];
                iArr19[0] = 64;
                iArr19[1] = value73 == 1 ? 2 : 1;
                remoteModuleProxy19.cmd(1, iArr19, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value74 = DataCanbus.DATA[114];
                RemoteModuleProxy remoteModuleProxy20 = DataCanbus.PROXY;
                int[] iArr20 = new int[2];
                iArr20[0] = 7;
                iArr20[1] = value74 == 1 ? 2 : 1;
                remoteModuleProxy20.cmd(1, iArr20, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value75 = DataCanbus.DATA[170];
                RemoteModuleProxy remoteModuleProxy21 = DataCanbus.PROXY;
                int[] iArr21 = new int[2];
                iArr21[0] = 96;
                iArr21[1] = value75 == 1 ? 2 : 1;
                remoteModuleProxy21.cmd(1, iArr21, null, null);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value76 = DataCanbus.DATA[172];
                RemoteModuleProxy remoteModuleProxy22 = DataCanbus.PROXY;
                int[] iArr22 = new int[2];
                iArr22[0] = 98;
                iArr22[1] = value76 == 1 ? 2 : 1;
                remoteModuleProxy22.cmd(1, iArr22, null, null);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int value77 = DataCanbus.DATA[175];
                RemoteModuleProxy remoteModuleProxy23 = DataCanbus.PROXY;
                int[] iArr23 = new int[2];
                iArr23[0] = 18;
                iArr23[1] = value77 == 1 ? 2 : 1;
                remoteModuleProxy23.cmd(1, iArr23, null, null);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int value78 = DataCanbus.DATA[176];
                RemoteModuleProxy remoteModuleProxy24 = DataCanbus.PROXY;
                int[] iArr24 = new int[2];
                iArr24[0] = 112;
                iArr24[1] = value78 == 1 ? 2 : 1;
                remoteModuleProxy24.cmd(1, iArr24, null, null);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int value79 = DataCanbus.DATA[179];
                RemoteModuleProxy remoteModuleProxy25 = DataCanbus.PROXY;
                int[] iArr25 = new int[2];
                iArr25[0] = 115;
                iArr25[1] = value79 == 1 ? 2 : 1;
                remoteModuleProxy25.cmd(1, iArr25, null, null);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                int value80 = DataCanbus.DATA[180];
                RemoteModuleProxy remoteModuleProxy26 = DataCanbus.PROXY;
                int[] iArr26 = new int[2];
                iArr26[0] = 128;
                iArr26[1] = value80 == 1 ? 2 : 1;
                remoteModuleProxy26.cmd(1, iArr26, null, null);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                int value81 = DataCanbus.DATA[181];
                RemoteModuleProxy remoteModuleProxy27 = DataCanbus.PROXY;
                int[] iArr27 = new int[2];
                iArr27[0] = 129;
                iArr27[1] = value81 == 1 ? 2 : 1;
                remoteModuleProxy27.cmd(1, iArr27, null, null);
                break;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                int value82 = DataCanbus.DATA[182];
                RemoteModuleProxy remoteModuleProxy28 = DataCanbus.PROXY;
                int[] iArr28 = new int[2];
                iArr28[0] = 130;
                iArr28[1] = value82 == 1 ? 2 : 1;
                remoteModuleProxy28.cmd(1, iArr28, null, null);
                break;
            case R.id.btn_minus31 /* 2131427828 */:
                int value83 = DataCanbus.DATA[205] - 1;
                if (value83 < 1) {
                    value83 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{44, value83}, null, null);
                break;
            case R.id.btn_plus31 /* 2131427829 */:
                int value84 = DataCanbus.DATA[205] + 1;
                if (value84 > 3) {
                    value84 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{44, value84}, null, null);
                break;
            case R.id.btn_minus32 /* 2131427830 */:
                int value85 = DataCanbus.DATA[207] - 1;
                if (value85 < 1) {
                    value85 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{46, value85}, null, null);
                break;
            case R.id.btn_plus32 /* 2131427831 */:
                int value86 = DataCanbus.DATA[207] + 1;
                if (value86 > 3) {
                    value86 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{46, value86}, null, null);
                break;
            case R.id.btn_minus33 /* 2131427832 */:
                int value87 = DataCanbus.DATA[209];
                if (value87 > 1) {
                    value87--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{58, value87}, null, null);
                break;
            case R.id.btn_plus33 /* 2131427833 */:
                int value88 = DataCanbus.DATA[209];
                if (value88 < 20) {
                    value88++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{58, value88}, null, null);
                break;
            case R.id.btn_minus34 /* 2131427834 */:
                int value89 = DataCanbus.DATA[216] - 1;
                if (value89 < 1) {
                    value89 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{116, value89}, null, null);
                break;
            case R.id.btn_plus34 /* 2131427835 */:
                int value90 = DataCanbus.DATA[216] + 1;
                if (value90 > 2) {
                    value90 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{116, value90}, null, null);
                break;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                int value91 = DataCanbus.DATA[183];
                RemoteModuleProxy remoteModuleProxy29 = DataCanbus.PROXY;
                int[] iArr29 = new int[2];
                iArr29[0] = 131;
                iArr29[1] = value91 == 1 ? 2 : 1;
                remoteModuleProxy29.cmd(1, iArr29, null, null);
                break;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                int value92 = DataCanbus.DATA[184];
                RemoteModuleProxy remoteModuleProxy30 = DataCanbus.PROXY;
                int[] iArr30 = new int[2];
                iArr30[0] = 144;
                iArr30[1] = value92 == 1 ? 2 : 1;
                remoteModuleProxy30.cmd(1, iArr30, null, null);
                break;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                int value93 = DataCanbus.DATA[185];
                RemoteModuleProxy remoteModuleProxy31 = DataCanbus.PROXY;
                int[] iArr31 = new int[2];
                iArr31[0] = 145;
                iArr31[1] = value93 == 1 ? 2 : 1;
                remoteModuleProxy31.cmd(1, iArr31, null, null);
                break;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                int value94 = DataCanbus.DATA[186];
                RemoteModuleProxy remoteModuleProxy32 = DataCanbus.PROXY;
                int[] iArr32 = new int[2];
                iArr32[0] = 146;
                iArr32[1] = value94 == 1 ? 2 : 1;
                remoteModuleProxy32.cmd(1, iArr32, null, null);
                break;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                dialog(R.string.all_settings, 255);
                break;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                int value95 = DataCanbus.DATA[197];
                RemoteModuleProxy remoteModuleProxy33 = DataCanbus.PROXY;
                int[] iArr33 = new int[2];
                iArr33[0] = 36;
                iArr33[1] = value95 == 1 ? 2 : 1;
                remoteModuleProxy33.cmd(1, iArr33, null, null);
                break;
            case R.id.ctv_checkedtext36 /* 2131427844 */:
                int value96 = DataCanbus.DATA[198];
                RemoteModuleProxy remoteModuleProxy34 = DataCanbus.PROXY;
                int[] iArr34 = new int[2];
                iArr34[0] = 37;
                iArr34[1] = value96 == 1 ? 2 : 1;
                remoteModuleProxy34.cmd(1, iArr34, null, null);
                break;
            case R.id.ctv_checkedtext37 /* 2131427855 */:
                int value97 = DataCanbus.DATA[200];
                RemoteModuleProxy remoteModuleProxy35 = DataCanbus.PROXY;
                int[] iArr35 = new int[2];
                iArr35[0] = 39;
                iArr35[1] = value97 == 1 ? 2 : 1;
                remoteModuleProxy35.cmd(1, iArr35, null, null);
                break;
            case R.id.ctv_checkedtext38 /* 2131427856 */:
                int value98 = DataCanbus.DATA[201];
                RemoteModuleProxy remoteModuleProxy36 = DataCanbus.PROXY;
                int[] iArr36 = new int[2];
                iArr36[0] = 40;
                iArr36[1] = value98 == 1 ? 2 : 1;
                remoteModuleProxy36.cmd(1, iArr36, null, null);
                break;
            case R.id.ctv_checkedtext39 /* 2131427857 */:
                int value99 = DataCanbus.DATA[202];
                RemoteModuleProxy remoteModuleProxy37 = DataCanbus.PROXY;
                int[] iArr37 = new int[2];
                iArr37[0] = 41;
                iArr37[1] = value99 == 1 ? 2 : 1;
                remoteModuleProxy37.cmd(1, iArr37, null, null);
                break;
            case R.id.ctv_checkedtext40 /* 2131427858 */:
                int value100 = DataCanbus.DATA[203];
                RemoteModuleProxy remoteModuleProxy38 = DataCanbus.PROXY;
                int[] iArr38 = new int[2];
                iArr38[0] = 42;
                iArr38[1] = value100 == 1 ? 2 : 1;
                remoteModuleProxy38.cmd(1, iArr38, null, null);
                break;
            case R.id.ctv_checkedtext41 /* 2131427859 */:
                int value101 = DataCanbus.DATA[206];
                RemoteModuleProxy remoteModuleProxy39 = DataCanbus.PROXY;
                int[] iArr39 = new int[2];
                iArr39[0] = 45;
                iArr39[1] = value101 == 1 ? 2 : 1;
                remoteModuleProxy39.cmd(1, iArr39, null, null);
                break;
            case R.id.ctv_checkedtext42 /* 2131427860 */:
                dialog(1, 57);
                break;
            case R.id.ctv_checkedtext43 /* 2131427861 */:
                int value102 = DataCanbus.DATA[210];
                RemoteModuleProxy remoteModuleProxy40 = DataCanbus.PROXY;
                int[] iArr40 = new int[2];
                iArr40[0] = 65;
                iArr40[1] = value102 == 1 ? 2 : 1;
                remoteModuleProxy40.cmd(1, iArr40, null, null);
                break;
            case R.id.ctv_checkedtext44 /* 2131427875 */:
                int value103 = DataCanbus.DATA[211];
                RemoteModuleProxy remoteModuleProxy41 = DataCanbus.PROXY;
                int[] iArr41 = new int[2];
                iArr41[0] = 66;
                iArr41[1] = value103 == 1 ? 2 : 1;
                remoteModuleProxy41.cmd(1, iArr41, null, null);
                break;
            case R.id.ctv_checkedtext45 /* 2131427876 */:
                int value104 = DataCanbus.DATA[212];
                RemoteModuleProxy remoteModuleProxy42 = DataCanbus.PROXY;
                int[] iArr42 = new int[2];
                iArr42[0] = 67;
                iArr42[1] = value104 == 1 ? 2 : 1;
                remoteModuleProxy42.cmd(1, iArr42, null, null);
                break;
            case R.id.ctv_checkedtext46 /* 2131427877 */:
                int value105 = DataCanbus.DATA[213];
                RemoteModuleProxy remoteModuleProxy43 = DataCanbus.PROXY;
                int[] iArr43 = new int[2];
                iArr43[0] = 68;
                iArr43[1] = value105 == 1 ? 2 : 1;
                remoteModuleProxy43.cmd(1, iArr43, null, null);
                break;
            case R.id.ctv_checkedtext47 /* 2131427878 */:
                int value106 = DataCanbus.DATA[214];
                RemoteModuleProxy remoteModuleProxy44 = DataCanbus.PROXY;
                int[] iArr44 = new int[2];
                iArr44[0] = 69;
                iArr44[1] = value106 == 1 ? 2 : 1;
                remoteModuleProxy44.cmd(1, iArr44, null, null);
                break;
            case R.id.ctv_checkedtext48 /* 2131427879 */:
                int value107 = DataCanbus.DATA[215];
                RemoteModuleProxy remoteModuleProxy45 = DataCanbus.PROXY;
                int[] iArr45 = new int[2];
                iArr45[0] = 99;
                iArr45[1] = value107 == 1 ? 2 : 1;
                remoteModuleProxy45.cmd(1, iArr45, null, null);
                break;
            case R.id.ctv_checkedtext49 /* 2131427880 */:
                int value108 = DataCanbus.DATA[217];
                RemoteModuleProxy remoteModuleProxy46 = DataCanbus.PROXY;
                int[] iArr46 = new int[2];
                iArr46[0] = 117;
                iArr46[1] = value108 == 1 ? 2 : 1;
                remoteModuleProxy46.cmd(1, iArr46, null, null);
                break;
            case R.id.ctv_checkedtext50 /* 2131427881 */:
                int value109 = DataCanbus.DATA[218];
                RemoteModuleProxy remoteModuleProxy47 = DataCanbus.PROXY;
                int[] iArr47 = new int[2];
                iArr47[0] = 132;
                iArr47[1] = value109 == 1 ? 2 : 1;
                remoteModuleProxy47.cmd(1, iArr47, null, null);
                break;
            case R.id.ctv_checkedtext51 /* 2131427897 */:
                int value110 = DataCanbus.DATA[219];
                RemoteModuleProxy remoteModuleProxy48 = DataCanbus.PROXY;
                int[] iArr48 = new int[2];
                iArr48[0] = 147;
                iArr48[1] = value110 == 1 ? 2 : 1;
                remoteModuleProxy48.cmd(1, iArr48, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{82, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempCtrl() {
        int value = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
    }

    protected void updateRearViewMode() {
        int value = DataCanbus.DATA[107];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_394_all_view);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_394_rear_view_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_394_rear_view_2);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_394_rear_view_3);
                break;
        }
    }

    protected void updateFrontViewMode() {
        int value = DataCanbus.DATA[106];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_394_all_view);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_394_front_view_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_394_front_view_2);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_394_front_view_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadarOn() {
        int value = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGuijiOn() {
        int value = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (stringId == 1) {
            builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " Service Interval " + getResources().getString(R.string.data));
        } else {
            builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        }
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
