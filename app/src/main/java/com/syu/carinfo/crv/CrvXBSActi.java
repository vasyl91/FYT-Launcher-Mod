package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0188_XBS_XP1_CRV2012;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CrvXBSActi extends BaseActivity {
    public static CrvXBSActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.crv.CrvXBSActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    CrvXBSActi.this.mUpdaterStatus();
                    break;
                case 2:
                    CrvXBSActi.this.mUpdaterCurrSource();
                    break;
                case 3:
                    CrvXBSActi.this.mUpdaterMdi();
                    break;
                case 4:
                    CrvXBSActi.this.mUpdaterTrackTime();
                    break;
                case 5:
                    CrvXBSActi.this.mUpdaterTrack();
                    break;
                case 6:
                    CrvXBSActi.this.mUpdaterProgress();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_crv);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.crv_btn_ff).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 4);
            }
        });
        findViewById(R.id.crv_btn_fr).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 3);
            }
        });
        findViewById(R.id.crv_btn_play).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 1);
            }
        });
        findViewById(R.id.crv_btn_scan).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 2);
            }
        });
        findViewById(R.id.crv_btn_folderb).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 9);
            }
        });
        findViewById(R.id.crv_btn_folderf).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 9);
            }
        });
        findViewById(R.id.crv_btn_playmode).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 10);
            }
        });
        findViewById(R.id.crv_btn_random).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.CrvXBSActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, 11);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[1] != 1) {
            DataCanbus.PROXY.cmd(1, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrSource() {
        int value = DataCanbus.DATA[2];
        if (value == 0) {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_usb);
            return;
        }
        if (value == -128) {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_ipod);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_BT);
        } else {
            ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterMdi() {
        int value = DataCanbus.DATA[3];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.crv_tv_mdi)).setText(R.string.crv_playstate_4);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int track = Callback_0188_XBS_XP1_CRV2012.mTRACK_INFO[0];
        int tarckTotal = Callback_0188_XBS_XP1_CRV2012.mTRACK_INFO[1];
        ((TextView) findViewById(R.id.crv_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int minute = Callback_0188_XBS_XP1_CRV2012.mTRACK_TIME_INFO[0];
        int second = Callback_0188_XBS_XP1_CRV2012.mTRACK_TIME_INFO[1];
        ((TextView) findViewById(R.id.crv_tv_time)).setText(String.format("%02d:%02d:%02d", Integer.valueOf(minute / 60), Integer.valueOf(minute % 60), Integer.valueOf(second)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterProgress() {
        int progress = DataCanbus.DATA[6];
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        ((ProgressBar) findViewById(R.id.crv_progress)).setProgress(progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[1];
        switch (value) {
            case 0:
                tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 1:
                tips(getResources().getString(R.string.crv_state_play));
                break;
            case 2:
                tips(getResources().getString(R.string.crv_state_pause));
                break;
            case 3:
            case 4:
            default:
                tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 5:
                tips(getResources().getString(R.string.crv_state_ScanFile));
                break;
            case 6:
                tips(getResources().getString(R.string.crv_state_ScanFld));
                break;
            case 7:
                tips(getResources().getString(R.string.crv_state_loading));
                break;
        }
    }

    public void tips(String str) {
        this.toast = new Toast(this);
        this.toast.setGravity(17, 0, 0);
        this.toast.setDuration(0);
        this.view = new TextView(this);
        this.view.setText(str);
        this.view.setWidth(200);
        this.view.setHeight(100);
        this.view.setGravity(17);
        this.view.setBackgroundResource(R.drawable.d_popwindow);
        this.view.setTextSize(24.0f);
        this.toast.setView(this.view);
        this.toast.show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(1, 2);
            finish();
        }
        return true;
    }
}
