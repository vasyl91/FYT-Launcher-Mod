package com.syu.carinfo.rzc.keleijia;

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
public class KeLeiJia_Set_Fengweideng extends BaseActivity {
    private int[] eventsIDs = {29, 30, 31, 32, 33};
    private int[] colorString = {R.string.str_background_green, R.string.str_background_red, R.string.str_background_blue, R.string.color_pueple_str, R.string.color_orange_str};
    private int[] colorString_rzc = {R.string.color_white_str, R.string.str_background_green, R.string.str_background_red, R.string.str_background_blue, R.string.color_pueple_str, R.string.color_orange_str, R.string.color_blue_green_str, R.string.str_403_ambient_7};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Fengweideng.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                case 80:
                    int val = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val != 0);
                        break;
                    }
                case 30:
                case 81:
                    int val2 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val2 != 0);
                        break;
                    }
                case 31:
                case 82:
                    int val3 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val3 != 0);
                        break;
                    }
                case 32:
                    int val4 = DataCanbus.DATA[updateCode];
                    if (val4 > -1 && val4 < KeLeiJia_Set_Fengweideng.this.colorString.length && ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)).setText(KeLeiJia_Set_Fengweideng.this.colorString[val4]);
                        break;
                    }
                case 33:
                case 84:
                    int val5 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val5)).toString());
                        break;
                    }
                case 83:
                    int val6 = DataCanbus.DATA[updateCode];
                    if (val6 > -1 && val6 < KeLeiJia_Set_Fengweideng.this.colorString_rzc.length && ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)).setText(KeLeiJia_Set_Fengweideng.this.colorString_rzc[val6]);
                        break;
                    }
                case 93:
                    int val7 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val7 != 0);
                        break;
                    }
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Fengweideng.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    int value = DataCanbus.DATA[93] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 33;
                    iArr[1] = value != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.btn_minus1 /* 2131427480 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value2 = (DataCanbus.DATA[83] & 255) - 1;
                        if (value2 < 0) {
                            value2 = 7;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{24, value2}, null, null);
                        break;
                    } else {
                        int value3 = (DataCanbus.DATA[32] & 255) - 1;
                        if (value3 < 0) {
                            value3 = KeLeiJia_Set_Fengweideng.this.colorString.length - 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{51, value3}, null, null);
                        break;
                    }
                case R.id.btn_plus1 /* 2131427482 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value4 = (DataCanbus.DATA[83] & 255) + 1;
                        if (value4 > 7) {
                            value4 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{24, value4}, null, null);
                        break;
                    } else {
                        int value5 = (DataCanbus.DATA[32] & 255) + 1;
                        if (value5 >= KeLeiJia_Set_Fengweideng.this.colorString.length) {
                            value5 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{51, value5}, null, null);
                        break;
                    }
                case R.id.btn_minus2 /* 2131427484 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value6 = (DataCanbus.DATA[84] & 255) - 5;
                        if (value6 < 0) {
                            value6 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{25, value6}, null, null);
                        break;
                    } else {
                        int value7 = (DataCanbus.DATA[33] & 255) - 5;
                        if (value7 < 0) {
                            value7 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{52, value7}, null, null);
                        break;
                    }
                case R.id.btn_plus2 /* 2131427486 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value8 = (DataCanbus.DATA[84] & 255) + 5;
                        if (value8 > 100) {
                            value8 = 100;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{25, value8}, null, null);
                        break;
                    } else {
                        int value9 = (DataCanbus.DATA[33] & 255) + 5;
                        if (value9 > 100) {
                            value9 = 100;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{52, value9}, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext2 /* 2131427531 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value10 = DataCanbus.DATA[80] & 255;
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int[] iArr2 = new int[2];
                        iArr2[0] = 21;
                        iArr2[1] = value10 != 1 ? 1 : 0;
                        remoteModuleProxy2.cmd(1, iArr2, null, null);
                        break;
                    } else {
                        int value11 = DataCanbus.DATA[29] & 255;
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int[] iArr3 = new int[2];
                        iArr3[0] = 48;
                        iArr3[1] = value11 != 1 ? 1 : 0;
                        remoteModuleProxy3.cmd(1, iArr3, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext3 /* 2131427532 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value12 = DataCanbus.DATA[81] & 255;
                        RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                        int[] iArr4 = new int[2];
                        iArr4[0] = 22;
                        iArr4[1] = value12 != 1 ? 1 : 0;
                        remoteModuleProxy4.cmd(1, iArr4, null, null);
                        break;
                    } else {
                        int value13 = DataCanbus.DATA[30] & 255;
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int[] iArr5 = new int[2];
                        iArr5[0] = 49;
                        iArr5[1] = value13 != 1 ? 1 : 0;
                        remoteModuleProxy5.cmd(1, iArr5, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext4 /* 2131427533 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value14 = DataCanbus.DATA[82] & 255;
                        RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                        int[] iArr6 = new int[2];
                        iArr6[0] = 23;
                        iArr6[1] = value14 != 1 ? 1 : 0;
                        remoteModuleProxy6.cmd(1, iArr6, null, null);
                        break;
                    } else {
                        int value15 = DataCanbus.DATA[31] & 255;
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int[] iArr7 = new int[2];
                        iArr7[0] = 50;
                        iArr7[1] = value15 != 1 ? 1 : 0;
                        remoteModuleProxy7.cmd(1, iArr7, null, null);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bsd_keleijia_set_fenweideng);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus2), this.mClickListener);
    }

    void checkAndSetListener(View v, View.OnClickListener clickListener) {
        if (v != null) {
            v.setOnClickListener(clickListener);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
            DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
            DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
            return;
        }
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].removeNotify(this.mNotifyCanbus);
        }
    }
}
