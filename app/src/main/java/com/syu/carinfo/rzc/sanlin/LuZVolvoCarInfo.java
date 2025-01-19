package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuZVolvoCarInfo extends BaseActivity implements View.OnTouchListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext36).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key3_p : R.drawable.ic_volvo_key3_n);
                    break;
                case 128:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext26).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key27_p : R.drawable.ic_volvo_key27_n);
                    break;
                case 129:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext37).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key4_p : R.drawable.ic_volvo_key4_n);
                    break;
                case 136:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext38).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key26_p : R.drawable.ic_volvo_key26_n);
                    break;
                case 137:
                    LuZVolvoCarInfo.this.findViewById(R.id.ctv_checkedtext39).setBackgroundResource(value == 1 ? R.drawable.ic_volvo_key1_p : R.drawable.ic_volvo_key1_n);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_volvo_carinfo);
        findViewById(R.id.ctv_checkedtext1).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext11).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext12).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext13).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext14).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext15).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext16).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext17).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext18).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext19).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext20).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext21).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext22).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext23).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext24).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext25).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext26).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext27).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext28).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext29).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext30).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext31).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext32).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext33).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext34).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext35).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext36).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext37).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext38).setOnTouchListener(this);
        findViewById(R.id.ctv_checkedtext39).setOnTouchListener(this);
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
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                data0 = 26;
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                data0 = 27;
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                data0 = 28;
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                data0 = 29;
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                data0 = 30;
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                data0 = 31;
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                data0 = 32;
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                data0 = 33;
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                data0 = 34;
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                data0 = 35;
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                data0 = 36;
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                data0 = 37;
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                data0 = 22;
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                data0 = 11;
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                data0 = 12;
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                data0 = 24;
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                data0 = 19;
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                data0 = 23;
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                data0 = 20;
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                data0 = 25;
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                data0 = 7;
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                data0 = 21;
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                data0 = 18;
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                data0 = 16;
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                data0 = 13;
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                data0 = 39;
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                data0 = 8;
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                data0 = 6;
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                data0 = 14;
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                data0 = 10;
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                data0 = 9;
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                data0 = 15;
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                data0 = 5;
                break;
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                data0 = 17;
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                data0 = 2;
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                data0 = 3;
                break;
            case R.id.ctv_checkedtext37 /* 2131428377 */:
                data0 = 4;
                break;
            case R.id.ctv_checkedtext38 /* 2131428379 */:
                data0 = 38;
                break;
            case R.id.ctv_checkedtext39 /* 2131428381 */:
                data0 = 1;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(3, new int[]{data0, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(3, new int[]{data0}, null, null);
        }
        return false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }
}
