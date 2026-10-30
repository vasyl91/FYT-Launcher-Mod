package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class MzdRZCCX9ClockSetActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida_cx9_rzc);
        ((Button) findViewById(R.id.mzd_btn_set)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCCX9ClockSetActi.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(5, new int[]{32, 0}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(5, new int[2], null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_hour)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCCX9ClockSetActi.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(5, new int[]{64, 0}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(5, new int[2], null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_min)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCCX9ClockSetActi.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(5, new int[]{128, 0}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(5, new int[2], null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_temp)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCCX9ClockSetActi.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_temp)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(5, new int[]{0, 64}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCCX9ClockSetActi.this.findViewById(R.id.mzd_btn_temp)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(5, new int[2], null, null);
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
