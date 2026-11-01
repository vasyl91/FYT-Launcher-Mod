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
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class TangduLexusCarUSB extends Activity implements View.OnTouchListener {
    public static TangduLexusCarUSB mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCarUSB.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 156:
                case 157:
                    TangduLexusCarUSB.this.mUpdaterCarUSBState();
                    break;
                case 158:
                case 159:
                    TangduLexusCarUSB.this.mUpdaterCarUSBTrack();
                    break;
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                    TangduLexusCarUSB.this.mUpdaterCarUSBTime();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_CD /* 4981191 */:
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_CD /* 5046727 */:
                setContentView(R.layout.layout_0439_luz_lexus_carusb_yl);
                break;
            default:
                setContentView(R.layout.layout_0439_luz_lexus_carusb);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBState() {
        int value = DataCanbus.DATA[156];
        int value1 = DataCanbus.DATA[157];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTrack() {
        int value = DataCanbus.DATA[158];
        int value1 = DataCanbus.DATA[159];
        ((TextView) findViewById(R.id.luz_lexus_carusb_track)).setText("Track:" + value + "/" + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarUSBTime() {
        int value = DataCanbus.DATA[160];
        int value1 = DataCanbus.DATA[161];
        int value2 = DataCanbus.DATA[162];
        int value3 = DataCanbus.DATA[163];
        int value4 = DataCanbus.DATA[164];
        int value5 = DataCanbus.DATA[165];
        ((TextView) findViewById(R.id.luz_lexus_carusb_time)).setText(String.format("%d%d:%d%d:%d%d / %d%d:%d%d:%d%d", Integer.valueOf(value5 / 10), Integer.valueOf(value5 % 10), Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10), Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10), Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10), Integer.valueOf(value1 / 10), Integer.valueOf(value1 % 10), Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
    }
}
