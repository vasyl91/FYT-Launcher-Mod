package com.syu.carinfo.xbs.accord9;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XBSAccord9SettingsActi extends BaseActivity implements View.OnClickListener {
    int canbusId;
    int cmdCode;
    private TextView mAdjustOutsideTempDisplay;
    private TextView mAutoLightSensitivity;
    private Button mBtnAdjustOutsideTempDisplayMinus;
    private Button mBtnAdjustOutsideTempDisplayPlus;
    private Button mBtnAutoLightSensitivityMinus;
    private Button mBtnAutoLightSensitivityPlus;
    private CheckedTextView mBtnDefaultAll;
    private CheckedTextView mBtnDeflationWarningSystem;
    private Button mBtnFrontHazardDisMinus;
    private Button mBtnFrontHazardDisPlus;
    private CheckedTextView mBtnFuelEfficiencyBacklight;
    private Button mBtnHeadlightAutOffTimerMinus;
    private Button mBtnHeadlightAutOffTimerPlus;
    private Button mBtnInteriorLightDimmingTimeMinus;
    private Button mBtnInteriorLightDimmingTimePlus;
    private CheckedTextView mBtnKeylessAccessBeep;
    private Button mBtnKeylessAccessBeepVolumeMinus;
    private Button mBtnKeylessAccessBeepVolumePlus;
    private CheckedTextView mBtnKeylessLockAnswerBack;
    private Button mBtnMinorLaneMinus;
    private Button mBtnMinorLanePlus;
    private CheckedTextView mBtnResetMaintenanceInfo;
    private Button mBtnSecurityRelockTimerMinus;
    private Button mBtnSecurityRelockTimerPlus;
    private Button mBtnTripaResetTimingMinus;
    private Button mBtnTripaResetTimingPlus;
    private Button mBtnTripbResetTimingMinus;
    private Button mBtnTripbResetTimingPlus;
    private CheckedTextView mCtvAccTone;
    private CheckedTextView mCtvEnergyAutoStart;
    private CheckedTextView mCtvFuelEff;
    private CheckedTextView mCtvPauseLKADTone;
    private CheckedTextView mCtvRemoteStartSys;
    private CheckedTextView mCtvSmartKeyStartGuide;
    private CheckedTextView mCtvTrafficSign;
    private TextView mHeadlightAutOffTimer;
    private TextView mInteriorLightDimmingTime;
    private TextView mKeylessAccessBeepVolume;
    private TextView mSecurityRelockTimer;
    private TextView mTextFrontHazardDis;
    private TextView mTextMinorLane;
    private TextView mTripaResetTiming;
    private TextView mTripbResetTiming;
    int updateCode;
    int value;
    private IUiNotify mNotifyCanbusAccord9 = new IUiNotify() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 119:
                    XBSAccord9SettingsActi.this.mUpdaterTripaResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    XBSAccord9SettingsActi.this.mUpdaterTripbResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 121:
                    XBSAccord9SettingsActi.this.mUpdaterAdjustOutsideTempDisplay(DataCanbus.DATA[updateCode]);
                    break;
                case 122:
                    XBSAccord9SettingsActi.this.mUpdaterAutoLightSensitivity(DataCanbus.DATA[updateCode]);
                    break;
                case 123:
                    XBSAccord9SettingsActi.this.mUpdaterHeadlightAutOffTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    XBSAccord9SettingsActi.this.mUpdaterInteriorLightDimmingTime(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessLockAnswerBack(DataCanbus.DATA[updateCode]);
                    break;
                case 126:
                    XBSAccord9SettingsActi.this.mUpdaterSecurityRelockTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 127:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeep(DataCanbus.DATA[updateCode]);
                    break;
                case 128:
                    XBSAccord9SettingsActi.this.updateRemoteStartSys(DataCanbus.DATA[updateCode]);
                    break;
                case 129:
                    XBSAccord9SettingsActi.this.mUpdateEnergySaveFuelEffBackLight(DataCanbus.DATA[updateCode]);
                    break;
                case 130:
                    XBSAccord9SettingsActi.this.updateSmartKeyStartGuide(DataCanbus.DATA[updateCode]);
                    break;
                case 131:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeepVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 132:
                    XBSAccord9SettingsActi.this.updateEnergySaveAutoEnging(DataCanbus.DATA[updateCode]);
                    break;
                case 134:
                    XBSAccord9SettingsActi.this.updateAccTone(DataCanbus.DATA[updateCode]);
                    break;
                case 135:
                    XBSAccord9SettingsActi.this.updatePauseLKASTone(DataCanbus.DATA[updateCode]);
                    break;
                case 136:
                    XBSAccord9SettingsActi.this.updateSetFrontHazardDistance(DataCanbus.DATA[updateCode]);
                    break;
                case 151:
                    XBSAccord9SettingsActi.this.updateTrafficSign(DataCanbus.DATA[updateCode]);
                    break;
                case 152:
                    XBSAccord9SettingsActi.this.updateMinorLaneSys(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    XBSAccord9SettingsActi.this.mUpdaterTripbResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 117:
                    XBSAccord9SettingsActi.this.mUpdaterTripaResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 118:
                    XBSAccord9SettingsActi.this.mUpdaterAdjustOutsideTempDisplay(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    XBSAccord9SettingsActi.this.mUpdaterFuelEfficiencyBacklight(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    XBSAccord9SettingsActi.this.mUpdaterAutoLightSensitivity(DataCanbus.DATA[updateCode]);
                    break;
                case 121:
                    XBSAccord9SettingsActi.this.mUpdaterHeadlightAutOffTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 122:
                    XBSAccord9SettingsActi.this.mUpdaterInteriorLightDimmingTime(DataCanbus.DATA[updateCode]);
                    break;
                case 123:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessLockAnswerBack(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    XBSAccord9SettingsActi.this.mUpdaterSecurityRelockTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeepVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 126:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeep(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xbs_setting);
        this.mAdjustOutsideTempDisplay = (TextView) findViewById(R.id.xp_accord9_tv_adjust_outside_temp_display);
        this.mBtnAdjustOutsideTempDisplayMinus = (Button) findViewById(R.id.xp_accord9_btn_adjust_outside_temp_display_minus);
        this.mBtnAdjustOutsideTempDisplayMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 118;
                XBSAccord9SettingsActi.this.cmdCode = 0;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 121;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnAdjustOutsideTempDisplayPlus = (Button) findViewById(R.id.xp_accord9_btn_adjust_outside_temp_display_plus);
        this.mBtnAdjustOutsideTempDisplayPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 118;
                XBSAccord9SettingsActi.this.cmdCode = 0;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 121;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnFuelEfficiencyBacklight = (CheckedTextView) findViewById(R.id.xp_accord9_btn_fuel_efficiency_backlight);
        this.mBtnFuelEfficiencyBacklight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
            }
        });
        this.mTripaResetTiming = (TextView) findViewById(R.id.xp_accord9_tv_tripa_reset_timing);
        this.mBtnTripaResetTimingMinus = (Button) findViewById(R.id.xp_accord9_btn_tripa_reset_timing_minus);
        this.mBtnTripaResetTimingMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 117;
                XBSAccord9SettingsActi.this.cmdCode = 2;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 119;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{2}, null, null);
                }
            }
        });
        this.mBtnTripaResetTimingPlus = (Button) findViewById(R.id.xp_accord9_btn_tripa_reset_timing_plus);
        this.mBtnTripaResetTimingPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 117;
                XBSAccord9SettingsActi.this.cmdCode = 2;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 119;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[1], null, null);
                }
            }
        });
        this.mTripbResetTiming = (TextView) findViewById(R.id.xp_accord9_tv_tripb_reset_timing);
        this.mBtnTripbResetTimingMinus = (Button) findViewById(R.id.xp_accord9_btn_tripb_reset_timing_minus);
        this.mBtnTripbResetTimingMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 116;
                XBSAccord9SettingsActi.this.cmdCode = 3;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 120;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{2}, null, null);
                }
            }
        });
        this.mBtnTripbResetTimingPlus = (Button) findViewById(R.id.xp_accord9_btn_tripb_reset_timing_plus);
        this.mBtnTripbResetTimingPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 116;
                XBSAccord9SettingsActi.this.cmdCode = 3;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 120;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[1], null, null);
                }
            }
        });
        this.mInteriorLightDimmingTime = (TextView) findViewById(R.id.xp_accord9_tv_interior_light_dimming_time);
        this.mBtnInteriorLightDimmingTimeMinus = (Button) findViewById(R.id.xp_accord9_btn_interior_light_dimming_time_minus);
        this.mBtnInteriorLightDimmingTimeMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 122;
                XBSAccord9SettingsActi.this.cmdCode = 4;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 124;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnInteriorLightDimmingTimePlus = (Button) findViewById(R.id.xp_accord9_btn_interior_light_dimming_time_plus);
        this.mBtnInteriorLightDimmingTimePlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 122;
                XBSAccord9SettingsActi.this.cmdCode = 4;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 124;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mHeadlightAutOffTimer = (TextView) findViewById(R.id.xp_accord9_tv_headlight_aut_off_timer);
        this.mBtnHeadlightAutOffTimerMinus = (Button) findViewById(R.id.xp_accord9_btn_headlight_aut_off_timer_minus);
        this.mBtnHeadlightAutOffTimerMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 121;
                XBSAccord9SettingsActi.this.cmdCode = 5;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 123;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnHeadlightAutOffTimerPlus = (Button) findViewById(R.id.xp_accord9_btn_headlight_aut_off_timer_plus);
        this.mBtnHeadlightAutOffTimerPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 121;
                XBSAccord9SettingsActi.this.cmdCode = 5;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 123;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mAutoLightSensitivity = (TextView) findViewById(R.id.xp_accord9_tv_auto_light_sensitivity);
        this.mBtnAutoLightSensitivityMinus = (Button) findViewById(R.id.xp_accord9_btn_auto_light_sensitivity_minus);
        this.mBtnAutoLightSensitivityMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 120;
                XBSAccord9SettingsActi.this.cmdCode = 6;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 122;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnAutoLightSensitivityPlus = (Button) findViewById(R.id.xp_accord9_btn_auto_light_sensitivity_plus);
        this.mBtnAutoLightSensitivityPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 120;
                XBSAccord9SettingsActi.this.cmdCode = 6;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 122;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnKeylessLockAnswerBack = (CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_lock_answer_back);
        this.mBtnKeylessLockAnswerBack.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 123;
                XBSAccord9SettingsActi.this.cmdCode = 10;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 125;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mSecurityRelockTimer = (TextView) findViewById(R.id.xp_accord9_tv_security_relock_timer);
        this.mBtnSecurityRelockTimerMinus = (Button) findViewById(R.id.xp_accord9_btn_security_relock_timer_minus);
        this.mBtnSecurityRelockTimerMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 124;
                XBSAccord9SettingsActi.this.cmdCode = 11;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 126;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnSecurityRelockTimerPlus = (Button) findViewById(R.id.xp_accord9_btn_security_relock_timer_plus);
        this.mBtnSecurityRelockTimerPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 124;
                XBSAccord9SettingsActi.this.cmdCode = 11;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 126;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 2) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mKeylessAccessBeepVolume = (TextView) findViewById(R.id.xp_accord9_tv_keyless_access_beep_volume);
        this.mBtnKeylessAccessBeepVolumeMinus = (Button) findViewById(R.id.xp_accord9_btn_keyless_access_beep_volume_minus);
        this.mBtnKeylessAccessBeepVolumeMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 125;
                XBSAccord9SettingsActi.this.cmdCode = 12;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 127;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnKeylessAccessBeepVolumePlus = (Button) findViewById(R.id.xp_accord9_btn_keyless_access_beep_volume_plus);
        this.mBtnKeylessAccessBeepVolumePlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 125;
                XBSAccord9SettingsActi.this.cmdCode = 12;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 131;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnKeylessAccessBeep = (CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_access_beep);
        this.mBtnKeylessAccessBeep.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 126;
                XBSAccord9SettingsActi.this.cmdCode = 13;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 127;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnResetMaintenanceInfo = (CheckedTextView) findViewById(R.id.xp_accord9_btn_reset_maintenance_info);
        this.mBtnResetMaintenanceInfo.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.dialog(R.string.xp_accord9_reset_maintenance_info, 14);
            }
        });
        this.mBtnDefaultAll = (CheckedTextView) findViewById(R.id.xp_accord9_btn_default_all);
        this.mBtnDefaultAll.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.dialog(R.string.xp_accord9_default_all, 15);
            }
        });
        this.mBtnDeflationWarningSystem = (CheckedTextView) findViewById(R.id.xp_accord9_btn_deflation_warning_system);
        this.mBtnDeflationWarningSystem.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.dialog(R.string.xp_accord9_deflation_warning_system, 17);
            }
        });
        this.mCtvFuelEff = (CheckedTextView) findViewById(R.id.xp_ctv_fuel_efficiency_backlight);
        this.mCtvSmartKeyStartGuide = (CheckedTextView) findViewById(R.id.xp_ctv_smart_key_start_guide);
        this.mCtvEnergyAutoStart = (CheckedTextView) findViewById(R.id.xp_ctv_energy_save_auto_engine);
        this.mBtnFrontHazardDisMinus = (Button) findViewById(R.id.xp_siyu_set_front_hazard_distance_minus);
        this.mBtnFrontHazardDisPlus = (Button) findViewById(R.id.xp_siyu_btn_set_front_hazard_distance_plus);
        this.mTextFrontHazardDis = (TextView) findViewById(R.id.xp_siyu_tv_set_front_hazard_distance);
        this.mCtvTrafficSign = (CheckedTextView) findViewById(R.id.xp_ctv_traffic_sign_recognition_sys);
        this.mCtvAccTone = (CheckedTextView) findViewById(R.id.xp_ctv_acc_tone);
        this.mBtnMinorLaneMinus = (Button) findViewById(R.id.xp_siyu_btn_minor_lane_departure_sys_settings_minus);
        this.mBtnMinorLanePlus = (Button) findViewById(R.id.xp_siyu_btn_minor_lane_departure_sys_settings_plus);
        this.mTextMinorLane = (TextView) findViewById(R.id.xp_siyu_tv_minor_lane_departure_sys_settings);
        this.mCtvPauseLKADTone = (CheckedTextView) findViewById(R.id.xp_ctv_pause_lkas_tone);
        this.mCtvRemoteStartSys = (CheckedTextView) findViewById(R.id.xp_ctv_remote_start_system);
        setListener();
    }

    private void setListener() {
        this.mCtvFuelEff.setOnClickListener(this);
        this.mCtvSmartKeyStartGuide.setOnClickListener(this);
        this.mCtvEnergyAutoStart.setOnClickListener(this);
        this.mCtvTrafficSign.setOnClickListener(this);
        this.mCtvAccTone.setOnClickListener(this);
        this.mCtvPauseLKADTone.setOnClickListener(this);
        this.mCtvRemoteStartSys.setOnClickListener(this);
        this.mBtnFrontHazardDisMinus.setOnClickListener(this);
        this.mBtnFrontHazardDisPlus.setOnClickListener(this);
        this.mBtnMinorLaneMinus.setOnClickListener(this);
        this.mBtnMinorLanePlus.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xp_ctv_fuel_efficiency_backlight /* 2131429650 */:
                this.updateCode = 129;
                this.cmdCode = 26;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_smart_key_start_guide /* 2131429652 */:
                this.updateCode = 130;
                this.cmdCode = 27;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_energy_save_auto_engine /* 2131429654 */:
                this.updateCode = 132;
                this.cmdCode = 28;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_set_front_hazard_distance_minus /* 2131429656 */:
                this.updateCode = 136;
                this.cmdCode = 29;
                this.value = DataCanbus.DATA[this.updateCode] - 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_btn_set_front_hazard_distance_plus /* 2131429658 */:
                this.updateCode = 136;
                this.cmdCode = 29;
                this.value = DataCanbus.DATA[this.updateCode] + 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_traffic_sign_recognition_sys /* 2131429660 */:
                this.updateCode = 151;
                this.cmdCode = 30;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_acc_tone /* 2131429662 */:
                this.updateCode = 134;
                this.cmdCode = 31;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_btn_minor_lane_departure_sys_settings_minus /* 2131429664 */:
                this.updateCode = 152;
                this.cmdCode = 32;
                this.value = DataCanbus.DATA[this.updateCode] - 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_btn_minor_lane_departure_sys_settings_plus /* 2131429666 */:
                this.updateCode = 152;
                this.cmdCode = 32;
                this.value = DataCanbus.DATA[this.updateCode] + 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_pause_lkas_tone /* 2131429668 */:
                this.updateCode = 135;
                this.cmdCode = 33;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_remote_start_system /* 2131429670 */:
                this.updateCode = 128;
                this.cmdCode = 34;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.canbusId = DataCanbus.DATA[1000];
        if (isAccord9H()) {
            DataCanbus.PROXY.cmd(100, new int[]{10, 0}, null, null);
        } else {
            DataCanbus.PROXY.cmd(100, new int[]{4, 0}, null, null);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (isAccord9H()) {
            DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbusAccord9, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (isAccord9H()) {
            DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbusAccord9);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSmartKeyStartGuide(int value) {
        if (this.mCtvSmartKeyStartGuide != null) {
            this.mCtvSmartKeyStartGuide.setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteStartSys(int value) {
        if (this.mCtvRemoteStartSys != null) {
            this.mCtvRemoteStartSys.setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergySaveAutoEnging(int i) {
        if (this.mCtvEnergyAutoStart != null) {
            this.mCtvEnergyAutoStart.setChecked(this.value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccTone(int i) {
        if (this.mCtvAccTone != null) {
            this.mCtvAccTone.setChecked(this.value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePauseLKASTone(int i) {
        if (this.mCtvPauseLKADTone != null) {
            this.mCtvPauseLKADTone.setChecked(this.value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSetFrontHazardDistance(int i) {
        if (this.mTextFrontHazardDis != null) {
            switch (this.value) {
                case 1:
                    this.mTextFrontHazardDis.setText(R.string.jeep_lanesensewarn_1);
                    break;
                case 2:
                    this.mTextFrontHazardDis.setText(R.string.jeep_forwardcollisionwarn_1);
                    break;
                default:
                    this.mTextFrontHazardDis.setText(R.string.jeep_forwardcollisionwarn_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMinorLaneSys(int i) {
        if (this.mTextMinorLane != null) {
            switch (this.value) {
                case 1:
                    this.mTextMinorLane.setText(R.string.wc_321_warning_lan_str);
                    break;
                case 2:
                    this.mTextMinorLane.setText(R.string.wc_321_warning_wan_str);
                    break;
                default:
                    this.mTextMinorLane.setText(R.string.driver_system_standard);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrafficSign(int i) {
        if (this.mCtvTrafficSign != null) {
            this.mCtvTrafficSign.setChecked(this.value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAdjustOutsideTempDisplay(int value) {
        if (this.mAdjustOutsideTempDisplay != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                this.mAdjustOutsideTempDisplay.setText("+" + value2);
            } else if (value2 == 0) {
                this.mAdjustOutsideTempDisplay.setText("0" + value2);
            } else {
                this.mAdjustOutsideTempDisplay.setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFuelEfficiencyBacklight(int value) {
        if (this.mBtnFuelEfficiencyBacklight != null) {
            this.mBtnFuelEfficiencyBacklight.setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateEnergySaveFuelEffBackLight(int value) {
        if (this.mCtvFuelEff != null) {
            this.mCtvFuelEff.setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripaResetTiming(int value) {
        if (this.mTripaResetTiming != null) {
            switch (value) {
                case 1:
                    this.mTripaResetTiming.setText(R.string.xp_accord9_ign_off);
                    break;
                case 2:
                    this.mTripaResetTiming.setText(R.string.xp_accord9_manually_reset);
                    break;
                default:
                    this.mTripaResetTiming.setText(R.string.xp_accord9_with_refuel);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripbResetTiming(int value) {
        if (this.mTripbResetTiming != null) {
            switch (value) {
                case 1:
                    this.mTripbResetTiming.setText(R.string.xp_accord9_ign_off);
                    break;
                case 2:
                    this.mTripbResetTiming.setText(R.string.xp_accord9_manually_reset);
                    break;
                default:
                    this.mTripbResetTiming.setText(R.string.xp_accord9_with_refuel);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightDimmingTime(int value) {
        if (this.mInteriorLightDimmingTime != null) {
            switch (value) {
                case 1:
                    this.mInteriorLightDimmingTime.setText("30s");
                    break;
                case 2:
                    this.mInteriorLightDimmingTime.setText("60s");
                    break;
                default:
                    this.mInteriorLightDimmingTime.setText("15s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadlightAutOffTimer(int value) {
        if (this.mHeadlightAutOffTimer != null) {
            switch (value) {
                case 1:
                    this.mHeadlightAutOffTimer.setText("15s");
                    break;
                case 2:
                    this.mHeadlightAutOffTimer.setText("30s");
                    break;
                case 3:
                    this.mHeadlightAutOffTimer.setText("60s");
                    break;
                default:
                    this.mHeadlightAutOffTimer.setText("0s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoLightSensitivity(int value) {
        if (this.mAutoLightSensitivity != null) {
            switch (value) {
                case 1:
                    this.mAutoLightSensitivity.setText(R.string.xp_accord9_auto_light_1lower);
                    break;
                case 2:
                    this.mAutoLightSensitivity.setText(R.string.xp_accord9_auto_light_2middle);
                    break;
                case 3:
                    this.mAutoLightSensitivity.setText(R.string.xp_accord9_auto_light_3higher);
                    break;
                case 4:
                    this.mAutoLightSensitivity.setText(R.string.xp_accord9_auto_light_4highest);
                    break;
                default:
                    this.mAutoLightSensitivity.setText(R.string.xp_accord9_auto_light_0lowest);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeylessLockAnswerBack(int value) {
        if (this.mBtnKeylessLockAnswerBack != null) {
            this.mBtnKeylessLockAnswerBack.setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSecurityRelockTimer(int value) {
        if (this.mSecurityRelockTimer != null) {
            switch (value) {
                case 1:
                    this.mSecurityRelockTimer.setText("60s");
                    break;
                case 2:
                    this.mSecurityRelockTimer.setText("90s");
                    break;
                default:
                    this.mSecurityRelockTimer.setText("30s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeylessAccessBeepVolume(int value) {
        if (this.mKeylessAccessBeepVolume != null) {
            this.mKeylessAccessBeepVolume.setText(value == 0 ? R.string.xp_accord9_keyless_access_beep_volume_low : R.string.xp_accord9_keyless_access_beep_volume_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeylessAccessBeep(int value) {
        if (this.mBtnKeylessAccessBeep != null) {
            this.mBtnKeylessAccessBeep.setChecked(value != 0);
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.25
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[1], null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.26
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAccord9H() {
        return this.canbusId == 410;
    }
}
