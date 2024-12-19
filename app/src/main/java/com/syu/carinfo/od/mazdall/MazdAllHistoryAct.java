package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MazdAllHistoryAct extends BaseActivity {
    public VerticalProgressbar mProgressbarHisCur;
    private TextView mTvCurAverageOil;
    private TextView mTvIeloopAverageOil;
    public VerticalProgressbar[] mProgressbarHis = new VerticalProgressbar[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.MazdAllHistoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    MazdAllHistoryAct.this.mUpdaterOilValue1(value);
                    break;
                case 8:
                    MazdAllHistoryAct.this.mUpdaterOilValue2(value);
                    break;
                case 9:
                    MazdAllHistoryAct.this.mUpdaterOilValue3(value);
                    break;
                case 10:
                    MazdAllHistoryAct.this.mUpdaterOilValue4(value);
                    break;
                case 11:
                    MazdAllHistoryAct.this.mUpdaterOilValue5(value);
                    break;
                case 12:
                    MazdAllHistoryAct.this.mUpdaterOilValue6(value);
                    break;
                case 13:
                    MazdAllHistoryAct.this.mUpdaterOilIEloop(value);
                    break;
                case 14:
                    MazdAllHistoryAct.this.mUpdaterOilDriving(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_od_mazdall_history);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvIeloopAverageOil = (TextView) findViewById(R.id.od_mazdall_tv_eloop_aveoil);
        this.mTvCurAverageOil = (TextView) findViewById(R.id.od_mazdall_tv_driving_aveoil);
        this.mProgressbarHis[0] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_0);
        this.mProgressbarHis[1] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_1);
        this.mProgressbarHis[2] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_2);
        this.mProgressbarHis[3] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_3);
        this.mProgressbarHis[4] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_4);
        this.mProgressbarHis[5] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_5);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilDriving(int value) {
        if (this.mTvCurAverageOil != null) {
            this.mTvCurAverageOil.setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilIEloop(int value) {
        if (this.mTvIeloopAverageOil != null) {
            this.mTvIeloopAverageOil.setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue6(int value) {
        int num = value / 10;
        this.mProgressbarHis[0].setProgress(num);
        this.mProgressbarHis[0].invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue5(int value) {
        int num = value / 10;
        this.mProgressbarHis[1].setProgress(num);
        this.mProgressbarHis[1].invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue4(int value) {
        int num = value / 10;
        this.mProgressbarHis[2].setProgress(num);
        this.mProgressbarHis[2].invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue3(int value) {
        int num = value / 10;
        this.mProgressbarHis[3].setProgress(num);
        this.mProgressbarHis[3].invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue2(int value) {
        int num = value / 10;
        this.mProgressbarHis[4].setProgress(num);
        this.mProgressbarHis[4].invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue1(int value) {
        int num = value / 10;
        this.mProgressbarHis[5].setProgress(num);
        this.mProgressbarHis[5].invalidate();
    }
}
