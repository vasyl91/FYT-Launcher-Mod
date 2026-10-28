package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PSAOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                case 172:
                    PSAOilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 99:
                    break;
                default:
                    return;
            }
            PSAOilMilePage1Acti.this.mUpdaterDrivingMileage();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_oil_page1);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[98];
        int value1 = DataCanbus.DATA[172];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("--.--");
            }
            switch (value1) {
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg");
                    break;
                default:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            }
        }
    }

    private void mUpdaterCanbusType() {
    }
}
