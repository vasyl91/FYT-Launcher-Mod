package com.syu.carinfo.wc.axela;

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
import com.syu.module.canbus.Callback_0443_WC2_MAZD_ALL;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityMzdAllAxelaCD extends BaseActivity implements View.OnClickListener {
    public static ActivityMzdAllAxelaCD mInstance;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllAxelaCD.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                case 32:
                case 33:
                    ActivityMzdAllAxelaCD.this.mUpdaterStatus();
                    break;
                case 34:
                    ActivityMzdAllAxelaCD.this.mUpdaterTrack();
                    break;
                case 36:
                    ActivityMzdAllAxelaCD.this.mUpdaterTrackTime();
                    break;
                case 37:
                    ActivityMzdAllAxelaCD.this.updaterCdTextInfo();
                    break;
            }
        }
    };
    public static boolean mIsFront = false;
    static int mCurrentTime = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_421_carcd);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.jeep_btn_play)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_ff)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_pause)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_random)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_backward)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_forward)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_ff)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllAxelaCD.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{6, 1}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.jeep_btn_fr)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.syu.carinfo.wc.axela.ActivityMzdAllAxelaCD.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{6}, null, null);
                return true;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(5, new int[]{2}, null, null);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(5, new int[]{7}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(5, new int[]{7, 1}, null, null);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                int value = DataCanbus.DATA[32] + 1;
                DataCanbus.PROXY.cmd(5, new int[]{3, value % 3}, null, null);
                break;
            case R.id.jeep_btn_backward /* 2131428346 */:
                DataCanbus.PROXY.cmd(5, new int[]{8, 1}, null, null);
                break;
            case R.id.jeep_btn_forward /* 2131428347 */:
                DataCanbus.PROXY.cmd(5, new int[]{8}, null, null);
                break;
            case R.id.jeep_btn_random /* 2131428348 */:
                int value2 = DataCanbus.DATA[33] + 1;
                DataCanbus.PROXY.cmd(5, new int[]{5, value2 % 3}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(5, new int[]{9, 1}, null, null);
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(5, new int[]{10}, null, null);
        DataCanbus.PROXY.cmd(5, new int[]{10, 1}, null, null);
        DataCanbus.PROXY.cmd(5, new int[]{10, 2}, null, null);
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
        DataCanbus.PROXY.cmd(5, new int[]{9}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[31];
        int value1 = DataCanbus.DATA[33];
        int value2 = DataCanbus.DATA[32];
        StringBuffer sb = new StringBuffer();
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%02d/ %02d", 0, 0));
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate1));
                break;
            case 1:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
            case 2:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate10));
                break;
            case 3:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
            case 4:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 5:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 6:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate7));
                break;
            case 7:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate11));
                break;
            case 8:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate8));
                break;
            case 9:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate9));
                break;
        }
        switch (value2) {
            case 1:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_repeatfolder));
                break;
            case 2:
                sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_repeattrack));
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
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        int mId3Type = Callback_0443_WC2_MAZD_ALL.mId3Type & 65535;
        String strInfo = "";
        if (Callback_0443_WC2_MAZD_ALL.mId3Name != null) {
            strInfo = Callback_0443_WC2_MAZD_ALL.mId3Name;
        }
        switch (mId3Type) {
            case 1:
                String str = String.valueOf(getString(R.string.str_car_cd_title)) + strInfo;
                ((TextView) findViewById(R.id.m3_421_song)).setText(str);
                break;
            case 2:
                String str2 = String.valueOf(getString(R.string.str_car_cd_artist)) + strInfo;
                ((TextView) findViewById(R.id.m3_421_artist)).setText(str2);
                break;
            case 3:
                String str3 = String.valueOf(getString(R.string.str_car_cd_album)) + strInfo;
                ((TextView) findViewById(R.id.m3_421_album)).setText(str3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int curTrack = DataCanbus.DATA[34] & 65535;
        int totalTrack = (DataCanbus.DATA[34] >> 16) & 65535;
        if (totalTrack == 65535) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("---");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%02d/ %02d", Integer.valueOf(curTrack), Integer.valueOf(totalTrack)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int totalTime = (DataCanbus.DATA[36] >> 16) & 65535;
        int curTime = DataCanbus.DATA[36] & 65535;
        if (totalTime == 65535) {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText("--:-- / --:--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText(String.format("%02d:%02d / %02d:%02d", Integer.valueOf(curTime / 60), Integer.valueOf(curTime % 60), Integer.valueOf(totalTime / 60), Integer.valueOf(totalTime % 60)));
        }
        if (curTime >= 0) {
            ((ProgressBar) findViewById(R.id.jeep_progress)).setMax(totalTime);
            ((ProgressBar) findViewById(R.id.jeep_progress)).setProgress(curTime);
        }
        if (totalTime != 0 && curTime >= totalTime - 1) {
            DataCanbus.PROXY.cmd(5, new int[]{10}, null, null);
            DataCanbus.PROXY.cmd(5, new int[]{10, 1}, null, null);
            DataCanbus.PROXY.cmd(5, new int[]{10, 2}, null, null);
        }
        mCurrentTime = curTime;
    }
}
