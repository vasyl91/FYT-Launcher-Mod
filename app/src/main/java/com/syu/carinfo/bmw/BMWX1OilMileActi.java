package com.syu.carinfo.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BMWX1OilMileActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    BMWX1OilMileActi.this.mUpdaterOilExpend();
                    break;
                case 99:
                    BMWX1OilMileActi.this.mUpdaterDrivingMileage();
                    break;
                case 100:
                    BMWX1OilMileActi.this.mUpdaterAverageSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bmwx1_oilmile);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.bmwx1_btn_cleanspeed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.bmwx1_btn_cleanoil)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
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

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.bmwx1_text_oil)) != null) {
            if (value > 0 && value < 4000) {
                ((TextView) findViewById(R.id.bmwx1_text_oil)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
            } else {
                ((TextView) findViewById(R.id.bmwx1_text_oil)).setText("--.-");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.bmwx1_text_mileage)) != null) {
            if (value > 0 && value < 4000) {
                ((TextView) findViewById(R.id.bmwx1_text_mileage)).setText(String.format("%d", Integer.valueOf(value)));
            } else {
                ((TextView) findViewById(R.id.bmwx1_text_mileage)).setText("----");
            }
        }
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.bmwx1_text_velocity)) != null) {
            if (value > 0 && value < 4000) {
                ((TextView) findViewById(R.id.bmwx1_text_velocity)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
            } else {
                ((TextView) findViewById(R.id.bmwx1_text_velocity)).setText("--.-");
            }
        }
    }
}
