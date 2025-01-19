package com.syu.carinfo.wc.jianghuai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class WcJianghuaiIEV6EIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_jianghuai_iev6e_indexact);
        if (DataCanbus.DATA[1000] == 1114555) {
            findViewById(R.id.wc_jianghuai_carset_view).setVisibility(8);
        }
        ((Button) findViewById(R.id.jeep_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WcJianghuaiIEV6EIndexAct.this, WcJianghuaiCarSet.class);
                    WcJianghuaiIEV6EIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.wc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WcJianghuaiIEV6EIndexAct.this, WcJianghuaiIEV6ECarinfoAct.class);
                    WcJianghuaiIEV6EIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.wc_jianghuai_car_tire)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WcJianghuaiIEV6EIndexAct.this, WcJianghuaiIEV6ETireAct.class);
                    WcJianghuaiIEV6EIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
