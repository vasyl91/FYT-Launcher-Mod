package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TuRui_SettingAct extends BaseActivity {
    int iLanguageSet = 0;
    private int[] eventIds = {27, 28, 164, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 41, 40, 78, 19, 20, 21, 22, 23, 177, 178, 179, 180, 181, 182, 232, 233, 231, 82};
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 19:
                    TuRui_SettingAct.this.uAutoActive(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    TuRui_SettingAct.this.uFVol(DataCanbus.DATA[updateCode]);
                    break;
                case 21:
                    TuRui_SettingAct.this.uFTone(DataCanbus.DATA[updateCode]);
                    break;
                case 22:
                    TuRui_SettingAct.this.uRVol(DataCanbus.DATA[updateCode]);
                    break;
                case 23:
                    TuRui_SettingAct.this.uRTone(DataCanbus.DATA[updateCode]);
                    break;
                case 27:
                    TuRui_SettingAct.this.uSpeedWarn(DataCanbus.DATA[updateCode]);
                    break;
                case 28:
                    TuRui_SettingAct.this.uSpeedWarnAt(DataCanbus.DATA[updateCode]);
                    break;
                case 40:
                    TuRui_SettingAct.this.uDoorUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 41:
                    TuRui_SettingAct.this.uAutoLock(DataCanbus.DATA[updateCode]);
                    break;
                case 78:
                    TuRui_SettingAct.this.uDaytimeLight(DataCanbus.DATA[updateCode]);
                    break;
                case 82:
                    TuRui_SettingAct.this.UpdateVehicleVin(ConstGolf.mCarId);
                    break;
                case 164:
                    TuRui_SettingAct.this.uRainSensor(DataCanbus.DATA[updateCode]);
                    break;
                case 166:
                    TuRui_SettingAct.this.uLeftDrive(DataCanbus.DATA[updateCode]);
                    break;
                case 167:
                    TuRui_SettingAct.this.uSmartBiglight(DataCanbus.DATA[updateCode]);
                    break;
                case 168:
                    TuRui_SettingAct.this.uHomelight(DataCanbus.DATA[updateCode]);
                    break;
                case 169:
                    TuRui_SettingAct.this.uLeaveHomelight(DataCanbus.DATA[updateCode]);
                    break;
                case 170:
                    TuRui_SettingAct.this.uFootlight(DataCanbus.DATA[updateCode]);
                    break;
                case 171:
                    TuRui_SettingAct.this.uInSidelight(DataCanbus.DATA[updateCode]);
                    break;
                case 172:
                    TuRui_SettingAct.this.uFWin(DataCanbus.DATA[updateCode]);
                    break;
                case 173:
                    TuRui_SettingAct.this.uRWin(DataCanbus.DATA[updateCode]);
                    break;
                case 174:
                    TuRui_SettingAct.this.uSkyWin(DataCanbus.DATA[updateCode]);
                    break;
                case 175:
                    TuRui_SettingAct.this.uFoldMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 176:
                    TuRui_SettingAct.this.uOnlyUnlockTrunk(DataCanbus.DATA[updateCode]);
                    break;
                case 177:
                    TuRui_SettingAct.this.uUnitDistance(DataCanbus.DATA[updateCode]);
                    break;
                case 178:
                    TuRui_SettingAct.this.uUnitSpeed(DataCanbus.DATA[updateCode]);
                    break;
                case 179:
                    TuRui_SettingAct.this.uUnitTemp(DataCanbus.DATA[updateCode]);
                    break;
                case 180:
                    TuRui_SettingAct.this.uUnitCapacity(DataCanbus.DATA[updateCode]);
                    break;
                case 181:
                    TuRui_SettingAct.this.uUnitEnergy(DataCanbus.DATA[updateCode]);
                    break;
                case 182:
                    TuRui_SettingAct.this.uUnitTirePress(DataCanbus.DATA[updateCode]);
                    break;
                case 231:
                    TuRui_SettingAct.this.uMatchedKeys(DataCanbus.DATA[updateCode]);
                    break;
                case 232:
                    TuRui_SettingAct.this.uTireLoadStatus(DataCanbus.DATA[updateCode]);
                    break;
                case 233:
                    TuRui_SettingAct.this.uTireType(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private int[] doorUnlockStr = {R.string.wc_ruiteng_string_unlock_mode_1, R.string.wc_ruiteng_string_unlock_mode_0};

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_turui_settings);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int type, int cmd, int value) {
        DataCanbus.PROXY.cmd(23, new int[]{type, cmd, value}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.turui_winter_tyres), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[27] & 255;
                TuRui_SettingAct.this.sendCMD(75, 2, val == 1 ? 0 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_tpres_setting_warnint_at_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[28] & 255) + 10;
                if (val > 240) {
                    val = 240;
                }
                TuRui_SettingAct.this.sendCMD(75, 3, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_tpres_setting_warnint_at_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[28] & 255) - 10;
                if (val < 30) {
                    val = 30;
                }
                TuRui_SettingAct.this.sendCMD(75, 3, val);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_rainsensor), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[164] & 255;
                TuRui_SettingAct.this.sendCMD(77, 1, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_leftdriver), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[166] & 255;
                TuRui_SettingAct.this.sendCMD(109, 19, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_smartbiglight), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[167] & 255;
                TuRui_SettingAct.this.sendCMD(109, 18, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_daytimelight), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[78] & 255;
                TuRui_SettingAct.this.sendCMD(109, 16, val == 1 ? 0 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_homelight_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[168] & 255) - 1;
                if (val < 1) {
                    val = 1;
                }
                TuRui_SettingAct.this.sendCMD(109, 13, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_homelight_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[168] & 255) + 1;
                if (val > 3) {
                    val = 3;
                }
                TuRui_SettingAct.this.sendCMD(109, 13, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_leavehomelight_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[169] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(109, 14, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_leavehomelight_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[169] & 255) + 1;
                if (val > 3) {
                    val = 3;
                }
                TuRui_SettingAct.this.sendCMD(109, 14, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_footlight_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[170] & 255) - 10;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(109, 15, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_footlight_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[170] & 255) + 10;
                if (val > 100) {
                    val = 100;
                }
                TuRui_SettingAct.this.sendCMD(109, 15, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_insidecarlight_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[171] & 255) + 10;
                if (val > 100) {
                    val = 100;
                }
                TuRui_SettingAct.this.sendCMD(109, 17, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_insidecarlight_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[171] & 255) - 10;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(109, 17, val);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_frontwindow), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[172] & 255;
                TuRui_SettingAct.this.sendCMD(111, 1, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_rearwindow), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[173] & 255;
                TuRui_SettingAct.this.sendCMD(111, 2, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_skywindow), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[174] & 255;
                TuRui_SettingAct.this.sendCMD(111, 3, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_autolock), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[41] & 255;
                TuRui_SettingAct.this.sendCMD(111, 5, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_foldrearmirror), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[175] & 255;
                TuRui_SettingAct.this.sendCMD(111, 6, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_cardoor_unlock), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[40] & 255;
                TuRui_SettingAct.this.sendCMD(111, 7, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_only_unlock_trunk), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[176] & 255;
                TuRui_SettingAct.this.sendCMD(111, 8, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_activate_automaticlly), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[19] & 255;
                TuRui_SettingAct.this.sendCMD(122, 5, val == 1 ? 0 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_frontvol_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[20] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 1, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_frontvol_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[20] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 1, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_fronttune_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[21] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 2, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_fronttune_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[21] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 2, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_rearvol_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[22] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 3, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_rearvol_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[22] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 3, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_reartone_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[23] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 4, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_reartone_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[23] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 4, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_distance_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[177] & 255;
                TuRui_SettingAct.this.sendCMD(202, 1, val == 1 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_distance_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[177] & 255;
                TuRui_SettingAct.this.sendCMD(202, 1, val == 1 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_speed_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[178] & 255;
                TuRui_SettingAct.this.sendCMD(202, 2, val != 1 ? 2 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_speed_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[178] & 255;
                TuRui_SettingAct.this.sendCMD(202, 2, val != 1 ? 2 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_temp_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[179] & 255;
                TuRui_SettingAct.this.sendCMD(202, 3, val != 1 ? 2 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_temp_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[179] & 255;
                TuRui_SettingAct.this.sendCMD(202, 3, val != 1 ? 2 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_capacity_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[180] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(202, 4, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_capacity_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[180] & 255) + 1;
                if (val > 2) {
                    val = 2;
                }
                TuRui_SettingAct.this.sendCMD(202, 4, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_energycost_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[181] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(202, 5, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_energycost_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[181] & 255) + 1;
                if (val > 3) {
                    val = 3;
                }
                TuRui_SettingAct.this.sendCMD(202, 5, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_tirepress_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[182] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(202, 6, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_tirepress_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[182] & 255) + 1;
                if (val > 2) {
                    val = 2;
                }
                TuRui_SettingAct.this.sendCMD(202, 6, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_language_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TuRui_SettingAct.this.iLanguageSet <= 1) {
                    TuRui_SettingAct.this.iLanguageSet = 16;
                } else {
                    TuRui_SettingAct tuRui_SettingAct = TuRui_SettingAct.this;
                    tuRui_SettingAct.iLanguageSet--;
                }
                TuRui_SettingAct.this.UpdateLanguageSettings(TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.sendCMD(154, 1, TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.getSharedPreferences("turui", 0).edit().putInt("languageset", TuRui_SettingAct.this.iLanguageSet).commit();
            }
        });
        setSelfClick(findViewById(R.id.turui_language_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TuRui_SettingAct.this.iLanguageSet >= 16) {
                    TuRui_SettingAct.this.iLanguageSet = 1;
                } else {
                    TuRui_SettingAct.this.iLanguageSet++;
                }
                TuRui_SettingAct.this.UpdateLanguageSettings(TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.sendCMD(154, 1, TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.getSharedPreferences("turui", 0).edit().putInt("languageset", TuRui_SettingAct.this.iLanguageSet).commit();
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_load_status_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[232] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 1, value);
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_load_status_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.48
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[232] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 1, value);
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_type_m), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.49
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[233];
                if (value2 <= 0) {
                    value = 8;
                } else {
                    value = value2 - 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 2, value);
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_type_p), new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_SettingAct.50
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[233] & 255;
                if (value2 >= 8) {
                    value = 0;
                } else {
                    value = value2 + 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 2, value);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] != 196878) {
            if (((TextView) findViewById(R.id.turui_tire_title)) != null) {
                ((TextView) findViewById(R.id.turui_tire_title)).setVisibility(8);
            }
            if (((TextView) findViewById(R.id.turui_matchedkeys_title)) != null) {
                ((TextView) findViewById(R.id.turui_matchedkeys_title)).setVisibility(8);
            }
            if (findViewById(R.id.turui_tire_load_status_view) != null) {
                findViewById(R.id.turui_tire_load_status_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_tire_type_view) != null) {
                findViewById(R.id.turui_tire_type_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_matchedkeys_view) != null) {
                findViewById(R.id.turui_matchedkeys_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_vehicle_vin_view) != null) {
                findViewById(R.id.turui_vehicle_vin_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_language_setting_view) != null) {
                findViewById(R.id.turui_language_setting_view).setVisibility(8);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.turui_tire_title)) != null) {
            ((TextView) findViewById(R.id.turui_tire_title)).setVisibility(0);
        }
        if (((TextView) findViewById(R.id.turui_matchedkeys_title)) != null) {
            ((TextView) findViewById(R.id.turui_matchedkeys_title)).setVisibility(0);
        }
        if (findViewById(R.id.turui_tire_load_status_view) != null) {
            findViewById(R.id.turui_tire_load_status_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_tire_type_view) != null) {
            findViewById(R.id.turui_tire_type_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_matchedkeys_view) != null) {
            findViewById(R.id.turui_matchedkeys_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_vehicle_vin_view) != null) {
            findViewById(R.id.turui_vehicle_vin_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_language_setting_view) != null) {
            findViewById(R.id.turui_language_setting_view).setVisibility(0);
        }
        this.iLanguageSet = getSharedPreferences("turui", 0).getInt("languageset", 1);
        UpdateLanguageSettings(this.iLanguageSet);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.notifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateVehicleVin(String str) {
        if (((TextView) findViewById(R.id.turui_vehiclevin_txt)) != null) {
            ((TextView) findViewById(R.id.turui_vehiclevin_txt)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateLanguageSettings(int val) {
        if (((TextView) findViewById(R.id.turui_language_setting_show)) != null) {
            String str = "";
            switch (val) {
                case 1:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_1);
                    break;
                case 2:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_2);
                    break;
                case 3:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_3);
                    break;
                case 4:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_4);
                    break;
                case 5:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_5);
                    break;
                case 6:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_6);
                    break;
                case 7:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_7);
                    break;
                case 8:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_8);
                    break;
                case 9:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_9);
                    break;
                case 10:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_10);
                    break;
                case 11:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_11);
                    break;
                case 12:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_12);
                    break;
                case 13:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_13);
                    break;
                case 14:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_14);
                    break;
                case 15:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_15);
                    break;
                case 16:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_16);
                    break;
            }
            ((TextView) findViewById(R.id.turui_language_setting_show)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireLoadStatus(int val) {
        if (((TextView) findViewById(R.id.turui_tire_load_status_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_tire_load_status_view) != null) {
                findViewById(R.id.turui_tire_load_status_view).setVisibility(enable == 1 ? 0 : 8);
            }
            int val2 = val & 255;
            String str = getResources().getString(R.string.str_270_tirepress2);
            if (val2 == 1) {
                str = getResources().getString(R.string.str_270_tirepress2);
            } else if (val2 == 2) {
                str = getResources().getString(R.string.str_270_tirepress3);
            }
            ((TextView) findViewById(R.id.turui_tire_load_status_txt)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireType(int val) {
        if (((TextView) findViewById(R.id.turui_tire_type_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_tire_type_view) != null) {
                findViewById(R.id.turui_tire_type_view).setVisibility(enable == 1 ? 0 : 8);
            }
            String str = String.valueOf(val & 255);
            ((TextView) findViewById(R.id.turui_tire_type_txt)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uMatchedKeys(int val) {
        if (((TextView) findViewById(R.id.turui_matchedkeys_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_matchedkeys_view) != null) {
                findViewById(R.id.turui_matchedkeys_view).setVisibility(enable == 1 ? 0 : 8);
            }
            String str = String.valueOf(val & 255);
            ((TextView) findViewById(R.id.turui_matchedkeys_txt)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSpeedWarn(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_winter_tyres)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_winter_tyres_view) != null) {
                findViewById(R.id.turui_winter_tyres_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_winter_tyres)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSpeedWarnAt(int val) {
        if (((TextView) findViewById(R.id.turui_tpres_setting_warnint_at_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_tpres_setting_warnint_at_view) != null) {
                findViewById(R.id.turui_tpres_setting_warnint_at_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((TextView) findViewById(R.id.turui_tpres_setting_warnint_at_txt)).setText((val & 255) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uRainSensor(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_rainsensor)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_rainsensor_view) != null) {
                findViewById(R.id.turui_rainsensor_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_rainsensor)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uLeftDrive(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_leftdriver)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_leftdriver_view) != null) {
                findViewById(R.id.turui_leftdriver_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_leftdriver)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSmartBiglight(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_smartbiglight)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_smartbiglight_view) != null) {
                findViewById(R.id.turui_smartbiglight_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_smartbiglight)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uHomelight(int val) {
        if (((TextView) findViewById(R.id.turui_homelight_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_homelight_view) != null) {
                findViewById(R.id.turui_homelight_view).setVisibility(enable == 1 ? 0 : 8);
            }
            int val2 = val & 255;
            int id = R.string.off;
            if (val2 == 1) {
                id = R.string.str_wc_jy_str8;
            } else if (val2 == 2) {
                id = R.string.str_wc_jy_str9;
            } else if (val2 == 3) {
                id = R.string.str_wc_jy_str10;
            }
            ((TextView) findViewById(R.id.turui_homelight_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uLeaveHomelight(int val) {
        if (((TextView) findViewById(R.id.turui_leavehomelight_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_leavehomelight_view) != null) {
                findViewById(R.id.turui_leavehomelight_view).setVisibility(enable == 1 ? 0 : 8);
            }
            int val2 = val & 255;
            int id = R.string.off;
            if (val2 == 1) {
                id = R.string.str_wc_jy_str8;
            } else if (val2 == 2) {
                id = R.string.str_wc_jy_str9;
            } else if (val2 == 3) {
                id = R.string.str_wc_jy_str10;
            }
            ((TextView) findViewById(R.id.turui_leavehomelight_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uFootlight(int val) {
        if (((TextView) findViewById(R.id.turui_footlight_txt)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_footlight_view) != null) {
                findViewById(R.id.turui_footlight_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((TextView) findViewById(R.id.turui_footlight_txt)).setText(String.valueOf(val & 255) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uInSidelight(int val) {
        if (((TextView) findViewById(R.id.turui_insidecarlight_txt)) != null) {
            ((TextView) findViewById(R.id.turui_insidecarlight_txt)).setText(String.valueOf(val & 255) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uFWin(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_frontwindow)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_frontwindow_view) != null) {
                findViewById(R.id.turui_frontwindow_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_frontwindow)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uRWin(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_rearwindow)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_rearwindow_view) != null) {
                findViewById(R.id.turui_rearwindow_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_rearwindow)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSkyWin(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_skywindow)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_skywindow_view) != null) {
                findViewById(R.id.turui_skywindow_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_skywindow)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uFoldMirror(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_foldrearmirror)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_foldrearmirror_view) != null) {
                findViewById(R.id.turui_foldrearmirror_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_foldrearmirror)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uOnlyUnlockTrunk(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_only_unlock_trunk)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_only_unlock_trunk_view) != null) {
                findViewById(R.id.turui_only_unlock_trunk_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_only_unlock_trunk)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAutoLock(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_autolock)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_autolock_view) != null) {
                findViewById(R.id.turui_autolock_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_autolock)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uDoorUnlock(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_cardoor_unlock_view) != null) {
            findViewById(R.id.turui_cardoor_unlock_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((CheckedTextView) findViewById(R.id.turui_cardoor_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.turui_cardoor_unlock)).setChecked(val2 == 1);
        }
        if (((TextView) findViewById(R.id.turui_cardoor_unlock_txt)) != null) {
            ((TextView) findViewById(R.id.turui_cardoor_unlock_txt)).setText(this.doorUnlockStr[val2 % 2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uDaytimeLight(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_daytimelight)) != null) {
            int enable = (val >> 8) & 1;
            if (findViewById(R.id.turui_daytimelight_view) != null) {
                findViewById(R.id.turui_daytimelight_view).setVisibility(enable == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_daytimelight)).setChecked((val & 255) == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAutoActive(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_activate_automaticlly_view) != null) {
            findViewById(R.id.turui_activate_automaticlly_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((CheckedTextView) findViewById(R.id.turui_activate_automaticlly)) != null) {
            ((CheckedTextView) findViewById(R.id.turui_activate_automaticlly)).setChecked(val2 == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uFVol(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_frontvol_txt)) != null) {
            ((TextView) findViewById(R.id.turui_frontvol_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uFTone(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_fronttune_txt)) != null) {
            ((TextView) findViewById(R.id.turui_fronttune_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uRVol(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_rearvol_txt)) != null) {
            ((TextView) findViewById(R.id.turui_rearvol_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uRTone(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_reartone_txt)) != null) {
            ((TextView) findViewById(R.id.turui_reartone_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uUnitDistance(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_unit_distance_view) != null) {
            findViewById(R.id.turui_unit_distance_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_distance_txt)) != null) {
            int id = R.string.str_turui_str12;
            if (val2 == 1) {
                id = R.string.str_bogoo_bmw_juli_unit_0;
            }
            ((TextView) findViewById(R.id.turui_unit_distance_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uUnitSpeed(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_unit_speed_view) != null) {
            findViewById(R.id.turui_unit_speed_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_speed_txt)) != null) {
            int id = R.string.str_turui_str14;
            if (val2 == 1) {
                id = R.string.str_turui_str13;
            }
            ((TextView) findViewById(R.id.turui_unit_speed_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uUnitTemp(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_unit_temp_view) != null) {
            findViewById(R.id.turui_unit_temp_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_temp_txt)) != null) {
            int id = R.string.wc_15ruijie_temp_unit_f_set;
            if (val2 == 1) {
                id = R.string.wc_15ruijie_temp_unit_c_set;
            }
            ((TextView) findViewById(R.id.turui_unit_temp_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uUnitCapacity(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_unit_capacity_view) != null) {
            findViewById(R.id.turui_unit_capacity_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_capacity_txt)) != null) {
            int id = R.string.str_turui_str15;
            if (val2 == 1) {
                id = R.string.str_turui_str16;
            } else if (val2 == 2) {
                id = R.string.str_turui_str17;
            }
            ((TextView) findViewById(R.id.turui_unit_capacity_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uUnitEnergy(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_unit_energycost_view) != null) {
            findViewById(R.id.turui_unit_energycost_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_energycost_txt)) != null) {
            int id = R.string.str_bogoo_bmw_oil_unit_0;
            if (val2 == 1) {
                id = R.string.str_bogoo_bmw_oil_unit_3;
            } else if (val2 == 2) {
                id = R.string.str_bogoo_bmw_oil_unit_1;
            } else if (val2 == 3) {
                id = R.string.str_bogoo_bmw_oil_unit_2;
            }
            ((TextView) findViewById(R.id.turui_unit_energycost_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uUnitTirePress(int val) {
        int enable = (val >> 8) & 1;
        if (findViewById(R.id.turui_unit_tirepress_view) != null) {
            findViewById(R.id.turui_unit_tirepress_view).setVisibility(enable == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_tirepress_txt)) != null) {
            int id = R.string.str_press_unit_0;
            if (val2 == 1) {
                id = R.string.str_press_unit_1;
            } else if (val2 == 2) {
                id = R.string.str_press_unit_2;
            }
            ((TextView) findViewById(R.id.turui_unit_tirepress_txt)).setText(id);
        }
    }
}
