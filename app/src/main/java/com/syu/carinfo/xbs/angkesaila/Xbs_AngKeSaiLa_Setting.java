package com.syu.carinfo.xbs.angkesaila;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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
public class Xbs_AngKeSaiLa_Setting extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("LG", "MupdateCode::" + updateCode);
            switch (updateCode) {
                case 59:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D07();
                    break;
                case 60:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D04();
                    break;
                case 61:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D02();
                    break;
                case 62:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D00();
                    break;
                case 63:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D17();
                    break;
                case 64:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D16();
                    break;
                case 65:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D15();
                    break;
                case 66:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D14();
                    break;
                case 67:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D12();
                    break;
                case 68:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D10();
                    break;
                case 69:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D27();
                    break;
                case 70:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D26();
                    break;
                case 71:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D25();
                    break;
                case 72:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D24();
                    break;
                case 73:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D23();
                    break;
                case 74:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D22();
                    break;
                case 75:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D20();
                    break;
                case 76:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D36();
                    break;
                case 77:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D33();
                    break;
                case 78:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D30();
                    break;
                case 79:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D40();
                    break;
                case 80:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D50();
                    break;
                case 81:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D60();
                    break;
                case 88:
                    Xbs_AngKeSaiLa_Setting.this.mSetting_09D77();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_418_xbs_angkesaila);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.jeep_rain_sense_wipers)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[59];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_nokey_enter_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[61];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_nokey_enter_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[61];
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_autolock_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[60];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_autolock_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[60];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_relock_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[62];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_relock_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[62];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_unlock_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[63];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_unlock_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[63];
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_leave_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[64];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_flash_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[65];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_turn_sign_vol_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[66];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_turn_sign_vol_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[66];
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_open_light_off_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[67];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_open_light_off_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[67];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_close_light_off_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[68];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_close_light_off_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[68];
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_light_system)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[69];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_bright_con_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[70];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_bright_con_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[70];
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_drive_dis)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[71];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 17;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_drive_nav)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[72];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 18;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_smart_break)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[73];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 20;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_eco_sync)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[74];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 22;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_blind_vol_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[75];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_blind_vol_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[75];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_no_release_remind_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[76];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_no_release_remind_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[76];
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_light_off_time_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[77];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_light_off_time_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[77];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_auto_light_open_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[78];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_auto_light_open_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[78];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_high_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[79];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_high_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[79];
                if (value2 < 26) {
                    value = value2 + 1;
                } else {
                    value = 26;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_bright_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[80];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_drive_bright_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[80];
                if (value2 < 40) {
                    value = value2 + 1;
                } else {
                    value = 40;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_dirve_cal_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[81];
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xbs_dirve_cal_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[81];
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_functional_factory_eco)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Xbs_AngKeSaiLa_Setting.this.dialog(R.string.str_418_reset_eco, 23);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_leaving_home)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[88];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 48;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xbs_functional_factory_all_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Xbs_AngKeSaiLa_Setting.this.dialog(R.string.all_settings, 24);
            }
        });
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.43
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_Setting.44
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D07() {
        int value = DataCanbus.DATA[59];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.jeep_rain_sense_wipers)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D04() {
        int value = DataCanbus.DATA[60];
        if (((TextView) findViewById(R.id.xbs_autolock_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock2);
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock3);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.str_418_relock4);
            } else {
                ((TextView) findViewById(R.id.xbs_autolock_set_show)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D02() {
        int value = DataCanbus.DATA[61];
        if (((TextView) findViewById(R.id.xbs_nokey_enter_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_low);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_high);
            } else {
                ((TextView) findViewById(R.id.xbs_nokey_enter_set_show)).setText(R.string.wc_372_volumestr0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D00() {
        int value = DataCanbus.DATA[62];
        if (((TextView) findViewById(R.id.xbs_relock_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_relock_set_show)).setText("60S");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_relock_set_show)).setText("90S");
            } else {
                ((TextView) findViewById(R.id.xbs_relock_set_show)).setText("30S");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D17() {
        int value = DataCanbus.DATA[63];
        if (((TextView) findViewById(R.id.xbs_unlock_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_unlock_set_show)).setText(R.string.str_418_unlock2);
            } else {
                ((TextView) findViewById(R.id.xbs_unlock_set_show)).setText(R.string.str_418_unlock1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D16() {
        int value = DataCanbus.DATA[64];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_leave_lock)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D15() {
        int value = DataCanbus.DATA[65];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_flash_light)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D14() {
        int value = DataCanbus.DATA[66];
        if (((TextView) findViewById(R.id.xbs_turn_sign_vol_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_turn_sign_vol_set_show)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.xbs_turn_sign_vol_set_show)).setText(R.string.klc_air_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D12() {
        int value = DataCanbus.DATA[67];
        if (((TextView) findViewById(R.id.xbs_open_light_off_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_open_light_off_set_show)).setText("30Min");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_open_light_off_set_show)).setText("60Min");
            } else {
                ((TextView) findViewById(R.id.xbs_open_light_off_set_show)).setText("10Min");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D10() {
        int value = DataCanbus.DATA[68];
        if (((TextView) findViewById(R.id.xbs_close_light_off_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("15 S");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("30 S");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("60 S");
            } else {
                ((TextView) findViewById(R.id.xbs_close_light_off_set_show)).setText("7.5 S");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D27() {
        int value = DataCanbus.DATA[69];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_light_system)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D26() {
        int value = DataCanbus.DATA[70];
        if (((TextView) findViewById(R.id.xbs_bright_con_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_bright_con_set_show)).setText(R.string.klc_air_Manual);
            } else {
                ((TextView) findViewById(R.id.xbs_bright_con_set_show)).setText(R.string.klc_air_auto);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D25() {
        int value = DataCanbus.DATA[71];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_drive_dis)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D24() {
        int value = DataCanbus.DATA[72];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_drive_nav)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D23() {
        int value = DataCanbus.DATA[73];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_smart_break)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D22() {
        int value = DataCanbus.DATA[74];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_eco_sync)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D20() {
        int value = DataCanbus.DATA[75];
        if (((TextView) findViewById(R.id.xbs_blind_vol_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_blind_vol_set_show)).setText(R.string.klc_air_low);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_blind_vol_set_show)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.xbs_blind_vol_set_show)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D36() {
        int value = DataCanbus.DATA[76];
        if (((TextView) findViewById(R.id.xbs_no_release_remind_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_no_release_remind_set_show)).setText(R.string.klc_air_low);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.xbs_no_release_remind_set_show)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.xbs_no_release_remind_set_show)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D33() {
        int value = DataCanbus.DATA[77];
        if (((TextView) findViewById(R.id.xbs_light_off_time_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("30 S");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("60 S");
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("90 S");
            } else if (value == 4) {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText("120 S");
            } else {
                ((TextView) findViewById(R.id.xbs_light_off_time_set_show)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D30() {
        int value = DataCanbus.DATA[78];
        if (((TextView) findViewById(R.id.xbs_auto_light_open_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_3);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_wc_mzd_cx5_auto_headlight_on_1);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.xbs_auto_light_open_set_show)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D40() {
        int value = DataCanbus.DATA[79] & 255;
        int value2 = value - 13;
        if (((TextView) findViewById(R.id.xbs_drive_high_set_show)) != null) {
            ((TextView) findViewById(R.id.xbs_drive_high_set_show)).setText(new StringBuilder().append(value2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D50() {
        int value = DataCanbus.DATA[80] & 255;
        int value2 = value - 20;
        if (((TextView) findViewById(R.id.xbs_drive_bright_set_show)) != null) {
            ((TextView) findViewById(R.id.xbs_drive_bright_set_show)).setText(new StringBuilder().append(value2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D60() {
        int value = DataCanbus.DATA[81] & 255;
        int value2 = value - 2;
        if (((TextView) findViewById(R.id.xbs_dirve_cal_set_show)) != null) {
            ((TextView) findViewById(R.id.xbs_dirve_cal_set_show)).setText(new StringBuilder().append(value2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetting_09D77() {
        int value = DataCanbus.DATA[88];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.xbs_leaving_home)).setChecked(switchOn != 0);
    }
}
