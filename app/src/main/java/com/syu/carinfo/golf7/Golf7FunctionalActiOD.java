package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalActiOD extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 65:
                    Golf7FunctionalActiOD.this.mUpdaterEscSystem();
                    break;
                case 86:
                    Golf7FunctionalActiOD.this.mUpdaterCarLogo();
                    break;
                case 266:
                    Golf7FunctionalActiOD.this.mUpdaterOilBoxset();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_golf7_functional_state_od);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if ((DataCanbus.DATA[1000] == 65576 || DataCanbus.DATA[1000] == 131112 || DataCanbus.DATA[1000] == 196648 || DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) && findViewById(R.id.glf7_functional_air) != null) {
            findViewById(R.id.glf7_functional_air).setVisibility(8);
        }
        if ((DataCanbus.DATA[1000] == 65576 || DataCanbus.DATA[1000] == 131112 || DataCanbus.DATA[1000] == 196648 || DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256) && findViewById(R.id.glf7_functional_btn_driving_mode_view) != null) {
            findViewById(R.id.glf7_functional_btn_driving_mode_view).setVisibility(8);
        }
        ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7OilMileageIndexActiOD.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_maintenance)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7MaintenanceActi_DZSJ.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_factory_data_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalFactoryDataResetActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_air_conditioner_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalAirConditionerActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_parking_and_Manoeurvring_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalParkingAndManoeurvrinActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_Tyres_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalTyresActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_driver_assistance_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalDriverAssistanceActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_light_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalLightActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_mirrors_and_wipers_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalMirrorsAndWipersActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_opening_and_closing_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalOpeningAndClosingActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_multifunction_display_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalMultifunctionDisplayActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[65] & 255;
                if (switchOn2 == 0) {
                    switchOn = 1;
                } else if (switchOn2 == 1) {
                    if (ConstGolf.isWcGolf()) {
                        switchOn = 2;
                    } else {
                        switchOn = 0;
                    }
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(86, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[65] & 255;
                if (switchOn2 == 1) {
                    switchOn = 0;
                } else if (switchOn2 == 0) {
                    if (ConstGolf.isWcGolf()) {
                        switchOn = 2;
                    } else {
                        switchOn = 1;
                    }
                } else {
                    switchOn = 1;
                }
                DataCanbus.PROXY.cmd(86, new int[]{switchOn}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_driving_mode_in1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalDrivingInfo1Acti.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_functional_btn_unit_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalUnitActi.class);
                    Golf7FunctionalActiOD.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (findViewById(R.id.glf7_functional_btn_carcamera_view) != null) {
            if (DataCanbus.DATA[1000] == 327697) {
                findViewById(R.id.glf7_functional_btn_carcamera_view).setVisibility(0);
                findViewById(R.id.glf7_functional_btn_carcamera_view).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.17
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent();
                            intent.setClass(Golf7FunctionalActiOD.this, Golf7FunctionalCarCamera.class);
                            Golf7FunctionalActiOD.this.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                findViewById(R.id.glf7_functional_btn_carcamera_view).setVisibility(8);
            }
        }
        if ((DataCanbus.DATA[1000] != 393233 || DataCanbus.DATA[1000] == 458769) && findViewById(R.id.vw_pictrue_set) != null) {
            findViewById(R.id.vw_pictrue_set).setVisibility(8);
        }
        ((Button) findViewById(R.id.glf7_btn_pictrue_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[86] + 1;
                if (switchOn == 1) {
                    switchOn = 2;
                }
                if (switchOn > 4) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(137, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_pictrue_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[86] - 1;
                if (switchOn == 1) {
                    switchOn = 0;
                }
                if (switchOn < 0) {
                    switchOn = 4;
                }
                DataCanbus.PROXY.cmd(137, new int[]{switchOn}, null, null);
            }
        });
        if (findViewById(R.id.vw_dashboard_on_set) != null) {
            findViewById(R.id.vw_dashboard_on_set).setVisibility(8);
        }
        if (DataCanbus.DATA[264] == 0 && findViewById(R.id.vw_dash_oilbox_set) != null) {
            findViewById(R.id.vw_dash_oilbox_set).setVisibility(8);
        }
        ((Button) findViewById(R.id.glf7_btn_oilbox_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[266] + 1;
                if (switchOn > 6) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(139, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_oilbox_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActiOD.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[266] - 1;
                if (switchOn < 0) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(139, new int[]{switchOn}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            try {
                Intent intent = new Intent();
                intent.setClass(this, Golf7OilMileageIndexActiOD.class);
                startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilBoxset() {
        int value = DataCanbus.DATA[266];
        int switchOn = value & 255;
        switch (switchOn) {
            case 0:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("50L");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("55L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("58L");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("60L");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("63L");
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("66L");
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("70L");
                break;
            default:
                ((TextView) findViewById(R.id.tv_oilbox_set)).setText("50L");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarLogo() {
        int value = DataCanbus.DATA[86];
        int switchOn = value & 255;
        switch (switchOn) {
            case 1:
                ((TextView) findViewById(R.id.tv_pictrue_set)).setText(R.string.golf_carlogo2);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_pictrue_set)).setText(R.string.golf_carlogo1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_pictrue_set)).setText(R.string.golf_carlogo3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_pictrue_set)).setText(R.string.golf_carlogo4);
                break;
            default:
                ((TextView) findViewById(R.id.tv_pictrue_set)).setText(R.string.golf_carlogo2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEscSystem() {
        int value = DataCanbus.DATA[65];
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_esc_system_set)).setText(R.string.esc_system_0);
                return;
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_esc_system_set)).setText(R.string.Eesc_sport);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_esc_system_set)).setText("ASR OFF");
                return;
            }
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_esc_system_set)).setText(R.string.esc_system_0);
        } else {
            ((TextView) findViewById(R.id.tv_esc_system_set)).setText(R.string.esc_system_1);
        }
    }
}
