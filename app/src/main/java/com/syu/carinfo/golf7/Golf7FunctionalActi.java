package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_factory_data_reset), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalFactoryDataResetActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_air_conditioner_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalAirConditionerActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_parking_and_Manoeurvring_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalParkingAndManoeurvrinActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_Tyres_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalTyresActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_driver_assistance_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalDriverAssistanceActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_light_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalLightActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_mirrors_and_wipers_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalMirrorsAndWipersActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_opening_and_closing_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalOpeningAndClosingActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_multifunction_display_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalMultifunctionDisplayActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_esc_system_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalEscSystemActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_driving_mode_in1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalDrivingInfo1Acti.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_hybrid_driving_mode_in1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalHybridDrivingInfo1Acti.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 655377) {
            findViewById(R.id.glf7_functional_btn_hybrid_driving_mode_view).setVisibility(0);
        } else {
            findViewById(R.id.glf7_functional_btn_hybrid_driving_mode_view).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_unit_settings), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalUnitActi.class);
                    Golf7FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (findViewById(R.id.glf7_functional_btn_carcamera_view) != null) {
            if (DataCanbus.DATA[1000] == 327697) {
                setViewVisible(findViewById(R.id.glf7_functional_btn_carcamera_view), true);
                setSelfClick(findViewById(R.id.glf7_functional_btn_carcamera_view), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent();
                            intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalCarCamera.class);
                            Golf7FunctionalActi.this.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                setViewVisible(findViewById(R.id.glf7_functional_btn_carcamera_view), false);
            }
        }
        if (findViewById(R.id.layout_view1) != null) {
            if (DataCanbus.DATA[1000] == 589984) {
                setViewVisible(findViewById(R.id.layout_view1), true);
                setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent();
                            intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalCarTange.class);
                            Golf7FunctionalActi.this.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                setViewVisible(findViewById(R.id.layout_view1), false);
            }
        }
        if (findViewById(R.id.layout_view2) != null) {
            if (ConstGolf.isRZCGolf()) {
                setViewVisible(findViewById(R.id.layout_view2), true);
                setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalActi.16
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent();
                            intent.setClass(Golf7FunctionalActi.this, Golf7FunctionalCarDigitalcockpit.class);
                            Golf7FunctionalActi.this.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                setViewVisible(findViewById(R.id.layout_view2), false);
            }
        }
    }
}
