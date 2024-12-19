package com.syu.carinfo.xbs.angkesaila;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Xbs_AngKeSaiLa_CarCD extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    public static Xbs_AngKeSaiLa_CarCD mInstance;
    public static boolean mIsFront = false;
    int rep_mode = 255;
    int random_mode = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 50:
                case 52:
                case 53:
                    Xbs_AngKeSaiLa_CarCD.this.mUpdaterStatus();
                    break;
                case 51:
                case 55:
                    Xbs_AngKeSaiLa_CarCD.this.mUpdaterTrack();
                    break;
                case 56:
                case 57:
                    Xbs_AngKeSaiLa_CarCD.this.mUpdaterTrackTime();
                    break;
                case 58:
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
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(0, new int[1], null, null);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                if (this.rep_mode == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
                    break;
                } else if (this.rep_mode == 2) {
                    DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{6}, null, null);
                    break;
                }
            case R.id.jeep_btn_random /* 2131428348 */:
                if (this.random_mode == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
                    break;
                } else if (this.random_mode == 2) {
                    DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                    break;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        return true;
     */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r7) {
        /*
            r6 = this;
            r5 = 1
            r4 = 0
            r3 = 0
            int r0 = r7.getId()
            switch(r0) {
                case 2131427610: goto L17;
                case 2131427611: goto Lb;
                default: goto La;
            }
        La:
            return r5
        Lb:
            com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r1 = new int[r5]
            r2 = 13
            r1[r3] = r2
            r0.cmd(r3, r1, r4, r4)
            goto La
        L17:
            com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r1 = new int[r5]
            r2 = 12
            r1[r3] = r2
            r0.cmd(r3, r1, r4, r4)
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_CarCD.onLongClick(android.view.View):boolean");
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
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
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
        int value = DataCanbus.DATA[52];
        this.random_mode = DataCanbus.DATA[53] & 15;
        this.rep_mode = (DataCanbus.DATA[53] >> 4) & 15;
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
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 4:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
        }
        if (this.rep_mode == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_off));
        } else if (this.rep_mode == 1) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_repeat1));
        } else if (this.rep_mode == 2) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_repeatfolder));
        }
        if (this.random_mode == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_off));
        } else if (this.random_mode == 1) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_randomfoldle));
        } else if (this.random_mode == 2) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.str_car_cd_randomdisc));
        }
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[55];
        int tarckTotal = DataCanbus.DATA[51];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[57];
        int valueall = DataCanbus.DATA[56];
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
