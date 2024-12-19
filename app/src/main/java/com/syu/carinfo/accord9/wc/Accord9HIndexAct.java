package com.syu.carinfo.accord9.wc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Accord9HIndexAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.wc.Accord9HIndexAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Accord9HIndexAct.this.mUpdateCurSpeed();
                    break;
                case 2:
                    Accord9HIndexAct.this.mUpdateRightCameraStatus();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_h_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.accord9h_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.wc.Accord9HIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Accord9HIndexAct.this, Accord9HSettingsAct.class);
                    Accord9HIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurSpeed() {
        int value = DataCanbus.DATA[0];
        if (value > 0) {
            ((TextView) findViewById(R.id.accord9h_tv_curr_velocity)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.accord9h_tv_curr_velocity)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRightCameraStatus() {
        int value = DataCanbus.DATA[2];
        if (value == 0) {
            ((TextView) findViewById(R.id.accord9h_tv_right_camera_status)).setText(getString(R.string.str_right_camera_close));
        } else {
            ((TextView) findViewById(R.id.accord9h_tv_right_camera_status)).setText(getString(R.string.str_right_camera_open));
        }
    }
}
