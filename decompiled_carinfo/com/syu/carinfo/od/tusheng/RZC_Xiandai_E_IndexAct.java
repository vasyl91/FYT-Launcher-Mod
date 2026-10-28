package com.syu.carinfo.od.tusheng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_Xiandai_E_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_xiandai_e_indexact);
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_Xiandai_E_IndexAct.this, OD_19Tusheng_CarSettingAct.class);
                    RZC_Xiandai_E_IndexAct.this.startActivity(intent);
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
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9_E /* 786879 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K3_E /* 852415 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K5_E /* 917951 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9M_E /* 983487 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9H_E /* 1049023 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_ENCINO /* 3342783 */:
                        case FinalCanbus.CAR_RZC3_XianDai_Qiya_ENCINO_H /* 3408319 */:
                            intent.setClass(RZC_Xiandai_E_IndexAct.this, RZC_XiandaiE_CarSettingAct.class);
                            break;
                    }
                    RZC_Xiandai_E_IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
