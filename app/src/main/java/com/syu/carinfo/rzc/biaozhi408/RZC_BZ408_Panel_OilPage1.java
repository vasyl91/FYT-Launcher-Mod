package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_BZ408_Panel_OilPage1 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterOilExpend();
                    break;
                case 11:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterDrivingMileage();
                    break;
                case 12:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterSpecialMileage();
                    break;
            }
        }
    };
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_c4l_oil_page1);
        init();
    }

    @Override
    public void init() {
        this.mTv1 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv1);
        this.mTv2 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv2);
        this.mTv3 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv3);
        this.mTv4 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv4_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[1], null, null);
        DataCanbus.PROXY.cmd(70, new int[1], null, null);
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[10];
        if (this.mTv1 != null) {
            if (value > -1 && value < 3001) {
                this.mTv1.setText(String.valueOf(value / 10.0f) + " L/100KM");
            } else {
                this.mTv1.setText("--.--");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[11];
        if (this.mTv2 != null) {
            if (value > -1 && value < 2001) {
                this.mTv2.setText(String.valueOf(value) + " KM");
            } else {
                this.mTv2.setText("--.--");
            }
        }
    }

    
    public void mUpdaterSpecialMileage() {
        int value = DataCanbus.DATA[12];
        if (this.mTv3 != null) {
            if (value > -1 && value < 6001) {
                this.mTv3.setText(String.valueOf(value) + " KM");
            } else {
                this.mTv3.setText("--.--");
            }
        }
    }
}
