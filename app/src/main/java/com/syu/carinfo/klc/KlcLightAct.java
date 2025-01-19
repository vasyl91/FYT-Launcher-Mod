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

public class KlcLightAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 140:
                    KlcLightAct.this.updateLookIngForLight();
                    break;
                case 141:
                    KlcLightAct.this.updateLuosuoDelay();
                    break;
                case 190:
                    KlcLightAct.this.updateLocationLight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_light_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_btn_Look_for_lightsParking_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_location_lights_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Lasuo_headlight_delay_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_btn_Lasuo_headlight_delay_next)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_Look_for_lightsParking_check /* 2131431877 */:
                int valLightPark = DataCanbus.DATA[140] & 255;
                KlcFunc.C_CAR_LIGHT(1, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Lasuo_headlight_delay_pre /* 2131431879 */:
                int valLasuoDelayPre = DataCanbus.DATA[141] & 255;
                if (valLasuoDelayPre == 0) {
                    KlcFunc.C_CAR_LIGHT(2, 3);
                    break;
                } else if (valLasuoDelayPre == 1) {
                    KlcFunc.C_CAR_LIGHT(2, 0);
                    break;
                } else if (valLasuoDelayPre == 2) {
                    KlcFunc.C_CAR_LIGHT(2, 1);
                    break;
                } else if (valLasuoDelayPre == 3) {
                    KlcFunc.C_CAR_LIGHT(2, 2);
                    break;
                }
            case R.id.klc_btn_Lasuo_headlight_delay_next /* 2131431881 */:
                int valLasuoDelayNext = DataCanbus.DATA[141] & 255;
                if (valLasuoDelayNext == 0) {
                    KlcFunc.C_CAR_LIGHT(2, 1);
                    break;
                } else if (valLasuoDelayNext == 1) {
                    KlcFunc.C_CAR_LIGHT(2, 2);
                    break;
                } else if (valLasuoDelayNext == 2) {
                    KlcFunc.C_CAR_LIGHT(2, 3);
                    break;
                } else if (valLasuoDelayNext == 3) {
                    KlcFunc.C_CAR_LIGHT(2, 0);
                    break;
                }
            case R.id.klc_btn_location_lights_check /* 2131431883 */:
                int valLocationLights = DataCanbus.DATA[190] & 255;
                KlcFunc.C_CAR_LIGHT(3, valLocationLights != 0 ? 0 : 1);
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

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateLookIngForLight() {
        int val = DataCanbus.DATA[140];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            enable = 1;
        }
        if (enable == 0) {
            findViewById(R.id.klc_btn_Look_for_lightsParking_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_btn_Look_for_lightsParking_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_Look_for_lightsParking_check)).setChecked(switchOn != 0);
        }
    }

    
    public void updateLocationLight() {
        int val = DataCanbus.DATA[190];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_btn_location_lights_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_btn_location_lights_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_location_lights_check)).setChecked(switchOn != 0);
        }
    }

    
    public void updateLuosuoDelay() {
        int val = DataCanbus.DATA[141];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_light_Lasuo_headlight_delay_view).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.klc_light_Lasuo_headlight_delay_view).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.klc_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_Parking_with_trailer_Off);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.klc_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.klc_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.klc_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
            }
        }
    }
}
