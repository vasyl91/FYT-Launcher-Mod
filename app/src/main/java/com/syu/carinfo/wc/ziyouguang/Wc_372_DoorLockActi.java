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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_372_DoorLockActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                    Wc_372_DoorLockActi.this.m60d14();
                    break;
                case 30:
                    Wc_372_DoorLockActi.this.m60d13();
                    break;
                case 31:
                    Wc_372_DoorLockActi.this.m60d12();
                    break;
                case 32:
                    Wc_372_DoorLockActi.this.m60D11();
                    break;
                case 33:
                    Wc_372_DoorLockActi.this.m60D10();
                    break;
                case 88:
                    Wc_372_DoorLockActi.this.m60d15();
                    break;
                case 95:
                    Wc_372_DoorLockActi.this.m60d17();
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
        ((CheckedTextView) findViewById(R.id.wc_372_dorrwarring)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[29] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_nokeyenter)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[30] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_firsttimeunlock_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[31] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_firsttimeunlock_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[31] & 255;
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_offautolock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_autolock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lock_voice_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[88] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lock_voice_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[88] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_remotestartsound)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DoorLockActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[95] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
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
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d15() {
        int temp = DataCanbus.DATA[88] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lock_voice).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_lock_voice_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_lock_voice_set_show)).setText("OFF");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_lock_voice_set_show)).setText(String.format("1" + getString(R.string.str_372_press1), new Object[0]));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_lock_voice_set_show)).setText(String.format("2" + getString(R.string.str_372_press2), new Object[0]));
            }
        }
    }

    protected void m60d17() {
        int temp = DataCanbus.DATA[95] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_remotestartsound).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_remotestartsound)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d14() {
        int temp = DataCanbus.DATA[29] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_dorrwarring).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_dorrwarring)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d13() {
        int temp = DataCanbus.DATA[30] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_nokeyenter).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_nokeyenter)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60d12() {
        int temp = DataCanbus.DATA[31] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_firsttimeunlock).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_firsttimeunlock_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_firsttimeunlock_set_show)).setText(R.string.klc_lock_manual_Only_the_driver_door_unlocks);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_firsttimeunlock_set_show)).setText(R.string.klc_lock_manual_All_doors_unlock);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60D11() {
        int temp = DataCanbus.DATA[32] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_offautolock).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_offautolock)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m60D10() {
        int temp = DataCanbus.DATA[33] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_autolock).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_autolock)).setChecked(switchOn == 1);
    }
}
