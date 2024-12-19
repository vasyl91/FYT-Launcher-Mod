package com.syu.carinfo.xp_angkesailam3;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0170_XP1_AnKeSela;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class M3CarCD extends BaseActivity {
    public static M3CarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp_angkesailam3.M3CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    M3CarCD.this.updaterCdTextInfo();
                    break;
                case 2:
                    M3CarCD.this.mUpdaterTrackTime();
                    break;
                case 3:
                case 5:
                    M3CarCD.this.mUpdaterStatus();
                    break;
                case 4:
                    M3CarCD.this.mUpdaterTrack();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_170_carcd);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.jeep_btn_play)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_ff)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_fr)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_pause)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_random)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_backward)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_forward)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_open)).setOnTouchListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener, View.OnTouchListener {
        ButtonListener() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == 0) {
                switch (v.getId()) {
                    case R.id.jeep_btn_play /* 2131427575 */:
                        DataCanbus.PROXY.cmd(0, new int[]{2}, null, null);
                        break;
                    case R.id.jeep_btn_pause /* 2131427576 */:
                        DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                        break;
                    case R.id.jeep_btn_fr /* 2131427610 */:
                        DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
                        break;
                    case R.id.jeep_btn_ff /* 2131427611 */:
                        DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                        break;
                    case R.id.jeep_btn_loop /* 2131428345 */:
                        if ((DataCanbus.DATA[5] & 1) == 1) {
                            DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
                            break;
                        }
                    case R.id.jeep_btn_backward /* 2131428346 */:
                        DataCanbus.PROXY.cmd(0, new int[]{6}, null, null);
                        break;
                    case R.id.jeep_btn_forward /* 2131428347 */:
                        DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                        break;
                    case R.id.jeep_btn_random /* 2131428348 */:
                        if (((DataCanbus.DATA[5] >> 1) & 1) == 1) {
                            DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                            break;
                        }
                    case R.id.jeep_btn_open /* 2131428801 */:
                        DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
                        break;
                }
            }
            return false;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(1, new int[]{37}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{39}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{240}, null, null);
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
        DataCanbus.PROXY.cmd(0, new int[1], null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[3];
        int value1 = DataCanbus.DATA[5];
        StringBuffer sb = new StringBuffer();
        switch (value) {
            case 0:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate1));
                break;
            case 1:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 3:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate10));
                break;
            case 4:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
            case 5:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
            case 6:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 7:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_fb));
                break;
            case 8:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_ff));
                break;
            case 13:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.crv_state_ScanFile));
                break;
        }
        if ((value1 & 1) == 1) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_on));
        } else {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_off));
        }
        if (((value1 >> 1) & 1) == 1) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_on));
        } else {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_off));
        }
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        int infoType = Callback_0170_XP1_AnKeSela.infoType & 65535;
        String strInfo = "";
        if (Callback_0170_XP1_AnKeSela.Songname != null) {
            strInfo = Callback_0170_XP1_AnKeSela.Songname;
        }
        switch (infoType) {
            case 1:
                String str = String.valueOf(String.format("歌曲名：", new Object[0])) + " " + strInfo;
                ((TextView) findViewById(R.id.m3_170_song)).setText(str);
                break;
            case 3:
                String str2 = String.valueOf(String.format("艺术家：", new Object[0])) + " " + strInfo;
                ((TextView) findViewById(R.id.m3_170_artist)).setText(str2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[4];
        if (track == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("---");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%03d", Integer.valueOf(track)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int value = (DataCanbus.DATA[2] >> 16) & 65535;
        int valueall = DataCanbus.DATA[2] & 65535;
        if (value == 65535) {
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
