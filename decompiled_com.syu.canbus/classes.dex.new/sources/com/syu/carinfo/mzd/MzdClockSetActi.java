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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class MzdClockSetActi extends BaseActivity {
    private boolean mBooleanHour;
    private Handler mHandler;
    private boolean mBooleanMin = false;
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
        ((Button) findViewById(R.id.mzd_btn_set)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827 || DataCanbus.DATA[1000] == 131363) {
                        DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                    } else {
                        HandlerHelper.postDelayed(HandlerRemove.getInstance(), MzdClockSetActi.this.mSet, 0L);
                        MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mSet);
                        DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    }
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
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
        ((Button) findViewById(R.id.mzd_btn_hour)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdClockSetActi.this.mBooleanHour = true;
                    if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                        DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                    } else {
                        MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mHour);
                        DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    }
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
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
        ((Button) findViewById(R.id.mzd_btn_min)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdClockSetActi.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdClockSetActi.this.mBooleanMin = true;
                    if (DataCanbus.DATA[1000] == 79 || DataCanbus.DATA[1000] == 65827) {
                        DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                    } else {
                        MzdClockSetActi.this.mHandler.post(MzdClockSetActi.this.mMin);
                        DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    }
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
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
            ((Button) findViewById(R.id.mzd_btn_hour)).setText("CLOCK");
            ((Button) findViewById(R.id.mzd_btn_min)).setVisibility(8);
        }
    }
}
