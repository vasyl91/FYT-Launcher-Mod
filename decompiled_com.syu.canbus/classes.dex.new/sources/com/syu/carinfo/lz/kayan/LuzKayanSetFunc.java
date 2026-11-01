package com.syu.carinfo.lz.kayan;

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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_LZ_Kayan;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzKayanSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0439_LZ_Kayan.modevalue = ints[2];
                        }
                    }
                    break;
            }
        }
    };
    int pressunit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + " km");
                    break;
                case 113:
                    LuzKayanSetFunc.this.updateInterlightOfftime(value);
                    break;
                case 114:
                    LuzKayanSetFunc.this.updateInterlight(value);
                    break;
                case 115:
                    LuzKayanSetFunc.this.updateDayTimeLight(value);
                    break;
                case 116:
                    LuzKayanSetFunc.this.updateWiperSensorType(value);
                    break;
                case 117:
                    LuzKayanSetFunc.this.updateWiperRearType(value);
                    break;
                case 118:
                    LuzKayanSetFunc.this.updateReversingOptions(value);
                    break;
                case 119:
                    LuzKayanSetFunc.this.updateDoorUnlockType(value);
                    break;
                case 120:
                    LuzKayanSetFunc.this.updateDoorlockType(value);
                    break;
                case 121:
                    LuzKayanSetFunc.this.updateComfortEntry(value);
                    break;
                case 122:
                    LuzKayanSetFunc.this.updateAirPanel(value);
                    break;
                case 123:
                    LuzKayanSetFunc.this.updateAirAutoCirc(value);
                    break;
                case 124:
                    LuzKayanSetFunc.this.updateAirStyleType(value);
                    break;
                case 125:
                    LuzKayanSetFunc.this.updateOutlightOfftime(value);
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text1)).setText("Type1");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text1)).setText("Type2");
                            break;
                    }
                    break;
                case 128:
                    LuzKayanSetFunc.this.updateLauguageSet();
                    break;
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_Manual);
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
                            break;
                    }
                    break;
                case 133:
                    LuzKayanSetFunc.this.findViewById(R.id.layout_view3).setVisibility(value == 1 ? 0 : 8);
                    break;
                case 142:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " PSI");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value * 10) + " Kpa");
                            break;
                    }
                    break;
                case 143:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " PSI");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value * 10) + " Kpa");
                            break;
                    }
                    break;
                case 144:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value) + " PSI");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value * 10) + " Kpa");
                            break;
                    }
                    break;
                case 145:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value) + " PSI");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value * 10) + " Kpa");
                            break;
                    }
                    break;
                case 146:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value) + " PSI");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value * 10) + " Kpa");
                            break;
                    }
                    break;
                case 147:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value / 10) + "." + (value % 10) + " bar");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value) + " PSI");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value * 10) + " Kpa");
                            break;
                    }
                    break;
                case 148:
                    LuzKayanSetFunc.this.pressunit = value;
                    break;
                case 149:
                    switch (LuzKayanSetFunc.this.pressunit) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text19)).setText("275/50 R20 All");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text19)).setText("285/45 R21 All");
                            break;
                        case 2:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text19)).setText("285/45 ZR21 SU");
                            break;
                        case 3:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text19)).setText("285/45 R21 WI");
                            break;
                        case 4:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text19)).setText("285/40 ZR22 SU");
                            break;
                    }
                    break;
                case 150:
                    ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " km");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_luz_kayan_setfunc);
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_DAOH_Panamera_18_SCREEN /* 10289607 */:
                    findViewById(R.id.layout_view1).setVisibility(8);
                    break;
                default:
                    findViewById(R.id.layout_view1).setVisibility(0);
                    break;
            }
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LUZ_KAYAN_MACAN_CD_HP_LOW /* 1900998 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD /* 6291895 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD_HP /* 6422967 */:
            case FinalCanbus.CAR_455_Daohang_LUZ_KAYAN_MACAN_CD_HP /* 9830855 */:
            case FinalCanbus.CAR_455_Daohang_LUZ_KAYAN_MACAN_CD_HP_LOW /* 9896391 */:
            case FinalCanbus.CAR_455_Daohang_LUZ_Cayenne_CD_HP /* 9961927 */:
            case FinalCanbus.CAR_455_LUZ_KAYAN_MACAN_CD_HP_21 /* 12517831 */:
            case FinalCanbus.CAR_455_Daohang_LUZ_KAYAN_MACAN_CD_HP_21 /* 12583367 */:
            case FinalCanbus.CAR_455_Daohang_LUZ_Cayenne_CD_HP_21 /* 13500871 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        init();
    }

    String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LuzKayanSetFunc.this.language_set = position;
                if (LuzKayanSetFunc.this.language_set >= 0 && LuzKayanSetFunc.this.language_set <= LuzKayanSetFunc.this.mLauStylelist.size() && LuzKayanSetFunc.this.send_lang != null) {
                    LuzKayanSetFunc.this.setCarInfo(250, LuzKayanSetFunc.this.language_set);
                    switch (LuzKayanSetFunc.this.language_set) {
                        case 0:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[129] != 2) {
                                LuzKayanSetFunc.this.setCarInfo(254, 2);
                            }
                            break;
                        case 1:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 19, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[129] != 1) {
                                LuzKayanSetFunc.this.setCarInfo(254, 1);
                            }
                            break;
                        case 2:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[129] != 1) {
                                LuzKayanSetFunc.this.setCarInfo(254, 1);
                            }
                            break;
                    }
                }
                LuzKayanSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[128];
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

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("Audi 2017 A4L 1024x480 T100");
        this.mLauStylelist.add("Audi 2017 A4L 400x240 T100");
        this.mLauStylelist.add("Audi 2017 A4L 800x480 T100");
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LuzKayanSetFunc.this.mLauStyle == null) {
                    LuzKayanSetFunc.this.initLauStyle();
                }
                if (LuzKayanSetFunc.this.mLauStyle != null && LuzKayanSetFunc.this.mPopShowView != null) {
                    LuzKayanSetFunc.this.mLauStyle.showAtLocation(LuzKayanSetFunc.this.mPopShowView, 17, 0, 0);
                    LuzKayanSetFunc.this.updateLauguageSet();
                }
            }
        });
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
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
                DataCanbus.PROXY.cmd(0, new int[]{18, value6}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value7 = DataCanbus.DATA[127] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value7}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value8 = DataCanbus.DATA[130] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{248, value8}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value9 = DataCanbus.DATA[130] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{248, value9}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value10 = DataCanbus.DATA[113] - 1;
                if (value10 < 0) {
                    value10 = 30;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value10}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value11 = DataCanbus.DATA[113] + 1;
                if (value11 > 30) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value11}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value12 = DataCanbus.DATA[114] - 1;
                if (value12 < 0) {
                    value12 = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value12}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value13 = DataCanbus.DATA[114] + 1;
                if (value13 > 10) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value13}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value14 = DataCanbus.DATA[125] - 1;
                if (value14 < 1) {
                    value14 = 12;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value14}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value15 = DataCanbus.DATA[125] + 1;
                if (value15 > 12) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value15}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value16 = DataCanbus.DATA[116] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value16}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value17 = DataCanbus.DATA[116] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value17}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value18 = DataCanbus.DATA[117] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value18}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value19 = DataCanbus.DATA[117] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value19}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value20 = DataCanbus.DATA[119] - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value20}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value21 = DataCanbus.DATA[119] + 1;
                if (value21 > 1) {
                    value21 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value21}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value22 = DataCanbus.DATA[120] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value22}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value23 = DataCanbus.DATA[120] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value23}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value24 = DataCanbus.DATA[124] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value24}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value25 = DataCanbus.DATA[124] + 1;
                if (value25 > 2) {
                    value25 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value25}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LuzKayanEVCarInfo.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[121] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value3}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[122] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value2}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (DataCanbus.DATA[115] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value5}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[118] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value4}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (DataCanbus.DATA[123] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, LuzKayanCarInfo.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirStyleType(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.mateng_air_con_profile_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.mateng_air_con_profile_2);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAutoCirc(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirPanel(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComfortEntry(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorlockType(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_ignition_on_lock);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_runautolock);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlockType(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_psa_all_string_door_open_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_psa_all_string_door_open_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReversingOptions(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWiperRearType(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWiperSensorType(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutlightOfftime(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value2) + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDayTimeLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterlight(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterlightOfftime(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value2) + "s");
        }
    }
}
