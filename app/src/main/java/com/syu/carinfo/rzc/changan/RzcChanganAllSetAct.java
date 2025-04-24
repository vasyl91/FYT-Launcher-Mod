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

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcChanganAllSetAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    RzcChanganAllSetAct.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 99:
                    RzcChanganAllSetAct.this.mUpdaterValue8();
                    break;
                case 113:
                    RzcChanganAllSetAct.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 114:
                    RzcChanganAllSetAct.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 115:
                    RzcChanganAllSetAct.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 116:
                    RzcChanganAllSetAct.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 117:
                    RzcChanganAllSetAct.this.uCloseTopWindow(DataCanbus.DATA[updateCode]);
                    break;
                case 118:
                    RzcChanganAllSetAct.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    RzcChanganAllSetAct.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    RzcChanganAllSetAct.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 121:
                    RzcChanganAllSetAct.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 122:
                    RzcChanganAllSetAct.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 123:
                    RzcChanganAllSetAct.this.updateTireMessage(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    RzcChanganAllSetAct.this.uYingBingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    RzcChanganAllSetAct.this.uTishiVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 126:
                    RzcChanganAllSetAct.this.uBaojingVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 127:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_yidong_part_autounlock)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 128:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_yidong_air_autoclear)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 129:
                    RzcChanganAllSetAct.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 130:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_yidong_window_light)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 131:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_yidong_window_yaokong)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 132:
                    RzcChanganAllSetAct.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 133:
                    RzcChanganAllSetAct.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
                case 134:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_bluetooth_blow_down)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 135:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_day_light)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 136:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.tv_rzc_atmosphere_light)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 139:
                    RzcChanganAllSetAct.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_rzc_changan_all_setfunc);
        initview();
    }

    private void initview() {
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[99] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_restore_carset)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    RzcChanganAllSetAct.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_restire_carset)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_restire_carset)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    RzcChanganAllSetAct.this.ShoeRestoreCarTireDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[98];
                    DataCanbus.PROXY.cmd(1, new int[]{1, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_back_rainassist)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[113];
                    DataCanbus.PROXY.cmd(1, new int[]{2, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_remote_unlock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[114];
                    DataCanbus.PROXY.cmd(1, new int[]{3, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_drive_lock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[115];
                    DataCanbus.PROXY.cmd(1, new int[]{4, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_accoff_lock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[116];
                    DataCanbus.PROXY.cmd(1, new int[]{5, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_doorwindow_rainvolume_closetopwindow)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[117];
                    DataCanbus.PROXY.cmd(1, new int[]{6, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[118];
                    DataCanbus.PROXY.cmd(1, new int[]{7, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[119];
                    DataCanbus.PROXY.cmd(1, new int[]{8, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_airauto_dry)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[120];
                    DataCanbus.PROXY.cmd(1, new int[]{9, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.cs55_btn_light_forntdelay_left)) != null) {
            ((Button) findViewById(R.id.cs55_btn_light_forntdelay_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_light_forntdelay_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_light_forntdelay_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs55_btn_light_onekeyturn_left)) != null) {
            ((Button) findViewById(R.id.cs55_btn_light_onekeyturn_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.cs75_btn_light_onekeyturn_right)) != null) {
            ((Button) findViewById(R.id.cs75_btn_light_onekeyturn_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.OnekeyturnMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_yingbingvol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_yingbingvol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[124] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_yingbingvol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_yingbingvol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[124] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_tishivol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_tishivol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[125] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_tishivol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_tishivol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[125] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_baojingvol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_baojingvol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[126] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_baojingvol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_baojingvol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[126] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{15, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_part_autounlock)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[127];
                    DataCanbus.PROXY.cmd(1, new int[]{16, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_air_autoclear)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[128];
                    DataCanbus.PROXY.cmd(1, new int[]{17, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_window_delaytime_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_window_delaytime_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_windeow_delaytime_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_windeow_delaytime_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{18, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_light)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[130];
                    DataCanbus.PROXY.cmd(1, new int[]{19, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_yidong_window_yaokong)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[131];
                    DataCanbus.PROXY.cmd(1, new int[]{20, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_dianlabavol_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_dianlabavol_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[132] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_dianlabavol_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_dianlabavol_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[132] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_unlockrecv_left)) != null) {
            ((Button) findViewById(R.id.yidong_btn_unlockrecv_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.yidong_btn_unlockrecv_right)) != null) {
            ((Button) findViewById(R.id.yidong_btn_unlockrecv_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_bluetooth_blow_down)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_bluetooth_blow_down)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[134];
                    DataCanbus.PROXY.cmd(1, new int[]{23, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_day_light)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_day_light)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[135];
                    DataCanbus.PROXY.cmd(1, new int[]{24, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.tv_rzc_atmosphere_light)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_rzc_atmosphere_light)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int i = DataCanbus.DATA[136];
                    DataCanbus.PROXY.cmd(1, new int[]{25, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[99] & 255;
        if (((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_oushang_turn_right_enter_camera)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[122];
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
        int temp = DataCanbus.DATA[121];
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
        normalDialog.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { 
            @Override
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
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(1, new int[]{0, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void ShoeRestoreCarTireDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.bsd_klj_str15);
        normalDialog.setMessage(R.string.bsd_klj_str15);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(1, new int[]{12, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    
    public int getCheckedValue(int i) {
        return i == 1 ? 2 : 1;
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
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
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_openwindowtowind)).setChecked(i == 1);
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

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs75_foldrearmirror)).setChecked(i == 1);
        }
    }

    
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[139];
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
}
