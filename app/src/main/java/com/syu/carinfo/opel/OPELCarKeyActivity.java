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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class OPELCarKeyActivity extends BaseActivity {
    boolean isPress = false;
    private View.OnTouchListener mTouch = new View.OnTouchListener() { // from class: com.syu.carinfo.opel.OPELCarKeyActivity.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    OPELCarKeyActivity.this.isPress = true;
                    Thread t = new Thread(OPELCarKeyActivity.this.new LongClickedRunner(v));
                    t.start();
                    break;
                case 1:
                    OPELCarKeyActivity.this.isPress = false;
                    DataCanbus.PROXY.cmd(1, 0);
                    break;
            }
            v.setPressed(OPELCarKeyActivity.this.isPress);
            return true;
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_opel_car_key);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.opel_ok)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_setting)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_bc)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_left)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_right)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_fmam)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_cdmp3)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_1)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_2)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_3)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_4)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_5)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_6)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_7)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_8)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.opel_9)).setOnTouchListener(this.mTouch);
    }

    private class LongClickedRunner implements Runnable {
        private WeakReference<View> mReference;

        public LongClickedRunner(View v) {
            this.mReference = new WeakReference<>(v);
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.mReference.get();
            while (view != null && OPELCarKeyActivity.this.isPress) {
                switch (view.getId()) {
                    case R.id.opel_fmam /* 2131432130 */:
                        DataCanbus.PROXY.cmd(1, 6);
                        break;
                    case R.id.opel_cdmp3 /* 2131432131 */:
                        DataCanbus.PROXY.cmd(1, 7);
                        break;
                    case R.id.opel_left /* 2131432132 */:
                        DataCanbus.PROXY.cmd(1, 4);
                        break;
                    case R.id.opel_ok /* 2131432133 */:
                        DataCanbus.PROXY.cmd(1, 1);
                        break;
                    case R.id.opel_right /* 2131432134 */:
                        DataCanbus.PROXY.cmd(1, 5);
                        break;
                    case R.id.opel_bc /* 2131432135 */:
                        DataCanbus.PROXY.cmd(1, 3);
                        break;
                    case R.id.opel_setting /* 2131432136 */:
                        DataCanbus.PROXY.cmd(1, 2);
                        break;
                    case R.id.opel_1 /* 2131432137 */:
                        DataCanbus.PROXY.cmd(1, 8);
                        break;
                    case R.id.opel_2 /* 2131432138 */:
                        DataCanbus.PROXY.cmd(1, 9);
                        break;
                    case R.id.opel_3 /* 2131432139 */:
                        DataCanbus.PROXY.cmd(1, 10);
                        break;
                    case R.id.opel_4 /* 2131432140 */:
                        DataCanbus.PROXY.cmd(1, 11);
                        break;
                    case R.id.opel_5 /* 2131432141 */:
                        DataCanbus.PROXY.cmd(1, 12);
                        break;
                    case R.id.opel_6 /* 2131432142 */:
                        DataCanbus.PROXY.cmd(1, 13);
                        break;
                    case R.id.opel_7 /* 2131432143 */:
                        DataCanbus.PROXY.cmd(1, 14);
                        break;
                    case R.id.opel_8 /* 2131432144 */:
                        DataCanbus.PROXY.cmd(1, 15);
                        break;
                    case R.id.opel_9 /* 2131432145 */:
                        DataCanbus.PROXY.cmd(1, 16);
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
