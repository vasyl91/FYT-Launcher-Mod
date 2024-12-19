package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rav4SettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 4:
                    Rav4SettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 5:
                    Rav4SettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 6:
                    Rav4SettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 7:
                    Rav4SettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 8:
                    Rav4SettingsAct.this.mUpdaterAutoAc();
                    break;
                case 9:
                    Rav4SettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 10:
                    Rav4SettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 11:
                    Rav4SettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 12:
                    Rav4SettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 13:
                    Rav4SettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 14:
                    Rav4SettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 15:
                    Rav4SettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 16:
                    Rav4SettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 33:
                    Rav4SettingsAct.this.mUpdaterOuteriorLightOffTime();
                    break;
                case 128:
                    if (value > 3) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("+" + (value - 3));
                        break;
                    } else if (value < 3) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("-" + (3 - value));
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("0");
                        break;
                    }
                case 129:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                        break;
                    }
                case 130:
                    if (value > 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("+" + (value - 2));
                        break;
                    } else if (value < 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("-" + (2 - value));
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("0");
                        break;
                    }
                case 131:
                    if (value > 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("+" + (value - 2));
                        break;
                    } else if (value < 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("-" + (2 - value));
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    }
                case 132:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_only_incline);
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_only_telescoping);
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_incline_telescoping);
                            break;
                    }
                case 133:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 140:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText("Half");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText("All");
                            break;
                    }
                case 141:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText("Stop");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText("Start");
                            break;
                    }
                case 142:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                        break;
                    }
                case 143:
                    if (value == 0) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
                        break;
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rav4_settings);
        init();
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
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios /* 2359590 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios_H /* 2425126 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios /* 2490662 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios_H /* 2556198 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
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
                findViewById(R.id.layout_view18).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(8);
                findViewById(R.id.layout_view20).setVisibility(8);
                findViewById(R.id.layout_view21).setVisibility(8);
                findViewById(R.id.layout_view22).setVisibility(8);
                findViewById(R.id.layout_view23).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view4).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
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
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                break;
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[5] == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[15] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[13] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[7] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[6] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[14] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[10] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[16] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[12] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[8] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[9] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[129] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 11, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 11}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[142] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 17, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 17}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = 0;
                int value2 = DataCanbus.DATA[11];
                if (value2 > 0 && value2 - 1 > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[143] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[143] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130];
                if (value < 4) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value < 4) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[133];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[133];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[140];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[140];
                if (value < 2) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                if (value < 2) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value < 6) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 14, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOuteriorLightOffTime() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.tv_text4)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text4)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.tv_text3)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text3)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[5];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[15];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[13];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[7];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[6];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[14];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[10];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[16];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[12];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[8];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[9];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.tv_text2)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }
}
