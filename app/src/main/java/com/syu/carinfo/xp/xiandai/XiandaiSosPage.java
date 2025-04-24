package com.syu.carinfo.xp.xiandai;

import android.os.Bundle;

import com.syu.canbus.BaseActivity;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XiandaiSosPage extends BaseActivity {
    public static XiandaiSosPage mInstance;
    public static boolean mIsFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0355_xp_xiandai_sos);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
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
        DataCanbus.PROXY.cmd(238, new int[1], null, null);
    }

    @Override
    public void addNotify() {
    }

    @Override
    public void removeNotify() {
    }
}
