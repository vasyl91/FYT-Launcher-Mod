package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.JumpPage;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpCrvActi extends BaseActivity {
    public static XpCrvActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.crv.XpCrvActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    XpCrvActi.this.mUpdaterStatus();
                    break;
                case 1:
                    XpCrvActi.this.mUpdaterCurrSource();
                    break;
                case 2:
                    XpCrvActi.this.mUpdaterTrackTime();
                    break;
                case 3:
                    XpCrvActi.this.mUpdaterTrack();
                    break;
                case 4:
                    XpCrvActi.this.mUpdaterTrack();
                    break;
                case 5:
                    XpCrvActi.this.mUpdaterFolder();
                    break;
                case 6:
                    XpCrvActi.this.mUpdaterProgress();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_12crv_xp);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.crv_btn_ff).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCrvActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 3);
            }
        });
        findViewById(R.id.crv_btn_fr).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCrvActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 4);
            }
        });
        findViewById(R.id.crv_btn_play).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCrvActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 1);
            }
        });
        findViewById(R.id.crv_btn_stop).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCrvActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 2);
            }
        });
        findViewById(R.id.xp_crv_compass).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCrvActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.crv.XpCompassActi");
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[0] != 4) {
            DataCanbus.PROXY.cmd(0, 1);
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
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrSource() {
        int value = DataCanbus.DATA[1];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_ipod);
                break;
            case 2:
                ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_usb);
                break;
            default:
                ((TextView) findViewById(R.id.crv_tv_source)).setText(R.string.crv_source_null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFolder() {
        int value = DataCanbus.DATA[5];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_mdi)).setText("----");
        } else {
            ((TextView) findViewById(R.id.crv_tv_mdi)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[3];
        int tarckTotal = DataCanbus.DATA[4];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.crv_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[2];
        int minute = (value >> 8) & 255;
        int second = value & 255;
        if (value == 16777215) {
            ((TextView) findViewById(R.id.crv_tv_time)).setText("--:--");
        } else {
            ((TextView) findViewById(R.id.crv_tv_time)).setText(String.format("%02d:%02d", Integer.valueOf(minute), Integer.valueOf(second)));
        }
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
        int value = DataCanbus.DATA[0];
        switch (value) {
            case 0:
                FuncMain.tips(getResources().getString(R.string.crv_state_stop));
                break;
            case 1:
                FuncMain.tips(getResources().getString(R.string.crv_state_loading));
                break;
            case 4:
                FuncMain.tips(getResources().getString(R.string.crv_state_play));
                break;
            case 5:
                FuncMain.tips(getResources().getString(R.string.crv_state_pause));
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(0, 2);
            finish();
            return true;
        }
        return true;
    }
}
