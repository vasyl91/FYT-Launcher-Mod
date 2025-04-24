package com.syu.carinfo.saiou3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.xfl.chuangku.XflCkFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class SO3AirAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    SO3AirAct.this.updaterAutoModeWild();
                    break;
                case 98:
                    SO3AirAct.this.updaterAirQuality();
                    break;
                case 99:
                    SO3AirAct.this.updaterZoonTemp();
                    break;
                case 100:
                    SO3AirAct.this.updaterRearWindowDefog();
                    break;
                case 101:
                    SO3AirAct.this.updaterFrontWindowDefog();
                    break;
                case 102:
                    SO3AirAct.this.mUpdateBackAirState();
                    break;
                case 103:
                    SO3AirAct.this.updaterAirStartMode();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_sb_so3_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.xfl_ck_air_rear_window_auto_foggest_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xfl_ck_air_front_window_auto_foggest_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_btn_Auto_air_volume_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_btn_Auto_air_volume_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_air_Air_quality_sensor_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_air_Air_quality_sensor_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_air_Auto_zone_climate_control_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_air_Auto_zone_climate_control_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_air_start_mode_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_air_start_mode_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_back_air_start_mode_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xfl_ck_back_air_start_mode_next)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xfl_ck_btn_Auto_air_volume_pre /* 2131432807 */:
                int AutoModeWildState = DataCanbus.DATA[97];
                if (AutoModeWildState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (AutoModeWildState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                } else if (AutoModeWildState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                }
            case R.id.xfl_ck_btn_Auto_air_volume_next /* 2131432809 */:
                int AutoModeWildState2 = DataCanbus.DATA[97];
                if (AutoModeWildState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 1);
                    break;
                } else if (AutoModeWildState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 2);
                    break;
                } else if (AutoModeWildState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(0, 0);
                    break;
                }
            case R.id.xfl_ck_air_Air_quality_sensor_pre /* 2131432810 */:
                int AirQualityState = DataCanbus.DATA[98];
                if (AirQualityState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (AirQualityState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                } else if (AirQualityState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                }
            case R.id.xfl_ck_air_Air_quality_sensor_next /* 2131432812 */:
                int AirQualityState2 = DataCanbus.DATA[98];
                if (AirQualityState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 1);
                    break;
                } else if (AirQualityState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 2);
                    break;
                } else if (AirQualityState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(1, 0);
                    break;
                }
            case R.id.xfl_ck_air_Auto_zone_climate_control_pre /* 2131432813 */:
                int ZoonTempState = DataCanbus.DATA[99];
                if (ZoonTempState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (ZoonTempState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                } else if (ZoonTempState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                }
            case R.id.xfl_ck_air_Auto_zone_climate_control_next /* 2131432815 */:
                int ZoonTempState2 = DataCanbus.DATA[99];
                if (ZoonTempState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 1);
                    break;
                } else if (ZoonTempState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 2);
                    break;
                } else if (ZoonTempState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(2, 0);
                    break;
                }
            case R.id.xfl_ck_air_rear_window_auto_foggest_check /* 2131432816 */:
                XflCkFunc.CAR_AIR_CONTROL(5, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.xfl_ck_air_front_window_auto_foggest_check /* 2131432817 */:
                XflCkFunc.CAR_AIR_CONTROL(6, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.xfl_ck_air_start_mode_pre /* 2131432818 */:
                int AirStartModeState = DataCanbus.DATA[103];
                if (AirStartModeState == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 2);
                    break;
                } else if (AirStartModeState == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 0);
                    break;
                } else if (AirStartModeState == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 1);
                    break;
                }
            case R.id.xfl_ck_air_start_mode_next /* 2131432820 */:
                int AirStartModeState2 = DataCanbus.DATA[103];
                if (AirStartModeState2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 1);
                    break;
                } else if (AirStartModeState2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 2);
                    break;
                } else if (AirStartModeState2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(3, 0);
                    break;
                }
            case R.id.xfl_ck_back_air_start_mode_pre /* 2131432821 */:
                int mBackAir = DataCanbus.DATA[102];
                if (mBackAir == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 2);
                    break;
                } else if (mBackAir == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 0);
                    break;
                } else if (mBackAir == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 1);
                    break;
                }
            case R.id.xfl_ck_back_air_start_mode_next /* 2131432823 */:
                int mBackAir2 = DataCanbus.DATA[102];
                if (mBackAir2 == 0) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 2);
                    break;
                } else if (mBackAir2 == 1) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 0);
                    break;
                } else if (mBackAir2 == 2) {
                    XflCkFunc.CAR_AIR_CONTROL(4, 1);
                    break;
                }
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

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAutoModeWild() {
        int AutoModeWildState = DataCanbus.DATA[97];
        if (AutoModeWildState == 0) {
            ((TextView) findViewById(R.id.xfl_ck_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_low);
        } else if (AutoModeWildState == 1) {
            ((TextView) findViewById(R.id.xfl_ck_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_middle);
        } else if (AutoModeWildState == 2) {
            ((TextView) findViewById(R.id.xfl_ck_air_Automatic_air_volume_Tv)).setText(R.string.klc_air_high);
        }
    }

    
    public void updaterAirQuality() {
        int AirQualityState = DataCanbus.DATA[98];
        if (AirQualityState == 0) {
            ((TextView) findViewById(R.id.xfl_ck_air_Air_quality_sensor_TV)).setText(R.string.klc_air_Low_sensitivity);
        } else if (AirQualityState == 1) {
            ((TextView) findViewById(R.id.xfl_ck_air_Air_quality_sensor_TV)).setText(R.string.xfl_ck_middle_sensitivity);
        } else if (AirQualityState == 2) {
            ((TextView) findViewById(R.id.xfl_ck_air_Air_quality_sensor_TV)).setText(R.string.klc_air_high_sensitivity);
        }
    }

    
    public void updaterZoonTemp() {
        int ZoonTempState = DataCanbus.DATA[99];
        if (ZoonTempState == 0) {
            ((TextView) findViewById(R.id.xfl_ck_air_Auto_zone_climate_control_TV)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
        } else if (ZoonTempState == 1) {
            ((TextView) findViewById(R.id.xfl_ck_air_Auto_zone_climate_control_TV)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
        } else if (ZoonTempState == 2) {
            ((TextView) findViewById(R.id.xfl_ck_air_Auto_zone_climate_control_TV)).setText(R.string.klc_air_last_Set);
        }
    }

    
    public void updaterRearWindowDefog() {
        int RearWindowAutoState = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.xfl_ck_air_rear_window_auto_foggest_check)).setChecked(RearWindowAutoState != 0);
    }

    
    public void updaterFrontWindowDefog() {
        int FrontWindowAutoState = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.xfl_ck_air_front_window_auto_foggest_check)).setChecked(FrontWindowAutoState != 0);
    }

    
    public void updaterAirStartMode() {
        int AirStartModeState = DataCanbus.DATA[103];
        if (AirStartModeState == 0) {
            ((TextView) findViewById(R.id.xfl_ck_air_start_mode_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (AirStartModeState == 1) {
            ((TextView) findViewById(R.id.xfl_ck_air_start_mode_Tv)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (AirStartModeState == 2) {
            ((TextView) findViewById(R.id.xfl_ck_air_start_mode_Tv)).setText(R.string.klc_air_last_set);
        }
    }

    
    public void mUpdateBackAirState() {
        int mBackAir = DataCanbus.DATA[102];
        if (mBackAir == 0) {
            ((TextView) findViewById(R.id.xfl_ck_back_air_start_mode_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (mBackAir == 1) {
            ((TextView) findViewById(R.id.xfl_ck_back_air_start_mode_Tv)).setText(R.string.str_sb_saiou3_str3);
        } else if (mBackAir == 2) {
            ((TextView) findViewById(R.id.xfl_ck_back_air_start_mode_Tv)).setText(R.string.str_sb_saiou3_str4);
        }
    }
}
