package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerHelper;
import com.syu.util.HandlerRemove;

public class MzdAllM3ClockSetActi extends BaseActivity {
    private boolean mBooleanHour;
    private Handler mHandler;
    private boolean mBooleanMin = false;
    private Runnable mSet = new Runnable() { 
        @Override
        public void run() {
            DataCanbus.PROXY.cmd(0, null, null, null);
            HandlerRemove.getInstance().postDelayed(this, 200L);
        }
    };
    private Runnable mUp = new Runnable() { 
        @Override
        public void run() {
            DataCanbus.PROXY.cmd(3, null, null, null);
        }
    };
    private Runnable mHour = new Runnable() { 
        @Override
        public void run() {
            if (MzdAllM3ClockSetActi.this.mBooleanHour) {
                DataCanbus.PROXY.cmd(1, null, null, null);
                MzdAllM3ClockSetActi.this.mHandler.postDelayed(this, 200L);
            }
        }
    };
    private Runnable mMin = new Runnable() { 
        @Override
        public void run() {
            if (MzdAllM3ClockSetActi.this.mBooleanMin) {
                DataCanbus.PROXY.cmd(2, null, null, null);
                MzdAllM3ClockSetActi.this.mHandler.postDelayed(this, 200L);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_mazida);
        this.mHandler = new Handler(Looper.getMainLooper());
        ((Button) findViewById(R.id.mzd_btn_set)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdAllM3ClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    HandlerHelper.postDelayed(HandlerRemove.getInstance(), MzdAllM3ClockSetActi.this.mSet, 0L);
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mSet);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else if (action == 1) {
                    ((Button) MzdAllM3ClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    HandlerHelper.removeCallbacks(HandlerRemove.getInstance(), MzdAllM3ClockSetActi.this.mSet);
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_hour)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdAllM3ClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdAllM3ClockSetActi.this.mBooleanHour = true;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mHour);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else if (action == 1) {
                    ((Button) MzdAllM3ClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    MzdAllM3ClockSetActi.this.mBooleanHour = false;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_min)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdAllM3ClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdAllM3ClockSetActi.this.mBooleanMin = true;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mMin);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else if (action == 1) {
                    ((Button) MzdAllM3ClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    MzdAllM3ClockSetActi.this.mBooleanMin = false;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 459195 || DataCanbus.DATA[1000] == 524731 || DataCanbus.DATA[1000] == 852411 || DataCanbus.DATA[1000] == 590267) {
            ((Button) findViewById(R.id.mzd_btn_set)).setText("SET");
            ((Button) findViewById(R.id.mzd_btn_hour)).setText("CLOCK");
            ((Button) findViewById(R.id.mzd_btn_min)).setVisibility(8);
        } else {
            if (DataCanbus.DATA[1000] == 393659 || DataCanbus.DATA[1000] == 15663547) {
                ((Button) findViewById(R.id.mzd_btn_set)).setText("SET");
                ((Button) findViewById(R.id.mzd_btn_hour)).setText("HOUR");
                ((Button) findViewById(R.id.mzd_btn_min)).setText("MIN");
                ((Button) findViewById(R.id.mzd_btn_min)).setVisibility(0);
                return;
            }
            if (DataCanbus.DATA[1000] == 655803 || DataCanbus.DATA[1000] == 1049019) {
                ((Button) findViewById(R.id.mzd_btn_set)).setText("HOUR");
                ((Button) findViewById(R.id.mzd_btn_hour)).setText("MIN");
                ((Button) findViewById(R.id.mzd_btn_min)).setText(":00");
                ((Button) findViewById(R.id.mzd_btn_min)).setVisibility(0);
            }
        }
    }
}
