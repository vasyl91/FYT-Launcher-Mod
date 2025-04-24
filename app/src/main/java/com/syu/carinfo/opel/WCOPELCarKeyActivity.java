package com.syu.carinfo.opel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import java.lang.ref.WeakReference;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCOPELCarKeyActivity extends BaseActivity {
    boolean isPress = false;
    private View.OnTouchListener mTouch = new View.OnTouchListener() { 
        @Override
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    WCOPELCarKeyActivity.this.isPress = true;
                    switch (v.getId()) {
                        case R.id.opel_left /* 2131432079 */:
                            DataCanbus.PROXY.cmd(1, 4);
                            break;
                        case R.id.opel_ok /* 2131432080 */:
                            DataCanbus.PROXY.cmd(1, 3);
                            break;
                        case R.id.opel_right /* 2131432081 */:
                            DataCanbus.PROXY.cmd(1, 5);
                            break;
                        case R.id.opel_bc /* 2131432082 */:
                            DataCanbus.PROXY.cmd(1, 1);
                            break;
                        case R.id.opel_setting /* 2131432083 */:
                            DataCanbus.PROXY.cmd(1, 2);
                            break;
                        case R.id.opel_none /* 2131432093 */:
                            DataCanbus.PROXY.cmd(1, 18);
                            break;
                    }
                case 1:
                    WCOPELCarKeyActivity.this.isPress = false;
                    break;
            }
            v.setPressed(WCOPELCarKeyActivity.this.isPress);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_opel_car_key);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.opel_none)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_ok)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_setting)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_bc)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_left)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_right)).setOnTouchListener(this.mTouch);
    }

    private class LongClickedRunner implements Runnable {
        private WeakReference<View> mReference;

        public LongClickedRunner(View v) {
            this.mReference = new WeakReference<>(v);
        }

        @Override
        public void run() {
            View view = this.mReference.get();
            while (view != null && WCOPELCarKeyActivity.this.isPress) {
                switch (view.getId()) {
                    case R.id.opel_left /* 2131432079 */:
                        DataCanbus.PROXY.cmd(1, 4);
                        break;
                    case R.id.opel_ok /* 2131432080 */:
                        DataCanbus.PROXY.cmd(1, 3);
                        break;
                    case R.id.opel_right /* 2131432081 */:
                        DataCanbus.PROXY.cmd(1, 5);
                        break;
                    case R.id.opel_bc /* 2131432082 */:
                        DataCanbus.PROXY.cmd(1, 1);
                        break;
                    case R.id.opel_setting /* 2131432083 */:
                        DataCanbus.PROXY.cmd(1, 2);
                        break;
                    case R.id.opel_none /* 2131432093 */:
                        DataCanbus.PROXY.cmd(1, 6);
                        break;
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
