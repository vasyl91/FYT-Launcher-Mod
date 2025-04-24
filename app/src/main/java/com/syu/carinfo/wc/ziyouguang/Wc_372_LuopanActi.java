package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_372_LuopanActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 134:
                    Wc_372_LuopanActi.this.mc1d3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_zyg_luopan);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.wc_372_luopan_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[134] & 255;
                if (value2 < 15) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(6, value);
            }
        });
        ((Button) findViewById(R.id.wc_372_gpsangle_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(8, 1);
                FuncMain.tips(Wc_372_LuopanActi.this.getString(R.string.str_372_calibration));
            }
        });
        if (DataCanbus.DATA[1000] == 131444) {
            findViewById(R.id.wc_372_view_gpsangle).setVisibility(8);
        }
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
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
    }

    
    public void mc1d3() {
        int temp = DataCanbus.DATA[134] & 65535;
        int value = temp & 255;
        int i = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_luopan).setVisibility(0);
        if (((TextView) findViewById(R.id.wc_372_luopan_set_show)) != null) {
            ((TextView) findViewById(R.id.wc_372_luopan_set_show)).setText(new StringBuilder().append(value).toString());
        }
    }
}
