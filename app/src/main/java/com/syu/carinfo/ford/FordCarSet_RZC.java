package com.syu.carinfo.ford;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordCarSet_RZC extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 28:
                    if (((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text1)).setText("℃");
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text1)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 38:
                    FordCarSet_RZC.this.mTowsystem(val);
                    break;
                case 39:
                    FordCarSet_RZC.this.mInformation(val);
                    break;
                case 40:
                    FordCarSet_RZC.this.mWarning(val);
                    break;
                case 41:
                    FordCarSet_RZC.this.mBrightness(val);
                    break;
                case 42:
                    FordCarSet_RZC.this.mUnit(val);
                    break;
                case 43:
                    FordCarSet_RZC.this.mVoicemode(val);
                    break;
                case 44:
                    FordCarSet_RZC.this.mTurnlight(val);
                    break;
                case 45:
                    FordCarSet_RZC.this.mInteriorlighting(val);
                    break;
                case 47:
                    FordCarSet_RZC.this.mRainsensor(val);
                    break;
                case 57:
                    FordCarSet_RZC.this.mAmbientlight(val);
                    break;
                case 58:
                    FordCarSet_RZC.this.mAmbientlightLev(val);
                    break;
                case 60:
                    FordCarSet_RZC.this.mRearViewStay(val);
                    break;
                case 61:
                    FordCarSet_RZC.this.mRearViewZoom(val);
                    break;
                case 62:
                    FordCarSet_RZC.this.mRearViewSplit(val);
                    break;
                case 63:
                    FordCarSet_RZC.this.mBeepVoiceWarn(val);
                    break;
                case 64:
                    FordCarSet_RZC.this.mAutoLightSensor(val);
                    break;
                case 65:
                    FordCarSet_RZC.this.mAutoUnlock(val);
                    break;
                case 66:
                    FordCarSet_RZC.this.mWelcometime(val);
                    break;
                case 67:
                    FordCarSet_RZC.this.mRemoteLock(val);
                    break;
                case 68:
                    FordCarSet_RZC.this.mWirelessCharging(val);
                    break;
                case 69:
                    FordCarSet_RZC.this.mSpeedLock(val);
                    break;
                case 70:
                    FordCarSet_RZC.this.mInterLightTime(val);
                    break;
                case 71:
                    FordCarSet_RZC.this.mRearViewAuto(val);
                    break;
                case 72:
                    FordCarSet_RZC.this.mRearDefrogTime(val);
                    break;
                case 73:
                    FordCarSet_RZC.this.mHomeLightTime(val);
                    break;
                case 90:
                    ((CheckedTextView) FordCarSet_RZC.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    break;
                case 132:
                    ((CheckedTextView) FordCarSet_RZC.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
                    break;
                case 180:
                    if (((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text2)).setText("KPA");
                                break;
                            case 1:
                                ((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text2)).setText("psi");
                                break;
                            case 2:
                                ((TextView) FordCarSet_RZC.this.findViewById(R.id.tv_text2)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 187:
                    ((CheckedTextView) FordCarSet_RZC.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val == 1);
                    break;
                case 188:
                    ((CheckedTextView) FordCarSet_RZC.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val == 1);
                    break;
                case 189:
                    ((CheckedTextView) FordCarSet_RZC.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_xp_yl_carset);
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(0);
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
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(1, new int[]{163, 18}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.3
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[132] & 255;
                if (value2 == 0) {
                    value = 23;
                } else {
                    value = 24;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[187] & 255;
                if (value2 == 0) {
                    value = 30;
                } else {
                    value = 31;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[188] & 255;
                if (value2 == 0) {
                    value = 32;
                } else {
                    value = 33;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[189] & 255;
                if (value2 == 0) {
                    value = 34;
                } else {
                    value = 35;
                }
                DataCanbus.PROXY.cmd(1, new int[]{163, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_zoom)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.8
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_retention)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.9
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_rearview_split)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.10
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_incre_parking)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.11
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_beep_warn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.12
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
        ((Button) findViewById(R.id.xp_ylford_ambientlight_color_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.13
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
        ((Button) findViewById(R.id.xp_ylford_ambientlight_color_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.14
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
        ((Button) findViewById(R.id.xp_ylford_ambientlight_lev_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] & 255;
                int value1 = DataCanbus.DATA[58] & 255;
                if (1900878 == DataCanbus.DATA[1000]) {
                    if (value1 < 100) {
                        value1 += 20;
                    }
                } else if (value1 < 100) {
                    value1 += 5;
                }
                if (value1 > 100) {
                    value1 = 100;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value, value1}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_ambientlight_lev_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] & 255;
                int value1 = DataCanbus.DATA[58] & 255;
                if (1900878 == DataCanbus.DATA[1000]) {
                    if (value1 > 1) {
                        value1 -= 20;
                    }
                } else if (value1 > 1) {
                    value1 -= 5;
                }
                if (value1 < 1) {
                    value1 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value, value1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] & 255;
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{255, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] & 255;
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{255, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[180] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{254, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[180] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{254, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_tyre_monitor)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FordCarSet_RZC.this.dialog(R.string.xp_ylford_set_tyre_monitor_init, 1);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_brightness_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.22
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
        ((Button) findViewById(R.id.xp_ylford_brightness_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.23
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
        ((Button) findViewById(R.id.xp_ylford_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.24
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
        ((Button) findViewById(R.id.xp_ylford_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.25
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.26
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.27
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.28
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_interiorlighting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.29
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_rainsensor)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.30
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
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.31
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
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.32
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
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.33
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
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.34
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
        ((Button) findViewById(R.id.xp_ylford_autolight_sensor_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[64] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{0, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_autolight_sensor_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[64] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{0, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_auto_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.37
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
        ((Button) findViewById(R.id.xp_ylford_welcom_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[66] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_welcom_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[66] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_remote_window)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.40
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_wireless_charging)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.41
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_speed_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.42
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
        ((CheckedTextView) findViewById(R.id.xp_ylford_rearview_auto)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.43
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
        ((Button) findViewById(R.id.xp_ylford_inter_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[70] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_inter_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[70] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_rear_defrosting_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[72] & 255) + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_rear_defrosting_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[72] & 255) - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_home_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.48
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[73] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_home_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.49
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[73] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value}, null, null);
            }
        });
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_36));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
        this.mLauStylelist.add("Thailand");
        this.send_lang = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 18, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 31};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.50
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FordCarSet_RZC.this.mLauStyle == null) {
                    FordCarSet_RZC.this.initLauStyle();
                }
                if (FordCarSet_RZC.this.mLauStyle == null || FordCarSet_RZC.this.mPopShowView == null) {
                    return;
                }
                FordCarSet_RZC.this.mLauStyle.showAtLocation(FordCarSet_RZC.this.mPopShowView, 17, 0, 0);
                FordCarSet_RZC.this.updateLauguageSet();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.51
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                FordCarSet_RZC.this.language_set = position;
                if (FordCarSet_RZC.this.language_set >= 0 && FordCarSet_RZC.this.language_set <= FordCarSet_RZC.this.mLauStylelist.size() && FordCarSet_RZC.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(11, new int[]{164, FordCarSet_RZC.this.send_lang[FordCarSet_RZC.this.language_set]}, null, null);
                }
                FordCarSet_RZC.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.52
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.52.1
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
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_RZC.53
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
