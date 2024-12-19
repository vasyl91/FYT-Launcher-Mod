package com.syu.carinfo.xbs.yage8;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS08YageCar6Cd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static XBS08YageCar6Cd mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.yage8.XBS08YageCar6Cd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 19:
                case 20:
                    XBS08YageCar6Cd.this.updatecdTime();
                    break;
                case 21:
                    XBS08YageCar6Cd.this.updatecdTrack();
                    break;
                case 22:
                    XBS08YageCar6Cd.this.mUpdateCdRpt();
                    break;
                case 26:
                    XBS08YageCar6Cd.this.mUpdateCd1State();
                    break;
                case 27:
                    XBS08YageCar6Cd.this.mUpdateCd2State();
                    break;
                case 28:
                    XBS08YageCar6Cd.this.mUpdateCd3State();
                    break;
                case 29:
                    XBS08YageCar6Cd.this.mUpdateCd4State();
                    break;
                case 30:
                    XBS08YageCar6Cd.this.mUpdateCd5State();
                    break;
                case 31:
                    XBS08YageCar6Cd.this.mUpdateCd6State();
                    break;
                case 33:
                    XBS08YageCar6Cd.this.updateDiscNum(value);
                    break;
            }
        }
    };
    int cmdId = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_yage8_carcd);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[26];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[27];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[28];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[29];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[30];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[31];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[22];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
        findViewById(R.id.lexus_cd_random).setBackgroundResource(R.drawable.ic_lexus_cd_random_n);
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_n);
        switch (On) {
            case 1:
            case 6:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt1_n);
                break;
            case 2:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rptall_n);
                break;
            case 3:
            case 7:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_random_p);
                break;
            case 4:
            case 5:
            case 8:
                findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_p);
                break;
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d", Integer.valueOf(value)));
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[20];
        int value1 = DataCanbus.DATA[19];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d%d:%d%d", Integer.valueOf(value1 / 10), Integer.valueOf(value1 % 10), Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
    }

    public void updateDiscNum(int value) {
        ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-65536);
                break;
        }
    }

    public void init() {
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(1, 1);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_prev /* 2131427915 */:
                this.cmdId = 3;
                break;
            case R.id.cd_next /* 2131427920 */:
                this.cmdId = 4;
                break;
        }
        if (this.cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    setCdControl(this.cmdId, 1);
                    break;
                case 1:
                    setCdControl(this.cmdId, 0);
                    break;
            }
        }
        return false;
    }
}
