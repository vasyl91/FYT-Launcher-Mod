package com.syu.carinfo.wc.nissan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Wc_360_DspinfoActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Wc_360_DspinfoActi.this.ma6d70();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_360_dspinfo);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.wc_322_volume_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[0] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_322_volume_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[0] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
    }

    
    public void ma6d70() {
        int temp = DataCanbus.DATA[0] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_322_volume_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.klc_Parking_with_trailer_ON);
            } else {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.klc_Parking_with_trailer_Off);
            }
        }
    }
}
