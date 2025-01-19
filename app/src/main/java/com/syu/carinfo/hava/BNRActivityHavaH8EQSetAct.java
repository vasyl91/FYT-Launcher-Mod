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

public class BNRActivityHavaH8EQSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[137];
                    if (value > 0) {
                        value--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(3, value);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[137];
                    if (value2 < 20) {
                        value2++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(3, value2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value3 = DataCanbus.DATA[136];
                    if (value3 > 0) {
                        value3--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(4, value3);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value4 = DataCanbus.DATA[136];
                    if (value4 < 20) {
                        value4++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(4, value4);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value5 = DataCanbus.DATA[135];
                    if (value5 > 0) {
                        value5--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(5, value5);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value6 = DataCanbus.DATA[135];
                    if (value6 < 20) {
                        value6++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(5, value6);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value7 = DataCanbus.DATA[141];
                    if (value7 > 0) {
                        value7--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(2, value7);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value8 = DataCanbus.DATA[141];
                    if (value8 < 20) {
                        value8++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(2, value8);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    int value9 = DataCanbus.DATA[140];
                    if (value9 > 0) {
                        value9--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(1, value9);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[140];
                    if (value10 < 20) {
                        value10++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(1, value10);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                    int value11 = DataCanbus.DATA[138];
                    if (value11 > 0) {
                        value11--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(6, value11);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    int value12 = DataCanbus.DATA[138];
                    if (value12 < 3) {
                        value12++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(6, value12);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                    int value13 = DataCanbus.DATA[134];
                    if (value13 > 0) {
                        value13--;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(8, value13);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    int value14 = DataCanbus.DATA[134];
                    if (value14 < 39) {
                        value14++;
                    }
                    BNRActivityHavaH8EQSetAct.this.sendCMD(8, value14);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 121:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 16) + "." + (value % 16));
                    break;
                case 122:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 16) + "." + (value % 16));
                    break;
                case 123:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "℃");
                    break;
                case 124:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 125:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 134:
                    ((TextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 135:
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
                case 136:
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
                case 137:
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
                case 138:
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
                case 139:
                    if (((CheckedTextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) BNRActivityHavaH8EQSetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
                case 140:
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
                case 141:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_bnr_havalh8_eq_set);
        init();
    }

    @Override
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
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[139] & 255;
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
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
    }
}
