package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Rzc_RamHY_WindowButton extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 201:
                    Rzc_RamHY_WindowButton.this.findViewById(R.id.btn_plus9).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_leftwindow_auto_down_p : R.drawable.ic_lamborghini_leftwindow_auto_down_n);
                    break;
                case 220:
                    Rzc_RamHY_WindowButton.this.findViewById(R.id.btn_plus10).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_window_lock_p : R.drawable.ic_lamborghini_window_lock_n);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0373_rzc_ramhy_windowsset);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
        findViewById(R.id.btn_plus10).setOnTouchListener(this);
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
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 1;
                data1 = 1;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 1;
                data1 = 2;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 3;
                data1 = 1;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data0 = 3;
                data1 = 2;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 2;
                data1 = 1;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data0 = 2;
                data1 = 2;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                data0 = 4;
                data1 = 1;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                data0 = 4;
                data1 = 2;
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                data0 = 0;
                if (DataCanbus.DATA[201] == 1) {
                    data1 = 0;
                    break;
                } else {
                    data1 = 1;
                    break;
                }
            case R.id.btn_plus10 /* 2131427484 */:
                data0 = 5;
                if (DataCanbus.DATA[220] == 1) {
                    data1 = 0;
                    break;
                } else {
                    data1 = 1;
                    break;
                }
        }
        if (data0 == 0 || data0 == 5) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
            }
        } else if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(1, new int[]{data0}, null, null);
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
    }
}
