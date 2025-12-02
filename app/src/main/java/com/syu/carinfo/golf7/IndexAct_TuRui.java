package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class IndexAct_TuRui extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_index);
        init();
        DataCanbus.PROXY.cmd(98, new int[]{255}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!ConstGolf.isRZCGolf() && findViewById(R.id.golf_view_tmps) != null) {
            findViewById(R.id.golf_view_tmps).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 196768) {
            findViewById(R.id.layout_air_control).setVisibility(0);
        } else {
            findViewById(R.id.layout_air_control).setVisibility(8);
        }
        DataCanbus.PROXY.cmd(98, new int[]{255}, null, null);
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_functional_state)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(IndexAct_TuRui.this, Golf7FunctionalActi.class);
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_air_control)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                        intent.setClass(IndexAct_TuRui.this, AirControlMQB_WC_Front.class);
                    }
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_oil_mileage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(IndexAct_TuRui.this, Golf7OilMileageIndexActi.class);
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_convenience_consumers)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(IndexAct_TuRui.this, Golf7ConvenienceAct.class);
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_maintenance_information)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(IndexAct_TuRui.this, Golf7MaintenanceActi.class);
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_alarm_record)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(IndexAct_TuRui.this, Golf7AlarmRecordAct.class);
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_main_btn_start_stop)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(IndexAct_TuRui.this, Golf7StartStopAct.class);
                    IndexAct_TuRui.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (ConstGolf.isRZCGolf()) {
            ((CheckedTextView) findViewById(R.id.glf7_main_btn_tire_pressure)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_TuRui.this, RzcGolfPressureTireAct.class);
                        IndexAct_TuRui.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
