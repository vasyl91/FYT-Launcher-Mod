package com.syu.carinfo.od.dongnanv5;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dongnanv5CarinfoActi extends BaseActivity {
    private ProgressBar mProgressBarAvgOilUsed;
    private ProgressBar mProgressBarRemOil;
    private TextView mTvAvgOilUsed;
    private TextView mTvDrivedMileage;
    private TextView mTvDrivingMileage;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.dongnanv5.Dongnanv5CarinfoActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 13:
                    Dongnanv5CarinfoActi.this.trip1();
                    break;
                case 14:
                    Dongnanv5CarinfoActi.this.trip2();
                    break;
                case 15:
                    Dongnanv5CarinfoActi.this.trip3();
                    break;
                case 16:
                case 17:
                    Dongnanv5CarinfoActi.this.trip4();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oudi_17dongnanv5_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mProgressBarAvgOilUsed = (ProgressBar) findViewById(R.id.dongnanv5_avg_oil);
        this.mProgressBarRemOil = (ProgressBar) findViewById(R.id.dongnanv5_progress_rem_oil);
        this.mTvAvgOilUsed = (TextView) findViewById(R.id.dongnanv5_avg_oil_unit);
        this.mTvDrivedMileage = (TextView) findViewById(R.id.dongnanv5_mileage);
        this.mTvDrivingMileage = (TextView) findViewById(R.id.dongnanv5_driving_mileage);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trip1() {
        int value = DataCanbus.DATA[13];
        int temp = value / 10;
        if (this.mProgressBarAvgOilUsed != null) {
            if (temp < 0) {
                temp = 0;
            } else if (temp > 21) {
                temp = 21;
            }
            this.mProgressBarAvgOilUsed.setProgress(temp);
        }
        this.mTvAvgOilUsed.setText(String.format("%d.%dL", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trip2() {
        int value = DataCanbus.DATA[14];
        if (this.mProgressBarRemOil != null) {
            if (value < 0) {
                value = 0;
            } else if (value > 101) {
                value = 101;
            }
            this.mProgressBarRemOil.setProgress(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trip3() {
        int value = DataCanbus.DATA[15];
        this.mTvDrivingMileage.setText(String.format("%dkm", Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trip4() {
        int value = DataCanbus.DATA[16];
        int value1 = DataCanbus.DATA[17];
        this.mTvDrivedMileage.setText(String.format("%dkm", Integer.valueOf((value * 256) + value1)));
    }
}
