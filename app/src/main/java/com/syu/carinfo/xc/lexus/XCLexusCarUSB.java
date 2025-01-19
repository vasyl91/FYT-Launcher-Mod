package com.syu.carinfo.xc.lexus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XCLexusCarUSB extends Activity implements View.OnTouchListener {
    public static XCLexusCarUSB mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 134:
                case 135:
                    XCLexusCarUSB.this.mUpdaterCarUSBFile();
                    break;
                case 136:
                case 137:
                    XCLexusCarUSB.this.mUpdaterCarUSBTrack();
                    break;
                case 141:
                case 142:
                    XCLexusCarUSB.this.mUpdaterCarUSBState();
                    break;
                case 144:
                case 145:
                    XCLexusCarUSB.this.mUpdaterCarUSBTime();
                    break;
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
        ((Button) findViewById(R.id.luz_lexus_carusb_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.luz_lexus_carusb_start)).setOnTouchListener(this);
        ((Button) findViewById(R.id.luz_lexus_carusb_stop)).setOnTouchListener(this);
        ((Button) findViewById(R.id.luz_lexus_carusb_next)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(0, new int[2], null, null);
        addNotify();
        FuncMain.setChannel(11);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int cmdId1) {
        DataCanbus.PROXY.cmd(1, new int[]{cmdId, cmdId}, null, null);
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
            r0 = -1
            switch(r1) {
                case 2131428278: goto L11;
                case 2131428279: goto L9;
                case 2131428280: goto L9;
                case 2131428281: goto L14;
                default: goto L9;
            }
        L9:
            int r2 = r6.getAction()
            switch(r2) {
                case 0: goto L17;
                case 1: goto L1c;
                default: goto L10;
            }
        L10:
            return r3
        L11:
            r0 = 19
            goto L9
        L14:
            r0 = 20
            goto L9
        L17:
            r2 = 1
            r4.setCdControl(r0, r2)
            goto L10
        L1c:
            r4.setCdControl(r0, r3)
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.xc.lexus.XCLexusCarUSB.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCarUSBState() {
        int value = DataCanbus.DATA[141];
        int value1 = DataCanbus.DATA[142];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.xp_380_playmode4);
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.jeep_loop_off);
                break;
            case 1:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.jeep_loop_on);
                break;
            case 2:
                ((TextView) findViewById(R.id.luz_lexus_carusb_state)).setText(R.string.str_car_cd_repeattrack);
                break;
        }
    }

    
    public void mUpdaterCarUSBFile() {
        int value = DataCanbus.DATA[135];
        int value1 = DataCanbus.DATA[134];
        ((TextView) findViewById(R.id.luz_lexus_carusb_foldernum)).setText("Folder:" + value + "/" + value1);
    }

    
    public void mUpdaterCarUSBTrack() {
        int value = DataCanbus.DATA[137];
        int value1 = DataCanbus.DATA[136];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[145];
        int value1 = DataCanbus.DATA[144];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(String.valueOf(value) + ":" + value1);
    }
}
