package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityHondaNullBackCar extends Activity {
    public static ActivityHondaNullBackCar mInstance;
    public static boolean mIsFront = false;
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { 
        @Override
        public void run() {
            ActivityHondaNullBackCar.this.num++;
            if (ActivityHondaNullBackCar.this.num == 8) {
                DataCanbus.PROXY.cmd(99, new int[]{1}, null, null);
                HandlerUI.getInstance().removeCallbacks(ActivityHondaNullBackCar.this.mShowTurnLeftLight);
            } else {
                HandlerUI.getInstance().removeCallbacks(ActivityHondaNullBackCar.this.mShowTurnLeftLight);
                HandlerUI.getInstance().postDelayed(ActivityHondaNullBackCar.this.mShowTurnLeftLight, 100L);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_298_honda_nullact);
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        mUpdaterTurnleftLight(1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        mUpdaterTurnleftLight(0);
    }

    private void mUpdaterTurnleftLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnLeftLight, 100L);
        } else {
            this.num = 0;
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
        }
    }
}
