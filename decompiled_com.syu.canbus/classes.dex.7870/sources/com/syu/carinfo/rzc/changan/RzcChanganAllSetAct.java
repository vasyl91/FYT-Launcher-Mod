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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RzcChanganAllSetAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.1
        @Override // com.syu.module.IUiNotify
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
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 128:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 129:
                    RzcChanganAllSetAct.this.uWinDelayTimeset(DataCanbus.DATA[updateCode]);
                    break;
                case 130:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 131:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 132:
                    RzcChanganAllSetAct.this.uDianlabaVolset(DataCanbus.DATA[updateCode]);
                    break;
                case 133:
                    RzcChanganAllSetAct.this.uUnlockrecvset(DataCanbus.DATA[updateCode]);
                    break;
                case 134:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 135:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 136:
                    ((CheckedTextView) RzcChanganAllSetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 139:
                    RzcChanganAllSetAct.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzc_changan_all_setfunc);
        initview();
    }

    private void initview() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[99] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RzcChanganAllSetAct.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext19)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    RzcChanganAllSetAct.this.ShoeRestoreCarTireDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[98];
                    DataCanbus.PROXY.cmd(1, new int[]{1, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[113];
                    DataCanbus.PROXY.cmd(1, new int[]{2, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[114];
                    DataCanbus.PROXY.cmd(1, new int[]{3, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[115];
                    DataCanbus.PROXY.cmd(1, new int[]{4, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[116];
                    DataCanbus.PROXY.cmd(1, new int[]{5, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[117];
                    DataCanbus.PROXY.cmd(1, new int[]{6, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[118];
                    DataCanbus.PROXY.cmd(1, new int[]{7, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[119];
                    DataCanbus.PROXY.cmd(1, new int[]{8, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[120];
                    DataCanbus.PROXY.cmd(1, new int[]{9, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.17
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RzcChanganAllSetAct.this.OnekeyturnMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.18
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[124] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[124] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{13, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[125] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[125] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{14, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[126] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{15, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[126] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{15, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[127];
                    DataCanbus.PROXY.cmd(1, new int[]{16, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[128];
                    DataCanbus.PROXY.cmd(1, new int[]{17, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.26
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] - 1;
                    if (temp < 0) {
                        temp = 4;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{18, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.27
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[129] + 1;
                    if (temp > 4) {
                        temp = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{18, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[130];
                    DataCanbus.PROXY.cmd(1, new int[]{19, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext15)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[131];
                    DataCanbus.PROXY.cmd(1, new int[]{20, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.30
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[132] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.31
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[132] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{21, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.32
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] - 1;
                    if (temp < 1) {
                        temp = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, temp}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.33
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int temp = DataCanbus.DATA[133] + 1;
                    if (temp > 3) {
                        temp = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, temp}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext16)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.34
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[134];
                    DataCanbus.PROXY.cmd(1, new int[]{23, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.35
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[135];
                    DataCanbus.PROXY.cmd(1, new int[]{24, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext18)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.36
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[136];
                    DataCanbus.PROXY.cmd(1, new int[]{25, RzcChanganAllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[99] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
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
        if (value != 0) {
            normalDialog.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.RzcChanganAllSetAct.37
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            normalDialog.show();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedValue(int i) {
        return i == 1 ? 2 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
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
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(i == 1);
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i == 1);
        }
    }

    protected void uCloseTopWindow(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(i == 1);
        }
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            int value = DataCanbus.DATA[139];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(str) + " KM");
        }
    }
}
