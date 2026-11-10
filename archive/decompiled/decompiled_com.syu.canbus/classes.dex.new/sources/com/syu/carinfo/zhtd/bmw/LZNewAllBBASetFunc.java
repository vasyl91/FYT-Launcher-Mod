package com.syu.carinfo.zhtd.bmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_BBA_All;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNewAllBBASetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    String platform = "";
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0453_LZ_BBA_All.modevalue = ints[2];
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                switch (updateCode) {
                    case 140:
                    case 141:
                        int w = DataCanbus.DATA[140];
                        int h = DataCanbus.DATA[141];
                        ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                        break;
                    case 142:
                        ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 143:
                        switch (value) {
                            case 0:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                                break;
                            case 1:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                                break;
                        }
                        break;
                    case 144:
                        switch (value) {
                            case 0:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text14)).setText("IS.Hi");
                                break;
                            case 1:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text14)).setText("IS.Low");
                                break;
                            case 2:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text14)).setText("11.LC");
                                break;
                            case 3:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text14)).setText("18.LC");
                                break;
                        }
                        break;
                    case 145:
                        ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 147:
                        LZNewAllBBASetFunc.this.updateLauguageSet();
                        break;
                    case 160:
                        ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                        break;
                }
            }
            if (DataCanbus.DATA[1000] == 9175494) {
                switch (updateCode) {
                    case 117:
                        LZNewAllBBASetFunc.this.updateLauguageSet();
                        break;
                    case 118:
                        switch (value) {
                            case 1:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state0);
                                break;
                            case 2:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state1);
                                break;
                            case 3:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state2);
                                break;
                            default:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText("");
                                break;
                        }
                        break;
                }
            }
            switch (updateCode) {
                case 126:
                    ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 0);
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive A(CCC)");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive B(CCC)");
                            break;
                    }
                    break;
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text2)).setText("6.5");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text2)).setText("8.8");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text2)).setText("8.8 H");
                            break;
                    }
                    break;
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                    break;
                case 130:
                    switch (value) {
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state0);
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state1);
                            break;
                        case 3:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state2);
                            break;
                        default:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text4)).setText("");
                            break;
                    }
                    break;
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view5).setVisibility(8);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view5).setVisibility(0);
                            break;
                    }
                    break;
                case 144:
                    switch (value) {
                        case 0:
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view7).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view8).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view9).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view24).setVisibility(0);
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text6)).setText("bmw");
                            break;
                        case 1:
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view24).setVisibility(8);
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text6)).setText("audi");
                            break;
                        case 2:
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view18).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view24).setVisibility(8);
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text6)).setText("benz");
                            break;
                    }
                    break;
                case 145:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 146:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                            break;
                    }
                    break;
                case 147:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text9)).setText("BT");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text9)).setText("USB");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text9)).setText("AUX");
                            break;
                        case 3:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text9)).setText("TV");
                            break;
                    }
                    break;
                case 148:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 149:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 150:
                case 151:
                    int w2 = DataCanbus.DATA[150];
                    int h2 = DataCanbus.DATA[151];
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w2) + " X " + h2);
                    break;
                case 152:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 153:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 154:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.0");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.5");
                            break;
                    }
                    break;
                case 155:
                    LZNewAllBBASetFunc.this.updateLauguageSet();
                    break;
                case 156:
                    LZNewAllBBASetFunc.this.updateLauguageSet();
                    break;
                case 157:
                    LZNewAllBBASetFunc.this.updateLauguageSet();
                    break;
                case 158:
                    ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 168:
                    ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 169:
                    ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 170:
                    ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 172:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text17)).setText("800*480");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text17)).setText("1280*480");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text17)).setText("1440*540");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_bba_setfunc);
        this.platform = SystemProperties.get("ro.fyt.platform", "");
        init();
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
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
            findViewById(R.id.layout_view11).setVisibility(0);
            findViewById(R.id.layout_view12).setVisibility(0);
            findViewById(R.id.layout_view13).setVisibility(0);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(0);
            findViewById(R.id.layout_view16).setVisibility(0);
            findViewById(R.id.layout_view17).setVisibility(0);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(0);
            if (DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                findViewById(R.id.layout_view21).setVisibility(8);
            } else {
                findViewById(R.id.layout_view21).setVisibility(0);
            }
            findViewById(R.id.layout_view22).setVisibility(8);
            findViewById(R.id.layout_view23).setVisibility(8);
            findViewById(R.id.layout_view24).setVisibility(8);
            DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        } else if (DataCanbus.DATA[1000] == 9175494) {
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(0);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(8);
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(8);
            findViewById(R.id.layout_view21).setVisibility(8);
            findViewById(R.id.layout_view22).setVisibility(8);
            findViewById(R.id.layout_view23).setVisibility(8);
            findViewById(R.id.layout_view24).setVisibility(8);
            DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        } else {
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
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(8);
            findViewById(R.id.layout_view17).setVisibility(0);
            findViewById(R.id.layout_view18).setVisibility(0);
            findViewById(R.id.layout_view19).setVisibility(0);
            findViewById(R.id.layout_view20).setVisibility(0);
            findViewById(R.id.layout_view21).setVisibility(0);
            findViewById(R.id.layout_view22).setVisibility(0);
            findViewById(R.id.layout_view23).setVisibility(0);
            findViewById(R.id.layout_view24).setVisibility(0);
            DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAllBBASetFunc.this.language_set = position;
                if (LZNewAllBBASetFunc.this.language_set >= 0 && LZNewAllBBASetFunc.this.language_set <= LZNewAllBBASetFunc.this.mLauStylelist.size() && LZNewAllBBASetFunc.this.send_lang != null) {
                    if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                        DataCanbus.PROXY.cmd(51, new int[]{LZNewAllBBASetFunc.this.language_set}, null, null);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 7, 0, 0}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 8, 0, 0}, null, null);
                                break;
                        }
                    } else if (DataCanbus.DATA[1000] == 9175494) {
                        DataMain.PROXY.cmd(36, new int[]{11, 4, 0, 0, 0}, null, null);
                        LZNewAllBBASetFunc.this.setCarInfo(250, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 4, 112, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                        }
                    } else if (DataCanbus.DATA[144] == 0) {
                        LZNewAllBBASetFunc.this.setCarInfo(251, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 7, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 0, 0, 0}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 1, 0, 0}, null, null);
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 2, 0, 0}, null, null);
                                break;
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 3, 0, 0}, null, null);
                                break;
                            case 6:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 8:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 9:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 17, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 10:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 11:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 9, 0, 0}, null, null);
                                break;
                        }
                        if (DataCanbus.DATA[149] != 0) {
                            LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                        }
                    } else if (DataCanbus.DATA[144] == 1) {
                        DataMain.PROXY.cmd(36, new int[]{11, 4, 0, 0, 0}, null, null);
                        LZNewAllBBASetFunc.this.setCarInfo(250, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 2) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 2);
                                }
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 4, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                }
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 19, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 1) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 1);
                                }
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 5, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                }
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 2, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                }
                                break;
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                }
                                break;
                            case 6:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 1) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 1);
                                }
                                break;
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 5, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 4, 112, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                }
                                break;
                        }
                    } else if (DataCanbus.DATA[144] == 2) {
                        LZNewAllBBASetFunc.this.setCarInfo(249, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 1, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 12, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                break;
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 22, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                break;
                            case 6:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 28, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                break;
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 28, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                break;
                        }
                        if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                            DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                        }
                        if (DataCanbus.DATA[149] != 0) {
                            LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                        }
                    } else {
                        DataMain.PROXY.cmd(36, new int[]{11, -2, LZNewAllBBASetFunc.this.send_lang[LZNewAllBBASetFunc.this.language_set], 0, 0}, null, null);
                    }
                }
                LZNewAllBBASetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = Callback_0453_LZ_BBA_All.modevalue;
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
            value = DataCanbus.DATA[147];
        } else if (DataCanbus.DATA[1000] == 9175494) {
            value = DataCanbus.DATA[117];
        } else if (DataCanbus.DATA[144] == 0) {
            value = DataCanbus.DATA[155];
        } else if (DataCanbus.DATA[144] == 1) {
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
            this.mLauStylelist.add("LX 15-22 800x480 S200");
            this.mLauStylelist.add("LX 15-22 1280x480 S200");
            this.mLauStylelist.add("LX 09-13 800x480 S100");
            this.mLauStylelist.add("LX 09-13 800x480-1 S100");
            this.send_lang = new int[]{0, 1, 2, 3};
        } else if (DataCanbus.DATA[1000] == 9175494) {
            this.mLauStylelist.add("No select!");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-H 800x480 T300");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-H 800x480-1 T300");
            this.send_lang = new int[]{0, 1, 2};
        } else if (DataCanbus.DATA[144] == 0) {
            this.mLauStylelist.add("BMW CIC 800x480 T200");
            this.mLauStylelist.add("BMW CIC 1280x480 T200");
            this.mLauStylelist.add("BMW CCC 640x240 T600");
            this.mLauStylelist.add("BMW CCC 400x250 T600");
            this.mLauStylelist.add("BMW CCC 640x250 T600");
            this.mLauStylelist.add("BMW CCC 400x240-1 T600");
            this.mLauStylelist.add("BMW NBT 1280x480 I100");
            this.mLauStylelist.add("BMW NBT 800x480 I100");
            this.mLauStylelist.add("BMW EVO 800x480 I200");
            this.mLauStylelist.add("BMW EVO 1440x540 I200");
            this.mLauStylelist.add("BMW EVO 1280x480 I200");
            this.mLauStylelist.add("RR 800x240 T600");
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        } else if (DataCanbus.DATA[144] == 1) {
            this.mLauStylelist.add("Audi 2017 A4L 1024x480 T100");
            this.mLauStylelist.add("Audi 2009 A6L/Q7 480x240 T500");
            this.mLauStylelist.add("Audi 2017 A4L 400x240 T100");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-H 400x240 T300");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-L 400x240 M100");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-H 800x480 T300");
            this.mLauStylelist.add("Audi 2017 A4L 800x480 T100");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-H 400x240-1 T300");
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        } else if (DataCanbus.DATA[144] == 2) {
            this.mLauStylelist.add("Benz NTG 4.0 576x124 M200");
            this.mLauStylelist.add("Benz NTG 4.0 800x480 M200");
            this.mLauStylelist.add("Benz NTG 4.5/4.7 800x480 T400");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 800x480 M300");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 960x540 M300");
            this.mLauStylelist.add("Benz NTG 4.5/4.7 400x240 T400");
            this.mLauStylelist.add("Benz NTG 5.5 1920x720 M400");
            this.mLauStylelist.add("Benz NTG 6.0 1920x720 M400");
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        } else {
            this.mLauStylelist.add(getResources().getString(R.string.crv_source_null));
            this.mLauStylelist.add("BMW CCC 640 X 240");
            this.mLauStylelist.add("BMW CCC 400 X 250");
            this.mLauStylelist.add("BMW CCC 640 X 250");
            this.mLauStylelist.add("BMW CCC 640 X 240-1");
            this.send_lang = new int[]{-1, 0, 1, 2, 3};
        }
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewAllBBASetFunc.this.mLauStyle == null) {
                    LZNewAllBBASetFunc.this.initLauStyle();
                }
                if (LZNewAllBBASetFunc.this.mLauStyle != null && LZNewAllBBASetFunc.this.mPopShowView != null) {
                    LZNewAllBBASetFunc.this.mLauStyle.showAtLocation(LZNewAllBBASetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewAllBBASetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DataCanbus.DATA[1000] != 9175494) {
                            LZNewAllBBASetFunc.this.setCarInfo(9, 0);
                        } else {
                            DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc.6
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
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
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
                int value12 = DataCanbus.DATA[143];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value12 = DataCanbus.DATA[143];
                }
                int value13 = value12 - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(48, new int[]{value13}, null, null);
                } else {
                    setCarInfo(255, value13);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value14 = DataCanbus.DATA[143];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value14 = DataCanbus.DATA[143];
                }
                int value15 = value14 + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(48, new int[]{value15}, null, null);
                } else {
                    setCarInfo(255, value15);
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value16 = DataCanbus.DATA[144] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(248, value16);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value17 = DataCanbus.DATA[144] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(248, value17);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value0 = DataCanbus.DATA[144];
                int value1 = DataCanbus.DATA[145];
                int value18 = DataCanbus.DATA[146];
                int value19 = DataCanbus.DATA[147];
                int value20 = DataCanbus.DATA[148];
                int value21 = value1 - 1;
                if (value21 < 1) {
                    value21 = 8;
                }
                setCarInfo2(value0, value21, ((value18 << 7) & 128) | ((value19 << 4) & 112), value20);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value22 = DataCanbus.DATA[144];
                int value23 = DataCanbus.DATA[145];
                int value24 = DataCanbus.DATA[146];
                int value25 = DataCanbus.DATA[147];
                int value26 = DataCanbus.DATA[148];
                int value27 = value23 + 1;
                if (value27 > 8) {
                    value27 = 1;
                }
                setCarInfo2(value22, value27, ((value24 << 7) & 128) | ((value25 << 4) & 112), value26);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value28 = DataCanbus.DATA[144];
                int value29 = DataCanbus.DATA[145];
                int value30 = DataCanbus.DATA[146];
                int value31 = DataCanbus.DATA[147];
                int value32 = DataCanbus.DATA[148];
                int value33 = value30 - 1;
                if (value33 < 0) {
                    value33 = 1;
                }
                setCarInfo2(value28, value29, ((value33 << 7) & 128) | ((value31 << 4) & 112), value32);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value34 = DataCanbus.DATA[144];
                int value35 = DataCanbus.DATA[145];
                int value36 = DataCanbus.DATA[146];
                int value37 = DataCanbus.DATA[147];
                int value38 = DataCanbus.DATA[148];
                int value39 = value36 + 1;
                if (value39 > 1) {
                    value39 = 0;
                }
                setCarInfo2(value34, value35, ((value39 << 7) & 128) | ((value37 << 4) & 112), value38);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value40 = DataCanbus.DATA[144];
                int value41 = DataCanbus.DATA[145];
                int value42 = DataCanbus.DATA[146];
                int value43 = DataCanbus.DATA[147];
                int value44 = DataCanbus.DATA[148];
                int value45 = value43 - 1;
                if (value45 < 0) {
                    value45 = 3;
                }
                setCarInfo2(value40, value41, ((value42 << 7) & 128) | ((value45 << 4) & 112), value44);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value46 = DataCanbus.DATA[144];
                int value47 = DataCanbus.DATA[145];
                int value48 = DataCanbus.DATA[146];
                int value49 = DataCanbus.DATA[147];
                int value50 = DataCanbus.DATA[148];
                int value51 = value49 + 1;
                if (value51 > 3) {
                    value51 = 0;
                }
                setCarInfo2(value46, value47, ((value48 << 7) & 128) | ((value51 << 4) & 112), value50);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value52 = DataCanbus.DATA[144];
                int value53 = DataCanbus.DATA[145];
                int value54 = DataCanbus.DATA[146];
                int value55 = DataCanbus.DATA[147];
                int value56 = DataCanbus.DATA[148] - 1;
                if (value56 < 1) {
                    value56 = 15;
                }
                setCarInfo2(value52, value53, ((value54 << 7) & 128) | ((value55 << 4) & 112), value56);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value57 = DataCanbus.DATA[144];
                int value58 = DataCanbus.DATA[145];
                int value59 = DataCanbus.DATA[146];
                int value60 = DataCanbus.DATA[147];
                int value61 = DataCanbus.DATA[148] + 1;
                if (value61 > 15) {
                    value61 = 1;
                }
                setCarInfo2(value57, value58, ((value59 << 7) & 128) | ((value60 << 4) & 112), value61);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value62 = DataCanbus.DATA[149] - 1;
                if (value62 < 0) {
                    value62 = 3;
                }
                setCarInfo(254, value62);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value63 = DataCanbus.DATA[149] + 1;
                if (value63 > 3) {
                    value63 = 0;
                }
                setCarInfo(254, value63);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value64 = DataCanbus.DATA[152];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value64 = DataCanbus.DATA[142];
                }
                if (value64 > 0) {
                    value64--;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(47, new int[]{value64}, null, null);
                } else {
                    setCarInfo(253, value64);
                }
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value65 = DataCanbus.DATA[152];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value65 = DataCanbus.DATA[142];
                }
                if (value65 < 36) {
                    value65++;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(47, new int[]{value65}, null, null);
                } else {
                    setCarInfo(253, value65);
                }
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value66 = DataCanbus.DATA[144] - 1;
                if (value66 < 0) {
                    value66 = 3;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value66}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value67 = DataCanbus.DATA[144] + 1;
                if (value67 > 3) {
                    value67 = 0;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value67}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value68 = DataCanbus.DATA[153];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value68 = DataCanbus.DATA[145];
                }
                if (value68 > 0) {
                    value68--;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(50, new int[]{value68}, null, null);
                } else {
                    setCarInfo(252, value68);
                }
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value69 = DataCanbus.DATA[153];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value69 = DataCanbus.DATA[145];
                }
                if (value69 < 36) {
                    value69++;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(50, new int[]{value69}, null, null);
                } else {
                    setCarInfo(252, value69);
                }
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value70 = DataCanbus.DATA[154] - 1;
                if (value70 < 0) {
                    value70 = 1;
                }
                setCarInfo(10, value70);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value71 = DataCanbus.DATA[154] + 1;
                if (value71 > 1) {
                    value71 = 0;
                }
                setCarInfo(10, value71);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value72 = DataCanbus.DATA[172] - 1;
                if (value72 < 0) {
                    value72 = 2;
                }
                setCarInfo(128, value72);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value73 = DataCanbus.DATA[172] + 1;
                if (value73 > 2) {
                    value73 = 0;
                }
                setCarInfo(128, value73);
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
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655) {
                        intent.setClass(this, LZToyotaLexRX450LightAct.class);
                    } else {
                        intent.setClass(this, LZBBAFenweiLightAct.class);
                    }
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value74 = DataCanbus.DATA[168];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value74 = DataCanbus.DATA[160];
                }
                if (value74 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(53, new int[]{value3}, null, null);
                } else {
                    setCarInfo(244, value3);
                }
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
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (DataCanbus.DATA[169] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(243, value2);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (DataCanbus.DATA[170] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(242, value);
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
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
            DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 9175494) {
            DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
            return;
        }
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
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 4915655 || DataCanbus.DATA[1000] == 4587975 || DataCanbus.DATA[1000] == 4719047 || DataCanbus.DATA[1000] == 5505479 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
            DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
            return;
        }
        if (DataCanbus.DATA[1000] == 9175494) {
            DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
            return;
        }
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
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
    }
}
