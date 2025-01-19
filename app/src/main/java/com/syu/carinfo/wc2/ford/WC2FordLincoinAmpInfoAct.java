package com.syu.carinfo.wc2.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WC2FordLincoinAmpInfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text1)) != null && val <= 30 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 112:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text2)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 113:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text3)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 114:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text4)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 115:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text5)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 116:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text6)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 117:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 118:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (val == 1) {
                            ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_Parking_with_trailer_ON);
                            break;
                        } else {
                            ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_Parking_with_trailer_Off);
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_tianlai_gj_amp_info);
        init();
    }

    @Override
    public void init() {
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
    }

    @Override
    public void onClick(View v) {
        int data = 0;
        int value = 0;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 0;
                }
                data = 1;
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                value = DataCanbus.DATA[111] + 1;
                if (value > 30) {
                    value = 30;
                }
                data = 1;
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                value = DataCanbus.DATA[112] - 1;
                if (value < 0) {
                    value = 0;
                }
                data = 2;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                value = DataCanbus.DATA[112] + 1;
                if (value > 14) {
                    value = 14;
                }
                data = 2;
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 0;
                }
                data = 3;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                value = DataCanbus.DATA[113] + 1;
                if (value > 14) {
                    value = 14;
                }
                data = 3;
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                value = DataCanbus.DATA[114] - 1;
                if (value < 0) {
                    value = 0;
                }
                data = 4;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                value = DataCanbus.DATA[114] + 1;
                if (value > 14) {
                    value = 14;
                }
                data = 4;
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                value = DataCanbus.DATA[115] - 1;
                if (value < 0) {
                    value = 0;
                }
                data = 5;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                value = DataCanbus.DATA[115] + 1;
                if (value > 14) {
                    value = 14;
                }
                data = 5;
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                value = DataCanbus.DATA[116] - 1;
                if (value < 0) {
                    value = 0;
                }
                data = 6;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                value = DataCanbus.DATA[116] + 1;
                if (value > 14) {
                    value = 14;
                }
                data = 6;
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                value = DataCanbus.DATA[117] - 1;
                if (value < 0) {
                    value = 3;
                }
                data = 7;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                value = DataCanbus.DATA[117] + 1;
                if (value > 3) {
                    value = 0;
                }
                data = 7;
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 1;
                }
                data = 8;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                value = DataCanbus.DATA[118] + 1;
                if (value > 1) {
                    value = 0;
                }
                data = 8;
                break;
        }
        cmd(data, value);
    }

    private void cmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }
}
