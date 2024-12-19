package com.syu.carinfo.dj.havalh8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dj_0439_HavalH8AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8AmpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 88:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 89:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 90:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 91:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 92:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 93:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 94:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                        case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                        case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                        case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                        case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                        case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                            Dj_0439_HavalH8AmpSetAct.this.setCheck((CheckedTextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 2);
                            break;
                        default:
                            Dj_0439_HavalH8AmpSetAct.this.setCheck((CheckedTextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_dj_h8_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value2 = DataCanbus.DATA[94];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        if (value2 == 1) {
                            value = 2;
                        } else {
                            value = 1;
                        }
                        setCarInfo(7, value);
                        break;
                    default:
                        if (value2 == 1) {
                            value2 = 0;
                        } else if (value2 == 0) {
                            value2 = 1;
                        }
                        setCarInfo(7, value2);
                        break;
                }
            case R.id.btn_minus1 /* 2131427480 */:
                int bass = DataCanbus.DATA[90];
                if (bass > 0) {
                    bass--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(4, bass);
                        break;
                    default:
                        setCarInfo(5, bass);
                        break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int bass2 = DataCanbus.DATA[90];
                if (bass2 < 20) {
                    bass2++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(4, bass2);
                        break;
                    default:
                        setCarInfo(5, bass2);
                        break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int mid = DataCanbus.DATA[89];
                if (mid > 0) {
                    mid--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(3, mid);
                        break;
                    default:
                        setCarInfo(4, mid);
                        break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int mid2 = DataCanbus.DATA[89];
                if (mid2 < 20) {
                    mid2++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(3, mid2);
                        break;
                    default:
                        setCarInfo(4, mid2);
                        break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                int treb = DataCanbus.DATA[88];
                if (treb > 0) {
                    treb--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(2, treb);
                        break;
                    default:
                        setCarInfo(3, treb);
                        break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                int treb2 = DataCanbus.DATA[88];
                if (treb2 < 20) {
                    treb2++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(2, treb2);
                        break;
                    default:
                        setCarInfo(3, treb2);
                        break;
                }
            case R.id.btn_minus4 /* 2131427492 */:
                int bal = DataCanbus.DATA[91];
                if (bal > 0) {
                    bal--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(5, bal);
                        break;
                    default:
                        setCarInfo(2, bal);
                        break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                int bal2 = DataCanbus.DATA[91];
                if (bal2 < 20) {
                    bal2++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(5, bal2);
                        break;
                    default:
                        setCarInfo(2, bal2);
                        break;
                }
            case R.id.btn_minus5 /* 2131427496 */:
                int fad = DataCanbus.DATA[92];
                if (fad > 0) {
                    fad--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(6, fad);
                        break;
                    default:
                        setCarInfo(1, fad);
                        break;
                }
            case R.id.btn_plus5 /* 2131427498 */:
                int fad2 = DataCanbus.DATA[92];
                if (fad2 < 20) {
                    fad2++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(6, fad2);
                        break;
                    default:
                        setCarInfo(1, fad2);
                        break;
                }
            case R.id.btn_minus6 /* 2131427501 */:
                int value3 = DataCanbus.DATA[93];
                if (value3 > 0) {
                    value3--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(8, value3);
                        break;
                    default:
                        setCarInfo(6, value3);
                        break;
                }
            case R.id.btn_plus6 /* 2131427503 */:
                int value4 = DataCanbus.DATA[93];
                if (value4 < 3) {
                    value4++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(8, value4);
                        break;
                    default:
                        setCarInfo(6, value4);
                        break;
                }
            case R.id.btn_minus7 /* 2131427505 */:
                int value5 = DataCanbus.DATA[87];
                if (value5 > 0) {
                    value5--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(1, value5);
                        break;
                }
            case R.id.btn_plus7 /* 2131427507 */:
                int value6 = DataCanbus.DATA[87];
                if (value6 < 40) {
                    value6++;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(1, value6);
                        break;
                }
        }
    }

    public void setCarInfo(int value0, int value1) {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
                break;
            default:
                DataCanbus.PROXY.cmd(6, new int[]{value0, value1}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{49}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
    }
}
