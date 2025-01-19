package com.syu.carinfo.focus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.R;
import com.syu.carinfo.ford.FordCarSet_XP;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class ActivityIndex_14Festia extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_319_festia_index);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                switch (DataCanbus.DATA[1000]) {
                    case 22:
                    case FinalCanbus.CAR_XP1_Ford_KUGA_2013 /* 65558 */:
                    case FinalCanbus.CAR_XP1_Ford_Ecosport_2013 /* 196630 */:
                    case FinalCanbus.CAR_XP1_Ford_Fiesta_2013 /* 262166 */:
                    case FinalCanbus.CAR_XP1_Ford_CMAX_2013 /* 327702 */:
                    case FinalCanbus.CAR_XP1_Ford_Focus_2015 /* 393238 */:
                    case FinalCanbus.CAR_XP1_Ford_Tourneo_2015 /* 458774 */:
                    case FinalCanbus.CAR_XP1_Ford_Transit_2015 /* 524310 */:
                    case FinalCanbus.CAR_XP1_Ford_KUGA_2017 /* 589846 */:
                        ActivityIndex_14Festia.this.startActivity(new Intent(ActivityIndex_14Festia.this, (Class<?>) FordCarSet_XP.class));
                        break;
                    default:
                        ActivityIndex_14Festia.this.startActivity(new Intent(ActivityIndex_14Festia.this, (Class<?>) ActCarSet_14Festia.class));
                        break;
                }
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ActivityIndex_14Festia.this.startActivity(new Intent(ActivityIndex_14Festia.this, (Class<?>) FocusSyncBtActi.class));
            }
        });
    }
}
