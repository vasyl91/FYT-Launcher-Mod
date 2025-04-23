package com.syu.carinfo.wc.infeinidi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.util.ArrayList;

public class WcInfeinidiCarSet extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 30:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 113:
                    WcInfeinidiCarSet.this.updateText10(val);
                    break;
                case 114:
                    WcInfeinidiCarSet.this.updateText11(val);
                    break;
                case 115:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 116:
                    WcInfeinidiCarSet.this.updateText12(val);
                    break;
                case 117:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 118:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 119:
                    WcInfeinidiCarSet.this.updateText1(val);
                    break;
                case 120:
                    WcInfeinidiCarSet.this.updateText2(val);
                    break;
                case 121:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 122:
                    WcInfeinidiCarSet.this.updateText3(val);
                    break;
                case 123:
                    WcInfeinidiCarSet.this.updateText4(val);
                    break;
                case 124:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 125:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 127:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 128:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 129:
                    WcInfeinidiCarSet.this.updateText5(val);
                    break;
                case 130:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 131:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 132:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 133:
                    WcInfeinidiCarSet.this.updateText6(val);
                    break;
                case 134:
                    WcInfeinidiCarSet.this.updateText7(val);
                    break;
                case 135:
                    WcInfeinidiCarSet.this.updateText8(val);
                    break;
                case 136:
                    WcInfeinidiCarSet.this.updateText9(val);
                    break;
                case 161:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 162:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.speed_warning);
                                break;
                            case 2:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.str_focus_warm_13_6);
                                break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.str_boyue_str3);
                                break;
                            case 2:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text15)).setText(R.string.lock_set_autounlock_by_shift_to_p);
                                break;
                        }
                    }
                    break;
                case 164:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text16)).setText("Convenience");
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text16)).setText("Safety");
                                break;
                        }
                    }
                    break;
                case 165:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 166:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 167:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 168:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
                case 169:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext19), val == 1);
                    break;
                case 170:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext20), val == 1);
                    break;
                case 171:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 172:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.driver_system_sports);
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text19)).setText(R.string.str_17_snow);
                                break;
                        }
                    }
                    break;
                case 173:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext21), val == 1);
                    break;
                case 174:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text20)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 175:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext22), val == 1);
                    break;
                case 176:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.str_light_state);
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text21)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 177:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 178:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text22)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text22)).setText(CamryData.PRESSURE_UNIT_KPA);
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text22)).setText("psi");
                                break;
                            case 2:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text22)).setText("bar");
                                break;
                            case 3:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text22)).setText("KGF/CM2");
                                break;
                        }
                    }
                    break;
                case 179:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text23)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text23)).setText("KM/L");
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text23)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                        }
                    }
                    break;
                case 180:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text24)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text24)).setText("℃");
                                break;
                            case 1:
                                ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text24)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 181:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext23), val == 1);
                    break;
                case 182:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append((val * 10) + 190).toString());
                        break;
                    }
                case 183:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text26)) != null) {
                        ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text26)).setText(new StringBuilder().append((val * 10) + 190).toString());
                        break;
                    }
                case 184:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext24), val == 1);
                    break;
                case 185:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext25), val == 1);
                    break;
                case 186:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext26), val == 1);
                    break;
                case 187:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext27), val == 1);
                    break;
                case 188:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext28), val == 1);
                    break;
                case 189:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext29), val == 1);
                    break;
                case 190:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext30), val == 1);
                    break;
                case 191:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext31), val == 1);
                    break;
                case 192:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext32), val == 1);
                    break;
                case 193:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext33), val == 1);
                    break;
                case 194:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext34), val == 1);
                    break;
                case 195:
                    WcInfeinidiCarSet.this.setCheck((CheckedTextView) WcInfeinidiCarSet.this.findViewById(R.id.ctv_checkedtext36), val == 1);
                    break;
                case 196:
                    if (((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text27)) != null) {
                        if (val == 1) {
                            ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.str_244_als2);
                            break;
                        } else {
                            ((TextView) WcInfeinidiCarSet.this.findViewById(R.id.tv_text27)).setText(R.string.str_244_als1);
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_infeinidi_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
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
                WcInfeinidiCarSet.this.language_set = position;
                if (WcInfeinidiCarSet.this.language_set >= 0 && WcInfeinidiCarSet.this.language_set <= WcInfeinidiCarSet.this.mLauStylelist.size() && WcInfeinidiCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(7, new int[]{1, WcInfeinidiCarSet.this.send_lang[WcInfeinidiCarSet.this.language_set]}, null, null);
                }
                WcInfeinidiCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{1, 2, 3, 17, 18};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (WcInfeinidiCarSet.this.mLauStyle == null) {
                    WcInfeinidiCarSet.this.initLauStyle();
                }
                if (WcInfeinidiCarSet.this.mLauStyle != null && WcInfeinidiCarSet.this.mPopShowView != null) {
                    WcInfeinidiCarSet.this.mLauStyle.showAtLocation(WcInfeinidiCarSet.this.mPopShowView, 17, 0, 0);
                    WcInfeinidiCarSet.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), this);
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
    }

    public void initview() {
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(0);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view63).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    findViewById(R.id.layout_text_view1).setVisibility(0);
                    findViewById(R.id.layout_view1).setVisibility(0);
                    findViewById(R.id.layout_view2).setVisibility(0);
                    findViewById(R.id.layout_view3).setVisibility(0);
                    findViewById(R.id.layout_text_view2).setVisibility(0);
                    findViewById(R.id.layout_view4).setVisibility(0);
                    findViewById(R.id.layout_view5).setVisibility(0);
                    findViewById(R.id.layout_view6).setVisibility(0);
                    findViewById(R.id.layout_view7).setVisibility(0);
                    findViewById(R.id.layout_text_view3).setVisibility(0);
                    findViewById(R.id.layout_view8).setVisibility(0);
                    findViewById(R.id.layout_view19).setVisibility(0);
                    break;
                } else {
                    findViewById(R.id.layout_text_view1).setVisibility(0);
                    findViewById(R.id.layout_view1).setVisibility(0);
                    findViewById(R.id.layout_view2).setVisibility(0);
                    findViewById(R.id.layout_view3).setVisibility(0);
                    findViewById(R.id.layout_view25).setVisibility(0);
                    findViewById(R.id.layout_view26).setVisibility(0);
                    findViewById(R.id.layout_view13).setVisibility(0);
                    findViewById(R.id.layout_view14).setVisibility(0);
                    findViewById(R.id.layout_text_view2).setVisibility(0);
                    findViewById(R.id.layout_view4).setVisibility(0);
                    findViewById(R.id.layout_view5).setVisibility(0);
                    findViewById(R.id.layout_view6).setVisibility(0);
                    findViewById(R.id.layout_text_view3).setVisibility(0);
                    findViewById(R.id.layout_view7).setVisibility(0);
                    findViewById(R.id.layout_view8).setVisibility(0);
                    findViewById(R.id.layout_view9).setVisibility(0);
                    findViewById(R.id.layout_view10).setVisibility(0);
                    findViewById(R.id.layout_view27).setVisibility(0);
                    findViewById(R.id.layout_view28).setVisibility(0);
                    findViewById(R.id.layout_view29).setVisibility(0);
                    findViewById(R.id.layout_view30).setVisibility(0);
                    findViewById(R.id.layout_view31).setVisibility(0);
                    findViewById(R.id.layout_view32).setVisibility(0);
                    findViewById(R.id.layout_view33).setVisibility(0);
                    findViewById(R.id.layout_view34).setVisibility(0);
                    findViewById(R.id.layout_view35).setVisibility(0);
                    findViewById(R.id.layout_view38).setVisibility(0);
                    findViewById(R.id.layout_view39).setVisibility(0);
                    findViewById(R.id.layout_view40).setVisibility(0);
                    findViewById(R.id.layout_view41).setVisibility(0);
                    findViewById(R.id.layout_view42).setVisibility(0);
                    findViewById(R.id.layout_view43).setVisibility(0);
                    findViewById(R.id.layout_text_view4).setVisibility(0);
                    findViewById(R.id.layout_view15).setVisibility(0);
                    findViewById(R.id.layout_view16).setVisibility(0);
                    findViewById(R.id.layout_view17).setVisibility(0);
                    findViewById(R.id.layout_view18).setVisibility(0);
                    findViewById(R.id.layout_text_view6).setVisibility(0);
                    findViewById(R.id.layout_view44).setVisibility(0);
                    findViewById(R.id.layout_view45).setVisibility(0);
                    findViewById(R.id.layout_view46).setVisibility(0);
                    findViewById(R.id.layout_view47).setVisibility(0);
                    findViewById(R.id.layout_view48).setVisibility(0);
                    findViewById(R.id.layout_view49).setVisibility(0);
                    findViewById(R.id.layout_view50).setVisibility(0);
                    findViewById(R.id.layout_view51).setVisibility(0);
                    findViewById(R.id.layout_view52).setVisibility(0);
                    findViewById(R.id.layout_view53).setVisibility(0);
                    findViewById(R.id.layout_view54).setVisibility(0);
                    findViewById(R.id.layout_view55).setVisibility(0);
                    findViewById(R.id.layout_view56).setVisibility(0);
                    findViewById(R.id.layout_view57).setVisibility(0);
                    findViewById(R.id.layout_view58).setVisibility(0);
                    findViewById(R.id.layout_view59).setVisibility(0);
                    findViewById(R.id.layout_view60).setVisibility(0);
                    findViewById(R.id.layout_view61).setVisibility(0);
                    findViewById(R.id.layout_view62).setVisibility(0);
                    break;
                }
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_15Q70 /* 4129211 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l /* 4325819 */:
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_20QX60 /* 15204795 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_view60).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[119] - 1;
                if (value < 1) {
                    value = 4;
                }
                setCarInfo(2, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[119] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                setCarInfo(2, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[120] - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                setCarInfo(3, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[120] + 1;
                if (value4 > 4) {
                    value4 = 1;
                }
                setCarInfo(3, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[122] - 1;
                if (value5 < 1) {
                    value5 = 4;
                }
                setCarInfo(5, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[122] + 1;
                if (value6 > 4) {
                    value6 = 1;
                }
                setCarInfo(5, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[123] - 1;
                if (value7 < 0) {
                    value7 = 7;
                }
                setCarInfo(6, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[123] + 1;
                if (value8 > 7) {
                    value8 = 0;
                }
                setCarInfo(6, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[130] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(13, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[130] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(13, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[133] - 1;
                if (value11 < 1) {
                    value11 = 3;
                }
                setCarInfo(17, value11, 255, 255);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[133] + 1;
                if (value12 > 3) {
                    value12 = 1;
                }
                setCarInfo(17, value12, 255, 255);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[134] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(18, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[134] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(18, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[135] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(19, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[135] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(19, value16, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[136] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(20, value17, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[136] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(20, value18, 255, 255);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[113] - 1;
                if (value19 < 1) {
                    value19 = 5;
                }
                setCarInfo2(3, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[113] + 1;
                if (value20 > 5) {
                    value20 = 1;
                }
                setCarInfo2(3, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[114] - 1;
                if (value21 < 1) {
                    value21 = 5;
                }
                setCarInfo2(11, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[114] + 1;
                if (value22 > 5) {
                    value22 = 1;
                }
                setCarInfo2(11, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[116] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo2(22, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[116] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo2(22, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[171] - 1;
                if (value25 < 1) {
                    value25 = 3;
                }
                setCarInfo(31, value25, 255, 255);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[171] + 1;
                if (value26 > 3) {
                    value26 = 1;
                }
                setCarInfo(31, value26, 255, 255);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[162] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(22, value27, 255, 255);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[162] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(22, value28, 255, 255);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[163] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(23, value29, 255, 255);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[163] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(23, value30, 255, 255);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[164] - 1;
                if (value31 < 0) {
                    value31 = 1;
                }
                setCarInfo(24, value31, 255, 255);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[164] + 1;
                if (value32 > 1) {
                    value32 = 0;
                }
                setCarInfo(24, value32, 255, 255);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
            case R.id.btn_plus17 /* 2131427523 */:
                setCarAir(17);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[118];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(1, value33, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[121];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(4, value34, 255, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value35 = DataCanbus.DATA[124];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(7, value35, 255, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value36 = DataCanbus.DATA[125];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(8, value36, 255, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value37 = DataCanbus.DATA[127];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(10, value37, 255, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value38 = DataCanbus.DATA[128];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(11, value38, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value39 = DataCanbus.DATA[130];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(14, value39, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value40 = DataCanbus.DATA[131];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(15, value40, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value41 = DataCanbus.DATA[132];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(16, value41, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                dialog(R.string.all_settings, 9, 2);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value42 = DataCanbus.DATA[115];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo2(21, value42);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value43 = DataCanbus.DATA[117];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo2(23, value43);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value44 = DataCanbus.DATA[177];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(32, value44, 255, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value45 = DataCanbus.DATA[161];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(21, value45, 255, 255);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value46 = DataCanbus.DATA[165];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(25, value46, 255, 255);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value47 = DataCanbus.DATA[166];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(26, value47, 255, 255);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value48 = DataCanbus.DATA[167];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(27, value48, 255, 255);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value49 = DataCanbus.DATA[168];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(28, value49, 255, 255);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value50 = DataCanbus.DATA[169];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(29, value50, 255, 255);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value51 = DataCanbus.DATA[170];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(30, value51, 255, 255);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value52 = DataCanbus.DATA[173];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(34, value52, 255, 255);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value53 = DataCanbus.DATA[175];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(36, value53, 255, 255);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value54 = DataCanbus.DATA[181];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo3(7, value54, 255, 255);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value55 = DataCanbus.DATA[184];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo3(8, value55, 255, 255);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value56 = DataCanbus.DATA[185];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo3(9, value56, 255, 255);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value57 = DataCanbus.DATA[186];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo3(10, value57, 255, 255);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value58 = DataCanbus.DATA[187];
                if (value58 == 1) {
                    value58 = 0;
                } else if (value58 == 0) {
                    value58 = 1;
                }
                setCarInfo3(11, value58, 255, 255);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                int value59 = DataCanbus.DATA[192];
                if (value59 == 1) {
                    value59 = 0;
                } else if (value59 == 0) {
                    value59 = 1;
                }
                setCarInfo3(16, value59, 255, 255);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                int value60 = DataCanbus.DATA[189];
                if (value60 == 1) {
                    value60 = 0;
                } else if (value60 == 0) {
                    value60 = 1;
                }
                setCarInfo3(13, value60, 255, 255);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
            case R.id.btn_plus18 /* 2131427895 */:
                setCarAir(18);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value61 = DataCanbus.DATA[172] - 1;
                if (value61 < 0) {
                    value61 = 2;
                }
                setCarInfo(33, value61, 255, 255);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value62 = DataCanbus.DATA[172] + 1;
                if (value62 > 2) {
                    value62 = 0;
                }
                setCarInfo(33, value62, 255, 255);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value63 = DataCanbus.DATA[176] - 1;
                if (value63 < 0) {
                    value63 = 2;
                }
                setCarInfo(37, value63, 255, 255);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value64 = DataCanbus.DATA[176] + 1;
                if (value64 > 2) {
                    value64 = 0;
                }
                setCarInfo(37, value64, 255, 255);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                int value65 = DataCanbus.DATA[178] - 1;
                if (value65 < 0) {
                    value65 = 3;
                }
                setCarInfo3(2, value65, 255, 255);
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                int value66 = DataCanbus.DATA[178] + 1;
                if (value66 > 3) {
                    value66 = 0;
                }
                setCarInfo3(2, value66, 255, 255);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                int value67 = DataCanbus.DATA[190];
                if (value67 == 1) {
                    value67 = 0;
                } else if (value67 == 0) {
                    value67 = 1;
                }
                setCarInfo3(14, value67, 255, 255);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                int value68 = DataCanbus.DATA[191];
                if (value68 == 1) {
                    value68 = 0;
                } else if (value68 == 0) {
                    value68 = 1;
                }
                setCarInfo3(15, value68, 255, 255);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                int value69 = DataCanbus.DATA[188];
                if (value69 == 1) {
                    value69 = 0;
                } else if (value69 == 0) {
                    value69 = 1;
                }
                setCarInfo3(12, value69, 255, 255);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value70 = DataCanbus.DATA[174] - 1;
                if (value70 < 0) {
                    value70 = 1;
                }
                setCarInfo(35, value70, 255, 255);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value71 = DataCanbus.DATA[174] + 1;
                if (value71 > 1) {
                    value71 = 0;
                }
                setCarInfo(35, value71, 255, 255);
                break;
            case R.id.btn_plus25 /* 2131427926 */:
                int value72 = DataCanbus.DATA[182] + 1;
                if (value72 > 15) {
                    value72 = 1;
                }
                setCarInfo3(3, value72, 255, 255);
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                int value73 = DataCanbus.DATA[180] + 1;
                if (value73 > 1) {
                    value73 = 0;
                }
                setCarInfo3(6, value73, 255, 255);
                break;
            case R.id.btn_plus26 /* 2131427928 */:
                int value74 = DataCanbus.DATA[183] + 1;
                if (value74 > 15) {
                    value74 = 1;
                }
                setCarInfo3(4, value74, 255, 255);
                break;
            case R.id.btn_plus27 /* 2131427929 */:
                int value75 = DataCanbus.DATA[196] + 1;
                if (value75 > 1) {
                    value75 = 0;
                }
                setCarInfo3(19, value75, 255, 255);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value76 = DataCanbus.DATA[179] + 1;
                if (value76 > 1) {
                    value76 = 0;
                }
                setCarInfo3(5, value76, 255, 255);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                int value77 = DataCanbus.DATA[193];
                if (value77 == 1) {
                    value77 = 0;
                } else if (value77 == 0) {
                    value77 = 1;
                }
                setCarInfo3(17, value77, 255, 255);
                break;
            case R.id.btn_minus25 /* 2131428303 */:
                int value78 = DataCanbus.DATA[182] - 1;
                if (value78 < 1) {
                    value78 = 15;
                }
                setCarInfo3(3, value78, 255, 255);
                break;
            case R.id.btn_minus26 /* 2131428304 */:
                int value79 = DataCanbus.DATA[183] - 1;
                if (value79 < 1) {
                    value79 = 15;
                }
                setCarInfo3(4, value79, 255, 255);
                break;
            case R.id.btn_minus27 /* 2131428305 */:
                int value80 = DataCanbus.DATA[196] - 1;
                if (value80 < 0) {
                    value80 = 1;
                }
                setCarInfo3(19, value80, 255, 255);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value81 = DataCanbus.DATA[179] - 1;
                if (value81 < 0) {
                    value81 = 1;
                }
                setCarInfo3(5, value81, 255, 255);
                break;
            case R.id.btn_minus24 /* 2131428307 */:
                int value82 = DataCanbus.DATA[180] - 1;
                if (value82 < 0) {
                    value82 = 1;
                }
                setCarInfo3(6, value82, 255, 255);
                break;
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                int value83 = DataCanbus.DATA[194];
                if (value83 == 1) {
                    value83 = 0;
                } else if (value83 == 0) {
                    value83 = 1;
                }
                setCarInfo3(18, value83, 255, 255);
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                dialog2(R.string.xp_accord9_deflation_warning_system, 1, 6);
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                int value84 = DataCanbus.DATA[195];
                if (value84 == 1) {
                    value84 = 0;
                } else if (value84 == 0) {
                    value84 = 1;
                }
                setCarInfo3(255, value84, 255, 255);
                break;
        }
    }

    void setCarAir(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2, value3, value4}, null, null);
    }

    public void setCarInfo2(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo3(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        initview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.mateng_air_con_profile_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text12)).setText(R.string.mateng_air_con_profile_2);
                    break;
            }
        }
    }

    
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            ((TextView) findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_back_camera_depression);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_side_camera);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_back_camera_wide_angle);
                    break;
            }
        }
    }

    
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_back_camera_depression);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_side_camera);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_back_camera_wide_angle);
                    break;
            }
        }
    }

    
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_back_camera_depression);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_side_camera);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_back_camera_wide_angle);
                    break;
            }
        }
    }

    
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.mateng_air_con_profile_0);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.normal);
                    break;
            }
        }
    }

    
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("45s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text4)).setText("90s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text4)).setText("120s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text4)).setText("150s");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text4)).setText("180s");
                    break;
            }
        }
    }

    
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
        }
    }

    protected void dialog(int stringId, final int cmd, final int cmdid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmdid;
                final int i2 = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 1, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                DataCanbus.PROXY.cmd(cmdid, new int[]{cmd, 0, 255, 255}, null, null);
            }
        });
        builder.create().show();
    }

    protected void dialog2(int stringId, final int cmd, final int cmdid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmdid;
                final int i2 = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 0, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
