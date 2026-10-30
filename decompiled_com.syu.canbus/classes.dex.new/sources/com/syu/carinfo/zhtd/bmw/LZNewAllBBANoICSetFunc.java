package com.syu.carinfo.zhtd.bmw;

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
import com.syu.carinfo.wc2.tata.LZBMWMiniFenweiLightAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNewAllBBANoICSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBANoICSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 0);
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive A(CCC)");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive B(CCC)");
                            break;
                    }
                    break;
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text2)).setText("6.5");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text2)).setText("8.8");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text2)).setText("8.8 H");
                            break;
                    }
                    break;
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                    break;
                case 130:
                    switch (value) {
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state0);
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state1);
                            break;
                        case 3:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state2);
                            break;
                    }
                    break;
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view5).setVisibility(8);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view5).setVisibility(0);
                            break;
                    }
                    break;
                case 144:
                    LZNewAllBBANoICSetFunc.this.updatemLauStylelist();
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    switch (value) {
                        case 0:
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view7).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view8).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view9).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view10).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view20).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view21).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view22).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view24).setVisibility(0);
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text6)).setText("bmw");
                            break;
                        case 1:
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view20).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view21).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view22).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view24).setVisibility(8);
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text6)).setText("audi");
                            break;
                        case 2:
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view18).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view20).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view21).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view22).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view24).setVisibility(8);
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text6)).setText("benz");
                            break;
                    }
                    break;
                case 145:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 146:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                            break;
                    }
                    break;
                case 147:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("BT");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("USB");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("AUX");
                            break;
                        case 3:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("TV");
                            break;
                    }
                    break;
                case 148:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 152:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 153:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 154:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.0");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.5");
                            break;
                    }
                    break;
                case 155:
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    break;
                case 156:
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    break;
                case 157:
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    break;
                case 158:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 160:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text17)).setText("CIC");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text17)).setText("CCC");
                            break;
                    }
                    break;
                case 161:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text19)).setText(R.string.str_bmw_shortcut_key_types1);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text19)).setText(R.string.str_bmw_shortcut_key_types2);
                            break;
                    }
                    break;
                case 162:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text18)).setText(R.string.str_bmw_type1);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text18)).setText(R.string.str_bmw_type2);
                            break;
                    }
                    break;
                case 168:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 170:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 172:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text20)).setText("800*480");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text20)).setText("1280*480");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text20)).setText("1440*540");
                            break;
                    }
                    break;
                case 173:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_bba_noic_setfunc);
        init();
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
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(0);
        findViewById(R.id.layout_view19).setVisibility(0);
        findViewById(R.id.layout_view23).setVisibility(0);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBANoICSetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAllBBANoICSetFunc.this.language_set = position;
                if (LZNewAllBBANoICSetFunc.this.language_set >= 0 && LZNewAllBBANoICSetFunc.this.language_set <= LZNewAllBBANoICSetFunc.this.mLauStylelist.size() && LZNewAllBBANoICSetFunc.this.send_lang != null) {
                    LZNewAllBBANoICSetFunc.this.setCarInfo(5, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    if (DataCanbus.DATA[144] == 0) {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(251, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    } else if (DataCanbus.DATA[144] == 1) {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(250, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    } else if (DataCanbus.DATA[144] == 2) {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(249, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    }
                }
                LZNewAllBBANoICSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[155];
        if (DataCanbus.DATA[144] == 1) {
            value = DataCanbus.DATA[157];
        } else if (DataCanbus.DATA[144] == 2) {
            value = DataCanbus.DATA[156];
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatemLauStylelist() {
        this.mLauStylelist.clear();
        if (DataCanbus.DATA[144] == 1) {
            this.mLauStylelist.add("Audi 09-16 A4L/Q5-L 400x240");
            this.mLauStylelist.add("Audi 09-16 A4L/Q5-H 400x240");
            this.mLauStylelist.add("Audi 09-16 A4L/Q5-H 800x480");
            this.mLauStylelist.add("Audi 17 A4L 400x240");
            this.mLauStylelist.add("Audi 17 A4L 800x480");
            this.mLauStylelist.add("Audi 17 A4L 1024x480");
            this.mLauStylelist.add("Audi 09-16 Q3-H 400x240");
            this.mLauStylelist.add("Audi -2G 480x240");
            this.mLauStylelist.add("Audi Other");
            this.send_lang = new int[]{16, 17, 18, 19, 20, 21, 22, 23, 24};
            return;
        }
        if (DataCanbus.DATA[144] == 2) {
            this.mLauStylelist.add("Benz NTG 4.0 576x124");
            this.mLauStylelist.add("Benz NTG 4.0 800x480");
            this.mLauStylelist.add("Benz NTG 4.5/4.7 800x480");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 800x480");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 960x540");
            this.mLauStylelist.add("Benz NTG 4.5 400x240");
            this.mLauStylelist.add("Benz NTG 5.5 1920x720");
            this.mLauStylelist.add("Benz NTG 6.0 1920x720");
            this.mLauStylelist.add("Benz NTG 4.0 400x240");
            this.mLauStylelist.add("Benz NTG 5.5 960x540");
            this.mLauStylelist.add("Benz NTG 6.0 960x540");
            this.mLauStylelist.add("Benz NTG 6.0 960x540_1");
            this.mLauStylelist.add("Benz Other");
            this.send_lang = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44};
            return;
        }
        this.mLauStylelist.add("BMW CCC 1");
        this.mLauStylelist.add("BMW CCC 2");
        this.mLauStylelist.add("BMW CCC 3");
        this.mLauStylelist.add("BMW CCC 4");
        this.mLauStylelist.add("BMW CCC 5");
        this.mLauStylelist.add("BMW CCC 6");
        this.mLauStylelist.add("BMW CIC 800x480");
        this.mLauStylelist.add("BMW CIC 1280x480");
        this.mLauStylelist.add("BMW CIC 800x480 2");
        this.mLauStylelist.add("BMW NBT 800x480");
        this.mLauStylelist.add("BMW NBT 1280x480");
        this.mLauStylelist.add("BMW EVO 800x480");
        this.mLauStylelist.add("BMW EVO 1280x480");
        this.mLauStylelist.add("BMW EVO 1440x540 1");
        this.mLauStylelist.add("BMW EVO 1440x540 2");
        this.mLauStylelist.add("BMW Other");
        this.send_lang = new int[]{0, 1, 2, 3, 13, 14, 4, 5, 12, 6, 7, 8, 9, 10, 11, 15};
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        updatemLauStylelist();
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBANoICSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewAllBBANoICSetFunc.this.mLauStyle == null) {
                    LZNewAllBBANoICSetFunc.this.initLauStyle();
                }
                if (LZNewAllBBANoICSetFunc.this.mLauStyle != null && LZNewAllBBANoICSetFunc.this.mPopShowView != null) {
                    LZNewAllBBANoICSetFunc.this.mLauStyle.showAtLocation(LZNewAllBBANoICSetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBANoICSetFunc.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBANoICSetFunc.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(9, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBANoICSetFunc.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value6 = DataCanbus.DATA[127] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value7 = DataCanbus.DATA[127] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value8 = DataCanbus.DATA[128] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value9 = DataCanbus.DATA[128] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value10 = DataCanbus.DATA[129] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value11 = DataCanbus.DATA[129] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value12 = DataCanbus.DATA[143] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(255, value12);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value13 = DataCanbus.DATA[143] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(255, value13);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value14 = DataCanbus.DATA[144] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(248, value14);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value15 = DataCanbus.DATA[144] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(248, value15);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value0 = DataCanbus.DATA[144];
                int value1 = DataCanbus.DATA[145];
                int value16 = DataCanbus.DATA[146];
                int value17 = DataCanbus.DATA[147];
                int value18 = DataCanbus.DATA[148];
                int value19 = value1 - 1;
                if (value19 < 1) {
                    value19 = 8;
                }
                setCarInfo2(value0, value19, ((value16 << 7) & 128) | ((value17 << 4) & 112), value18);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value20 = DataCanbus.DATA[144];
                int value21 = DataCanbus.DATA[145];
                int value22 = DataCanbus.DATA[146];
                int value23 = DataCanbus.DATA[147];
                int value24 = DataCanbus.DATA[148];
                int value25 = value21 + 1;
                if (value25 > 8) {
                    value25 = 1;
                }
                setCarInfo2(value20, value25, ((value22 << 7) & 128) | ((value23 << 4) & 112), value24);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value26 = DataCanbus.DATA[144];
                int value27 = DataCanbus.DATA[145];
                int value28 = DataCanbus.DATA[146];
                int value29 = DataCanbus.DATA[147];
                int value30 = DataCanbus.DATA[148];
                int value31 = value28 - 1;
                if (value31 < 0) {
                    value31 = 1;
                }
                setCarInfo2(value26, value27, ((value31 << 7) & 128) | ((value29 << 4) & 112), value30);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value32 = DataCanbus.DATA[144];
                int value33 = DataCanbus.DATA[145];
                int value34 = DataCanbus.DATA[146];
                int value35 = DataCanbus.DATA[147];
                int value36 = DataCanbus.DATA[148];
                int value37 = value34 + 1;
                if (value37 > 1) {
                    value37 = 0;
                }
                setCarInfo2(value32, value33, ((value37 << 7) & 128) | ((value35 << 4) & 112), value36);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value38 = DataCanbus.DATA[144];
                int value39 = DataCanbus.DATA[145];
                int value40 = DataCanbus.DATA[146];
                int value41 = DataCanbus.DATA[147];
                int value42 = DataCanbus.DATA[148];
                int value43 = value41 - 1;
                if (value43 < 0) {
                    value43 = 3;
                }
                setCarInfo2(value38, value39, ((value40 << 7) & 128) | ((value43 << 4) & 112), value42);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value44 = DataCanbus.DATA[144];
                int value45 = DataCanbus.DATA[145];
                int value46 = DataCanbus.DATA[146];
                int value47 = DataCanbus.DATA[147];
                int value48 = DataCanbus.DATA[148];
                int value49 = value47 + 1;
                if (value49 > 3) {
                    value49 = 0;
                }
                setCarInfo2(value44, value45, ((value46 << 7) & 128) | ((value49 << 4) & 112), value48);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value50 = DataCanbus.DATA[144];
                int value51 = DataCanbus.DATA[145];
                int value52 = DataCanbus.DATA[146];
                int value53 = DataCanbus.DATA[147];
                int value54 = DataCanbus.DATA[148] - 1;
                if (value54 < 1) {
                    value54 = 15;
                }
                setCarInfo2(value50, value51, ((value52 << 7) & 128) | ((value53 << 4) & 112), value54);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value55 = DataCanbus.DATA[144];
                int value56 = DataCanbus.DATA[145];
                int value57 = DataCanbus.DATA[146];
                int value58 = DataCanbus.DATA[147];
                int value59 = DataCanbus.DATA[148] + 1;
                if (value59 > 15) {
                    value59 = 1;
                }
                setCarInfo2(value55, value56, ((value57 << 7) & 128) | ((value58 << 4) & 112), value59);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value60 = DataCanbus.DATA[152];
                if (value60 > 0) {
                    value60--;
                }
                setCarInfo(253, value60);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value61 = DataCanbus.DATA[152];
                if (value61 < 36) {
                    value61++;
                }
                setCarInfo(253, value61);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value62 = DataCanbus.DATA[144] - 1;
                if (value62 < 0) {
                    value62 = 3;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value62}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value63 = DataCanbus.DATA[144] + 1;
                if (value63 > 3) {
                    value63 = 0;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value63}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value64 = DataCanbus.DATA[153];
                if (value64 > 0) {
                    value64--;
                }
                setCarInfo(252, value64);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value65 = DataCanbus.DATA[153];
                if (value65 < 36) {
                    value65++;
                }
                setCarInfo(252, value65);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value66 = DataCanbus.DATA[154] - 1;
                if (value66 < 0) {
                    value66 = 1;
                }
                setCarInfo(10, value66);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value67 = DataCanbus.DATA[154] + 1;
                if (value67 > 1) {
                    value67 = 0;
                }
                setCarInfo(10, value67);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value68 = DataCanbus.DATA[160] - 1;
                if (value68 < 0) {
                    value68 = 1;
                }
                setCarInfo(12, value68);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value69 = DataCanbus.DATA[160] + 1;
                if (value69 > 1) {
                    value69 = 0;
                }
                setCarInfo(12, value69);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value70 = DataCanbus.DATA[162] - 1;
                if (value70 < 0) {
                    value70 = 1;
                }
                setCarInfo(245, value70);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value71 = DataCanbus.DATA[162] + 1;
                if (value71 > 1) {
                    value71 = 0;
                }
                setCarInfo(245, value71);
                break;
            case R.id.btn_minus18 /* 2131427507 */:
                int value72 = DataCanbus.DATA[161] - 1;
                if (value72 < 0) {
                    value72 = 1;
                }
                setCarInfo(246, value72);
                break;
            case R.id.btn_plus18 /* 2131427509 */:
                int value73 = DataCanbus.DATA[161] + 1;
                if (value73 > 1) {
                    value73 = 0;
                }
                setCarInfo(246, value73);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[126] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[173] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(241, value3);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[168] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(244, value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                dialog();
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[158] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(247, value4);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (DataCanbus.DATA[170] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(242, value);
                break;
            case R.id.btn_minus19 /* 2131427593 */:
                int value74 = DataCanbus.DATA[172] - 1;
                if (value74 < 0) {
                    value74 = 2;
                }
                setCarInfo(128, value74);
                break;
            case R.id.btn_plus19 /* 2131427595 */:
                int value75 = DataCanbus.DATA[172] + 1;
                if (value75 > 2) {
                    value75 = 0;
                }
                setCarInfo(128, value75);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZBMWMiniFenweiLightAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo2(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1, value2, value3}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
    }
}
