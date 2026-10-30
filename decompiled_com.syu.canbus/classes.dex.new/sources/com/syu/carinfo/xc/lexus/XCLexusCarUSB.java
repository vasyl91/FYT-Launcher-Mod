package com.syu.carinfo.xc.lexus;

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
public class XCLexusCarUSB extends Activity implements View.OnTouchListener {
    public static XCLexusCarUSB mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.lexus.XCLexusCarUSB.1
        @Override // com.syu.module.IUiNotify
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
        DataCanbus.PROXY.cmd(0, new int[2], null, null);
        addNotify();
        FuncMain.setChannel(11);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int cmdId1) {
        DataCanbus.PROXY.cmd(1, new int[]{cmdId, cmdId}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int cmdId = -1;
        switch (id) {
            case R.id.luz_lexus_carusb_prev /* 2131428451 */:
                cmdId = 19;
                break;
            case R.id.luz_lexus_carusb_next /* 2131428454 */:
                cmdId = 20;
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBFile() {
        int value = DataCanbus.DATA[135];
        int value1 = DataCanbus.DATA[134];
        ((TextView) findViewById(R.id.luz_lexus_carusb_foldernum)).setText("Folder:" + value + "/" + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTrack() {
        int value = DataCanbus.DATA[137];
        int value1 = DataCanbus.DATA[136];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[145];
        int value1 = DataCanbus.DATA[144];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(String.valueOf(value) + ":" + value1);
    }
}
