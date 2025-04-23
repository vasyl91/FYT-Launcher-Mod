package com.syu.carinfo.rzc.sanlin;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCMzd3CarInfo extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                case 102:
                    int unit = DataCanbus.DATA[102];
                    int data = DataCanbus.DATA[98];
                    if (unit == 1) {
                        ((TextView) RZCMzd3CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(data) + " mile/h");
                        break;
                    } else {
                        ((TextView) RZCMzd3CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(data) + " km/h");
                        break;
                    }
                case 99:
                    ((TextView) RZCMzd3CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 100:
                    ((TextView) RZCMzd3CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 101:
                    ((TextView) RZCMzd3CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0079_rzc_mazd3_carinfo);
        findViewById(R.id.ctv_checkedtext1).setOnTouchListener(this);
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
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                data0 = 0;
                data1 = 128;
                break;
        }
        if (event.getAction() == 0) {
            findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_btn_p);
            DataCanbus.PROXY.cmd(4, new int[]{data0, data1}, null, null);
        } else if (event.getAction() == 1) {
            findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_btn_n);
            DataCanbus.PROXY.cmd(4, new int[2], null, null);
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }
}
