package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class TangduLexusCarUSB extends Activity implements View.OnTouchListener {
    public static TangduLexusCarUSB mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 134:
                case 135:
                    TangduLexusCarUSB.this.mUpdaterCarUSBState();
                    break;
                case 136:
                case 137:
                    TangduLexusCarUSB.this.mUpdaterCarUSBTrack();
                    break;
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                    TangduLexusCarUSB.this.mUpdaterCarUSBTime();
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
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.lz.lexusis.TangduLexusCarUSB.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCarUSBState() {
        int value = DataCanbus.DATA[134];
        int value1 = DataCanbus.DATA[135];
        if (value1 == 1) {
            ((TextView) findViewById(R.id.luz_lexus_carusb_foldernum)).setText(R.string.jeep_random_on);
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.luz_lexus_carusb_foldernum)).setText(R.string.jeep_loop_off);
                break;
            case 1:
                ((TextView) findViewById(R.id.luz_lexus_carusb_foldernum)).setText(R.string.jeep_loop_on);
                break;
            case 2:
                ((TextView) findViewById(R.id.luz_lexus_carusb_foldernum)).setText(R.string.str_car_cd_repeattrack);
                break;
        }
    }

    
    public void mUpdaterCarUSBTrack() {
        int value = DataCanbus.DATA[136];
        int value1 = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[138];
        int value1 = DataCanbus.DATA[139];
        int value2 = DataCanbus.DATA[140];
        int value3 = DataCanbus.DATA[141];
        int value4 = DataCanbus.DATA[142];
        int value5 = DataCanbus.DATA[143];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(String.format("%d%d:%d%d:%d%d / %d%d:%d%d:%d%d", Integer.valueOf(value5 / 10), Integer.valueOf(value5 % 10), Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10), Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10), Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10), Integer.valueOf(value1 / 10), Integer.valueOf(value1 % 10), Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
    }
}
