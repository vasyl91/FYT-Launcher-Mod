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
import com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8AmpSetAct;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Oudi_0439_HavalH9SetAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Oudi_0439_HavalH9SetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int value;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Oudi_0439_HavalH9SetAct.this, Dj_0439_HavalH8AmpSetAct.class);
                        Oudi_0439_HavalH9SetAct.this.startActivity(intent);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case R.id.btn_minus1 /* 2131427480 */:
                    int value2 = DataCanbus.DATA[85] - 1;
                    if (value2 < 1) {
                        value2 = 10;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(26, value2);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int value3 = DataCanbus.DATA[85] + 1;
                    if (value3 > 10) {
                        value3 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(26, value3);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    int value4 = DataCanbus.DATA[34] - 1;
                    if (value4 < 1) {
                        value4 = 4;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(4, value4);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int value5 = DataCanbus.DATA[34] + 1;
                    if (value5 > 4) {
                        value5 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(4, value5);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int value6 = DataCanbus.DATA[35] - 1;
                    if (value6 < 1) {
                        value6 = 4;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(5, value6);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int value7 = DataCanbus.DATA[35] + 1;
                    if (value7 > 4) {
                        value7 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(5, value7);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int value8 = DataCanbus.DATA[36] - 1;
                    if (value8 < 1) {
                        value8 = 3;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(6, value8);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int value9 = DataCanbus.DATA[36] + 1;
                    if (value9 > 3) {
                        value9 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(6, value9);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                case R.id.btn_plus5 /* 2131427498 */:
                    int value10 = DataCanbus.DATA[37];
                    if (value10 == 1) {
                        value10 = 1;
                    } else if (value10 == 0) {
                        value10 = 2;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(7, value10);
                    break;
                case R.id.btn_minus6 /* 2131427501 */:
                case R.id.btn_plus6 /* 2131427503 */:
                    if (DataCanbus.DATA[39] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(12, value);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                case R.id.btn_plus7 /* 2131427507 */:
                    int value11 = DataCanbus.DATA[41];
                    if (value11 == 1) {
                        value11 = 0;
                    } else if (value11 == 0) {
                        value11 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(15, value11);
                    break;
                case R.id.btn_minus8 /* 2131427509 */:
                    int value12 = DataCanbus.DATA[42] - 1;
                    if (value12 < 0) {
                        value12 = 3;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(14, value12);
                    break;
                case R.id.btn_plus8 /* 2131427511 */:
                    int value13 = DataCanbus.DATA[42] + 1;
                    if (value13 > 3) {
                        value13 = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(14, value13);
                    break;
                case R.id.btn_minus9 /* 2131427513 */:
                case R.id.btn_plus9 /* 2131427515 */:
                    int value14 = DataCanbus.DATA[43];
                    if (value14 == 1) {
                        value14 = 0;
                    } else if (value14 == 0) {
                        value14 = 1;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(16, value14);
                    break;
                case R.id.btn_minus10 /* 2131427517 */:
                    int value15 = DataCanbus.DATA[97] - 1;
                    if (value15 < 0) {
                        value15 = 2;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(50, value15);
                    break;
                case R.id.btn_plus10 /* 2131427519 */:
                    int value16 = DataCanbus.DATA[97] + 1;
                    if (value16 > 2) {
                        value16 = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(50, value16);
                    break;
                case R.id.btn_minus11 /* 2131427521 */:
                    int value17 = DataCanbus.DATA[105] - 1;
                    if (value17 < 0) {
                        value17 = 2;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(51, value17);
                    break;
                case R.id.btn_plus11 /* 2131427523 */:
                    int value18 = DataCanbus.DATA[105] + 1;
                    if (value18 > 2) {
                        value18 = 0;
                    }
                    Oudi_0439_HavalH9SetAct.this.sendCMD(51, value18);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427531 */:
                    int value19 = DataCanbus.DATA[38] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value19 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427532 */:
                    int value20 = DataCanbus.DATA[40] & 255;
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[2];
                    iArr2[0] = 13;
                    iArr2[1] = value20 == 0 ? 1 : 0;
                    remoteModuleProxy2.cmd(1, iArr2, null, null);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427533 */:
                    int value21 = DataCanbus.DATA[104] & 255;
                    RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                    int[] iArr3 = new int[2];
                    iArr3[0] = 60;
                    iArr3[1] = value21 == 0 ? 1 : 0;
                    remoteModuleProxy3.cmd(1, iArr3, null, null);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427537 */:
                    int value22 = DataCanbus.DATA[44] & 255;
                    RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                    int[] iArr4 = new int[2];
                    iArr4[0] = 17;
                    iArr4[1] = value22 == 0 ? 1 : 0;
                    remoteModuleProxy4.cmd(1, iArr4, null, null);
                    break;
                case R.id.ctv_checkedtext6 /* 2131427538 */:
                    int value23 = DataCanbus.DATA[45] & 255;
                    RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                    int[] iArr5 = new int[2];
                    iArr5[0] = 18;
                    iArr5[1] = value23 == 0 ? 1 : 0;
                    remoteModuleProxy5.cmd(1, iArr5, null, null);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427539 */:
                    int value24 = DataCanbus.DATA[46] & 255;
                    RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                    int[] iArr6 = new int[2];
                    iArr6[0] = 19;
                    iArr6[1] = value24 == 0 ? 1 : 0;
                    remoteModuleProxy6.cmd(1, iArr6, null, null);
                    break;
                case R.id.ctv_checkedtext8 /* 2131427540 */:
                    int value25 = DataCanbus.DATA[69] & 255;
                    RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                    int[] iArr7 = new int[2];
                    iArr7[0] = 23;
                    iArr7[1] = value25 == 0 ? 1 : 0;
                    remoteModuleProxy7.cmd(1, iArr7, null, null);
                    break;
                case R.id.ctv_checkedtext9 /* 2131427541 */:
                    int value26 = DataCanbus.DATA[70] & 255;
                    RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                    int[] iArr8 = new int[2];
                    iArr8[0] = 24;
                    iArr8[1] = value26 == 0 ? 1 : 0;
                    remoteModuleProxy8.cmd(1, iArr8, null, null);
                    break;
                case R.id.ctv_checkedtext10 /* 2131427542 */:
                    int value27 = DataCanbus.DATA[48] & 255;
                    RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                    int[] iArr9 = new int[1];
                    iArr9[0] = value27 != 0 ? 0 : 1;
                    remoteModuleProxy9.cmd(2, iArr9, null, null);
                    break;
                case R.id.ctv_checkedtext11 /* 2131427543 */:
                    int value28 = DataCanbus.DATA[95] & 255;
                    RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                    int[] iArr10 = new int[2];
                    iArr10[0] = 48;
                    iArr10[1] = value28 == 0 ? 1 : 0;
                    remoteModuleProxy10.cmd(1, iArr10, null, null);
                    break;
                case R.id.ctv_checkedtext12 /* 2131427544 */:
                    int value29 = DataCanbus.DATA[96] & 255;
                    RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                    int[] iArr11 = new int[2];
                    iArr11[0] = 49;
                    iArr11[1] = value29 == 0 ? 1 : 0;
                    remoteModuleProxy11.cmd(1, iArr11, null, null);
                    break;
                case R.id.ctv_checkedtext13 /* 2131427545 */:
                    int value30 = DataCanbus.DATA[98] & 255;
                    RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                    int[] iArr12 = new int[2];
                    iArr12[0] = 53;
                    iArr12[1] = value30 == 0 ? 1 : 0;
                    remoteModuleProxy12.cmd(1, iArr12, null, null);
                    break;
                case R.id.ctv_checkedtext14 /* 2131427546 */:
                    int value31 = DataCanbus.DATA[99] & 255;
                    RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                    int[] iArr13 = new int[2];
                    iArr13[0] = 54;
                    iArr13[1] = value31 == 0 ? 1 : 0;
                    remoteModuleProxy13.cmd(1, iArr13, null, null);
                    break;
                case R.id.ctv_checkedtext15 /* 2131427547 */:
                    int value32 = DataCanbus.DATA[100] & 255;
                    RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                    int[] iArr14 = new int[2];
                    iArr14[0] = 55;
                    iArr14[1] = value32 == 0 ? 1 : 0;
                    remoteModuleProxy14.cmd(1, iArr14, null, null);
                    break;
                case R.id.ctv_checkedtext16 /* 2131427548 */:
                    int value33 = DataCanbus.DATA[101] & 255;
                    RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                    int[] iArr15 = new int[2];
                    iArr15[0] = 57;
                    iArr15[1] = value33 == 0 ? 1 : 0;
                    remoteModuleProxy15.cmd(1, iArr15, null, null);
                    break;
                case R.id.ctv_checkedtext17 /* 2131427647 */:
                    int value34 = DataCanbus.DATA[102] & 255;
                    RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                    int[] iArr16 = new int[2];
                    iArr16[0] = 58;
                    iArr16[1] = value34 == 0 ? 1 : 0;
                    remoteModuleProxy16.cmd(1, iArr16, null, null);
                    break;
                case R.id.ctv_checkedtext18 /* 2131427649 */:
                    int value35 = DataCanbus.DATA[103] & 255;
                    RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                    int[] iArr17 = new int[2];
                    iArr17[0] = 59;
                    iArr17[1] = value35 == 0 ? 1 : 0;
                    remoteModuleProxy17.cmd(1, iArr17, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.Oudi_0439_HavalH9SetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 34:
                    Oudi_0439_HavalH9SetAct.this.updateDomeDelay();
                    break;
                case 35:
                    Oudi_0439_HavalH9SetAct.this.updateFollowHome();
                    break;
                case 36:
                    Oudi_0439_HavalH9SetAct.this.updatePowerSave();
                    break;
                case 37:
                    Oudi_0439_HavalH9SetAct.this.updateRainFall();
                    break;
                case 38:
                    Oudi_0439_HavalH9SetAct.this.updateRearViewAuto();
                    break;
                case 39:
                    Oudi_0439_HavalH9SetAct.this.updateFrontLight();
                    break;
                case 40:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterSeatmemory();
                    break;
                case 41:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterParkset();
                    break;
                case 42:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterAntisheftset();
                    break;
                case 43:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterDoorlockset();
                    break;
                case 44:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterCetaset();
                    break;
                case 45:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterCartopset();
                    break;
                case 46:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterAllterrainset();
                    break;
                case 47:
                    Oudi_0439_HavalH9SetAct.this.updateScreenBright();
                    break;
                case 48:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterValue8();
                    break;
                case 69:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterCollisionWarn();
                    break;
                case 70:
                    Oudi_0439_HavalH9SetAct.this.mUpdaterAutoBrake();
                    break;
                case 85:
                    if (((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 95:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                        break;
                    }
                case 96:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                        break;
                    }
                case 97:
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
                case 98:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                        break;
                    }
                case 99:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                        break;
                    }
                case 100:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext15)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                        break;
                    }
                case 101:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext16)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                        break;
                    }
                case 102:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext17)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                        break;
                    }
                case 103:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext18)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                        break;
                    }
                case 104:
                    if (((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) Oudi_0439_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
                case 105:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_od_havalh9set);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Oudi_0439_HavalH9SetAct.3
            @Override // android.widget.AdapterView.OnItemClickListener
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

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Oudi_0439_HavalH9SetAct.4
            @Override // android.view.View.OnClickListener
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoBrake() {
        int value = DataCanbus.DATA[70];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCollisionWarn() {
        int value = DataCanbus.DATA[69];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAllterrainset() {
        int value = DataCanbus.DATA[46];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCartopset() {
        int value = DataCanbus.DATA[45];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCetaset() {
        int value = DataCanbus.DATA[44];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorlockset() {
        int value = DataCanbus.DATA[43];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAntisheftset() {
        int value = DataCanbus.DATA[42];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterParkset() {
        int value = DataCanbus.DATA[41];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatmemory() {
        int value = DataCanbus.DATA[40];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[48] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDomeDelay() {
        String str;
        int domedelay = DataCanbus.DATA[34];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollowHome() {
        String str;
        int followhome = DataCanbus.DATA[35];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePowerSave() {
        String str;
        int powersave = DataCanbus.DATA[36];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRainFall() {
        int rainfall = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (rainfall == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall2);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_244_rainfall1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewAuto() {
        int value = DataCanbus.DATA[38];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScreenBright() {
        int bright = DataCanbus.DATA[47];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontLight() {
        int frontlight = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (frontlight == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight1);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_frontlight2);
            }
        }
    }
}
