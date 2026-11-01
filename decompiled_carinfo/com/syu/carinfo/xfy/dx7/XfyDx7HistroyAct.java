package com.syu.carinfo.xfy.dx7;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XfyDx7HistroyAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    XfyDx7HistroyAct.this.mUpdateCurOilExpend();
                    break;
                case 103:
                    XfyDx7HistroyAct.this.mUpdaterDrivingMileage();
                    break;
                case 104:
                    XfyDx7HistroyAct.this.mUpdateCurOptimalOilExpend();
                    break;
                case 105:
                    XfyDx7HistroyAct.this.mUpdaterLastOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xfydx7_oil_trip_info);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCurOilExpend() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.xfydx7_average_oil)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_average_oil)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_average_oil)).setText(String.valueOf(value / 10) + "." + (value % 10) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
            }
        }
    }

    
    public void mUpdateCurOptimalOilExpend() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.xfydx7_current_consumption)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_current_consumption)).setText(String.valueOf(value) + " Km");
            }
        }
    }

    
    public void mUpdaterLastOil() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.xfydx7_trip_oil_value)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText("--.--");
            } else if (value < 5) {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText("0%");
            } else {
                ((TextView) findViewById(R.id.xfydx7_trip_oil_value)).setText(String.valueOf(value) + "%");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.xfydx7_driving_mileage)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.xfydx7_driving_mileage)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.xfydx7_driving_mileage)).setText(String.valueOf(value) + " km");
            }
        }
    }
}
