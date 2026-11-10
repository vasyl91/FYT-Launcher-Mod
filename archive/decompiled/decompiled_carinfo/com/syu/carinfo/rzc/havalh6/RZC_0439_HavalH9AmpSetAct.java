package com.syu.carinfo.rzc.havalh6;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_0439_HavalH9AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 143:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 145:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 146:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                            break;
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 148:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 149:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                        case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                        case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                        case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                        case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                        case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                            RZC_0439_HavalH9AmpSetAct.this.setCheck((CheckedTextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 2);
                            break;
                        default:
                            RZC_0439_HavalH9AmpSetAct.this.setCheck((CheckedTextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_dj_h8_amp_settings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int bass = DataCanbus.DATA[145];
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
            case R.id.btn_plus1 /* 2131427457 */:
                int bass2 = DataCanbus.DATA[145];
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
            case R.id.btn_minus2 /* 2131427458 */:
                int mid = DataCanbus.DATA[144];
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
            case R.id.btn_plus2 /* 2131427460 */:
                int mid2 = DataCanbus.DATA[144];
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
            case R.id.btn_minus3 /* 2131427461 */:
                int treb = DataCanbus.DATA[143];
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
            case R.id.btn_plus3 /* 2131427463 */:
                int treb2 = DataCanbus.DATA[143];
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
            case R.id.btn_minus4 /* 2131427464 */:
                int bal = DataCanbus.DATA[146];
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
            case R.id.btn_plus4 /* 2131427466 */:
                int bal2 = DataCanbus.DATA[146];
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
            case R.id.btn_minus5 /* 2131427467 */:
                int fad = DataCanbus.DATA[147];
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
            case R.id.btn_plus5 /* 2131427469 */:
                int fad2 = DataCanbus.DATA[147];
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
            case R.id.btn_minus6 /* 2131427470 */:
                int value2 = DataCanbus.DATA[148];
                if (value2 > 0) {
                    value2--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(8, value2);
                        break;
                    default:
                        setCarInfo(6, value2);
                        break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                int value3 = DataCanbus.DATA[148];
                if (value3 < 3) {
                    value3++;
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
            case R.id.btn_minus7 /* 2131427473 */:
                int value4 = DataCanbus.DATA[142];
                if (value4 > 0) {
                    value4--;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        setCarInfo(1, value4);
                        break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                int value5 = DataCanbus.DATA[142];
                if (value5 < 40) {
                    value5++;
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
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value6 = DataCanbus.DATA[149];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                    case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                        if (value6 == 1) {
                            value = 2;
                        } else {
                            value = 1;
                        }
                        setCarInfo(7, value);
                        break;
                    default:
                        if (value6 == 1) {
                            value6 = 0;
                        } else if (value6 == 0) {
                            value6 = 1;
                        }
                        setCarInfo(7, value6);
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{49}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }
}
