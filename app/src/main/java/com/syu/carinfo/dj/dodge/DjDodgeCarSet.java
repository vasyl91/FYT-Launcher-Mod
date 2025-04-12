package com.syu.carinfo.dj.dodge;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DjDodgeCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (DjDodgeCarSet.this.findViewById(R.id.tv_text1) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text1)).setText("Off");
                                break;
                            case 1:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text1)).setText("Sound Only");
                                break;
                            case 2:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text1)).setText("Sound & Display");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (DjDodgeCarSet.this.findViewById(R.id.tv_text2) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (DjDodgeCarSet.this.findViewById(R.id.tv_text3) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 2:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            case 3:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text3)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 102:
                    DjDodgeCarSet.this.setCheck(DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 103:
                    DjDodgeCarSet.this.setCheck(DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 104:
                    DjDodgeCarSet.this.setCheck(DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 105:
                    DjDodgeCarSet.this.setCheck(DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 106:
                    if (DjDodgeCarSet.this.findViewById(R.id.tv_text4) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                                break;
                            case 1:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                                break;
                        }
                    }
                    break;
                case 107:
                    DjDodgeCarSet.this.setCheck(DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 108:
                    DjDodgeCarSet.this.setCheck(DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 109:
                    if (DjDodgeCarSet.this.findViewById(R.id.tv_text5) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text5)).setText("0s");
                                break;
                            case 1:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text5)).setText("45s");
                                break;
                            case 2:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text5)).setText("5min");
                                break;
                            case 3:
                                ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text5)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 111:
                    DjDodgeCarSet.this.updateText6(val);
                    break;
                case 112:
                    if (DjDodgeCarSet.this.findViewById(R.id.tv_text15) != null) {
                        ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text15)).setText(val + "%");
                        break;
                    }
                case 113:
                    DjDodgeCarSet.this.updateText7(val);
                    break;
                case 114:
                    DjDodgeCarSet.this.updateText8(val);
                    break;
                case 115:
                    DjDodgeCarSet.this.updateText9(val);
                    break;
                case 116:
                    DjDodgeCarSet.this.updateText10(val);
                    break;
                case 117:
                    DjDodgeCarSet.this.updateText11(val);
                    break;
                case 118:
                    DjDodgeCarSet.this.updateText12(val);
                    break;
                case 119:
                    DjDodgeCarSet.this.updateText13(val);
                    break;
                case 120:
                    DjDodgeCarSet.this.updateText14(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_dj_dodge_jcuv_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_minus8), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
        setSelfClick(findViewById(R.id.btn_minus9), this);
        setSelfClick(findViewById(R.id.btn_plus9), this);
        setSelfClick(findViewById(R.id.btn_minus10), this);
        setSelfClick(findViewById(R.id.btn_plus10), this);
        setSelfClick(findViewById(R.id.btn_minus11), this);
        setSelfClick(findViewById(R.id.btn_plus11), this);
        setSelfClick(findViewById(R.id.btn_minus12), this);
        setSelfClick(findViewById(R.id.btn_plus12), this);
        setSelfClick(findViewById(R.id.btn_minus13), this);
        setSelfClick(findViewById(R.id.btn_plus13), this);
        setSelfClick(findViewById(R.id.btn_minus14), this);
        setSelfClick(findViewById(R.id.btn_plus14), this);
        setSelfClick(findViewById(R.id.btn_minus15), this);
        setSelfClick(findViewById(R.id.btn_plus15), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int D0_B76 = DataCanbus.DATA[99];
                int D0_B54 = DataCanbus.DATA[100];
                int D0_B32 = DataCanbus.DATA[101];
                int D0_B1 = DataCanbus.DATA[102];
                int D0_B0 = DataCanbus.DATA[103];
                int D1_B7 = DataCanbus.DATA[104];
                int D1_B6 = DataCanbus.DATA[105];
                int D1_B5 = DataCanbus.DATA[106];
                int D1_B4 = DataCanbus.DATA[107];
                int D1_B3 = DataCanbus.DATA[108];
                int D1_B21 = DataCanbus.DATA[109];
                int unit = DataCanbus.DATA[119];
                int lang = DataCanbus.DATA[120];
                int D0_B762 = D0_B76 - 1;
                if (D0_B762 < 0) {
                    D0_B762 = 2;
                }
                setCarInfo(((D0_B762 << 6) & 192) | ((D0_B54 << 4) & 48) | ((D0_B32 << 2) & 12) | ((D0_B1 << 1) & 2) | ((D0_B0 << 0) & 1), ((D1_B7 << 7) & 128) | ((D1_B6 << 6) & 64) | ((D1_B5 << 5) & 32) | ((D1_B4 << 4) & 16) | ((D1_B3 << 3) & 8) | ((D1_B21 << 1) & 6), ((lang << 4) & 240) | ((unit << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int D0_B763 = DataCanbus.DATA[99];
                int D0_B542 = DataCanbus.DATA[100];
                int D0_B322 = DataCanbus.DATA[101];
                int D0_B12 = DataCanbus.DATA[102];
                int D0_B02 = DataCanbus.DATA[103];
                int D1_B72 = DataCanbus.DATA[104];
                int D1_B62 = DataCanbus.DATA[105];
                int D1_B52 = DataCanbus.DATA[106];
                int D1_B42 = DataCanbus.DATA[107];
                int D1_B32 = DataCanbus.DATA[108];
                int D1_B212 = DataCanbus.DATA[109];
                int unit2 = DataCanbus.DATA[119];
                int lang2 = DataCanbus.DATA[120];
                int D0_B764 = D0_B763 + 1;
                if (D0_B764 > 2) {
                    D0_B764 = 0;
                }
                setCarInfo(((D0_B764 << 6) & 192) | ((D0_B542 << 4) & 48) | ((D0_B322 << 2) & 12) | ((D0_B12 << 1) & 2) | ((D0_B02 << 0) & 1), ((D1_B72 << 7) & 128) | ((D1_B62 << 6) & 64) | ((D1_B52 << 5) & 32) | ((D1_B42 << 4) & 16) | ((D1_B32 << 3) & 8) | ((D1_B212 << 1) & 6), ((lang2 << 4) & 240) | ((unit2 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int D0_B765 = DataCanbus.DATA[99];
                int D0_B543 = DataCanbus.DATA[100];
                int D0_B323 = DataCanbus.DATA[101];
                int D0_B13 = DataCanbus.DATA[102];
                int D0_B03 = DataCanbus.DATA[103];
                int D1_B73 = DataCanbus.DATA[104];
                int D1_B63 = DataCanbus.DATA[105];
                int D1_B53 = DataCanbus.DATA[106];
                int D1_B43 = DataCanbus.DATA[107];
                int D1_B33 = DataCanbus.DATA[108];
                int D1_B213 = DataCanbus.DATA[109];
                int unit3 = DataCanbus.DATA[119];
                int lang3 = DataCanbus.DATA[120];
                int D0_B544 = D0_B543 - 1;
                if (D0_B544 < 0) {
                    D0_B544 = 3;
                }
                setCarInfo(((D0_B765 << 6) & 192) | ((D0_B544 << 4) & 48) | ((D0_B323 << 2) & 12) | ((D0_B13 << 1) & 2) | ((D0_B03 << 0) & 1), ((D1_B73 << 7) & 128) | ((D1_B63 << 6) & 64) | ((D1_B53 << 5) & 32) | ((D1_B43 << 4) & 16) | ((D1_B33 << 3) & 8) | ((D1_B213 << 1) & 6), ((lang3 << 4) & 240) | ((unit3 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int D0_B766 = DataCanbus.DATA[99];
                int D0_B545 = DataCanbus.DATA[100];
                int D0_B324 = DataCanbus.DATA[101];
                int D0_B14 = DataCanbus.DATA[102];
                int D0_B04 = DataCanbus.DATA[103];
                int D1_B74 = DataCanbus.DATA[104];
                int D1_B64 = DataCanbus.DATA[105];
                int D1_B54 = DataCanbus.DATA[106];
                int D1_B44 = DataCanbus.DATA[107];
                int D1_B34 = DataCanbus.DATA[108];
                int D1_B214 = DataCanbus.DATA[109];
                int unit4 = DataCanbus.DATA[119];
                int lang4 = DataCanbus.DATA[120];
                int D0_B546 = D0_B545 + 1;
                if (D0_B546 > 3) {
                    D0_B546 = 0;
                }
                setCarInfo(((D0_B766 << 6) & 192) | ((D0_B546 << 4) & 48) | ((D0_B324 << 2) & 12) | ((D0_B14 << 1) & 2) | ((D0_B04 << 0) & 1), ((D1_B74 << 7) & 128) | ((D1_B64 << 6) & 64) | ((D1_B54 << 5) & 32) | ((D1_B44 << 4) & 16) | ((D1_B34 << 3) & 8) | ((D1_B214 << 1) & 6), ((lang4 << 4) & 240) | ((unit4 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int D0_B767 = DataCanbus.DATA[99];
                int D0_B547 = DataCanbus.DATA[100];
                int D0_B325 = DataCanbus.DATA[101];
                int D0_B15 = DataCanbus.DATA[102];
                int D0_B05 = DataCanbus.DATA[103];
                int D1_B75 = DataCanbus.DATA[104];
                int D1_B65 = DataCanbus.DATA[105];
                int D1_B55 = DataCanbus.DATA[106];
                int D1_B45 = DataCanbus.DATA[107];
                int D1_B35 = DataCanbus.DATA[108];
                int D1_B215 = DataCanbus.DATA[109];
                int unit5 = DataCanbus.DATA[119];
                int lang5 = DataCanbus.DATA[120];
                int D0_B326 = D0_B325 - 1;
                if (D0_B326 < 0) {
                    D0_B326 = 3;
                }
                setCarInfo(((D0_B767 << 6) & 192) | ((D0_B547 << 4) & 48) | ((D0_B326 << 2) & 12) | ((D0_B15 << 1) & 2) | ((D0_B05 << 0) & 1), ((D1_B75 << 7) & 128) | ((D1_B65 << 6) & 64) | ((D1_B55 << 5) & 32) | ((D1_B45 << 4) & 16) | ((D1_B35 << 3) & 8) | ((D1_B215 << 1) & 6), ((lang5 << 4) & 240) | ((unit5 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int D0_B768 = DataCanbus.DATA[99];
                int D0_B548 = DataCanbus.DATA[100];
                int D0_B327 = DataCanbus.DATA[101];
                int D0_B16 = DataCanbus.DATA[102];
                int D0_B06 = DataCanbus.DATA[103];
                int D1_B76 = DataCanbus.DATA[104];
                int D1_B66 = DataCanbus.DATA[105];
                int D1_B56 = DataCanbus.DATA[106];
                int D1_B46 = DataCanbus.DATA[107];
                int D1_B36 = DataCanbus.DATA[108];
                int D1_B216 = DataCanbus.DATA[109];
                int unit6 = DataCanbus.DATA[119];
                int lang6 = DataCanbus.DATA[120];
                int D0_B328 = D0_B327 + 1;
                if (D0_B328 > 3) {
                    D0_B328 = 0;
                }
                setCarInfo(((D0_B768 << 6) & 192) | ((D0_B548 << 4) & 48) | ((D0_B328 << 2) & 12) | ((D0_B16 << 1) & 2) | ((D0_B06 << 0) & 1), ((D1_B76 << 7) & 128) | ((D1_B66 << 6) & 64) | ((D1_B56 << 5) & 32) | ((D1_B46 << 4) & 16) | ((D1_B36 << 3) & 8) | ((D1_B216 << 1) & 6), ((lang6 << 4) & 240) | ((unit6 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
            case R.id.btn_plus4 /* 2131427466 */:
                int D0_B769 = DataCanbus.DATA[99];
                int D0_B549 = DataCanbus.DATA[100];
                int D0_B329 = DataCanbus.DATA[101];
                int D0_B17 = DataCanbus.DATA[102];
                int D0_B07 = DataCanbus.DATA[103];
                int D1_B77 = DataCanbus.DATA[104];
                int D1_B67 = DataCanbus.DATA[105];
                int D1_B57 = DataCanbus.DATA[106];
                int D1_B47 = DataCanbus.DATA[107];
                int D1_B37 = DataCanbus.DATA[108];
                int D1_B217 = DataCanbus.DATA[109];
                int unit7 = DataCanbus.DATA[119];
                int lang7 = DataCanbus.DATA[120];
                if (D1_B57 == 0) {
                    D1_B57 = 1;
                } else if (D1_B57 == 1) {
                    D1_B57 = 0;
                }
                setCarInfo(((D0_B769 << 6) & 192) | ((D0_B549 << 4) & 48) | ((D0_B329 << 2) & 12) | ((D0_B17 << 1) & 2) | ((D0_B07 << 0) & 1), ((D1_B77 << 7) & 128) | ((D1_B67 << 6) & 64) | ((D1_B57 << 5) & 32) | ((D1_B47 << 4) & 16) | ((D1_B37 << 3) & 8) | ((D1_B217 << 1) & 6), ((lang7 << 4) & 240) | ((unit7 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int D0_B7610 = DataCanbus.DATA[99];
                int D0_B5410 = DataCanbus.DATA[100];
                int D0_B3210 = DataCanbus.DATA[101];
                int D0_B18 = DataCanbus.DATA[102];
                int D0_B08 = DataCanbus.DATA[103];
                int D1_B78 = DataCanbus.DATA[104];
                int D1_B68 = DataCanbus.DATA[105];
                int D1_B58 = DataCanbus.DATA[106];
                int D1_B48 = DataCanbus.DATA[107];
                int D1_B38 = DataCanbus.DATA[108];
                int D1_B218 = DataCanbus.DATA[109];
                int unit8 = DataCanbus.DATA[119];
                int lang8 = DataCanbus.DATA[120];
                int D1_B219 = D1_B218 - 1;
                if (D1_B219 < 0) {
                    D1_B219 = 3;
                }
                setCarInfo(((D0_B7610 << 6) & 192) | ((D0_B5410 << 4) & 48) | ((D0_B3210 << 2) & 12) | ((D0_B18 << 1) & 2) | ((D0_B08 << 0) & 1), ((D1_B78 << 7) & 128) | ((D1_B68 << 6) & 64) | ((D1_B58 << 5) & 32) | ((D1_B48 << 4) & 16) | ((D1_B38 << 3) & 8) | ((D1_B219 << 1) & 6), ((lang8 << 4) & 240) | ((unit8 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int D0_B7611 = DataCanbus.DATA[99];
                int D0_B5411 = DataCanbus.DATA[100];
                int D0_B3211 = DataCanbus.DATA[101];
                int D0_B19 = DataCanbus.DATA[102];
                int D0_B09 = DataCanbus.DATA[103];
                int D1_B79 = DataCanbus.DATA[104];
                int D1_B69 = DataCanbus.DATA[105];
                int D1_B59 = DataCanbus.DATA[106];
                int D1_B49 = DataCanbus.DATA[107];
                int D1_B39 = DataCanbus.DATA[108];
                int D1_B2110 = DataCanbus.DATA[109];
                int unit9 = DataCanbus.DATA[119];
                int lang9 = DataCanbus.DATA[120];
                int D1_B2111 = D1_B2110 + 1;
                if (D1_B2111 > 3) {
                    D1_B2111 = 0;
                }
                setCarInfo(((D0_B7611 << 6) & 192) | ((D0_B5411 << 4) & 48) | ((D0_B3211 << 2) & 12) | ((D0_B19 << 1) & 2) | ((D0_B09 << 0) & 1), ((D1_B79 << 7) & 128) | ((D1_B69 << 6) & 64) | ((D1_B59 << 5) & 32) | ((D1_B49 << 4) & 16) | ((D1_B39 << 3) & 8) | ((D1_B2111 << 1) & 6), ((lang9 << 4) & 240) | ((unit9 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int vol = DataCanbus.DATA[111];
                int percent = DataCanbus.DATA[112];
                int bal = DataCanbus.DATA[113];
                int fad = DataCanbus.DATA[114];
                int bass = DataCanbus.DATA[115];
                int mid = DataCanbus.DATA[116];
                int treb = DataCanbus.DATA[117];
                int speedvol = DataCanbus.DATA[118];
                if (vol > 0) {
                    vol--;
                }
                setCarEQ(vol, percent, bal, fad, bass, mid, treb, speedvol);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int vol2 = DataCanbus.DATA[111];
                int percent2 = DataCanbus.DATA[112];
                int bal2 = DataCanbus.DATA[113];
                int fad2 = DataCanbus.DATA[114];
                int bass2 = DataCanbus.DATA[115];
                int mid2 = DataCanbus.DATA[116];
                int treb2 = DataCanbus.DATA[117];
                int speedvol2 = DataCanbus.DATA[118];
                if (vol2 < 38) {
                    vol2++;
                }
                setCarEQ(vol2, percent2, bal2, fad2, bass2, mid2, treb2, speedvol2);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int vol3 = DataCanbus.DATA[111];
                int percent3 = DataCanbus.DATA[112];
                int bal3 = DataCanbus.DATA[113];
                int fad3 = DataCanbus.DATA[114];
                int bass3 = DataCanbus.DATA[115];
                int mid3 = DataCanbus.DATA[116];
                int treb3 = DataCanbus.DATA[117];
                int speedvol3 = DataCanbus.DATA[118];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarEQ(vol3, percent3, bal3, fad3, bass3, mid3, treb3, speedvol3);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int vol4 = DataCanbus.DATA[111];
                int percent4 = DataCanbus.DATA[112];
                int bal4 = DataCanbus.DATA[113];
                int fad4 = DataCanbus.DATA[114];
                int bass4 = DataCanbus.DATA[115];
                int mid4 = DataCanbus.DATA[116];
                int treb4 = DataCanbus.DATA[117];
                int speedvol4 = DataCanbus.DATA[118];
                if (bal4 < 19) {
                    bal4++;
                }
                setCarEQ(vol4, percent4, bal4, fad4, bass4, mid4, treb4, speedvol4);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int vol5 = DataCanbus.DATA[111];
                int percent5 = DataCanbus.DATA[112];
                int bal5 = DataCanbus.DATA[113];
                int fad5 = DataCanbus.DATA[114];
                int bass5 = DataCanbus.DATA[115];
                int mid5 = DataCanbus.DATA[116];
                int treb5 = DataCanbus.DATA[117];
                int speedvol5 = DataCanbus.DATA[118];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarEQ(vol5, percent5, bal5, fad5, bass5, mid5, treb5, speedvol5);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int vol6 = DataCanbus.DATA[111];
                int percent6 = DataCanbus.DATA[112];
                int bal6 = DataCanbus.DATA[113];
                int fad6 = DataCanbus.DATA[114];
                int bass6 = DataCanbus.DATA[115];
                int mid6 = DataCanbus.DATA[116];
                int treb6 = DataCanbus.DATA[117];
                int speedvol6 = DataCanbus.DATA[118];
                if (fad6 < 19) {
                    fad6++;
                }
                setCarEQ(vol6, percent6, bal6, fad6, bass6, mid6, treb6, speedvol6);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int vol7 = DataCanbus.DATA[111];
                int percent7 = DataCanbus.DATA[112];
                int bal7 = DataCanbus.DATA[113];
                int fad7 = DataCanbus.DATA[114];
                int bass7 = DataCanbus.DATA[115];
                int mid7 = DataCanbus.DATA[116];
                int treb7 = DataCanbus.DATA[117];
                int speedvol7 = DataCanbus.DATA[118];
                if (bass7 > 0) {
                    bass7--;
                }
                setCarEQ(vol7, percent7, bal7, fad7, bass7, mid7, treb7, speedvol7);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int vol8 = DataCanbus.DATA[111];
                int volper = DataCanbus.DATA[112];
                int bal8 = DataCanbus.DATA[113];
                int fad8 = DataCanbus.DATA[114];
                int bass8 = DataCanbus.DATA[115];
                int mid8 = DataCanbus.DATA[116];
                int treb8 = DataCanbus.DATA[117];
                int speedvol8 = DataCanbus.DATA[118];
                if (bass8 < 19) {
                    bass8++;
                }
                setCarEQ(vol8, volper, bal8, fad8, bass8, mid8, treb8, speedvol8);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int vol9 = DataCanbus.DATA[111];
                int volper2 = DataCanbus.DATA[112];
                int bal9 = DataCanbus.DATA[113];
                int fad9 = DataCanbus.DATA[114];
                int bass9 = DataCanbus.DATA[115];
                int mid9 = DataCanbus.DATA[116];
                int treb9 = DataCanbus.DATA[117];
                int speedvol9 = DataCanbus.DATA[118];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarEQ(vol9, volper2, bal9, fad9, bass9, mid9, treb9, speedvol9);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int vol10 = DataCanbus.DATA[111];
                int volper3 = DataCanbus.DATA[112];
                int bal10 = DataCanbus.DATA[113];
                int fad10 = DataCanbus.DATA[114];
                int bass10 = DataCanbus.DATA[115];
                int mid10 = DataCanbus.DATA[116];
                int treb10 = DataCanbus.DATA[117];
                int speedvol10 = DataCanbus.DATA[118];
                if (mid10 < 19) {
                    mid10++;
                }
                setCarEQ(vol10, volper3, bal10, fad10, bass10, mid10, treb10, speedvol10);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int vol11 = DataCanbus.DATA[111];
                int volper4 = DataCanbus.DATA[112];
                int bal11 = DataCanbus.DATA[113];
                int fad11 = DataCanbus.DATA[114];
                int bass11 = DataCanbus.DATA[115];
                int mid11 = DataCanbus.DATA[116];
                int treb11 = DataCanbus.DATA[117];
                int speedvol11 = DataCanbus.DATA[118];
                if (treb11 > 0) {
                    treb11--;
                }
                setCarEQ(vol11, volper4, bal11, fad11, bass11, mid11, treb11, speedvol11);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int vol12 = DataCanbus.DATA[111];
                int volper5 = DataCanbus.DATA[112];
                int bal12 = DataCanbus.DATA[113];
                int fad12 = DataCanbus.DATA[114];
                int bass12 = DataCanbus.DATA[115];
                int mid12 = DataCanbus.DATA[116];
                int treb12 = DataCanbus.DATA[117];
                int speedvol12 = DataCanbus.DATA[118];
                if (treb12 < 19) {
                    treb12++;
                }
                setCarEQ(vol12, volper5, bal12, fad12, bass12, mid12, treb12, speedvol12);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int vol13 = DataCanbus.DATA[111];
                int volper6 = DataCanbus.DATA[112];
                int bal13 = DataCanbus.DATA[113];
                int fad13 = DataCanbus.DATA[114];
                int bass13 = DataCanbus.DATA[115];
                int mid13 = DataCanbus.DATA[116];
                int treb13 = DataCanbus.DATA[117];
                int speedvol13 = DataCanbus.DATA[118];
                if (speedvol13 > 0) {
                    speedvol13--;
                }
                setCarEQ(vol13, volper6, bal13, fad13, bass13, mid13, treb13, speedvol13);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int vol14 = DataCanbus.DATA[111];
                int volper7 = DataCanbus.DATA[112];
                int bal14 = DataCanbus.DATA[113];
                int fad14 = DataCanbus.DATA[114];
                int bass14 = DataCanbus.DATA[115];
                int mid14 = DataCanbus.DATA[116];
                int treb14 = DataCanbus.DATA[117];
                int speedvol14 = DataCanbus.DATA[118];
                if (speedvol14 < 3) {
                    speedvol14++;
                }
                setCarEQ(vol14, volper7, bal14, fad14, bass14, mid14, treb14, speedvol14);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int D0_B7612 = DataCanbus.DATA[99];
                int D0_B5412 = DataCanbus.DATA[100];
                int D0_B3212 = DataCanbus.DATA[101];
                int D0_B110 = DataCanbus.DATA[102];
                int D0_B010 = DataCanbus.DATA[103];
                int D1_B710 = DataCanbus.DATA[104];
                int D1_B610 = DataCanbus.DATA[105];
                int D1_B510 = DataCanbus.DATA[106];
                int D1_B410 = DataCanbus.DATA[107];
                int D1_B310 = DataCanbus.DATA[108];
                int D1_B2112 = DataCanbus.DATA[109];
                int unit10 = DataCanbus.DATA[119];
                int lang10 = DataCanbus.DATA[120];
                int unit11 = unit10 - 1;
                if (unit11 < 0) {
                    unit11 = 2;
                }
                setCarInfo(((D0_B7612 << 6) & 192) | ((D0_B5412 << 4) & 48) | ((D0_B3212 << 2) & 12) | ((D0_B110 << 1) & 2) | ((D0_B010 << 0) & 1), ((D1_B710 << 7) & 128) | ((D1_B610 << 6) & 64) | ((D1_B510 << 5) & 32) | ((D1_B410 << 4) & 16) | ((D1_B310 << 3) & 8) | ((D1_B2112 << 1) & 6), ((lang10 << 4) & 240) | ((unit11 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int D0_B7613 = DataCanbus.DATA[99];
                int D0_B5413 = DataCanbus.DATA[100];
                int D0_B3213 = DataCanbus.DATA[101];
                int D0_B111 = DataCanbus.DATA[102];
                int D0_B011 = DataCanbus.DATA[103];
                int D1_B711 = DataCanbus.DATA[104];
                int D1_B611 = DataCanbus.DATA[105];
                int D1_B511 = DataCanbus.DATA[106];
                int D1_B411 = DataCanbus.DATA[107];
                int D1_B311 = DataCanbus.DATA[108];
                int D1_B2113 = DataCanbus.DATA[109];
                int unit12 = DataCanbus.DATA[119];
                int lang11 = DataCanbus.DATA[120];
                int unit13 = unit12 + 1;
                if (unit13 > 2) {
                    unit13 = 0;
                }
                setCarInfo(((D0_B7613 << 6) & 192) | ((D0_B5413 << 4) & 48) | ((D0_B3213 << 2) & 12) | ((D0_B111 << 1) & 2) | ((D0_B011 << 0) & 1), ((D1_B711 << 7) & 128) | ((D1_B611 << 6) & 64) | ((D1_B511 << 5) & 32) | ((D1_B411 << 4) & 16) | ((D1_B311 << 3) & 8) | ((D1_B2113 << 1) & 6), ((lang11 << 4) & 240) | ((unit13 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int D0_B7614 = DataCanbus.DATA[99];
                int D0_B5414 = DataCanbus.DATA[100];
                int D0_B3214 = DataCanbus.DATA[101];
                int D0_B112 = DataCanbus.DATA[102];
                int D0_B012 = DataCanbus.DATA[103];
                int D1_B712 = DataCanbus.DATA[104];
                int D1_B612 = DataCanbus.DATA[105];
                int D1_B512 = DataCanbus.DATA[106];
                int D1_B412 = DataCanbus.DATA[107];
                int D1_B312 = DataCanbus.DATA[108];
                int D1_B2114 = DataCanbus.DATA[109];
                int unit14 = DataCanbus.DATA[119];
                int lang12 = DataCanbus.DATA[120] - 1;
                if (lang12 < 0) {
                    lang12 = 2;
                }
                setCarInfo(((D0_B7614 << 6) & 192) | ((D0_B5414 << 4) & 48) | ((D0_B3214 << 2) & 12) | ((D0_B112 << 1) & 2) | ((D0_B012 << 0) & 1), ((D1_B712 << 7) & 128) | ((D1_B612 << 6) & 64) | ((D1_B512 << 5) & 32) | ((D1_B412 << 4) & 16) | ((D1_B312 << 3) & 8) | ((D1_B2114 << 1) & 6), ((lang12 << 4) & 240) | ((unit14 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int D0_B7615 = DataCanbus.DATA[99];
                int D0_B5415 = DataCanbus.DATA[100];
                int D0_B3215 = DataCanbus.DATA[101];
                int D0_B113 = DataCanbus.DATA[102];
                int D0_B013 = DataCanbus.DATA[103];
                int D1_B713 = DataCanbus.DATA[104];
                int D1_B613 = DataCanbus.DATA[105];
                int D1_B513 = DataCanbus.DATA[106];
                int D1_B413 = DataCanbus.DATA[107];
                int D1_B313 = DataCanbus.DATA[108];
                int D1_B2115 = DataCanbus.DATA[109];
                int unit15 = DataCanbus.DATA[119];
                int lang13 = DataCanbus.DATA[120] + 1;
                if (lang13 > 2) {
                    lang13 = 0;
                }
                setCarInfo(((D0_B7615 << 6) & 192) | ((D0_B5415 << 4) & 48) | ((D0_B3215 << 2) & 12) | ((D0_B113 << 1) & 2) | ((D0_B013 << 0) & 1), ((D1_B713 << 7) & 128) | ((D1_B613 << 6) & 64) | ((D1_B513 << 5) & 32) | ((D1_B413 << 4) & 16) | ((D1_B313 << 3) & 8) | ((D1_B2115 << 1) & 6), ((lang13 << 4) & 240) | ((unit15 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int vol15 = DataCanbus.DATA[111];
                int percent8 = DataCanbus.DATA[112];
                int bal15 = DataCanbus.DATA[113];
                int fad15 = DataCanbus.DATA[114];
                int bass15 = DataCanbus.DATA[115];
                int mid15 = DataCanbus.DATA[116];
                int treb15 = DataCanbus.DATA[117];
                int speedvol15 = DataCanbus.DATA[118];
                if (percent8 > 0) {
                    percent8 -= 5;
                }
                if (percent8 < 0) {
                    percent8 = 0;
                }
                setCarEQ(vol15, percent8, bal15, fad15, bass15, mid15, treb15, speedvol15);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int vol16 = DataCanbus.DATA[111];
                int percent9 = DataCanbus.DATA[112];
                int bal16 = DataCanbus.DATA[113];
                int fad16 = DataCanbus.DATA[114];
                int bass16 = DataCanbus.DATA[115];
                int mid16 = DataCanbus.DATA[116];
                int treb16 = DataCanbus.DATA[117];
                int speedvol16 = DataCanbus.DATA[118];
                if (percent9 < 100) {
                    percent9 += 5;
                }
                if (percent9 > 100) {
                    percent9 = 100;
                }
                setCarEQ(vol16, percent9, bal16, fad16, bass16, mid16, treb16, speedvol16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int D0_B7616 = DataCanbus.DATA[99];
                int D0_B5416 = DataCanbus.DATA[100];
                int D0_B3216 = DataCanbus.DATA[101];
                int D0_B114 = DataCanbus.DATA[102];
                int D0_B014 = DataCanbus.DATA[103];
                int D1_B714 = DataCanbus.DATA[104];
                int D1_B614 = DataCanbus.DATA[105];
                int D1_B514 = DataCanbus.DATA[106];
                int D1_B414 = DataCanbus.DATA[107];
                int D1_B314 = DataCanbus.DATA[108];
                int D1_B2116 = DataCanbus.DATA[109];
                int unit16 = DataCanbus.DATA[119];
                int lang14 = DataCanbus.DATA[120];
                if (D1_B314 == 0) {
                    D1_B314 = 1;
                } else if (D1_B314 == 1) {
                    D1_B314 = 0;
                }
                setCarInfo(((D0_B7616 << 6) & 192) | ((D0_B5416 << 4) & 48) | ((D0_B3216 << 2) & 12) | ((D0_B114 << 1) & 2) | ((D0_B014 << 0) & 1), ((D1_B714 << 7) & 128) | ((D1_B614 << 6) & 64) | ((D1_B514 << 5) & 32) | ((D1_B414 << 4) & 16) | ((D1_B314 << 3) & 8) | ((D1_B2116 << 1) & 6), ((lang14 << 4) & 240) | ((unit16 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int D0_B7617 = DataCanbus.DATA[99];
                int D0_B5417 = DataCanbus.DATA[100];
                int D0_B3217 = DataCanbus.DATA[101];
                int D0_B115 = DataCanbus.DATA[102];
                int D0_B015 = DataCanbus.DATA[103];
                int D1_B715 = DataCanbus.DATA[104];
                int D1_B615 = DataCanbus.DATA[105];
                int D1_B515 = DataCanbus.DATA[106];
                int D1_B415 = DataCanbus.DATA[107];
                int D1_B315 = DataCanbus.DATA[108];
                int D1_B2117 = DataCanbus.DATA[109];
                int unit17 = DataCanbus.DATA[119];
                int lang15 = DataCanbus.DATA[120];
                if (D0_B115 == 0) {
                    D0_B115 = 1;
                } else if (D0_B115 == 1) {
                    D0_B115 = 0;
                }
                setCarInfo(((D0_B7617 << 6) & 192) | ((D0_B5417 << 4) & 48) | ((D0_B3217 << 2) & 12) | ((D0_B115 << 1) & 2) | ((D0_B015 << 0) & 1), ((D1_B715 << 7) & 128) | ((D1_B615 << 6) & 64) | ((D1_B515 << 5) & 32) | ((D1_B415 << 4) & 16) | ((D1_B315 << 3) & 8) | ((D1_B2117 << 1) & 6), ((lang15 << 4) & 240) | ((unit17 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int D0_B7618 = DataCanbus.DATA[99];
                int D0_B5418 = DataCanbus.DATA[100];
                int D0_B3218 = DataCanbus.DATA[101];
                int D0_B116 = DataCanbus.DATA[102];
                int D0_B016 = DataCanbus.DATA[103];
                int D1_B716 = DataCanbus.DATA[104];
                int D1_B616 = DataCanbus.DATA[105];
                int D1_B516 = DataCanbus.DATA[106];
                int D1_B416 = DataCanbus.DATA[107];
                int D1_B316 = DataCanbus.DATA[108];
                int D1_B2118 = DataCanbus.DATA[109];
                int unit18 = DataCanbus.DATA[119];
                int lang16 = DataCanbus.DATA[120];
                if (D0_B016 == 0) {
                    D0_B016 = 1;
                } else if (D0_B016 == 1) {
                    D0_B016 = 0;
                }
                setCarInfo(((D0_B7618 << 6) & 192) | ((D0_B5418 << 4) & 48) | ((D0_B3218 << 2) & 12) | ((D0_B116 << 1) & 2) | ((D0_B016 << 0) & 1), ((D1_B716 << 7) & 128) | ((D1_B616 << 6) & 64) | ((D1_B516 << 5) & 32) | ((D1_B416 << 4) & 16) | ((D1_B316 << 3) & 8) | ((D1_B2118 << 1) & 6), ((lang16 << 4) & 240) | ((unit18 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int D0_B7619 = DataCanbus.DATA[99];
                int D0_B5419 = DataCanbus.DATA[100];
                int D0_B3219 = DataCanbus.DATA[101];
                int D0_B117 = DataCanbus.DATA[102];
                int D0_B017 = DataCanbus.DATA[103];
                int D1_B717 = DataCanbus.DATA[104];
                int D1_B617 = DataCanbus.DATA[105];
                int D1_B517 = DataCanbus.DATA[106];
                int D1_B417 = DataCanbus.DATA[107];
                int D1_B317 = DataCanbus.DATA[108];
                int D1_B2119 = DataCanbus.DATA[109];
                int unit19 = DataCanbus.DATA[119];
                int lang17 = DataCanbus.DATA[120];
                if (D1_B617 == 0) {
                    D1_B617 = 1;
                } else if (D1_B617 == 1) {
                    D1_B617 = 0;
                }
                setCarInfo(((D0_B7619 << 6) & 192) | ((D0_B5419 << 4) & 48) | ((D0_B3219 << 2) & 12) | ((D0_B117 << 1) & 2) | ((D0_B017 << 0) & 1), ((D1_B717 << 7) & 128) | ((D1_B617 << 6) & 64) | ((D1_B517 << 5) & 32) | ((D1_B417 << 4) & 16) | ((D1_B317 << 3) & 8) | ((D1_B2119 << 1) & 6), ((lang17 << 4) & 240) | ((unit19 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int D0_B7620 = DataCanbus.DATA[99];
                int D0_B5420 = DataCanbus.DATA[100];
                int D0_B3220 = DataCanbus.DATA[101];
                int D0_B118 = DataCanbus.DATA[102];
                int D0_B018 = DataCanbus.DATA[103];
                int D1_B718 = DataCanbus.DATA[104];
                int D1_B618 = DataCanbus.DATA[105];
                int D1_B518 = DataCanbus.DATA[106];
                int D1_B418 = DataCanbus.DATA[107];
                int D1_B318 = DataCanbus.DATA[108];
                int D1_B2120 = DataCanbus.DATA[109];
                int unit20 = DataCanbus.DATA[119];
                int lang18 = DataCanbus.DATA[120];
                if (D1_B418 == 0) {
                    D1_B418 = 1;
                } else if (D1_B418 == 1) {
                    D1_B418 = 0;
                }
                setCarInfo(((D0_B7620 << 6) & 192) | ((D0_B5420 << 4) & 48) | ((D0_B3220 << 2) & 12) | ((D0_B118 << 1) & 2) | ((D0_B018 << 0) & 1), ((D1_B718 << 7) & 128) | ((D1_B618 << 6) & 64) | ((D1_B518 << 5) & 32) | ((D1_B418 << 4) & 16) | ((D1_B318 << 3) & 8) | ((D1_B2120 << 1) & 6), ((lang18 << 4) & 240) | ((unit20 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int D0_B7621 = DataCanbus.DATA[99];
                int D0_B5421 = DataCanbus.DATA[100];
                int D0_B3221 = DataCanbus.DATA[101];
                int D0_B119 = DataCanbus.DATA[102];
                int D0_B019 = DataCanbus.DATA[103];
                int D1_B719 = DataCanbus.DATA[104];
                int D1_B619 = DataCanbus.DATA[105];
                int D1_B519 = DataCanbus.DATA[106];
                int D1_B419 = DataCanbus.DATA[107];
                int D1_B319 = DataCanbus.DATA[108];
                int D1_B2121 = DataCanbus.DATA[109];
                int unit21 = DataCanbus.DATA[119];
                int lang19 = DataCanbus.DATA[120];
                if (D1_B719 == 0) {
                    D1_B719 = 1;
                } else if (D1_B719 == 1) {
                    D1_B719 = 0;
                }
                setCarInfo(((D0_B7621 << 6) & 192) | ((D0_B5421 << 4) & 48) | ((D0_B3221 << 2) & 12) | ((D0_B119 << 1) & 2) | ((D0_B019 << 0) & 1), ((D1_B719 << 7) & 128) | ((D1_B619 << 6) & 64) | ((D1_B519 << 5) & 32) | ((D1_B419 << 4) & 16) | ((D1_B319 << 3) & 8) | ((D1_B2121 << 1) & 6), ((lang19 << 4) & 240) | ((unit21 << 0) & 15), 0, 0, 0, 0, 0);
                break;
        }
    }

    public void setCarEQ(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1, value2, value3, value4, value5, value6, value7}, null, null);
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3, value4, value5, value6, value7}, null, null);
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
    }

    
    public void updateText14(int value) {
        if (findViewById(R.id.tv_text14) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_0);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_1);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text14)).setText(R.string.off);
                    break;
            }
        }
    }

    
    public void updateText13(int value) {
        if (findViewById(R.id.tv_text13) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text13)).setText(R.string.str_unit_us_imperial);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text13)).setText(R.string.str_unit_metric);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text13)).setText(R.string.off);
                    break;
            }
        }
    }

    
    public void updateText12(int value) {
        if (findViewById(R.id.tv_text12) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Off");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value));
                    break;
            }
        }
    }

    
    public void updateText11(int value) {
        if (findViewById(R.id.tv_text11) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text11)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value - 10));
            }
        }
    }

    
    public void updateText10(int value) {
        if (findViewById(R.id.tv_text10) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text10)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value - 10));
            }
        }
    }

    
    public void updateText9(int value) {
        if (findViewById(R.id.tv_text9) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text9)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value - 10));
            }
        }
    }

    
    public void updateText8(int value) {
        if (findViewById(R.id.tv_text8) != null) {
            if (value == 10) {
                ((TextView) findViewById(R.id.tv_text8)).setText("0");
                return;
            }
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text8)).setText("F" + (10 - value));
            } else if (value > 10) {
                ((TextView) findViewById(R.id.tv_text8)).setText("R" + (value - 10));
            }
        }
    }

    
    public void updateText7(int value) {
        if (findViewById(R.id.tv_text7) != null) {
            if (value == 10) {
                ((TextView) findViewById(R.id.tv_text7)).setText("0");
                return;
            }
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text7)).setText("L" + (10 - value));
            } else if (value > 10) {
                ((TextView) findViewById(R.id.tv_text7)).setText("R" + (value - 10));
            }
        }
    }

    
    public void updateText6(int value) {
        if (findViewById(R.id.tv_text6) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value));
        }
    }
}
