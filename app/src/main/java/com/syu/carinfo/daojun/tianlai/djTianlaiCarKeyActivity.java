package com.syu.carinfo.daojun.tianlai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class djTianlaiCarKeyActivity extends Activity implements View.OnTouchListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_djtianlai_car_key);
        init();
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
        findViewById(R.id.btn_plus10).setOnTouchListener(this);
        findViewById(R.id.btn_plus11).setOnTouchListener(this);
        findViewById(R.id.btn_plus12).setOnTouchListener(this);
        findViewById(R.id.btn_plus13).setOnTouchListener(this);
        findViewById(R.id.btn_plus14).setOnTouchListener(this);
        findViewById(R.id.btn_plus15).setOnTouchListener(this);
        findViewById(R.id.btn_plus16).setOnTouchListener(this);
        findViewById(R.id.btn_plus17).setOnTouchListener(this);
        findViewById(R.id.btn_plus18).setOnTouchListener(this);
        findViewById(R.id.btn_plus19).setOnTouchListener(this);
        findViewById(R.id.btn_plus20).setOnTouchListener(this);
        findViewById(R.id.btn_plus21).setOnTouchListener(this);
        findViewById(R.id.btn_plus22).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 1;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 3;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 2;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data0 = 4;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 5;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data0 = 7;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                data0 = 9;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                data0 = 8;
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                data0 = 16;
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                data0 = 17;
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                data0 = 18;
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                data0 = 35;
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                data0 = 19;
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                data0 = 20;
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                data0 = 21;
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                data0 = 25;
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                data0 = 32;
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                data0 = 33;
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                data0 = 34;
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                data0 = 23;
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                data0 = 24;
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                data0 = 22;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(0, new int[]{data0, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
        }
        return false;
    }
}
