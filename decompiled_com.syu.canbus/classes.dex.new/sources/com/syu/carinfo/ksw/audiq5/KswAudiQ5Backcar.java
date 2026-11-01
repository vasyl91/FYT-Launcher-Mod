package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KswAudiQ5Backcar extends BaseActivity {
    public static KswAudiQ5Backcar mInstance;
    public static boolean mIsFront = false;
    int touchMode;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_ksw_audiq5_backcar);
        initUI();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(10, new int[1], null, null);
        mIsFront = false;
    }

    private void initUI() {
        findViewById(R.id.layout_main).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int touchX = (int) event.getX();
                int touchY = (int) event.getY();
                switch (event.getAction()) {
                    case 0:
                        DataCanbus.PROXY.cmd(4, new int[]{(touchX >> 8) & 255, touchX & 255, (touchY >> 8) & 255, touchY & 255, 1}, null, null);
                        return true;
                    case 1:
                        DataCanbus.PROXY.cmd(4, new int[]{(touchX >> 8) & 255, touchX & 255, (touchY >> 8) & 255, touchY & 255, 0}, null, null);
                        return true;
                    default:
                        return true;
                }
            }
        });
    }
}
