package com.syu.carinfo.xbs.angkesaila;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Xbs_AngKeSaiLa_CarCD extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    public static Xbs_AngKeSaiLa_CarCD mInstance;
    public static boolean mIsFront = false;
    int rep_mode = 255;
    int random_mode = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                case 9:
                case 10:
                    Xbs_AngKeSaiLa_CarCD.this.mUpdaterStatus();
                    break;
                case 8:
                case 12:
                    Xbs_AngKeSaiLa_CarCD.this.mUpdaterTrack();
                    break;
                case 13:
                case 14:
                    Xbs_AngKeSaiLa_CarCD.this.mUpdaterTrackTime();
                    break;
                case 15:
                    Xbs_AngKeSaiLa_CarCD.this.updaterCdTextInfo();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_418_xbs_carcd);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.jeep_btn_loop).setOnClickListener(this);
        findViewById(R.id.jeep_btn_random).setOnClickListener(this);
        findViewById(R.id.jeep_btn_pause).setOnClickListener(this);
        findViewById(R.id.jeep_btn_fr).setOnClickListener(this);
        findViewById(R.id.jeep_btn_ff).setOnClickListener(this);
        findViewById(R.id.jeep_btn_play).setOnClickListener(this);
        findViewById(R.id.jeep_btn_ff).setOnLongClickListener(this);
        findViewById(R.id.jeep_btn_fr).setOnLongClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_play /* 2131427688 */:
                DataCanbus.PROXY.cmd(0, new int[1], null, null);
                break;
            case R.id.jeep_btn_pause /* 2131427689 */:
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                break;
            case R.id.jeep_btn_fr /* 2131427726 */:
                DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427727 */:
                DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                break;
            case R.id.jeep_btn_loop /* 2131427820 */:
                if (this.rep_mode == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
                } else if (this.rep_mode == 2) {
                    DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{6}, null, null);
                }
                break;
            case R.id.jeep_btn_random /* 2131427823 */:
                if (this.random_mode == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
                } else if (this.random_mode == 2) {
                    DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_fr /* 2131427726 */:
                DataCanbus.PROXY.cmd(0, new int[]{12}, null, null);
                return true;
            case R.id.jeep_btn_ff /* 2131427727 */:
                DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
                return true;
            default:
                return true;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(0, new int[]{14}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        int infoType = Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza.infoType & 65535;
        String strInfo = "";
        if (Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza.Songname != null) {
            strInfo = Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza.Songname;
        }
        switch (infoType) {
            case 0:
                ((TextView) findViewById(R.id.xbs_418_song)).setText(strInfo);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_418_disc)).setText(strInfo);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_418_artist)).setText(strInfo);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[9];
        this.random_mode = DataCanbus.DATA[10] & 15;
        this.rep_mode = (DataCanbus.DATA[10] >> 4) & 15;
        StringBuffer sb = new StringBuffer();
        switch (value) {
            case 0:
                sb.append(TheApp.getInstance().getResources().getString(R.string.jeep_playstate7));
                break;
            case 1:
                sb.append(TheApp.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 2:
                sb.append(TheApp.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
            case 3:
                sb.append(TheApp.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 4:
                sb.append(TheApp.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
        }
        if (this.rep_mode == 0) {
            sb.append("  " + TheApp.getInstance().getResources().getString(R.string.jeep_loop_off));
        } else if (this.rep_mode == 1) {
            sb.append("  " + TheApp.getInstance().getResources().getString(R.string.str_car_cd_repeat1));
        } else if (this.rep_mode == 2) {
            sb.append("  " + TheApp.getInstance().getResources().getString(R.string.str_car_cd_repeatfolder));
        }
        if (this.random_mode == 0) {
            sb.append("  " + TheApp.getInstance().getResources().getString(R.string.jeep_random_off));
        } else if (this.random_mode == 1) {
            sb.append("  " + TheApp.getInstance().getResources().getString(R.string.str_car_cd_randomfoldle));
        } else if (this.random_mode == 2) {
            sb.append("  " + TheApp.getInstance().getResources().getString(R.string.str_car_cd_randomdisc));
        }
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[12];
        int tarckTotal = DataCanbus.DATA[8];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[14];
        int valueall = DataCanbus.DATA[13];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText("--:-- / --:--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText(String.format("%02d:%02d / %02d:%02d", Integer.valueOf(value / 60), Integer.valueOf(value % 60), Integer.valueOf(valueall / 60), Integer.valueOf(valueall % 60)));
        }
        if (valueall > 0) {
            int progress = (value * 100) / valueall;
            if (progress > 100) {
                progress = 100;
            }
            ((ProgressBar) findViewById(R.id.jeep_progress)).setProgress(progress);
        }
    }
}
