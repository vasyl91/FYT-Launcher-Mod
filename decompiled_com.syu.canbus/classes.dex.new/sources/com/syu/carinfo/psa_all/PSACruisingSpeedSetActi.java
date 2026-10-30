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
public class PSACruisingSpeedSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    PSACruisingSpeedSetActi.this.mUpdaterValue71();
                    break;
                case 154:
                    PSACruisingSpeedSetActi.this.mUpdaterValue72();
                    break;
                case 155:
                    PSACruisingSpeedSetActi.this.mUpdaterValue73();
                    break;
                case 156:
                    PSACruisingSpeedSetActi.this.mUpdaterValue74();
                    break;
                case 157:
                    PSACruisingSpeedSetActi.this.mUpdaterValue75();
                    break;
                case 158:
                    PSACruisingSpeedSetActi.this.mUpdaterValue76();
                    break;
                case 159:
                    PSACruisingSpeedSetActi.this.mUpdaterValue77();
                    break;
                case 160:
                    PSACruisingSpeedSetActi.this.mUpdaterValue78();
                    break;
                case 161:
                    PSACruisingSpeedSetActi.this.mUpdaterValue79();
                    break;
                case 162:
                    PSACruisingSpeedSetActi.this.mUpdaterValue80();
                    break;
                case 163:
                    PSACruisingSpeedSetActi.this.mUpdaterValue81();
                    break;
                case 164:
                    PSACruisingSpeedSetActi.this.mUpdaterValue82();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa_all_cruising_speed_set);
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(74, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[154];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(76, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[155];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(78, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[156];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(80, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[157];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(82, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[158];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(84, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(75, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(75, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(77, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(77, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[161] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(79, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[161] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(79, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[162] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(81, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[162] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(81, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(83, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(83, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[164] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(85, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSACruisingSpeedSetActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[164] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(85, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue71() {
        int value = DataCanbus.DATA[153];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue72() {
        int value = DataCanbus.DATA[154];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue73() {
        int value = DataCanbus.DATA[155];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue74() {
        int value = DataCanbus.DATA[156];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue75() {
        int value = DataCanbus.DATA[157];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue76() {
        int value = DataCanbus.DATA[158];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue77() {
        int value = DataCanbus.DATA[159];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue78() {
        int value = DataCanbus.DATA[160];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue79() {
        int value = DataCanbus.DATA[161];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue80() {
        int value = DataCanbus.DATA[162];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue81() {
        int value = DataCanbus.DATA[163];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue82() {
        int value = DataCanbus.DATA[164];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
