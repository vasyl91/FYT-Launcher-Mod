package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_OD_MZD_ALL;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MazdAllCarCD extends BaseActivity implements View.OnClickListener {
    public static MazdAllCarCD mInstance;
    private Button mBtnFF;
    private Button mBtnFR;
    private Button mBtnLoop;
    private Button mBtnPause;
    private Button mBtnPlay;
    private Button mBtnRandom;
    private Button mBtnbackward;
    private Button mBtnforward;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.MazdAllCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                    MazdAllCarCD.this.mUpdaterStatus();
                    break;
                case 33:
                case 37:
                    MazdAllCarCD.this.mUpdaterTrack();
                    break;
                case 38:
                case 39:
                    MazdAllCarCD.this.mUpdaterTrackTime();
                    break;
                case 40:
                case 41:
                case 42:
                    MazdAllCarCD.this.updaterCdTextInfo();
                    break;
            }
        }
    };
    private ProgressBar mPlayProgress;
    private TextView mTvAlbum;
    private TextView mTvArtist;
    private TextView mTvSong;
    private TextView mTvState;
    private TextView mTvTrack;
    private TextView mTvTrackTime;
    public static boolean mIsFront = false;
    static int mCurrentTime = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_od_mazdall_carcd);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvState = (TextView) findViewById(R.id.jeep_tv_state);
        this.mTvTrack = (TextView) findViewById(R.id.jeep_tv_track);
        this.mTvTrackTime = (TextView) findViewById(R.id.jeep_tv_time);
        this.mPlayProgress = (ProgressBar) findViewById(R.id.jeep_progress);
        this.mTvSong = (TextView) findViewById(R.id.m3_421_song);
        this.mTvAlbum = (TextView) findViewById(R.id.m3_421_album);
        this.mTvArtist = (TextView) findViewById(R.id.m3_421_artist);
        this.mBtnPlay = (Button) findViewById(R.id.jeep_btn_play);
        this.mBtnPlay.setOnClickListener(this);
        this.mBtnFF = (Button) findViewById(R.id.jeep_btn_ff);
        this.mBtnFF.setOnClickListener(this);
        this.mBtnFR = (Button) findViewById(R.id.jeep_btn_fr);
        this.mBtnFR.setOnClickListener(this);
        this.mBtnPause = (Button) findViewById(R.id.jeep_btn_pause);
        this.mBtnPause.setOnClickListener(this);
        this.mBtnLoop = (Button) findViewById(R.id.jeep_btn_loop);
        this.mBtnLoop.setOnClickListener(this);
        this.mBtnRandom = (Button) findViewById(R.id.jeep_btn_random);
        this.mBtnRandom.setOnClickListener(this);
        this.mBtnbackward = (Button) findViewById(R.id.jeep_btn_backward);
        this.mBtnbackward.setOnClickListener(this);
        this.mBtnforward = (Button) findViewById(R.id.jeep_btn_forward);
        this.mBtnforward.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(1, new int[1], null, null);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(1, new int[]{5}, null, null);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                int value = (DataCanbus.DATA[35] + 1) % 3;
                if (value == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{6}, null, null);
                    break;
                } else if (value == 2) {
                    DataCanbus.PROXY.cmd(1, new int[]{7}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(1, new int[]{8}, null, null);
                    break;
                }
            case R.id.jeep_btn_backward /* 2131428346 */:
                DataCanbus.PROXY.cmd(1, new int[]{13}, null, null);
                break;
            case R.id.jeep_btn_forward /* 2131428347 */:
                DataCanbus.PROXY.cmd(1, new int[]{12}, null, null);
                break;
            case R.id.jeep_btn_random /* 2131428348 */:
                int value2 = (DataCanbus.DATA[36] + 1) % 3;
                if (value2 == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{9}, null, null);
                    break;
                } else if (value2 == 2) {
                    DataCanbus.PROXY.cmd(1, new int[]{10}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(1, new int[]{11}, null, null);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(1, new int[]{14}, null, null);
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DataCanbus.PROXY.cmd(1, new int[]{15}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[34];
        int value1 = DataCanbus.DATA[36];
        int value2 = DataCanbus.DATA[35];
        int value3 = DataCanbus.DATA[31];
        int value4 = DataCanbus.DATA[32];
        StringBuffer sb = new StringBuffer();
        switch (value3) {
            case 0:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate1));
                this.mTvTrack.setText(String.format("%02d/ %02d", 0, 0));
                break;
            case 1:
                sb.append("DVD");
                break;
            case 2:
                sb.append("CD");
                break;
        }
        switch (value4) {
            case 1:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate9));
                this.mTvTrack.setText(String.format("%02d/ %02d", 0, 0));
                break;
        }
        switch (value) {
            case 0:
                this.mTvTrack.setText(String.format("%02d/ %02d", 0, 0));
                sb.append(" " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate7));
                break;
            case 1:
                sb.append(" " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 2:
                sb.append(" " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
            case 3:
                sb.append(" " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 4:
                sb.append(" " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
        }
        switch (value2) {
            case 1:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_repeattrack));
                break;
            case 2:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_repeatfolder));
                break;
            default:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_off));
                break;
        }
        switch (value1) {
            case 1:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_randomfoldle));
                break;
            case 2:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_randomdisc));
                break;
            default:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_off));
                break;
        }
        this.mTvState.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        this.mTvSong.setText(String.valueOf(getString(R.string.str_car_cd_title)) + Callback_0439_OD_MZD_ALL.mId3Name);
        this.mTvArtist.setText(String.valueOf(getString(R.string.str_car_cd_artist)) + Callback_0439_OD_MZD_ALL.mIdArtist3Name);
        this.mTvAlbum.setText(String.valueOf(getString(R.string.str_car_cd_album)) + Callback_0439_OD_MZD_ALL.mId3DiscName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int curTrack = DataCanbus.DATA[37];
        int totalTrack = DataCanbus.DATA[33];
        if (totalTrack == 65535) {
            this.mTvTrack.setText("---");
        } else {
            this.mTvTrack.setText(String.format("%02d/ %02d", Integer.valueOf(curTrack), Integer.valueOf(totalTrack)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int totalTime = DataCanbus.DATA[39];
        int curTime = DataCanbus.DATA[38];
        if (totalTime == 65535) {
            this.mTvTrackTime.setText("--:-- / --:--");
        } else {
            this.mTvTrackTime.setText(String.format("%02d:%02d / %02d:%02d", Integer.valueOf(curTime / 60), Integer.valueOf(curTime % 60), Integer.valueOf(totalTime / 60), Integer.valueOf(totalTime % 60)));
        }
        if (curTime >= 0) {
            this.mPlayProgress.setMax(totalTime);
            this.mPlayProgress.setProgress(curTime);
        }
        if (totalTime != 0 && curTime >= totalTime - 1) {
            DataCanbus.PROXY.cmd(1, new int[]{10}, null, null);
            DataCanbus.PROXY.cmd(1, new int[]{10, 1}, null, null);
            DataCanbus.PROXY.cmd(1, new int[]{10, 2}, null, null);
        }
        mCurrentTime = curTime;
    }
}