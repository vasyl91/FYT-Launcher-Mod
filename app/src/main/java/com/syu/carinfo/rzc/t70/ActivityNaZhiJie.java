package com.syu.carinfo.rzc.t70;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityNaZhiJie extends Activity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ActivityNaZhiJie.this.updateCurOilExpend(value);
                    break;
                case 99:
                    ActivityNaZhiJie.this.updateDrivingMileage(value);
                    break;
                case 100:
                    ActivityNaZhiJie.this.updateOptimalOilExpend(value);
                    break;
                case 103:
                    ActivityNaZhiJie.this.updateMileage(value);
                    break;
                case 111:
                    ActivityNaZhiJie.this.updateRightCamera(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_290_nazhijie_u6);
        if (((CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[111] == 1 ? 0 : 1;
                    DataCanbus.PROXY.cmd(18, value);
                }
            });
        }
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
    }

    protected void updateMileage(int value) {
        if (((TextView) findViewById(R.id.tv_290_drived_mileage)) != null) {
            ((TextView) findViewById(R.id.tv_290_drived_mileage)).setText(String.valueOf(value) + " KM");
        }
    }

    protected void updateRightCamera(int value) {
        if (((CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp)).setChecked(value == 1);
        }
    }

    protected void updateCurOilExpend(int value) {
        if (((TextView) findViewById(R.id.tv_290_current_consumption)) != null) {
            ((TextView) findViewById(R.id.tv_290_current_consumption)).setText(String.valueOf(value / 10.0f) + " L/100KM");
        }
    }

    protected void updateDrivingMileage(int value) {
        if (((TextView) findViewById(R.id.tv_290_driving_mileage)) != null) {
            ((TextView) findViewById(R.id.tv_290_driving_mileage)).setText(String.valueOf(value) + " KM");
        }
    }

    protected void updateOptimalOilExpend(int value) {
        if (((TextView) findViewById(R.id.tv_290_average_consumption)) != null) {
            ((TextView) findViewById(R.id.tv_290_average_consumption)).setText(String.valueOf(value / 10.0f) + " L/100KM");
        }
    }
}
