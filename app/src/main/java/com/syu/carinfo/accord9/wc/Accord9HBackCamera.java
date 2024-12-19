package com.syu.carinfo.accord9.wc;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Accord9HBackCamera extends BaseActivity implements View.OnClickListener {
    public static boolean isFront = false;
    public static Accord9HBackCamera mInstance;
    private IUiNotify mNotifyCanbusLo = new IUiNotify() { // from class: com.syu.carinfo.accord9.wc.Accord9HBackCamera.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 63:
                    Accord9HBackCamera.this.mUpdateCameraStatus();
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.wc.Accord9HBackCamera.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    Accord9HBackCamera.this.mUpdateCameraMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_h_backcar);
        ((Button) findViewById(R.id.backcar_btn_wideangle)).setOnClickListener(this);
        ((Button) findViewById(R.id.backcar_btn_standard)).setOnClickListener(this);
        ((Button) findViewById(R.id.backcar_btn_depression)).setOnClickListener(this);
        mInstance = this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backcar_btn_wideangle /* 2131430150 */:
                setBackCameraMode(0);
                break;
            case R.id.backcar_btn_standard /* 2131430151 */:
                setBackCameraMode(1);
                break;
            case R.id.backcar_btn_depression /* 2131430152 */:
                setBackCameraMode(2);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        isFront = false;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 || keyCode == 3) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setBackCameraMode(int position) {
        if (DataCanbus.DATA[1000] == 131114) {
            int cmd = 0;
            switch (position) {
                case 0:
                    cmd = 4;
                    break;
                case 1:
                    cmd = 5;
                    break;
                case 2:
                    cmd = 6;
                    break;
            }
            DataCanbus.PROXY.cmd(15, new int[]{cmd, 255}, null, null);
            return;
        }
        if (DataCanbus.DATA[1000] == 131109) {
            if (position < 0) {
                position = 2;
            } else if (position > 2) {
                position = 0;
            }
            DataCanbus.PROXY.cmd(2, new int[]{position}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 131114) {
            DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbusLo, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 131114) {
            DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbusLo);
        } else {
            DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCameraMode() {
        int mBackCameraMode = DataCanbus.DATA[4];
        setBtnCameraFocuse(mBackCameraMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCameraStatus() {
        int mBackCameraMode = DataCanbus.DATA[63];
        setBtnCameraFocuse(mBackCameraMode);
    }

    private void setBtnCameraFocuse(int value) {
        ((Button) findViewById(R.id.backcar_btn_wideangle)).setBackgroundResource(R.drawable.d_accord9_btn_backcar_wideangle);
        ((Button) findViewById(R.id.backcar_btn_standard)).setBackgroundResource(R.drawable.d_accord9_btn_backcar_standard);
        ((Button) findViewById(R.id.backcar_btn_depression)).setBackgroundResource(R.drawable.d_accord9_btn_backcar_depression);
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.backcar_btn_wideangle)).setBackgroundResource(R.drawable.ic_accord9_back_car_wideangle_p);
                break;
            case 1:
                ((Button) findViewById(R.id.backcar_btn_standard)).setBackgroundResource(R.drawable.ic_accord9_back_car_standard_p);
                break;
            case 2:
                ((Button) findViewById(R.id.backcar_btn_depression)).setBackgroundResource(R.drawable.ic_accord9_back_car_depression_p);
                break;
        }
    }
}
