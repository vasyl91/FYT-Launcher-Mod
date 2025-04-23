package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.view.KeyEvent;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;

public class IndexAct_lz_bmw extends BaseActivity {
    public static IndexAct_lz_bmw mInstance;
    public static boolean mIsFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_448_lz_bmw);
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
