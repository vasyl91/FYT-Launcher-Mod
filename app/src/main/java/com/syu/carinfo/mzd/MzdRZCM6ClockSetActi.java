package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class MzdRZCM6ClockSetActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_mazida6_rzc);
        ((Button) findViewById(R.id.mzd_btn_set)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
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
        ((Button) findViewById(R.id.mzd_btn_hour)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
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
        ((Button) findViewById(R.id.mzd_btn_min)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
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

    @Override
    protected void onResume() {
        super.onResume();
    }
}
