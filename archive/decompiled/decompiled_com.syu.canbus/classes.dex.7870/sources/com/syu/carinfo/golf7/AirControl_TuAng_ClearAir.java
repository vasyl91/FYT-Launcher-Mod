package com.syu.carinfo.golf7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class AirControl_TuAng_ClearAir extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControl_TuAng_ClearAir.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 73:
                    AirControl_TuAng_ClearAir.this.uClearProgress(value);
                    break;
                case 76:
                    AirControl_TuAng_ClearAir.this.uClearAir(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_tuang_clearair);
        initUI();
    }

    private void initUI() {
        setListner((Button) findViewById(R.id.btn_plus1));
        setListner((ImageView) findViewById(R.id.layout_view1));
    }

    private void setListner(View v) {
        if (v != null) {
            v.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_view1 /* 2131427404 */:
            case R.id.btn_plus1 /* 2131427419 */:
                int value = DataCanbus.DATA[76];
                setAirCmd(32, value == 0 ? 1 : 0);
                break;
        }
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

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mCanbusNotify);
    }

    protected void uClearAir(int val) {
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setText(val == 0 ? "OFF" : "ON");
        }
    }

    protected void uClearProgress(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setVisibility(val == 0 ? 0 : 4);
        }
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (val > 0 && val < 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(val * 10) + "%");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText("0%");
            }
        }
    }
}
