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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class klcAirMessageAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.klcAirMessageAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    updateAutoWindMode();
                    break;
                case 1:
                    updateAIrModeSet();
                    break;
                case 2:
                    updateQualitySensor1();
                    break;
                case 3:
                    updateAirQualitySensor2();
                    break;
                case 4:
                    updateAutoZoomTempSet();
                    break;
                case 5:
                    updateAutoSeatTongfengSet();
                    break;
                case 6:
                    updateAutoHeatSeat();
                    break;
                case 7:
                    updateRemoteStartSeatAutoTongfeng();
                    break;
                case 8:
                    updateRemoteStartSeatAutoHot();
                    break;
                case 10:
                    updateRearZoomTempSet();
                    break;
                case 11:
                    updateAutoFrontFogOn();
                    break;
                case 12:
                    updateAutoRearFogOn();
                    break;
                case 14:
                    updateRemoteStartAir();
                    break;
                case 68:
                    updateRemoteStartSeatAutoHeat1();
                    break;
            }
        }

        private void updateRemoteStartSeatAutoHeat1() {
            int val = DataCanbus.DATA[68];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.wc_weilang_btn_Seat_auto_heat_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.wc_weilang_btn_Seat_auto_heat_view).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.wc_weilang_air_Seat_auto_heat_TV)).setText(R.string.off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.wc_weilang_air_Seat_auto_heat_TV)).setText(R.string.wc_weilang_driver_and_customer);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.wc_weilang_air_Seat_auto_heat_TV)).setText(R.string.wc_weilang_driver);
                }
            }
        }

        private void updateAirQualitySensor2() {
            int val = DataCanbus.DATA[3];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_view).setVisibility(0);
                if (switchOn == 2) {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_check)).setChecked(false);
                } else {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_check)).setChecked(true);
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_Tv)).setText(R.string.klc_air_Low_sensitivity);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_Tv)).setText(R.string.klc_air_high_sensitivity);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_2_Tv)).setText(R.string.off);
                }
            }
        }

        private void updateRemoteStartAir() {
            int val = DataCanbus.DATA[14];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Remote_start_conditioning_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Remote_start_conditioning_view).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Remote_start_conditioning_check)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Remote_start_conditioning_Tv)).setText(R.string.klc_air_Manual);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Remote_start_conditioning_Tv)).setText(R.string.klc_air_auto);
                }
            }
        }

        private void updateAutoRearFogOn() {
            int val = DataCanbus.DATA[12];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_rear_window_defogging_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_rear_window_defogging_view).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_rear_window_defogging_check)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_Manual);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_auto);
                }
            }
        }

        private void updateAutoFrontFogOn() {
            int val = DataCanbus.DATA[11];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_Auto_front_window_defogging_view).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_Auto_front_window_defogging_view).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_btn_Auto_front_window_defogging_check)).setChecked(switchOn != 0);
            }
        }

        private void updateRearZoomTempSet() {
            int val = DataCanbus.DATA[10];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_rear_seat_temp_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_rear_seat_temp_view).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_rear_seat_temp_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_rear_seat_temp_Tv)).setText(R.string.klc_air_Like_last);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_rear_seat_temp_Tv)).setText(R.string.klc_air_last_Set);
                }
            }
        }

        private void updateRemoteStartSeatAutoHot() {
            int val = DataCanbus.DATA[8];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_remote_Seat_auto_heating_view).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_remote_Seat_auto_heating_view).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_btn_remote_Seat_auto_heating_check)).setChecked(switchOn != 0);
            }
        }

        private void updateRemoteStartSeatAutoTongfeng() {
            int val = DataCanbus.DATA[7];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_remote_Seat_auto_ventilation_view).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_remote_Seat_auto_ventilation_view).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_btn_remote_Seat_auto_ventilation_check)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoHeatSeat() {
            int val = DataCanbus.DATA[6];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_Seat_auto_heating_View).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_Seat_auto_heating_View).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_btn_Seat_auto_heating_check)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoSeatTongfengSet() {
            int val = DataCanbus.DATA[5];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_Seat_auto_ventilation_view).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_btn_Seat_auto_ventilation_view).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_btn_Seat_auto_ventilation_check)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoZoomTempSet() {
            int val = DataCanbus.DATA[4];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_view).setVisibility(0);
                if (DataCanbus.DATA[1000] == 308) {
                    if (switchOn == 0) {
                        ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_Tv)).setText(R.string.wc_weilang_danqu);
                        return;
                    } else if (switchOn == 1) {
                        ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_Tv)).setText(R.string.wc_weilang_shuangqu);
                        return;
                    } else {
                        if (switchOn == 2) {
                            ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_last_Set);
                            return;
                        }
                        return;
                    }
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_last_Set);
                }
            }
        }

        private void updateQualitySensor1() {
            int val = DataCanbus.DATA[2];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_view).setVisibility(0);
                if (switchOn == 2) {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_check)).setChecked(false);
                } else {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_check)).setChecked(true);
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_Tv)).setText(R.string.klc_air_Low_sensitivity);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_Tv)).setText(R.string.klc_air_high_sensitivity);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_quality_sensor_1_Tv)).setText(R.string.off);
                }
            }
        }

        private void updateAIrModeSet() {
            int val = DataCanbus.DATA[1];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Air_conditioning_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Air_conditioning_view).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_ON);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Air_conditioning_Tv)).setText(R.string.klc_air_last_set);
                }
            }
        }

        private void updateAutoWindMode() {
            int val = DataCanbus.DATA[0];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Automatic_air_volume_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.klc_air_Automatic_air_volume_view).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_low);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_middle);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.klc_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_high);
                }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_air_message_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_btn_Seat_auto_ventilation_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Seat_auto_heating_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_air_Air_quality_sensor_1_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_remote_Seat_auto_ventilation_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_remote_Seat_auto_heating_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Auto_front_window_defogging_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_air_Auto_rear_window_defogging_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_air_Remote_start_conditioning_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_air_Air_quality_sensor_2_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Autoc_air_volume_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Auto_air_volume_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Air_conditioning_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Air_conditioning_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Auto_zone_climate_control_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Auto_zone_climate_control_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_rear_seat_temp_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_rear_seat_temp_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_weilang_air_Seat_auto_heat_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_weilang_air_Seat_auto_heat_next)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_Autoc_air_volume_pre /* 2131431817 */:
                int valAutoVolPre = DataCanbus.DATA[0] & 255;
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
            case R.id.klc_btn_Auto_air_volume_next /* 2131431819 */:
                int valAutoVolNext = DataCanbus.DATA[0] & 255;
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
            case R.id.klc_btn_Air_conditioning_pre /* 2131431821 */:
                int valAirConPre = DataCanbus.DATA[1] & 255;
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
            case R.id.klc_btn_Air_conditioning_next /* 2131431823 */:
                int valAirConNext = DataCanbus.DATA[1] & 255;
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
            case R.id.klc_air_Air_quality_sensor_1_check /* 2131431825 */:
                int valQuality1 = DataCanbus.DATA[2] & 255;
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
            case R.id.klc_btn_Auto_zone_climate_control_pre /* 2131431828 */:
                int valAutoZonePre = DataCanbus.DATA[4] & 255;
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
            case R.id.klc_btn_Auto_zone_climate_control_next /* 2131431830 */:
                int valAutoZoneNext = DataCanbus.DATA[4] & 255;
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
            case R.id.klc_btn_Seat_auto_ventilation_check /* 2131431832 */:
                int valseat = DataCanbus.DATA[5] & 255;
                KlcFunc.C_CAR_AIR(5, valseat == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Seat_auto_heating_check /* 2131431834 */:
                int valSeatHeat = DataCanbus.DATA[6] & 255;
                KlcFunc.C_CAR_AIR(6, valSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_remote_Seat_auto_ventilation_check /* 2131431836 */:
                int valRemoteSeatven = DataCanbus.DATA[7] & 255;
                KlcFunc.C_CAR_AIR(7, valRemoteSeatven == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_remote_Seat_auto_heating_check /* 2131431838 */:
                int valRemoteSeatHeat = DataCanbus.DATA[8] & 255;
                KlcFunc.C_CAR_AIR(8, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_rear_seat_temp_pre /* 2131431840 */:
                int valSeatTempPre = DataCanbus.DATA[10] & 255;
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
            case R.id.klc_btn_rear_seat_temp_next /* 2131431842 */:
                int valSeatTempNext = DataCanbus.DATA[10] & 255;
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
            case R.id.klc_btn_Auto_front_window_defogging_check /* 2131431844 */:
                int valAutFrontDefog = DataCanbus.DATA[11] & 255;
                KlcFunc.C_CAR_AIR(10, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.klc_air_Auto_rear_window_defogging_check /* 2131431846 */:
                int valRearWindowDefog = DataCanbus.DATA[12] & 255;
                KlcFunc.C_CAR_AIR(11, valRearWindowDefog == 0 ? 1 : 0);
                break;
            case R.id.klc_air_Remote_start_conditioning_check /* 2131431849 */:
                int valRemoteStart = DataCanbus.DATA[14] & 255;
                KlcFunc.C_CAR_AIR(12, valRemoteStart == 0 ? 1 : 0);
                break;
            case R.id.klc_air_Air_quality_sensor_2_check /* 2131431852 */:
                int valQulaity2 = DataCanbus.DATA[3] & 255;
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
            case R.id.wc_weilang_air_Seat_auto_heat_pre /* 2131431855 */:
                int value = DataCanbus.DATA[68] & 255;
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
            case R.id.wc_weilang_air_Seat_auto_heat_next /* 2131431857 */:
                int valueNext = DataCanbus.DATA[68] & 255;
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
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 308 || DataCanbus.DATA[1000] == 357) {
            findViewById(R.id.wc_weilang_btn_Seat_auto_heat_view).setVisibility(0);
        } else {
            findViewById(R.id.wc_weilang_btn_Seat_auto_heat_view).setVisibility(8);
        }
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
    }
}
