package com.syu.carinfo.wc.leinuo;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DusterOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    DusterOilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 100:
                    break;
                default:
                    return;
            }
            DusterOilMilePage1Acti.this.mUpdaterDrivingMileage();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_duster_all_oil_page1);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("--.--");
            } else {
                if ((value & 128) != 0) {
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("L-title-" + (value - 128));
                    return;
                }
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("R-title-" + value);
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("--.--");
                return;
            }
            if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
                if (value == 255) {
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("--.--");
                } else {
                    if ((value & 128) != 0) {
                        ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("F-title-" + (value - 128));
                        return;
                    }
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("R-title-" + value);
                }
            }
        }
    }
}
