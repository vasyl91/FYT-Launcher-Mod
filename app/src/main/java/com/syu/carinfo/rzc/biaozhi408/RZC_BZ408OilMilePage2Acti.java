package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_BZ408OilMilePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    RZC_BZ408OilMilePage2Acti.this.mUpdaterValue1();
                    break;
                case 101:
                    RZC_BZ408OilMilePage2Acti.this.mUpdaterValue2();
                    break;
                case 105:
                    RZC_BZ408OilMilePage2Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_biaozhi408_oil_page2);
        init();
        DataCanbus.PROXY.cmd(71, new int[]{52}, null, null);
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.rzc_bz408_btn_oil_page2_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(28, new int[]{2}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[]{1}, null, null);
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv1)) != null) {
            if (value > -1 && value < 301) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv1)).setText("--.--");
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv2)) != null) {
            if (value > -1 && value < 251) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv2)).setText(String.valueOf(value) + " KM/H");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv2)).setText("--.--");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv3)) != null) {
            if (value > -1 && value < 10000) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page2_tv3)).setText("--.--");
            }
        }
    }
}
