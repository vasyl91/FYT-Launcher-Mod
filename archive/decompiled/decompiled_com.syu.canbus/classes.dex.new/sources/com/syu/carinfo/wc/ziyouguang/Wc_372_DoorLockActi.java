package com.syu.carinfo.wc.ziyouguang;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_DoorLockActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    Wc_372_DoorLockActi.this.m60d14();
                    break;
                case 127:
                    Wc_372_DoorLockActi.this.m60d13();
                    break;
                case 128:
                    Wc_372_DoorLockActi.this.m60d12();
                    break;
                case 129:
                    Wc_372_DoorLockActi.this.m60D11();
                    break;
                case 130:
                    Wc_372_DoorLockActi.this.m60D10();
                    break;
                case 157:
                    Wc_372_DoorLockActi.this.m60d15();
                    break;
                case 163:
                    Wc_372_DoorLockActi.this.m60d17();
                    break;
                case 218:
                    ((CheckedTextView) Wc_372_DoorLockActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_doorlock);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128] & 255;
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[157] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[157] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[218] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d15() {
        int temp = DataCanbus.DATA[157] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view6).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText("OFF");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.format("1" + getString(R.string.str_372_press1), new Object[0]));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.format("2" + getString(R.string.str_372_press2), new Object[0]));
            }
        }
    }

    protected void m60d17() {
        int temp = DataCanbus.DATA[163] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view7).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d14() {
        int temp = DataCanbus.DATA[126] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view1).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d13() {
        int temp = DataCanbus.DATA[127] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view2).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d12() {
        int temp = DataCanbus.DATA[128] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view3).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_lock_manual_Only_the_driver_door_unlocks);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_lock_manual_All_doors_unlock);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60D11() {
        int temp = DataCanbus.DATA[129] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view4).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60D10() {
        int temp = DataCanbus.DATA[130] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view5).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
    }
}
