package com.syu.carinfo.lz.lexusis;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LuzLexusLSClockSetAct extends BaseActivity {
    private final int delay = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_mazida);
        findViewById(R.id.mzd_btn_set).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81}, null, null);
                }
                return false;
            }
        });
        findViewById(R.id.mzd_btn_hour).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81, 1}, null, null);
                    return false;
                }
                return false;
            }
        });
        findViewById(R.id.mzd_btn_min).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81, 2}, null, null);
                    return false;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((Button) findViewById(R.id.mzd_btn_set)).setText("HOUR");
        ((Button) findViewById(R.id.mzd_btn_hour)).setText("MIN");
        ((Button) findViewById(R.id.mzd_btn_min)).setText(":00");
        findViewById(R.id.mzd_btn_min).setVisibility(0);
    }
}
