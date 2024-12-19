package com.syu.carinfo.rzc.changan;

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
public class RzcChanganAllSetAct extends BaseActivity {
    TextView TvBaojingVolSet;
    TextView TvDianlabaVolSet;
    TextView TvTishiVolSet;
    TextView TvUnlockrecvSet;
    TextView TvWinDelayTimeSet;
    TextView TvYingBingVolSet;
    CheckedTextView btnAccOffLock;
    CheckedTextView btnAirAutoClearSet;
    CheckedTextView btnAirAutoDry;
    CheckedTextView btnAtmosphereLightSet;
    CheckedTextView btnBackRainAssist;
    CheckedTextView btnBluetoothBlowDownSet;
    CheckedTextView btnDayLightSet;
    CheckedTextView btnFoldRearMirror;
    CheckedTextView btnPartAutoUnlockSet;
    CheckedTextView btnRainvolumeCloseTopWindow;
    CheckedTextView btnRemoteUnlock;
    CheckedTextView btnRestoreCarTire;
    CheckedTextView btnRestoreCarset;
    CheckedTextView btnUnlockAutoair;
    CheckedTextView btnUnlockOpenWindowToWind;
    CheckedTextView btnWindowLightSet;
    CheckedTextView btnWindowYaokongSet;
    CheckedTextView btnvDrivelock;
    CheckedTextView mBtnRightCamera;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 19:
                    RzcChanganAllSetAct.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    RzcChanganAllSetAct.this.mUpdaterValue8();
                    break;
                case 34:
                    RzcChanganAllSetAct.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 35:
                    RzcChanganAllSetAct.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 36:
                    RzcChanganAllSetAct.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 37:
                    RzcChanganAllSetAct.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 38:
                    RzcChanganAllSetAct.this.uCloseTopWindow(DataCanbus.DATA[updateCode]);
                    break;
                case 39:
                    RzcChanganAllSetAct.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 40:
                    RzcChanganAllSetAct.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 41:
                    RzcChanganAllSetAct.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 42:
                    RzcChanganAllSetAct.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 43:
                    RzcChanganAllSetAct.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 44:
                    RzcChanganAllSetAct.this.updateTireMessage(DataCanbus.DATA[updateCode]);
                    break;
                case 45:
                    RzcChanganAllSetAct.this.uYingBingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 46:
                    RzcChanganAllSetAct.this.uTishiVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 47:
                    RzcChanganAllSetAct.this.uBaojingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 48:
                    RzcChanganAllSetAct.this.btnPartAutoUnlockSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 49:
                    RzcChanganAllSetAct.this.btnAirAutoClearSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 50:
                    RzcChanganAllSetAct.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 51:
                    RzcChanganAllSetAct.this.btnWindowLightSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 52:
                    RzcChanganAllSetAct.this.btnWindowYaokongSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 53:
                    RzcChanganAllSetAct.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 54:
                    RzcChanganAllSetAct.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
                case 55:
                    RzcChanganAllSetAct.this.btnBluetoothBlowDownSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 56:
                    RzcChanganAllSetAct.this.btnDayLightSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 57:
                    RzcChanganAllSetAct.this.btnAtmosphereLightSet.setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 60:
                    RzcChanganAllSetAct.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };
    TextView mTextMileageLast;
    Button mbtOnekeyturnRight;
    Button mbtnBaojingVolLeft;
    Button mbtnBaojingVolRight;
    Button mbtnDianlabaVolLeft;
    Button mbtnDianlabaVolRight;
    Button mbtnOnekeyturnLeft;
    Button mbtnTishiVolLeft;
    Button mbtnTishiVolRight;
    Button mbtnUnlockrecvLeft;
    Button mbtnUnlockrecvRight;
    Button mbtnWinDelayTimeLeft;
    Button mbtnWinDelayTimeRight;
    Button mbtnYingBingVolLeft;
    Button mbtnYingBingVolRight;
    Button mbtnforntdelayLeft;
    Button mbtnforntdelayRight;
    TextView tvLightForntDelay;
    TextView tvLightOneKeyTurn;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzc_changan_all_setfunc);
        initview();
    }

    private void initview() {
        this.mTextMileageLast = (TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last);
        this.mBtnRightCamera = (CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera);
        if (this.mBtnRightCamera != null) {
            this.mBtnRightCamera.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[20] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        this.btnRestoreCarset = (CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset);
        if (this.btnRestoreCarset != null) {
            this.btnRestoreCarset.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RzcChanganAllSetAct.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        this.btnRestoreCarTire = (CheckedTextView) findViewById(R.id.rzc_cs55_restire_carset);
        if (this.btnRestoreCarTire != null) {
            this.btnRestoreCarTire.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RzcChanganAllSetAct.this.ShoeRestoreCarTireDialog();
                }
            });
        }
        this.btnFoldRearMirror = (CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror);
        if (this.btnFoldRearMirror != null) {
            this.btnFoldRearMirror.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[19];
                    DataCanbus.PROXY.cmd(1, new int[]{1, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnBackRainAssist = (CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist);
        if (this.btnBackRainAssist != null) {
            this.btnBackRainAssist.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[34];
                    DataCanbus.PROXY.cmd(1, new int[]{2, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnRemoteUnlock = (CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock);
        if (this.btnRemoteUnlock != null) {
            this.btnRemoteUnlock.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[35];
                    DataCanbus.PROXY.cmd(1, new int[]{3, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnvDrivelock = (CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock);
        if (this.btnvDrivelock != null) {
            this.btnvDrivelock.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[36];
                    DataCanbus.PROXY.cmd(1, new int[]{4, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnAccOffLock = (CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock);
        if (this.btnAccOffLock != null) {
            this.btnAccOffLock.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[37];
                    DataCanbus.PROXY.cmd(1, new int[]{5, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnRainvolumeCloseTopWindow = (CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow);
        if (this.btnRainvolumeCloseTopWindow != null) {
            this.btnRainvolumeCloseTopWindow.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[38];
                    DataCanbus.PROXY.cmd(1, new int[]{6, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnUnlockAutoair = (CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair);
        if (this.btnUnlockAutoair != null) {
            this.btnUnlockAutoair.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[39];
                    DataCanbus.PROXY.cmd(1, new int[]{7, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnUnlockOpenWindowToWind = (CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind);
        if (this.btnUnlockOpenWindowToWind != null) {
            this.btnUnlockOpenWindowToWind.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[40];
                    DataCanbus.PROXY.cmd(1, new int[]{8, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnAirAutoDry = (CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry);
        if (this.btnAirAutoDry != null) {
            this.btnAirAutoDry.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[41];
                    DataCanbus.PROXY.cmd(1, new int[]{9, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.tvLightForntDelay = (TextView) findViewById(R.id.rzc_cs55_light_forntdelay);
        this.mbtnforntdelayLeft = (Button) findViewById(R.id.cs55_btn_light_forntdelay_left);
        this.mbtnforntdelayRight = (Button) findViewById(R.id.cs75_btn_light_forntdelay_right);
        if (this.mbtnforntdelayLeft != null) {
            this.mbtnforntdelayLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (this.mbtnforntdelayRight != null) {
            this.mbtnforntdelayRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.FrontLightDelayMode(1);
                }
            });
        }
        this.tvLightOneKeyTurn = (TextView) findViewById(R.id.rzc_cs55_light_onekeyturn);
        this.mbtnOnekeyturnLeft = (Button) findViewById(R.id.cs55_btn_light_onekeyturn_left);
        this.mbtOnekeyturnRight = (Button) findViewById(R.id.cs75_btn_light_onekeyturn_right);
        if (this.mbtnOnekeyturnLeft != null) {
            this.mbtnOnekeyturnLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.OnekeyturnMode(-1);
                }
            });
        }
        if (this.mbtOnekeyturnRight != null) {
            this.mbtOnekeyturnRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.17
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.OnekeyturnMode(1);
                }
            });
        }
        this.TvYingBingVolSet = (TextView) findViewById(R.id.rzc_yidong_yingbingvol);
        this.mbtnYingBingVolLeft = (Button) findViewById(R.id.yidong_btn_yingbingvol_left);
        if (this.mbtnYingBingVolLeft != null) {
            this.mbtnYingBingVolLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.18
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[45] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{13, temp}, null, null);
                }
            });
        }
        this.mbtnYingBingVolRight = (Button) findViewById(R.id.yidong_btn_yingbingvol_right);
        if (this.mbtnYingBingVolRight != null) {
            this.mbtnYingBingVolRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[45] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{13, temp}, null, null);
                }
            });
        }
        this.TvTishiVolSet = (TextView) findViewById(R.id.rzc_yidong_tishivol);
        this.mbtnTishiVolLeft = (Button) findViewById(R.id.yidong_btn_tishivol_left);
        if (this.mbtnTishiVolLeft != null) {
            this.mbtnTishiVolLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[46] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{14, temp}, null, null);
                }
            });
        }
        this.mbtnTishiVolRight = (Button) findViewById(R.id.yidong_btn_tishivol_right);
        if (this.mbtnTishiVolRight != null) {
            this.mbtnTishiVolRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[46] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{14, temp}, null, null);
                }
            });
        }
        this.TvBaojingVolSet = (TextView) findViewById(R.id.rzc_yidong_baojingvol);
        this.mbtnBaojingVolLeft = (Button) findViewById(R.id.yidong_btn_baojingvol_left);
        if (this.mbtnBaojingVolLeft != null) {
            this.mbtnBaojingVolLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[47] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{15, temp}, null, null);
                }
            });
        }
        this.mbtnBaojingVolRight = (Button) findViewById(R.id.yidong_btn_baojingvol_right);
        if (this.mbtnBaojingVolRight != null) {
            this.mbtnBaojingVolRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[47] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{15, temp}, null, null);
                }
            });
        }
        this.btnPartAutoUnlockSet = (CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock);
        if (this.btnPartAutoUnlockSet != null) {
            this.btnPartAutoUnlockSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[48];
                    DataCanbus.PROXY.cmd(1, new int[]{16, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnAirAutoClearSet = (CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear);
        if (this.btnAirAutoClearSet != null) {
            this.btnAirAutoClearSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[49];
                    DataCanbus.PROXY.cmd(1, new int[]{17, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.TvWinDelayTimeSet = (TextView) findViewById(R.id.rzc_yidong_window_delaytime);
        this.mbtnWinDelayTimeLeft = (Button) findViewById(R.id.yidong_btn_window_delaytime_left);
        if (this.mbtnWinDelayTimeLeft != null) {
            this.mbtnWinDelayTimeLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.26
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[50] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{18, temp}, null, null);
                }
            });
        }
        this.mbtnWinDelayTimeRight = (Button) findViewById(R.id.yidong_btn_windeow_delaytime_right);
        if (this.mbtnWinDelayTimeRight != null) {
            this.mbtnWinDelayTimeRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.27
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[50] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{18, temp}, null, null);
                }
            });
        }
        this.btnWindowLightSet = (CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light);
        if (this.btnWindowLightSet != null) {
            this.btnWindowLightSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[51];
                    DataCanbus.PROXY.cmd(1, new int[]{19, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnWindowYaokongSet = (CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong);
        if (this.btnWindowYaokongSet != null) {
            this.btnWindowYaokongSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[52];
                    DataCanbus.PROXY.cmd(1, new int[]{20, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.TvDianlabaVolSet = (TextView) findViewById(R.id.rzc_yidong_dianlabavol);
        this.mbtnDianlabaVolLeft = (Button) findViewById(R.id.yidong_btn_dianlabavol_left);
        if (this.mbtnDianlabaVolLeft != null) {
            this.mbtnDianlabaVolLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.30
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[53] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{21, temp}, null, null);
                }
            });
        }
        this.mbtnDianlabaVolRight = (Button) findViewById(R.id.yidong_btn_dianlabavol_right);
        if (this.mbtnDianlabaVolRight != null) {
            this.mbtnDianlabaVolRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.31
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[53] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{21, temp}, null, null);
                }
            });
        }
        this.TvUnlockrecvSet = (TextView) findViewById(R.id.rzc_yidong_unlockrecv);
        this.mbtnUnlockrecvLeft = (Button) findViewById(R.id.yidong_btn_unlockrecv_left);
        if (this.mbtnUnlockrecvLeft != null) {
            this.mbtnUnlockrecvLeft.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.32
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[54] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, temp}, null, null);
                }
            });
        }
        this.mbtnUnlockrecvRight = (Button) findViewById(R.id.yidong_btn_unlockrecv_right);
        if (this.mbtnUnlockrecvRight != null) {
            this.mbtnUnlockrecvRight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.33
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[54] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, temp}, null, null);
                }
            });
        }
        this.btnBluetoothBlowDownSet = (CheckedTextView) findViewById(R.id.tv_rzc_bluetooth_blow_down);
        if (this.btnBluetoothBlowDownSet != null) {
            this.btnBluetoothBlowDownSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.34
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[55];
                    DataCanbus.PROXY.cmd(1, new int[]{23, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnDayLightSet = (CheckedTextView) findViewById(R.id.tv_rzc_day_light);
        if (this.btnDayLightSet != null) {
            this.btnDayLightSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.35
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[56];
                    DataCanbus.PROXY.cmd(1, new int[]{24, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        this.btnAtmosphereLightSet = (CheckedTextView) findViewById(R.id.tv_rzc_atmosphere_light);
        if (this.btnAtmosphereLightSet != null) {
            this.btnAtmosphereLightSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.36
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[57];
                    DataCanbus.PROXY.cmd(1, new int[]{25, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[20] & 255;
        if (this.mBtnRightCamera != null) {
            this.mBtnRightCamera.setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[43];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 3) {
            temp++;
        }
        DataCanbus.PROXY.cmd(1, new int[]{11, temp}, null, null);
    }

    protected void FrontLightDelayMode(int i) {
        int temp = DataCanbus.DATA[42];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 4) {
            temp++;
        }
        DataCanbus.PROXY.cmd(1, new int[]{10, temp}, null, null);
    }

    protected void updateTireMessage(int value) {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        switch (value) {
            case 1:
                normalDialog.setMessage(R.string.str_driving_reset);
                break;
            case 2:
                normalDialog.setMessage(R.string.str_faile_reset);
                break;
            case 3:
                normalDialog.setMessage(R.string.str_success_reset);
                break;
        }
        normalDialog.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.37
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        normalDialog.show();
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.38
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(1, new int[]{0, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.39
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void ShoeRestoreCarTireDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.bsd_klj_str15);
        normalDialog.setMessage(R.string.bsd_klj_str15);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.40
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(1, new int[]{12, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.41
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedValue(int i) {
        return i == 1 ? 2 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
    }

    protected void uYingBingVolset(int i) {
        this.TvYingBingVolSet.setText("声音" + i);
    }

    protected void uTishiVolset(int i) {
        this.TvTishiVolSet.setText("声音" + i);
    }

    protected void uBaojingVolset(int i) {
        this.TvBaojingVolSet.setText("声音" + i);
    }

    protected void uWinDelayTimeset(int i) {
        switch (i) {
            case 0:
                this.TvWinDelayTimeSet.setText("关闭");
                break;
            case 1:
                this.TvWinDelayTimeSet.setText("30秒");
                break;
            case 2:
                this.TvWinDelayTimeSet.setText("60秒");
                break;
            case 3:
                this.TvWinDelayTimeSet.setText("90秒");
                break;
            case 4:
                this.TvWinDelayTimeSet.setText("120秒");
                break;
        }
    }

    protected void uDianlabaVolset(int i) {
        switch (i) {
            case 1:
                this.TvDianlabaVolSet.setText("寻车和门未关闭锁");
                break;
            case 2:
                this.TvDianlabaVolSet.setText("寻车");
                break;
            case 3:
                this.TvDianlabaVolSet.setText("门未关闭锁");
                break;
        }
    }

    protected void uUnlockrecvset(int i) {
        switch (i) {
            case 1:
                this.TvUnlockrecvSet.setText("灯光+声音");
                break;
            case 2:
                this.TvUnlockrecvSet.setText("灯光");
                break;
            case 3:
                this.TvUnlockrecvSet.setText("声音");
                break;
        }
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                this.tvLightOneKeyTurn.setText("3 times");
                break;
            case 2:
                this.tvLightOneKeyTurn.setText("5 times");
                break;
            case 3:
                this.tvLightOneKeyTurn.setText("7 times");
                break;
            default:
                this.tvLightOneKeyTurn.setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                this.tvLightForntDelay.setText("10s");
                break;
            case 2:
                this.tvLightForntDelay.setText("30s");
                break;
            case 3:
                this.tvLightForntDelay.setText("60s");
                break;
            case 4:
                this.tvLightForntDelay.setText("120s");
                break;
            default:
                this.tvLightForntDelay.setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uAirAutoDry(int i) {
        if (this.btnAirAutoDry != null) {
            this.btnAirAutoDry.setChecked(i == 1);
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (this.btnUnlockOpenWindowToWind != null) {
            this.btnUnlockOpenWindowToWind.setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (this.btnUnlockAutoair != null) {
            this.btnUnlockAutoair.setChecked(i == 1);
        }
    }

    protected void uCloseTopWindow(int i) {
        if (this.btnRainvolumeCloseTopWindow != null) {
            this.btnRainvolumeCloseTopWindow.setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (this.btnAccOffLock != null) {
            this.btnAccOffLock.setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (this.btnvDrivelock != null) {
            this.btnvDrivelock.setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (this.btnRemoteUnlock != null) {
            this.btnRemoteUnlock.setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (this.btnBackRainAssist != null) {
            this.btnBackRainAssist.setChecked(i == 1);
        }
    }

    protected void uFoldRearMirror(int i) {
        if (this.btnFoldRearMirror != null) {
            this.btnFoldRearMirror.setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (this.mTextMileageLast != null) {
            int value = DataCanbus.DATA[60];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            this.mTextMileageLast.setText(String.valueOf(str) + " KM");
        }
    }
}
