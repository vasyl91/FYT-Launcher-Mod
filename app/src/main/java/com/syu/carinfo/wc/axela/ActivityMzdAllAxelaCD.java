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

public class ActivityMzdAllAxelaCD extends BaseActivity implements View.OnClickListener {
    public static ActivityMzdAllAxelaCD mInstance;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                case 100:
                case 101:
                    ActivityMzdAllAxelaCD.this.mUpdaterStatus();
                    break;
                case 102:
                    ActivityMzdAllAxelaCD.this.mUpdaterTrack();
                    break;
                case 104:
                    ActivityMzdAllAxelaCD.this.mUpdaterTrackTime();
                    break;
                case 105:
                    ActivityMzdAllAxelaCD.this.updaterCdTextInfo();
                    break;
            }
        }
    };
    public static boolean mIsFront = false;
    static int mCurrentTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_421_carcd);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.jeep_btn_play)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_ff)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_fr)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_pause)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_random)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_backward)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_forward)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_ff)).setOnLongClickListener(new View.OnLongClickListener() { 
            @Override
            public boolean onLongClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{6, 1}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.jeep_btn_fr)).setOnLongClickListener(new View.OnLongClickListener() { 
            @Override
            public boolean onLongClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{6}, null, null);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_play /* 2131427585 */:
                DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                break;
            case R.id.jeep_btn_pause /* 2131427586 */:
                DataCanbus.PROXY.cmd(5, new int[]{2}, null, null);
                break;
            case R.id.jeep_btn_fr /* 2131427622 */:
                DataCanbus.PROXY.cmd(5, new int[]{7}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427623 */:
                DataCanbus.PROXY.cmd(5, new int[]{7, 1}, null, null);
                break;
            case R.id.jeep_btn_loop /* 2131427737 */:
                int value = DataCanbus.DATA[100] + 1;
                DataCanbus.PROXY.cmd(5, new int[]{3, value % 3}, null, null);
                break;
            case R.id.jeep_btn_random /* 2131427740 */:
                int value2 = DataCanbus.DATA[101] + 1;
                DataCanbus.PROXY.cmd(5, new int[]{5, value2 % 3}, null, null);
                break;
            case R.id.jeep_btn_backward /* 2131428334 */:
                DataCanbus.PROXY.cmd(5, new int[]{8, 1}, null, null);
                break;
            case R.id.jeep_btn_forward /* 2131428335 */:
                DataCanbus.PROXY.cmd(5, new int[]{8}, null, null);
                break;
        }
    }

    @Override
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

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DataCanbus.PROXY.cmd(5, new int[]{9}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[99];
        int value1 = DataCanbus.DATA[101];
        int value2 = DataCanbus.DATA[100];
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

    
    public void mUpdaterTrack() {
        int curTrack = DataCanbus.DATA[102] & 65535;
        int totalTrack = (DataCanbus.DATA[102] >> 16) & 65535;
        if (totalTrack == 65535) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("---");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%02d/ %02d", Integer.valueOf(curTrack), Integer.valueOf(totalTrack)));
        }
    }

    
    public void mUpdaterTrackTime() {
        int totalTime = (DataCanbus.DATA[104] >> 16) & 65535;
        int curTime = DataCanbus.DATA[104] & 65535;
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
