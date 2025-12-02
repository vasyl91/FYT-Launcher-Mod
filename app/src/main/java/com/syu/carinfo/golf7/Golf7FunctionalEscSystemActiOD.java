package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalEscSystemActiOD extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 285:
                    Golf7FunctionalEscSystemActiOD.this.mUpdaterEscSystem();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_esc_system_od);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.glf7_btn_esc_system_jj)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(131, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_bz)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(131, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_yd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(131, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_ss)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(131, new int[]{4}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_diy)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(131, new int[]{3}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterEscSystem() {
        int value = DataCanbus.DATA[285];
        ((Button) findViewById(R.id.glf7_btn_esc_system_jj)).setBackgroundResource(value == 2 ? R.drawable.ic_esc_jj_p : R.drawable.ic_esc_jj);
        ((Button) findViewById(R.id.glf7_btn_esc_system_bz)).setBackgroundResource(value == 0 ? R.drawable.ic_esc_bz_p : R.drawable.ic_esc_bz);
        ((Button) findViewById(R.id.glf7_btn_esc_system_yd)).setBackgroundResource(value == 1 ? R.drawable.ic_esc_yd_p : R.drawable.ic_esc_yd);
        ((Button) findViewById(R.id.glf7_btn_esc_system_ss)).setBackgroundResource(value == 4 ? R.drawable.ic_esc_ss_p : R.drawable.ic_esc_ss);
        ((Button) findViewById(R.id.glf7_btn_esc_system_diy)).setBackgroundResource(value == 3 ? R.drawable.ic_esc_diy_p : R.drawable.ic_esc_diy);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }
}
