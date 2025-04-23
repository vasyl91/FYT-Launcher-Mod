package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XpCompassActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    XpCompassActi.this.compassArea();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_crv_compass);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.xp_crv_compass_calibration)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(2);
            }
        });
        ((Button) findViewById(R.id.xp_crv_btn_compass_area_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[106];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(1, value);
            }
        });
        ((Button) findViewById(R.id.xp_crv_btn_compass_area_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[106];
                if (value < 15) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, value);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    
    public void compassArea() {
        int value = DataCanbus.DATA[106];
        ((TextView) findViewById(R.id.xp_crv_tv_compass_area_plus)).setText(new StringBuilder().append(value).toString());
    }
}
