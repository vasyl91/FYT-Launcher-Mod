package com.syu.carinfo.honda;

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
public class Wc_16Civic_DoorActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 65535;
            switch (updateCode) {
                case 129:
                    Wc_16Civic_DoorActi.this.m65D13();
                    break;
                case 130:
                    Wc_16Civic_DoorActi.this.m65D11();
                    break;
                case 131:
                    Wc_16Civic_DoorActi.this.m65D10();
                    break;
                case 147:
                    Wc_16Civic_DoorActi.this.m65D16();
                    break;
                case 148:
                    Wc_16Civic_DoorActi.this.m65D14();
                    break;
                case 184:
                    int switchOn = value & 255;
                    if (switchOn == 1) {
                        ((TextView) Wc_16Civic_DoorActi.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                    } else {
                        ((TextView) Wc_16Civic_DoorActi.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                    }
                    break;
                case 185:
                    int switchOn2 = value & 255;
                    ((CheckedTextView) Wc_16Civic_DoorActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn2 == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_door);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(104, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(104, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[185] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(104, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[130] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(104, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[130] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(104, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] + 1;
                if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(104, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] + 1;
                if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(104, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[184] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(104, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_DoorActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[184] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(104, new int[]{7, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m65D13() {
        int temp = DataCanbus.DATA[129] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m65D11() {
        int temp = DataCanbus.DATA[130] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText("30 S");
                return;
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText("60 S");
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText("90 S");
            } else if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_playstate11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m65D10() {
        int temp = DataCanbus.DATA[131] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m65D16() {
        int value = DataCanbus.DATA[147];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.guandao_unlock1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.guandao_unlock2);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m65D14() {
        int value = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.guandao_lock2);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.guandao_lock1);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
            }
        }
    }
}
