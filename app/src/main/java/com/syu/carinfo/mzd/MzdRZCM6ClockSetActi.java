package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MzdRZCM6ClockSetActi extends BaseActivity {
    private boolean mBooleanHour;
    private Button mBtnHour;
    private Button mBtnMin;
    private Button mBtnSet;
    private Handler mHandler;
    private boolean mBooleanMin = false;
    private final int delay = 200;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida6_rzc);
        this.mHandler = new Handler();
        this.mBtnSet = (Button) findViewById(R.id.mzd_btn_set);
        this.mBtnSet.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCM6ClockSetActi.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdRZCM6ClockSetActi.this.mBtnSet.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                MzdRZCM6ClockSetActi.this.mBtnSet.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(0, new int[1], null, null);
                return false;
            }
        });
        this.mBtnHour = (Button) findViewById(R.id.mzd_btn_hour);
        this.mBtnHour.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCM6ClockSetActi.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdRZCM6ClockSetActi.this.mBtnHour.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdRZCM6ClockSetActi.this.mBooleanHour = true;
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                MzdRZCM6ClockSetActi.this.mBtnHour.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                MzdRZCM6ClockSetActi.this.mBooleanHour = false;
                DataCanbus.PROXY.cmd(1, new int[1], null, null);
                return false;
            }
        });
        this.mBtnMin = (Button) findViewById(R.id.mzd_btn_min);
        this.mBtnMin.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCM6ClockSetActi.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    MzdRZCM6ClockSetActi.this.mBtnMin.setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    MzdRZCM6ClockSetActi.this.mBooleanMin = true;
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                MzdRZCM6ClockSetActi.this.mBtnMin.setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                MzdRZCM6ClockSetActi.this.mBooleanMin = false;
                DataCanbus.PROXY.cmd(2, new int[1], null, null);
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
