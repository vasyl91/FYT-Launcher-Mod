package com.syu.carinfo.golf7_xp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class Golf7_XP_FunctionalActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_xp);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{64, 255}, null, null);
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_factory_data_reset), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalFactoryDataResetActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_air_conditioner_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalAirConditionerActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_parking_and_Manoeurvring_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalParkingAndManoeurvrinActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_Tyres_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalTyresActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_carcamera_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalCarCamera.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_driver_assistance_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalDriverAssistanceActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_light_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalLightActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_mirrors_and_wipers_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalMirrorsAndWipersActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_opening_and_closing_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalOpeningAndClosingActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_multifunction_display_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalMultifunctionDisplayActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_esc_system_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalEscSystemActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_driving_mode_in1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalDrivingInfo1Acti.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_functional_btn_unit_settings), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7_XP_FunctionalActi.this, Golf7_XP_FunctionalUnitActi.class);
                    Golf7_XP_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
