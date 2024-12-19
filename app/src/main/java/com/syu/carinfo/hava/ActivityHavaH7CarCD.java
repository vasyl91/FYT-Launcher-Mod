package com.syu.carinfo.hava;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0244_RZC_XP1_HavalH2;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHavaH7CarCD extends Activity implements View.OnTouchListener {
    public static ActivityHavaH7CarCD mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.ActivityHavaH7CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    ActivityHavaH7CarCD.this.mUpdaterCdRepeat(value);
                    ActivityHavaH7CarCD.this.mUpdaterCdRandom(value);
                    break;
                case 136:
                    ActivityHavaH7CarCD.this.mUpdaterCdState(value);
                    break;
                case 137:
                case 138:
                    ActivityHavaH7CarCD.this.mUpdaterCdTrack();
                    break;
                case 139:
                case 140:
                    ActivityHavaH7CarCD.this.mUpdaterCdTime();
                    break;
                case 141:
                    ((TextView) ActivityHavaH7CarCD.this.findViewById(R.id.cd_title)).setText(Callback_0244_RZC_XP1_HavalH2.Title);
                    break;
                case 142:
                    ((TextView) ActivityHavaH7CarCD.this.findViewById(R.id.cd_album)).setText(Callback_0244_RZC_XP1_HavalH2.Album);
                    break;
                case 143:
                    ((TextView) ActivityHavaH7CarCD.this.findViewById(R.id.cd_artist)).setText(Callback_0244_RZC_XP1_HavalH2.Artist);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_daqienuoji_carcd);
        mInstance = this;
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ff)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_fb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_repeat)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ramdom)).setOnTouchListener(this);
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

    private void setCdControl(int cmdId) {
        DataCanbus.PROXY.cmd(7, new int[]{cmdId}, null, null);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_repeat /* 2131427913 */:
                this.cmdId = 17;
                break;
            case R.id.cd_ramdom /* 2131427914 */:
                this.cmdId = 8;
                break;
            case R.id.cd_prev /* 2131427915 */:
                this.cmdId = 2;
                break;
            case R.id.cd_fb /* 2131427916 */:
                this.cmdId = 3;
                break;
            case R.id.cd_play /* 2131427917 */:
                this.cmdId = 19;
                break;
            case R.id.cd_pause /* 2131427918 */:
                this.cmdId = 20;
                break;
            case R.id.cd_ff /* 2131427919 */:
                this.cmdId = 4;
                break;
            case R.id.cd_next /* 2131427920 */:
                this.cmdId = 1;
                break;
        }
        switch (event.getAction()) {
            case 0:
                setCdControl(this.cmdId);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdRandom(int value) {
        ((Button) findViewById(R.id.cd_ramdom)).setSelected(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdRepeat(int value) {
        ((Button) findViewById(R.id.cd_repeat)).setSelected(value == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate3);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate5);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate7);
                break;
            case 8:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate8);
                break;
            case 9:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate9);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[138];
        int value1 = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value + " / " + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTime() {
        int value = DataCanbus.DATA[140] / 3600;
        int value1 = (DataCanbus.DATA[140] % 3600) / 60;
        int value2 = DataCanbus.DATA[140] % 60;
        int value3 = DataCanbus.DATA[139] / 3600;
        int value4 = (DataCanbus.DATA[139] % 3600) / 60;
        int value5 = DataCanbus.DATA[139] % 60;
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value) + ":" + value1 + ":" + value2 + " / " + value3 + ":" + value4 + ":" + value5);
    }
}
