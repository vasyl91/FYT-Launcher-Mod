package com.syu.carinfo.biaozhi408;

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
public class BZ408SpeedLimitSetActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 23:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue7();
                    break;
                case 24:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue8();
                    break;
                case 25:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue9();
                    break;
                case 26:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue10();
                    break;
                case 27:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue11();
                    break;
                case 28:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue12();
                    break;
                case 36:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue1();
                    break;
                case 37:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue2();
                    break;
                case 38:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue3();
                    break;
                case 39:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue4();
                    break;
                case 40:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue5();
                    break;
                case 41:
                    BZ408SpeedLimitSetActi.this.mUpdaterValue6();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_biaozhi408_speed_limit_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[36];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[37];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(26, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[38];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(28, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[39];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(30, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[40];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(32, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[41];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(34, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_1_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_1_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_2_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_2_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[24] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(27, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_3_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[25] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_3_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[25] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_4_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_4_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_5_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_5_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(33, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_6_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.bz408_btn_limit_speed_6_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408SpeedLimitSetActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] + 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(35, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(53, new int[]{61}, null, null);
            findViewById(R.id.bz408_view_speed_limit_speed_1).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_2).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_3).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_4).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_5).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_6).setVisibility(8);
        } else {
            findViewById(R.id.bz408_view_speed_limit_speed_1).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_2).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_3).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_4).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_5).setVisibility(8);
            findViewById(R.id.bz408_view_speed_limit_speed_6).setVisibility(8);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[36];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_1)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[37];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_2)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[38];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_3)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[39];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_4)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[40];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_5)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[41];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_6)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_speed_6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_1_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_1_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_2_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_2_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_3_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_3_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_4_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_4_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_5_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_5_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.bz408_tv_limit_speed_6_set)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_limit_speed_6_set)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
