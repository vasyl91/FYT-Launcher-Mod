package com.syu.carinfo.hc.volvo;

import android.os.Bundle;
import android.view.KeyEvent;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;

@SuppressWarnings({"deprecation", "unchecked"})
public class IndexAct_Hc_volvo extends BaseActivity {
    public static IndexAct_Hc_volvo mInstance;
    public static boolean mIsFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_hc_volvo);
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }
}
