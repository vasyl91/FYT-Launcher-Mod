package com.syu.carinfo.zhtd.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZhtdBmwIndexFunc extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_indexact);
        findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        findViewById(R.id.rzc_jianghuai_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 5112261 || DataCanbus.DATA[1000] == 3146183 || DataCanbus.DATA[1000] == 16122310) {
                        intent.setClass(ZhtdBmwIndexFunc.this, LZNewAllBBASetFunc.class);
                    } else if (DataCanbus.DATA[1000] == 9568710) {
                        intent.setClass(ZhtdBmwIndexFunc.this, LZNewAllBBANoICSetFunc.class);
                    } else if (DataCanbus.DATA[1000] == 9503174) {
                        intent.setClass(ZhtdBmwIndexFunc.this, LZNewAllFordSetFunc.class);
                    } else {
                        intent.setClass(ZhtdBmwIndexFunc.this, ZhtdBmwSetFunc.class);
                    }
                    ZhtdBmwIndexFunc.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.rzc_jianghuai_carinfo).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 450 || DataCanbus.DATA[1000] == 393666 || DataCanbus.DATA[1000] == 328130 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274 || DataCanbus.DATA[1000] == 655810) {
                        intent.setClass(ZhtdBmwIndexFunc.this, ZhtdBmwNewCarinfoAct.class);
                    } else if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 197058 || DataCanbus.DATA[1000] == 524738) {
                        intent.setClass(ZhtdBmwIndexFunc.this, ZhtdBenzNewCarinfoAct.class);
                    } else if (DataCanbus.DATA[1000] == 131522 || DataCanbus.DATA[1000] == 459202) {
                        intent.setClass(ZhtdBmwIndexFunc.this, ZhtdAudiNewCarinfoAct.class);
                    } else if (DataCanbus.DATA[1000] == 5112261 || DataCanbus.DATA[1000] == 3146183 || DataCanbus.DATA[1000] == 16122310 || DataCanbus.DATA[1000] == 9568710) {
                        intent.setClass(ZhtdBmwIndexFunc.this, LZNewAllBBATireAct.class);
                    } else if (DataCanbus.DATA[1000] == 9503174) {
                        intent.setClass(ZhtdBmwIndexFunc.this, LZNewAllFordTireAct.class);
                    } else {
                        intent.setClass(ZhtdBmwIndexFunc.this, ZhtdBmwCarinfoAct.class);
                    }
                    ZhtdBmwIndexFunc.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
