package com.syu.carinfo.xfy.xc60;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Xc60SettingsAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 125:
                    Xc60SettingsAct.this.updateCarAudio(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xfy_xc60_setfunc);
        ((Button) findViewById(R.id.xc60_btn_car_audio_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xc60_btn_car_audio_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
    }

    
    public void updateCarAudio(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_xc60_car_audio)).setText(R.string.str_sbd_x80_media_state_15);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_xc60_car_audio)).setText(R.string.crv_source_usb);
                break;
        }
    }
}
