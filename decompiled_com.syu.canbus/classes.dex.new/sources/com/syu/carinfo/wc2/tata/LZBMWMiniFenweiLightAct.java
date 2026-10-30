package com.syu.carinfo.wc2.tata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZBMWMiniFenweiLightAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniFenweiLightAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 1507781) {
                switch (updateCode) {
                    case 163:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                        break;
                    case 164:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                        break;
                    case 165:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 166:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                        break;
                    case 167:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                        break;
                    case 168:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                        break;
                    case 169:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                        break;
                    case 170:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                        break;
                    case 171:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                        break;
                    case 172:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                        break;
                    case 173:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                        break;
                    case 174:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                        break;
                    case 175:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 176:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 177:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                }
            }
            if (DataCanbus.DATA[1000] == 9568710) {
                switch (updateCode) {
                    case 174:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                        break;
                    case 175:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                        break;
                    case 176:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 177:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                        break;
                    case 178:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                        break;
                    case 179:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                        break;
                    case 180:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                        break;
                    case 181:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                        break;
                    case 182:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                        break;
                    case 183:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                        break;
                    case 184:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                        break;
                    case 185:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                        break;
                    case 186:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 187:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 188:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                }
            }
            switch (updateCode) {
                case 35:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 36:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 37:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 38:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 39:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 40:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 41:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 42:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 43:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 44:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 45:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 46:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 47:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 48:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 49:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_lz_oldmini_fwlight_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int d0_b7 = DataCanbus.DATA[35];
                int d0_b6 = DataCanbus.DATA[36];
                int d0_b30 = DataCanbus.DATA[37];
                int d1_b7 = DataCanbus.DATA[38];
                int d1_b6 = DataCanbus.DATA[39];
                int d1_b5 = DataCanbus.DATA[40];
                int d1_b4 = DataCanbus.DATA[41];
                int d1_b3 = DataCanbus.DATA[42];
                int d1_b2 = DataCanbus.DATA[43];
                int d1_b1 = DataCanbus.DATA[44];
                int d1_b0 = DataCanbus.DATA[45];
                int d2_b0 = DataCanbus.DATA[46];
                int d3_b70 = DataCanbus.DATA[47];
                int d4_b70 = DataCanbus.DATA[48];
                int d5_b70 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b7 = DataCanbus.DATA[163];
                    d0_b6 = DataCanbus.DATA[164];
                    d0_b30 = DataCanbus.DATA[165];
                    d1_b7 = DataCanbus.DATA[166];
                    d1_b6 = DataCanbus.DATA[167];
                    d1_b5 = DataCanbus.DATA[168];
                    d1_b4 = DataCanbus.DATA[169];
                    d1_b3 = DataCanbus.DATA[170];
                    d1_b2 = DataCanbus.DATA[171];
                    d1_b1 = DataCanbus.DATA[172];
                    d1_b0 = DataCanbus.DATA[173];
                    d2_b0 = DataCanbus.DATA[174];
                    d3_b70 = DataCanbus.DATA[175];
                    d4_b70 = DataCanbus.DATA[176];
                    d5_b70 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b7 = DataCanbus.DATA[174];
                    d0_b6 = DataCanbus.DATA[175];
                    d0_b30 = DataCanbus.DATA[176];
                    d1_b7 = DataCanbus.DATA[177];
                    d1_b6 = DataCanbus.DATA[178];
                    d1_b5 = DataCanbus.DATA[179];
                    d1_b4 = DataCanbus.DATA[180];
                    d1_b3 = DataCanbus.DATA[181];
                    d1_b2 = DataCanbus.DATA[182];
                    d1_b1 = DataCanbus.DATA[183];
                    d1_b0 = DataCanbus.DATA[184];
                    d2_b0 = DataCanbus.DATA[185];
                    d3_b70 = DataCanbus.DATA[186];
                    d4_b70 = DataCanbus.DATA[187];
                    d5_b70 = DataCanbus.DATA[188];
                }
                if (d0_b30 > 1) {
                    d0_b30--;
                }
                setCarInfo((d0_b30 & 15) | ((d0_b7 << 7) & 128) | ((d0_b6 << 6) & 64), (d1_b0 & 1) | ((d1_b7 << 7) & 128) | ((d1_b6 << 6) & 64) | ((d1_b5 << 5) & 32) | ((d1_b4 << 4) & 16) | ((d1_b3 << 3) & 8) | ((d1_b2 << 2) & 4) | ((d1_b1 << 1) & 2), d2_b0 & 1, d3_b70, d4_b70, d5_b70);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int d0_b8 = DataCanbus.DATA[35];
                int d0_b9 = DataCanbus.DATA[36];
                int d0_b31 = DataCanbus.DATA[37];
                int d1_b8 = DataCanbus.DATA[38];
                int d1_b9 = DataCanbus.DATA[39];
                int d1_b10 = DataCanbus.DATA[40];
                int d1_b11 = DataCanbus.DATA[41];
                int d1_b12 = DataCanbus.DATA[42];
                int d1_b13 = DataCanbus.DATA[43];
                int d1_b14 = DataCanbus.DATA[44];
                int d1_b15 = DataCanbus.DATA[45];
                int d2_b1 = DataCanbus.DATA[46];
                int d3_b71 = DataCanbus.DATA[47];
                int d4_b71 = DataCanbus.DATA[48];
                int d5_b71 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b8 = DataCanbus.DATA[163];
                    d0_b9 = DataCanbus.DATA[164];
                    d0_b31 = DataCanbus.DATA[165];
                    d1_b8 = DataCanbus.DATA[166];
                    d1_b9 = DataCanbus.DATA[167];
                    d1_b10 = DataCanbus.DATA[168];
                    d1_b11 = DataCanbus.DATA[169];
                    d1_b12 = DataCanbus.DATA[170];
                    d1_b13 = DataCanbus.DATA[171];
                    d1_b14 = DataCanbus.DATA[172];
                    d1_b15 = DataCanbus.DATA[173];
                    d2_b1 = DataCanbus.DATA[174];
                    d3_b71 = DataCanbus.DATA[175];
                    d4_b71 = DataCanbus.DATA[176];
                    d5_b71 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b8 = DataCanbus.DATA[174];
                    d0_b9 = DataCanbus.DATA[175];
                    d0_b31 = DataCanbus.DATA[176];
                    d1_b8 = DataCanbus.DATA[177];
                    d1_b9 = DataCanbus.DATA[178];
                    d1_b10 = DataCanbus.DATA[179];
                    d1_b11 = DataCanbus.DATA[180];
                    d1_b12 = DataCanbus.DATA[181];
                    d1_b13 = DataCanbus.DATA[182];
                    d1_b14 = DataCanbus.DATA[183];
                    d1_b15 = DataCanbus.DATA[184];
                    d2_b1 = DataCanbus.DATA[185];
                    d3_b71 = DataCanbus.DATA[186];
                    d4_b71 = DataCanbus.DATA[187];
                    d5_b71 = DataCanbus.DATA[188];
                }
                if (d0_b31 < 15) {
                    d0_b31++;
                }
                setCarInfo((d0_b31 & 15) | ((d0_b8 << 7) & 128) | ((d0_b9 << 6) & 64), (d1_b15 & 1) | ((d1_b8 << 7) & 128) | ((d1_b9 << 6) & 64) | ((d1_b10 << 5) & 32) | ((d1_b11 << 4) & 16) | ((d1_b12 << 3) & 8) | ((d1_b13 << 2) & 4) | ((d1_b14 << 1) & 2), d2_b1 & 1, d3_b71, d4_b71, d5_b71);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int d0_b10 = DataCanbus.DATA[35];
                int d0_b11 = DataCanbus.DATA[36];
                int d0_b32 = DataCanbus.DATA[37];
                int d1_b16 = DataCanbus.DATA[38];
                int d1_b17 = DataCanbus.DATA[39];
                int d1_b18 = DataCanbus.DATA[40];
                int d1_b19 = DataCanbus.DATA[41];
                int d1_b20 = DataCanbus.DATA[42];
                int d1_b21 = DataCanbus.DATA[43];
                int d1_b22 = DataCanbus.DATA[44];
                int d1_b23 = DataCanbus.DATA[45];
                int d2_b2 = DataCanbus.DATA[46];
                int d3_b72 = DataCanbus.DATA[47];
                int d4_b72 = DataCanbus.DATA[48];
                int d5_b72 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b10 = DataCanbus.DATA[163];
                    d0_b11 = DataCanbus.DATA[164];
                    d0_b32 = DataCanbus.DATA[165];
                    d1_b16 = DataCanbus.DATA[166];
                    d1_b17 = DataCanbus.DATA[167];
                    d1_b18 = DataCanbus.DATA[168];
                    d1_b19 = DataCanbus.DATA[169];
                    d1_b20 = DataCanbus.DATA[170];
                    d1_b21 = DataCanbus.DATA[171];
                    d1_b22 = DataCanbus.DATA[172];
                    d1_b23 = DataCanbus.DATA[173];
                    d2_b2 = DataCanbus.DATA[174];
                    d3_b72 = DataCanbus.DATA[175];
                    d4_b72 = DataCanbus.DATA[176];
                    d5_b72 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b10 = DataCanbus.DATA[174];
                    d0_b11 = DataCanbus.DATA[175];
                    d0_b32 = DataCanbus.DATA[176];
                    d1_b16 = DataCanbus.DATA[177];
                    d1_b17 = DataCanbus.DATA[178];
                    d1_b18 = DataCanbus.DATA[179];
                    d1_b19 = DataCanbus.DATA[180];
                    d1_b20 = DataCanbus.DATA[181];
                    d1_b21 = DataCanbus.DATA[182];
                    d1_b22 = DataCanbus.DATA[183];
                    d1_b23 = DataCanbus.DATA[184];
                    d2_b2 = DataCanbus.DATA[185];
                    d3_b72 = DataCanbus.DATA[186];
                    d4_b72 = DataCanbus.DATA[187];
                    d5_b72 = DataCanbus.DATA[188];
                }
                if (d3_b72 > 0) {
                    d3_b72--;
                }
                setCarInfo((d0_b32 & 15) | ((d0_b10 << 7) & 128) | ((d0_b11 << 6) & 64), (d1_b23 & 1) | ((d1_b16 << 7) & 128) | ((d1_b17 << 6) & 64) | ((d1_b18 << 5) & 32) | ((d1_b19 << 4) & 16) | ((d1_b20 << 3) & 8) | ((d1_b21 << 2) & 4) | ((d1_b22 << 1) & 2), d2_b2 & 1, d3_b72, d4_b72, d5_b72);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int d0_b12 = DataCanbus.DATA[35];
                int d0_b13 = DataCanbus.DATA[36];
                int d0_b33 = DataCanbus.DATA[37];
                int d1_b24 = DataCanbus.DATA[38];
                int d1_b25 = DataCanbus.DATA[39];
                int d1_b26 = DataCanbus.DATA[40];
                int d1_b27 = DataCanbus.DATA[41];
                int d1_b28 = DataCanbus.DATA[42];
                int d1_b29 = DataCanbus.DATA[43];
                int d1_b30 = DataCanbus.DATA[44];
                int d1_b31 = DataCanbus.DATA[45];
                int d2_b3 = DataCanbus.DATA[46];
                int d3_b73 = DataCanbus.DATA[47];
                int d4_b73 = DataCanbus.DATA[48];
                int d5_b73 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b12 = DataCanbus.DATA[163];
                    d0_b13 = DataCanbus.DATA[164];
                    d0_b33 = DataCanbus.DATA[165];
                    d1_b24 = DataCanbus.DATA[166];
                    d1_b25 = DataCanbus.DATA[167];
                    d1_b26 = DataCanbus.DATA[168];
                    d1_b27 = DataCanbus.DATA[169];
                    d1_b28 = DataCanbus.DATA[170];
                    d1_b29 = DataCanbus.DATA[171];
                    d1_b30 = DataCanbus.DATA[172];
                    d1_b31 = DataCanbus.DATA[173];
                    d2_b3 = DataCanbus.DATA[174];
                    d3_b73 = DataCanbus.DATA[175];
                    d4_b73 = DataCanbus.DATA[176];
                    d5_b73 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b12 = DataCanbus.DATA[174];
                    d0_b13 = DataCanbus.DATA[175];
                    d0_b33 = DataCanbus.DATA[176];
                    d1_b24 = DataCanbus.DATA[177];
                    d1_b25 = DataCanbus.DATA[178];
                    d1_b26 = DataCanbus.DATA[179];
                    d1_b27 = DataCanbus.DATA[180];
                    d1_b28 = DataCanbus.DATA[181];
                    d1_b29 = DataCanbus.DATA[182];
                    d1_b30 = DataCanbus.DATA[183];
                    d1_b31 = DataCanbus.DATA[184];
                    d2_b3 = DataCanbus.DATA[185];
                    d3_b73 = DataCanbus.DATA[186];
                    d4_b73 = DataCanbus.DATA[187];
                    d5_b73 = DataCanbus.DATA[188];
                }
                if (d3_b73 < 255) {
                    d3_b73++;
                }
                setCarInfo((d0_b33 & 15) | ((d0_b12 << 7) & 128) | ((d0_b13 << 6) & 64), (d1_b31 & 1) | ((d1_b24 << 7) & 128) | ((d1_b25 << 6) & 64) | ((d1_b26 << 5) & 32) | ((d1_b27 << 4) & 16) | ((d1_b28 << 3) & 8) | ((d1_b29 << 2) & 4) | ((d1_b30 << 1) & 2), d2_b3 & 1, d3_b73, d4_b73, d5_b73);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int d0_b14 = DataCanbus.DATA[35];
                int d0_b15 = DataCanbus.DATA[36];
                int d0_b34 = DataCanbus.DATA[37];
                int d1_b32 = DataCanbus.DATA[38];
                int d1_b33 = DataCanbus.DATA[39];
                int d1_b34 = DataCanbus.DATA[40];
                int d1_b35 = DataCanbus.DATA[41];
                int d1_b36 = DataCanbus.DATA[42];
                int d1_b37 = DataCanbus.DATA[43];
                int d1_b38 = DataCanbus.DATA[44];
                int d1_b39 = DataCanbus.DATA[45];
                int d2_b4 = DataCanbus.DATA[46];
                int d3_b74 = DataCanbus.DATA[47];
                int d4_b74 = DataCanbus.DATA[48];
                int d5_b74 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b14 = DataCanbus.DATA[163];
                    d0_b15 = DataCanbus.DATA[164];
                    d0_b34 = DataCanbus.DATA[165];
                    d1_b32 = DataCanbus.DATA[166];
                    d1_b33 = DataCanbus.DATA[167];
                    d1_b34 = DataCanbus.DATA[168];
                    d1_b35 = DataCanbus.DATA[169];
                    d1_b36 = DataCanbus.DATA[170];
                    d1_b37 = DataCanbus.DATA[171];
                    d1_b38 = DataCanbus.DATA[172];
                    d1_b39 = DataCanbus.DATA[173];
                    d2_b4 = DataCanbus.DATA[174];
                    d3_b74 = DataCanbus.DATA[175];
                    d4_b74 = DataCanbus.DATA[176];
                    d5_b74 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b14 = DataCanbus.DATA[174];
                    d0_b15 = DataCanbus.DATA[175];
                    d0_b34 = DataCanbus.DATA[176];
                    d1_b32 = DataCanbus.DATA[177];
                    d1_b33 = DataCanbus.DATA[178];
                    d1_b34 = DataCanbus.DATA[179];
                    d1_b35 = DataCanbus.DATA[180];
                    d1_b36 = DataCanbus.DATA[181];
                    d1_b37 = DataCanbus.DATA[182];
                    d1_b38 = DataCanbus.DATA[183];
                    d1_b39 = DataCanbus.DATA[184];
                    d2_b4 = DataCanbus.DATA[185];
                    d3_b74 = DataCanbus.DATA[186];
                    d4_b74 = DataCanbus.DATA[187];
                    d5_b74 = DataCanbus.DATA[188];
                }
                if (d4_b74 > 0) {
                    d4_b74--;
                }
                setCarInfo((d0_b34 & 15) | ((d0_b14 << 7) & 128) | ((d0_b15 << 6) & 64), (d1_b39 & 1) | ((d1_b32 << 7) & 128) | ((d1_b33 << 6) & 64) | ((d1_b34 << 5) & 32) | ((d1_b35 << 4) & 16) | ((d1_b36 << 3) & 8) | ((d1_b37 << 2) & 4) | ((d1_b38 << 1) & 2), d2_b4 & 1, d3_b74, d4_b74, d5_b74);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int d0_b16 = DataCanbus.DATA[35];
                int d0_b17 = DataCanbus.DATA[36];
                int d0_b35 = DataCanbus.DATA[37];
                int d1_b40 = DataCanbus.DATA[38];
                int d1_b41 = DataCanbus.DATA[39];
                int d1_b42 = DataCanbus.DATA[40];
                int d1_b43 = DataCanbus.DATA[41];
                int d1_b44 = DataCanbus.DATA[42];
                int d1_b45 = DataCanbus.DATA[43];
                int d1_b46 = DataCanbus.DATA[44];
                int d1_b47 = DataCanbus.DATA[45];
                int d2_b5 = DataCanbus.DATA[46];
                int d3_b75 = DataCanbus.DATA[47];
                int d4_b75 = DataCanbus.DATA[48];
                int d5_b75 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b16 = DataCanbus.DATA[163];
                    d0_b17 = DataCanbus.DATA[164];
                    d0_b35 = DataCanbus.DATA[165];
                    d1_b40 = DataCanbus.DATA[166];
                    d1_b41 = DataCanbus.DATA[167];
                    d1_b42 = DataCanbus.DATA[168];
                    d1_b43 = DataCanbus.DATA[169];
                    d1_b44 = DataCanbus.DATA[170];
                    d1_b45 = DataCanbus.DATA[171];
                    d1_b46 = DataCanbus.DATA[172];
                    d1_b47 = DataCanbus.DATA[173];
                    d2_b5 = DataCanbus.DATA[174];
                    d3_b75 = DataCanbus.DATA[175];
                    d4_b75 = DataCanbus.DATA[176];
                    d5_b75 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b16 = DataCanbus.DATA[174];
                    d0_b17 = DataCanbus.DATA[175];
                    d0_b35 = DataCanbus.DATA[176];
                    d1_b40 = DataCanbus.DATA[177];
                    d1_b41 = DataCanbus.DATA[178];
                    d1_b42 = DataCanbus.DATA[179];
                    d1_b43 = DataCanbus.DATA[180];
                    d1_b44 = DataCanbus.DATA[181];
                    d1_b45 = DataCanbus.DATA[182];
                    d1_b46 = DataCanbus.DATA[183];
                    d1_b47 = DataCanbus.DATA[184];
                    d2_b5 = DataCanbus.DATA[185];
                    d3_b75 = DataCanbus.DATA[186];
                    d4_b75 = DataCanbus.DATA[187];
                    d5_b75 = DataCanbus.DATA[188];
                }
                if (d4_b75 < 255) {
                    d4_b75++;
                }
                setCarInfo((d0_b35 & 15) | ((d0_b16 << 7) & 128) | ((d0_b17 << 6) & 64), (d1_b47 & 1) | ((d1_b40 << 7) & 128) | ((d1_b41 << 6) & 64) | ((d1_b42 << 5) & 32) | ((d1_b43 << 4) & 16) | ((d1_b44 << 3) & 8) | ((d1_b45 << 2) & 4) | ((d1_b46 << 1) & 2), d2_b5 & 1, d3_b75, d4_b75, d5_b75);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int d0_b18 = DataCanbus.DATA[35];
                int d0_b19 = DataCanbus.DATA[36];
                int d0_b36 = DataCanbus.DATA[37];
                int d1_b48 = DataCanbus.DATA[38];
                int d1_b49 = DataCanbus.DATA[39];
                int d1_b50 = DataCanbus.DATA[40];
                int d1_b51 = DataCanbus.DATA[41];
                int d1_b52 = DataCanbus.DATA[42];
                int d1_b53 = DataCanbus.DATA[43];
                int d1_b54 = DataCanbus.DATA[44];
                int d1_b55 = DataCanbus.DATA[45];
                int d2_b6 = DataCanbus.DATA[46];
                int d3_b76 = DataCanbus.DATA[47];
                int d4_b76 = DataCanbus.DATA[48];
                int d5_b76 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b18 = DataCanbus.DATA[163];
                    d0_b19 = DataCanbus.DATA[164];
                    d0_b36 = DataCanbus.DATA[165];
                    d1_b48 = DataCanbus.DATA[166];
                    d1_b49 = DataCanbus.DATA[167];
                    d1_b50 = DataCanbus.DATA[168];
                    d1_b51 = DataCanbus.DATA[169];
                    d1_b52 = DataCanbus.DATA[170];
                    d1_b53 = DataCanbus.DATA[171];
                    d1_b54 = DataCanbus.DATA[172];
                    d1_b55 = DataCanbus.DATA[173];
                    d2_b6 = DataCanbus.DATA[174];
                    d3_b76 = DataCanbus.DATA[175];
                    d4_b76 = DataCanbus.DATA[176];
                    d5_b76 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b18 = DataCanbus.DATA[174];
                    d0_b19 = DataCanbus.DATA[175];
                    d0_b36 = DataCanbus.DATA[176];
                    d1_b48 = DataCanbus.DATA[177];
                    d1_b49 = DataCanbus.DATA[178];
                    d1_b50 = DataCanbus.DATA[179];
                    d1_b51 = DataCanbus.DATA[180];
                    d1_b52 = DataCanbus.DATA[181];
                    d1_b53 = DataCanbus.DATA[182];
                    d1_b54 = DataCanbus.DATA[183];
                    d1_b55 = DataCanbus.DATA[184];
                    d2_b6 = DataCanbus.DATA[185];
                    d3_b76 = DataCanbus.DATA[186];
                    d4_b76 = DataCanbus.DATA[187];
                    d5_b76 = DataCanbus.DATA[188];
                }
                if (d5_b76 > 0) {
                    d5_b76--;
                }
                setCarInfo((d0_b36 & 15) | ((d0_b18 << 7) & 128) | ((d0_b19 << 6) & 64), (d1_b55 & 1) | ((d1_b48 << 7) & 128) | ((d1_b49 << 6) & 64) | ((d1_b50 << 5) & 32) | ((d1_b51 << 4) & 16) | ((d1_b52 << 3) & 8) | ((d1_b53 << 2) & 4) | ((d1_b54 << 1) & 2), d2_b6 & 1, d3_b76, d4_b76, d5_b76);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int d0_b20 = DataCanbus.DATA[35];
                int d0_b21 = DataCanbus.DATA[36];
                int d0_b37 = DataCanbus.DATA[37];
                int d1_b56 = DataCanbus.DATA[38];
                int d1_b57 = DataCanbus.DATA[39];
                int d1_b58 = DataCanbus.DATA[40];
                int d1_b59 = DataCanbus.DATA[41];
                int d1_b60 = DataCanbus.DATA[42];
                int d1_b61 = DataCanbus.DATA[43];
                int d1_b62 = DataCanbus.DATA[44];
                int d1_b63 = DataCanbus.DATA[45];
                int d2_b7 = DataCanbus.DATA[46];
                int d3_b77 = DataCanbus.DATA[47];
                int d4_b77 = DataCanbus.DATA[48];
                int d5_b77 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b20 = DataCanbus.DATA[163];
                    d0_b21 = DataCanbus.DATA[164];
                    d0_b37 = DataCanbus.DATA[165];
                    d1_b56 = DataCanbus.DATA[166];
                    d1_b57 = DataCanbus.DATA[167];
                    d1_b58 = DataCanbus.DATA[168];
                    d1_b59 = DataCanbus.DATA[169];
                    d1_b60 = DataCanbus.DATA[170];
                    d1_b61 = DataCanbus.DATA[171];
                    d1_b62 = DataCanbus.DATA[172];
                    d1_b63 = DataCanbus.DATA[173];
                    d2_b7 = DataCanbus.DATA[174];
                    d3_b77 = DataCanbus.DATA[175];
                    d4_b77 = DataCanbus.DATA[176];
                    d5_b77 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b20 = DataCanbus.DATA[174];
                    d0_b21 = DataCanbus.DATA[175];
                    d0_b37 = DataCanbus.DATA[176];
                    d1_b56 = DataCanbus.DATA[177];
                    d1_b57 = DataCanbus.DATA[178];
                    d1_b58 = DataCanbus.DATA[179];
                    d1_b59 = DataCanbus.DATA[180];
                    d1_b60 = DataCanbus.DATA[181];
                    d1_b61 = DataCanbus.DATA[182];
                    d1_b62 = DataCanbus.DATA[183];
                    d1_b63 = DataCanbus.DATA[184];
                    d2_b7 = DataCanbus.DATA[185];
                    d3_b77 = DataCanbus.DATA[186];
                    d4_b77 = DataCanbus.DATA[187];
                    d5_b77 = DataCanbus.DATA[188];
                }
                if (d5_b77 < 255) {
                    d5_b77++;
                }
                setCarInfo((d0_b37 & 15) | ((d0_b20 << 7) & 128) | ((d0_b21 << 6) & 64), (d1_b63 & 1) | ((d1_b56 << 7) & 128) | ((d1_b57 << 6) & 64) | ((d1_b58 << 5) & 32) | ((d1_b59 << 4) & 16) | ((d1_b60 << 3) & 8) | ((d1_b61 << 2) & 4) | ((d1_b62 << 1) & 2), d2_b7 & 1, d3_b77, d4_b77, d5_b77);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int d0_b22 = DataCanbus.DATA[35];
                int d0_b23 = DataCanbus.DATA[36];
                int d0_b38 = DataCanbus.DATA[37];
                int d1_b64 = DataCanbus.DATA[38];
                int d1_b65 = DataCanbus.DATA[39];
                int d1_b66 = DataCanbus.DATA[40];
                int d1_b67 = DataCanbus.DATA[41];
                int d1_b68 = DataCanbus.DATA[42];
                int d1_b69 = DataCanbus.DATA[43];
                int d1_b70 = DataCanbus.DATA[44];
                int d1_b71 = DataCanbus.DATA[45];
                int d2_b8 = DataCanbus.DATA[46];
                int d3_b78 = DataCanbus.DATA[47];
                int d4_b78 = DataCanbus.DATA[48];
                int d5_b78 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b22 = DataCanbus.DATA[163];
                    d0_b23 = DataCanbus.DATA[164];
                    d0_b38 = DataCanbus.DATA[165];
                    d1_b64 = DataCanbus.DATA[166];
                    d1_b65 = DataCanbus.DATA[167];
                    d1_b66 = DataCanbus.DATA[168];
                    d1_b67 = DataCanbus.DATA[169];
                    d1_b68 = DataCanbus.DATA[170];
                    d1_b69 = DataCanbus.DATA[171];
                    d1_b70 = DataCanbus.DATA[172];
                    d1_b71 = DataCanbus.DATA[173];
                    d2_b8 = DataCanbus.DATA[174];
                    d3_b78 = DataCanbus.DATA[175];
                    d4_b78 = DataCanbus.DATA[176];
                    d5_b78 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b22 = DataCanbus.DATA[174];
                    d0_b23 = DataCanbus.DATA[175];
                    d0_b38 = DataCanbus.DATA[176];
                    d1_b64 = DataCanbus.DATA[177];
                    d1_b65 = DataCanbus.DATA[178];
                    d1_b66 = DataCanbus.DATA[179];
                    d1_b67 = DataCanbus.DATA[180];
                    d1_b68 = DataCanbus.DATA[181];
                    d1_b69 = DataCanbus.DATA[182];
                    d1_b70 = DataCanbus.DATA[183];
                    d1_b71 = DataCanbus.DATA[184];
                    d2_b8 = DataCanbus.DATA[185];
                    d3_b78 = DataCanbus.DATA[186];
                    d4_b78 = DataCanbus.DATA[187];
                    d5_b78 = DataCanbus.DATA[188];
                }
                if (d0_b22 == 1) {
                    d0_b22 = 0;
                } else if (d0_b22 == 0) {
                    d0_b22 = 1;
                }
                setCarInfo((d0_b38 & 15) | ((d0_b22 << 7) & 128) | ((d0_b23 << 6) & 64), (d1_b71 & 1) | ((d1_b64 << 7) & 128) | ((d1_b65 << 6) & 64) | ((d1_b66 << 5) & 32) | ((d1_b67 << 4) & 16) | ((d1_b68 << 3) & 8) | ((d1_b69 << 2) & 4) | ((d1_b70 << 1) & 2), d2_b8 & 1, d3_b78, d4_b78, d5_b78);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int d0_b24 = DataCanbus.DATA[35];
                int d0_b25 = DataCanbus.DATA[36];
                int d0_b39 = DataCanbus.DATA[37];
                int d1_b72 = DataCanbus.DATA[38];
                int d1_b73 = DataCanbus.DATA[39];
                int d1_b74 = DataCanbus.DATA[40];
                int d1_b75 = DataCanbus.DATA[41];
                int d1_b76 = DataCanbus.DATA[42];
                int d1_b77 = DataCanbus.DATA[43];
                int d1_b78 = DataCanbus.DATA[44];
                int d1_b79 = DataCanbus.DATA[45];
                int d2_b9 = DataCanbus.DATA[46];
                int d3_b79 = DataCanbus.DATA[47];
                int d4_b79 = DataCanbus.DATA[48];
                int d5_b79 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b24 = DataCanbus.DATA[163];
                    d0_b25 = DataCanbus.DATA[164];
                    d0_b39 = DataCanbus.DATA[165];
                    d1_b72 = DataCanbus.DATA[166];
                    d1_b73 = DataCanbus.DATA[167];
                    d1_b74 = DataCanbus.DATA[168];
                    d1_b75 = DataCanbus.DATA[169];
                    d1_b76 = DataCanbus.DATA[170];
                    d1_b77 = DataCanbus.DATA[171];
                    d1_b78 = DataCanbus.DATA[172];
                    d1_b79 = DataCanbus.DATA[173];
                    d2_b9 = DataCanbus.DATA[174];
                    d3_b79 = DataCanbus.DATA[175];
                    d4_b79 = DataCanbus.DATA[176];
                    d5_b79 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b24 = DataCanbus.DATA[174];
                    d0_b25 = DataCanbus.DATA[175];
                    d0_b39 = DataCanbus.DATA[176];
                    d1_b72 = DataCanbus.DATA[177];
                    d1_b73 = DataCanbus.DATA[178];
                    d1_b74 = DataCanbus.DATA[179];
                    d1_b75 = DataCanbus.DATA[180];
                    d1_b76 = DataCanbus.DATA[181];
                    d1_b77 = DataCanbus.DATA[182];
                    d1_b78 = DataCanbus.DATA[183];
                    d1_b79 = DataCanbus.DATA[184];
                    d2_b9 = DataCanbus.DATA[185];
                    d3_b79 = DataCanbus.DATA[186];
                    d4_b79 = DataCanbus.DATA[187];
                    d5_b79 = DataCanbus.DATA[188];
                }
                if (d1_b73 == 1) {
                    d1_b73 = 0;
                } else if (d1_b73 == 0) {
                    d1_b73 = 1;
                }
                setCarInfo((d0_b39 & 15) | ((d0_b24 << 7) & 128) | ((d0_b25 << 6) & 64), (d1_b79 & 1) | ((d1_b72 << 7) & 128) | ((d1_b73 << 6) & 64) | ((d1_b74 << 5) & 32) | ((d1_b75 << 4) & 16) | ((d1_b76 << 3) & 8) | ((d1_b77 << 2) & 4) | ((d1_b78 << 1) & 2), d2_b9 & 1, d3_b79, d4_b79, d5_b79);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int d0_b26 = DataCanbus.DATA[35];
                int d0_b27 = DataCanbus.DATA[36];
                int d0_b310 = DataCanbus.DATA[37];
                int d1_b80 = DataCanbus.DATA[38];
                int d1_b81 = DataCanbus.DATA[39];
                int d1_b82 = DataCanbus.DATA[40];
                int d1_b83 = DataCanbus.DATA[41];
                int d1_b84 = DataCanbus.DATA[42];
                int d1_b85 = DataCanbus.DATA[43];
                int d1_b86 = DataCanbus.DATA[44];
                int d1_b87 = DataCanbus.DATA[45];
                int d2_b10 = DataCanbus.DATA[46];
                int d3_b710 = DataCanbus.DATA[47];
                int d4_b710 = DataCanbus.DATA[48];
                int d5_b710 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b26 = DataCanbus.DATA[163];
                    d0_b27 = DataCanbus.DATA[164];
                    d0_b310 = DataCanbus.DATA[165];
                    d1_b80 = DataCanbus.DATA[166];
                    d1_b81 = DataCanbus.DATA[167];
                    d1_b82 = DataCanbus.DATA[168];
                    d1_b83 = DataCanbus.DATA[169];
                    d1_b84 = DataCanbus.DATA[170];
                    d1_b85 = DataCanbus.DATA[171];
                    d1_b86 = DataCanbus.DATA[172];
                    d1_b87 = DataCanbus.DATA[173];
                    d2_b10 = DataCanbus.DATA[174];
                    d3_b710 = DataCanbus.DATA[175];
                    d4_b710 = DataCanbus.DATA[176];
                    d5_b710 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b26 = DataCanbus.DATA[174];
                    d0_b27 = DataCanbus.DATA[175];
                    d0_b310 = DataCanbus.DATA[176];
                    d1_b80 = DataCanbus.DATA[177];
                    d1_b81 = DataCanbus.DATA[178];
                    d1_b82 = DataCanbus.DATA[179];
                    d1_b83 = DataCanbus.DATA[180];
                    d1_b84 = DataCanbus.DATA[181];
                    d1_b85 = DataCanbus.DATA[182];
                    d1_b86 = DataCanbus.DATA[183];
                    d1_b87 = DataCanbus.DATA[184];
                    d2_b10 = DataCanbus.DATA[185];
                    d3_b710 = DataCanbus.DATA[186];
                    d4_b710 = DataCanbus.DATA[187];
                    d5_b710 = DataCanbus.DATA[188];
                }
                if (d1_b82 == 1) {
                    d1_b82 = 0;
                } else if (d1_b82 == 0) {
                    d1_b82 = 1;
                }
                setCarInfo((d0_b310 & 15) | ((d0_b26 << 7) & 128) | ((d0_b27 << 6) & 64), (d1_b87 & 1) | ((d1_b80 << 7) & 128) | ((d1_b81 << 6) & 64) | ((d1_b82 << 5) & 32) | ((d1_b83 << 4) & 16) | ((d1_b84 << 3) & 8) | ((d1_b85 << 2) & 4) | ((d1_b86 << 1) & 2), d2_b10 & 1, d3_b710, d4_b710, d5_b710);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int d0_b28 = DataCanbus.DATA[35];
                int d0_b29 = DataCanbus.DATA[36];
                int d0_b311 = DataCanbus.DATA[37];
                int d1_b88 = DataCanbus.DATA[38];
                int d1_b89 = DataCanbus.DATA[39];
                int d1_b90 = DataCanbus.DATA[40];
                int d1_b91 = DataCanbus.DATA[41];
                int d1_b92 = DataCanbus.DATA[42];
                int d1_b93 = DataCanbus.DATA[43];
                int d1_b94 = DataCanbus.DATA[44];
                int d1_b95 = DataCanbus.DATA[45];
                int d2_b11 = DataCanbus.DATA[46];
                int d3_b711 = DataCanbus.DATA[47];
                int d4_b711 = DataCanbus.DATA[48];
                int d5_b711 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b28 = DataCanbus.DATA[163];
                    d0_b29 = DataCanbus.DATA[164];
                    d0_b311 = DataCanbus.DATA[165];
                    d1_b88 = DataCanbus.DATA[166];
                    d1_b89 = DataCanbus.DATA[167];
                    d1_b90 = DataCanbus.DATA[168];
                    d1_b91 = DataCanbus.DATA[169];
                    d1_b92 = DataCanbus.DATA[170];
                    d1_b93 = DataCanbus.DATA[171];
                    d1_b94 = DataCanbus.DATA[172];
                    d1_b95 = DataCanbus.DATA[173];
                    d2_b11 = DataCanbus.DATA[174];
                    d3_b711 = DataCanbus.DATA[175];
                    d4_b711 = DataCanbus.DATA[176];
                    d5_b711 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b28 = DataCanbus.DATA[174];
                    d0_b29 = DataCanbus.DATA[175];
                    d0_b311 = DataCanbus.DATA[176];
                    d1_b88 = DataCanbus.DATA[177];
                    d1_b89 = DataCanbus.DATA[178];
                    d1_b90 = DataCanbus.DATA[179];
                    d1_b91 = DataCanbus.DATA[180];
                    d1_b92 = DataCanbus.DATA[181];
                    d1_b93 = DataCanbus.DATA[182];
                    d1_b94 = DataCanbus.DATA[183];
                    d1_b95 = DataCanbus.DATA[184];
                    d2_b11 = DataCanbus.DATA[185];
                    d3_b711 = DataCanbus.DATA[186];
                    d4_b711 = DataCanbus.DATA[187];
                    d5_b711 = DataCanbus.DATA[188];
                }
                if (d0_b29 == 1) {
                    d0_b29 = 0;
                } else if (d0_b29 == 0) {
                    d0_b29 = 1;
                }
                setCarInfo((d0_b311 & 15) | ((d0_b28 << 7) & 128) | ((d0_b29 << 6) & 64), (d1_b95 & 1) | ((d1_b88 << 7) & 128) | ((d1_b89 << 6) & 64) | ((d1_b90 << 5) & 32) | ((d1_b91 << 4) & 16) | ((d1_b92 << 3) & 8) | ((d1_b93 << 2) & 4) | ((d1_b94 << 1) & 2), d2_b11 & 1, d3_b711, d4_b711, d5_b711);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int d0_b40 = DataCanbus.DATA[35];
                int d0_b41 = DataCanbus.DATA[36];
                int d0_b312 = DataCanbus.DATA[37];
                int d1_b96 = DataCanbus.DATA[38];
                int d1_b97 = DataCanbus.DATA[39];
                int d1_b98 = DataCanbus.DATA[40];
                int d1_b99 = DataCanbus.DATA[41];
                int d1_b100 = DataCanbus.DATA[42];
                int d1_b101 = DataCanbus.DATA[43];
                int d1_b102 = DataCanbus.DATA[44];
                int d1_b103 = DataCanbus.DATA[45];
                int d2_b12 = DataCanbus.DATA[46];
                int d3_b712 = DataCanbus.DATA[47];
                int d4_b712 = DataCanbus.DATA[48];
                int d5_b712 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b40 = DataCanbus.DATA[163];
                    d0_b41 = DataCanbus.DATA[164];
                    d0_b312 = DataCanbus.DATA[165];
                    d1_b96 = DataCanbus.DATA[166];
                    d1_b97 = DataCanbus.DATA[167];
                    d1_b98 = DataCanbus.DATA[168];
                    d1_b99 = DataCanbus.DATA[169];
                    d1_b100 = DataCanbus.DATA[170];
                    d1_b101 = DataCanbus.DATA[171];
                    d1_b102 = DataCanbus.DATA[172];
                    d1_b103 = DataCanbus.DATA[173];
                    d2_b12 = DataCanbus.DATA[174];
                    d3_b712 = DataCanbus.DATA[175];
                    d4_b712 = DataCanbus.DATA[176];
                    d5_b712 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b40 = DataCanbus.DATA[174];
                    d0_b41 = DataCanbus.DATA[175];
                    d0_b312 = DataCanbus.DATA[176];
                    d1_b96 = DataCanbus.DATA[177];
                    d1_b97 = DataCanbus.DATA[178];
                    d1_b98 = DataCanbus.DATA[179];
                    d1_b99 = DataCanbus.DATA[180];
                    d1_b100 = DataCanbus.DATA[181];
                    d1_b101 = DataCanbus.DATA[182];
                    d1_b102 = DataCanbus.DATA[183];
                    d1_b103 = DataCanbus.DATA[184];
                    d2_b12 = DataCanbus.DATA[185];
                    d3_b712 = DataCanbus.DATA[186];
                    d4_b712 = DataCanbus.DATA[187];
                    d5_b712 = DataCanbus.DATA[188];
                }
                if (d1_b96 == 1) {
                    d1_b96 = 0;
                } else if (d1_b96 == 0) {
                    d1_b96 = 1;
                }
                setCarInfo((d0_b312 & 15) | ((d0_b40 << 7) & 128) | ((d0_b41 << 6) & 64), (d1_b103 & 1) | ((d1_b96 << 7) & 128) | ((d1_b97 << 6) & 64) | ((d1_b98 << 5) & 32) | ((d1_b99 << 4) & 16) | ((d1_b100 << 3) & 8) | ((d1_b101 << 2) & 4) | ((d1_b102 << 1) & 2), d2_b12 & 1, d3_b712, d4_b712, d5_b712);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int d0_b42 = DataCanbus.DATA[35];
                int d0_b43 = DataCanbus.DATA[36];
                int d0_b313 = DataCanbus.DATA[37];
                int d1_b104 = DataCanbus.DATA[38];
                int d1_b105 = DataCanbus.DATA[39];
                int d1_b106 = DataCanbus.DATA[40];
                int d1_b107 = DataCanbus.DATA[41];
                int d1_b108 = DataCanbus.DATA[42];
                int d1_b109 = DataCanbus.DATA[43];
                int d1_b110 = DataCanbus.DATA[44];
                int d1_b111 = DataCanbus.DATA[45];
                int d2_b13 = DataCanbus.DATA[46];
                int d3_b713 = DataCanbus.DATA[47];
                int d4_b713 = DataCanbus.DATA[48];
                int d5_b713 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b42 = DataCanbus.DATA[163];
                    d0_b43 = DataCanbus.DATA[164];
                    d0_b313 = DataCanbus.DATA[165];
                    d1_b104 = DataCanbus.DATA[166];
                    d1_b105 = DataCanbus.DATA[167];
                    d1_b106 = DataCanbus.DATA[168];
                    d1_b107 = DataCanbus.DATA[169];
                    d1_b108 = DataCanbus.DATA[170];
                    d1_b109 = DataCanbus.DATA[171];
                    d1_b110 = DataCanbus.DATA[172];
                    d1_b111 = DataCanbus.DATA[173];
                    d2_b13 = DataCanbus.DATA[174];
                    d3_b713 = DataCanbus.DATA[175];
                    d4_b713 = DataCanbus.DATA[176];
                    d5_b713 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b42 = DataCanbus.DATA[174];
                    d0_b43 = DataCanbus.DATA[175];
                    d0_b313 = DataCanbus.DATA[176];
                    d1_b104 = DataCanbus.DATA[177];
                    d1_b105 = DataCanbus.DATA[178];
                    d1_b106 = DataCanbus.DATA[179];
                    d1_b107 = DataCanbus.DATA[180];
                    d1_b108 = DataCanbus.DATA[181];
                    d1_b109 = DataCanbus.DATA[182];
                    d1_b110 = DataCanbus.DATA[183];
                    d1_b111 = DataCanbus.DATA[184];
                    d2_b13 = DataCanbus.DATA[185];
                    d3_b713 = DataCanbus.DATA[186];
                    d4_b713 = DataCanbus.DATA[187];
                    d5_b713 = DataCanbus.DATA[188];
                }
                if (d1_b107 == 1) {
                    d1_b107 = 0;
                } else if (d1_b107 == 0) {
                    d1_b107 = 1;
                }
                setCarInfo((d0_b313 & 15) | ((d0_b42 << 7) & 128) | ((d0_b43 << 6) & 64), (d1_b111 & 1) | ((d1_b104 << 7) & 128) | ((d1_b105 << 6) & 64) | ((d1_b106 << 5) & 32) | ((d1_b107 << 4) & 16) | ((d1_b108 << 3) & 8) | ((d1_b109 << 2) & 4) | ((d1_b110 << 1) & 2), d2_b13 & 1, d3_b713, d4_b713, d5_b713);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int d0_b44 = DataCanbus.DATA[35];
                int d0_b45 = DataCanbus.DATA[36];
                int d0_b314 = DataCanbus.DATA[37];
                int d1_b112 = DataCanbus.DATA[38];
                int d1_b113 = DataCanbus.DATA[39];
                int d1_b114 = DataCanbus.DATA[40];
                int d1_b115 = DataCanbus.DATA[41];
                int d1_b116 = DataCanbus.DATA[42];
                int d1_b117 = DataCanbus.DATA[43];
                int d1_b118 = DataCanbus.DATA[44];
                int d1_b119 = DataCanbus.DATA[45];
                int d2_b14 = DataCanbus.DATA[46];
                int d3_b714 = DataCanbus.DATA[47];
                int d4_b714 = DataCanbus.DATA[48];
                int d5_b714 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b44 = DataCanbus.DATA[163];
                    d0_b45 = DataCanbus.DATA[164];
                    d0_b314 = DataCanbus.DATA[165];
                    d1_b112 = DataCanbus.DATA[166];
                    d1_b113 = DataCanbus.DATA[167];
                    d1_b114 = DataCanbus.DATA[168];
                    d1_b115 = DataCanbus.DATA[169];
                    d1_b116 = DataCanbus.DATA[170];
                    d1_b117 = DataCanbus.DATA[171];
                    d1_b118 = DataCanbus.DATA[172];
                    d1_b119 = DataCanbus.DATA[173];
                    d2_b14 = DataCanbus.DATA[174];
                    d3_b714 = DataCanbus.DATA[175];
                    d4_b714 = DataCanbus.DATA[176];
                    d5_b714 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b44 = DataCanbus.DATA[174];
                    d0_b45 = DataCanbus.DATA[175];
                    d0_b314 = DataCanbus.DATA[176];
                    d1_b112 = DataCanbus.DATA[177];
                    d1_b113 = DataCanbus.DATA[178];
                    d1_b114 = DataCanbus.DATA[179];
                    d1_b115 = DataCanbus.DATA[180];
                    d1_b116 = DataCanbus.DATA[181];
                    d1_b117 = DataCanbus.DATA[182];
                    d1_b118 = DataCanbus.DATA[183];
                    d1_b119 = DataCanbus.DATA[184];
                    d2_b14 = DataCanbus.DATA[185];
                    d3_b714 = DataCanbus.DATA[186];
                    d4_b714 = DataCanbus.DATA[187];
                    d5_b714 = DataCanbus.DATA[188];
                }
                if (d1_b116 == 1) {
                    d1_b116 = 0;
                } else if (d1_b116 == 0) {
                    d1_b116 = 1;
                }
                setCarInfo((d0_b314 & 15) | ((d0_b44 << 7) & 128) | ((d0_b45 << 6) & 64), (d1_b119 & 1) | ((d1_b112 << 7) & 128) | ((d1_b113 << 6) & 64) | ((d1_b114 << 5) & 32) | ((d1_b115 << 4) & 16) | ((d1_b116 << 3) & 8) | ((d1_b117 << 2) & 4) | ((d1_b118 << 1) & 2), d2_b14 & 1, d3_b714, d4_b714, d5_b714);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int d0_b46 = DataCanbus.DATA[35];
                int d0_b47 = DataCanbus.DATA[36];
                int d0_b315 = DataCanbus.DATA[37];
                int d1_b120 = DataCanbus.DATA[38];
                int d1_b121 = DataCanbus.DATA[39];
                int d1_b122 = DataCanbus.DATA[40];
                int d1_b123 = DataCanbus.DATA[41];
                int d1_b124 = DataCanbus.DATA[42];
                int d1_b125 = DataCanbus.DATA[43];
                int d1_b126 = DataCanbus.DATA[44];
                int d1_b127 = DataCanbus.DATA[45];
                int d2_b15 = DataCanbus.DATA[46];
                int d3_b715 = DataCanbus.DATA[47];
                int d4_b715 = DataCanbus.DATA[48];
                int d5_b715 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b46 = DataCanbus.DATA[163];
                    d0_b47 = DataCanbus.DATA[164];
                    d0_b315 = DataCanbus.DATA[165];
                    d1_b120 = DataCanbus.DATA[166];
                    d1_b121 = DataCanbus.DATA[167];
                    d1_b122 = DataCanbus.DATA[168];
                    d1_b123 = DataCanbus.DATA[169];
                    d1_b124 = DataCanbus.DATA[170];
                    d1_b125 = DataCanbus.DATA[171];
                    d1_b126 = DataCanbus.DATA[172];
                    d1_b127 = DataCanbus.DATA[173];
                    d2_b15 = DataCanbus.DATA[174];
                    d3_b715 = DataCanbus.DATA[175];
                    d4_b715 = DataCanbus.DATA[176];
                    d5_b715 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b46 = DataCanbus.DATA[174];
                    d0_b47 = DataCanbus.DATA[175];
                    d0_b315 = DataCanbus.DATA[176];
                    d1_b120 = DataCanbus.DATA[177];
                    d1_b121 = DataCanbus.DATA[178];
                    d1_b122 = DataCanbus.DATA[179];
                    d1_b123 = DataCanbus.DATA[180];
                    d1_b124 = DataCanbus.DATA[181];
                    d1_b125 = DataCanbus.DATA[182];
                    d1_b126 = DataCanbus.DATA[183];
                    d1_b127 = DataCanbus.DATA[184];
                    d2_b15 = DataCanbus.DATA[185];
                    d3_b715 = DataCanbus.DATA[186];
                    d4_b715 = DataCanbus.DATA[187];
                    d5_b715 = DataCanbus.DATA[188];
                }
                if (d1_b125 == 1) {
                    d1_b125 = 0;
                } else if (d1_b125 == 0) {
                    d1_b125 = 1;
                }
                setCarInfo((d0_b315 & 15) | ((d0_b46 << 7) & 128) | ((d0_b47 << 6) & 64), (d1_b127 & 1) | ((d1_b120 << 7) & 128) | ((d1_b121 << 6) & 64) | ((d1_b122 << 5) & 32) | ((d1_b123 << 4) & 16) | ((d1_b124 << 3) & 8) | ((d1_b125 << 2) & 4) | ((d1_b126 << 1) & 2), d2_b15 & 1, d3_b715, d4_b715, d5_b715);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int d0_b48 = DataCanbus.DATA[35];
                int d0_b49 = DataCanbus.DATA[36];
                int d0_b316 = DataCanbus.DATA[37];
                int d1_b128 = DataCanbus.DATA[38];
                int d1_b129 = DataCanbus.DATA[39];
                int d1_b130 = DataCanbus.DATA[40];
                int d1_b131 = DataCanbus.DATA[41];
                int d1_b132 = DataCanbus.DATA[42];
                int d1_b133 = DataCanbus.DATA[43];
                int d1_b134 = DataCanbus.DATA[44];
                int d1_b135 = DataCanbus.DATA[45];
                int d2_b16 = DataCanbus.DATA[46];
                int d3_b716 = DataCanbus.DATA[47];
                int d4_b716 = DataCanbus.DATA[48];
                int d5_b716 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b48 = DataCanbus.DATA[163];
                    d0_b49 = DataCanbus.DATA[164];
                    d0_b316 = DataCanbus.DATA[165];
                    d1_b128 = DataCanbus.DATA[166];
                    d1_b129 = DataCanbus.DATA[167];
                    d1_b130 = DataCanbus.DATA[168];
                    d1_b131 = DataCanbus.DATA[169];
                    d1_b132 = DataCanbus.DATA[170];
                    d1_b133 = DataCanbus.DATA[171];
                    d1_b134 = DataCanbus.DATA[172];
                    d1_b135 = DataCanbus.DATA[173];
                    d2_b16 = DataCanbus.DATA[174];
                    d3_b716 = DataCanbus.DATA[175];
                    d4_b716 = DataCanbus.DATA[176];
                    d5_b716 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b48 = DataCanbus.DATA[174];
                    d0_b49 = DataCanbus.DATA[175];
                    d0_b316 = DataCanbus.DATA[176];
                    d1_b128 = DataCanbus.DATA[177];
                    d1_b129 = DataCanbus.DATA[178];
                    d1_b130 = DataCanbus.DATA[179];
                    d1_b131 = DataCanbus.DATA[180];
                    d1_b132 = DataCanbus.DATA[181];
                    d1_b133 = DataCanbus.DATA[182];
                    d1_b134 = DataCanbus.DATA[183];
                    d1_b135 = DataCanbus.DATA[184];
                    d2_b16 = DataCanbus.DATA[185];
                    d3_b716 = DataCanbus.DATA[186];
                    d4_b716 = DataCanbus.DATA[187];
                    d5_b716 = DataCanbus.DATA[188];
                }
                if (d1_b134 == 1) {
                    d1_b134 = 0;
                } else if (d1_b134 == 0) {
                    d1_b134 = 1;
                }
                setCarInfo((d0_b316 & 15) | ((d0_b48 << 7) & 128) | ((d0_b49 << 6) & 64), (d1_b135 & 1) | ((d1_b128 << 7) & 128) | ((d1_b129 << 6) & 64) | ((d1_b130 << 5) & 32) | ((d1_b131 << 4) & 16) | ((d1_b132 << 3) & 8) | ((d1_b133 << 2) & 4) | ((d1_b134 << 1) & 2), d2_b16 & 1, d3_b716, d4_b716, d5_b716);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int d0_b50 = DataCanbus.DATA[35];
                int d0_b51 = DataCanbus.DATA[36];
                int d0_b317 = DataCanbus.DATA[37];
                int d1_b136 = DataCanbus.DATA[38];
                int d1_b137 = DataCanbus.DATA[39];
                int d1_b138 = DataCanbus.DATA[40];
                int d1_b139 = DataCanbus.DATA[41];
                int d1_b140 = DataCanbus.DATA[42];
                int d1_b141 = DataCanbus.DATA[43];
                int d1_b142 = DataCanbus.DATA[44];
                int d1_b143 = DataCanbus.DATA[45];
                int d2_b17 = DataCanbus.DATA[46];
                int d3_b717 = DataCanbus.DATA[47];
                int d4_b717 = DataCanbus.DATA[48];
                int d5_b717 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b50 = DataCanbus.DATA[163];
                    d0_b51 = DataCanbus.DATA[164];
                    d0_b317 = DataCanbus.DATA[165];
                    d1_b136 = DataCanbus.DATA[166];
                    d1_b137 = DataCanbus.DATA[167];
                    d1_b138 = DataCanbus.DATA[168];
                    d1_b139 = DataCanbus.DATA[169];
                    d1_b140 = DataCanbus.DATA[170];
                    d1_b141 = DataCanbus.DATA[171];
                    d1_b142 = DataCanbus.DATA[172];
                    d1_b143 = DataCanbus.DATA[173];
                    d2_b17 = DataCanbus.DATA[174];
                    d3_b717 = DataCanbus.DATA[175];
                    d4_b717 = DataCanbus.DATA[176];
                    d5_b717 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b50 = DataCanbus.DATA[174];
                    d0_b51 = DataCanbus.DATA[175];
                    d0_b317 = DataCanbus.DATA[176];
                    d1_b136 = DataCanbus.DATA[177];
                    d1_b137 = DataCanbus.DATA[178];
                    d1_b138 = DataCanbus.DATA[179];
                    d1_b139 = DataCanbus.DATA[180];
                    d1_b140 = DataCanbus.DATA[181];
                    d1_b141 = DataCanbus.DATA[182];
                    d1_b142 = DataCanbus.DATA[183];
                    d1_b143 = DataCanbus.DATA[184];
                    d2_b17 = DataCanbus.DATA[185];
                    d3_b717 = DataCanbus.DATA[186];
                    d4_b717 = DataCanbus.DATA[187];
                    d5_b717 = DataCanbus.DATA[188];
                }
                if (d1_b143 == 1) {
                    d1_b143 = 0;
                } else if (d1_b143 == 0) {
                    d1_b143 = 1;
                }
                setCarInfo((d0_b317 & 15) | ((d0_b50 << 7) & 128) | ((d0_b51 << 6) & 64), (d1_b143 & 1) | ((d1_b136 << 7) & 128) | ((d1_b137 << 6) & 64) | ((d1_b138 << 5) & 32) | ((d1_b139 << 4) & 16) | ((d1_b140 << 3) & 8) | ((d1_b141 << 2) & 4) | ((d1_b142 << 1) & 2), d2_b17 & 1, d3_b717, d4_b717, d5_b717);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int d0_b52 = DataCanbus.DATA[35];
                int d0_b53 = DataCanbus.DATA[36];
                int d0_b318 = DataCanbus.DATA[37];
                int d1_b144 = DataCanbus.DATA[38];
                int d1_b145 = DataCanbus.DATA[39];
                int d1_b146 = DataCanbus.DATA[40];
                int d1_b147 = DataCanbus.DATA[41];
                int d1_b148 = DataCanbus.DATA[42];
                int d1_b149 = DataCanbus.DATA[43];
                int d1_b150 = DataCanbus.DATA[44];
                int d1_b151 = DataCanbus.DATA[45];
                int d2_b18 = DataCanbus.DATA[46];
                int d3_b718 = DataCanbus.DATA[47];
                int d4_b718 = DataCanbus.DATA[48];
                int d5_b718 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b52 = DataCanbus.DATA[163];
                    d0_b53 = DataCanbus.DATA[164];
                    d0_b318 = DataCanbus.DATA[165];
                    d1_b144 = DataCanbus.DATA[166];
                    d1_b145 = DataCanbus.DATA[167];
                    d1_b146 = DataCanbus.DATA[168];
                    d1_b147 = DataCanbus.DATA[169];
                    d1_b148 = DataCanbus.DATA[170];
                    d1_b149 = DataCanbus.DATA[171];
                    d1_b150 = DataCanbus.DATA[172];
                    d1_b151 = DataCanbus.DATA[173];
                    d2_b18 = DataCanbus.DATA[174];
                    d3_b718 = DataCanbus.DATA[175];
                    d4_b718 = DataCanbus.DATA[176];
                    d5_b718 = DataCanbus.DATA[177];
                } else if (DataCanbus.DATA[1000] == 9568710) {
                    d0_b52 = DataCanbus.DATA[174];
                    d0_b53 = DataCanbus.DATA[175];
                    d0_b318 = DataCanbus.DATA[176];
                    d1_b144 = DataCanbus.DATA[177];
                    d1_b145 = DataCanbus.DATA[178];
                    d1_b146 = DataCanbus.DATA[179];
                    d1_b147 = DataCanbus.DATA[180];
                    d1_b148 = DataCanbus.DATA[181];
                    d1_b149 = DataCanbus.DATA[182];
                    d1_b150 = DataCanbus.DATA[183];
                    d1_b151 = DataCanbus.DATA[184];
                    d2_b18 = DataCanbus.DATA[185];
                    d3_b718 = DataCanbus.DATA[186];
                    d4_b718 = DataCanbus.DATA[187];
                    d5_b718 = DataCanbus.DATA[188];
                }
                if (d2_b18 == 1) {
                    d2_b18 = 0;
                } else if (d2_b18 == 0) {
                    d2_b18 = 1;
                }
                setCarInfo((d0_b318 & 15) | ((d0_b52 << 7) & 128) | ((d0_b53 << 6) & 64), (d1_b151 & 1) | ((d1_b144 << 7) & 128) | ((d1_b145 << 6) & 64) | ((d1_b146 << 5) & 32) | ((d1_b147 << 4) & 16) | ((d1_b148 << 3) & 8) | ((d1_b149 << 2) & 4) | ((d1_b150 << 1) & 2), d2_b18 & 1, d3_b718, d4_b718, d5_b718);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5, int value6) {
        if (DataCanbus.DATA[1000] == 9568710) {
            DataCanbus.PROXY.cmd(8, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
        } else {
            DataCanbus.PROXY.cmd(3, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 9568710) {
            DataCanbus.PROXY.cmd(1, new int[]{25, 0}, null, null);
        } else {
            DataCanbus.PROXY.cmd(2, new int[]{25}, null, null);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 1507781) {
            DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 9568710) {
            DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
            return;
        }
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
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 1507781) {
            DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
            return;
        }
        if (DataCanbus.DATA[1000] == 9568710) {
            DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
            return;
        }
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
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
    }
}
