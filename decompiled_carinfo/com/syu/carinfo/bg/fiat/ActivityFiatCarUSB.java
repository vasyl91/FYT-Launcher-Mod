package com.syu.carinfo.bg.fiat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityFiatCarUSB extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    ActivityFiatCarUSB.this.updateVoiceState(this.value);
                    break;
                case 8:
                    ActivityFiatCarUSB.this.updateBTState(this.value);
                    break;
                case 9:
                    ActivityFiatCarUSB.this.updateUSBState(this.value);
                    break;
                case 10:
                    ActivityFiatCarUSB.this.updatePlayTime(this.value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_434_bg_fiat_carusb);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_327_cd_pre).setOnClickListener(this);
        findViewById(R.id.btn_327_cd_next).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        setCmdKey(129);
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_327_cd_pre /* 2131430054 */:
                setCmdKey(4);
                break;
            case R.id.btn_327_cd_next /* 2131430055 */:
                setCmdKey(3);
                break;
        }
    }

    private void setCmdKey(int cmd) {
        DataCanbus.PROXY.cmd(0, cmd);
    }

    protected void updateVoiceState(int value) {
        if (findViewById(R.id.tv_434_voice_state) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_434_voice_state)).setText(R.string.rzc_c4l_close);
            } else {
                ((TextView) findViewById(R.id.tv_434_voice_state)).setText(R.string.rzc_c4l_open);
            }
        }
    }

    protected void updateBTState(int value) {
        if (findViewById(R.id.tv_434_bt_state) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_434_bt_state)).setText(R.string.str_434fiat_bt_state0);
            } else {
                ((TextView) findViewById(R.id.tv_434_bt_state)).setText(R.string.str_434fiat_bt_state1);
            }
        }
    }

    protected void updatePlayTime(int value) {
        if (findViewById(R.id.tv_434_usb_playtime) != null) {
            ((TextView) findViewById(R.id.tv_434_usb_playtime)).setText(String.format("%02d:%02d", Integer.valueOf(value / 60), Integer.valueOf(value % 60)));
        }
    }

    protected void updateUSBState(int value) {
        if (findViewById(R.id.tv_434_usb_state) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_434_usb_state)).setText(R.string.str_434fiat_usb_state0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_434_usb_state)).setText(R.string.str_434fiat_usb_state1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_434_usb_state)).setText(R.string.str_434fiat_usb_state2);
                    break;
            }
        }
    }
}
