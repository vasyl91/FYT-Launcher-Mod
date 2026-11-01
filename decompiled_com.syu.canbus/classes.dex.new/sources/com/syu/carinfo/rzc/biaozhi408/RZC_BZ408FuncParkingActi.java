package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408FuncParkingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue3();
                    break;
                case 126:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue4();
                    break;
                case 167:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue1();
                    break;
                case 168:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue2();
                    break;
                case 171:
                    RZC_BZ408FuncParkingActi.this.mUpdaterValue5();
                    break;
                case 181:
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    }
                    break;
                case 182:
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    }
                    break;
                case 183:
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    }
                    break;
                case 184:
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    }
                    break;
                case 185:
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    }
                    break;
                case 258:
                    if (((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) RZC_BZ408FuncParkingActi.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                    }
                    break;
            }
        }
    };
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext6 /* 2131427581 */:
                    int value = DataCanbus.DATA[182];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(73, iArr, null, null);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427582 */:
                    int value2 = DataCanbus.DATA[183];
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[1];
                    iArr2[0] = value2 != 0 ? 0 : 1;
                    remoteModuleProxy2.cmd(74, iArr2, null, null);
                    break;
                case R.id.ctv_checkedtext9 /* 2131427634 */:
                    int value3 = DataCanbus.DATA[184];
                    RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                    int[] iArr3 = new int[1];
                    iArr3[0] = value3 != 0 ? 0 : 1;
                    remoteModuleProxy3.cmd(76, iArr3, null, null);
                    break;
                case R.id.ctv_checkedtext10 /* 2131427635 */:
                    int value4 = DataCanbus.DATA[185];
                    RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                    int[] iArr4 = new int[1];
                    iArr4[0] = value4 != 0 ? 0 : 1;
                    remoteModuleProxy4.cmd(77, iArr4, null, null);
                    break;
                case R.id.ctv_checkedtext11 /* 2131427636 */:
                    int value5 = DataCanbus.DATA[181];
                    RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                    int[] iArr5 = new int[1];
                    iArr5[0] = value5 != 0 ? 0 : 1;
                    remoteModuleProxy5.cmd(78, iArr5, null, null);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_func_parking);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[167];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int bit60;
                int bit61 = DataCanbus.DATA[168];
                int bit7 = DataCanbus.DATA[258];
                if (bit61 == 1) {
                    bit60 = 0;
                } else {
                    bit60 = 1;
                }
                int value = ((bit7 << 7) & 128) | (bit60 & 127);
                DataCanbus.PROXY.cmd(18, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int bit7;
                int bit60 = DataCanbus.DATA[168];
                int bit8 = DataCanbus.DATA[258];
                if (bit8 == 1) {
                    bit7 = 0;
                } else {
                    bit7 = 1;
                }
                int value = ((bit7 << 7) & 128) | (bit60 & 127);
                DataCanbus.PROXY.cmd(18, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(19, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[126];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(20, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncParkingActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[171];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(27, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this.mClick);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this.mClick);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        for (int i = 181; i < 298; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        for (int i = 181; i < 298; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[167];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[168];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[126];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(value != 0 ? R.string.xp_psa_all_string_door_open_1 : R.string.xp_psa_all_string_door_open_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[171];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }
}
