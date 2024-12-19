package com.syu.carinfo.zhtd.bmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                                break;
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
            if (DataCanbus.DATA[1000] == 12648900) {
                switch (updateCode) {
                    case 195:
                    case 196:
                        int w = DataCanbus.DATA[195];
                        int h = DataCanbus.DATA[196];
                        ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                        break;
                    case 197:
                        ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 198:
                        switch (value) {
                            case 0:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                                break;
                            case 1:
                                ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                                break;
                        }
                    case 199:
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
                    case 200:
                        ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 202:
                        LZNewAllBBASetFunc.this.updateLauguageSet();
                        break;
                }
            }
            switch (updateCode) {
                case 59:
                    ((CheckedTextView) LZNewAllBBASetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 0);
                    break;
                case 60:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive A(CCC)");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive B(CCC)");
                            break;
                    }
                case 61:
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
                case 62:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                case 63:
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
                    }
                case 76:
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
                case 77:
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
                            LZNewAllBBASetFunc.this.findViewById(R.id.layout_view10).setVisibility(8);
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
                case 78:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 79:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                            break;
                    }
                case 80:
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
                case 81:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 82:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 83:
                case 84:
                    int w2 = DataCanbus.DATA[83];
                    int h2 = DataCanbus.DATA[84];
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w2) + " X " + h2);
                    break;
                case 85:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 86:
                    ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 87:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.0");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.5");
                            break;
                    }
                case 88:
                    LZNewAllBBASetFunc.this.updateLauguageSet();
                    break;
                case 89:
                    LZNewAllBBASetFunc.this.updateLauguageSet();
                    break;
                case 90:
                    LZNewAllBBASetFunc.this.updateLauguageSet();
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
        if (DataCanbus.DATA[1000] == 12648900) {
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
            findViewById(R.id.layout_view18).setVisibility(8);
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
            findViewById(R.id.layout_view18).setVisibility(0);
            DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                    if (DataCanbus.DATA[1000] == 12648900) {
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
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 7}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 8}, null, null);
                                break;
                        }
                    } else if (DataCanbus.DATA[77] == 0) {
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
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                                break;
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
                                break;
                            case 7:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                                break;
                            case 8:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                                break;
                            case 9:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 17}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                                break;
                            case 10:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                    break;
                                }
                                break;
                        }
                        if (DataCanbus.DATA[82] != 0) {
                            LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                        }
                    } else if (DataCanbus.DATA[77] == 1) {
                        LZNewAllBBASetFunc.this.setCarInfo(250, LZNewAllBBASetFunc.this.language_set);
                        switch (LZNewAllBBASetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[82] != 2) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 2);
                                    break;
                                }
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 4}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[82] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 19}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[82] != 1) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 1);
                                    break;
                                }
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 5}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[82] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 3}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[82] != 0) {
                                    LZNewAllBBASetFunc.this.setCarInfo(254, 0);
                                    break;
                                }
                                break;
                        }
                    } else if (DataCanbus.DATA[77] == 2) {
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
                        }
                        if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                            DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                        }
                        if (DataCanbus.DATA[82] != 0) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = Callback_0453_LZ_BBA_All.modevalue;
        if (DataCanbus.DATA[1000] == 12648900) {
            value = DataCanbus.DATA[202];
        } else if (DataCanbus.DATA[77] == 0) {
            value = DataCanbus.DATA[88];
        } else if (DataCanbus.DATA[77] == 1) {
            value = DataCanbus.DATA[90];
        } else if (DataCanbus.DATA[77] == 2) {
            value = DataCanbus.DATA[89];
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
        if (DataCanbus.DATA[1000] == 12648900) {
            this.mLauStylelist.add("LX 15-22 800x480 S200");
            this.mLauStylelist.add("LX 15-22 1280x480 S200");
            this.mLauStylelist.add("LX 09-13 800x480 S100");
            this.mLauStylelist.add("LX 09-13 800x480-1 S100");
            this.send_lang = new int[]{0, 1, 2, 3};
        } else if (DataCanbus.DATA[77] == 0) {
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
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        } else if (DataCanbus.DATA[77] == 1) {
            this.mLauStylelist.add("Audi 2017 A4L 1024x480 T100");
            this.mLauStylelist.add("Audi 2009 A6L/Q7 480x240 T500");
            this.mLauStylelist.add("Audi 2017 A4L 400x240 T100");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-H 400x240 T300");
            this.mLauStylelist.add("Audi 2009 A4L/Q5-L 400x240 M100");
            this.send_lang = new int[]{0, 1, 2, 3, 4};
        } else if (DataCanbus.DATA[77] == 2) {
            this.mLauStylelist.add("Benz NTG 4.0 576x124 M200");
            this.mLauStylelist.add("Benz NTG 4.0 800x480 M200");
            this.mLauStylelist.add("Benz NTG 4.5/4.7 800x480 T400");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 800x480 M300");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 960x540 M300");
            this.send_lang = new int[]{0, 1, 2, 3, 4};
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
                        LZNewAllBBASetFunc.this.setCarInfo(9, 0);
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
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value2 = DataCanbus.DATA[199] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value2}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value3 = DataCanbus.DATA[199] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value3}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value4 = DataCanbus.DATA[86];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value4 = DataCanbus.DATA[200];
                }
                if (value4 > 0) {
                    value4--;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(50, new int[]{value4}, null, null);
                    break;
                } else {
                    setCarInfo(252, value4);
                    break;
                }
            case R.id.btn_plus14 /* 2131427473 */:
                int value5 = DataCanbus.DATA[86];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value5 = DataCanbus.DATA[200];
                }
                if (value5 < 36) {
                    value5++;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(50, new int[]{value5}, null, null);
                    break;
                } else {
                    setCarInfo(252, value5);
                    break;
                }
            case R.id.btn_minus15 /* 2131427474 */:
                int value6 = DataCanbus.DATA[87] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(10, value6);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value7 = DataCanbus.DATA[87] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(10, value7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[59] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[60] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[60] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[61] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[61] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[62] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[62] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value14 = DataCanbus.DATA[76];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value14 = DataCanbus.DATA[198];
                }
                int value15 = value14 - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(48, new int[]{value15}, null, null);
                    break;
                } else {
                    setCarInfo(255, value15);
                    break;
                }
            case R.id.btn_plus5 /* 2131427498 */:
                int value16 = DataCanbus.DATA[76];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value16 = DataCanbus.DATA[198];
                }
                int value17 = value16 + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(48, new int[]{value17}, null, null);
                    break;
                } else {
                    setCarInfo(255, value17);
                    break;
                }
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[77] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(248, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[77] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(248, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value0 = DataCanbus.DATA[77];
                int value1 = DataCanbus.DATA[78];
                int value22 = DataCanbus.DATA[79];
                int value32 = DataCanbus.DATA[80];
                int value42 = DataCanbus.DATA[81];
                int value110 = value1 - 1;
                if (value110 < 1) {
                    value110 = 8;
                }
                setCarInfo2(value0, value110, ((value22 << 7) & 128) | ((value32 << 4) & 112), value42);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value02 = DataCanbus.DATA[77];
                int value111 = DataCanbus.DATA[78];
                int value23 = DataCanbus.DATA[79];
                int value33 = DataCanbus.DATA[80];
                int value43 = DataCanbus.DATA[81];
                int value112 = value111 + 1;
                if (value112 > 8) {
                    value112 = 1;
                }
                setCarInfo2(value02, value112, ((value23 << 7) & 128) | ((value33 << 4) & 112), value43);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value03 = DataCanbus.DATA[77];
                int value113 = DataCanbus.DATA[78];
                int value24 = DataCanbus.DATA[79];
                int value34 = DataCanbus.DATA[80];
                int value44 = DataCanbus.DATA[81];
                int value25 = value24 - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo2(value03, value113, ((value25 << 7) & 128) | ((value34 << 4) & 112), value44);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value04 = DataCanbus.DATA[77];
                int value114 = DataCanbus.DATA[78];
                int value26 = DataCanbus.DATA[79];
                int value35 = DataCanbus.DATA[80];
                int value45 = DataCanbus.DATA[81];
                int value27 = value26 + 1;
                if (value27 > 1) {
                    value27 = 0;
                }
                setCarInfo2(value04, value114, ((value27 << 7) & 128) | ((value35 << 4) & 112), value45);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value05 = DataCanbus.DATA[77];
                int value115 = DataCanbus.DATA[78];
                int value28 = DataCanbus.DATA[79];
                int value36 = DataCanbus.DATA[80];
                int value46 = DataCanbus.DATA[81];
                int value37 = value36 - 1;
                if (value37 < 0) {
                    value37 = 3;
                }
                setCarInfo2(value05, value115, ((value28 << 7) & 128) | ((value37 << 4) & 112), value46);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value06 = DataCanbus.DATA[77];
                int value116 = DataCanbus.DATA[78];
                int value29 = DataCanbus.DATA[79];
                int value38 = DataCanbus.DATA[80];
                int value47 = DataCanbus.DATA[81];
                int value39 = value38 + 1;
                if (value39 > 3) {
                    value39 = 0;
                }
                setCarInfo2(value06, value116, ((value29 << 7) & 128) | ((value39 << 4) & 112), value47);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value07 = DataCanbus.DATA[77];
                int value117 = DataCanbus.DATA[78];
                int value210 = DataCanbus.DATA[79];
                int value310 = DataCanbus.DATA[80];
                int value48 = DataCanbus.DATA[81] - 1;
                if (value48 < 1) {
                    value48 = 15;
                }
                setCarInfo2(value07, value117, ((value210 << 7) & 128) | ((value310 << 4) & 112), value48);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value08 = DataCanbus.DATA[77];
                int value118 = DataCanbus.DATA[78];
                int value211 = DataCanbus.DATA[79];
                int value311 = DataCanbus.DATA[80];
                int value49 = DataCanbus.DATA[81] + 1;
                if (value49 > 15) {
                    value49 = 1;
                }
                setCarInfo2(value08, value118, ((value211 << 7) & 128) | ((value311 << 4) & 112), value49);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value20 = DataCanbus.DATA[82] - 1;
                if (value20 < 0) {
                    value20 = 3;
                }
                setCarInfo(254, value20);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value21 = DataCanbus.DATA[82] + 1;
                if (value21 > 3) {
                    value21 = 0;
                }
                setCarInfo(254, value21);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[85];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value30 = DataCanbus.DATA[197];
                }
                if (value30 > 0) {
                    value30--;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(47, new int[]{value30}, null, null);
                    break;
                } else {
                    setCarInfo(253, value30);
                    break;
                }
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[85];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value31 = DataCanbus.DATA[197];
                }
                if (value31 < 36) {
                    value31++;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(47, new int[]{value31}, null, null);
                    break;
                } else {
                    setCarInfo(253, value31);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                dialog();
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
        if (DataCanbus.DATA[1000] == 12648900) {
            DataCanbus.NOTIFY_EVENTS[195].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[196].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[197].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[198].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[199].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[200].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[202].addNotify(this.notifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 12648900) {
            DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.notifyCanbus);
    }
}
