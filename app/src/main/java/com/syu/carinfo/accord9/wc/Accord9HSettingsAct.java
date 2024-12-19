package com.syu.carinfo.accord9.wc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Accord9HSettingsAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.wc.Accord9HSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    Accord9HSettingsAct.this.mUpdateBright();
                    break;
                case 3:
                    Accord9HSettingsAct.this.mUpdateBackgroundColor();
                    break;
                case 4:
                    Accord9HSettingsAct.this.mUpdateCameraMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_h_settings);
        init();
        initData();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.accord9h_btn_bright_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9h_btn_bright_right)).setOnClickListener(this);
        ((TextView) findViewById(R.id.accord9h_tv_bk)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9h_btn_bk_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9h_btn_bk_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9h_btn_depression)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9h_btn_standard)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9h_btn_wideangle)).setOnClickListener(this);
    }

    private void initData() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accord9h_btn_bright_left /* 2131430159 */:
                setScreenBright(-1);
                break;
            case R.id.accord9h_btn_bright_right /* 2131430161 */:
                setScreenBright(1);
                break;
            case R.id.accord9h_btn_bk_left /* 2131430162 */:
                setBackgroundColor(-1);
                break;
            case R.id.accord9h_tv_bk /* 2131430163 */:
                setBackgroundColor(1);
                break;
            case R.id.accord9h_btn_bk_right /* 2131430164 */:
                setBackgroundColor(1);
                break;
            case R.id.accord9h_btn_depression /* 2131430165 */:
                setBackCameraMode(2);
                break;
            case R.id.accord9h_btn_standard /* 2131430166 */:
                setBackCameraMode(1);
                break;
            case R.id.accord9h_btn_wideangle /* 2131430167 */:
                setBackCameraMode(0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBright() {
        int mBrightMode = DataCanbus.DATA[1];
        ((TextView) findViewById(R.id.accord9h_tv_bright)).setText(getScreenBrightMode(mBrightMode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCameraMode() {
        int mBackCameraMode = DataCanbus.DATA[4];
        setBtnCameraFocuse(mBackCameraMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackgroundColor() {
        int mBkColor = DataCanbus.DATA[3];
        ((TextView) findViewById(R.id.accord9h_tv_bk)).setText(getBackgroundColor(mBkColor));
    }

    private void setBackCameraMode(int position) {
        int mBackCameraMode = position;
        if (mBackCameraMode < 0) {
            mBackCameraMode = 2;
        } else if (mBackCameraMode > 2) {
            mBackCameraMode = 0;
        }
        DataCanbus.PROXY.cmd(2, new int[]{mBackCameraMode}, null, null);
    }

    private void setScreenBright(int alpe) {
        int mBrightMode = DataCanbus.DATA[1] + alpe;
        if (mBrightMode < 0) {
            mBrightMode = 2;
        } else if (mBrightMode > 2) {
            mBrightMode = 0;
        }
        DataCanbus.PROXY.cmd(0, new int[]{mBrightMode}, null, null);
    }

    private String getScreenBrightMode(int position) {
        switch (position) {
            case 0:
                return getString(R.string.str_screen_bright_brightest);
            case 1:
                return getString(R.string.str_screen_bright_half);
            case 2:
                return getString(R.string.str_screen_bright_black);
            default:
                return "";
        }
    }

    private void setBackgroundColor(int alpe) {
        int mBkColor = DataCanbus.DATA[3] + alpe;
        if (mBkColor < 1) {
            mBkColor = 4;
        } else if (mBkColor > 4) {
            mBkColor = 1;
        }
        DataCanbus.PROXY.cmd(1, new int[]{mBkColor}, null, null);
    }

    private String getBackgroundColor(int position) {
        switch (position) {
            case 1:
                return getString(R.string.str_background_blue);
            case 2:
                return getString(R.string.str_background_amber);
            case 3:
                return getString(R.string.str_background_red);
            case 4:
                return getString(R.string.str_background_violet);
            default:
                return "";
        }
    }

    private void setBtnCameraFocuse(int value) {
        ((Button) findViewById(R.id.accord9h_btn_wideangle)).setBackgroundResource(R.drawable.d_accord9_btn_wideangle);
        ((Button) findViewById(R.id.accord9h_btn_standard)).setBackgroundResource(R.drawable.d_accord9_btn_standard);
        ((Button) findViewById(R.id.accord9h_btn_depression)).setBackgroundResource(R.drawable.d_accord9_btn_depression);
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.accord9h_btn_wideangle)).setBackgroundResource(R.drawable.ic_accord9_wideangle_p);
                break;
            case 1:
                ((Button) findViewById(R.id.accord9h_btn_standard)).setBackgroundResource(R.drawable.ic_accord9_standard_p);
                break;
            case 2:
                ((Button) findViewById(R.id.accord9h_btn_depression)).setBackgroundResource(R.drawable.ic_accord9_depression_p);
                break;
        }
    }
}
