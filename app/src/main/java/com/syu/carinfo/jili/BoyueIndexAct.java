package com.syu.carinfo.jili;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class BoyueIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_boyue_index);
        if (DataCanbus.DATA[1000] == 1835147 || DataCanbus.DATA[1000] == 1114251 || DataCanbus.DATA[1000] == 1704075 || DataCanbus.DATA[1000] == 1507467 || DataCanbus.DATA[1000] == 1704126 || DataCanbus.DATA[1000] == 1769662 || DataCanbus.DATA[1000] == 2425285 || DataCanbus.DATA[1000] == 2490821 || DataCanbus.DATA[1000] == 8454597 || DataCanbus.DATA[1000] == 16056773 || DataCanbus.DATA[1000] == 14156230 || DataCanbus.DATA[1000] == 14549446 || DataCanbus.DATA[1000] == 2228679) {
            findViewById(R.id.jeep_car_air).setVisibility(8);
            findViewById(R.id.jeep_car_tire).setVisibility(0);
        } else {
            findViewById(R.id.jeep_car_tire).setVisibility(8);
            findViewById(R.id.jeep_car_air).setVisibility(0);
        }
        if (((Button) findViewById(R.id.jeep_car_settings)) != null) {
            ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        if (DataCanbus.DATA[1000] == 1835147 || DataCanbus.DATA[1000] == 1114251 || DataCanbus.DATA[1000] == 1704075 || DataCanbus.DATA[1000] == 1507467) {
                            intent.setClass(BoyueIndexAct.this, YuanJingX1CarSettingsAct.class);
                        } else if (DataCanbus.DATA[1000] == 1704126 || DataCanbus.DATA[1000] == 1769662) {
                            intent.setClass(BoyueIndexAct.this, RZCNisaanRuiqi6CarSettingsAct.class);
                        } else if (DataCanbus.DATA[1000] == 2425285 || DataCanbus.DATA[1000] == 2490821 || DataCanbus.DATA[1000] == 8454597 || DataCanbus.DATA[1000] == 2228679) {
                            intent.setClass(BoyueIndexAct.this, ODJiliRuilanX3CarSettingsAct.class);
                        } else if (DataCanbus.DATA[1000] == 16056773) {
                            intent.setClass(BoyueIndexAct.this, ODJiliDihaoEVCarSettingsAct.class);
                        } else if (DataCanbus.DATA[1000] == 14156230) {
                            intent.setClass(BoyueIndexAct.this, ODJiliDihaoSCarSettingsAct.class);
                        } else if (DataCanbus.DATA[1000] == 14549446) {
                            intent.setClass(BoyueIndexAct.this, ODJiliYCXZCarSettingsAct.class);
                        } else {
                            intent.setClass(BoyueIndexAct.this, BoyueCarSettingsAct.class);
                        }
                        BoyueIndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (((Button) findViewById(R.id.jeep_car_airset)) != null) {
            ((Button) findViewById(R.id.jeep_car_airset)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(BoyueIndexAct.this, BoyueAirControlAct.class);
                        BoyueIndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (((Button) findViewById(R.id.jeep_car_tireinfo)) != null) {
            ((Button) findViewById(R.id.jeep_car_tireinfo)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        if (DataCanbus.DATA[1000] == 1704126 || DataCanbus.DATA[1000] == 1769662) {
                            intent.setClass(BoyueIndexAct.this, RZCNissanTireAct.class);
                        } else if (DataCanbus.DATA[1000] == 2425285 || DataCanbus.DATA[1000] == 2490821 || DataCanbus.DATA[1000] == 8454597 || DataCanbus.DATA[1000] == 14156230 || DataCanbus.DATA[1000] == 14549446 || DataCanbus.DATA[1000] == 2228679 || DataCanbus.DATA[1000] == 16056773) {
                            intent.setClass(BoyueIndexAct.this, ODJiliRuilanX3TireAct.class);
                        } else {
                            intent.setClass(BoyueIndexAct.this, YuanjingX3TireAct.class);
                        }
                        BoyueIndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
