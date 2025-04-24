package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PsaOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    PsaOilMilePage1Acti.this.mUpdaterStartStopTime();
                    break;
                case 102:
                    PsaOilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 103:
                    PsaOilMilePage1Acti.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_oil_page1);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa_btn_oil_page1_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(24, new int[]{1}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[102];
        if (DataCanbus.DATA[1000] == 12) {
            if (((TextView) findViewById(R.id.psa_tv_oil_page1_tv1)) != null) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.psa_tv_oil_page1_tv1)).setText("--.--");
                    return;
                } else {
                    ((TextView) findViewById(R.id.psa_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " L/100KM");
                    return;
                }
            }
            return;
        }
        if (((TextView) findViewById(R.id.psa_tv_oil_page1_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_tv_oil_page1_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.psa_tv_oil_page1_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_tv_oil_page1_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            }
        }
    }

    
    public void mUpdaterStartStopTime() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.psa_tv_oil_page1_tv3)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_tv_oil_page1_tv3)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page1_tv3)).setText(String.valueOf(value / 2.0f) + " KM");
            }
        }
    }
}
