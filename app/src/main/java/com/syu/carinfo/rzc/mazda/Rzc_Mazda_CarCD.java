package com.syu.carinfo.rzc.mazda;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_RZC_MZD_ALL;
import com.syu.module.canbus.DataCanbus;

public class Rzc_Mazda_CarCD extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    public static Rzc_Mazda_CarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 79:
                case 80:
                case 81:
                    Rzc_Mazda_CarCD.this.mUpdaterStatus();
                    break;
                case 85:
                case 86:
                    Rzc_Mazda_CarCD.this.mUpdaterTrack();
                    break;
                case 87:
                case 88:
                    Rzc_Mazda_CarCD.this.mUpdaterTrackTime();
                    break;
                case 89:
                    ((TextView) Rzc_Mazda_CarCD.this.findViewById(R.id.xbs_418_song)).setText(Callback_0439_RZC_MZD_ALL.SongTitle);
                    break;
                case 90:
                    ((TextView) Rzc_Mazda_CarCD.this.findViewById(R.id.xbs_418_artist)).setText(Callback_0439_RZC_MZD_ALL.SongArtist);
                    break;
                case 91:
                    ((TextView) Rzc_Mazda_CarCD.this.findViewById(R.id.xbs_418_disc)).setText(Callback_0439_RZC_MZD_ALL.SongAblum);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_418_xbs_carcd);
        mInstance = this;
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_play /* 2131427585 */:
                DataCanbus.PROXY.cmd(3, new int[]{128}, null, null);
                break;
            case R.id.jeep_btn_pause /* 2131427586 */:
                DataCanbus.PROXY.cmd(3, new int[]{129}, null, null);
                break;
            case R.id.jeep_btn_fr /* 2131427622 */:
                DataCanbus.PROXY.cmd(3, new int[]{132}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427623 */:
                DataCanbus.PROXY.cmd(3, new int[]{131}, null, null);
                break;
            case R.id.jeep_btn_loop /* 2131427737 */:
                int rep_mode = DataCanbus.DATA[81];
                if (rep_mode == 1) {
                    DataCanbus.PROXY.cmd(3, new int[]{136}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{135}, null, null);
                    break;
                }
            case R.id.jeep_btn_random /* 2131427740 */:
                int random_mode = DataCanbus.DATA[80];
                if (random_mode == 1) {
                    DataCanbus.PROXY.cmd(3, new int[]{134}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{133}, null, null);
                    break;
                }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_btn_fr /* 2131427622 */:
                DataCanbus.PROXY.cmd(3, new int[]{13}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427623 */:
                DataCanbus.PROXY.cmd(3, new int[]{12}, null, null);
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(3, new int[]{14}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[79];
        int random_mode = DataCanbus.DATA[80];
        int rep_mode = DataCanbus.DATA[81];
        StringBuffer sb = new StringBuffer();
        switch (value) {
            case 0:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate7));
                break;
            case 1:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 2:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
            case 3:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
            case 4:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 5:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate10));
                break;
        }
        if (rep_mode == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_off));
        } else if (rep_mode == 1) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_on));
        }
        if (random_mode == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_off));
        } else if (random_mode == 1) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_on));
        }
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[86];
        int tarckTotal = DataCanbus.DATA[85];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[88];
        int valueall = DataCanbus.DATA[87];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText("--:--:-- / --:--:--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText(String.format("%02d:%02d:%02d / %02d:%02d:%02d", Integer.valueOf(value >> 16), Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255), Integer.valueOf(valueall >> 16), Integer.valueOf((valueall >> 8) & 255), Integer.valueOf(valueall & 255)));
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
