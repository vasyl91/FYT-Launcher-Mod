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
public class Wc_372_SafeyActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    Wc_372_SafeyActi.this.m43d36();
                    break;
                case 2:
                    Wc_372_SafeyActi.this.m43d34();
                    break;
                case 3:
                    Wc_372_SafeyActi.this.m43d32();
                    break;
                case 4:
                    Wc_372_SafeyActi.this.m43d31();
                    break;
                case 5:
                    Wc_372_SafeyActi.this.m43d30();
                    break;
                case 6:
                    Wc_372_SafeyActi.this.m43d47();
                    break;
                case 7:
                    Wc_372_SafeyActi.this.m43d46();
                    break;
                case 8:
                    Wc_372_SafeyActi.this.m43d45();
                    break;
                case 9:
                    Wc_372_SafeyActi.this.m43d43();
                    break;
                case 10:
                    Wc_372_SafeyActi.this.m43d42();
                    break;
                case 11:
                    Wc_372_SafeyActi.this.m43d40();
                    break;
                case 12:
                    Wc_372_SafeyActi.this.m43d56();
                    break;
                case 13:
                    Wc_372_SafeyActi.this.m43d55();
                    break;
                case 14:
                    Wc_372_SafeyActi.this.m43d54();
                    break;
                case 15:
                    Wc_372_SafeyActi.this.m43d52();
                    break;
                case 16:
                    Wc_372_SafeyActi.this.m43d50();
                    break;
                case 94:
                    Wc_372_SafeyActi.this.m43d44();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_safetyassist);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.jeep_parksense_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[1] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_parksense_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[1] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_view_lanedev_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[2] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_view_lanedev_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[2] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lanewar_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[3] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lanewar_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[3] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brak)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brakwarring)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[5] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.jeep_auto_park_brake)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[6] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.jeep_hill_start_assist)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[7] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 11;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_rainauto)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[8] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_video_move)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[9] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_video_static)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[10] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_blindwarring_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_blindwarring_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_autoserve_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[12] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_autoserve_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[12] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_parksystem)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[13] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 16;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_parksensebreak)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 15;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_frontsensevo_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[16] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_frontsensevo_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[16] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_backsensevol_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[15] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_backsensevol_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[15] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_parkingimagedelay)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_SafeyActi.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[94] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d36() {
        int temp = DataCanbus.DATA[1] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_assist).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.jeep_parksense_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.jeep_parksense_set_show)).setText(R.string.jeep_parksense_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.jeep_parksense_set_show)).setText(R.string.jeep_parksense_0);
            }
        }
    }

    protected void m43d44() {
        int temp = DataCanbus.DATA[94] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_parkingimagedelay).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_parkingimagedelay)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d34() {
        int temp = DataCanbus.DATA[2] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lanedev).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)).setText(R.string.wc_372_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)).setText(R.string.wc_372_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d32() {
        int temp = DataCanbus.DATA[3] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lanewar).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_lanewar_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_lanewar_set_show)).setText(R.string.jeep_lanesensewarn_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_lanewar_set_show)).setText(R.string.jeep_lanesensewarn_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_lanewar_set_show)).setText(R.string.jeep_lanesensewarn_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d31() {
        int temp = DataCanbus.DATA[4] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_crash_brak).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brak)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d30() {
        int temp = DataCanbus.DATA[5] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_crash_brakwarring).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brakwarring)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d47() {
        int temp = DataCanbus.DATA[6] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_auto_park_brake).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.jeep_auto_park_brake)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d46() {
        int temp = DataCanbus.DATA[7] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_jeep_hill_start_assist).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.jeep_hill_start_assist)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d45() {
        int temp = DataCanbus.DATA[8] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_rainauto).setVisibility(enable != 0 ? 0 : 8);
        ((CheckedTextView) findViewById(R.id.wc_372_rainauto)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d43() {
        int temp = DataCanbus.DATA[9] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_video_move).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_video_move)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d42() {
        int temp = DataCanbus.DATA[10] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_video_static).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_video_static)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d40() {
        int temp = DataCanbus.DATA[11] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_blindwarring).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_blindwarring_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_blindwarring_set_show)).setText(R.string.jeep_blindwarn_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_blindwarring_set_show)).setText(R.string.jeep_blindwarn_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_blindwarring_set_show)).setText(R.string.jeep_blindwarn_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d56() {
        int temp = DataCanbus.DATA[12] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_autoserve).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_autoserve_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_autoserve_set_show)).setText(R.string.jeep_comfortsystems_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_autoserve_set_show)).setText(R.string.jeep_comfortsystems_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_autoserve_set_show)).setText(R.string.jeep_comfortsystems_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d55() {
        int temp = DataCanbus.DATA[13] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_parksystem).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_parksystem)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d54() {
        int temp = DataCanbus.DATA[14] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_parksensebreak).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_parksensebreak)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d52() {
        int temp = DataCanbus.DATA[15] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_backsensevol).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_backsensevol_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_backsensevol_set_show)).setText(R.string.wc_372_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_backsensevol_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_backsensevol_set_show)).setText(R.string.wc_372_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m43d50() {
        int temp = DataCanbus.DATA[16] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_frontsensevol).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)).setText(R.string.wc_372_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)).setText(R.string.wc_372_low);
            }
        }
    }
}
