package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODCaptivaCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                case 100:
                    ODCaptivaCarInfo.this.updateCarinfo1();
                    break;
                case 99:
                case 101:
                    ODCaptivaCarInfo.this.updateCarinfo2();
                    break;
                case 102:
                    ODCaptivaCarInfo.this.updateCarinfo3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_captiva_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[102];
        ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[99];
        int unit = DataCanbus.DATA[101];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mile");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[98];
        int unit = DataCanbus.DATA[100];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " km/l");
        } else if (unit == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " l/100km");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " mpg");
        }
    }
}
