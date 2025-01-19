package com.syu.carinfo.od.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODBMWX1CarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    ODBMWX1CarInfo.this.updateCarinfo1();
                    break;
                case 9:
                    ODBMWX1CarInfo.this.updateCarinfo2();
                    break;
                case 10:
                case 12:
                    ODBMWX1CarInfo.this.updateCarinfo3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_bmw_mini_carinfo);
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
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[10];
        int unit = DataCanbus.DATA[12];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " Km/L");
                break;
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[9];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " Km/h");
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[8];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(value + " km");
        }
    }
}
