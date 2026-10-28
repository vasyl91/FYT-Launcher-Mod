package com.syu.carinfo.hc.rongwei950;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class Hc_Rongwei950_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_hc_rongwei950_index);
        init();
    }

    @Override
    public void init() {
        if (findViewById(R.id.ctv_checkedtext2) != null) {
            findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Hc_Rongwei950_IndexAct.this, Hc_Rongwei950_AirSettingAct.class);
                        Hc_Rongwei950_IndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (findViewById(R.id.ctv_checkedtext1) != null) {
            findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Hc_Rongwei950_IndexAct.this, Hc_Rongwei950_CarSettingAct.class);
                        Hc_Rongwei950_IndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
