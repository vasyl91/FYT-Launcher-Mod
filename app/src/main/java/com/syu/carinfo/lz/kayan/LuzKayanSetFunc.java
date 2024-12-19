package com.syu.carinfo.lz.kayan;

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
public class LuzKayanSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    LuzKayanSetFunc.this.updateInterlightOfftime(value);
                    break;
                case 12:
                    LuzKayanSetFunc.this.updateInterlight(value);
                    break;
                case 13:
                    LuzKayanSetFunc.this.updateDayTimeLight(value);
                    break;
                case 14:
                    LuzKayanSetFunc.this.updateWiperSensorType(value);
                    break;
                case 15:
                    LuzKayanSetFunc.this.updateWiperRearType(value);
                    break;
                case 16:
                    LuzKayanSetFunc.this.updateReversingOptions(value);
                    break;
                case 17:
                    LuzKayanSetFunc.this.updateDoorUnlockType(value);
                    break;
                case 18:
                    LuzKayanSetFunc.this.updateDoorlockType(value);
                    break;
                case 19:
                    LuzKayanSetFunc.this.updateComfortEntry(value);
                    break;
                case 20:
                    LuzKayanSetFunc.this.updateAirPanel(value);
                    break;
                case 21:
                    LuzKayanSetFunc.this.updateAirAutoCirc(value);
                    break;
                case 22:
                    LuzKayanSetFunc.this.updateAirStyleType(value);
                    break;
                case 23:
                    LuzKayanSetFunc.this.updateOutlightOfftime(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_luz_kayan_setfunc);
        ((Button) findViewById(R.id.luz_kayan_intlight_offtime_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[11] - 1;
                if (value < 0) {
                    value = 30;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_intlight_offtime_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[11] + 1;
                if (value > 30) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_intamblight_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[12] - 1;
                if (value < 0) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_intamblightplus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[12] + 1;
                if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[13];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_outlight_offtime_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] - 1;
                if (value < 1) {
                    value = 12;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_outlight_offtime_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[23] + 1;
                if (value > 12) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_wiper_rainauto_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_wiper_rainauto_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_rear_wiper_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[15] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_rear_wiper_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[15] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[16];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_unlock_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[17] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_unlock_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[17] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_lock_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[18] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_lock_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[18] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[19];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[20];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[21];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_air_conditioning_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_air_conditioning_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirStyleType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.mateng_air_con_profile_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.mateng_air_con_profile_2);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAutoCirc(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirPanel(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComfortEntry(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorlockType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_door_lock)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.str_ignition_on_lock);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.jeep_runautolock);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlockType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)).setText(R.string.xp_psa_all_string_door_open_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)).setText(R.string.xp_psa_all_string_door_open_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReversingOptions(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWiperRearType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWiperSensorType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutlightOfftime(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_luz_kayan_outlight_offtime)) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_outlight_offtime)).setText(String.valueOf(value2) + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDayTimeLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterlight(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_luz_kayan_intamblight)) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_intamblight)).setText(String.valueOf(value2) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterlightOfftime(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_luz_kayan_intlight_offtime)) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_intlight_offtime)).setText(String.valueOf(value2) + "s");
        }
    }
}
