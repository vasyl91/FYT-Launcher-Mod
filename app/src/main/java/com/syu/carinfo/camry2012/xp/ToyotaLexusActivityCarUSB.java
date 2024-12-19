package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ToyotaLexusActivityCarUSB extends BaseActivity implements View.OnClickListener {
    public static ToyotaLexusActivityCarUSB mInst;
    public static boolean mIsFront = false;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusActivityCarUSB.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 204:
                    ToyotaLexusActivityCarUSB.this.updateDiscMode();
                    break;
                case 205:
                case 206:
                    ToyotaLexusActivityCarUSB.this.updatePlayMode();
                    break;
                case 207:
                    ToyotaLexusActivityCarUSB.this.updatePlayTrack();
                    break;
                case 208:
                    ToyotaLexusActivityCarUSB.this.updaterPlayTime();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_429_dj_crown_carusb);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_random)).setOnClickListener(this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_ff), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_fr), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_pause), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_play), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(42, 3, 0);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(42, 3, 0);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(42, 4, 0);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(42, 5, 0);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                DataCanbus.PROXY.cmd(42, 2, 0);
                break;
            case R.id.jeep_btn_random /* 2131428348 */:
                DataCanbus.PROXY.cmd(42, 1, 0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(43, 98, 0);
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[178] != 4) {
            DataCanbus.PROXY.cmd(42, 32, 8);
        }
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayTrack() {
        int track = DataCanbus.DATA[207];
        if (((TextView) findViewById(R.id.track_num_tv)) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        }
        if (((TextView) findViewById(R.id.cd_title_show)) != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText("TRACK: " + track);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayMode() {
        int rep = DataCanbus.DATA[205];
        int random = DataCanbus.DATA[206];
        if (((TextView) findViewById(R.id.mode_tv)) != null) {
            if (random == 2) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.crv_playstate_3);
                return;
            }
            if (random == 1) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.crv_playstate_4);
                return;
            }
            if (rep == 2) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_car_cd_repeatfolder);
            } else if (rep == 2) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.jeep_loop_on);
            } else {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscMode() {
        int rep_disc = DataCanbus.DATA[204];
        if (((TextView) findViewById(R.id.file_num_tv)) != null) {
            if (rep_disc == 2) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_car_cd_pause);
            } else if (rep_disc == 1) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_car_cd_play);
            } else {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_434fiat_usb_state0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPlayTime() {
        int playminute = (DataCanbus.DATA[208] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[208] & 255;
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        if (((TextView) findViewById(R.id.time_tv)) != null) {
            ((TextView) findViewById(R.id.time_tv)).setText(String.format("%02d:%02d", Integer.valueOf(playminute), Integer.valueOf(playsecond)));
        }
    }
}
