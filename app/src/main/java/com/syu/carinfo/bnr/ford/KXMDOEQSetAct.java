package com.syu.carinfo.bnr.ford;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KXMDOEQSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bnr.ford.KXMDOEQSetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    int value = DataCanbus.DATA[79];
                    if (value > 2) {
                        value--;
                    }
                    KXMDOEQSetAct.this.sendCMD(5, value);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int value2 = DataCanbus.DATA[79];
                    if (value2 < 12) {
                        value2++;
                    }
                    KXMDOEQSetAct.this.sendCMD(5, value2);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    int value3 = DataCanbus.DATA[78];
                    if (value3 > 2) {
                        value3--;
                    }
                    KXMDOEQSetAct.this.sendCMD(6, value3);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int value4 = DataCanbus.DATA[78];
                    if (value4 < 12) {
                        value4++;
                    }
                    KXMDOEQSetAct.this.sendCMD(6, value4);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int value5 = DataCanbus.DATA[77];
                    if (value5 > 2) {
                        value5--;
                    }
                    KXMDOEQSetAct.this.sendCMD(4, value5);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int value6 = DataCanbus.DATA[77];
                    if (value6 < 12) {
                        value6++;
                    }
                    KXMDOEQSetAct.this.sendCMD(4, value6);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int value7 = DataCanbus.DATA[75];
                    if (value7 > 0) {
                        value7--;
                    }
                    KXMDOEQSetAct.this.sendCMD(2, value7);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int value8 = DataCanbus.DATA[75];
                    if (value8 < 14) {
                        value8++;
                    }
                    KXMDOEQSetAct.this.sendCMD(2, value8);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                    int value9 = DataCanbus.DATA[74];
                    if (value9 > 0) {
                        value9--;
                    }
                    KXMDOEQSetAct.this.sendCMD(1, value9);
                    break;
                case R.id.btn_plus5 /* 2131427498 */:
                    int value10 = DataCanbus.DATA[74];
                    if (value10 < 14) {
                        value10++;
                    }
                    KXMDOEQSetAct.this.sendCMD(1, value10);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                    int value11 = DataCanbus.DATA[80];
                    if (value11 > 0) {
                        value11--;
                    }
                    KXMDOEQSetAct.this.sendCMD(7, value11);
                    break;
                case R.id.btn_plus7 /* 2131427507 */:
                    int value12 = DataCanbus.DATA[80];
                    if (value12 < 63) {
                        value12++;
                    }
                    KXMDOEQSetAct.this.sendCMD(7, value12);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.ford.KXMDOEQSetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 74:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (7 - value));
                        break;
                    }
                case 75:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (7 - value));
                        break;
                    }
                case 76:
                    if (((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 8);
                        break;
                    }
                case 77:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                        break;
                    }
                case 78:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                        break;
                    }
                case 79:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (7 - value));
                        break;
                    }
                case 80:
                    ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 81:
                    if (((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0403_kx_mengdiou_eq_set);
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
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus7));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.ford.KXMDOEQSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[76];
                    if (value == 1) {
                        value = 8;
                    } else if (value == 8) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.ford.KXMDOEQSetAct.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[81] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(2, new int[]{cmd, val}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
    }
}
