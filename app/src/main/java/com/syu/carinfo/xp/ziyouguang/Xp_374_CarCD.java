package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Xp_374_CarCD extends Activity implements View.OnTouchListener {
    public static Xp_374_CarCD mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Xp_374_CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 169:
                    Xp_374_CarCD.this.mUpdaterCdState(value);
                    break;
                case 170:
                    Xp_374_CarCD.this.mUpdaterCdRepeat(value);
                    break;
                case 171:
                    Xp_374_CarCD.this.mUpdaterCdRandom(value);
                    break;
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                    Xp_374_CarCD.this.mUpdaterCdTime();
                    break;
                case 178:
                case 179:
                    Xp_374_CarCD.this.mUpdaterCdTrack();
                    break;
                case 180:
                    ((TextView) Xp_374_CarCD.this.findViewById(R.id.cd_title)).setText(Callback_0374_XP1_ZiYouGuang.Title);
                    break;
                case 181:
                    ((TextView) Xp_374_CarCD.this.findViewById(R.id.cd_album)).setText(Callback_0374_XP1_ZiYouGuang.Album);
                    break;
                case 182:
                    ((TextView) Xp_374_CarCD.this.findViewById(R.id.cd_artist)).setText(Callback_0374_XP1_ZiYouGuang.Artist);
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

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(5, cmdId, 0);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_repeat /* 2131427913 */:
                if (DataCanbus.DATA[170] == 1) {
                    this.cmdId = 15;
                    break;
                } else {
                    this.cmdId = 14;
                    break;
                }
            case R.id.cd_ramdom /* 2131427914 */:
                if (DataCanbus.DATA[171] == 1) {
                    this.cmdId = 10;
                    break;
                } else {
                    this.cmdId = 9;
                    break;
                }
            case R.id.cd_prev /* 2131427915 */:
                this.cmdId = 3;
                break;
            case R.id.cd_fb /* 2131427916 */:
                this.cmdId = 6;
                break;
            case R.id.cd_play /* 2131427917 */:
                this.cmdId = 2;
                break;
            case R.id.cd_pause /* 2131427918 */:
                this.cmdId = 1;
                break;
            case R.id.cd_ff /* 2131427919 */:
                this.cmdId = 5;
                break;
            case R.id.cd_next /* 2131427920 */:
                this.cmdId = 4;
                break;
        }
        switch (event.getAction()) {
            case 0:
                setCdControl(this.cmdId, 0);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdRandom(int value) {
        ((Button) findViewById(R.id.cd_ramdom)).setSelected(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdRepeat(int value) {
        ((Button) findViewById(R.id.cd_repeat)).setSelected(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_327_insert_disc);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.crv_playstate_0);
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.crv_state_pause);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_car_cd_eject);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[178];
        int value1 = DataCanbus.DATA[179];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value + " / " + value1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTime() {
        int value = DataCanbus.DATA[172];
        int value1 = DataCanbus.DATA[173];
        int value2 = DataCanbus.DATA[174];
        int value3 = DataCanbus.DATA[175];
        int value4 = DataCanbus.DATA[176];
        int value5 = DataCanbus.DATA[177];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value) + ":" + value1 + ":" + value2 + " / " + value3 + ":" + value4 + ":" + value5);
    }
}
