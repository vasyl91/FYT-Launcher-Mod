package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class SanlinCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.SanlinCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 6:
                    SanlinCarSet.this.updateText1(val);
                    break;
                case 7:
                    SanlinCarSet.this.updateText2(val);
                    break;
                case 8:
                    SanlinCarSet.this.updateText3(val);
                    break;
                case 9:
                    SanlinCarSet.this.updateText4(val);
                    break;
                case 10:
                    SanlinCarSet.this.updateText5(val);
                    break;
                case 11:
                    SanlinCarSet.this.updateText6(val);
                    break;
                case 12:
                    SanlinCarSet.this.updateText7(val);
                    break;
                case 13:
                    SanlinCarSet.this.updateText8(val);
                    break;
                case 14:
                    SanlinCarSet.this.updateText9(val);
                    break;
                case 15:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 144);
                    break;
                case 16:
                    SanlinCarSet.this.updateText10(val);
                    break;
                case 17:
                    SanlinCarSet.this.updateText11(val);
                    break;
                case 18:
                    SanlinCarSet.this.updateText12(val);
                    break;
                case 19:
                    SanlinCarSet.this.updateText13(val);
                    break;
                case 20:
                    SanlinCarSet.this.updateText14(val);
                    break;
                case 21:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 144);
                    break;
                case 22:
                    SanlinCarSet.this.updateText15(val);
                    break;
                case 23:
                    SanlinCarSet.this.updateText16(val);
                    break;
                case 24:
                    SanlinCarSet.this.updateText17(val);
                    break;
                case 25:
                    SanlinCarSet.this.updateText18(val);
                    break;
                case 26:
                    SanlinCarSet.this.updateText19(val);
                    break;
                case 27:
                    SanlinCarSet.this.updateText20(val);
                    break;
                case 28:
                    SanlinCarSet.this.updateText21(val);
                    break;
                case 29:
                    SanlinCarSet.this.updateText22(val);
                    break;
                case 30:
                    SanlinCarSet.this.updateText23(val);
                    break;
                case 31:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 144);
                    break;
                case 32:
                    SanlinCarSet.this.updateText24(val);
                    break;
                case 33:
                    SanlinCarSet.this.updateText25(val);
                    break;
                case 34:
                    SanlinCarSet.this.updateText26(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_sanlin_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value3 = ((DataCanbus.DATA[19] >> 4) & 15) - 1;
                if (value3 < 8) {
                    value3 = 14;
                }
                setCarInfo(13, (value3 << 4) & 240);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value4 = ((DataCanbus.DATA[19] >> 4) & 15) + 1;
                if (value4 > 14) {
                    value4 = 8;
                }
                setCarInfo(13, (value4 << 4) & 240);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value5 = ((DataCanbus.DATA[20] >> 4) & 15) - 1;
                if (value5 < 8) {
                    value5 = 9;
                }
                setCarInfo(14, (value5 << 4) & 240);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value6 = ((DataCanbus.DATA[20] >> 4) & 15) + 1;
                if (value6 > 9) {
                    value6 = 8;
                }
                setCarInfo(14, (value6 << 4) & 240);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value7 = ((DataCanbus.DATA[22] >> 4) & 15) - 1;
                if (value7 < 8) {
                    value7 = 9;
                }
                setCarInfo(16, (value7 << 4) & 240);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value8 = ((DataCanbus.DATA[22] >> 4) & 15) + 1;
                if (value8 > 9) {
                    value8 = 8;
                }
                setCarInfo(16, (value8 << 4) & 240);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value9 = DataCanbus.DATA[15];
                if (value9 == 128) {
                    value9 = 144;
                } else if (value9 == 144) {
                    value9 = 128;
                }
                setCarInfo(9, value9);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value10 = DataCanbus.DATA[6] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(0, value10);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value11 = DataCanbus.DATA[6] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(0, value11);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value12 = ((DataCanbus.DATA[7] >> 4) & 15) - 1;
                if (value12 < 8) {
                    value12 = 14;
                }
                setCarInfo(1, (value12 << 4) & 240);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value13 = ((DataCanbus.DATA[7] >> 4) & 15) + 1;
                if (value13 > 14) {
                    value13 = 8;
                }
                setCarInfo(1, (value13 << 4) & 240);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                if (((DataCanbus.DATA[8] >> 4) & 15) == 8) {
                    value2 = 12;
                } else {
                    value2 = 8;
                }
                setCarInfo(2, (value2 << 4) & 240);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                if (((DataCanbus.DATA[8] >> 4) & 15) == 8) {
                    value = 12;
                } else {
                    value = 8;
                }
                setCarInfo(2, (value << 4) & 240);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = ((DataCanbus.DATA[9] >> 4) & 15) - 1;
                if (value14 < 8) {
                    value14 = 10;
                }
                setCarInfo(3, (value14 << 4) & 240);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = ((DataCanbus.DATA[9] >> 4) & 15) + 1;
                if (value15 > 10) {
                    value15 = 8;
                }
                setCarInfo(3, (value15 << 4) & 240);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = ((DataCanbus.DATA[10] >> 4) & 15) - 1;
                if (value16 < 8) {
                    value16 = 11;
                }
                setCarInfo(4, (value16 << 4) & 240);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = ((DataCanbus.DATA[10] >> 4) & 15) + 1;
                if (value17 > 11) {
                    value17 = 8;
                }
                setCarInfo(4, (value17 << 4) & 240);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = ((DataCanbus.DATA[11] >> 4) & 15) - 1;
                if (value18 < 8) {
                    value18 = 10;
                }
                setCarInfo(5, (value18 << 4) & 240);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = ((DataCanbus.DATA[11] >> 4) & 15) + 1;
                if (value19 > 10) {
                    value19 = 8;
                }
                setCarInfo(5, (value19 << 4) & 240);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = ((DataCanbus.DATA[12] >> 4) & 15) - 1;
                if (value20 < 8) {
                    value20 = 9;
                }
                setCarInfo(6, (value20 << 4) & 240);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = ((DataCanbus.DATA[12] >> 4) & 15) + 1;
                if (value21 > 9) {
                    value21 = 8;
                }
                setCarInfo(6, (value21 << 4) & 240);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = ((DataCanbus.DATA[13] >> 4) & 15) - 1;
                if (value22 < 8) {
                    value22 = 11;
                }
                setCarInfo(7, (value22 << 4) & 240);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = ((DataCanbus.DATA[13] >> 4) & 15) + 1;
                if (value23 > 11) {
                    value23 = 8;
                }
                setCarInfo(7, (value23 << 4) & 240);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = ((DataCanbus.DATA[14] >> 4) & 15) - 1;
                if (value24 < 8) {
                    value24 = 9;
                }
                setCarInfo(8, (value24 << 4) & 240);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = ((DataCanbus.DATA[14] >> 4) & 15) + 1;
                if (value25 > 9) {
                    value25 = 8;
                }
                setCarInfo(8, (value25 << 4) & 240);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = ((DataCanbus.DATA[16] >> 4) & 15) - 1;
                if (value26 < 8) {
                    value26 = 12;
                }
                setCarInfo(10, (value26 << 4) & 240);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = ((DataCanbus.DATA[16] >> 4) & 15) + 1;
                if (value27 > 12) {
                    value27 = 8;
                }
                setCarInfo(10, (value27 << 4) & 240);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = ((DataCanbus.DATA[17] >> 4) & 15) - 1;
                if (value28 < 8) {
                    value28 = 10;
                }
                setCarInfo(11, (value28 << 4) & 240);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = ((DataCanbus.DATA[17] >> 4) & 15) + 1;
                if (value29 > 10) {
                    value29 = 8;
                }
                setCarInfo(11, (value29 << 4) & 240);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = ((DataCanbus.DATA[18] >> 4) & 15) - 1;
                if (value30 < 8) {
                    value30 = 11;
                }
                setCarInfo(12, (value30 << 4) & 240);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = ((DataCanbus.DATA[18] >> 4) & 15) + 1;
                if (value31 > 11) {
                    value31 = 8;
                }
                setCarInfo(12, (value31 << 4) & 240);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[21];
                if (value32 == 128) {
                    value32 = 144;
                } else if (value32 == 144) {
                    value32 = 128;
                }
                setCarInfo(15, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[31];
                if (value33 == 128) {
                    value33 = 144;
                } else if (value33 == 144) {
                    value33 = 128;
                }
                setCarInfo(25, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                dialog(R.string.all_settings, 31);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value34 = ((DataCanbus.DATA[25] >> 4) & 15) - 1;
                if (value34 < 8) {
                    value34 = 10;
                }
                setCarInfo(19, (value34 << 4) & 240);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value35 = ((DataCanbus.DATA[25] >> 4) & 15) + 1;
                if (value35 > 10) {
                    value35 = 8;
                }
                setCarInfo(19, (value35 << 4) & 240);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value36 = ((DataCanbus.DATA[26] >> 4) & 15) - 1;
                if (value36 < 8) {
                    value36 = 9;
                }
                setCarInfo(20, (value36 << 4) & 240);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value37 = ((DataCanbus.DATA[26] >> 4) & 15) + 1;
                if (value37 > 9) {
                    value37 = 8;
                }
                setCarInfo(20, (value37 << 4) & 240);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value38 = ((DataCanbus.DATA[28] >> 4) & 15) - 1;
                if (value38 < 8) {
                    value38 = 9;
                }
                setCarInfo(22, (value38 << 4) & 240);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value39 = ((DataCanbus.DATA[28] >> 4) & 15) + 1;
                if (value39 > 9) {
                    value39 = 8;
                }
                setCarInfo(22, (value39 << 4) & 240);
                break;
            case R.id.btn_minus22 /* 2131427884 */:
                int value40 = ((DataCanbus.DATA[29] >> 4) & 15) - 1;
                if (value40 < 8) {
                    value40 = 10;
                }
                setCarInfo(23, (value40 << 4) & 240);
                break;
            case R.id.btn_plus22 /* 2131427885 */:
                int value41 = ((DataCanbus.DATA[29] >> 4) & 15) + 1;
                if (value41 > 10) {
                    value41 = 8;
                }
                setCarInfo(23, (value41 << 4) & 240);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value42 = ((DataCanbus.DATA[23] >> 4) & 15) - 1;
                if (value42 < 8) {
                    value42 = 11;
                }
                setCarInfo(17, (value42 << 4) & 240);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value43 = ((DataCanbus.DATA[23] >> 4) & 15) + 1;
                if (value43 > 11) {
                    value43 = 8;
                }
                setCarInfo(17, (value43 << 4) & 240);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value44 = ((DataCanbus.DATA[24] >> 4) & 15) - 1;
                if (value44 < 8) {
                    value44 = 9;
                }
                setCarInfo(18, (value44 << 4) & 240);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value45 = ((DataCanbus.DATA[24] >> 4) & 15) + 1;
                if (value45 > 9) {
                    value45 = 8;
                }
                setCarInfo(18, (value45 << 4) & 240);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value46 = ((DataCanbus.DATA[27] >> 4) & 15) - 1;
                if (value46 < 8) {
                    value46 = 9;
                }
                setCarInfo(21, (value46 << 4) & 240);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value47 = ((DataCanbus.DATA[27] >> 4) & 15) + 1;
                if (value47 > 9) {
                    value47 = 8;
                }
                setCarInfo(21, (value47 << 4) & 240);
                break;
            case R.id.btn_plus25 /* 2131427923 */:
                int value48 = ((DataCanbus.DATA[33] >> 4) & 15) + 1;
                if (value48 > 10) {
                    value48 = 8;
                }
                setCarInfo(27, (value48 << 4) & 240);
                break;
            case R.id.btn_plus24 /* 2131427924 */:
                int value49 = ((DataCanbus.DATA[32] >> 4) & 15) + 1;
                if (value49 > 11) {
                    value49 = 8;
                }
                setCarInfo(26, (value49 << 4) & 240);
                break;
            case R.id.btn_plus26 /* 2131427925 */:
                int value50 = DataCanbus.DATA[34] + 1;
                if (value50 > 2) {
                    value50 = 1;
                }
                setCarInfo(28, value50);
                break;
            case R.id.btn_plus23 /* 2131427928 */:
                int value51 = ((DataCanbus.DATA[30] >> 4) & 15) + 1;
                if (value51 > 10) {
                    value51 = 8;
                }
                setCarInfo(24, (value51 << 4) & 240);
                break;
            case R.id.btn_minus25 /* 2131428315 */:
                int value52 = ((DataCanbus.DATA[33] >> 4) & 15) - 1;
                if (value52 < 8) {
                    value52 = 10;
                }
                setCarInfo(27, (value52 << 4) & 240);
                break;
            case R.id.btn_minus26 /* 2131428316 */:
                int value53 = DataCanbus.DATA[34] - 1;
                if (value53 < 1) {
                    value53 = 2;
                }
                setCarInfo(28, value53);
                break;
            case R.id.btn_minus23 /* 2131428318 */:
                int value54 = ((DataCanbus.DATA[30] >> 4) & 15) - 1;
                if (value54 < 8) {
                    value54 = 10;
                }
                setCarInfo(24, (value54 << 4) & 240);
                break;
            case R.id.btn_minus24 /* 2131428319 */:
                int value55 = ((DataCanbus.DATA[32] >> 4) & 15) - 1;
                if (value55 < 8) {
                    value55 = 11;
                }
                setCarInfo(26, (value55 << 4) & 240);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }

    void updateText26(int value) {
        if (((TextView) findViewById(R.id.tv_text26)) != null) {
            switch (value) {
                case 2:
                    ((TextView) findViewById(R.id.tv_text26)).setText("Automatic");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text26)).setText("Manual");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText25(int value) {
        if (((TextView) findViewById(R.id.tv_text25)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text25)).setText("30 minute");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text25)).setText("60 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text25)).setText("Never");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText24(int value) {
        if (((TextView) findViewById(R.id.tv_text24)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text24)).setText("Fold out(by vehicle speed)");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text24)).setText("Fold In/Out by ignition switch ON/OFF");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text24)).setText("Fold In/Out by Keyless Entry");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text24)).setText("None");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText23(int value) {
        if (((TextView) findViewById(R.id.tv_text23)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text23)).setText("More Airflow to Face");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text23)).setText("More Airflow to Foot");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text23)).setText("Normal");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText22(int value) {
        if (((TextView) findViewById(R.id.tv_text22)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text22)).setText("More Airflow to Foot");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text22)).setText("More Airflow to Windshield");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text22)).setText("Normal");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText21(int value) {
        if (((TextView) findViewById(R.id.tv_text21)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text21)).setText("Comfort");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text21)).setText("Eco");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText20(int value) {
        if (((TextView) findViewById(R.id.tv_text20)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text20)).setText("Automatic");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text20)).setText("Manual");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText19(int value) {
        if (((TextView) findViewById(R.id.tv_text19)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text19)).setText("Automatic");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text19)).setText("Manual");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText18(int value) {
        if (((TextView) findViewById(R.id.tv_text18)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text18)).setText("Connects to gearlever in position");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text18)).setText("Connects to ignition switch OFF(LOCK) position");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text18)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText17(int value) {
        if (((TextView) findViewById(R.id.tv_text17)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text17)).setText("Dirver door only");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text17)).setText("ALL doors");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText16(int value) {
        if (((TextView) findViewById(R.id.tv_text16)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text16)).setText("1 minute");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text16)).setText("2 minute");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text16)).setText("3 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text16)).setText("30 seconds");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText15(int value) {
        if (((TextView) findViewById(R.id.tv_text15)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text15)).setText("Long");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text15)).setText("Short");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText14(int value) {
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text14)).setText("ignition switch ON");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text14)).setText("ignition switch ON or Accessory");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText13(int value) {
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            switch (value) {
                case 128:
                    ((TextView) findViewById(R.id.tv_text13)).setText("0 seconds");
                    break;
                case 144:
                    ((TextView) findViewById(R.id.tv_text13)).setText("7.5 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text13)).setText("15 seconds");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text13)).setText("30 seconds");
                    break;
                case 192:
                    ((TextView) findViewById(R.id.tv_text13)).setText("1 minute");
                    break;
                case 208:
                    ((TextView) findViewById(R.id.tv_text13)).setText("2 minute");
                    break;
                case 224:
                    ((TextView) findViewById(R.id.tv_text13)).setText("3 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text13)).setText("0 seconds");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text12)).setText("3 minute");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text12)).setText("30 minute");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text12)).setText("60 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Never");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Front position Lamp ON");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Head lights ON");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text10)).setText("15 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text10)).setText("30 seconds");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text10)).setText("1 minute");
                    break;
                case 192:
                    ((TextView) findViewById(R.id.tv_text10)).setText("3 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text10)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Front/ Rear Wiper switch ON");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Rear Wiper switch ON");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text8)).setText("4 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text8)).setText("8 seconds");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text8)).setText("16 seconds");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText("0 seconds");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text7)).setText("On");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text6)).setText("On");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text6)).setText("On(with Delayed Finishing Wipe)");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Variable");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Variable(by vehicle speed)");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Variable(rain sensing)");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText("4 seconds");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text4)).setText("3 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text4)).setText("5 seconds");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 192:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Wing mirror:Fold out&Fold in");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 128:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock:Once/Unlock:Twice");
                    break;
                case 144:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock:Once/Unlock:Off");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock:Off/Unlock:Twice");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock: Twice /Unlock: Once");
                    break;
                case 192:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock: Off /Unlock: Once");
                    break;
                case 208:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock: Twice /Unlock: Off");
                    break;
                case 224:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("High");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Medium");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Low");
                    break;
            }
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.SanlinCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.SanlinCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.SanlinCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
