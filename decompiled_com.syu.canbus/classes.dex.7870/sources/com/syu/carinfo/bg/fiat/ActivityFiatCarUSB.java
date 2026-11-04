package com.syu.carinfo.bg.fiat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ActivityFiatCarUSB extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.fiat.ActivityFiatCarUSB.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    ActivityFiatCarUSB.this.updateVoiceState(value);
                    break;
                case 8:
                    ActivityFiatCarUSB.this.updateBTState(value);
                    break;
                case 9:
                    ActivityFiatCarUSB.this.updateUSBState(value);
                    break;
                case 10:
                    ActivityFiatCarUSB.this.updatePlayTime(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_434_bg_fiat_carusb);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        setCmdKey(129);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        setCmdKey(128);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427419 */:
                setCmdKey(4);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                setCmdKey(3);
                break;
        }
    }

    private void setCmdKey(int cmd) {
        DataCanbus.PROXY.cmd(0, cmd);
    }

    protected void updateVoiceState(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.rzc_c4l_close);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.rzc_c4l_open);
            }
        }
    }

    protected void updateBTState(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_434fiat_bt_state0);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_434fiat_bt_state1);
            }
        }
    }

    protected void updatePlayTime(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%02d:%02d", Integer.valueOf(value / 60), Integer.valueOf(value % 60)));
        }
    }

    protected void updateUSBState(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_434fiat_usb_state0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_434fiat_usb_state1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_434fiat_usb_state2);
                    break;
            }
        }
    }
}
