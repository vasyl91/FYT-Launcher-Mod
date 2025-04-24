package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class HC_Biaozhi206OilPage extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    HC_Biaozhi206OilPage.this.uCurSpeed(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 8:
                    HC_Biaozhi206OilPage.this.uAverageSpeed(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 9:
                    HC_Biaozhi206OilPage.this.uDrivingMiles(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 10:
                    HC_Biaozhi206OilPage.this.uTripMiles(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 11:
                    HC_Biaozhi206OilPage.this.uCurOilCost(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 12:
                    HC_Biaozhi206OilPage.this.uAverageOilCost(DataCanbus.DATA[updateCode] & 65535);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_biaozhi206_hc_oil_page);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    protected void uAverageOilCost(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)) != null) {
            if (i < 0 || i > 300) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)).setText("----");
            } else {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)).setText(String.valueOf(i / 10) + "." + (i % 10) + "L/100Km");
            }
        }
    }

    protected void uDrivingMiles(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)) != null) {
            if (i == 65535) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)).setText("----");
            } else {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)).setText(String.valueOf(i) + "Km");
            }
        }
    }

    protected void uTripMiles(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage_low)) != null) {
            if (i == 65535) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage_low)).setText("----");
            } else {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage_low)).setText(String.valueOf(i) + "Km");
            }
        }
    }

    protected void uCurOilCost(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time_low)) != null) {
            if (i < 0 || i > 300) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time_low)).setText("----");
            } else {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time_low)).setText(String.valueOf(i / 10) + "." + (i % 10) + "L/100Km");
            }
        }
    }

    protected void uAverageSpeed(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity_low)) != null) {
            if (i < 0 || i > 250) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity_low)).setText("----");
            } else {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity_low)).setText(String.valueOf(i) + "Km/h");
            }
        }
    }

    protected void uCurSpeed(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_cur_velocity_low)) != null) {
            if (i < 0 || i > 250) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_cur_velocity_low)).setText("----");
            } else {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_cur_velocity_low)).setText(String.valueOf(i) + "Km/h");
            }
        }
    }
}
