package com.syu.carinfo.rzc.t70;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityNaZhiJie extends Activity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.t70.ActivityNaZhiJie.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    ActivityNaZhiJie.this.updateCurOilExpend(value);
                    break;
                case 1:
                    ActivityNaZhiJie.this.updateDrivingMileage(value);
                    break;
                case 2:
                    ActivityNaZhiJie.this.updateOptimalOilExpend(value);
                    break;
                case 52:
                    ActivityNaZhiJie.this.updateMileage(value);
                    break;
                case 60:
                    ActivityNaZhiJie.this.updateRightCamera(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_290_nazhijie_u6);
        if (((CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.t70.ActivityNaZhiJie.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[60] == 1 ? 0 : 1;
                    DataCanbus.PROXY.cmd(18, value);
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
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
