package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_FunctionalEscSystemActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 162:
                    Golf7_XP_FunctionalEscSystemActi.this.mUpdaterEscSystem();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_esc_system_xp);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.glf7_btn_esc_system_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[162] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{16, switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[162] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{16, switchOn}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterEscSystem() {
        int switchOn = DataCanbus.DATA[162] & 255;
        if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.Eesc_sport);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_act);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_asr);
        }
    }
}
