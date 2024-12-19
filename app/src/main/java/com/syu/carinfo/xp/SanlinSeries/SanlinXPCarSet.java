package com.syu.carinfo.xp.SanlinSeries;

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
public class SanlinXPCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.SanlinSeries.SanlinXPCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 20:
                    SanlinXPCarSet.this.updateCartype();
                    break;
                case 21:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Once/Unlock:Twice");
                                break;
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Once /Unlock:Off");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Off/Unlock:Twice");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Twice/Unlock:Once");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:OFF/Unlock:Once");
                                break;
                            case 5:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Lock:Twice/Unlock:Off");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text1)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 22:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)).setText("3 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)).setText("5 seconds");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text2)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 23:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("variable");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("variable(by vehicle speed)");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("variable(rain sensing)");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text3)).setText("4 seconds");
                                break;
                        }
                    }
                    break;
                case 24:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 25:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 26:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("4 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("8 seconds");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("16 seconds");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text4)).setText("0 seconds");
                                break;
                        }
                    }
                    break;
                case 27:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text5)).setText("Front/Rear wiper switch on");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text5)).setText("Rear wiper switch on");
                                break;
                        }
                    }
                    break;
                case 28:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 29:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Quite fast");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Normal");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Quite slow");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Slow");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text6)).setText("Fast");
                                break;
                        }
                    }
                    break;
                case 30:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("15 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("30 seconds");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("1 Minute");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("3 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text7)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 31:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)).setText("Front position lamp on");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)).setText("Head lights on");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text8)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 32:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("3 Minutes");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("30 Minutes");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("60 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text9)).setText("Never");
                                break;
                        }
                    }
                    break;
                case 33:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("7.5 seconds");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("15 seconds");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("30 seconds");
                                break;
                            case 4:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("1 Minute");
                                break;
                            case 5:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("2 Minutes");
                                break;
                            case 6:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("3 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text10)).setText("0 second");
                                break;
                        }
                    }
                    break;
                case 34:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text11)).setText("Ignition switch on");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text11)).setText("Ignition switch on or accessory");
                                break;
                        }
                    }
                    break;
                case 35:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 36:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text12)).setText("Long");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text12)).setText("Short");
                                break;
                        }
                    }
                    break;
                case 37:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("1 minute");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("2 minutes");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("3 minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text13)).setText("30 Seconds");
                                break;
                        }
                    }
                    break;
                case 38:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text14)).setText("Driver door only");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text14)).setText("All doors");
                                break;
                        }
                    }
                    break;
                case 39:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)).setText("Connects to gearlever in P position");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)).setText("Connects to ignition switch OFF(LOCK) position");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text15)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 40:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text16)).setText("Automatic");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text16)).setText("Manual");
                                break;
                        }
                    }
                    break;
                case 41:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text17)).setText("Automatic");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text17)).setText("Manual");
                                break;
                        }
                    }
                    break;
                case 42:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)).setText("More airflow to foot");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)).setText("More airflow to windshield");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text18)).setText("Normal");
                                break;
                        }
                    }
                    break;
                case 43:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)).setText("More airflow to face");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)).setText("More airflow to foot");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text19)).setText("Normal");
                                break;
                        }
                    }
                    break;
                case 44:
                    SanlinXPCarSet.this.setCheck((CheckedTextView) SanlinXPCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 45:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("vehicle speed");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("ignition switch ON/OFF(lock) and driver door Open/Closed");
                                break;
                            case 3:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("keyless entry(keyless operation) unlock/lock");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text20)).setText("None");
                                break;
                        }
                    }
                    break;
                case 46:
                    if (((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)).setText("30 Minutes");
                                break;
                            case 2:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)).setText("60 Minutes");
                                break;
                            default:
                                ((TextView) SanlinXPCarSet.this.findViewById(R.id.tv_text21)).setText("Never");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0354_sanlin_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((Button) findViewById(R.id.lz_landrover_btn_tempunit_minus), this);
        setSelfClick((Button) findViewById(R.id.lz_landrover_btn_tempunit_plus), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[37] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarSetInfo(64, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[37] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarSetInfo(64, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[38] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarSetInfo(65, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[38] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarSetInfo(65, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[39] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarSetInfo(66, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[39] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarSetInfo(66, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value7 = DataCanbus.DATA[24];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarSetInfo(17, value7);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value8 = DataCanbus.DATA[21] - 1;
                if (value8 < 0) {
                    value8 = 6;
                }
                setCarSetInfo(1, value8);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value9 = DataCanbus.DATA[21] + 1;
                if (value9 > 6) {
                    value9 = 0;
                }
                setCarSetInfo(1, value9);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value10 = DataCanbus.DATA[22] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarSetInfo(2, value10);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value11 = DataCanbus.DATA[22] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarSetInfo(2, value11);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value12 = DataCanbus.DATA[23] - 1;
                if (value12 < 0) {
                    value12 = 3;
                }
                setCarSetInfo(16, value12);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value13 = DataCanbus.DATA[23] + 1;
                if (value13 > 3) {
                    value13 = 0;
                }
                setCarSetInfo(16, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[26] - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarSetInfo(19, value14);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value15 = DataCanbus.DATA[26] + 1;
                if (value15 > 3) {
                    value15 = 0;
                }
                setCarSetInfo(19, value15);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value16 = DataCanbus.DATA[27] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarSetInfo(20, value16);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value17 = DataCanbus.DATA[27] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarSetInfo(20, value17);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value18 = DataCanbus.DATA[29] - 1;
                if (value18 < 0) {
                    value18 = 4;
                }
                setCarSetInfo(33, value18);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value19 = DataCanbus.DATA[29] + 1;
                if (value19 > 4) {
                    value19 = 0;
                }
                setCarSetInfo(33, value19);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value20 = DataCanbus.DATA[30] - 1;
                if (value20 < 0) {
                    value20 = 4;
                }
                setCarSetInfo(34, value20);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value21 = DataCanbus.DATA[30] + 1;
                if (value21 > 4) {
                    value21 = 0;
                }
                setCarSetInfo(34, value21);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value22 = DataCanbus.DATA[31] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarSetInfo(35, value22);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value23 = DataCanbus.DATA[31] + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                setCarSetInfo(35, value23);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value24 = DataCanbus.DATA[32] - 1;
                if (value24 < 0) {
                    value24 = 3;
                }
                setCarSetInfo(36, value24);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value25 = DataCanbus.DATA[32] + 1;
                if (value25 > 3) {
                    value25 = 0;
                }
                setCarSetInfo(36, value25);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value26 = DataCanbus.DATA[33] - 1;
                if (value26 < 0) {
                    value26 = 6;
                }
                setCarSetInfo(37, value26);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value27 = DataCanbus.DATA[33] + 1;
                if (value27 > 6) {
                    value27 = 0;
                }
                setCarSetInfo(37, value27);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value28 = DataCanbus.DATA[34] - 1;
                if (value28 < 0) {
                    value28 = 1;
                }
                setCarSetInfo(48, value28);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value29 = DataCanbus.DATA[34] + 1;
                if (value29 > 1) {
                    value29 = 0;
                }
                setCarSetInfo(48, value29);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value30 = DataCanbus.DATA[36] - 1;
                if (value30 < 0) {
                    value30 = 1;
                }
                setCarSetInfo(50, value30);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value31 = DataCanbus.DATA[36] + 1;
                if (value31 > 1) {
                    value31 = 0;
                }
                setCarSetInfo(50, value31);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[25];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarSetInfo(18, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[28];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarSetInfo(32, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[35];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarSetInfo(49, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[44];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarSetInfo(84, value35);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value36 = DataCanbus.DATA[42] - 1;
                if (value36 < 0) {
                    value36 = 2;
                }
                setCarSetInfo(82, value36);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value37 = DataCanbus.DATA[42] + 1;
                if (value37 > 2) {
                    value37 = 0;
                }
                setCarSetInfo(82, value37);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value38 = DataCanbus.DATA[43] - 1;
                if (value38 < 0) {
                    value38 = 2;
                }
                setCarSetInfo(83, value38);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value39 = DataCanbus.DATA[43] + 1;
                if (value39 > 2) {
                    value39 = 0;
                }
                setCarSetInfo(83, value39);
                break;
            case R.id.btn_minus21 /* 2131427882 */:
                int value40 = DataCanbus.DATA[46] - 1;
                if (value40 < 0) {
                    value40 = 2;
                }
                setCarSetInfo(97, value40);
                break;
            case R.id.btn_plus21 /* 2131427883 */:
                int value41 = DataCanbus.DATA[46] + 1;
                if (value41 > 2) {
                    value41 = 0;
                }
                setCarSetInfo(97, value41);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value42 = DataCanbus.DATA[40] - 1;
                if (value42 < 0) {
                    value42 = 1;
                }
                setCarSetInfo(80, value42);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value43 = DataCanbus.DATA[40] + 1;
                if (value43 > 1) {
                    value43 = 0;
                }
                setCarSetInfo(80, value43);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value44 = DataCanbus.DATA[41] - 1;
                if (value44 < 0) {
                    value44 = 1;
                }
                setCarSetInfo(81, value44);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value45 = DataCanbus.DATA[41] + 1;
                if (value45 > 1) {
                    value45 = 0;
                }
                setCarSetInfo(81, value45);
                break;
            case R.id.btn_minus20 /* 2131427893 */:
                int value46 = DataCanbus.DATA[45] - 1;
                if (value46 < 0) {
                    value46 = 3;
                }
                setCarSetInfo(96, value46);
                break;
            case R.id.btn_plus20 /* 2131427894 */:
                int value47 = DataCanbus.DATA[45] + 1;
                if (value47 > 3) {
                    value47 = 0;
                }
                setCarSetInfo(96, value47);
                break;
            case R.id.lz_landrover_btn_tempunit_minus /* 2131427895 */:
                int value48 = DataCanbus.DATA[20] - 1;
                if (value48 < 0) {
                    value48 = 1;
                }
                setCarInfo(value48);
                break;
            case R.id.lz_landrover_btn_tempunit_plus /* 2131427897 */:
                int value49 = DataCanbus.DATA[20] + 1;
                if (value49 > 1) {
                    value49 = 0;
                }
                setCarInfo(value49);
                break;
        }
    }

    public void setCarInfo(int value) {
        DataCanbus.PROXY.cmd(0, value);
    }

    public void setCarSetInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCartype() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.tv_lz_landrover_tempunit)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("Type1");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_lz_landrover_tempunit)).setText("Type2");
                    break;
            }
        }
    }
}
