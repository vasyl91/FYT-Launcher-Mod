package com.syu.carinfo.zhtd.bmw;

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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_BBA_All;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZNewAllBBASetFunc_beifen extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0453_LZ_BBA_All.modevalue = ints[2];
                                LZNewAllBBASetFunc_beifen.this.updateLauguageSet();
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 12648900) {
                switch (updateCode) {
                    case 195:
                    case 196:
                        int w = DataCanbus.DATA[195];
                        int h = DataCanbus.DATA[196];
                        ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                        break;
                    case 197:
                        ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 198:
                        switch (value) {
                            case 0:
                                ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                                break;
                            case 1:
                                ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                                break;
                        }
                        break;
                    case 199:
                        switch (value) {
                            case 0:
                                ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text14)).setText("IS.Hi");
                                break;
                            case 1:
                                ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text14)).setText("IS.Low");
                                break;
                            case 2:
                                ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text14)).setText("11.LC");
                                break;
                            case 3:
                                ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text14)).setText("18.LC");
                                break;
                        }
                        break;
                    case 200:
                        ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                }
            }
            switch (updateCode) {
                case 59:
                    ((CheckedTextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 0);
                    break;
                case 60:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text1)).setText("IDrive A(CCC)");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text1)).setText("IDrive B(CCC)");
                            break;
                    }
                    break;
                case 61:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text2)).setText("6.5");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text2)).setText("8.8");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text2)).setText("8.8 H");
                            break;
                    }
                    break;
                case 62:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                    break;
                case 63:
                    switch (value) {
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state0);
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state1);
                            break;
                        case 3:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state2);
                            break;
                    }
                    break;
                case 76:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view1).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view2).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view3).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view4).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view5).setVisibility(8);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view5).setVisibility(0);
                            break;
                    }
                    break;
                case 77:
                    switch (value) {
                        case 0:
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view7).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view8).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view9).setVisibility(0);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view10).setVisibility(8);
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text6)).setText("bmw");
                            break;
                        case 1:
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view10).setVisibility(8);
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text6)).setText("audi");
                            break;
                        case 2:
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBASetFunc_beifen.this.findViewById(R.id.layout_view10).setVisibility(0);
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text6)).setText("benz");
                            break;
                    }
                    break;
                case 78:
                    ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 79:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                            break;
                    }
                    break;
                case 80:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text9)).setText("BT");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text9)).setText("USB");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text9)).setText("AUX");
                            break;
                        case 3:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text9)).setText("TV");
                            break;
                    }
                    break;
                case 81:
                    ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 82:
                    ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 83:
                case 84:
                    int w2 = DataCanbus.DATA[83];
                    int h2 = DataCanbus.DATA[84];
                    ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w2) + " X " + h2);
                    break;
                case 85:
                    ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 86:
                    ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 87:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text16)).setText("NTG4.0");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBASetFunc_beifen.this.findViewById(R.id.tv_text16)).setText("NTG4.5");
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
            findViewById(R.id.layout_view14).setVisibility(0);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAllBBASetFunc_beifen.this.language_set = position;
                if (LZNewAllBBASetFunc_beifen.this.language_set >= 0 && LZNewAllBBASetFunc_beifen.this.language_set <= LZNewAllBBASetFunc_beifen.this.mLauStylelist.size() && LZNewAllBBASetFunc_beifen.this.send_lang != null) {
                    DataMain.PROXY.cmd(36, new int[]{11, -2, LZNewAllBBASetFunc_beifen.this.send_lang[LZNewAllBBASetFunc_beifen.this.language_set], 0, 0}, null, null);
                }
                LZNewAllBBASetFunc_beifen.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = Callback_0453_LZ_BBA_All.modevalue;
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
            this.mLauStylelist.add(getResources().getString(R.string.crv_source_null));
            this.mLauStylelist.add("TOYOTA CROWN 800 X 480");
            this.mLauStylelist.add("TOYOTA CROWN 800 X 480 -1");
            this.send_lang = new int[]{-1, 7, 8};
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewAllBBASetFunc_beifen.this.mLauStyle == null) {
                    LZNewAllBBASetFunc_beifen.this.initLauStyle();
                }
                if (LZNewAllBBASetFunc_beifen.this.mLauStyle != null && LZNewAllBBASetFunc_beifen.this.mPopShowView != null) {
                    LZNewAllBBASetFunc_beifen.this.mLauStyle.showAtLocation(LZNewAllBBASetFunc_beifen.this.mPopShowView, 17, 0, 0);
                    LZNewAllBBASetFunc_beifen.this.updateLauguageSet();
                }
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LZNewAllBBASetFunc_beifen.this.setCarInfo(9, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc_beifen.6
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
        updateLauguageSet();
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
                } else {
                    setCarInfo(252, value4);
                }
                break;
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
                } else {
                    setCarInfo(252, value5);
                }
                break;
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
                } else {
                    setCarInfo(255, value15);
                }
                break;
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
                } else {
                    setCarInfo(255, value17);
                }
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value0 = DataCanbus.DATA[77];
                int value1 = DataCanbus.DATA[78];
                int value18 = DataCanbus.DATA[79];
                int value19 = DataCanbus.DATA[80];
                int value20 = DataCanbus.DATA[81];
                int value21 = value1 - 1;
                if (value21 < 1) {
                    value21 = 8;
                }
                setCarInfo2(value0, value21, ((value18 << 7) & 128) | ((value19 << 4) & 112), value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value22 = DataCanbus.DATA[77];
                int value23 = DataCanbus.DATA[78];
                int value24 = DataCanbus.DATA[79];
                int value25 = DataCanbus.DATA[80];
                int value26 = DataCanbus.DATA[81];
                int value27 = value23 + 1;
                if (value27 > 8) {
                    value27 = 1;
                }
                setCarInfo2(value22, value27, ((value24 << 7) & 128) | ((value25 << 4) & 112), value26);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value28 = DataCanbus.DATA[77];
                int value29 = DataCanbus.DATA[78];
                int value30 = DataCanbus.DATA[79];
                int value31 = DataCanbus.DATA[80];
                int value32 = DataCanbus.DATA[81];
                int value33 = value30 - 1;
                if (value33 < 0) {
                    value33 = 1;
                }
                setCarInfo2(value28, value29, ((value33 << 7) & 128) | ((value31 << 4) & 112), value32);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value34 = DataCanbus.DATA[77];
                int value35 = DataCanbus.DATA[78];
                int value36 = DataCanbus.DATA[79];
                int value37 = DataCanbus.DATA[80];
                int value38 = DataCanbus.DATA[81];
                int value39 = value36 + 1;
                if (value39 > 1) {
                    value39 = 0;
                }
                setCarInfo2(value34, value35, ((value39 << 7) & 128) | ((value37 << 4) & 112), value38);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value40 = DataCanbus.DATA[77];
                int value41 = DataCanbus.DATA[78];
                int value42 = DataCanbus.DATA[79];
                int value43 = DataCanbus.DATA[80];
                int value44 = DataCanbus.DATA[81];
                int value45 = value43 - 1;
                if (value45 < 0) {
                    value45 = 3;
                }
                setCarInfo2(value40, value41, ((value42 << 7) & 128) | ((value45 << 4) & 112), value44);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value46 = DataCanbus.DATA[77];
                int value47 = DataCanbus.DATA[78];
                int value48 = DataCanbus.DATA[79];
                int value49 = DataCanbus.DATA[80];
                int value50 = DataCanbus.DATA[81];
                int value51 = value49 + 1;
                if (value51 > 3) {
                    value51 = 0;
                }
                setCarInfo2(value46, value47, ((value48 << 7) & 128) | ((value51 << 4) & 112), value50);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value52 = DataCanbus.DATA[77];
                int value53 = DataCanbus.DATA[78];
                int value54 = DataCanbus.DATA[79];
                int value55 = DataCanbus.DATA[80];
                int value56 = DataCanbus.DATA[81] - 1;
                if (value56 < 1) {
                    value56 = 15;
                }
                setCarInfo2(value52, value53, ((value54 << 7) & 128) | ((value55 << 4) & 112), value56);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value57 = DataCanbus.DATA[77];
                int value58 = DataCanbus.DATA[78];
                int value59 = DataCanbus.DATA[79];
                int value60 = DataCanbus.DATA[80];
                int value61 = DataCanbus.DATA[81] + 1;
                if (value61 > 15) {
                    value61 = 1;
                }
                setCarInfo2(value57, value58, ((value59 << 7) & 128) | ((value60 << 4) & 112), value61);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value62 = DataCanbus.DATA[82] - 1;
                if (value62 < 0) {
                    value62 = 3;
                }
                setCarInfo(254, value62);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value63 = DataCanbus.DATA[82] + 1;
                if (value63 > 3) {
                    value63 = 0;
                }
                setCarInfo(254, value63);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value64 = DataCanbus.DATA[85];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value64 = DataCanbus.DATA[197];
                }
                if (value64 > 0) {
                    value64--;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(47, new int[]{value64}, null, null);
                } else {
                    setCarInfo(253, value64);
                }
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value65 = DataCanbus.DATA[85];
                if (DataCanbus.DATA[1000] == 12648900) {
                    value65 = DataCanbus.DATA[197];
                }
                if (value65 < 36) {
                    value65++;
                }
                if (DataCanbus.DATA[1000] == 12648900) {
                    DataCanbus.PROXY.cmd(47, new int[]{value65}, null, null);
                } else {
                    setCarInfo(253, value65);
                }
                break;
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
    }
}
