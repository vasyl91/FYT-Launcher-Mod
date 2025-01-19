package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzLexusISCarUSB extends Activity implements View.OnTouchListener {
    public static LuzLexusISCarUSB mInstance;
    public static boolean mIsFront = false;
    int device = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                        break;
                    } else {
                        ((TextView) LuzLexusISCarUSB.this.findViewById(R.id.luz_lexus_carusb_foldernum)).setText("--.--");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_lexus_carusb);
        mInstance = this;
        init();
    }

    private void init() {
        findViewById(R.id.luz_lexus_carusb_prev).setOnTouchListener(this);
        findViewById(R.id.luz_lexus_carusb_start).setOnTouchListener(this);
        findViewById(R.id.luz_lexus_carusb_stop).setOnTouchListener(this);
        findViewById(R.id.luz_lexus_carusb_next).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(1, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        return false;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            r3 = 0
            int r1 = r5.getId()
            r0 = 0
            switch(r1) {
                case 2131428278: goto L11;
                case 2131428279: goto L13;
                case 2131428280: goto L15;
                case 2131428281: goto L17;
                default: goto L9;
            }
        L9:
            int r2 = r6.getAction()
            switch(r2) {
                case 0: goto L19;
                case 1: goto L1e;
                default: goto L10;
            }
        L10:
            return r3
        L11:
            r0 = 3
            goto L9
        L13:
            r0 = 1
            goto L9
        L15:
            r0 = 2
            goto L9
        L17:
            r0 = 4
            goto L9
        L19:
            r2 = 1
            r4.setCdControl(r0, r2)
            goto L10
        L1e:
            r4.setCdControl(r0, r3)
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.lz.lexusis.LuzLexusISCarUSB.onTouch(android.view.View, android.view.MotionEvent):boolean");
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

    
    public void mUpdaterCarUSBTrack() {
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[104];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[101];
        int value1 = DataCanbus.DATA[102];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(value + ":" + value1);
    }
}
