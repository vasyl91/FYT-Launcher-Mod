package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class PSAOrinalCarActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_orinal_car);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.pas_all_btn_down)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(93, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_up)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(92, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_left)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(94, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_right)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(95, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_ok)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(96, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_mode)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(98, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_esc)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(97, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_park)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(99, null, null, null);
            }
        });
        ((Button) findViewById(R.id.pas_all_btn_menu)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(91, null, null, null);
            }
        });
    }
}
