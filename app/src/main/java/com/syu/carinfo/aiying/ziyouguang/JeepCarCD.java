package com.syu.carinfo.aiying.ziyouguang;

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
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JeepCarCD extends BaseActivity {
    public static JeepCarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 31:
                case 32:
                case 33:
                    JeepCarCD.this.mUpdaterStatus();
                    break;
                case 34:
                case 35:
                    JeepCarCD.this.mUpdaterTrack();
                    break;
                case 36:
                case 37:
                    JeepCarCD.this.mUpdaterTrackTime();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_365_carcd);
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
    }

    class ButtonListener implements View.OnClickListener, View.OnTouchListener {
        ButtonListener() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
        
            return false;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
    public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.jeep_btn_play /* 2131427575 */:
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                        break;
                    }
                    break;
                case R.id.jeep_btn_pause /* 2131427576 */:
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(3, new int[]{2}, null, null);
                        break;
                    }
                    break;
                case R.id.jeep_btn_fr /* 2131427610 */:
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(3, new int[]{5}, null, null);
                        break;
                    }
                    break;
                case R.id.jeep_btn_ff /* 2131427611 */:
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
                        break;
                    }
                    break;
                case R.id.jeep_btn_loop /* 2131428345 */:
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(3, new int[]{7}, null, null);
                        break;
                    }
                    break;
                case R.id.jeep_btn_random /* 2131428348 */:
                    if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    }
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(3, new int[]{8}, null, null);
                        break;
                    }
                    break;
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
        DataCanbus.PROXY.cmd(3, new int[]{51}, null, null);
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[31];
        int value1 = DataCanbus.DATA[32];
        int value2 = DataCanbus.DATA[33];
        StringBuffer sb = new StringBuffer();
        switch (value) {
            case 0:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate11));
                break;
            case 1:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 2:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate10));
                break;
            case 3:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
            case 4:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 15:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
        }
        if (value2 == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_on));
        } else {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_off));
        }
        if (value1 == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_on));
        } else {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_off));
        }
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[34];
        int tarckTotal = DataCanbus.DATA[35];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[36];
        int valueall = DataCanbus.DATA[37];
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
