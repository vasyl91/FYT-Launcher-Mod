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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AtsAirMessageAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.ats.AtsAirMessageAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 2:
                    AtsAirMessageAct.this.updaterAutoAirVo();
                    break;
                case 3:
                    AtsAirMessageAct.this.updaterAirQualitySensor1();
                    break;
                case 4:
                    AtsAirMessageAct.this.updaterAutoZoneCon();
                    break;
                case 5:
                    AtsAirMessageAct.this.updaterAutoRearWindowDefogg();
                    break;
                case 6:
                    AtsAirMessageAct.this.updaterAutoFrontWindowDefogg();
                    break;
                case 7:
                    AtsAirMessageAct.this.updaterRemoteSeatAutoHeat();
                    break;
                case 8:
                    AtsAirMessageAct.this.updaterAirConditioning();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_daojun_ats_air_message_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.daojun_ats_btn_Autoc_air_volume_pre /* 2131430803 */:
                int valAutoVolPre = DataCanbus.DATA[2] & 255;
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
            case R.id.daojun_ats_btn_Auto_air_volume_next /* 2131430805 */:
                int valAutoVolNext = DataCanbus.DATA[2] & 255;
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
            case R.id.daojun_ats_btn_Air_conditioning_pre /* 2131430807 */:
                int valAirConPre = DataCanbus.DATA[8] & 255;
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
            case R.id.daojun_ats_btn_Air_conditioning_next /* 2131430809 */:
                int valAirConNext = DataCanbus.DATA[8] & 255;
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
            case R.id.daojun_ats_air_Air_quality_sensor_pre /* 2131430811 */:
                int value = DataCanbus.DATA[3];
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
            case R.id.daojun_ats_air_Air_quality_sensor_next /* 2131430813 */:
                int valueQualityNext = DataCanbus.DATA[3];
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
            case R.id.daojun_ats_btn_Auto_zone_climate_control_pre /* 2131430815 */:
                int valAutoZonePre = DataCanbus.DATA[4] & 255;
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
            case R.id.daojun_ats_btn_Auto_zone_climate_control_next /* 2131430817 */:
                int valAutoZoneNext = DataCanbus.DATA[4] & 255;
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
            case R.id.daojun_ats_btn_remote_Seat_auto_heating_check /* 2131430819 */:
                int valRemoteSeatHeat = DataCanbus.DATA[7] & 255;
                AtsFunc.CAR_AIR_CONTROL(5, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.daojun_ats_btn_Auto_front_window_defogging_check /* 2131430821 */:
                int valAutFrontDefog = DataCanbus.DATA[6] & 255;
                AtsFunc.CAR_AIR_CONTROL(4, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.daojun_ats_air_Auto_rear_window_defogging_check /* 2131430823 */:
                int valRearWindowDefog = DataCanbus.DATA[5] & 255;
                AtsFunc.CAR_AIR_CONTROL(3, valRearWindowDefog == 0 ? 1 : 0);
                break;
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
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAirVo() {
        int switchOn = DataCanbus.DATA[2];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_low);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_middle);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirConditioning() {
        int switchOn = DataCanbus.DATA[8];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_conditioning_Tv)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_conditioning_Tv)).setText(R.string.klc_air_last_set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAirQualitySensor1() {
        int switchOn = DataCanbus.DATA[3];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_quality_sensor_tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_quality_sensor_tv)).setText(R.string.klc_air_Low_sensitivity);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Air_quality_sensor_tv)).setText(R.string.klc_air_high_sensitivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoZoneCon() {
        int switchOn = DataCanbus.DATA[4];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_zone_climate_control_Tv)).setText(R.string.klc_air_last_Set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteSeatAutoHeat() {
        int switchOn = DataCanbus.DATA[7] & 255;
        ((CheckedTextView) findViewById(R.id.daojun_ats_btn_remote_Seat_auto_heating_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoFrontWindowDefogg() {
        int switchOn = DataCanbus.DATA[6];
        ((CheckedTextView) findViewById(R.id.daojun_ats_btn_Auto_front_window_defogging_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoRearWindowDefogg() {
        int switchOn = DataCanbus.DATA[5];
        ((CheckedTextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_check)).setChecked(switchOn != 0);
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_Manual);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.daojun_ats_air_Auto_rear_window_defogging_Tv)).setText(R.string.klc_air_auto);
        }
    }
}
