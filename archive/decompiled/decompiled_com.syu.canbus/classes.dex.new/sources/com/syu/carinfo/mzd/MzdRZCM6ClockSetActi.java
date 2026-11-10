package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class MzdRZCM6ClockSetActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida6_rzc);
        ((Button) findViewById(R.id.mzd_btn_set)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCM6ClockSetActi.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCM6ClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCM6ClockSetActi.this.findViewById(R.id.mzd_btn_set)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(0, new int[1], null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_hour)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCM6ClockSetActi.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCM6ClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCM6ClockSetActi.this.findViewById(R.id.mzd_btn_hour)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(1, new int[1], null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_min)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.MzdRZCM6ClockSetActi.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) MzdRZCM6ClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) MzdRZCM6ClockSetActi.this.findViewById(R.id.mzd_btn_min)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
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
