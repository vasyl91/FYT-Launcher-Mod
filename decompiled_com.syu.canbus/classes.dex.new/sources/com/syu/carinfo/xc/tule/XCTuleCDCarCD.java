package com.syu.carinfo.xc.tule;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XCTuleCDCarCD extends BaseActivity implements View.OnTouchListener {
    public static XCTuleCDCarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.tule.XCTuleCDCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    XCTuleCDCarCD.this.mUpdaterCdState(value);
                    break;
                case 123:
                    ((Button) XCTuleCDCarCD.this.findViewById(R.id.cd_ramdom)).setSelected(value == 1);
                    break;
                case 124:
                    ((Button) XCTuleCDCarCD.this.findViewById(R.id.cd_repeat)).setSelected(value == 1);
                    break;
                case 125:
                case 126:
                    XCTuleCDCarCD.this.mUpdaterCdTime();
                    break;
                case 127:
                case 128:
                    XCTuleCDCarCD.this.mUpdaterCdTrack();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_nissan_tule_carcd);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.cd_repeat)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ramdom)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_fb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ff)).setOnTouchListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(7, new int[]{3, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(8, new int[]{cmdId, touchState}, null, null);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int cmdId = -1;
        int id = v.getId();
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.cd_repeat /* 2131428095 */:
                    if (DataCanbus.DATA[124] == 1) {
                        cmdId = 8;
                    } else {
                        cmdId = 6;
                    }
                    break;
                case R.id.cd_ramdom /* 2131428096 */:
                    if (DataCanbus.DATA[123] == 1) {
                        cmdId = 7;
                    } else {
                        cmdId = 5;
                    }
                    break;
                case R.id.cd_prev /* 2131428097 */:
                    cmdId = 1;
                    break;
                case R.id.cd_fb /* 2131428098 */:
                    cmdId = 10;
                    break;
                case R.id.cd_play /* 2131428099 */:
                    cmdId = 3;
                    break;
                case R.id.cd_pause /* 2131428100 */:
                    cmdId = 4;
                    break;
                case R.id.cd_ff /* 2131428101 */:
                    cmdId = 9;
                    break;
                case R.id.cd_next /* 2131428102 */:
                    cmdId = 2;
                    break;
            }
            if (cmdId != -1) {
                setCdControl(cmdId, 1);
            }
        } else if (event.getAction() == 1) {
            switch (id) {
                case R.id.cd_fb /* 2131428098 */:
                    cmdId = 10;
                    break;
                case R.id.cd_ff /* 2131428101 */:
                    cmdId = 9;
                    break;
            }
            if (cmdId != -1) {
                setCdControl(cmdId, 0);
            }
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate7);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_sbd_x80_scan);
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate3);
                break;
            case 7:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 8:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate5);
                break;
            case 9:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate9);
                break;
            case 128:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            default:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate11);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[127];
        int value2 = DataCanbus.DATA[128];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value + "/" + value2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTime() {
        int value1 = DataCanbus.DATA[125];
        int value2 = DataCanbus.DATA[126];
        int hour1 = value1 / 3600;
        int minute1 = (value1 % 3600) / 60;
        int second1 = value1 % 60;
        int hour2 = value2 / 3600;
        int minute2 = (value2 % 3600) / 60;
        int second2 = value2 % 60;
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(hour1) + ":" + minute1 + ":" + second1 + " / " + hour2 + ":" + minute2 + ":" + second2);
    }
}
