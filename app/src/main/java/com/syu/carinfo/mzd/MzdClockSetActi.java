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
public class MzdClockSetActi extends BaseActivity {
    private boolean mBooleanHour;
    private Button mBtnHour;
    private Button mBtnMin;
    private Button mBtnSet;
    private Handler mHandler;
    private boolean mBooleanMin = false;
    private final int delay = 200;
    private Runnable mSet = new Runnable() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.1
        @Override // java.lang.Runnable
        public void run() {
            DataCanbus.PROXY.cmd(0, null, null, null);
            HandlerRemove.getInstance().postDelayed(this, 200L);
        }
    };
    private Runnable mUp = new Runnable() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.2
        @Override // java.lang.Runnable
        public void run() {
            DataCanbus.PROXY.cmd(3, null, null, null);
        }
    };
    private Runnable mHour = new Runnable() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.3
        @Override // java.lang.Runnable
        public void run() {
            if (MzdClockSetActi.this.mBooleanHour) {
                DataCanbus.PROXY.cmd(1, null, null, null);
                MzdClockSetActi.this.mHandler.postDelayed(this, 200L);
            }
        }
    };
    private Runnable mMin = new Runnable() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.4
        @Override // java.lang.Runnable
        public void run() {
            if (MzdClockSetActi.this.mBooleanMin) {
                DataCanbus.PROXY.cmd(2, null, null, null);
                MzdClockSetActi.this.mHandler.postDelayed(this, 200L);
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida);
        this.mHandler = new Handler();
        this.mBtnSet = (Button) findViewById(R.id.mzd_btn_set);
        this.mBtnSet.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdClockSetActi.this.mBtnSet.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827 || DataCanbus.DATA[1000] == 131363) {
                        DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                        return true;
                    }
                    HandlerHelper.postDelayed(HandlerRemove.getInstance(), MzdClockSetActi.this.mSet, 0L);
                    MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mSet);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                MzdClockSetActi.this.mBtnSet.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                } else {
                    HandlerHelper.removeCallbacks(HandlerRemove.getInstance(), MzdClockSetActi.this.mSet);
                    MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
        this.mBtnHour = (Button) findViewById(R.id.mzd_btn_hour);
        this.mBtnHour.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdClockSetActi.this.mBtnHour.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdClockSetActi.this.mBooleanHour = true;
                    if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                        return true;
                    }
                    MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mHour);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                MzdClockSetActi.this.mBtnHour.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                MzdClockSetActi.this.mBooleanHour = false;
                if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                } else {
                    MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
        this.mBtnMin = (Button) findViewById(R.id.mzd_btn_min);
        this.mBtnMin.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdClockSetActi.this.mBtnMin.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdClockSetActi.this.mBooleanMin = true;
                    if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                        DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                        return true;
                    }
                    MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mMin);
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                MzdClockSetActi.this.mBtnMin.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                MzdClockSetActi.this.mBooleanMin = false;
                if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                } else {
                    MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mUp);
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 16) {
            this.mBtnHour.setText("CLOCK");
            this.mBtnMin.setVisibility(8);
        }
    }
}
