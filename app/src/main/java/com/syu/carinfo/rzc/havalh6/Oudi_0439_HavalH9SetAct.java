package com.syu.carinfo.rzc.havalh6;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class Oudi_0439_HavalH9SetAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int value;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value2 = DataCanbus.DATA[153] - 1;
                    if (value2 < 1) {
                        value2 = 10;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(26, value2);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value3 = DataCanbus.DATA[153] + 1;
                    if (value3 > 10) {
                        value3 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(26, value3);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value4 = DataCanbus.DATA[101] - 1;
                    if (value4 < 1) {
                        value4 = 4;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(4, value4);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value5 = DataCanbus.DATA[101] + 1;
                    if (value5 > 4) {
                        value5 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(4, value5);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value6 = DataCanbus.DATA[102] - 1;
                    if (value6 < 1) {
                        value6 = 4;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(5, value6);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value7 = DataCanbus.DATA[102] + 1;
                    if (value7 > 4) {
                        value7 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(5, value7);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value8 = DataCanbus.DATA[103] - 1;
                    if (value8 < 1) {
                        value8 = 3;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(6, value8);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value9 = DataCanbus.DATA[103] + 1;
                    if (value9 > 3) {
                        value9 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(6, value9);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[104];
                    if (value10 == 1) {
                        value10 = 1;
                    } else if (value10 == 0) {
                        value10 = 2;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(7, value10);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                case R.id.btn_plus6 /* 2131427472 */:
                    if (DataCanbus.DATA[106] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(12, value);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                case R.id.btn_plus7 /* 2131427475 */:
                    int value11 = DataCanbus.DATA[108];
                    if (value11 == 1) {
                        value11 = 0;
                    } else if (value11 == 0) {
                        value11 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(15, value11);
                    break;
                case R.id.btn_minus8 /* 2131427476 */:
                    int value12 = DataCanbus.DATA[109] - 1;
                    if (value12 < 0) {
                        value12 = 3;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(14, value12);
                    break;
                case R.id.btn_plus8 /* 2131427478 */:
                    int value13 = DataCanbus.DATA[109] + 1;
                    if (value13 > 3) {
                        value13 = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(14, value13);
                    break;
                case R.id.btn_minus9 /* 2131427479 */:
                case R.id.btn_plus9 /* 2131427481 */:
                    int value14 = DataCanbus.DATA[110];
                    if (value14 == 1) {
                        value14 = 0;
                    } else if (value14 == 0) {
                        value14 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(16, value14);
                    break;
                case R.id.btn_minus10 /* 2131427482 */:
                    int value15 = DataCanbus.DATA[156] - 1;
                    if (value15 < 0) {
                        value15 = 2;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(50, value15);
                    break;
                case R.id.btn_plus10 /* 2131427484 */:
                    int value16 = DataCanbus.DATA[156] + 1;
                    if (value16 > 2) {
                        value16 = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(50, value16);
                    break;
                case R.id.btn_minus11 /* 2131427485 */:
                    int value17 = DataCanbus.DATA[164] - 1;
                    if (value17 < 0) {
                        value17 = 2;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(51, value17);
                    break;
                case R.id.btn_plus11 /* 2131427487 */:
                    int value18 = DataCanbus.DATA[164] + 1;
                    if (value18 > 2) {
                        value18 = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(51, value18);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Oudi_0439_HavalH9SetAct.this, RZC_0439_HavalH9AmpSetAct.class);
                        Oudi_0439_HavalH9SetAct.this.startActivity(intent);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    int value19 = DataCanbus.DATA[105] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value19 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    int value20 = DataCanbus.DATA[107] & 255;
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[2];
                    iArr2[0] = 13;
                    iArr2[1] = value20 == 0 ? 1 : 0;
                    remoteModuleProxy2.cmd(1, iArr2, null, null);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    int value21 = DataCanbus.DATA[163] & 255;
                    RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                    int[] iArr3 = new int[2];
                    iArr3[0] = 60;
                    iArr3[1] = value21 == 0 ? 1 : 0;
                    remoteModuleProxy3.cmd(1, iArr3, null, null);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    int value22 = DataCanbus.DATA[111] & 255;
                    RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                    int[] iArr4 = new int[2];
                    iArr4[0] = 17;
                    iArr4[1] = value22 == 0 ? 1 : 0;
                    remoteModuleProxy4.cmd(1, iArr4, null, null);
                    break;
                case R.id.ctv_checkedtext6 /* 2131427548 */:
                    int value23 = DataCanbus.DATA[112] & 255;
                    RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                    int[] iArr5 = new int[2];
                    iArr5[0] = 18;
                    iArr5[1] = value23 == 0 ? 1 : 0;
                    remoteModuleProxy5.cmd(1, iArr5, null, null);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427549 */:
                    int value24 = DataCanbus.DATA[113] & 255;
                    RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                    int[] iArr6 = new int[2];
                    iArr6[0] = 19;
                    iArr6[1] = value24 == 0 ? 1 : 0;
                    remoteModuleProxy6.cmd(1, iArr6, null, null);
                    break;
                case R.id.ctv_checkedtext8 /* 2131427550 */:
                    int value25 = DataCanbus.DATA[129] & 255;
                    RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                    int[] iArr7 = new int[2];
                    iArr7[0] = 23;
                    iArr7[1] = value25 == 0 ? 1 : 0;
                    remoteModuleProxy7.cmd(1, iArr7, null, null);
                    break;
                case R.id.ctv_checkedtext9 /* 2131427551 */:
                    int value26 = DataCanbus.DATA[130] & 255;
                    RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                    int[] iArr8 = new int[2];
                    iArr8[0] = 24;
                    iArr8[1] = value26 == 0 ? 1 : 0;
                    remoteModuleProxy8.cmd(1, iArr8, null, null);
                    break;
                case R.id.ctv_checkedtext10 /* 2131427552 */:
                    int value27 = DataCanbus.DATA[115] & 255;
                    RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                    int[] iArr9 = new int[1];
                    iArr9[0] = value27 != 0 ? 0 : 1;
                    remoteModuleProxy9.cmd(2, iArr9, null, null);
                    break;
                case R.id.ctv_checkedtext11 /* 2131427553 */:
                    int value28 = DataCanbus.DATA[154] & 255;
                    RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                    int[] iArr10 = new int[2];
                    iArr10[0] = 48;
                    iArr10[1] = value28 == 0 ? 1 : 0;
                    remoteModuleProxy10.cmd(1, iArr10, null, null);
                    break;
                case R.id.ctv_checkedtext12 /* 2131427554 */:
                    int value29 = DataCanbus.DATA[155] & 255;
                    RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                    int[] iArr11 = new int[2];
                    iArr11[0] = 49;
                    iArr11[1] = value29 == 0 ? 1 : 0;
                    remoteModuleProxy11.cmd(1, iArr11, null, null);
                    break;
                case R.id.ctv_checkedtext13 /* 2131427555 */:
                    int value30 = DataCanbus.DATA[157] & 255;
                    RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                    int[] iArr12 = new int[2];
                    iArr12[0] = 53;
                    iArr12[1] = value30 == 0 ? 1 : 0;
                    remoteModuleProxy12.cmd(1, iArr12, null, null);
                    break;
                case R.id.ctv_checkedtext14 /* 2131427556 */:
                    int value31 = DataCanbus.DATA[158] & 255;
                    RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                    int[] iArr13 = new int[2];
                    iArr13[0] = 54;
                    iArr13[1] = value31 == 0 ? 1 : 0;
                    remoteModuleProxy13.cmd(1, iArr13, null, null);
                    break;
                case R.id.ctv_checkedtext15 /* 2131427557 */:
                    int value32 = DataCanbus.DATA[159] & 255;
                    RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                    int[] iArr14 = new int[2];
                    iArr14[0] = 55;
                    iArr14[1] = value32 == 0 ? 1 : 0;
                    remoteModuleProxy14.cmd(1, iArr14, null, null);
                    break;
                case R.id.ctv_checkedtext16 /* 2131427558 */:
                    int value33 = DataCanbus.DATA[160] & 255;
                    RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                    int[] iArr15 = new int[2];
                    iArr15[0] = 57;
                    iArr15[1] = value33 == 0 ? 1 : 0;
                    remoteModuleProxy15.cmd(1, iArr15, null, null);
                    break;
                case R.id.ctv_checkedtext17 /* 2131427559 */:
                    int value34 = DataCanbus.DATA[161] & 255;
                    RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                    int[] iArr16 = new int[2];
                    iArr16[0] = 58;
                    iArr16[1] = value34 == 0 ? 1 : 0;
                    remoteModuleProxy16.cmd(1, iArr16, null, null);
                    break;
                case R.id.ctv_checkedtext18 /* 2131427661 */:
                    int value35 = DataCanbus.DATA[162] & 255;
                    RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                    int[] iArr17 = new int[2];
                    iArr17[0] = 59;
                    iArr17[1] = value35 == 0 ? 1 : 0;
                    remoteModuleProxy17.cmd(1, iArr17, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    Oudi_0439_HavalH9SetAct.this.updateDomeDelay();
                    break;
                case 102:
                    Oudi_0439_HavalH9SetAct.this.updateFollowHome();
                    break;
                case 103:
                    Oudi_0439_HavalH9SetAct.this.updatePowerSave();
                    break;
                case 104:
                    Oudi_0439_HavalH9SetAct.this.updateRainFall();
                    break;
                case 105:
                    Oudi_0439_HavalH9SetAct.this.updateRearViewAuto();
                    break;
                case 106:
                    Oudi_0439_HavalH9SetAct.this.updateFrontLight();
                    break;
                case 107:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterSeatmemory();
                    break;
                case 108:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterParkset();
                    break;
                case 109:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterAntisheftset();
                    break;
                case 110:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterDoorlockset();
                    break;
                case 111:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterCetaset();
                    break;
                case 112:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterCartopset();
                    break;
                case 113:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterAllterrainset();
                    break;
                case 114:
                    Oudi_0439_HavalH9SetAct.this.updateScreenBright();
                    break;
                case 115:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterValue8();
                    break;
                case 129:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterCollisionWarn();
                    break;
                case 130:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterAutoBrake();
                    break;
                case 153:
                    if (((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 154:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                        break;
                    }
                case 155:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                        break;
                    }
                case 156:
                    switch (value) {
                        case 0:
                            ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_middle);
                            break;
                        default:
                            ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                            break;
                    }
                case 157:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                        break;
                    }
                case 158:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                        break;
                    }
                case 159:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                        break;
                    }
                case 160:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                        break;
                    }
                case 161:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                        break;
                    }
                case 162:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext18)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                        break;
                    }
                case 163:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
                case 164:
                    switch (value) {
                        case 0:
                            ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                            break;
                        default:
                            ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_od_havalh9set);
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
                Oudi_0439_HavalH9SetAct.this.language_set = position;
                if (Oudi_0439_HavalH9SetAct.this.language_set >= 0 && Oudi_0439_HavalH9SetAct.this.language_set <= Oudi_0439_HavalH9SetAct.this.mLauStylelist.size() && Oudi_0439_HavalH9SetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{25, Oudi_0439_HavalH9SetAct.this.send_lang[Oudi_0439_HavalH9SetAct.this.language_set]}, null, null);
                }
                Oudi_0439_HavalH9SetAct.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Oudi_0439_HavalH9SetAct.this.mLauStyle == null) {
                    Oudi_0439_HavalH9SetAct.this.initLauStyle();
                }
                if (Oudi_0439_HavalH9SetAct.this.mLauStyle != null && Oudi_0439_HavalH9SetAct.this.mPopShowView != null) {
                    Oudi_0439_HavalH9SetAct.this.mLauStyle.showAtLocation(Oudi_0439_HavalH9SetAct.this.mPopShowView, 17, 0, 0);
                    Oudi_0439_HavalH9SetAct.this.updateLauguageSet();
                }
            }
        });
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
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                break;
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                break;
        }
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus8));
        setonClick((Button) findViewById(R.id.btn_plus8));
        setonClick((Button) findViewById(R.id.btn_minus9));
        setonClick((Button) findViewById(R.id.btn_plus9));
        setonClick((Button) findViewById(R.id.btn_minus10));
        setonClick((Button) findViewById(R.id.btn_plus10));
        setonClick((Button) findViewById(R.id.btn_minus11));
        setonClick((Button) findViewById(R.id.btn_plus11));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18));
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
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
    }

    
    public void mUpdaterAutoBrake() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCollisionWarn() {
        int value = DataCanbus.DATA[129];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                        default:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                    }
                default:
                    switch (value) {
                        case 0:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                        case 1:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockdriver_set);
                            break;
                        default:
                            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_unlockall_set);
                            break;
                    }
            }
        }
    }

    
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("10min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("20min");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText("30min");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                    break;
            }
        }
    }

    
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[115] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
        }
    }

    
    public void updateDomeDelay() {
        String str;
        int domedelay = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    switch (domedelay) {
                        case 1:
                            str = "10s";
                            break;
                        case 2:
                            str = "30s";
                            break;
                        case 3:
                            str = "1min";
                            break;
                        case 4:
                            str = "3min";
                            break;
                        default:
                            str = "10s";
                            break;
                    }
                default:
                    switch (domedelay) {
                        case 1:
                            str = "3s";
                            break;
                        case 2:
                            str = "10s";
                            break;
                        case 3:
                            str = "20s";
                            break;
                        case 4:
                            str = "30s";
                            break;
                        default:
                            str = "3s";
                            break;
                    }
            }
            ((TextView) findViewById(R.id.tv_text2)).setText(str);
        }
    }

    
    public void updateFollowHome() {
        String str;
        int followhome = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (followhome) {
                case 1:
                    str = "30s";
                    break;
                case 2:
                    str = "1min";
                    break;
                case 3:
                    str = "2min";
                    break;
                case 4:
                    str = "3min";
                    break;
                default:
                    str = "30s";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text3)).setText(str);
        }
    }

    
    public void updatePowerSave() {
        String str;
        int powersave = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (powersave) {
                case 1:
                    str = "10min";
                    break;
                case 2:
                    str = "20min";
                    break;
                case 3:
                    str = "30min";
                    break;
                default:
                    str = "10min";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text4)).setText(str);
        }
    }

    
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)) != null) {
            if (bright <= 26) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_244_screenbright);
            } else if (bright >= 255) {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.rzc_havalh6_bright_adjust_text)).setText(String.format("%d", Integer.valueOf(bright)));
            }
        }
    }

    
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (frontlight == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight2);
            }
        }
    }
}
