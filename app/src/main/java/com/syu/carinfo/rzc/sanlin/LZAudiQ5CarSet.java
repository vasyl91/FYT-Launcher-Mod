package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0452_LZ_Audi_Q5_All;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

public class LZAudiQ5CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit_juli = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 0 || value == 255) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + "V");
                            break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 101:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 102:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("10s");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("20s");
                                break;
                            case 3:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("30s");
                                break;
                            case 4:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("40s");
                                break;
                            case 5:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("50s");
                                break;
                            case 6:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 103:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 104:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 105:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 106:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 107:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 108:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 109:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 110:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 111:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 112:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 113:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 114:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 115:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 116:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 117:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 118:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 119:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 120:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text14)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text14)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 121:
                    LZAudiQ5CarSet.this.unit_juli = value;
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text15)) != null) {
                        if (value == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text15)).setText("mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text15)).setText("km");
                            break;
                        }
                    }
                    break;
                case 122:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text16)).setText("bar");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text16)).setText("psi");
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text17)).setText("km/h");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text17)).setText("mph");
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText("mpg(uk)");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText("mpg(us)");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            case 3:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)).setText("L");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)).setText("gal(uk)");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)).setText("gal(us)");
                                break;
                        }
                    }
                    break;
                case 126:
                    LZAudiQ5CarSet.this.updateLauguageSet();
                    break;
                case 127:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        int value2 = value * 100;
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + "km");
                            break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "Days");
                        break;
                    }
                case 129:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        int value3 = value * 100;
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value3) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value3) + "km");
                            break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "Days");
                        break;
                    }
                case 131:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text24)).setText(Callback_0452_LZ_Audi_Q5_All.CarVinID);
                        break;
                    }
                case 132:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text22)).setText(String.valueOf(value) + "/8");
                        break;
                    }
                case 133:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)).setText("Front");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)).setText("Middle");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)).setText("Rear");
                                break;
                        }
                    }
                    break;
                case 134:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 135:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 136:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 137:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 138:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 139:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 140:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 141:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 142:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 143:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text21)).setText(String.valueOf((value * 10) + 30) + "km/h");
                        break;
                    }
                case 144:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 145:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 146:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 147:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 148:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 149:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 150:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 151:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 152:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_audi_q5_settings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZAudiQ5CarSet.this.language_set = position;
                if (LZAudiQ5CarSet.this.language_set >= 0 && LZAudiQ5CarSet.this.language_set <= LZAudiQ5CarSet.this.mLauStylelist.size() && LZAudiQ5CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{20, LZAudiQ5CarSet.this.send_lang[LZAudiQ5CarSet.this.language_set]}, null, null);
                }
                LZAudiQ5CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[126];
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.send_lang = new int[]{0, 1, 2, 3, 4};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LZAudiQ5CarSet.this.mLauStyle == null) {
                    LZAudiQ5CarSet.this.initLauStyle();
                }
                if (LZAudiQ5CarSet.this.mLauStyle != null && LZAudiQ5CarSet.this.mPopShowView != null) {
                    LZAudiQ5CarSet.this.mLauStyle.showAtLocation(LZAudiQ5CarSet.this.mPopShowView, 17, 0, 0);
                    LZAudiQ5CarSet.this.updateLauguageSet();
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
    }

    protected void dialog2(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{52, i}, null, null);
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

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[102] - 1;
                if (value < 0) {
                    value = 6;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[102] + 1;
                if (value2 > 6) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[115];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(14, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[115];
                if (value4 < 100) {
                    value4++;
                }
                setCarInfo(14, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[116];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(15, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[116];
                if (value6 < 9) {
                    value6++;
                }
                setCarInfo(15, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[117];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[117];
                if (value8 < 9) {
                    value8++;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[118];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(17, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[118];
                if (value10 < 9) {
                    value10++;
                }
                setCarInfo(17, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[119];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(18, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[119];
                if (value12 < 9) {
                    value12++;
                }
                setCarInfo(18, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[120] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(19, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[120] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(19, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[121] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(31, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[121] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(31, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[122] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(21, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[122] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(21, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[123] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(32, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[123] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(32, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[124] - 1;
                if (value21 < 0) {
                    value21 = 3;
                }
                setCarInfo(22, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[124] + 1;
                if (value22 > 3) {
                    value22 = 0;
                }
                setCarInfo(22, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[125] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(23, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[125] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(23, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[133] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(33, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[133] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(33, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[143] - 1;
                if (value27 < 0) {
                    value27 = 21;
                }
                setCarInfo(43, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[143] + 1;
                if (value28 > 21) {
                    value28 = 0;
                }
                setCarInfo(43, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[152] - 1;
                if (value29 < 0) {
                    value29 = 4;
                }
                setCarInfo(53, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[152] + 1;
                if (value30 > 4) {
                    value30 = 0;
                }
                setCarInfo(53, value30);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.str_other_set_Maintenance_Reset, 24);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value31 = DataCanbus.DATA[101];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(0, value31);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value32 = DataCanbus.DATA[103];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(2, value32);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value33 = DataCanbus.DATA[104];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(3, value33);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value34 = DataCanbus.DATA[105];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(4, value34);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value35 = DataCanbus.DATA[106];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(5, value35);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value36 = DataCanbus.DATA[107];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(6, value36);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value37 = DataCanbus.DATA[108];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(7, value37);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value38 = DataCanbus.DATA[109];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(8, value38);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value39 = DataCanbus.DATA[110];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(9, value39);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value40 = DataCanbus.DATA[111];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(10, value40);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value41 = DataCanbus.DATA[112];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(11, value41);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value42 = DataCanbus.DATA[113];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(12, value42);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value43 = DataCanbus.DATA[114];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(13, value43);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                dialog(R.string.str_store_tire_pressures, 29);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                dialog(R.string.str_initialize_tires, 30);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value44 = DataCanbus.DATA[134];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(34, value44);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value45 = DataCanbus.DATA[135];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(35, value45);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value46 = DataCanbus.DATA[136];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(36, value46);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value47 = DataCanbus.DATA[137];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(37, value47);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value48 = DataCanbus.DATA[138];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(38, value48);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value49 = DataCanbus.DATA[139];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(39, value49);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value50 = DataCanbus.DATA[140];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(40, value50);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value51 = DataCanbus.DATA[141];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(41, value51);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value52 = DataCanbus.DATA[142];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(42, value52);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value53 = DataCanbus.DATA[144];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(44, value53);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value54 = DataCanbus.DATA[145];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(45, value54);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                int value55 = DataCanbus.DATA[149];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(49, value55);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                int value56 = DataCanbus.DATA[146];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(46, value56);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                int value57 = DataCanbus.DATA[147];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo(47, value57);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                int value58 = DataCanbus.DATA[148];
                if (value58 == 1) {
                    value58 = 0;
                } else if (value58 == 0) {
                    value58 = 1;
                }
                setCarInfo(48, value58);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                dialog2(R.string.str_car_computer_5, 0);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                int value59 = DataCanbus.DATA[150];
                if (value59 == 1) {
                    value59 = 0;
                } else if (value59 == 0) {
                    value59 = 1;
                }
                setCarInfo(50, value59);
                break;
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                int value60 = DataCanbus.DATA[151];
                if (value60 == 1) {
                    value60 = 0;
                } else if (value60 == 0) {
                    value60 = 1;
                }
                setCarInfo(51, value60);
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                dialog2(R.string.str_car_computer_10, 1);
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZAudiQ5SuspensionSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{15}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{125}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{126}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }
}
