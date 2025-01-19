package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KlcCrashSetAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            switch (updateCode) {
                case 112:
                    KlcCrashSetAct.this.updateBoCheHelpSystemSet();
                    break;
                case 113:
                    KlcCrashSetAct.this.updateCeMangWarnSystemset();
                    break;
                case 114:
                    KlcCrashSetAct.this.updateFangzhuangWarnType();
                    break;
                case 115:
                    KlcCrashSetAct.this.updateBoCheSystemSetTuoKa();
                    break;
                case 116:
                    KlcCrashSetAct.this.update24GhzRadarSet();
                    break;
                case 163:
                    KlcCrashSetAct.this.updateAutoFangzhuang();
                    break;
                case 164:
                    KlcCrashSetAct.this.updateCarNotify();
                    break;
                case 170:
                    KlcCrashSetAct.this.updateCarSettingAssist();
                    break;
                case 171:
                    KlcCrashSetAct.this.updateCarCruiseControl();
                    break;
                case 199:
                    if (enable == 0) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                        break;
                    } else if (enable == 1) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                        if (switchOn == 0) {
                            ((TextView) KlcCrashSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                        } else if (switchOn == 1) {
                            ((TextView) KlcCrashSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
                            break;
                        } else if (switchOn == 2) {
                            ((TextView) KlcCrashSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                            break;
                        }
                    }
                    break;
                case 200:
                    if (enable == 0) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view11).setVisibility(8);
                        break;
                    } else if (enable == 1) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                        ((CheckedTextView) KlcCrashSetAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_crash_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valParkTrailerPre = DataCanbus.DATA[115] & 255;
                if (valParkTrailerPre == 0) {
                    KlcFunc.C_CAR_CRASH(3, 2);
                    break;
                } else if (valParkTrailerPre == 1) {
                    KlcFunc.C_CAR_CRASH(3, 0);
                    break;
                } else if (valParkTrailerPre == 2) {
                    KlcFunc.C_CAR_CRASH(3, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int valParkTrailerNext = DataCanbus.DATA[115] & 255;
                if (valParkTrailerNext == 0) {
                    KlcFunc.C_CAR_CRASH(3, 1);
                    break;
                } else if (valParkTrailerNext == 1) {
                    KlcFunc.C_CAR_CRASH(3, 2);
                    break;
                } else if (valParkTrailerNext == 2) {
                    KlcFunc.C_CAR_CRASH(3, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                int valuepre = DataCanbus.DATA[163] & 255;
                if (valuepre == 0) {
                    KlcFunc.C_CAR_CRASH(6, 2);
                    break;
                } else if (valuepre == 1) {
                    KlcFunc.C_CAR_CRASH(6, 0);
                    break;
                } else if (valuepre == 2) {
                    KlcFunc.C_CAR_CRASH(6, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                int valueNext = DataCanbus.DATA[163] & 255;
                if (valueNext == 0) {
                    KlcFunc.C_CAR_CRASH(6, 1);
                    break;
                } else if (valueNext == 1) {
                    KlcFunc.C_CAR_CRASH(6, 2);
                    break;
                } else if (valueNext == 2) {
                    KlcFunc.C_CAR_CRASH(6, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                int valuepre2 = DataCanbus.DATA[199] & 255;
                if (valuepre2 == 0) {
                    KlcFunc.C_CAR_CRASH(10, 2);
                    break;
                } else if (valuepre2 == 1) {
                    KlcFunc.C_CAR_CRASH(10, 0);
                    break;
                } else if (valuepre2 == 2) {
                    KlcFunc.C_CAR_CRASH(10, 1);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                int valueNext2 = DataCanbus.DATA[199] & 255;
                if (valueNext2 == 0) {
                    KlcFunc.C_CAR_CRASH(10, 1);
                    break;
                } else if (valueNext2 == 1) {
                    KlcFunc.C_CAR_CRASH(10, 2);
                    break;
                } else if (valueNext2 == 2) {
                    KlcFunc.C_CAR_CRASH(10, 0);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int valPark = DataCanbus.DATA[112] & 255;
                KlcFunc.C_CAR_CRASH(1, valPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int valBlind = DataCanbus.DATA[113] & 255;
                KlcFunc.C_CAR_CRASH(2, valBlind == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int valRader = DataCanbus.DATA[116] & 255;
                KlcFunc.C_CAR_CRASH(5, valRader == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int valAlertType = DataCanbus.DATA[114] & 255;
                KlcFunc.C_CAR_CRASH(4, valAlertType == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value = DataCanbus.DATA[164] & 255;
                KlcFunc.C_CAR_CRASH(7, value == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value1 = DataCanbus.DATA[171] & 255;
                KlcFunc.C_CAR_CRASH(9, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value12 = DataCanbus.DATA[170] & 255;
                KlcFunc.C_CAR_CRASH(8, value12 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value13 = DataCanbus.DATA[200] & 255;
                KlcFunc.C_CAR_CRASH(11, value13 == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.layout_view6).setVisibility(0);
        findViewById(R.id.layout_view7).setVisibility(0);
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateBoCheHelpSystemSet() {
        int val = DataCanbus.DATA[112];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
            return;
        }
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    
    public void updateBoCheSystemSetTuoKa() {
        int val = DataCanbus.DATA[115];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_ON);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Trailer);
            }
        }
    }

    
    public void updateCeMangWarnSystemset() {
        int val = DataCanbus.DATA[113];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    
    public void updateFangzhuangWarnType() {
        int val = DataCanbus.DATA[114];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Collision_Alert_Type_Chime_alarm);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Collision_Alert_Type_Seat_alarm);
            }
        }
    }

    
    public void update24GhzRadarSet() {
        int val = DataCanbus.DATA[116];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
        }
    }

    
    public void updateAutoFangzhuang() {
        int val = DataCanbus.DATA[163];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
            }
        }
    }

    
    public void updateCarNotify() {
        int val = DataCanbus.DATA[164];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view7).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
        }
    }

    
    public void updateCarCruiseControl() {
        int val = DataCanbus.DATA[171];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view8).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view8).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
        }
    }

    
    public void updateCarSettingAssist() {
        int val = DataCanbus.DATA[170];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view9).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view9).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_stand_parking);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_incre_parking);
            }
        }
    }
}
