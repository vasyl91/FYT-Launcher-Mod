package com.syu.carinfo.rzc.mingjueruiteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActRuiTengIndex extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_ruiteng_index);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_carset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent;
                if (196881 == DataCanbus.DATA[1000]) {
                    intent = new Intent(ActRuiTengIndex.this, (Class<?>) Act17RuiTengCarSet.class);
                } else {
                    intent = new Intent(ActRuiTengIndex.this, (Class<?>) ActRuiTengCarSet.class);
                }
                ActRuiTengIndex.this.startActivity(intent);
            }
        });
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_air_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(ActRuiTengIndex.this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                ActRuiTengIndex.this.startActivity(intent);
            }
        });
    }
}
