package com.syu.carinfo.wc.crown;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class wc_420_crown_AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.crown.wc_420_crown_AmpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 77:
                    ((TextView) wc_420_crown_AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 78:
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
                case 79:
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
                case 80:
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
                case 81:
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
                case 82:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0420_wc_amp_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus6 /* 2131427501 */:
                setCarAmpInfo(1, -1);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarAmpInfo(1, 1);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value = DataCanbus.DATA[78];
                if (value > 1) {
                    value--;
                }
                setCarAmpInfo(2, value);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value2 = DataCanbus.DATA[78];
                if (value2 < 31) {
                    value2++;
                }
                setCarAmpInfo(2, value2);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value3 = DataCanbus.DATA[79];
                if (value3 > 1) {
                    value3--;
                }
                setCarAmpInfo(3, value3);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value4 = DataCanbus.DATA[79];
                if (value4 < 31) {
                    value4++;
                }
                setCarAmpInfo(3, value4);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value5 = DataCanbus.DATA[80];
                if (value5 > 1) {
                    value5--;
                }
                setCarAmpInfo(4, value5);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value6 = DataCanbus.DATA[80];
                if (value6 < 31) {
                    value6++;
                }
                setCarAmpInfo(4, value6);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value7 = DataCanbus.DATA[81];
                if (value7 > 1) {
                    value7--;
                }
                setCarAmpInfo(5, value7);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value8 = DataCanbus.DATA[81];
                if (value8 < 31) {
                    value8++;
                }
                setCarAmpInfo(5, value8);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value9 = DataCanbus.DATA[82];
                if (value9 > 1) {
                    value9--;
                }
                setCarAmpInfo(6, value9);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value10 = DataCanbus.DATA[82];
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
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
    }
}
