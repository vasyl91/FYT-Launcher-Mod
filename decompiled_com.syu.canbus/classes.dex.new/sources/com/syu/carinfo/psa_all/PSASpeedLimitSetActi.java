package com.syu.carinfo.psa_all;

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
public class PSASpeedLimitSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 139:
                    PSASpeedLimitSetActi.this.mUpdaterValue101();
                case 140:
                    PSASpeedLimitSetActi.this.mUpdaterValue102();
                case 141:
                    PSASpeedLimitSetActi.this.mUpdaterValue103();
                case 142:
                    PSASpeedLimitSetActi.this.mUpdaterValue104();
                case 143:
                    PSASpeedLimitSetActi.this.mUpdaterValue105();
                case 144:
                    PSASpeedLimitSetActi.this.mUpdaterValue106();
                case 145:
                    PSASpeedLimitSetActi.this.mUpdaterValue107();
                case 146:
                    PSASpeedLimitSetActi.this.mUpdaterValue108();
                case 147:
                    PSASpeedLimitSetActi.this.mUpdaterValue109();
                case 148:
                    PSASpeedLimitSetActi.this.mUpdaterValue110();
                case 149:
                    PSASpeedLimitSetActi.this.mUpdaterValue111();
                case 150:
                    PSASpeedLimitSetActi.this.mUpdaterValue112();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa_all_speed_limit_set);
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[139];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(61, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[140];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(63, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(65, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[142];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(67, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[143];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(69, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[144];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(71, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[145] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(62, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[145] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(62, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[146] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(64, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[146] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(64, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(66, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(66, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(68, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(68, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[149] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(70, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[149] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(70, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[150] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(72, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSASpeedLimitSetActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[150] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(72, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue101() {
        int value = DataCanbus.DATA[139];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue102() {
        int value = DataCanbus.DATA[140];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue103() {
        int value = DataCanbus.DATA[141];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue104() {
        int value = DataCanbus.DATA[142];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue105() {
        int value = DataCanbus.DATA[143];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue106() {
        int value = DataCanbus.DATA[144];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue107() {
        int value = DataCanbus.DATA[145];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue108() {
        int value = DataCanbus.DATA[146];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue109() {
        int value = DataCanbus.DATA[147];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue110() {
        int value = DataCanbus.DATA[148];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue111() {
        int value = DataCanbus.DATA[149];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue112() {
        int value = DataCanbus.DATA[150];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
