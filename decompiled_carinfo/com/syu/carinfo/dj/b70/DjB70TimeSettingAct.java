package com.syu.carinfo.dj.b70;

import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DjB70TimeSettingAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_dj_14b70_time_setting);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.dj_14b70_hour_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{97, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{97}, null, null);
            }
        });
        findViewById(R.id.dj_14b70_hour_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{96, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{96}, null, null);
            }
        });
        findViewById(R.id.dj_14b70_minte_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{99, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{99}, null, null);
            }
        });
        findViewById(R.id.dj_14b70_minte_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{98, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{98}, null, null);
            }
        });
        findViewById(R.id.dj_14b70_format_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{101, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{101}, null, null);
            }
        });
        findViewById(R.id.dj_14b70_format_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{100, 1}, null, null);
                DataCanbus.PROXY.cmd(1, new int[]{100}, null, null);
            }
        });
    }
}
