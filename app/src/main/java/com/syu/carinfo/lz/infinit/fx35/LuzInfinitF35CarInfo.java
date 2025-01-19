package com.syu.carinfo.lz.infinit.fx35;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzInfinitF35CarInfo extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                case 103:
                    LuzInfinitF35CarInfo.this.mUpdateWaterTemp();
                    break;
                case 100:
                    LuzInfinitF35CarInfo.this.mUpdateSpeed();
                    break;
                case 101:
                    LuzInfinitF35CarInfo.this.mUpdateMile();
                    break;
                case 102:
                    ((TextView) LuzInfinitF35CarInfo.this.findViewById(R.id.tv_text4)).setText(value + " Rpm");
                    break;
                case 104:
                    LuzInfinitF35CarInfo.this.mUpdateSpeed();
                    LuzInfinitF35CarInfo.this.mUpdateMile();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_infinit_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{53}, null, null);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateWaterTemp() {
        int value = DataCanbus.DATA[99];
        if (value >= 40) {
            int value2 = value - 40;
            if (DataCanbus.DATA[103] == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(value2 + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(value2 + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (DataCanbus.DATA[103] == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + value3 + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + value3 + " ℃");
        }
    }

    
    public void mUpdateSpeed() {
        int value = DataCanbus.DATA[100];
        if (DataCanbus.DATA[104] == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(value + " mil/h");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(value + " km/h");
        }
    }

    
    public void mUpdateMile() {
        int value = DataCanbus.DATA[101];
        if (DataCanbus.DATA[104] == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(value + " Mil");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(value + " Km");
        }
    }
}
