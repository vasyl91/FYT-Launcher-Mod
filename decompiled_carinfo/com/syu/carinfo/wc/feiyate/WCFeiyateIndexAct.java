package com.syu.carinfo.wc.feiyate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCFeiyateIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_feiyatei_indexact);
        if (DataCanbus.DATA[1000] != 8126907) {
            findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 8126907 || DataCanbus.DATA[1000] == 8257979 || DataCanbus.DATA[1000] == 8192443 || DataCanbus.DATA[1000] == 8323515 || DataCanbus.DATA[1000] == 8389051 || DataCanbus.DATA[1000] == 14090683 || DataCanbus.DATA[1000] == 8454587 || DataCanbus.DATA[1000] == 8520123 || DataCanbus.DATA[1000] == 8520123 || DataCanbus.DATA[1000] == 3735995 || DataCanbus.DATA[1000] == 3932603 || DataCanbus.DATA[1000] == 3998139 || DataCanbus.DATA[1000] == 7864763 || DataCanbus.DATA[1000] == 12124603 || DataCanbus.DATA[1000] == 12190139 || DataCanbus.DATA[1000] == 12255675 || DataCanbus.DATA[1000] == 12321211 || DataCanbus.DATA[1000] == 12386747) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, WCFeiyateSetFunc.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, WCFeiyateSetFunc2.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, FYTOilMileIndexActi.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_car_tire)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, WCFeiyateTireAct.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
