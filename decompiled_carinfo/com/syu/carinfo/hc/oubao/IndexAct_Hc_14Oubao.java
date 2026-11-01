package com.syu.carinfo.hc.oubao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.hc.tianlai.ActivityTianLaiCarCD;
import com.syu.carinfo.hc.tianlai.ActivityTianLaiCarInfo;

@SuppressWarnings({"deprecation", "unchecked"})
public class IndexAct_Hc_14Oubao extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_hc_14oubao_index);
        if (findViewById(R.id.jeep_car_cd) != null) {
            findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_14Oubao.this, ActivityTianLaiCarCD.class);
                        IndexAct_Hc_14Oubao.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (findViewById(R.id.jeep_car_radio) != null) {
            findViewById(R.id.jeep_car_radio).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_14Oubao.this, ActivityTianLaiCarInfo.class);
                        IndexAct_Hc_14Oubao.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
