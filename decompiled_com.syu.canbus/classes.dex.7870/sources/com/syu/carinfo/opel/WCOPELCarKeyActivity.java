package com.syu.carinfo.opel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class WCOPELCarKeyActivity extends BaseActivity {
    boolean isPress = false;
    private View.OnTouchListener mTouch = new View.OnTouchListener() { // from class: com.syu.carinfo.opel.WCOPELCarKeyActivity.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    WCOPELCarKeyActivity.this.isPress = true;
                    switch (v.getId()) {
                        case R.id.btn_plus1 /* 2131427419 */:
                            DataCanbus.PROXY.cmd(1, 18);
                            break;
                        case R.id.btn_plus2 /* 2131427423 */:
                            DataCanbus.PROXY.cmd(1, 1);
                            break;
                        case R.id.btn_plus3 /* 2131427427 */:
                            DataCanbus.PROXY.cmd(1, 2);
                            break;
                        case R.id.btn_plus4 /* 2131427428 */:
                            DataCanbus.PROXY.cmd(1, 4);
                            break;
                        case R.id.btn_plus5 /* 2131427429 */:
                            DataCanbus.PROXY.cmd(1, 3);
                            break;
                        case R.id.btn_plus6 /* 2131427430 */:
                            DataCanbus.PROXY.cmd(1, 5);
                            break;
                        case R.id.btn_plus7 /* 2131427431 */:
                            DataCanbus.PROXY.cmd(1, 9);
                            break;
                        case R.id.btn_plus8 /* 2131427432 */:
                            DataCanbus.PROXY.cmd(1, 10);
                            break;
                        case R.id.btn_plus9 /* 2131427433 */:
                            DataCanbus.PROXY.cmd(1, 11);
                            break;
                        case R.id.btn_plus10 /* 2131427434 */:
                            DataCanbus.PROXY.cmd(1, 12);
                            break;
                    }
                    break;
                case 1:
                    WCOPELCarKeyActivity.this.isPress = false;
                    break;
            }
            v.setPressed(WCOPELCarKeyActivity.this.isPress);
            return true;
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_opel_car_key);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus5)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus6)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus7)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus8)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus9)).setOnTouchListener(this.mTouch);
        ((Button) findViewById(R.id.btn_plus10)).setOnTouchListener(this.mTouch);
    }
}
