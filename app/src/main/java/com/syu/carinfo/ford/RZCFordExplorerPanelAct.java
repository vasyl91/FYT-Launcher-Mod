package com.syu.carinfo.ford;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class RZCFordExplorerPanelAct extends Activity implements View.OnTouchListener {
    public static RZCFordExplorerPanelAct mInstance;
    public static boolean mIsFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_ford_explorer_panel);
        mInstance = this;
        init();
    }

    public void init() {
        findViewById(R.id.navigator_button1).setOnTouchListener(this);
        findViewById(R.id.navigator_button2).setOnTouchListener(this);
        findViewById(R.id.navigator_button3).setOnTouchListener(this);
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
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x004e. Please report as an issue. */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.navigator_button1 /* 2131427820 */:
                    DataCanbus.PROXY.cmd(11, new int[]{163, 36}, null, null);
                    break;
                case R.id.navigator_button2 /* 2131427821 */:
                    DataCanbus.PROXY.cmd(11, new int[]{163, 38}, null, null);
                    break;
                case R.id.navigator_button3 /* 2131427822 */:
                    DataCanbus.PROXY.cmd(11, new int[]{163, 37}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
            }
        }
        return false;
    }
}
