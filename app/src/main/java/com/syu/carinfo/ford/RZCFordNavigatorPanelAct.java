package com.syu.carinfo.ford;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCFordNavigatorPanelAct extends Activity implements View.OnTouchListener {
    public static RZCFordNavigatorPanelAct mInstance;
    public static boolean mIsFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_ford_navigator_panel);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.navigator_button1).setOnTouchListener(this);
        findViewById(R.id.navigator_button2).setOnTouchListener(this);
        findViewById(R.id.navigator_button3).setOnTouchListener(this);
        findViewById(R.id.navigator_button4).setOnTouchListener(this);
        findViewById(R.id.navigator_button5).setOnTouchListener(this);
        findViewById(R.id.navigator_button6).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.navigator_button1 /* 2131427820 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 4}, null, null);
                    break;
                case R.id.navigator_button2 /* 2131427821 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 8}, null, null);
                    break;
                case R.id.navigator_button3 /* 2131427822 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 16}, null, null);
                    break;
                case R.id.navigator_button4 /* 2131427828 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 32}, null, null);
                    break;
                case R.id.navigator_button5 /* 2131427829 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 128}, null, null);
                    break;
                case R.id.navigator_button6 /* 2131427830 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 64}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.navigator_button1 /* 2131427820 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button2 /* 2131427821 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button3 /* 2131427822 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button4 /* 2131427828 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button5 /* 2131427829 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button6 /* 2131427830 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
            }
        }
        return false;
    }
}
