package com.syu.carinfo.hc.elysion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class Hc_103_Elysion_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0103_hc_elysion_index);
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
                        intent.setClass(Hc_103_Elysion_IndexAct.this, Hc_103_Elysion_LightAct.class);
                        Hc_103_Elysion_IndexAct.this.startActivity(intent);
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
                        intent.setClass(Hc_103_Elysion_IndexAct.this, Hc_103_Elysion_CarSettingAct.class);
                        Hc_103_Elysion_IndexAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
