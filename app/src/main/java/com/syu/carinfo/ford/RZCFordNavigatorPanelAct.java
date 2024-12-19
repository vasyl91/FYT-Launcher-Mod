package com.syu.carinfo.ford;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCFordNavigatorPanelAct extends Activity implements View.OnTouchListener {
    public static RZCFordNavigatorPanelAct mInstance;
    public static boolean mIsFront = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_navigator_panel);
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

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.navigator_button1 /* 2131427809 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 4}, null, null);
                    break;
                case R.id.navigator_button2 /* 2131427810 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 8}, null, null);
                    break;
                case R.id.navigator_button3 /* 2131427811 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 16}, null, null);
                    break;
                case R.id.navigator_button4 /* 2131427812 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 32}, null, null);
                    break;
                case R.id.navigator_button5 /* 2131427813 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 128}, null, null);
                    break;
                case R.id.navigator_button6 /* 2131427814 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162, 0, 64}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.navigator_button1 /* 2131427809 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button2 /* 2131427810 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button3 /* 2131427811 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button4 /* 2131427812 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button5 /* 2131427813 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
                case R.id.navigator_button6 /* 2131427814 */:
                    DataCanbus.PROXY.cmd(11, new int[]{162}, null, null);
                    break;
            }
        }
        return false;
    }
}
