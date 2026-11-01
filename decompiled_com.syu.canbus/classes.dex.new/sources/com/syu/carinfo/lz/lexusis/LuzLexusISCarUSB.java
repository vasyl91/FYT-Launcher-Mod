package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzLexusISCarUSB extends Activity implements View.OnTouchListener {
    public static LuzLexusISCarUSB mInstance;
    public static boolean mIsFront = false;
    int device = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISCarUSB.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    LuzLexusISCarUSB.this.device = (value >> 4) & 3;
                    LuzLexusISCarUSB.this.mUpdaterCarUSBState();
                    break;
                case 101:
                case 102:
                    LuzLexusISCarUSB.this.mUpdaterCarUSBTime();
                    break;
                case 103:
                case 104:
                    LuzLexusISCarUSB.this.mUpdaterCarUSBTrack();
                    break;
                case 105:
                    if (LuzLexusISCarUSB.this.device == 2) {
                        ((TextView) LuzLexusISCarUSB.this.findViewById(R.id.luz_lexus_carusb_foldernum)).setText(String.format("Folder: %d", Integer.valueOf(value)));
                    } else {
                        ((TextView) LuzLexusISCarUSB.this.findViewById(R.id.luz_lexus_carusb_foldernum)).setText("--.--");
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_lexus_carusb);
        mInstance = this;
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.luz_lexus_carusb_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.luz_lexus_carusb_start)).setOnTouchListener(this);
        ((Button) findViewById(R.id.luz_lexus_carusb_stop)).setOnTouchListener(this);
        ((Button) findViewById(R.id.luz_lexus_carusb_next)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(1, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int cmdId = 0;
        switch (id) {
            case R.id.luz_lexus_carusb_prev /* 2131428451 */:
                cmdId = 3;
                break;
            case R.id.luz_lexus_carusb_start /* 2131428452 */:
                cmdId = 1;
                break;
            case R.id.luz_lexus_carusb_stop /* 2131428453 */:
                cmdId = 2;
                break;
            case R.id.luz_lexus_carusb_next /* 2131428454 */:
                cmdId = 4;
                break;
        }
        switch (event.getAction()) {
            case 0:
                setCdControl(cmdId, 1);
                return false;
            case 1:
                setCdControl(cmdId, 0);
                return false;
            default:
                return false;
        }
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBState() {
        int value = (DataCanbus.DATA[100] >> 4) & 3;
        int value1 = DataCanbus.DATA[100] & 15;
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.luz_lexus_carusb_device)).setText(R.string.str_no_device);
                break;
            case 1:
                ((TextView) findViewById(R.id.luz_lexus_carusb_device)).setText(R.string.crv_source_ipod);
                break;
            case 2:
                ((TextView) findViewById(R.id.luz_lexus_carusb_device)).setText(R.string.crv_source_usb);
                break;
        }
        switch (value1) {
            case 0:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.crv_state_stop);
                break;
            case 1:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.crv_state_loading);
                break;
            case 2:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.str_no_usb_device);
                break;
            case 3:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.str_connected_device);
                break;
            case 4:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.crv_playstate_0);
                break;
            case 5:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.crv_state_pause);
                break;
            case 6:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.start_stop_warning_14);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTrack() {
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[104];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[101];
        int value1 = DataCanbus.DATA[102];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(String.valueOf(value) + ":" + value1);
    }
}
