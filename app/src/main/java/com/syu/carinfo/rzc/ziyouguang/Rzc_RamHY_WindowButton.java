package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_RamHY_WindowButton extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_RamHY_WindowButton.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 145:
                    Rzc_RamHY_WindowButton.this.findViewById(R.id.Button9).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_leftwindow_auto_down_p : R.drawable.ic_lamborghini_leftwindow_auto_down_n);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_ramhy_windowsset);
        findViewById(R.id.Button1).setOnTouchListener(this);
        findViewById(R.id.Button2).setOnTouchListener(this);
        findViewById(R.id.Button3).setOnTouchListener(this);
        findViewById(R.id.Button4).setOnTouchListener(this);
        findViewById(R.id.Button5).setOnTouchListener(this);
        findViewById(R.id.Button6).setOnTouchListener(this);
        findViewById(R.id.Button7).setOnTouchListener(this);
        findViewById(R.id.Button8).setOnTouchListener(this);
        findViewById(R.id.Button9).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        switch (id) {
            case R.id.Button1 /* 2131427898 */:
                data0 = 1;
                data1 = 1;
                break;
            case R.id.Button2 /* 2131427899 */:
                data0 = 1;
                data1 = 2;
                break;
            case R.id.Button3 /* 2131427900 */:
                data0 = 3;
                data1 = 1;
                break;
            case R.id.Button4 /* 2131427901 */:
                data0 = 3;
                data1 = 2;
                break;
            case R.id.Button9 /* 2131427902 */:
                data0 = 0;
                if (DataCanbus.DATA[145] == 1) {
                    data1 = 0;
                    break;
                } else {
                    data1 = 1;
                    break;
                }
            case R.id.Button5 /* 2131427903 */:
                data0 = 2;
                data1 = 1;
                break;
            case R.id.Button6 /* 2131427904 */:
                data0 = 2;
                data1 = 2;
                break;
            case R.id.Button7 /* 2131427905 */:
                data0 = 4;
                data1 = 1;
                break;
            case R.id.Button8 /* 2131427906 */:
                data0 = 4;
                data1 = 2;
                break;
        }
        if (data0 == 0) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
            }
        } else if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(1, new int[]{data0}, null, null);
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }
}
