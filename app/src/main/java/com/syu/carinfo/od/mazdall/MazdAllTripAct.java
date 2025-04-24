package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class MazdAllTripAct extends BaseActivity {
    private TextView mTvWaterTemp;
    private final VerticalProgressbar[] mProgressbar = new VerticalProgressbar[15];
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 15:
                    MazdAllTripAct.this.mUpdaterOilValue1(value);
                    break;
                case 16:
                    MazdAllTripAct.this.mUpdaterOilValue2(value);
                    break;
                case 17:
                    MazdAllTripAct.this.mUpdaterOilValue3(value);
                    break;
                case 18:
                    MazdAllTripAct.this.mUpdaterOilValue4(value);
                    break;
                case 19:
                    MazdAllTripAct.this.mUpdaterOilValue5(value);
                    break;
                case 20:
                    MazdAllTripAct.this.mUpdaterOilValue6(value);
                    break;
                case 21:
                    MazdAllTripAct.this.mUpdaterOilValue7(value);
                    break;
                case 22:
                    MazdAllTripAct.this.mUpdaterOilValue8(value);
                    break;
                case 23:
                    MazdAllTripAct.this.mUpdaterOilValue9(value);
                    break;
                case 24:
                    MazdAllTripAct.this.mUpdaterOilValue10(value);
                    break;
                case 25:
                    MazdAllTripAct.this.mUpdaterOilValue11(value);
                    break;
                case 26:
                    MazdAllTripAct.this.mUpdaterOilValue21(value);
                    break;
                case 27:
                    MazdAllTripAct.this.mUpdaterOilValue31(value);
                    break;
                case 28:
                    MazdAllTripAct.this.mUpdaterOilValue41(value);
                    break;
                case 29:
                    MazdAllTripAct.this.mUpdaterOilValue51(value);
                    break;
                case 45:
                    MazdAllTripAct.this.mUpdaterWaterTemp(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_od_mazdall_trip);
        init();
    }

    @Override
    public void init() {
        this.mProgressbar[0] = findViewById(R.id.camry_progressbar_0);
        this.mProgressbar[1] = findViewById(R.id.camry_progressbar_1);
        this.mProgressbar[2] = findViewById(R.id.camry_progressbar_2);
        this.mProgressbar[3] = findViewById(R.id.camry_progressbar_3);
        this.mProgressbar[4] = findViewById(R.id.camry_progressbar_4);
        this.mProgressbar[5] = findViewById(R.id.camry_progressbar_5);
        this.mProgressbar[6] = findViewById(R.id.camry_progressbar_6);
        this.mProgressbar[7] = findViewById(R.id.camry_progressbar_7);
        this.mProgressbar[8] = findViewById(R.id.camry_progressbar_8);
        this.mProgressbar[9] = findViewById(R.id.camry_progressbar_9);
        this.mProgressbar[10] = findViewById(R.id.camry_progressbar_10);
        this.mProgressbar[11] = findViewById(R.id.camry_progressbar_11);
        this.mProgressbar[12] = findViewById(R.id.camry_progressbar_12);
        this.mProgressbar[13] = findViewById(R.id.camry_progressbar_13);
        this.mProgressbar[14] = findViewById(R.id.camry_progressbar_14);
        this.mTvWaterTemp = findViewById(R.id.text_water_temp);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterWaterTemp(int value) {
        if (this.mTvWaterTemp != null) {
            this.mTvWaterTemp.setText(String.format("  %d ℃", Integer.valueOf(value - 40)));
        }
    }

    
    public void mUpdaterOilValue51(int value) {
        int num = value / 10;
        this.mProgressbar[0].setProgress(num);
        this.mProgressbar[0].invalidate();
    }

    
    public void mUpdaterOilValue41(int value) {
        int num = value / 10;
        this.mProgressbar[1].setProgress(num);
        this.mProgressbar[1].invalidate();
    }

    
    public void mUpdaterOilValue31(int value) {
        int num = value / 10;
        this.mProgressbar[2].setProgress(num);
        this.mProgressbar[2].invalidate();
    }

    
    public void mUpdaterOilValue21(int value) {
        int num = value / 10;
        this.mProgressbar[3].setProgress(num);
        this.mProgressbar[3].invalidate();
    }

    
    public void mUpdaterOilValue11(int value) {
        int num = value / 10;
        this.mProgressbar[4].setProgress(num);
        this.mProgressbar[4].invalidate();
    }

    
    public void mUpdaterOilValue10(int value) {
        int num = value / 10;
        this.mProgressbar[5].setProgress(num);
        this.mProgressbar[5].invalidate();
    }

    
    public void mUpdaterOilValue9(int value) {
        int num = value / 10;
        this.mProgressbar[6].setProgress(num);
        this.mProgressbar[6].invalidate();
    }

    
    public void mUpdaterOilValue8(int value) {
        int num = value / 10;
        this.mProgressbar[7].setProgress(num);
        this.mProgressbar[7].invalidate();
    }

    
    public void mUpdaterOilValue7(int value) {
        int num = value / 10;
        this.mProgressbar[8].setProgress(num);
        this.mProgressbar[8].invalidate();
    }

    
    public void mUpdaterOilValue6(int value) {
        int num = value / 10;
        this.mProgressbar[9].setProgress(num);
        this.mProgressbar[9].invalidate();
    }

    
    public void mUpdaterOilValue5(int value) {
        int num = value / 10;
        this.mProgressbar[10].setProgress(num);
        this.mProgressbar[10].invalidate();
    }

    
    public void mUpdaterOilValue4(int value) {
        int num = value / 10;
        this.mProgressbar[11].setProgress(num);
        this.mProgressbar[11].invalidate();
    }

    
    public void mUpdaterOilValue3(int value) {
        int num = value / 10;
        this.mProgressbar[12].setProgress(num);
        this.mProgressbar[12].invalidate();
    }

    
    public void mUpdaterOilValue2(int value) {
        int num = value / 10;
        this.mProgressbar[13].setProgress(num);
        this.mProgressbar[13].invalidate();
    }

    
    public void mUpdaterOilValue1(int value) {
        int num = value / 10;
        this.mProgressbar[14].setProgress(num);
        this.mProgressbar[14].invalidate();
    }
}
