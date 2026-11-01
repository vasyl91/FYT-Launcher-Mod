package com.syu.carinfo.oudi.changan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class OdChanganSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 162:
                    OdChanganSetFunc.this.updateAmbientlightLev(value);
                    break;
                case 163:
                    OdChanganSetFunc.this.mUpdaterAmbientlightOn(value);
                    break;
                case 164:
                    OdChanganSetFunc.this.mUpdaterSeatPleaseOn(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_odchangan_setfunc);
        ((Button) findViewById(R.id.changan_btn_ambient_light_lev_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[162] - 1;
                if (value < 1) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_ambient_light_lev_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[162] + 1;
                if (value > 7) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[163];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{148, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[164];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{147, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
    }

    
    public void updateAmbientlightLev(int value) {
        ((TextView) findViewById(R.id.tv_changan_ambient_light)).setText(String.format("%d", Integer.valueOf(value)));
    }

    
    public void mUpdaterAmbientlightOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterSeatPleaseOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)).setChecked(value == 1);
        }
    }
}
