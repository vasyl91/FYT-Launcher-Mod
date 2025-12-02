package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_BZ408_Panel_OilPage2 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    RZC_BZ408_Panel_OilPage2.this.mUpdaterValue1();
                    break;
                case 9:
                    RZC_BZ408_Panel_OilPage2.this.mUpdaterValue2();
                    break;
                case 13:
                    RZC_BZ408_Panel_OilPage2.this.mUpdaterValue3();
                    break;
            }
        }
    };
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_c4l_oil_page2);
        init();
    }

    @Override
    public void init() {
        this.mTv1 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv1);
        this.mTv2 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv2);
        this.mTv3 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[]{1}, null, null);
        DataCanbus.PROXY.cmd(71, new int[1], null, null);
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[8];
        if (this.mTv1 != null) {
            if (value > -1 && value < 301) {
                this.mTv1.setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100");
            } else {
                this.mTv1.setText("--.--");
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[9];
        if (this.mTv2 != null) {
            if (value > -1 && value < 251) {
                this.mTv2.setText(String.valueOf(value) + " KM/H");
            } else {
                this.mTv2.setText("--.--");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[13];
        if (this.mTv3 != null) {
            if (value > -1 && value < 10000) {
                this.mTv3.setText(String.valueOf(value) + " KM");
            } else {
                this.mTv3.setText("--.--");
            }
        }
    }
}
