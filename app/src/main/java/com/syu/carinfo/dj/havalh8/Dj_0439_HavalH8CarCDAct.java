package com.syu.carinfo.dj.havalh8;

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
public class Dj_0439_HavalH8CarCDAct extends Activity implements View.OnTouchListener {
    public static Dj_0439_HavalH8CarCDAct mInstance;
    public static boolean mIsFront = false;
    int cmdId = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8CarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 74:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdTrack();
                    break;
                case 75:
                case 76:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdRepeatState();
                    break;
                case 77:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdState(value);
                    break;
                case 78:
                case 79:
                    Dj_0439_HavalH8CarCDAct.this.mUpdaterCdTime();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_dj_havalh8_carcd);
        mInstance = this;
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_rpt_random)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        setCdControl(7, 1, 0);
        setCdControl(7, 0, 0);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState, int type) {
        if (type == 1) {
            DataCanbus.PROXY.cmd(5, cmdId, touchState);
        } else {
            DataCanbus.PROXY.cmd(4, cmdId, touchState);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int type = 0;
        switch (id) {
            case R.id.cd_prev /* 2131427915 */:
                this.cmdId = 9;
                break;
            case R.id.cd_play /* 2131427917 */:
                type = 1;
                this.cmdId = 17;
                break;
            case R.id.cd_pause /* 2131427918 */:
                type = 1;
                this.cmdId = 16;
                break;
            case R.id.cd_next /* 2131427920 */:
                this.cmdId = 8;
                break;
            case R.id.cd_rpt_random /* 2131428201 */:
                int value = DataCanbus.DATA[75];
                int value1 = DataCanbus.DATA[76];
                if (value == 0 && value1 == 0) {
                    this.cmdId = 1;
                } else if (value == 1 && value1 == 0) {
                    this.cmdId = 2;
                } else if (value == 0 && value1 == 1) {
                    this.cmdId = 0;
                }
                type = 1;
                break;
        }
        if (this.cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    setCdControl(this.cmdId, 1, type);
                    break;
                case 1:
                    setCdControl(this.cmdId, 0, type);
                    break;
            }
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdRepeatState() {
        int value = DataCanbus.DATA[75];
        int value1 = DataCanbus.DATA[76];
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode1);
            ((Button) findViewById(R.id.cd_rpt_random)).setBackgroundResource(R.drawable.ic_cd_repeat_n);
        } else if (value == 1 && value1 == 0) {
            ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode2);
            ((Button) findViewById(R.id.cd_rpt_random)).setBackgroundResource(R.drawable.ic_cd_repeat_p);
        } else if (value == 0 && value1 == 1) {
            ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode4);
            ((Button) findViewById(R.id.cd_rpt_random)).setBackgroundResource(R.drawable.ic_cd_random2_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[74];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTime() {
        int value1 = DataCanbus.DATA[78];
        int value2 = DataCanbus.DATA[79];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value1 / 16) + (value1 % 16) + ":" + (value2 / 16) + (value2 % 16));
    }
}
