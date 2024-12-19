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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XC_429_crown_AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.XC_429_crown_AmpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 70:
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
                case 71:
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
                case 72:
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
                case 73:
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
                case 74:
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
                case 75:
                    ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 76:
                    XC_429_crown_AmpSetAct.this.setCheck((CheckedTextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0429_xc_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[76];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarAmpInfo(9, value);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value2 = DataCanbus.DATA[75];
                if (value2 > 1) {
                    value2--;
                }
                setCarAmpInfo(7, value2);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value3 = DataCanbus.DATA[75];
                if (value3 < 63) {
                    value3++;
                }
                setCarAmpInfo(7, value3);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value4 = DataCanbus.DATA[71];
                if (value4 > 1) {
                    value4--;
                }
                setCarAmpInfo(2, value4);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value5 = DataCanbus.DATA[71];
                if (value5 < 31) {
                    value5++;
                }
                setCarAmpInfo(2, value5);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value6 = DataCanbus.DATA[70];
                if (value6 > 1) {
                    value6--;
                }
                setCarAmpInfo(1, value6);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value7 = DataCanbus.DATA[70];
                if (value7 < 31) {
                    value7++;
                }
                setCarAmpInfo(1, value7);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value8 = DataCanbus.DATA[72];
                if (value8 > 1) {
                    value8--;
                }
                setCarAmpInfo(4, value8);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value9 = DataCanbus.DATA[72];
                if (value9 < 31) {
                    value9++;
                }
                setCarAmpInfo(4, value9);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value10 = DataCanbus.DATA[74];
                if (value10 > 1) {
                    value10--;
                }
                setCarAmpInfo(5, value10);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value11 = DataCanbus.DATA[74];
                if (value11 < 31) {
                    value11++;
                }
                setCarAmpInfo(5, value11);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value12 = DataCanbus.DATA[73];
                if (value12 > 1) {
                    value12--;
                }
                setCarAmpInfo(6, value12);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value13 = DataCanbus.DATA[73];
                if (value13 < 31) {
                    value13++;
                }
                setCarAmpInfo(6, value13);
                break;
        }
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
    }
}
