package com.syu.carinfo.dj.dodge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DjDodgeCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.dodge.DjDodgeCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 30:
                    if (((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text1)) != null) {
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
                case 31:
                    if (((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text2)) != null) {
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
                case 32:
                    if (((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text3)) != null) {
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
                case 33:
                    DjDodgeCarSet.this.setCheck((CheckedTextView) DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 34:
                    DjDodgeCarSet.this.setCheck((CheckedTextView) DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 35:
                    DjDodgeCarSet.this.setCheck((CheckedTextView) DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 36:
                    DjDodgeCarSet.this.setCheck((CheckedTextView) DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 37:
                    if (((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text4)) != null) {
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
                case 38:
                    DjDodgeCarSet.this.setCheck((CheckedTextView) DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 39:
                    DjDodgeCarSet.this.setCheck((CheckedTextView) DjDodgeCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 40:
                    if (((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text5)) != null) {
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
                case 42:
                    DjDodgeCarSet.this.updateText6(val);
                    break;
                case 43:
                    if (((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) DjDodgeCarSet.this.findViewById(R.id.tv_text15)).setText(String.valueOf(val) + "%");
                    }
                    break;
                case 44:
                    DjDodgeCarSet.this.updateText7(val);
                    break;
                case 45:
                    DjDodgeCarSet.this.updateText8(val);
                    break;
                case 46:
                    DjDodgeCarSet.this.updateText9(val);
                    break;
                case 47:
                    DjDodgeCarSet.this.updateText10(val);
                    break;
                case 48:
                    DjDodgeCarSet.this.updateText11(val);
                    break;
                case 49:
                    DjDodgeCarSet.this.updateText12(val);
                    break;
                case 50:
                    DjDodgeCarSet.this.updateText13(val);
                    break;
                case 51:
                    DjDodgeCarSet.this.updateText14(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_dj_dodge_jcuv_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int D0_B76 = DataCanbus.DATA[30];
                int D0_B54 = DataCanbus.DATA[31];
                int D0_B32 = DataCanbus.DATA[32];
                int D0_B1 = DataCanbus.DATA[33];
                int D0_B0 = DataCanbus.DATA[34];
                int D1_B7 = DataCanbus.DATA[35];
                int D1_B6 = DataCanbus.DATA[36];
                int D1_B5 = DataCanbus.DATA[37];
                int D1_B4 = DataCanbus.DATA[38];
                int D1_B3 = DataCanbus.DATA[39];
                int D1_B21 = DataCanbus.DATA[40];
                int unit = DataCanbus.DATA[50];
                int lang = DataCanbus.DATA[51];
                int unit2 = unit - 1;
                if (unit2 < 0) {
                    unit2 = 2;
                }
                setCarInfo(((D0_B76 << 6) & 192) | ((D0_B54 << 4) & 48) | ((D0_B32 << 2) & 12) | ((D0_B1 << 1) & 2) | ((D0_B0 << 0) & 1), ((D1_B7 << 7) & 128) | ((D1_B6 << 6) & 64) | ((D1_B5 << 5) & 32) | ((D1_B4 << 4) & 16) | ((D1_B3 << 3) & 8) | ((D1_B21 << 1) & 6), ((lang << 4) & 240) | ((unit2 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int D0_B77 = DataCanbus.DATA[30];
                int D0_B55 = DataCanbus.DATA[31];
                int D0_B33 = DataCanbus.DATA[32];
                int D0_B2 = DataCanbus.DATA[33];
                int D0_B3 = DataCanbus.DATA[34];
                int D1_B8 = DataCanbus.DATA[35];
                int D1_B9 = DataCanbus.DATA[36];
                int D1_B10 = DataCanbus.DATA[37];
                int D1_B11 = DataCanbus.DATA[38];
                int D1_B12 = DataCanbus.DATA[39];
                int D1_B22 = DataCanbus.DATA[40];
                int unit3 = DataCanbus.DATA[50];
                int lang2 = DataCanbus.DATA[51];
                int unit4 = unit3 + 1;
                if (unit4 > 2) {
                    unit4 = 0;
                }
                setCarInfo(((D0_B77 << 6) & 192) | ((D0_B55 << 4) & 48) | ((D0_B33 << 2) & 12) | ((D0_B2 << 1) & 2) | ((D0_B3 << 0) & 1), ((D1_B8 << 7) & 128) | ((D1_B9 << 6) & 64) | ((D1_B10 << 5) & 32) | ((D1_B11 << 4) & 16) | ((D1_B12 << 3) & 8) | ((D1_B22 << 1) & 6), ((lang2 << 4) & 240) | ((unit4 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int D0_B78 = DataCanbus.DATA[30];
                int D0_B56 = DataCanbus.DATA[31];
                int D0_B34 = DataCanbus.DATA[32];
                int D0_B4 = DataCanbus.DATA[33];
                int D0_B5 = DataCanbus.DATA[34];
                int D1_B13 = DataCanbus.DATA[35];
                int D1_B14 = DataCanbus.DATA[36];
                int D1_B15 = DataCanbus.DATA[37];
                int D1_B16 = DataCanbus.DATA[38];
                int D1_B17 = DataCanbus.DATA[39];
                int D1_B23 = DataCanbus.DATA[40];
                int unit5 = DataCanbus.DATA[50];
                int lang3 = DataCanbus.DATA[51] - 1;
                if (lang3 < 0) {
                    lang3 = 2;
                }
                setCarInfo(((D0_B78 << 6) & 192) | ((D0_B56 << 4) & 48) | ((D0_B34 << 2) & 12) | ((D0_B4 << 1) & 2) | ((D0_B5 << 0) & 1), ((D1_B13 << 7) & 128) | ((D1_B14 << 6) & 64) | ((D1_B15 << 5) & 32) | ((D1_B16 << 4) & 16) | ((D1_B17 << 3) & 8) | ((D1_B23 << 1) & 6), ((lang3 << 4) & 240) | ((unit5 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int D0_B79 = DataCanbus.DATA[30];
                int D0_B57 = DataCanbus.DATA[31];
                int D0_B35 = DataCanbus.DATA[32];
                int D0_B6 = DataCanbus.DATA[33];
                int D0_B7 = DataCanbus.DATA[34];
                int D1_B18 = DataCanbus.DATA[35];
                int D1_B19 = DataCanbus.DATA[36];
                int D1_B20 = DataCanbus.DATA[37];
                int D1_B24 = DataCanbus.DATA[38];
                int D1_B25 = DataCanbus.DATA[39];
                int D1_B26 = DataCanbus.DATA[40];
                int unit6 = DataCanbus.DATA[50];
                int lang4 = DataCanbus.DATA[51] + 1;
                if (lang4 > 2) {
                    lang4 = 0;
                }
                setCarInfo(((D0_B79 << 6) & 192) | ((D0_B57 << 4) & 48) | ((D0_B35 << 2) & 12) | ((D0_B6 << 1) & 2) | ((D0_B7 << 0) & 1), ((D1_B18 << 7) & 128) | ((D1_B19 << 6) & 64) | ((D1_B20 << 5) & 32) | ((D1_B24 << 4) & 16) | ((D1_B25 << 3) & 8) | ((D1_B26 << 1) & 6), ((lang4 << 4) & 240) | ((unit6 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int vol = DataCanbus.DATA[42];
                int percent = DataCanbus.DATA[43];
                int bal = DataCanbus.DATA[44];
                int fad = DataCanbus.DATA[45];
                int bass = DataCanbus.DATA[46];
                int mid = DataCanbus.DATA[47];
                int treb = DataCanbus.DATA[48];
                int speedvol = DataCanbus.DATA[49];
                if (percent > 0) {
                    percent -= 5;
                }
                if (percent < 0) {
                    percent = 0;
                }
                setCarEQ(vol, percent, bal, fad, bass, mid, treb, speedvol);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int vol2 = DataCanbus.DATA[42];
                int percent2 = DataCanbus.DATA[43];
                int bal2 = DataCanbus.DATA[44];
                int fad2 = DataCanbus.DATA[45];
                int bass2 = DataCanbus.DATA[46];
                int mid2 = DataCanbus.DATA[47];
                int treb2 = DataCanbus.DATA[48];
                int speedvol2 = DataCanbus.DATA[49];
                if (percent2 < 100) {
                    percent2 += 5;
                }
                if (percent2 > 100) {
                    percent2 = 100;
                }
                setCarEQ(vol2, percent2, bal2, fad2, bass2, mid2, treb2, speedvol2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int D0_B710 = DataCanbus.DATA[30];
                int D0_B58 = DataCanbus.DATA[31];
                int D0_B36 = DataCanbus.DATA[32];
                int D0_B8 = DataCanbus.DATA[33];
                int D0_B9 = DataCanbus.DATA[34];
                int D1_B27 = DataCanbus.DATA[35];
                int D1_B28 = DataCanbus.DATA[36];
                int D1_B29 = DataCanbus.DATA[37];
                int D1_B30 = DataCanbus.DATA[38];
                int D1_B31 = DataCanbus.DATA[39];
                int D1_B210 = DataCanbus.DATA[40];
                int unit7 = DataCanbus.DATA[50];
                int lang5 = DataCanbus.DATA[51];
                if (D1_B31 == 0) {
                    D1_B31 = 1;
                } else if (D1_B31 == 1) {
                    D1_B31 = 0;
                }
                setCarInfo(((D0_B710 << 6) & 192) | ((D0_B58 << 4) & 48) | ((D0_B36 << 2) & 12) | ((D0_B8 << 1) & 2) | ((D0_B9 << 0) & 1), ((D1_B27 << 7) & 128) | ((D1_B28 << 6) & 64) | ((D1_B29 << 5) & 32) | ((D1_B30 << 4) & 16) | ((D1_B31 << 3) & 8) | ((D1_B210 << 1) & 6), ((lang5 << 4) & 240) | ((unit7 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int D0_B711 = DataCanbus.DATA[30];
                int D0_B59 = DataCanbus.DATA[31];
                int D0_B37 = DataCanbus.DATA[32];
                int D0_B10 = DataCanbus.DATA[33];
                int D0_B11 = DataCanbus.DATA[34];
                int D1_B32 = DataCanbus.DATA[35];
                int D1_B33 = DataCanbus.DATA[36];
                int D1_B34 = DataCanbus.DATA[37];
                int D1_B35 = DataCanbus.DATA[38];
                int D1_B36 = DataCanbus.DATA[39];
                int D1_B211 = DataCanbus.DATA[40];
                int unit8 = DataCanbus.DATA[50];
                int lang6 = DataCanbus.DATA[51];
                int D0_B712 = D0_B711 - 1;
                if (D0_B712 < 0) {
                    D0_B712 = 2;
                }
                setCarInfo(((D0_B712 << 6) & 192) | ((D0_B59 << 4) & 48) | ((D0_B37 << 2) & 12) | ((D0_B10 << 1) & 2) | ((D0_B11 << 0) & 1), ((D1_B32 << 7) & 128) | ((D1_B33 << 6) & 64) | ((D1_B34 << 5) & 32) | ((D1_B35 << 4) & 16) | ((D1_B36 << 3) & 8) | ((D1_B211 << 1) & 6), ((lang6 << 4) & 240) | ((unit8 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int D0_B713 = DataCanbus.DATA[30];
                int D0_B510 = DataCanbus.DATA[31];
                int D0_B38 = DataCanbus.DATA[32];
                int D0_B12 = DataCanbus.DATA[33];
                int D0_B13 = DataCanbus.DATA[34];
                int D1_B37 = DataCanbus.DATA[35];
                int D1_B38 = DataCanbus.DATA[36];
                int D1_B39 = DataCanbus.DATA[37];
                int D1_B40 = DataCanbus.DATA[38];
                int D1_B41 = DataCanbus.DATA[39];
                int D1_B212 = DataCanbus.DATA[40];
                int unit9 = DataCanbus.DATA[50];
                int lang7 = DataCanbus.DATA[51];
                int D0_B714 = D0_B713 + 1;
                if (D0_B714 > 2) {
                    D0_B714 = 0;
                }
                setCarInfo(((D0_B714 << 6) & 192) | ((D0_B510 << 4) & 48) | ((D0_B38 << 2) & 12) | ((D0_B12 << 1) & 2) | ((D0_B13 << 0) & 1), ((D1_B37 << 7) & 128) | ((D1_B38 << 6) & 64) | ((D1_B39 << 5) & 32) | ((D1_B40 << 4) & 16) | ((D1_B41 << 3) & 8) | ((D1_B212 << 1) & 6), ((lang7 << 4) & 240) | ((unit9 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int D0_B715 = DataCanbus.DATA[30];
                int D0_B511 = DataCanbus.DATA[31];
                int D0_B39 = DataCanbus.DATA[32];
                int D0_B14 = DataCanbus.DATA[33];
                int D0_B15 = DataCanbus.DATA[34];
                int D1_B42 = DataCanbus.DATA[35];
                int D1_B43 = DataCanbus.DATA[36];
                int D1_B44 = DataCanbus.DATA[37];
                int D1_B45 = DataCanbus.DATA[38];
                int D1_B46 = DataCanbus.DATA[39];
                int D1_B213 = DataCanbus.DATA[40];
                int unit10 = DataCanbus.DATA[50];
                int lang8 = DataCanbus.DATA[51];
                int D0_B512 = D0_B511 - 1;
                if (D0_B512 < 0) {
                    D0_B512 = 3;
                }
                setCarInfo(((D0_B715 << 6) & 192) | ((D0_B512 << 4) & 48) | ((D0_B39 << 2) & 12) | ((D0_B14 << 1) & 2) | ((D0_B15 << 0) & 1), ((D1_B42 << 7) & 128) | ((D1_B43 << 6) & 64) | ((D1_B44 << 5) & 32) | ((D1_B45 << 4) & 16) | ((D1_B46 << 3) & 8) | ((D1_B213 << 1) & 6), ((lang8 << 4) & 240) | ((unit10 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int D0_B716 = DataCanbus.DATA[30];
                int D0_B513 = DataCanbus.DATA[31];
                int D0_B310 = DataCanbus.DATA[32];
                int D0_B16 = DataCanbus.DATA[33];
                int D0_B17 = DataCanbus.DATA[34];
                int D1_B47 = DataCanbus.DATA[35];
                int D1_B48 = DataCanbus.DATA[36];
                int D1_B49 = DataCanbus.DATA[37];
                int D1_B50 = DataCanbus.DATA[38];
                int D1_B51 = DataCanbus.DATA[39];
                int D1_B214 = DataCanbus.DATA[40];
                int unit11 = DataCanbus.DATA[50];
                int lang9 = DataCanbus.DATA[51];
                int D0_B514 = D0_B513 + 1;
                if (D0_B514 > 3) {
                    D0_B514 = 0;
                }
                setCarInfo(((D0_B716 << 6) & 192) | ((D0_B514 << 4) & 48) | ((D0_B310 << 2) & 12) | ((D0_B16 << 1) & 2) | ((D0_B17 << 0) & 1), ((D1_B47 << 7) & 128) | ((D1_B48 << 6) & 64) | ((D1_B49 << 5) & 32) | ((D1_B50 << 4) & 16) | ((D1_B51 << 3) & 8) | ((D1_B214 << 1) & 6), ((lang9 << 4) & 240) | ((unit11 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int D0_B717 = DataCanbus.DATA[30];
                int D0_B515 = DataCanbus.DATA[31];
                int D0_B311 = DataCanbus.DATA[32];
                int D0_B18 = DataCanbus.DATA[33];
                int D0_B19 = DataCanbus.DATA[34];
                int D1_B52 = DataCanbus.DATA[35];
                int D1_B53 = DataCanbus.DATA[36];
                int D1_B54 = DataCanbus.DATA[37];
                int D1_B55 = DataCanbus.DATA[38];
                int D1_B56 = DataCanbus.DATA[39];
                int D1_B215 = DataCanbus.DATA[40];
                int unit12 = DataCanbus.DATA[50];
                int lang10 = DataCanbus.DATA[51];
                int D0_B312 = D0_B311 - 1;
                if (D0_B312 < 0) {
                    D0_B312 = 3;
                }
                setCarInfo(((D0_B717 << 6) & 192) | ((D0_B515 << 4) & 48) | ((D0_B312 << 2) & 12) | ((D0_B18 << 1) & 2) | ((D0_B19 << 0) & 1), ((D1_B52 << 7) & 128) | ((D1_B53 << 6) & 64) | ((D1_B54 << 5) & 32) | ((D1_B55 << 4) & 16) | ((D1_B56 << 3) & 8) | ((D1_B215 << 1) & 6), ((lang10 << 4) & 240) | ((unit12 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int D0_B718 = DataCanbus.DATA[30];
                int D0_B516 = DataCanbus.DATA[31];
                int D0_B313 = DataCanbus.DATA[32];
                int D0_B20 = DataCanbus.DATA[33];
                int D0_B21 = DataCanbus.DATA[34];
                int D1_B57 = DataCanbus.DATA[35];
                int D1_B58 = DataCanbus.DATA[36];
                int D1_B59 = DataCanbus.DATA[37];
                int D1_B60 = DataCanbus.DATA[38];
                int D1_B61 = DataCanbus.DATA[39];
                int D1_B216 = DataCanbus.DATA[40];
                int unit13 = DataCanbus.DATA[50];
                int lang11 = DataCanbus.DATA[51];
                int D0_B314 = D0_B313 + 1;
                if (D0_B314 > 3) {
                    D0_B314 = 0;
                }
                setCarInfo(((D0_B718 << 6) & 192) | ((D0_B516 << 4) & 48) | ((D0_B314 << 2) & 12) | ((D0_B20 << 1) & 2) | ((D0_B21 << 0) & 1), ((D1_B57 << 7) & 128) | ((D1_B58 << 6) & 64) | ((D1_B59 << 5) & 32) | ((D1_B60 << 4) & 16) | ((D1_B61 << 3) & 8) | ((D1_B216 << 1) & 6), ((lang11 << 4) & 240) | ((unit13 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
            case R.id.btn_plus4 /* 2131427494 */:
                int D0_B719 = DataCanbus.DATA[30];
                int D0_B517 = DataCanbus.DATA[31];
                int D0_B315 = DataCanbus.DATA[32];
                int D0_B22 = DataCanbus.DATA[33];
                int D0_B23 = DataCanbus.DATA[34];
                int D1_B62 = DataCanbus.DATA[35];
                int D1_B63 = DataCanbus.DATA[36];
                int D1_B64 = DataCanbus.DATA[37];
                int D1_B65 = DataCanbus.DATA[38];
                int D1_B66 = DataCanbus.DATA[39];
                int D1_B217 = DataCanbus.DATA[40];
                int unit14 = DataCanbus.DATA[50];
                int lang12 = DataCanbus.DATA[51];
                if (D1_B64 == 0) {
                    D1_B64 = 1;
                } else if (D1_B64 == 1) {
                    D1_B64 = 0;
                }
                setCarInfo(((D0_B719 << 6) & 192) | ((D0_B517 << 4) & 48) | ((D0_B315 << 2) & 12) | ((D0_B22 << 1) & 2) | ((D0_B23 << 0) & 1), ((D1_B62 << 7) & 128) | ((D1_B63 << 6) & 64) | ((D1_B64 << 5) & 32) | ((D1_B65 << 4) & 16) | ((D1_B66 << 3) & 8) | ((D1_B217 << 1) & 6), ((lang12 << 4) & 240) | ((unit14 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int D0_B720 = DataCanbus.DATA[30];
                int D0_B518 = DataCanbus.DATA[31];
                int D0_B316 = DataCanbus.DATA[32];
                int D0_B24 = DataCanbus.DATA[33];
                int D0_B25 = DataCanbus.DATA[34];
                int D1_B67 = DataCanbus.DATA[35];
                int D1_B68 = DataCanbus.DATA[36];
                int D1_B69 = DataCanbus.DATA[37];
                int D1_B70 = DataCanbus.DATA[38];
                int D1_B71 = DataCanbus.DATA[39];
                int D1_B218 = DataCanbus.DATA[40];
                int unit15 = DataCanbus.DATA[50];
                int lang13 = DataCanbus.DATA[51];
                int D1_B219 = D1_B218 - 1;
                if (D1_B219 < 0) {
                    D1_B219 = 3;
                }
                setCarInfo(((D0_B720 << 6) & 192) | ((D0_B518 << 4) & 48) | ((D0_B316 << 2) & 12) | ((D0_B24 << 1) & 2) | ((D0_B25 << 0) & 1), ((D1_B67 << 7) & 128) | ((D1_B68 << 6) & 64) | ((D1_B69 << 5) & 32) | ((D1_B70 << 4) & 16) | ((D1_B71 << 3) & 8) | ((D1_B219 << 1) & 6), ((lang13 << 4) & 240) | ((unit15 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int D0_B721 = DataCanbus.DATA[30];
                int D0_B519 = DataCanbus.DATA[31];
                int D0_B317 = DataCanbus.DATA[32];
                int D0_B26 = DataCanbus.DATA[33];
                int D0_B27 = DataCanbus.DATA[34];
                int D1_B72 = DataCanbus.DATA[35];
                int D1_B73 = DataCanbus.DATA[36];
                int D1_B74 = DataCanbus.DATA[37];
                int D1_B75 = DataCanbus.DATA[38];
                int D1_B76 = DataCanbus.DATA[39];
                int D1_B220 = DataCanbus.DATA[40];
                int unit16 = DataCanbus.DATA[50];
                int lang14 = DataCanbus.DATA[51];
                int D1_B221 = D1_B220 + 1;
                if (D1_B221 > 3) {
                    D1_B221 = 0;
                }
                setCarInfo(((D0_B721 << 6) & 192) | ((D0_B519 << 4) & 48) | ((D0_B317 << 2) & 12) | ((D0_B26 << 1) & 2) | ((D0_B27 << 0) & 1), ((D1_B72 << 7) & 128) | ((D1_B73 << 6) & 64) | ((D1_B74 << 5) & 32) | ((D1_B75 << 4) & 16) | ((D1_B76 << 3) & 8) | ((D1_B221 << 1) & 6), ((lang14 << 4) & 240) | ((unit16 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int vol3 = DataCanbus.DATA[42];
                int percent3 = DataCanbus.DATA[43];
                int bal3 = DataCanbus.DATA[44];
                int fad3 = DataCanbus.DATA[45];
                int bass3 = DataCanbus.DATA[46];
                int mid3 = DataCanbus.DATA[47];
                int treb3 = DataCanbus.DATA[48];
                int speedvol3 = DataCanbus.DATA[49];
                if (vol3 > 0) {
                    vol3--;
                }
                setCarEQ(vol3, percent3, bal3, fad3, bass3, mid3, treb3, speedvol3);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int vol4 = DataCanbus.DATA[42];
                int percent4 = DataCanbus.DATA[43];
                int bal4 = DataCanbus.DATA[44];
                int fad4 = DataCanbus.DATA[45];
                int bass4 = DataCanbus.DATA[46];
                int mid4 = DataCanbus.DATA[47];
                int treb4 = DataCanbus.DATA[48];
                int speedvol4 = DataCanbus.DATA[49];
                if (vol4 < 38) {
                    vol4++;
                }
                setCarEQ(vol4, percent4, bal4, fad4, bass4, mid4, treb4, speedvol4);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int vol5 = DataCanbus.DATA[42];
                int percent5 = DataCanbus.DATA[43];
                int bal5 = DataCanbus.DATA[44];
                int fad5 = DataCanbus.DATA[45];
                int bass5 = DataCanbus.DATA[46];
                int mid5 = DataCanbus.DATA[47];
                int treb5 = DataCanbus.DATA[48];
                int speedvol5 = DataCanbus.DATA[49];
                if (bal5 > 0) {
                    bal5--;
                }
                setCarEQ(vol5, percent5, bal5, fad5, bass5, mid5, treb5, speedvol5);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int vol6 = DataCanbus.DATA[42];
                int percent6 = DataCanbus.DATA[43];
                int bal6 = DataCanbus.DATA[44];
                int fad6 = DataCanbus.DATA[45];
                int bass6 = DataCanbus.DATA[46];
                int mid6 = DataCanbus.DATA[47];
                int treb6 = DataCanbus.DATA[48];
                int speedvol6 = DataCanbus.DATA[49];
                if (bal6 < 19) {
                    bal6++;
                }
                setCarEQ(vol6, percent6, bal6, fad6, bass6, mid6, treb6, speedvol6);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int vol7 = DataCanbus.DATA[42];
                int percent7 = DataCanbus.DATA[43];
                int bal7 = DataCanbus.DATA[44];
                int fad7 = DataCanbus.DATA[45];
                int bass7 = DataCanbus.DATA[46];
                int mid7 = DataCanbus.DATA[47];
                int treb7 = DataCanbus.DATA[48];
                int speedvol7 = DataCanbus.DATA[49];
                if (fad7 > 0) {
                    fad7--;
                }
                setCarEQ(vol7, percent7, bal7, fad7, bass7, mid7, treb7, speedvol7);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int vol8 = DataCanbus.DATA[42];
                int percent8 = DataCanbus.DATA[43];
                int bal8 = DataCanbus.DATA[44];
                int fad8 = DataCanbus.DATA[45];
                int bass8 = DataCanbus.DATA[46];
                int mid8 = DataCanbus.DATA[47];
                int treb8 = DataCanbus.DATA[48];
                int speedvol8 = DataCanbus.DATA[49];
                if (fad8 < 19) {
                    fad8++;
                }
                setCarEQ(vol8, percent8, bal8, fad8, bass8, mid8, treb8, speedvol8);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int vol9 = DataCanbus.DATA[42];
                int percent9 = DataCanbus.DATA[43];
                int bal9 = DataCanbus.DATA[44];
                int fad9 = DataCanbus.DATA[45];
                int bass9 = DataCanbus.DATA[46];
                int mid9 = DataCanbus.DATA[47];
                int treb9 = DataCanbus.DATA[48];
                int speedvol9 = DataCanbus.DATA[49];
                if (bass9 > 0) {
                    bass9--;
                }
                setCarEQ(vol9, percent9, bal9, fad9, bass9, mid9, treb9, speedvol9);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int vol10 = DataCanbus.DATA[42];
                int volper = DataCanbus.DATA[43];
                int bal10 = DataCanbus.DATA[44];
                int fad10 = DataCanbus.DATA[45];
                int bass10 = DataCanbus.DATA[46];
                int mid10 = DataCanbus.DATA[47];
                int treb10 = DataCanbus.DATA[48];
                int speedvol10 = DataCanbus.DATA[49];
                if (bass10 < 19) {
                    bass10++;
                }
                setCarEQ(vol10, volper, bal10, fad10, bass10, mid10, treb10, speedvol10);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int vol11 = DataCanbus.DATA[42];
                int volper2 = DataCanbus.DATA[43];
                int bal11 = DataCanbus.DATA[44];
                int fad11 = DataCanbus.DATA[45];
                int bass11 = DataCanbus.DATA[46];
                int mid11 = DataCanbus.DATA[47];
                int treb11 = DataCanbus.DATA[48];
                int speedvol11 = DataCanbus.DATA[49];
                if (mid11 > 0) {
                    mid11--;
                }
                setCarEQ(vol11, volper2, bal11, fad11, bass11, mid11, treb11, speedvol11);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int vol12 = DataCanbus.DATA[42];
                int volper3 = DataCanbus.DATA[43];
                int bal12 = DataCanbus.DATA[44];
                int fad12 = DataCanbus.DATA[45];
                int bass12 = DataCanbus.DATA[46];
                int mid12 = DataCanbus.DATA[47];
                int treb12 = DataCanbus.DATA[48];
                int speedvol12 = DataCanbus.DATA[49];
                if (mid12 < 19) {
                    mid12++;
                }
                setCarEQ(vol12, volper3, bal12, fad12, bass12, mid12, treb12, speedvol12);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int vol13 = DataCanbus.DATA[42];
                int volper4 = DataCanbus.DATA[43];
                int bal13 = DataCanbus.DATA[44];
                int fad13 = DataCanbus.DATA[45];
                int bass13 = DataCanbus.DATA[46];
                int mid13 = DataCanbus.DATA[47];
                int treb13 = DataCanbus.DATA[48];
                int speedvol13 = DataCanbus.DATA[49];
                if (treb13 > 0) {
                    treb13--;
                }
                setCarEQ(vol13, volper4, bal13, fad13, bass13, mid13, treb13, speedvol13);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int vol14 = DataCanbus.DATA[42];
                int volper5 = DataCanbus.DATA[43];
                int bal14 = DataCanbus.DATA[44];
                int fad14 = DataCanbus.DATA[45];
                int bass14 = DataCanbus.DATA[46];
                int mid14 = DataCanbus.DATA[47];
                int treb14 = DataCanbus.DATA[48];
                int speedvol14 = DataCanbus.DATA[49];
                if (treb14 < 19) {
                    treb14++;
                }
                setCarEQ(vol14, volper5, bal14, fad14, bass14, mid14, treb14, speedvol14);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int vol15 = DataCanbus.DATA[42];
                int volper6 = DataCanbus.DATA[43];
                int bal15 = DataCanbus.DATA[44];
                int fad15 = DataCanbus.DATA[45];
                int bass15 = DataCanbus.DATA[46];
                int mid15 = DataCanbus.DATA[47];
                int treb15 = DataCanbus.DATA[48];
                int speedvol15 = DataCanbus.DATA[49];
                if (speedvol15 > 0) {
                    speedvol15--;
                }
                setCarEQ(vol15, volper6, bal15, fad15, bass15, mid15, treb15, speedvol15);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int vol16 = DataCanbus.DATA[42];
                int volper7 = DataCanbus.DATA[43];
                int bal16 = DataCanbus.DATA[44];
                int fad16 = DataCanbus.DATA[45];
                int bass16 = DataCanbus.DATA[46];
                int mid16 = DataCanbus.DATA[47];
                int treb16 = DataCanbus.DATA[48];
                int speedvol16 = DataCanbus.DATA[49];
                if (speedvol16 < 3) {
                    speedvol16++;
                }
                setCarEQ(vol16, volper7, bal16, fad16, bass16, mid16, treb16, speedvol16);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int D0_B722 = DataCanbus.DATA[30];
                int D0_B520 = DataCanbus.DATA[31];
                int D0_B318 = DataCanbus.DATA[32];
                int D0_B28 = DataCanbus.DATA[33];
                int D0_B29 = DataCanbus.DATA[34];
                int D1_B77 = DataCanbus.DATA[35];
                int D1_B78 = DataCanbus.DATA[36];
                int D1_B79 = DataCanbus.DATA[37];
                int D1_B80 = DataCanbus.DATA[38];
                int D1_B81 = DataCanbus.DATA[39];
                int D1_B222 = DataCanbus.DATA[40];
                int unit17 = DataCanbus.DATA[50];
                int lang15 = DataCanbus.DATA[51];
                if (D0_B28 == 0) {
                    D0_B28 = 1;
                } else if (D0_B28 == 1) {
                    D0_B28 = 0;
                }
                setCarInfo(((D0_B722 << 6) & 192) | ((D0_B520 << 4) & 48) | ((D0_B318 << 2) & 12) | ((D0_B28 << 1) & 2) | ((D0_B29 << 0) & 1), ((D1_B77 << 7) & 128) | ((D1_B78 << 6) & 64) | ((D1_B79 << 5) & 32) | ((D1_B80 << 4) & 16) | ((D1_B81 << 3) & 8) | ((D1_B222 << 1) & 6), ((lang15 << 4) & 240) | ((unit17 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int D0_B723 = DataCanbus.DATA[30];
                int D0_B521 = DataCanbus.DATA[31];
                int D0_B319 = DataCanbus.DATA[32];
                int D0_B30 = DataCanbus.DATA[33];
                int D0_B31 = DataCanbus.DATA[34];
                int D1_B82 = DataCanbus.DATA[35];
                int D1_B83 = DataCanbus.DATA[36];
                int D1_B84 = DataCanbus.DATA[37];
                int D1_B85 = DataCanbus.DATA[38];
                int D1_B86 = DataCanbus.DATA[39];
                int D1_B223 = DataCanbus.DATA[40];
                int unit18 = DataCanbus.DATA[50];
                int lang16 = DataCanbus.DATA[51];
                if (D0_B31 == 0) {
                    D0_B31 = 1;
                } else if (D0_B31 == 1) {
                    D0_B31 = 0;
                }
                setCarInfo(((D0_B723 << 6) & 192) | ((D0_B521 << 4) & 48) | ((D0_B319 << 2) & 12) | ((D0_B30 << 1) & 2) | ((D0_B31 << 0) & 1), ((D1_B82 << 7) & 128) | ((D1_B83 << 6) & 64) | ((D1_B84 << 5) & 32) | ((D1_B85 << 4) & 16) | ((D1_B86 << 3) & 8) | ((D1_B223 << 1) & 6), ((lang16 << 4) & 240) | ((unit18 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int D0_B724 = DataCanbus.DATA[30];
                int D0_B522 = DataCanbus.DATA[31];
                int D0_B320 = DataCanbus.DATA[32];
                int D0_B40 = DataCanbus.DATA[33];
                int D0_B41 = DataCanbus.DATA[34];
                int D1_B87 = DataCanbus.DATA[35];
                int D1_B88 = DataCanbus.DATA[36];
                int D1_B89 = DataCanbus.DATA[37];
                int D1_B90 = DataCanbus.DATA[38];
                int D1_B91 = DataCanbus.DATA[39];
                int D1_B224 = DataCanbus.DATA[40];
                int unit19 = DataCanbus.DATA[50];
                int lang17 = DataCanbus.DATA[51];
                if (D1_B88 == 0) {
                    D1_B88 = 1;
                } else if (D1_B88 == 1) {
                    D1_B88 = 0;
                }
                setCarInfo(((D0_B724 << 6) & 192) | ((D0_B522 << 4) & 48) | ((D0_B320 << 2) & 12) | ((D0_B40 << 1) & 2) | ((D0_B41 << 0) & 1), ((D1_B87 << 7) & 128) | ((D1_B88 << 6) & 64) | ((D1_B89 << 5) & 32) | ((D1_B90 << 4) & 16) | ((D1_B91 << 3) & 8) | ((D1_B224 << 1) & 6), ((lang17 << 4) & 240) | ((unit19 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int D0_B725 = DataCanbus.DATA[30];
                int D0_B523 = DataCanbus.DATA[31];
                int D0_B321 = DataCanbus.DATA[32];
                int D0_B42 = DataCanbus.DATA[33];
                int D0_B43 = DataCanbus.DATA[34];
                int D1_B92 = DataCanbus.DATA[35];
                int D1_B93 = DataCanbus.DATA[36];
                int D1_B94 = DataCanbus.DATA[37];
                int D1_B95 = DataCanbus.DATA[38];
                int D1_B96 = DataCanbus.DATA[39];
                int D1_B225 = DataCanbus.DATA[40];
                int unit20 = DataCanbus.DATA[50];
                int lang18 = DataCanbus.DATA[51];
                if (D1_B95 == 0) {
                    D1_B95 = 1;
                } else if (D1_B95 == 1) {
                    D1_B95 = 0;
                }
                setCarInfo(((D0_B725 << 6) & 192) | ((D0_B523 << 4) & 48) | ((D0_B321 << 2) & 12) | ((D0_B42 << 1) & 2) | ((D0_B43 << 0) & 1), ((D1_B92 << 7) & 128) | ((D1_B93 << 6) & 64) | ((D1_B94 << 5) & 32) | ((D1_B95 << 4) & 16) | ((D1_B96 << 3) & 8) | ((D1_B225 << 1) & 6), ((lang18 << 4) & 240) | ((unit20 << 0) & 15), 0, 0, 0, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int D0_B726 = DataCanbus.DATA[30];
                int D0_B524 = DataCanbus.DATA[31];
                int D0_B322 = DataCanbus.DATA[32];
                int D0_B44 = DataCanbus.DATA[33];
                int D0_B45 = DataCanbus.DATA[34];
                int D1_B97 = DataCanbus.DATA[35];
                int D1_B98 = DataCanbus.DATA[36];
                int D1_B99 = DataCanbus.DATA[37];
                int D1_B100 = DataCanbus.DATA[38];
                int D1_B101 = DataCanbus.DATA[39];
                int D1_B226 = DataCanbus.DATA[40];
                int unit21 = DataCanbus.DATA[50];
                int lang19 = DataCanbus.DATA[51];
                if (D1_B97 == 0) {
                    D1_B97 = 1;
                } else if (D1_B97 == 1) {
                    D1_B97 = 0;
                }
                setCarInfo(((D0_B726 << 6) & 192) | ((D0_B524 << 4) & 48) | ((D0_B322 << 2) & 12) | ((D0_B44 << 1) & 2) | ((D0_B45 << 0) & 1), ((D1_B97 << 7) & 128) | ((D1_B98 << 6) & 64) | ((D1_B99 << 5) & 32) | ((D1_B100 << 4) & 16) | ((D1_B101 << 3) & 8) | ((D1_B226 << 1) & 6), ((lang19 << 4) & 240) | ((unit21 << 0) & 15), 0, 0, 0, 0, 0);
                break;
        }
    }

    public void setCarEQ(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1, value2, value3, value4, value5, value6, value7}, null, null);
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3, value4, value5, value6, value7}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText14(int value) {
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText13(int value) {
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Off");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text11)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value - 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text10)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value - 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value < 10) {
                ((TextView) findViewById(R.id.tv_text9)).setText("-" + (10 - value));
            } else if (value >= 10) {
                ((TextView) findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value - 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
        }
    }
}
