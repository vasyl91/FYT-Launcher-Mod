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
import com.syu.carinfo.mzd.LZ300CButtonSetActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class LuZMaserati300CCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 101:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 102:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 103:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 104:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text2)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                            case 3:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text3)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text3)).setText("30S");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text3)).setText("60S");
                                break;
                            case 3:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text3)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 106:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 107:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 109:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 110:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 111:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 112:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 113:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 114:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 115:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 116:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_presskeyunlock_1);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_presskeyunlock_0);
                                break;
                        }
                    }
                    break;
                case 117:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 118:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text5)).setText("km");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text5)).setText("mil");
                                break;
                        }
                    }
                    break;
                case 119:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 120:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text6)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text6)).setText("45S");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text6)).setText("5min");
                                break;
                            case 3:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text6)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text7)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text7)).setText("60S");
                                break;
                            case 3:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text7)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 122:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 123:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 124:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 125:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 126:
                    LuZMaserati300CCarSet.this.updateLauguageSet();
                    break;
                case 127:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 128:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 129:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 130:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 131:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 132:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 133:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 134:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 135:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text11)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text12)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 139:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_driving_normal);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_driving_sport);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text13)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_blindwarn_1);
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_blindwarn_2);
                                break;
                        }
                    }
                    break;
                case 141:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 142:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 143:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 144:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 145:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 146:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 147:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 148:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext35), value == 1);
                    break;
                case 149:
                    LuZMaserati300CCarSet.this.setCheck((CheckedTextView) LuZMaserati300CCarSet.this.findViewById(R.id.ctv_checkedtext36), value == 1);
                    break;
                case 150:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text15)).setText("km/h");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text15)).setText("mph");
                                break;
                        }
                    }
                    break;
                case 151:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text16)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text16)).setText("l/100km");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text16)).setText("mpg(uk)");
                                break;
                            case 3:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text16)).setText("mpg(us)");
                                break;
                        }
                    }
                    break;
                case 152:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text17)).setText("L");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text17)).setText("gal(uk)");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text17)).setText("gal(us)");
                                break;
                        }
                    }
                    break;
                case 153:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text18)).setText("kpa");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text18)).setText("bar");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text18)).setText("psi");
                                break;
                        }
                    }
                    break;
                case 154:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text19)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text19)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text20)).setText("kw");
                                break;
                            case 1:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text20)).setText("hp(uk)");
                                break;
                            case 2:
                                ((TextView) LuZMaserati300CCarSet.this.findViewById(R.id.tv_text20)).setText("hp(us)");
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
        //setContentView(R.layout.layout_0453_lz_maserati300c_carinfo);
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
                LuZMaserati300CCarSet.this.language_set = position;
                if (LuZMaserati300CCarSet.this.language_set >= 0 && LuZMaserati300CCarSet.this.language_set <= LuZMaserati300CCarSet.this.mLauStylelist.size() && LuZMaserati300CCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, LuZMaserati300CCarSet.this.send_lang[LuZMaserati300CCarSet.this.language_set]}, null, null);
                }
                LuZMaserati300CCarSet.this.mLauStyle.dismiss();
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
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LuZMaserati300CCarSet.this.mLauStyle == null) {
                    LuZMaserati300CCarSet.this.initLauStyle();
                }
                if (LuZMaserati300CCarSet.this.mLauStyle != null && LuZMaserati300CCarSet.this.mPopShowView != null) {
                    LuZMaserati300CCarSet.this.mLauStyle.showAtLocation(LuZMaserati300CCarSet.this.mPopShowView, 17, 0, 0);
                    LuZMaserati300CCarSet.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext38), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[104] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[104] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[105] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[105] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[116] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[116] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[118] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[118] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[120] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(21, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[120] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(21, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[121] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(22, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[121] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(22, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[129] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(34, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[129] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(34, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[135] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(29, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[135] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(29, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[136] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(30, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[136] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(30, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[137] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(31, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[137] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(31, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[138] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(32, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[138] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(32, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = DataCanbus.DATA[139] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(35, value25);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = DataCanbus.DATA[139] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(35, value26);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = DataCanbus.DATA[140] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(36, value27);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = DataCanbus.DATA[140] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(36, value28);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = DataCanbus.DATA[150] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(53, value29);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = DataCanbus.DATA[150] + 1;
                if (value30 > 1) {
                    value30 = 0;
                }
                setCarInfo(53, value30);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = DataCanbus.DATA[151] - 1;
                if (value31 < 0) {
                    value31 = 3;
                }
                setCarInfo(54, value31);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = DataCanbus.DATA[151] + 1;
                if (value32 > 3) {
                    value32 = 0;
                }
                setCarInfo(54, value32);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = DataCanbus.DATA[152] - 1;
                if (value33 < 0) {
                    value33 = 2;
                }
                setCarInfo(55, value33);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = DataCanbus.DATA[152] + 1;
                if (value34 > 2) {
                    value34 = 0;
                }
                setCarInfo(55, value34);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(0, DataCanbus.DATA[99] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(2, DataCanbus.DATA[101] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(4, DataCanbus.DATA[102] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(5, DataCanbus.DATA[103] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(8, DataCanbus.DATA[106] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(9, DataCanbus.DATA[107] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(11, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(10, DataCanbus.DATA[109] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(13, DataCanbus.DATA[110] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(14, DataCanbus.DATA[111] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(60, DataCanbus.DATA[112] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(15, DataCanbus.DATA[113] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfo(17, DataCanbus.DATA[114] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setCarInfo(18, DataCanbus.DATA[115] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setCarInfo(19, DataCanbus.DATA[117] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setCarInfo(20, DataCanbus.DATA[119] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                setCarInfo(26, DataCanbus.DATA[122] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                setCarInfo(27, DataCanbus.DATA[123] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                setCarInfo(59, DataCanbus.DATA[124] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                setCarInfo(52, DataCanbus.DATA[125] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                setCarInfo(28, DataCanbus.DATA[127] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                setCarInfo(33, DataCanbus.DATA[128] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                setCarInfo(37, DataCanbus.DATA[130] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                setCarInfo(38, DataCanbus.DATA[131] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                setCarInfo(39, 1);
                setCarInfo(39, 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                setCarInfo(40, 1);
                setCarInfo(40, 0);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                setCarInfo(41, 1);
                setCarInfo(41, 0);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                setCarInfo(47, DataCanbus.DATA[145] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                setCarInfo(44, DataCanbus.DATA[142] != 1 ? 1 : 0);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value35 = DataCanbus.DATA[153] - 1;
                if (value35 < 0) {
                    value35 = 2;
                }
                setCarInfo(56, value35);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value36 = DataCanbus.DATA[153] + 1;
                if (value36 > 2) {
                    value36 = 0;
                }
                setCarInfo(56, value36);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value37 = DataCanbus.DATA[154] - 1;
                if (value37 < 0) {
                    value37 = 1;
                }
                setCarInfo(57, value37);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value38 = DataCanbus.DATA[154] + 1;
                if (value38 > 1) {
                    value38 = 0;
                }
                setCarInfo(57, value38);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                setCarInfo(45, DataCanbus.DATA[143] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                setCarInfo(46, DataCanbus.DATA[144] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                setCarInfo(43, DataCanbus.DATA[141] != 1 ? 1 : 0);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value39 = DataCanbus.DATA[155] - 1;
                if (value39 < 0) {
                    value39 = 2;
                }
                setCarInfo(58, value39);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value40 = DataCanbus.DATA[155] + 1;
                if (value40 > 2) {
                    value40 = 0;
                }
                setCarInfo(58, value40);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                setCarInfo(48, DataCanbus.DATA[146] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                setCarInfo(49, DataCanbus.DATA[147] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                setCarInfo(50, DataCanbus.DATA[148] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                setCarInfo(51, DataCanbus.DATA[149] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext37 /* 2131428377 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LuZMaserati300CAmpCarSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext38 /* 2131428379 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, LZ300CButtonSetActi.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
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
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
    }

    @Override
    public void removeNotify() {
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
    }
}
