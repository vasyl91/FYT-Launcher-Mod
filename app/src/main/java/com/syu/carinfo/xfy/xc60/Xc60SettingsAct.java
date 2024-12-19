package com.syu.carinfo.xfy.xc60;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Xc60SettingsAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.xc60.Xc60SettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 59:
                    Xc60SettingsAct.this.updateCarAudio(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xfy_xc60_setfunc);
        ((Button) findViewById(R.id.xc60_btn_car_audio_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.xc60.Xc60SettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[59] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xc60_btn_car_audio_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.xc60.Xc60SettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[59] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarAudio(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_xc60_car_audio)).setText(R.string.str_sbd_x80_media_state_15);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_xc60_car_audio)).setText(R.string.crv_source_usb);
                break;
        }
    }
}
