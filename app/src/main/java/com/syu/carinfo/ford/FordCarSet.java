package com.syu.carinfo.ford;

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
public class FordCarSet extends BaseActivity {
    int val = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            FordCarSet.this.val = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 38:
                    FordCarSet.this.mTowsystem(FordCarSet.this.val);
                    break;
                case 39:
                    FordCarSet.this.mInformation(FordCarSet.this.val);
                    break;
                case 40:
                    FordCarSet.this.mWarning(FordCarSet.this.val);
                    break;
                case 41:
                    FordCarSet.this.mBrightness(FordCarSet.this.val);
                    break;
                case 42:
                    FordCarSet.this.mUnit(FordCarSet.this.val);
                    break;
                case 43:
                    FordCarSet.this.mVoicemode(FordCarSet.this.val);
                    break;
                case 44:
                    FordCarSet.this.mTurnlight(FordCarSet.this.val);
                    break;
                case 45:
                    FordCarSet.this.mInteriorlighting(FordCarSet.this.val);
                    break;
                case 47:
                    FordCarSet.this.mRainsensor(FordCarSet.this.val);
                    break;
                case 57:
                    FordCarSet.this.mAmbientlight(FordCarSet.this.val);
                    break;
                case 58:
                    FordCarSet.this.mAmbientlightLev(FordCarSet.this.val);
                    break;
                case 60:
                    FordCarSet.this.mRearViewStay(FordCarSet.this.val);
                    break;
                case 61:
                    FordCarSet.this.mRearViewZoom(FordCarSet.this.val);
                    break;
                case 62:
                    FordCarSet.this.mRearViewSplit(FordCarSet.this.val);
                    break;
                case 63:
                    FordCarSet.this.mBeepVoiceWarn(FordCarSet.this.val);
                    break;
                case 64:
                    FordCarSet.this.mAutoLightSensor(FordCarSet.this.val);
                    break;
                case 65:
                    FordCarSet.this.mAutoUnlock(FordCarSet.this.val);
                    break;
                case 66:
                    FordCarSet.this.mWelcometime(FordCarSet.this.val);
                    break;
                case 67:
                    FordCarSet.this.mRemoteLock(FordCarSet.this.val);
                    break;
                case 68:
                    FordCarSet.this.mWirelessCharging(FordCarSet.this.val);
                    break;
                case 69:
                    FordCarSet.this.mSpeedLock(FordCarSet.this.val);
                    break;
                case 70:
                    FordCarSet.this.mInterLightTime(FordCarSet.this.val);
                    break;
                case 71:
                    FordCarSet.this.mRearViewAuto(FordCarSet.this.val);
                    break;
                case 72:
                    FordCarSet.this.mRearDefrogTime(FordCarSet.this.val);
                    break;
                case 73:
                    FordCarSet.this.mHomeLightTime(FordCarSet.this.val);
                    break;
                case 90:
                    ((CheckedTextView) FordCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(FordCarSet.this.val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_carset);
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(0);
        findViewById(R.id.layout_view29).setVisibility(8);
        if (DataCanbus.DATA[1000] == 459086 || 1179982 == DataCanbus.DATA[1000] || 1245518 == DataCanbus.DATA[1000]) {
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(8);
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(0);
            findViewById(R.id.layout_view19).setVisibility(0);
            findViewById(R.id.layout_view20).setVisibility(0);
            findViewById(R.id.layout_view21).setVisibility(0);
            findViewById(R.id.layout_view22).setVisibility(0);
            findViewById(R.id.layout_view23).setVisibility(0);
            findViewById(R.id.layout_view24).setVisibility(0);
            findViewById(R.id.layout_view25).setVisibility(0);
            findViewById(R.id.layout_view26).setVisibility(0);
            findViewById(R.id.layout_view27).setVisibility(0);
            findViewById(R.id.layout_view28).setVisibility(8);
        } else {
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(0);
            findViewById(R.id.layout_view12).setVisibility(0);
            findViewById(R.id.layout_view13).setVisibility(0);
            findViewById(R.id.layout_view14).setVisibility(0);
            findViewById(R.id.layout_view15).setVisibility(0);
            findViewById(R.id.layout_view16).setVisibility(0);
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(8);
            findViewById(R.id.layout_view21).setVisibility(8);
            findViewById(R.id.layout_view22).setVisibility(8);
            findViewById(R.id.layout_view23).setVisibility(8);
            findViewById(R.id.layout_view24).setVisibility(8);
            findViewById(R.id.layout_view25).setVisibility(8);
            findViewById(R.id.layout_view26).setVisibility(8);
            findViewById(R.id.layout_view27).setVisibility(8);
            findViewById(R.id.layout_view28).setVisibility(0);
        }
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(1, new int[]{163, 18}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[90] & 255;
                if (value2 == 0) {
                    value = 21;
                } else {
                    value = 22;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_zoom)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[61] & 255;
                if (value2 == 0) {
                    value = 19;
                } else {
                    value = 18;
                }
                DataCanbus.PROXY.cmd(1, new int[]{171, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_retention)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[60] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{174, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_split)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[62] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{175, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_incre_parking)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[43] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{173, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_beep_warn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[63] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{166, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_ambientlight_color_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] & 255;
                int value1 = DataCanbus.DATA[58] & 255;
                int value2 = value + 1;
                if (value2 > 7) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value2, value1}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_ambientlight_color_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] & 255;
                int value1 = DataCanbus.DATA[58] & 255;
                int value2 = value - 1;
                if (value2 < 1) {
                    value2 = 7;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value2, value1}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_ambientlight_lev_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] & 255;
                int value1 = DataCanbus.DATA[58] & 255;
                if (value1 < 100) {
                    value1 += 5;
                }
                if (value1 > 100) {
                    value1 = 100;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value, value1}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_ambientlight_lev_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] & 255;
                int value1 = DataCanbus.DATA[58] & 255;
                if (value1 > 1) {
                    value1 -= 5;
                }
                if (value1 < 1) {
                    value1 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value, value1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_tyre_monitor)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FordCarSet.this.dialog(R.string.xp_ylford_set_tyre_monitor_init, 1);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_brightness_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[41] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_brightness_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[41] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[42] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[42] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.18
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[38] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.19
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[39] & 255;
                if (value2 == 0) {
                    value = 6;
                } else {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.20
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[40] & 255;
                if (value2 == 0) {
                    value = 8;
                } else {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_interiorlighting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.21
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[45] & 255;
                if (value2 == 0) {
                    value = 19;
                } else {
                    value = 20;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_rainsensor)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.22
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[47] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{165, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[44] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[44] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[43] & 255;
                if (value2 < 4) {
                    value = value2 + 10;
                } else {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[43] & 255;
                if (value2 > 0) {
                    value = value2 + 8;
                } else {
                    value = 13;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_autolight_sensor_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[64] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{0, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_autolight_sensor_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[64] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{0, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_auto_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.29
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[65] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_welcom_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[66] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_welcom_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[66] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_remote_window)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.32
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[67] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_wireless_charging)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.33
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[68] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_speed_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.34
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[69] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_rearview_auto)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.35
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[71] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_inter_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[70] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_inter_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[70] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_rear_defrosting_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[72] & 255) + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_rear_defrosting_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[72] & 255) - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_home_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[73] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_home_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[73] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value}, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHomeLightTime(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_home_light_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_home_light_set_show)).setText("30s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_home_light_set_show)).setText("1m");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_home_light_set_show)).setText("2m");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_ylford_home_light_set_show)).setText("3m");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearDefrogTime(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_rear_defrosting_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_rear_defrosting_set_show)).setText("5m");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_rear_defrosting_set_show)).setText("10m");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearViewAuto(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_rearview_auto)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_rearview_auto)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mInterLightTime(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_inter_light_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_inter_light_set_show)).setText("5m");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_inter_light_set_show)).setText("10m");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_inter_light_set_show)).setText("15m");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSpeedLock(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_speed_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_speed_lock)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mWirelessCharging(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_wireless_charging)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_wireless_charging)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRemoteLock(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_remote_window)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_remote_window)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mWelcometime(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_welcom_light_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_welcom_light_set_show)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_welcom_light_set_show)).setText("15s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_welcom_light_set_show)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_ylford_welcom_light_set_show)).setText("60s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAutoUnlock(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_auto_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_auto_unlock)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAutoLightSensor(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_autolight_sensor_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_autolight_sensor_set_show)).setText(R.string.klc_air_low);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_autolight_sensor_set_show)).setText(R.string.klc_air_middle);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_autolight_sensor_set_show)).setText(R.string.klc_air_high);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTowsystem(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mInformation(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mWarning(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mInteriorlighting(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_interiorlighting)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_interiorlighting)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRainsensor(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_rainsensor)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_rainsensor)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBeepVoiceWarn(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_beep_warn)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_beep_warn)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearViewSplit(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_split)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_split)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearViewZoom(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_zoom)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_zoom)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearViewStay(int temp) {
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_retention)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_retention)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mVoicemode(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.klc_onstar_close);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.klc_air_auto);
                    break;
            }
        }
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_incre_parking)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_incre_parking)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBrightness(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_brightness_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_brightness_set_show)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_brightness_set_show)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTurnlight(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAmbientlight(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)) != null) {
            if (DataCanbus.sCanbusId == 459086 || 1179982 == DataCanbus.DATA[1000] || 1245518 == DataCanbus.DATA[1000]) {
                switch (temp) {
                    case 0:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.off);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_7);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_3);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_8);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_6);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_5);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_4);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_2);
                        break;
                }
            }
            switch (temp) {
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_2);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.color_orange_str);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.color_mediumblue_str);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_3);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_4);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_5);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.xp_ylford_ambientlight_color_set_show)).setText(R.string.str_403_ambient_6);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAmbientlightLev(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_ambientlight_lev_set_show)) != null) {
            ((TextView) findViewById(R.id.xp_ylford_ambientlight_lev_set_show)).setText(new StringBuilder().append(temp).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUnit(int temp) {
        if (((TextView) findViewById(R.id.xp_ylford_unit_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_unit_set_show)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_unit_set_show)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                    break;
            }
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.42
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.ford.FordCarSet.42.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i == 1) {
                            DataCanbus.PROXY.cmd(1, new int[]{169, 1}, null, null);
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet.43
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
