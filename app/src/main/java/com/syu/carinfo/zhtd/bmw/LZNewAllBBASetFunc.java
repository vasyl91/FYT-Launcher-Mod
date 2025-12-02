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

@SuppressWarnings({"deprecation", "unchecked"})
public class LZNewAllBBASetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    String platform = "";
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0453_LZ_BBA_All.modevalue = ints[2];
                                break;
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
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
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
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
                case 144:
                    switch (value) {
                        case 0:
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view7).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view8).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view9).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text6)).setText("bmw");
                            break;
                        case 1:
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text6)).setText("audi");
                            break;
                        case 2:
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view18).setVisibility(0);
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text6)).setText("benz");
                            break;
                    }
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
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_bba_setfunc);
        this.platform = SystemProperties.get("ro.fyt.platform", "");
        init();
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
            findViewById(R.id.layout_view13).setVisibility(0);
            findViewById(R.id.layout_view15).setVisibility(0);
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
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(0);
            findViewById(R.id.layout_view17).setVisibility(0);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(0);
            if (DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                findViewById(R.id.layout_view21).setVisibility(8);
            } else {
                findViewById(R.id.layout_view21).setVisibility(0);
            }
            findViewById(R.id.layout_view22).setVisibility(8);
            findViewById(R.id.layout_view23).setVisibility(8);
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
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAllBBASetFunc.this.language_set = position;
                if (LZNewAllBBASetFunc.this.language_set >= 0 && LZNewAllBBASetFunc.this.language_set <= LZNewAllBBASetFunc.this.mLauStylelist.size() && LZNewAllBBASetFunc.this.send_lang != null) {
                    if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                        DataCanbus.PROXY.cmd(51, new int[]{LZNewAllBBASetFunc.this.language_set}, null, null);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 7}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 8}, null, null);
                                break;
                        }
                    } else if (DataCanbus.DATA[1000] == 9175494) {
                        DataMain.PROXY.cmd(36, new int[]{11, 4}, null, null);
                        LZNewAllBBASetFunc.this.setCarInfo(250, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 4, 112}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                        }
                    } else if (DataCanbus.DATA[144] == 0) {
                        LZNewAllBBASetFunc.this.setCarInfo(251, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 7}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, -2}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 1}, null, null);
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 2}, null, null);
                                break;
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 3}, null, null);
                                break;
                            case 6:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 8:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 9:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 17}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 10:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                            case 11:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 9}, null, null);
                                break;
                        }
                        if (DataCanbus.DATA[149] != 0) {
                            LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                        }
                    } else if (DataCanbus.DATA[144] == 1) {
                        DataMain.PROXY.cmd(36, new int[]{11, 4}, null, null);
                        LZNewAllBBASetFunc.this.setCarInfo(250, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 2) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 2);
                                    break;
                                }
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 4}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 19}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 1) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 1);
                                    break;
                                }
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 5}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 2}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                            case 6:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 1) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 1);
                                    break;
                                }
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 5}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 4, 112}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[149] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                        }
                    } else if (DataCanbus.DATA[144] == 2) {
                        LZNewAllBBASetFunc.this.setCarInfo(249, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 1}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 12}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                break;
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 22}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                break;
                            case 6:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 28}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                break;
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 28}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                break;
                        }
                        if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                            DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                        }
                        if (DataCanbus.DATA[149] != 0) {
                            LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                        }
                    } else {
                        DataMain.PROXY.cmd(36, new int[]{11, -2, LZNewAllBBASetFunc.this.send_lang[LZNewAllBBASetFunc.this.language_set]}, null, null);
                    }
                }
                LZNewAllBBASetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    
    public void updateLauguageSet() {
        int value = Callback_0453_LZ_BBA_All.modevalue;
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
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
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value6 = DataCanbus.DATA[127] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value7 = DataCanbus.DATA[127] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value8 = DataCanbus.DATA[128] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value9 = DataCanbus.DATA[128] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value10 = DataCanbus.DATA[129] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value11 = DataCanbus.DATA[129] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value12 = DataCanbus.DATA[143];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value12 = DataCanbus.DATA[143];
                }
                int value13 = value12 - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(48, new int[]{value13}, null, null);
                    break;
                } else {
                    setCarInfo(255, value13);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                int value14 = DataCanbus.DATA[143];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value14 = DataCanbus.DATA[143];
                }
                int value15 = value14 + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(48, new int[]{value15}, null, null);
                    break;
                } else {
                    setCarInfo(255, value15);
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                int value16 = DataCanbus.DATA[144] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(248, value16);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value17 = DataCanbus.DATA[144] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(248, value17);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value0 = DataCanbus.DATA[144];
                int value1 = DataCanbus.DATA[145];
                int value22 = DataCanbus.DATA[146];
                int value32 = DataCanbus.DATA[147];
                int value42 = DataCanbus.DATA[148];
                int value18 = value1 - 1;
                if (value18 < 1) {
                    value18 = 8;
                }
                setCarInfo2(value0, value18, ((value22 << 7) & 128) | ((value32 << 4) & 112), value42);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value02 = DataCanbus.DATA[144];
                int value19 = DataCanbus.DATA[145];
                int value23 = DataCanbus.DATA[146];
                int value33 = DataCanbus.DATA[147];
                int value43 = DataCanbus.DATA[148];
                int value110 = value19 + 1;
                if (value110 > 8) {
                    value110 = 1;
                }
                setCarInfo2(value02, value110, ((value23 << 7) & 128) | ((value33 << 4) & 112), value43);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value03 = DataCanbus.DATA[144];
                int value111 = DataCanbus.DATA[145];
                int value24 = DataCanbus.DATA[146];
                int value34 = DataCanbus.DATA[147];
                int value44 = DataCanbus.DATA[148];
                int value25 = value24 - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo2(value03, value111, ((value25 << 7) & 128) | ((value34 << 4) & 112), value44);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value04 = DataCanbus.DATA[144];
                int value112 = DataCanbus.DATA[145];
                int value26 = DataCanbus.DATA[146];
                int value35 = DataCanbus.DATA[147];
                int value45 = DataCanbus.DATA[148];
                int value27 = value26 + 1;
                if (value27 > 1) {
                    value27 = 0;
                }
                setCarInfo2(value04, value112, ((value27 << 7) & 128) | ((value35 << 4) & 112), value45);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value05 = DataCanbus.DATA[144];
                int value113 = DataCanbus.DATA[145];
                int value28 = DataCanbus.DATA[146];
                int value36 = DataCanbus.DATA[147];
                int value46 = DataCanbus.DATA[148];
                int value37 = value36 - 1;
                if (value37 < 0) {
                    value37 = 3;
                }
                setCarInfo2(value05, value113, ((value28 << 7) & 128) | ((value37 << 4) & 112), value46);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value06 = DataCanbus.DATA[144];
                int value114 = DataCanbus.DATA[145];
                int value29 = DataCanbus.DATA[146];
                int value38 = DataCanbus.DATA[147];
                int value47 = DataCanbus.DATA[148];
                int value39 = value38 + 1;
                if (value39 > 3) {
                    value39 = 0;
                }
                setCarInfo2(value06, value114, ((value29 << 7) & 128) | ((value39 << 4) & 112), value47);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value07 = DataCanbus.DATA[144];
                int value115 = DataCanbus.DATA[145];
                int value210 = DataCanbus.DATA[146];
                int value310 = DataCanbus.DATA[147];
                int value48 = DataCanbus.DATA[148] - 1;
                if (value48 < 1) {
                    value48 = 15;
                }
                setCarInfo2(value07, value115, ((value210 << 7) & 128) | ((value310 << 4) & 112), value48);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value08 = DataCanbus.DATA[144];
                int value116 = DataCanbus.DATA[145];
                int value211 = DataCanbus.DATA[146];
                int value311 = DataCanbus.DATA[147];
                int value49 = DataCanbus.DATA[148] + 1;
                if (value49 > 15) {
                    value49 = 1;
                }
                setCarInfo2(value08, value116, ((value211 << 7) & 128) | ((value311 << 4) & 112), value49);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value20 = DataCanbus.DATA[149] - 1;
                if (value20 < 0) {
                    value20 = 3;
                }
                setCarInfo(254, value20);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value21 = DataCanbus.DATA[149] + 1;
                if (value21 > 3) {
                    value21 = 0;
                }
                setCarInfo(254, value21);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value30 = DataCanbus.DATA[152];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value30 = DataCanbus.DATA[142];
                }
                if (value30 > 0) {
                    value30--;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(47, new int[]{value30}, null, null);
                    break;
                } else {
                    setCarInfo(253, value30);
                    break;
                }
            case R.id.btn_plus12 /* 2131427490 */:
                int value31 = DataCanbus.DATA[152];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value31 = DataCanbus.DATA[142];
                }
                if (value31 < 36) {
                    value31++;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(47, new int[]{value31}, null, null);
                    break;
                } else {
                    setCarInfo(253, value31);
                    break;
                }
            case R.id.btn_minus13 /* 2131427491 */:
                int value40 = DataCanbus.DATA[144] - 1;
                if (value40 < 0) {
                    value40 = 3;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value40}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value41 = DataCanbus.DATA[144] + 1;
                if (value41 > 3) {
                    value41 = 0;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value41}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value50 = DataCanbus.DATA[153];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value50 = DataCanbus.DATA[145];
                }
                if (value50 > 0) {
                    value50--;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(50, new int[]{value50}, null, null);
                    break;
                } else {
                    setCarInfo(252, value50);
                    break;
                }
            case R.id.btn_plus14 /* 2131427496 */:
                int value51 = DataCanbus.DATA[153];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value51 = DataCanbus.DATA[145];
                }
                if (value51 < 36) {
                    value51++;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(50, new int[]{value51}, null, null);
                    break;
                } else {
                    setCarInfo(252, value51);
                    break;
                }
            case R.id.btn_minus15 /* 2131427515 */:
                int value52 = DataCanbus.DATA[154] - 1;
                if (value52 < 0) {
                    value52 = 1;
                }
                setCarInfo(10, value52);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value53 = DataCanbus.DATA[154] + 1;
                if (value53 > 1) {
                    value53 = 0;
                }
                setCarInfo(10, value53);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[126] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog();
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[158] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(247, value4);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 12648900) {
                        intent.setClass(this, LZToyotaLexRX450LightAct.class);
                    } else {
                        intent.setClass(this, LZBBAFenweiLightAct.class);
                    }
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value54 = DataCanbus.DATA[168];
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    value54 = DataCanbus.DATA[160];
                }
                if (value54 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
                    DataCanbus.PROXY.cmd(53, new int[]{value3}, null, null);
                    break;
                } else {
                    setCarInfo(244, value3);
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[169] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(243, value2);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
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

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
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
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 2621894 || DataCanbus.DATA[1000] == 1114567 || DataCanbus.DATA[1000] == 1180103) {
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
    }
}
