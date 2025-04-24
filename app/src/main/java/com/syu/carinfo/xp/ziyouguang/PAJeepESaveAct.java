package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepESaveAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_pa_jeep_on2;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 239:
                    Button button = (Button) PAJeepESaveAct.this.findViewById(R.id.btn_pa_jeep_onoff1);
                    if (value != 1) {
                        i = 2130841391;
                    }
                    button.setBackgroundResource(i);
                    break;
                case 240:
                    Button button2 = (Button) PAJeepESaveAct.this.findViewById(R.id.btn_pa_jeep_onoff);
                    if (value != 1) {
                        i = 2130841391;
                    }
                    button2.setBackgroundResource(i);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_e_save);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_pa_jeep_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[240];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(11, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(11, new int[]{1, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_pa_jeep_onoff1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[239];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(11, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(11, new int[]{2, 1}, null, null);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{83}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
    }
}
