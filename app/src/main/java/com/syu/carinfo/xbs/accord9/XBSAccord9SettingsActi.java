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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case 51:
                    XBSAccord9SettingsActi.this.mUpdaterTripaResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 52:
                    XBSAccord9SettingsActi.this.mUpdaterTripbResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 53:
                    XBSAccord9SettingsActi.this.mUpdaterAdjustOutsideTempDisplay(DataCanbus.DATA[updateCode]);
                    break;
                case 54:
                    XBSAccord9SettingsActi.this.mUpdaterAutoLightSensitivity(DataCanbus.DATA[updateCode]);
                    break;
                case 55:
                    XBSAccord9SettingsActi.this.mUpdaterHeadlightAutOffTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 56:
                    XBSAccord9SettingsActi.this.mUpdaterInteriorLightDimmingTime(DataCanbus.DATA[updateCode]);
                    break;
                case 57:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessLockAnswerBack(DataCanbus.DATA[updateCode]);
                    break;
                case 58:
                    XBSAccord9SettingsActi.this.mUpdaterSecurityRelockTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 59:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeep(DataCanbus.DATA[updateCode]);
                    break;
                case 60:
                    XBSAccord9SettingsActi.this.updateRemoteStartSys(DataCanbus.DATA[updateCode]);
                    break;
                case 61:
                    XBSAccord9SettingsActi.this.mUpdateEnergySaveFuelEffBackLight(DataCanbus.DATA[updateCode]);
                    break;
                case 62:
                    XBSAccord9SettingsActi.this.updateSmartKeyStartGuide(DataCanbus.DATA[updateCode]);
                    break;
                case 63:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeepVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 64:
                    XBSAccord9SettingsActi.this.updateEnergySaveAutoEnging(DataCanbus.DATA[updateCode]);
                    break;
                case 66:
                    XBSAccord9SettingsActi.this.updateAccTone(DataCanbus.DATA[updateCode]);
                    break;
                case 67:
                    XBSAccord9SettingsActi.this.updatePauseLKASTone(DataCanbus.DATA[updateCode]);
                    break;
                case 68:
                    XBSAccord9SettingsActi.this.updateSetFrontHazardDistance(DataCanbus.DATA[updateCode]);
                    break;
                case 69:
                    XBSAccord9SettingsActi.this.updateTrafficSign(DataCanbus.DATA[updateCode]);
                    break;
                case 70:
                    XBSAccord9SettingsActi.this.updateMinorLaneSys(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 18:
                    XBSAccord9SettingsActi.this.mUpdaterTripbResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 19:
                    XBSAccord9SettingsActi.this.mUpdaterTripaResetTiming(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    XBSAccord9SettingsActi.this.mUpdaterAdjustOutsideTempDisplay(DataCanbus.DATA[updateCode]);
                    break;
                case 21:
                    XBSAccord9SettingsActi.this.mUpdaterFuelEfficiencyBacklight(DataCanbus.DATA[updateCode]);
                    break;
                case 22:
                    XBSAccord9SettingsActi.this.mUpdaterAutoLightSensitivity(DataCanbus.DATA[updateCode]);
                    break;
                case 23:
                    XBSAccord9SettingsActi.this.mUpdaterHeadlightAutOffTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 24:
                    XBSAccord9SettingsActi.this.mUpdaterInteriorLightDimmingTime(DataCanbus.DATA[updateCode]);
                    break;
                case 25:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessLockAnswerBack(DataCanbus.DATA[updateCode]);
                    break;
                case 26:
                    XBSAccord9SettingsActi.this.mUpdaterSecurityRelockTimer(DataCanbus.DATA[updateCode]);
                    break;
                case 27:
                    XBSAccord9SettingsActi.this.mUpdaterKeylessAccessBeepVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 28:
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
                XBSAccord9SettingsActi.this.updateCode = 20;
                XBSAccord9SettingsActi.this.cmdCode = 0;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 53;
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
                XBSAccord9SettingsActi.this.updateCode = 20;
                XBSAccord9SettingsActi.this.cmdCode = 0;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 53;
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
                int value = DataCanbus.DATA[21] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
            }
        });
        this.mTripaResetTiming = (TextView) findViewById(R.id.xp_accord9_tv_tripa_reset_timing);
        this.mBtnTripaResetTimingMinus = (Button) findViewById(R.id.xp_accord9_btn_tripa_reset_timing_minus);
        this.mBtnTripaResetTimingMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 19;
                XBSAccord9SettingsActi.this.cmdCode = 2;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 51;
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
                XBSAccord9SettingsActi.this.updateCode = 19;
                XBSAccord9SettingsActi.this.cmdCode = 2;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 51;
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
                XBSAccord9SettingsActi.this.updateCode = 18;
                XBSAccord9SettingsActi.this.cmdCode = 3;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 52;
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
                XBSAccord9SettingsActi.this.updateCode = 18;
                XBSAccord9SettingsActi.this.cmdCode = 3;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 52;
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
                XBSAccord9SettingsActi.this.updateCode = 24;
                XBSAccord9SettingsActi.this.cmdCode = 4;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 56;
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
                XBSAccord9SettingsActi.this.updateCode = 24;
                XBSAccord9SettingsActi.this.cmdCode = 4;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 56;
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
                XBSAccord9SettingsActi.this.updateCode = 23;
                XBSAccord9SettingsActi.this.cmdCode = 5;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 55;
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
                XBSAccord9SettingsActi.this.updateCode = 23;
                XBSAccord9SettingsActi.this.cmdCode = 5;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 55;
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
                XBSAccord9SettingsActi.this.updateCode = 22;
                XBSAccord9SettingsActi.this.cmdCode = 6;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 54;
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
                XBSAccord9SettingsActi.this.updateCode = 22;
                XBSAccord9SettingsActi.this.cmdCode = 6;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 54;
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
                XBSAccord9SettingsActi.this.updateCode = 25;
                XBSAccord9SettingsActi.this.cmdCode = 10;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 57;
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
                XBSAccord9SettingsActi.this.updateCode = 26;
                XBSAccord9SettingsActi.this.cmdCode = 11;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 58;
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
                XBSAccord9SettingsActi.this.updateCode = 26;
                XBSAccord9SettingsActi.this.cmdCode = 11;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 58;
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
                XBSAccord9SettingsActi.this.updateCode = 27;
                XBSAccord9SettingsActi.this.cmdCode = 12;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 59;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnKeylessAccessBeepVolumePlus = (Button) findViewById(R.id.xp_accord9_btn_keyless_access_beep_volume_plus);
        this.mBtnKeylessAccessBeepVolumePlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 27;
                XBSAccord9SettingsActi.this.cmdCode = 12;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 63;
                }
                int value = DataCanbus.DATA[XBSAccord9SettingsActi.this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(XBSAccord9SettingsActi.this.cmdCode, new int[]{value}, null, null);
            }
        });
        this.mBtnKeylessAccessBeep = (CheckedTextView) findViewById(R.id.xp_accord9_btn_keyless_access_beep);
        this.mBtnKeylessAccessBeep.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9SettingsActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XBSAccord9SettingsActi.this.updateCode = 28;
                XBSAccord9SettingsActi.this.cmdCode = 13;
                if (XBSAccord9SettingsActi.this.isAccord9H()) {
                    XBSAccord9SettingsActi.this.updateCode = 59;
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
            case R.id.xp_ctv_fuel_efficiency_backlight /* 2131430286 */:
                this.updateCode = 61;
                this.cmdCode = 26;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_smart_key_start_guide /* 2131430288 */:
                this.updateCode = 62;
                this.cmdCode = 27;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_energy_save_auto_engine /* 2131430290 */:
                this.updateCode = 64;
                this.cmdCode = 28;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_set_front_hazard_distance_minus /* 2131430292 */:
                this.updateCode = 68;
                this.cmdCode = 29;
                this.value = DataCanbus.DATA[this.updateCode] - 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_btn_set_front_hazard_distance_plus /* 2131430294 */:
                this.updateCode = 68;
                this.cmdCode = 29;
                this.value = DataCanbus.DATA[this.updateCode] + 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_traffic_sign_recognition_sys /* 2131430296 */:
                this.updateCode = 69;
                this.cmdCode = 30;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_acc_tone /* 2131430298 */:
                this.updateCode = 66;
                this.cmdCode = 31;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_btn_minor_lane_departure_sys_settings_minus /* 2131430300 */:
                this.updateCode = 70;
                this.cmdCode = 32;
                this.value = DataCanbus.DATA[this.updateCode] - 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_siyu_btn_minor_lane_departure_sys_settings_plus /* 2131430302 */:
                this.updateCode = 70;
                this.cmdCode = 32;
                this.value = DataCanbus.DATA[this.updateCode] + 1;
                if (this.value < 0) {
                    this.value = 0;
                } else if (this.value > 3) {
                    this.value = 3;
                }
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_pause_lkas_tone /* 2131430304 */:
                this.updateCode = 67;
                this.cmdCode = 33;
                this.value = DataCanbus.DATA[this.updateCode] == 0 ? 1 : 0;
                DataCanbus.PROXY.cmd(this.cmdCode, new int[]{this.value}, null, null);
                break;
            case R.id.xp_ctv_remote_start_system /* 2131430306 */:
                this.updateCode = 60;
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
            DataCanbus.PROXY.cmd(100, new int[]{10}, null, null);
        } else {
            DataCanbus.PROXY.cmd(100, new int[]{4}, null, null);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (isAccord9H()) {
            DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbusAccord9, 1);
            DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbusAccord9, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (isAccord9H()) {
            DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbusAccord9);
            DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbusAccord9);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
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
