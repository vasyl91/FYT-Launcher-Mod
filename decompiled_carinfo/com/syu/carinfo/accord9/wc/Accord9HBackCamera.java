package com.syu.carinfo.accord9.wc;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Accord9HBackCamera extends BaseActivity implements View.OnClickListener {
    public static boolean isFront = false;
    public static Accord9HBackCamera mInstance;
    private IUiNotify mNotifyCanbusLo = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 134:
                    Accord9HBackCamera.this.mUpdateCameraStatus();
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    Accord9HBackCamera.this.mUpdateCameraMode();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_accord9_h_backcar);
        ((Button) findViewById(R.id.backcar_btn_wideangle)).setOnClickListener(this);
        ((Button) findViewById(R.id.backcar_btn_standard)).setOnClickListener(this);
        ((Button) findViewById(R.id.backcar_btn_depression)).setOnClickListener(this);
        mInstance = this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backcar_btn_wideangle /* 2131430092 */:
                setBackCameraMode(0);
                break;
            case R.id.backcar_btn_standard /* 2131430093 */:
                setBackCameraMode(1);
                break;
            case R.id.backcar_btn_depression /* 2131430094 */:
                setBackCameraMode(2);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        isFront = false;
    }

    @Override
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

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 131114) {
            DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbusLo, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 131114) {
            DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbusLo);
        } else {
            DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void mUpdateCameraMode() {
        int mBackCameraMode = DataCanbus.DATA[4];
        setBtnCameraFocuse(mBackCameraMode);
    }

    
    public void mUpdateCameraStatus() {
        int mBackCameraMode = DataCanbus.DATA[134];
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
