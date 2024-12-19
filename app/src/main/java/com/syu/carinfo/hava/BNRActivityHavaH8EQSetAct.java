package com.syu.carinfo.hava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BNRActivityHavaH8EQSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8EQSetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    int value = DataCanbus.DATA[60];
                    if (value > 0) {
                        value--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(3, value);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int value2 = DataCanbus.DATA[60];
                    if (value2 < 20) {
                        value2++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(3, value2);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    int value3 = DataCanbus.DATA[59];
                    if (value3 > 0) {
                        value3--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(4, value3);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int value4 = DataCanbus.DATA[59];
                    if (value4 < 20) {
                        value4++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(4, value4);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int value5 = DataCanbus.DATA[58];
                    if (value5 > 0) {
                        value5--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(5, value5);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int value6 = DataCanbus.DATA[58];
                    if (value6 < 20) {
                        value6++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(5, value6);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int value7 = DataCanbus.DATA[64];
                    if (value7 > 0) {
                        value7--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(2, value7);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int value8 = DataCanbus.DATA[64];
                    if (value8 < 20) {
                        value8++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(2, value8);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                    int value9 = DataCanbus.DATA[63];
                    if (value9 > 0) {
                        value9--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(1, value9);
                    break;
                case R.id.btn_plus5 /* 2131427498 */:
                    int value10 = DataCanbus.DATA[63];
                    if (value10 < 20) {
                        value10++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(1, value10);
                    break;
                case R.id.btn_minus6 /* 2131427501 */:
                    int value11 = DataCanbus.DATA[61];
                    if (value11 > 0) {
                        value11--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(6, value11);
                    break;
                case R.id.btn_plus6 /* 2131427503 */:
                    int value12 = DataCanbus.DATA[61];
                    if (value12 < 3) {
                        value12++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(6, value12);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                    int value13 = DataCanbus.DATA[57];
                    if (value13 > 0) {
                        value13--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(8, value13);
                    break;
                case R.id.btn_plus7 /* 2131427507 */:
                    int value14 = DataCanbus.DATA[57];
                    if (value14 < 39) {
                        value14++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(8, value14);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8EQSetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 44:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 16) + "." + (value % 16));
                    break;
                case 45:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 16) + "." + (value % 16));
                    break;
                case 46:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "℃");
                    break;
                case 47:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 48:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 57:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 58:
                    if (value > 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                        break;
                    }
                case 59:
                    if (value > 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                        break;
                    }
                case 60:
                    if (value > 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                        break;
                    }
                case 61:
                    switch (value) {
                        case 0:
                            ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                            break;
                    }
                case 62:
                    if (((CheckedTextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
                case 63:
                    if (value > 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                        break;
                    }
                case 64:
                    if (value > 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_bnr_havalh8_eq_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus7));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8EQSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[62] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 7;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            });
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_BNR_HAVAL_H8 /* 16318903 */:
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                break;
            case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
    }
}
