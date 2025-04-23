package com.syu.carinfo.wc.feiyate;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class FYTOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                case 113:
                    FYTOilMilePage1Acti.this.mUpdaterOilExpend();
                case 100:
                    FYTOilMilePage1Acti.this.mUpdaterDrivingMileage();
                case 101:
                    FYTOilMilePage1Acti.this.mUpdaterDivedMile();
                case 112:
                    FYTOilMilePage1Acti.this.mUpdaterDrivingMileage();
                    FYTOilMilePage1Acti.this.mUpdaterDivedMile();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_fyt_all_oil_page1);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[99];
        int value1 = DataCanbus.DATA[113] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(us)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(uk)");
                    break;
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[100];
        int unit = DataCanbus.DATA[112] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText(String.valueOf(value) + " Mil");
            }
        }
    }

    
    public void mUpdaterDivedMile() {
        int value = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv3)).setText(String.valueOf(value) + " Mil");
            }
        }
    }
}
