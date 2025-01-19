package com.syu.carinfo.dj.huangguan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XC_429_crown_AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("R" + (value - 7));
                        break;
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("F" + (7 - value));
                        break;
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("0");
                        break;
                    }
                case 115:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("R" + (value - 7));
                        break;
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("L" + (7 - value));
                        break;
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    }
                case 116:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("+" + (value - 7));
                        break;
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("-" + (7 - value));
                        break;
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("0");
                        break;
                    }
                case 117:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("+" + (value - 7));
                        break;
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("-" + (7 - value));
                        break;
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("0");
                        break;
                    }
                case 118:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("+" + (value - 7));
                        break;
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("-" + (7 - value));
                        break;
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("0");
                        break;
                    }
                case 119:
                    ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value));
                    break;
                case 120:
                    XC_429_crown_AmpSetAct.this.setCheck(XC_429_crown_AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0429_xc_amp_settings);
        init();
    }

    @Override
    public void init() {
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
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus6 /* 2131427470 */:
                int value = DataCanbus.DATA[119];
                if (value > 1) {
                    value--;
                }
                setCarAmpInfo(7, value);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value2 = DataCanbus.DATA[119];
                if (value2 < 63) {
                    value2++;
                }
                setCarAmpInfo(7, value2);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value3 = DataCanbus.DATA[115];
                if (value3 > 1) {
                    value3--;
                }
                setCarAmpInfo(2, value3);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value4 = DataCanbus.DATA[115];
                if (value4 < 31) {
                    value4++;
                }
                setCarAmpInfo(2, value4);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value5 = DataCanbus.DATA[114];
                if (value5 > 1) {
                    value5--;
                }
                setCarAmpInfo(1, value5);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value6 = DataCanbus.DATA[114];
                if (value6 < 31) {
                    value6++;
                }
                setCarAmpInfo(1, value6);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value7 = DataCanbus.DATA[116];
                if (value7 > 1) {
                    value7--;
                }
                setCarAmpInfo(4, value7);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value8 = DataCanbus.DATA[116];
                if (value8 < 31) {
                    value8++;
                }
                setCarAmpInfo(4, value8);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value9 = DataCanbus.DATA[118];
                if (value9 > 1) {
                    value9--;
                }
                setCarAmpInfo(6, value9);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value10 = DataCanbus.DATA[118];
                if (value10 < 31) {
                    value10++;
                }
                setCarAmpInfo(6, value10);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value11 = DataCanbus.DATA[117];
                if (value11 > 1) {
                    value11--;
                }
                setCarAmpInfo(5, value11);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value12 = DataCanbus.DATA[117];
                if (value12 < 31) {
                    value12++;
                }
                setCarAmpInfo(5, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[120];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarAmpInfo(9, value13);
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
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }
}
