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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class XC_429_crown_AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.XC_429_crown_AmpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("R" + (value - 7));
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("F" + (7 - value));
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text8)).setText("0");
                    }
                    break;
                case 115:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("R" + (value - 7));
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("L" + (7 - value));
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text7)).setText("0");
                    }
                    break;
                case 116:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("+" + (value - 7));
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("-" + (7 - value));
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text9)).setText("0");
                    }
                    break;
                case 117:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("+" + (value - 7));
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("-" + (7 - value));
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text11)).setText("0");
                    }
                    break;
                case 118:
                    if (value > 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("+" + (value - 7));
                    } else if (value < 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("-" + (7 - value));
                    } else if (value == 7) {
                        ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text10)).setText("0");
                    }
                    break;
                case 119:
                    ((TextView) XC_429_crown_AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 120:
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
            case R.id.btn_plus6 /* 2131427430 */:
                int value = DataCanbus.DATA[119];
                if (value < 63) {
                    value++;
                }
                setCarAmpInfo(7, value);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value2 = DataCanbus.DATA[115];
                if (value2 < 14) {
                    value2++;
                }
                setCarAmpInfo(2, value2);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value3 = DataCanbus.DATA[114];
                if (value3 < 14) {
                    value3++;
                }
                setCarAmpInfo(1, value3);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value4 = DataCanbus.DATA[116];
                if (value4 < 12) {
                    value4++;
                }
                setCarAmpInfo(4, value4);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value5 = DataCanbus.DATA[118];
                if (value5 < 12) {
                    value5++;
                }
                setCarAmpInfo(6, value5);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value6 = DataCanbus.DATA[117];
                if (value6 < 12) {
                    value6++;
                }
                setCarAmpInfo(5, value6);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value7 = DataCanbus.DATA[119];
                if (value7 > 1) {
                    value7--;
                }
                setCarAmpInfo(7, value7);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value8 = DataCanbus.DATA[115];
                if (value8 > 0) {
                    value8--;
                }
                if (value8 < 0) {
                    value8 = 0;
                }
                setCarAmpInfo(2, value8);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value9 = DataCanbus.DATA[114];
                if (value9 > 0) {
                    value9--;
                }
                if (value9 < 0) {
                    value9 = 0;
                }
                setCarAmpInfo(1, value9);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value10 = DataCanbus.DATA[116];
                if (value10 > 2) {
                    value10--;
                }
                if (value10 < 2) {
                    value10 = 2;
                }
                setCarAmpInfo(4, value10);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value11 = DataCanbus.DATA[118];
                if (value11 > 2) {
                    value11--;
                }
                if (value11 < 2) {
                    value11 = 2;
                }
                setCarAmpInfo(6, value11);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value12 = DataCanbus.DATA[117];
                if (value12 > 2) {
                    value12--;
                }
                if (value12 < 2) {
                    value12 = 2;
                }
                setCarAmpInfo(5, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
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
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
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
