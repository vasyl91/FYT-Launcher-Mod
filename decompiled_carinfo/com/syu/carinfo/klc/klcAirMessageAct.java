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

@SuppressWarnings({"deprecation", "unchecked"})
public class klcAirMessageAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            switch (updateCode) {
                case 97:
                    updateAutoWindMode();
                    break;
                case 98:
                    updateAIrModeSet();
                    break;
                case 99:
                    updateQualitySensor1();
                    break;
                case 100:
                    updateAirQualitySensor2();
                    break;
                case 101:
                    updateAutoZoomTempSet();
                    break;
                case 102:
                    updateAutoSeatTongfengSet();
                    break;
                case 103:
                    updateAutoHeatSeat();
                    break;
                case 104:
                    updateRemoteStartSeatAutoTongfeng();
                    break;
                case 105:
                    updateRemoteStartSeatAutoHot();
                    break;
                case 107:
                    updateRearZoomTempSet();
                    break;
                case 108:
                    updateAutoFrontFogOn();
                    break;
                case 109:
                    updateAutoRearFogOn();
                    break;
                case 111:
                    updateRemoteStartAir();
                    break;
                case 165:
                    updateRemoteStartSeatAutoHeat1();
                    break;
                case 198:
                    if (enable == 0) {
                        klcAirMessageAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                        break;
                    } else if (enable == 1) {
                        klcAirMessageAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                        if (switchOn == 1) {
                            ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(true);
                            break;
                        } else {
                            ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(false);
                            break;
                        }
                    }
                    break;
            }
        }

        private void updateRemoteStartSeatAutoHeat1() {
            int val = DataCanbus.DATA[165];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view15).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view15).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_driver_and_customer);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_driver);
                }
            }
        }

        private void updateAirQualitySensor2() {
            int val = DataCanbus.DATA[100];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view14).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view14).setVisibility(0);
                if (switchOn == 2) {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(false);
                } else {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(true);
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_Low_sensitivity);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_high_sensitivity);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                }
            }
        }

        private void updateRemoteStartAir() {
            int val = DataCanbus.DATA[111];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view13).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view13).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Manual);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                }
            }
        }

        private void updateAutoRearFogOn() {
            int val = DataCanbus.DATA[109];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view12).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view12).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                }
            }
        }

        private void updateAutoFrontFogOn() {
            int val = DataCanbus.DATA[108];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view11).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
            }
        }

        private void updateRearZoomTempSet() {
            int val = DataCanbus.DATA[107];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_Like_last);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_last_Set);
                }
            }
        }

        private void updateRemoteStartSeatAutoHot() {
            int val = DataCanbus.DATA[105];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view9).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view9).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
            }
        }

        private void updateRemoteStartSeatAutoTongfeng() {
            int val = DataCanbus.DATA[104];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view8).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view8).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoHeatSeat() {
            int val = DataCanbus.DATA[103];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view7).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view7).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoSeatTongfengSet() {
            int val = DataCanbus.DATA[102];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view6).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view6).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoZoomTempSet() {
            int val = DataCanbus.DATA[101];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                if (DataCanbus.DATA[1000] == 308) {
                    if (switchOn == 0) {
                        ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_danqu);
                        return;
                    } else if (switchOn == 1) {
                        ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_shuangqu);
                        return;
                    } else {
                        if (switchOn == 2) {
                            ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
                            return;
                        }
                        return;
                    }
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
                }
            }
        }

        private void updateQualitySensor1() {
            int val = DataCanbus.DATA[99];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                if (switchOn == 2) {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(false);
                } else {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(true);
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_Low_sensitivity);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high_sensitivity);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                }
            }
        }

        private void updateAIrModeSet() {
            int val = DataCanbus.DATA[98];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_ON);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_last_set);
                }
            }
        }

        private void updateAutoWindMode() {
            int val = DataCanbus.DATA[97];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_air_message_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valAutoVolPre = DataCanbus.DATA[97] & 255;
                if (valAutoVolPre == 0) {
                    KlcFunc.C_CAR_AIR(1, 2);
                    break;
                } else if (valAutoVolPre == 1) {
                    KlcFunc.C_CAR_AIR(1, 0);
                    break;
                } else if (valAutoVolPre == 2) {
                    KlcFunc.C_CAR_AIR(1, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int valAutoVolNext = DataCanbus.DATA[97] & 255;
                if (valAutoVolNext == 0) {
                    KlcFunc.C_CAR_AIR(1, 1);
                    break;
                } else if (valAutoVolNext == 1) {
                    KlcFunc.C_CAR_AIR(1, 2);
                    break;
                } else if (valAutoVolNext == 2) {
                    KlcFunc.C_CAR_AIR(1, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                int valAirConPre = DataCanbus.DATA[98] & 255;
                if (valAirConPre == 0) {
                    KlcFunc.C_CAR_AIR(2, 2);
                    break;
                } else if (valAirConPre == 1) {
                    KlcFunc.C_CAR_AIR(2, 0);
                    break;
                } else if (valAirConPre == 2) {
                    KlcFunc.C_CAR_AIR(2, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                int valAirConNext = DataCanbus.DATA[98] & 255;
                if (valAirConNext == 0) {
                    KlcFunc.C_CAR_AIR(2, 1);
                    break;
                } else if (valAirConNext == 1) {
                    KlcFunc.C_CAR_AIR(2, 2);
                    break;
                } else if (valAirConNext == 2) {
                    KlcFunc.C_CAR_AIR(2, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                int valAutoZonePre = DataCanbus.DATA[101] & 255;
                if (valAutoZonePre == 0) {
                    KlcFunc.C_CAR_AIR(4, 2);
                    break;
                } else if (valAutoZonePre == 1) {
                    KlcFunc.C_CAR_AIR(4, 0);
                    break;
                } else if (valAutoZonePre == 2) {
                    KlcFunc.C_CAR_AIR(4, 1);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                int valAutoZoneNext = DataCanbus.DATA[101] & 255;
                if (valAutoZoneNext == 0) {
                    KlcFunc.C_CAR_AIR(4, 1);
                    break;
                } else if (valAutoZoneNext == 1) {
                    KlcFunc.C_CAR_AIR(4, 2);
                    break;
                } else if (valAutoZoneNext == 2) {
                    KlcFunc.C_CAR_AIR(4, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                int valSeatTempPre = DataCanbus.DATA[107] & 255;
                if (valSeatTempPre == 0) {
                    KlcFunc.C_CAR_AIR(9, 2);
                    break;
                } else if (valSeatTempPre == 1) {
                    KlcFunc.C_CAR_AIR(9, 0);
                    break;
                } else if (valSeatTempPre == 2) {
                    KlcFunc.C_CAR_AIR(9, 1);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                int valSeatTempNext = DataCanbus.DATA[107] & 255;
                if (valSeatTempNext == 0) {
                    KlcFunc.C_CAR_AIR(9, 1);
                    break;
                } else if (valSeatTempNext == 1) {
                    KlcFunc.C_CAR_AIR(9, 2);
                    break;
                } else if (valSeatTempNext == 2) {
                    KlcFunc.C_CAR_AIR(9, 0);
                    break;
                }
            case R.id.btn_minus5 /* 2131427467 */:
                int value = DataCanbus.DATA[165] & 255;
                if (value == 0) {
                    KlcFunc.C_CAR_AIR(14, 2);
                    break;
                } else if (value == 1) {
                    KlcFunc.C_CAR_AIR(14, 0);
                    break;
                } else if (value == 2) {
                    KlcFunc.C_CAR_AIR(14, 1);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                int valueNext = DataCanbus.DATA[165] & 255;
                if (valueNext == 0) {
                    KlcFunc.C_CAR_AIR(14, 1);
                    break;
                } else if (valueNext == 1) {
                    KlcFunc.C_CAR_AIR(14, 2);
                    break;
                } else if (valueNext == 2) {
                    KlcFunc.C_CAR_AIR(14, 0);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                KlcFunc.C_CAR_AIR(15, (DataCanbus.DATA[198] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int valQulaity2 = DataCanbus.DATA[100] & 255;
                if (valQulaity2 == 0) {
                    KlcFunc.C_CAR_AIR(13, 1);
                    break;
                } else if (valQulaity2 == 1) {
                    KlcFunc.C_CAR_AIR(13, 2);
                    break;
                } else {
                    KlcFunc.C_CAR_AIR(13, 0);
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int valRemoteStart = DataCanbus.DATA[111] & 255;
                KlcFunc.C_CAR_AIR(12, valRemoteStart == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int valRearWindowDefog = DataCanbus.DATA[109] & 255;
                KlcFunc.C_CAR_AIR(11, valRearWindowDefog == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int valAutFrontDefog = DataCanbus.DATA[108] & 255;
                KlcFunc.C_CAR_AIR(10, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int valRemoteSeatHeat = DataCanbus.DATA[105] & 255;
                KlcFunc.C_CAR_AIR(8, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int valRemoteSeatven = DataCanbus.DATA[104] & 255;
                KlcFunc.C_CAR_AIR(7, valRemoteSeatven == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int valQuality1 = DataCanbus.DATA[99] & 255;
                if (valQuality1 == 0) {
                    KlcFunc.C_CAR_AIR(3, 1);
                    break;
                } else if (valQuality1 == 1) {
                    KlcFunc.C_CAR_AIR(3, 2);
                    break;
                } else {
                    KlcFunc.C_CAR_AIR(3, 0);
                    break;
                }
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int valSeatHeat = DataCanbus.DATA[103] & 255;
                KlcFunc.C_CAR_AIR(6, valSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int valseat = DataCanbus.DATA[102] & 255;
                KlcFunc.C_CAR_AIR(5, valseat == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
    }
}
