package com.syu.carinfo.daojun.ats;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class AtsAirMessageAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    AtsAirMessageAct.this.updaterAutoAirVo();
                    break;
                case 101:
                    AtsAirMessageAct.this.updaterAirQualitySensor1();
                    break;
                case 102:
                    AtsAirMessageAct.this.updaterAutoZoneCon();
                    break;
                case 103:
                    AtsAirMessageAct.this.updaterAutoRearWindowDefogg();
                    break;
                case 104:
                    AtsAirMessageAct.this.updaterAutoFrontWindowDefogg();
                    break;
                case 105:
                    AtsAirMessageAct.this.updaterRemoteSeatAutoHeat();
                    break;
                case 106:
                    AtsAirMessageAct.this.updaterAirConditioning();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_daojun_ats_air_message_set);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.daojun_ats_btn_remote_Seat_auto_heating_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_air_Air_quality_sensor_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_air_Air_quality_sensor_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.daojun_ats_btn_Auto_front_window_defogging_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_btn_Autoc_air_volume_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_btn_Auto_air_volume_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_btn_Air_conditioning_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_btn_Air_conditioning_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_btn_Auto_zone_climate_control_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.daojun_ats_btn_Auto_zone_climate_control_next)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.daojun_ats_btn_Autoc_air_volume_pre /* 2131430780 */:
                int valAutoVolPre = DataCanbus.DATA[100] & 255;
                if (valAutoVolPre == 0) {
                    AtsFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (valAutoVolPre == 1) {
                    AtsFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                } else if (valAutoVolPre == 2) {
                    AtsFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                }
            case R.id.daojun_ats_btn_Auto_air_volume_next /* 2131430782 */:
                int valAutoVolNext = DataCanbus.DATA[100] & 255;
                if (valAutoVolNext == 0) {
                    AtsFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                } else if (valAutoVolNext == 1) {
                    AtsFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (valAutoVolNext == 2) {
                    AtsFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                }
            case R.id.daojun_ats_btn_Air_conditioning_pre /* 2131430784 */:
                int valAirConPre = DataCanbus.DATA[106] & 255;
                if (valAirConPre == 0) {
                    AtsFunc.CAR_AIR_CONTROL(6, 2);
                    break;
                } else if (valAirConPre == 1) {
                    AtsFunc.CAR_AIR_CONTROL(6, 0);
                    break;
                } else if (valAirConPre == 2) {
                    AtsFunc.CAR_AIR_CONTROL(6, 1);
                    break;
                }
            case R.id.daojun_ats_btn_Air_conditioning_next /* 2131430786 */:
                int valAirConNext = DataCanbus.DATA[106] & 255;
                if (valAirConNext == 0) {
                    AtsFunc.CAR_AIR_CONTROL(6, 1);
                    break;
                } else if (valAirConNext == 1) {
                    AtsFunc.CAR_AIR_CONTROL(6, 2);
                    break;
                } else if (valAirConNext == 2) {
                    AtsFunc.CAR_AIR_CONTROL(6, 0);
                    break;
                }
            case R.id.daojun_ats_air_Air_quality_sensor_pre /* 2131430788 */:
                int value = DataCanbus.DATA[101];
                if (value == 0) {
                    AtsFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (value == 1) {
                    AtsFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                } else if (value == 2) {
                    AtsFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                }
            case R.id.daojun_ats_air_Air_quality_sensor_next /* 2131430790 */:
                int valueQualityNext = DataCanbus.DATA[101];
                if (valueQualityNext == 0) {
                    AtsFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                } else if (valueQualityNext == 1) {
                    AtsFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (valueQualityNext == 2) {
                    AtsFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                }
            case R.id.daojun_ats_btn_Auto_zone_climate_control_pre /* 2131430792 */:
                int valAutoZonePre = DataCanbus.DATA[102] & 255;
                if (valAutoZonePre == 0) {
                    AtsFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (valAutoZonePre == 1) {
                    AtsFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                } else if (valAutoZonePre == 2) {
                    AtsFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                }
            case R.id.daojun_ats_btn_Auto_zone_climate_control_next /* 2131430794 */:
                int valAutoZoneNext = DataCanbus.DATA[102] & 255;
                if (valAutoZoneNext == 0) {
                    AtsFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                } else if (valAutoZoneNext == 1) {
                    AtsFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (valAutoZoneNext == 2) {
                    AtsFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                }
            case R.id.daojun_ats_btn_remote_Seat_auto_heating_check /* 2131430796 */:
                int valRemoteSeatHeat = DataCanbus.DATA[105] & 255;
                AtsFunc.CAR_AIR_CONTROL(5, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.daojun_ats_btn_Auto_front_window_defogging_check /* 2131430798 */:
                int valAutFrontDefog = DataCanbus.DATA[104] & 255;
                AtsFunc.CAR_AIR_CONTROL(4, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.daojun_ats_air_Auto_rear_window_defogging_check /* 2131430800 */:
                int valRearWindowDefog = DataCanbus.DATA[103] & 255;
                AtsFunc.CAR_AIR_CONTROL(3, valRearWindowDefog == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
    }

    
    public void updaterAutoAirVo() {
        int switchOn = DataCanbus.DATA[100];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_low);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_middle);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_high);
        }
    }

    
    public void updaterAirConditioning() {
        int switchOn = DataCanbus.DATA[106];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_conditioning_Tv)).setText(R.string.klc_air_last_set);
        }
    }

    
    public void updaterAirQualitySensor1() {
        int switchOn = DataCanbus.DATA[101];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_quality_sensor_tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_quality_sensor_tv)).setText(R.string.klc_air_Low_sensitivity);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_quality_sensor_tv)).setText(R.string.klc_air_high_sensitivity);
        }
    }

    
    public void updaterAutoZoneCon() {
        int switchOn = DataCanbus.DATA[102];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_last_Set);
        }
    }

    
    public void updaterRemoteSeatAutoHeat() {
        int switchOn = DataCanbus.DATA[105] & 255;
        ((CheckedTextView) findViewById(R.id.daojun_ats_btn_remote_Seat_auto_heating_check)).setChecked(switchOn != 0);
    }

    
    public void updaterAutoFrontWindowDefogg() {
        int switchOn = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.daojun_ats_btn_Auto_front_window_defogging_check)).setChecked(switchOn != 0);
    }

    
    public void updaterAutoRearWindowDefogg() {
        int switchOn = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_check)).setChecked(switchOn != 0);
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_Manual);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_auto);
        }
    }
}
