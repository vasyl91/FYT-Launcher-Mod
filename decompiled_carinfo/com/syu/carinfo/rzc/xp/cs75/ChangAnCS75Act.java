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

@SuppressWarnings({"deprecation", "unchecked"})
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    ChangAnCS75Act.this.mUpdateCurOilExpend();
                    break;
                case 99:
                    ChangAnCS75Act.this.mUpdateCurOptimalOilExpend();
                    break;
                case 100:
                    ChangAnCS75Act.this.mUpdaterDrivingMileage();
                    break;
                case 101:
                    ChangAnCS75Act.this.mUpdaterCurTripOilExpend();
                    break;
                case 102:
                    ChangAnCS75Act.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 103:
                    ChangAnCS75Act.this.mUpdaterValue8();
                    break;
                case 116:
                    ChangAnCS75Act.this.uRestoreCarSet(DataCanbus.DATA[updateCode]);
                    break;
                case 117:
                    ChangAnCS75Act.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 118:
                    ChangAnCS75Act.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    ChangAnCS75Act.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    ChangAnCS75Act.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 121:
                    ChangAnCS75Act.this.uCloseTopWindow(DataCanbus.DATA[updateCode]);
                    break;
                case 122:
                    ChangAnCS75Act.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 123:
                    ChangAnCS75Act.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    ChangAnCS75Act.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    ChangAnCS75Act.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 126:
                    ChangAnCS75Act.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 128:
                    ChangAnCS75Act.this.uYingBingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 129:
                    ChangAnCS75Act.this.uTishiVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 130:
                    ChangAnCS75Act.this.uBaojingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 131:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_part_autounlock)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 132:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_air_autoclear)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 133:
                    ChangAnCS75Act.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 134:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_window_light)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 135:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.tv_rzc_yidong_window_yaokong)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 136:
                    ChangAnCS75Act.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 137:
                    ChangAnCS75Act.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_rzcxp_cs75);
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
        setSelfClick((CheckedTextView) findViewById(R.id.rzc_cs75_ctv_maintain_reminders), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int oilReminder = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = oilReminder != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[103] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(3, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_bk_left)) != null) {
            ((Button) findViewById(R.id.cs75_btn_bk_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.setMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_bk_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_bk_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.setMode(-1);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[102];
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
            ((Button) findViewById(R.id.yidong_btn_yingbingvol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[128] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_yingbingvol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_yingbingvol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[128] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_tishivol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_tishivol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_tishivol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_tishivol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_baojingvol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_baojingvol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[130] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_baojingvol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_baojingvol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[130] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[131];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 16, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[132];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 17, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_window_delaytime_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_window_delaytime_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_windeow_delaytime_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_windeow_delaytime_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[134];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 19, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[135];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 20, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_dianlabavol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_dianlabavol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[136] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_dianlabavol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_dianlabavol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[136] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_unlockrecv_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_unlockrecv_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[137] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_unlockrecv_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_unlockrecv_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[137] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    ChangAnCS75Act.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        bindViewOnClick(R.id.rzc_cs55_maintenance_information, new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ChangAnCS75Act.this.maintenanceCarSetDialog();
            }
        });
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[117];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_BACKCAR_REAR_ASSIT, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[118];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_REMOTE_UNLOCK, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[119];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_DRIVE_LOCK, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[120];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_ACCOFF_UNLOCK, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[121];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, 6, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[122];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_UNLOCK_VENTIALION, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind_)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[123];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_UNLOCK_OPENWINDOW, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[124];
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_UNLOCK_AIR_PURIFY, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.cs55_btn_light_forntdelay_left)) != null) {
            ((Button) findViewById(R.id.cs55_btn_light_forntdelay_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_light_forntdelay_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_light_forntdelay_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs55_btn_light_onekeyturn_left)) != null) {
            ((Button) findViewById(R.id.cs55_btn_light_onekeyturn_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_light_onekeyturn_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_light_onekeyturn_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.OnekeyturnMode(1);
                }
            });
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[103] & 255;
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[126];
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
        int temp = DataCanbus.DATA[125];
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
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_RESETCARSET}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_RESETCARSET, 1}, null, null);
                }
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void maintenanceCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_other_set_Maintenance_Reset);
        normalDialog.setMessage(R.string.str_other_set_Maintenance_Reset);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{ChangAnCS75Act.this.C_SET, ChangAnCS75Act.this.C_PURNISH_RESET}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.carId == 1) {
            DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
            if (findViewById(R.id.rzc_cs75_foldrearmirror_view) != null) {
                viewSetOnOff(false);
                viewSet2OnOff(false);
                setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), true);
            }
        } else if (DataCanbus.DATA[1000] == 327750 || DataCanbus.DATA[1000] == 1704006 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 786502 || DataCanbus.DATA[1000] == 720966 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
            viewSetOnOff(true);
            viewSet2OnOff(false);
            DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
            if (DataCanbus.DATA[1000] == 720966 || DataCanbus.DATA[1000] == 786502) {
                viewSet2OnOff(true);
                setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), false);
                DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
            }
        } else {
            setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), false);
            viewSetOnOff(false);
            viewSet2OnOff(false);
        }
        if (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862 || DataCanbus.DATA[1000] == 917574) {
            DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
            setViewVisible(bindViewOnClick(R.id.rzc_cs75_ctv_maintain_reminders_view, null), true);
            setViewVisible(bindViewOnClick(R.id.rzc_xp_cs75_tv_oil_signal_view, null), false);
            setViewVisible(findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow_view), false);
            setViewVisible(findViewById(R.id.rzc_cs75_foldrearmirror_view), true);
            if (DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 917574) {
                setViewVisible(bindViewOnClick(R.id.rzc_cs55_maintenance_information_view, null), true);
            }
        }
    }

    
    public int getCheckedValue(int i) {
        return (DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) ? i == 1 ? 0 : 1 : i == 1 ? 2 : 1;
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.carId == 1) {
            DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
            return;
        }
        if (DataCanbus.carId == 5 || DataCanbus.DATA[1000] == 393286 || DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 786502 || DataCanbus.DATA[1000] == 720966) {
            DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
            if (DataCanbus.DATA[1000] == 720966 || DataCanbus.DATA[1000] == 786502) {
                DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
            }
        }
    }

    
    public void mUpdaterCurTripOilExpend() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_oil_signal)) != null) {
            int value = DataCanbus.DATA[101];
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

    
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[100];
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

    
    public void mUpdateCurOilExpend() {
        this.mMode = DataCanbus.DATA[98];
        showModeState(this.mMode);
    }

    
    public void mUpdateCurOptimalOilExpend() {
        int oilReminder = DataCanbus.DATA[99];
        setCheck((CheckedTextView) findViewById(R.id.rzc_cs75_ctv_maintain_reminders), oilReminder == 1);
    }

    
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
