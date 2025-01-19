package com.syu.carinfo.psa;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Psa308OilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    Psa308OilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 103:
                    Psa308OilMilePage1Acti.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa308_oil_page1);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.psa308_tv_oil_page1_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa308_tv_oil_page1_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa308_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " L/100KM");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.psa308_tv_oil_page1_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa308_tv_oil_page1_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa308_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            }
        }
    }
}
