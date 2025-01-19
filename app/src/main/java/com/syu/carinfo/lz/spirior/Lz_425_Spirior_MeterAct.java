package com.syu.carinfo.lz.spirior;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Lz_425_Spirior_MeterAct extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    Lz_425_Spirior_MeterAct.this.updateCurSpeed();
                    break;
                case 99:
                    Lz_425_Spirior_MeterAct.this.updateEngineSpeed();
                    break;
                case 100:
                    Lz_425_Spirior_MeterAct.this.updateTotalMileage();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0425_lz_spirior_meter_info);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCurSpeed() {
        int curspeed = DataCanbus.DATA[98];
        if (findViewById(R.id.tv_text4) != null) {
            if (curspeed > 0 && curspeed <= 4000) {
                ((TextView) findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(curspeed / 10), Integer.valueOf(curspeed % 10)) + " Km/h");
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText("---");
            }
        }
    }

    
    public void updateEngineSpeed() {
        int enginespeed = DataCanbus.DATA[99];
        if (findViewById(R.id.tv_text2) != null) {
            if (enginespeed >= 0 && enginespeed <= 7000) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(enginespeed)) + " Rpm");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText("---");
            }
        }
    }

    
    public void updateTotalMileage() {
        int totalgmileage = DataCanbus.DATA[100];
        if (findViewById(R.id.tv_text6) != null) {
            if (totalgmileage >= 0 && totalgmileage <= 16777215) {
                ((TextView) findViewById(R.id.tv_text6)).setText(String.format("%d", Integer.valueOf(totalgmileage)) + " KM");
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText("--.-");
            }
        }
    }
}
