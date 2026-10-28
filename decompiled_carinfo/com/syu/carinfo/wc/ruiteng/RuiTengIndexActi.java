package com.syu.carinfo.wc.ruiteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RuiTengIndexActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 148:
                    RuiTengIndexActi.this.mUpdaterValue3();
                    RuiTengIndexActi.this.mUpdaterValue4();
                    break;
                case 149:
                    RuiTengIndexActi.this.mUpdaterValue3();
                    RuiTengIndexActi.this.mUpdaterValue4();
                    break;
                case 152:
                    RuiTengIndexActi.this.mUpdaterValue2();
                    break;
                case 159:
                    RuiTengIndexActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_ruiteng_index);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_btn_show_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengLight.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_btn_meter_info)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengMeterAct.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_air_conditioning_control)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, Air_Activity_All_NewAdd_HP.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_btn_functional_state)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengFuncSettings.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengOilAct.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_alarm_record)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTengWarningInfo.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 131354) {
            findViewById(R.id.wc_ruiteng_main_btn_airsystem_set_view).setVisibility(0);
        } else {
            findViewById(R.id.wc_ruiteng_main_btn_airsystem_set_view).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_main_btn_airsystem_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RuiTengIndexActi.this, RuiTeng17YearAirSystemSet.class);
                    RuiTengIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[159];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)) != null) {
            if (value != 0) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[152];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_alarm_record_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value1 = DataCanbus.DATA[149];
        int value2 = DataCanbus.DATA[148];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)) != null) {
            if (value1 == 1 || value2 == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue4() {
        int value1 = DataCanbus.DATA[149];
        int value2 = DataCanbus.DATA[148];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)) != null) {
            if (value1 == 1 || value2 == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_main_btn_oil_mileage_view)).setVisibility(8);
            }
        }
    }
}
