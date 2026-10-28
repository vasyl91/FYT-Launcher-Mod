package com.syu.carinfo.zx6606;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.honda.CZHHondaNewCarinfoAct;
import com.syu.carinfo.honda.HondaIndexActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZX6606HondaIndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_zx6606_honda_index);
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ZX6606HondaIndexActi.this, HondaIndexActi.class);
                    ZX6606HondaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                            intent.setClass(ZX6606HondaIndexActi.this, CZHHondaNewCarinfoAct.class);
                            break;
                        default:
                            intent.setClass(ZX6606HondaIndexActi.this, ZX6606HondaNewCarinfoAct.class);
                            break;
                    }
                    ZX6606HondaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
