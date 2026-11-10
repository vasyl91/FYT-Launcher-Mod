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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ChangAnCS75Act extends BaseActivity {
    private int mMode = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.1
        @Override // com.syu.module.IUiNotify
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
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 132:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 133:
                    ChangAnCS75Act.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 134:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.ctv_checkedtext16)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 135:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.ctv_checkedtext17)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 136:
                    ChangAnCS75Act.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 137:
                    ChangAnCS75Act.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
                case 154:
                    ((CheckedTextView) ChangAnCS75Act.this.findViewById(R.id.ctv_checkedtext18)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzcxp_cs75);
        setupView();
    }

    private void setupView() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int oilReminder = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = oilReminder != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[103] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(3, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.setMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.5
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.setMode(-1);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[102];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 1, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.7
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[128] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[128] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[130] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.12
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[130] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 15, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[131];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 16, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[132];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 17, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 18, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[134];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 19, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.18
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[135];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 20, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.19
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[154];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(6, iArr, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[136] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[136] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[137] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[137] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{131, 22, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ChangAnCS75Act.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        bindViewOnClick(R.id.ctv_checkedtext5, new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChangAnCS75Act.this.maintenanceCarSetDialog();
            }
        });
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[117];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 2, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.27
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[118];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 3, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[119];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 4, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[120];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 5, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.30
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[121];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 6, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.31
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[122];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 7, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.32
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[123];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 8, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.33
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[124];
                    DataCanbus.PROXY.cmd(2, new int[]{131, 9, ChangAnCS75Act.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.34
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.35
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.36
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.37
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ChangAnCS75Act.this.OnekeyturnMode(1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[103] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
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
        DataCanbus.PROXY.cmd(2, new int[]{131, 11, temp}, null, null);
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
        DataCanbus.PROXY.cmd(2, new int[]{131, 10, temp}, null, null);
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.38
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{131, 0, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.39
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
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.40
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{131, 10, 0}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act.41
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedValue(int i) {
        return i == 1 ? 2 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            int value = DataCanbus.DATA[101];
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_oil_signal_normal);
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_oil_signal_low);
            }
        }
    }

    protected void uYingBingVolset(int i) {
        ((TextView) findViewById(R.id.tv_text4)).setText("声音" + i);
    }

    protected void uTishiVolset(int i) {
        ((TextView) findViewById(R.id.tv_text5)).setText("声音" + i);
    }

    protected void uBaojingVolset(int i) {
        ((TextView) findViewById(R.id.tv_text6)).setText("声音" + i);
    }

    protected void uWinDelayTimeset(int i) {
        switch (i) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText("关闭");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText("30秒");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text7)).setText("60秒");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text7)).setText("90秒");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text7)).setText("120秒");
                break;
        }
    }

    protected void uDianlabaVolset(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText("寻车和门未关闭锁");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text8)).setText("寻车");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text8)).setText("门未关闭锁");
                break;
        }
    }

    protected void uUnlockrecvset(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text9)).setText("灯光+声音");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text9)).setText("灯光");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text9)).setText("声音");
                break;
        }
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText("3 times");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText("5 times");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText("7 times");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText("60s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText("120s");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uAirAutoDry(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(i == 1);
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_cs55_airset_unlock_autoair)).setChecked(i == 1);
        }
    }

    protected void uCloseTopWindow(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(i == 1);
        }
    }

    protected void uRestoreCarSet(int i) {
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            int value = DataCanbus.DATA[100];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(str) + " KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        this.mMode = DataCanbus.DATA[98];
        showModeState(this.mMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOptimalOilExpend() {
        int oilReminder = DataCanbus.DATA[99];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), oilReminder == 1);
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
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (mode) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_mode_paraller);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_mode_close);
                    break;
            }
        }
    }
}
