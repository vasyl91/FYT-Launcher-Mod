package com.syu.carinfo.rzc.xp.cs75;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class ChangAnCS75Act extends BaseActivity {
    int C_SET = 131;
    int C_REMOTE_UNLOCK = 3;
    int C_DRIVE_LOCK = 4;
    int C_ACCOFF_UNLOCK = 5;
    int C_FRONTLIGHT_DELAY = 10;
    int C_ONEKEY_TRUN = 11;
    int C_BACKCAR_REAR_ASSIT = 2;
    int C_UNLOCK_VENTIALION = 7;
    int C_UNLOCK_OPENWINDOW = 8;
    int C_UNLOCK_AIR_PURIFY = 9;
    int C_PURNISH_RESET = 10;
    int C_RESETCARSET = 0;
    private int mMode = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    ChangAnCS75Act.this.mUpdateCurOilExpend();
                    break;
                case 1:
                    ChangAnCS75Act.this.mUpdateCurOptimalOilExpend();
                    break;
                case 2:
                    ChangAnCS75Act.this.mUpdaterDrivingMileage();
                    break;
                case 3:
                    ChangAnCS75Act.this.mUpdaterCurTripOilExpend();
                    break;
                case 23:
                    ChangAnCS75Act.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 24:
                    ChangAnCS75Act.this.mUpdaterValue8();
                    break;
                case 37:
                    ChangAnCS75Act.this.uRestoreCarSet(DataCanbus.DATA[updateCode]);
                    break;
                case 38:
                    ChangAnCS75Act.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 39:
                    ChangAnCS75Act.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 40:
                    ChangAnCS75Act.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 41:
                    ChangAnCS75Act.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 42:
                    ChangAnCS75Act.this.uCloseTopWindow(DataCanbus.DATA[updateCode]);
                    break;
                case 43:
                    ChangAnCS75Act.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 44:
                    ChangAnCS75Act.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 45:
                    ChangAnCS75Act.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 46:
                    ChangAnCS75Act.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 47:
                    ChangAnCS75Act.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 49:
                    ChangAnCS75Act.this.uYingBingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 50:
                    ChangAnCS75Act.this.uTishiVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 51:
                    ChangAnCS75Act.this.uBaojingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 52:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_part_autounlock)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 53:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_air_autoclear)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 54:
                    ChangAnCS75Act.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 55:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_window_light)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 56:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_window_yaokong)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 57:
                    ChangAnCS75Act.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 58:
                    ChangAnCS75Act.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzcxp_cs75);
        setupView();
        if (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
            this.C_SET = 136;
            this.C_REMOTE_UNLOCK = 0;
            this.C_DRIVE_LOCK = 1;
            this.C_ACCOFF_UNLOCK = 2;
            this.C_FRONTLIGHT_DELAY = 3;
            this.C_ONEKEY_TRUN = 4;
            this.C_BACKCAR_REAR_ASSIT = 6;
            this.C_UNLOCK_VENTIALION = 7;
            this.C_UNLOCK_OPENWINDOW = 8;
            this.C_UNLOCK_AIR_PURIFY = 9;
            this.C_PURNISH_RESET = 10;
            this.C_RESETCARSET = 255;
        }
    }

    private void setupView() {
        setSelfClick((CheckedTextView) findViewById(R.id.rzc_cs75_ctv_maintain_reminders), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int oilReminder = DataCanbus.DATA[1];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = oilReminder != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[24] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(3, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_bk_left)) != null) {
            ((Button) findViewById(R.id.cs75_btn_bk_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.setMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_bk_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_bk_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.5
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.setMode(-1);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[23];
                    if (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int[] iArr = new int[2];
                        iArr[0] = 2;
                        iArr[1] = i != 1 ? 1 : 0;
                        remoteModuleProxy.cmd(1, iArr, null, null);
                        return;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, 1, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_yingbingvol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_yingbingvol_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[49] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_yingbingvol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_yingbingvol_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[49] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_tishivol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_tishivol_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[50] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_tishivol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_tishivol_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[50] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_baojingvol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_baojingvol_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[51] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_baojingvol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_baojingvol_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.12
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[51] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[52];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 16, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[53];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 17, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_window_delaytime_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_window_delaytime_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[54] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_windeow_delaytime_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_windeow_delaytime_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[54] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[55];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 19, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.18
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[56];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 20, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_dianlabavol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_dianlabavol_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[57] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_dianlabavol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_dianlabavol_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[57] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_unlockrecv_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_unlockrecv_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[58] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_unlockrecv_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_unlockrecv_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[58] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.23
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ChangAnCS75Act.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        bindViewOnClick(R.id.rzc_cs55_maintenance_information, new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChangAnCS75Act.this.maintenanceCarSetDialog();
            }
        });
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[38];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_BACKCAR_REAR_ASSIT, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[39];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_REMOTE_UNLOCK, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.27
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[40];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_DRIVE_LOCK, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[41];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_ACCOFF_UNLOCK, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[42];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, 6, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.30
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[43];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_UNLOCK_VENTIALION, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.31
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[44];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_UNLOCK_OPENWINDOW, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.32
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[45];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_UNLOCK_AIR_PURIFY, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.cs55_btn_light_forntdelay_left)) != null) {
            ((Button) findViewById(R.id.cs55_btn_light_forntdelay_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.33
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_light_forntdelay_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_light_forntdelay_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.34
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs55_btn_light_onekeyturn_left)) != null) {
            ((Button) findViewById(R.id.cs55_btn_light_onekeyturn_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.35
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_light_onekeyturn_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_light_onekeyturn_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.36
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.OnekeyturnMode(1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[24] & 255;
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[47];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 3) {
            temp++;
        }
        DataCanbus.PROXY.cmd(2, new int[]{this.C_SET, this.C_ONEKEY_TRUN, temp}, null, null);
    }

    protected void FrontLightDelayMode(int i) {
        int temp = DataCanbus.DATA[46];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 4) {
            temp++;
        }
        DataCanbus.PROXY.cmd(2, new int[]{this.C_SET, this.C_FRONTLIGHT_DELAY, temp}, null, null);
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.37
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_RESETCARSET}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_RESETCARSET, 1}, null, null);
                }
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.38
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void maintenanceCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_other_set_Maintenance_Reset);
        normalDialog.setMessage(R.string.str_other_set_Maintenance_Reset);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.39
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_PURNISH_RESET}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.40
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    public void viewSetOnOff(boolean value) {
        setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_restore_carset_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_back_rainassist_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_remote_unlock_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_drive_lock_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_accoff_lock_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_airset_unlock_autoair_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_airset_airauto_dry_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_light_forntdelay_view), value);
        setViewVisible(findViewById(R.id.rzc_cs55_light_onekeyturn_view), value);
    }

    public void viewSet2OnOff(boolean value) {
        setViewVisible(findViewById(R.id.rzc_yidong_window_delaytime_view), value);
        setViewVisible(findViewById(R.id.rzc_yidong_dianlabavol_view), value);
        setViewVisible(findViewById(R.id.rzc_yidong_unlockrecv_view), value);
        setViewVisible(findViewById(R.id.rzc_yidong_part_autounlock_view), value);
        setViewVisible(findViewById(R.id.rzc_yidong_window_light_view), value);
        setViewVisible(findViewById(R.id.rzc_yidong_window_yaokong_view), value);
        if (value) {
            setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow_view), false);
            setViewVisible(bindViewOnClick(R.id.rzc_xp_cs75_tv_oil_signal_view, null), false);
            setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), false);
            setViewVisible(bindViewOnClick(R.id.rzc_cs75_ctv_maintain_reminders_view, null), false);
        }
        setViewVisible(findViewById(R.id.rzc_yidong_air_autoclear_view), false);
        setViewVisible(findViewById(R.id.rzc_yidong_yingbingvol_view), false);
        setViewVisible(findViewById(R.id.rzc_yidong_tishivol_view), false);
        setViewVisible(findViewById(R.id.rzc_yidong_baojing_view), false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.carId == 1) {
            DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
            if (findViewById(R.id.rzc_cs75_foldrearmirror_view) != null) {
                viewSetOnOff(false);
                viewSet2OnOff(false);
                setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), true);
            }
        } else if (DataCanbus.DATA[1000] == 327750 || DataCanbus.DATA[1000] == 1704006 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 786502 || DataCanbus.DATA[1000] == 720966 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
            viewSetOnOff(true);
            viewSet2OnOff(false);
            DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
            if (DataCanbus.DATA[1000] == 720966 || DataCanbus.DATA[1000] == 786502) {
                viewSet2OnOff(true);
                setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), false);
                DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
            }
        } else {
            setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), false);
            viewSetOnOff(false);
            viewSet2OnOff(false);
        }
        if (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862 || DataCanbus.DATA[1000] == 917574) {
            DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
            setViewVisible(bindViewOnClick(R.id.rzc_cs75_ctv_maintain_reminders_view, null), true);
            setViewVisible(bindViewOnClick(R.id.rzc_xp_cs75_tv_oil_signal_view, null), false);
            setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow_view), false);
            setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), true);
            if (DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 917574) {
                setViewVisible(bindViewOnClick(R.id.rzc_cs55_maintenance_information_view, null), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedValue(int i) {
        return (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) ? i == 1 ? 0 : 1 : i == 1 ? 2 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.carId == 1) {
            DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
            return;
        }
        if (DataCanbus.carId == 5 || DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 786502 || DataCanbus.DATA[1000] == 720966) {
            DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
            if (DataCanbus.DATA[1000] == 720966 || DataCanbus.DATA[1000] == 786502) {
                DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)) != null) {
            int value = DataCanbus.DATA[3];
            if (value == 0) {
                ((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)).setText(R.string.str_oil_signal_normal);
            } else {
                ((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)).setText(R.string.str_oil_signal_low);
            }
        }
    }

    protected void uYingBingVolset(int i) {
        ((TextView) findViewById(R.id.rzc_yidong_yingbingvol)).setText("声音" + i);
    }

    protected void uTishiVolset(int i) {
        ((TextView) findViewById(R.id.rzc_yidong_tishivol)).setText("声音" + i);
    }

    protected void uBaojingVolset(int i) {
        ((TextView) findViewById(R.id.rzc_yidong_baojingvol)).setText("声音" + i);
    }

    protected void uWinDelayTimeset(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.rzc_yidong_window_delaytime)).setText("关闭");
                break;
            case 1:
                ((TextView) findViewById(R.id.rzc_yidong_window_delaytime)).setText("30秒");
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_yidong_window_delaytime)).setText("60秒");
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_yidong_window_delaytime)).setText("90秒");
                break;
            case 4:
                ((TextView) findViewById(R.id.rzc_yidong_window_delaytime)).setText("120秒");
                break;
        }
    }

    protected void uDianlabaVolset(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.rzc_yidong_dianlabavol)).setText("寻车和门未关闭锁");
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_yidong_dianlabavol)).setText("寻车");
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_yidong_dianlabavol)).setText("门未关闭锁");
                break;
        }
    }

    protected void uUnlockrecvset(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.rzc_yidong_unlockrecv)).setText("灯光+声音");
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_yidong_unlockrecv)).setText("灯光");
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_yidong_unlockrecv)).setText("声音");
                break;
        }
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.rzc_cs55_light_onekeyturn)).setText("3 times");
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_cs55_light_onekeyturn)).setText("5 times");
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_cs55_light_onekeyturn)).setText("7 times");
                break;
            default:
                ((TextView) findViewById(R.id.rzc_cs55_light_onekeyturn)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.rzc_cs55_light_forntdelay)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_cs55_light_forntdelay)).setText("30s");
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_cs55_light_forntdelay)).setText("60s");
                break;
            case 4:
                ((TextView) findViewById(R.id.rzc_cs55_light_forntdelay)).setText("120s");
                break;
            default:
                ((TextView) findViewById(R.id.rzc_cs55_light_forntdelay)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uAirAutoDry(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)).setChecked(i == 1);
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)).setChecked(i == 1);
        }
    }

    protected void uCloseTopWindow(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)).setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)).setChecked(i == 1);
        }
    }

    protected void uRestoreCarSet(int i) {
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)).setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[2];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)).setText(String.valueOf(str) + " KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        this.mMode = DataCanbus.DATA[0];
        showModeState(this.mMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOptimalOilExpend() {
        int oilReminder = DataCanbus.DATA[1];
        setCheck((CheckedTextView) findViewById(R.id.rzc_cs75_ctv_maintain_reminders), oilReminder == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(int mode) {
        this.mMode += mode;
        if (this.mMode <= 0) {
            this.mMode = 3;
        } else if (this.mMode > 3) {
            this.mMode = 1;
        }
        DataCanbus.PROXY.cmd(0, new int[]{this.mMode}, null, null);
        showModeState(this.mMode);
    }

    private void showModeState(int mode) {
        if (((TextView) findViewById(R.id.cs75_tv_bk)) != null) {
            switch (mode) {
                case 1:
                    ((TextView) findViewById(R.id.cs75_tv_bk)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.cs75_tv_bk)).setText(R.string.str_mode_paraller);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.cs75_tv_bk)).setText(R.string.str_mode_close);
                    break;
            }
        }
    }
}
