package com.syu.carinfo.xfy.psa;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PSA3008OilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 110:
                    PSA3008OilMilePage1Acti.this.mUpdaterOilExpend();
                case 111:
                    PSA3008OilMilePage1Acti.this.mUpdaterDrivingMileage();
                case 112:
                    PSA3008OilMilePage1Acti.this.mUpdaterDivedMile();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_oil_page1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, 80);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            }
        }
    }

    
    public void mUpdaterDivedMile() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText(String.valueOf(value) + " KM");
            }
        }
    }
}
