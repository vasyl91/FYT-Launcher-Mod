package com.syu.carinfo.rzc.mazda;

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
public class Rzc_Mazda_CarSafeSysSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mazda.Rzc_Mazda_CarSafeSysSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 101:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 104:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 106:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 107:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 109:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 110:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_low);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 4:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text9)).setText("few");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text9)).setText("frequently");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text10)).setText("Rumble");
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view5).setVisibility(8);
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view4).setVisibility(0);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text10)).setText("Beep");
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view4).setVisibility(8);
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view5).setVisibility(0);
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 115:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 116:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text13)).setText(R.string.jeep_parksense_2);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text13)).setText(R.string.jeep_parksense_1);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text14)).setText("+5km/h");
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text14)).setText("+10km/h");
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text14)).setText("+0km/h");
                                break;
                        }
                    }
                    break;
                case 118:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 119:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 120:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text15)).setText(R.string.str_vibration_only);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text15)).setText(R.string.jeep_parksense_0);
                                break;
                        }
                    }
                    break;
                case 121:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 122:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 123:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_mid);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text16)).setText(R.string.wc_372_low);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 124:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 125:
                    switch (value) {
                        case 1:
                            Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view9).setVisibility(0);
                            Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext11), false);
                            break;
                        case 2:
                            Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view9).setVisibility(0);
                            Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext11), true);
                            break;
                        default:
                            Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view9).setVisibility(8);
                            break;
                    }
                case 126:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 127:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text17)).setText(R.string.jeep_parksense_2);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text17)).setText(R.string.jeep_parksense_1);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text17)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text18)).setText(R.string.switch_on_time_medium);
                                break;
                            case 3:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text18)).setText(R.string.switch_on_time_late);
                                break;
                            default:
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text18)).setText(R.string.switch_on_time_early);
                                break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 1:
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view10).setVisibility(0);
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text19)).setText("sound");
                                break;
                            case 2:
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view10).setVisibility(0);
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text19)).setText("vibrate");
                                break;
                            case 3:
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view10).setVisibility(0);
                                ((TextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.tv_text19)).setText("sound + vibrate");
                                break;
                            default:
                                Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.layout_view10).setVisibility(8);
                                break;
                        }
                    }
                    break;
                case 130:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 131:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 132:
                    Rzc_Mazda_CarSafeSysSet.this.setCheck((CheckedTextView) Rzc_Mazda_CarSafeSysSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_mazda_safe_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value7 = DataCanbus.DATA[116] - 1;
                if (value7 < 1) {
                    value7 = 3;
                }
                setCarInfo(7, 2, value7);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value8 = DataCanbus.DATA[116] + 1;
                if (value8 > 3) {
                    value8 = 1;
                }
                setCarInfo(7, 2, value8);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value9 = DataCanbus.DATA[117] - 1;
                if (value9 < 1) {
                    value9 = 3;
                }
                setCarInfo(7, 3, value9);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value10 = DataCanbus.DATA[117] + 1;
                if (value10 > 3) {
                    value10 = 1;
                }
                setCarInfo(7, 3, value10);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                if (DataCanbus.DATA[120] == 1) {
                    value2 = 2;
                } else {
                    value2 = 3;
                }
                setCarInfo(6, 3, value2);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                if (DataCanbus.DATA[120] == 1) {
                    value = 2;
                } else {
                    value = 3;
                }
                setCarInfo(6, 3, value);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value11 = DataCanbus.DATA[100];
                if (value11 == 1) {
                    value11 = 1;
                } else if (value11 == 0) {
                    value11 = 2;
                }
                setCarInfo(1, value11, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value12 = DataCanbus.DATA[101] - 1;
                if (value12 < 1) {
                    value12 = 3;
                }
                setCarInfo(2, value12, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value13 = DataCanbus.DATA[101] + 1;
                if (value13 > 3) {
                    value13 = 1;
                }
                setCarInfo(2, value13, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value14 = DataCanbus.DATA[102] - 1;
                if (value14 < 1) {
                    value14 = 3;
                }
                setCarInfo(1, value14 + 16, 0);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value15 = DataCanbus.DATA[102] + 1;
                if (value15 > 3) {
                    value15 = 1;
                }
                setCarInfo(1, value15 + 16, 0);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value16 = DataCanbus.DATA[103] - 1;
                if (value16 < 1) {
                    value16 = 3;
                }
                setCarInfo(1, value16 + 32, 0);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value17 = DataCanbus.DATA[103] + 1;
                if (value17 > 3) {
                    value17 = 1;
                }
                setCarInfo(1, value17 + 32, 0);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value18 = DataCanbus.DATA[105] - 1;
                if (value18 < 1) {
                    value18 = 3;
                }
                setCarInfo(3, 2, value18);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value19 = DataCanbus.DATA[105] + 1;
                if (value19 > 3) {
                    value19 = 1;
                }
                setCarInfo(3, 2, value19);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value20 = DataCanbus.DATA[107] - 1;
                if (value20 < 1) {
                    value20 = 3;
                }
                setCarInfo(4, 2, value20);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value21 = DataCanbus.DATA[107] + 1;
                if (value21 > 3) {
                    value21 = 1;
                }
                setCarInfo(4, 2, value21);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value22 = DataCanbus.DATA[108] - 1;
                if (value22 < 1) {
                    value22 = 3;
                }
                setCarInfo(4, 3, value22);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value23 = DataCanbus.DATA[108] + 1;
                if (value23 > 3) {
                    value23 = 1;
                }
                setCarInfo(4, 3, value23);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value24 = DataCanbus.DATA[110] - 1;
                if (value24 < 1) {
                    value24 = 3;
                }
                setCarInfo(5, 2, value24);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value25 = DataCanbus.DATA[110] + 1;
                if (value25 > 3) {
                    value25 = 1;
                }
                setCarInfo(5, 2, value25);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value26 = DataCanbus.DATA[111] - 1;
                if (value26 < 1) {
                    value26 = 4;
                }
                setCarInfo(6, 1, value26);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value27 = DataCanbus.DATA[111] + 1;
                if (value27 > 4) {
                    value27 = 1;
                }
                setCarInfo(6, 1, value27);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value28 = DataCanbus.DATA[112] - 1;
                if (value28 < 1) {
                    value28 = 3;
                }
                setCarInfo(6, 2, value28);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value29 = DataCanbus.DATA[112] + 1;
                if (value29 > 3) {
                    value29 = 1;
                }
                setCarInfo(6, 2, value29);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                if (DataCanbus.DATA[113] == 0) {
                    value6 = 2;
                } else {
                    value6 = 1;
                }
                setCarInfo(6, 3, value6);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                if (DataCanbus.DATA[113] == 0) {
                    value5 = 2;
                } else {
                    value5 = 1;
                }
                setCarInfo(6, 3, value5);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value30 = DataCanbus.DATA[114] - 1;
                if (value30 < 1) {
                    value30 = 3;
                }
                setCarInfo(6, 4, value30);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value31 = DataCanbus.DATA[114] + 1;
                if (value31 > 3) {
                    value31 = 1;
                }
                setCarInfo(6, 4, value31);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                if (DataCanbus.DATA[114] == 1) {
                    value4 = 3;
                } else {
                    value4 = 1;
                }
                setCarInfo(6, 4, value4);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                if (DataCanbus.DATA[114] == 1) {
                    value3 = 3;
                } else {
                    value3 = 1;
                }
                setCarInfo(6, 4, value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value32 = DataCanbus.DATA[104];
                if (value32 == 1) {
                    value32 = 1;
                } else if (value32 == 0) {
                    value32 = 2;
                }
                setCarInfo(3, 1, value32);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value33 = DataCanbus.DATA[106];
                if (value33 == 1) {
                    value33 = 1;
                } else if (value33 == 0) {
                    value33 = 2;
                }
                setCarInfo(4, 1, value33);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value34 = DataCanbus.DATA[109];
                if (value34 == 1) {
                    value34 = 1;
                } else if (value34 == 0) {
                    value34 = 2;
                }
                setCarInfo(5, 1, value34);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value35 = DataCanbus.DATA[115];
                if (value35 == 1) {
                    value35 = 1;
                } else if (value35 == 0) {
                    value35 = 2;
                }
                setCarInfo(7, 1, value35);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value36 = DataCanbus.DATA[118];
                if (value36 == 1) {
                    value36 = 1;
                } else if (value36 == 0) {
                    value36 = 2;
                }
                setCarInfo(6, 6, value36);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value37 = DataCanbus.DATA[119];
                if (value37 == 1) {
                    value37 = 1;
                } else if (value37 == 0) {
                    value37 = 2;
                }
                setCarInfo(6, 7, value37);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value38 = DataCanbus.DATA[121];
                if (value38 == 1) {
                    value38 = 1;
                } else if (value38 == 0) {
                    value38 = 2;
                }
                setCarInfo(8, 1, value38);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value39 = DataCanbus.DATA[122];
                if (value39 == 1) {
                    value39 = 1;
                } else if (value39 == 0) {
                    value39 = 2;
                }
                setCarInfo(9, 1, value39);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value40 = DataCanbus.DATA[124];
                if (value40 == 1) {
                    value40 = 2;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(10, value40, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value41 = DataCanbus.DATA[125];
                if (value41 == 1) {
                    value41 = 1;
                } else if (value41 == 0) {
                    value41 = 2;
                }
                setCarInfo(8, 2, value41);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value42 = DataCanbus.DATA[126];
                if (value42 == 1) {
                    value42 = 1;
                } else if (value42 == 0) {
                    value42 = 2;
                }
                setCarInfo(11, 1, value42);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value43 = DataCanbus.DATA[130];
                if (value43 == 1) {
                    value43 = 1;
                } else if (value43 == 0) {
                    value43 = 2;
                }
                setCarInfo(12, 1, value43);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value44 = DataCanbus.DATA[131];
                if (value44 == 1) {
                    value44 = 1;
                } else if (value44 == 0) {
                    value44 = 2;
                }
                setCarInfo(12, 2, value44);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value45 = DataCanbus.DATA[132];
                if (value45 == 1) {
                    value45 = 1;
                } else if (value45 == 0) {
                    value45 = 2;
                }
                setCarInfo(12, 3, value45);
                break;
            case R.id.btn_minus18 /* 2131427878 */:
                int value46 = DataCanbus.DATA[128] - 1;
                if (value46 < 1) {
                    value46 = 3;
                }
                setCarInfo(11, 3, value46);
                break;
            case R.id.btn_plus18 /* 2131427879 */:
                int value47 = DataCanbus.DATA[128] + 1;
                if (value47 > 3) {
                    value47 = 1;
                }
                setCarInfo(11, 3, value47);
                break;
            case R.id.btn_minus19 /* 2131427880 */:
                int value48 = DataCanbus.DATA[129] - 1;
                if (value48 < 1) {
                    value48 = 3;
                }
                setCarInfo(11, 6, value48);
                break;
            case R.id.btn_plus19 /* 2131427881 */:
                int value49 = DataCanbus.DATA[129] + 1;
                if (value49 > 3) {
                    value49 = 1;
                }
                setCarInfo(11, 6, value49);
                break;
            case R.id.btn_minus16 /* 2131427888 */:
                int value50 = DataCanbus.DATA[123] - 1;
                if (value50 < 1) {
                    value50 = 4;
                }
                setCarInfo(9, 2, value50);
                break;
            case R.id.btn_plus16 /* 2131427889 */:
                int value51 = DataCanbus.DATA[123] + 1;
                if (value51 > 4) {
                    value51 = 1;
                }
                setCarInfo(9, 2, value51);
                break;
            case R.id.btn_minus17 /* 2131427890 */:
                int value52 = DataCanbus.DATA[127] - 1;
                if (value52 < 1) {
                    value52 = 3;
                }
                setCarInfo(11, 2, value52);
                break;
            case R.id.btn_plus17 /* 2131427891 */:
                int value53 = DataCanbus.DATA[127] + 1;
                if (value53 > 3) {
                    value53 = 1;
                }
                setCarInfo(11, 2, value53);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{116}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }
}
