package com.syu.carinfo.wc.crown;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class wc_420_crown_AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 128:
                    if (value > 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("R" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("L" + (10 - value));
                        break;
                    } else if (value == 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    }
                case 129:
                    if (value > 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("R" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("F" + (10 - value));
                        break;
                    } else if (value == 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("0");
                        break;
                    }
                case 130:
                    if (value > 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("+" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("-" + (10 - value));
                        break;
                    } else if (value == 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("0");
                        break;
                    }
                case 131:
                    if (value > 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("+" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("-" + (10 - value));
                        break;
                    } else if (value == 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("0");
                        break;
                    }
                case 132:
                    if (value > 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("+" + (value - 10));
                        break;
                    } else if (value < 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("-" + (10 - value));
                        break;
                    } else if (value == 10) {
                        ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("0");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0420_wc_amp_settings);
        init();
    }

    @Override
    public void init() {
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus6 /* 2131427470 */:
                setCarAmpInfo(1, -1);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarAmpInfo(1, 1);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value = DataCanbus.DATA[128];
                if (value > 1) {
                    value--;
                }
                setCarAmpInfo(2, value);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value2 = DataCanbus.DATA[128];
                if (value2 < 31) {
                    value2++;
                }
                setCarAmpInfo(2, value2);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value3 = DataCanbus.DATA[129];
                if (value3 > 1) {
                    value3--;
                }
                setCarAmpInfo(3, value3);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value4 = DataCanbus.DATA[129];
                if (value4 < 31) {
                    value4++;
                }
                setCarAmpInfo(3, value4);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value5 = DataCanbus.DATA[130];
                if (value5 > 1) {
                    value5--;
                }
                setCarAmpInfo(4, value5);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value6 = DataCanbus.DATA[130];
                if (value6 < 31) {
                    value6++;
                }
                setCarAmpInfo(4, value6);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value7 = DataCanbus.DATA[131];
                if (value7 > 1) {
                    value7--;
                }
                setCarAmpInfo(5, value7);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value8 = DataCanbus.DATA[131];
                if (value8 < 31) {
                    value8++;
                }
                setCarAmpInfo(5, value8);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value9 = DataCanbus.DATA[132];
                if (value9 > 1) {
                    value9--;
                }
                setCarAmpInfo(6, value9);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value10 = DataCanbus.DATA[132];
                if (value10 < 31) {
                    value10++;
                }
                setCarAmpInfo(6, value10);
                break;
        }
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }
}
