package com.syu.carinfo.lz.infinit.fx35;

import android.os.Bundle;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;

public class LuzInfinitF35CarCD extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_infinit_carcd);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
    }

    @Override
    public void removeNotify() {
    }

    @Override
    public void init() {
    }
}
