package com.syu.carinfo.rzc.jianghuai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcJianghuaiIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_indexact);
        if (DataCanbus.sCanbusId != 2621879 && DataCanbus.sCanbusId != 11338167 && DataCanbus.sCanbusId != 11403703 && DataCanbus.sCanbusId != 10879428 && DataCanbus.sCanbusId != 10944964 && DataCanbus.sCanbusId != 6029765 && DataCanbus.sCanbusId != 6095301) {
            findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(8);
        } else {
            findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(0);
        }
        if (DataCanbus.sCanbusId == 6029765 || DataCanbus.sCanbusId == 6095301) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_guandao_amp);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
        }
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiSetFunc.class);
                    RzcJianghuaiIndexAct.this.startActivity(intent);
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
                    if (DataCanbus.sCanbusId == 6029765 || DataCanbus.sCanbusId == 6095301) {
                        intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiAmpSetFunc.class);
                    } else {
                        intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiCarinfoAct.class);
                    }
                    RzcJianghuaiIndexAct.this.startActivity(intent);
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
                    intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiTireAct.class);
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
