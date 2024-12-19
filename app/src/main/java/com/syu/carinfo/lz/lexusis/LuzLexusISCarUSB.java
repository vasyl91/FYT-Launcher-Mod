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
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzLexusISCarUSB extends Activity implements View.OnTouchListener {
    public static LuzLexusISCarUSB mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable CdControl = new Runnable() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISCarUSB.1
        @Override // java.lang.Runnable
        public void run() {
            LuzLexusISCarUSB.this.setCdControl(LuzLexusISCarUSB.this.cmdId, 0);
        }
    };
    int device = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusISCarUSB.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    LuzLexusISCarUSB.this.device = (value >> 4) & 3;
                    LuzLexusISCarUSB.this.mUpdaterCarUSBState();
                    break;
                case 28:
                case 29:
                    LuzLexusISCarUSB.this.mUpdaterCarUSBTime();
                    break;
                case 30:
                case 31:
                    LuzLexusISCarUSB.this.mUpdaterCarUSBTrack();
                    break;
                case 32:
                    if (LuzLexusISCarUSB.this.device == 2) {
                        ((TextView) LuzLexusISCarUSB.this.findViewById(R.id.luz_lexus_carusb_foldernum)).setText(String.format("Folder: %d", Integer.valueOf(value)));
                        break;
                    } else {
                        ((TextView) LuzLexusISCarUSB.this.findViewById(R.id.luz_lexus_carusb_foldernum)).setText("--.--");
                        break;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(1, cmdId, touchState);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.luz_lexus_carusb_prev /* 2131428286 */:
                this.cmdId = 3;
                break;
            case R.id.luz_lexus_carusb_start /* 2131428287 */:
                this.cmdId = 1;
                break;
            case R.id.luz_lexus_carusb_stop /* 2131428288 */:
                this.cmdId = 2;
                break;
            case R.id.luz_lexus_carusb_next /* 2131428289 */:
                this.cmdId = 4;
                break;
        }
        switch (event.getAction()) {
            case 0:
                this.touchState = 1;
                this.bNeedSend = true;
                setCdControl(this.cmdId, this.touchState);
                break;
            case 1:
                this.bNeedSend = false;
                this.touchState = 0;
                HandlerUI.getInstance().postDelayed(this.CdControl, 100L);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBState() {
        int value = (DataCanbus.DATA[27] >> 4) & 3;
        int value1 = DataCanbus.DATA[27] & 15;
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
        int value = DataCanbus.DATA[30];
        int value1 = DataCanbus.DATA[31];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[28];
        int value1 = DataCanbus.DATA[29];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(String.valueOf(value) + ":" + value1);
    }
}
