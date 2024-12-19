package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerHelper;
import com.syu.util.HandlerRemove;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MzdAllM3ClockSetActi extends BaseActivity {
    private boolean mBooleanHour;
    private Button mBtnHour;
    private Button mBtnMin;
    private Button mBtnSet;
    private Handler mHandler;
    private boolean mBooleanMin = false;
    private final int delay = 200;
    private Runnable mSet = new Runnable() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.1
        @Override // java.lang.Runnable
        public void run() {
            DataCanbus.PROXY.cmd(0, null, null, null);
            HandlerRemove.getInstance().postDelayed(this, 200L);
        }
    };
    private Runnable mUp = new Runnable() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.2
        @Override // java.lang.Runnable
        public void run() {
            DataCanbus.PROXY.cmd(3, null, null, null);
        }
    };
    private Runnable mHour = new Runnable() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.3
        @Override // java.lang.Runnable
        public void run() {
            if (MzdAllM3ClockSetActi.this.mBooleanHour) {
                DataCanbus.PROXY.cmd(1, null, null, null);
                MzdAllM3ClockSetActi.this.mHandler.postDelayed(this, 200L);
            }
        }
    };
    private Runnable mMin = new Runnable() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.4
        @Override // java.lang.Runnable
        public void run() {
            if (MzdAllM3ClockSetActi.this.mBooleanMin) {
                DataCanbus.PROXY.cmd(2, null, null, null);
                MzdAllM3ClockSetActi.this.mHandler.postDelayed(this, 200L);
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida);
        this.mHandler = new Handler();
        this.mBtnSet = (Button) findViewById(R.id.mzd_btn_set);
        this.mBtnSet.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdAllM3ClockSetActi.this.mBtnSet.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    HandlerHelper.postDelayed(HandlerRemove.getInstance(), MzdAllM3ClockSetActi.this.mSet, 0L);
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mSet);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else if (action == 1) {
                    MzdAllM3ClockSetActi.this.mBtnSet.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    HandlerHelper.removeCallbacks(HandlerRemove.getInstance(), MzdAllM3ClockSetActi.this.mSet);
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
        this.mBtnHour = (Button) findViewById(R.id.mzd_btn_hour);
        this.mBtnHour.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdAllM3ClockSetActi.this.mBtnHour.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdAllM3ClockSetActi.this.mBooleanHour = true;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mHour);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else if (action == 1) {
                    MzdAllM3ClockSetActi.this.mBtnHour.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    MzdAllM3ClockSetActi.this.mBooleanHour = false;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
        this.mBtnMin = (Button) findViewById(R.id.mzd_btn_min);
        this.mBtnMin.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdAllM3ClockSetActi.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdAllM3ClockSetActi.this.mBtnMin.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdAllM3ClockSetActi.this.mBooleanMin = true;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mMin);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else if (action == 1) {
                    MzdAllM3ClockSetActi.this.mBtnMin.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    MzdAllM3ClockSetActi.this.mBooleanMin = false;
                    MzdAllM3ClockSetActi.this.mHandler.post(MzdAllM3ClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 459195 || DataCanbus.DATA[1000] == 524731 || DataCanbus.DATA[1000] == 852411 || DataCanbus.DATA[1000] == 590267) {
            this.mBtnSet.setText("SET");
            this.mBtnHour.setText("CLOCK");
            this.mBtnMin.setVisibility(8);
        } else {
            if (DataCanbus.DATA[1000] == 393659) {
                this.mBtnSet.setText("SET");
                this.mBtnHour.setText("HOUR");
                this.mBtnMin.setText("MIN");
                this.mBtnMin.setVisibility(0);
                return;
            }
            if (DataCanbus.DATA[1000] == 655803 || DataCanbus.DATA[1000] == 1049019) {
                this.mBtnSet.setText("HOUR");
                this.mBtnHour.setText("MIN");
                this.mBtnMin.setText(":00");
                this.mBtnMin.setVisibility(0);
            }
        }
    }
}
