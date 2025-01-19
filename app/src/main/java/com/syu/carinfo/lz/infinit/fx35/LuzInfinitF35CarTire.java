package com.syu.carinfo.lz.infinit.fx35;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzInfinitF35CarTire extends BaseActivity {
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    LuzInfinitF35CarTire.this.mUpdaterTireFL();
                    break;
                case 107:
                    LuzInfinitF35CarTire.this.mUpdaterTireFR();
                    break;
                case 108:
                    LuzInfinitF35CarTire.this.mUpdaterTireRL();
                    break;
                case 109:
                    LuzInfinitF35CarTire.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_infinit_cartire);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{54}, null, null);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[106];
        if (findViewById(R.id.tv_text1) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text1)).setText(value2 / 100 + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[107];
        if (findViewById(R.id.tv_text2) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text2)).setText(value2 / 100 + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[108];
        if (findViewById(R.id.tv_text3) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text3)).setText(value2 / 100 + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[109];
        if (findViewById(R.id.tv_text4) != null) {
            int value2 = value * 173;
            ((TextView) findViewById(R.id.tv_text4)).setText(value2 / 100 + "." + ((value2 / 100) / 10) + (value2 % 10) + "kpa");
        }
    }
}
