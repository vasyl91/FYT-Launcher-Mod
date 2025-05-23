package com.syu.carinfo.honda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.carinfo.crv.WcCrvActiAll;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivitySiYuIndex extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_index_siyu);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_Honda_12Siyu_CRV /* 1638721 */:
            case FinalCanbus.CAR_WC2_Honda_14Siyu_L /* 1704257 */:
            case FinalCanbus.CAR_WC2_Honda_15CRV_L /* 1769793 */:
            case FinalCanbus.CAR_WC2_Honda_12Siyu /* 1966401 */:
            case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_L /* 3146049 */:
            case FinalCanbus.CAR_WC2_Honda_15CIVIC_OverSea_L /* 3277121 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                break;
            case FinalCanbus.CAR_443_WC_14Aodesai_CD /* 7078331 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                break;
        }
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) WcCrvActiAll.class));
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) Act_WC_CarCD_AoDeSai.class));
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 459073 || DataCanbus.DATA[1000] == 590145 || DataCanbus.DATA[1000] == 1179969 || DataCanbus.DATA[1000] == 4915521 || DataCanbus.DATA[1000] == 1245505 || DataCanbus.DATA[1000] == 1311041 || DataCanbus.DATA[1000] == 524609 || DataCanbus.DATA[1000] == 3080513 || DataCanbus.DATA[1000] == 3146049) {
                    ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) Activity17CRVAirControl.class));
                } else {
                    ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) ActivityAirControl.class));
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ActivitySiYuIndex.this.startActivity(new Intent(ActivitySiYuIndex.this, (Class<?>) HondaIndexActi.class));
            }
        });
    }
}
